package com.bytedance.android.live.messagewindow.tempdraggablewindow;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.room.api.messagewindow.manager.IFloatingBannerManager;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import d90.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t70.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/messagewindow/tempdraggablewindow/TempDraggableTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/d;", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TempDraggableTetris extends LiveTetris<d> {
    public final Disposable o;

    public final void O() {
    }

    public TempDraggableTetris() {
        this.o = Disposables.disposed();
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onDestroy();
        this.o.dispose();
    }

    public final View G(k r3) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        IFloatingBannerManager r0 = jc1.k.n(IMsgWindowService.class).getFloatingBannerManager(K().h);
        if (r0 != null) goto L6;
        ALogger.e("TempDraggableTetris", "FloatingBannerManager is null!");
        return new View(r3.getContext());
    L6:
        ViewGroup r4 = r0.getRootContainer();
        if (r4 == null) goto L9;
        ViewGroup r5 = UtilityKotlinExtentionsKt.p(r4);
    L10:
        if (r5 == null) goto L15;
        ViewGroup r6 = r0.getRootContainer();
        if (r6 == null) goto L15;
        UtilityKotlinExtentionsKt.q(r6);
    L15:
        return r0.getRootContainer();
    L9:
        r5 = null;
        goto L10
    }
}
