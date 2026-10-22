package com.bytedance.android.livesdk.interactivity.comment.frequentchat.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends c {
    @Override // com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.c
    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        ((TextView) r3.findViewById(2131365114)).setText(s1.B(2131897057));
        ((TextView) r3.findViewById(2131367639)).setText(s1.B(2131897048));
        ((TextView) r3.findViewById(2131388772)).setText(s1.B(2131897049));
    }

    public l(Context r2, Function0<Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "cancelOperation");
        Intrinsics.checkNotNullParameter(r4, "confirmOperation");
        super(r2, r3, r4);
    }
}
