package com.larus.profile.impl.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.account.base.api.ILoginService;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.bean.BotOnBoarding;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.profile.impl.databinding.LarusViewBotProfileBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0002J\u0014\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/profile/impl/view/BotProfileView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/profile/impl/databinding/LarusViewBotProfileBinding;", "bindData", "", "data", "Lcom/larus/profile/api/bean/ProfileBot;", "updateReviewTagStartConstraint", "setAddItemClick", "onClick", "Lkotlin/Function0;", "getSubtitle", "", "bot", "bindPrivateData", "privateStatus", "bindHeatData", "botStatus", "Lcom/larus/im/bean/bot/BotStatistic;", "isTagVisible", "visible", "", "isCreator", "creatorId", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BotProfileView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusViewBotProfileBinding a;

    public BotProfileView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BotProfileView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(fs9.n r15) {
        Intrinsics.checkNotNullParameter(r15, "data");
        LarusViewBotProfileBinding r0 = this.a;
        r0.g.setText(r15.n());
        r0.b.setVisibility(8);
        if (this.a.b.getVisibility() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        int r8 = 2131376312;
    L9:
        ConstraintSet r2 = new ConstraintSet();
        r2.clone(this);
        r2.connect(2131383195, 6, r8, 7, i5.j0());
        r2.setHorizontalBias(2131383195, 0.0f);
        r2.applyTo(this);
        if (Intrinsics.areEqual(r15.l(), "rollback") == false) goto L12;
    L15:
        r0.h.setVisibility(0);
        r0.h.setMaxWidth((int) (((double) ((((com.larus.utils.i.d(getContext()) - i5.q()) - i5.k0()) - i5.q()) - i5.q())) * 0.7d));
    L17:
        if (r0.h.getVisibility() != 0) goto L19;
        boolean r3 = true;
    L21:
        if (r3 == true) goto L23;
    L28:
        Number r4 = 0;
    L30:
        if (r0.b.getVisibility() != 0) goto L32;
        boolean r6 = true;
    L33:
        if (r6 == false) goto L35;
        int r7 = i5.v() + (i5.j0() * 2);
    L36:
        r0.g.setMaxWidth((((((com.larus.utils.i.d(getContext()) - i5.q()) - i5.k0()) - i5.q()) - Math.min(r0.h.getMaxWidth(), r4.intValue())) - i5.q()) - r7);
        BotIconImage r5 = r15.m();
        String r9 = null;
        if (r5 == null) goto L39;
        String r10 = r5.getTinyUrl();
    L41:
        if (o0.d(r10) == false) goto L47;
        SimpleDraweeView r11 = r0.e;
        BotIconImage r12 = r15.m();
        if (r12 == null) goto L45;
        String r13 = r12.getTinyUrl();
    L46:
        ImageLoaderKt.y(r11, r13, "settings_itg.bot", new b(), 4);
    L59:
        AppCompatTextView r14 = r0.f;
        String r16 = r15.d();
        String r17 = "";
        if (r16 == null) goto L63;
        String r18 = StringsKt.replace$default(r16, "\n", "", false, 4, null);
        if (r18 == null) goto L63;
    L64:
        BotOnBoarding r19 = r15.f();
        if (r19 == null) goto L67;
        String r20 = r19.d();
    L68:
        FeatureKitDelegate r21 = FeatureKitDelegate.b;
        if (r21.R().b() == true) goto L71;
    L73:
        if (r20 != null) goto L75;
    L77:
        boolean r22 = false;
    L78:
        if (r22 == false) goto L80;
        r18 = r20;
    L81:
        r14.setText(r18);
        BotCreatorInfo r23 = r15.k();
        if (r23 == null) goto L84;
        String r24 = r23.getId();
    L85:
        ILoginService.Companion r25 = ILoginService.a;
        if (Intrinsics.areEqual(r24, r25.getAccountInfo().c) == false) goto L88;
        r0.d.setVisibility(8);
    L96:
        if (r21.b().b() == false) goto L123;
        BotCreatorInfo r26 = r15.k();
        if (r26 == null) goto L100;
        r9 = r26.getId();
    L100:
        if (r9 == null) goto L103;
        r17 = r9;
    L103:
        String r27 = r25.getAccountInfo().c;
        FLogger.a.d("BotProfileView", "isCreator called: creatorId = " + r17 + ", userId = " + r27);
        if (Intrinsics.areEqual(r17, r27) == false) goto L122;
        Integer r28 = r15.o();
        if (r28 != null) goto L109;
    L110:
        if (r28 != null) goto L113;
    L115:
        S5(r15.g());
        return;
    L113:
        if (r28.intValue() != 3) goto L115;
    L116:
        int r110 = r28.intValue();
        LarusViewBotProfileBinding r29 = this.a;
        if (r110 == 2) goto L121;
        if (r110 == 3) goto L120;
        T5(false);
        return;
    L120:
        T5(true);
        r29.c.setImageResource(2131242165);
        r29.j.setText(getContext().getString(2131897492));
        return;
    L121:
        T5(true);
        r29.c.setImageResource(2131242840);
        r29.j.setText(getContext().getString(2131911008));
        return;
    L109:
        if (r28.intValue() == 2) goto L116;
    L122:
        S5(r15.g());
        return;
    L123:
        T5(false);
        return;
    L88:
        AppCompatImageView r30 = r0.d;
        Context r31 = getContext();
        if (r15.p() == true) goto L91;
    L93:
        int r32 = 2131235809;
    L94:
        r30.setImageDrawable(ContextCompat.getDrawable(r31, r32));
        r0.i.setVisibility(0);
        goto L96
    L91:
        if (r15.q() == true) goto L93;
        r32 = 2131235815;
        goto L94
    L84:
        r24 = null;
        goto L85
    L80:
        r18 = getContext().getString(2131906312);
        Intrinsics.checkNotNull(r18);
        goto L81
    L75:
        if (o0.d(r20) != true) goto L77;
        r22 = true;
        goto L78
    L71:
        if (o0.d(r18) == false) goto L73;
    L67:
        r20 = null;
    L63:
        r18 = "";
        goto L64
    L45:
        r13 = null;
        goto L46
    L47:
        BotIconImage r33 = r15.m();
        if (r33 == null) goto L50;
        String r34 = r33.getOriginUrl();
    L52:
        if (o0.d(r34) == false) goto L58;
        SimpleDraweeView r35 = r0.e;
        BotIconImage r36 = r15.m();
        if (r36 == null) goto L56;
        String r37 = r36.getOriginUrl();
    L57:
        ImageLoaderKt.y(r35, r37, "settings_itg.bot", new c(this), 4);
        goto L59
    L56:
        r37 = null;
        goto L57
    L58:
        ImageLoaderKt.y(r0.e, y0.k(new Uri.Builder().scheme("res").path(String.valueOf(2131240119)).build()), "settings_itg.bot", new d(), 4);
        goto L59
    L50:
        r34 = null;
        goto L52
    L39:
        r10 = null;
        goto L41
    L35:
        r7 = 0;
        goto L36
    L32:
        r6 = false;
        goto L33
    L23:
        if (r0.h.getText().length() <= 0) goto L25;
        boolean r38 = true;
    L26:
        if (r38 == false) goto L28;
        r4 = Float.valueOf((r0.h.getPaint().measureText(r0.h.getText().toString()) + (i5.j0() * 2)) + i5.r0());
        goto L30
    L25:
        r38 = false;
        goto L26
    L19:
        r3 = false;
        goto L21
    L12:
        if (Intrinsics.areEqual(r15.l(), "ban") == true) goto L15;
        r0.h.setVisibility(8);
        goto L17
    L8:
        r8 = 2131383194;
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    public final void S5(BotStatistic r6) {
        LarusViewBotProfileBinding r0 = this.a;
        String r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.getDisplayHeatScore();
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        T5(false);
        return;
    L15:
        T5(true);
        r0.c.setImageResource(2131242834);
        AppCompatTextView r4 = r0.j;
        if (r6 == null) goto L18;
        r1 = r6.getDisplayHeatScore();
    L18:
        r4.setText(r1);
        return;
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    public final void T5(boolean r6) {
        LarusViewBotProfileBinding r0 = this.a;
        AppCompatImageView r1 = r0.c;
        int r2 = 0;
        if (r6 == false) goto L5;
        int r4 = 0;
    L6:
        r1.setVisibility(r4);
        AppCompatTextView r3 = r0.j;
        if (r6 == true) goto L10;
        r2 = 8;
    L10:
        r3.setVisibility(r2);
        return;
    L5:
        r4 = 8;
        goto L6
    }

    public final void setAddItemClick(final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onClick");
        e1.d(this.a.d, new a(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BotProfileView(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        LayoutInflater.from(r12).inflate(2131563205, this);
        int r15 = 2131376312;
        AppCompatImageView r2 = ViewBindings.findChildViewById(this, 2131376312);
        if (r2 == null) goto L23;
        r15 = 2131376655;
        AppCompatImageView r3 = ViewBindings.findChildViewById(this, 2131376655);
        if (r3 == null) goto L23;
        r15 = 2131383184;
        AppCompatImageView r4 = ViewBindings.findChildViewById(this, 2131383184);
        if (r4 == null) goto L23;
        r15 = 2131383192;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(this, 2131383192);
        if (r5 == null) goto L23;
        r15 = 2131383193;
        AppCompatTextView r6 = ViewBindings.findChildViewById(this, 2131383193);
        if (r6 == null) goto L23;
        r15 = 2131383194;
        AppCompatTextView r7 = ViewBindings.findChildViewById(this, 2131383194);
        if (r7 == null) goto L23;
        r15 = 2131383195;
        AppCompatTextView r8 = ViewBindings.findChildViewById(this, 2131383195);
        if (r8 == null) goto L23;
        r15 = 2131383251;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(this, 2131383251);
        if (r9 == null) goto L23;
        r15 = 2131391552;
        AppCompatTextView r10 = ViewBindings.findChildViewById(this, 2131391552);
        if (r10 == null) goto L23;
        this.a = new LarusViewBotProfileBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r15)));
    }

    public /* synthetic */ BotProfileView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
