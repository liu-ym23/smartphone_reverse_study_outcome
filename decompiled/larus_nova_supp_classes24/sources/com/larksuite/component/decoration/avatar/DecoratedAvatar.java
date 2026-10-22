package com.larksuite.component.decoration.avatar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ \u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u001a\u0010 \u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\"\u001a\u00020\u0016J,\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$*\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H$0'H\u0082\b¢\u0006\u0002\u0010(R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larksuite/component/decoration/avatar/DecoratedAvatar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "decorationView", "Landroid/widget/ImageView;", "getDecorationView", "()Landroid/widget/ImageView;", "setDecorationView", "(Landroid/widget/ImageView;)V", "avatarView", "getAvatarView", "setAvatarView", "decorationElevation", "", "initDecorationView", "", "addAvatarView", "initAvatarView", "initAIAvatarView", "bgView", "loadSdkDecoration", "imageKey", "", "widthPx", "heightPx", "loadPassThroughDecoration", "fsUnit", "clearDecoration", "use", "R", "Landroid/content/res/TypedArray;", "block", "Lkotlin/Function1;", "(Landroid/content/res/TypedArray;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "avatar-decoration_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DecoratedAvatar extends FrameLayout {
    public ImageView a;
    public ImageView b;

    public static final class a {
    }

    static {
    }

    public DecoratedAvatar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DecoratedAvatar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final ImageView getAvatarView() {
        return this.b;
    }

    public final ImageView getDecorationView() {
        return this.a;
    }

    public final void a(ImageView r3) {
        if (r3 == null) goto L9;
        ImageView r0 = this.b;
        if (r0 == null) goto L7;
        removeView(r0);
    L7:
        r3.getParent();
        this.b = r3;
        addView(r3, new FrameLayout.LayoutParams(-1, -1));
        return;
    }

    public final void b(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        String r1 = r3;
    L10:
        if (r1 == null) goto L14;
        ImageLoader.with(getContext()).load(new EncryptImage(r3)).override(getMeasuredWidth(), getMeasuredHeight()).into(this.a);
        return;
    L14:
        return;
    L9:
        r1 = null;
        goto L10
    L6:
        r0 = false;
        goto L7
    }

    public final void setAvatarView(ImageView r1) {
        this.b = r1;
    }

    public final void setDecorationView(ImageView r1) {
        this.a = r1;
    }

    public DecoratedAvatar(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130969726}, r6, 0);
        int r0 = r7.getResourceId(0, -1);
        if ((-1) == r0) goto L5;
        View r8 = LayoutInflater.from(r4).inflate(r0, this, false);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.widget.ImageView");
        a((ImageView) r8);
    L5:
        Unit r9 = Unit.INSTANCE;
        r7.recycle();
        ImageView r10 = new ImageView(getContext());
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r10.setElevation(1.0f);
        this.a = r10;
        addView(r10);
    }

    public /* synthetic */ DecoratedAvatar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
