package com.ss.android.lark.chat.api.service.impl;

import android.util.ArrayMap;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PreviewCache {
    public static final Lazy<PreviewCache> f = null;
    public final ExecutorService a;
    public final ConcurrentHashMap<String, Map<String, UrlCardPreviewEntity>> b;
    public final ConcurrentHashMap<String, ArrayMap<String, MessageLink>> c;
    public final ReentrantReadWriteLock d;
    public final ConcurrentHashMap<tya.a, Object> e;

    public static final class a {
        public static PreviewCache a() {
            return (PreviewCache) PreviewCache.f.getValue();
        }
    }

    static {
        f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PreviewCache$Companion$INSTANCE$2.INSTANCE);
    }

    public PreviewCache() {
        this.a = PThreadExecutorsUtils.newSingleThreadExecutor(new com.larksuite.framework.thread.n("thread-pool-message-preview-cache"));
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ReentrantReadWriteLock();
        this.e = new ConcurrentHashMap();
    }

    public final Map<String, Map<String, MessageLink>> a(Map<String, ? extends List<String>> r8) {
        this.d.readLock().lock();     // Catch: Throwable -> L22
        Ref.ObjectRef r0 = new Ref.ObjectRef();     // Catch: Throwable -> L22
        if (r8 == null) goto L19;
        Iterator<Map.Entry<String, ? extends List<String>>> r9 = r8.entrySet().iterator();     // Catch: Throwable -> L22
    L6:
        if (r9.hasNext() == false) goto L19;
        Map.Entry<String, ? extends List<String>> r1 = r9.next();     // Catch: Throwable -> L22
        ArrayMap<String, MessageLink> r2 = this.c.get(r1.getKey());     // Catch: Throwable -> L22
        List<String> r3 = r1.getValue();     // Catch: Throwable -> L22
        if (r2 == null) goto L6;
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Throwable -> L22
        Iterator<Map.Entry<String, MessageLink>> r5 = r2.entrySet().iterator();     // Catch: Throwable -> L22
    L11:
        if (r5.hasNext() == false) goto L15;
        Map.Entry<String, MessageLink> r6 = r5.next();     // Catch: Throwable -> L22
        if (r3.contains(r6.getKey()) == false) goto L11;
        r4.put(r6.getKey(), r6.getValue());     // Catch: Throwable -> L22
        goto L11
    L15:
        ConcurrentHashMap r7 = (ConcurrentHashMap) r0.element;     // Catch: Throwable -> L22
        if (r7 != null) goto L18;
        r7 = new ConcurrentHashMap();     // Catch: Throwable -> L22
    L18:
        r0.element = r7;     // Catch: Throwable -> L22
        ConcurrentHashMap r10 = r7;     // Catch: Throwable -> L22
        Map r11 = (Map) r7.put(r1.getKey(), r4);     // Catch: Throwable -> L22
    L19:
        Map<String, Map<String, MessageLink>> r12 = (Map) r0.element;     // Catch: Throwable -> L22
        this.d.readLock().unlock();
        return r12;
    L22:
        th = move-exception;
        this.d.readLock().unlock();
        throw th;
    }

    public final Map<String, Map<String, UrlCardPreviewEntity>> d(Map<String, ? extends List<String>> r8) {
        this.d.readLock().lock();     // Catch: Throwable -> L19
        ConcurrentHashMap r0 = new ConcurrentHashMap();     // Catch: Throwable -> L19
        if (r8 == null) goto L17;
        Iterator<Map.Entry<String, ? extends List<String>>> r9 = r8.entrySet().iterator();     // Catch: Throwable -> L19
    L5:
        if (r9.hasNext() == false) goto L17;
        Map.Entry<String, ? extends List<String>> r1 = r9.next();     // Catch: Throwable -> L19
        String r2 = r1.getKey();     // Catch: Throwable -> L19
        Map<String, UrlCardPreviewEntity> r3 = this.b.get(r2);     // Catch: Throwable -> L19
        List<String> r4 = r1.getValue();     // Catch: Throwable -> L19
        if (r3 == null) goto L5;
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Throwable -> L19
        Iterator<Map.Entry<String, UrlCardPreviewEntity>> r6 = r3.entrySet().iterator();     // Catch: Throwable -> L19
    L11:
        if (r6.hasNext() == false) goto L15;
        Map.Entry<String, UrlCardPreviewEntity> r7 = r6.next();     // Catch: Throwable -> L19
        if (r4.contains(r7.getKey()) == false) goto L11;
        r5.put(r7.getKey(), r7.getValue());     // Catch: Throwable -> L19
        goto L11
    L15:
        r0.put(r2, r5);     // Catch: Throwable -> L19
    L17:
        this.d.readLock().unlock();
        return r0;
    L19:
        th = move-exception;
        this.d.readLock().unlock();
        throw th;
    }

    public final boolean f(UrlCardPreviewEntity r6) {
        this.d.writeLock().lock();     // Catch: Throwable -> L15
        UrlInlinePreviewEntity r0 = r6.getInlineEntity();     // Catch: Throwable -> L15
        boolean r2 = true;
        if (this.b.get(r0.getSourceId()) != null) goto L7;
        ConcurrentHashMap<String, Map<String, UrlCardPreviewEntity>> r1 = this.b;     // Catch: Throwable -> L15
        String r3 = r0.getSourceId();     // Catch: Throwable -> L15
        ArrayMap r4 = new ArrayMap();     // Catch: Throwable -> L15
        r4.put(r0.getPreviewId(), r6);     // Catch: Throwable -> L15
        r1.put(r3, r4);     // Catch: Throwable -> L15
    L5:
        this.d.writeLock().unlock();
        return r2;
    L7:
        UrlCardPreviewEntity r5 = b(r0.getSourceId(), r0.getPreviewId());     // Catch: Throwable -> L15
        Map<String, UrlCardPreviewEntity> r7 = this.b.get(r0.getSourceId());     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.util.ArrayMap<kotlin.String, com.ss.android.lark.export.entity.UrlCardPreviewEntity>");     // Catch: Throwable -> L15
        ArrayMap r8 = (ArrayMap) r7;     // Catch: Throwable -> L15
        if (r5 != null) goto L11;
        r8.put(r0.getPreviewId(), r6);     // Catch: Throwable -> L15
        goto L5
    L11:
        if (r6.compareTo2(r5) < 0) goto L14;
        r8.put(r0.getPreviewId(), r6);     // Catch: Throwable -> L15
        goto L5
    L14:
        r2 = false;
    L15:
        th = move-exception;
        this.d.writeLock().unlock();
        throw th;
    }

    public final UrlCardPreviewEntity b(String r2, String r3) {
        this.d.readLock().lock();     // Catch: Throwable -> L9
        Map<String, UrlCardPreviewEntity> r4 = this.b.get(r2);     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        UrlCardPreviewEntity r5 = r4.get(r3);     // Catch: Throwable -> L9
    L7:
        this.d.readLock().unlock();
        return r5;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        this.d.readLock().unlock();
        throw th;
    }

    public final Map<String, UrlCardPreviewEntity> c(String r4, List<String> r5) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        Intrinsics.checkNotNullParameter(r5, "previewIds");
        this.d.readLock().lock();     // Catch: Throwable -> L16
        Map<String, UrlCardPreviewEntity> r6 = this.b.get(r4);     // Catch: Throwable -> L16
        if (r6 != null) goto L7;
        this.d.readLock().unlock();
        return null;
    L7:
        ArrayMap r0 = new ArrayMap();     // Catch: Throwable -> L16
        Iterator<T> r7 = r5.iterator();     // Catch: Throwable -> L16
    L9:
        if (r7.hasNext() == false) goto L14;
        String r1 = (String) r7.next();     // Catch: Throwable -> L16
        UrlCardPreviewEntity r2 = r6.get(r1);     // Catch: Throwable -> L16
        if (r2 == null) goto L9;
        r0.put(r1, r2);     // Catch: Throwable -> L16
        goto L9
    L14:
        this.d.readLock().unlock();
        return r0;
    L16:
        th = move-exception;
        this.d.readLock().unlock();
        throw th;
    }

    public final void e(Map r8, Map r9) {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        this.d.writeLock().lock();     // Catch: Throwable -> L30
        if (r8 == null) goto L28;
        Iterator r10 = r8.entrySet().iterator();     // Catch: Throwable -> L30
    L6:
        if (r10.hasNext() == false) goto L28;
        Map.Entry r1 = (Map.Entry) r10.next();     // Catch: Throwable -> L30
        r0.put(r1.getKey(), new ArrayList());     // Catch: Throwable -> L30
        Iterator r2 = ((Map) r1.getValue()).entrySet().iterator();     // Catch: Throwable -> L30
    L10:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) r2.next();     // Catch: Throwable -> L30
        if (f((UrlCardPreviewEntity) r3.getValue()) == false) goto L10;
        ArrayList r4 = (ArrayList) r0.get(r1.getKey());     // Catch: Throwable -> L30
        if (r4 == null) goto L16;
        r4.add(r3.getKey());     // Catch: Throwable -> L30
    L16:
        String r5 = (String) r1.getKey();     // Catch: Throwable -> L30
        String r6 = (String) r3.getKey();     // Catch: Throwable -> L30
        if (r9 == null) goto L10;
        MessageLink r7 = (MessageLink) r9.get(r6);     // Catch: Throwable -> L30
        if (r7 == null) goto L10;
        if (this.c.get(r5) == null) goto L23;
        ArrayMap<String, MessageLink> r11 = this.c.get(r5);     // Catch: Throwable -> L30
        if (r11 == null) goto L10;
        r11.put(r6, r7);     // Catch: Throwable -> L30
        goto L10
    L23:
        ArrayMap<String, MessageLink> r12 = new ArrayMap();     // Catch: Throwable -> L30
        r12.put(r6, r7);     // Catch: Throwable -> L30
        this.c.put(r5, r12);     // Catch: Throwable -> L30
    L28:
        this.d.writeLock().unlock();
        this.a.submit(new v0(this, r0));
        return;
    L30:
        th = move-exception;
        this.d.writeLock().unlock();
        throw th;
    }
}
