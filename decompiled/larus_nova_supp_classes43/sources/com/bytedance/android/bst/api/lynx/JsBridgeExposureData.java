package com.bytedance.android.bst.api.lynx;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003JY\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"Lcom/bytedance/android/bst/api/lynx/JsBridgeExposureData;", "", "btm", "", "uniqueId", "", "cardId", "biz", "model", "exposureRepeatedly", "", "eventName", "data", "Lorg/json/JSONObject;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lorg/json/JSONObject;)V", "getBiz", "()Ljava/lang/String;", "getBtm", "getCardId", "getData", "()Lorg/json/JSONObject;", "getEventName", "setEventName", "(Ljava/lang/String;)V", "getExposureRepeatedly", "()Z", "setExposureRepeatedly", "(Z)V", "getModel", "getUniqueId", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "api_cnRelease"}, k = 1, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class JsBridgeExposureData {
    private final String biz;
    private final String btm;
    private final String cardId;
    private final JSONObject data;
    private String eventName;
    private boolean exposureRepeatedly;
    private final String model;
    private final int uniqueId;

    public static /* synthetic */ JsBridgeExposureData copy$default(JsBridgeExposureData r10, String r11, int r12, String r13, String r14, String r15, boolean r16, String r17, JSONObject r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r20 = r10.btm;
    L7:
        if ((r19 & 2) == 0) goto L9;
        int r21 = r10.uniqueId;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r22 = r10.cardId;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r23 = r10.biz;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r24 = r10.model;
    L23:
        if ((r19 & 32) == 0) goto L25;
        boolean r25 = r10.exposureRepeatedly;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r26 = r10.eventName;
    L31:
        if ((r19 & 128) == 0) goto L33;
        JSONObject r1 = r10.data;
    L35:
        return r10.copy(r20, r21, r22, r23, r24, r25, r26, r1);
    L33:
        r1 = r18;
        goto L35
    L29:
        r26 = r17;
        goto L31
    L25:
        r25 = r16;
        goto L27
    L21:
        r24 = r15;
        goto L23
    L17:
        r23 = r14;
        goto L19
    L13:
        r22 = r13;
        goto L15
    L9:
        r21 = r12;
        goto L11
    L5:
        r20 = r11;
        goto L7
    }

    public final String component1() {
        return this.btm;
    }

    public final int component2() {
        return this.uniqueId;
    }

    public final String component3() {
        return this.cardId;
    }

    public final String component4() {
        return this.biz;
    }

    public final String component5() {
        return this.model;
    }

    public final boolean component6() {
        return this.exposureRepeatedly;
    }

    public final String component7() {
        return this.eventName;
    }

    public final JSONObject component8() {
        return this.data;
    }

    public final JsBridgeExposureData copy(String r11, int r12, String r13, String r14, String r15, boolean r16, String r17, JSONObject r18) {
        return new JsBridgeExposureData(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof JsBridgeExposureData) == false) goto L22;
        JsBridgeExposureData r11 = (JsBridgeExposureData) r10;
        if (Intrinsics.areEqual(this.btm, r11.btm) == true) goto L8;
        return false;
    L8:
        if (this.uniqueId == r11.uniqueId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cardId, r11.cardId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.biz, r11.biz) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.model, r11.model) == true) goto L16;
        return false;
    L16:
        if (this.exposureRepeatedly == r11.exposureRepeatedly) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.eventName, r11.eventName) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.data, r11.data) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v21 */
    public int hashCode() {
        String r0 = this.btm;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = ((r10 * 31) + this.uniqueId) * 31;
        String r12 = this.cardId;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.biz;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.model;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        boolean r21 = this.exposureRepeatedly;
        ?? r22 = r21;
        if (r21 == false) goto L21;
        r22 = 1;
    L21:
        int r23 = (r20 + r22) * 31;
        String r24 = this.eventName;
        if (r24 == null) goto L24;
        int r25 = r24.hashCode();
    L25:
        int r26 = (r23 + r25) * 31;
        JSONObject r27 = this.data;
        if (r27 == null) goto L29;
        r1 = r27.hashCode();
    L29:
        return r26 + r1;
    L24:
        r25 = 0;
        goto L25
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "JsBridgeExposureData(btm=" + this.btm + ", uniqueId=" + this.uniqueId + ", cardId=" + this.cardId + ", biz=" + this.biz + ", model=" + this.model + ", exposureRepeatedly=" + this.exposureRepeatedly + ", eventName=" + this.eventName + ", data=" + this.data + ")";
    }

    public final String getBiz() {
        return this.biz;
    }

    public final String getBtm() {
        return this.btm;
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final JSONObject getData() {
        return this.data;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final boolean getExposureRepeatedly() {
        return this.exposureRepeatedly;
    }

    public final String getModel() {
        return this.model;
    }

    public final int getUniqueId() {
        return this.uniqueId;
    }

    public final void setEventName(String r1) {
        this.eventName = r1;
    }

    public final void setExposureRepeatedly(boolean r1) {
        this.exposureRepeatedly = r1;
    }

    public JsBridgeExposureData(String r1, int r10, String r11, String r12, String r13, boolean r14, String r15, JSONObject r16) {
        this.btm = r1;
        this.uniqueId = r10;
        this.cardId = r11;
        this.biz = r12;
        this.model = r13;
        this.exposureRepeatedly = r14;
        this.eventName = r15;
        this.data = r16;
    }
}
