package com.obric.assistant.interaction.impl.essentialtask.ipc;

import android.os.IBinder;
import android.os.Messenger;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ Messenger a;
    public final /* synthetic */ IBinder.DeathRecipient b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;

    public /* synthetic */ b(Messenger r1, a r2, int r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r5) {
        return EssentialTaskIPCProvider.b(this.a, this.b, this.c, this.d, (Throwable) r5);
    }
}
