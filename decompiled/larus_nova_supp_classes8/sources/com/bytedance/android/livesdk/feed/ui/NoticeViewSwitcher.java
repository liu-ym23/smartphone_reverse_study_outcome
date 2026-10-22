package com.bytedance.android.livesdk.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ViewSwitcher;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/feed/ui/NoticeViewSwitcher;", "Landroid/widget/ViewSwitcher;", "", "text", "", "setText", "setCurrentText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NoticeViewSwitcher extends ViewSwitcher {

    public static final class a implements ViewSwitcher.ViewFactory {
        public final /* synthetic */ NoticeViewSwitcher a;

        public a(NoticeViewSwitcher r1) {
            this.a = r1;
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public final View makeView() {
            return new NoticeView(this.a.getContext(), null, 6, 0);
        }
    }

    public final void setCurrentText(CharSequence r2) {
        Object r0 = getCurrentView();
        if (r0 == null) goto L7;
        ((NoticeView) r0).setText(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.ui.NoticeView");
    }

    public final void setText(CharSequence r2) {
        Object r0 = getNextView();
        if (r0 == null) goto L7;
        ((NoticeView) r0).setText(r2);
        showNext();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.ui.NoticeView");
    }

    public NoticeViewSwitcher(Context r1, AttributeSet r2) {
        super(r1, r2);
        setFactory(new a(this));
        setInAnimation(AnimationUtils.loadAnimation(getContext(), 2130772001));
        setOutAnimation(AnimationUtils.loadAnimation(getContext(), 2130772002));
    }

    @Override // android.widget.ViewSwitcher, android.widget.ViewAnimator, android.view.ViewGroup
    public final void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        if ((r2 instanceof NoticeView) == false) goto L7;
        super.addView(r2, r3, r4);
        return;
    L7:
        throw new IllegalArgumentException("NoticeViewSwitcher children must be instances of NoticeView".toString());
    }
}
