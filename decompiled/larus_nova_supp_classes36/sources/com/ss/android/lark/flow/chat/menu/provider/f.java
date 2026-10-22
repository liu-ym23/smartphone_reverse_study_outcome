package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.message.menu.provider.ChatReplyActionProvider;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f extends ChatReplyActionProvider {

    public static final class a extends ChatReplyActionProvider.ReplyMessageAction {
        public a(yya.a r2) {
            Intrinsics.checkNotNullParameter(r2, "actionContext");
            super(r2);
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131235447, UDColorUtils.getColor(r3, 2131100799));
        }
    }

    public final List<PageType> b() {
        return CollectionsKt.plus(CollectionsKt.listOf(PageType.CHAT_WINDOW), PageType.THREAD_WINDOW);
    }

    public f() {
    }

    public final yya.i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new a(r2);
    }
}
