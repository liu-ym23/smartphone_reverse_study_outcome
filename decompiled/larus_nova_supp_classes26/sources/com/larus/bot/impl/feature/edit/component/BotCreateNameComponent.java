package com.larus.bot.impl.feature.edit.component;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.keva.Keva;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import com.larus.platform.model.bot.BotMakerDataModel;
import com.larus.platform.service.AccountService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0013R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/larus/bot/impl/feature/edit/component/BotCreateNameComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "<init>", "()V", "botEditAbility", "Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "getBotEditAbility", "()Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "botEditAbility$delegate", "Lkotlin/Lazy;", "botCreateAbility", "Lcom/larus/bot/impl/feature/ability/IBotCreateAbility;", "getBotCreateAbility", "()Lcom/larus/bot/impl/feature/ability/IBotCreateAbility;", "botCreateAbility$delegate", "onParentViewCreated", "", "setupNameEdit", "()Lkotlin/Unit;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateNameComponent extends ComponentFeature {
    public final Lazy h;
    public final Lazy i;

    public final void B2() {
        ru8.e r0 = (ru8.e) this.h.getValue();
        if (r0 == null) goto L49;
        final LarusPageBotEditBinding r1 = r0.e();
        if (r1 == null) goto L50;
        ru8.a r2 = (ru8.a) this.i.getValue();
        if (r2 == null) goto L47;
        BotCreateViewModel r3 = r2.a1();
        if (r3 == null) goto L47;
        if (r3.getCanAddBgImage() == false) goto L18;
        FrameLayout r4 = r1.A;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L17;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        r6.topMargin = c7.b(16);
        r4.setLayoutParams(r6);
        goto L18
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L18:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r7 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r7 == null) goto L26;
        com.larus.bot.impl.feature.botmaker.k r8 = com.larus.bot.impl.feature.botmaker.k.a;
        BotMakerDataModel r9 = com.larus.bot.impl.feature.botmaker.k.d(r7.getString("bot_create_info"));
        if (r9 == null) goto L24;
        String r10 = r9.getNick_name();
        if (r10 == null) goto L24;
    L25:
        if (r10 == null) goto L26;
    L27:
        String r11 = StringsKt.trim(r10).toString();
        final Context r12 = getContext();
        boolean r13 = true;
        if (r12 == null) goto L30;
        r1.z.setFilters(new InputFilter[]{new com.larus.bot.impl.common.util.c(r12.getResources().getInteger(2131427368), new c0(r12))});
    L30:
        r1.z.setText(r11);
        r3.updateName(r11);
        if (r11.length() <= 0) goto L33;
        boolean r14 = true;
    L34:
        if (r14 == false) goto L37;
        r3.onBotInfoChanged(ContentType.NAME, false);
    L37:
        if (AccountService.a.isLogin().booleanValue() == true) goto L39;
    L46:
        r1.z.addTextChangedListener(new h0(r1, r3, this));
        r1.B.setOnClickListener(new d0(r1));
        r1.z.setOnFocusChangeListener(new e0(r1));
        goto L47
    L39:
        if (r11.length() == 0) goto L42;
        r13 = false;
    L42:
        if (r13 == false) goto L46;
        tu8.a.a.getClass();
        Keva r15 = tu8.a.b;
        String r16 = r15.getString("key_create_bot_name", null);
        if (com.larus.utils.o0.d(r16) == false) goto L46;
        r1.z.setText(r16);
        Intrinsics.checkNotNull(r16);
        r3.updateName(r16);
        r15.erase("key_create_bot_name");
        goto L46
    L33:
        r14 = false;
    L24:
        r10 = r7.getString("pre_filled_bot_name");
    L26:
        r10 = "";
    L47:
        Unit r17 = Unit.INSTANCE;
        return;
    L50:
        return;
    }

    public BotCreateNameComponent() {
        this.h = LazyKt.lazy(new f0(this));
        this.i = LazyKt.lazy(new g0(this));
    }
}
