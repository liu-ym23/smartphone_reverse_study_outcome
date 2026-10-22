package j2b;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends com.ss.android.lark.biz.im.api.extension.chat_window.b {
    public final KeyboardViewModel f;

    public c(Fragment r2, com.ss.android.lark.keyboard.b r3, Chat r4, ChatChatter r5, KeyboardViewModel r6) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r4, "chat");
        super(r2, r3, r4, r5);
        this.f = r6;
    }
}
