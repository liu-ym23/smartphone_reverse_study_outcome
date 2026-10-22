package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.ProductLabelInfo")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductLabelInfo;", "Landroid/os/Parcelable;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "leftIconList", "Ljava/util/List;", "", "leftText", "Ljava/lang/String;", "rightText", "", "fontSize", "I", "fontColor", "borderColor", "", "dividingLine", "Z", "labelType", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductLabelInfo implements Parcelable, h {
    public static final Parcelable.Creator<ProductLabelInfo> CREATOR = null;

    @SerializedName("border_color")
    public String borderColor;

    @SerializedName("dividing_line")
    public boolean dividingLine;

    @SerializedName("font_color")
    public String fontColor;

    @SerializedName("font_size")
    public int fontSize;

    @SerializedName("label_type")
    public int labelType;

    @SerializedName("left_icon_list")
    public List<ImageModel> leftIconList;

    @SerializedName("left_text")
    public String leftText;

    @SerializedName("right_text")
    public String rightText;

    public static class a implements Parcelable.Creator<ProductLabelInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProductLabelInfo createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "in");
            if (r11.readInt() == 0) goto L7;
            int r1 = r11.readInt();
            ArrayList r2 = new ArrayList(r1);
        L5:
            if (r1 == 0) goto L8;
            r2.add(r11.readParcelable(ProductLabelInfo.class.getClassLoader()));
            r1 = r1 - 1;
        L8:
            String r3 = r11.readString();
            String r4 = r11.readString();
            int r5 = r11.readInt();
            String r6 = r11.readString();
            String r7 = r11.readString();
            if (r11.readInt() == 0) goto L11;
            boolean r8 = true;
        L13:
            return new ProductLabelInfo(r2, r3, r4, r5, r6, r7, r8, r11.readInt());
        L11:
            r8 = false;
            goto L13
        L7:
            r2 = null;
            goto L8
        }

        @Override // android.os.Parcelable.Creator
        public final ProductLabelInfo[] newArray(int r1) {
            return new ProductLabelInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProductLabelInfo(List<? extends ImageModel> r1, String r2, String r3, int r4, String r5, String r6, boolean r7, int r8) {
        this.leftIconList = r1;
        this.leftText = r2;
        this.rightText = r3;
        this.fontSize = r4;
        this.fontColor = r5;
        this.borderColor = r6;
        this.dividingLine = r7;
        this.labelType = r8;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ProductLabelInfo) == false) goto L22;
        ProductLabelInfo r4 = (ProductLabelInfo) r3;
        if (Intrinsics.areEqual(this.leftIconList, r4.leftIconList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.leftText, r4.leftText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rightText, r4.rightText) == true) goto L12;
        return false;
    L12:
        if (this.fontSize == r4.fontSize) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fontColor, r4.fontColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.borderColor, r4.borderColor) == true) goto L18;
        return false;
    L18:
        if (this.dividingLine == r4.dividingLine) goto L20;
        return false;
    L20:
        if (this.labelType == r4.labelType) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        List<ImageModel> r0 = this.leftIconList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.leftText;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.rightText;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + this.fontSize) * 31;
        String r10 = this.fontColor;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.borderColor;
        if (r13 == null) goto L21;
        r1 = r13.hashCode();
    L21:
        int r14 = (r12 + r1) * 31;
        boolean r15 = this.dividingLine;
        ?? r16 = r15;
        if (r15 == false) goto L25;
        r16 = 1;
    L25:
        return ((r14 + r16) * 31) + this.labelType;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductLabelInfo(leftIconList=" + this.leftIconList + ", leftText=" + this.leftText + ", rightText=" + this.rightText + ", fontSize=" + this.fontSize + ", fontColor=" + this.fontColor + ", borderColor=" + this.borderColor + ", dividingLine=" + this.dividingLine + ", labelType=" + this.labelType + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        List<ImageModel> r0 = this.leftIconList;
        if (r0 == null) goto L8;
        r3.writeInt(1);
        r3.writeInt(r0.size());
        Iterator<ImageModel> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r3.writeParcelable(r1.next(), r4);
    L9:
        r3.writeString(this.leftText);
        r3.writeString(this.rightText);
        r3.writeInt(this.fontSize);
        r3.writeString(this.fontColor);
        r3.writeString(this.borderColor);
        r3.writeInt(this.dividingLine ? 1 : 0);
        r3.writeInt(this.labelType);
        return;
    L8:
        r3.writeInt(0);
        goto L9
    }

    public ProductLabelInfo() {
        this.leftIconList = null;
        this.leftText = null;
        this.rightText = null;
        this.fontSize = 0;
        this.fontColor = null;
        this.borderColor = null;
        this.dividingLine = false;
        this.labelType = 0;
    }

    public ProductLabelInfo(am3.g r7) {
        this.leftIconList = new ArrayList();
        long r0 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L15;
        switch(r4) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.leftIconList.add(x.a(r7));
        goto L3
    L8:
        this.labelType = r7.i();
        r3 = r3 | 4;
        goto L3
    L9:
        this.dividingLine = am3.h.a(r7);
        r3 = r3 | 2;
        goto L3
    L10:
        this.borderColor = am3.h.c(r7);
        goto L3
    L11:
        this.fontColor = am3.h.c(r7);
        goto L3
    L12:
        this.fontSize = r7.i();
        r3 = r3 | 1;
        goto L3
    L13:
        this.rightText = am3.h.c(r7);
        goto L3
    L14:
        this.leftText = am3.h.c(r7);
        goto L3
    L6:
        am3.h.e(r7);
        goto L3
    L15:
        r7.d(r0);
        if (this.leftIconList.isEmpty() == false) goto L19;
        this.leftIconList = null;
    L19:
        if (this.leftText != null) goto L22;
        this.leftText = null;
    L22:
        if (this.rightText != null) goto L25;
        this.rightText = null;
    L25:
        if ((r3 & 1) != 0) goto L28;
        this.fontSize = 0;
    L28:
        if (this.fontColor != null) goto L31;
        this.fontColor = null;
    L31:
        if (this.borderColor != null) goto L34;
        this.borderColor = null;
    L34:
        if ((r3 & 2) != 0) goto L37;
        this.dividingLine = false;
    L37:
        if ((r3 & 4) != 0) goto L60;
        this.labelType = 0;
        return;
    }
}
