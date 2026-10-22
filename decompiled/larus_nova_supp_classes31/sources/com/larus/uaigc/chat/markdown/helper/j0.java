package com.larus.uaigc.chat.markdown.helper;

import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j0 {

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            CreationTask r4 = (CreationTask) r2;
            int r0 = 0;
            if (r4 == null) goto L7;
            Integer r5 = r4.index;
            if (r5 == null) goto L7;
            int r6 = r5.intValue();
        L8:
            Integer r7 = Integer.valueOf(r6);
            CreationTask r8 = (CreationTask) r3;
            if (r8 == null) goto L14;
            Integer r9 = r8.index;
            if (r9 == null) goto L14;
            r0 = r9.intValue();
        L14:
            return ComparisonsKt.compareValues(r7, Integer.valueOf(r0));
        L7:
            r6 = 0;
            goto L8
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            Integer r4 = ((CreationTask) r2).index;
            int r0 = 0;
            if (r4 == null) goto L5;
            int r5 = r4.intValue();
        L6:
            Integer r6 = Integer.valueOf(r5);
            Integer r7 = ((CreationTask) r3).index;
            if (r7 == null) goto L10;
            r0 = r7.intValue();
        L10:
            return ComparisonsKt.compareValues(r6, Integer.valueOf(r0));
        L5:
            r5 = 0;
            goto L6
        }
    }

    public static final String b(ImageInfo r2) {
        Image r0 = r2.a;
        if (r0 == null) goto L6;
        String r1 = r0.e;
        if (r1 == null) goto L6;
        return r1;
    L6:
        Image r3 = r2.c;
        if (r3 == null) goto L9;
        String r4 = r3.e;
    L10:
        if (r4 != null) goto L24;
        Image r5 = r2.b;
        if (r5 == null) goto L14;
        String r6 = r5.e;
    L15:
        if (r6 != null) goto L25;
        Image r7 = r2.i;
        if (r7 == null) goto L19;
        String r8 = r7.e;
    L20:
        if (r8 == null) goto L22;
        return r8;
    L22:
        return r2.e;
    L19:
        r8 = null;
        goto L20
    L25:
        return r6;
    L14:
        r6 = null;
        goto L15
    L24:
        return r4;
    L9:
        r4 = null;
        goto L10
    }

    public static final Map<String, CreationTask> c(CreationMsgContentData r4) {
        Map<String, CreationTask> r5 = d(r4);
        if (r5 == null) goto L23;
        Collection<CreationTask> r6 = r5.values();
        if (r6 == null) goto L24;
        List r7 = CollectionsKt.toList(r6);
        if (r7 == null) goto L25;
        List r8 = CollectionsKt.sortedWith(r7, new a());
        if (r8 == null) goto L26;
        List r9 = r8;
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r9, 10)), 16));
        Iterator r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L19;
        Object r1 = r10.next();
        CreationTask r3 = (CreationTask) r1;
        if (r3 == null) goto L16;
        String r11 = r3.id;
    L17:
        r2.put(r11, r1);
        goto L12
    L16:
        r11 = null;
        goto L17
    L19:
        return r2;
    L26:
        return null;
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    }

    public static final Map<String, CreationTask> d(CreationMsgContentData r5) {
        if (r5 == null) goto L20;
        CreationInfo r6 = r5.creationInfo;
        if (r6 == null) goto L20;
        Map r7 = r6.taskInfo;
        if (r7 == null) goto L20;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r8 = r7.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L27;
        Map.Entry r1 = (Map.Entry) r8.next();
        CreationTask r2 = (CreationTask) r1.getValue();
        boolean r3 = false;
        if (r2 == null) goto L18;
        Integer r4 = r2.status;
        if (r4 == null) goto L18;
        if (r4.intValue() != 4) goto L18;
        r3 = true;
    L18:
        if (r3 == false) goto L9;
        r0.put(r1.getKey(), r1.getValue());
        goto L9
    L27:
        return r0;
    L20:
        return null;
    }

    public static final ImageItem g(ImageInfo r20) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        String r1 = b(r20);
        String r3 = r20.e;
        String r4 = r20.f;
        Image r2 = r20.b;
        if (r2 == null) goto L5;
        ImageEntity r6 = f(r2, r1);
    L6:
        Image r5 = r20.a;
        if (r5 == null) goto L9;
        ImageEntity r7 = f(r5, r1);
    L10:
        Image r8 = r20.c;
        if (r8 == null) goto L13;
        ImageEntity r9 = f(r8, r1);
    L14:
        Image r10 = r20.i;
        if (r10 == null) goto L17;
        ImageEntity r11 = f(r10, r1);
    L18:
        Image r12 = r20.d;
        if (r12 == null) goto L21;
        ImageEntity r13 = com.larus.bmhome.chat.layout.holder.image.e0.a(r12);
    L23:
        return new ImageItem(r3, r4, r6, r7, r9, r11, r13, null, null, r20.g, null, false, null, null, 15744, null);
    L21:
        r13 = null;
        goto L23
    L17:
        r11 = null;
        goto L18
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    public static final fz9.b a(final usc.e r4, final Message r5) {
        Intrinsics.checkNotNullParameter(r4, "span");
        Intrinsics.checkNotNullParameter("CreationCustomWidgetBinder", "tag");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl((fz9.b) fh8.b.a(r4, new i0(r5, r4)));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L11;
        FLogger.a.e("CreationCustomWidgetBinder", "bindData called failed, " + r7.getMessage(), r7);
        EnsureManager.ensureNotReachHere(r7, "CreationCustomWidgetBinder");
    L11:
        if (Result.isFailure-impl(r6) == false) goto L14;
        r6 = null;
    L14:
        return (fz9.b) r6;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static final List<CreationTask> e(fz9.b r4, CreationMsgContentData r5) {
        if (r4 == null) goto L26;
        List<String> r6 = r4.a();
        if (r6 == null) goto L27;
        ArrayList r1 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L20;
        String r2 = (String) r7.next();
        if (r5 == null) goto L16;
        CreationInfo r3 = r5.creationInfo;
        if (r3 == null) goto L16;
        Map r8 = r3.taskInfo;
        if (r8 == null) goto L16;
        CreationTask r9 = (CreationTask) r8.get(r2);
    L17:
        if (r9 == null) goto L8;
        r1.add(r9);
    L16:
        r9 = null;
        goto L17
    L20:
        return CollectionsKt.sortedWith(r1, new b());
    L27:
        return null;
    L26:
        return null;
    }

    public static final ImageEntity f(Image r7, String r8) {
        String r1 = r7.a;
        String r2 = r7.b;
        int r3 = (int) r7.c;
        int r4 = (int) r7.d;
        if (r8 != null) goto L6;
        r8 = r7.e;
    L6:
        return new ImageEntity(r1, r2, r3, r4, r8);
    }

    public static final Image h(Image r7, String r8) {
        return Image.a(r7, 0, 0, r8, 15);
    }
}
