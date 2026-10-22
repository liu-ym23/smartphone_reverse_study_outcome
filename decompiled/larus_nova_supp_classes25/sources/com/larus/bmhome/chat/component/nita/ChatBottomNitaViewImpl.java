package com.larus.bmhome.chat.component.nita;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.chat.api.nita.IChatBottomNitaView;
import com.larus.platform.service.z2;
import gd8.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o37.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/component/nita/ChatBottomNitaViewImpl;", "Lcom/larus/chat/api/nita/IChatBottomNitaView;", "<init>", "()V", "getChatSpeakerNitaView", "Landroid/view/View;", "curCtx", "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatBottomNitaViewImpl implements IChatBottomNitaView {
    public ChatBottomNitaViewImpl() {
    }

    public final View a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "curCtx");
        if (z2.a.enablePreloadChatPageView().b() == false) goto L10;
        c.e.getClass();
        if (c.f("chat_bottom_nita") == true) goto L7;
        return null;
    L7:
        if ((r4 instanceof Activity) == false) goto L13;
        b r0 = c.e("chat_bottom_nita");
        int r1 = b.b;
        return r0.i(2131562783, (Activity) r4, true);
    L13:
        return null;
    L10:
        return null;
    }
}
