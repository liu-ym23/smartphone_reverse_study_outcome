package com.larus.platform.spi;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function0;
import sr9.e0;
import st8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class IAIChatService$a {
    public static /* synthetic */ void b(IAIChatService.Companion r13, FragmentManager r14, Message r15, String r16, String r17, String r18, Integer r19, int r20) {
        if ((r20 & 8) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r20 & 32) == 0) goto L9;
        String r7 = "";
    L11:
        if ((r20 & 64) == 0) goto L13;
        String r8 = "";
    L15:
        if ((r20 & 1024) == 0) goto L17;
        Integer r12 = null;
    L18:
        r13.W7(r14, r15, null, r4, 0, r7, r8, null, null, null, r12);
        return;
    L17:
        r12 = r19;
        goto L18
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public static /* synthetic */ e0 a(IAIChatService.Companion r12, Fragment r13, RecyclerView r14, q0 r15, Object r16, a r17, q0.a r18, Message r19, Function0 r20, boolean r21, LongClickSource r22, int r23) {
        if ((r23 & 1024) == 0) goto L5;
        LongClickSource r11 = LongClickSource.Content;
    L7:
        return r12.G7(r13, r14, r15, r16, r17, r18, r19, r20, r21, null, r11);
    L5:
        r11 = r22;
        goto L7
    }
}
