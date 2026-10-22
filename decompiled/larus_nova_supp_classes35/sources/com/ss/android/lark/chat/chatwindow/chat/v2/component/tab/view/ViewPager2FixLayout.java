package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/view/ViewPager2FixLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewPagerControl", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/view/ViewPager2FixLayout$IViewPagerControl;", "getViewPagerControl", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/view/ViewPager2FixLayout$IViewPagerControl;", "setViewPagerControl", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/view/ViewPager2FixLayout$IViewPagerControl;)V", "startX", "startY", "dispatchTouchEvent", BuildConfig.FLAVOR, "ev", "Landroid/view/MotionEvent;", "resetEvent", BuildConfig.FLAVOR, "IViewPagerControl", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewPager2FixLayout extends FrameLayout {
    public int a;
    public int b;

    public interface a {
    }

    public ViewPager2FixLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ViewPager2FixLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final a getViewPagerControl() {
        return null;
    }

    public final void setViewPagerControl(a r1) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        int r0 = r4.getAction() & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        if (r0 != 0) goto L5;
        this.a = (int) r4.getX();
        this.b = (int) r4.getY();
    L15:
        return super.dispatchTouchEvent(r4);
    L5:
        if (r0 != 1) goto L7;
    L12:
        this.a = 0;
        this.b = 0;
        goto L15
    L7:
        if (r0 != 2) goto L9;
        int r1 = (int) r4.getX();
        int r2 = (int) r4.getY();
        Math.abs(r1 - this.a);
        Math.abs(r2 - this.b);
        goto L15
    L9:
        if (r0 == 3) goto L12;
        goto L12
    }

    public ViewPager2FixLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ViewPager2FixLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
