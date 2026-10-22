package com.larus.bmhome.nestedfile;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR(\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/nestedfile/UpdateNestedMessageDownLinkInfo;", "Ljava/io/Serializable;", "conversationId", "", "localMsgId", "entityStateList", "", "Lcom/larus/bmhome/nestedfile/EntityState;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "getLocalMsgId", "setLocalMsgId", "getEntityStateList", "()Ljava/util/List;", "setEntityStateList", "(Ljava/util/List;)V", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateNestedMessageDownLinkInfo implements Serializable {

    @SerializedName(MusicAppletPage.KEY_CONVERSATION_ID)
    private String conversationId;

    @SerializedName("update_entity_state_list")
    private List<EntityState> entityStateList;

    @SerializedName("local_message_id")
    private String localMsgId;

    public UpdateNestedMessageDownLinkInfo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdateNestedMessageDownLinkInfo copy$default(UpdateNestedMessageDownLinkInfo r0, String r1, String r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.conversationId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.localMsgId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.entityStateList;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.localMsgId;
    }

    public final List<EntityState> component3() {
        return this.entityStateList;
    }

    public final UpdateNestedMessageDownLinkInfo copy(String r2, String r3, List<EntityState> r4) {
        return new UpdateNestedMessageDownLinkInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UpdateNestedMessageDownLinkInfo) == true) goto L8;
        return false;
    L8:
        UpdateNestedMessageDownLinkInfo r6 = (UpdateNestedMessageDownLinkInfo) r5;
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.localMsgId, r6.localMsgId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entityStateList, r6.entityStateList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.conversationId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.localMsgId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<EntityState> r7 = this.entityStateList;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (r2 != null) goto L15;
        return "";
    L15:
        return r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final List<EntityState> getEntityStateList() {
        return this.entityStateList;
    }

    public final String getLocalMsgId() {
        return this.localMsgId;
    }

    public final void setConversationId(String r1) {
        this.conversationId = r1;
    }

    public final void setEntityStateList(List<EntityState> r1) {
        this.entityStateList = r1;
    }

    public final void setLocalMsgId(String r1) {
        this.localMsgId = r1;
    }

    public UpdateNestedMessageDownLinkInfo(String r1, String r2, List<EntityState> r3) {
        this.conversationId = r1;
        this.localMsgId = r2;
        this.entityStateList = r3;
    }

    public /* synthetic */ UpdateNestedMessageDownLinkInfo(String r2, String r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
