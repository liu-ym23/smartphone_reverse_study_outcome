package com.obric.assistant.dora;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0001/B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010$\u001a\u00020\fJ\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\fHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u00060"}, d2 = {"Lcom/obric/assistant/dora/DoraMainProcessConnectResult;", "Landroid/os/Parcelable;", "requestId", "", "deviceInfo", "Lcom/obric/assistant/dora/DoraDeviceInfo;", "isBound", "", "connectAttempted", "connectSuccess", "shouldStartOnboarding", "errorCode", "", "errorMessage", "<init>", "(Ljava/lang/String;Lcom/obric/assistant/dora/DoraDeviceInfo;ZZZZILjava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "getDeviceInfo", "()Lcom/obric/assistant/dora/DoraDeviceInfo;", "()Z", "getConnectAttempted", "getConnectSuccess", "getShouldStartOnboarding", "getErrorCode", "()I", "getErrorMessage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraMainProcessConnectResult implements Parcelable {
    public static final Parcelable.Creator<DoraMainProcessConnectResult> CREATOR = null;
    public final String a;
    public final DoraDeviceInfo b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final int g;
    public final String h;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<DoraMainProcessConnectResult> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraMainProcessConnectResult createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            String r2 = r12.readString();
            DoraDeviceInfo r3 = (DoraDeviceInfo) DoraDeviceInfo.CREATOR.createFromParcel(r12);
            if (r12.readInt() == 0) goto L5;
            boolean r6 = true;
        L7:
            if (r12.readInt() == 0) goto L9;
            boolean r7 = true;
        L11:
            if (r12.readInt() == 0) goto L13;
            boolean r8 = true;
        L15:
            if (r12.readInt() == 0) goto L17;
            boolean r9 = true;
        L18:
            boolean r4 = r6;
            boolean r5 = r7;
            boolean r10 = r8;
            boolean r11 = r9;
            return new DoraMainProcessConnectResult(r2, r3, r4, r5, r10, r11, r12.readInt(), r12.readString());
        L17:
            r9 = false;
            goto L18
        L13:
            r8 = false;
            goto L15
        L9:
            r7 = false;
            goto L11
        L5:
            r6 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final DoraMainProcessConnectResult[] newArray(int r1) {
            return new DoraMainProcessConnectResult[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    public DoraMainProcessConnectResult() {
        this(null, null, false, false, false, 0, null, 255);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraMainProcessConnectResult) == true) goto L8;
        return false;
    L8:
        DoraMainProcessConnectResult r6 = (DoraMainProcessConnectResult) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        int r4 = 1231;
        if (this.c == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.d == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.e == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.f == true) goto L22;
        r4 = 1237;
    L22:
        int r11 = (((r10 + r4) * 31) + this.g) * 31;
        String r12 = this.h;
        if (r12 == null) goto L27;
        r1 = r12.hashCode();
    L27:
        return r11 + r1;
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraMainProcessConnectResult(requestId=" + this.a + ", deviceInfo=" + this.b + ", isBound=" + this.c + ", connectAttempted=" + this.d + ", connectSuccess=" + this.e + ", shouldStartOnboarding=" + this.f + ", errorCode=" + this.g + ", errorMessage=" + this.h + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.a);
        this.b.writeToParcel(r2, r3);
        r2.writeInt(this.c ? 1 : 0);
        r2.writeInt(this.d ? 1 : 0);
        r2.writeInt(this.e ? 1 : 0);
        r2.writeInt(this.f ? 1 : 0);
        r2.writeInt(this.g);
        r2.writeString(this.h);
    }

    public /* synthetic */ DoraMainProcessConnectResult(String r19, DoraDeviceInfo r20, boolean r21, boolean r22, boolean r23, int r24, String r25, int r26) {
        if ((r26 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r26 & 2) == 0) goto L9;
        DoraDeviceInfo r5 = new DoraDeviceInfo(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383);
    L11:
        if ((r26 & 4) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r26 & 8) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r26 & 32) == 0) goto L21;
        boolean r9 = false;
    L23:
        if ((r26 & 64) == 0) goto L25;
        int r10 = 0;
    L27:
        if ((r26 & 128) == 0) goto L29;
        String r11 = null;
    L30:
        this(r4, r5, r6, r7, false, r9, r10, r11);
        return;
    L29:
        r11 = r25;
        goto L30
    L25:
        r10 = r24;
        goto L27
    L21:
        r9 = r23;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public DoraMainProcessConnectResult(String r2, DoraDeviceInfo r3, boolean r4, boolean r5, boolean r6, boolean r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r3, "deviceInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
