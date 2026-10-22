package com.bytedance.android.annie.scheme.vo.refactor;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/HybridSchemaParam;", "Landroid/os/Parcelable;", "a", "annie_release"}, k = 1, mv = {1, 4, 3})
public class HybridSchemaParam implements Parcelable {
    public static final Parcelable.Creator<HybridSchemaParam> CREATOR = null;
    public final boolean A;
    public final boolean B;
    public final String C;
    public int D;
    public final boolean E;
    public final boolean F;
    public final int G;
    public final int H;
    public final String I;
    public final boolean J;
    public final boolean K;
    public final int L;
    public final boolean M;
    public final String N;
    public final boolean O;
    public final boolean P;
    public final boolean Q;
    public HybridKitType a;
    public String b;
    public String c;
    public final String d;
    public final boolean e;
    public boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final String k;
    public final boolean l;
    public final int m;
    public final String n;
    public final String o;
    public final boolean p;
    public final boolean q;
    public final Boolean r;
    public final boolean s;
    public final String t;
    public final String u;
    public final Integer v;
    public final Integer w;
    public final String x;
    public int y;
    public final int z;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<HybridSchemaParam> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final HybridSchemaParam createFromParcel(Parcel r49) {
            Intrinsics.checkNotNullParameter(r49, "parcel");
            HybridKitType r10 = HybridKitType.valueOf(r49.readString());
            String r11 = r49.readString();
            String r12 = r49.readString();
            String r13 = r49.readString();
            if (r49.readInt() == 0) goto L5;
            boolean r14 = true;
        L7:
            if (r49.readInt() == 0) goto L9;
            boolean r15 = true;
        L11:
            if (r49.readInt() == 0) goto L13;
            boolean r16 = true;
        L15:
            if (r49.readInt() == 0) goto L17;
            boolean r17 = true;
        L19:
            if (r49.readInt() == 0) goto L21;
            boolean r18 = true;
        L23:
            if (r49.readInt() == 0) goto L25;
            boolean r19 = true;
        L26:
            String r110 = r49.readString();
            if (r49.readInt() == 0) goto L29;
            boolean r111 = true;
        L30:
            int r112 = r49.readInt();
            String r113 = r49.readString();
            String r114 = r49.readString();
            if (r49.readInt() == 0) goto L33;
            boolean r115 = true;
        L35:
            if (r49.readInt() == 0) goto L37;
            boolean r20 = true;
        L38:
            Integer r22 = null;
            if (r49.readInt() != 0) goto L42;
            Boolean r21 = null;
        L47:
            if (r49.readInt() == 0) goto L49;
            boolean r23 = true;
        L50:
            String r24 = r49.readString();
            String r25 = r49.readString();
            if (r49.readInt() != 0) goto L53;
            Integer r26 = null;
        L55:
            if (r49.readInt() == 0) goto L58;
            r22 = Integer.valueOf(r49.readInt());
        L58:
            Integer r27 = r22;
            String r28 = r49.readString();
            int r29 = r49.readInt();
            int r30 = r49.readInt();
            if (r49.readInt() == 0) goto L61;
            boolean r31 = true;
        L63:
            if (r49.readInt() == 0) goto L65;
            boolean r32 = true;
        L66:
            String r33 = r49.readString();
            int r34 = r49.readInt();
            if (r49.readInt() == 0) goto L69;
            boolean r35 = true;
        L71:
            if (r49.readInt() == 0) goto L73;
            boolean r36 = true;
        L74:
            int r37 = r49.readInt();
            int r38 = r49.readInt();
            String r39 = r49.readString();
            if (r49.readInt() == 0) goto L77;
            boolean r40 = true;
        L79:
            if (r49.readInt() == 0) goto L81;
            boolean r41 = true;
        L82:
            int r42 = r49.readInt();
            if (r49.readInt() == 0) goto L85;
            boolean r43 = true;
        L86:
            String r44 = r49.readString();
            if (r49.readInt() == 0) goto L89;
            boolean r45 = true;
        L91:
            if (r49.readInt() == 0) goto L93;
            boolean r46 = true;
        L95:
            if (r49.readInt() == 0) goto L97;
            boolean r47 = true;
        L99:
            return new HybridSchemaParam(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47);
        L97:
            r47 = false;
            goto L99
        L93:
            r46 = false;
            goto L95
        L89:
            r45 = false;
            goto L91
        L85:
            r43 = false;
            goto L86
        L81:
            r41 = false;
            goto L82
        L77:
            r40 = false;
            goto L79
        L73:
            r36 = false;
            goto L74
        L69:
            r35 = false;
            goto L71
        L65:
            r32 = false;
            goto L66
        L61:
            r31 = false;
            goto L63
        L53:
            r26 = Integer.valueOf(r49.readInt());
            goto L55
        L49:
            r23 = false;
            goto L50
        L42:
            if (r49.readInt() == 0) goto L44;
            boolean r210 = true;
        L45:
            r21 = Boolean.valueOf(r210);
            goto L47
        L44:
            r210 = false;
            goto L45
        L37:
            r20 = false;
            goto L38
        L33:
            r115 = false;
            goto L35
        L29:
            r111 = false;
            goto L30
        L25:
            r19 = false;
            goto L26
        L21:
            r18 = false;
            goto L23
        L17:
            r17 = false;
            goto L19
        L13:
            r16 = false;
            goto L15
        L9:
            r15 = false;
            goto L11
        L5:
            r14 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final HybridSchemaParam[] newArray(int r1) {
            return new HybridSchemaParam[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    public HybridSchemaParam() {
        this(0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "out");
        r10.writeString(this.a.name());
        r10.writeString(this.b);
        r10.writeString(this.c);
        r10.writeString(this.d);
        r10.writeInt(this.e ? 1 : 0);
        r10.writeInt(this.f ? 1 : 0);
        r10.writeInt(this.g ? 1 : 0);
        r10.writeInt(this.h ? 1 : 0);
        r10.writeInt(this.i ? 1 : 0);
        r10.writeInt(this.j ? 1 : 0);
        r10.writeString(this.k);
        r10.writeInt(this.l ? 1 : 0);
        r10.writeInt(this.m);
        r10.writeString(this.n);
        r10.writeString(this.o);
        r10.writeInt(this.p ? 1 : 0);
        r10.writeInt(this.q ? 1 : 0);
        Boolean r12 = this.r;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        r10.writeInt(this.s ? 1 : 0);
        r10.writeString(this.t);
        r10.writeString(this.u);
        Integer r13 = this.v;
        if (r13 != null) goto L9;
        r10.writeInt(0);
    L10:
        Integer r14 = this.w;
        if (r14 != null) goto L13;
        r10.writeInt(0);
    L14:
        r10.writeString(this.x);
        r10.writeInt(this.y);
        r10.writeInt(this.z);
        r10.writeInt(this.A ? 1 : 0);
        r10.writeInt(this.B ? 1 : 0);
        r10.writeString(this.C);
        r10.writeInt(this.D);
        r10.writeInt(this.E ? 1 : 0);
        r10.writeInt(this.F ? 1 : 0);
        r10.writeInt(this.G);
        r10.writeInt(this.H);
        r10.writeString(this.I);
        r10.writeInt(this.J ? 1 : 0);
        r10.writeInt(this.K ? 1 : 0);
        r10.writeInt(this.L);
        r10.writeInt(this.M ? 1 : 0);
        r10.writeString(this.N);
        r10.writeInt(this.O ? 1 : 0);
        r10.writeInt(this.P ? 1 : 0);
        r10.writeInt(this.Q ? 1 : 0);
        return;
    L13:
        r10.writeInt(1);
        r10.writeInt(r14.intValue());
        goto L14
    L9:
        r10.writeInt(1);
        r10.writeInt(r13.intValue());
        goto L10
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.booleanValue() ? 1 : 0);
        goto L6
    }

    public /* synthetic */ HybridSchemaParam(int r45) {
        this(HybridKitType.WEB, "", "", "hybridkit_default_bid", false, false, false, false, false, false, null, false, 1, "", "", false, false, null, false, "default_lynx_group", "", null, null, "", -1, -1, false, true, "", 0, true, false, 0, -1, "", false, false, 0, false, "", false, true, false);
    }

    public HybridSchemaParam(HybridKitType r15, String r16, String r17, String r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, String r25, boolean r26, int r27, String r28, String r29, boolean r30, boolean r31, Boolean r32, boolean r33, String r34, String r35, Integer r36, Integer r37, String r38, int r39, int r40, boolean r41, boolean r42, String r43, int r44, boolean r45, boolean r46, int r47, int r48, String r49, boolean r50, boolean r51, int r52, boolean r53, String r54, boolean r55, boolean r56, boolean r57) {
        Intrinsics.checkNotNullParameter(r15, "engineType");
        Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r17, "fallbackUrl");
        Intrinsics.checkNotNullParameter(r18, "bid");
        Intrinsics.checkNotNullParameter(r28, "bundle");
        Intrinsics.checkNotNullParameter(r29, "channel");
        Intrinsics.checkNotNullParameter(r34, "group");
        Intrinsics.checkNotNullParameter(r35, "initialData");
        Intrinsics.checkNotNullParameter(r38, "preloadFonts");
        Intrinsics.checkNotNullParameter(r43, "surl");
        Intrinsics.checkNotNullParameter(r49, "secLinkScene");
        Intrinsics.checkNotNullParameter(r54, "preloadSettingsKeys");
        this.a = r15;
        this.b = r16;
        this.c = r17;
        this.d = r18;
        this.e = r19;
        this.f = r20;
        this.g = r21;
        this.h = r22;
        this.i = r23;
        this.j = r24;
        this.k = r25;
        this.l = r26;
        this.m = r27;
        this.n = r28;
        this.o = r29;
        this.p = r30;
        this.q = r31;
        this.r = r32;
        this.s = r33;
        this.t = r34;
        this.u = r35;
        this.v = r36;
        this.w = r37;
        this.x = r38;
        this.y = r39;
        this.z = r40;
        this.A = r41;
        this.B = r42;
        this.C = r43;
        this.D = r44;
        this.E = r45;
        this.F = r46;
        this.G = r47;
        this.H = r48;
        this.I = r49;
        this.J = r50;
        this.K = r51;
        this.L = r52;
        this.M = r53;
        this.N = r54;
        this.O = r55;
        this.P = r56;
        this.Q = r57;
    }
}
