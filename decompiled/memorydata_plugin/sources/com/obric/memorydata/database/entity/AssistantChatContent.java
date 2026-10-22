package com.obric.memorydata.database.entity;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/entity/AssistantChatContent;", "", "contentType", "", "contentValue", AILabCheckPermissionTask.KEY_SOURCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContentType", "()Ljava/lang/String;", "getContentValue", "getSource", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistantChatContent {
    private final String contentType;
    private final String contentValue;
    private final String source;

    public AssistantChatContent(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "contentType");
        this.contentType = r2;
        this.contentValue = r3;
        this.source = r4;
    }

    public /* synthetic */ AssistantChatContent(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }

    public static /* synthetic */ AssistantChatContent copy$default(AssistantChatContent r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.contentType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.contentValue;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.source;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.contentType;
    }

    public final String component2() {
        return this.contentValue;
    }

    public final String component3() {
        return this.source;
    }

    public final AssistantChatContent copy(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "contentType");
        return new AssistantChatContent(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AssistantChatContent.class) == true) goto L8;
        return false;
    L8:
        AssistantChatContent r6 = (AssistantChatContent) ZeusTransformUtils.preCheckCast(r5, AssistantChatContent.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.contentType, r6.contentType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contentValue, r6.contentValue) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.source, r6.source) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getContentValue() {
        return this.contentValue;
    }

    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        int r0 = this.contentType.hashCode() * 31;
        String r1 = this.contentValue;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.source;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "AssistantChatContent(contentType=" + this.contentType + ", contentValue=" + this.contentValue + ", source=" + this.source + ')';
    }
}
