package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006#"}, d2 = {"Lcom/obric/memorydata/database/entity/AssistantChatEntity;", "", OaidModel.KEY_ID, "", "logId", "", "messages", "", "Lcom/obric/memorydata/database/entity/ChatMessage;", "createdAt", "updatedAt", "<init>", "(JLjava/lang/String;Ljava/util/List;JJ)V", "getId", "()J", "getLogId", "()Ljava/lang/String;", "getMessages", "()Ljava/util/List;", "getCreatedAt", "getUpdatedAt", "isValid", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistantChatEntity {
    public static final a Companion = null;
    private static final String TAG = "AssistantChatEntity";
    private final long createdAt;
    private final long id;
    private final String logId;
    private final List<ChatMessage> messages;
    private final long updatedAt;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/entity/AssistantChatEntity$Companion;", "", "<init>", "()V", "TAG", "", "create", "Lcom/obric/memorydata/database/entity/AssistantChatEntity;", "logId", "messages", "", "Lcom/obric/memorydata/database/entity/ChatMessage;", OaidModel.KEY_ID, "", "fromJson", "json", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public AssistantChatEntity(long r3, String r5, List<ChatMessage> r6, long r7, long r9) {
        List<ChatMessage> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "logId");
        Intrinsics.checkNotNullParameter(r8, "messages");
        this.id = r3;
        this.logId = r5;
        this.messages = r8;
        this.createdAt = r7;
        this.updatedAt = r9;
    }

    public /* synthetic */ AssistantChatEntity(long r13, String r15, List r16, long r17, long r19, int r21, DefaultConstructorMarker r22) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        if ((r21 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r21 & 4) == 0) goto L9;
        r0 = CollectionsKt.emptyList();
    L9:
        List r7 = r0;
        if ((r21 & 8) == 0) goto L12;
        long r8 = System.currentTimeMillis();
    L14:
        if ((r21 & 16) == 0) goto L16;
        long r10 = System.currentTimeMillis();
    L17:
        this(r4, r15, r7, r8, r10);
        return;
    L16:
        r10 = r19;
        goto L17
    L12:
        r8 = r17;
        goto L14
    L5:
        r4 = r13;
        goto L7
    }

    public static /* synthetic */ AssistantChatEntity copy$default(AssistantChatEntity r9, long r10, String r12, List r13, long r14, long r16, int r18, Object r19) {
        List<ChatMessage> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        if ((r18 & 1) == 0) goto L5;
        long r2 = r9.id;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r4 = r9.logId;
    L11:
        if ((r18 & 4) == 0) goto L14;
        r1 = r9.messages;
    L14:
        if ((r18 & 8) == 0) goto L16;
        long r5 = r9.createdAt;
    L18:
        if ((r18 & 16) == 0) goto L20;
        long r7 = r9.updatedAt;
    L22:
        return r9.copy(r2, r4, r1, r5, r7);
    L20:
        r7 = r16;
        goto L22
    L16:
        r5 = r14;
        goto L18
    L9:
        r4 = r12;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.logId;
    }

    public final List<ChatMessage> component3() {
        return this.messages;
    }

    public final long component4() {
        return this.createdAt;
    }

    public final long component5() {
        return this.updatedAt;
    }

    public final AssistantChatEntity copy(long r11, String r13, List<ChatMessage> r14, long r15, long r17) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "logId");
        Intrinsics.checkNotNullParameter(r5, "messages");
        return new AssistantChatEntity(r11, r13, r5, r15, r17);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AssistantChatEntity.class) == true) goto L8;
        return false;
    L8:
        AssistantChatEntity r10 = (AssistantChatEntity) ZeusTransformUtils.preCheckCast(r9, AssistantChatEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logId, r10.logId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messages, r10.messages) == true) goto L18;
        return false;
    L18:
        if (this.createdAt == r10.createdAt) goto L21;
        return false;
    L21:
        if (this.updatedAt == r10.updatedAt) goto L23;
        return false;
    L23:
        return true;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final long getId() {
        return this.id;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final List<ChatMessage> getMessages() {
        return this.messages;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.id) * 31) + this.logId.hashCode()) * 31) + this.messages.hashCode()) * 31) + Long.hashCode(this.createdAt)) * 31) + Long.hashCode(this.updatedAt);
    }

    public final boolean isValid() {
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.logId, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L7:
        return false;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.messages, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L7;
        return true;
    }

    public String toString() {
        return "AssistantChatEntity(id=" + this.id + ", logId=" + this.logId + ", messages=" + this.messages + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ')';
    }
}
