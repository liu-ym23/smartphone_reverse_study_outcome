package com.bytedance.android.livesdk.dislike;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f extends Dialog {
    public View a;
    public View b;
    public View c;
    public final Function0<Unit> d;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        setContentView(2131565406);
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setLayout(-1, -2);
    L5:
        Window r5 = getWindow();
        if (r5 == null) goto L8;
        r5.setGravity(80);
    L8:
        this.a = findViewById(2131384813);
        this.b = findViewById(2131378665);
        this.c = findViewById(2131364673);
        View r6 = this.a;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L11:
        r6.setOnClickListener(new c(this));
        View r7 = this.c;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mCancelView");
    L14:
        r7.setOnClickListener(new d(this));
        View r8 = this.b;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDislikeView");
    L17:
        r8.setOnClickListener(new e(this));
    }

    public f(Activity r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2, 2131954659);
        this.d = r3;
    }
}
