package com.larus.avlink.e.mock;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003Jz\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006+"}, d2 = {"Lcom/larus/avlink/e/mock/CameraDataFrameJson;", "", "stage", "", "scene", "id", "type", "seq", "count", "dataBase64", "", "assId", "assDataBase64", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getStage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScene", "getId", "getType", "getSeq", "getCount", "getDataBase64", "()Ljava/lang/String;", "getAssId", "getAssDataBase64", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/avlink/e/mock/CameraDataFrameJson;", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CameraDataFrameJson {
    public static final int $stable = 0;

    @SerializedName("assDataBase64")
    private final String assDataBase64;

    @SerializedName("assId")
    private final Integer assId;

    @SerializedName("count")
    private final Integer count;

    @SerializedName("dataBase64")
    private final String dataBase64;

    @SerializedName("id")
    private final Integer id;

    @SerializedName("scene")
    private final Integer scene;

    @SerializedName("seq")
    private final Integer seq;

    @SerializedName("stage")
    private final Integer stage;

    @SerializedName("type")
    private final Integer type;

    public CameraDataFrameJson() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ CameraDataFrameJson copy$default(CameraDataFrameJson r10, Integer r11, Integer r12, Integer r13, Integer r14, Integer r15, Integer r16, String r17, Integer r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        Integer r2 = r10.stage;
    L7:
        if ((r20 & 2) == 0) goto L9;
        Integer r3 = r10.scene;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Integer r4 = r10.id;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Integer r5 = r10.type;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Integer r6 = r10.seq;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Integer r7 = r10.count;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.dataBase64;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Integer r9 = r10.assId;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.assDataBase64;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final Integer component1() {
        return this.stage;
    }

    public final Integer component2() {
        return this.scene;
    }

    public final Integer component3() {
        return this.id;
    }

    public final Integer component4() {
        return this.type;
    }

    public final Integer component5() {
        return this.seq;
    }

    public final Integer component6() {
        return this.count;
    }

    public final String component7() {
        return this.dataBase64;
    }

    public final Integer component8() {
        return this.assId;
    }

    public final String component9() {
        return this.assDataBase64;
    }

    public final CameraDataFrameJson copy(Integer r12, Integer r13, Integer r14, Integer r15, Integer r16, Integer r17, String r18, Integer r19, String r20) {
        return new CameraDataFrameJson(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CameraDataFrameJson) == true) goto L8;
        return false;
    L8:
        CameraDataFrameJson r6 = (CameraDataFrameJson) r5;
        if (Intrinsics.areEqual(this.stage, r6.stage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.seq, r6.seq) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.count, r6.count) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.dataBase64, r6.dataBase64) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.assId, r6.assId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.assDataBase64, r6.assDataBase64) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.stage;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.scene;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.id;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.type;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.seq;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.count;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.dataBase64;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.assId;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.assDataBase64;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
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

    public String toString() {
        return "CameraDataFrameJson(stage=" + this.stage + ", scene=" + this.scene + ", id=" + this.id + ", type=" + this.type + ", seq=" + this.seq + ", count=" + this.count + ", dataBase64=" + this.dataBase64 + ", assId=" + this.assId + ", assDataBase64=" + this.assDataBase64 + ')';
    }

    public final String getAssDataBase64() {
        return this.assDataBase64;
    }

    public final Integer getAssId() {
        return this.assId;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final String getDataBase64() {
        return this.dataBase64;
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public final Integer getSeq() {
        return this.seq;
    }

    public final Integer getStage() {
        return this.stage;
    }

    public final Integer getType() {
        return this.type;
    }

    public CameraDataFrameJson(Integer r1, Integer r2, Integer r3, Integer r4, Integer r5, Integer r6, String r7, Integer r8, String r9) {
        this.stage = r1;
        this.scene = r2;
        this.id = r3;
        this.type = r4;
        this.seq = r5;
        this.count = r6;
        this.dataBase64 = r7;
        this.assId = r8;
        this.assDataBase64 = r9;
    }

    public /* synthetic */ CameraDataFrameJson(Integer r12, Integer r13, Integer r14, Integer r15, Integer r16, Integer r17, String r18, Integer r19, String r20, int r21, DefaultConstructorMarker r22) {
        Integer r2 = 0;
        if ((r21 & 1) == 0) goto L5;
        Integer r1 = r2;
    L7:
        if ((r21 & 2) == 0) goto L9;
        Integer r3 = r2;
    L11:
        if ((r21 & 4) == 0) goto L13;
        Integer r4 = r2;
    L15:
        if ((r21 & 8) == 0) goto L17;
        Integer r5 = r2;
    L19:
        if ((r21 & 16) == 0) goto L21;
        Integer r6 = r2;
    L23:
        if ((r21 & 32) == 0) goto L25;
        Integer r7 = r2;
    L26:
        String r9 = null;
        if ((r21 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r21 & 128) != 0) goto L35;
        r2 = r19;
    L35:
        if ((r21 & 256) != 0) goto L38;
        r9 = r20;
    L38:
        this(r1, r3, r4, r5, r6, r7, r8, r2, r9);
        return;
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L26
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
