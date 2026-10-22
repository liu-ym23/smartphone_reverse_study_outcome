package f4b;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.message.menu.provider.ChatReplyActionProvider;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends d implements ChatReplyActionProvider.c {
    public OpenApp i;
    public Function1<? super String, Unit> j;

    @Override // com.ss.android.lark.chat.message.menu.provider.ChatReplyActionProvider.c
    public final OpenApp e() {
        return this.i;
    }

    public e(Context r9, c r10, Fragment r11, v r12, View r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r11, "fragment");
        Intrinsics.checkNotNullParameter(r12, "chatContainer");
        Intrinsics.checkNotNullParameter(r13, "view");
        super(r9, r10, r11, PageType.REPLY_IN_THREAD, r12, r13);
    }
}
