package com.bytedance.android.ec.core.imagex.common;

import android.net.Uri;
import com.bytedance.android.ec.core.imagex.ImageSettings;
import com.bytedance.android.ec.core.imagex.tmplConv.TmplConvConfig;
import com.bytedance.android.shopping.api.image.p0;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ImageUrlParser implements com.bytedance.android.shopping.api.image.r {
    public static final String[] B = null;
    public static final String[] C = null;
    public final boolean A;
    public boolean a;
    public String b;
    public boolean c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public Integer j;
    public Integer k;
    public String l;
    public String m;
    public List<String> n;
    public String o;
    public com.bytedance.android.shopping.api.image.t p;
    public final Map<String, String> q;
    public final int r;
    public final o s;
    public final Uri t;
    public final Lazy u;
    public boolean v;
    public Pair<Integer, Integer> w;
    public final String x;
    public final String y;
    public final com.bytedance.android.ec.core.imagex.r z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/common/ImageUrlParser$Type;", "", "PROTOCOL", "DOMAIN", "FLAG", "URI", "SERVICE_ID", "TMPL_NAME", "ParamValues", "FORMAT", "END", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type DOMAIN = null;
        public static final Type END = null;
        public static final Type FLAG = null;
        public static final Type FORMAT = null;
        public static final Type PROTOCOL = null;
        public static final Type ParamValues = null;
        public static final Type SERVICE_ID = null;
        public static final Type TMPL_NAME = null;
        public static final Type URI = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r1 = new Type("PROTOCOL", 0);
            PROTOCOL = r1;
            Type r10 = new Type("DOMAIN", 1);
            DOMAIN = r10;
            Type r11 = new Type("FLAG", 2);
            FLAG = r11;
            Type r12 = new Type("URI", 3);
            URI = r12;
            Type r13 = new Type("SERVICE_ID", 4);
            SERVICE_ID = r13;
            Type r14 = new Type("TMPL_NAME", 5);
            TMPL_NAME = r14;
            Type r15 = new Type("ParamValues", 6);
            ParamValues = r15;
            Type r16 = new Type("FORMAT", 7);
            FORMAT = r16;
            Type r17 = new Type("END", 8);
            END = r17;
            a = new Type[]{r1, r10, r11, r12, r13, r14, r15, r16, r17};
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public Type(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final Character[] a;
        public final h[] b;
        public int c;
        public int d;
        public boolean e;
        public int f;
        public int g;

        public b() {
            int r10 = 0;
            this.a = new Character[]{'_', 'w', 'w', 'w'};
            h[] r0 = new h[2];
        L3:
            if (r10 >= 2) goto L5;
            r0[r10] = new com.bytedance.android.ec.core.imagex.common.a(8);
            r10 = r10 + 1;
            goto L3
        L5:
            this.b = r0;
        }
    }

    public final class c {
        public boolean a;
        public int b;
        public Type c;
        public final int d;
        public final List<String> e;
        public final com.bytedance.android.ec.core.imagex.common.a f;
        public final b g;
        public final e h;
        public int i;
        public final /* synthetic */ ImageUrlParser j;

        public c(ImageUrlParser r17) {
            this.j = r17;
            this.c = Type.PROTOCOL;
            this.d = r17.x.length();
            this.e = new ArrayList();
            this.f = new com.bytedance.android.ec.core.imagex.common.a(r17.r);
            this.g = new b();
            this.h = new e();
            this.i = -1;
            long r1 = System.nanoTime();
        L3:
            int r10 = this.b;
            boolean r11 = false;
            if (r10 >= this.d) goto L220;
            int r12 = r10 + 1;
            this.b = r12;
            char r13 = this.j.x.charAt(r10);
            this.f.a(r13);
            switch(n.a[this.c.ordinal()]) {
                case 1: goto L208;
                case 2: goto L202;
                case 3: goto L161;
                case 4: goto L66;
                case 5: goto L39;
                case 6: goto L28;
                case 7: goto L17;
                case 8: goto L8;
                default: goto L3;
            };
        L8:
            Character r14 = StringsKt.getOrNull(this.j.x, r12);
            if (r14 == null) goto L15;
            if (r14.charValue() != '?') goto L15;
            this.b++;
            this.j.o = this.f.toString();
            this.f.c();
            this.a = true;
        L15:
            if (r10 < (this.d - 1)) goto L3;
            this.j.o = this.f.toString();
            this.c = Type.END;
            goto L3
        L17:
            Character r15 = StringsKt.getOrNull(this.j.x, r12);
            if (r15 == null) goto L23;
            if (r15.charValue() != ':') goto L23;
            ((ArrayList) this.e).add(this.f.toString());
            this.f.c();
            this.b++;
        L23:
            if (r15 == null) goto L3;
            if (r15.charValue() != '.') goto L3;
            this.b++;
            ((ArrayList) this.e).add(this.f.toString());
            this.j.n = this.e;
            this.f.c();
            this.c = Type.FORMAT;
            goto L3
        L28:
            Character r16 = StringsKt.getOrNull(this.j.x, r12);
            if (r16 == null) goto L34;
            if (r16.charValue() != ':') goto L34;
            this.b++;
            this.j.m = this.f.toString();
            this.f.c();
            this.c = Type.ParamValues;
        L34:
            if (r16 == null) goto L3;
            if (r16.charValue() != '.') goto L3;
            this.b++;
            this.j.m = this.f.toString();
            this.f.c();
            this.c = Type.FORMAT;
            this.j.n = this.e;
            goto L3
        L39:
            Character r18 = StringsKt.getOrNull(this.j.x, r12);
            if (r18 == null) goto L56;
            if (r18.charValue() != '-') goto L56;
            String r19 = this.f.toString();
            if (r19.length() != 10) goto L53;
            p0 r20 = TmplConvConfig.k.b();
            if (r20 == null) goto L53;
            HashMap r21 = r20.e();
            if (r21 == null) goto L53;
            if (r21.containsKey(r19) != true) goto L53;
            r11 = true;
        L53:
            if (r11 == true) goto L54;
            this.c = Type.TMPL_NAME;
            goto L3
        L54:
            this.b++;
            this.j.l = r19;
            this.f.c();
            this.c = Type.TMPL_NAME;
        L56:
            if (r18 == null) goto L61;
            if (r18.charValue() != ':') goto L61;
            this.b++;
            this.j.m = this.f.toString();
            this.c = Type.TMPL_NAME;
            this.f.c();
            this.c = Type.ParamValues;
        L61:
            if (r18 == null) goto L3;
            if (r18.charValue() != '.') goto L3;
            this.b++;
            this.j.m = this.f.toString();
            this.c = Type.TMPL_NAME;
            this.f.c();
            this.c = Type.FORMAT;
            goto L3
        L66:
            Character r110 = StringsKt.getOrNull(this.j.x, r12);
            if (this.j.i != null) goto L73;
            if (r110 == null) goto L73;
            if (r110.charValue() != '/') goto L73;
            this.j.i = this.f.toString();
        L73:
            e r111 = this.h;
            Character r22 = StringsKt.getOrNull(this.j.x, r10 + 6);
            if (r111.c == true) goto L90;
            int r112 = r111.b;
            Character[] r113 = r111.a;
            if (r112 >= r113.length) goto L90;
            char r114 = r113[r112].charValue();
            if (r22 != null) goto L81;
        L83:
            r111.b = 0;
        L85:
            if (r111.b < r111.a.length) goto L87;
            boolean r23 = true;
        L88:
            r111.c = r23;
            goto L90
        L87:
            r23 = false;
            goto L88
        L81:
            if (r114 != r22.charValue()) goto L83;
            r111.b++;
        L90:
            if (r111.c == false) goto L92;
            this.b += 6;
            this.j.h = this.f.toString();
            ImageUrlParser r24 = this.j;
            r24.c = true;
            r24.d = "~tplv-";
            this.f.c();
            this.c = Type.SERVICE_ID;
        L114:
            if (Intrinsics.areEqual(this.j.i, "ecom-shop-material") == false) goto L159;
            b r25 = this.g;
            if (this.c == Type.URI) goto L118;
            boolean r26 = true;
        L120:
            if (r25.e == true) goto L155;
            int r27 = r25.c;
            Character[] r115 = r25.a;
            if (r27 >= r115.length) goto L129;
            if (r115[r27].charValue() != r13) goto L127;
            r25.c++;
            goto L155
        L127:
            r25.c = 0;
            goto L155
        L129:
            if ('0' > r13) goto L146;
            if ('9' < r13) goto L146;
            r25.b[r25.d].a(r13);
            if (r26 == true) goto L136;
        L153:
            if (r26 == false) goto L155;
            r25.d = 0;
            r25.c = 0;
            r25.b[0].c();
            r25.b[1].c();
            r25.e = true;
            goto L155
        L136:
            if (r25.d != 1) goto L153;
            Integer r28 = StringsKt.toIntOrNull(r25.b[0].toString());
            Integer r29 = StringsKt.toIntOrNull(r25.b[1].toString());
            if (r28 == null) goto L153;
            if (r28.intValue() <= 0) goto L153;
            if (r29 == null) goto L153;
            if (r29.intValue() <= 0) goto L153;
            r25.e = true;
            r25.f = r28.intValue();
            r25.g = r29.intValue();
            boolean r30 = true;
        L156:
            if (r30 == false) goto L159;
            this.j.j = Integer.valueOf(this.g.f);
            this.j.k = Integer.valueOf(this.g.g);
        L146:
            if (r13 == '-') goto L148;
        L152:
            r25.d = 0;
            r25.c = 0;
            r25.b[0].c();
            r25.b[1].c();
            goto L153
        L148:
            if (r25.d != 0) goto L152;
            if (r25.b[0].b() == false) goto L152;
            r25.d++;
        L155:
            r30 = false;
            goto L156
        L118:
            r26 = false;
        L159:
            if (this.c != Type.END) goto L3;
        L92:
            d r31 = ImageUrlParser.b(this.j, r110, r12, 0);
            if (r31 == null) goto L95;
            ImageUrlParser r32 = this.j;
            r32.d = "~";
            r32.c = true;
            r32.m = r31.c;
            r32.w = new Pair(Integer.valueOf(r31.a), Integer.valueOf(r31.b));
            this.b += r31.c.length() + 2;
        L96:
            if (r31 == null) goto L98;
            this.j.h = this.f.toString();
            this.f.c();
            this.c = Type.FORMAT;
            goto L114
        L98:
            if (r110 != null) goto L101;
        L105:
            if (r110 == null) goto L111;
            if (r110.charValue() != '?') goto L111;
            this.j.h = this.f.toString();
            this.f.c();
            this.c = Type.END;
            this.a = true;
        L111:
            if (r10 < (this.d - 1)) goto L114;
            this.j.h = this.f.toString();
            this.c = Type.END;
            goto L114
        L101:
            if (r110.charValue() != '.') goto L105;
            ImageUrlParser r33 = this.j;
            if (r33.w == null) goto L105;
            this.b++;
            r33.h = this.f.toString();
            this.f.c();
            this.c = Type.FORMAT;
            goto L114
        L95:
            r31 = null;
            goto L96
        L161:
            Character r34 = StringsKt.getOrNull(this.j.x, r12);
            if (r13 == '/') goto L163;
            if (r34 == null) goto L200;
            if (r34.charValue() != '?') goto L200;
            this.j.h = this.f.toString();
            this.f.c();
            this.c = Type.END;
            this.a = true;
        L200:
            if (r10 < (this.d - 1)) goto L3;
            this.j.h = this.f.toString();
            this.c = Type.END;
            goto L3
        L163:
            String r35 = this.f.toString();
            if (ArraysKt.contains(ImageUrlParser.C, r35) == true) goto L165;
            if (Intrinsics.areEqual(r35, "/aweme/") == false) goto L174;
            d r36 = ImageUrlParser.b(this.j, null, r10, 1);
            if (r36 == null) goto L171;
            ImageUrlParser r37 = this.j;
            r37.c = true;
            r37.g = "/aweme/" + r36.c;
            this.j.w = new Pair(Integer.valueOf(r36.a), Integer.valueOf(r36.b));
            this.b += r36.c.length();
            d r38 = r36;
        L172:
            if (r38 == null) goto L174;
            this.f.c();
            this.c = Type.URI;
            goto L3
        L171:
            r38 = null;
        L174:
            this.c = Type.URI;
            ImageUrlParser r39 = this.j;
            if (r39.i != null) goto L185;
            com.bytedance.android.ec.core.imagex.common.a r40 = this.f;
            int r41 = r40.c + 1;
            int r42 = r40.d;
            int r43 = (r42 - 1) - 1;
            if (r42 <= 1) goto L183;
            int r116 = 1 + r43;
            if (1 > r116) goto L183;
            if (r42 < r116) goto L183;
            String r44 = new String(r40.b, r41, r43);
        L184:
            r39.i = r44;
        L183:
            r44 = null;
        L185:
            com.bytedance.android.ec.core.imagex.common.a r45 = this.f;
            if (r45.d <= 0) goto L188;
            Character r46 = Character.valueOf(r45.b[0]);
        L189:
            if (r46 == null) goto L3;
            if (r46.charValue() != '/') goto L3;
            this.f.c = 1;
            goto L3
        L188:
            r46 = null;
            goto L189
        L165:
            this.j.g = r35;
            this.f.c();
            this.c = Type.URI;
            goto L3
        L202:
            Character r47 = StringsKt.getOrNull(this.j.x, r12);
            if (r47 == null) goto L3;
            if (r47.charValue() != '/') goto L3;
            this.b++;
            this.j.f = this.f.toString();
            com.bytedance.android.ec.core.imagex.common.a r48 = this.f;
            char[] r49 = r48.b;
            r48.d = 1;
            r49[0] = '/';
            this.i = r12;
            this.c = Type.FLAG;
            goto L3
        L208:
            String r50 = this.f.toString();
            if (r50.length() < 7) goto L217;
            String[] r51 = ImageUrlParser.B;
            if (ArraysKt.contains(r51, r50) == false) goto L217;
            ImageUrlParser r52 = this.j;
            if (((Boolean) ImageSettings.q.getValue()).booleanValue() == false) goto L215;
            r50 = r51[0];
        L215:
            r52.e = r50;
            this.f.c();
            this.c = Type.DOMAIN;
        L217:
            if (r10 < 8) goto L3;
            this.b = this.d;
        L220:
            if (this.a == false) goto L230;
            if (this.j.isHierarchical() == false) goto L230;
            Iterator r53 = UriProtector.getQueryParameterNames(this.j.t).iterator();
        L225:
            if (r53.hasNext() == false) goto L230;
            String r54 = (String) r53.next();
            String r55 = UriProtector.getQueryParameter(this.j.t, r54);
            if (r55 == null) goto L225;
            this.j.s.appendQueryParameter(r54, r55);
        L230:
            if (this.j.A == false) goto L309;
            com.bytedance.android.ec.core.imagex.opt.w r56 = com.bytedance.android.ec.core.imagex.opt.w.c;
            r56.getClass();
            if (com.bytedance.android.ec.core.imagex.opt.w.a() == false) goto L309;
            com.bytedance.android.shopping.api.image.k r57 = (com.bytedance.android.shopping.api.image.k) com.bytedance.android.ec.core.imagex.opt.w.b.getValue(r56, com.bytedance.android.ec.core.imagex.opt.w.a[0]);
            if (r57 == null) goto L287;
            ImageUrlParser r58 = this.j;
            com.bytedance.android.ec.core.imagex.r r59 = r58.z;
            Intrinsics.checkNotNullParameter(r57, "$this$matchSign");
            Intrinsics.checkNotNullParameter(r58, "imageUrlParser");
            List r60 = r57.b();
            if (r60 == null) goto L287;
            Iterator r61 = r60.iterator();
        L240:
            if (r61.hasNext() == false) goto L287;
            com.bytedance.android.shopping.api.image.i r62 = (com.bytedance.android.shopping.api.image.i) r61.next();
            List r117 = r62.a();
            if (r117 == null) goto L284;
            Iterator r118 = r117.iterator();
        L245:
            if (r118.hasNext() == false) goto L282;
            Object r119 = r118.next();
            com.bytedance.android.shopping.api.image.j r120 = (com.bytedance.android.shopping.api.image.j) r119;
            if (r58.f(r120.b(), r120.c()) == false) goto L278;
            String r121 = r120.a();
            if (r121 != null) goto L252;
        L255:
            boolean r122 = true;
        L256:
            if (r122 == true) goto L264;
            String r123 = r120.a();
            if (r59 == null) goto L260;
            String r124 = r59.f;
        L262:
            if ((!Intrinsics.areEqual(r123, r124)) == false) goto L264;
        L260:
            r124 = null;
        L264:
            String r125 = r120.d();
            if (r125 != null) goto L267;
        L270:
            boolean r126 = true;
        L271:
            if (r126 == true) goto L279;
            String r127 = r120.d();
            if (r59 == null) goto L275;
            String r128 = r59.g;
        L277:
            if ((!Intrinsics.areEqual(r127, r128)) == false) goto L279;
        L275:
            r128 = null;
        L279:
            boolean r129 = true;
        L280:
            if (r129 == false) goto L245;
        L283:
            com.bytedance.android.shopping.api.image.j r130 = (com.bytedance.android.shopping.api.image.j) r119;
        L285:
            if (r130 == null) goto L240;
            String r63 = r62.b();
        L288:
            if (r63 != null) goto L290;
        L293:
            boolean r64 = true;
        L294:
            if (r64 == true) goto L300;
            String r65 = this.j.f;
            if (r65 == null) goto L300;
            String r66 = null;
            if (true != StringsKt.contains$default(r65, "-sign", false, 2, null)) goto L301;
            r11 = true;
        L301:
            if (r11 == false) goto L303;
            String r67 = r63;
        L304:
            if (r67 == null) goto L309;
            ImageUrlParser r68 = this.j;
            r68.v = true;
            r68.q.remove("lk3s");
            this.j.q.remove("x-signature");
            this.j.q.remove("x-expires");
            ImageUrlParser r69 = this.j;
            if (r69.i(r67, r69.f) == false) goto L309;
            r69.f = r67;
            goto L309
        L303:
            r67 = r66;
        L300:
            r66 = null;
            goto L301
        L290:
            if (r63.length() == 0) goto L293;
            r64 = false;
            goto L294
        L267:
            if (StringsKt.isBlank(r125) == true) goto L270;
            r126 = false;
            goto L271
        L252:
            if (StringsKt.isBlank(r121) == true) goto L255;
            r122 = false;
        L278:
            r129 = false;
            goto L280
        L282:
            r119 = null;
            goto L283
        L284:
            r130 = null;
        L287:
            r63 = null;
        L309:
            this.j.p = new ImageUrlParser$Parser$onUrlParse$1(this);
            this.j.z.f("ec_local_duration_url_parser", Float.valueOf((System.nanoTime() - r1) / 1000000.0f));
        }
    }

    public static final class d {
        public final int a;
        public final int b;
        public final String c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof d) == false) goto L12;
            d r11 = (d) r10;
            if (this.a == r11.a) goto L8;
            return false;
        L8:
            if (this.b == r11.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            String r1 = this.c;
            if (r1 == null) goto L5;
            int r10 = r1.hashCode();
        L7:
            return r0 + r10;
        L5:
            r10 = 0;
            goto L7
        }

        public final String toString() {
            return "SpecialTmpl(width=" + this.a + ", height=" + this.b + ", extraFlag=" + this.c + ")";
        }

        public d(int r10, int r11, String r12) {
            Intrinsics.checkNotNullParameter(r12, "extraFlag");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    public static final class e {
        public final Character[] a;
        public int b;
        public boolean c;

        public e() {
            this.a = new Character[]{'~', 't', 'p', 'l', 'v', '-'};
        }
    }

    public final boolean isHierarchical() {
        return ((Boolean) this.u.getValue()).booleanValue();
    }

    static {
        B = new String[]{"https://", "http://"};
        C = new String[]{"/img/", "/obj/"};
    }

    public final int a() {
        Integer r0 = this.k;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final boolean d() {
        String r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (ArraysKt.contains(B, r0) != true) goto L7;
        return true;
    }

    public final int e() {
        Integer r0 = this.j;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final String k() {
        if (this.v == false) goto L88;
        if (d() == false) goto L88;
        boolean r1 = true;
        StringBuilder r10 = null;
        if (this.c == false) goto L32;
        TmplConvConfig r0 = TmplConvConfig.k;
        r0.getClass();
        if (((Boolean) TmplConvConfig.g.getValue()).booleanValue() == false) goto L18;
        p0 r11 = r0.b();
        if (r11 == null) goto L14;
        Boolean r12 = r11.c();
    L16:
        if (Intrinsics.areEqual(r12, Boolean.TRUE) == false) goto L18;
        boolean r13 = true;
    L19:
        if (r13 == false) goto L32;
        String r14 = this.g;
        if (r14 != null) goto L23;
    L26:
        boolean r15 = true;
    L27:
        if (r15 == false) goto L32;
        if (i("/img/", this.g) == false) goto L32;
        this.g = "/img/";
        goto L32
    L23:
        if (r14.length() == 0) goto L26;
        r15 = false;
        goto L27
    L14:
        r12 = null;
    L18:
        r13 = false;
    L32:
        if (this.a == false) goto L34;
        this.a = false;
        List<String> r16 = this.n;
        StringBuilder r17 = new StringBuilder(this.r * 2);
        String r18 = this.e;
        String r19 = "";
        if (r18 != null) goto L38;
        r18 = "";
    L38:
        r17.append(r18);
        String r20 = this.f;
        if (r20 != null) goto L41;
        r20 = "";
    L41:
        r17.append(r20);
        String r21 = this.g;
        if (r21 != null) goto L44;
        r21 = "";
    L44:
        r17.append(r21);
        Character r22 = StringsKt.lastOrNull(r17);
        if (r22 != null) goto L47;
    L49:
        boolean r23 = false;
    L50:
        if (r23 == false) goto L52;
        r17.append('/');
    L52:
        String r24 = this.h;
        if (r24 != null) goto L55;
        r24 = "";
    L55:
        r17.append(r24);
        if (this.c == false) goto L82;
        String r25 = this.d;
        if (r25 != null) goto L60;
        r25 = "";
    L60:
        r17.append(r25);
        String r26 = this.l;
        if (r26 != null) goto L63;
    L66:
        if (r1 == true) goto L68;
        r17.append(this.l);
        r17.append('-');
    L68:
        String r27 = this.m;
        if (r27 == null) goto L72;
        r19 = r27;
    L72:
        r17.append(r19);
        if (r16 == null) goto L83;
        Iterator<T> r28 = r16.iterator();
    L76:
        if (r28.hasNext() == false) goto L78;
        String r29 = (String) r28.next();
        r17.append(":");
        r17.append(r29);
        goto L76
    L78:
        r17.append(".");
        String r30 = this.o;
        if (r30 != null) goto L81;
        r30 = "image";
    L81:
        r17.append(r30);
    L83:
        if (r10 == null) goto L86;
        this.b = r10.toString();
    L86:
        return this.b;
    L63:
        if (r26.length() == 0) goto L66;
        r1 = false;
    L82:
        r10 = r17;
        goto L83
    L47:
        if (r22.charValue() == '/') goto L49;
        r23 = true;
        goto L50
    L34:
        return this.b;
    L88:
        return this.x;
    }

    public final String c() {
        return this.i;
    }

    public final String getDomain() {
        return this.f;
    }

    public final String getFlag() {
        return this.g;
    }

    public final String getFormat() {
        return this.o;
    }

    public final String getImageUri() {
        return this.h;
    }

    public final String getOriginUrl() {
        return this.y;
    }

    public final com.bytedance.android.shopping.api.image.u getQuery() {
        return this.s;
    }

    public final String getServiceId() {
        return this.l;
    }

    public final Pair<Integer, Integer> h() {
        return this.w;
    }

    public final boolean j() {
        return this.c;
    }

    public final String l() {
        return this.m;
    }

    public final com.bytedance.android.shopping.api.image.t n() {
        return this.p;
    }

    public final boolean f(String r10, String r11) {
        if (r10 == null) goto L5;
        return Intrinsics.areEqual(c(), r10);
    L5:
        if (r11 == null) goto L22;
        String r0 = c();
        if (r0 != null) goto L9;
    L19:
        return false;
    L9:
        if (r0.length() <= 0) goto L11;
        boolean r12 = true;
    L12:
        if (r12 == true) goto L14;
    L16:
        boolean r13 = false;
    L17:
        if (r13 != true) goto L19;
        return true;
    L14:
        if (StringsKt.contains$default(r11, r0, false, 2, null) == false) goto L16;
        r13 = true;
        goto L17
    L11:
        r12 = false;
        goto L12
    L22:
        return true;
    }

    public final boolean i(Object r10, Object r11) {
        if ((r10 instanceof Iterable) == false) goto L5;
    L6:
        if (r10 == r11) goto L10;
        this.a = true;
        return true;
    L10:
        if ((!Intrinsics.areEqual(r10, r11)) == false) goto L13;
        this.a = true;
        return true;
    L13:
        return false;
    L5:
        if ((r11 instanceof Iterable) == false) goto L10;
        goto L6
    }

    public ImageUrlParser(String r10, String r11, com.bytedance.android.ec.core.imagex.r r12) {
        Intrinsics.checkNotNullParameter(r10, "sourceUrl");
        Intrinsics.checkNotNullParameter(r11, "originUrl");
        Intrinsics.checkNotNullParameter(r12, "callerContext");
        this.x = r10;
        this.y = r11;
        this.z = r12;
        this.A = true;
        this.b = r10;
        this.q = new LinkedHashMap();
        this.r = r10.length();
        this.s = new o(this);
        this.t = UriProtector.parse(r10);
        this.u = LazyKt.lazy(new AnonymousClass2(this));
        this.v = com.bytedance.android.ec.core.imagex.transform.b.d(r10);
        new HashMap();
        new c(this);
    }

    public static final d b(ImageUrlParser r11, Character r12, int r13, int r14) {
        r11.getClass();
        if (r14 != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r14 != 1) goto L8;
        boolean r15 = true;
    L9:
        if (r10 == false) goto L15;
        if (r12 != null) goto L13;
    L14:
        boolean r16 = true;
    L16:
        p0 r17 = TmplConvConfig.k.b();
        if (r17 == null) goto L19;
        List r18 = r17.j();
    L20:
        if (r18 == null) goto L22;
        boolean r19 = true;
    L23:
        if (r19 == false) goto L71;
        if (r16 == true) goto L74;
        StringBuilder r110 = new StringBuilder();
        int r20 = r13;
        Integer r21 = null;
        Integer r22 = null;
        int r23 = 0;
    L27:
        r20 = r20 + 1;
        if (r20 >= r11.x.length()) goto L56;
        Character r24 = StringsKt.getOrNull(r11.x, r20);
        if (r24 == null) goto L56;
        char r25 = r24.charValue();
        if ('0' > r25) goto L39;
        if ('9' < r25) goto L39;
    L55:
        r110.append(r25);
    L39:
        if (r25 != 'x') goto L43;
        Integer r26 = StringsKt.toIntOrNull(r110.substring(0, (r20 - r13) - 1));
        int r27 = r20 + 1;
        if (r26 == null) goto L56;
        r21 = Integer.valueOf(r26.intValue());
        r23 = r27;
        goto L55
    L43:
        if (r10 == false) goto L48;
        if (r21 == null) goto L48;
        if (r25 != '.') goto L48;
        r22 = StringsKt.toIntOrNull(r110.substring((r23 - r13) - 1, (r20 - r13) - 1));
    L48:
        if (r15 == false) goto L56;
        if (r21 == null) goto L56;
        if (r25 != '/') goto L56;
        Integer r28 = StringsKt.toIntOrNull(r110.substring((r23 - r13) - 1, (r20 - r13) - 1));
        if (r28 == null) goto L56;
        r22 = Integer.valueOf(r28.intValue());
    L56:
        if (r21 == null) goto L72;
        if (r22 != null) goto L59;
        return null;
    L59:
        return new d(r21.intValue(), r22.intValue(), r110.toString());
    L72:
        return null;
    L74:
        return null;
    L71:
        return null;
    L22:
        r19 = false;
        goto L23
    L19:
        r18 = null;
        goto L20
    L13:
        if (r12.charValue() != '~') goto L14;
    L15:
        r16 = false;
        goto L16
    L8:
        r15 = false;
        goto L9
    L5:
        r10 = false;
        goto L6
    }
}
