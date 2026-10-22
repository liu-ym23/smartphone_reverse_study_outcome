package com.bytedance.android.live.revlink.impl.multianchor.utils;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.drawable.ScalingUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiFeedUtils {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/utils/MultiFeedUtils$ViewIndex;", "", "INDEX_0", "INDEX_FRONT", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ViewIndex extends Enum<ViewIndex> {
        public static final ViewIndex INDEX_0 = null;
        public static final ViewIndex INDEX_FRONT = null;
        public static final /* synthetic */ ViewIndex[] a = null;

        static {
            ViewIndex r1 = new ViewIndex("INDEX_0", 0);
            INDEX_0 = r1;
            ViewIndex r2 = new ViewIndex("INDEX_FRONT", 1);
            INDEX_FRONT = r2;
            a = new ViewIndex[]{r1, r2};
        }

        public static ViewIndex valueOf(String r1) {
            return (ViewIndex) r27.a.a(ViewIndex.class, r1);
        }

        public static ViewIndex[] values() {
            return (ViewIndex[]) a.clone();
        }

        public ViewIndex(String r1, int r2) {
            super(r1, r2);
        }
    }

    public MultiFeedUtils() {
    }

    static {
    }

    public static void b(FrameLayout r1) {
        Intrinsics.checkNotNullParameter(r1, "container");
        HSImageView r0 = r1.findViewById(2131389668);
        if (r0 == null) goto L5;
        r1.removeView(r0);
    L5:
        HSImageView r2 = r1.findViewById(2131389666);
        if (r2 == null) goto L9;
        r1.removeView(r2);
        return;
    }

    public static void a(FrameLayout r1, HSImageView r2, FrameLayout.LayoutParams r3, ViewIndex r4) {
        if (r4 != ViewIndex.INDEX_0) goto L6;
        r1.addView(r2, 0, r3);
        return;
    L6:
        if (r4 != ViewIndex.INDEX_FRONT) goto L10;
        r1.addView(r2, r3);
        return;
    }

    public static void f(FrameLayout r6, int r7, int r8, ViewIndex r9) {
        Intrinsics.checkNotNullParameter(r6, "container");
        Intrinsics.checkNotNullParameter(r9, "index");
        HSImageView r1 = r6.findViewById(2131389668);
        if (r1 != null) goto L5;
        r1 = new HSImageView(r6.getContext());
        r1.setId(2131389668);
        r1.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        a(r6, r1, new FrameLayout.LayoutParams(r7, -1), r9);
        r1.setBackgroundResource(2131249372);
    L14:
        r1.setBackgroundResource(2131249372);
        HSImageView r0 = r6.findViewById(2131389666);
        if (r0 != null) goto L17;
        r0 = new HSImageView(r6.getContext());
        r0.setId(2131389666);
        r0.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-1, -1);
        r10.leftMargin = r8;
        a(r6, r0, r10, r9);
    L22:
        r0.setBackgroundResource(2131249372);
        return;
    L17:
        ViewGroup.LayoutParams r12 = r0.getLayoutParams();
        if (r12 == null) goto L25;
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12;
        r13.leftMargin = r8;
        r13.topMargin = 0;
        Unit r14 = Unit.INSTANCE;
        r0.setLayoutParams(r13);
        if (r9 != ViewIndex.INDEX_FRONT) goto L22;
        r0.bringToFront();
        goto L22
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L5:
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        FrameLayout.LayoutParams r5 = null;
        if ((r2 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r2 = null;
    L8:
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        if (r3 == null) goto L11;
        r3.width = r7;
        r3.height = -1;
        Unit r15 = Unit.INSTANCE;
        r5 = r3;
    L11:
        r1.setLayoutParams(r5);
        if (r9 != ViewIndex.INDEX_FRONT) goto L14;
        r1.bringToFront();
        goto L14
    }

    public static /* synthetic */ void e(FrameLayout r8, int r9, int r10, ViewIndex r12, String r13, String r14) {
        c(r8, r9, r10, r12, r13, r14, false, false);
    }

    public static void c(FrameLayout r10, int r12, int r13, ViewIndex r14, String r15, String r16, boolean r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r14, "index");
        Intrinsics.checkNotNullParameter(r15, "topBgUrl");
        Intrinsics.checkNotNullParameter(r16, "bottomBgUrl");
        d(r10, r12, r13, r14, r15, r16, r17, r18, r18);
    }

    public static void d(FrameLayout r6, int r7, int r8, ViewIndex r9, String r10, String r12, boolean r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r6, "container");
        Intrinsics.checkNotNullParameter(r9, "index");
        Intrinsics.checkNotNullParameter(r10, "topBgUrl");
        Intrinsics.checkNotNullParameter(r12, "bottomBgUrl");
        HSImageView r1 = r6.findViewById(2131389668);
        if (r1 != null) goto L5;
        r1 = new HSImageView(r6.getContext());
        r1.setId(2131389668);
        r1.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        a(r6, r1, new FrameLayout.LayoutParams(-1, r7), r9);
        ImageLoader.bindImage(r1, r10);
    L14:
        if (r13 == false) goto L18;
        if (r14 == false) goto L17;
        com.bytedance.android.live.revlink.impl.pk.utils.w.a(r1, r10);
        goto L18
    L17:
        ImageLoader.bindImage(r1, r10);
    L18:
        HSImageView r16 = r6.findViewById(2131389666);
        if (r16 != null) goto L21;
        r16 = new HSImageView(r6.getContext());
        r16.setId(2131389666);
        r16.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-1, -1);
        r17.topMargin = r8;
        a(r6, r16, r17, r9);
        ImageLoader.bindImage(r16, r12);
    L26:
        if (r13 == false) goto L33;
        if (r15 == false) goto L29;
        com.bytedance.android.live.revlink.impl.pk.utils.w.a(r16, r12);
        return;
    L29:
        ImageLoader.bindImage(r16, r12);
        return;
    L33:
        return;
    L21:
        ViewGroup.LayoutParams r18 = r16.getLayoutParams();
        if (r18 == null) goto L32;
        FrameLayout.LayoutParams r19 = (FrameLayout.LayoutParams) r18;
        r19.leftMargin = 0;
        r19.topMargin = r8;
        Unit r20 = Unit.INSTANCE;
        r16.setLayoutParams(r19);
        if (r9 != ViewIndex.INDEX_FRONT) goto L26;
        r16.bringToFront();
        goto L26
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L5:
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        FrameLayout.LayoutParams r5 = null;
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L8;
        r0 = null;
    L8:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r0;
        if (r2 == null) goto L11;
        r2.leftMargin = 0;
        r2.height = r7;
        r2.width = -1;
        Unit r22 = Unit.INSTANCE;
        r5 = r2;
    L11:
        r1.setLayoutParams(r5);
        if (r9 != ViewIndex.INDEX_FRONT) goto L14;
        r1.bringToFront();
        goto L14
    }
}
