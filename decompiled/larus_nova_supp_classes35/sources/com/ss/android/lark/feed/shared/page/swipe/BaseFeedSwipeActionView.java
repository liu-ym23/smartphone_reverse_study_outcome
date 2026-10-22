package com.ss.android.lark.feed.shared.page.swipe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\b\u0010\u0018\u001a\u00020\u0019H$J\"\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u0015\u001a\u00020\nH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H&J\b\u0010!\u001a\u00020\u0019H&J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/swipe/BaseFeedSwipeActionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "feedActionHandler", "Lcom/ss/android/lark/feed/export/feedcard/action/IFeedActionHandler;", "getFeedActionHandler", "()Lcom/ss/android/lark/feed/export/feedcard/action/IFeedActionHandler;", "setFeedActionHandler", "(Lcom/ss/android/lark/feed/export/feedcard/action/IFeedActionHandler;)V", "value", "bgColor", "getBgColor", "()I", "initView", BuildConfig.FLAVOR, "bindAction", "icon", "Landroid/graphics/drawable/Drawable;", "text", BuildConfig.FLAVOR, "getActionName", BuildConfig.FLAVOR, "preMeasure", "setOnlyShowText", "isOnlyShowText", BuildConfig.FLAVOR, "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseFeedSwipeActionView extends LinearLayout {
    public aeb.d a;
    public int b;

    public abstract void b();

    public abstract CharSequence getActionName();

    public void setOnlyShowText(boolean r1) {
    }

    public final int getBgColor() {
        return this.b;
    }

    public final aeb.d getFeedActionHandler() {
        return this.a;
    }

    public BaseFeedSwipeActionView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setFeedActionHandler(aeb.d r1) {
        this.a = r1;
    }

    public BaseFeedSwipeActionView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public BaseFeedSwipeActionView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        b();
    }

    public void a(Drawable r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "icon");
        Intrinsics.checkNotNullParameter(r3, "text");
        this.b = r4;
    }
}
