package com.obric.cae.userAware.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.utils.AIKernelJavaBridge;
import com.obric.cae.utils.CaeUtil;
import java.time.LocalTime;

/* JADX INFO: loaded from: classes2.dex */
public class NearElevatorActivity extends Activity {
    private static final String TAG = "NearElevatorActivity";
    private final int BUTTON_CLICK_TIMEOUT_CNT;
    private final int BUTTON_FREE_INTERVAL;
    private Activity mActivity;
    private TextView mContentText;
    private NearElevator mNearElevator;
    private ScrollView mScrollView;
    private int nearElevatorCnt;
    private int testCnt;

    /* JADX INFO: renamed from: com.obric.cae.userAware.ui.NearElevatorActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements NearElevator.NearElevatorListener {
        final /* synthetic */ NearElevatorActivity this$0;

        public AnonymousClass1(NearElevatorActivity r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass1 r8, int r10) {
            r8.lambda$nearElevatorEvent$2(r10);
        }

        public static /* synthetic */ void b(AnonymousClass1 r8) {
            r8.lambda$outElevatorEvent$1();
        }

        public static /* synthetic */ void c(AnonymousClass1 r8, int r10, int r11) {
            r8.lambda$outElevatorAndAnchorUpdate$3(r10, r11);
        }

        public static /* synthetic */ void d(AnonymousClass1 r8) {
            r8.lambda$inElevatorEvent$0();
        }

        private /* synthetic */ void lambda$inElevatorEvent$0() {
            CaeUtil.showShortToast(NearElevatorActivity.access$200(this.this$0), this.this$0.getString(R.string.user_aware_aware_in_elevator));
            NearElevatorActivity.access$000(this.this$0).append("\n" + LocalTime.now() + ": " + this.this$0.getString(R.string.user_aware_aware_in_elevator));
            NearElevatorActivity.access$100(this.this$0);
        }

        private /* synthetic */ void lambda$nearElevatorEvent$2(int r8) {
            CaeUtil.showShortToast(NearElevatorActivity.access$200(this.this$0), this.this$0.getString(R.string.user_aware_aware_near_elevator));
            NearElevatorActivity.access$000(this.this$0).append("\n" + LocalTime.now() + ": " + this.this$0.getString(R.string.user_aware_wifi_match_by_system_wifi_scan) + this.this$0.getString(R.string.user_aware_aware_near_elevator) + "elevatorId: " + r8);
            NearElevatorActivity.access$100(this.this$0);
        }

        private /* synthetic */ void lambda$outElevatorAndAnchorUpdate$3(int r8, int r10) {
            defpackage.a.i("outElevatorAndAnchorUpdate, anchorSize: ", r8, NearElevatorActivity.TAG);
            NearElevatorActivity.access$000(this.this$0).append("\n" + LocalTime.now() + ": " + this.this$0.getString(R.string.user_aware_aware_out_elevator_anchor_update) + r8 + " new elevatorId: " + r10);
            NearElevatorActivity.access$100(this.this$0);
        }

        private /* synthetic */ void lambda$outElevatorEvent$1() {
            CaeUtil.showShortToast(NearElevatorActivity.access$200(this.this$0), this.this$0.getString(R.string.user_aware_aware_out_elevator));
            NearElevatorActivity.access$000(this.this$0).append("\n" + LocalTime.now() + ": " + this.this$0.getString(R.string.user_aware_aware_out_elevator));
            NearElevatorActivity.access$100(this.this$0);
        }

        @Override // com.obric.cae.userAware.NearElevator.NearElevator.NearElevatorListener
        public void inElevatorEvent() {
            this.this$0.runOnUiThread(new b0(this, 0));
        }

        @Override // com.obric.cae.userAware.NearElevator.NearElevator.NearElevatorListener
        public void nearElevatorEvent(int r8) {
            this.this$0.runOnUiThread(new a0(r8, 0, this));
        }

        @Override // com.obric.cae.userAware.NearElevator.NearElevator.NearElevatorListener
        public void outElevatorAndAnchorUpdate(final int r8, final int r10) {
            this.this$0.runOnUiThread(new d0(this, r8, r10));
        }

