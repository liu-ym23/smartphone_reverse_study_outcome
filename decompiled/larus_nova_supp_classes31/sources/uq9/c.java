package uq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003Jw\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006!"}, d2 = {"Lcom/larus/platform/model/ecommerce/ECAppletNavigationConfig;", "", "type", "", "allowPageWhiteListHybrid", "", "", "firstPageWhiteListHybrid", "originPageWhiteListNa", "flagPageBlackListNa", "lightPageBlackListNa", "<init>", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getType", "()I", "getAllowPageWhiteListHybrid", "()Ljava/util/List;", "getFirstPageWhiteListHybrid", "getOriginPageWhiteListNa", "getFlagPageBlackListNa", "getLightPageBlackListNa", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class c {

    @SerializedName("allow_page_white_list_hybrid")
    private final List<String> allowPageWhiteListHybrid;

    @SerializedName("first_page_white_list_hybrid")
    private final List<String> firstPageWhiteListHybrid;

    @SerializedName("flag_page_black_list_na")
    private final List<String> flagPageBlackListNa;

    @SerializedName("light_page_black_list_na")
    private final List<String> lightPageBlackListNa;

    @SerializedName("origin_page_white_list_na")
    private final List<String> originPageWhiteListNa;

    @SerializedName("type")
    private final int type;

    public c() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.allowPageWhiteListHybrid, r6.allowPageWhiteListHybrid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.firstPageWhiteListHybrid, r6.firstPageWhiteListHybrid) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.originPageWhiteListNa, r6.originPageWhiteListNa) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.flagPageBlackListNa, r6.flagPageBlackListNa) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lightPageBlackListNa, r6.lightPageBlackListNa) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.type * 31;
        List<String> r1 = this.allowPageWhiteListHybrid;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<String> r5 = this.firstPageWhiteListHybrid;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        List<String> r8 = this.originPageWhiteListNa;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        List<String> r11 = this.flagPageBlackListNa;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        List<String> r14 = this.lightPageBlackListNa;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ECAppletNavigationConfig(type=" + this.type + ", allowPageWhiteListHybrid=" + this.allowPageWhiteListHybrid + ", firstPageWhiteListHybrid=" + this.firstPageWhiteListHybrid + ", originPageWhiteListNa=" + this.originPageWhiteListNa + ", flagPageBlackListNa=" + this.flagPageBlackListNa + ", lightPageBlackListNa=" + this.lightPageBlackListNa + ')';
    }

    public final List<String> a() {
        return this.allowPageWhiteListHybrid;
    }

    public final List<String> b() {
        return this.firstPageWhiteListHybrid;
    }

    public final List<String> c() {
        return this.flagPageBlackListNa;
    }

    public final List<String> d() {
        return this.originPageWhiteListNa;
    }

    public final int getType() {
        return this.type;
    }

    public c(Object r1) {
        this.type = 0;
        this.allowPageWhiteListHybrid = null;
        this.firstPageWhiteListHybrid = null;
        this.originPageWhiteListNa = null;
        this.flagPageBlackListNa = null;
        this.lightPageBlackListNa = null;
    }
}
