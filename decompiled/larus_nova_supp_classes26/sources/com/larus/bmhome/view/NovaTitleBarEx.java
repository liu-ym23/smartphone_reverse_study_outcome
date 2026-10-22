package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common_res.common_ui.databinding.LarusLayoutLeftAvatarBinding;
import com.larus.common_res.common_ui.databinding.LarusWidgetTitlebarExBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010\"J0\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0014JA\u0010*\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\nJ\u000e\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\nJD\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\n2\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020%2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010;\u001a\u00020\u001cJ:\u0010<\u001a\u00020=2\u0006\u00104\u001a\u00020\n2\b\b\u0002\u00107\u001a\u00020%2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010>\u001a\u00020\u001cJ)\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020A2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010BJD\u0010C\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\n2\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020%2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010!J:\u0010D\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\n2\b\b\u0002\u00107\u001a\u00020%2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010!J\u0006\u0010E\u001a\u00020\u001cJ\u0006\u0010F\u001a\u00020=J\"\u0010G\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!J\u000e\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020%J$\u0010J\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010K\u001a\u0004\u0018\u00010\r2\b\u0010L\u001a\u0004\u0018\u00010\rJ#\u0010M\u001a\u00020\u001c2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010R\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020UH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006V"}, d2 = {"Lcom/larus/bmhome/view/NovaTitleBarEx;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "value", "Lcom/larus/common_res/common_ui/databinding/LarusWidgetTitlebarExBinding;", "binding", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusWidgetTitlebarExBinding;", "avatarAreaViewStub", "Lcom/larus/common_ui/view/ViewStubManager;", "Lcom/larus/common_res/common_ui/databinding/LarusLayoutLeftAvatarBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getAvatarAreaViewStub", "()Lcom/larus/common_ui/view/ViewStubManager;", "avatarAreaViewStub$delegate", "Lkotlin/Lazy;", "init", "", "setTitle", "title", "color", "listener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)V", "onLayout", "changed", "", "left", "top", "right", "bottom", "setTitleWithDesc", "desc", "titleColor", "descColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)Lkotlin/Unit;", "updateTitleVisibility", "visibility", "setTitleMaxWidth", "maxWidth", "showLeftImgSec", "resId", "alpha", "", "staticColor", "scaleType", "Landroid/widget/ImageView$ScaleType;", "accessibilityContent", "hideLeftImgSec", "showLeftImg", "Landroid/view/View;", "hideLeftImg", "showLeftText", ShareType.TEXT, "", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)V", "showRightImgSec", "showRightImg", "hideRightImg", "getRightImg", "showRightText", "setRightTextEnable", "enable", "setAvatarInfo", "subtitle", "avatarUrl", "setAvatarAreaStyle", "startMargin", "avatarSize", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setAvatarClickListener", "loadImg", "imgUrl", "builder", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NovaTitleBarEx extends ConstraintLayout {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public LarusWidgetTitlebarExBinding b;
    public final Lazy c;

    private final com.larus.common_ui.view.b0<LarusLayoutLeftAvatarBinding> getAvatarAreaViewStub() {
        return (com.larus.common_ui.view.b0) this.c.getValue();
    }

    public final LarusWidgetTitlebarExBinding getBinding() {
        LarusWidgetTitlebarExBinding r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void R5() {
        getBinding().f.setVisibility(8);
    }

    public final View getRightImg() {
        return getBinding().f;
    }

    public NovaTitleBarEx(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = "NovaTitleBarEx";
        this.c = LazyKt.lazy(new w3(this));
        S5(r2, null);
    }

    public final void setAvatarClickListener(View.OnClickListener r2) {
        getAvatarAreaViewStub().b();
        LarusLayoutLeftAvatarBinding r0 = getAvatarAreaViewStub().c;
        if (r0 == null) goto L10;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L11;
        if (r2 != null) goto L8;
        r1.setOnClickListener(null);
        r1.setClickable(false);
        return;
    L8:
        com.larus.utils.e1.c(r1, r2);
        return;
    L11:
        return;
    }

    public final void setRightTextEnable(boolean r3) {
        LarusWidgetTitlebarExBinding r0 = getBinding();
        r0.h.setEnabled(r3);
        TextView r1 = r0.h;
        if (r3 == false) goto L5;
        float r4 = 1.0f;
    L6:
        r1.setAlpha(r4);
        return;
    L5:
        r4 = 0.3f;
        goto L6
    }

    public final void setTitleMaxWidth(int r2) {
        getBinding().j.setMaxWidth(r2);
    }

    public NovaTitleBarEx(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = "NovaTitleBarEx";
        this.c = LazyKt.lazy(new w3(this));
        S5(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(Context r12, AttributeSet r13) {
        LayoutInflater.from(r12).inflate(2131563269, this);
        int r14 = 2131367606;
        if (((TextView) ViewBindings.findChildViewById(this, 2131367606)) == null) goto L27;
        r14 = 2131367607;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(this, 2131367607);
        if (r2 == null) goto L27;
        r14 = 2131367608;
        if (((TextView) ViewBindings.findChildViewById(this, 2131367608)) == null) goto L27;
        r14 = 2131377782;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(this, 2131377782);
        if (r3 == null) goto L27;
        r14 = 2131377783;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(this, 2131377783);
        if (r4 == null) goto L27;
        r14 = 2131377814;
        TextView r5 = (TextView) ViewBindings.findChildViewById(this, 2131377814);
        if (r5 == null) goto L27;
        r14 = 2131384596;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(this, 2131384596);
        if (r6 == null) goto L27;
        r14 = 2131384597;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(this, 2131384597);
        if (r7 == null) goto L27;
        r14 = 2131384632;
        TextView r8 = (TextView) ViewBindings.findChildViewById(this, 2131384632);
        if (r8 == null) goto L27;
        r14 = 2131386005;
        ViewStub r9 = (ViewStub) ViewBindings.findChildViewById(this, 2131386005);
        if (r9 == null) goto L27;
        r14 = 2131388915;
        TextView r10 = (TextView) ViewBindings.findChildViewById(this, 2131388915);
        if (r10 == null) goto L27;
        this.b = new LarusWidgetTitlebarExBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r14)));
    }

    public final void T5(Integer r3, Integer r4) {
        getAvatarAreaViewStub().b();
        if (r3 == null) goto L13;
        int r5 = r3.intValue();
        LarusLayoutLeftAvatarBinding r0 = getAvatarAreaViewStub().c;
        if (r0 == null) goto L13;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L13;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L12;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r2;
        r6.setMarginStart(r5);
        r1.setLayoutParams(r6);
        goto L13
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        if (r4 == null) goto L23;
        int r7 = r4.intValue();
        LarusLayoutLeftAvatarBinding r8 = getAvatarAreaViewStub().c;
        if (r8 == null) goto L24;
        TitleAvatarImageView r9 = r8.b;
        if (r9 == null) goto L25;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L22;
        r10.width = r7;
        r10.height = r7;
        r9.setLayoutParams(r10);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L25:
        return;
    L24:
        return;
    }

    public NovaTitleBarEx(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "NovaTitleBarEx";
        this.c = LazyKt.lazy(new w3(this));
        S5(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o6(NovaTitleBarEx r3, CharSequence r4, View.OnClickListener r5) {
        r3.n6(r4, v19.c.b(2130972123, r3.getContext(), 2131103203), r5);
    }

    public final void U5(String r3, String r4, String r5) {
        getAvatarAreaViewStub().b();
        LarusLayoutLeftAvatarBinding r0 = getAvatarAreaViewStub().c;
        if (r0 == null) goto L7;
        TextView r1 = r0.d;
        if (r1 == null) goto L7;
        r1.setText(r3);
    L7:
        LarusLayoutLeftAvatarBinding r6 = getAvatarAreaViewStub().c;
        if (r6 == null) goto L12;
        TextView r7 = r6.c;
        if (r7 == null) goto L12;
        r7.setText(r4);
    L12:
        LarusLayoutLeftAvatarBinding r8 = getAvatarAreaViewStub().c;
        if (r8 == null) goto L31;
        TitleAvatarImageView r9 = r8.b;
        if (r9 == null) goto L32;
        if (r5 != null) goto L18;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == false) goto L25;
        r9.setActualImageResource(2131240119);
        return;
    L25:
        r9.getHierarchy().setFadeDuration(200);
        final PipelineDraweeControllerBuilder r11 = Fresco.newDraweeControllerBuilder();
        LarusLayoutLeftAvatarBinding r12 = getAvatarAreaViewStub().c;
        if (r12 == null) goto L33;
        TitleAvatarImageView r13 = r12.b;
        if (r13 == null) goto L34;
        ImageLoaderKt.w(r13, r5, "chat.setting.bot_avatar", new x3(r11), null);
        return;
    L34:
        return;
    L33:
        return;
    L18:
        if (r5.length() == 0) goto L21;
        r10 = false;
        goto L22
    L32:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(String r4, Integer r5, View.OnClickListener r6) {
        Intrinsics.checkNotNullParameter(r4, "title");
        LarusWidgetTitlebarExBinding r0 = getBinding();
        com.larus.utils.e1.o(r0.b);
        r0.j.setVisibility(0);
        r0.j.setText(r4);
        if (r5 == null) goto L5;
        r0.j.setTextColor(ContextCompat.getColor(getContext(), r5.intValue()));
    L5:
        if (r6 == null) goto L8;
        com.larus.utils.e1.c(r0.j, r6);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c6(CharSequence r4, Integer r5, View.OnClickListener r6) {
        Intrinsics.checkNotNullParameter(r4, ShareType.TEXT);
        LarusWidgetTitlebarExBinding r0 = getBinding();
        r0.c.setVisibility(8);
        r0.e.setVisibility(0);
        r0.e.setText(r4);
        if (r5 == null) goto L5;
        r0.e.setTextColor(ContextCompat.getColor(getContext(), r5.intValue()));
    L5:
        com.larus.utils.e1.c(r0.e, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n6(CharSequence r5, int r6, View.OnClickListener r7) {
        Intrinsics.checkNotNullParameter(r5, ShareType.TEXT);
        LarusWidgetTitlebarExBinding r0 = getBinding();
        r0.f.setVisibility(8);
        r0.g.setVisibility(8);
        r0.h.setVisibility(0);
        if (r6 != v19.c.b(2130972123, getContext(), 2131103203)) goto L5;
    L7:
        r0.h.setText(r5);
        com.larus.utils.e1.c(r0.h, r7);
        return;
    L5:
        if (getContext() == null) goto L7;
        r0.h.setTextColor(ContextCompat.getColor(getContext(), r6));
        goto L7
    }

    public static /* synthetic */ void Y5(NovaTitleBarEx r2, String r3, Integer r4, View.OnClickListener r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        r2.V5(r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View Z5(int r6, boolean r7, ImageView.ScaleType r8, String r9, View.OnClickListener r10) {
        LarusWidgetTitlebarExBinding r0 = getBinding();
        r0.c.setVisibility(0);
        if (r7 == true) goto L5;
        r0.c.setColorFilter(ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
    L5:
        r0.e.setVisibility(8);
        r0.c.setImageResource(r6);
        if (r8 == null) goto L8;
        r0.c.setScaleType(r8);
    L8:
        if (r9 == null) goto L10;
        r0.c.setContentDescription(r9);
    L10:
        com.larus.utils.e1.c(r0.c, r10);
        return getBinding().c;
    }

    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        super.onLayout(r3, r4, r5, r6, r7);
        if (r3 == true) goto L5;
        return;
    L5:
        if (getBinding().e.getRight() <= getBinding().j.getLeft()) goto L12;
        FLogger r8 = FLogger.a;
        r8.d(this.a, "title bar overlap");
        int r9 = (getBinding().e.getWidth() - (getBinding().e.getRight() - getBinding().j.getLeft())) - i5.z();
        int r10 = i5.T();
        if (r9 < r10) goto L9;
        r8.d(this.a, "title bar overlap, candidate " + r9 + " >= minWidth " + r10);
        getBinding().e.setMaxWidth(r9);
        return;
    L9:
        getBinding().e.setMaxWidth(r10);
        getBinding().j.setMaxWidth(getBinding().j.getWidth() - ((r10 - r9) * 2));
        r8.d(this.a, "title bar overlap, candidate " + r9 + " < minWidth " + r10 + ", resize title maxWidth " + getBinding().j.getMaxWidth());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i6(NovaTitleBarEx r3, int r4, ImageView.ScaleType r5, String r6, View.OnClickListener r7, int r8) {
        if ((r8 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r8 & 8) == 0) goto L8;
        r6 = null;
    L8:
        LarusWidgetTitlebarExBinding r9 = r3.getBinding();
        r9.f.setVisibility(0);
        r9.h.setVisibility(8);
        r9.f.setImageResource(r4);
        r9.f.setColorFilter(ContextCompat.getColor(r3.getContext(), v19.c.b(2130972079, r3.getContext(), 2131103136)));
        if (r5 == null) goto L11;
        r9.f.setScaleType(r5);
    L11:
        if (r6 == null) goto L13;
        r9.f.setContentDescription(r6);
    L13:
        com.larus.utils.e1.c(r9.f, r7);
    }

    public static /* synthetic */ View b6(NovaTitleBarEx r6, int r7, boolean r8, ImageView.ScaleType r9, String r10, View.OnClickListener r11, int r12) {
        if ((r12 & 2) == 0) goto L5;
        boolean r2 = false;
    L7:
        if ((r12 & 4) == 0) goto L9;
        ImageView.ScaleType r3 = null;
    L11:
        if ((r12 & 8) == 0) goto L13;
        String r4 = null;
    L15:
        return r6.Z5(r7, r2, r3, r4, r11);
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void k6(NovaTitleBarEx r2, int r3, float r4, ImageView.ScaleType r5, String r6, View.OnClickListener r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r4 = 1.0f;
    L6:
        if ((r8 & 8) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 16) == 0) goto L11;
        r6 = null;
    L11:
        LarusWidgetTitlebarExBinding r9 = r2.getBinding();
        r9.g.setVisibility(0);
        r9.g.setAlpha(r4);
        r9.h.setVisibility(8);
        r9.g.setImageResource(r3);
        r9.g.setColorFilter(ContextCompat.getColor(r2.getContext(), v19.c.b(2130972079, r2.getContext(), 2131103136)));
        if (r5 == null) goto L14;
        r9.g.setScaleType(r5);
    L14:
        if (r6 == null) goto L16;
        r9.g.setContentDescription(r6);
    L16:
        com.larus.utils.e1.c(r9.g, r7);
    }
}
