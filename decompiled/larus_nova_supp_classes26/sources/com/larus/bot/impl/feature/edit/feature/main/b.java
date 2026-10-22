package com.larus.bot.impl.feature.edit.feature.main;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements c, d {
    public final CoroutineScope a;
    public final MutableSharedFlow<e> b;
    public final a1 c;

    @Override // com.larus.bot.impl.feature.edit.feature.main.d
    public final void g() {
        e.a r0 = e.a.a;
        BuildersKt.launch$default(this.a, null, null, new BotMainEditViewModel$sendUIEvent$1(this, r0, null), 3, null);
    }

    @Override // uu8.b
    public final d1<e> getUiEvent() {
        return this.c;
    }

    public b(CoroutineScope r3) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.a = r3;
        kotlinx.coroutines.flow.e.b(j1.a(new f(0)));
        MutableSharedFlow<e> r4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.b = r4;
        this.c = kotlinx.coroutines.flow.e.a(r4);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.main.d
    public final void b(boolean r8) {
        e.b r0 = new e.b(r8);
        BuildersKt.launch$default(this.a, null, null, new BotMainEditViewModel$sendUIEvent$1(this, r0, null), 3, null);
    }
}
