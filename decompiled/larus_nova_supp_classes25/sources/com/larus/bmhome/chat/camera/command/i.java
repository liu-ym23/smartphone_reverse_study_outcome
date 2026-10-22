package com.larus.bmhome.chat.camera.command;

import com.larus.camera.impl.result.CameraResultFirstFlow;
import com.larus.feishu.office.im.impl.base.q0;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionScene;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements p {
    public final CoroutineScope a;
    public final Deferred<BotModel> b;
    public final e c;
    public BotModel d;
    public final CameraSuggestedActionDataController e;

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void G8(q0 r1) {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void d(SuggestedActionData r1) {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final boolean d3() {
        BotModel r0 = this.c.a();
        if (r0 != null) goto L5;
        r0 = this.d;
    L5:
        if (r0 != null) goto L11;
        if (this.b.isCompleted() == true) goto L11;
        return true;
    L11:
        return this.e.d3();
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void preload(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void c(String r1, iq9.e r2) {
        Intrinsics.checkNotNullParameter(r1, "bizScene");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.bmhome.chat.camera.command.g] */
    public i(CoroutineScope r3, CompletableDeferred r4, CameraResultFirstFlow.a.c r5) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "botDeferred");
        Intrinsics.checkNotNullParameter(r5, "commandContext");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        CameraSuggestedActionDataController r6 = new CameraSuggestedActionDataController(new CameraDirectSuggestedActionProvider$controller$1(this), new o(new g(this), 2));
        this.e = r6;
        r6.preload("o_result_first");
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final List<SuggestedAction> r4(SuggestedActionScene r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "bizScene");
        if (d3() == true) goto L7;
        return null;
    L7:
        return this.e.r4(r2, r3, r4);
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void b(SuggestedActionScene r3, String r4, boolean r5, final Function1<? super List<SuggestedAction>, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "bizScene");
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.e.b(r3, r4, r5, new h(r6, this));
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void a(SuggestedActionScene r1, String r2, boolean r3, String r4, Function1<? super List<SuggestedAction>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "bizScene");
        Intrinsics.checkNotNullParameter(r5, "callback");
        b(r1, r2, r3, r5);
    }
}
