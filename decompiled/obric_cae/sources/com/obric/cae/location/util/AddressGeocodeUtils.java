package com.obric.cae.location.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.text.TextUtils;
import com.obric.cae.log.CommSenseLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class AddressGeocodeUtils {
    private static final long CACHE_TTL_MS = 0;
    private static final int MAX_CACHE_SIZE = 64;
    private static final ConcurrentHashMap<String, CacheEntry> sCache = null;

    public static final class CacheEntry {
        private final List<Address> addresses;
        private final long expireAtMs;

        private CacheEntry(List<Address> r8) {
            this.addresses = r8;
            long r10 = System.currentTimeMillis();
            this.expireAtMs = AddressGeocodeUtils.access$400() + r10;
        }

        public static /* synthetic */ boolean access$000(CacheEntry r8) {
            return r8.isExpired();
        }

        public static /* synthetic */ List access$100(CacheEntry r8) {
            return r8.addresses;
        }

        public static /* synthetic */ long access$300(CacheEntry r8) {
            return r8.expireAtMs;
        }

        private boolean isExpired() {
            if (System.currentTimeMillis() <= this.expireAtMs) goto L5;
            return true;
        L5:
            return false;
        }

        public /* synthetic */ CacheEntry(List r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    static {
        CACHE_TTL_MS = TimeUnit.MINUTES.toMillis(10);
        sCache = new ConcurrentHashMap();
    }

    private AddressGeocodeUtils() {
    }

    public static /* synthetic */ long access$400() {
        return CACHE_TTL_MS;
    }

    private static String buildCacheKey(String r8) {
        return r8.trim().toLowerCase(Locale.ROOT);
    }

    @SuppressLint({"NewApi"})
    public static List<Address> resolveAddressList(Context r8, String r10, int r11, long r12, final String r13, final String r14) {
        AnonymousClass1 r15 = null;
        if (r8 != null) goto L9;
        StringBuilder r16 = new StringBuilder();
        r16.append(r14);
        String r17 = ": context is null";
    L5:
        r16.append(r17);
        String r18 = r16.toString();
    L6:
        CommSenseLog.e(r13, r18);
        return null;
    L9:
        if (TextUtils.isEmpty(r10) == false) goto L12;
        r16 = new StringBuilder();
        r16.append(r14);
        r17 = ": address is empty";
        goto L5
    L12:
        if (Geocoder.isPresent() == true) goto L14;
        r16 = new StringBuilder();
        r16.append(r14);
        r17 = ": geocoder is unavailable";
        goto L5
    L14:
        String r19 = buildCacheKey(r10);
        ConcurrentHashMap<String, CacheEntry> r20 = sCache;
        CacheEntry r21 = r20.get(r19);
        if (r21 != null) goto L17;
    L20:
        final AtomicReference r22 = new AtomicReference(Collections.emptyList());
        final CountDownLatch r23 = new CountDownLatch(1);
        new Geocoder(r8.getApplicationContext(), Locale.getDefault()).getFromLocationName(r10, Math.max(r11, 1), new AnonymousClass1(r22, r23, r13, r14));
    L33:
        e = move-exception;
        Thread.currentThread().interrupt();
        r18 = r14 + ": interrupted: " + e.getMessage();
        goto L6
    L22:
        if (r23.await(r12, TimeUnit.MILLISECONDS) == true) goto L25;
        CommSenseLog.e(r13, r14 + ": timeout");     // Catch: InterruptedException -> L33
        return null;
    L25:
        List<Address> r24 = (List) r22.get();
        if (r24 != null) goto L28;
    L32:
        r16 = new StringBuilder();
        r16.append(r14);
        r17 = ": no address result";
        goto L5
    L28:
        if (r24.isEmpty() == true) goto L32;
        trimCacheIfNeeded();
        r20.put(r19, new CacheEntry(r24, r15));
        return r24;
    L17:
        if (CacheEntry.access$000(r21) == true) goto L20;
        CommSenseLog.d(r13, r14 + ": hit geocoder cache for address=" + r10);
        return CacheEntry.access$100(r21);
    }

    @SuppressLint({"NewApi"})
    public static Address resolveFirstAddress(Context r8, String r10, long r11, String r12, String r13) {
        List<Address> r14 = resolveAddressList(r8, r10, 1, r11, r12, r13);
        if (r14 != null) goto L5;
        return null;
    L5:
        if (r14.isEmpty() == false) goto L8;
        return null;
    L8:
        return r14.get(0);
    }

    private static void trimCacheIfNeeded() {
        ConcurrentHashMap<String, CacheEntry> r8 = sCache;
        if (r8.size() >= 64) goto L5;
        return;
    L5:
        long r10 = System.currentTimeMillis();
        Iterator<String> r11 = r8.keySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        String r12 = r11.next();
        ConcurrentHashMap<String, CacheEntry> r13 = sCache;
        CacheEntry r14 = r13.get(r12);
        if (r14 == null) goto L12;
        if (CacheEntry.access$300(r14) > r10) goto L7;
    L12:
        r13.remove(r12);
        goto L7
    L13:
        ConcurrentHashMap<String, CacheEntry> r15 = sCache;
        if (r15.size() < 64) goto L23;
        r15.clear();
        return;
    }
}
