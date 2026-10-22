package com.larus.bmhome.chat.component.bottom.reference;

import com.larus.bmhome.chat.component.bottom.reference.entity.RefEntranceType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface a extends t1a.a {

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.reference.a$a, reason: collision with other inner class name */
    public static final class C0053a {
        public static /* synthetic */ void a(a r8, Message r9, Integer r10, String r11, boolean r12, RefEntranceType r13, int r14) {
            if ((r14 & 4) == 0) goto L5;
            String r5 = null;
        L7:
            if ((r14 & 8) == 0) goto L9;
            boolean r6 = true;
        L11:
            if ((r14 & 16) == 0) goto L13;
            RefEntranceType r7 = null;
        L14:
            r8.Vu(r9, r10, r5, r6, r7);
            return;
        L13:
            r7 = r13;
            goto L14
        L9:
            r6 = r12;
            goto L11
        L5:
            r5 = r11;
            goto L7
        }
    }

    void CN(Message r1);

    void Dk(String r1);

    void Ek(boolean r1);

    boolean GD();

    void L60(String r1, boolean r2);

    boolean LX();

    void NR();

    void OW(BotModel r1);

    boolean Qj();

    ReferenceInfo T6();

    String TL();

    boolean VM();

    void Vu(Message r1, Integer r2, String r3, boolean r4, RefEntranceType r5);

    boolean i9();

    void mE();

    void sZ();

    String vS();

    String wf();

    void xo(Message r1, boolean r2);
}
