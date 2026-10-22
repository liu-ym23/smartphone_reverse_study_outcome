package com.ss.android.lark.flow.feed.long_click;

import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.shared.page.binder2.o;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements o {
    public e() {
    }

    public final UDDialog a(View r9, UIFeedCard r10, ueb.a r11, LinkedHashMap<FeedActionType, aeb.c> r12, aeb.a r13, int r14) {
        Intrinsics.checkNotNullParameter(r9, "parentView");
        Intrinsics.checkNotNullParameter(r10, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r11, "itemContainer");
        Intrinsics.checkNotNullParameter(r12, "feedActionMap");
        Intrinsics.checkNotNullParameter(r13, "actionStatusListener");
        return new FlowFeedDialogBuilder(r9, r10, r11, r12, r13, r14).c();
    }
}
