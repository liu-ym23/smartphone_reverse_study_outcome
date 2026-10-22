package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "old data flow")
public final class ChatConversation {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatConversation$Config;", "", "sectionTimeout", "", "profileTimeout", "firstIndex", "", "retentionIndex", "lastIndex", "readIndex", "<init>", "(JJIIII)V", "getSectionTimeout", "()J", "getProfileTimeout", "getFirstIndex", "()I", "setFirstIndex", "(I)V", "getRetentionIndex", "setRetentionIndex", "getLastIndex", "setLastIndex", "getReadIndex", "setReadIndex", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class Config {

        @SerializedName("fi")
        private int firstIndex;

        @SerializedName("li")
        private int lastIndex;

        @SerializedName("pt")
        private final long profileTimeout;

        @SerializedName("ri")
        private int readIndex;

        @SerializedName("rei")
        private int retentionIndex;

        @SerializedName("st")
        private final long sectionTimeout;

        public Config() {
            this(0, 0, 0, 0, 0, 0, 63, null);
        }

        public static /* synthetic */ Config copy$default(Config r9, long r10, long r12, int r14, int r15, int r16, int r17, int r18, Object r19) {
            if ((r18 & 1) == 0) goto L5;
            long r1 = r9.sectionTimeout;
        L7:
            if ((r18 & 2) == 0) goto L9;
            long r3 = r9.profileTimeout;
        L11:
            if ((r18 & 4) == 0) goto L13;
            int r5 = r9.firstIndex;
        L15:
            if ((r18 & 8) == 0) goto L17;
            int r6 = r9.retentionIndex;
        L19:
            if ((r18 & 16) == 0) goto L21;
            int r7 = r9.lastIndex;
        L23:
            if ((r18 & 32) == 0) goto L25;
            int r8 = r9.readIndex;
        L27:
            return r9.copy(r1, r3, r5, r6, r7, r8);
        L25:
            r8 = r17;
            goto L27
        L21:
            r7 = r16;
            goto L23
        L17:
            r6 = r15;
            goto L19
        L13:
            r5 = r14;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r1 = r10;
            goto L7
        }

        public final long component1() {
            return this.sectionTimeout;
        }

        public final long component2() {
            return this.profileTimeout;
        }

        public final int component3() {
            return this.firstIndex;
        }

        public final int component4() {
            return this.retentionIndex;
        }

        public final int component5() {
            return this.lastIndex;
        }

        public final int component6() {
            return this.readIndex;
        }

