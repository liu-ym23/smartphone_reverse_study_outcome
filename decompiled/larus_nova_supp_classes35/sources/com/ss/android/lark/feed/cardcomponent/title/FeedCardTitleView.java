package com.ss.android.lark.feed.cardcomponent.title;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larksuite.framework.ui.SpareLayout;
import com.ss.android.lark.feed.cardcomponent.title.specialfocus.SpecialFocusComponent;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0002JB\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001b2\u0006\u0010#\u001a\u00020\u00172\b\b\u0002\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!J\f\u0010'\u001a\u00020%*\u00020(H\u0002J\b\u0010)\u001a\u00020*H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/title/FeedCardTitleView;", "Lcom/larksuite/framework/ui/SpareLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "titleComponent", "Lcom/ss/android/lark/feed/cardcomponent/title/titleview/TitleViewComponent;", "specialFocusComponent", "Lcom/ss/android/lark/feed/cardcomponent/title/specialfocus/SpecialFocusComponent;", "customStatusComponent", "Lcom/ss/android/lark/feed/cardcomponent/title/customstatus/CustomStatusComponent;", "feedTagComponent", "Lcom/ss/android/lark/feed/cardcomponent/title/feedtag/FeedTagComponent;", "init", BuildConfig.FLAVOR, "addTitleView", "addSpecialFocusView", "bindSpecialFocus", "isSpecialFocus", BuildConfig.FLAVOR, "addCustomStatusView", "bindCustomStatus", "customStatusDrawable", "Landroid/graphics/drawable/Drawable;", "addFeedTagView", "bindFeedTag", "drawable", "bindTitleView", "titleText", BuildConfig.FLAVOR, "feedTagDrawable", "isBoldDisplay", "titleTextSize", BuildConfig.FLAVOR, "bindTitleViewText", "dp2px", BuildConfig.FLAVOR, "generateLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedCardTitleView extends SpareLayout {
    public wdb.a b;
    public SpecialFocusComponent c;
    public udb.a d;
    public vdb.a e;

    public static final class a {
    }

    static {
    }

    public FeedCardTitleView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedCardTitleView(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, 0);
        setFirstViewMinWidth(b.g(getContext(), 36));
        this.b = new wdb.a(getContext());
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -2);
        r8.gravity = 16;
        wdb.a r2 = this.b;
        vdb.a r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleComponent");
        r2 = null;
    L5:
        addView(r2.c(), 0, r8);
        this.c = new SpecialFocusComponent(getContext());
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(b.g(getContext(), 18), b.g(getContext(), 18));
        r9.leftMargin = UIHelper.dp2px(4.0f);
        r9.gravity = 16;
        SpecialFocusComponent r4 = this.c;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("specialFocusComponent");
        r4 = null;
    L8:
        addView(r4.c(), r9);
        this.d = new udb.a(getContext());
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2);
        r10.leftMargin = UIHelper.dp2px(8.0f);
        r10.gravity = 16;
        udb.a r5 = this.d;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("customStatusComponent");
        r5 = null;
    L11:
        addView(r5.c(), r10);
        this.e = new vdb.a(getContext());
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.leftMargin = UIHelper.dp2px(4.0f);
        r11.gravity = 16;
        vdb.a r12 = this.e;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("feedTagComponent");
    L15:
        addView(r3.c(), r11);
        return;
    L14:
        r3 = r12;
        goto L15
    }
}
