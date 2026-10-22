package com.larus.bmhome.chat;

import com.larus.bmhome.IChatAzerothService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/ChatAzerothServiceImpl;", "Lcom/larus/bmhome/IChatAzerothService;", "<init>", "()V", "isMessageCipher", "", "data", "Lcom/larus/im/bean/message/Message;", "isAdvancedModeMessage", "generateUidToken", "", "decryptFile", "", "decryptionKey", "inputPath", "outputPath", "deleteInput", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatAzerothServiceImpl implements IChatAzerothService {

    public static final class a {
    }

    static {
    }

    public ChatAzerothServiceImpl() {
    }

    @Override // com.larus.bmhome.IChatAzerothService
    public final String b() {
        com.privacy.azerothprivacy.userAuthToken.c r0 = com.privacy.azerothprivacy.userAuthToken.c.c();
        HashMap r1 = new HashMap();
        r0.getClass();
        return com.privacy.azerothprivacy.userAuthToken.c.b(1400, r1);
    }

    @Override // com.larus.bmhome.IChatAzerothService
    public final boolean a(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Map r3 = r2.getExt();
        if (r3 == null) goto L5;
        String r4 = (String) r3.get("mailbox_id");
    L7:
        return com.larus.utils.o0.d(r4);
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.larus.bmhome.IChatAzerothService
    public final boolean d(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Map r0 = r4.getExt();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) r0.get("archive_state");
    L6:
        int r3 = b.a;
        if (Intrinsics.areEqual("shadow_mailbox", r2) == true) goto L9;
        return false;
    L9:
        Map r5 = r4.getBusinessExt();
        if (r5 == null) goto L13;
        r1 = (String) r5.get("local_plain_content");
    L13:
        if ((!Intrinsics.areEqual(r1, "1")) == true) goto L16;
        return false;
    L16:
        return com.larus.utils.o0.d(r4.getContent());
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.bmhome.IChatAzerothService
    public final Object c(String r9, String r10, String r11, Continuation r12) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ChatAzerothServiceImpl$decryptFile$2(r10, r11, true, r9, null), r12);
    }
}
