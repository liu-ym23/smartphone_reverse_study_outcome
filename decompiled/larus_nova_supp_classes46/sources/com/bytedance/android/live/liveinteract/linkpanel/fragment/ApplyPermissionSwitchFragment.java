package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.linkpanel.contract.VideoTalkDialogContract$View;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/ApplyPermissionSwitchFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/VideoTalkDialogContract$View;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ApplyPermissionSwitchFragment extends VideoTalkDialogContract$View {
    public static final /* synthetic */ int o = 0;
    public Map<Integer, View> g;
    public View h;
    public ViewGroup i;
    public IRoom j;
    public int k;
    public final CompositeDisposable l;
    public boolean m;
    public boolean n;

    public static final class a {
        @JvmStatic
        public static ApplyPermissionSwitchFragment a(yf0.g r1, IRoom r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
            ApplyPermissionSwitchFragment r0 = new ApplyPermissionSwitchFragment();
            r0.d = r1;
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r0.j = r2;
            r0.k = r3;
            return r0;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        ViewGroup r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L5:
        return r0;
    }

    public final boolean ca0() {
        if (((Boolean) vm2.d.M0.getValue(null, vm2.d.a[88])).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.k == 3) goto L7;
        return true;
    }

    public final void ea0() {
        if (this.n == false) goto L11;
        View r0 = this.h;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L7:
        ((ImageView) r0.findViewById(2131376428)).setVisibility(0);
        View r1 = this.h;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L10:
        ((ImageView) r1.findViewById(2131376439)).setVisibility(8);
        return;
    L11:
        View r2 = this.h;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L14:
        ((ImageView) r2.findViewById(2131376428)).setVisibility(8);
        View r3 = this.h;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L17:
        ((ImageView) r3.findViewById(2131376439)).setVisibility(0);
    }

    public ApplyPermissionSwitchFragment() {
        this.g = new LinkedHashMap();
        this.l = new CompositeDisposable();
        this.m = true;
    }

    public final void da0() {
        if (ca0() == true) goto L5;
    L19:
        this.m = true;
        View r0 = this.h;
        if (r0 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L22:
        ((FrameLayout) r0.findViewById(2131372797)).setAlpha(1.0f);
        View r1 = this.h;
        if (r1 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L25:
        ((FrameLayout) r1.findViewById(2131372795)).setAlpha(1.0f);
        ea0();
        return;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L19;
        this.m = false;
        View r2 = this.h;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L9:
        ((FrameLayout) r2.findViewById(2131372797)).setAlpha(0.4f);
        View r3 = this.h;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L12:
        ((FrameLayout) r3.findViewById(2131372795)).setAlpha(0.4f);
        View r4 = this.h;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L15:
        ((ImageView) r4.findViewById(2131376428)).setVisibility(8);
        View r5 = this.h;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L18:
        ((ImageView) r5.findViewById(2131376439)).setVisibility(8);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.g).clear();
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        this.l.dispose();
    }

    public final View aa0(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r4 = (View) ((LinkedHashMap) this.g).get(2131387922);
        if (r4 != null) goto L14;
        View r5 = getView();
        if (r5 == null) goto L12;
        View r6 = r5.findViewById(2131387922);
        if (r6 == null) goto L12;
        this.g.put(2131387922, r6);
        return r6;
    L12:
        return null;
    L14:
        return r4;
    }

    public static final void ba0(ApplyPermissionSwitchFragment r5, boolean r6) {
        if (r5.m == false) goto L17;
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        HashMap r1 = new HashMap();
        r0.element = r1;
        r1.put("scene", Integer.valueOf(r5.k));
        int r2 = r5.k;
        if (r2 != 1) goto L8;
        ((HashMap) r0.element).put("big_party_accept_need_verified", Boolean.valueOf(r6));
        ((HashMap) r0.element).put("big_party_only_accept_follower_apply", Boolean.valueOf(((Switch) r5.aa0(2131387922)).isChecked()));
    L12:
        LinkApi r3 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r4 = r5.j;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L15:
        Disposable r7 = r3.updateSetting(r4.getId(), (HashMap) r0.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r5, r0, r6));
        r5.l.add(r7);
        return;
    L8:
        if (r2 != 3) goto L12;
        ((HashMap) r0.element).put("audio_chat_accept_need_verified", Boolean.valueOf(r6));
        ((HashMap) r0.element).put("audio_chat_only_accept_follower_apply", Boolean.valueOf(((Switch) r5.aa0(2131387922)).isChecked()));
        goto L12
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        int r0 = 0;
        this.h = r4.inflate(2131565529, r5, false);
        View r7 = LayoutInflater.from(getContext()).inflate(2131565653, null);
        if (r7 == null) goto L56;
        ViewGroup r8 = (ViewGroup) r7;
        this.i = r8;
        ((ImageView) r8.findViewById(2131363802)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new ApplyPermissionSwitchFragment$initTopView$1(this)));
        ViewGroup r9 = this.i;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L7:
        ((TextView) r9.findViewById(2131388920)).setText(com.bytedance.android.live.core.utils.s1.B(2131917704));
        int r10 = this.k;
        boolean r11 = true;
        if (r10 != 1) goto L10;
        View r12 = this.h;
        if (r12 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L19:
        ((Switch) r12.findViewById(2131387922)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.p1.getValue()).booleanValue());
        this.n = ((Boolean) com.bytedance.android.livesdk.sharedpref.c.t1.getValue()).booleanValue();
        ea0();
    L20:
        View r13 = this.h;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L23:
        ((Switch) r13.findViewById(2131387922)).setOnCheckedChangeListener(new b(this));
        View r14 = this.h;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L26:
        ((FrameLayout) r14.findViewById(2131372797)).setOnClickListener(new c(this));
        View r15 = this.h;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L29:
        ((FrameLayout) r15.findViewById(2131372795)).setOnClickListener(new d(this));
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.D() == false) goto L32;
    L35:
        if (r11 == false) goto L51;
        View r16 = this.h;
        if (r16 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L40:
        FrameLayout r17 = (FrameLayout) r16.findViewById(2131372864);
        if (ca0() == true) goto L44;
        r0 = 8;
    L44:
        r17.setVisibility(r0);
        View r18 = this.h;
        if (r18 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L47:
        ((Switch) r18.findViewById(2131387924)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue());
        View r19 = this.h;
        if (r19 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L50:
        ((Switch) r19.findViewById(2131387924)).setOnCheckedChangeListener(new com.bytedance.android.live.liveinteract.linkpanel.fragment.a(this));
    L51:
        da0();
        View r20 = this.h;
        if (r20 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L54:
        return r20;
    L32:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.C() == true) goto L35;
        r11 = false;
        goto L35
    L10:
        if (r10 != 3) goto L20;
        View r21 = this.h;
        if (r21 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L15:
        ((Switch) r21.findViewById(2131387922)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.M0.getValue()).booleanValue());
        this.n = ((Boolean) com.bytedance.android.livesdk.sharedpref.c.L0.getValue()).booleanValue();
        ea0();
        goto L20
    L56:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
