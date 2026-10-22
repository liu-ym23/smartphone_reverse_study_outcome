package com.bytedance.android.livesdk.floatview;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o extends Dialog {
    public final View a;

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        com.bytedance.android.livesdk.f.d().a();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        com.bytedance.android.livesdk.f.d().f();
    }

    public o(FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, 2131954708);
        View r0 = LayoutInflater.from(getContext()).inflate(2131565788, null);
        this.a = r0;
        TextView r1 = (TextView) r0.findViewById(2131389523);
        TextView r2 = (TextView) r0.findViewById(2131389522);
        setContentView(r0);
        r2.setOnClickListener(new m(this));
        r1.setOnClickListener(new n(this, r4));
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }
}
