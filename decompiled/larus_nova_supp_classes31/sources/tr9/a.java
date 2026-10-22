package tr9;

import com.larus.home.impl.sdk.t1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.AudioRecordBlock;
import com.larus.im.bean.message.block.AudioRecordFailInfo;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tx9.i;
import tx9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(Integer r2) {
        if (r2 != null) goto L5;
    L7:
        if (r2 != null) goto L10;
    L12:
        if (r2 != null) goto L15;
    L17:
        return "message_interrupted";
    L15:
        if (r2.intValue() != 22) goto L17;
        return "message_receive_failed";
    L10:
        if (r2.intValue() != 13) goto L12;
        return "message_send_interrupted";
    L5:
        if (r2.intValue() != 23) goto L7;
        return "message_receive_interrupted";
    }

    public static i a(Message r20, Block r21) {
        Intrinsics.checkNotNullParameter(r20, "message");
        Intrinsics.checkNotNullParameter(r21, "block");
        BlockContent r0 = r21.getContent();
        String r3 = null;
        if (r0 == null) goto L5;
        AudioRecordBlock r1 = r0.getAudioRecordBlock();
    L6:
        Map r4 = r20.getExt();
        if (r4 == null) goto L9;
        String r5 = (String) r4.get("record_id");
    L10:
        if (r1 == null) goto L12;
        String r6 = r1.getRecordId();
    L13:
        String r7 = r20.getMessageId();
        String r8 = r20.getReplyId();
        String r9 = r20.getConversationId();
        int r10 = j.a;
        if (r1 == null) goto L16;
        Integer r11 = r1.getCardType();
    L17:
        if (r11 != null) goto L20;
    L22:
        String r12 = "record";
    L23:
        String r13 = r12;
        Integer r14 = Integer.valueOf(r21.getBlockType());
        String r15 = r21.getBlockId();
        if (r1 == null) goto L26;
        Integer r16 = Integer.valueOf(r1.getStatus());
    L27:
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L30;
        r2.y();
        String r17 = t1.a.getDeviceId();
    L31:
        if (r17 != null) goto L33;
        r17 = "";
    L33:
        String r18 = r17;
        String r19 = AccountService.a.getUserId();
        Map r22 = r20.getExt();
        if (r22 == null) goto L36;
        String r110 = (String) r22.get("record_create_did");
    L37:
        if (r1 == null) goto L41;
        AudioRecordFailInfo r23 = r1.getFailInfo();
        if (r23 == null) goto L41;
        Integer r111 = Integer.valueOf(r23.getErrCode());
    L42:
        if (r1 == null) goto L47;
        AudioRecordFailInfo r24 = r1.getFailInfo();
        if (r24 == null) goto L47;
        r3 = r24.getErrMessage();
    L47:
        return new i(r5, r6, r7, r8, r9, r13, r14, r15, r16, r18, r19, r110, r111, r3);
    L41:
        r111 = null;
        goto L42
    L36:
        r110 = null;
        goto L37
    L30:
        r17 = null;
        goto L31
    L26:
        r16 = null;
        goto L27
    L20:
        if (r11.intValue() != 2) goto L22;
        r12 = "independent_si";
        goto L23
    L16:
        r11 = null;
        goto L17
    L12:
        r6 = null;
        goto L13
    L9:
        r5 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
