package com.larus.voicecall.impl.ui;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.av_call.constant.ThemeType;
import com.larus.im.bean.bot.BotModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusLayoutRealtimeCallBgBinding;
import com.larus.voicecall.impl.util.t0;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u00016B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u001f\u001a\u00020 2\u0006\u0010\f\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u00112\u0006\u0010\"\u001a\u00020\u000fJ \u0010#\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010$\u001a\u00020%J\u0012\u0010&\u001a\u00020 2\b\b\u0003\u0010'\u001a\u00020\u0007H\u0002J\u0012\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020 H\u0002J\u0006\u0010.\u001a\u00020 J\u0006\u0010/\u001a\u00020 J\u0012\u00100\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u00101\u001a\u000202J\b\u00103\u001a\u00020 H\u0002J\u0010\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020%H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018¨\u00067"}, d2 = {"Lcom/larus/voicecall/impl/ui/VoiceCallBgLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgBinding", "Lcom/larus/voicecall/impl/databinding/LarusLayoutRealtimeCallBgBinding;", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "isShowVideo", NameKeys.UnloadStrategy_No_Strategy, "curBotModel", "Lcom/larus/im/bean/bot/BotModel;", "runtimeParam", "Lkotlin/Function0;", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeParam", "()Lkotlin/jvm/functions/Function0;", "setRuntimeParam", "(Lkotlin/jvm/functions/Function0;)V", "argumentParam", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentParam", "setArgumentParam", "isTranslateScene", "setTranslateScene", "initView", NameKeys.UnloadStrategy_No_Strategy, "botModel", "forceSimpleColor", "refreshBg", "bigBgView", "Landroid/view/View;", "showSimpleColor", "colorRes", "setBackground", "background", "Landroid/graphics/drawable/Drawable;", "setBackgroundColor", "color", "showVideo", "tryResumeVideo", "tryHideVideo", "showImage", "getLiveVideoViewContainer", "Landroid/widget/FrameLayout;", "hideAll", "exceptView", "view", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCallBgLayout extends ConstraintLayout {
    public static final /* synthetic */ int g = 0;
    public final LarusLayoutRealtimeCallBgBinding a;
    public ThemeType b;
    public boolean c;
    public Function0<e3a.b> d;
    public Function0<e3a.a> e;
    public Function0<Boolean> f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ThemeType.values().length];
            r0[ThemeType.MAIN_BOT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ThemeType.UGC_BOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ThemeType.IMMERS_BOT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public VoiceCallBgLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceCallBgLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void T5() {
        t0.a.getClass();
        t0.b r0 = t0.f;
        if (r0.a() == true) goto L10;
        t0.b("bg_small_video.mp4", r0.a);
        if (r0.a() == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L12;
    L14:
        boolean r2 = false;
    L16:
        if (r2 == false) goto L18;
        VoiceCallVideoView.f(this.a.i, r0);
        FLogger.a.i("VoiceCallBgLayout", "showVideo bgVideo:" + r0 + " isMain=" + com.bytedance.apm.util.u.a());
    L19:
        VoiceCallVideoView r1 = this.a.i;
        Application r3 = c4a.f.a;
        ThemeType r4 = this.b;
        Intrinsics.checkNotNullParameter(r4, "themeType");
        if (i88.e.o(r4) == false) goto L22;
        VoiceCallVideoView.b r5 = c4a.f.c;
    L23:
        VoiceCallVideoView.h(r1, r5);
        e1.x(this.a.i);
        this.c = true;
        return;
    L22:
        r5 = c4a.f.b;
        goto L23
    L18:
        VoiceCallVideoView r6 = this.a.i;
        e1.x(r6.l);
        r6.l.setImageResource(2131239475);
        FLogger.a.i("VoiceCallBgLayout", "showVideo first frame  isMain=" + com.bytedance.apm.util.u.a());
        goto L19
    L12:
        if (r0.a() != true) goto L14;
        r2 = true;
        goto L16
    }

    public final FrameLayout getLiveVideoViewContainer() {
        return this.a.c;
    }

    public final Function0<e3a.a> getArgumentParam() {
        return this.e;
    }

    public final Function0<e3a.b> getRuntimeParam() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void S5(VoiceCallBgLayout r3) {
        int r0 = v19.c.b(2130972364, null, 2131103343);
        r3.setBackground(new ColorDrawable(ContextCompat.getColor(r3.getContext(), r0)));
    }

    public final void setArgumentParam(Function0<e3a.a> r1) {
        this.e = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackground(Drawable r1) {
        super/*android.view.ViewGroup*/.setBackground(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(int r1) {
        super/*android.view.ViewGroup*/.setBackgroundColor(r1);
    }

    public final void setRuntimeParam(Function0<e3a.b> r1) {
        this.d = r1;
    }

    public final void setTranslateScene(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VoiceCallBgLayout(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        LayoutInflater.from(r13).inflate(2131562867, this);
        int r16 = 2131378205;
        View r2 = ViewBindings.findChildViewById(this, 2131378205);
        if (r2 == null) goto L25;
        r16 = 2131378522;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(this, 2131378522);
        if (r3 == null) goto L25;
        r16 = 2131380875;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(this, 2131380875);
        if (r4 == null) goto L25;
        r16 = 2131383787;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(this, 2131383787);
        if (r5 == null) goto L25;
        r16 = 2131383788;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(this, 2131383788);
        if (r6 == null) goto L25;
        r16 = 2131383789;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(this, 2131383789);
        if (r7 == null) goto L25;
        r16 = 2131383790;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(this, 2131383790);
        if (r8 == null) goto L25;
        r16 = 2131383791;
        VoiceCallVideoView r9 = (VoiceCallVideoView) ViewBindings.findChildViewById(this, 2131383791);
        if (r9 == null) goto L25;
        r16 = 2131383829;
        View r10 = ViewBindings.findChildViewById(this, 2131383829);
        if (r10 == null) goto L25;
        r16 = 2131387647;
        View r11 = ViewBindings.findChildViewById(this, 2131387647);
        if (r11 == null) goto L25;
        this.a = new LarusLayoutRealtimeCallBgBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        this.b = ThemeType.DEFAULT;
        this.f = new w();
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r16)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(ThemeType r8, BotModel r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "themeType");
        this.b = r8;
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        View r3 = getChildAt(r2);
        if (CollectionsKt.contains(CollectionsKt.listOf(this.a.c), r3) == true) goto L7;
        e1.o(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        Function0<e3a.a> r1 = this.e;
        if (r1 == null) goto L15;
        e3a.a r4 = (e3a.a) r1.invoke();
        if (r4 == null) goto L15;
        if (((h88.a) r4).k0 != true) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L18;
    L21:
        boolean r11 = false;
    L22:
        int r12 = b.a[r8.ordinal()];
        if (r12 == 1) goto L55;
        if (r12 == 2) goto L47;
        if (r12 == 3) goto L30;
        if (r11 == false) goto L68;
        S5(this);
        return;
    L68:
        return;
    L30:
        if (r11 == false) goto L32;
        S5(this);
        return;
    L32:
        if (r9 == null) goto L75;
        final LarusLayoutRealtimeCallBgBinding r13 = this.a;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L40
        e1.x(r13.e);     // Catch: Throwable -> L40
        e1.x(r13.h);     // Catch: Throwable -> L40
        e1.x(r13.g);     // Catch: Throwable -> L40
        e1.x(r13.f);     // Catch: Throwable -> L40
        ImageLoaderKt.y(r13.e, r9.getBgImgUrl(), "audio_immerse_decorate_wrap_1", new v(r13), 4);     // Catch: Throwable -> L40
        if (com.larus.bmhome.chat.immerse.k0.a <= 0) goto L38;
        r13.e.getLayoutParams().height = com.larus.bmhome.chat.immerse.k0.a;     // Catch: Throwable -> L40
    L38:
        int r15 = com.larus.bmhome.chat.immerse.k0.a(Color.parseColor(r9.getBgImgColor()), 0.4f, 0.15f);     // Catch: Throwable -> L40
        setBackgroundColor(r15);     // Catch: Throwable -> L40
        r13.f.setBackgroundColor(r15);     // Catch: Throwable -> L40
        GradientDrawable r16 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{r15, 0});     // Catch: Throwable -> L40
        r16.setGradientType(0);     // Catch: Throwable -> L40
        r13.g.setBackground(r16);     // Catch: Throwable -> L40
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L42:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L76;
        FLogger.a.e("VoiceCallBgLayout", "showImage failed:" + r18);
        return;
    L76:
        return;
    L40:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L75:
        return;
    L47:
        if (c4a.l.a() == true) goto L53;
        boolean r20 = v19.h.a;
        if (v19.h.a(null) == true) goto L53;
        if (r11 == true) goto L53;
        T5();
        return;
    L53:
        S5(this);
        return;
    L55:
        if (c4a.l.a() == true) goto L61;
        boolean r21 = v19.h.a;
        if (v19.h.a(null) == true) goto L61;
        if (r11 == true) goto L61;
        T5();
        return;
    L61:
        S5(this);
        return;
    L18:
        if (((Boolean) this.f.invoke()).booleanValue() == false) goto L20;
        if (r10 == false) goto L21;
    L20:
        r11 = true;
    L15:
        r5 = false;
        goto L16
    }

    public /* synthetic */ VoiceCallBgLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
