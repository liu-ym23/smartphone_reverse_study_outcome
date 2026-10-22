package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import android.content.Context;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LatestPhotoShortcutMsgProcessor {
    public final Context a;
    public final Function1<String, Unit> b;
    public final List<String> c;
    public final LatestPhotoShortcutMsgProcessor$broadcastReceiver$1 d;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutMsgProcessor$broadcastReceiver$1] */
    public LatestPhotoShortcutMsgProcessor(Context r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "doDismiss");
        this.a = r4;
        this.b = r5;
        this.c = CollectionsKt.listOf(new String[]{"chat.message.ACTION_SELECT_MENU_SHOW", "chat.message.ACTION_TEXT_ANSWER_SINGLE_BUTTON_CLICK", "chat.actionbar.ACTION_BAR_ITEM_CLICKED", "chat.message.PROMPT_SPAN_CLICK", "chat.message.markdown.ON_LINK_RESOLVER_INVOKE"});
        this.d = new LatestPhotoShortcutMsgProcessor$broadcastReceiver$1(this);
    }
}
