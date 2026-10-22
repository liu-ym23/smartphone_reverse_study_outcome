package com.ss.android.lark.flow.feed.component.text_layer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends FeedCardComponent<C0046a, FlowTextLayerView> {
    public final Context c;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.component.text_layer.a$a, reason: collision with other inner class name */
    public static final class C0046a {
        public final boolean a;
        public final int b;

        public C0046a(boolean r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final View a() {
        return new FlowTextLayerView(getContext());
    }

    public final ViewGroup.MarginLayoutParams b() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -2);
        r0.gravity = 16;
        return r0;
    }

    public Context getContext() {
        return this.c;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = r2;
    }
}
