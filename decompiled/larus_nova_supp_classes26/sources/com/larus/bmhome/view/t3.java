package com.larus.bmhome.view;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.auth.model.PluginAuthType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class t3 implements Function1 {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ MessagePluginAuthView b;

    public /* synthetic */ t3(lg8.e r1, MessagePluginAuthView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        Function1 r0 = this.a;
        ConstraintLayout r1 = this.b;
        int r2 = MessagePluginAuthView.b;
        Intrinsics.checkNotNullParameter((TextView) r4, "it");
        r0.invoke(PluginAuthType.Deny);
        com.larus.utils.e1.o(r1);
        return Unit.INSTANCE;
    }
}
