package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import com.larus.bmhome.chat.component.collection.o$a;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e extends com.larus.bmhome.chat.layout.holder.menu.item.a {

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != 2131910857) goto L5;
        return true;
    L5:
        return false;
    }

    public e() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r3, View r4, ef8.b r5) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "menuContext");
        Message r6 = r5.a;
        FLogger.a.i("CancelCollectMenuHandler", "CancelCollectMenuCreator cancelCollectMessage, msgId=" + r6.getMessageId());
        com.larus.bmhome.chat.api.q0.a r7 = r5.b;
        if (r7 == null) goto L9;
        com.larus.bmhome.chat.component.collection.o r8 = r7.i2();
        if (r8 == null) goto L10;
        o$a.a(r8, "long_press_answer", r6);
        return true;
    L10:
        return true;
    L9:
        return true;
    }
}
