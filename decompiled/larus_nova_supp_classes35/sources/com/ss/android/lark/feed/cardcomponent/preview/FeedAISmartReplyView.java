package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larksuite.component.ui.imageview.GreyStartLoadingView;
import com.larksuite.framework.utils.UIUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/FeedAISmartReplyView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "iconSize", BuildConfig.FLAVOR, "iconStartMargin", "iconEndMargin", "iconVerticalMargin", "dividerEndMargin", "smartReplyIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "staticIcon", "dynamicIcon", "Lcom/larksuite/component/ui/imageview/GreyStartLoadingView;", "divider", "atKnowledgeAiIconSize", "setSmartReplyMode", BuildConfig.FLAVOR, "setAtKnowledgeAiMode", "isStaticIcon", BuildConfig.FLAVOR, "isDigestQuery", "setViewGone", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedAISmartReplyView extends LinearLayout {

    public static final class a {
    }

    static {
    }

    public FeedAISmartReplyView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public FeedAISmartReplyView(Context r11, AttributeSet r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12);
        int r0 = zz7.b.g(r11, 16);
        int r1 = UIUtils.dp2px(r11, 2.0f);
        int r3 = UIUtils.dp2px(r11, 6.0f);
        int r4 = UIUtils.dp2px(r11, 1.0f);
        int r2 = UIUtils.dp2px(r11, 6.0f);
        int r5 = zz7.b.g(r11, 14);
        AppCompatImageView r6 = new AppCompatImageView(r11);
        r6.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r6.setAdjustViewBounds(true);
        r6.setImageResource(2131253577);
        r6.setVisibility(8);
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(r0, r0);
        r9.gravity = 16;
        r9.setMargins(r1, r4, r3, r4);
        r9.setMarginStart(r1);
        r9.setMarginEnd(r3);
        addView(r6, r9);
        AppCompatImageView r7 = new AppCompatImageView(r11);
        r7.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r7.setAdjustViewBounds(true);
        r7.setImageResource(2131255092);
        r7.setImageTintList(ContextCompat.getColorStateList(r11, 2131102420));
        r7.setVisibility(8);
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(r5, r5);
        r8.gravity = 16;
        r8.setMargins(r1, r4, r3, r4);
        r8.setMarginStart(r1);
        r8.setMarginEnd(r3);
        addView(r7, r8);
        View r10 = new GreyStartLoadingView(r11);
        r10.setVisibility(8);
        addView(r10, r8);
        View r13 = new AppCompatImageView(r11);
        r13.setImageResource(2131256454);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-2, -2);
        r14.gravity = 16;
        r14.setMarginEnd(r2);
        addView(r13, r14);
    }
}
