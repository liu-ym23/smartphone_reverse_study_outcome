package com.obric.cae.BWDL.BwdlDrop.activity;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.appcompat.app.e;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropDeviceManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSessionObserver;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import defpackage.a;
import defpackage.b;
import gc.i;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropTransferControlActivity extends e {
    private static final String TAG = "BwdlDropTransferControlActivity";
    private BwdlDropManager mBwdlDropManager;
    private BwdlDropSessionObserver mBwdlDropSessionObserver;
    private final DialogInterface.OnCancelListener mCancelListener;
    private final DialogInterface.OnClickListener mClickListener;
    private int mDeviceId;
    private BwdlDropSession mSession;

    public BwdlDropTransferControlActivity() {
        this.mClickListener = new AnonymousClass1(this);
        this.mCancelListener = new AnonymousClass2(this);
        this.mBwdlDropSessionObserver = new AnonymousClass3(this);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ BwdlDropSession access$100(BwdlDropTransferControlActivity r8) {
        return r8.mSession;
    }

    public static /* synthetic */ BwdlDropManager access$200(BwdlDropTransferControlActivity r8) {
        return r8.mBwdlDropManager;
    }

    private void parserIntentData(Bundle r8) {
        int r10 = getIntent().getIntExtra("device_id", 0);
        this.mDeviceId = r10;
        if (r10 == 0) goto L5;
        this.mSession = this.mBwdlDropManager.getOrCreateDeviceManager(r10).getBwdlDropSession();
    L5:
        String r11 = TAG;
        StringBuilder r12 = new StringBuilder("Drop transfer control message: mSession:");
        r12.append(this.mSession);
        r12.append(" mDeviceId: ");
        a.j(r12, this.mDeviceId, r11);
    }

    private void registerBwdlSessionObserver(int r8) {
        BwdlDropDeviceManager r10 = this.mBwdlDropManager.getOrCreateDeviceManager(r8);
        if (r10 == null) goto L8;
        BwdlDropSession r11 = r10.getBwdlDropSession();
        if (r11 == null) goto L7;
        r11.registerBwdlSessionObserver(this.mBwdlDropSessionObserver);
        return;
    L7:
        String r12 = TAG;
        StringBuilder r13 = new StringBuilder("session is null:");
        r13.append(r8);
    L9:
        CaeLog.d(r12, r13.toString());
        return;
    L8:
        r12 = TAG;
        r13 = b.f("deviceId(", r8, ") not exist.");
        goto L9
    }

    private void show() {
        i r8 = new i(this);
        r8.f7826s = true;
        r8.f(R.string.drop_confirm_cancel_transfer);
        r8.f7825r = true;
        r8.d(R.string.drop_transfer_continue, this.mClickListener);
        r8.e(R.string.drop_cancel, this.mClickListener);
        r8.f7376c = false;
        r8.f7374a = this.mCancelListener;
        r8.c();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r8) {
        CaeLog.d(TAG, "onCreate");
        super.onCreate(r8);
        overridePendingTransition(0, 0);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setFlags(512, 512);
        this.mBwdlDropManager = BwdlDropManager.getInstance(this);
        parserIntentData(r8);
        registerBwdlSessionObserver(this.mDeviceId);
        show();
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.m, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.m, android.app.Activity
    public void onPause() {
        super.onPause();
    }
}
