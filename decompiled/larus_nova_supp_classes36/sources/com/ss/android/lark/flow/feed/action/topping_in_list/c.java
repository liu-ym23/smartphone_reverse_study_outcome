package com.ss.android.lark.flow.feed.action.topping_in_list;

import aeb.e;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCardExtraKt;
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
        return 2131101971;
    }

    public final int b(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (UIFeedCardExtraKt.isOnTop(r2) == false) goto L5;
        return 2131237922;
    L5:
        return 2131237921;
    }

    public final int c(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (UIFeedCardExtraKt.isOnTop(r2) == false) goto L5;
        return 2131237940;
    L5:
        return 2131237939;
    }

    public final String d(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return e(r2);
    }

    public final String e(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (UIFeedCardExtraKt.isOnTop(r2) == false) goto L5;
        String r3 = UIHelper.getString(2131890023);
        Intrinsics.checkNotNull(r3);
        return r3;
    L5:
        String r4 = UIHelper.getString(2131890019);
        Intrinsics.checkNotNull(r4);
        return r4;
    }
}
