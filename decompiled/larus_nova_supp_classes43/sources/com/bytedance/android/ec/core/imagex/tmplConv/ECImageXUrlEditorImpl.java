package com.bytedance.android.ec.core.imagex.tmplConv;

import com.bytedance.android.ec.core.imagex.common.ImageUrlParser;
import com.bytedance.android.ec.core.imagex.common.l;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.api.image.f0;
import com.bytedance.android.shopping.api.image.g0;
import com.bytedance.android.shopping.api.image.i0;
import com.bytedance.android.shopping.api.image.j0;
import com.bytedance.android.shopping.api.image.k0;
import com.bytedance.android.shopping.api.image.l0;
import com.bytedance.android.shopping.api.image.m;
import com.bytedance.android.shopping.api.image.n;
import com.bytedance.android.shopping.api.image.o;
import com.bytedance.android.shopping.api.image.p;
import com.bytedance.android.shopping.api.image.p0;
import com.bytedance.android.shopping.api.image.q0;
import com.bytedance.android.shopping.api.image.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECImageXUrlEditorImpl extends p {
    public final c b;
    public ECImageXTmplParamsEditor c;
    public final r d;
    public final ImageUrlParser e;
    public final String f;

    public final class ECImageXTmplParamsEditor implements o {
        public final boolean a;
        public final a b;
        public final a c;
        public final a d;
        public final a e;
        public final a f;
        public final a g;
        public final a h;
        public final x i;
        public final Lazy j;
        public final Lazy k;
        public final Lazy l;
        public final c m;
        public final /* synthetic */ ECImageXUrlEditorImpl n;

        public final class a implements m {
            public Integer a;
            public boolean b;
            public boolean c;
            public final int d;
            public final TmplParamType e;
            public final /* synthetic */ ECImageXTmplParamsEditor f;

            public a() {
                throw null;
            }

            public final String d() {
                if (b.a[this.e.ordinal()] == 1) goto L9;
                Integer r0 = getValue();
                if (r0 == null) goto L8;
                String r1 = String.valueOf(r0.intValue());
                if (r1 == null) goto L8;
                return r1;
            L8:
                return "0";
            L9:
                Integer r10 = getValue();
                if (r10 == null) goto L12;
                int r11 = r10.intValue();
            L14:
                return "q" + r11;
            L12:
                r11 = 0;
                goto L14
            }

            public final Integer getValue() {
                Integer r0 = this.a;
                if (r0 == null) goto L5;
                return r0;
            L5:
                if (this.b == true) goto L10;
                return null;
            L10:
                return Integer.valueOf(this.d);
            }

            public final boolean a() {
                return this.b;
            }

            public final Integer b(String r10) {
                int r0 = 1;
                int r1 = 0;
                if (r10 != null) goto L5;
            L8:
                boolean r11 = true;
            L10:
                if (r11 == false) goto L13;
                return null;
            L13:
                if (this.e != TmplParamType.QUALITY) goto L17;
                if (r10.charAt(0) != 'q') goto L17;
            L20:
                int r12 = r10.length();
            L21:
                if (r0 >= r12) goto L30;
                char r13 = r10.charAt(r0);
                if ('0' > r13) goto L28;
                if ('9' < r13) goto L28;
                r1 = (r1 * 10) + (r13 - '0');
                r0 = r0 + 1;
            L28:
                return null;
            L30:
                return Integer.valueOf(r1);
            L17:
                if (r10.charAt(0) == 'Q') goto L20;
                r0 = 0;
                goto L20
            L5:
                if (r10.length() == 0) goto L8;
                r11 = false;
                goto L10
            }

            public final boolean c(Integer r10) {
                ECImageXTmplParamsEditor r0 = this.f;
                boolean r11 = false;
                if (r0.n.e.v == false) goto L23;
                if (r0.m.a == true) goto L23;
                if (Intrinsics.areEqual(r10, this.a) == false) goto L11;
            L10:
                r11 = true;
                goto L23
            L11:
                ECImageXTmplParamsEditor r1 = this.f;
                boolean r12 = r1.a;
                if (r12 == false) goto L14;
            L17:
                this.a = r10;
                if (r12 == true) goto L10;
                c r13 = r1.m;
                if (r13.b == true) goto L10;
                r13.b = true;
                goto L10
            L14:
                if (this.b == false) goto L23;
                if (this.c == true) goto L17;
            L23:
                if (this.f.a == false) goto L26;
                if (r11 == false) goto L26;
                this.b = true;
            L26:
                return r11;
            }

            public a(ECImageXTmplParamsEditor r1, TmplParamType r10, int r11) {
                if ((r11 & 2) == 0) goto L5;
                r10 = TmplParamType.NUMBER;
            L5:
                Intrinsics.checkNotNullParameter(r10, "type");
                this.f = r1;
                this.d = 0;
                this.e = r10;
            }
        }

        public final String i() {
            return (String) this.k.getValue();
        }

        public final boolean m() {
            return ((Boolean) this.l.getValue()).booleanValue();
        }

        public final Integer k() {
            if (this.n.e() > 0) goto L5;
        L26:
            return null;
        L5:
            if (this.n.a() <= 0) goto L26;
            if (m() == true) goto L28;
            a r0 = this.b;
            if (r0.b == false) goto L26;
            if (this.c.b == false) goto L26;
            Integer r1 = r0.getValue();
            int r10 = 0;
            if (r1 == null) goto L16;
            int r11 = r1.intValue();
        L17:
            Integer r12 = this.c.getValue();
            if (r12 == null) goto L20;
            r10 = r12.intValue();
        L20:
            if (r11 != 0) goto L23;
            if (r10 != 0) goto L23;
            return Integer.valueOf(this.n.e() * this.n.a());
        L23:
            if (r11 == 0) goto L31;
            return Integer.valueOf(((this.n.a() * r11) / this.n.e()) * r11);
        L31:
            return Integer.valueOf(((this.n.e() * r10) / this.n.a()) * r10);
        L16:
            r11 = 0;
            goto L17
        L28:
            return Integer.valueOf(this.n.e() * this.n.a());
        }

        public final m a(String r10) {
            if (r10 != null) goto L5;
        L28:
            return null;
        L5:
            switch(r10.hashCode()) {
                case -1050356101: goto L26;
                case 651215103: goto L23;
                case 1038216603: goto L20;
                case 1038216604: goto L17;
                case 1038216789: goto L14;
                case 1038216790: goto L11;
                case 1365704466: goto L8;
                default: goto L28;
            };
        L8:
            if (r10.equals("resize_height") == false) goto L28;
            return this.c;
        L11:
            if (r10.equals("crop_ry") == false) goto L28;
            return this.g;
        L14:
            if (r10.equals("crop_rx") == false) goto L28;
            return this.e;
        L17:
            if (r10.equals("crop_ly") == false) goto L28;
            return this.f;
        L20:
            if (r10.equals("crop_lx") == false) goto L28;
            return this.d;
        L23:
            if (r10.equals("quality") == false) goto L28;
            return this.h;
        L26:
            if (r10.equals("resize_width") == false) goto L28;
            return this.b;
        }

        public ECImageXTmplParamsEditor(ECImageXUrlEditorImpl r10, c r11, a r12) {
            Intrinsics.checkNotNullParameter(r11, "editorController");
            this.n = r10;
            this.m = r11;
            this.b = new a(this, null, 3);
            this.c = new a(this, null, 3);
            this.d = new a(this, null, 3);
            this.e = new a(this, null, 3);
            this.f = new a(this, null, 3);
            this.g = new a(this, null, 3);
            boolean r13 = true;
            this.h = new a(this, TmplParamType.QUALITY, 1);
            if (r12 == null) goto L5;
            x r14 = r12.b;
        L6:
            this.i = r14;
            Function0<String> r15 = new ECImageXUrlEditorImpl$ECImageXTmplParamsEditor$targetTmplName$2(this);
            LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
            this.j = LazyKt.lazy(r1, r15);
            this.k = LazyKt.lazy(r1, new ECImageXUrlEditorImpl$ECImageXTmplParamsEditor$tmplType$2(this));
            this.l = LazyKt.lazy(r1, new ECImageXUrlEditorImpl$ECImageXTmplParamsEditor$isOriginImage$2(this));
            this.a = true;
            if (r12 != null) goto L9;
        L27:
            if (r12 == null) goto L59;
            List r16 = r12.b.a();
            List r17 = r16;
            if (r17 != null) goto L31;
        L34:
            boolean r18 = true;
        L35:
            if (r18 == true) goto L46;
            Iterator r19 = r16.iterator();
        L38:
            if (r19.hasNext() == false) goto L46;
            String r20 = (String) r19.next();
            m r21 = r12.a.a(r20);
            if (r21 == null) goto L42;
            Integer r22 = ((a) r21).getValue();
        L44:
            if (c(r20, r22, Boolean.TRUE) == true) goto L38;
        L234:
            this.a = false;
            return;
        L42:
            r22 = null;
        L46:
            HashMap r23 = r12.b.f();
            if (r23 != null) goto L49;
        L52:
            if (r13 == true) goto L234;
            Iterator r24 = r23.entrySet().iterator();
        L55:
            if (r24.hasNext() == false) goto L234;
            Map.Entry r25 = (Map.Entry) r24.next();
            if (c((String) r25.getKey(), r25.getValue(), null) == true) goto L55;
        L49:
            if (r23.isEmpty() == true) goto L52;
            r13 = false;
            goto L52
        L31:
            if (r17.isEmpty() == true) goto L34;
            r18 = false;
            goto L35
        L59:
            r10.n();
            if (r10.j() == false) goto L160;
            if (r10.h() == null) goto L89;
            p0 r26 = TmplConvConfig.k.b();
            if (r26 == null) goto L193;
            List r27 = r26.j();
            if (r27 == null) goto L193;
            Iterator r28 = r27.iterator();
        L69:
            if (r28.hasNext() == false) goto L73;
            Object r29 = r28.next();
            ECImageXUrlEditorImpl r30 = this.n;
            if (l.b((k0) r29, r30.d, r30) == false) goto L69;
        L74:
            k0 r31 = (k0) r29;
            if (r31 == null) goto L193;
            HashMap r32 = r31.f();
            if (r32 == null) goto L79;
            HashMap r33 = new HashMap(r32);
        L80:
            Pair r34 = this.n.h();
            if (r34 == null) goto L83;
            Integer r35 = (Integer) r34.getFirst();
        L84:
            r33.put("resize_width", Integer.valueOf(r35.intValue()));
            Pair r36 = this.n.h();
            if (r36 == null) goto L87;
            Integer r37 = (Integer) r36.getSecond();
        L88:
            r33.put("resize_height", Integer.valueOf(r37.intValue()));
            k0 r38 = k0.h(r31, r33);
        L194:
            this.i = r38;
            if (r38 == null) goto L234;
            List<String> r39 = this.n.e.n;
            if (r39 != null) goto L200;
            r39 = CollectionsKt.emptyList();
        L200:
            int r40 = r39.size();
            List r41 = r38.a();
            if (r41 == null) goto L203;
            int r42 = r41.size();
        L204:
            if (r40 != r42) goto L234;
            HashMap r43 = r38.f();
            if (r43 != null) goto L209;
        L212:
            if (r13 == true) goto L219;
            Iterator r44 = r43.entrySet().iterator();
        L215:
            if (r44.hasNext() == false) goto L219;
            Map.Entry r45 = (Map.Entry) r44.next();
            if (c((String) r45.getKey(), r45.getValue(), null) == true) goto L215;
        L219:
            x r46 = this.i;
            if (r46 == null) goto L222;
            List r47 = r46.a();
        L223:
            Iterator<T> r48 = r39.iterator();
            int r49 = 0;
        L225:
            if (r48.hasNext() == false) goto L234;
            String r50 = (String) r48.next();
            if (r47 == null) goto L229;
            String r51 = (String) CollectionsKt.getOrNull(r47, r49);
        L231:
            if (c(r51, r50, Boolean.TRUE) == false) goto L234;
            r49 = r49 + 1;
            goto L225
        L229:
            r51 = null;
            goto L231
        L222:
            r47 = null;
            goto L223
        L209:
            if (r43.isEmpty() == true) goto L212;
            r13 = false;
            goto L212
        L203:
            r42 = 0;
            goto L204
        L87:
            r37 = null;
            goto L88
        L83:
            r35 = null;
            goto L84
        L79:
            r33 = new HashMap();
            goto L80
        L73:
            r29 = null;
        L193:
            r38 = null;
            goto L194
        L89:
            String r52 = r10.getServiceId();
            if (r52 != null) goto L92;
        L95:
            boolean r53 = true;
        L96:
            if (r53 == true) goto L124;
            String r54 = r10.l();
            if (r54 != null) goto L100;
        L103:
            boolean r55 = true;
        L104:
            if (r55 == true) goto L124;
            TmplConvConfig r56 = TmplConvConfig.k;
            p0 r57 = r56.b();
            if (r57 == null) goto L119;
            HashMap r58 = r57.e();
            if (r58 == null) goto L119;
            g0 r59 = (g0) r58.get(r10.getServiceId());
            if (r59 == null) goto L119;
            HashMap r60 = r59.a();
            if (r60 == null) goto L116;
            l0 r61 = (l0) r60.get(r10.l());
            if (r61 == null) goto L116;
            Intrinsics.checkNotNullParameter(r59, "mather");
            k0 r62 = new l0.a(r61, r59);
        L117:
            if (r62 == null) goto L119;
            r38 = r62;
        L116:
            r62 = null;
        L119:
            p0 r63 = r56.b();
            if (r63 == null) goto L193;
            HashMap r64 = r63.b();
            if (r64 == null) goto L193;
            r38 = (q0) r64.get(r10.l());
            goto L194
        L100:
            if (r54.length() == 0) goto L103;
            r55 = false;
        L124:
            String r65 = r10.getServiceId();
            if (r65 != null) goto L127;
        L130:
            boolean r66 = true;
        L131:
            if (r66 == false) goto L193;
            String r67 = r10.l();
            if (r67 != null) goto L135;
        L138:
            boolean r68 = true;
        L139:
            if (r68 == true) goto L193;
            p0 r69 = TmplConvConfig.k.b();
            if (r69 == null) goto L193;
            HashMap r70 = r69.i();
            if (r70 == null) goto L193;
            j0 r71 = (j0) r70.get(r10.l());
            if (r71 == null) goto L193;
            List r72 = r71.b();
            if (r72 == null) goto L156;
            Iterator r73 = r72.iterator();
        L150:
            if (r73.hasNext() == false) goto L154;
            Object r74 = r73.next();
            ECImageXUrlEditorImpl r75 = this.n;
            if (l.b((f0) r74, r75.d, r75) == false) goto L150;
        L155:
            f0 r76 = (f0) r74;
        L157:
            if (r76 == null) goto L193;
            Intrinsics.checkNotNullParameter(r76, "target");
            r38 = new j0.a(r71, r76);
            goto L194
        L154:
            r74 = null;
            goto L155
        L156:
            r76 = null;
            goto L157
        L135:
            if (r67.length() == 0) goto L138;
            r68 = false;
            goto L139
        L127:
            if (r65.length() == 0) goto L130;
            r66 = false;
            goto L131
        L92:
            if (r52.length() == 0) goto L95;
            r53 = false;
            goto L96
        L160:
            if (Intrinsics.areEqual(r10.getFlag(), "/obj/") == false) goto L173;
            p0 r77 = TmplConvConfig.k.b();
            if (r77 == null) goto L193;
            List r78 = r77.h();
            if (r78 == null) goto L193;
            Iterator r79 = r78.iterator();
        L167:
            if (r79.hasNext() == false) goto L171;
            Object r80 = r79.next();
            ECImageXUrlEditorImpl r81 = this.n;
            if (l.b((i0) r80, r81.d, r81) == false) goto L167;
        L172:
            r38 = (i0) r80;
            goto L194
        L171:
            r80 = null;
            goto L172
        L173:
            String r82 = r10.getFlag();
            if (r82 != null) goto L176;
        L179:
            boolean r83 = true;
        L180:
            if (r83 == false) goto L193;
            p0 r84 = TmplConvConfig.k.b();
            if (r84 == null) goto L193;
            List r85 = r84.f();
            if (r85 == null) goto L193;
            Iterator r86 = r85.iterator();
        L187:
            if (r86.hasNext() == false) goto L191;
            Object r87 = r86.next();
            ECImageXUrlEditorImpl r88 = this.n;
            if (l.b((i0) r87, r88.d, r88) == false) goto L187;
        L192:
            r38 = (i0) r87;
            goto L194
        L191:
            r87 = null;
            goto L192
        L176:
            if (r82.length() == 0) goto L179;
            r83 = false;
            goto L180
        L9:
            if (r12.c == false) goto L27;
            List r89 = r12.b.a();
            List r90 = r89;
            if (r90 != null) goto L13;
        L16:
            if (r13 == true) goto L234;
            Iterator r91 = r89.iterator();
        L19:
            if (r91.hasNext() == false) goto L234;
            String r92 = (String) r91.next();
            m r93 = r12.a.a(r92);
            if (r93 == null) goto L23;
            Integer r94 = ((a) r93).getValue();
        L25:
            if (c(r92, r94, Boolean.TRUE) == true) goto L19;
        L23:
            r94 = null;
            goto L25
        L13:
            if (r90.isEmpty() == true) goto L16;
            r13 = false;
            goto L16
        L5:
            r14 = null;
            goto L6
        }

        public final boolean c(String r10, Object r11, Boolean r12) {
            m r13 = a(r10);
            if (r13 != null) goto L5;
        L22:
            return false;
        L5:
            if ((r11 instanceof String) == false) goto L10;
            String r14 = (String) r11;
            Integer r0 = r13.b(r14);
            if (r0 != null) goto L13;
            r0 = StringsKt.toIntOrNull(r14);
        L13:
            if (r12 == null) goto L20;
            if ((r13 instanceof a) == false) goto L20;
            a r15 = (a) r13;
            boolean r16 = r12.booleanValue();
            if (r15.f.a == false) goto L20;
            r15.c = r16;
        L20:
            if (r13.c(r0) != true) goto L22;
            return true;
        L10:
            if ((r11 instanceof Number) == false) goto L12;
            r0 = Integer.valueOf(((Number) r11).intValue());
            goto L13
        L12:
            r0 = null;
            goto L13
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/tmplConv/ECImageXUrlEditorImpl$TmplParamType;", "", "NUMBER", "QUALITY", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TmplParamType extends Enum<TmplParamType> {
        public static final TmplParamType NUMBER = null;
        public static final TmplParamType QUALITY = null;
        public static final /* synthetic */ TmplParamType[] a = null;

        static {
            TmplParamType r1 = new TmplParamType("NUMBER", 0);
            NUMBER = r1;
            TmplParamType r10 = new TmplParamType("QUALITY", 1);
            QUALITY = r10;
            a = new TmplParamType[]{r1, r10};
        }

        public static TmplParamType valueOf(String r1) {
            return (TmplParamType) r27.a.a(TmplParamType.class, r1);
        }

        public static TmplParamType[] values() {
            return (TmplParamType[]) a.clone();
        }

        public TmplParamType(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
        public final ECImageXTmplParamsEditor a;
        public final x b;
        public final boolean c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == false) goto L12;
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r11.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            ECImageXTmplParamsEditor r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r10 = r0.hashCode();
        L6:
            int r11 = r10 * 31;
            x r12 = this.b;
            if (r12 == null) goto L9;
            r1 = r12.hashCode();
        L9:
            int r13 = (r11 + r1) * 31;
            boolean r14 = this.c;
            ?? r15 = r14;
            if (r14 == false) goto L13;
            r15 = 1;
        L13:
            return r13 + r15;
        L5:
            r10 = 0;
            goto L6
        }

        public final String toString() {
            return "ReplaceModel(prepareParamsEditor=" + this.a + ", replaceTmplModel=" + this.b + ", isCloneEditor=" + this.c + ")";
        }

        public a(ECImageXTmplParamsEditor r10, q0 r11) {
            Intrinsics.checkNotNullParameter(r10, "prepareParamsEditor");
            Intrinsics.checkNotNullParameter(r11, "replaceTmplModel");
            this.a = r10;
            this.b = r11;
            this.c = false;
        }
    }

    public final n b() {
        return this.c.c;
    }

    public final n d() {
        return this.c.b;
    }

    public final String getFormat() {
        String r0 = this.e.o;
        if (r0 != null) goto L6;
        return "image";
    L6:
        return r0;
    }

    public final n getQuality() {
        return this.c.h;
    }

    public final String i() {
        return this.c.i();
    }

    public final Integer k() {
        return this.c.k();
    }

    public final boolean m() {
        return this.c.m();
    }

    public final void q() {
        if (this.b.b == true) goto L5;
        return;
    L5:
        ImageUrlParser r0 = this.e;
        ECImageXTmplParamsEditor r1 = this.c;
        x r10 = r1.i;
        if (r10 == null) goto L18;
        ArrayList r11 = new ArrayList();
        List r12 = r10.a();
        boolean r13 = false;
        if (r12 == null) goto L16;
        Iterator r14 = r12.iterator();
    L11:
        if (r14.hasNext() == false) goto L16;
        m r15 = r1.a((String) r14.next());
        if (r15 != null) goto L14;
        r13 = true;
        goto L11
    L14:
        r11.add(r15.d());
    L16:
        if (r13 == true) goto L18;
    L20:
        if (r0.i(r11, r0.n) == false) goto L22;
        r0.n = r11;
    L22:
        this.b.b = true;
        return;
    L18:
        r11 = null;
        goto L20
    }

    public final String g() {
        q();
        return this.e.k();
    }

    public final String getOriginUrl() {
        return this.f;
    }

    public final void o(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        ImageUrlParser r0 = this.e;
        if (r0.c == true) goto L5;
        return;
    L5:
        if (r0.i(r10, r0.o) == false) goto L9;
        r0.o = r10;
        return;
    }

    public ECImageXUrlEditorImpl(r r10, ImageUrlParser r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "callerContext");
        Intrinsics.checkNotNullParameter(r11, "imageUrlParser");
        Intrinsics.checkNotNullParameter(r12, "originUrl");
        super(r11);
        this.d = r10;
        this.e = r11;
        this.f = r12;
        c r13 = new c();
        this.b = r13;
        this.c = new ECImageXTmplParamsEditor(this, r13, null);
    }

    public final void p(String r10, String r11, q0 r12) {
        Intrinsics.checkNotNullParameter(r11, "tmplName");
        Intrinsics.checkNotNullParameter(r12, "targetTmplModel");
        if (r10 == null) goto L7;
        ImageUrlParser r0 = this.e;
        if (r0.i(r10, r0.l) == false) goto L7;
        r0.l = r10;
    L7:
        ImageUrlParser r13 = this.e;
        if (r13.i(r11, r13.m) == false) goto L10;
        r13.m = r11;
    L10:
        ImageUrlParser r14 = this.e;
        if (r14.i(Boolean.TRUE, Boolean.valueOf(r14.c)) == false) goto L13;
        r14.c = true;
        r14.g = "/img/";
    L13:
        ImageUrlParser r15 = this.e;
        if (r15.c == true) goto L16;
    L18:
        ImageUrlParser r16 = this.e;
        if (r16.i("/img/", r16.g) == false) goto L21;
        r16.g = "/img/";
    L21:
        this.c = new ECImageXTmplParamsEditor(this, this.b, new a(this.c, r12));
        this.b.b = true;
        return;
    L16:
        if (r15.i("~tplv-", r15.d) == false) goto L18;
        r15.d = "~tplv-";
        goto L18
    }
}
