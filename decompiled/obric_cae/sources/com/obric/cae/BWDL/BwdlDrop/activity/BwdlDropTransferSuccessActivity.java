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

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropTransferSuccessActivity extends e {
    private static final String TAG = "BwdlDropTransferSuccessActivity";
    private BwdlDropManager mBwdlDropManager;
    private final DialogInterface.OnCancelListener mCancelListener;
    private final DialogInterface.OnClickListener mClickListener;
    private CharSequence mDropDialogMessage;
    private a mOAlertDialog;

    public BwdlDropTransferSuccessActivity() {
        this.mOAlertDialog = null;
        this.mClickListener = new AnonymousClass1(this);
        this.mCancelListener = new AnonymousClass2(this);
    }

    public static /* synthetic */ void access$000(BwdlDropTransferSuccessActivity r8) {
        r8.safeDismissDialog();
    }

    @SuppressLint({"StringFormatMatches"})
    private void parserIntentData(Bundle r8) {
        Bundle r10 = getIntent().getExtras();
        if (r10 == null) goto L7;
        BwdlDropSession r11 = this.mBwdlDropManager.getOrCreateDeviceManager(r10.getInt("device_id")).getBwdlDropSession();
        if (r11 == null) goto L7;
        this.mDropDialogMessage = String.format(getString(R.string.drop_transfer_file_success_info), new Object[]{r11.getRemoteDeviceName(), Integer.valueOf(r11.getFileCount())});
        show();
    L7:
        CaeLog.d(TAG, "Drop transfer incoming message: " + this.mDropDialogMessage);
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
        r8.f(R.string.drop_transfer_success);
        r8.f7815h = this.mDropDialogMessage;
        r8.f7827t = new l(new AnonymousClass3(this));
        r8.f7825r = false;
        r8.d(R.string.drop_OK, this.mClickListener);
        r8.f7376c = false;
        r8.f7374a = this.mCancelListener;
        r8.c();
        this.mOAlertDialog = r8.a();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    @SuppressLint({"StringFormatMatches"})
    public void onCreate(Bundle r8) {
        CaeLog.d(TAG, "onCreate");
        super.onCreate(r8);
        this.mBwdlDropManager = BwdlDropManager.getInstance(getApplicationContext());
        overridePendingTransition(0, 0);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setFlags(512, 512);
        parserIntentData(r8);
        show();
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
