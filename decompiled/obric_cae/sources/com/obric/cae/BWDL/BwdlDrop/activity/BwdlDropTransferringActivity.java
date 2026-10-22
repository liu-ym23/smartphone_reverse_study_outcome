package com.obric.cae.BWDL.BwdlDrop.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.e;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropDeviceManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSessionObserver;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.oui.progress.ODownloadProgressView;
import dc.l;
import defpackage.b;
import gc.a;
import gc.i;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropTransferringActivity extends e {
    private static final String TAG = "BwdlDropTransferringActivity";
    private boolean isNotificaitonHiding;
    private BwdlDropManager mBwdlDropManager;
    private BwdlDropNotification mBwdlDropNotification;
    private BwdlDropSession mBwdlDropSession;
    private BwdlDropSessionObserver mBwdlDropSessionObserver;
    private final DialogInterface.OnClickListener mCancelClickListener;
    private final DialogInterface.OnCancelListener mCancelListener;
    private final DialogInterface.OnClickListener mClickListener;
    private final ContentObserver mContentObserver;
    private Context mContext;
    private int mDeviceId;
    private String mDropDialogMessageInfo;
    private long mFileTotalSize;
    private a mOAlertDialog;
    private i mOAlertDialogBuilder;
    private int mProcessValue;
    private final AtomicInteger mState;
    private Handler mUiHandler;
    private List<Uri> mUriList;
    private ODownloadProgressView progressView;
    private View view;

    public BwdlDropTransferringActivity() {
        this.mUriList = new ArrayList();
        this.mOAlertDialog = null;
        this.mState = new AtomicInteger(2);
        final Handler r8 = new Handler();
        this.mContentObserver = new AnonymousClass1(this, r8);
        this.mClickListener = new AnonymousClass2(this);
        this.mCancelListener = new AnonymousClass3(this);
        this.mCancelClickListener = new AnonymousClass5(this);
        this.mBwdlDropSessionObserver = new AnonymousClass7(this);
    }

    public static /* synthetic */ void access$000(BwdlDropTransferringActivity r8, int r10) {
        r8.setState(r10);
    }

    public static /* synthetic */ void access$100(BwdlDropTransferringActivity r8) {
        r8.notifyTransferring();
    }

    public static /* synthetic */ long access$1000(BwdlDropTransferringActivity r8) {
        return r8.mFileTotalSize;
    }

    public static /* synthetic */ int access$1100(BwdlDropTransferringActivity r8) {
        return r8.mDeviceId;
    }

    public static /* synthetic */ void access$1200(BwdlDropTransferringActivity r8, int r10) {
        r8.unRegisterBwdlSessionObserver(r10);
    }

    public static /* synthetic */ void access$1300(BwdlDropTransferringActivity r8) {
        r8.cleanUpNotification();
    }

    public static /* synthetic */ int access$1400(BwdlDropTransferringActivity r8) {
        return r8.getState();
    }

    public static /* synthetic */ void access$1500(BwdlDropTransferringActivity r8) {
        r8.launcherDropTransferSuccessActivity();
    }

    public static /* synthetic */ boolean access$200(BwdlDropTransferringActivity r8) {
        return r8.isNotificaitonHiding;
    }

    public static /* synthetic */ boolean access$202(BwdlDropTransferringActivity r8, boolean r10) {
        r8.isNotificaitonHiding = r10;
        return r10;
    }

    public static /* synthetic */ ODownloadProgressView access$300(BwdlDropTransferringActivity r8) {
        return r8.progressView;
    }

    public static /* synthetic */ ODownloadProgressView access$302(BwdlDropTransferringActivity r8, ODownloadProgressView r10) {
        r8.progressView = r10;
        return r10;
    }

    public static /* synthetic */ void access$400(BwdlDropTransferringActivity r8) {
        r8.show();
    }

    public static /* synthetic */ BwdlDropSession access$500(BwdlDropTransferringActivity r8) {
        return r8.mBwdlDropSession;
    }

    public static /* synthetic */ BwdlDropManager access$600(BwdlDropTransferringActivity r8) {
        return r8.mBwdlDropManager;
    }

    public static /* synthetic */ void access$700(BwdlDropTransferringActivity r8) {
        r8.startTransferFailedActivity();
    }

    public static /* synthetic */ void access$800(BwdlDropTransferringActivity r8) {
        r8.safeDismissDialogAndFinish();
    }

    public static /* synthetic */ int access$900(BwdlDropTransferringActivity r8) {
        return r8.mProcessValue;
    }

    public static /* synthetic */ int access$902(BwdlDropTransferringActivity r8, int r10) {
        r8.mProcessValue = r10;
        return r10;
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
        this.mBwdlDropNotification = new BwdlDropNotification(this, this.mBwdlDropSession, this.mDeviceId);
    }

    private void launcherDropTransferSuccessActivity() {
        CaeLog.d(TAG, "launcherDropTransferSuccessActivity");
        Intent r8 = new Intent(this.mContext, BwdlDropTransferSuccessActivity.class);
        Bundle r10 = new Bundle();
        r10.putParcelable(BwdlDropConstant.BWLD_DROP_SESSION, this.mBwdlDropSession);
        r10.putInt("device_id", this.mDeviceId);
        r8.putExtras(r10);
        r8.setFlags(335544320);
        startActivity(r8);
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

    @SuppressLint({"StringFormatMatches", "StringFormatInvalid"})
    private void parserIntentData(Bundle r8) {
        Bundle r10 = getIntent().getExtras();
        if (r10 == null) goto L12;
        int r11 = r10.getInt("device_id");
        this.mDeviceId = r11;
        BwdlDropSession r12 = this.mBwdlDropManager.getOrCreateDeviceManager(r11).getBwdlDropSession();
        this.mBwdlDropSession = r12;
        if (r12 == null) goto L12;
        initNotification();
        this.mFileTotalSize = this.mBwdlDropSession.getFileTotalSize();
        long r13 = this.mBwdlDropSession.getTransferSize();
        if (r13 < 0) goto L11;
        long r14 = this.mFileTotalSize;
        if (r14 <= 0) goto L11;
        this.mProcessValue = (int) ((r13 * 100) / r14);
    L11:
        String r15 = getString(R.string.drop_transfering_file_info);
        String r16 = this.mBwdlDropSession.getRemoteDeviceName();
        int r17 = this.mBwdlDropSession.getFileCount();
        this.mDropDialogMessageInfo = String.format(r15, new Object[]{r16, Integer.valueOf(r17), BwdlDropUtils.formatSizeToString(this.mFileTotalSize)});
        registerBwdlSessionObserver(this.mDeviceId);
    L12:
        CaeLog.d(TAG, "Drop transferring message: " + this.mDropDialogMessageInfo);
    }

    private void registerBwdlSessionObserver(int r8) {
        b.m("deviceId:", r8, TAG);
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

    private void safeDismissDialogAndFinish() {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (isDestroyed() == true) goto L18;
        a r8 = this.mOAlertDialog;
        if (r8 != null) goto L15;
    L13:
        new Handler(Looper.getMainLooper()).post(new AnonymousClass8(this));
        return;
    L15:
        r8.i();     // Catch: IllegalArgumentException -> L11
    L11:
        e = move-exception;
        CaeLog.e(TAG, "dismiss dialog failed:", e);
        goto L13
    }

    private void setState(int r8) {
        this.mState.set(r8);
    }

    @SuppressLint({"SuspiciousIndentation"})
    private void show() {
        i r8 = new i(this);
        r8.f7826s = false;
        r8.f(R.string.drop_transfering_title_info);
        r8.f7815h = this.mDropDialogMessageInfo;
        r8.f7827t = new l(new AnonymousClass4(this));
        r8.f7825r = false;
        r8.d(R.string.drop_cancel, this.mClickListener);
        r8.e(R.string.drop_hide, this.mClickListener);
        this.mOAlertDialogBuilder = r8;
        r8.f7376c = false;
        r8.f7374a = this.mCancelListener;
        a r10 = r8.a();
        this.mOAlertDialog = r10;
        r10.show();
    }

    private void startTransferFailedActivity() {
        Intent r8 = new Intent(this.mContext, BwdlDropTransferFailedActivity.class);
        r8.setFlags(335544320);
        startActivity(r8);
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
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    @SuppressLint({"ResourceType"})
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setFlags(512, 512);
        this.mContext = this;
        this.mProcessValue = 0;
        this.isNotificaitonHiding = true;
        this.mBwdlDropManager = BwdlDropManager.getInstance(this);
        this.mUiHandler = new Handler(Looper.getMainLooper());
        parserIntentData(r8);
        show();
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.m, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CaeLog.d(TAG, "onDestroy:");
        Handler r8 = this.mUiHandler;
        if (r8 == null) goto L5;
        r8.removeCallbacksAndMessages(null);
    L5:
        a r10 = this.mOAlertDialog;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.isShowing() == false) goto L17;
        this.mOAlertDialog.i();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        CaeLog.e(TAG, "dismiss dialog in onDestroy failed:", e);
        return;
    }

    @Override // androidx.fragment.app.m, android.app.Activity
    public void onPause() {
        super.onPause();
        defpackage.a.j(new StringBuilder("onPause:"), getState(), TAG);
        if (getState() != 2) goto L6;
        notifyTransferring();
        this.isNotificaitonHiding = false;
        moveTaskToBack(true);
        return;
    }

    @Override // androidx.fragment.app.m, android.app.Activity
    public void onResume() {
        super.onResume();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        CaeLog.d(TAG, "onResume");
    }

    public void showCancelDialog() {
        i r8 = new i(this.mContext);
        r8.f7826s = true;
        r8.f(R.string.drop_confirm_cancel_transfer);
        r8.f7825r = true;
        r8.d(R.string.drop_transfer_continue, this.mCancelClickListener);
        r8.e(R.string.drop_transfer_cancel, this.mCancelClickListener);
        r8.c();
    }

    public void updateNotification(int r8) {
        if (this.isNotificaitonHiding == false) goto L5;
        return;
    L5:
        BwdlDropNotification r10 = this.mBwdlDropNotification;
        if (r10 == null) goto L9;
        r10.updateTransferProcess(this.mProcessValue);
        return;
    }

    public void updateProcess(int r8) {
        defpackage.a.j(new StringBuilder("updateProcess: "), this.mProcessValue, TAG);
        updateNotification(this.mProcessValue);
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (isDestroyed() == true) goto L10;
        this.mProcessValue = Math.max(0, Math.min(100, r8));
        this.mUiHandler.post(new AnonymousClass6(this));
        return;
    }
}
