package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface g0 {

    public static final class a {
        public static /* synthetic */ void a(g0 r6, wc9.e r7, List r8, String r9, boolean r10, int r11) {
            if ((r11 & 16) == 0) goto L5;
            boolean r5 = true;
        L6:
            r6.h(r7, r8, null, r9, r5);
            return;
        L5:
            r5 = r10;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void d(g0 r6, wc9.e r7, ic8.w r8, IIMCallback r9, boolean r10, String r11, int r12) {
            if ((r12 & 4) == 0) goto L5;
            r9 = null;
        L5:
            IIMCallback r3 = r9;
            if ((r12 & 8) == 0) goto L8;
            boolean r4 = true;
        L9:
            r6.j(r7, r8, r3, r4, r11);
            return;
        L8:
            r4 = r10;
            goto L9
        }

        public static /* synthetic */ void b(g0 r9, String r10, int r11, ic8.w r12, boolean r13, Integer r14, Function1 r15, int r16) {
            if ((r16 & 2) == 0) goto L5;
            int r4 = 0;
        L7:
            if ((r16 & 8) == 0) goto L9;
            boolean r6 = false;
        L10:
            r9.g(r10, r4, r12, r6, r14, r15);
            return;
        L9:
            r6 = r13;
            goto L10
        L5:
            r4 = r11;
            goto L7
        }

        public static /* synthetic */ void c(g0 r15, wc9.e r16, Message r17, String r18, boolean r19, Map r20, boolean r21, AttachmentInfo r22, NestedFileContent r23, String r24, String r25, ChatPageContext r26, Long r27, int r28) {
            if ((r28 & 32) == 0) goto L5;
            boolean r8 = false;
        L7:
            if ((r28 & 64) == 0) goto L9;
            AttachmentInfo r9 = null;
        L11:
            if ((r28 & 128) == 0) goto L13;
            NestedFileContent r10 = null;
        L15:
            if ((r28 & 256) == 0) goto L17;
            String r11 = null;
        L19:
            if ((r28 & 512) == 0) goto L21;
            String r12 = null;
        L23:
            if ((r28 & 2048) == 0) goto L25;
            Long r14 = null;
        L26:
            r15.e(r16, r17, r18, r19, r20, r8, r9, r10, r11, r12, r26, r14);
            return;
        L25:
            r14 = r27;
            goto L26
        L21:
            r12 = r25;
            goto L23
        L17:
            r11 = r24;
            goto L19
        L13:
            r10 = r23;
            goto L15
        L9:
            r9 = r22;
            goto L11
        L5:
            r8 = r21;
            goto L7
        }
    }

    void a(Message r1, String r2, long r3);

    void b(wc9.e r1, ic8.w r2, Function2<? super Message, ? super IIMError, Unit> r3, boolean r4);

    @Deprecated(message = "deprecated in social")
    void c(String r1, String r2, long r3, wc9.e r5, Function2<? super Message, ? super IIMError, Unit> r6);

    void d(String r1, String r2, wc9.e r3, Map r4, MessageStatus r5, Function2 r6, boolean r7, ReferenceInfo r8, String r9, ChatPageContext r10);

    void e(wc9.e r1, Message r2, String r3, boolean r4, Map<String, String> r5, boolean r6, AttachmentInfo r7, NestedFileContent r8, String r9, String r10, ChatPageContext r11, Long r12);

    void f(String r1, NestedFileContent r2, Map<String, String> r3, IIMCallback<Message> r4);

    void g(String r1, int r2, ic8.w r3, boolean r4, Integer r5, Function1<? super Message, Unit> r6);

    void h(wc9.e r1, List<? extends ic8.w> r2, IIMCallback<List<Message>> r3, String r4, boolean r5);

    void i(String r1, int r2, List<? extends ic8.w> r3, Function1<? super List<Message>, Unit> r4);

    void j(wc9.e r1, ic8.w r2, IIMCallback<Message> r3, boolean r4, String r5);

    void streamAudioText(Message r1);

    void submitAudioText(Message r1);
}
