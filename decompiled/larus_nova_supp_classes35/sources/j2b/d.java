package j2b;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final KeyboardViewModel a(com.ss.android.lark.biz.im.api.extension.chat_window.b r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof c) == true) goto L7;
        return null;
    L7:
        return ((c) r1).f;
    }
}
