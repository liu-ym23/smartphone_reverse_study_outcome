package com.ss.android.lark.message.card.pin;

import android.view.View;
import android.widget.FrameLayout;
import com.larksuite.component.card.cardcontainer.CardImpl;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.message.card.view.MaxHeightInterruptEventScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends iya.b {
    public static final /* synthetic */ int i = 0;
    public final View a;
    public final bz7.a b;
    public final LKUIRoundableLayout c;
    public final MaxHeightInterruptEventScrollView d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final View g;
    public final FrameLayout h;

    public static final class a {
    }

    static {
    }

    public d(View r1, CardImpl r2) {
        this.a = r1;
        this.b = r2;
        this.c = r1.findViewById(2131384813);
        this.d = (MaxHeightInterruptEventScrollView) r1.findViewById(2131385238);
        this.e = (FrameLayout) r1.findViewById(2131374285);
        this.f = (FrameLayout) r1.findViewById(2131377472);
        this.g = r1.findViewById(2131379672);
        this.h = (FrameLayout) r1.findViewById(2131372777);
    }
}
