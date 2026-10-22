package com.larus.bot.impl.feature.edit.component;

import com.larus.bmhome.utils.x1;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/larus/bot/impl/feature/edit/component/BotMainEditComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "<init>", "()V", "mainView", "Lcom/larus/bot/impl/feature/edit/feature/main/BotMainEditView;", "botEditAbility", "Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "getBotEditAbility", "()Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "botEditAbility$delegate", "Lkotlin/Lazy;", "onParentViewCreated", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotMainEditComponent extends ComponentFeature {
    public final Lazy h;

    public final void B2() {
        ru8.e r0 = (ru8.e) this.h.getValue();
        if (r0 == null) goto L23;
        LarusPageBotEditBinding r3 = r0.e();
        if (r3 == null) goto L24;
        FLogger.a.d("BotMainEditComponent", "init BotMainEditView");
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof TraceFragment) == false) goto L25;
        Intrinsics.checkNotNullParameter(this, "<this>");
        TraceFragment r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larus.trace.tracknode.TraceFragment");
        TraceFragment r2 = r1;
        ru8.e r4 = (ru8.e) this.h.getValue();
        if (r4 == null) goto L12;
        com.larus.bot.impl.feature.edit.feature.main.c r5 = r4.uk();
    L13:
        ru8.e r6 = (ru8.e) this.h.getValue();
        if (r6 == null) goto L16;
        com.larus.common_ui.dialog.l0 r7 = r6.uL();
    L17:
        ru8.e r8 = (ru8.e) this.h.getValue();
        if (r8 == null) goto L20;
        x1 r9 = r8.jZ();
    L21:
        new com.larus.bot.impl.feature.edit.feature.main.a(r2, r3, r5, r7, r9).a();
        return;
    L20:
        r9 = null;
        goto L21
    L16:
        r7 = null;
        goto L17
    L12:
        r5 = null;
        goto L13
    L25:
        return;
    L24:
        return;
    }

    public BotMainEditComponent() {
        this.h = LazyKt.lazy(new q0(this));
    }
}
