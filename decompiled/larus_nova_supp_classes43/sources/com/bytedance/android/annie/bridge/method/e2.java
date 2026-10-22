package com.bytedance.android.annie.bridge.method;

import android.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.SetContainerResultModel;
import com.bytedance.android.annie.container.dialog.BaseDialogFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragment;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "setContainer")
public final class e2 extends com.bytedance.android.annie.bridge.d<com.bytedance.android.annie.bridge.s, SetContainerResultModel> {
    public final HybridFragment a;
    public final com.bytedance.android.annie.container.fragment.p b;

    public e2(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        HybridFragment r0 = (HybridFragment) r10.c(HybridFragment.class);
        if (r0 == null) goto L5;
        this.a = r0;
    L5:
        com.bytedance.android.annie.container.fragment.p r11 = (com.bytedance.android.annie.container.fragment.p) r10.c(com.bytedance.android.annie.container.fragment.p.class);
        if (r11 == null) goto L9;
        this.b = r11;
    L9:
        if (this.a != null) goto L12;
        this.a = new AnnieFragment();
        return;
    }

    public e2(HybridFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        this.a = r10;
    }

    public final void invoke(Object r10, CallContext r11) {
        com.bytedance.android.annie.bridge.s r12 = (com.bytedance.android.annie.bridge.s) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        com.bytedance.android.annie.bridge.s.b r13 = r12.b();
        boolean r0 = false;
        HybridDialog r14 = null;
        if (r13 == null) goto L96;
        HybridFragment r15 = this.a;
        if (r15 == null) goto L7;
        Fragment r16 = r15.getParentFragment();
    L9:
        if ((r16 instanceof BaseDialogFragment) == false) goto L12;
        SetContainerResultModel r17 = new SetContainerResultModel();
        r17.a(SetContainerResultModel.Code.Failed);
        r17.b("must use pageUI under fullscreen scene");
        finishWithResult(r17);
        return;
    L12:
        if (this.b == null) goto L15;
        SetContainerResultModel r18 = new SetContainerResultModel();
        r18.a(SetContainerResultModel.Code.Failed);
        r18.b("must use pageUI under fullscreen scene");
        finishWithResult(r18);
        return;
    L15:
        if (r13.f() == null) goto L20;
        HybridFragment r19 = this.a;
        if (r19 == null) goto L20;
        r19.setHybridTitle(r13.f());
    L20:
        if (r13.g() == null) goto L25;
        HybridFragment r20 = this.a;
        if (r20 == null) goto L25;
        r20.setHybridTitleColor(r13.g());
    L25:
        if (r13.b() == null) goto L30;
        HybridFragment r21 = this.a;
        if (r21 == null) goto L30;
        r21.setHybridNavBarColor(r13.b());
    L30:
        if (r13.c() == null) goto L35;
        HybridFragment r22 = this.a;
        if (r22 == null) goto L35;
        r22.setHybridStatusBarBgColor(r13.c());
    L35:
        if (r13.e() == null) goto L40;
        HybridFragment r23 = this.a;
        if (r23 == null) goto L40;
        r23.setHybridStatusFontMode(r13.e());
    L40:
        if ((r13.d() instanceof Number) == false) goto L71;
        Integer r24 = r13.d();
        if (r24 != null) goto L45;
    L58:
        Integer r25 = r13.d();
        if (r25 == null) goto L71;
        if (r25.intValue() != 0) goto L71;
        int r26 = com.bytedance.android.annie.util.u.a;
        HybridFragment r27 = this.a;
        if (r27 == null) goto L66;
        FragmentActivity r28 = r27.getActivity();
    L67:
        if (r28 == null) goto L71;
        r28.getWindow().clearFlags(1024);
        Intrinsics.checkNotNullParameter(r28, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        r28.getWindow().setStatusBarColor(r28.getResources().getColor(R.color.transparent));
        goto L71
    L66:
        r28 = null;
        goto L67
    L45:
        if (r24.intValue() != 1) goto L58;
        int r29 = com.bytedance.android.annie.util.u.a;
        HybridFragment r30 = this.a;
        if (r30 == null) goto L49;
        FragmentActivity r31 = r30.getActivity();
    L50:
        if (r31 == null) goto L53;
        r31.getWindow().setFlags(1024, 1024);
        Intrinsics.checkNotNullParameter(r31, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        r31.getWindow().setStatusBarColor(r31.getResources().getColor(R.color.transparent));
    L53:
        HybridFragment r32 = this.a;
        if (r32 == null) goto L56;
        FragmentActivity r33 = r32.getActivity();
    L57:
        com.bytedance.android.annie.container.fragment.n.g(r33, "");
        goto L71
    L56:
        r33 = null;
        goto L57
    L49:
        r31 = null;
    L71:
        if (r13.a() == null) goto L96;
        Integer r34 = r13.a();
        if (r34 != null) goto L76;
    L84:
        Integer r110 = r13.a();
        if (r110 == null) goto L96;
        if (r110.intValue() != 0) goto L96;
        int r111 = com.bytedance.android.annie.util.u.a;
        HybridFragment r112 = this.a;
        if (r112 == null) goto L92;
        FragmentActivity r113 = r112.getActivity();
    L93:
        if (r113 == null) goto L96;
        com.bytedance.android.annie.util.u.a(r113.getWindow()).setSystemUiVisibility(0);
        goto L96
    L92:
        r113 = null;
        goto L93
    L76:
        if (r34.intValue() != 1) goto L84;
        int r114 = com.bytedance.android.annie.util.u.a;
        HybridFragment r115 = this.a;
        if (r115 == null) goto L80;
        FragmentActivity r116 = r115.getActivity();
    L81:
        if (r116 == null) goto L96;
        com.bytedance.android.annie.util.u.a(r116.getWindow()).setSystemUiVisibility(IAPI.ACTION_STARTSERVER);
        goto L96
    L80:
        r116 = null;
        goto L81
    L7:
        r16 = null;
    L96:
        com.bytedance.android.annie.bridge.s.a r117 = r12.a();
        if (r117 != null) goto L99;
    L138:
        com.bytedance.android.annie.bridge.s.c r35 = r12.c();
        if (r35 == null) goto L200;
        HybridFragment r118 = this.a;
        if (r118 == null) goto L143;
        Fragment r119 = r118.getParentFragment();
    L145:
        if ((r119 instanceof BaseDialogFragment) == true) goto L148;
        SetContainerResultModel r36 = new SetContainerResultModel();
        r36.a(SetContainerResultModel.Code.Failed);
        r36.b("must use popupInteraction under dialog scene");
        finishWithResult(r36);
        return;
    L148:
        if (this.b != null) goto L151;
        SetContainerResultModel r37 = new SetContainerResultModel();
        r37.a(SetContainerResultModel.Code.Failed);
        r37.b("must use popupInteraction under dialog scene");
        finishWithResult(r37);
        return;
    L151:
        if ((r35.a() instanceof Number) == false) goto L177;
        HybridFragment r120 = this.a;
        if (r120 == null) goto L155;
        Fragment r121 = r120.getParentFragment();
    L157:
        if ((r121 instanceof HybridDialog) == false) goto L159;
        HybridDialog r122 = (HybridDialog) r121;
    L160:
        if (r122 != null) goto L162;
    L166:
        Object r123 = this.b;
        if ((r123 instanceof HybridDialog) == false) goto L169;
        HybridDialog r124 = (HybridDialog) r123;
    L170:
        if (r124 == null) goto L177;
        if (r35.a().intValue() == 1) goto L174;
        boolean r38 = true;
    L175:
        r124.U90(r38);
        goto L177
    L174:
        r38 = false;
        goto L175
    L169:
        r124 = null;
        goto L170
    L162:
        if (r35.a().intValue() == 1) goto L164;
        boolean r39 = true;
    L165:
        r122.U90(r39);
        goto L166
    L164:
        r39 = false;
        goto L165
    L159:
        r122 = null;
        goto L160
    L155:
        r121 = null;
    L177:
        if ((r35.b() instanceof Number) == false) goto L200;
        HybridFragment r125 = this.a;
        if (r125 == null) goto L181;
        Fragment r126 = r125.getParentFragment();
    L183:
        if ((r126 instanceof HybridDialog) == false) goto L185;
        HybridDialog r127 = (HybridDialog) r126;
    L186:
        if (r127 != null) goto L188;
    L192:
        Object r128 = this.b;
        if ((r128 instanceof HybridDialog) == false) goto L195;
        r14 = (HybridDialog) r128;
    L195:
        if (r14 == null) goto L200;
        if (r35.b().intValue() != 1) goto L199;
        r0 = true;
    L199:
        r14.Y90(r0);
        goto L200
    L188:
        if (r35.b().intValue() != 1) goto L190;
        boolean r40 = true;
    L191:
        r127.Y90(r40);
        goto L192
    L190:
        r40 = false;
        goto L191
    L185:
        r127 = null;
        goto L186
    L181:
        r126 = null;
        goto L183
    L143:
        r119 = null;
    L200:
        SetContainerResultModel r41 = new SetContainerResultModel();
        r41.a(SetContainerResultModel.Code.Success);
        finishWithResult(r41);
        return;
    L99:
        if ((r117.b() instanceof Boolean) == false) goto L107;
        HybridFragment r42 = this.a;
        if (r42 == null) goto L103;
        r42.enableClose(!Intrinsics.areEqual(r117.b(), Boolean.TRUE));
    L103:
        com.bytedance.android.annie.container.fragment.p r43 = this.b;
        if (r43 == null) goto L107;
        r43.enableClose(!Intrinsics.areEqual(r117.b(), Boolean.TRUE));
    L107:
        if ((r117.b() instanceof Number) == false) goto L123;
        HybridFragment r44 = this.a;
        if (r44 != null) goto L111;
    L115:
        com.bytedance.android.annie.container.fragment.p r45 = this.b;
        if (r45 == null) goto L123;
        if (((Number) r117.b()).intValue() == 1) goto L120;
        boolean r46 = true;
    L121:
        r45.enableClose(r46);
        goto L123
    L120:
        r46 = false;
        goto L121
    L111:
        if (((Number) r117.b()).intValue() == 1) goto L113;
        boolean r47 = true;
    L114:
        r44.enableClose(r47);
        goto L115
    L113:
        r47 = false;
    L123:
        if ((r117.a() instanceof Number) == false) goto L138;
        HybridFragment r48 = this.a;
        if (r48 != null) goto L127;
    L131:
        com.bytedance.android.annie.container.fragment.p r49 = this.b;
        if (r49 == null) goto L138;
        if (r117.a().intValue() == 1) goto L136;
        boolean r129 = true;
    L137:
        r49.setCloseByGesture(r129);
        goto L138
    L136:
        r129 = false;
        goto L137
    L127:
        if (r117.a().intValue() == 1) goto L129;
        boolean r50 = true;
    L130:
        r48.setCloseByGesture(r50);
        goto L131
    L129:
        r50 = false;
        goto L130
    }
}
