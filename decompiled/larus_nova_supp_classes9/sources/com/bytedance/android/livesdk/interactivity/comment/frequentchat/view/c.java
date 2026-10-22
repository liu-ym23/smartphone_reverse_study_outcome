package com.bytedance.android.livesdk.interactivity.comment.frequentchat.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class c extends Dialog {
    public final Function0<Unit> a;
    public final Function0<Unit> b;

    public abstract void a(View r1);

    @Override // android.app.Dialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        View r4 = LayoutInflater.from(getContext()).inflate(2131566095, null);
        setContentView(r4);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        a(r4);
        ((TextView) r4.findViewById(2131367639)).setOnClickListener(new a(this));
        ((TextView) r4.findViewById(2131365114)).setOnClickListener(new b(this));
    }

    public c(Context r2, Function0<Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "cancelOperation");
        Intrinsics.checkNotNullParameter(r4, "confirmOperation");
        super(r2, 2131954708);
        this.a = r3;
        this.b = r4;
    }
}
