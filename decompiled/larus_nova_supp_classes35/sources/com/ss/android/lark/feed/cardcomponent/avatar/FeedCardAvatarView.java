package com.ss.android.lark.feed.cardcomponent.avatar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.decoration.avatar.DecoratedAvatar;
import com.larksuite.component.ui.imageview.LKUIBadgeView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.feed.app.view.AdvanceAvatarView;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\nJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&H\u0002J\u000e\u0010'\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&J<\u0010(\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\u001d2\u0006\u0010,\u001a\u00020-2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010.\u001a\u00020-J\u001a\u0010/\u001a\u00020\u00182\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u00010&J\f\u00103\u001a\u00020\u0005*\u000204H\u0002J\f\u00103\u001a\u00020\u0005*\u00020\u0005H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/avatar/FeedCardAvatarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "avatarSize", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;I)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "urgentBackground", "Landroid/view/View;", "avatarView", "Lcom/ss/android/lark/feed/app/view/AdvanceAvatarView;", "decorateAvatarView", "Lcom/larksuite/component/decoration/avatar/DecoratedAvatar;", "badgeView", "Lcom/larksuite/component/ui/imageview/LKUIBadgeView;", "miniIconView", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "miniAvatarView", "decorationViewIndex", "init", BuildConfig.FLAVOR, "createUrgentBackgroundView", "createDecorateAvatarView", "bindDecorateAvatarView", "imageKey", BuildConfig.FLAVOR, "createBadgeView", "bindBadgeView", "remindUIInfo", "Lcom/ss/android/lark/feed/app/viewentity/RemindUIInfo;", "createThreadIconView", "createThreadMiniAvatarView", "bindThreadMiniAvatarView", "avatarModel", "Lcom/larksuite/component/ui/avatar/AvatarModel;", "bindAvatarView", "bindAvatar", "miniAvatarModel", "Lcom/larksuite/component/ui/badge/miniicon/MiniIconModel;", "decorateImageKey", "isUrgent", BuildConfig.FLAVOR, "isShowBadge", "bindMiniIcon", "miniIconDrawable", "Landroid/graphics/drawable/Drawable;", "miniIconModel", "dp2px", BuildConfig.FLAVOR, "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedCardAvatarView extends ConstraintLayout {
    public static final Lazy<Boolean> i = null;
    public View a;
    public AdvanceAvatarView b;
    public DecoratedAvatar c;
    public LKUIBadgeView d;
    public LKUIRoundedImageView2 e;
    public AdvanceAvatarView f;
    public int g;
    public int h;

    public static final class a {
    }

    static {
        i = LazyKt.lazy(FeedCardAvatarView$Companion$feedAvatarRollbackEnabled$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View, android.widget.ImageView, com.ss.android.lark.feed.app.view.AdvanceAvatarView] */
    public FeedCardAvatarView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, 0);
        this.h = 48;
        ?? r1 = new AdvanceAvatarView(r6);
        r1.setId(2131381508);
        r1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(b.g(r6, r8), b.g(r6, r8));
        r2.topToTop = 0;
        r2.bottomToBottom = 0;
        r2.leftToLeft = 0;
        r2.setMargins(UIHelper.dp2px(16.0f), 0, 0, 0);
        r1.setLayoutParams(r2);
        this.b = r1;
        this.h = r8;
        this.g++;
        addView(r1);
        View r9 = new View(r6);
        r9.setBackgroundResource(2131256436);
        this.a = r9;
        int r10 = (UIHelper.dp2px(52.0f) + b.g(r6, this.h)) - UIHelper.dp2px(48);
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(r10, r10);
        r11.topToTop = 0;
        r11.bottomToBottom = 0;
        r11.leftToLeft = 0;
        r11.setMarginStart(UIHelper.dp2px(14.0f));
        addView(this.a, r11);
        View r12 = this.a;
        if (r12 == null) goto L6;
        r12.setVisibility(8);
        return;
    }
}
