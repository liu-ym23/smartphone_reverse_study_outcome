package com.ss.android.lark.locationmessage.ui.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.biz.im.api.LocationInfo;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class NavigateFragment extends BaseFragment {
    public View d;
    public h e;
    public NavigateView f;
    public String g;
    public boolean h;
    public final a i;

    public class a implements NavigateView.b {
        public final /* synthetic */ NavigateFragment a;

        public a(NavigateFragment r1) {
            this.a = r1;
        }
    }

    public NavigateFragment() {
        this.i = new a(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        h r0 = this.e;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        com.ss.android.lark.location.service.d r0 = this.f.o;
        if (r0 == null) goto L7;
        r0.onPause();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        NavigateView r0 = this.f;
        com.ss.android.lark.location.service.d r1 = r0.o;
        if (r1 == null) goto L16;
        r1.onResume();
        TextView r2 = r0.mTvRequestPermission;
        Activity r3 = r0.b;
        int r4 = 0;
        if (ContextCompat.checkSelfPermission(r3, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        r4 = 8;
    L14:
        r2.setVisibility(r4);
        return;
    L8:
        if (ContextCompat.checkSelfPermission(r3, "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L11;
        r5 = false;
        goto L12
    }

    public final void onActivityCreated(Bundle r3) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r3);
        FragmentActivity r4 = requireActivity();
        if (com.ss.android.lark.location.service.f.a().isAdminLocationMapSDKEnabled() == true) goto L6;
        Log.e("NavigateFragment", "disable start NavigateFragment cause admin amap sdk is false");
        UDToast.show(r4, r4.getString(2131890618));
        finish();
        return;
    }

    public final void onSaveInstanceState(Bundle r2) {
        com.ss.android.lark.location.service.d r0 = this.f.o;
        if (r0 == null) goto L7;
        r0.onSaveInstanceState(r2);
        return;
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        this.d = r9.inflate(2131561222, r10, false);
        Bundle r12 = getArguments();
        LocationInfo r6 = r12.getSerializable("extra_location");
        this.h = r12.getBoolean("only_fragment");
        this.g = r12.getString("extra_favorite_id", null);
        Token r3 = r12.getParcelable("location_token");
        String r7 = r12.getString("origin_merge_forward_id");
        Scene r13 = (Scene) r12.getSerializable("scene");
        if (r13 != null) goto L5;
        r13 = Scene.IM.INSTANCE;
        Log.e("NavigateFragment", "initMVP, scene not provide");
    L5:
        FragmentActivity r1 = getActivity();
        View r2 = this.d;
        NavigateView r14 = new NavigateView(r1, r2, r3, r13, this.i, r6, r7);
        this.f = r14;
        h r15 = new h(r14);
        this.e = r15;
        r15.create();
        return this.d;
    }
}
