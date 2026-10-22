package com.ss.android.lark.chat.preview.components.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import se6.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJO\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n¢\u0006\u0002\u0010#J\u0006\u0010+\u001a\u00020\u0018J\u0010\u0010,\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b&\u0010'R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/SpinButton;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView$delegate", "Lkotlin/Lazy;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "imageView$delegate", "setSpinButtonData", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "textColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "fontLevel", "Lcom/ss/android/lark/export/entity/preview/FontLevel;", "iconKey", "iconResource", "iconWidth", "iconHeight", "(Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ThemeColor;Lcom/ss/android/lark/export/entity/preview/FontLevel;Ljava/lang/String;Ljava/lang/Integer;II)V", "animator", "Landroid/animation/ObjectAnimator;", "getAnimator", "()Landroid/animation/ObjectAnimator;", "animator$delegate", "isOriginDegree", BuildConfig.FLAVOR, "startAnim", "setTextContent", "getTextWidthAndHeight", "Lcom/ss/android/lark/tangram/base/node/IVirtualNode$RectSize;", "size", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpinButton extends LinearLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public boolean d;

    public static final class a extends SimpleTarget<Drawable> {
        public final /* synthetic */ ThemeColor a;
        public final /* synthetic */ SpinButton b;

        public final void onResourceReady(Object r5) {
            Drawable r6 = (Drawable) r5;
            if (r6 == null) goto L10;
            ThemeColor r0 = this.a;
            SpinButton r1 = this.b;
            r6.mutate();
            if (r0 == null) goto L7;
            r6.setTint(com.ss.android.lark.export.entity.preview.a.a(r0, r1.getContext(), null));
        L8:
            SpinButton.a(r1).setImageDrawable(r6);
            return;
        L7:
            r6.setTint(r1.getContext().getResources().getColor(2131108626));
            goto L8
        }

        public a(ThemeColor r1, SpinButton r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    private final ObjectAnimator getAnimator() {
        return (ObjectAnimator) this.c.getValue();
    }

    private final ImageView getImageView() {
        return (ImageView) this.b.getValue();
    }

    private final TextView getTextView() {
        return (TextView) this.a.getValue();
    }

    public final void d() {
        boolean r0 = this.d;
        float r1 = 0.0f;
        if (r0 == false) goto L5;
        float r3 = 0.0f;
    L6:
        if (r0 == false) goto L8;
        r1 = 180.0f;
    L8:
        getAnimator().setFloatValues(new float[]{r3, r1});
        getAnimator().start();
        this.d = !this.d;
        return;
    L5:
        r3 = 180.0f;
        goto L6
    }

    public SpinButton(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = LazyKt.lazy(new SpinButton$textView$2(this));
        this.b = LazyKt.lazy(new SpinButton$imageView$2(this));
        addView(getTextView());
        addView(getImageView());
        setGravity(16);
        this.c = LazyKt.lazy(new SpinButton$animator$2(this));
        this.d = true;
    }

    public static final /* synthetic */ ImageView a(SpinButton r0) {
        return r0.getImageView();
    }

    public final s6c.b.a b(s6c.b.a r3) {
        Intrinsics.checkNotNullParameter(r3, "size");
        getTextView().measure(View.MeasureSpec.makeMeasureSpec(UIHelper.dp2px(r3.a), PluginList.LEVEL_NOT_SET), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new s6c.b.a(UIHelper.px2dp(getTextView().getMeasuredWidth()), UIHelper.px2dp(getTextView().getMeasuredHeight()));
    }

    public final void setTextContent(String r2) {
        if (r2 == null) goto L5;
        getTextView().setText(r2);
        return;
    }

    public SpinButton(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = LazyKt.lazy(new SpinButton$textView$2(this));
        this.b = LazyKt.lazy(new SpinButton$imageView$2(this));
        addView(getTextView());
        addView(getImageView());
        setGravity(16);
        this.c = LazyKt.lazy(new SpinButton$animator$2(this));
        this.d = true;
    }

    public SpinButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new SpinButton$textView$2(this));
        this.b = LazyKt.lazy(new SpinButton$imageView$2(this));
        addView(getTextView());
        addView(getImageView());
        setGravity(16);
        this.c = LazyKt.lazy(new SpinButton$animator$2(this));
        this.d = true;
    }

    public final void c(String r4, ThemeColor r5, FontLevel r6, String r7, Integer r8, int r9, int r10) {
        getTextView().setText(r4);
        if (r5 == null) goto L5;
        getTextView().setTextColor(com.ss.android.lark.export.entity.preview.a.a(r5, getContext(), null));
    L6:
        int r0 = h6b.a.a;
        float r11 = h6b.a.c(getContext(), r6);
        getTextView().setTextSize(0, r11);
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(r9, r10);
        r12.leftMargin = UIHelper.dp2px(4.0f);
        getImageView().setLayoutParams(r12);
        if (u.a() == false) goto L24;
        if (r7 != null) goto L10;
    L13:
        boolean r13 = true;
    L15:
        if (r13 == true) goto L20;
        IRequestCreator r14 = ImageLoader.with(getContext()).load(new EncryptImage(r7));
        g6b.a.InterfaceC0223a r15 = g6b.a.a;
        if (r15 == null) goto L19;
        r15.c();
    L19:
        r14.isAsync(false).asDrawable().centerCrop().override(r9, r10).error(2131235841).into(new a(r5, this));
        return;
    L20:
        if (r8 == null) goto L22;
        getImageView().setImageResource(r8.intValue());
        getImageView().setColorFilter(getContext().getResources().getColor(2131108626));
        return;
    L22:
        getImageView().setImageResource(2131235841);
        return;
    L10:
        if (r7.length() == 0) goto L13;
        r13 = false;
        goto L15
    L24:
        return;
    L5:
        getTextView().setTextColor(getContext().getResources().getColor(2131108626));
        goto L6
    }
}
