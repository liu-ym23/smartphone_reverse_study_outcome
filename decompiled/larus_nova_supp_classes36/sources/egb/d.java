package egb;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class d {
    public static /* synthetic */ void a(e r7, Context r8, int r9, Message r10, String r11, boolean r12, Fragment r13, int r14) {
        if ((r14 & 16) == 0) goto L5;
        boolean r5 = false;
    L6:
        r7.d(r8, r9, r10, r11, r5, null);
        return;
    L5:
        r5 = r12;
        goto L6
    }
}
