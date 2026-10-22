package gd8;

import com.larus.bmhome.view.AttachmentInfo;
import com.larus.feishu.office.im.impl.base.FeishuInputAdapterComponent;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.spi.IAIChatControlTraceService;
import ic8.w;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface g extends m1a.a {

    public static final class a {
        public static /* synthetic */ void a(g r7, e r8, String r9, List r10, String r11, Boolean r12, Long r13, int r14) {
            if ((r14 & 8) == 0) goto L5;
            r11 = IAIChatControlTraceService.a.vb();
        L5:
            String r4 = r11;
            if ((r14 & 16) == 0) goto L8;
            Boolean r5 = null;
        L10:
            if ((r14 & 32) == 0) goto L12;
            Long r6 = null;
        L13:
            r7.sW(r8, r9, r10, r4, r5, r6);
            return;
        L12:
            r6 = r13;
            goto L13
        L8:
            r5 = r12;
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(g r15, String r16, String r17, String r18, Map r19, boolean r20, MessageStatus r21, ReferenceInfo r22, String r23, Function2 r24, Long r25, int r26) {
            if ((r26 & 8) == 0) goto L5;
            Map r7 = null;
        L7:
            if ((r26 & 16) == 0) goto L9;
            boolean r8 = true;
        L11:
            if ((r26 & 32) == 0) goto L13;
            MessageStatus r9 = null;
        L15:
            if ((r26 & 64) == 0) goto L17;
            ReferenceInfo r10 = null;
        L19:
            if ((r26 & 128) == 0) goto L21;
            String r11 = null;
        L23:
            if ((r26 & 256) == 0) goto L25;
            Function2 r12 = null;
        L27:
            if ((r26 & 512) == 0) goto L29;
            Long r13 = null;
        L31:
            if ((r26 & 1024) == 0) goto L33;
            boolean r14 = true;
        L34:
            r15.sd(r16, r17, r18, r7, r8, r9, r10, r11, r12, r13, r14);
            return;
        L33:
            r14 = false;
            goto L34
        L29:
            r13 = r25;
            goto L31
        L25:
            r12 = r24;
            goto L27
        L21:
            r11 = r23;
            goto L23
        L17:
            r10 = r22;
            goto L19
        L13:
            r9 = r21;
            goto L15
        L9:
            r8 = r20;
            goto L11
        L5:
            r7 = r19;
            goto L7
        }
    }

    Unit CQ(e r1, Message r2);

    void J00(Message r1, String r2, Map<String, String> r3, boolean r4, AttachmentInfo r5, NestedFileContent r6, boolean r7, String r8, Long r9);

    void MU(FeishuInputAdapterComponent.e r1);

    Object hi(Message r1, Continuation<? super Unit> r2);

    void mh(String r1, String r2, OmniBreakReason r3);

    void ou(String r1, String r2);

    void sW(e r1, String r2, List<? extends w> r3, String r4, Boolean r5, Long r6);

    void sd(String r1, String r2, String r3, Map<String, String> r4, boolean r5, MessageStatus r6, ReferenceInfo r7, String r8, Function2<? super Message, ? super IIMError, Unit> r9, Long r10, boolean r11);
}
