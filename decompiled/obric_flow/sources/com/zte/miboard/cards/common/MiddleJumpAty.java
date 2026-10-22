package com.zte.miboard.cards.common;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.core.view.WindowCompat;
import c.m;
import c.s0;
import com.bytedance.ai.event.MessageIndication;
import com.obric.flow.cardlistpage.ui.d;
import com.obric.oui.dialog.v2.alert.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class MiddleJumpAty extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16237c;
    private Dialog d;

    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f16240c;
        final /* synthetic */ String d;

        public a(String r5, String r10, Activity r11, String r12) {
            this.f16238a = r5;
            this.f16239b = r10;
            this.f16240c = r11;
            this.d = r12;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r5, int r10) {
            m.i(this.f16238a, "showDownloadDialog Positive click");
            String r11 = this.f16239b;
            if (r11 != null) goto L5;
            return;
        L5:
            if ("dialog_to_store".equals(r11) == false) goto L9;
            s0.i(this.f16240c.getApplicationContext(), this.d);
            return;
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r5, int r10) {
        }
    }

    public MiddleJumpAty() {
        this.f16235a = 0;
        this.f16236b = "";
        this.f16237c = false;
        this.d = null;
    }

    public static Intent a(Context r5, String r10, String r11, String r12, String r13) {
        Intent r14 = new Intent(r5, MiddleJumpAty.class);
        r14.addFlags(268435456);
        s0.b(r5, r14);
        r14.putExtra("to_where", "where_to_show_download_dialog");
        r14.putExtra("url", r10);
        r14.putExtra("download_package_name", r10);
        r14.putExtra("content_disposition", r11);
        r14.putExtra("mimeType", r12);
        r14.putExtra("dialog_type", r13);
        return r14;
    }

    public static /* synthetic */ void b(Activity r5, DialogInterface r10) {
        a(r5, r10);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        m.i("MiddleJumpAty", "finish");
    }

    @Override // android.app.Activity
    public void onActivityResult(int r5, int r10, Intent r11) {
        finish();
        super.onActivityResult(r5, r10, r11);
        if (r10 == (-1)) goto L5;
        boolean r12 = true;
    L6:
        m.i("MiddleJumpAty", "onActivityResult requestCode=" + r5 + " canceled==" + r12 + " whenCreate=" + this.f16237c);
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        if (getIntent() == null) goto L18;
        String r11 = getIntent().getStringExtra("to_where");
        if ("where_to_aty_from_service".equals(r11) == false) goto L12;
        Intent r12 = (Intent) getIntent().getParcelableExtra("jump_intent");
        int r5 = getIntent().getIntExtra("request_code", 0);
        if (r12 == null) goto L18;
        if (r5 <= 0) goto L10;
        startActivityForResult(r12, r5);
        goto L18
    L10:
        startActivity(r12);
        goto L18
    L12:
        if ("where_to_show_download_dialog".equals(r11) == false) goto L16;
        this.d = a(this, getIntent(), "MiddleJumpAty");
        return;
    L16:
        if ("where_to_map_navigation".equals(r11) == false) goto L18;
        String r13 = getIntent().getStringExtra("map_navigation_btn_text");
        String r14 = getIntent().getStringExtra("map_navigation_data_key_str");
        String r15 = getIntent().getStringExtra("map_navigation_travel_data_str");
        com.zte.miboard.cards.travel.b.a(this, getIntent().getBooleanExtra("map_navigation_need_cancel", false), r13, r14, r15);
    L18:
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m.i("MiddleJumpAty", "onDestroy");
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        m.i("MiddleJumpAty", "onPause");
        Dialog r5 = this.d;
        if (r5 == null) goto L6;
        r5.dismiss();
        this.d = null;
        return;
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        m.i("MiddleJumpAty", "onStop");
    }

    private static /* synthetic */ void a(Activity r5, DialogInterface r10) {
        r5.finish();
    }

    public static void b(Context r5, String r10, String r11, String r12, String r13) {
        r5.startActivity(a(r5, r10, r11, r12, r13));
    }

    public static Dialog a(Activity r10, Intent r11, String r12) {
        if (r11 != null) goto L5;
        return null;
    L5:
        r11.getStringExtra("url");
        String r5 = r11.getStringExtra("content_disposition");
        r11.getStringExtra("mimeType");
        String r13 = r11.getStringExtra("dialog_type");
        if (r10 == null) goto L12;
        NetworkInfo r14 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r14 == null) goto L12;
        if (r14.getType() != 0) goto L12;
        boolean r15 = r14.isAvailable();
    L13:
        String r16 = r11.getStringExtra("download_package_name");
        if (r13 != null) goto L16;
    L18:
        Resources r17 = r10.getResources();
        if (r15 == false) goto L21;
        int r18 = com.zte.miboard.cards.R.string.recommend_use_network_tip;
    L22:
        r5 = r17.getString(r18);
    L23:
        e r19 = new e(r10);
        int r20 = com.zte.miboard.cards.R.string.recommend_download_tip;
        Context r21 = r19.f;
        CharSequence r22 = r21.getText(r20);
        r19.f13159i = false;
        r19.g = r22;
        r19.f13158h = r5;
        int r23 = com.zte.miboard.cards.R.string.dialog_button_cancel;
        e.f(r19, r21.getString(r23), new b());
        int r24 = com.zte.miboard.cards.R.string.dialog_ok_download;
        a r25 = new a(r12, r13, r10, r16);
        String r26 = r21.getString(r24);
        Intrinsics.checkNotNullParameter(r26, MessageIndication.CONTENT_TYPE_TEXT);
        r19.f13165o = r26;
        r19.f13166p = r25;
        r19.f13167q = null;
        d r27 = new d(r10, 2);
        Intrinsics.checkNotNullParameter(r27, "onDismissListener");
        r19.f13116a = r27;
        com.obric.oui.dialog.v2.alert.b r28 = r19.a();
        r28.show();
        return r28;
    L21:
        r18 = com.zte.miboard.cards.R.string.dialog_download_app_tip;
        goto L22
    L16:
        if ("dialog_to_store".equals(r13) == false) goto L18;
    L12:
        r15 = false;
        goto L13
    }
}
