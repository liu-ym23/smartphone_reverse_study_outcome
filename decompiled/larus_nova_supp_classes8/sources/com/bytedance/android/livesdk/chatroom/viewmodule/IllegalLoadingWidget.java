package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/IllegalLoadingWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lo70/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IllegalLoadingWidget extends LiveRecyclableWidget implements o70.a {
    public LottieAnimationView a;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566665;
    }

    public final void onUnload() {
    }

    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(yn1.e.class);
    }

    public IllegalLoadingWidget() {
    }

    public void onEvent(o70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof yn1.e) == false) goto L28;
        int r3 = ((yn1.e) r2).a.s();
        if (r3 == 2) goto L20;
        if (r3 != 3) goto L9;
    L13:
        LottieAnimationView r4 = this.a;
        if (r4 == null) goto L16;
        r4.setVisibility(8);
    L16:
        LottieAnimationView r5 = this.a;
        if (r5 == null) goto L29;
        r5.cancelAnimation();
        return;
    L29:
        return;
    L9:
        if (r3 == 15) goto L20;
        if (r3 == 16) goto L13;
        return;
    L20:
        if (com.bytedance.android.live.core.utils.z.e(((Widget) this).dataCenter, false) == false) goto L31;
        LottieAnimationView r6 = this.a;
        if (r6 == null) goto L24;
        r6.setVisibility(0);
    L24:
        LottieAnimationView r7 = this.a;
        if (r7 == null) goto L32;
        r7.playAnimation();
        return;
    L32:
        return;
    L31:
        return;
    }

    public final void onInit(Object[] r2) {
        this.a = ((Widget) this).containerView.findViewById(2131374911);
    }

    public final void onLoad(Object[] r2) {
        LottieAnimationView r3 = this.a;
        if (r3 == null) goto L5;
        r3.setImageAssetsFolder("images/");
    L5:
        LottieAnimationView r4 = this.a;
        if (r4 == null) goto L8;
        r4.setAnimation("illegal_live_shadow_loading.json");
    L8:
        LottieAnimationView r5 = this.a;
        if (r5 == null) goto L12;
        r5.loop(true);
        return;
    }
}
