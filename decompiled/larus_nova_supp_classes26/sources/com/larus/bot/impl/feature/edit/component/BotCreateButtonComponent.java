package com.larus.bot.impl.feature.edit.component;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import com.larus.bot.impl.feature.edit.feature.accesspermission.BotPublicPermissionBSDialog;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import tx9.o3;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 +2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001+B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001bJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0015J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J8\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010#2\u0006\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u0012H\u0016J\b\u0010*\u001a\u00020\u0012H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006,"}, d2 = {"Lcom/larus/bot/impl/feature/edit/component/BotCreateButtonComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/bot/impl/feature/ability/IBotCreateButtonAbility;", "<init>", "()V", "botEditAbility", "Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "getBotEditAbility", "()Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "botEditAbility$delegate", "Lkotlin/Lazy;", "botCreateAbility", "Lcom/larus/bot/impl/feature/ability/IBotCreateAbility;", "getBotCreateAbility", "()Lcom/larus/bot/impl/feature/ability/IBotCreateAbility;", "botCreateAbility$delegate", "onAttach", "", "onParentViewCreated", "setupCreateBtn", "()Lkotlin/Unit;", "setupCreate", "setupCreateQuotaInfo", "refreshCreateBtn", "canCreate", "", "(Z)Lkotlin/Unit;", "updateScrollChildBottomPadding", "requireConversationDetail", "Lkotlinx/coroutines/Job;", "bot", "Lcom/larus/im/bean/bot/BotModel;", "handleCreateSuccess", "botId", "", "conversationId", "bgImgUrl", "bgImgColor", "showBg", "openInSideBar", "doFinish", "tryCrateBot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateButtonComponent extends ComponentFeature implements ru8.b {
    public static final /* synthetic */ int j = 0;
    public final Lazy h;
    public final Lazy i;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(com.larus.bot.impl.feature.edit.component.a r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final ru8.a F2() {
        return (ru8.a) this.i.getValue();
    }

    public final ru8.e L2() {
        return (ru8.e) this.h.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, ru8.b.class);
    }

    public BotCreateButtonComponent() {
        this.h = LazyKt.lazy(new d(this));
        this.i = LazyKt.lazy(new e(this));
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.bot.impl.feature.edit.component.a] */
    public final void B2() {
        ru8.e r0 = L2();
        if (r0 == null) goto L31;
        LarusPageBotEditBinding r1 = r0.e();
        if (r1 == null) goto L31;
        ru8.a r2 = F2();
        if (r2 == null) goto L30;
        final BotCreateViewModel r3 = r2.a1();
        if (r3 == null) goto L30;
        if (r3.getCanAddBgImage() == false) goto L29;
        com.larus.utils.e1.x(r1.h);
        com.larus.utils.e1.x(r1.j);
        ru8.e r4 = L2();
        if (r4 == null) goto L18;
        LarusPageBotEditBinding r5 = r4.e();
        if (r5 == null) goto L18;
        com.larus.utils.e1.o(r5.k);
        Unit r6 = Unit.INSTANCE;
    L18:
        boolean r7 = false;
        N2(false);
        com.larus.utils.e1.d(r1.i, new com.larus.bot.impl.feature.edit.component.b(this, r3));
        ru8.e r8 = L2();
        if (r8 == null) goto L30;
        LarusPageBotEditBinding r9 = r8.e();
        if (r9 == null) goto L30;
        if (r9.k.getVisibility() != 0) goto L25;
        r7 = true;
    L25:
        if (r7 == false) goto L27;
        int r10 = c7.b(106);
    L28:
        ConstraintLayout r11 = r9.I;
        r11.setPaddingRelative(r11.getPaddingStart(), r11.getPaddingTop(), r11.getPaddingEnd(), r10);
        Unit r12 = Unit.INSTANCE;
        goto L30
    L27:
        r10 = c7.b(88);
        goto L28
    L29:
        com.larus.utils.e1.o(r1.h);
    L30:
        Unit r13 = Unit.INSTANCE;
    L31:
        ru8.e r14 = L2();
        if (r14 != null) goto L34;
        return;
    L34:
        if (r14.e() == null) goto L49;
        ru8.a r15 = F2();
        if (r15 == null) goto L46;
        final BotCreateViewModel r16 = r15.a1();
        if (r16 == null) goto L46;
        ru8.e r17 = L2();
        if (r17 == null) goto L46;
        LifecycleOwner r18 = r17.s4();
        if (r18 == null) goto L46;
        com.larus.bot.impl.common.util.e.a(r16.getReady(), LifecycleOwnerKt.getLifecycleScope(r18), new BotCreateButtonComponent$setupCreate$1$1(this, null));
        r16.getCreateResult().observe(r18, new b(new com.larus.bot.impl.feature.edit.component.a(this, r16)));
    L46:
        Unit r19 = Unit.INSTANCE;
        return;
    }

    @Override // ru8.b
    public final void Eb() {
        ru8.a r0 = F2();
        if (r0 == null) goto L11;
        BotCreateViewModel r1 = r0.a1();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.interceptDoFinish() == true) goto L12;
        o20();
        return;
    L12:
        return;
    }

    @Override // ru8.b
    public final void o20() {
        ru8.a r0 = F2();
        if (r0 == null) goto L54;
        final BotCreateViewModel r1 = r0.a1();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getPrivateStatus() != 1) goto L22;
        BotPublicPermissionBSDialog r2 = new BotPublicPermissionBSDialog();
        Pair[] r3 = new Pair[2];
        boolean r5 = false;
        r3[0] = TuplesKt.to("public_permission_scene_argument", 1);
        if (r1.getPrivateStatus() != 1) goto L12;
        r5 = true;
    L12:
        r3[1] = TuplesKt.to("public_status_key", Boolean.valueOf(r5));
        r2.setArguments(com.larus.utils.f.c(r3));
        r2.j = new c(this, r1);
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r4 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragmentManager();
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "BotPublicPermissionBSDialog", r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r2, r6) == false) goto L48;
    L17:
        ru8.a r7 = F2();
        if (r7 == null) goto L20;
        String r8 = r7.Wc();
    L21:
        String r9 = r8;
        String r10 = r1.getBotCreateTrace().d();
        String r11 = r1.getBotCreateTrace().o();
        String r12 = r1.getBotCreateTrace().c();
        String r13 = r1.getBotCreateTrace().i();
        String r14 = r1.getBotCreateTrace().h();
        Intrinsics.checkNotNullParameter(this, "<this>");
        TraceFragment r15 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.larus.trace.tracknode.TraceFragment");
        o3.a(r9, r10, r11, r12, "status_permission", r13, r14, r15, 257);
        return;
    L20:
        r8 = null;
        goto L21
    L48:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L16:
        r2.show(r4, "BotPublicPermissionBSDialog");
        goto L17
    L22:
        e10 r16 = e10.a;
        if (e10.l() == true) goto L33;
        ru8.e r17 = L2();
        if (r17 == null) goto L33;
        com.larus.common_ui.dialog.l0 r18 = r17.uL();
        if (r18 == null) goto L33;
        if (DialogLancet.shouldBlockDialogShow(r18) == false) goto L50;
        DialogLancet.handleBlockedDialogShow(r18);
        goto L33
    L50:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L32:
        DialogLancet.beforeDialogShow(r18);
        r18.show();
        DialogLancet.afterDialogShow(r18);
    L33:
        r1.create();
        if (e10.l() == false) goto L56;
        ru8.e r19 = L2();
        if (r19 == null) goto L57;
        com.larus.common_ui.dialog.l0 r20 = r19.uL();
        if (r20 != null) goto L40;
        return;
    L40:
        if (DialogLancet.shouldBlockDialogShow(r20) == false) goto L52;
        DialogLancet.handleBlockedDialogShow(r20);
        return;
    L52:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L47
    L43:
        DialogLancet.beforeDialogShow(r20);
        r20.show();
        DialogLancet.afterDialogShow(r20);
        return;
    L57:
        return;
    L56:
        return;
    }

    public final Unit N2(boolean r5) {
        ru8.e r0 = L2();
        if (r0 == null) goto L20;
        LarusPageBotEditBinding r1 = r0.e();
        if (r1 == null) goto L20;
        ru8.a r2 = F2();
        boolean r3 = false;
        if (r2 == null) goto L13;
        BotCreateViewModel r4 = r2.a1();
        if (r4 == null) goto L13;
        if (r4.getCanAddBgImage() != true) goto L13;
        r3 = true;
    L13:
        if (r3 == false) goto L18;
        r1.i.setEnabled(r5);
        if (r5 == false) goto L17;
        r1.i.setAlpha(1.0f);
    L22:
        return Unit.INSTANCE;
    L17:
        r1.i.setAlpha(0.3f);
        goto L22
    L18:
        r1.K.setRightTextEnable(r5);
    L20:
        return null;
    }
}
