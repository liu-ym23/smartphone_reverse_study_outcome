package com.obric.memorydata.datatransport.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003J\b\u0010!\u001a\u00020\u0003H\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0013\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0017¨\u0006\""}, d2 = {"Lcom/obric/memorydata/datatransport/entity/ConstructedMessageEntity;", "Lcom/obric/memorydata/datatransport/entity/ConstructedAppEntity;", OaidModel.KEY_ID, "", "createTime", "", "modifyTime", "telephones", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "contacts", "Lcom/obric/memorydata/datatransport/entity/ConstructedContactEntity;", "messageType", "messageStatusType", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getTelephones", "()Ljava/util/List;", "getText", "()Ljava/lang/String;", "getContacts", "getMessageType", "setMessageType", "(Ljava/lang/String;)V", "getMessageStatusType", "setMessageStatusType", "toOriginalAppEntity", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "mapStringToMessageTypeEnum", "Lcom/obric/capabilitykit/entity/enums/MessageTypeEnum;", TypedValues.Custom.S_STRING, "mapStringToMessageStatusTypeEnum", "Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "generateEvaluationId", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f9720b;
    private final String c;
    private final List<c> d;
    private String e;
    private String f;

    public final MessageTypeEnum a(String r1) {
        if (Intrinsics.areEqual(r1, "验证码") == true) goto L7;
        return null;
    L7:
        return MessageTypeEnum.VERIFICATION_CODE;
    }

    public final MessageStatusTypeEnum b(String r1) {
        if (Intrinsics.areEqual(r1, "收件箱") == false) goto L6;
        return MessageStatusTypeEnum.INBOX;
    L6:
        if (Intrinsics.areEqual(r1, "发送箱") == true) goto L11;
        return null;
    L11:
        return MessageStatusTypeEnum.OUTBOX;
    }

    @Override // com.obric.memorydata.datatransport.a.a
    public /* synthetic */ AppEntity d() {
        return (AppEntity) ZeusTransformUtils.preCheckCast(e(), AppEntity.class, "com.obric.memorydata.plugin");
    }

    public MessageEntity e() {
        List<c> r0 = this.d;
        if (r0 == null) goto L9;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.add(((c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.memorydata.plugin")).e());
        goto L6
    L8:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L10:
        List r9 = r4;
        String r5 = a();
        if (r5 != null) goto L13;
        r5 = "0";
    L13:
        String r6 = r5;
        Long r7 = b();
        long r8 = 0;
        if (r7 == null) goto L16;
        long r10 = r7.longValue();
    L17:
        Long r11 = c();
        if (r11 == null) goto L20;
        r8 = r11.longValue();
    L20:
        MessageEntity r12 = new MessageEntity(r6, r10, r8, this.f9720b, this.c, r9);
        r12.setMessageType(a(this.e));
        r12.setMessageStatusType(b(this.f));
        return r12;
    L16:
        r10 = 0;
        goto L17
    L9:
        r4 = null;
        goto L10
    }
}