        public final Config copy(long r11, long r13, int r15, int r16, int r17, int r18) {
            return new Config(r11, r13, r15, r16, r17, r18);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Config) == true) goto L8;
            return false;
        L8:
            Config r9 = (Config) r8;
            if (this.sectionTimeout == r9.sectionTimeout) goto L12;
            return false;
        L12:
            if (this.profileTimeout == r9.profileTimeout) goto L15;
            return false;
        L15:
            if (this.firstIndex == r9.firstIndex) goto L18;
            return false;
        L18:
            if (this.retentionIndex == r9.retentionIndex) goto L21;
            return false;
        L21:
            if (this.lastIndex == r9.lastIndex) goto L24;
            return false;
        L24:
            if (this.readIndex == r9.readIndex) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            long r0 = this.sectionTimeout;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.profileTimeout;
            return ((((((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.firstIndex) * 31) + this.retentionIndex) * 31) + this.lastIndex) * 31) + this.readIndex;
        }

        public String toString() {
            return "Config(sectionTimeout=" + this.sectionTimeout + ", profileTimeout=" + this.profileTimeout + ", firstIndex=" + this.firstIndex + ", retentionIndex=" + this.retentionIndex + ", lastIndex=" + this.lastIndex + ", readIndex=" + this.readIndex + ')';
        }

        public final int getFirstIndex() {
            return this.firstIndex;
        }

        public final int getLastIndex() {
            return this.lastIndex;
        }

        public final long getProfileTimeout() {
            return this.profileTimeout;
        }

        public final int getReadIndex() {
            return this.readIndex;
        }

        public final int getRetentionIndex() {
            return this.retentionIndex;
        }

        public final long getSectionTimeout() {
            return this.sectionTimeout;
        }

        public final void setFirstIndex(int r1) {
            this.firstIndex = r1;
        }

        public final void setLastIndex(int r1) {
            this.lastIndex = r1;
        }

        public final void setReadIndex(int r1) {
            this.readIndex = r1;
        }

        public final void setRetentionIndex(int r1) {
            this.retentionIndex = r1;
        }

        public Config(long r1, long r3, int r5, int r6, int r7, int r8) {
            this.sectionTimeout = r1;
            this.profileTimeout = r3;
            this.firstIndex = r5;
            this.retentionIndex = r6;
            this.lastIndex = r7;
            this.readIndex = r8;
        }

        public /* synthetic */ Config(long r10, long r12, int r14, int r15, int r16, int r17, int r18, DefaultConstructorMarker r19) {
            if ((r18 & 1) == 0) goto L5;
            long r0 = Long.MAX_VALUE;
        L7:
            if ((r18 & 2) == 0) goto L9;
            long r2 = 86400000;
        L10:
            int r5 = 0;
            if ((r18 & 4) == 0) goto L13;
            int r4 = 0;
        L15:
            if ((r18 & 8) == 0) goto L17;
            int r6 = 0;
        L19:
            if ((r18 & 16) == 0) goto L21;
            int r7 = 0;
        L23:
            if ((r18 & 32) != 0) goto L26;
            r5 = r17;
        L26:
            this(r0, r2, r4, r6, r7, r5);
            return;
        L21:
            r7 = r16;
            goto L23
        L17:
            r6 = r15;
            goto L19
        L13:
            r4 = r14;
            goto L15
        L9:
            r2 = r12;
            goto L10
        L5:
            r0 = r10;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatConversation$Prefer;", "", "tts", "", "<init>", "(Z)V", "getTts", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class Prefer {

        @SerializedName("tts")
        private final boolean tts;

        public Prefer() {
            boolean r2 = false;
            this(r2, 1, null);
        }

        public static /* synthetic */ Prefer copy$default(Prefer r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.tts;
        L6:
            return r0.copy(r1);
        }

        public final boolean component1() {
            return this.tts;
        }

        public final Prefer copy(boolean r2) {
            return new Prefer(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Prefer) == true) goto L9;
            return false;
        L9:
            if (this.tts == ((Prefer) r4).tts) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            if (this.tts == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public String toString() {
            return "Prefer(tts=" + this.tts + ')';
        }

        public final boolean getTts() {
            return this.tts;
        }

        public Prefer(boolean r1) {
            this.tts = r1;
        }

        public /* synthetic */ Prefer(boolean r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = true;
        L5:
            this(r1);
        }
    }

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    static {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ChatConversation) == true) goto L8;
        return false;
    L8:
        ((ChatConversation) r4).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(null, null) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(null, null) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(null, null) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(null, null) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(null, null) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(null, null) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(null, null) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(null, null) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(null, null) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(null, null) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(null, null) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(null, null) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(null, null) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(null, null) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(null, null) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(null, null) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(null, null) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(null, null) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(null, null) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(null, null) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(null, null) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(null, null) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(null, null) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(null, null) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(null, null) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(null, null) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(null, null) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(null, null) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(null, null) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(null, null) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(null, null) == true) goto L113;
        return false;
    L113:
        return true;
    }

    public final String getType() {
        return null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "ChatConversation(id=null, conversationId=null, conversationType=null, name=null, avatar=null, iconImage=null, time=null, updateTime=null, type=null, status=null, owner=null, priority=null, lastSection=null, lastMessageId=null, lastMessageTime=null, botIdList=null, lastMessageIndex=null, prefer=null, config=null, isLocal=null, recommendBotIndex=null, subtitleMessageId=null, tags=null, pinned=null, conversationPage=null, templates=null, bio=null, botStatus=null, botType=null, bgImgUrl=null, bgImgColor=null, conversationContentType=null, botContentType=null, defaultOnboarding=null, botCreatorInfo=null)";
    }
}
