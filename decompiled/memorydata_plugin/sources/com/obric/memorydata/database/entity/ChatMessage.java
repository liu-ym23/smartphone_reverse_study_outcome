package com.obric.memorydata.database.entity;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/entity/ChatMessage;", "", "type", "", Params.CONTENT, "tosKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getContent", "getTosKey", "isValid", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChatMessage {
    private static final List<String> ALL_MESSAGE_TYPES = null;
    public static final a Companion = null;
    public static final String TYPE_QUERY = "query";
    public static final String TYPE_RESPONSE = "response";

    @GsonUtil.a
    private final String content;
    private final String tosKey;
    private final String type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/entity/ChatMessage$Companion;", "", "<init>", "()V", "TYPE_QUERY", "", "TYPE_RESPONSE", "ALL_MESSAGE_TYPES", "", "getALL_MESSAGE_TYPES", "()Ljava/util/List;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
        ALL_MESSAGE_TYPES = CollectionsKt.listOf(new String[]{TYPE_QUERY, TYPE_RESPONSE});
    }

    public ChatMessage(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        this.type = r2;
        this.content = r3;
        this.tosKey = r4;
    }

    public /* synthetic */ ChatMessage(String r1, String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ List access$getALL_MESSAGE_TYPES$cp() {
        return ALL_MESSAGE_TYPES;
    }

    public static /* synthetic */ ChatMessage copy$default(ChatMessage r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.tosKey;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.tosKey;
    }

    public final ChatMessage copy(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        return new ChatMessage(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ChatMessage.class) == true) goto L8;
        return false;
    L8:
        ChatMessage r6 = (ChatMessage) ZeusTransformUtils.preCheckCast(r5, ChatMessage.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tosKey, r6.tosKey) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getTosKey() {
        return this.tosKey;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((this.type.hashCode() * 31) + this.content.hashCode()) * 31;
        String r2 = this.tosKey;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public final boolean isValid() {
        if (ALL_MESSAGE_TYPES.contains(this.type) == true) goto L5;
    L7:
        return false;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.content, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        return true;
    }

    public String toString() {
        return "ChatMessage(type=" + this.type + ", content=" + this.content + ", tosKey=" + this.tosKey + ')';
    }
}
