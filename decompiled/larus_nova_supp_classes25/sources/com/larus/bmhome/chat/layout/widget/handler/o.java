package com.larus.bmhome.chat.layout.widget.handler;

import android.content.Context;
import android.view.ViewGroup;
import com.larus.bmhome.utils.t2;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.HtmlBlock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o implements pw8.b {
    public final Message a;
    public final long b;

    public final pw8.a b(Context r1, int r2, int r3, ViewGroup r4, uvc.b r5, Boolean r6, lw8.h r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "currentViewGroup");
        Intrinsics.checkNotNullParameter(r5, "node");
        return null;
    }

    public final int priority() {
        return 13;
    }

    public final boolean c(uvc.b r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        if ((r2 instanceof HtmlBlock) == false) goto L9;
        int r0 = vh8.a.a;
        HtmlBlock r3 = (HtmlBlock) r2;
        if (vh8.a.b(r3.h) == false) goto L9;
        int r1 = t2.a;
        if (Intrinsics.areEqual(t2.b(r3.h), "video-group-scrollable") == false) goto L9;
        return true;
    L9:
        return false;
    }

    public o(Message r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a = r2;
        this.b = r3;
    }

    public final pw8.a a(Context r1, int r2, uvc.b r3, Boolean r4, lw8.h r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "node");
        return new n(r1, r3, this);
    }
}
