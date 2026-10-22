package com.larus.bot.impl.feature.edit.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.InputFilter;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.BotUpdateViewModel;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.EditPos;
import com.larus.settings.value.e10;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0013R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/larus/bot/impl/feature/edit/component/BotUpdateNameComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "<init>", "()V", "botEditAbility", "Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "getBotEditAbility", "()Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "botEditAbility$delegate", "Lkotlin/Lazy;", "botUpdateAbility", "Lcom/larus/bot/impl/feature/ability/IBotUpdateAbility;", "getBotUpdateAbility", "()Lcom/larus/bot/impl/feature/ability/IBotUpdateAbility;", "botUpdateAbility$delegate", "onParentViewCreated", "", "setupNameEdit", "()Lkotlin/Unit;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotUpdateNameComponent extends ComponentFeature {
    public final Lazy h;
    public final Lazy i;

    public final void B2() {
        ru8.e r0 = (ru8.e) this.h.getValue();
        if (r0 == null) goto L51;
        final LarusPageBotEditBinding r1 = r0.e();
        if (r1 == null) goto L52;
        ru8.f r2 = (ru8.f) this.i.getValue();
        if (r2 == null) goto L49;
        BotUpdateViewModel r3 = r2.c50();
        if (r3 == null) goto L49;
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
        AppCompatEditText r7 = r1.z;
        ru8.f r8 = (ru8.f) this.i.getValue();
        if (r8 == null) goto L23;
        EditPos r9 = r8.Ph();
        if (r9 == null) goto L23;
        boolean r10 = r9.i();
    L24:
        r7.setEnabled(r10);
        e10 r11 = e10.a;
        if (e10.B0() == false) goto L33;
        Context r12 = getContext();
        if (r12 == null) goto L31;
        Resources r13 = r12.getResources();
        if (r13 == null) goto L31;
        r1.z.setTextColor(r13.getColor(2131103140));
        r1.z.setHintTextColor(r13.getColor(2131103140));
        r1.F.setTextColor(r13.getColor(2131103140));
    L31:
        r1.z.setKeyListener(null);
        r1.z.setOnClickListener(new o1(this));
        r1.z.setOnLongClickListener(new p1(this));
    L33:
        if (r1.z.isEnabled() == true) goto L38;
        Context r14 = getContext();
        if (r14 == null) goto L37;
        r1.z.setTextColor(ContextCompat.getColor(r14, 2131103143));
    L37:
        r1.C.setVisibility(0);
        r1.C.setOnClickListener(new q1(this));
    L38:
        final Context r15 = getContext();
        if (r15 == null) goto L41;
        r1.z.setFilters(new InputFilter[]{new com.larus.bot.impl.common.util.c(r15.getResources().getInteger(2131427368), new r1(r15))});
    L41:
        AppCompatEditText r16 = r1.z;
        ru8.f r17 = (ru8.f) this.i.getValue();
        if (r17 == null) goto L47;
        BotModel r18 = r17.FH();
        if (r18 == null) goto L47;
        String r19 = r18.getName();
        if (r19 == null) goto L47;
    L48:
        r16.setText(r19);
        r1.z.addTextChangedListener(new t1(this, r1, r3));
        r1.B.setOnClickListener(new s1(r1));
    L47:
        r19 = "";
    L23:
        r10 = false;
    L49:
        Unit r20 = Unit.INSTANCE;
        return;
    L52:
        return;
    }

    public BotUpdateNameComponent() {
        this.h = LazyKt.lazy(new m1(this));
        this.i = LazyKt.lazy(new n1(this));
    }
}
