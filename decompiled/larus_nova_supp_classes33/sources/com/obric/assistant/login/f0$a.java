package com.obric.assistant.login;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import n38.k;
import q38.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f0$a implements k {
    public final /* synthetic */ int a;
    public final /* synthetic */ List<b> b;
    public final /* synthetic */ Function0<Unit> c;

    public final void a(n38.b r4) {
        Intrinsics.checkNotNullParameter(r4, WindowEvent.Params.RESULT);
        FLogger.a.e("ObricLoginStrategyCenter", "remove account before O account logout failed, code=" + r4.d + ", msg=" + r4.e);
        f0.b(this.b, this.c, this.a + 1);
    }

    public final void b(n38.b r3) {
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.RESULT);
        f0.b(this.b, this.c, this.a + 1);
    }

    public f0$a(int r1, List<b> r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
