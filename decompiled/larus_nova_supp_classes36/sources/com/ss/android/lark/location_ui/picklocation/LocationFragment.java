package com.ss.android.lark.location_ui.picklocation;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.LocationConstants$NameType;
import com.ss.android.lark.location.dto.POIConfig;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location.service.IPickLocationMap;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.storage.LarkKVStorage;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LocationFragment extends BaseFragment implements dqb.b {
    public static final /* synthetic */ int k = 0;
    public View d;
    public LocationView e;
    public i f;
    public boolean g;
    public POIConfig h;
    public Token i;
    public final a j;

    public class a implements com.ss.android.lark.location_ui.picklocation.a.InterfaceC0170a {
        public final /* synthetic */ LocationFragment a;

        public a(LocationFragment r1) {
            this.a = r1;
        }

        public final void a(POIInfo r45) {
            POIInfo r0 = r45;
            if (r0 == null) goto L15;
            this.a.h.disallowLatLngTransformation();
            LocationFragment r3 = this.a;
            if (r3.h.isLatLngTransformationDisallowed() == false) goto L7;
            r0.setInternal(com.ss.android.lark.location.service.f.a().isInHouse(r45.getLatitude(), r45.getLongitude()));
            r3.T90(r0);
            goto L15
        L7:
            boolean r4 = com.ss.android.lark.location.service.f.a().isInHouse(r45.getLatitude(), r45.getLongitude());
            POIConfig r5 = r3.h;
            if (r5 != null) goto L10;
        L11:
            if (r4 == false) goto L13;
            double r6 = r45.getLatitude();
            double r7 = r45.getLongitude();
            double r8 = r7 - 105.0d;
            double r10 = r6 - 35.0d;
            double r14 = r8 * 2.0d;
            double r24 = r8 * 0.1d;
            double r26 = r24 * r10;
            double r16 = ((((r14 - 100.0d) + (r10 * 3.0d)) + ((r10 * 0.2d) * r10)) + r26) + (Math.sqrt(Math.abs(r8)) * 0.2d);
            double r20 = (6.0d * r8) * 3.141592653589793d;
            double r15 = r14 * 3.141592653589793d;
            double r30 = r10 * 3.141592653589793d;
            double r17 = ((r16 + ((((Math.sin(r20) * 20.0d) + (Math.sin(r15) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r30) * 20.0d) + (Math.sin((r10 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r10 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(r30 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
            double r36 = (((((((r8 + 300.0d) + (r10 * 2.0d)) + (r24 * r8)) + r26) + (Math.sqrt(Math.abs(r8)) * 0.1d)) + ((((Math.sin(r20) * 20.0d) + (Math.sin(r15) * 20.0d)) * 2.0d) / 3.0d)) + ((((Math.sin(r8 * 3.141592653589793d) * 20.0d) + (Math.sin((r8 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d)) + ((((Math.sin((r8 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((r8 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
            double r11 = (r6 / 180.0d) * 3.141592653589793d;
            double r12 = Math.sin(r11);
            double r13 = 1.0d - ((0.006693421622965943d * r12) * r12);
            double r18 = Math.sqrt(r13);
            double[] r9 = {r6 - ((r17 * 180.0d) / ((6335552.717000426d / (r13 * r18)) * 3.141592653589793d)), r7 - ((r36 * 180.0d) / (((6378245.0d / r18) * Math.cos(r11)) * 3.141592653589793d))};
            r0 = (POIInfo) r45.clone();
            r0.setLatitude(r9[0]);
            r0.setLongitude(r9[1]);
            r0.setInternal(true);
        L13:
            r3.T90(r0);
            goto L15
        L10:
            if (r5.isNeedWGSLatLng() == false) goto L13;
        L15:
            if (this.a.h.isSelfDefine() == true) goto L33;
            int r1 = eqb.a.a;
            String r2 = LocationConstants$NameType.BUILDING;
            Intrinsics.checkNotNullParameter(LocationConstants$NameType.BUILDING, "defValue");
            String r19 = LarkKVStorage.q(new com.ss.android.lark.storage.a("location_component"), true).getString("name_type", LocationConstants$NameType.BUILDING);
            if (r19 == null) goto L21;
            r2 = r19;
        L21:
            int r21 = kqb.e.a;
            String r22 = LocationHitPoint$ResultType.DEFAULT;
            Intrinsics.checkNotNullParameter(LocationHitPoint$ResultType.DEFAULT, "defValue");
            String r23 = kqb.e.a().getString("result_type", LocationHitPoint$ResultType.DEFAULT);
            if (r23 == null) goto L31;
            r22 = r23;
        L31:
            JSONObject r25 = new JSONObject();     // Catch: JSONException -> L28
            r25.put("name_type", r2);     // Catch: JSONException -> L28
            r25.put("result_type", r22);     // Catch: JSONException -> L28
            Statistics.sendEvent("message_location_sent", r25);     // Catch: JSONException -> L28
            return;
        L28:
            e = move-exception;
            Log.d("sendLocationSendEvent failed to e:" + e);
            return;
        }
    }

    @Override // dqb.b
    public final boolean i5() {
        return ((c) this.f.getView()).i5();
    }

    public LocationFragment() {
        this.j = new a(this);
    }

    public final void S90() {
        if ((getActivity() instanceof LocationResponsiveActivity) == false) goto L6;
        com.ss.android.lark.ui.component_container.a.d(this, null);
        return;
    L6:
        if (getActivity() != null) goto L8;
        return;
    L8:
        if (this.g == false) goto L10;
        getActivity().onBackPressed();
        return;
    L10:
        getActivity().finish();
    }

    public final void onDestroy() {
        super.onDestroy();
        i r0 = this.f;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        IPickLocationMap r0 = this.e.n;
        if (r0 == null) goto L7;
        r0.onPause();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        LocationView r0 = this.e;
        IPickLocationMap r1 = r0.n;
        if (r1 == null) goto L11;
        r1.onResume();
        TextView r2 = r0.mTvRequestPermission;
        if (r0.s(r0.b) == false) goto L8;
        int r3 = 8;
    L9:
        r2.setVisibility(r3);
        return;
    L8:
        r3 = 0;
        goto L9
    }

    public final void T90(POIInfo r4) {
        Bundle r0 = getArguments();
        if (r0 != null) goto L6;
        S90();
        return;
    L6:
        String r1 = r0.getString("location_unique_key");
        hqb.a r2 = hqb.a.a(r1);
        FragmentActivity r3 = getActivity();
        gqb.a r5 = r2.a;
        if (r5 == null) goto L12;
        if (r4 == null) goto L12;
        r5.a(r3, r4);
    L12:
        hqb.a.b(r1);
        S90();
    }

    public final void onActivityCreated(Bundle r4) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r4);
        FragmentActivity r5 = requireActivity();
        if (com.ss.android.lark.location.service.f.a().isAdminLocationMapSDKEnabled() == true) goto L9;
        Log.e("LocationFragment", "disable start LocationFragment cause admin amap sdk is false");
        POIInfo r0 = new POIInfo();
        r0.setErrorCode(40400);
        int r1 = LarkLocation.k;
        r0.setErrorMsg(r5.getString(2131890611));
        Bundle r2 = getArguments();
        if (r2 == null) goto L7;
        String r3 = r2.getString("location_unique_key");
        hqb.a.a(r3).a.a(r5, r0);
        UDToast.show(r5, r5.getString(2131890612));
        hqb.a.b(r3);
    L7:
        S90();
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        Log.i("LocationFragment", "on configuration changed, amap refresh marker");
        LocationView r3 = this.e;
        if (r3 == null) goto L8;
        IPickLocationMap r4 = r3.n;
        if (r4 == null) goto L9;
        r4.k();
        return;
    L9:
        return;
    }

    public final void onSaveInstanceState(Bundle r2) {
        IPickLocationMap r0 = this.e.n;
        if (r0 == null) goto L7;
        r0.onSaveInstanceState(r2);
        return;
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r1, r2, r3);
        this.e.getClass();
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        this.d = r10.inflate(2131561216, r11, false);
        Bundle r13 = getArguments();
        POIConfig r14 = (POIConfig) r13.getSerializable("location_request_config");
        this.h = r14;
        if (r14 != null) goto L5;
        Log.e("LocationFragment", "initMVP, config not provide");
        S90();
    L10:
        return this.d;
    L5:
        this.g = r13.getBoolean("only_fragment");
        this.i = r13.getParcelable("location_token");
        Scene r15 = (Scene) r13.getSerializable("scene");
        if (r15 != null) goto L8;
        r15 = Scene.IM.INSTANCE;
        Log.e("LocationFragment", "initMVP, scene not provide");
    L8:
        boolean r8 = r13.getBoolean("is_office_sdk");
        e r16 = new e();
        FragmentActivity r2 = getActivity();
        a r3 = this.j;
        POIConfig r4 = this.h;
        boolean r5 = this.g;
        Token r6 = this.i;
        LocationView r17 = new LocationView(r2, r3, r4, r5, r6, r15, r8);
        this.e = r17;
        i r18 = new i(r16, r17);
        this.f = r18;
        r18.create();
        goto L10
    }
}
