package com.obric.memorydata.memory.memoryentity;

import com.google.gson.annotations.SerializedName;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/ChatMessage;", "", "roleType", "", Params.CONTENT, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRoleType", "()Ljava/lang/String;", "getContent", "isValid", "", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChatMessage {
    public static final a Companion = null;
    public static final String ROLE_ASSISTANT = "assistant";
    public static final String ROLE_USER = "user";

    @SerializedName("Content")
    private final String content;

    @SerializedName("RoleType")
    private final String roleType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/ChatMessage$Companion;", "", "<init>", "()V", "ROLE_USER", "", "ROLE_ASSISTANT", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public ChatMessage(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "roleType");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        this.roleType = r2;
        this.content = r3;
    }

    public static /* synthetic */ ChatMessage copy$default(ChatMessage r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.roleType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.roleType;
    }

    public final String component2() {
        return this.content;
    }

    public final ChatMessage copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "roleType");
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        return new ChatMessage(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ChatMessage.class) == true) goto L8;
        return false;
    L8:
        ChatMessage r6 = (ChatMessage) ZeusTransformUtils.preCheckCast(r5, ChatMessage.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.roleType, r6.roleType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getRoleType() {
        return this.roleType;
    }

    public int hashCode() {
        return (this.roleType.hashCode() * 31) + this.content.hashCode();
    }

    public final boolean isValid() {
        if (Intrinsics.areEqual(this.roleType, "user") == false) goto L5;
    L6:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(this.content, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        return false;
    L15:
        return true;
    L9:
        if (r4.length() == 0) goto L12;
        r5 = false;
        goto L13
    L5:
        if (Intrinsics.areEqual(this.roleType, "assistant") == true) goto L6;
        return false;
    }

    public String toString() {
        return "ChatMessage(roleType=" + this.roleType + ", content=" + this.content + ')';
    }
}
