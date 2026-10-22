package com.larus.bot.impl.feature.edit.feature.bio;

import com.larus.bot.impl.bean.BotEditParam;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BotBioEditViewModel implements j, h {
    public static final /* synthetic */ int j = 0;
    public final /* synthetic */ h a;
    public final CoroutineScope b;
    public final StateFlowImpl c;
    public final b1 d;
    public final MutableSharedFlow<b> e;
    public final a1 f;
    public final MutableSharedFlow<b> g;
    public boolean h;
    public String i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.h
    public final BotEditParam a() {
        return this.a.a();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.h
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bio");
        this.a.b(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.h
    public final boolean c() {
        return this.a.c();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.j
    public final boolean Ol() {
        String r0 = this.i;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = a().getBio();
        if (r2 == null) goto L10;
        r1 = r2;
    L10:
        return !Intrinsics.areEqual(r0, r1);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.j
    public final String R() {
        String r0 = a().getBio();
        if (r0 == null) goto L5;
        String r1 = StringsKt.trim(r0).toString();
    L6:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        return new Regex("\\n+").replace(r1, "\n");
    L5:
        r1 = null;
        goto L6
    }

    @Override // uu8.b
    public final d1<b> getUiEvent() {
        return this.f;
    }

    @Override // uu8.b
    public final i1<c> getUiState() {
        return this.d;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.j
    public final void P6(String r4) {
        if (((c) this.d.getValue()).a == true) goto L5;
        return;
    L5:
        if (this.h == true) goto L7;
        return;
    L7:
        if (r4 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        FLogger.a.e("BotBioEditViewModel", "generated empty bio");
    L16:
        this.h = false;
        return;
    L15:
        b(r4);
        e(new b.a(r4, true));
        goto L16
    L9:
        if (StringsKt.isBlank(r4) == true) goto L12;
        r2 = false;
        goto L13
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bio.j
    public final void Sf(boolean r3) {
        if (((c) this.d.getValue()).a == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        this.h = true;
        d(this, true);
        e(new b.a("", false));
        return;
    L7:
        d(this, false);
    }

    @Override // uu8.b
    public final void dispatchUIAction(com.larus.bot.impl.feature.edit.feature.bio.a r3) {
        com.larus.bot.impl.feature.edit.feature.bio.a r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "action");
        if ((r4 instanceof com.larus.bot.impl.feature.edit.feature.bio.a.b) == false) goto L6;
        b(((com.larus.bot.impl.feature.edit.feature.bio.a.b) r4).a);
        return;
    L6:
        if ((r4 instanceof com.larus.bot.impl.feature.edit.feature.bio.a.c) == false) goto L11;
        if (((c) this.d.getValue()).a == false) goto L23;
        e(new b.a(a().getBio(), false));
        return;
    L23:
        return;
    L11:
        if ((r4 instanceof com.larus.bot.impl.feature.edit.feature.bio.a.C0065a) == false) goto L21;
        if (((c) this.d.getValue()).a == false) goto L18;
        String r5 = a().getBio();
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        b(r5);
    L18:
        this.i = a().getBio();
        return;
    L21:
        throw new NoWhenBranchMatchedException();
    }

    public final void e(b r7) {
        BuildersKt.launch$default(this.b, null, null, new BotBioEditViewModel$sendUIEvent$1(this, r7, null), 3, null);
    }

    public BotBioEditViewModel(CoroutineScope r8, h r9) {
        Intrinsics.checkNotNullParameter(r8, "scope");
        Intrinsics.checkNotNullParameter(r9, "dependency");
        this.a = r9;
        this.b = r8;
        e10 r0 = e10.a;
        if (e10.D().bioEditable == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        StateFlowImpl r10 = j1.a(new c(r1, false));
        this.c = r10;
        this.d = kotlinx.coroutines.flow.e.b(r10);
        MutableSharedFlow<b> r2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.e = r2;
        this.f = kotlinx.coroutines.flow.e.a(r2);
        this.g = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        BuildersKt.launch$default(r8, null, null, new BotBioEditViewModel$bindObservers$1(this, null), 3, null);
        return;
    L5:
        if (c() == false) goto L7;
        r1 = true;
        goto L8
    }

    public static void d(BotBioEditViewModel r2, boolean r3) {
        boolean r0 = ((c) r2.d.getValue()).a;
        r2.c.setValue(new c(r0, r3));
    }
}
