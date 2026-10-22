package com.xiphias.browser.scanner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "handleInterceptEvent", "Lkotlin/Function0;", "", "getHandleInterceptEvent", "()Lkotlin/jvm/functions/Function0;", "setHandleInterceptEvent", "(Lkotlin/jvm/functions/Function0;)V", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onInterceptHoverEvent", "event", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScannerContainerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function0<Unit> f16313a;

    public ScannerContainerView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        this.f16313a = $$Lambda$ScannerContainerView$d7SaPv0Ur0b6yg7VkbBGIFhe1bk.INSTANCE;
    }

    private static final Unit a() {
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$d7SaPv0Ur0b6yg7VkbBGIFhe1bk() {
        return a();
    }

    public final Function0<Unit> getHandleInterceptEvent() {
        return this.f16313a;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent r2) {
        this.f16313a.invoke();
        return super.onInterceptHoverEvent(r2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        this.f16313a.invoke();
        return super.onInterceptTouchEvent(r2);
    }

    public final void setHandleInterceptEvent(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.f16313a = r4;
    }
}
