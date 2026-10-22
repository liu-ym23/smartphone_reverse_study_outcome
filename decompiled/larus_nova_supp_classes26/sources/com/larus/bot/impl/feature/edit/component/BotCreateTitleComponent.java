package com.larus.bot.impl.feature.edit.component;

import android.view.View;
import android.view.Window;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bot.impl.bean.BotEditParam;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/bot/impl/feature/edit/component/BotCreateTitleComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/bot/impl/feature/ability/IBotCreateNavAbility;", "<init>", "()V", "botEditAbility", "Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "getBotEditAbility", "()Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "botEditAbility$delegate", "Lkotlin/Lazy;", "botCreateAbility", "Lcom/larus/bot/impl/feature/ability/IBotCreateAbility;", "getBotCreateAbility", "()Lcom/larus/bot/impl/feature/ability/IBotCreateAbility;", "botCreateAbility$delegate", "botCreateButtonAbility", "Lcom/larus/bot/impl/feature/ability/IBotCreateButtonAbility;", "getBotCreateButtonAbility", "()Lcom/larus/bot/impl/feature/ability/IBotCreateButtonAbility;", "botCreateButtonAbility$delegate", "onAttach", "", "onParentViewCreated", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "goBack", "showExitCreateDialog", "backPage", "closeInputWindow", "cancelCreate", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateTitleComponent extends ComponentFeature implements ru8.d {
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;

    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.ViewGroup, com.larus.bmhome.view.NovaTitleBarEx] */
    public final void B2() {
        ru8.e r0 = (ru8.e) this.h.getValue();
        if (r0 == null) goto L19;
        LarusPageBotEditBinding r1 = r0.e();
        if (r1 == null) goto L20;
        FLogger.a.d("BotEditTitleComponent", "setupTitle");
        ?? r4 = r1.K;
        ru8.a r2 = F2();
        if (r2 == null) goto L13;
        BotCreateViewModel r3 = r2.a1();
        if (r3 == null) goto L13;
        boolean r5 = true;
        if (r3.getCanAddBgImage() != true) goto L13;
    L15:
        if (r5 == false) goto L17;
        NovaTitleBarEx.Y5(r4, r4.getContext().getString(2131901108), null, null, 6);
        int r6 = com.larus.utils.j0.a;
        NovaTitleBarEx.b6(r4, 2131243589, false, null, com.larus.utils.j0.d(2131898809), new i0(this), 6);
        return;
    L17:
        NovaTitleBarEx.Y5(r4, r4.getContext().getString(2131901108), null, null, 6);
        r4.c6(r4.getContext().getString(2131901050), null, new j0(this));
        NovaTitleBarEx.o6(r4, r4.getContext().getString(2131901060), new k0(this));
        r4.setRightTextEnable(false);
        return;
    L13:
        r5 = false;
        goto L15
    L20:
        return;
    }

    public final ru8.a F2() {
        return (ru8.a) this.i.getValue();
    }

    @Override // ru8.d
    public final void goBack() {
        ru8.a r1 = F2();
        if (r1 == null) goto L85;
        BotCreateViewModel r2 = r1.a1();
        if (r2 == null) goto L88;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof TraceFragment) == true) goto L11;
        return;
    L11:
        if (r2.checkUserEdited(false, false) == false) goto L25;
        ru8.a r3 = F2();
        if (r3 == null) goto L86;
        BotCreateViewModel r4 = r3.a1();
        if (r4 == null) goto L89;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof TraceFragment) == false) goto L90;
        CommonDialog.a r5 = new CommonDialog.a();
        r5.i(getContext().getString(2131905453));
        CommonDialog.a.f(r5, new o0(this, r4), getContext().getString(2131905452), false, 12);
        CommonDialog.a.e(r5, new p0(), getContext().getString(2131905451), 4);
        CommonDialog r6 = r5.c();
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r7 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, null, r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r6, r8) == true) goto L91;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L82
    L24:
        r6.show(r7, null);
        return;
    L91:
        return;
    L90:
        return;
    L89:
        return;
    L86:
        return;
    L25:
        dv8.b.C0105b r9 = r2.getBotCreateTrace().g();
        String r15 = r2.getBotCreateTrace().o();
        if (r2.getBotCreateTrace().j() == false) goto L28;
        String r10 = "1";
    L30:
        if (r2.getBotCreateTrace().q() == false) goto L32;
        String r12 = "1";
    L33:
        boolean r11 = true;
        if ((!StringsKt.isBlank(r2.getEditParam().getDescription())) == false) goto L36;
        String r13 = "1";
    L37:
        ru8.a r14 = F2();
        if (r14 == null) goto L40;
        String r16 = r14.n6();
    L41:
        ru8.a r17 = F2();
        if (r17 == null) goto L44;
        String r18 = r17.Wc();
    L45:
        String r19 = r2.getBotCreateTrace().e();
        ru8.a r110 = F2();
        if (r110 != null) goto L48;
    L50:
        r11 = false;
    L51:
        if (r11 == false) goto L53;
        String r111 = "1";
    L54:
        BotEditParam r20 = r2.getEditParam();
        if (r20 == null) goto L57;
        boolean r21 = Intrinsics.areEqual(r20.getEnableWebSearch(), Boolean.TRUE);
    L58:
        if (r21 == false) goto L60;
        String r22 = "1";
    L61:
        BotEditParam r23 = r2.getEditParam();
        if (r23 == null) goto L64;
        boolean r24 = Intrinsics.areEqual(r23.getEnableGenPic(), Boolean.TRUE);
    L65:
        if (r24 == false) goto L67;
        String r25 = "1";
    L68:
        String r26 = r2.getBotCreateTrace().c();
        String r112 = r2.getBotCreateTrace().d();
        Boolean r27 = r9.a;
        Integer r28 = r9.b;
        Boolean r29 = r9.c;
        String r210 = r2.getBotCreateTrace().i();
        String r211 = r2.getBotCreateTrace().h();
        String r212 = r2.getBotCreateTrace().l();
        BgImage r30 = r2.getEditParam().getBgImage();
        if (r30 == null) goto L75;
        BgImageInfo r31 = r30.bgImageInfo;
        if (r31 == null) goto L75;
        Boolean r32 = r31.getBgImgOpen();
        if (r32 == null) goto L75;
        boolean r113 = r32.booleanValue();
    L76:
        SpeakerVoice r33 = r2.getEditParam().getVoice();
        if (r33 == null) goto L79;
        String r213 = r33.getId();
    L80:
        String r214 = dv8.c.b(r2.getEditParam().getVoice());
        String r215 = r2.getBotCreateTrace().r();
        String r216 = r2.getBotCreateTrace().v();
        String r34 = r2.getBotCreateTrace().t();
        String r35 = r2.getBotCreateTrace().x();
        String r36 = r2.getBotCreateTrace().w();
        String r37 = r2.getBotCreateTrace().b();
        String r38 = r2.getBotCreateTrace().s();
        boolean r39 = r2.getBotCreateTrace().p();
        boolean r114 = r2.getBotCreateTrace().k();
        int r217 = r2.getBotCreateTrace().m();
        String r310 = r2.getBotCreateTrace().n();
        String r311 = r2.getPrivateStatusString();
        boolean r40 = r2.polishUseInternet();
        boolean r41 = r2.autoFillUseInternet();
        Intrinsics.checkNotNullParameter(this, "<this>");
        TraceFragment r42 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNull(r42, "null cannot be cast to non-null type com.larus.trace.tracknode.TraceFragment");
        String r43 = r16;
        String r44 = r18;
        String r115 = r25;
        tx9.v.a(r43, r44, r22, r10, r115, r12, r13, r111, r15, r19, r26, r112, r27, r28, r29, r210, r211, r212, Boolean.valueOf(r113), r213, r214, r215, r216, r34, r35, r36, r37, r38, Boolean.valueOf(r39), Boolean.valueOf(r114), Integer.valueOf(r217), r310, r311, Boolean.valueOf(r40), Boolean.valueOf(r41), r42);
        bb();
        return;
    L79:
        r213 = null;
    L75:
        r113 = false;
        goto L76
    L67:
        r25 = TriggerSendLoading.NO_LOADING;
        goto L68
    L64:
        r24 = false;
        goto L65
    L60:
        r22 = TriggerSendLoading.NO_LOADING;
        goto L61
    L57:
        r21 = false;
        goto L58
    L53:
        r111 = TriggerSendLoading.NO_LOADING;
        goto L54
    L48:
        if (r110.na() != true) goto L50;
    L44:
        r18 = null;
        goto L45
    L40:
        r16 = null;
        goto L41
    L36:
        r13 = TriggerSendLoading.NO_LOADING;
        goto L37
    L32:
        r12 = TriggerSendLoading.NO_LOADING;
        goto L33
    L28:
        r10 = TriggerSendLoading.NO_LOADING;
        goto L30
    L88:
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, ru8.d.class);
    }

    public BotCreateTitleComponent() {
        this.h = LazyKt.lazy(new l0(this));
        this.i = LazyKt.lazy(new m0(this));
        this.j = LazyKt.lazy(new n0(this));
    }

    @Override // ru8.d
    public final void bb() {
        ru8.a r0 = F2();
        if (r0 == null) goto L7;
        BotCreateViewModel r1 = r0.a1();
        if (r1 == null) goto L7;
        r1.onBackPage();
    L7:
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r2 == null) goto L10;
        r2.clearFocus();
    L10:
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r3 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r3 == null) goto L17;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r4 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r4 == null) goto L17;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L17;
        new WindowInsetsControllerCompat(r5, r3).hide(WindowInsetsCompat.Type.ime());
    L17:
        qu8.b.d("bot_create", -1);
        ru8.a r6 = F2();
        boolean r7 = true;
        if (r6 == null) goto L24;
        BotCreateViewModel r8 = r6.a1();
        if (r8 == null) goto L24;
        if (r8.inRequireBotEnrich() != true) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == false) goto L27;
        qu8.b.d("enrich", -1);
        qu8.b.d("bot_create_auto_fill", -1);
    L27:
        ru8.a r10 = F2();
        if (r10 == null) goto L34;
        BotCreateViewModel r11 = r10.a1();
        if (r11 == null) goto L34;
        if (r11.inRequireBotAvatar() != true) goto L34;
    L35:
        if (r7 == false) goto L37;
        qu8.b.c(-1, new String[]{"gen_icon", "bot_create/autofill/bg", "gen_icon_by_prompt", "avatar_head_location_crop", "upload_file", "bot_create_auto_fill"});
    L37:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r12 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r12 == null) goto L40;
        r12.finish();
    L40:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r13 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r13 == null) goto L44;
        r13.overridePendingTransition(0, 2130772402);
        return;
    L44:
        return;
    L34:
        r7 = false;
    L24:
        r9 = false;
        goto L25
    }
}
