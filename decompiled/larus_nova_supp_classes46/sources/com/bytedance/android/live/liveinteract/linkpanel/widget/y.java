package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y<T> implements Observer {
    public final /* synthetic */ LinkPanelTopBarWidget a;

    public y(LinkPanelTopBarWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Integer r6 = (Integer) r5;
        if (this.a.a == false) goto L6;
        return;
    L6:
        if (r6 != null) goto L9;
    L14:
        if (r6 != null) goto L17;
    L22:
        if (r6 != null) goto L25;
        return;
    L25:
        if (r6.intValue() != 2) goto L33;
        ViewGroup r7 = this.a.b;
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L29:
        ((TextView) r7.findViewById(2131362297)).setText(2131919271);
        return;
    L33:
        return;
    L17:
        if (r6.intValue() != 1) goto L22;
        ViewGroup r8 = this.a.b;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L21:
        ((TextView) r8.findViewById(2131362297)).setText(2131917526);
        return;
    L9:
        if (r6.intValue() != 0) goto L14;
        ViewGroup r9 = this.a.b;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L13:
        ((TextView) r9.findViewById(2131362297)).setText(2131923154);
    }
}
