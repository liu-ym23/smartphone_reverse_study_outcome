package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/GetPocketPageDataResponseData;", "", "pocketPageData", "Lcom/larus/uaigc/lynx/pocket/PocketPageData;", "versionCode", "", "<init>", "(Lcom/larus/uaigc/lynx/pocket/PocketPageData;Ljava/lang/String;)V", "getPocketPageData", "()Lcom/larus/uaigc/lynx/pocket/PocketPageData;", "getVersionCode", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GetPocketPageDataResponseData {

    @SerializedName("pocket_page_data")
    private final PocketPageData pocketPageData;

    @SerializedName("version_code")
    private final String versionCode;

    /* JADX WARN: Multi-variable type inference failed */
    public GetPocketPageDataResponseData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GetPocketPageDataResponseData copy$default(GetPocketPageDataResponseData r0, PocketPageData r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.pocketPageData;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.versionCode;
    L9:
        return r0.copy(r1, r2);
    }

    public final PocketPageData component1() {
        return this.pocketPageData;
    }

    public final String component2() {
        return this.versionCode;
    }

    public final GetPocketPageDataResponseData copy(PocketPageData r2, String r3) {
        return new GetPocketPageDataResponseData(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetPocketPageDataResponseData) == true) goto L8;
        return false;
    L8:
        GetPocketPageDataResponseData r6 = (GetPocketPageDataResponseData) r5;
        if (Intrinsics.areEqual(this.pocketPageData, r6.pocketPageData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.versionCode, r6.versionCode) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        PocketPageData r0 = this.pocketPageData;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.versionCode;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GetPocketPageDataResponseData(pocketPageData=" + this.pocketPageData + ", versionCode=" + this.versionCode + ')';
    }

    public final PocketPageData getPocketPageData() {
        return this.pocketPageData;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public GetPocketPageDataResponseData(PocketPageData r1, String r2) {
        this.pocketPageData = r1;
        this.versionCode = r2;
    }

    public /* synthetic */ GetPocketPageDataResponseData(PocketPageData r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
