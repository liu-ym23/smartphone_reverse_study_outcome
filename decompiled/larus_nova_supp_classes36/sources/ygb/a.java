package ygb;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.flow.chatthread.page.FlowChatThreadFragment;
import kotlin.jvm.internal.Intrinsics;
import s2b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends d {
    public final boolean m() {
        return true;
    }

    public final Chat getChat() {
        return ((d) this).d;
    }

    public a(FragmentActivity r2, v r3, FlowChatThreadFragment r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatContainer");
        Intrinsics.checkNotNullParameter(r4, "sourceFragment");
        super(r2, r3, r4);
    }
}
