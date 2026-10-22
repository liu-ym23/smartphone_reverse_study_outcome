package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MessageEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f7495a = null;

    static {
        f7495a = new d0();
    }

    private d0() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, MessageEntity.class) == false) goto L21;
        MessageEntity r1 = (MessageEntity) ZeusTransformUtils.preCheckCast(r2, MessageEntity.class, "com.obric.memorydata.plugin");
        int r3 = ((r1.getTelephones().hashCode() + 0) * 31) + r1.getText().hashCode();
        List<ContactEntity> r0 = r1.getContacts();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        MessageTypeEnum r4 = r1.getMessageType();
        if (r4 == null) goto L10;
        r3 = (r3 * 31) + r4.name().hashCode();
    L10:
        List<FileEntity> r5 = r1.getFiles();
        if (r5 == null) goto L13;
        r3 = (r3 * 31) + r5.hashCode();
    L13:
        MessageStatusTypeEnum r6 = r1.getMessageStatusType();
        if (r6 == null) goto L16;
        r3 = (r3 * 31) + r6.name().hashCode();
    L16:
        GroupChatEntity r7 = r1.getGroupChat();
        if (r7 != null) goto L19;
        return r3;
    L19:
        return (r3 * 31) + r7.hashCode();
    L21:
        throw new IllegalStateException("Check failed.".toString());
    }
}
