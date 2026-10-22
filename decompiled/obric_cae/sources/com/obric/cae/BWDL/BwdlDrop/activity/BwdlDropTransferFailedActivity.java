package com.obric.cae.BWDL.BwdlDrop.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.appcompat.app.e;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import dc.l;
import gc.a;
import gc.i;
import java.util.Timer;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropTransferFailedActivity extends e {
    private static final String TAG = "BwdlDropTransferFailedActivity";
    private static final int TIME_OUT = 30000;
    private BwdlDropManager mBwdlDropManager;
    private BwdlDropNotification mBwdlDropNotification;
    private final DialogInterface.OnCancelListener mCancelListener;
    private final DialogInterface.OnClickListener mClickListener;
    private int mDeviceId;
    private a mOAlertDialog;
    private BwdlDropSession mSession;
    private Timer timer;

    public BwdlDropTransferFailedActivity() {
        this.mOAlertDialog = null;
        this.mClickListener = new AnonymousClass1(this);
        this.mCancelListener = new AnonymousClass2(this);
    }

    public static /* synthetic */ void access$000(BwdlDropTransferFailedActivity r8) {
        r8.cleanUpNotification();
    }

    public static /* synthetic */ void access$100(BwdlDropTransferFailedActivity r8) {
        r8.safeDismissDialog();
    }

    private void cleanUpNotification() {
        BwdlDropNotification r8 = this.mBwdlDropNotification;
        if (r8 == null) goto L6;
        r8.clearup();
        return;
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
    private void parserIntentData(Bundle r8) {
        Bundle r10 = getIntent().getExtras();
        if (r10 == null) goto L7;
        int r11 = r10.getInt("device_id");
        this.mDeviceId = r11;
        BwdlDropSession r12 = this.mBwdlDropManager.getOrCreateDeviceManager(r11).getBwdlDropSession();
        this.mSession = r12;
        if (r12 == null) goto L7;
        initNotification();
        notifyTransferFailed();
    L7:
        StringBuilder r13 = new StringBuilder("Drop transfer failed message: mSession:");
        r13.append(this.mSession);
        r13.append(" mDeviceId: ");
        defpackage.a.j(r13, this.mDeviceId, TAG);
    }

    private void safeDismissDialog() {
        a r8 = this.mOAlertDialog;
        if (r8 == null) goto L11;
        r8.i();     // Catch: IllegalArgumentException -> L6
        return;
    L6:
        e = move-exception;
        CaeLog.e(TAG, "dismiss dialog failed:", e);
        return;
    }

    private void show() {
        i r8 = new i(this);
        r8.f7826s = false;
        r8.f(R.string.drop_transfer_failed);
        r8.f7815h = r8.f7828u.getString(R.string.drop_transfer_failed_message);
        r8.f7827t = new l(new AnonymousClass3(this));
        r8.f7825r = false;
        r8.d(R.string.drop_OK, this.mClickListener);
        r8.f7376c = false;
        r8.f7374a = this.mCancelListener;
        r8.c();
        this.mOAlertDialog = r8.a();
    }

    private void startTimeoutTask(final long r8) {
        Timer r10 = new Timer();     // Catch: Exception -> L4
        this.timer = r10;     // Catch: Exception -> L4
        r10.schedule(new AnonymousClass4(this, r8), r8, 30000);     // Catch: Exception -> L4
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

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        stopTimeoutTask();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        overridePendingTransition(0, 0);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setFlags(512, 512);
        this.mBwdlDropManager = BwdlDropManager.getInstance(this);
        parserIntentData(r8);
        show();
        startTimeoutTask(30000);
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.m, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.m, android.app.Activity
    public void onPause() {
        super.onPause();
        finish();
    }
}
