package com.obric.cae.smartBluetooth.dcf;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.obric.cae.libs.bluetooth.CaeDcfScanResult;
import com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanCallbackExporter;
import com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter;
import com.obric.cae.log.CaeLog;
import defpackage.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class DcfScanTestActivity extends Activity {
    private static final String SERVICE_ACTION = "com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter";
    private static final String TAG = "DcfScanTestActivity";
    private ArrayAdapter<String> mAdapter;
    private boolean mBound;
    private final ICaeDcfScanCallbackExporter mCallback;
    private final ServiceConnection mConnection;
    private final List<String> mDeviceRows;
    private Button mInitButton;
    private Button mScanButton;
    private boolean mScanning;
    private ICaeDcfScanExporter mService;
    private TextView mStatusText;

    /* JADX INFO: renamed from: com.obric.cae.smartBluetooth.dcf.DcfScanTestActivity$1, reason: invalid class name */
    public class AnonymousClass1 extends ICaeDcfScanCallbackExporter.Stub {
        final /* synthetic */ DcfScanTestActivity this$0;

        public AnonymousClass1(DcfScanTestActivity r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void H2(AnonymousClass1 r8, List r10) {
            r8.lambda$onDevicesChanged$0(r10);
        }

        private /* synthetic */ void lambda$onDevicesChanged$0(List r8) {
            DcfScanTestActivity.access$000(this.this$0, r8);
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanCallbackExporter
        public void onDevicesChanged(final List<CaeDcfScanResult> r8) {
            this.this$0.runOnUiThread(new a(this, r8));
        }
    }

    public DcfScanTestActivity() {
        this.mDeviceRows = new ArrayList();
        this.mCallback = new AnonymousClass1(this);
        this.mConnection = new AnonymousClass2(this);
    }

    public static /* synthetic */ void a(DcfScanTestActivity r8, View r10) {
        r8.lambda$createContentView$1(r10);
    }

    public static /* synthetic */ void access$000(DcfScanTestActivity r8, List r10) {
        r8.updateDevices(r10);
    }

    public static /* synthetic */ ICaeDcfScanExporter access$102(DcfScanTestActivity r8, ICaeDcfScanExporter r10) {
        r8.mService = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$202(DcfScanTestActivity r8, boolean r10) {
        r8.mBound = r10;
        return r10;
    }

    public static /* synthetic */ Button access$300(DcfScanTestActivity r8) {
        return r8.mInitButton;
    }

    public static /* synthetic */ Button access$400(DcfScanTestActivity r8) {
        return r8.mScanButton;
    }

    public static /* synthetic */ boolean access$500(DcfScanTestActivity r8) {
        return r8.isDcfScanSupported();
    }

    public static /* synthetic */ void access$600(DcfScanTestActivity r8, String r10) {
        r8.updateStatus(r10);
    }

    public static /* synthetic */ boolean access$702(DcfScanTestActivity r8, boolean r10) {
        r8.mScanning = r10;
        return r10;
    }

    public static /* synthetic */ void b(DcfScanTestActivity r8, View r10) {
        r8.lambda$createContentView$0(r10);
    }

    private void bindDcfService() {
        if (this.mBound == false) goto L15;
        updateStatus("service already connected, platformReady=" + isDcfScanSupported());
        return;
    L15:
        Intent r8 = new Intent(this, CaeDcfScanService.class);     // Catch: Exception -> L12
        r8.setAction(SERVICE_ACTION);     // Catch: Exception -> L12
        if (bindService(r8, this.mConnection, 1) == false) goto L9;
        String r10 = "started";
    L10:
        updateStatus("bind service ".concat(r10));     // Catch: Exception -> L12
        return;
    L9:
        r10 = "failed";
    L12:
        e = move-exception;
        CaeLog.e(TAG, "bindDcfService failed", e);
        updateStatus("bind failed: " + e.getMessage());
    }

    private View createContentView() {
        LinearLayout r8 = new LinearLayout(this);
        r8.setOrientation(1);
        r8.setPadding(dp(16), dp(16), dp(16), dp(16));
        TextView r10 = new TextView(this);
        this.mStatusText = r10;
        r10.setTextSize(14.0f);
        r8.addView(this.mStatusText, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout r11 = new LinearLayout(this);
        r11.setGravity(16);
        r11.setOrientation(0);
        r11.setPadding(0, dp(12), 0, dp(12));
        r8.addView(r11, new LinearLayout.LayoutParams(-1, -2));
        Button r12 = new Button(this);
        this.mInitButton = r12;
        r12.setText("Bind Service");
        this.mInitButton.setAllCaps(false);
        this.mInitButton.setOnClickListener(new com.google.android.material.search.a(this, 3));
        r11.addView(this.mInitButton, new LinearLayout.LayoutParams(0, -2, 1.0f));
        Button r13 = new Button(this);
        this.mScanButton = r13;
        r13.setText("Start Scan");
        this.mScanButton.setAllCaps(false);
        this.mScanButton.setEnabled(false);
        this.mScanButton.setOnClickListener(new com.obric.cae.location.zpp.ui.a(this, 2));
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        r14.leftMargin = dp(12);
        r11.addView(this.mScanButton, r14);
        ListView r15 = new ListView(this);
        ArrayAdapter<String> r16 = new ArrayAdapter(this, R.layout.simple_list_item_1, this.mDeviceRows);
        this.mAdapter = r16;
        r15.setAdapter(r16);
        r8.addView(r15, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return r8;
    }

    private int dp(int r8) {
        return (int) ((r8 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private String formatDevice(CaeDcfScanResult r8) {
        if (r8 != null) goto L5;
        return "null device";
    L5:
        String r10 = DcfByteUtils.byteToString(r8.getRawData());
        if (TextUtils.isEmpty(r10) == false) goto L9;
        r10 = "";
    L9:
        return "deviceId=" + r8.getDeviceId() + "\ntime=" + formatTime(r8.getTimestamp()) + "\nrawData=" + r10;
    }

    private String formatTime(long r8) {
        return new SimpleDateFormat("HH:mm:ss.SSS", Locale.US).format(new Date(r8));
    }

    private boolean isDcfScanSupported() {
        ICaeDcfScanExporter r8 = this.mService;
        if (r8 != null) goto L10;
        return false;
    L10:
        return r8.isDcfScanSupported();
    L7:
        e = move-exception;
        CaeLog.e(TAG, "isDcfScanSupported failed", e);
        return false;
    }

    private /* synthetic */ void lambda$createContentView$0(View r8) {
        bindDcfService();
    }

    private /* synthetic */ void lambda$createContentView$1(View r8) {
        toggleScan();
    }

    private void stopScanIfNeeded() {
        if (this.mScanning == false) goto L15;
        ICaeDcfScanExporter r8 = this.mService;
        if (r8 == null) goto L16;
        r8.unregisterDcfScanCallback(this.mCallback);     // Catch: Throwable -> L9
    L11:
        this.mScanning = false;
        this.mScanButton.setText("Start Scan");
        updateStatus("scan stopped");
        return;
    L9:
        e = move-exception;
        CaeLog.e(TAG, "stop scan failed", e);
        updateStatus("stop scan failed: " + e.getMessage());
        goto L11
    L16:
        return;
    }

    private void toggleScan() {
        if (this.mBound == false) goto L16;
        ICaeDcfScanExporter r8 = this.mService;
        if (r8 == null) goto L16;
        if (this.mScanning == false) goto L18;
        stopScanIfNeeded();
        return;
    L18:
        r8.registerDcfScanCallback(this.mCallback);     // Catch: Throwable -> L13
        this.mScanning = true;     // Catch: Throwable -> L13
        this.mScanButton.setText("Stop Scan");     // Catch: Throwable -> L13
        this.mDeviceRows.clear();     // Catch: Throwable -> L13
        this.mDeviceRows.add("Scanning...");     // Catch: Throwable -> L13
        this.mAdapter.notifyDataSetChanged();     // Catch: Throwable -> L13
        updateStatus("scan starting, platformReady=" + isDcfScanSupported());     // Catch: Throwable -> L13
        return;
    L13:
        e = move-exception;
        CaeLog.e(TAG, "start scan failed", e);
        updateStatus("start scan failed: " + e.getMessage());
        return;
    L16:
        updateStatus("please bind service first");
    }

    private void updateDevices(List<CaeDcfScanResult> r8) {
        this.mDeviceRows.clear();
        if (r8 == null) goto L9;
        Iterator<CaeDcfScanResult> r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L9;
        CaeDcfScanResult r11 = r10.next();
        this.mDeviceRows.add(formatDevice(r11));
    L9:
        if (this.mDeviceRows.isEmpty() == false) goto L11;
        this.mDeviceRows.add("No DCF devices discovered.");
    L11:
        this.mAdapter.notifyDataSetChanged();
        StringBuilder r12 = new StringBuilder("scan=");
        r12.append(this.mScanning);
        r12.append(", platformReady=");
        r12.append(isDcfScanSupported());
        r12.append(", devices=");
        if (r8 == null) goto L14;
        int r13 = r8.size();
    L15:
        r12.append(r13);
        updateStatus(r12.toString());
        return;
    L14:
        r13 = 0;
        goto L15
    }

    private void updateStatus(String r8) {
        String r10 = b.c("Status: ", r8);
        CaeLog.i(TAG, r10);
        TextView r11 = this.mStatusText;
        if (r11 == null) goto L6;
        r11.setText(r10);
        return;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        setTitle("DCF BLE Scan Test");
        setContentView(createContentView());
        updateStatus("idle");
        bindDcfService();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        stopScanIfNeeded();
        if (this.mBound == false) goto L5;
        unbindService(this.mConnection);
        this.mBound = false;
    L5:
        super.onDestroy();
    }
}
