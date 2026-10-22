package com.obric.assistant.remote_card_container.cache;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jg\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\nHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0016R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006*"}, d2 = {"Lcom/obric/assistant/remote_card_container/cache/CardInfo;", "", "cardUri", "", "localMessageIds", "", "extraParams", "isExpired", "", "actualViewHeight", "", "defaultViewHeight", "sourceAppLastUpdateTime", "", "dataUUID", "<init>", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;ZIIJLjava/lang/String;)V", "getCardUri", "()Ljava/lang/String;", "getLocalMessageIds", "()Ljava/util/Set;", "getExtraParams", "()Z", "getActualViewHeight", "()I", "getDefaultViewHeight", "getSourceAppLastUpdateTime", "()J", "getDataUUID", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    @SerializedName("actualViewHeight")
    private final int actualViewHeight;

    @SerializedName("cardUri")
    private final String cardUri;

    @SerializedName("dataUUID")
    private final String dataUUID;

    @SerializedName("defaultViewHeight")
    private final int defaultViewHeight;

    @SerializedName("extraParams")
    private final String extraParams;

    @SerializedName("isExpired")
    private final boolean isExpired;

    @SerializedName("localMessageIds")
    private final Set<String> localMessageIds;

    @SerializedName("sourceAppLastUpdateTime")
    private final long sourceAppLastUpdateTime;

    public j() {
        this(null, null, null, 0, 255);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (Intrinsics.areEqual(this.cardUri, r9.cardUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.localMessageIds, r9.localMessageIds) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extraParams, r9.extraParams) == true) goto L18;
        return false;
    L18:
        if (this.isExpired == r9.isExpired) goto L21;
        return false;
    L21:
        if (this.actualViewHeight == r9.actualViewHeight) goto L24;
        return false;
    L24:
        if (this.defaultViewHeight == r9.defaultViewHeight) goto L27;
        return false;
    L27:
        if (this.sourceAppLastUpdateTime == r9.sourceAppLastUpdateTime) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.dataUUID, r9.dataUUID) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.cardUri;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Set<String> r4 = this.localMessageIds;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.extraParams;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.isExpired == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (((((r9 + r10) * 31) + this.actualViewHeight) * 31) + this.defaultViewHeight) * 31;
        long r12 = this.sourceAppLastUpdateTime;
        int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        String r14 = this.dataUUID;
        if (r14 == null) goto L23;
        r1 = r14.hashCode();
    L23:
        return r13 + r1;
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CardInfo(cardUri=" + this.cardUri + ", localMessageIds=" + this.localMessageIds + ", extraParams=" + this.extraParams + ", isExpired=" + this.isExpired + ", actualViewHeight=" + this.actualViewHeight + ", defaultViewHeight=" + this.defaultViewHeight + ", sourceAppLastUpdateTime=" + this.sourceAppLastUpdateTime + ", dataUUID=" + this.dataUUID + ')';
    }

    public final int b() {
        return this.actualViewHeight;
    }

    public final String c() {
        return this.cardUri;
    }

    public final String d() {
        return this.dataUUID;
    }

    public final int e() {
        return this.defaultViewHeight;
    }

    public final String f() {
        return this.extraParams;
    }

    public final Set<String> g() {
        return this.localMessageIds;
    }

    public final long h() {
        return this.sourceAppLastUpdateTime;
    }

    public final boolean i() {
        return this.isExpired;
    }

    public /* synthetic */ j(String r14, Set r15, String r16, int r17, int r18) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Set r5 = SetsKt.emptySet();
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r7 = true;
    L19:
        if ((r18 & 32) == 0) goto L21;
        int r9 = 0;
    L23:
        if ((r18 & 64) == 0) goto L25;
        long r10 = -1;
    L27:
        if ((r18 & 128) == 0) goto L29;
        r2 = "";
    L29:
        this(r4, r5, r6, r7, 0, r9, r10, r2);
        return;
    L25:
        r10 = 0;
        goto L27
    L21:
        r9 = r17;
        goto L23
    L17:
        r7 = false;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    public j(String r1, Set<String> r2, String r3, boolean r4, int r5, int r6, long r7, String r9) {
        this.cardUri = r1;
        this.localMessageIds = r2;
        this.extraParams = r3;
        this.isExpired = r4;
        this.actualViewHeight = r5;
        this.defaultViewHeight = r6;
        this.sourceAppLastUpdateTime = r7;
        this.dataUUID = r9;
    }

    public static j a(j r10, Set r11, String r12, boolean r13, int r14, int r15, long r16, String r18, int r19) {
        if ((r19 & 1) == 0) goto L5;
        String r2 = r10.cardUri;
    L7:
        if ((r19 & 2) == 0) goto L9;
        Set r3 = r10.localMessageIds;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r4 = r10.extraParams;
    L15:
        if ((r19 & 8) == 0) goto L17;
        boolean r5 = r10.isExpired;
    L19:
        if ((r19 & 16) == 0) goto L21;
        int r6 = r10.actualViewHeight;
    L23:
        if ((r19 & 32) == 0) goto L25;
        int r7 = r10.defaultViewHeight;
    L27:
        if ((r19 & 64) == 0) goto L29;
        long r8 = r10.sourceAppLastUpdateTime;
    L31:
        if ((r19 & 128) == 0) goto L33;
        String r1 = r10.dataUUID;
    L34:
        r10.getClass();
        return new j(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r18;
        goto L34
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
        r2 = null;
        goto L7
    }
}
