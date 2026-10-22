package com.obric.cae.BWDL.BwdlDrop.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.e;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
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
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropIncomingFileConfirmActivity extends e {
    private static final int DESTROY_ACTIVITY_TIMER = 1500;
    private static final String TAG = "BwdlDropIncomingFileConfirmActivity";
    private static final int TIME_OUT = 30000;
    private i builder;
    private boolean iSStorageAvailable;
    private BwdlDropManager mBwdlDropManager;
    private BwdlDropNotification mBwdlDropNotification;
    private BwdlDropSessionObserver mBwdlDropSessionObserver;
    private final DialogInterface.OnCancelListener mCancelListener;
    private final DialogInterface.OnClickListener mClickListener;
    private Context mContext;
    private int mDeviceId;
    private a mDialog;
    private CharSequence mDropDialogMessage;
    private long mFileTotalSize;
    private int mProcessValue;
    private BwdlDropSession mSession;
    private final AtomicInteger mState;
    private Handler mUiHandler;
    private Timer timer;

    public BwdlDropIncomingFileConfirmActivity() {
        this.mDropDialogMessage = "";
        this.mDialog = null;
        this.iSStorageAvailable = true;
        this.mState = new AtomicInteger(1);
        this.mClickListener = new AnonymousClass1(this);
        this.mCancelListener = new AnonymousClass2(this);
        this.mBwdlDropSessionObserver = new AnonymousClass3(this);
    }

    public static /* synthetic */ boolean access$000(BwdlDropIncomingFileConfirmActivity r8) {
        return r8.iSStorageAvailable;
    }

    public static /* synthetic */ BwdlDropSession access$100(BwdlDropIncomingFileConfirmActivity r8) {
        return r8.mSession;
    }

    public static /* synthetic */ void access$1000(BwdlDropIncomingFileConfirmActivity r8) {
        r8.cleanUpNotification();
    }

    public static /* synthetic */ Handler access$1100(BwdlDropIncomingFileConfirmActivity r8) {
        return r8.mUiHandler;
    }

    public static /* synthetic */ void access$1200(BwdlDropIncomingFileConfirmActivity r8) {
        r8.stopTimeoutTask();
    }

    public static /* synthetic */ void access$1300(BwdlDropIncomingFileConfirmActivity r8) {
        r8.notifyTransferring();
    }

    public static /* synthetic */ int access$1400(BwdlDropIncomingFileConfirmActivity r8) {
        return r8.getState();
    }

    public static /* synthetic */ a access$1500(BwdlDropIncomingFileConfirmActivity r8) {
        return r8.mDialog;
    }

    public static /* synthetic */ void access$1600(BwdlDropIncomingFileConfirmActivity r8) {
        r8.notifyTransferSuccess();
    }

    public static /* synthetic */ Context access$1700(BwdlDropIncomingFileConfirmActivity r8) {
        return r8.mContext;
    }

    public static /* synthetic */ BwdlDropManager access$200(BwdlDropIncomingFileConfirmActivity r8) {
        return r8.mBwdlDropManager;
    }

    public static /* synthetic */ void access$300(BwdlDropIncomingFileConfirmActivity r8, int r10) {
        r8.setState(r10);
    }

    public static /* synthetic */ long access$400(BwdlDropIncomingFileConfirmActivity r8) {
        return r8.mFileTotalSize;
    }

    public static /* synthetic */ int access$500(BwdlDropIncomingFileConfirmActivity r8) {
        return r8.mProcessValue;
    }

    public static /* synthetic */ int access$502(BwdlDropIncomingFileConfirmActivity r8, int r10) {
        r8.mProcessValue = r10;
        return r10;
    }

    public static /* synthetic */ int access$600(BwdlDropIncomingFileConfirmActivity r8) {
        return r8.mDeviceId;
    }

    public static /* synthetic */ void access$700(BwdlDropIncomingFileConfirmActivity r8, int r10) {
        r8.unRegisterBwdlSessionObserver(r10);
    }

    public static /* synthetic */ void access$800(BwdlDropIncomingFileConfirmActivity r8) {
        r8.cancelNotification();
    }

    public static /* synthetic */ void access$900(BwdlDropIncomingFileConfirmActivity r8) {
        r8.notifyTransferFailed();
    }

    private void cancelNotification() {
        BwdlDropNotification r8 = this.mBwdlDropNotification;
        if (r8 == null) goto L6;
        r8.cancelNotification();
        return;
    }

    private void checkStorageAvailable() {
        if (BwdlDropUtils.checkExternalStorageAvailability(this.mFileTotalSize) == true) goto L5;
        this.iSStorageAvailable = false;
        showToast(getString(R.string.drop_storage_insufficient_exit));
        return;
    L5:
        this.iSStorageAvailable = true;
    }

    private void cleanUpNotification() {
        BwdlDropNotification r8 = this.mBwdlDropNotification;
        if (r8 == null) goto L6;
        r8.clearup();
        return;
    }

    private int getState() {
        return this.mState.get();
    }

    private void initNotification() {
        this.mBwdlDropNotification = new BwdlDropNotification(this, this.mSession, this.mDeviceId);
    }

    private void notifyTransferFailed() {
        BwdlDropNotification r8 = this.mBwdlDropNotification;
        if (r8 == null) goto L6;
        r8.notifyTransferFailed();
        return;
    }

    private void notifyTransferSuccess() {
        BwdlDropNotification r8 = this.mBwdlDropNotification;
        if (r8 == null) goto L6;
        r8.notifyTransferSuccess();
        return;
    }

    private void notifyTransferring() {
        BwdlDropNotification r8 = this.mBwdlDropNotification;
        if (r8 == null) goto L6;
        r8.notifyTransferring();
        return;
    }

    @SuppressLint({"StringFormatMatches"})
    private void parserIntentData(Bundle r10) {
        Bundle r11 = getIntent().getExtras();
        if (r11 == null) goto L16;
        int r12 = r11.getInt("device_id");
        this.mDeviceId = r12;
        BwdlDropDeviceManager r13 = this.mBwdlDropManager.getOrCreateDeviceManager(r12);
        if (r13 != null) goto L8;
        CaeLog.e(TAG, "deviceManager is null");
        return;
    L8:
        BwdlDropSession r14 = r13.getBwdlDropSession();
        this.mSession = r14;
        if (r14 == null) goto L16;
        initNotification();
        String r15 = getString(R.string.drop_incoming_file_info);
        String r8 = this.mSession.getRemoteDeviceName();
        int r16 = this.mSession.getFileCount();
        this.mFileTotalSize = this.mSession.getFileTotalSize();
        long r17 = this.mSession.getTransferSize();
        if (r17 < 0) goto L15;
        long r18 = this.mFileTotalSize;
        if (r18 <= 0) goto L15;
        this.mProcessValue = (int) ((r17 * 100) / r18);
    L15:
        this.mDropDialogMessage = String.format(r15, new Object[]{r8, Integer.valueOf(r16), BwdlDropUtils.formatSizeToString(this.mFileTotalSize)});
        registerBwdlSessionObserver(this.mDeviceId);
    L16:
        CaeLog.d(TAG, "Drop transferring message: " + this.mDropDialogMessage);
    }

    private void registerBwdlSessionObserver(int r8) {
        BwdlDropDeviceManager r10 = this.mBwdlDropManager.getOrCreateDeviceManager(r8);
        if (r10 == null) goto L8;
        BwdlDropSession r11 = r10.getBwdlDropSession();
        if (r11 == null) goto L7;
        r11.registerBwdlSessionObserver(this.mBwdlDropSessionObserver);
        return;
    L7:
        StringBuilder r12 = new StringBuilder("session is null.");
        r12.append(r8);
    L9:
        CaeLog.d(TAG, r12.toString());
        return;
    L8:
        r12 = b.f("deviceId(", r8, ") not exist.");
        goto L9
    }

    private void setState(int r8) {
        this.mState.set(r8);
    }

    private void show() {
        if (BwdlDropUtils.shouldClipToCircle(this.mContext) == false) goto L5;
        int r8 = R.drawable.bwdl_drop_round;
    L6:
        i r10 = new i(this);
        r10.f7826s = true;
        r10.f(R.string.drop_name);
        r10.f7815h = this.mDropDialogMessage;
        Object r11 = androidx.core.content.a.f1674a;
        Drawable r12 = androidx.core.content.a.b.b(this, r8);
        Objects.requireNonNull(r12);
        r10.f7817j = r12;
        r10.f7825r = false;
        r10.d(R.string.drop_refuse_incoming_file, this.mClickListener);
        r10.e(R.string.drop_receive_incoming_file, this.mClickListener);
        this.builder = r10;
        r10.f7376c = false;
        a r13 = r10.a();
        this.mDialog = r13;
        r13.show();
        return;
    L5:
        r8 = R.drawable.bwdl_drop_square;
        goto L6
    }

    private void showToast(final String r8) {
        b.o("showToast:", r8, TAG);
        this.mUiHandler.post(new AnonymousClass6(this, r8));
        this.mUiHandler.postDelayed(new AnonymousClass7(this), 1500);
    }

    private void startTimeoutTask(final long r8) {
        Timer r10 = new Timer();     // Catch: Exception -> L4
        this.timer = r10;     // Catch: Exception -> L4
        r10.schedule(new AnonymousClass5(this, r8), r8, 30000);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        android.aimedia.a.q("start timeout task failed:", e, TAG);
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
    @SuppressLint({"ResourceType"})
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        this.mContext = this;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setFlags(512, 512);
        this.mBwdlDropManager = BwdlDropManager.getInstance(this);
        this.mUiHandler = new Handler(Looper.getMainLooper());
        parserIntentData(r8);
        show();
        startTimeoutTask(30000);
        checkStorageAvailable();
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.m, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        defpackage.a.j(new StringBuilder("onDestroy:"), getState(), TAG);
        if (this.mSession != null) goto L5;
        return;
    L5:
        if (getState() != 1) goto L9;
        this.mBwdlDropManager.sendFileTransferResp(BwdlDropConstant.REASON_USER_REFUSE, this.mSession);
        return;
    }

    @Override // androidx.fragment.app.m, android.app.Activity
    public void onPause() {
        super.onPause();
        CaeLog.d(TAG, "onPause");
    }

    public void updateNotification(int r8) {
        BwdlDropNotification r10 = this.mBwdlDropNotification;
        if (r10 == null) goto L6;
        r10.updateTransferProcess(this.mProcessValue);
        return;
    }

    public void updateProcess(int r8) {
        this.mProcessValue = Math.max(0, Math.min(100, r8));
        defpackage.a.j(new StringBuilder("updateProcess: "), this.mProcessValue, TAG);
        updateNotification(this.mProcessValue);
        this.mUiHandler.post(new AnonymousClass4(this));
    }
}
