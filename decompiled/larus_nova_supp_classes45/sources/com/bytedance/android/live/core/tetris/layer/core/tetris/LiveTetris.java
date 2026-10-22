package com.bytedance.android.live.core.tetris.layer.core.tetris;

import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.ServiceWidgetElement;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.ies.sdk.widgets.Widget;
import h70.b;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t70.f;
import t70.i;
import t70.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Lh70/b;", "T", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LiveTetris<T extends b> extends Tetris<T> {
    public LiveTetris() {
    }

    public final void S(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        H(r2);
        if ((r2 instanceof WidgetElement) == false) goto L6;
        ((WidgetElement) r2).l();
        return;
    L6:
        if ((r2 instanceof ServiceWidgetElement) == false) goto L10;
        ((ServiceWidgetElement) r2).m();
        return;
    }

    public final <T> void T(Class<T> r2, Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventClass");
        Intrinsics.checkNotNullParameter(r3, "func");
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new f(r3));
    }

    public static WidgetElement R(LiveTetris r2, Widget r3, ViewGroup r4) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "widget");
        Intrinsics.checkNotNullParameter(r4, "elementView");
        return (WidgetElement) r2.F(new j(false, false, r3), r4);
    }

    public final WidgetElement P(Class<? extends Widget> r2, ViewGroup r3, boolean r4, Object[] r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "widgetClass");
        Intrinsics.checkNotNullParameter(r3, "elementView");
        i r0 = new i(r4, r6, r2);
        if (r5 == null) goto L6;
        r0.d(r5);
    L6:
        return (WidgetElement) F(r0, r3);
    }

    public static /* synthetic */ WidgetElement Q(LiveTetris r6, Class r7, ViewGroup r8, boolean r9, Object[] r11, int r12) {
        if ((r12 & 4) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r12 & 8) == 0) goto L10;
        r11 = null;
    L10:
        return r6.P(r7, r8, r3, r11, false);
    L5:
        r3 = r9;
        goto L7
    }
}
