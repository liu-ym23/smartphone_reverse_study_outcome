package com.bytedance.ai.applet.components.page;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.applet.render.core.RenderType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001dHÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lcom/bytedance/ai/applet/components/page/RenderUrlData;", "Landroid/os/Parcelable;", "renderType", "Lcom/bytedance/ai/applet/render/core/RenderType;", "transStatusBar", "", "hideNavBar", com.bytedance.android.ec.core.event.a.KEY_URL, "", "queryItems", "", "<init>", "(Lcom/bytedance/ai/applet/render/core/RenderType;ZZLjava/lang/String;Ljava/util/Map;)V", "getRenderType", "()Lcom/bytedance/ai/applet/render/core/RenderType;", "getTransStatusBar", "()Z", "getHideNavBar", "getUrl", "()Ljava/lang/String;", "getQueryItems", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderUrlData implements Parcelable {
    public static final Parcelable.Creator<RenderUrlData> CREATOR = null;
    public final RenderType a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final Map<String, String> e;

    public static final class a implements Parcelable.Creator<RenderUrlData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RenderUrlData createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            RenderType r11 = RenderType.valueOf(r10.readString());
            int r12 = 0;
            if (r10.readInt() == 0) goto L5;
            boolean r0 = true;
        L7:
            if (r10.readInt() == 0) goto L9;
            boolean r13 = true;
        L10:
            String r14 = r10.readString();
            int r1 = r10.readInt();
            LinkedHashMap r15 = new LinkedHashMap(r1);
        L11:
            if (r12 == r1) goto L14;
            r15.put(r10.readString(), r10.readString());
            r12 = r12 + 1;
            goto L11
        L14:
            return new RenderUrlData(r11, r0, r13, r14, r15);
        L9:
            r13 = false;
            goto L10
        L5:
            r0 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final RenderUrlData[] newArray(int r1) {
            return new RenderUrlData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof RenderUrlData) == true) goto L8;
        return false;
    L8:
        RenderUrlData r11 = (RenderUrlData) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r10 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r11 = (r0 + r1) * 31;
        if (this.c == true) goto L11;
        r10 = 1237;
    L11:
        return ((((r11 + r10) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "RenderUrlData(renderType=" + this.a + ", transStatusBar=" + this.b + ", hideNavBar=" + this.c + ", url=" + this.d + ", queryItems=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "dest");
        r10.writeString(this.a.name());
        r10.writeInt(this.b ? 1 : 0);
        r10.writeInt(this.c ? 1 : 0);
        r10.writeString(this.d);
        Map<String, String> r12 = this.e;
        r10.writeInt(r12.size());
        Iterator<Map.Entry<String, String>> r13 = r12.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry<String, String> r0 = r13.next();
        r10.writeString(r0.getKey());
        r10.writeString(r0.getValue());
        goto L4
    }

    public RenderUrlData(RenderType r10, boolean r11, boolean r12, String r13, Map<String, String> r14) {
        Intrinsics.checkNotNullParameter(r10, "renderType");
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r14, "queryItems");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