        @Override // com.obric.cae.userAware.NearElevator.NearElevator.NearElevatorListener
        public void outElevatorEvent() {
            this.this$0.runOnUiThread(new c0(this, 0));
        }
    }

    public NearElevatorActivity() {
        this.testCnt = 0;
        this.nearElevatorCnt = 0;
        this.BUTTON_FREE_INTERVAL = 100;
        this.BUTTON_CLICK_TIMEOUT_CNT = 30;
    }

    public static /* synthetic */ TextView access$000(NearElevatorActivity r8) {
        return r8.mContentText;
    }

    public static /* synthetic */ void access$100(NearElevatorActivity r8) {
        r8.scrollToBottom();
    }

    public static /* synthetic */ Activity access$200(NearElevatorActivity r8) {
        return r8.mActivity;
    }

    public static /* synthetic */ void access$300(NearElevatorActivity r8) {
        r8.onClearAnchorClick();
    }

    public static /* synthetic */ void access$400(NearElevatorActivity r8) {
        r8.onCreateAnchorClick();
    }

    public static /* synthetic */ void access$500(NearElevatorActivity r8) {
        r8.onCheckElevatorClick();
    }

    public static /* synthetic */ void access$600(NearElevatorActivity r8) {
        r8.onLoadModelClick();
    }

    public static /* synthetic */ void access$700(NearElevatorActivity r8) {
        r8.onCheckElevatorErrorClick();
    }

    public static /* synthetic */ void access$800(NearElevatorActivity r8) {
        r8.onCheckElevatorErrorClickConfirmed();
    }

    public static /* synthetic */ ScrollView access$900(NearElevatorActivity r8) {
        return r8.mScrollView;
    }

    private void initData() {
        this.mContentText.setText(getString(R.string.user_aware_elevator_introduce));
        this.mContentText.append("\n" + getString(R.string.user_aware_wifi_match_ai_model_state) + AIKernelJavaBridge.isModelLoadSuccess(NearElevator.ELEVATOR_WIFI_MATCH_MODEL_NAME));
        scrollToBottom();
    }

    private void initViews() {
        this.mContentText = (TextView) findViewById(R.id.content_text);
        Button r8 = (Button) findViewById(R.id.clear_anchor_btn);
        Button r10 = (Button) findViewById(R.id.create_anchor_btn);
        Button r11 = (Button) findViewById(R.id.check_elevator_btn);
        this.mScrollView = (ScrollView) findViewById(R.id.scroll_view);
        r8.setOnClickListener(new AnonymousClass2(this));
        r10.setOnClickListener(new AnonymousClass3(this));
        r11.setOnClickListener(new AnonymousClass4(this));
        ((Button) findViewById(R.id.load_model_btn)).setOnClickListener(new AnonymousClass5(this));
        ((Button) findViewById(R.id.identify_error_btn)).setOnClickListener(new AnonymousClass6(this));
    }

    private void onCheckElevatorClick() {
        NearElevator r8 = this.mNearElevator;
        if (r8 != null) goto L6;
        this.mContentText.append("\n unsupported NearElevator");
        return;
    L6:
        r8.startWifiScan(NearElevator.ScanReason.ANCHOR_MATCH_TEST);
        int r10 = 0;
    L8:
        if (this.mNearElevator.mIsScanning.get() == true) goto L25;
        if (this.mNearElevator.mIsInferenceRunning.get() == true) goto L25;
        this.testCnt++;
        if (this.mNearElevator.mInferenceResult == false) goto L15;
        this.nearElevatorCnt++;
        TextView r11 = this.mContentText;
        StringBuilder r12 = new StringBuilder("\n");
        r12.append(LocalTime.now());
        r12.append(": ");
        r12.append(getString(R.string.user_aware_wifi_match_result));
        r12.append("(");
        r12.append(this.testCnt);
        r12.append("): ");
        r12.append(getString(R.string.user_aware_aware_near_elevator));
        r12.append("(");
        r12.append(this.nearElevatorCnt);
        r12.append(")elevatorId: ");
        r12.append(this.mNearElevator.mMatchAnchorElevatorId);
    L16:
        r11.append(r12.toString());
        scrollToBottom();
        return;
    L15:
        r11 = this.mContentText;
        r12 = new StringBuilder("\n");
        r12.append(LocalTime.now());
        r12.append(": ");
        r12.append(getString(R.string.user_aware_wifi_match_result));
        r12.append("(");
        r12.append(this.testCnt);
        r12.append("): ");
        r12.append(getString(R.string.user_aware_aware_not_near_elevator));
        r12.append("(");
        r12.append(this.testCnt - this.nearElevatorCnt);
        r12.append(")");
    L25:
        Thread.sleep(100);     // Catch: InterruptedException -> L23
        r10 = r10 + 1;     // Catch: InterruptedException -> L23
        if (r10 <= 30) goto L8;
        CaeLog.e(TAG, "onCheckElevatorClick wait for inference end timeout");     // Catch: InterruptedException -> L23
        return;
    L23:
        e = move-exception;
        CaeLog.e(TAG, "onCheckElevatorClick wait for inference end InterruptedException", e);
        goto L8
    }

    private void onCheckElevatorErrorClick() {
        AlertDialog.Builder r8 = new AlertDialog.Builder(this);
        r8.setTitle(getString(R.string.user_aware_is_wifi_match_result_error)).setMessage(getString(R.string.user_aware_wifi_match_error_confirm_text)).setPositiveButton(getString(R.string.user_aware_wifi_match_error_confirm), new AnonymousClass8(this)).setNegativeButton(getString(R.string.user_aware_wifi_match_error_cancel), new AnonymousClass7(this)).setCancelable(true);
        r8.create().show();
    }

    private void onCheckElevatorErrorClickConfirmed() {
        CaeLog.i(TAG, "onCheckElevatorErrorClickConfirmed call");
        this.mContentText.append("\n" + LocalTime.now() + ": " + getString(R.string.user_aware_wifi_match_error_confirm_again));
        scrollToBottom();
    }

    private void onClearAnchorClick() {
        NearElevator r8 = this.mNearElevator;
        if (r8 != null) goto L6;
        this.mContentText.append("\n unsupported NearElevator");
        return;
    L6:
        r8.clearAnchorList();
        this.testCnt = 0;
        this.nearElevatorCnt = 0;
        this.mContentText.append("\n" + LocalTime.now() + ": " + getString(R.string.user_aware_clean_all_anchor));
        scrollToBottom();
    }

    private void onCreateAnchorClick() {
        CaeLog.i(TAG, "onCreateAnchorClick call");
        NearElevator r8 = this.mNearElevator;
        if (r8 != null) goto L6;
        this.mContentText.append("\n unsupported NearElevator");
        return;
    L6:
        r8.startWifiScan(NearElevator.ScanReason.OUT_ELEVATOR_TEST);
        this.mContentText.append("\n" + LocalTime.now() + ": " + getString(R.string.user_aware_create_fake_out_elevator_event_for_test));
        int r10 = 0;
    L8:
        if (this.mNearElevator.mIsScanning.get() == false) goto L16;
        Thread.sleep(100);     // Catch: InterruptedException -> L14
        r10 = r10 + 1;     // Catch: InterruptedException -> L14
        if (r10 <= 30) goto L8;
        CaeLog.e(TAG, "onCreateAnchorClick wait for scan end timeout");     // Catch: InterruptedException -> L14
        return;
    L14:
        e = move-exception;
        CaeLog.e(TAG, "onCreateAnchorClick wait for scan end InterruptedException", e);
        goto L8
    }

    private void onLoadModelClick() {
        if (this.mNearElevator != null) goto L6;
        this.mContentText.append("\n unsupported NearElevator");
        return;
    L6:
        CaeLog.i(TAG, "onLoadModelClick call");
        this.mNearElevator.updateModel(this);
        this.mContentText.append("\n" + LocalTime.now() + ": " + getString(R.string.user_aware_wifi_match_ai_model_state) + ": " + AIKernelJavaBridge.isModelLoadSuccess(NearElevator.ELEVATOR_WIFI_MATCH_MODEL_NAME));
        scrollToBottom();
    }

    private void scrollToBottom() {
        this.mContentText.invalidate();
        this.mContentText.requestLayout();
        this.mScrollView.invalidate();
        this.mScrollView.requestLayout();
        this.mScrollView.post(new AnonymousClass9(this));
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_near_elevator);
        initViews();
        initData();
        this.mActivity = this;
        NearElevator r10 = NearElevator.getInstance(this);
        this.mNearElevator = r10;
        if (r10 == null) goto L6;
        AnonymousClass1 r11 = new AnonymousClass1(this);
        this.mNearElevator.regNearElevatorListener(r11);
        return;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        NearElevator r8 = this.mNearElevator;
        if (r8 == null) goto L5;
        r8.unregNearElevatorListener();
    L5:
        CaeLog.i(TAG, "Activity onDestroy");
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        CaeLog.i(TAG, "Activity onPause");
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        CaeLog.i(TAG, "Activity onResume");
    }
}
