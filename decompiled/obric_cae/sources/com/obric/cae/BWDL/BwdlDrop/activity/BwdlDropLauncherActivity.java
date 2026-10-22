package com.obric.cae.BWDL.BwdlDrop.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropManager;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropShareItem;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import defpackage.b;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropLauncherActivity extends Activity {
    private static final int DESTROY_ACTIVITY_TIMER = 1500;
    private static final String TAG = "BwdlDropLauncherActivity";
    private Context mContext;
    private BwdlDropSession mSession;
    private Handler mUiHandler;

    public BwdlDropLauncherActivity() {
    }

    public static /* synthetic */ Context access$000(BwdlDropLauncherActivity r8) {
        return r8.mContext;
    }

    private void showToast(final String r8) {
        b.o("showToast:", r8, TAG);
        this.mUiHandler.post(new AnonymousClass1(this, r8));
        this.mUiHandler.postDelayed(new AnonymousClass2(this), 1500);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r26) {
        super.onCreate(r26);
        CaeLog.d(TAG, "onCreate");
        overridePendingTransition(0, 0);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setFlags(512, 512);
        this.mContext = this;
        BwdlDropManager r8 = BwdlDropManager.getInstance(getApplicationContext());
        this.mUiHandler = new Handler(Looper.getMainLooper());
        Intent r10 = getIntent();
        if (r10 != null) goto L5;
        String r11 = null;
    L6:
        if (r11 != null) goto L9;
        CaeLog.e(TAG, "Unexpected error! action is null");
        finish();
        return;
    L9:
        int r12 = Binder.getCallingPid();
        int r13 = Binder.getCallingUid();
        if (r11.equals("android.intent.action.SEND") == false) goto L12;
    L13:
        CaeLog.d(TAG, "receive ACTION:".concat(r11));
        if (r8.isReadyForFileSharing == true) goto L17;
        CaeLog.d(TAG, "File share already in process...");
        showToast(getString(R.string.bwdl_drop_in_process));
        return;
    L17:
        BwdlDropUtils.grantPermissionToUri(getApplicationContext(), r10.getClipData());
        if (r11.equals("android.intent.action.SEND") == false) goto L49;
        String r14 = r10.getType();
        Uri r15 = (Uri) r10.getParcelableExtra("android.intent.extra.STREAM");
        if (r15 == null) goto L46;
        if (r14 == null) goto L46;
        CaeLog.d(TAG, "Get ACTION_SEND intent: Uri = " + r15 + "; mimetype = " + r14);
        CopyOnWriteArrayList r16 = new CopyOnWriteArrayList();
        ContentResolver r17 = getApplicationContext().getContentResolver();
        if (BwdlDropUtils.checkCallerUriReadPermission(getApplicationContext(), r15, r12, r13) == true) goto L90;
        CaeLog.e(TAG, "Caller PID: " + r12 + ", UID: " + r13 + " does not have permission to access the URI they are trying to share");
        finish();
        return;
    L90:
        FileInputStream r18 = (FileInputStream) r17.openInputStream(r15);     // Catch: FileNotFoundException -> L43
        if (r18 != null) goto L86;
    L34:
        BwdlDropShareItem r19 = new BwdlDropShareItem(getApplicationContext(), r15, r14, r18);
        BwdlDropUtils.RequestResultCode r20 = BwdlDropUtils.isTransmissionIllegal(1, r19.getSize());
        if (r20 != BwdlDropUtils.RequestResultCode.NumberOverflow) goto L39;
        CaeLog.d(TAG, "File number exceeds limited");
        showToast(getString(R.string.file_count_exceed));
        return;
    L39:
        if (r20 != BwdlDropUtils.RequestResultCode.SizeOverflow) goto L42;
        CaeLog.d(TAG, "File size exceeds limited");
        showToast(getString(R.string.file_size_exceed));
        return;
    L42:
        r16.add(r19);
        BwdlDropSession r21 = new BwdlDropSession(getApplicationContext(), r16, r16.size(), r19.getSize());
    L75:
        this.mSession = r21;
    L78:
        r8.setSession(this.mSession);
        if (r8.isBTEnabled() == true) goto L82;
        r8.enableBluetoothNoAutoConnect();
    L82:
        if (r8.isWifiEnabled() == true) goto L84;
        r8.enableWifi();
    L84:
        r8.launchBwdlDevicePicker(this.mSession);
        finish();
        overridePendingTransition(0, 0);
        return;
    L86:
    L32:
        showToast(getString(R.string.file_type_transmission_not_supported));
        return;
    L29:
        if (r18.getChannel().size() != 0) goto L34;
        showToast(getString(R.string.file_type_transmission_not_supported));     // Catch: IOException -> L32
        return;
    L43:
        e = move-exception;
        CaeLog.e(TAG, "FileNotFoundException:" + e.getMessage());
        showToast(getString(R.string.file_not_found));
        return;
    L46:
        CaeLog.e(TAG, "mimeType or sending file URI is null");
        showToast(getString(R.string.file_type_transmission_not_supported));
        return;
    L49:
        if (r11.equals("android.intent.action.SEND_MULTIPLE") == false) goto L78;
        String r22 = r10.getType();
        ArrayList r23 = r10.getParcelableArrayListExtra("android.intent.extra.STREAM");
        CopyOnWriteArrayList r24 = new CopyOnWriteArrayList();
        if (r22 == null) goto L76;
        if (r23 == null) goto L76;
        CaeLog.v(TAG, "Get ACTION_SHARE_MULTIPLE intent: uris " + r23 + "\n Type= " + r22);
        if (BwdlDropUtils.checkAllUrisCallerPermission(getApplicationContext(), r10.getClipData(), r12, r13) == true) goto L57;
        CaeLog.e(TAG, "Caller PID: " + r12 + ", UID: " + r13 + " does not have permission to access the URIs they are trying to share");
        finish();
        return;
    L57:
        Iterator r25 = r23.iterator();
        long r27 = 0;
    L59:
        if (r25.hasNext() == false) goto L66;
        Uri r28 = (Uri) r25.next();
        BwdlDropShareItem r29 = new BwdlDropShareItem(getApplicationContext(), r28, getContentResolver().getType(r28), (FileInputStream) getApplicationContext().getContentResolver().openInputStream(r28));
        r27 = r27 + r29.getSize();
        r24.add(r29);
    L63:
        e = move-exception;
        CaeLog.e(TAG, "FileNotFoundException:" + e.getMessage());
        showToast(getString(R.string.file_not_found));
        return;
    L66:
        BwdlDropUtils.RequestResultCode r30 = BwdlDropUtils.isTransmissionIllegal(r24.size(), r27);
        if (r30 != BwdlDropUtils.RequestResultCode.NumberOverflow) goto L71;
        CaeLog.d(TAG, "File number exceeds limited");
        showToast(getString(R.string.file_count_exceed));
        return;
    L71:
        if (r30 != BwdlDropUtils.RequestResultCode.SizeOverflow) goto L74;
        CaeLog.d(TAG, "File size exceeds limited");
        showToast(getString(R.string.file_size_exceed));
        return;
    L74:
        r21 = new BwdlDropSession(getApplicationContext(), r24, r24.size(), r27);
    L76:
        CaeLog.e(TAG, "type is null; or sending files URIs are null");
        finish();
        return;
    L12:
        if (r11.equals("android.intent.action.SEND_MULTIPLE") == true) goto L13;
        return;
    L5:
        r11 = r10.getAction();
        goto L6
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
