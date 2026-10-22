package com.obric.cae.BWDL.BwdlDrop.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.e;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropDeviceManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSessionObserver;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import defpackage.b;
import gc.a;
import gc.i;
import java.util.Objects;
import java.util.Timer;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropWaitingActivity extends e {
    private static final int DESTROY_ACTIVITY_TIMER = 2500;
    private static final String TAG = "BwdlDropWaitingActivity";
    private static final int TIME_OUT = 40000;
    private a dialog;
    private boolean isUserRefuse;
    private BwdlDropManager mBwdlDropManager;
    private BwdlDropSession mBwdlDropSession;
    private BwdlDropSessionObserver mBwdlDropSessionObserver;
    private final DialogInterface.OnClickListener mCancelClickListener;
    private final DialogInterface.OnCancelListener mCancelListener;
    private final DialogInterface.OnClickListener mClickListener;
    private Context mContext;
    private int mDeviceId;
    private CharSequence mDropDialogMessage;
    private Handler mUiHandler;
    private Timer timer;

    public BwdlDropWaitingActivity() {
        this.dialog = null;
        this.mDropDialogMessage = "";
        this.mClickListener = new AnonymousClass1(this);
        this.mCancelListener = new AnonymousClass2(this);
        this.mCancelClickListener = new AnonymousClass3(this);
        this.mBwdlDropSessionObserver = new AnonymousClass4(this);
    }

    public static /* synthetic */ BwdlDropSession access$000(BwdlDropWaitingActivity r8) {
        return r8.mBwdlDropSession;
    }

    public static /* synthetic */ BwdlDropManager access$100(BwdlDropWaitingActivity r8) {
        return r8.mBwdlDropManager;
    }

    public static /* synthetic */ boolean access$200(BwdlDropWaitingActivity r8) {
        return r8.isUserRefuse;
    }

    public static /* synthetic */ boolean access$202(BwdlDropWaitingActivity r8, boolean r10) {
        r8.isUserRefuse = r10;
        return r10;
    }

    public static /* synthetic */ void access$300(BwdlDropWaitingActivity r8) {
        r8.startTransferFailedActivity();
    }

    public static /* synthetic */ int access$400(BwdlDropWaitingActivity r8) {
        return r8.mDeviceId;
    }

    public static /* synthetic */ void access$500(BwdlDropWaitingActivity r8, int r10) {
        r8.unRegisterBwdlSessionObserver(r10);
    }

    public static /* synthetic */ void access$600(BwdlDropWaitingActivity r8, String r10) {
        r8.showToast(r10);
    }

    public static /* synthetic */ Context access$700(BwdlDropWaitingActivity r8) {
        return r8.mContext;
    }

    public static /* synthetic */ a access$800(BwdlDropWaitingActivity r8) {
        return r8.dialog;
    }

    private void parserIntentData(Bundle r8) {
        Bundle r10 = getIntent().getExtras();
        if (r10 == null) goto L7;
        int r11 = r10.getInt("device_id");
        this.mDeviceId = r11;
        BwdlDropSession r12 = this.mBwdlDropManager.getOrCreateDeviceManager(r11).getBwdlDropSession();
        this.mBwdlDropSession = r12;
        if (r12 == null) goto L7;
        this.mDropDialogMessage = String.format(getString(R.string.drop_transfer_file), new Object[]{this.mBwdlDropSession.getRemoteDeviceName()});
        CaeLog.d(TAG, "mBwdlDropSession: " + this.mBwdlDropSession);
    L7:
        CaeLog.d(TAG, "Drop waiting message: " + this.mDropDialogMessage);
    }

    private void registerBwdlSessionObserver(int r8) {
        BwdlDropDeviceManager r10 = this.mBwdlDropManager.getOrCreateDeviceManager(r8);
        if (r10 == null) goto L8;
        BwdlDropSession r11 = r10.getBwdlDropSession();
        if (r11 == null) goto L7;
        r11.registerBwdlSessionObserver(this.mBwdlDropSessionObserver);
        return;
    L7:
        StringBuilder r12 = new StringBuilder("session is null:");
        r12.append(r8);
    L9:
        CaeLog.d(TAG, r12.toString());
        return;
    L8:
        r12 = b.f("deviceId(", r8, ") not exist.");
        goto L9
    }

    private void showToast(final String r8) {
        b.o("showToast:", r8, TAG);
        this.mUiHandler.post(new AnonymousClass6(this, r8));
        this.mUiHandler.postDelayed(new AnonymousClass7(this), 2500);
    }

    private void startTimeoutTask(final long r8) {
        Timer r10 = new Timer();     // Catch: Exception -> L4
        this.timer = r10;     // Catch: Exception -> L4
        r10.schedule(new AnonymousClass5(this, r8), r8, 40000);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        android.aimedia.a.q("start timeout task failed:", e, TAG);
    }

    private void startTransferFailedActivity() {
        Intent r8 = new Intent(this.mContext, BwdlDropTransferFailedActivity.class);
        r8.setFlags(335544320);
        startActivity(r8);
    }

    private void stopTimeoutTask() {
        Timer r8 = this.timer;
        if (r8 == null) goto L6;
        r8.cancel();
        this.timer = null;
        return;
    }

    private void unRegisterBwdlSessionObserver(int r8) {
        BwdlDropDeviceManager r10 = this.mBwdlDropManager.getOrCreateDeviceManager(r8);
        if (r10 == null) goto L7;
        BwdlDropSession r11 = r10.getBwdlDropSession();
        if (r11 == null) goto L9;
        r11.unRegisterBwdlSessionObserver(this.mBwdlDropSessionObserver);
        return;
    L9:
        return;
    L7:
        CaeLog.d(TAG, "deviceId(" + r8 + ") not exist.");
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        stopTimeoutTask();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r8) {
        CaeLog.d(TAG, "onCreate");
        super.onCreate(r8);
        this.mContext = this;
        this.isUserRefuse = false;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.mBwdlDropManager = BwdlDropManager.getInstance(getApplicationContext());
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setFlags(512, 512);
        parserIntentData(r8);
        show();
        registerBwdlSessionObserver(this.mDeviceId);
        startTimeoutTask(30000);
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.m, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CaeLog.d(TAG, "onDestroy");
    }

    @Override // androidx.fragment.app.m, android.app.Activity
    public void onPause() {
        super.onPause();
        CaeLog.d(TAG, "onPause");
    }

    public void show() {
        if (BwdlDropUtils.shouldClipToCircle(this.mContext) == false) goto L5;
        int r8 = R.drawable.bwdl_drop_round;
    L6:
        i r10 = new i(this.mContext);
        r10.f7826s = false;
        r10.f(R.string.drop_name);
        r10.f7815h = this.mDropDialogMessage;
        Object r11 = androidx.core.content.a.f1674a;
        Drawable r12 = androidx.core.content.a.b.b(this, r8);
        Objects.requireNonNull(r12);
        r10.f7817j = r12;
        r10.f7825r = false;
        r10.d(R.string.drop_cancel, this.mClickListener);
        r10.e(R.string.drop_hide, this.mClickListener);
        this.dialog = r10.a();
        r10.f7376c = false;
        r10.f7374a = this.mCancelListener;
        r10.c();
        return;
    L5:
        r8 = R.drawable.bwdl_drop_square;
        goto L6
    }

    public void showCancelDialog() {
        i r8 = new i(this.mContext);
        r8.f7826s = true;
        r8.f(R.string.drop_confirm_cancel_transfer);
        r8.f7825r = true;
        r8.d(R.string.drop_continue, this.mCancelClickListener);
        r8.e(R.string.drop_cancel, this.mCancelClickListener);
        r8.c();
    }
}
