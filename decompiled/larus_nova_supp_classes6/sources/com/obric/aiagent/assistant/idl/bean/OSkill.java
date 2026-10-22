package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017Jd\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020&J\u0013\u0010'\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020&HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017¨\u00061"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OSkill;", "Landroid/os/Parcelable;", "slug", "", "displayName", "coverUrl", "enabled", "", "available", "createdAt", "", "lastUsedAt", "lastUpdatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getSlug", "()Ljava/lang/String;", "getDisplayName", "getCoverUrl", "getEnabled", "()Z", "getAvailable", "getCreatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLastUsedAt", "getLastUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/obric/aiagent/assistant/idl/bean/OSkill;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class OSkill implements Parcelable {
    public static final Parcelable.Creator<OSkill> CREATOR = null;
    private final boolean available;
    private final String coverUrl;
    private final Long createdAt;
    private final String displayName;
    private final boolean enabled;
    private final Long lastUpdatedAt;
    private final Long lastUsedAt;
    private final String slug;

    static {
        CREATOR = new a();
    }

    public OSkill() {
        this(null, null, null, false, false, null, null, null, 255, null);
    }

    public static /* synthetic */ OSkill copy$default(OSkill r9, String r10, String r11, String r12, boolean r13, boolean r14, Long r15, Long r16, Long r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.slug;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.displayName;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.coverUrl;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = r9.enabled;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.available;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Long r7 = r9.createdAt;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Long r8 = r9.lastUsedAt;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Long r1 = r9.lastUpdatedAt;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.slug;
    }

    public final String component2() {
        return this.displayName;
    }

    public final String component3() {
        return this.coverUrl;
    }

    public final boolean component4() {
        return this.enabled;
    }

    public final boolean component5() {
        return this.available;
    }

    public final Long component6() {
        return this.createdAt;
    }

    public final Long component7() {
        return this.lastUsedAt;
    }

    public final Long component8() {
        return this.lastUpdatedAt;
    }

    public final OSkill copy(String r11, String r12, String r13, boolean r14, boolean r15, Long r16, Long r17, Long r18) {
        Intrinsics.checkNotNullParameter(r11, "slug");
        Intrinsics.checkNotNullParameter(r12, "displayName");
        Intrinsics.checkNotNullParameter(r13, "coverUrl");
        return new OSkill(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OSkill) == true) goto L8;
        return false;
    L8:
        OSkill r6 = (OSkill) r5;
        if (Intrinsics.areEqual(this.slug, r6.slug) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayName, r6.displayName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.coverUrl, r6.coverUrl) == true) goto L18;
        return false;
    L18:
        if (this.enabled == r6.enabled) goto L21;
        return false;
    L21:
        if (this.available == r6.available) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.createdAt, r6.createdAt) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.lastUsedAt, r6.lastUsedAt) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lastUpdatedAt, r6.lastUpdatedAt) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.slug.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.coverUrl.hashCode()) * 31;
        int r2 = 1231;
        if (this.enabled == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.available == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (r3 + r2) * 31;
        Long r5 = this.createdAt;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r4 + r7) * 31;
        Long r9 = this.lastUsedAt;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        Long r12 = this.lastUpdatedAt;
        if (r12 == null) goto L23;
        r6 = r12.hashCode();
    L23:
        return r11 + r6;
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r5.hashCode();
        goto L14
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "OSkill(slug=" + this.slug + ", displayName=" + this.displayName + ", coverUrl=" + this.coverUrl + ", enabled=" + this.enabled + ", available=" + this.available + ", createdAt=" + this.createdAt + ", lastUsedAt=" + this.lastUsedAt + ", lastUpdatedAt=" + this.lastUpdatedAt + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeString(this.slug);
        r5.writeString(this.displayName);
        r5.writeString(this.coverUrl);
        r5.writeInt(this.enabled ? 1 : 0);
        r5.writeInt(this.available ? 1 : 0);
        Long r7 = this.createdAt;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Long r8 = this.lastUsedAt;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L10:
        Long r9 = this.lastUpdatedAt;
        if (r9 != null) goto L13;
        r5.writeInt(0);
        return;
    L13:
        r5.writeInt(1);
        r5.writeLong(r9.longValue());
        return;
    L9:
        r5.writeInt(1);
        r5.writeLong(r8.longValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeLong(r7.longValue());
        goto L6
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Long getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public final Long getLastUsedAt() {
        return this.lastUsedAt;
    }

    public final String getSlug() {
        return this.slug;
    }

    public OSkill(String r2, String r3, String r4, boolean r5, boolean r6, Long r7, Long r8, Long r9) {
        Intrinsics.checkNotNullParameter(r2, "slug");
        Intrinsics.checkNotNullParameter(r3, "displayName");
        Intrinsics.checkNotNullParameter(r4, "coverUrl");
        this.slug = r2;
        this.displayName = r3;
        this.coverUrl = r4;
        this.enabled = r5;
        this.available = r6;
        this.createdAt = r7;
        this.lastUsedAt = r8;
        this.lastUpdatedAt = r9;
    }

    public /* synthetic */ OSkill(String r10, String r11, String r12, boolean r13, boolean r14, Long r15, Long r16, Long r17, int r18, DefaultConstructorMarker r19) {
        String r2 = "";
        if ((r18 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r18 & 4) != 0) goto L14;
        r2 = r12;
    L14:
        boolean r5 = false;
        if ((r18 & 8) == 0) goto L17;
        boolean r4 = false;
    L19:
        if ((r18 & 16) != 0) goto L22;
        r5 = r14;
    L22:
        Long r7 = null;
        if ((r18 & 32) == 0) goto L25;
        Long r6 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Long r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r7 = r17;
    L34:
        this(r1, r3, r2, r4, r5, r6, r8, r7);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r6 = r15;
        goto L27
    L17:
        r4 = r13;
        goto L19
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
