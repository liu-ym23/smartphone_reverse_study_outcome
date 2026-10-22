package com.bytedance.android.live.core.arch.mvi.widgetcompat;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.presenter.TopRightBannerPresenter;
import com.bytedance.android.livesdk.utils.IView;
import com.bytedance.android.livesdk.utils.LiveViewState;
import com.bytedance.android.livesdk.utils.b2;
import com.bytedance.android.livesdk.utils.g2;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\u0014\b\u0002\u0010\u0006*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0005*\b\b\u0003\u0010\b*\u00020\u00072\u00020\t2\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\nB\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/core/arch/mvi/widgetcompat/MVIDataWidget;", "Lcom/bytedance/android/livesdk/utils/g2;", "STATE", "", "INTENT", "Lcom/bytedance/android/livesdk/utils/b2;", "M", "Lcom/bytedance/live/datacontext/DataContext;", "DATA", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/utils/IView;", "<init>", "()V", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MVIDataWidget<STATE extends g2, INTENT, M extends b2<INTENT, STATE>, DATA extends DataContext> extends LiveRecyclableWidget implements IView<STATE, INTENT, M> {
    public TopRightBannerPresenter a;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onInit(Object[] r1) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        TopRightBannerPresenter r0 = this.a;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public MVIDataWidget() {
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        wq((g2) r1);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onLoad(Object[] r3) {
        TopRightBannerPresenter r4 = ((ActivityTopBannerWidget) this).h;
        this.a = r4;
        if (r4 == null) goto L9;
        LiveViewState r0 = (LiveViewState) r4.m.getValue();
        Intrinsics.checkNotNullParameter(r0, "liveViewState");
        Intrinsics.checkNotNullParameter(r0, "liveViewState");
        r0.observe(this, this);
        TopRightBannerPresenter r1 = this.a;
        if (r1 == null) goto L7;
        r1.b(new a(this));
    L7:
        r4.e();
        return;
    }

    public void wq(STATE r2) {
        ((ActivityTopBannerWidget) this).Lq(r2);
    }

    public final void xq(ActivityTopBannerViewIntent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        TopRightBannerPresenter r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }
}
