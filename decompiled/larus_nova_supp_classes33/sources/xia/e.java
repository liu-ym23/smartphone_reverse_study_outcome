package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e implements c {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // xia.c
    public final int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof MessageEntity) == false) goto L21;
        MessageEntity r4 = (MessageEntity) r3;
        int r0 = ((r4.getTelephones().hashCode() + 0) * 31) + r4.getText().hashCode();
        List r1 = r4.getContacts();
        if (r1 == null) goto L7;
        r0 = (r0 * 31) + r1.hashCode();
    L7:
        MessageTypeEnum r2 = r4.getMessageType();
        if (r2 == null) goto L10;
        r0 = (r0 * 31) + r2.name().hashCode();
    L10:
        List r5 = r4.getFiles();
        if (r5 == null) goto L13;
        r0 = (r0 * 31) + r5.hashCode();
    L13:
        MessageStatusTypeEnum r6 = r4.getMessageStatusType();
        if (r6 == null) goto L16;
        r0 = (r0 * 31) + r6.name().hashCode();
    L16:
        GroupChatEntity r7 = r4.getGroupChat();
        if (r7 != null) goto L19;
        return r0;
    L19:
        return (r0 * 31) + r7.hashCode();
    L21:
        throw new IllegalStateException("Check failed.".toString());
    }
}
