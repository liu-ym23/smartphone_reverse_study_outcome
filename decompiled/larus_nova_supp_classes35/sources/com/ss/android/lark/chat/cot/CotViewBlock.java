package com.ss.android.lark.chat.cot;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JU\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chat/cot/CotViewBlock;", "Ljava/io/Serializable;", "stableId", BuildConfig.FLAVOR, IPortraitService.TYPE, "Lcom/ss/android/lark/chat/cot/CotViewBlockType;", "title", "body", "status", "Lcom/ss/android/lark/chat/cot/CotBlockStatus;", "isStreaming", BuildConfig.FLAVOR, "cotBlockExtra", "Lcom/ss/android/lark/chat/cot/CotBlockExtra;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/cot/CotViewBlockType;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chat/cot/CotBlockStatus;ZLcom/ss/android/lark/chat/cot/CotBlockExtra;)V", "getStableId", "()Ljava/lang/String;", "getType", "()Lcom/ss/android/lark/chat/cot/CotViewBlockType;", "getTitle", "getBody", "getStatus", "()Lcom/ss/android/lark/chat/cot/CotBlockStatus;", "()Z", "getCotBlockExtra", "()Lcom/ss/android/lark/chat/cot/CotBlockExtra;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotViewBlock implements Serializable {
    private final String body;
    private final CotBlockExtra cotBlockExtra;
    private final boolean isStreaming;
    private final String stableId;
    private final CotBlockStatus status;
    private final String title;
    private final CotViewBlockType type;

    public static /* synthetic */ CotViewBlock copy$default(CotViewBlock r5, String r6, CotViewBlockType r7, String r8, String r9, CotBlockStatus r10, boolean r11, CotBlockExtra r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.stableId;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.type;
    L8:
        CotViewBlockType r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.title;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.body;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.status;
    L17:
        CotBlockStatus r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.isStreaming;
    L20:
        boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.cotBlockExtra;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.stableId;
    }

    public final CotViewBlockType component2() {
        return this.type;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.body;
    }

    public final CotBlockStatus component5() {
        return this.status;
    }

    public final boolean component6() {
        return this.isStreaming;
    }

    public final CotBlockExtra component7() {
        return this.cotBlockExtra;
    }

    public final CotViewBlock copy(String r10, CotViewBlockType r11, String r12, String r13, CotBlockStatus r14, boolean r15, CotBlockExtra r16) {
        Intrinsics.checkNotNullParameter(r10, "stableId");
        Intrinsics.checkNotNullParameter(r11, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r14, "status");
        return new CotViewBlock(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CotViewBlock) == true) goto L8;
        return false;
    L8:
        CotViewBlock r6 = (CotViewBlock) r5;
        if (Intrinsics.areEqual(this.stableId, r6.stableId) == true) goto L12;
        return false;
    L12:
        if (this.type == r6.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.body, r6.body) == true) goto L21;
        return false;
    L21:
        if (this.status == r6.status) goto L24;
        return false;
    L24:
        if (this.isStreaming == r6.isStreaming) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cotBlockExtra, r6.cotBlockExtra) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.stableId.hashCode() * 31) + this.type.hashCode()) * 31;
        String r1 = this.title;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.body;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.status.hashCode()) * 31;
        if (this.isStreaming == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        CotBlockExtra r10 = this.cotBlockExtra;
        if (r10 == null) goto L19;
        r2 = r10.hashCode();
    L19:
        return r9 + r2;
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "CotViewBlock(stableId=" + this.stableId + ", type=" + this.type + ", title=" + this.title + ", body=" + this.body + ", status=" + this.status + ", isStreaming=" + this.isStreaming + ", cotBlockExtra=" + this.cotBlockExtra + ')';
    }

    public final String getBody() {
        return this.body;
    }

    public final CotBlockExtra getCotBlockExtra() {
        return this.cotBlockExtra;
    }

    public final String getStableId() {
        return this.stableId;
    }

    public final CotBlockStatus getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final CotViewBlockType getType() {
        return this.type;
    }

    public final boolean isStreaming() {
        return this.isStreaming;
    }

    public CotViewBlock(String r2, CotViewBlockType r3, String r4, String r5, CotBlockStatus r6, boolean r7, CotBlockExtra r8) {
        Intrinsics.checkNotNullParameter(r2, "stableId");
        Intrinsics.checkNotNullParameter(r3, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r6, "status");
        this.stableId = r2;
        this.type = r3;
        this.title = r4;
        this.body = r5;
        this.status = r6;
        this.isStreaming = r7;
        this.cotBlockExtra = r8;
    }

    public /* synthetic */ CotViewBlock(String r10, CotViewBlockType r11, String r12, String r13, CotBlockStatus r14, boolean r15, CotBlockExtra r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 64) == 0) goto L5;
        CotBlockExtra r8 = NoExtra.INSTANCE;
    L6:
        this(r10, r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }
}
