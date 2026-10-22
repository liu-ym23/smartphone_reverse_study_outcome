package com.ss.android.lark.flow.feed.component.title;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends FeedCardComponent<C0048b, TextView> {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.component.title.b$b, reason: collision with other inner class name */
    public static final class C0048b {
        public final String a;
        public final boolean b;
        public final int c;

        public C0048b(String r2, boolean r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "titleText");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public final View a() {
        TextView r0 = new TextView(getContext());
        r0.setTextColor(UDColorUtils.getColor(r0.getContext(), 2131106622));
        r0.setTextSize(0, zz7.b.h(r0.getContext(), 17));
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setSingleLine(true);
        return r0;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
