package com.bytedance.ai.applet.components.page;

import a5.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.applet.render.core.RenderType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kk.a;
import kn.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/applet/components/page/RenderUrlData;", "Landroid/os/Parcelable;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RenderUrlData implements Parcelable {
    public static final Parcelable.Creator<RenderUrlData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RenderType f1716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1718c;
    public final String d;
    public final LinkedHashMap e;

    static {
        CREATOR = new b(11);
    }

    public RenderUrlData(RenderType r5, boolean r10, boolean r11, String r12, LinkedHashMap r13) {
        Intrinsics.checkNotNullParameter(r5, "renderType");
        Intrinsics.checkNotNullParameter(r12, "url");
        Intrinsics.checkNotNullParameter(r13, "queryItems");
        this.f1716a = r5;
        this.f1717b = r10;
        this.f1718c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RenderUrlData) == true) goto L8;
        return false;
    L8:
        RenderUrlData r10 = (RenderUrlData) r5;
        RenderType r11 = r10.f1716a;
        if (this.f1716a == r11) goto L12;
        return false;
    L12:
        if (this.f1717b == r10.f1717b) goto L15;
        return false;
    L15:
        if (this.f1718c == r10.f1718c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = e.a(e.a(this.f1716a.hashCode() * 31, 31, this.f1717b), 31, this.f1718c);
        int r10 = a.b(this.d, r5, 31);
        return this.e.hashCode() + r10;
    }

    public final String toString() {
        return "RenderUrlData(renderType=" + this.f1716a + ", transStatusBar=" + this.f1717b + ", hideNavBar=" + this.f1718c + ", url=" + this.d + ", queryItems=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeString(this.f1716a.name());
        r5.writeInt(this.f1717b ? 1 : 0);
        r5.writeInt(this.f1718c ? 1 : 0);
        r5.writeString(this.d);
        LinkedHashMap r11 = this.e;
        r5.writeInt(r11.size());
        Iterator r12 = r11.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry r13 = (Map.Entry) r12.next();
        r5.writeString((String) r13.getKey());
        r5.writeString((String) r13.getValue());
        goto L4
    }
}
