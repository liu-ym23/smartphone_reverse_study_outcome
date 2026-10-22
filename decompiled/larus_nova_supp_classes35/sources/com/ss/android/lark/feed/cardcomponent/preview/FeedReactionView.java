package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0007R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/FeedReactionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "reactionIconSizeDp", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "reactionIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "reactionCountText", "Landroid/widget/TextView;", "reactionIconSize", "reactionXPadding", "reactionNoBackgroundXPadding", "reactionYPadding", "value", BuildConfig.FLAVOR, "isShowBackground", "()Z", "setShowBackground", "(Z)V", "initView", BuildConfig.FLAVOR, "updateBackground", "getReactionIcon", "setReactionCount", "count", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedReactionView extends LinearLayout {
    public AppCompatImageView a;
    public TextView b;
    public final int c;
    public final int d;
    public final int e;
    public boolean f;

    public FeedReactionView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 0, 14);
    }

    public FeedReactionView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 0, 12);
    }

    public FeedReactionView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, r10, 0, 8);
    }

    public final void a() {
        if (this.f == false) goto L5;
        int r0 = this.c;
    L6:
        int r1 = this.e;
        setPadding(r0, r1, r0, r1);
        if (this.f == false) goto L9;
        setBackgroundResource(2131235358);
        return;
    L9:
        setBackground(null);
        return;
    L5:
        r0 = this.d;
        goto L6
    }

    public final AppCompatImageView getReactionIcon() {
        AppCompatImageView r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("reactionIcon");
        return null;
    L6:
        return r0;
    }

    public final void setReactionCount(int r5) {
        TextView r1 = null;
        if (r5 <= 1) goto L12;
        TextView r0 = this.b;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("reactionCountText");
        r0 = null;
    L7:
        r0.setVisibility(0);
        TextView r2 = this.b;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("reactionCountText");
    L11:
        r1.setText(String.valueOf(r5));
        return;
    L10:
        r1 = r2;
        goto L11
    L12:
        TextView r6 = this.b;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("reactionCountText");
    L16:
        r1.setVisibility(8);
        return;
    L15:
        r1 = r6;
        goto L16
    }

    public final void setShowBackground(boolean r2) {
        if (this.f != r2) goto L5;
        return;
    L5:
        this.f = r2;
        a();
    }

    public FeedReactionView(Context r4, AttributeSet r5, int r6, int r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r6 = 0;
    L9:
        if ((r8 & 8) == 0) goto L11;
        r7 = 14;
    L11:
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        int r9 = zz7.b.g(r4, r7);
        this.c = UIHelper.dp2px(6.0f);
        this.d = UIHelper.dp2px(3.0f);
        this.e = UIHelper.dp2px(2.0f);
        this.f = true;
        AppCompatImageView r10 = new AppCompatImageView(r4);
        r10.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r10.setAdjustViewBounds(true);
        this.a = r10;
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, r9);
        r11.gravity = 16;
        Unit r2 = Unit.INSTANCE;
        addView(r10, r11);
        TextView r12 = new TextView(r4);
        r12.setGravity(17);
        zz7.a.c(r12, 10);
        r12.setTextColor(UDColorUtils.getColor(r4, 2131106607));
        this.b = r12;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, r9);
        r13.gravity = 16;
        r13.leftMargin = UIHelper.dp2px(2.0f);
        addView(r12, r13);
        a();
    }
}
