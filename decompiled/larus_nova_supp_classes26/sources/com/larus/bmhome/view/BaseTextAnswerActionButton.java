package com.larus.bmhome.view;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.view.actionbar.ActionStyle;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.n0;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rs8.o;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0005¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0005J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0004J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0004J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0004¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/view/BaseTextAnswerActionButton;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/view/ITextAnswerActionButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "config", "", "action", "Lcom/larus/bmhome/view/actionbar/IAction;", "useSubscribedColor", "", "compact", "getTextColorForSubscriber", "(Z)Ljava/lang/Integer;", "getTintColorForSubscriber", "getColorFilterForSubscriber", "Landroid/graphics/ColorFilter;", "setLottieValueCallbackForSubscriber", "lottieView", "Lcom/lynx/lottieadapter/LottieAdapterView;", "setLottieValueCallback", "color", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseTextAnswerActionButton extends LinearLayout implements f2 {
    public static final /* synthetic */ int a = 0;

    public BaseTextAnswerActionButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseTextAnswerActionButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.larus.bmhome.view.f2
    public abstract /* synthetic */ ViewGroup getRoot();

    public final ColorFilter b(boolean r4) {
        if (r4 == true) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(ContextCompat.getColor(getContext(), v19.c.b(2130968760, getContext(), 2131100139)), PorterDuff.Mode.SRC_ATOP);
    }

    public final Integer c(boolean r4) {
        if (r4 == false) goto L5;
        return Integer.valueOf(ContextCompat.getColor(getContext(), v19.c.b(2130968760, getContext(), 2131100139)));
    L5:
        return Integer.valueOf(ContextCompat.getColor(getContext(), v19.c.b(2130972123, getContext(), 2131103203)));
    }

    public final void setLottieValueCallbackForSubscriber(LottieAdapterView r6) {
        Intrinsics.checkNotNullParameter(r6, "lottieView");
        int r1 = ContextCompat.getColor(getContext(), v19.c.b(2130968760, getContext(), 2131100139));
        Intrinsics.checkNotNullParameter(r6, "lottieView");
        r6.addValueCallback(new d6a.a(new String[]{"**"}), c6a.d.C, new a(r1));
    }

    public BaseTextAnswerActionButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    @Override // com.larus.bmhome.view.f2
    public void a(rs8.g r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "action");
        setId(r8.getId());
        ViewGroup.MarginLayoutParams r0 = null;
        if (r9 == true) goto L5;
        ActionStyle r11 = r8.getStyle();
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (r11 != ActionStyle.HIGHLIGHT) goto L12;
    L15:
        boolean r12 = true;
    L16:
        if (r12 == false) goto L19;
        setBackgroundResource(2131239715);
    L22:
        IFlowThemeConfigProvider r1 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r1 == null) goto L26;
        Drawable r2 = getBackground();
        ThemeColorKey r3 = ThemeColorKey.MESSAGE_ANSWER_ACTION_BACKGROUND_COLOR;
        ThemeConfigScene r4 = ThemeConfigScene.CHAT;
        AdaptThemeFeatureKey r5 = AdaptThemeFeatureKey.MESSAGE_ANSWER_ACTION_BACKGROUND;
        boolean r13 = v19.h.a;
        r1.g(r2, r3, r4, r5, Boolean.valueOf(v19.h.b(getContext())));
    L26:
        if (r8.getId() == 2131380350) goto L28;
    L30:
        ViewGroup.LayoutParams r14 = getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L33;
        r0 = (ViewGroup.MarginLayoutParams) r14;
    L33:
        if (r0 != null) goto L36;
        r0 = generateDefaultLayoutParams();
    L36:
        if (r8.b() != MessageActionBarAlign.END) goto L38;
        r0.setMarginEnd(i5.r0());
    L40:
        if (StringsKt.isBlank(r8.getDescription()) == true) goto L42;
    L52:
        r0.width = -2;
        r0.height = -2;
    L53:
        setLayoutParams(r0);
        setContentDescription(r8.d());
        return;
    L42:
        if ((r8 instanceof o) == true) goto L52;
        if (r10 == false) goto L46;
        int r6 = 34;
    L47:
        r0.width = c7.b(r6);
        if (r10 == false) goto L50;
        int r15 = 34;
    L51:
        r0.height = c7.b(r15);
        goto L53
    L50:
        r15 = 36;
        goto L51
    L46:
        r6 = 36;
        goto L47
    L38:
        r0.setMarginStart(i5.r0());
        goto L40
    L28:
        if (AudioServiceDelegate.a.g() == false) goto L30;
        setAlpha(0.3f);
        goto L30
    L19:
        if (n0.a.b() == false) goto L21;
        setBackgroundResource(2131239714);
        goto L22
    L21:
        setBackgroundResource(v19.c.b(2130970833, null, 2131239712));
        goto L22
    L12:
        if (r11 == ActionStyle.HIGHLIGHT_WITH_LEFT_ICON) goto L15;
        r12 = false;
        goto L16
    L5:
        if (n0.a.b() == false) goto L7;
        int r16 = 2131239726;
    L8:
        setBackgroundResource(r16);
        goto L22
    L7:
        r16 = v19.c.b(2130970836, null, 2131239724);
        goto L8
    }

    public /* synthetic */ BaseTextAnswerActionButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
