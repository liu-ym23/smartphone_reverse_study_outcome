package com.larus.bmhome.social;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003Je\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010/\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\bHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00064"}, d2 = {"Lcom/larus/bmhome/social/MentionedUserInfo;", "Ljava/io/Serializable;", "id", "", "name", "isInGroup", "", "spanStartInt", "", "spanEndIndex", "type", "avatarUrl", "description", "updateTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZIIILjava/lang/String;Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "()Z", "setInGroup", "(Z)V", "getSpanStartInt", "()I", "setSpanStartInt", "(I)V", "getSpanEndIndex", "setSpanEndIndex", "getType", "setType", "getAvatarUrl", "getDescription", "getUpdateTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MentionedUserInfo implements Serializable {
    private final String avatarUrl;
    private final String description;
    private final String id;
    private boolean isInGroup;
    private String name;
    private int spanEndIndex;
    private int spanStartInt;
    private int type;
    private final long updateTime;

    public static /* synthetic */ MentionedUserInfo copy$default(MentionedUserInfo r12, String r13, String r14, boolean r15, int r16, int r17, int r18, String r19, String r20, long r21, int r23, Object r24) {
        if ((r23 & 1) == 0) goto L5;
        String r2 = r12.id;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r3 = r12.name;
    L11:
        if ((r23 & 4) == 0) goto L13;
        boolean r4 = r12.isInGroup;
    L15:
        if ((r23 & 8) == 0) goto L17;
        int r5 = r12.spanStartInt;
    L19:
        if ((r23 & 16) == 0) goto L21;
        int r6 = r12.spanEndIndex;
    L23:
        if ((r23 & 32) == 0) goto L25;
        int r7 = r12.type;
    L27:
        if ((r23 & 64) == 0) goto L29;
        String r8 = r12.avatarUrl;
    L31:
        if ((r23 & 128) == 0) goto L33;
        String r9 = r12.description;
    L35:
        if ((r23 & 256) == 0) goto L37;
        long r10 = r12.updateTime;
    L39:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.isInGroup;
    }

    public final int component4() {
        return this.spanStartInt;
    }

    public final int component5() {
        return this.spanEndIndex;
    }

    public final int component6() {
        return this.type;
    }

    public final String component7() {
        return this.avatarUrl;
    }

    public final String component8() {
        return this.description;
    }

    public final long component9() {
        return this.updateTime;
    }

    public final MentionedUserInfo copy(String r13, String r14, boolean r15, int r16, int r17, int r18, String r19, String r20, long r21) {
        Intrinsics.checkNotNullParameter(r13, "id");
        Intrinsics.checkNotNullParameter(r14, "name");
        Intrinsics.checkNotNullParameter(r20, "description");
        return new MentionedUserInfo(r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MentionedUserInfo) == true) goto L8;
        return false;
    L8:
        MentionedUserInfo r9 = (MentionedUserInfo) r8;
        if (Intrinsics.areEqual(this.id, r9.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L15;
        return false;
    L15:
        if (this.isInGroup == r9.isInGroup) goto L18;
        return false;
    L18:
        if (this.spanStartInt == r9.spanStartInt) goto L21;
        return false;
    L21:
        if (this.spanEndIndex == r9.spanEndIndex) goto L24;
        return false;
    L24:
        if (this.type == r9.type) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.avatarUrl, r9.avatarUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.description, r9.description) == true) goto L33;
        return false;
    L33:
        if (this.updateTime == r9.updateTime) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
        if (this.isInGroup == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((((((r0 + r1) * 31) + this.spanStartInt) * 31) + this.spanEndIndex) * 31) + this.type) * 31;
        String r3 = this.avatarUrl;
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (((r2 + r4) * 31) + this.description.hashCode()) * 31;
        long r6 = this.updateTime;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L9:
        r4 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "MentionedUserInfo(id=" + this.id + ", name=" + this.name + ", isInGroup=" + this.isInGroup + ", spanStartInt=" + this.spanStartInt + ", spanEndIndex=" + this.spanEndIndex + ", type=" + this.type + ", avatarUrl=" + this.avatarUrl + ", description=" + this.description + ", updateTime=" + this.updateTime + ')';
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSpanEndIndex() {
        return this.spanEndIndex;
    }

    public final int getSpanStartInt() {
        return this.spanStartInt;
    }

    public final int getType() {
        return this.type;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final boolean isInGroup() {
        return this.isInGroup;
    }

    public final void setInGroup(boolean r1) {
        this.isInGroup = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setSpanEndIndex(int r1) {
        this.spanEndIndex = r1;
    }

    public final void setSpanStartInt(int r1) {
        this.spanStartInt = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public MentionedUserInfo(String r2, String r3, boolean r4, int r5, int r6, int r7, String r8, String r9, long r10) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r9, "description");
        this.id = r2;
        this.name = r3;
        this.isInGroup = r4;
        this.spanStartInt = r5;
        this.spanEndIndex = r6;
        this.type = r7;
        this.avatarUrl = r8;
        this.description = r9;
        this.updateTime = r10;
    }

    public /* synthetic */ MentionedUserInfo(String r15, String r16, boolean r17, int r18, int r19, int r20, String r21, String r22, long r23, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 8) == 0) goto L5;
        int r7 = 0;
    L7:
        if ((r25 & 16) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r25 & 32) == 0) goto L13;
        int r9 = 0;
    L15:
        if ((r25 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r25 & 128) == 0) goto L21;
        String r11 = "";
    L23:
        if ((r25 & 256) == 0) goto L25;
        long r12 = 0;
    L26:
        this(r15, r16, r17, r7, r8, r9, r10, r11, r12);
        return;
    L25:
        r12 = r23;
        goto L26
    L21:
        r11 = r22;
        goto L23
    L17:
        r10 = r21;
        goto L19
    L13:
        r9 = r20;
        goto L15
    L9:
        r8 = r19;
        goto L11
    L5:
        r7 = r18;
        goto L7
    }
}
