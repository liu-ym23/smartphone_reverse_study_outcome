package com.zte.miboard.cards.common;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.WindowCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import c.m;
import c.s0;
import com.obric.oui.dialog.v2.alert.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class DialogAty extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Dialog f16230c;

    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogAty f16231a;

        public a(DialogAty r5) {
            this.f16231a = r5;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r5, int r10) {
            m.i("DialogAty", "onCreate dialog positive click");
            DialogAty.a(this.f16231a, true);
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogAty f16232a;

        public b(DialogAty r5) {
            this.f16232a = r5;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r5, int r10) {
            m.i("DialogAty", "onCreate dialog negative click");
            DialogAty.a(this.f16232a, false);
        }
    }

    public class c implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogAty f16233a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f16234a;

            public a(c r5) {
                this.f16234a = r5;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16234a.f16233a.finish();
            }
        }

        public c(DialogAty r5) {
            this.f16233a = r5;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface r5) {
            m.i("DialogAty", "onCreate dialog onDismiss");
            new Handler(Looper.getMainLooper()).postDelayed(new a(this), 150);
        }
    }

    public DialogAty() {
        this.f16229b = false;
        this.f16230c = null;
    }

    public static /* synthetic */ boolean a(DialogAty r5, boolean r10) {
        r5.f16229b = r10;
        return r10;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        m.i("DialogAty", "finish mLocalBroadcastAction=" + this.f16228a);
        if (TextUtils.isEmpty(this.f16228a) == true) goto L6;
        Intent r5 = new Intent(this.f16228a);
        r5.putExtra("local_broadcast_result", this.f16229b);
        LocalBroadcastManager.getInstance(this).sendBroadcast(r5);
        return;
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle r11) {
        super.onCreate(r11);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        m.i("DialogAty", "onCreate");
        this.f16228a = getIntent().getStringExtra("local_broadcast_action");
        String r12 = getIntent().getStringExtra("dialog_title");
        String r5 = getIntent().getStringExtra("dialog_info");
        String r10 = getIntent().getStringExtra("dialog_positive");
        String r13 = getIntent().getStringExtra("dialog_negative");
        boolean r14 = getIntent().getBooleanExtra("cant_cancel_on_touch_outside", false);
        a r15 = new a(this);
        c.c r16 = new c.c();
        r16.f1028a = r15;
        r16.f1029b = null;
        b r17 = new b(this);
        c.c r18 = new c.c();
        r18.f1028a = r17;
        r18.f1029b = null;
        c r19 = new c(this);
        c.c r20 = new c.c();
        r20.f1028a = null;
        r20.f1029b = r19;
        e r21 = new e(this);
        r21.f13158h = r5;
        r21.f13159i = false;
        r21.g = r12;
        r21.e(r13, r18);
        r21.g(r10, r16);
        Intrinsics.checkNotNullParameter(r20, "onDismissListener");
        r21.f13116a = r20;
        com.obric.oui.dialog.v2.alert.b r110 = r21.a();
        if (r14 == false) goto L5;
        r110.setCanceledOnTouchOutside(false);
    L5:
        r110.show();
        r16.a(r110);
        r18.a(r110);
        r20.a(r110);
        this.f16230c = r110;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        StringBuilder r5 = new StringBuilder("onPause mDialog=");
        if (this.f16230c == null) goto L5;
        boolean r10 = true;
    L6:
        r5.append(r10);
        m.i("DialogAty", r5.toString());
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        StringBuilder r5 = new StringBuilder("onStop mDialog=");
        if (this.f16230c == null) goto L5;
        boolean r10 = true;
    L6:
        r5.append(r10);
        m.i("DialogAty", r5.toString());
        Dialog r11 = this.f16230c;
        if (r11 == null) goto L10;
        r11.dismiss();
        this.f16230c = null;
        return;
    L10:
        return;
    L5:
        r10 = false;
        goto L6
    }

    public static boolean a(Context r5, String r10, String r11, String r12, String r13, String r14, boolean r15) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L13:
        m.l("DialogAty", "showInfoDialog return, data empty");
        return false;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L13;
        if (TextUtils.isEmpty(r13) == true) goto L13;
        if (TextUtils.isEmpty(r14) == true) goto L13;
        m.i("DialogAty", "showInfoDialog title=" + r11);
        Intent r16 = new Intent(r5, DialogAty.class);
        r16.putExtra("local_broadcast_action", r10);
        r16.putExtra("dialog_title", r11);
        r16.putExtra("dialog_info", r12);
        r16.putExtra("dialog_positive", r13);
        r16.putExtra("dialog_negative", r14);
        r16.putExtra("cant_cancel_on_touch_outside", r15);
        s0.g(r5, r16);
        return true;
    }
}
