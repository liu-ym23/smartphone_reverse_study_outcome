package com.larus.bmhome.view;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.actionbar.ActionStyle;
import com.larus.chat.common.databinding.LarusLayoutTextMessageActionButtonBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rs8.n;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/view/TextAnswerSingleActionButton;", "Lcom/larus/bmhome/view/BaseTextAnswerActionButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutTextMessageActionButtonBinding;", "getBinding", "()Lcom/larus/chat/common/databinding/LarusLayoutTextMessageActionButtonBinding;", "binding$delegate", "Lkotlin/Lazy;", "lastAction", "Lcom/larus/bmhome/view/actionbar/IAction;", "config", "", "action", "useSubscribedColor", "", "compact", "configLottieAction", "Lcom/larus/bmhome/view/actionbar/LottieAction;", "configImageAction", "Lcom/larus/bmhome/view/actionbar/ImageAction;", "getRoot", "Landroid/view/ViewGroup;", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextAnswerSingleActionButton extends BaseTextAnswerActionButton {
    public static final /* synthetic */ int d = 0;
    public final Lazy b;
    public rs8.g c;

    public static final class a {
    }

    static {
    }

    public TextAnswerSingleActionButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TextAnswerSingleActionButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.larus.bmhome.view.BaseTextAnswerActionButton, com.larus.bmhome.view.f2
    public ViewGroup getRoot() {
        return this;
    }

    private final LarusLayoutTextMessageActionButtonBinding getBinding() {
        return (LarusLayoutTextMessageActionButtonBinding) this.b.getValue();
    }

    public TextAnswerSingleActionButton(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setGravity(17);
        this.b = LazyKt.lazy(new m4(r2, this));
    }

    @Override // com.larus.bmhome.view.BaseTextAnswerActionButton, com.larus.bmhome.view.f2
    public final void a(final rs8.g r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "action");
        super.a(r11, r12, r13);
        boolean r0 = r11 instanceof rs8.j;
        if (r0 == false) goto L5;
    L7:
        LarusLayoutTextMessageActionButtonBinding r1 = getBinding();
        if (r13 == false) goto L10;
        int r14 = i5.j0();
    L11:
        r1.e.setPadding(r14, r14, r14, r14);
        boolean r2 = true;
        int r3 = 0;
        if (StringsKt.isBlank(r11.getDescription()) == false) goto L14;
        com.larus.utils.e1.o(r1.d);
    L34:
        if (r0 == false) goto L73;
        rs8.j r4 = (rs8.j) r11;
        LarusLayoutTextMessageActionButtonBinding r5 = getBinding();
        r5.e.setVisibility(0);
        r5.c.cancelAnimation();
        r5.c.setVisibility(8);
        SimpleDraweeView r6 = r5.b;
        if (r4.d != null) goto L39;
        r2 = false;
    L39:
        if (r2 == false) goto L41;
        int r7 = 0;
    L42:
        r6.setVisibility(r7);
        SimpleDraweeView r8 = r5.f;
        if (o0.d(r4.e) == true) goto L46;
        r3 = 8;
    L46:
        r8.setVisibility(r3);
        r5.b.setEnabled(r4.i);
        r5.b.setSelected(r4.h);
        r5.b.setRotation(r4.f);
        boolean r15 = Intrinsics.areEqual(r4.a, "fork_conv");
        if (r15 == false) goto L49;
        int r9 = i5.A();
    L50:
        SimpleDraweeView r10 = r5.b;
        ViewGroup.LayoutParams r16 = r10.getLayoutParams();
        r16.width = r9;
        r16.height = r9;
        r10.setLayoutParams(r16);
        SimpleDraweeView r17 = r5.b;
        if (r15 == false) goto L53;
        ImageView.ScaleType r18 = ImageView.ScaleType.FIT_CENTER;
    L54:
        r17.setScaleType(r18);
        Drawable r19 = r4.d;
        if (r19 == null) goto L62;
        r5.b.setImageDrawable(r19);
        ColorFilter r110 = b(r12);
        if (r110 == null) goto L59;
        r5.b.setColorFilter(r110);
    L59:
        IFlowThemeConfigProvider r20 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r20 == null) goto L62;
        ThemeColorKey r21 = ThemeColorKey.MESSAGE_ANSWER_ACTION_COLOR;
        ThemeConfigScene r22 = ThemeConfigScene.CHAT;
        AdaptThemeFeatureKey r23 = AdaptThemeFeatureKey.MESSAGE_ANSWER_ACTION;
        boolean r111 = v19.h.a;
        r20.g(r19, r21, r22, r23, Boolean.valueOf(v19.h.b(getContext())));
    L62:
        String r112 = r4.e;
        if (r112 == null) goto L68;
        ImageLoaderKt.y(r5.f, r112, "text_message_action_bar", new o4(), 4);
        ColorFilter r113 = b(r12);
        if (r113 == null) goto L68;
        r5.f.setColorFilter(r113);
    L68:
        if (r4.i == false) goto L70;
        float r114 = 1.0f;
    L71:
        setAlpha(r114);
    L94:
        com.larus.utils.e1.d(this, new n4(this, r11));
        this.c = r11;
        return;
    L70:
        r114 = 0.3f;
        goto L71
    L53:
        r18 = ImageView.ScaleType.CENTER_INSIDE;
        goto L54
    L49:
        r9 = i5.C();
        goto L50
    L41:
        r7 = 8;
        goto L42
    L73:
        if ((r11 instanceof n) == false) goto L94;
        n r24 = (n) r11;
        LarusLayoutTextMessageActionButtonBinding r25 = getBinding();
        rs8.g r26 = this.c;
        if ((r26 instanceof n) == false) goto L81;
        String r27 = r24.e;
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type com.larus.bmhome.view.actionbar.LottieAction");
        if (Intrinsics.areEqual(r27, ((n) r26).e) == false) goto L81;
        if (r25.c.isAnimating() == false) goto L81;
        FLogger.a.i("TextAnswerSingleActionButton", "skip duplicate lottie animation");
    L81:
        r25.e.setVisibility(0);
        r25.c.setVisibility(0);
        r25.b.setVisibility(8);
        r25.f.setVisibility(8);
        r25.c.setImageAssetsFolder(r24.d);
        r25.c.setRepeatMode(r24.g);
        r25.c.setRepeatCount(r24.f);
        com.larus.platform.service.n1.a.a(r25.c);
        LottieAdapterView r115 = r25.c;
        if (r115.isAttachedToWindow() == false) goto L93;
        FLogger.a.i("TextAnswerSingleActionButton", "play lottie animation");
        r25.c.setAnimation(r24.e);
        if (r12 == false) goto L86;
        setLottieValueCallbackForSubscriber(r25.c);
    L86:
        ColorFilter r116 = b(r12);
        if (r116 == null) goto L89;
        r25.c.setColorFilter(r116);
    L89:
        IFlowChatThemeConfigProvider r117 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r117 == null) goto L92;
        r117.e(new p4(this, r25), AdaptThemeFeatureKey.MESSAGE_ANSWER_ACTION_LOTTIE);
    L92:
        r25.c.playAnimation();
        goto L94
    L93:
        r115.addOnAttachStateChangeListener(new q4(r115, r25, r24, r12, this));
        goto L94
    L14:
        com.larus.utils.e1.x(r1.d);
        r1.d.setText(r11.getDescription());
        ActionStyle r118 = r11.getStyle();
        Intrinsics.checkNotNullParameter(r118, "<this>");
        ActionStyle r28 = ActionStyle.HIGHLIGHT;
        if (r118 != r28) goto L17;
    L20:
        boolean r119 = true;
    L22:
        if (r119 == false) goto L28;
        AppCompatTextView r120 = r1.d;
        r120.setTextColor(ContextCompat.getColor(r120.getContext(), 2131103298));
        r120.setTextSize(0, i5.m());
        if (r11.getStyle() != r28) goto L26;
        Drawable r29 = ContextCompat.getDrawable(r120.getContext(), 2131240773);
    L27:
        r120.setCompoundDrawablesWithIntrinsicBounds(null, null, r29, null);
        r120.setCompoundDrawablePadding(i5.z());
    L32:
        Intrinsics.checkNotNull(r120);
        goto L34
    L26:
        r29 = ContextCompat.getDrawable(r120.getContext(), 2131240774);
        goto L27
    L28:
        r120 = r1.d;
        Integer r30 = c(r12);
        if (r30 == null) goto L31;
        r120.setTextColor(r30.intValue());
    L31:
        r120.setTextSize(0, i5.q());
        r120.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        goto L32
    L17:
        if (r118 == ActionStyle.HIGHLIGHT_WITH_LEFT_ICON) goto L20;
        r119 = false;
        goto L22
    L10:
        r14 = i5.n0();
        goto L11
    L5:
        if ((r11 instanceof n) == true) goto L7;
    }

    public /* synthetic */ TextAnswerSingleActionButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
