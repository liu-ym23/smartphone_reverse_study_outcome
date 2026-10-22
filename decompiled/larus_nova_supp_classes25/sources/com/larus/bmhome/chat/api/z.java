package com.larus.bmhome.chat.api;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.trace.CopyContentTypeString;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface z {

    public static final class a {
        public static /* synthetic */ void b(z r13, q0 r14, View r15, Message r16, boolean r17, String r18, int r19, boolean r20, d0 r21, int r22) {
            if ((r22 & 16) == 0) goto L5;
            String r8 = null;
        L7:
            if ((r22 & 64) == 0) goto L9;
            int r10 = 2;
        L11:
            if ((r22 & 128) == 0) goto L13;
            boolean r11 = false;
        L15:
            if ((r22 & 256) == 0) goto L17;
            d0 r12 = null;
        L18:
            r13.b(r14, r15, r16, r17, r8, null, r10, r11, r12);
            return;
        L17:
            r12 = r21;
            goto L18
        L13:
            r11 = r20;
            goto L15
        L9:
            r10 = r19;
            goto L11
        L5:
            r8 = r18;
            goto L7
        }

        public static /* synthetic */ void a(z r24, by7.e r25, BotModel r26, String r27, long r28, View r30, Message r31, String r32, String r33, RecyclerView r34, boolean r35, int r36, boolean r37, String r38, d0 r39, boolean r40, Boolean r41, String r42, com.larus.bmhome.chat.cotdetail.list.processor.m r43, int r44) {
            if ((r44 & 128) == 0) goto L5;
            String r12 = null;
        L7:
            if ((r44 & 256) == 0) goto L9;
            RecyclerView r13 = null;
        L11:
            if ((r44 & 512) == 0) goto L13;
            boolean r14 = false;
        L15:
            if ((r44 & 1024) == 0) goto L17;
            int r15 = 2;
        L19:
            if ((r44 & 2048) == 0) goto L21;
            boolean r16 = false;
        L23:
            if ((r44 & 4096) == 0) goto L25;
            String r17 = null;
        L27:
            if ((r44 & 8192) == 0) goto L29;
            d0 r18 = null;
        L31:
            if ((r44 & 16384) == 0) goto L33;
            boolean r19 = false;
        L35:
            if ((32768 & r44) == 0) goto L37;
            Boolean r20 = Boolean.TRUE;
        L39:
            if ((65536 & r44) == 0) goto L41;
            String r21 = null;
        L43:
            if ((r44 & 262144) == 0) goto L45;
            com.larus.bmhome.chat.cotdetail.list.processor.m r23 = null;
        L46:
            r24.a(r25, r26, r27, r28, r30, r31, r32, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, null, r23);
            return;
        L45:
            r23 = r43;
            goto L46
        L41:
            r21 = r42;
            goto L43
        L37:
            r20 = r41;
            goto L39
        L33:
            r19 = r40;
            goto L35
        L29:
            r18 = r39;
            goto L31
        L25:
            r17 = r38;
            goto L27
        L21:
            r16 = r37;
            goto L23
        L17:
            r15 = r36;
            goto L19
        L13:
            r14 = r35;
            goto L15
        L9:
            r13 = r34;
            goto L11
        L5:
            r12 = r33;
            goto L7
        }
    }

    void a(by7.e r1, BotModel r2, String r3, long r4, View r6, Message r7, String r8, String r9, RecyclerView r10, boolean r11, int r12, boolean r13, @CopyContentTypeString String r14, d0 r15, boolean r16, Boolean r17, String r18, Function3<? super Message, ? super SelectionRangeType, ? super String, Unit> r19, Function0<Boolean> r20);

    void b(q0 r1, View r2, Message r3, boolean r4, String r5, String r6, int r7, boolean r8, d0 r9);
}
