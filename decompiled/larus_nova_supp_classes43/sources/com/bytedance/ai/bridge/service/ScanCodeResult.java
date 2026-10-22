package com.bytedance.ai.bridge.service;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/bridge/service/ScanCodeResult;", "", "characterSet", "", "path", "rawData", a.KEY_RESULT, "scanType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCharacterSet", "()Ljava/lang/String;", "getPath", "getRawData", "getResult", "getScanType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanCodeResult {
    private final String characterSet;
    private final String path;
    private final String rawData;
    private final String result;
    private final String scanType;

    public static /* synthetic */ ScanCodeResult copy$default(ScanCodeResult r10, String r11, String r12, String r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.characterSet;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.path;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.rawData;
    L11:
        String r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.result;
    L14:
        String r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.scanType;
    L17:
        String r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final String component1() {
        return this.characterSet;
    }

    public final String component2() {
        return this.path;
    }

    public final String component3() {
        return this.rawData;
    }

    public final String component4() {
        return this.result;
    }

    public final String component5() {
        return this.scanType;
    }

    public final ScanCodeResult copy(String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "characterSet");
        Intrinsics.checkNotNullParameter(r11, "path");
        Intrinsics.checkNotNullParameter(r12, "rawData");
        Intrinsics.checkNotNullParameter(r13, a.KEY_RESULT);
        Intrinsics.checkNotNullParameter(r14, "scanType");
        return new ScanCodeResult(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ScanCodeResult) == true) goto L8;
        return false;
    L8:
        ScanCodeResult r11 = (ScanCodeResult) r10;
        if (Intrinsics.areEqual(this.characterSet, r11.characterSet) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.path, r11.path) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rawData, r11.rawData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.result, r11.result) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.scanType, r11.scanType) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.characterSet.hashCode() * 31) + this.path.hashCode()) * 31) + this.rawData.hashCode()) * 31) + this.result.hashCode()) * 31) + this.scanType.hashCode();
    }

    public String toString() {
        return "ScanCodeResult(characterSet=" + this.characterSet + ", path=" + this.path + ", rawData=" + this.rawData + ", result=" + this.result + ", scanType=" + this.scanType + ')';
    }

    public final String getCharacterSet() {
        return this.characterSet;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final String getResult() {
        return this.result;
    }

    public final String getScanType() {
        return this.scanType;
    }

    public ScanCodeResult(String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "characterSet");
        Intrinsics.checkNotNullParameter(r11, "path");
        Intrinsics.checkNotNullParameter(r12, "rawData");
        Intrinsics.checkNotNullParameter(r13, a.KEY_RESULT);
        Intrinsics.checkNotNullParameter(r14, "scanType");
        this.characterSet = r10;
        this.path = r11;
        this.rawData = r12;
        this.result = r13;
        this.scanType = r14;
    }

    public /* synthetic */ ScanCodeResult(String r10, String r11, String r12, String r13, String r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        String r17 = "";
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r18 = "";
    L11:
        if ((r15 & 4) == 0) goto L13;
        String r19 = "";
    L14:
        this(r17, r18, r19, r13, r14);
        return;
    L13:
        r19 = r12;
        goto L14
    L9:
        r18 = r11;
        goto L11
    L5:
        r17 = r10;
        goto L7
    }
}
