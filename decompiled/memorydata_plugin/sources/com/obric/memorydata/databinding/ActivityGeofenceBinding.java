package com.obric.memorydata.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityGeofenceBinding implements ViewBinding {
    public final Button btnAddGeofence;
    public final Button btnCloseStrategy;
    public final Button btnFiveMinute;
    public final Button btnOneMinute;
    public final Button btnOpenStrategy;
    public final Button btnRemoveGeofence;
    public final Button btnTwoMinute;
    public final EditText etFenceId;
    public final EditText etLocation;
    public final EditText etPackage;
    private final LinearLayout rootView;

    private ActivityGeofenceBinding(LinearLayout r1, Button r2, Button r3, Button r4, Button r5, Button r6, Button r7, Button r8, EditText r9, EditText r10, EditText r11) {
        this.rootView = r1;
        this.btnAddGeofence = r2;
        this.btnCloseStrategy = r3;
        this.btnFiveMinute = r4;
        this.btnOneMinute = r5;
        this.btnOpenStrategy = r6;
        this.btnRemoveGeofence = r7;
        this.btnTwoMinute = r8;
        this.etFenceId = r9;
        this.etLocation = r10;
        this.etPackage = r11;
    }

    public static ActivityGeofenceBinding bind(View r18) {
        int r1 = ZeusTransformUtils.mapRes(R.id.btn_add_geofence, OaidModel.KEY_ID, "btn_add_geofence");
        Button r8 = (Button) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), Button.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_close_strategy, OaidModel.KEY_ID, "btn_close_strategy");
        Button r9 = (Button) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), Button.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_five_minute, OaidModel.KEY_ID, "btn_five_minute");
        Button r10 = (Button) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), Button.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_one_minute, OaidModel.KEY_ID, "btn_one_minute");
        Button r11 = (Button) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), Button.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_open_strategy, OaidModel.KEY_ID, "btn_open_strategy");
        Button r12 = (Button) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), Button.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_remove_geofence, OaidModel.KEY_ID, "btn_remove_geofence");
        Button r13 = (Button) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), Button.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_two_minute, OaidModel.KEY_ID, "btn_two_minute");
        Button r14 = (Button) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), Button.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.et_fence_id, OaidModel.KEY_ID, "et_fence_id");
        EditText r15 = (EditText) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), EditText.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.et_location, OaidModel.KEY_ID, "et_location");
        EditText r16 = (EditText) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), EditText.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L25;
        r1 = ZeusTransformUtils.mapRes(R.id.et_package, OaidModel.KEY_ID, "et_package");
        EditText r17 = (EditText) ZeusTransformUtils.preCheckCast(r18.findViewById(r1), EditText.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L25;
        return new ActivityGeofenceBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r18, LinearLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r18, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static ActivityGeofenceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityGeofenceBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_geofence, "layout", "activity_geofence"), r4, false, "com.obric.memorydata.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return bind(r6);
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
