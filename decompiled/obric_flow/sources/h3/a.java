package h3;

import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppletPopup f17272b;

    public /* synthetic */ a(AppletPopup r5, int r10) {
        this.f17271a = r10;
        this.f17272b = r5;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        AppletPopup r5 = this.f17272b;
        switch(this.f17271a) {
            case 0: goto L156;
            default: goto L4;
        };
    L4:
        int r11 = AppletPopup.L;
        r5.g();
        FragmentActivity r12 = r5.getActivity();
        AppletPopupSchemaParam r10 = r5.f2857j;
        AppletPopupSchemaParam r13 = null;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r10 = null;
    L7:
        int r14 = td.e.b(r12, r10, r5);
        boolean r15 = r5.A;
        if (r14 <= 0) goto L10;
        AppletPopupSchemaParam r16 = r5.f2857j;
        if (r16 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r16 = null;
    L45:
        if (r16.f2896n == false) goto L113;
        AppletPopupSchemaParam r17 = r5.f2857j;
        if (r17 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r17 = null;
    L50:
        if (r14 >= r17.f2897o) goto L113;
        BottomSheetBehavior r18 = r5.f2859l;
        if (r18 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r18 = null;
    L55:
        if (r14 <= 0) goto L57;
        int r19 = RangesKt.coerceAtMost(r14, com.bytedance.ai.utils.c.k(r5.g()));
    L58:
        r18.a(r19);
        BottomSheetBehavior r110 = r5.f2859l;
        if (r110 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r110 = null;
    L61:
        AppletPopupSchemaParam r20 = r5.f2857j;
        if (r20 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r20 = null;
    L64:
        r110.f = r20.f2897o;
        BottomSheetBehavior r111 = r5.f2859l;
        if (r111 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r111 = null;
    L67:
        AppletPopupSchemaParam r21 = r5.f2857j;
        if (r21 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r21 = null;
    L70:
        int r22 = r21.f2898p;
        r111.getClass();
        BottomSheetBehavior r112 = r5.f2859l;
        if (r112 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r112 = null;
    L73:
        AppletPopupSchemaParam r23 = r5.f2857j;
        if (r23 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r23 = null;
    L76:
        r23.getClass();
        BottomSheetBehavior r24 = r5.f2859l;
        if (r24 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r24 = null;
    L79:
        r24.getClass();
        BottomSheetBehavior r25 = r5.f2859l;
        if (r25 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r25 = null;
    L82:
        r25.getClass();
        r112.getClass();
        BottomSheetBehavior r113 = r5.f2859l;
        if (r113 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r113 = null;
    L85:
        AppletPopupSchemaParam r26 = r5.f2857j;
        if (r26 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r26 = null;
    L88:
        r26.getClass();
        BottomSheetBehavior r27 = r5.f2859l;
        if (r27 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r27 = null;
    L91:
        r27.getClass();
        BottomSheetBehavior r28 = r5.f2859l;
        if (r28 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r28 = null;
    L94:
        r28.getClass();
        r113.getClass();
        BottomSheetBehavior r114 = r5.f2859l;
        if (r114 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r114 = null;
    L97:
        AppletPopupSchemaParam r29 = r5.f2857j;
        if (r29 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r29 = null;
    L100:
        r29.getClass();
        BottomSheetBehavior r30 = r5.f2859l;
        if (r30 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r30 = null;
    L103:
        r30.getClass();
        r114.getClass();
        BottomSheetBehavior r115 = r5.f2859l;
        if (r115 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r115 = null;
    L106:
        r115.c(4);
        BottomSheetBehavior r116 = r5.f2859l;
        if (r116 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r116 = null;
    L109:
        AppletPopupSchemaParam r31 = r5.f2857j;
        if (r31 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r31 = null;
    L112:
        boolean r32 = r31.f2899q;
        r116.getClass();
    L141:
        AppletPopupSchemaParam r117 = r5.f2857j;
        if (r117 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r117 = null;
    L144:
        r117.getClass();
        k3.b r118 = r5.f2856i;
        if (r118 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("animatorParamHandler");
        r118 = null;
    L147:
        c r33 = (c) r5.G.getValue();
        AppletPopupSchemaParam r34 = r5.f2857j;
        if (r34 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r34 = null;
    L150:
        r118.b(r33, r34.d, new a3.f(26));
        AppletPopupSchemaParam r119 = r5.f2857j;
        if (r119 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L154:
        r13.getClass();
        AppletPopup.d(r5, false, false, 7);
        return;
    L153:
        r13 = r119;
        goto L154
    L57:
        r19 = 0;
    L113:
        if (r15 == false) goto L118;
        BottomSheetBehavior r35 = r5.f2859l;
        if (r35 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r35 = null;
    L117:
        r35.a(r14);
    L122:
        BottomSheetBehavior r120 = r5.f2859l;
        if (r120 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r120 = null;
    L125:
        AppletPopupSchemaParam r36 = r5.f2857j;
        if (r36 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r36 = null;
    L128:
        r120.f = r36.f2897o;
        BottomSheetBehavior r121 = r5.f2859l;
        if (r121 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r121 = null;
    L131:
        r121.getClass();
        BottomSheetBehavior r122 = r5.f2859l;
        if (r122 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r122 = null;
    L134:
        AppletPopupSchemaParam r37 = r5.f2857j;
        if (r37 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r37 = null;
    L137:
        r37.getClass();
        int r38 = d.f17275a;
        r122.getClass();
        BottomSheetBehavior r123 = r5.f2859l;
        if (r123 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r123 = null;
    L140:
        r123.c(3);
        goto L141
    L118:
        BottomSheetBehavior r39 = r5.f2859l;
        if (r39 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r39 = null;
    L121:
        r39.a(r14 - 1);
        goto L122
    L10:
        if (r15 == false) goto L21;
        BottomSheetBehavior r40 = r5.f2859l;
        if (r40 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r40 = null;
    L14:
        BottomSheetBehavior r41 = r5.f2859l;
        if (r41 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r41 = null;
    L17:
        int r42 = r41.f;
        if (r42 != (-1)) goto L20;
        r42 = r41.f2884b;
    L20:
        r40.a(r42);
    L31:
        BottomSheetBehavior r124 = r5.f2859l;
        if (r124 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r124 = null;
    L34:
        int r43 = com.bytedance.ai.utils.c.k(r5.g());
        r5.e(4);
        r124.f = r43;
        BottomSheetBehavior r125 = r5.f2859l;
        if (r125 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r125 = null;
    L37:
        r125.getClass();
        BottomSheetBehavior r126 = r5.f2859l;
        if (r126 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r126 = null;
    L40:
        r126.c(3);
        goto L141
    L21:
        BottomSheetBehavior r44 = r5.f2859l;
        if (r44 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r44 = null;
    L24:
        BottomSheetBehavior r45 = r5.f2859l;
        if (r45 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r45 = null;
    L27:
        int r127 = r45.f;
        if (r127 != (-1)) goto L30;
        r127 = r45.f2884b;
    L30:
        r44.a(r127 - 1);
        goto L31
    L156:
        int r128 = AppletPopup.L;
        String r129 = r5 + " onLayoutListener -- " + r5.f2869w;
        Intrinsics.checkNotNullParameter("AppletPopup", "tag");
        t0.d r46 = com.bytedance.ai.utils.c.f2846a;
        if (r46 == null) goto L160;
        r46.d("AppletPopup", r129);
    L160:
        if (r5.f2863p == true) goto L170;
        int r130 = td.e.a(r5.g(), r5.getView(), r5);
        if (r130 == r5.f2864q) goto L171;
        r5.f2864q = r130;
        a r131 = r5.f2865r;
        if (r131 == null) goto L168;
        r131.onGlobalLayout();
    L168:
        r5.f2863p = true;
        return;
    L171:
        return;
    }
}
