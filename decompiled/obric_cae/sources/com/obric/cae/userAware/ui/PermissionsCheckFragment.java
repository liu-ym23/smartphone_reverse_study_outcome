package com.obric.cae.userAware.ui;

import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.R;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionsCheckFragment extends Fragment {
    private Button btnNext;
    private Button btnOpenBt;
    private Button btnOpenLoc;
    private Button btnOpenWifi;
    private Button btnReqBtPerm;
    private Button btnReqLocPerm;
    private Button btnReqMicPerm;
    private androidx.activity.result.b<String[]> requestPermissionsLauncher;
    private TextView tvBtPerm;
    private TextView tvBtSwitch;
    private TextView tvLocPerm;
    private TextView tvLocSwitch;
    private TextView tvMicPerm;
    private TextView tvWifiSwitch;

    public interface OnAllReadyListener {
        void onAllReady();
    }

    public PermissionsCheckFragment() {
    }

    public static /* synthetic */ void a(PermissionsCheckFragment r8, View r10) {
        r8.lambda$onCreateView$5(r10);
    }

    public static /* synthetic */ void b(PermissionsCheckFragment r8, View r10) {
        r8.lambda$onCreateView$4(r10);
    }

    public static /* synthetic */ void c(PermissionsCheckFragment r8, Map r10) {
        r8.lambda$onCreateView$0(r10);
    }

    public static /* synthetic */ void d(PermissionsCheckFragment r8, View r10) {
        r8.lambda$onCreateView$3(r10);
    }

    public static /* synthetic */ void e(PermissionsCheckFragment r8, View r10) {
        r8.lambda$onCreateView$6(r10);
    }

    public static /* synthetic */ void f(PermissionsCheckFragment r8, View r10) {
        r8.lambda$onCreateView$7(r10);
    }

    public static /* synthetic */ void g(PermissionsCheckFragment r8, View r10) {
        r8.lambda$onCreateView$2(r10);
    }

    private OnAllReadyListener getAllReadyListener() {
        if ((getActivity() instanceof OnAllReadyListener) == true) goto L5;
        return null;
    L5:
        return (OnAllReadyListener) getActivity();
    }

    public static /* synthetic */ void h(PermissionsCheckFragment r8, View r10) {
        r8.lambda$onCreateView$1(r10);
    }

    private boolean isAllReady() {
        Context r8 = requireContext();
        if (isBluetoothPermissionGranted(r8) == true) goto L5;
    L15:
        return false;
    L5:
        if (isLocationPermissionGranted(r8) == false) goto L15;
        if (isMicPermissionGranted(r8) == false) goto L15;
        if (isBluetoothEnabled() == false) goto L15;
        if (isLocationEnabled(r8) == false) goto L15;
        if (isWifiEnabled(r8) == false) goto L15;
        return true;
    }

    private boolean isBluetoothEnabled() {
        BluetoothAdapter r8 = BluetoothAdapter.getDefaultAdapter();
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.isEnabled() == false) goto L7;
        return true;
    }

    private boolean isBluetoothPermissionGranted(Context r8) {
        if (androidx.core.content.a.a(r8, "android.permission.BLUETOOTH_CONNECT") == 0) goto L5;
    L7:
        return false;
    L5:
        if (androidx.core.content.a.a(r8, "android.permission.BLUETOOTH_SCAN") != 0) goto L7;
        return true;
    }

    private boolean isLocationEnabled(Context r8) {
        LocationManager r10 = (LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION);
        if (r10 != null) goto L13;
        return false;
    L13:
    L11:
        Log.e("PermissionsCheckFragment", "Check location enabled failed");
        return false;
    L6:
        if (r10.isProviderEnabled(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS) == true) goto L9;
        if (r10.isProviderEnabled("network") == true) goto L9;
        return false;
    L9:
        return true;
    }

    private boolean isLocationPermissionGranted(Context r8) {
        if (androidx.core.content.a.a(r8, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isMicPermissionGranted(Context r8) {
        if (androidx.core.content.a.a(r8, "android.permission.RECORD_AUDIO") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isWifiEnabled(Context r8) {
        WifiManager r10 = (WifiManager) r8.getApplicationContext().getSystemService("wifi");
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isWifiEnabled() == false) goto L7;
        return true;
    }

    private /* synthetic */ void lambda$onCreateView$0(Map r8) {
        updateAll();
    }

    private /* synthetic */ void lambda$onCreateView$1(View r8) {
        requestBluetoothPermissions();
    }

    private /* synthetic */ void lambda$onCreateView$2(View r8) {
        requestLocationPermission();
    }

    private /* synthetic */ void lambda$onCreateView$3(View r8) {
        requestMicPermissionOrSettings();
    }

    private /* synthetic */ void lambda$onCreateView$4(View r8) {
        openSettingsSafely("android.settings.BLUETOOTH_SETTINGS");
    }

    private /* synthetic */ void lambda$onCreateView$5(View r8) {
        openSettingsSafely("android.settings.LOCATION_SOURCE_SETTINGS");
    }

    private /* synthetic */ void lambda$onCreateView$6(View r8) {
        openSettingsSafely("android.settings.WIFI_SETTINGS");
    }

    private /* synthetic */ void lambda$onCreateView$7(View r8) {
        if (isAllReady() == false) goto L8;
        OnAllReadyListener r10 = getAllReadyListener();
        if (r10 == null) goto L9;
        r10.onAllReady();
        return;
    L9:
        return;
    }

    private void openSettingsSafely(String r8) {
        startActivity(new Intent(r8));     // Catch: ActivityNotFoundException -> L4
        return;
    L4:
        Log.e("PermissionsCheckFragment", "Settings activity not found: " + r8);
    }

    private void requestBluetoothPermissions() {
        this.requestPermissionsLauncher.a(new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN"});
    }

    private void requestLocationPermission() {
        this.requestPermissionsLauncher.a(new String[]{"android.permission.ACCESS_FINE_LOCATION"});
    }

    private void requestMicPermission() {
        this.requestPermissionsLauncher.a(new String[]{"android.permission.RECORD_AUDIO"});
    }

    private void requestMicPermissionOrSettings() {
        Context r8 = requireContext();
        if (isMicPermissionGranted(r8) == false) goto L6;
        return;
    L6:
        if (shouldShowRequestPermissionRationale("android.permission.RECORD_AUDIO") == false) goto L12;
    L10:
        requestMicPermission();
        return;
    L12:
        Intent r10 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");     // Catch: ActivityNotFoundException -> L9
        r10.setData(Uri.fromParts("package", r8.getPackageName(), null));     // Catch: ActivityNotFoundException -> L9
        startActivity(r10);     // Catch: ActivityNotFoundException -> L9
        return;
    L9:
        Log.e("PermissionsCheckFragment", "App settings not found");
        goto L10
    }

    private void updateAll() {
        Context r8 = requireContext();
        TextView r10 = this.tvBtPerm;
        if (isBluetoothPermissionGranted(r8) == false) goto L5;
        int r11 = R.string.debug_perm_bt_granted;
    L6:
        r10.setText(getString(r11));
        TextView r12 = this.tvLocPerm;
        if (isLocationPermissionGranted(r8) == false) goto L9;
        int r13 = R.string.debug_perm_location_granted;
    L10:
        r12.setText(getString(r13));
        TextView r14 = this.tvMicPerm;
        if (isMicPermissionGranted(r8) == false) goto L13;
        int r15 = R.string.debug_perm_mic_granted;
    L14:
        r14.setText(getString(r15));
        TextView r16 = this.tvBtSwitch;
        if (isBluetoothEnabled() == false) goto L17;
        int r17 = R.string.debug_switch_bt_on;
    L18:
        r16.setText(getString(r17));
        TextView r18 = this.tvLocSwitch;
        if (isLocationEnabled(r8) == false) goto L21;
        int r19 = R.string.debug_switch_location_on;
    L22:
        r18.setText(getString(r19));
        TextView r20 = this.tvWifiSwitch;
        if (isWifiEnabled(r8) == false) goto L25;
        int r21 = R.string.debug_switch_wifi_on;
    L26:
        r20.setText(getString(r21));
        Button r22 = this.btnReqBtPerm;
        int r23 = 8;
        if (isBluetoothPermissionGranted(r8) == false) goto L29;
        int r24 = 8;
    L30:
        r22.setVisibility(r24);
        Button r25 = this.btnReqLocPerm;
        if (isLocationPermissionGranted(r8) == false) goto L33;
        int r26 = 8;
    L34:
        r25.setVisibility(r26);
        Button r27 = this.btnReqMicPerm;
        if (isMicPermissionGranted(r8) == false) goto L37;
        int r28 = 8;
    L38:
        r27.setVisibility(r28);
        Button r29 = this.btnOpenBt;
        if (isBluetoothEnabled() == false) goto L41;
        int r30 = 8;
    L42:
        r29.setVisibility(r30);
        Button r31 = this.btnOpenLoc;
        if (isLocationEnabled(r8) == false) goto L45;
        int r32 = 8;
    L46:
        r31.setVisibility(r32);
        Button r33 = this.btnOpenWifi;
        if (isWifiEnabled(r8) == false) goto L49;
        int r34 = 8;
    L50:
        r33.setVisibility(r34);
        boolean r35 = isAllReady();
        Button r36 = this.btnNext;
        if (r35 == true) goto L54;
        r23 = 0;
    L54:
        r36.setVisibility(r23);
        Button r37 = this.btnNext;
        if (r35 == true) goto L57;
        r37.setEnabled(false);
        this.btnNext.setClickable(false);
        Button r38 = this.btnNext;
        float r39 = 0.5f;
    L58:
        r38.setAlpha(r39);
        if (r35 == false) goto L64;
        OnAllReadyListener r40 = getAllReadyListener();
        if (r40 == null) goto L65;
        r40.onAllReady();
        return;
    L65:
        return;
    L64:
        return;
    L57:
        r37.setEnabled(true);
        this.btnNext.setClickable(true);
        r38 = this.btnNext;
        r39 = 1.0f;
        goto L58
    L49:
        r34 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r30 = 0;
        goto L42
    L37:
        r28 = 0;
        goto L38
    L33:
        r26 = 0;
        goto L34
    L29:
        r24 = 0;
        goto L30
    L25:
        r21 = R.string.debug_switch_wifi_off;
        goto L26
    L21:
        r19 = R.string.debug_switch_location_off;
        goto L22
    L17:
        r17 = R.string.debug_switch_bt_off;
        goto L18
    L13:
        r15 = R.string.debug_perm_mic_denied;
        goto L14
    L9:
        r13 = R.string.debug_perm_location_denied;
        goto L10
    L5:
        r11 = R.string.debug_perm_bt_denied;
        goto L6
    }

    @Override // androidx.lifecycle.f
    public t0.a getDefaultViewModelCreationExtras() {
        return t0.a.C0158a.f12207b;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r8, ViewGroup r10, Bundle r11) {
        final int r12 = 0;
        View r13 = r8.inflate(R.layout.fragment_permissions_check, r10, false);
        this.tvBtPerm = (TextView) r13.findViewById(R.id.tv_bt_permission);
        this.tvLocPerm = (TextView) r13.findViewById(R.id.tv_location_permission);
        this.tvMicPerm = (TextView) r13.findViewById(R.id.tv_mic_permission);
        this.tvBtSwitch = (TextView) r13.findViewById(R.id.tv_bt_switch);
        this.tvLocSwitch = (TextView) r13.findViewById(R.id.tv_location_switch);
        this.tvWifiSwitch = (TextView) r13.findViewById(R.id.tv_wifi_switch);
        this.btnReqBtPerm = (Button) r13.findViewById(R.id.btn_request_bt_permission);
        this.btnReqLocPerm = (Button) r13.findViewById(R.id.btn_request_location_permission);
        this.btnReqMicPerm = (Button) r13.findViewById(R.id.btn_request_mic_permission);
        this.btnOpenBt = (Button) r13.findViewById(R.id.btn_open_bt);
        this.btnOpenLoc = (Button) r13.findViewById(R.id.btn_open_location);
        this.btnOpenWifi = (Button) r13.findViewById(R.id.btn_open_wifi);
        this.btnNext = (Button) r13.findViewById(R.id.btn_next);
        this.requestPermissionsLauncher = registerForActivityResult(new b.b(), new androidx.core.app.b(this));
        this.btnReqBtPerm.setOnClickListener(new e0(this, r12));
        this.btnReqLocPerm.setOnClickListener(new f0(this, r12));
        this.btnReqMicPerm.setOnClickListener(new g0(this, r12));
        final int r14 = 1;
        this.btnOpenBt.setOnClickListener(new e0(this, r14));
        this.btnOpenLoc.setOnClickListener(new f0(this, r14));
        this.btnOpenWifi.setOnClickListener(new g0(this, r14));
        final int r15 = 2;
        this.btnNext.setOnClickListener(new e0(this, r15));
        return r13;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateAll();
    }
}
