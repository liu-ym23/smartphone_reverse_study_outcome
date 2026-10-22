package com.obric.assistant.utils;

import android.os.UserHandle;
import com.larus.utils.logger.FLogger;
import java.util.function.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class i implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ UserHandle b;
    public final /* synthetic */ Function1 c;

    public /* synthetic */ i(String r1, UserHandle r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r7) {
        String r0 = this.a;
        UserHandle r1 = this.b;
        Function1 r2 = this.c;
        Boolean r8 = (Boolean) r7;
        FLogger.a.i("ObricKtUtils", "addRoleHolder callback, packageName=" + r0 + ", userHandle=" + r1 + ", success=" + r8);
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r8, r3) == true) goto L5;
        j.a = false;
    L5:
        r2.invoke(Boolean.valueOf(Intrinsics.areEqual(r8, r3)));
    }
}
