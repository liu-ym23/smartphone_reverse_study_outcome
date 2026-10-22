package com.bytedance.android.live.revlink.impl.pk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.livesdk.utils.t6;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends Dialog {
    public final int a;
    public final a b;

    public static final class a {
        public String a;
        public String b;
        public DialogInterface.OnClickListener c;
        public String d;
        public DialogInterface.OnClickListener e;
        public String f;
        public final Context g;

        public final void a() {
            h r0 = new h(this.g, this);
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r0);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
        }

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "mContext");
            this.g = r2;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            h r4 = this.a;
            DialogInterface.OnClickListener r0 = r4.b.c;
            if (r0 == null) goto L6;
            r0.onClick(r4, 0);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ h a;

        public c(h r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            h r4 = this.a;
            DialogInterface.OnClickListener r0 = r4.b.e;
            if (r0 == null) goto L6;
            r0.onClick(r4, 1);
            return;
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (getWindow() == null) goto L26;
        Window r0 = getWindow();
        if (r0 == null) goto L12;
        WindowManager.LayoutParams r1 = r0.getAttributes();
    L13:
        if (r1 == null) goto L15;
        r1.width = (int) t6.a(getContext(), this.a);
    L15:
        if (r1 == null) goto L17;
        r1.height = -2;
    L17:
        if (r1 == null) goto L19;
        r1.gravity = 17;
    L19:
        Window r2 = getWindow();
        if (r2 == null) goto L27;
        r2.setAttributes(r1);
        return;
    L27:
        return;
    L12:
        r1 = null;
        goto L13
    L26:
        return;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        View r6 = LayoutInflater.from(getContext()).inflate(2131565688, null);
        setContentView(r6);
        setCancelable(false);
        ((TextView) r6.findViewById(2131388772)).setText(this.b.a);
        ((TextView) r6.findViewById(2131379959)).setText(this.b.b);
        ((TextView) r6.findViewById(2131364749)).setText(this.b.d);
        ((TextView) r6.findViewById(2131364818)).setText(this.b.f);
        ((TextView) r6.findViewById(2131364749)).setOnClickListener(new b(this));
        ((TextView) r6.findViewById(2131364818)).setOnClickListener(new c(this));
    }

    public h(Context r2, a r3) {
        super(r2, 2131954708);
        this.b = r3;
        this.a = 280;
    }
}
