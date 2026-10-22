package com.larus.audio.call;

import com.lark.kmp.server.pb.improto.Packet;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.AvAudioKitMode;
import com.larus.im.service.audio.h1;
import com.larus.im.service.audio.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;
import ouc.d0;
import ouc.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class RealtimeCallParam {
    public boolean A;
    public m B;
    public ve9.c C;
    public String D;
    public boolean E;
    public boolean F;
    public String G;
    public String H;
    public int I;
    public String J;
    public String K;
    public com.larus.audio.call.n L;
    public l M;
    public g N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public String R;
    public boolean S;
    public boolean T;
    public int U;
    public int V;
    public boolean W;
    public Boolean X;
    public Boolean Y;
    public Boolean Z;
    public boolean a;
    public Boolean a0;
    public boolean b;
    public String b0;
    public long c;
    public int c0;
    public String d;
    public String d0;
    public String e;
    public String f;
    public int g;
    public int h;
    public String i;
    public final b j;
    public h k;
    public d l;
    public final o m;
    public final j n;
    public p o;
    public k p;
    public d0 q;
    public d0 r;
    public AudioSessionType s;
    public int t;
    public int u;
    public boolean v;
    public String w;
    public AvAudioKitMode x;
    public boolean y;
    public boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/audio/call/RealtimeCallParam$BusinessType;", "", "Companion", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface BusinessType {
        public static final a Companion = null;
        public static final int DORA_E = 8;
        public static final int DORA_G = 9;
        public static final int DORA_LITE = 6;
        public static final int DOUBAO_PHONE = 2;
        public static final int DOU_BAO = 1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/audio/call/RealtimeCallParam$DoraEndType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "VOICE_CONTROL", "TOUCHPAD", "EIGHT_TIMEOUT", "OTHER", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum DoraEndType extends Enum<DoraEndType> {
        public static final DoraEndType EIGHT_TIMEOUT = null;
        public static final DoraEndType OTHER = null;
        public static final DoraEndType TOUCHPAD = null;
        public static final DoraEndType VOICE_CONTROL = null;
        public static final /* synthetic */ DoraEndType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String type;

        public static EnumEntries<DoraEndType> getEntries() {
            return b;
        }

        static {
            DoraEndType r0 = new DoraEndType("VOICE_CONTROL", 0, "voice_control");
            VOICE_CONTROL = r0;
            DoraEndType r1 = new DoraEndType("TOUCHPAD", 1, "touchpad");
            TOUCHPAD = r1;
            DoraEndType r2 = new DoraEndType("EIGHT_TIMEOUT", 2, "8s_timeout");
            EIGHT_TIMEOUT = r2;
            DoraEndType r4 = new DoraEndType("OTHER", 3, "other");
            OTHER = r4;
            DoraEndType[] r6 = {r0, r1, r2, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static DoraEndType[] values() {
            return (DoraEndType[]) a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public static DoraEndType valueOf(String r1) {
            return (DoraEndType) r27.a.a(DoraEndType.class, r1);
        }

        public DoraEndType(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    @Serializable
    public static final class a {
        public static final b Companion = null;
        public final String a;
        public final String b;
        public final String c;
        public final Integer d;

        /* JADX INFO: renamed from: com.larus.audio.call.RealtimeCallParam$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class C0075a implements m0<a> {
            public static final C0075a a = null;
            public static final g2 b = null;

            public C0075a() {
            }

            public final juc.d<?>[] childSerializers() {
                v2 r1 = v2.a;
                return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(w0.a)};
            }

            public final luc.f getDescriptor() {
                return b;
            }

            static {
                C0075a r0 = new C0075a();
                a = r0;
                g2 r1 = new g2("com.larus.audio.call.RealtimeCallParam.ASTChannelInfo", r0, 4);
                r1.j("channel", true);
                r1.j("src_lang", true);
                r1.j("dest_lang", true);
                r1.j("speaker_mode", true);
                b = r1;
            }

            public final juc.d<?>[] typeParametersSerializers() {
                return i2.a;
            }

            public final Object deserialize(muc.e r19) {
                Intrinsics.checkNotNullParameter(r19, "decoder");
                g2 r1 = b;
                muc.c r0 = r19.beginStructure(r1);
                String r7 = null;
                if (r0.decodeSequentially() == false) goto L5;
                v2 r2 = v2.a;
                String r4 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
                String r5 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
                String r16 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
                Integer r17 = (Integer) r0.decodeNullableSerializableElement(r1, 3, w0.a, null);
                String r14 = r4;
                String r15 = r5;
                int r13 = 15;
            L21:
                r0.endStructure(r1);
                return new a(r13, r14, r15, r16, r17);
            L5:
                String r8 = null;
                String r9 = null;
                Integer r10 = null;
                int r3 = 0;
                boolean r11 = true;
            L6:
                if (r11 == false) goto L20;
                int r12 = r0.decodeElementIndex(r1);
                if (r12 != (-1)) goto L9;
                r11 = false;
                goto L6
            L9:
                if (r12 != 0) goto L10;
                r7 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r7);
                r3 = r3 | 1;
                goto L6
            L10:
                if (r12 != 1) goto L11;
                r8 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r8);
                r3 = r3 | 2;
                goto L6
            L11:
                if (r12 != 2) goto L12;
                r9 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r9);
                r3 = r3 | 4;
                goto L6
            L12:
                if (r12 != 3) goto L15;
                r10 = (Integer) r0.decodeNullableSerializableElement(r1, 3, w0.a, r10);
                r3 = r3 | 8;
                goto L6
            L15:
                throw new UnknownFieldException(r12);
            L20:
                r13 = r3;
                r14 = r7;
                r15 = r8;
                r16 = r9;
                r17 = r10;
                goto L21
            }

            public final void serialize(muc.f r7, Object r8) {
                a r9 = (a) r8;
                Intrinsics.checkNotNullParameter(r7, "encoder");
                Intrinsics.checkNotNullParameter(r9, "value");
                g2 r0 = b;
                muc.d r10 = r7.beginStructure(r0);
                b r1 = a.Companion;
                boolean r2 = false;
                if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
            L7:
                boolean r3 = true;
            L9:
                if (r3 == false) goto L12;
                r10.encodeNullableSerializableElement(r0, 0, v2.a, r9.a);
            L12:
                if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
            L16:
                boolean r4 = true;
            L18:
                if (r4 == false) goto L21;
                r10.encodeNullableSerializableElement(r0, 1, v2.a, r9.b);
            L21:
                if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
            L25:
                boolean r5 = true;
            L27:
                if (r5 == false) goto L30;
                r10.encodeNullableSerializableElement(r0, 2, v2.a, r9.c);
            L30:
                if (r10.shouldEncodeElementDefault(r0, 3) == true) goto L37;
                Integer r6 = r9.d;
                if (r6 == null) goto L37;
                if (r6.intValue() != 0) goto L37;
            L38:
                if (r2 == false) goto L40;
                r10.encodeNullableSerializableElement(r0, 3, w0.a, r9.d);
            L40:
                r10.endStructure(r0);
                return;
            L37:
                r2 = true;
                goto L38
            L24:
                if (Intrinsics.areEqual(r9.c, "") == false) goto L25;
                r5 = false;
                goto L27
            L15:
                if (Intrinsics.areEqual(r9.b, "") == false) goto L16;
                r4 = false;
                goto L18
            L6:
                if (Intrinsics.areEqual(r9.a, "") == false) goto L7;
                r3 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<a> serializer() {
                return C0075a.a;
            }
        }

        public a() {
            this("", "", "", 0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.d;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ASTChannelInfo(channel=" + this.a + ", srcLanguage=" + this.b + ", destLanguage=" + this.c + ", speakerMode=" + this.d + ')';
        }

        static {
            Companion = new b();
        }

        public a(String r1, String r2, String r3, Integer r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public a(int r4, String r5, String r6, String r7, Integer r8) {
            if ((r4 & 0) == 0) goto L5;
            b2.b(r4, 0, C0075a.b);
            throw null;
        L5:
            if ((r4 & 1) != 0) goto L7;
            this.a = "";
        L9:
            if ((r4 & 2) != 0) goto L11;
            this.b = "";
        L13:
            if ((r4 & 4) != 0) goto L15;
            this.c = "";
        L17:
            if ((r4 & 8) != 0) goto L19;
            this.d = 0;
            return;
        L19:
            this.d = r8;
            return;
        L15:
            this.c = r7;
            goto L17
        L11:
            this.b = r6;
            goto L13
        L7:
            this.a = r5;
            goto L9
        }
    }

    @Serializable
    public static final class b {
        public static final C0076b Companion = null;
        public static final Lazy<juc.d<Object>>[] b = null;
        public List<a> a;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements m0<b> {
            public static final a a = null;
            public static final g2 b = null;

            public a() {
            }

            public final luc.f getDescriptor() {
                return b;
            }

            static {
                a r0 = new a();
                a = r0;
                g2 r1 = new g2("com.larus.audio.call.RealtimeCallParam.ASTConfig", r0, 1);
                r1.j("channels", true);
                b = r1;
            }

            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{kuc.a.d((juc.d) b.b[0].getValue())};
            }

            public final juc.d<?>[] typeParametersSerializers() {
                return i2.a;
            }

            public final Object deserialize(muc.e r9) {
                Intrinsics.checkNotNullParameter(r9, "decoder");
                g2 r0 = b;
                muc.c r10 = r9.beginStructure(r0);
                Lazy<juc.d<Object>>[] r1 = b.b;
                int r3 = 1;
                List r5 = null;
                if (r10.decodeSequentially() == false) goto L5;
                List r2 = (List) r10.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
            L15:
                r10.endStructure(r0);
                return new b(r3, r2);
            L5:
                int r4 = 0;
            L6:
                if (r3 == 0) goto L14;
                int r6 = r10.decodeElementIndex(r0);
                if (r6 != (-1)) goto L9;
                r3 = 0;
                goto L6
            L9:
                if (r6 != 0) goto L12;
                r5 = (List) r10.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r5);
                r4 = r4 | 1;
                goto L6
            L12:
                throw new UnknownFieldException(r6);
            L14:
                r3 = r4;
                r2 = r5;
                goto L15
            }

            public final void serialize(muc.f r6, Object r7) {
                b r8 = (b) r7;
                Intrinsics.checkNotNullParameter(r6, "encoder");
                Intrinsics.checkNotNullParameter(r8, "value");
                g2 r0 = b;
                muc.d r9 = r6.beginStructure(r0);
                Lazy<juc.d<Object>>[] r1 = b.b;
                if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
            L7:
                boolean r3 = true;
            L9:
                if (r3 == false) goto L11;
                r9.encodeNullableSerializableElement(r0, 0, (juc.n) r1[0].getValue(), r8.a);
            L11:
                r9.endStructure(r0);
                return;
            L6:
                if (Intrinsics.areEqual(r8.a, CollectionsKt.emptyList()) == false) goto L7;
                r3 = false;
                goto L9
            }
        }

        /* JADX INFO: renamed from: com.larus.audio.call.RealtimeCallParam$b$b, reason: collision with other inner class name */
        public static final class C0076b {
            public C0076b() {
            }

            public final juc.d<b> serializer() {
                return a.a;
            }
        }

        public b() {
            this(null);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<a> r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "ASTConfig(channelList=" + this.a + ')';
        }

        static {
            Companion = new C0076b();
            b = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new com.larus.audio.call.m())};
        }

        public b(Object r1) {
            this.a = CollectionsKt.emptyList();
        }

        public b(int r2, List r3) {
            if ((r2 & 0) == 0) goto L5;
            b2.b(r2, 0, a.b);
            throw null;
        L5:
            if ((r2 & 1) != 0) goto L7;
            this.a = CollectionsKt.emptyList();
            return;
        L7:
            this.a = r3;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "actionBarKey=" + this.d + " actionBarItemId:" + this.a + ",actionBarRecommendRequestId:" + this.b + ",actionBarRecommendFrom:" + this.c;
        }

        public c(String r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class d {
        public static final /* synthetic */ int v = 0;
        public String a;
        public final String b;
        public String c;
        public String d;
        public final int e;
        public int f;
        public String g;
        public int h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public boolean m;
        public final boolean n;
        public String o;
        public String p;
        public final boolean q;
        public String r;
        public final String s;
        public boolean t;
        public String u;

        public static final class a {
        }

        static {
        }

        public d() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
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
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
            return false;
        L57:
            if (this.q == r6.q) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
            return false;
        L66:
            if (this.t == r6.t) goto L69;
            return false;
        L69:
            if (Intrinsics.areEqual(this.u, r6.u) == true) goto L71;
            return false;
        L71:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f) * 31) + this.g.hashCode()) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31;
            int r2 = 1231;
            if (this.m == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.n == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (((((r3 + r4) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31;
            if (this.q == false) goto L13;
            int r6 = 1231;
        L14:
            int r7 = (((((r5 + r6) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31;
            if (this.t == true) goto L19;
            r2 = 1237;
        L19:
            return ((r7 + r2) * 31) + this.u.hashCode();
        L13:
            r6 = 1237;
            goto L14
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "taskId:" + this.a + ",sessionId:" + this.b + ",conversationId:" + this.c + ",language:" + this.d + ",sampleRate:" + this.e + ",channel:" + this.f + ",format:" + this.g + ",interruptType:" + this.h + ",enablePunctuation:" + this.i + ",enableAudioCache:" + this.j + ",audioCacheSize:" + this.k + ",enableRemoveFirstAudioData:" + this.l + ",enablePreQuery:" + this.m + ",enableChatComfort:" + this.n + ",extra:" + this.o + ",model:" + this.p + ",isDoraOnboarding:" + this.q + ",isNewDoraOnboarding:" + this.r + ",isNewUser:" + this.s + ",nonStreamModel:" + this.u;
        }

        public /* synthetic */ d(int r23) {
            this("", "", "", "", 16000, 1, "pcm", 1, 1, 1, 1920000, 0, false, false, "", "", false, "0", "", false, "");
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.o = r2;
        }

        public d(String r13, String r14, String r15, String r16, int r17, int r19, String r110, int r20, int r21, int r22, int r23, int r24, boolean r25, boolean r26, String r27, String r29, boolean r210, String r30, String r31, boolean r32, String r33) {
            Intrinsics.checkNotNullParameter(r13, "taskId");
            Intrinsics.checkNotNullParameter(r14, "sessionId");
            Intrinsics.checkNotNullParameter(r15, "conversationId");
            Intrinsics.checkNotNullParameter(r16, "language");
            Intrinsics.checkNotNullParameter(r110, "format");
            Intrinsics.checkNotNullParameter(r27, "extra");
            Intrinsics.checkNotNullParameter(r29, "model");
            Intrinsics.checkNotNullParameter(r30, "isNewDoraOnboarding");
            Intrinsics.checkNotNullParameter(r31, "isNewUser");
            Intrinsics.checkNotNullParameter(r33, "asrTwoPassNonStreamModel");
            this.a = r13;
            this.b = r14;
            this.c = r15;
            this.d = r16;
            this.e = r17;
            this.f = r19;
            this.g = r110;
            this.h = r20;
            this.i = r21;
            this.j = r22;
            this.k = r23;
            this.l = r24;
            this.m = r25;
            this.n = r26;
            this.o = r27;
            this.p = r29;
            this.q = r210;
            this.r = r30;
            this.s = r31;
            this.t = r32;
            this.u = r33;
        }
    }

    public static final class e {
        public final boolean a;
        public final int b;
        public final int[] c;

        public e(boolean r1, int r2, int[] r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class f {
        public final e a;

        public f() {
            this(0);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            e r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "AudioRetransmitStrategy(data=" + this.a + ')';
        }

        public /* synthetic */ f(int r4) {
            this(new e(true, 0, new int[]{Packet.DEFAULT_STATUS, 400, 800, 1600, 6400}));
        }

        public f(e r1) {
            this.a = r1;
        }
    }

    public static final class g {
        public final Long a;
        public final Long b;

        public g() {
            this(null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof g) == true) goto L8;
            return false;
        L8:
            g r6 = (g) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Long r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Long r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "BackTraceParams(historyLengthMs=" + this.a + ", wakeupTimeStamp=" + this.b + ')';
        }

        public g(Long r1, Long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class h {
        public boolean A;
        public boolean B;
        public String a;
        public String b;
        public final String c;
        public String d;
        public int e;
        public String f;
        public String g;
        public String h;
        public int i;
        public int j;
        public int k;
        public f l;
        public int m;
        public int n;
        public String o;
        public boolean p;
        public String q;
        public String r;
        public int s;
        public String t;
        public Integer u;
        public boolean v;
        public boolean w;
        public String x;
        public String y;
        public String z;

        public h() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
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
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
            return false;
        L54:
            if (this.p == r6.p) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
            return false;
        L63:
            if (this.s == r6.s) goto L66;
            return false;
        L66:
            if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
            return false;
        L69:
            if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
            return false;
        L72:
            if (this.v == r6.v) goto L75;
            return false;
        L75:
            if (this.w == r6.w) goto L78;
            return false;
        L78:
            if (Intrinsics.areEqual(this.x, r6.x) == true) goto L81;
            return false;
        L81:
            if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
            return false;
        L84:
            if (Intrinsics.areEqual(this.z, r6.z) == true) goto L87;
            return false;
        L87:
            if (this.A == r6.A) goto L90;
            return false;
        L90:
            if (this.B == r6.B) goto L92;
            return false;
        L92:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l.hashCode()) * 31) + this.m) * 31) + this.n) * 31) + this.o.hashCode()) * 31;
            int r2 = 1231;
            if (this.p == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (((((((((r0 + r1) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31) + this.s) * 31) + this.t.hashCode()) * 31;
            Integer r4 = this.u;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            if (this.v == false) goto L13;
            int r7 = 1231;
        L14:
            int r8 = (r6 + r7) * 31;
            if (this.w == false) goto L17;
            int r9 = 1231;
        L18:
            int r10 = (((((((r8 + r9) * 31) + this.x.hashCode()) * 31) + this.y.hashCode()) * 31) + this.z.hashCode()) * 31;
            if (this.A == false) goto L21;
            int r11 = 1231;
        L22:
            int r12 = (r10 + r11) * 31;
            if (this.B == true) goto L27;
            r2 = 1237;
        L27:
            return r12 + r2;
        L21:
            r11 = 1237;
            goto L22
        L17:
            r9 = 1237;
            goto L18
        L13:
            r7 = 1237;
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String a() {
            String r0 = this.t;
            switch(r0.hashCode()) {
                case -1449454789: goto L16;
                case -450882357: goto L12;
                case 407405714: goto L9;
                case 785611651: goto L6;
                default: goto L17;
            };
        L17:
            return "call";
        L6:
            if (r0.equals("dora_call") == false) goto L17;
            return "dora_call";
        L9:
            if (r0.equals("radio_single_turn_conversation") == false) goto L17;
            return "dora_radio";
        L12:
            if (r0.equals("assistant_scene_mode_click_talk") == false) goto L17;
            return "obric_click_talk";
        L16:
            if (r0.equals("radio_multi_turn_conversation") == false) goto L17;
            return "dora_radio";
        }

        public final String toString() {
            return "url:" + this.a + ",appKey:" + this.b + ",token:" + this.c + ",header:" + this.d + ",connectTimeout:" + this.e + ",appVersion:" + this.h + ",appVersionCode:" + this.i + ",appUpdateVersionCode:" + this.j + ",maxDuration:" + this.k + "isMockChat:" + this.m + ",business:" + this.n + ",requestType:" + this.o + ",subConvFirstMetType:" + this.q + ",subConvSourceMessage:" + this.r + ",sceneMode:" + this.t;
        }

        public /* synthetic */ h(int r30) {
            this("", "", "", "", 10000, "", "", "", 0, 0, 5400, new f(0), 0, 1, "", false, "", "", 0, "call", null, false, false, "VoiceGenie", "", "", false, false);
        }

        public h(String r17, String r19, String r110, String r20, int r21, String r22, String r23, String r24, int r25, int r26, int r27, f r29, int r210, @BusinessType int r30, String r31, boolean r32, String r33, String r34, int r35, String r36, Integer r37, boolean r38, boolean r39, String r40, String r41, String r42, boolean r43, boolean r44) {
            Intrinsics.checkNotNullParameter(r17, "url");
            Intrinsics.checkNotNullParameter(r19, "appKey");
            Intrinsics.checkNotNullParameter(r110, "token");
            Intrinsics.checkNotNullParameter(r20, "header");
            Intrinsics.checkNotNullParameter(r22, "uid");
            Intrinsics.checkNotNullParameter(r23, "did");
            Intrinsics.checkNotNullParameter(r24, "appVersion");
            Intrinsics.checkNotNullParameter(r29, "retransmitStrategy");
            Intrinsics.checkNotNullParameter(r31, "requestType");
            Intrinsics.checkNotNullParameter(r33, "subConvFirstMetType");
            Intrinsics.checkNotNullParameter(r34, "subConvSourceMessage");
            Intrinsics.checkNotNullParameter(r36, "sceneMode");
            Intrinsics.checkNotNullParameter(r40, "namespace");
            Intrinsics.checkNotNullParameter(r41, "origin");
            Intrinsics.checkNotNullParameter(r42, "streamApp");
            this.a = r17;
            this.b = r19;
            this.c = r110;
            this.d = r20;
            this.e = r21;
            this.f = r22;
            this.g = r23;
            this.h = r24;
            this.i = r25;
            this.j = r26;
            this.k = r27;
            this.l = r29;
            this.m = r210;
            this.n = r30;
            this.o = r31;
            this.p = r32;
            this.q = r33;
            this.r = r34;
            this.s = r35;
            this.t = r36;
            this.u = r37;
            this.v = r38;
            this.w = r39;
            this.x = r40;
            this.y = r41;
            this.z = r42;
            this.A = r43;
            this.B = r44;
        }
    }

    public static final class i {
    }

    public static final class j {
        public Integer a;
        public boolean b;
        public boolean c;
        public int d;
        public boolean e;
        public h1 f;
        public String g;
        public String h;
        public String i;
        public long j;
        public String k;
        public String l;
        public Map<String, String> m;
        public final Map<String, Object> n;

        public j() {
            this.g = "zh";
            this.h = "en";
            this.i = "FaceToFace";
            this.k = "";
            this.l = "";
            this.m = new LinkedHashMap();
            this.n = new LinkedHashMap();
        }
    }

    public static final class k {
        public Boolean A;
        public final boolean B;
        public DoraEndType C;
        public boolean D;
        public boolean E;
        public boolean F;
        public boolean G;
        public String H;
        public String I;
        public String J;
        public Boolean K;
        public Integer L;
        public String M;
        public final String N;
        public String O;
        public String P;
        public Long Q;
        public boolean R;
        public final String S;
        public boolean T;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public n h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public c o;
        public String p;
        public final boolean q;
        public boolean r;
        public long s;
        public boolean t;
        public boolean u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        public k() {
            this(0);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof k) == true) goto L8;
            return false;
        L8:
            k r9 = (k) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.p, r9.p) == true) goto L57;
            return false;
        L57:
            if (this.q == r9.q) goto L60;
            return false;
        L60:
            if (this.r == r9.r) goto L63;
            return false;
        L63:
            if (this.s == r9.s) goto L66;
            return false;
        L66:
            if (this.t == r9.t) goto L69;
            return false;
        L69:
            if (this.u == r9.u) goto L72;
            return false;
        L72:
            if (Intrinsics.areEqual(this.v, r9.v) == true) goto L75;
            return false;
        L75:
            if (Intrinsics.areEqual(this.w, r9.w) == true) goto L78;
            return false;
        L78:
            if (Intrinsics.areEqual(this.x, r9.x) == true) goto L81;
            return false;
        L81:
            if (Intrinsics.areEqual(this.y, r9.y) == true) goto L84;
            return false;
        L84:
            if (Intrinsics.areEqual(this.z, r9.z) == true) goto L87;
            return false;
        L87:
            if (Intrinsics.areEqual(this.A, r9.A) == true) goto L90;
            return false;
        L90:
            if (this.B == r9.B) goto L93;
            return false;
        L93:
            if (this.C == r9.C) goto L96;
            return false;
        L96:
            if (this.D == r9.D) goto L99;
            return false;
        L99:
            if (this.E == r9.E) goto L102;
            return false;
        L102:
            if (this.F == r9.F) goto L105;
            return false;
        L105:
            if (this.G == r9.G) goto L108;
            return false;
        L108:
            if (Intrinsics.areEqual(this.H, r9.H) == true) goto L111;
            return false;
        L111:
            if (Intrinsics.areEqual(this.I, r9.I) == true) goto L114;
            return false;
        L114:
            if (Intrinsics.areEqual(this.J, r9.J) == true) goto L117;
            return false;
        L117:
            if (Intrinsics.areEqual(this.K, r9.K) == true) goto L120;
            return false;
        L120:
            if (Intrinsics.areEqual(this.L, r9.L) == true) goto L123;
            return false;
        L123:
            if (Intrinsics.areEqual(this.M, r9.M) == true) goto L126;
            return false;
        L126:
            if (Intrinsics.areEqual(this.N, r9.N) == true) goto L129;
            return false;
        L129:
            if (Intrinsics.areEqual(this.O, r9.O) == true) goto L132;
            return false;
        L132:
            if (Intrinsics.areEqual(this.P, r9.P) == true) goto L135;
            return false;
        L135:
            if (Intrinsics.areEqual(this.Q, r9.Q) == true) goto L138;
            return false;
        L138:
            if (this.R == r9.R) goto L141;
            return false;
        L141:
            if (Intrinsics.areEqual(this.S, r9.S) == true) goto L144;
            return false;
        L144:
            if (this.T == r9.T) goto L146;
            return false;
        L146:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            String r1 = this.e;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.g;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            n r11 = this.h;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.i;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.j;
            if (r17 != null) goto L25;
            int r19 = 0;
        L26:
            int r20 = (r16 + r19) * 31;
            String r21 = this.k;
            if (r21 != null) goto L29;
            int r22 = 0;
        L30:
            int r23 = (r20 + r22) * 31;
            String r24 = this.l;
            if (r24 != null) goto L33;
            int r25 = 0;
        L34:
            int r26 = (r23 + r25) * 31;
            String r27 = this.m;
            if (r27 != null) goto L37;
            int r29 = 0;
        L38:
            int r30 = (r26 + r29) * 31;
            String r31 = this.n;
            if (r31 != null) goto L41;
            int r32 = 0;
        L42:
            int r33 = (r30 + r32) * 31;
            c r34 = this.o;
            if (r34 != null) goto L45;
            int r35 = 0;
        L46:
            int r36 = (r33 + r35) * 31;
            String r37 = this.p;
            if (r37 != null) goto L49;
            int r38 = 0;
        L50:
            int r39 = (r36 + r38) * 31;
            int r40 = 1231;
            if (this.q == false) goto L53;
            int r41 = 1231;
        L54:
            int r42 = (r39 + r41) * 31;
            if (this.r == false) goto L57;
            int r43 = 1231;
        L58:
            long r44 = this.s;
            int r45 = (((r42 + r43) * 31) + ((int) (r44 ^ (r44 >>> 32)))) * 31;
            if (this.t == false) goto L61;
            int r46 = 1231;
        L62:
            int r47 = (r45 + r46) * 31;
            if (this.u == false) goto L65;
            int r48 = 1231;
        L66:
            int r49 = (r47 + r48) * 31;
            String r50 = this.v;
            if (r50 != null) goto L69;
            int r51 = 0;
        L70:
            int r52 = (r49 + r51) * 31;
            String r53 = this.w;
            if (r53 != null) goto L73;
            int r54 = 0;
        L74:
            int r55 = (r52 + r54) * 31;
            String r56 = this.x;
            if (r56 != null) goto L77;
            int r57 = 0;
        L78:
            int r59 = (r55 + r57) * 31;
            String r60 = this.y;
            if (r60 != null) goto L81;
            int r61 = 0;
        L82:
            int r62 = (r59 + r61) * 31;
            String r63 = this.z;
            if (r63 != null) goto L85;
            int r64 = 0;
        L86:
            int r65 = (r62 + r64) * 31;
            Boolean r66 = this.A;
            if (r66 != null) goto L89;
            int r67 = 0;
        L90:
            int r68 = (r65 + r67) * 31;
            if (this.B == false) goto L93;
            int r69 = 1231;
        L94:
            int r70 = (r68 + r69) * 31;
            DoraEndType r71 = this.C;
            if (r71 != null) goto L97;
            int r72 = 0;
        L98:
            int r73 = (r70 + r72) * 31;
            if (this.D == false) goto L101;
            int r74 = 1231;
        L102:
            int r75 = (r73 + r74) * 31;
            if (this.E == false) goto L105;
            int r76 = 1231;
        L106:
            int r77 = (r75 + r76) * 31;
            if (this.F == false) goto L109;
            int r79 = 1231;
        L110:
            int r80 = (r77 + r79) * 31;
            if (this.G == false) goto L113;
            int r81 = 1231;
        L114:
            int r82 = (r80 + r81) * 31;
            String r83 = this.H;
            if (r83 != null) goto L117;
            int r84 = 0;
        L118:
            int r85 = (r82 + r84) * 31;
            String r86 = this.I;
            if (r86 != null) goto L121;
            int r87 = 0;
        L122:
            int r88 = (r85 + r87) * 31;
            String r89 = this.J;
            if (r89 != null) goto L125;
            int r90 = 0;
        L126:
            int r91 = (r88 + r90) * 31;
            Boolean r92 = this.K;
            if (r92 != null) goto L129;
            int r93 = 0;
        L130:
            int r94 = (r91 + r93) * 31;
            Integer r95 = this.L;
            if (r95 != null) goto L133;
            int r96 = 0;
        L134:
            int r97 = (((r94 + r96) * 31) + this.M.hashCode()) * 31;
            String r98 = this.N;
            if (r98 != null) goto L137;
            int r99 = 0;
        L138:
            int r100 = (r97 + r99) * 31;
            String r101 = this.O;
            if (r101 != null) goto L141;
            int r102 = 0;
        L142:
            int r103 = (r100 + r102) * 31;
            String r104 = this.P;
            if (r104 != null) goto L145;
            int r105 = 0;
        L146:
            int r106 = (r103 + r105) * 31;
            Long r107 = this.Q;
            if (r107 != null) goto L149;
            int r108 = 0;
        L150:
            int r109 = (r106 + r108) * 31;
            if (this.R == false) goto L153;
            int r110 = 1231;
        L154:
            int r111 = (r109 + r110) * 31;
            String r112 = this.S;
            if (r112 == null) goto L158;
            r2 = r112.hashCode();
        L158:
            int r113 = (r111 + r2) * 31;
            if (this.T == true) goto L163;
            r40 = 1237;
        L163:
            return r113 + r40;
        L153:
            r110 = 1237;
            goto L154
        L149:
            r108 = r107.hashCode();
            goto L150
        L145:
            r105 = r104.hashCode();
            goto L146
        L141:
            r102 = r101.hashCode();
            goto L142
        L137:
            r99 = r98.hashCode();
            goto L138
        L133:
            r96 = r95.hashCode();
            goto L134
        L129:
            r93 = r92.hashCode();
            goto L130
        L125:
            r90 = r89.hashCode();
            goto L126
        L121:
            r87 = r86.hashCode();
            goto L122
        L117:
            r84 = r83.hashCode();
            goto L118
        L113:
            r81 = 1237;
            goto L114
        L109:
            r79 = 1237;
            goto L110
        L105:
            r76 = 1237;
            goto L106
        L101:
            r74 = 1237;
            goto L102
        L97:
            r72 = r71.hashCode();
            goto L98
        L93:
            r69 = 1237;
            goto L94
        L89:
            r67 = r66.hashCode();
            goto L90
        L85:
            r64 = r63.hashCode();
            goto L86
        L81:
            r61 = r60.hashCode();
            goto L82
        L77:
            r57 = r56.hashCode();
            goto L78
        L73:
            r54 = r53.hashCode();
            goto L74
        L69:
            r51 = r50.hashCode();
            goto L70
        L65:
            r48 = 1237;
            goto L66
        L61:
            r46 = 1237;
            goto L62
        L57:
            r43 = 1237;
            goto L58
        L53:
            r41 = 1237;
            goto L54
        L49:
            r38 = r37.hashCode();
            goto L50
        L45:
            r35 = r34.hashCode();
            goto L46
        L41:
            r32 = r31.hashCode();
            goto L42
        L37:
            r29 = r27.hashCode();
            goto L38
        L33:
            r25 = r24.hashCode();
            goto L34
        L29:
            r22 = r21.hashCode();
            goto L30
        L25:
            r19 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
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
            return "previousPage:" + this.b + ",enterFrom:" + this.c + ",currentPage:" + this.d + ",recommendFromScene:" + this.e + ",recommendFromReqId:" + this.f + ",chatType:" + this.g + ",searchMobParam:" + this.h + ",enterMethod:" + this.i + ",endMethod:" + this.j + ",secScene:" + this.k + ",fromActivityName:" + this.l + ",fromActivityModule:" + this.m + ",isCallBot:" + this.n + ",actionBarInfo:" + this.o + ",botSayHelloTextKey:" + this.p + ",isContinuousTalk:" + this.q + ",enableSilenceTimeout:" + this.r + ",silenceTimeoutMs:" + this.s + ",openVlmOnStart:" + this.t + ",avatar:" + this.v + ",summaryId:" + this.w + ",summaryScene:" + this.x;
        }

        public k(int r7) {
            Boolean r8 = Boolean.FALSE;
            Intrinsics.checkNotNullParameter("", "pushMsgId");
            Intrinsics.checkNotNullParameter("", "previousPage");
            Intrinsics.checkNotNullParameter("", "enterFrom");
            Intrinsics.checkNotNullParameter("", "currentPage");
            Intrinsics.checkNotNullParameter("", "doraRtosVersionCode");
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = false;
            this.r = false;
            this.s = 0;
            this.t = false;
            this.u = false;
            this.v = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
            this.A = null;
            this.B = false;
            this.C = null;
            this.D = false;
            this.E = false;
            this.F = false;
            this.G = false;
            this.H = null;
            this.I = null;
            this.J = null;
            this.K = r8;
            this.L = 0;
            this.M = "";
            this.N = null;
            this.O = null;
            this.P = null;
            this.Q = null;
            this.R = false;
            this.S = null;
            this.T = false;
        }
    }

    public static final class l {
        public final boolean a;
        public final String b;
        public final long c;
        public final boolean d;

        public l() {
            this(false, null, 0, 15);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof l) == true) goto L8;
            return false;
        L8:
            l r9 = (l) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
            long r3 = this.c;
            int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            if (this.d == true) goto L11;
            r1 = 1237;
        L11:
            return r4 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "OneshotParams(enable=" + this.a + ", keyword=" + this.b + ", offset=" + this.c + ", breathWakeup=" + this.d + ')';
        }

        public /* synthetic */ l(boolean r7, String r8, long r9, int r11) {
            if ((r11 & 1) == 0) goto L5;
            boolean r1 = false;
        L7:
            if ((r11 & 2) == 0) goto L9;
            r8 = "";
        L9:
            String r2 = r8;
            if ((r11 & 4) == 0) goto L12;
            r9 = -1;
        L12:
            this(r1, r2, r9, false);
            return;
        L5:
            r1 = r7;
            goto L7
        }

        public l(boolean r2, String r3, long r4, boolean r6) {
            Intrinsics.checkNotNullParameter(r3, "keyword");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
        }
    }

    public static final class m {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof m) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((m) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "RTCConfig(rtcAppId=" + this.a + ')';
        }

        public m(String r2) {
            Intrinsics.checkNotNullParameter(r2, "rtcAppId");
            this.a = r2;
        }
    }

    public static final class n {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;

        public n() {
            this(null, null, null, null, null, null, 127);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof n) == true) goto L8;
            return false;
        L8:
            n r6 = (n) r5;
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
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.f;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r19 = (r15 + r17) * 31;
            String r20 = this.g;
            if (r20 == null) goto L31;
            r1 = r20.hashCode();
        L31:
            return r19 + r1;
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "SearchMobParam(query=" + this.a + ", queryId=" + this.b + ", searchId=" + this.c + ", searchRequestId=" + this.d + ", searchResultId=" + this.e + ", rank=" + this.f + ", recommendFrom=" + this.g + ')';
        }

        public n(String r3, String r4, String r5, String r6, String r7, String r8, int r9) {
            if ((r9 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r9 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r9 & 4) == 0) goto L12;
            r5 = null;
        L12:
            if ((r9 & 16) == 0) goto L15;
            r6 = null;
        L15:
            if ((r9 & 32) == 0) goto L18;
            r7 = null;
        L18:
            if ((r9 & 64) == 0) goto L20;
            r8 = null;
        L20:
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = null;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public static final class o {
        public String a;
        public int b;
        public int c;
        public int d;
        public int e;
        public String f;
        public String g;

        public o() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof o) == true) goto L8;
            return false;
        L8:
            o r6 = (o) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
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
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
            String r1 = this.f;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.g;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            e0 r0 = new e0();
            ouc.j.c(r0, "format", this.a);
            ouc.j.b(r0, "decoderLength", Integer.valueOf(this.b));
            ouc.j.b(r0, "sampleRate", Integer.valueOf(this.c));
            ouc.j.b(r0, "bitrate", Integer.valueOf(this.e));
            ouc.j.b(r0, "channel", Integer.valueOf(this.d));
            d0 r1 = r0.a();
            e0 r2 = new e0();
            r2.b("wakeup_audio_config", r1);
            ouc.j.c(r2, "model_path", this.f);
            ouc.j.c(r2, "model_md5", this.g);
            return r2.a().toString();
        }

        public o(int r2) {
            Intrinsics.checkNotNullParameter("speech_opus", "format");
            this.a = "speech_opus";
            this.b = 80;
            this.c = 16000;
            this.d = 1;
            this.e = 32000;
            this.f = "";
            this.g = "";
        }
    }

    public static final class p {
        public static final /* synthetic */ int x = 0;
        public String a;
        public final String b;
        public String c;
        public String d;
        public final String e;
        public String f;
        public String g;
        public String h;
        public final String i;
        public int j;
        public final String k;
        public boolean l;
        public int m;
        public String n;
        public boolean o;
        public boolean p;
        public final String q;
        public final boolean r;
        public final Map<String, String> s;
        public String t;
        public float u;
        public int v;
        public boolean w;

        public static final class a {
        }

        public p() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof p) == true) goto L8;
            return false;
        L8:
            p r6 = (p) r5;
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
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
            return false;
        L51:
            if (this.o == r6.o) goto L54;
            return false;
        L54:
            if (this.p == r6.p) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
            return false;
        L60:
            if (this.r == r6.r) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
            return false;
        L66:
            if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
            return false;
        L69:
            if (Float.compare(this.u, r6.u) == 0) goto L72;
            return false;
        L72:
            if (this.v == r6.v) goto L74;
            return false;
        L74:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j) * 31) + this.k.hashCode()) * 31;
            int r2 = 1231;
            if (this.l == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (((((r0 + r1) * 31) + this.m) * 31) + this.n.hashCode()) * 31;
            if (this.o == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r3 + r4) * 31;
            if (this.p == false) goto L13;
            int r6 = 1231;
        L14:
            int r7 = (((r5 + r6) * 31) + this.q.hashCode()) * 31;
            if (this.r == true) goto L18;
            r2 = 1237;
        L18:
            int r8 = (r7 + r2) * 31;
            Map<String, String> r9 = this.s;
            if (r9 != null) goto L21;
            int r10 = 0;
        L23:
            return ((((((r8 + r10) * 31) + this.t.hashCode()) * 31) + Float.floatToIntBits(this.u)) * 31) + this.v;
        L21:
            r10 = r9.hashCode();
            goto L23
        L13:
            r6 = 1237;
            goto L14
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        static {
            int r0 = com.larus.audio.call.common.a.a;
        }

        public final String toString() {
            return "taskId:" + this.a + ",sessionId:" + this.b + ",conversationId:" + this.c + ",styleName:" + this.d + ",llModelName:" + this.e + ",voiceId:" + this.f + ",speakerName:" + this.g + ",botId:" + this.h + ",botName:" + this.i + ",sampleRate:" + this.j + ",format:" + this.k + ",enableNetTransportCompress:" + this.l + ",bitRate:" + this.m + ",extra:" + this.n + ",enableAudioInput:" + this.o + ",enableTextReading:" + this.p + ",sessionExtra:" + this.q + ",newCvs:" + this.r + ",ext:" + this.s + ",audioMetrics:" + this.t + ",targetLufs:" + this.u + ",loudNormAlgoType:" + this.v;
        }

        public /* synthetic */ p(int r24) {
            this("", "", "", "", "", "", "", "", "", 24000, "pcm", false, 32000, "", false, false, "", false, null, "", 0.0f, 0);
        }

        public p(String r16, String r17, String r19, String r110, String r20, String r21, String r22, String r23, String r24, int r25, String r26, boolean r27, int r29, String r210, boolean r30, boolean r31, String r32, boolean r33, Map<String, String> r34, String r35, float r36, int r37) {
            Intrinsics.checkNotNullParameter(r16, "taskId");
            Intrinsics.checkNotNullParameter(r17, "sessionId");
            Intrinsics.checkNotNullParameter(r19, "conversationId");
            Intrinsics.checkNotNullParameter(r110, "styleName");
            Intrinsics.checkNotNullParameter(r20, "llModelName");
            Intrinsics.checkNotNullParameter(r21, "voiceId");
            Intrinsics.checkNotNullParameter(r22, "speakerName");
            Intrinsics.checkNotNullParameter(r23, "botId");
            Intrinsics.checkNotNullParameter(r24, "botName");
            Intrinsics.checkNotNullParameter(r26, "format");
            Intrinsics.checkNotNullParameter(r210, "extra");
            Intrinsics.checkNotNullParameter(r32, "sessionExtra");
            Intrinsics.checkNotNullParameter(r35, "audioMetrics");
            this.a = r16;
            this.b = r17;
            this.c = r19;
            this.d = r110;
            this.e = r20;
            this.f = r21;
            this.g = r22;
            this.h = r23;
            this.i = r24;
            this.j = r25;
            this.k = r26;
            this.l = r27;
            this.m = r29;
            this.n = r210;
            this.o = r30;
            this.p = r31;
            this.q = r32;
            this.r = r33;
            this.s = r34;
            this.t = r35;
            this.u = r36;
            this.v = r37;
        }
    }

    static {
    }

    public final String toString() {
        return "roomId=" + this.d + " callId:" + this.e + ",llmModel:" + this.i + ",commonConfig:" + this.k + ",asrConfig:" + this.l + ",wakeupInfo:" + this.m + ",ttsConfig:" + this.o + ",extra:" + this.p + ",sessionExtra:" + this.q + ",isRtc:" + y0.e(this.s) + ", avSessionType:" + this.s + ", isImmersiveBackgroundString:" + this.w;
    }

    public RealtimeCallParam() {
        this.d = "";
        this.e = "";
        this.f = "";
        this.h = -1;
        this.i = "";
        this.j = new b(null);
        int r3 = 0;
        this.k = new h(r3);
        this.l = new d(r3);
        this.m = new o(0);
        this.n = new j();
        this.o = new p(r3);
        this.p = new k(0);
        this.q = new d0(MapsKt.emptyMap());
        this.r = new d0(MapsKt.emptyMap());
        this.s = AudioSessionType.SAMI;
        this.w = "0";
        this.x = AvAudioKitMode.PURE_BIZ;
        this.y = true;
        this.G = "";
        this.H = "";
        this.I = -1;
        this.J = "";
        this.K = "";
        this.R = "";
    }

    public final void a(AvAudioKitMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.x = r2;
    }
}
