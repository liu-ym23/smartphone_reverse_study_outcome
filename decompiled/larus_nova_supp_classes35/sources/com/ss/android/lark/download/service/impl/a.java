package com.ss.android.lark.download.service.impl;

import android.text.TextUtils;
import com.ss.android.lark.download.service.DownloadProgress;
import com.ss.android.lark.download.service.FileDownloadState;
import com.ss.android.lark.download.service.NetworkType;
import com.ss.android.lark.http.netstate.NetworkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final Map<String, wbb.a> a;
    public final com.ss.android.lark.http.netstate.c b;
    public final Set<wbb.b> c;
    public com.ss.android.lark.download.service.impl.b d;
    public final Set<wbb.c> e;
    public boolean f;
    public NetworkType g;

    /* JADX INFO: renamed from: com.ss.android.lark.download.service.impl.a$a, reason: collision with other inner class name */
    public class C0194a implements wbb.e {
        public final /* synthetic */ a a;

        public C0194a(a r1) {
            this.a = r1;
        }

        @Override // wbb.e
        public final void a(DownloadProgress r6) {
            a r0 = this.a;
            if (r6 != null) goto L5;
            r0.getClass();
            return;
        L5:
            Map<String, wbb.a> r1 = r0.a;
            HashMap r2 = (HashMap) r1;
            wbb.a r3 = (wbb.a) r2.get(r6.getKey());
            if (r3 != null) goto L9;
            return;
        L9:
            if (r6.getMessageId().equals(null) == true) goto L12;
            return;
        L12:
            if (r6.getState() != FileDownloadState.DOWNLOAD_SUCCESS) goto L20;
            String r4 = r6.getKey();
            r6.getMessageId();
            if (TextUtils.isEmpty(r4) == false) goto L17;
            return;
        L17:
            if (((wbb.a) ((HashMap) r0.a).get(r4)) == null) goto L26;
            throw null;
        L26:
            return;
        L20:
            r3.b = r6.getState();
            r3.a = r6.getProgress();
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NetworkUtils.NetworkType.values().length];
            a = r0;
            r0[NetworkUtils.NetworkType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            a[NetworkUtils.NetworkType.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            a[NetworkUtils.NetworkType.WIFI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            a[NetworkUtils.NetworkType.MOBILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            a[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            a[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            a[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static class c {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.a = new HashMap();
        this.b = com.ss.android.lark.http.netstate.c.a.a;
        C0194a r0 = new C0194a(this);
        e r1 = e.b.a;
        com.ss.android.lark.sdk.f.a(r1.b, r0, new com.ss.android.lark.download.service.impl.c(r1));
        this.c = Collections.newSetFromMap(new ConcurrentHashMap());
        this.e = Collections.newSetFromMap(new ConcurrentHashMap());
        new j();
    }

    public static boolean a(a r2) {
        Map<String, wbb.a> r0 = r2.a;
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (((HashMap) r0).size() == 0) goto L13;
        Iterator r3 = ((HashMap) r2.a).values().iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        if (((wbb.a) r3.next()).b != FileDownloadState.DOWNLOADING) goto L9;
        return true;
    }
}
