package com.ss.android.lark.flow.feed.component.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.feed.cardcomponent.preview.c;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends FeedCardComponent<C0045a, FlowPreviewView> {
    public final Context c;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.component.preview.a$a, reason: collision with other inner class name */
    public static final class C0045a {
        public final c a;
        public final com.ss.android.lark.feed.cardcomponent.preview.a.b b;
        public final com.ss.android.lark.flow.feed.component.text_layer.a.C0046a c;

        public C0045a(com.ss.android.lark.feed.cardcomponent.preview.a.b r2, com.ss.android.lark.flow.feed.component.text_layer.a.C0046a r3) {
            this(c.g, r2, r3);
        }

        public C0045a(c r2, com.ss.android.lark.feed.cardcomponent.preview.a.b r3, com.ss.android.lark.flow.feed.component.text_layer.a.C0046a r4) {
            Intrinsics.checkNotNullParameter(r2, "reactionParam");
            Intrinsics.checkNotNullParameter(r3, "digestParams");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public final View a() {
        FlowPreviewView r0 = new FlowPreviewView(getContext());
        r0.setGravity(16);
        return r0;
    }

    public final ViewGroup.MarginLayoutParams b() {
        ViewGroup.MarginLayoutParams r0 = super.b();
        r0.height = UIUtils.dp2px(getContext(), 22.0f);
        r0.width = 0;
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

    public final void d(C0045a r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        ((FlowPreviewView) c()).a(r4.a, r4.b, r4.c);
    }
}
