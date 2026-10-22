package pkb;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.larksuite.component.ui.dialog.d;
import com.ss.android.lark.chat.component.ChatInitErrorComponent;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import w4b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static void a(String r2, final ChatInitErrorComponent.showOpenChatError.1.a r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        c r0 = ChatCoreModule.a();
        if (r0 != null) goto L8;
        return;
    L8:
        Context r1 = r0.getContext();
        if (r1 != null) goto L11;
        return;
    L11:
        d r4 = new d(r1);
        r4.h(r2);
        r4.a(2131378551, 2131891840, r3);
        DialogInterface.OnDismissListener r5 = new a(r3);
        r4.c.onDismissListener(r5);
        r4.c.cancelOnTouchOutside(false);
        r4.d();
    }
}
