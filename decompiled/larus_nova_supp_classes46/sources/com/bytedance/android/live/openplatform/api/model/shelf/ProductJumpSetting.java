package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.JumpSetting")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductJumpSetting;", "Landroid/os/Parcelable;", "", "isJumpToOtherPage", "Z", "", "jumpToOtherPageAppId", "Ljava/lang/String;", "jumpToOtherPagePath", "", "jumpToOtherPageQuery", "Ljava/util/Map;", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductJumpSetting implements Parcelable, h {
    public static final Parcelable.Creator<ProductJumpSetting> CREATOR = null;

    @SerializedName("is_jump_other_page")
    public boolean isJumpToOtherPage;

    @SerializedName("jump_other_appid")
    public String jumpToOtherPageAppId;

    @SerializedName("jump_other_page")
    public String jumpToOtherPagePath;

    @SerializedName("jump_other_query")
    public Map<String, String> jumpToOtherPageQuery;

    public static class a implements Parcelable.Creator<ProductJumpSetting> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProductJumpSetting createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "in");
            if (r9.readInt() == 0) goto L5;
            boolean r1 = true;
        L6:
            String r2 = r9.readString();
            String r3 = r9.readString();
            if (r9.readInt() == 0) goto L11;
            int r4 = r9.readInt();
            LinkedHashMap r5 = new LinkedHashMap(r4);
        L9:
            if (r4 == 0) goto L13;
            r5.put(r9.readString(), r9.readString());
            r4 = r4 - 1;
        L13:
            return new ProductJumpSetting(r1, r2, r3, r5);
        L11:
            r5 = null;
            goto L13
        L5:
            r1 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ProductJumpSetting[] newArray(int r1) {
            return new ProductJumpSetting[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProductJumpSetting(boolean r1, String r2, String r3, Map<String, String> r4) {
        this.isJumpToOtherPage = r1;
        this.jumpToOtherPageAppId = r2;
        this.jumpToOtherPagePath = r3;
        this.jumpToOtherPageQuery = r4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ProductJumpSetting) == false) goto L14;
        ProductJumpSetting r4 = (ProductJumpSetting) r3;
        if (this.isJumpToOtherPage == r4.isJumpToOtherPage) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.jumpToOtherPageAppId, r4.jumpToOtherPageAppId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpToOtherPagePath, r4.jumpToOtherPagePath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpToOtherPageQuery, r4.jumpToOtherPageQuery) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r0 = this.isJumpToOtherPage;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        String r3 = this.jumpToOtherPageAppId;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        String r7 = this.jumpToOtherPagePath;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        Map<String, String> r10 = this.jumpToOtherPageQuery;
        if (r10 == null) goto L17;
        r4 = r10.hashCode();
    L17:
        return r9 + r4;
    L12:
        r8 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "ProductJumpSetting(isJumpToOtherPage=" + this.isJumpToOtherPage + ", jumpToOtherPageAppId=" + this.jumpToOtherPageAppId + ", jumpToOtherPagePath=" + this.jumpToOtherPagePath + ", jumpToOtherPageQuery=" + this.jumpToOtherPageQuery + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeInt(this.isJumpToOtherPage ? 1 : 0);
        r3.writeString(this.jumpToOtherPageAppId);
        r3.writeString(this.jumpToOtherPagePath);
        Map<String, String> r5 = this.jumpToOtherPageQuery;
        if (r5 == null) goto L8;
        r3.writeInt(1);
        r3.writeInt(r5.size());
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L11;
        Map.Entry<String, String> r0 = r6.next();
        r3.writeString(r0.getKey());
        r3.writeString(r0.getValue());
        goto L6
    L11:
        return;
    L8:
        r3.writeInt(0);
    }

    public ProductJumpSetting() {
        this.isJumpToOtherPage = false;
        this.jumpToOtherPageAppId = null;
        this.jumpToOtherPagePath = null;
        this.jumpToOtherPageQuery = null;
    }

    public ProductJumpSetting(am3.g r13) {
        this.jumpToOtherPageQuery = new HashMap();
        long r0 = r13.c();
        boolean r3 = false;
    L3:
        int r4 = r13.f();
        String r7 = null;
        if (r4 == (-1)) goto L32;
        if (r4 != 1) goto L7;
        this.isJumpToOtherPage = am3.h.a(r13);
        r3 = r3 | true;
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this.jumpToOtherPageAppId = am3.h.c(r13);
        goto L3
    L9:
        if (r4 != 3) goto L11;
        this.jumpToOtherPagePath = am3.h.c(r13);
        goto L3
    L11:
        if (r4 != 4) goto L12;
        long r9 = r13.c();
        String r5 = null;
    L14:
        int r11 = r13.f();
        if (r11 == (-1)) goto L21;
        if (r11 != 1) goto L17;
        r7 = am3.h.c(r13);
        goto L14
    L17:
        if (r11 != 2) goto L18;
        r5 = am3.h.c(r13);
        goto L14
    L18:
        am3.h.e(r13);
        goto L14
    L21:
        r13.d(r9);
        Map<String, String> r6 = this.jumpToOtherPageQuery;
        if (r7 == null) goto L28;
        if (r5 == null) goto L26;
        r6.put(r7, r5);
        goto L3
    L26:
        throw new IllegalStateException("Value must not be null");
    L28:
        throw new IllegalStateException("Key must not be null");
    L12:
        am3.h.e(r13);
        goto L3
    L32:
        r13.d(r0);
        if ((r3 & true) == true) goto L36;
        this.isJumpToOtherPage = false;
    L36:
        if (this.jumpToOtherPageAppId != null) goto L39;
        this.jumpToOtherPageAppId = null;
    L39:
        if (this.jumpToOtherPagePath != null) goto L42;
        this.jumpToOtherPagePath = null;
    L42:
        if (this.jumpToOtherPageQuery != null) goto L71;
        this.jumpToOtherPageQuery = null;
        return;
    }
}
