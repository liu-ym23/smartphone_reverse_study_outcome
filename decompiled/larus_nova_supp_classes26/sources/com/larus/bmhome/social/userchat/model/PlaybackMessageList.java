package com.larus.bmhome.social.userchat.model;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.IMMsg;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\r\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR&\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/social/userchat/model/PlaybackMessageList;", "", "messageList", "", "Lcom/larus/im/bean/IMMsg;", "Lcom/larus/bmhome/chat/resp/PushMessage;", "regenList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getMessageList", "()Ljava/util/List;", "getRegenList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlaybackMessageList {

    @SerializedName("message_list")
    private final List<IMMsg> messageList;

    @SerializedName("regen_list")
    private final List<IMMsg> regenList;

    public PlaybackMessageList() {
        List r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlaybackMessageList copy$default(PlaybackMessageList r0, List r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.messageList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.regenList;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<IMMsg> component1() {
        return this.messageList;
    }

    public final List<IMMsg> component2() {
        return this.regenList;
    }

    public final PlaybackMessageList copy(List<IMMsg> r2, List<IMMsg> r3) {
        return new PlaybackMessageList(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PlaybackMessageList) == true) goto L8;
        return false;
    L8:
        PlaybackMessageList r6 = (PlaybackMessageList) r5;
        if (Intrinsics.areEqual(this.messageList, r6.messageList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.regenList, r6.regenList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<IMMsg> r0 = this.messageList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<IMMsg> r4 = this.regenList;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PlaybackMessageList(messageList=" + this.messageList + ", regenList=" + this.regenList + ')';
    }

    public final List<IMMsg> getMessageList() {
        return this.messageList;
    }

    public final List<IMMsg> getRegenList() {
        return this.regenList;
    }

    public PlaybackMessageList(List<IMMsg> r1, List<IMMsg> r2) {
        this.messageList = r1;
        this.regenList = r2;
    }

    public /* synthetic */ PlaybackMessageList(List r1, List r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        this(r1, r2);
    }
}
