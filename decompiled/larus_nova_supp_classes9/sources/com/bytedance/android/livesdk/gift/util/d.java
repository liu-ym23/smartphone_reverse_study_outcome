package com.bytedance.android.livesdk.gift.util;

import androidx.collection.LongSparseArray;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPreloadSettingsKt;
import com.bytedance.android.livesdk.gift.platform.core.h;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.f1;
import com.bytedance.android.scope.m;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import i12.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final void c() {
        if (((Boolean) h.B.getValue(null, h.a[26])).booleanValue() == true) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.b()).iterator();
    L7:
        if (r0.hasNext() == false) goto L17;
        Iterator r1 = ((List) r0.next()).iterator();
    L10:
        if (r1.hasNext() == false) goto L7;
        T r2 = ((AbsPanel) r1.next()).h;
        if ((r2 instanceof h1) == false) goto L10;
        if (r2 == 0) goto L16;
        d((h1) r2);
        goto L10
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    }

    public static final void d(h1 r3) {
        Intrinsics.checkNotNullParameter(r3, "gift");
        e(r3.getLeftLogo(), s1.j(2131168729), s1.j(2131168730));
        e(r3.getImage(), s1.j(2131168749), s1.j(2131168749));
    }

    public static final ImageRequest a(k r2, int r3) {
        return (ImageRequest) CollectionsKt.firstOrNull(GiftImageLoader.d(GiftImageLoader.k, r2, new ResizeOptions(r3, r3)));
    }

    public static final void b(List<? extends h1> r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "giftList");
        int r0 = 0;
        if (r14 != 2) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L48;
    L18:
        ReadOnlyProperty r3 = com.bytedance.android.livesdk.gift.platform.business.b.p;     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
        KProperty[] r5 = com.bytedance.android.livesdk.gift.platform.business.b.a;     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
        int r4 = ((Number) r3.getValue(null, r5[14])).intValue();     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
        if (r14 != 3) goto L21;
        r4 = ((Number) com.bytedance.android.livesdk.gift.platform.business.b.q.getValue(null, r5[15])).intValue();     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
    L21:
        i12.e r15 = o.b();     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
        if (r15 == null) goto L24;
        Object r16 = m.e.d(r15, f1.class);     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
    L25:
        f1 r17 = (f1) r16;     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
        if (r17 == null) goto L28;
        LongSparseArray<Integer> r18 = r17.d;     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
    L29:
        int r6 = s1.j(2131168749);     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
        Iterator<? extends h1> r19 = r13.iterator();     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
    L31:
        if (r19.hasNext() == false) goto L43;
        h1 r7 = r19.next();     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
        if (r4 < 0) goto L34;
        if (r0 < r4) goto L41;
        if (r7.getId() == 463) goto L41;
        if (r18 == null) goto L31;
        if (r18.indexOfKey(r7.getId()) < 0) goto L31;
    L41:
        e(r7.getImage(), r6, r6);     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
    L42:
        r0 = r0 + 1;     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
        goto L31
    L34:
        d(r7);     // Catch: IllegalArgumentException -> L14 NullPointerException -> L16
        goto L42
    L43:
    L14:
        e = move-exception;
        jy0.b.c("loadFirstPanelIconIntoCache Err: " + e.getMessage(), null, e, 2);
        return;
    L16:
        e = move-exception;
        jy0.b.c("loadFirstPanelIconIntoCache Err: " + e.getMessage(), null, e, 2);
        return;
    L61:
        return;
    L28:
        r18 = null;
        goto L29
    L24:
        r16 = null;
        goto L25
    L48:
        if (GiftPreloadSettingsKt.b().d() == false) goto L18;
        return;
    L5:
        if (r14 == 13) goto L8;
        r2 = false;
        goto L10
    }

    public static final void e(k r2, int r3, int r4) {
        if (r2 != null) goto L14;
        return;
    L14:
        Object[] r5 = GiftImageLoader.d(GiftImageLoader.k, r2, new ResizeOptions(r4, r3)).toArray(new ImageRequest[0]);     // Catch: Exception -> L11
        if (r5 == null) goto L10;
        ImageRequest[] r6 = (ImageRequest[]) r5;     // Catch: Exception -> L11
        ImagePipeline r7 = Fresco.getImagePipeline();     // Catch: Exception -> L11
        if (r7.isInBitmapMemoryCache(r6[0]) == true) goto L15;
        r7.prefetchToBitmapCache(r6[0], "live_gift_panel_icon_prefetch");     // Catch: Exception -> L11
        return;
    L15:
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        jy0.b.a("loadGiftIconIntoCache", "loadImageIntoCache failed: " + e.getMessage());
    }
}
