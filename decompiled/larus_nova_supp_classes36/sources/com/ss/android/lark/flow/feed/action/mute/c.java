package com.ss.android.lark.flow.feed.action.mute;

import aeb.e;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements e {
    public c() {
    }

    public final int a() {
        return 2131101937;
    }

    public final int getBackground() {
        return 2131101969;
    }

    public final int b(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (r2.isRemind() == false) goto L5;
        return 2131237920;
    L5:
        return 2131237914;
    }

    public final int c(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (r2.isRemind() == false) goto L5;
        return 2131237928;
    L5:
        return 2131253828;
    }

    public final String d(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return e(r2);
    }

    public final String e(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (r2.isRemind() == false) goto L5;
        String r3 = UIHelper.getString(2131890017);
        Intrinsics.checkNotNull(r3);
        return r3;
    L5:
        String r4 = UIHelper.getString(2131890022);
        Intrinsics.checkNotNull(r4);
        return r4;
    }
}
