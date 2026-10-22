package com.bytedance.android.live.platformplayer.panel;

import android.app.Dialog;
import android.view.View;
import com.bytedance.android.livesdk.pannel.SheetBaseDialog;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.LiveStandardSheetDialog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import zg1.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o {
    public final CompositeDisposable a;
    public f0 b;
    public final StreamAutoAdapterPanelObserver$giftPanelObserver$1 c;
    public final StreamAutoAdapterService d;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.platformplayer.panel.StreamAutoAdapterPanelObserver$giftPanelObserver$1] */
    public o() {
        StreamAutoAdapterService r0 = StreamAutoAdapterService.o;
        Intrinsics.checkNotNullParameter(r0, "adapterService");
        this.d = r0;
        this.a = new CompositeDisposable();
        this.c = new StreamAutoAdapterPanelObserver$giftPanelObserver$1(this);
    }

    public static final void a(o r3, ds0.b r4) {
        r3.d.getClass();
        if (StreamAutoAdapterService.n == true) goto L6;
        r3.d.getClass();
        StreamAutoAdapterService.g(r4);
        return;
    L6:
        if (Intrinsics.areEqual(r4.b, "open") == false) goto L25;
        LiveStandardSheetDialog r0 = (Dialog) r4.d.get();
        if (r0 == null) goto L17;
        if ((r0 instanceof LiveStandardSheetDialog) == false) goto L14;
        ((SheetBaseDialog) r0).f = new m(r3, r4);
    L14:
        if ((r0 instanceof LiveBottomSheetDialog) == false) goto L17;
        ((LiveBottomSheetDialog) r0).setStateCallback(new n(r3, r4));
    L17:
        if (r4.c != 0) goto L25;
        Dialog r1 = r4.d.get();
        if (r1 != null) goto L21;
        r3.d.e("listenCommonPanel failed! " + r4.getType() + " with null dialog!");
        return;
    L21:
        View r2 = r1.findViewById(r4.e);
        if (r2 != null) goto L24;
        r3.d.e("listenCommonPanel failed! " + r4.getType() + " get root view failed!");
        return;
    L24:
        r2.post(new g(r3, r4, r2));
        return;
    L25:
        r3.d.c(r4);
    }
}
