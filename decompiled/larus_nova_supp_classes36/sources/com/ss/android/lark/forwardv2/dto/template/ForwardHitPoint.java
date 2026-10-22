package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0002*+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006,"}, d2 = {"Lcom/ss/android/lark/forwardv2/dto/template/ForwardHitPoint;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "searchBehaviorKey", "", "getSearchBehaviorKey", "()Ljava/lang/String;", "setSearchBehaviorKey", "(Ljava/lang/String;)V", "basicForwardSource", "getBasicForwardSource", "setBasicForwardSource", "forwardSourceChatType", "getForwardSourceChatType", "setForwardSourceChatType", "location", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardLocation;", "getLocation", "()Lcom/ss/android/lark/forwardv2/dto/template/ForwardLocation;", "setLocation", "(Lcom/ss/android/lark/forwardv2/dto/template/ForwardLocation;)V", "callType", "Lcom/ss/android/lark/forwardv2/dto/template/ForwardCallType;", "getCallType", "()Lcom/ss/android/lark/forwardv2/dto/template/ForwardCallType;", "setCallType", "(Lcom/ss/android/lark/forwardv2/dto/template/ForwardCallType;)V", "sourceMessageIds", "", "getSourceMessageIds", "()Ljava/util/List;", "setSourceMessageIds", "(Ljava/util/List;)V", "writeToParcel", "", "flags", "", "describeContents", "Builder", "CREATOR", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardHitPoint implements Parcelable {
    public static final b CREATOR = null;
    public String a;
    public String b;
    public String c;
    public ForwardLocation d;
    public ForwardCallType e;
    public List<String> f;

    public static final class a {
        public final ForwardLocation a;
        public final ForwardCallType b;
        public final List<String> c;

        /* JADX INFO: renamed from: com.ss.android.lark.forwardv2.dto.template.ForwardHitPoint$a$a, reason: collision with other inner class name */
        public static final class C0070a {
        }

        static {
        }

        public a() {
            this.a = ForwardLocation.OTHER;
            this.b = ForwardCallType.CLICK;
            this.c = new ArrayList();
        }
    }

    public static final class b implements Parcelable.Creator<ForwardHitPoint> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardHitPoint createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Intrinsics.checkNotNullParameter(r5, "parcel");
            ForwardHitPoint r1 = new ForwardHitPoint();
            r1.a = r5.readString();
            r1.b = r5.readString();
            r1.c = r5.readString();
            r1.f = r5.createStringArrayList();
            String r0 = r5.readString();
            ForwardCallType r2 = null;
            if (r0 == null) goto L5;
            ForwardLocation.Companion.getClass();
            ForwardLocation r3 = ForwardLocation.a.a(r0);
        L6:
            r1.d = r3;
            String r6 = r5.readString();
            if (r6 == null) goto L9;
            ForwardCallType.Companion.getClass();
            r2 = ForwardCallType.a.a(r6);
        L9:
            r1.e = r2;
            return r1;
        L5:
            r3 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardHitPoint[] newArray(int r1) {
            return new ForwardHitPoint[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardHitPoint() {
        this.d = ForwardLocation.OTHER;
        this.f = new ArrayList();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeString(this.a);
        r2.writeString(this.b);
        r2.writeString(this.c);
        r2.writeStringList(this.f);
        ForwardLocation r4 = this.d;
        String r0 = null;
        if (r4 == null) goto L5;
        String r5 = r4.getValue();
    L6:
        r2.writeString(r5);
        ForwardCallType r6 = this.e;
        if (r6 == null) goto L9;
        r0 = r6.getValue();
    L9:
        r2.writeString(r0);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
