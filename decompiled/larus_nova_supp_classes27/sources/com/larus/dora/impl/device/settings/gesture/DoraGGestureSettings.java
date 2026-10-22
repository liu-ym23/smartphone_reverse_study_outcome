package com.larus.dora.impl.device.settings.gesture;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0014J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0014HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettings;", "Landroid/os/Parcelable;", "role", "", "status", "gesture", "function", "<init>", "(BBBB)V", "getRole", "()B", "setRole", "(B)V", "getStatus", "setStatus", "getGesture", "setGesture", "getFunction", "setFunction", "roleText", "", "statusText", "gestureText", "functionText", "functionSubText", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGGestureSettings implements Parcelable {
    public static final Parcelable.Creator<DoraGGestureSettings> CREATOR = null;
    public final byte a;
    public final byte b;
    public final byte c;
    public final byte d;

    public static final class a implements Parcelable.Creator<DoraGGestureSettings> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraGGestureSettings createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            return new DoraGGestureSettings(r5.readByte(), r5.readByte(), r5.readByte(), r5.readByte());
        }

        @Override // android.os.Parcelable.Creator
        public final DoraGGestureSettings[] newArray(int r1) {
            return new DoraGGestureSettings[r1];
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
        if ((r5 instanceof DoraGGestureSettings) == true) goto L8;
        return false;
    L8:
        DoraGGestureSettings r6 = (DoraGGestureSettings) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "DoraGGestureSettings(role=" + this.a + ", status=" + this.b + ", gesture=" + this.c + ", function=" + this.d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeByte(this.a);
        r1.writeByte(this.b);
        r1.writeByte(this.c);
        r1.writeByte(this.d);
    }

    public final String b() {
        byte r0 = this.b;
        if (r0 != 6) goto L9;
        byte r1 = this.c;
        if (r1 != 2) goto L7;
    L8:
        boolean r2 = true;
    L11:
        if (r0 != 4) goto L18;
        if (this.c != 2) goto L18;
        if (this.d != 37) goto L18;
        int r3 = j0.a;
        return j0.d(2131902739);
    L18:
        if (r2 == false) goto L23;
        if (this.d != 34) goto L23;
        int r4 = j0.a;
        return j0.d(2131902748);
    L23:
        if (r2 == false) goto L28;
        if (this.d != 40) goto L28;
        int r5 = j0.a;
        return j0.d(2131902747);
    L28:
        if (r2 == true) goto L30;
    L32:
        byte r6 = this.d;
        if (r6 != 37) goto L36;
        int r7 = j0.a;
        return j0.d(2131903045);
    L36:
        if (r6 != 38) goto L38;
        int r8 = j0.a;
        return j0.d(2131903043);
    L38:
        if (r6 != 33) goto L41;
        int r9 = j0.a;
        return j0.d(2131903029);
    L41:
        if (r6 != 35) goto L44;
        int r10 = j0.a;
        return j0.d(2131904053);
    L44:
        if (r6 != 32) goto L46;
        int r11 = j0.a;
        return j0.d(2131904050);
    L46:
        if (r6 != 34) goto L49;
        int r12 = j0.a;
        return j0.d(2131903049);
    L49:
        if (r6 != 39) goto L51;
        int r13 = j0.a;
        return j0.d(2131902368);
    L51:
        if (r6 != 40) goto L53;
        int r14 = j0.a;
        return j0.d(2131903019);
    L53:
        return "";
    L30:
        if (this.d != 33) goto L32;
        int r15 = j0.a;
        return j0.d(2131902749);
    L7:
        if (r1 == 3) goto L8;
    L9:
        r2 = false;
        goto L11
    }

    public final String c() {
        byte r0 = this.b;
        if (r0 != 6) goto L24;
        byte r1 = this.d;
        if (r1 != 16) goto L8;
        int r2 = j0.a;
        return j0.d(2131903033);
    L8:
        if (r1 != 19) goto L11;
        int r3 = j0.a;
        return j0.d(2131903034);
    L11:
        if (r1 != 20) goto L13;
        int r4 = j0.a;
        return j0.d(2131903032);
    L13:
        if (r1 != 6) goto L15;
        int r5 = j0.a;
        return j0.d(2131903037);
    L15:
        if (r1 != 34) goto L17;
        int r6 = j0.a;
        return j0.d(2131903048);
    L17:
        if (r1 != 40) goto L19;
        int r7 = j0.a;
        return j0.d(2131903160);
    L19:
        if (r1 != 33) goto L21;
        int r8 = j0.a;
        return j0.d(2131903028);
    L21:
        if (r1 != 0) goto L70;
        int r9 = j0.a;
        return j0.d(2131903039);
    L70:
        return "";
    L24:
        if (r0 != 1) goto L38;
        byte r10 = this.d;
        if (r10 != 1) goto L28;
        int r11 = j0.a;
        return j0.d(2131903003);
    L28:
        if (r10 != 2) goto L31;
        int r12 = j0.a;
        return j0.d(2131902999);
    L31:
        if (r10 != 3) goto L33;
        int r13 = j0.a;
        return j0.d(2131903002);
    L33:
        if (r10 != 4) goto L35;
        int r14 = j0.a;
        return j0.d(2131903007);
    L35:
        if (r10 != 0) goto L70;
        int r15 = j0.a;
        return j0.d(2131903039);
    L38:
        if (r0 != 2) goto L59;
        byte r16 = this.d;
        if (r16 != 33) goto L43;
        int r17 = j0.a;
        return j0.d(2131903028);
    L43:
        if (r16 != 35) goto L46;
        int r18 = j0.a;
        return j0.d(2131904054);
    L46:
        if (r16 != 32) goto L48;
        int r20 = j0.a;
        return j0.d(2131904051);
    L48:
        if (r16 != 34) goto L50;
        int r21 = j0.a;
        return j0.d(2131903048);
    L50:
        if (r16 != 37) goto L53;
        int r22 = j0.a;
        return j0.d(2131903044);
    L53:
        if (r16 != 38) goto L55;
        int r23 = j0.a;
        return j0.d(2131903042);
    L55:
        if (r16 != 40) goto L57;
        int r24 = j0.a;
        return j0.d(2131903160);
    L57:
        if (r16 != 0) goto L70;
        int r25 = j0.a;
        return j0.d(2131903039);
    L59:
        if (r0 != 4) goto L70;
        byte r26 = this.d;
        if (r26 != 33) goto L63;
        int r27 = j0.a;
        return j0.d(2131903028);
    L63:
        if (r26 != 37) goto L66;
        int r28 = j0.a;
        return j0.d(2131903044);
    L66:
        if (r26 != 39) goto L68;
        int r30 = j0.a;
        return j0.d(2131902367);
    L68:
        if (r26 != 0) goto L70;
        int r31 = j0.a;
        return j0.d(2131903039);
    }

    public final String d() {
        byte r0 = this.c;
        if (r0 != 1) goto L6;
        int r1 = j0.a;
        return j0.d(2131903009);
    L6:
        if (r0 != 2) goto L9;
        int r2 = j0.a;
        return j0.d(2131903014);
    L9:
        if (r0 != 3) goto L12;
        int r3 = j0.a;
        return j0.d(2131903056);
    L12:
        if (r0 != 16) goto L15;
        int r4 = j0.a;
        return j0.d(2131903050);
    L15:
        if (r0 != 6) goto L17;
        int r5 = j0.a;
        return j0.d(2131903041);
    L17:
        return "";
    }

    public final String e() {
        byte r0 = this.a;
        if (r0 != 16) goto L5;
        int r1 = j0.a;
        return j0.d(2131903027);
    L5:
        if (r0 != 0) goto L7;
        int r2 = j0.a;
        return j0.d(2131903047);
    L7:
        return "";
    }

    public final String g() {
        byte r0 = this.b;
        if (r0 != 6) goto L6;
        int r1 = j0.a;
        return j0.d(2131902741);
    L6:
        if (r0 != 1) goto L9;
        int r2 = j0.a;
        return j0.d(2131903004);
    L9:
        if (r0 != 2) goto L11;
        int r3 = j0.a;
        return j0.d(2131903012);
    L11:
        return "";
    }

    public static DoraGGestureSettings a(DoraGGestureSettings r4, byte r5, int r6) {
        byte r1 = 0;
        if ((r6 & 1) == 0) goto L5;
        byte r0 = r4.a;
    L7:
        if ((r6 & 2) == 0) goto L9;
        byte r2 = r4.b;
    L11:
        if ((r6 & 4) == 0) goto L14;
        r1 = r4.c;
    L14:
        if ((r6 & 8) == 0) goto L16;
        r5 = r4.d;
    L16:
        r4.getClass();
        return new DoraGGestureSettings(r0, r2, r1, r5);
    L9:
        r2 = 0;
        goto L11
    L5:
        r0 = 0;
        goto L7
    }

    public DoraGGestureSettings(byte r1, byte r2, byte r3, byte r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
