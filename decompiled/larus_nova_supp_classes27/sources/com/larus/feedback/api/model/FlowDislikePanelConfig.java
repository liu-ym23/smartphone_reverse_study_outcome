package com.larus.feedback.api.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.larus.bmhome.auth.FeedbackMeta;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010$\u001a\u00020\u000eHÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003Jn\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\fJ\u0013\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\fHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001d¨\u00063"}, d2 = {"Lcom/larus/feedback/api/model/FlowDislikePanelConfig;", "Landroid/os/Parcelable;", "requestKey", "", "metaList", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/auth/FeedbackMeta;", "Lkotlin/collections/ArrayList;", "inputPlaceholder", "extraData", "Landroid/os/Bundle;", "conversationType", "", "directReportReason", "", "reportForNewEndpointOutside", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Integer;ZZ)V", "getRequestKey", "()Ljava/lang/String;", "getMetaList", "()Ljava/util/ArrayList;", "getInputPlaceholder", "getExtraData", "()Landroid/os/Bundle;", "getConversationType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDirectReportReason", "()Z", "getReportForNewEndpointOutside", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Integer;ZZ)Lcom/larus/feedback/api/model/FlowDislikePanelConfig;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDislikePanelConfig implements Parcelable {
    public static final Parcelable.Creator<FlowDislikePanelConfig> CREATOR = null;
    public final String a;
    public final ArrayList<FeedbackMeta> b;
    public final String c;
    public final Bundle d;
    public final Integer e;
    public final boolean f;
    public final boolean g;

    public static final class a implements Parcelable.Creator<FlowDislikePanelConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FlowDislikePanelConfig createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            String r2 = r11.readString();
            Integer r3 = null;
            if (r11.readInt() != 0) goto L5;
            ArrayList r4 = null;
        L8:
            String r0 = r11.readString();
            Bundle r5 = r11.readBundle(FlowDislikePanelConfig.class.getClassLoader());
            if (r11.readInt() == 0) goto L12;
            r3 = Integer.valueOf(r11.readInt());
        L12:
            Integer r6 = r3;
            if (r11.readInt() == 0) goto L15;
            boolean r8 = true;
        L17:
            if (r11.readInt() == 0) goto L19;
            boolean r12 = true;
        L21:
            return new FlowDislikePanelConfig(r2, r4, r0, r5, r6, r8, r12);
        L19:
            r12 = false;
            goto L21
        L15:
            r8 = false;
            goto L17
        L5:
            int r1 = r11.readInt();
            r4 = new ArrayList(r1);
            int r7 = 0;
        L6:
            if (r7 == r1) goto L8;
            r4.add(r11.readParcelable(FlowDislikePanelConfig.class.getClassLoader()));
            r7 = r7 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final FlowDislikePanelConfig[] newArray(int r1) {
            return new FlowDislikePanelConfig[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FlowDislikePanelConfig) == true) goto L8;
        return false;
    L8:
        FlowDislikePanelConfig r6 = (FlowDislikePanelConfig) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        ArrayList<FeedbackMeta> r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Bundle r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.e;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        int r12 = (r10 + r2) * 31;
        int r13 = 1231;
        if (this.f == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.g == true) goto L27;
        r13 = 1237;
    L27:
        return r15 + r13;
    L21:
        r14 = 1237;
        goto L22
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
        return "FlowDislikePanelConfig(requestKey=" + this.a + ", metaList=" + this.b + ", inputPlaceholder=" + this.c + ", extraData=" + this.d + ", conversationType=" + this.e + ", directReportReason=" + this.f + ", reportForNewEndpointOutside=" + this.g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeString(this.a);
        ArrayList<FeedbackMeta> r0 = this.b;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L9:
        r5.writeString(this.c);
        r5.writeBundle(this.d);
        Integer r7 = this.e;
        if (r7 != null) goto L12;
        r5.writeInt(0);
    L13:
        r5.writeInt(this.f ? 1 : 0);
        r5.writeInt(this.g ? 1 : 0);
        return;
    L12:
        r5.writeInt(1);
        r5.writeInt(r7.intValue());
        goto L13
    L5:
        r5.writeInt(1);
        r5.writeInt(r0.size());
        Iterator<FeedbackMeta> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r5.writeParcelable((Parcelable) r1.next(), r6);
        goto L7
    }

    public FlowDislikePanelConfig(String r2, ArrayList<FeedbackMeta> r3, String r4, Bundle r5, Integer r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "requestKey");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
