package com.larksuite.component.card.component.text;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.larksuite.component.card.component.udicon.UDIconContentProps;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public static final e a = null;
    public static final TextProps b = null;
    public static final ContentProps c = null;
    public static final AtProps d = null;
    public static final LinkProps e = null;
    public static final UDIconContentProps f = null;
    public static final EmojProps g = null;
    public static final PlainTextProps h = null;
    public static final TagProps i = null;
    public static final ListItem j = null;
    public static final CardCodeBlockProps k = null;
    public static final CardCodeBlockProps.b l = null;
    public static final CardCodeBlockProps.b.a m = null;
    public static final com.larksuite.component.card.component.image.a n = null;
    public static final PersonProps o = null;
    public static final Person p = null;
    public static final ContainerPadding q = null;
    public static final HeadingProps r = null;
    public static final NumberTagProps s = null;
    public static final AudioProps t = null;
    public static final a u = null;
    public static final MarkdownAudioState v = null;
    public static final MarkdownAudioBgPadding w = null;

    public e() {
    }

    static {
        a = new e();
        b = new TextProps(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        c = new ContentProps(null, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65533, null);
        d = new AtProps(null, null, null, null, null, null, 0, 127, null);
        e = new LinkProps(null, null, null, null, null, null, null, null, 0, 511, null);
        f = new UDIconContentProps(null, null, null, null, false, null, 63, null);
        g = new EmojProps(null, 0, 3, null);
        h = new PlainTextProps(null, null, null, null, null, 0, 63, null);
        i = new TagProps(null, null, null, null, 0, 0, 0, null, null, null, 0, 2047, null);
        j = new ListItem(0, null, null, null, 15, null);
        k = new CardCodeBlockProps();
        l = new CardCodeBlockProps.b();
        m = new CardCodeBlockProps.b.a();
        n = new com.larksuite.component.card.component.image.a(0);
        o = new PersonProps(null, false, false, null, null, null, null, null, null, null, 0, 2047, null);
        p = new Person(null, null, null, 7, null);
        q = new ContainerPadding(0, 0, 0, 0, 15, null);
        r = new HeadingProps(null, 1, null);
        s = new NumberTagProps(null, 0, 0, null, null, null, null, null, null, 0, 1023, null);
        t = new AudioProps(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 32767, null);
        u = new a(0);
        v = new MarkdownAudioState(null, null, null, 7, null);
        w = new MarkdownAudioBgPadding(0, 0, 0, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v425, types: [java.util.ArrayList] */
    public final ContentProps f(ReadableMap r25) {
        ContentProps r2 = c;
        String r6 = com.larksuite.component.card.component.f.n(r25, "id", r2.getId());
        String r3 = com.larksuite.component.card.component.f.n(r25, "tag", r2.getTag());
        if (r3 != null) goto L5;
        r3 = r2.getTag();
    L5:
        String r7 = r3;
        ReadableMap r4 = com.larksuite.component.card.component.f.k(r25, "atProps");
        if (r4 != null) goto L8;
        AtProps r5 = r2.getAtProps();
    L76:
        AtProps r8 = r5;
        ReadableMap r9 = com.larksuite.component.card.component.f.k(r25, "linkProps");
        if (r9 != null) goto L79;
        LinkProps r10 = r2.getLinkProps();
    L147:
        LinkProps r11 = r10;
        ReadableMap r12 = com.larksuite.component.card.component.f.k(r25, "emojProps");
        if (r12 != null) goto L150;
        EmojProps r13 = r2.getEmojProps();
    L218:
        EmojProps r14 = r13;
        ReadableMap r15 = com.larksuite.component.card.component.f.k(r25, "plainTextProps");
        if (r15 != null) goto L221;
        PlainTextProps r16 = r2.getPlainTextProps();
    L289:
        PlainTextProps r17 = r16;
        ReadableMap r19 = com.larksuite.component.card.component.f.k(r25, "textTagProps");
        if (r19 != null) goto L292;
        TagProps r20 = r2.getTextTagProps();
    L360:
        TagProps r110 = r20;
        ReadableArray r21 = com.larksuite.component.card.component.f.a(r25, "listProps");
        if (r21 == null) goto L501;
        ?? r22 = new ArrayList();
        int r111 = r21.size();
        int r112 = 0;
    L363:
        if (r112 >= r111) goto L502;
        if (Intrinsics.areEqual(ListItem.class, Boolean.TYPE) == false) goto L374;
        Object r23 = com.larksuite.component.card.component.f.b(r21, r112);
        if ((r23 instanceof ListItem) == true) goto L369;
        r23 = null;
    L369:
        ListItem r24 = (ListItem) r23;
        if (r24 == null) goto L500;
        r22.add(r24);
    L500:
        r112 = r112 + 1;
        r21 = r21;
        goto L363
    L374:
        if (Intrinsics.areEqual(ListItem.class, Double.TYPE) == false) goto L382;
        Object r26 = com.larksuite.component.card.component.f.f(r21, r112);
        if ((r26 instanceof ListItem) == true) goto L378;
        r26 = null;
    L378:
        ListItem r27 = (ListItem) r26;
        if (r27 == null) goto L500;
        r22.add(r27);
        goto L500
    L382:
        if (Intrinsics.areEqual(ListItem.class, Byte.TYPE) == false) goto L390;
        Object r29 = com.larksuite.component.card.component.f.d(r21, r112);
        if ((r29 instanceof ListItem) == true) goto L386;
        r29 = null;
    L386:
        ListItem r30 = (ListItem) r29;
        if (r30 == null) goto L500;
        r22.add(r30);
        goto L500
    L390:
        if (Intrinsics.areEqual(ListItem.class, Short.TYPE) == false) goto L398;
        Object r31 = com.larksuite.component.card.component.f.l(r21, r112);
        if ((r31 instanceof ListItem) == true) goto L394;
        r31 = null;
    L394:
        ListItem r32 = (ListItem) r31;
        if (r32 == null) goto L500;
        r22.add(r32);
        goto L500
    L398:
        if (Intrinsics.areEqual(ListItem.class, Long.TYPE) == false) goto L406;
        Object r33 = com.larksuite.component.card.component.f.i(r21, r112);
        if ((r33 instanceof ListItem) == true) goto L402;
        r33 = null;
    L402:
        ListItem r34 = (ListItem) r33;
        if (r34 == null) goto L500;
        r22.add(r34);
        goto L500
    L406:
        if (Intrinsics.areEqual(ListItem.class, Character.TYPE) == false) goto L414;
        Object r35 = com.larksuite.component.card.component.f.e(r21, r112);
        if ((r35 instanceof ListItem) == true) goto L410;
        r35 = null;
    L410:
        ListItem r36 = (ListItem) r35;
        if (r36 == null) goto L500;
        r22.add(r36);
        goto L500
    L414:
        if (Intrinsics.areEqual(ListItem.class, Integer.TYPE) == false) goto L422;
        Object r37 = com.larksuite.component.card.component.f.g(r21, r112);
        if ((r37 instanceof ListItem) == true) goto L418;
        r37 = null;
    L418:
        ListItem r38 = (ListItem) r37;
        if (r38 == null) goto L500;
        r22.add(r38);
        goto L500
    L422:
        if (Intrinsics.areEqual(ListItem.class, String.class) == false) goto L429;
        Object r39 = com.larksuite.component.card.component.f.m(r21, r112);
        if ((r39 instanceof ListItem) == true) goto L426;
        r39 = null;
    L426:
        ListItem r40 = (ListItem) r39;
        if (r40 == null) goto L500;
        r22.add(r40);
        goto L500
    L429:
        ReadableMap r41 = com.larksuite.component.card.component.f.j(r21, r112);
        if (r41 == null) goto L500;
        if (Intrinsics.areEqual(ListItem.class, TextProps.class) == false) goto L435;
        ListItem r42 = (ListItem) u(r41);
    L497:
        r22.add(r42);
        goto L500
    L435:
        if (Intrinsics.areEqual(ListItem.class, ContentProps.class) == false) goto L438;
        r42 = (ListItem) f(r41);
        goto L497
    L438:
        if (Intrinsics.areEqual(ListItem.class, AtProps.class) == false) goto L441;
        r42 = (ListItem) a(r41);
        goto L497
    L441:
        if (Intrinsics.areEqual(ListItem.class, LinkProps.class) == false) goto L444;
        r42 = (ListItem) k(r41);
        goto L497
    L444:
        if (Intrinsics.areEqual(ListItem.class, UDIconContentProps.class) == false) goto L447;
        r42 = (ListItem) v(r41);
        goto L497
    L447:
        if (Intrinsics.areEqual(ListItem.class, EmojProps.class) == false) goto L450;
        r42 = (ListItem) h(r41);
        goto L497
    L450:
        if (Intrinsics.areEqual(ListItem.class, PlainTextProps.class) == false) goto L453;
        r42 = (ListItem) s(r41);
        goto L497
    L453:
        if (Intrinsics.areEqual(ListItem.class, TagProps.class) == false) goto L456;
        r42 = (ListItem) t(r41);
        goto L497
    L456:
        if (Intrinsics.areEqual(ListItem.class, ListItem.class) == false) goto L459;
        r42 = l(r41);
        goto L497
    L459:
        if (Intrinsics.areEqual(ListItem.class, CardCodeBlockProps.class) == false) goto L462;
        r42 = (ListItem) c(r41);
        goto L497
    L462:
        if (Intrinsics.areEqual(ListItem.class, CardCodeBlockProps.b.class) == false) goto L465;
        r42 = (ListItem) g(r41);
        goto L497
    L465:
        if (Intrinsics.areEqual(ListItem.class, CardCodeBlockProps.b.a.class) == false) goto L468;
        r42 = (ListItem) e(r41);
        goto L497
    L468:
        if (Intrinsics.areEqual(ListItem.class, com.larksuite.component.card.component.image.a.class) == false) goto L471;
        r42 = (ListItem) j(r41);
        goto L497
    L471:
        if (Intrinsics.areEqual(ListItem.class, PersonProps.class) == false) goto L474;
        r42 = (ListItem) r(r41);
        goto L497
    L474:
        if (Intrinsics.areEqual(ListItem.class, Person.class) == false) goto L477;
        r42 = (ListItem) q(r41);
        goto L497
    L477:
        if (Intrinsics.areEqual(ListItem.class, ContainerPadding.class) == false) goto L480;
        r42 = (ListItem) d(r41);
        goto L497
    L480:
        if (Intrinsics.areEqual(ListItem.class, HeadingProps.class) == false) goto L483;
        r42 = (ListItem) i(r41);
        goto L497
    L483:
        if (Intrinsics.areEqual(ListItem.class, NumberTagProps.class) == false) goto L486;
        r42 = (ListItem) p(r41);
        goto L497
    L486:
        if (Intrinsics.areEqual(ListItem.class, AudioProps.class) == false) goto L489;
        r42 = (ListItem) b(r41);
        goto L497
    L489:
        if (Intrinsics.areEqual(ListItem.class, a.class) == false) goto L492;
        r42 = (ListItem) n(r41);
        goto L497
    L492:
        if (Intrinsics.areEqual(ListItem.class, MarkdownAudioState.class) == false) goto L495;
        r42 = (ListItem) o(r41);
        goto L497
    L495:
        if (Intrinsics.areEqual(ListItem.class, MarkdownAudioBgPadding.class) == false) goto L499;
        r42 = (ListItem) m(r41);
        goto L497
    L499:
        throw new IllegalArgumentException("unsupported type: " + ListItem.class);
    L502:
        ?? r113 = r22;
        ReadableMap r43 = com.larksuite.component.card.component.f.k(r25, "codeBlockProps");
        if (r43 != null) goto L505;
        CardCodeBlockProps r44 = c.getCodeBlockProps();
    L573:
        CardCodeBlockProps r114 = r44;
        ReadableMap r45 = com.larksuite.component.card.component.f.k(r25, "imageProps");
        if (r45 != null) goto L576;
        com.larksuite.component.card.component.image.a r46 = c.getImageProps();
    L644:
        com.larksuite.component.card.component.image.a r115 = r46;
        ReadableMap r47 = com.larksuite.component.card.component.f.k(r25, "personProps");
        if (r47 != null) goto L647;
        PersonProps r48 = c.getPersonProps();
    L715:
        ReadableMap r49 = com.larksuite.component.card.component.f.k(r25, "headingProps");
        if (r49 == null) goto L785;
        PersonProps r116 = r48;
        if (Intrinsics.areEqual(HeadingProps.class, TextProps.class) == false) goto L721;
        HeadingProps r50 = (HeadingProps) u(r49);
    L786:
        ReadableMap r51 = com.larksuite.component.card.component.f.k(r25, "codeSpanProps");
        if (r51 == null) goto L856;
        HeadingProps r117 = r50;
        if (Intrinsics.areEqual(PlainTextProps.class, TextProps.class) == false) goto L792;
        PlainTextProps r52 = (PlainTextProps) u(r51);
    L857:
        ReadableArray r53 = com.larksuite.component.card.component.f.a(r25, "blockQuoteProps");
        if (r53 == null) goto L999;
        ArrayList r54 = new ArrayList();
        int r55 = r53.size();
        int r118 = 0;
    L860:
        if (r118 >= r55) goto L998;
        int r119 = r55;
        CardCodeBlockProps r210 = r114;
        if (Intrinsics.areEqual(ContentProps.class, Boolean.TYPE) == false) goto L871;
        Object r56 = com.larksuite.component.card.component.f.b(r53, r118);
        if ((r56 instanceof ContentProps) == true) goto L866;
        r56 = null;
    L866:
        ContentProps r57 = (ContentProps) r56;
        if (r57 == null) goto L997;
        r54.add(r57);
    L997:
        r118 = r118 + 1;
        r55 = r119;
        r114 = r210;
        r53 = r53;
        goto L860
    L871:
        if (Intrinsics.areEqual(ContentProps.class, Double.TYPE) == false) goto L879;
        Object r59 = com.larksuite.component.card.component.f.f(r53, r118);
        if ((r59 instanceof ContentProps) == true) goto L875;
        r59 = null;
    L875:
        ContentProps r60 = (ContentProps) r59;
        if (r60 == null) goto L997;
        r54.add(r60);
        goto L997
    L879:
        if (Intrinsics.areEqual(ContentProps.class, Byte.TYPE) == false) goto L887;
        Object r61 = com.larksuite.component.card.component.f.d(r53, r118);
        if ((r61 instanceof ContentProps) == true) goto L883;
        r61 = null;
    L883:
        ContentProps r62 = (ContentProps) r61;
        if (r62 == null) goto L997;
        r54.add(r62);
        goto L997
    L887:
        if (Intrinsics.areEqual(ContentProps.class, Short.TYPE) == false) goto L895;
        Object r63 = com.larksuite.component.card.component.f.l(r53, r118);
        if ((r63 instanceof ContentProps) == true) goto L891;
        r63 = null;
    L891:
        ContentProps r64 = (ContentProps) r63;
        if (r64 == null) goto L997;
        r54.add(r64);
        goto L997
    L895:
        if (Intrinsics.areEqual(ContentProps.class, Long.TYPE) == false) goto L903;
        Object r65 = com.larksuite.component.card.component.f.i(r53, r118);
        if ((r65 instanceof ContentProps) == true) goto L899;
        r65 = null;
    L899:
        ContentProps r66 = (ContentProps) r65;
        if (r66 == null) goto L997;
        r54.add(r66);
        goto L997
    L903:
        if (Intrinsics.areEqual(ContentProps.class, Character.TYPE) == false) goto L911;
        Object r67 = com.larksuite.component.card.component.f.e(r53, r118);
        if ((r67 instanceof ContentProps) == true) goto L907;
        r67 = null;
    L907:
        ContentProps r68 = (ContentProps) r67;
        if (r68 == null) goto L997;
        r54.add(r68);
        goto L997
    L911:
        if (Intrinsics.areEqual(ContentProps.class, Integer.TYPE) == false) goto L919;
        Object r69 = com.larksuite.component.card.component.f.g(r53, r118);
        if ((r69 instanceof ContentProps) == true) goto L915;
        r69 = null;
    L915:
        ContentProps r70 = (ContentProps) r69;
        if (r70 == null) goto L997;
        r54.add(r70);
        goto L997
    L919:
        if (Intrinsics.areEqual(ContentProps.class, String.class) == false) goto L926;
        Object r71 = com.larksuite.component.card.component.f.m(r53, r118);
        if ((r71 instanceof ContentProps) == true) goto L923;
        r71 = null;
    L923:
        ContentProps r72 = (ContentProps) r71;
        if (r72 == null) goto L997;
        r54.add(r72);
        goto L997
    L926:
        ReadableMap r73 = com.larksuite.component.card.component.f.j(r53, r118);
        if (r73 == null) goto L997;
        if (Intrinsics.areEqual(ContentProps.class, TextProps.class) == false) goto L932;
        ContentProps r74 = (ContentProps) u(r73);
    L994:
        r54.add(r74);
        goto L997
    L932:
        if (Intrinsics.areEqual(ContentProps.class, ContentProps.class) == false) goto L935;
        r74 = f(r73);
        goto L994
    L935:
        if (Intrinsics.areEqual(ContentProps.class, AtProps.class) == false) goto L938;
        r74 = (ContentProps) a(r73);
        goto L994
    L938:
        if (Intrinsics.areEqual(ContentProps.class, LinkProps.class) == false) goto L941;
        r74 = (ContentProps) k(r73);
        goto L994
    L941:
        if (Intrinsics.areEqual(ContentProps.class, UDIconContentProps.class) == false) goto L944;
        r74 = (ContentProps) v(r73);
        goto L994
    L944:
        if (Intrinsics.areEqual(ContentProps.class, EmojProps.class) == false) goto L947;
        r74 = (ContentProps) h(r73);
        goto L994
    L947:
        if (Intrinsics.areEqual(ContentProps.class, PlainTextProps.class) == false) goto L950;
        r74 = (ContentProps) s(r73);
        goto L994
    L950:
        if (Intrinsics.areEqual(ContentProps.class, TagProps.class) == false) goto L953;
        r74 = (ContentProps) t(r73);
        goto L994
    L953:
        if (Intrinsics.areEqual(ContentProps.class, ListItem.class) == false) goto L956;
        r74 = (ContentProps) l(r73);
        goto L994
    L956:
        if (Intrinsics.areEqual(ContentProps.class, CardCodeBlockProps.class) == false) goto L959;
        r74 = (ContentProps) c(r73);
        goto L994
    L959:
        if (Intrinsics.areEqual(ContentProps.class, CardCodeBlockProps.b.class) == false) goto L962;
        r74 = (ContentProps) g(r73);
        goto L994
    L962:
        if (Intrinsics.areEqual(ContentProps.class, CardCodeBlockProps.b.a.class) == false) goto L965;
        r74 = (ContentProps) e(r73);
        goto L994
    L965:
        if (Intrinsics.areEqual(ContentProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L968;
        r74 = (ContentProps) j(r73);
        goto L994
    L968:
        if (Intrinsics.areEqual(ContentProps.class, PersonProps.class) == false) goto L971;
        r74 = (ContentProps) r(r73);
        goto L994
    L971:
        if (Intrinsics.areEqual(ContentProps.class, Person.class) == false) goto L974;
        r74 = (ContentProps) q(r73);
        goto L994
    L974:
        if (Intrinsics.areEqual(ContentProps.class, ContainerPadding.class) == false) goto L977;
        r74 = (ContentProps) d(r73);
        goto L994
    L977:
        if (Intrinsics.areEqual(ContentProps.class, HeadingProps.class) == false) goto L980;
        r74 = (ContentProps) i(r73);
        goto L994
    L980:
        if (Intrinsics.areEqual(ContentProps.class, NumberTagProps.class) == false) goto L983;
        r74 = (ContentProps) p(r73);
        goto L994
    L983:
        if (Intrinsics.areEqual(ContentProps.class, AudioProps.class) == false) goto L986;
        r74 = (ContentProps) b(r73);
        goto L994
    L986:
        if (Intrinsics.areEqual(ContentProps.class, a.class) == false) goto L989;
        r74 = (ContentProps) n(r73);
        goto L994
    L989:
        if (Intrinsics.areEqual(ContentProps.class, MarkdownAudioState.class) == false) goto L992;
        r74 = (ContentProps) o(r73);
        goto L994
    L992:
        if (Intrinsics.areEqual(ContentProps.class, MarkdownAudioBgPadding.class) == false) goto L996;
        r74 = (ContentProps) m(r73);
        goto L994
    L996:
        throw new IllegalArgumentException("unsupported type: " + ContentProps.class);
    L998:
        CardCodeBlockProps r211 = r114;
        List<ContentProps> r75 = r54;
    L1000:
        ReadableMap r76 = com.larksuite.component.card.component.f.k(r25, "numberTagProps");
        if (r76 != null) goto L1003;
        NumberTagProps r77 = c.getNumberTagProps();
    L1071:
        ReadableMap r0 = com.larksuite.component.card.component.f.k(r25, "audioProps");
        if (r0 != null) goto L1074;
        AudioProps r1 = c.getAudioProps();
    L1147:
        return new ContentProps(r6, r7, r8, r11, r14, r17, r110, r113, r211, r115, r116, r117, r52, r75, r77, r1);
    L1074:
        if (Intrinsics.areEqual(AudioProps.class, TextProps.class) == false) goto L1077;
        r1 = (AudioProps) u(r0);
        goto L1147
    L1077:
        if (Intrinsics.areEqual(AudioProps.class, ContentProps.class) == false) goto L1084;
        r1 = (AudioProps) f(r0);
    L1080:
        th = move-exception;
        throw th;
    L1084:
        if (Intrinsics.areEqual(AudioProps.class, AtProps.class) == false) goto L1087;
        r1 = (AudioProps) a(r0);
        goto L1147
    L1087:
        if (Intrinsics.areEqual(AudioProps.class, LinkProps.class) == false) goto L1090;
        r1 = (AudioProps) k(r0);
        goto L1147
    L1090:
        if (Intrinsics.areEqual(AudioProps.class, UDIconContentProps.class) == false) goto L1093;
        r1 = (AudioProps) v(r0);
        goto L1147
    L1093:
        if (Intrinsics.areEqual(AudioProps.class, EmojProps.class) == false) goto L1096;
        r1 = (AudioProps) h(r0);
        goto L1147
    L1096:
        if (Intrinsics.areEqual(AudioProps.class, PlainTextProps.class) == false) goto L1099;
        r1 = (AudioProps) s(r0);
        goto L1147
    L1099:
        if (Intrinsics.areEqual(AudioProps.class, TagProps.class) == false) goto L1102;
        r1 = (AudioProps) t(r0);
        goto L1147
    L1102:
        if (Intrinsics.areEqual(AudioProps.class, ListItem.class) == false) goto L1105;
        r1 = (AudioProps) l(r0);
        goto L1147
    L1105:
        if (Intrinsics.areEqual(AudioProps.class, CardCodeBlockProps.class) == false) goto L1108;
        r1 = (AudioProps) c(r0);
        goto L1147
    L1108:
        if (Intrinsics.areEqual(AudioProps.class, CardCodeBlockProps.b.class) == false) goto L1111;
        r1 = (AudioProps) g(r0);
        goto L1147
    L1111:
        if (Intrinsics.areEqual(AudioProps.class, CardCodeBlockProps.b.a.class) == false) goto L1114;
        r1 = (AudioProps) e(r0);
        goto L1147
    L1114:
        if (Intrinsics.areEqual(AudioProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L1117;
        r1 = (AudioProps) j(r0);
        goto L1147
    L1117:
        if (Intrinsics.areEqual(AudioProps.class, PersonProps.class) == false) goto L1120;
        r1 = (AudioProps) r(r0);
        goto L1147
    L1120:
        if (Intrinsics.areEqual(AudioProps.class, Person.class) == false) goto L1123;
        r1 = (AudioProps) q(r0);
        goto L1147
    L1123:
        if (Intrinsics.areEqual(AudioProps.class, ContainerPadding.class) == false) goto L1126;
        r1 = (AudioProps) d(r0);
        goto L1147
    L1126:
        if (Intrinsics.areEqual(AudioProps.class, HeadingProps.class) == false) goto L1129;
        r1 = (AudioProps) i(r0);
        goto L1147
    L1129:
        if (Intrinsics.areEqual(AudioProps.class, NumberTagProps.class) == false) goto L1132;
        r1 = (AudioProps) p(r0);
        goto L1147
    L1132:
        if (Intrinsics.areEqual(AudioProps.class, AudioProps.class) == false) goto L1135;
        r1 = b(r0);
        goto L1147
    L1135:
        if (Intrinsics.areEqual(AudioProps.class, a.class) == false) goto L1138;
        r1 = (AudioProps) n(r0);
        goto L1147
    L1138:
        if (Intrinsics.areEqual(AudioProps.class, MarkdownAudioState.class) == false) goto L1141;
        r1 = (AudioProps) o(r0);
        goto L1147
    L1141:
        if (Intrinsics.areEqual(AudioProps.class, MarkdownAudioBgPadding.class) == false) goto L1144;
        r1 = (AudioProps) m(r0);
        goto L1147
    L1144:
        throw new IllegalArgumentException("unsupported type: " + AudioProps.class);
    L1003:
        if (Intrinsics.areEqual(NumberTagProps.class, TextProps.class) == false) goto L1006;
        r77 = (NumberTagProps) u(r76);
        goto L1071
    L1006:
        if (Intrinsics.areEqual(NumberTagProps.class, ContentProps.class) == false) goto L1009;
        r77 = (NumberTagProps) f(r76);
        goto L1071
    L1009:
        if (Intrinsics.areEqual(NumberTagProps.class, AtProps.class) == false) goto L1012;
        r77 = (NumberTagProps) a(r76);
        goto L1071
    L1012:
        if (Intrinsics.areEqual(NumberTagProps.class, LinkProps.class) == false) goto L1015;
        r77 = (NumberTagProps) k(r76);
        goto L1071
    L1015:
        if (Intrinsics.areEqual(NumberTagProps.class, UDIconContentProps.class) == false) goto L1018;
        r77 = (NumberTagProps) v(r76);
        goto L1071
    L1018:
        if (Intrinsics.areEqual(NumberTagProps.class, EmojProps.class) == false) goto L1021;
        r77 = (NumberTagProps) h(r76);
        goto L1071
    L1021:
        if (Intrinsics.areEqual(NumberTagProps.class, PlainTextProps.class) == false) goto L1024;
        r77 = (NumberTagProps) s(r76);
        goto L1071
    L1024:
        if (Intrinsics.areEqual(NumberTagProps.class, TagProps.class) == false) goto L1027;
        r77 = (NumberTagProps) t(r76);
        goto L1071
    L1027:
        if (Intrinsics.areEqual(NumberTagProps.class, ListItem.class) == false) goto L1030;
        r77 = (NumberTagProps) l(r76);
        goto L1071
    L1030:
        if (Intrinsics.areEqual(NumberTagProps.class, CardCodeBlockProps.class) == false) goto L1033;
        r77 = (NumberTagProps) c(r76);
        goto L1071
    L1033:
        if (Intrinsics.areEqual(NumberTagProps.class, CardCodeBlockProps.b.class) == false) goto L1036;
        r77 = (NumberTagProps) g(r76);
        goto L1071
    L1036:
        if (Intrinsics.areEqual(NumberTagProps.class, CardCodeBlockProps.b.a.class) == false) goto L1039;
        r77 = (NumberTagProps) e(r76);
        goto L1071
    L1039:
        if (Intrinsics.areEqual(NumberTagProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L1042;
        r77 = (NumberTagProps) j(r76);
        goto L1071
    L1042:
        if (Intrinsics.areEqual(NumberTagProps.class, PersonProps.class) == false) goto L1045;
        r77 = (NumberTagProps) r(r76);
        goto L1071
    L1045:
        if (Intrinsics.areEqual(NumberTagProps.class, Person.class) == false) goto L1048;
        r77 = (NumberTagProps) q(r76);
        goto L1071
    L1048:
        if (Intrinsics.areEqual(NumberTagProps.class, ContainerPadding.class) == false) goto L1051;
        r77 = (NumberTagProps) d(r76);
        goto L1071
    L1051:
        if (Intrinsics.areEqual(NumberTagProps.class, HeadingProps.class) == false) goto L1054;
        r77 = (NumberTagProps) i(r76);
        goto L1071
    L1054:
        if (Intrinsics.areEqual(NumberTagProps.class, NumberTagProps.class) == false) goto L1057;
        r77 = p(r76);
        goto L1071
    L1057:
        if (Intrinsics.areEqual(NumberTagProps.class, AudioProps.class) == false) goto L1060;
        r77 = (NumberTagProps) b(r76);
        goto L1071
    L1060:
        if (Intrinsics.areEqual(NumberTagProps.class, a.class) == false) goto L1063;
        r77 = (NumberTagProps) n(r76);
        goto L1071
    L1063:
        if (Intrinsics.areEqual(NumberTagProps.class, MarkdownAudioState.class) == false) goto L1066;
        r77 = (NumberTagProps) o(r76);
        goto L1071
    L1066:
        if (Intrinsics.areEqual(NumberTagProps.class, MarkdownAudioBgPadding.class) == false) goto L1069;
        r77 = (NumberTagProps) m(r76);
        goto L1071
    L1069:
        throw new IllegalArgumentException("unsupported type: " + NumberTagProps.class);
    L999:
        r211 = r114;
        r75 = c.getBlockQuoteProps();
        goto L1000
    L792:
        if (Intrinsics.areEqual(PlainTextProps.class, ContentProps.class) == false) goto L795;
        r52 = (PlainTextProps) f(r51);
        goto L857
    L795:
        if (Intrinsics.areEqual(PlainTextProps.class, AtProps.class) == false) goto L798;
        r52 = a(r51);
        goto L857
    L798:
        if (Intrinsics.areEqual(PlainTextProps.class, LinkProps.class) == false) goto L801;
        r52 = k(r51);
        goto L857
    L801:
        if (Intrinsics.areEqual(PlainTextProps.class, UDIconContentProps.class) == false) goto L804;
        r52 = (PlainTextProps) v(r51);
        goto L857
    L804:
        if (Intrinsics.areEqual(PlainTextProps.class, EmojProps.class) == false) goto L807;
        r52 = (PlainTextProps) h(r51);
        goto L857
    L807:
        if (Intrinsics.areEqual(PlainTextProps.class, PlainTextProps.class) == false) goto L810;
        r52 = s(r51);
        goto L857
    L810:
        if (Intrinsics.areEqual(PlainTextProps.class, TagProps.class) == false) goto L813;
        r52 = (PlainTextProps) t(r51);
        goto L857
    L813:
        if (Intrinsics.areEqual(PlainTextProps.class, ListItem.class) == false) goto L816;
        r52 = (PlainTextProps) l(r51);
        goto L857
    L816:
        if (Intrinsics.areEqual(PlainTextProps.class, CardCodeBlockProps.class) == false) goto L819;
        r52 = (PlainTextProps) c(r51);
        goto L857
    L819:
        if (Intrinsics.areEqual(PlainTextProps.class, CardCodeBlockProps.b.class) == false) goto L822;
        r52 = (PlainTextProps) g(r51);
        goto L857
    L822:
        if (Intrinsics.areEqual(PlainTextProps.class, CardCodeBlockProps.b.a.class) == false) goto L825;
        r52 = (PlainTextProps) e(r51);
        goto L857
    L825:
        if (Intrinsics.areEqual(PlainTextProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L828;
        r52 = (PlainTextProps) j(r51);
        goto L857
    L828:
        if (Intrinsics.areEqual(PlainTextProps.class, PersonProps.class) == false) goto L831;
        r52 = r(r51);
        goto L857
    L831:
        if (Intrinsics.areEqual(PlainTextProps.class, Person.class) == false) goto L834;
        r52 = (PlainTextProps) q(r51);
        goto L857
    L834:
        if (Intrinsics.areEqual(PlainTextProps.class, ContainerPadding.class) == false) goto L837;
        r52 = (PlainTextProps) d(r51);
        goto L857
    L837:
        if (Intrinsics.areEqual(PlainTextProps.class, HeadingProps.class) == false) goto L840;
        r52 = (PlainTextProps) i(r51);
        goto L857
    L840:
        if (Intrinsics.areEqual(PlainTextProps.class, NumberTagProps.class) == false) goto L843;
        r52 = p(r51);
        goto L857
    L843:
        if (Intrinsics.areEqual(PlainTextProps.class, AudioProps.class) == false) goto L846;
        r52 = b(r51);
        goto L857
    L846:
        if (Intrinsics.areEqual(PlainTextProps.class, a.class) == false) goto L849;
        r52 = (PlainTextProps) n(r51);
        goto L857
    L849:
        if (Intrinsics.areEqual(PlainTextProps.class, MarkdownAudioState.class) == false) goto L852;
        r52 = (PlainTextProps) o(r51);
        goto L857
    L852:
        if (Intrinsics.areEqual(PlainTextProps.class, MarkdownAudioBgPadding.class) == false) goto L855;
        r52 = (PlainTextProps) m(r51);
        goto L857
    L855:
        throw new IllegalArgumentException("unsupported type: " + PlainTextProps.class);
    L856:
        r117 = r50;
        r52 = c.getCodeSpanProps();
        goto L857
    L721:
        if (Intrinsics.areEqual(HeadingProps.class, ContentProps.class) == false) goto L724;
        r50 = (HeadingProps) f(r49);
        goto L786
    L724:
        if (Intrinsics.areEqual(HeadingProps.class, AtProps.class) == false) goto L727;
        r50 = (HeadingProps) a(r49);
        goto L786
    L727:
        if (Intrinsics.areEqual(HeadingProps.class, LinkProps.class) == false) goto L730;
        r50 = (HeadingProps) k(r49);
        goto L786
    L730:
        if (Intrinsics.areEqual(HeadingProps.class, UDIconContentProps.class) == false) goto L733;
        r50 = (HeadingProps) v(r49);
        goto L786
    L733:
        if (Intrinsics.areEqual(HeadingProps.class, EmojProps.class) == false) goto L736;
        r50 = (HeadingProps) h(r49);
        goto L786
    L736:
        if (Intrinsics.areEqual(HeadingProps.class, PlainTextProps.class) == false) goto L739;
        r50 = (HeadingProps) s(r49);
        goto L786
    L739:
        if (Intrinsics.areEqual(HeadingProps.class, TagProps.class) == false) goto L742;
        r50 = (HeadingProps) t(r49);
        goto L786
    L742:
        if (Intrinsics.areEqual(HeadingProps.class, ListItem.class) == false) goto L745;
        r50 = (HeadingProps) l(r49);
        goto L786
    L745:
        if (Intrinsics.areEqual(HeadingProps.class, CardCodeBlockProps.class) == false) goto L748;
        r50 = (HeadingProps) c(r49);
        goto L786
    L748:
        if (Intrinsics.areEqual(HeadingProps.class, CardCodeBlockProps.b.class) == false) goto L751;
        r50 = (HeadingProps) g(r49);
        goto L786
    L751:
        if (Intrinsics.areEqual(HeadingProps.class, CardCodeBlockProps.b.a.class) == false) goto L754;
        r50 = (HeadingProps) e(r49);
        goto L786
    L754:
        if (Intrinsics.areEqual(HeadingProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L757;
        r50 = (HeadingProps) j(r49);
        goto L786
    L757:
        if (Intrinsics.areEqual(HeadingProps.class, PersonProps.class) == false) goto L760;
        r50 = (HeadingProps) r(r49);
        goto L786
    L760:
        if (Intrinsics.areEqual(HeadingProps.class, Person.class) == false) goto L763;
        r50 = (HeadingProps) q(r49);
        goto L786
    L763:
        if (Intrinsics.areEqual(HeadingProps.class, ContainerPadding.class) == false) goto L766;
        r50 = (HeadingProps) d(r49);
        goto L786
    L766:
        if (Intrinsics.areEqual(HeadingProps.class, HeadingProps.class) == false) goto L769;
        r50 = i(r49);
        goto L786
    L769:
        if (Intrinsics.areEqual(HeadingProps.class, NumberTagProps.class) == false) goto L772;
        r50 = (HeadingProps) p(r49);
        goto L786
    L772:
        if (Intrinsics.areEqual(HeadingProps.class, AudioProps.class) == false) goto L775;
        r50 = (HeadingProps) b(r49);
        goto L786
    L775:
        if (Intrinsics.areEqual(HeadingProps.class, a.class) == false) goto L778;
        r50 = (HeadingProps) n(r49);
        goto L786
    L778:
        if (Intrinsics.areEqual(HeadingProps.class, MarkdownAudioState.class) == false) goto L781;
        r50 = (HeadingProps) o(r49);
        goto L786
    L781:
        if (Intrinsics.areEqual(HeadingProps.class, MarkdownAudioBgPadding.class) == false) goto L784;
        r50 = (HeadingProps) m(r49);
        goto L786
    L784:
        throw new IllegalArgumentException("unsupported type: " + HeadingProps.class);
    L785:
        r116 = r48;
        r50 = c.getHeadingProps();
        goto L786
    L647:
        if (Intrinsics.areEqual(PersonProps.class, TextProps.class) == false) goto L650;
        r48 = (PersonProps) u(r47);
        goto L715
    L650:
        if (Intrinsics.areEqual(PersonProps.class, ContentProps.class) == false) goto L653;
        r48 = (PersonProps) f(r47);
        goto L715
    L653:
        if (Intrinsics.areEqual(PersonProps.class, AtProps.class) == false) goto L656;
        r48 = (PersonProps) a(r47);
        goto L715
    L656:
        if (Intrinsics.areEqual(PersonProps.class, LinkProps.class) == false) goto L659;
        r48 = (PersonProps) k(r47);
        goto L715
    L659:
        if (Intrinsics.areEqual(PersonProps.class, UDIconContentProps.class) == false) goto L662;
        r48 = (PersonProps) v(r47);
        goto L715
    L662:
        if (Intrinsics.areEqual(PersonProps.class, EmojProps.class) == false) goto L665;
        r48 = (PersonProps) h(r47);
        goto L715
    L665:
        if (Intrinsics.areEqual(PersonProps.class, PlainTextProps.class) == false) goto L668;
        r48 = (PersonProps) s(r47);
        goto L715
    L668:
        if (Intrinsics.areEqual(PersonProps.class, TagProps.class) == false) goto L671;
        r48 = (PersonProps) t(r47);
        goto L715
    L671:
        if (Intrinsics.areEqual(PersonProps.class, ListItem.class) == false) goto L674;
        r48 = (PersonProps) l(r47);
        goto L715
    L674:
        if (Intrinsics.areEqual(PersonProps.class, CardCodeBlockProps.class) == false) goto L677;
        r48 = (PersonProps) c(r47);
        goto L715
    L677:
        if (Intrinsics.areEqual(PersonProps.class, CardCodeBlockProps.b.class) == false) goto L680;
        r48 = (PersonProps) g(r47);
        goto L715
    L680:
        if (Intrinsics.areEqual(PersonProps.class, CardCodeBlockProps.b.a.class) == false) goto L683;
        r48 = (PersonProps) e(r47);
        goto L715
    L683:
        if (Intrinsics.areEqual(PersonProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L686;
        r48 = (PersonProps) j(r47);
        goto L715
    L686:
        if (Intrinsics.areEqual(PersonProps.class, PersonProps.class) == false) goto L689;
        r48 = r(r47);
        goto L715
    L689:
        if (Intrinsics.areEqual(PersonProps.class, Person.class) == false) goto L692;
        r48 = (PersonProps) q(r47);
        goto L715
    L692:
        if (Intrinsics.areEqual(PersonProps.class, ContainerPadding.class) == false) goto L695;
        r48 = (PersonProps) d(r47);
        goto L715
    L695:
        if (Intrinsics.areEqual(PersonProps.class, HeadingProps.class) == false) goto L698;
        r48 = (PersonProps) i(r47);
        goto L715
    L698:
        if (Intrinsics.areEqual(PersonProps.class, NumberTagProps.class) == false) goto L701;
        r48 = (PersonProps) p(r47);
        goto L715
    L701:
        if (Intrinsics.areEqual(PersonProps.class, AudioProps.class) == false) goto L704;
        r48 = (PersonProps) b(r47);
        goto L715
    L704:
        if (Intrinsics.areEqual(PersonProps.class, a.class) == false) goto L707;
        r48 = (PersonProps) n(r47);
        goto L715
    L707:
        if (Intrinsics.areEqual(PersonProps.class, MarkdownAudioState.class) == false) goto L710;
        r48 = (PersonProps) o(r47);
        goto L715
    L710:
        if (Intrinsics.areEqual(PersonProps.class, MarkdownAudioBgPadding.class) == false) goto L713;
        r48 = (PersonProps) m(r47);
        goto L715
    L713:
        throw new IllegalArgumentException("unsupported type: " + PersonProps.class);
    L576:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, TextProps.class) == false) goto L579;
        r46 = (com.larksuite.component.card.component.image.a) u(r45);
        goto L644
    L579:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, ContentProps.class) == false) goto L582;
        r46 = (com.larksuite.component.card.component.image.a) f(r45);
        goto L644
    L582:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, AtProps.class) == false) goto L585;
        r46 = (com.larksuite.component.card.component.image.a) a(r45);
        goto L644
    L585:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, LinkProps.class) == false) goto L588;
        r46 = (com.larksuite.component.card.component.image.a) k(r45);
        goto L644
    L588:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, UDIconContentProps.class) == false) goto L591;
        r46 = (com.larksuite.component.card.component.image.a) v(r45);
        goto L644
    L591:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, EmojProps.class) == false) goto L594;
        r46 = (com.larksuite.component.card.component.image.a) h(r45);
        goto L644
    L594:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, PlainTextProps.class) == false) goto L597;
        r46 = (com.larksuite.component.card.component.image.a) s(r45);
        goto L644
    L597:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, TagProps.class) == false) goto L600;
        r46 = (com.larksuite.component.card.component.image.a) t(r45);
        goto L644
    L600:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, ListItem.class) == false) goto L603;
        r46 = (com.larksuite.component.card.component.image.a) l(r45);
        goto L644
    L603:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, CardCodeBlockProps.class) == false) goto L606;
        r46 = (com.larksuite.component.card.component.image.a) c(r45);
        goto L644
    L606:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, CardCodeBlockProps.b.class) == false) goto L609;
        r46 = (com.larksuite.component.card.component.image.a) g(r45);
        goto L644
    L609:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, CardCodeBlockProps.b.a.class) == false) goto L612;
        r46 = (com.larksuite.component.card.component.image.a) e(r45);
        goto L644
    L612:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, com.larksuite.component.card.component.image.a.class) == false) goto L615;
        r46 = j(r45);
        goto L644
    L615:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, PersonProps.class) == false) goto L618;
        r46 = (com.larksuite.component.card.component.image.a) r(r45);
        goto L644
    L618:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, Person.class) == false) goto L621;
        r46 = (com.larksuite.component.card.component.image.a) q(r45);
        goto L644
    L621:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, ContainerPadding.class) == false) goto L624;
        r46 = (com.larksuite.component.card.component.image.a) d(r45);
        goto L644
    L624:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, HeadingProps.class) == false) goto L627;
        r46 = (com.larksuite.component.card.component.image.a) i(r45);
        goto L644
    L627:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, NumberTagProps.class) == false) goto L630;
        r46 = (com.larksuite.component.card.component.image.a) p(r45);
        goto L644
    L630:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, AudioProps.class) == false) goto L633;
        r46 = (com.larksuite.component.card.component.image.a) b(r45);
        goto L644
    L633:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, a.class) == false) goto L636;
        r46 = (com.larksuite.component.card.component.image.a) n(r45);
        goto L644
    L636:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, MarkdownAudioState.class) == false) goto L639;
        r46 = (com.larksuite.component.card.component.image.a) o(r45);
        goto L644
    L639:
        if (Intrinsics.areEqual(com.larksuite.component.card.component.image.a.class, MarkdownAudioBgPadding.class) == false) goto L642;
        r46 = (com.larksuite.component.card.component.image.a) m(r45);
        goto L644
    L642:
        throw new IllegalArgumentException("unsupported type: " + com.larksuite.component.card.component.image.a.class);
    L505:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, TextProps.class) == false) goto L508;
        r44 = (CardCodeBlockProps) u(r43);
        goto L573
    L508:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, ContentProps.class) == false) goto L511;
        r44 = (CardCodeBlockProps) f(r43);
        goto L573
    L511:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, AtProps.class) == false) goto L514;
        r44 = (CardCodeBlockProps) a(r43);
        goto L573
    L514:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, LinkProps.class) == false) goto L517;
        r44 = (CardCodeBlockProps) k(r43);
        goto L573
    L517:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, UDIconContentProps.class) == false) goto L520;
        r44 = (CardCodeBlockProps) v(r43);
        goto L573
    L520:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, EmojProps.class) == false) goto L523;
        r44 = (CardCodeBlockProps) h(r43);
        goto L573
    L523:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, PlainTextProps.class) == false) goto L526;
        r44 = (CardCodeBlockProps) s(r43);
        goto L573
    L526:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, TagProps.class) == false) goto L529;
        r44 = (CardCodeBlockProps) t(r43);
        goto L573
    L529:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, ListItem.class) == false) goto L532;
        r44 = (CardCodeBlockProps) l(r43);
        goto L573
    L532:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, CardCodeBlockProps.class) == false) goto L535;
        r44 = c(r43);
        goto L573
    L535:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, CardCodeBlockProps.b.class) == false) goto L538;
        r44 = (CardCodeBlockProps) g(r43);
        goto L573
    L538:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, CardCodeBlockProps.b.a.class) == false) goto L541;
        r44 = (CardCodeBlockProps) e(r43);
        goto L573
    L541:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L544;
        r44 = (CardCodeBlockProps) j(r43);
        goto L573
    L544:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, PersonProps.class) == false) goto L547;
        r44 = (CardCodeBlockProps) r(r43);
        goto L573
    L547:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, Person.class) == false) goto L550;
        r44 = (CardCodeBlockProps) q(r43);
        goto L573
    L550:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, ContainerPadding.class) == false) goto L553;
        r44 = (CardCodeBlockProps) d(r43);
        goto L573
    L553:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, HeadingProps.class) == false) goto L556;
        r44 = (CardCodeBlockProps) i(r43);
        goto L573
    L556:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, NumberTagProps.class) == false) goto L559;
        r44 = (CardCodeBlockProps) p(r43);
        goto L573
    L559:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, AudioProps.class) == false) goto L562;
        r44 = (CardCodeBlockProps) b(r43);
        goto L573
    L562:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, a.class) == false) goto L565;
        r44 = (CardCodeBlockProps) n(r43);
        goto L573
    L565:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, MarkdownAudioState.class) == false) goto L568;
        r44 = (CardCodeBlockProps) o(r43);
        goto L573
    L568:
        if (Intrinsics.areEqual(CardCodeBlockProps.class, MarkdownAudioBgPadding.class) == false) goto L571;
        r44 = (CardCodeBlockProps) m(r43);
        goto L573
    L571:
        throw new IllegalArgumentException("unsupported type: " + CardCodeBlockProps.class);
    L501:
        r22 = r2.getListProps();
        goto L502
    L292:
        if (Intrinsics.areEqual(TagProps.class, TextProps.class) == false) goto L295;
        r20 = (TagProps) u(r19);
        goto L360
    L295:
        if (Intrinsics.areEqual(TagProps.class, ContentProps.class) == false) goto L298;
        r20 = (TagProps) f(r19);
        goto L360
    L298:
        if (Intrinsics.areEqual(TagProps.class, AtProps.class) == false) goto L301;
        r20 = (TagProps) a(r19);
        goto L360
    L301:
        if (Intrinsics.areEqual(TagProps.class, LinkProps.class) == false) goto L304;
        r20 = (TagProps) k(r19);
        goto L360
    L304:
        if (Intrinsics.areEqual(TagProps.class, UDIconContentProps.class) == false) goto L307;
        r20 = (TagProps) v(r19);
        goto L360
    L307:
        if (Intrinsics.areEqual(TagProps.class, EmojProps.class) == false) goto L310;
        r20 = (TagProps) h(r19);
        goto L360
    L310:
        if (Intrinsics.areEqual(TagProps.class, PlainTextProps.class) == false) goto L313;
        r20 = (TagProps) s(r19);
        goto L360
    L313:
        if (Intrinsics.areEqual(TagProps.class, TagProps.class) == false) goto L316;
        r20 = t(r19);
        goto L360
    L316:
        if (Intrinsics.areEqual(TagProps.class, ListItem.class) == false) goto L319;
        r20 = (TagProps) l(r19);
        goto L360
    L319:
        if (Intrinsics.areEqual(TagProps.class, CardCodeBlockProps.class) == false) goto L322;
        r20 = (TagProps) c(r19);
        goto L360
    L322:
        if (Intrinsics.areEqual(TagProps.class, CardCodeBlockProps.b.class) == false) goto L325;
        r20 = (TagProps) g(r19);
        goto L360
    L325:
        if (Intrinsics.areEqual(TagProps.class, CardCodeBlockProps.b.a.class) == false) goto L328;
        r20 = (TagProps) e(r19);
        goto L360
    L328:
        if (Intrinsics.areEqual(TagProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L331;
        r20 = (TagProps) j(r19);
        goto L360
    L331:
        if (Intrinsics.areEqual(TagProps.class, PersonProps.class) == false) goto L334;
        r20 = (TagProps) r(r19);
        goto L360
    L334:
        if (Intrinsics.areEqual(TagProps.class, Person.class) == false) goto L337;
        r20 = (TagProps) q(r19);
        goto L360
    L337:
        if (Intrinsics.areEqual(TagProps.class, ContainerPadding.class) == false) goto L340;
        r20 = (TagProps) d(r19);
        goto L360
    L340:
        if (Intrinsics.areEqual(TagProps.class, HeadingProps.class) == false) goto L343;
        r20 = (TagProps) i(r19);
        goto L360
    L343:
        if (Intrinsics.areEqual(TagProps.class, NumberTagProps.class) == false) goto L346;
        r20 = (TagProps) p(r19);
        goto L360
    L346:
        if (Intrinsics.areEqual(TagProps.class, AudioProps.class) == false) goto L349;
        r20 = (TagProps) b(r19);
        goto L360
    L349:
        if (Intrinsics.areEqual(TagProps.class, a.class) == false) goto L352;
        r20 = (TagProps) n(r19);
        goto L360
    L352:
        if (Intrinsics.areEqual(TagProps.class, MarkdownAudioState.class) == false) goto L355;
        r20 = (TagProps) o(r19);
        goto L360
    L355:
        if (Intrinsics.areEqual(TagProps.class, MarkdownAudioBgPadding.class) == false) goto L358;
        r20 = (TagProps) m(r19);
        goto L360
    L358:
        throw new IllegalArgumentException("unsupported type: " + TagProps.class);
    L221:
        if (Intrinsics.areEqual(PlainTextProps.class, TextProps.class) == false) goto L224;
        r16 = (PlainTextProps) u(r15);
        goto L289
    L224:
        if (Intrinsics.areEqual(PlainTextProps.class, ContentProps.class) == false) goto L227;
        r16 = (PlainTextProps) f(r15);
        goto L289
    L227:
        if (Intrinsics.areEqual(PlainTextProps.class, AtProps.class) == false) goto L230;
        r16 = a(r15);
        goto L289
    L230:
        if (Intrinsics.areEqual(PlainTextProps.class, LinkProps.class) == false) goto L233;
        r16 = k(r15);
        goto L289
    L233:
        if (Intrinsics.areEqual(PlainTextProps.class, UDIconContentProps.class) == false) goto L236;
        r16 = (PlainTextProps) v(r15);
        goto L289
    L236:
        if (Intrinsics.areEqual(PlainTextProps.class, EmojProps.class) == false) goto L239;
        r16 = (PlainTextProps) h(r15);
        goto L289
    L239:
        if (Intrinsics.areEqual(PlainTextProps.class, PlainTextProps.class) == false) goto L242;
        r16 = s(r15);
        goto L289
    L242:
        if (Intrinsics.areEqual(PlainTextProps.class, TagProps.class) == false) goto L245;
        r16 = (PlainTextProps) t(r15);
        goto L289
    L245:
        if (Intrinsics.areEqual(PlainTextProps.class, ListItem.class) == false) goto L248;
        r16 = (PlainTextProps) l(r15);
        goto L289
    L248:
        if (Intrinsics.areEqual(PlainTextProps.class, CardCodeBlockProps.class) == false) goto L251;
        r16 = (PlainTextProps) c(r15);
        goto L289
    L251:
        if (Intrinsics.areEqual(PlainTextProps.class, CardCodeBlockProps.b.class) == false) goto L254;
        r16 = (PlainTextProps) g(r15);
        goto L289
    L254:
        if (Intrinsics.areEqual(PlainTextProps.class, CardCodeBlockProps.b.a.class) == false) goto L257;
        r16 = (PlainTextProps) e(r15);
        goto L289
    L257:
        if (Intrinsics.areEqual(PlainTextProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L260;
        r16 = (PlainTextProps) j(r15);
        goto L289
    L260:
        if (Intrinsics.areEqual(PlainTextProps.class, PersonProps.class) == false) goto L263;
        r16 = r(r15);
        goto L289
    L263:
        if (Intrinsics.areEqual(PlainTextProps.class, Person.class) == false) goto L266;
        r16 = (PlainTextProps) q(r15);
        goto L289
    L266:
        if (Intrinsics.areEqual(PlainTextProps.class, ContainerPadding.class) == false) goto L269;
        r16 = (PlainTextProps) d(r15);
        goto L289
    L269:
        if (Intrinsics.areEqual(PlainTextProps.class, HeadingProps.class) == false) goto L272;
        r16 = (PlainTextProps) i(r15);
        goto L289
    L272:
        if (Intrinsics.areEqual(PlainTextProps.class, NumberTagProps.class) == false) goto L275;
        r16 = p(r15);
        goto L289
    L275:
        if (Intrinsics.areEqual(PlainTextProps.class, AudioProps.class) == false) goto L278;
        r16 = b(r15);
        goto L289
    L278:
        if (Intrinsics.areEqual(PlainTextProps.class, a.class) == false) goto L281;
        r16 = (PlainTextProps) n(r15);
        goto L289
    L281:
        if (Intrinsics.areEqual(PlainTextProps.class, MarkdownAudioState.class) == false) goto L284;
        r16 = (PlainTextProps) o(r15);
        goto L289
    L284:
        if (Intrinsics.areEqual(PlainTextProps.class, MarkdownAudioBgPadding.class) == false) goto L287;
        r16 = (PlainTextProps) m(r15);
        goto L289
    L287:
        throw new IllegalArgumentException("unsupported type: " + PlainTextProps.class);
    L150:
        if (Intrinsics.areEqual(EmojProps.class, TextProps.class) == false) goto L153;
        r13 = (EmojProps) u(r12);
        goto L218
    L153:
        if (Intrinsics.areEqual(EmojProps.class, ContentProps.class) == false) goto L156;
        r13 = (EmojProps) f(r12);
        goto L218
    L156:
        if (Intrinsics.areEqual(EmojProps.class, AtProps.class) == false) goto L159;
        r13 = (EmojProps) a(r12);
        goto L218
    L159:
        if (Intrinsics.areEqual(EmojProps.class, LinkProps.class) == false) goto L162;
        r13 = (EmojProps) k(r12);
        goto L218
    L162:
        if (Intrinsics.areEqual(EmojProps.class, UDIconContentProps.class) == false) goto L165;
        r13 = (EmojProps) v(r12);
        goto L218
    L165:
        if (Intrinsics.areEqual(EmojProps.class, EmojProps.class) == false) goto L168;
        r13 = h(r12);
        goto L218
    L168:
        if (Intrinsics.areEqual(EmojProps.class, PlainTextProps.class) == false) goto L171;
        r13 = (EmojProps) s(r12);
        goto L218
    L171:
        if (Intrinsics.areEqual(EmojProps.class, TagProps.class) == false) goto L174;
        r13 = (EmojProps) t(r12);
        goto L218
    L174:
        if (Intrinsics.areEqual(EmojProps.class, ListItem.class) == false) goto L177;
        r13 = (EmojProps) l(r12);
        goto L218
    L177:
        if (Intrinsics.areEqual(EmojProps.class, CardCodeBlockProps.class) == false) goto L180;
        r13 = (EmojProps) c(r12);
        goto L218
    L180:
        if (Intrinsics.areEqual(EmojProps.class, CardCodeBlockProps.b.class) == false) goto L183;
        r13 = (EmojProps) g(r12);
        goto L218
    L183:
        if (Intrinsics.areEqual(EmojProps.class, CardCodeBlockProps.b.a.class) == false) goto L186;
        r13 = (EmojProps) e(r12);
        goto L218
    L186:
        if (Intrinsics.areEqual(EmojProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L189;
        r13 = (EmojProps) j(r12);
        goto L218
    L189:
        if (Intrinsics.areEqual(EmojProps.class, PersonProps.class) == false) goto L192;
        r13 = (EmojProps) r(r12);
        goto L218
    L192:
        if (Intrinsics.areEqual(EmojProps.class, Person.class) == false) goto L195;
        r13 = (EmojProps) q(r12);
        goto L218
    L195:
        if (Intrinsics.areEqual(EmojProps.class, ContainerPadding.class) == false) goto L198;
        r13 = (EmojProps) d(r12);
        goto L218
    L198:
        if (Intrinsics.areEqual(EmojProps.class, HeadingProps.class) == false) goto L201;
        r13 = (EmojProps) i(r12);
        goto L218
    L201:
        if (Intrinsics.areEqual(EmojProps.class, NumberTagProps.class) == false) goto L204;
        r13 = (EmojProps) p(r12);
        goto L218
    L204:
        if (Intrinsics.areEqual(EmojProps.class, AudioProps.class) == false) goto L207;
        r13 = (EmojProps) b(r12);
        goto L218
    L207:
        if (Intrinsics.areEqual(EmojProps.class, a.class) == false) goto L210;
        r13 = (EmojProps) n(r12);
        goto L218
    L210:
        if (Intrinsics.areEqual(EmojProps.class, MarkdownAudioState.class) == false) goto L213;
        r13 = (EmojProps) o(r12);
        goto L218
    L213:
        if (Intrinsics.areEqual(EmojProps.class, MarkdownAudioBgPadding.class) == false) goto L216;
        r13 = (EmojProps) m(r12);
        goto L218
    L216:
        throw new IllegalArgumentException("unsupported type: " + EmojProps.class);
    L79:
        if (Intrinsics.areEqual(LinkProps.class, TextProps.class) == false) goto L82;
        r10 = (LinkProps) u(r9);
        goto L147
    L82:
        if (Intrinsics.areEqual(LinkProps.class, ContentProps.class) == false) goto L85;
        r10 = (LinkProps) f(r9);
        goto L147
    L85:
        if (Intrinsics.areEqual(LinkProps.class, AtProps.class) == false) goto L88;
        r10 = (LinkProps) a(r9);
        goto L147
    L88:
        if (Intrinsics.areEqual(LinkProps.class, LinkProps.class) == false) goto L91;
        r10 = k(r9);
        goto L147
    L91:
        if (Intrinsics.areEqual(LinkProps.class, UDIconContentProps.class) == false) goto L94;
        r10 = (LinkProps) v(r9);
        goto L147
    L94:
        if (Intrinsics.areEqual(LinkProps.class, EmojProps.class) == false) goto L97;
        r10 = (LinkProps) h(r9);
        goto L147
    L97:
        if (Intrinsics.areEqual(LinkProps.class, PlainTextProps.class) == false) goto L100;
        r10 = (LinkProps) s(r9);
        goto L147
    L100:
        if (Intrinsics.areEqual(LinkProps.class, TagProps.class) == false) goto L103;
        r10 = (LinkProps) t(r9);
        goto L147
    L103:
        if (Intrinsics.areEqual(LinkProps.class, ListItem.class) == false) goto L106;
        r10 = (LinkProps) l(r9);
        goto L147
    L106:
        if (Intrinsics.areEqual(LinkProps.class, CardCodeBlockProps.class) == false) goto L109;
        r10 = (LinkProps) c(r9);
        goto L147
    L109:
        if (Intrinsics.areEqual(LinkProps.class, CardCodeBlockProps.b.class) == false) goto L112;
        r10 = (LinkProps) g(r9);
        goto L147
    L112:
        if (Intrinsics.areEqual(LinkProps.class, CardCodeBlockProps.b.a.class) == false) goto L115;
        r10 = (LinkProps) e(r9);
        goto L147
    L115:
        if (Intrinsics.areEqual(LinkProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L118;
        r10 = (LinkProps) j(r9);
        goto L147
    L118:
        if (Intrinsics.areEqual(LinkProps.class, PersonProps.class) == false) goto L121;
        r10 = (LinkProps) r(r9);
        goto L147
    L121:
        if (Intrinsics.areEqual(LinkProps.class, Person.class) == false) goto L124;
        r10 = (LinkProps) q(r9);
        goto L147
    L124:
        if (Intrinsics.areEqual(LinkProps.class, ContainerPadding.class) == false) goto L127;
        r10 = (LinkProps) d(r9);
        goto L147
    L127:
        if (Intrinsics.areEqual(LinkProps.class, HeadingProps.class) == false) goto L130;
        r10 = (LinkProps) i(r9);
        goto L147
    L130:
        if (Intrinsics.areEqual(LinkProps.class, NumberTagProps.class) == false) goto L133;
        r10 = (LinkProps) p(r9);
        goto L147
    L133:
        if (Intrinsics.areEqual(LinkProps.class, AudioProps.class) == false) goto L136;
        r10 = (LinkProps) b(r9);
        goto L147
    L136:
        if (Intrinsics.areEqual(LinkProps.class, a.class) == false) goto L139;
        r10 = (LinkProps) n(r9);
        goto L147
    L139:
        if (Intrinsics.areEqual(LinkProps.class, MarkdownAudioState.class) == false) goto L142;
        r10 = (LinkProps) o(r9);
        goto L147
    L142:
        if (Intrinsics.areEqual(LinkProps.class, MarkdownAudioBgPadding.class) == false) goto L145;
        r10 = (LinkProps) m(r9);
        goto L147
    L145:
        throw new IllegalArgumentException("unsupported type: " + LinkProps.class);
    L8:
        if (Intrinsics.areEqual(AtProps.class, TextProps.class) == false) goto L11;
        r5 = (AtProps) u(r4);
        goto L76
    L11:
        if (Intrinsics.areEqual(AtProps.class, ContentProps.class) == false) goto L14;
        r5 = (AtProps) f(r4);
        goto L76
    L14:
        if (Intrinsics.areEqual(AtProps.class, AtProps.class) == false) goto L17;
        r5 = a(r4);
        goto L76
    L17:
        if (Intrinsics.areEqual(AtProps.class, LinkProps.class) == false) goto L20;
        r5 = (AtProps) k(r4);
        goto L76
    L20:
        if (Intrinsics.areEqual(AtProps.class, UDIconContentProps.class) == false) goto L23;
        r5 = (AtProps) v(r4);
        goto L76
    L23:
        if (Intrinsics.areEqual(AtProps.class, EmojProps.class) == false) goto L26;
        r5 = (AtProps) h(r4);
        goto L76
    L26:
        if (Intrinsics.areEqual(AtProps.class, PlainTextProps.class) == false) goto L29;
        r5 = (AtProps) s(r4);
        goto L76
    L29:
        if (Intrinsics.areEqual(AtProps.class, TagProps.class) == false) goto L32;
        r5 = (AtProps) t(r4);
        goto L76
    L32:
        if (Intrinsics.areEqual(AtProps.class, ListItem.class) == false) goto L35;
        r5 = (AtProps) l(r4);
        goto L76
    L35:
        if (Intrinsics.areEqual(AtProps.class, CardCodeBlockProps.class) == false) goto L38;
        r5 = (AtProps) c(r4);
        goto L76
    L38:
        if (Intrinsics.areEqual(AtProps.class, CardCodeBlockProps.b.class) == false) goto L41;
        r5 = (AtProps) g(r4);
        goto L76
    L41:
        if (Intrinsics.areEqual(AtProps.class, CardCodeBlockProps.b.a.class) == false) goto L44;
        r5 = (AtProps) e(r4);
        goto L76
    L44:
        if (Intrinsics.areEqual(AtProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L47;
        r5 = (AtProps) j(r4);
        goto L76
    L47:
        if (Intrinsics.areEqual(AtProps.class, PersonProps.class) == false) goto L50;
        r5 = (AtProps) r(r4);
        goto L76
    L50:
        if (Intrinsics.areEqual(AtProps.class, Person.class) == false) goto L53;
        r5 = (AtProps) q(r4);
        goto L76
    L53:
        if (Intrinsics.areEqual(AtProps.class, ContainerPadding.class) == false) goto L56;
        r5 = (AtProps) d(r4);
        goto L76
    L56:
        if (Intrinsics.areEqual(AtProps.class, HeadingProps.class) == false) goto L59;
        r5 = (AtProps) i(r4);
        goto L76
    L59:
        if (Intrinsics.areEqual(AtProps.class, NumberTagProps.class) == false) goto L62;
        r5 = (AtProps) p(r4);
        goto L76
    L62:
        if (Intrinsics.areEqual(AtProps.class, AudioProps.class) == false) goto L65;
        r5 = (AtProps) b(r4);
        goto L76
    L65:
        if (Intrinsics.areEqual(AtProps.class, a.class) == false) goto L68;
        r5 = (AtProps) n(r4);
        goto L76
    L68:
        if (Intrinsics.areEqual(AtProps.class, MarkdownAudioState.class) == false) goto L71;
        r5 = (AtProps) o(r4);
        goto L76
    L71:
        if (Intrinsics.areEqual(AtProps.class, MarkdownAudioBgPadding.class) == false) goto L74;
        r5 = (AtProps) m(r4);
        goto L76
    L74:
        throw new IllegalArgumentException("unsupported type: " + AtProps.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.larksuite.component.card.component.text.CardCodeBlockProps] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
    public static CardCodeBlockProps c(ReadableMap r9) {
        ?? r0 = new CardCodeBlockProps();
        CardCodeBlockProps r1 = k;
        r0.setLanguage(com.larksuite.component.card.component.f.h(r9, "language", r1.getLanguage()));
        ReadableArray r2 = com.larksuite.component.card.component.f.a(r9, "contents");
        if (r2 == null) goto L150;
        e r3 = a;
        ?? r4 = new ArrayList();
        int r5 = r2.size();
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L151;
        Object r8 = null;
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, Boolean.TYPE) == false) goto L16;
        Boolean r7 = com.larksuite.component.card.component.f.b(r2, r6);
        if ((r7 instanceof CardCodeBlockProps.b) == false) goto L12;
        r8 = r7;
    L12:
        CardCodeBlockProps.b r10 = (CardCodeBlockProps.b) r8;
        if (r10 == null) goto L149;
        r4.add(r10);
    L149:
        r6 = r6 + 1;
        goto L5
    L16:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, Double.TYPE) == false) goto L25;
        Double r11 = com.larksuite.component.card.component.f.f(r2, r6);
        if ((r11 instanceof CardCodeBlockProps.b) == false) goto L21;
        r8 = r11;
    L21:
        CardCodeBlockProps.b r12 = (CardCodeBlockProps.b) r8;
        if (r12 == null) goto L149;
        r4.add(r12);
        goto L149
    L25:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, Byte.TYPE) == false) goto L34;
        Byte r13 = com.larksuite.component.card.component.f.d(r2, r6);
        if ((r13 instanceof CardCodeBlockProps.b) == false) goto L30;
        r8 = r13;
    L30:
        CardCodeBlockProps.b r14 = (CardCodeBlockProps.b) r8;
        if (r14 == null) goto L149;
        r4.add(r14);
        goto L149
    L34:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, Short.TYPE) == false) goto L43;
        Short r15 = com.larksuite.component.card.component.f.l(r2, r6);
        if ((r15 instanceof CardCodeBlockProps.b) == false) goto L39;
        r8 = r15;
    L39:
        CardCodeBlockProps.b r16 = (CardCodeBlockProps.b) r8;
        if (r16 == null) goto L149;
        r4.add(r16);
        goto L149
    L43:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, Long.TYPE) == false) goto L52;
        Long r17 = com.larksuite.component.card.component.f.i(r2, r6);
        if ((r17 instanceof CardCodeBlockProps.b) == false) goto L48;
        r8 = r17;
    L48:
        CardCodeBlockProps.b r19 = (CardCodeBlockProps.b) r8;
        if (r19 == null) goto L149;
        r4.add(r19);
        goto L149
    L52:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, Character.TYPE) == false) goto L61;
        Character r20 = com.larksuite.component.card.component.f.e(r2, r6);
        if ((r20 instanceof CardCodeBlockProps.b) == false) goto L57;
        r8 = r20;
    L57:
        CardCodeBlockProps.b r21 = (CardCodeBlockProps.b) r8;
        if (r21 == null) goto L149;
        r4.add(r21);
        goto L149
    L61:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, Integer.TYPE) == false) goto L70;
        Integer r22 = com.larksuite.component.card.component.f.g(r2, r6);
        if ((r22 instanceof CardCodeBlockProps.b) == false) goto L66;
        r8 = r22;
    L66:
        CardCodeBlockProps.b r23 = (CardCodeBlockProps.b) r8;
        if (r23 == null) goto L149;
        r4.add(r23);
        goto L149
    L70:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, String.class) == false) goto L78;
        String r24 = com.larksuite.component.card.component.f.m(r2, r6);
        if ((r24 instanceof CardCodeBlockProps.b) == false) goto L75;
        r8 = r24;
    L75:
        CardCodeBlockProps.b r25 = (CardCodeBlockProps.b) r8;
        if (r25 == null) goto L149;
        r4.add(r25);
        goto L149
    L78:
        ReadableMap r26 = com.larksuite.component.card.component.f.j(r2, r6);
        if (r26 == null) goto L149;
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, TextProps.class) == false) goto L84;
        CardCodeBlockProps.b r27 = (CardCodeBlockProps.b) r3.u(r26);
    L146:
        r4.add(r27);
        goto L149
    L84:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, ContentProps.class) == false) goto L87;
        r27 = (CardCodeBlockProps.b) r3.f(r26);
        goto L146
    L87:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, AtProps.class) == false) goto L90;
        r27 = (CardCodeBlockProps.b) r3.a(r26);
        goto L146
    L90:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, LinkProps.class) == false) goto L93;
        r27 = (CardCodeBlockProps.b) r3.k(r26);
        goto L146
    L93:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, UDIconContentProps.class) == false) goto L96;
        r27 = (CardCodeBlockProps.b) v(r26);
        goto L146
    L96:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, EmojProps.class) == false) goto L99;
        r27 = (CardCodeBlockProps.b) h(r26);
        goto L146
    L99:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, PlainTextProps.class) == false) goto L102;
        r27 = (CardCodeBlockProps.b) r3.s(r26);
        goto L146
    L102:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, TagProps.class) == false) goto L105;
        r27 = (CardCodeBlockProps.b) r3.t(r26);
        goto L146
    L105:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, ListItem.class) == false) goto L108;
        r27 = (CardCodeBlockProps.b) r3.l(r26);
        goto L146
    L108:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, CardCodeBlockProps.class) == false) goto L111;
        r27 = (CardCodeBlockProps.b) c(r26);
        goto L146
    L111:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, CardCodeBlockProps.b.class) == false) goto L114;
        r27 = g(r26);
        goto L146
    L114:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, CardCodeBlockProps.b.a.class) == false) goto L117;
        r27 = (CardCodeBlockProps.b) e(r26);
        goto L146
    L117:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, com.larksuite.component.card.component.image.a.class) == false) goto L120;
        r27 = (CardCodeBlockProps.b) j(r26);
        goto L146
    L120:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, PersonProps.class) == false) goto L123;
        r27 = (CardCodeBlockProps.b) r3.r(r26);
        goto L146
    L123:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, Person.class) == false) goto L126;
        r27 = (CardCodeBlockProps.b) q(r26);
        goto L146
    L126:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, ContainerPadding.class) == false) goto L129;
        r27 = (CardCodeBlockProps.b) d(r26);
        goto L146
    L129:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, HeadingProps.class) == false) goto L132;
        r27 = (CardCodeBlockProps.b) r3.i(r26);
        goto L146
    L132:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, NumberTagProps.class) == false) goto L135;
        r27 = (CardCodeBlockProps.b) r3.p(r26);
        goto L146
    L135:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, AudioProps.class) == false) goto L138;
        r27 = (CardCodeBlockProps.b) r3.b(r26);
        goto L146
    L138:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, a.class) == false) goto L141;
        r27 = (CardCodeBlockProps.b) n(r26);
        goto L146
    L141:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, MarkdownAudioState.class) == false) goto L144;
        r27 = (CardCodeBlockProps.b) o(r26);
        goto L146
    L144:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.class, MarkdownAudioBgPadding.class) == false) goto L148;
        r27 = (CardCodeBlockProps.b) m(r26);
        goto L146
    L148:
        throw new IllegalArgumentException("unsupported type: " + CardCodeBlockProps.b.class);
    L151:
        r0.setContents(r4);
        CardCodeBlockProps r29 = k;
        Boolean r30 = com.larksuite.component.card.component.f.c(r9, "wordWrap", Boolean.valueOf(r29.getWordWrap()));
        if (r30 == null) goto L154;
        boolean r31 = r30.booleanValue();
    L155:
        r0.setWordWrap(r31);
        Integer r32 = com.larksuite.component.card.component.f.h(r9, "version", Integer.valueOf(r29.getVersion()));
        if (r32 == null) goto L158;
        int r33 = r32.intValue();
    L159:
        r0.setVersion(r33);
        return r0;
    L158:
        r33 = r29.getVersion();
        goto L159
    L154:
        r31 = r29.getWordWrap();
        goto L155
    L150:
        r4 = r1.getContents();
        goto L151
    }

    public static ContainerPadding d(ReadableMap r7) {
        ContainerPadding r1 = q;
        Integer r2 = com.larksuite.component.card.component.f.h(r7, "top", Integer.valueOf(r1.getTop()));
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L6:
        Integer r4 = com.larksuite.component.card.component.f.h(r7, "right", Integer.valueOf(r1.getRight()));
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
    L10:
        Integer r6 = com.larksuite.component.card.component.f.h(r7, "bottom", Integer.valueOf(r1.getBottom()));
        if (r6 == null) goto L13;
        int r8 = r6.intValue();
    L14:
        Integer r9 = com.larksuite.component.card.component.f.h(r7, "left", Integer.valueOf(r1.getLeft()));
        if (r9 == null) goto L17;
        int r10 = r9.intValue();
    L19:
        return new ContainerPadding(r3, r5, r8, r10);
    L17:
        r10 = r1.getLeft();
        goto L19
    L13:
        r8 = r1.getBottom();
        goto L14
    L9:
        r5 = r1.getRight();
        goto L10
    L5:
        r3 = r1.getTop();
        goto L6
    }

    public static CardCodeBlockProps.b.a e(ReadableMap r4) {
        CardCodeBlockProps.b.a r0 = new CardCodeBlockProps.b.a();
        CardCodeBlockProps.b.a r1 = m;
        r0.b(com.larksuite.component.card.component.f.n(r4, "content", r1.a()));
        r0.c(com.larksuite.component.card.component.f.h(r4, "type", r1.getType()));
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.larksuite.component.card.component.text.CardCodeBlockProps$b] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList] */
    public static CardCodeBlockProps.b g(ReadableMap r8) {
        ?? r0 = new CardCodeBlockProps.b();
        ReadableArray r9 = com.larksuite.component.card.component.f.a(r8, "contents");
        if (r9 == null) goto L150;
        e r1 = a;
        ?? r2 = new ArrayList();
        int r3 = r9.size();
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L151;
        Object r7 = null;
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, Boolean.TYPE) == false) goto L16;
        Boolean r5 = com.larksuite.component.card.component.f.b(r9, r4);
        if ((r5 instanceof CardCodeBlockProps.b.a) == false) goto L12;
        r7 = r5;
    L12:
        CardCodeBlockProps.b.a r10 = (CardCodeBlockProps.b.a) r7;
        if (r10 == null) goto L149;
        r2.add(r10);
    L149:
        r4 = r4 + 1;
        goto L5
    L16:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, Double.TYPE) == false) goto L25;
        Double r6 = com.larksuite.component.card.component.f.f(r9, r4);
        if ((r6 instanceof CardCodeBlockProps.b.a) == false) goto L21;
        r7 = r6;
    L21:
        CardCodeBlockProps.b.a r11 = (CardCodeBlockProps.b.a) r7;
        if (r11 == null) goto L149;
        r2.add(r11);
        goto L149
    L25:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, Byte.TYPE) == false) goto L34;
        Byte r12 = com.larksuite.component.card.component.f.d(r9, r4);
        if ((r12 instanceof CardCodeBlockProps.b.a) == false) goto L30;
        r7 = r12;
    L30:
        CardCodeBlockProps.b.a r13 = (CardCodeBlockProps.b.a) r7;
        if (r13 == null) goto L149;
        r2.add(r13);
        goto L149
    L34:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, Short.TYPE) == false) goto L43;
        Short r14 = com.larksuite.component.card.component.f.l(r9, r4);
        if ((r14 instanceof CardCodeBlockProps.b.a) == false) goto L39;
        r7 = r14;
    L39:
        CardCodeBlockProps.b.a r15 = (CardCodeBlockProps.b.a) r7;
        if (r15 == null) goto L149;
        r2.add(r15);
        goto L149
    L43:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, Long.TYPE) == false) goto L52;
        Long r16 = com.larksuite.component.card.component.f.i(r9, r4);
        if ((r16 instanceof CardCodeBlockProps.b.a) == false) goto L48;
        r7 = r16;
    L48:
        CardCodeBlockProps.b.a r17 = (CardCodeBlockProps.b.a) r7;
        if (r17 == null) goto L149;
        r2.add(r17);
        goto L149
    L52:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, Character.TYPE) == false) goto L61;
        Character r19 = com.larksuite.component.card.component.f.e(r9, r4);
        if ((r19 instanceof CardCodeBlockProps.b.a) == false) goto L57;
        r7 = r19;
    L57:
        CardCodeBlockProps.b.a r20 = (CardCodeBlockProps.b.a) r7;
        if (r20 == null) goto L149;
        r2.add(r20);
        goto L149
    L61:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, Integer.TYPE) == false) goto L70;
        Integer r21 = com.larksuite.component.card.component.f.g(r9, r4);
        if ((r21 instanceof CardCodeBlockProps.b.a) == false) goto L66;
        r7 = r21;
    L66:
        CardCodeBlockProps.b.a r22 = (CardCodeBlockProps.b.a) r7;
        if (r22 == null) goto L149;
        r2.add(r22);
        goto L149
    L70:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, String.class) == false) goto L78;
        String r23 = com.larksuite.component.card.component.f.m(r9, r4);
        if ((r23 instanceof CardCodeBlockProps.b.a) == false) goto L75;
        r7 = r23;
    L75:
        CardCodeBlockProps.b.a r24 = (CardCodeBlockProps.b.a) r7;
        if (r24 == null) goto L149;
        r2.add(r24);
        goto L149
    L78:
        ReadableMap r25 = com.larksuite.component.card.component.f.j(r9, r4);
        if (r25 == null) goto L149;
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, TextProps.class) == false) goto L84;
        CardCodeBlockProps.b.a r26 = (CardCodeBlockProps.b.a) r1.u(r25);
    L146:
        r2.add(r26);
        goto L149
    L84:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, ContentProps.class) == false) goto L87;
        r26 = (CardCodeBlockProps.b.a) r1.f(r25);
        goto L146
    L87:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, AtProps.class) == false) goto L90;
        r26 = (CardCodeBlockProps.b.a) r1.a(r25);
        goto L146
    L90:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, LinkProps.class) == false) goto L93;
        r26 = (CardCodeBlockProps.b.a) r1.k(r25);
        goto L146
    L93:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, UDIconContentProps.class) == false) goto L96;
        r26 = (CardCodeBlockProps.b.a) v(r25);
        goto L146
    L96:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, EmojProps.class) == false) goto L99;
        r26 = (CardCodeBlockProps.b.a) h(r25);
        goto L146
    L99:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, PlainTextProps.class) == false) goto L102;
        r26 = (CardCodeBlockProps.b.a) r1.s(r25);
        goto L146
    L102:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, TagProps.class) == false) goto L105;
        r26 = (CardCodeBlockProps.b.a) r1.t(r25);
        goto L146
    L105:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, ListItem.class) == false) goto L108;
        r26 = (CardCodeBlockProps.b.a) r1.l(r25);
        goto L146
    L108:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, CardCodeBlockProps.class) == false) goto L111;
        r26 = (CardCodeBlockProps.b.a) c(r25);
        goto L146
    L111:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, CardCodeBlockProps.b.class) == false) goto L114;
        r26 = (CardCodeBlockProps.b.a) g(r25);
        goto L146
    L114:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, CardCodeBlockProps.b.a.class) == false) goto L117;
        r26 = e(r25);
        goto L146
    L117:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, com.larksuite.component.card.component.image.a.class) == false) goto L120;
        r26 = (CardCodeBlockProps.b.a) j(r25);
        goto L146
    L120:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, PersonProps.class) == false) goto L123;
        r26 = (CardCodeBlockProps.b.a) r1.r(r25);
        goto L146
    L123:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, Person.class) == false) goto L126;
        r26 = (CardCodeBlockProps.b.a) q(r25);
        goto L146
    L126:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, ContainerPadding.class) == false) goto L129;
        r26 = (CardCodeBlockProps.b.a) d(r25);
        goto L146
    L129:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, HeadingProps.class) == false) goto L132;
        r26 = (CardCodeBlockProps.b.a) r1.i(r25);
        goto L146
    L132:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, NumberTagProps.class) == false) goto L135;
        r26 = (CardCodeBlockProps.b.a) r1.p(r25);
        goto L146
    L135:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, AudioProps.class) == false) goto L138;
        r26 = (CardCodeBlockProps.b.a) r1.b(r25);
        goto L146
    L138:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, a.class) == false) goto L141;
        r26 = (CardCodeBlockProps.b.a) n(r25);
        goto L146
    L141:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, MarkdownAudioState.class) == false) goto L144;
        r26 = (CardCodeBlockProps.b.a) o(r25);
        goto L146
    L144:
        if (Intrinsics.areEqual(CardCodeBlockProps.b.a.class, MarkdownAudioBgPadding.class) == false) goto L148;
        r26 = (CardCodeBlockProps.b.a) m(r25);
        goto L146
    L148:
        throw new IllegalArgumentException("unsupported type: " + CardCodeBlockProps.b.a.class);
    L151:
        r0.b(r2);
        return r0;
    L150:
        r2 = l.a();
        goto L151
    }

    public static EmojProps h(ReadableMap r5) {
        EmojProps r1 = g;
        String r2 = com.larksuite.component.card.component.f.n(r5, "key", r1.getKey());
        Integer r6 = com.larksuite.component.card.component.f.h(r5, "textSize", Integer.valueOf(r1.getTextSize()));
        if (r6 == null) goto L5;
        int r7 = r6.intValue();
    L7:
        return new EmojProps(r2, r7);
    L5:
        r7 = r1.getTextSize();
        goto L7
    }

    public static com.larksuite.component.card.component.image.a j(ReadableMap r17) {
        com.larksuite.component.card.component.image.a r1 = n;
        String r2 = com.larksuite.component.card.component.f.n(r17, "image_id", r1.e());
        String r3 = com.larksuite.component.card.component.f.n(r17, "res_id", r1.j());
        String r4 = com.larksuite.component.card.component.f.n(r17, "tint_color", r1.k());
        String r5 = com.larksuite.component.card.component.f.n(r17, "crop_type", r1.a());
        Boolean r6 = com.larksuite.component.card.component.f.c(r17, "isTranslateElement", Boolean.valueOf(r1.m()));
        if (r6 == null) goto L5;
        boolean r7 = r6.booleanValue();
    L6:
        Boolean r8 = com.larksuite.component.card.component.f.c(r17, "forcePreview", Boolean.valueOf(r1.d()));
        if (r8 == null) goto L9;
        boolean r9 = r8.booleanValue();
    L10:
        Integer r10 = com.larksuite.component.card.component.f.h(r17, "originWidth", r1.h());
        Integer r11 = com.larksuite.component.card.component.f.h(r17, "originHeight", r1.g());
        Boolean r12 = com.larksuite.component.card.component.f.c(r17, "disableLongImageTag", Boolean.valueOf(r1.b()));
        if (r12 == null) goto L13;
        boolean r13 = r12.booleanValue();
    L14:
        Boolean r14 = com.larksuite.component.card.component.f.c(r17, "transparent", Boolean.valueOf(r1.l()));
        if (r14 == null) goto L17;
        boolean r15 = r14.booleanValue();
    L18:
        Boolean r16 = com.larksuite.component.card.component.f.c(r17, "disableTap", Boolean.valueOf(r1.c()));
        if (r16 == null) goto L21;
        boolean r19 = r16.booleanValue();
    L22:
        String r110 = com.larksuite.component.card.component.f.n(r17, "loadingStyle", r1.f());
        Boolean r0 = com.larksuite.component.card.component.f.c(r17, "preview", Boolean.valueOf(r1.i()));
        if (r0 == null) goto L25;
        boolean r20 = r0.booleanValue();
    L26:
        boolean r21 = r7;
        boolean r22 = r9;
        boolean r23 = r13;
        boolean r111 = r15;
        boolean r112 = r19;
        return new com.larksuite.component.card.component.image.a(r2, r3, r4, r5, r21, r22, r10, r11, r23, r111, r112, r110, r20);
    L25:
        r20 = r1.i();
        goto L26
    L21:
        r19 = r1.c();
        goto L22
    L17:
        r15 = r1.l();
        goto L18
    L13:
        r13 = r1.b();
        goto L14
    L9:
        r9 = r1.d();
        goto L10
    L5:
        r7 = r1.m();
        goto L6
    }

    public static MarkdownAudioBgPadding m(ReadableMap r7) {
        MarkdownAudioBgPadding r1 = w;
        Integer r2 = com.larksuite.component.card.component.f.h(r7, "top", Integer.valueOf(r1.getTop()));
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L6:
        Integer r4 = com.larksuite.component.card.component.f.h(r7, "right", Integer.valueOf(r1.getRight()));
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
    L10:
        Integer r6 = com.larksuite.component.card.component.f.h(r7, "bottom", Integer.valueOf(r1.getBottom()));
        if (r6 == null) goto L13;
        int r8 = r6.intValue();
    L14:
        Integer r9 = com.larksuite.component.card.component.f.h(r7, "left", Integer.valueOf(r1.getLeft()));
        if (r9 == null) goto L17;
        int r10 = r9.intValue();
    L19:
        return new MarkdownAudioBgPadding(r3, r5, r8, r10);
    L17:
        r10 = r1.getLeft();
        goto L19
    L13:
        r8 = r1.getBottom();
        goto L14
    L9:
        r5 = r1.getRight();
        goto L10
    L5:
        r3 = r1.getTop();
        goto L6
    }

    public static a n(ReadableMap r7) {
        a r0 = u;
        return new a(com.larksuite.component.card.component.f.n(r7, "audioID", r0.a), com.larksuite.component.card.component.f.n(r7, "fileID", r0.b), com.larksuite.component.card.component.f.n(r7, "fileKey", r0.c), com.larksuite.component.card.component.f.n(r7, "sessionID", r0.d), com.larksuite.component.card.component.f.h(r7, "duration", r0.e));
    }

    public static MarkdownAudioState o(ReadableMap r5) {
        MarkdownAudioState r1 = v;
        return new MarkdownAudioState(com.larksuite.component.card.component.f.n(r5, "state", r1.getState()), com.larksuite.component.card.component.f.h(r5, "position", r1.getPosition()), com.larksuite.component.card.component.f.h(r5, "duration", r1.getDuration()));
    }

    public static Person q(ReadableMap r5) {
        Person r1 = p;
        return new Person(com.larksuite.component.card.component.f.n(r5, "id", r1.getId()), com.larksuite.component.card.component.f.n(r5, "avatarKey", r1.getAvatarKey()), com.larksuite.component.card.component.f.n(r5, "content", r1.getContent()));
    }

    public static UDIconContentProps v(ReadableMap r8) {
        UDIconContentProps r0 = f;
        String r1 = com.larksuite.component.card.component.f.n(r8, "token", r0.getToken());
        String r2 = com.larksuite.component.card.component.f.n(r8, "color", r0.getColor());
        String r3 = com.larksuite.component.card.component.f.n(r8, "customColor", r0.getCustomColor());
        String r4 = com.larksuite.component.card.component.f.n(r8, "imageID", r0.getImageId());
        Boolean r5 = com.larksuite.component.card.component.f.c(r8, "isTranslateElement", Boolean.valueOf(r0.isTranslateElement()));
        if (r5 == null) goto L5;
        boolean r6 = r5.booleanValue();
    L7:
        return new UDIconContentProps(r1, r2, r3, r4, r6, com.larksuite.component.card.component.f.h(r8, "iconSize", r0.getIconSize()));
    L5:
        r6 = r0.isTranslateElement();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List] */
    public final AtProps a(ReadableMap r12) {
        AtProps r0 = d;
        String r4 = com.larksuite.component.card.component.f.n(r12, "userId", r0.getUserId());
        Integer r5 = com.larksuite.component.card.component.f.h(r12, "textSize", r0.getTextSize());
        String r6 = com.larksuite.component.card.component.f.n(r12, "textColor", r0.getTextColor());
        String r7 = com.larksuite.component.card.component.f.n(r12, "textBgColor", r0.getTextBgColor());
        ReadableArray r1 = com.larksuite.component.card.component.f.a(r12, "textDecoration");
        if (r1 == null) goto L149;
        ?? r2 = new ArrayList();
        int r3 = r1.size();
        int r8 = 0;
    L5:
        if (r8 >= r3) goto L150;
        Object r10 = null;
        if (Intrinsics.areEqual(String.class, Boolean.TYPE) == false) goto L16;
        Boolean r9 = com.larksuite.component.card.component.f.b(r1, r8);
        if ((r9 instanceof String) == false) goto L12;
        r10 = r9;
    L12:
        String r11 = (String) r10;
        if (r11 == null) goto L148;
        r2.add(r11);
    L148:
        r8 = r8 + 1;
        goto L5
    L16:
        if (Intrinsics.areEqual(String.class, Double.TYPE) == false) goto L25;
        Double r13 = com.larksuite.component.card.component.f.f(r1, r8);
        if ((r13 instanceof String) == false) goto L21;
        r10 = r13;
    L21:
        String r14 = (String) r10;
        if (r14 == null) goto L148;
        r2.add(r14);
        goto L148
    L25:
        if (Intrinsics.areEqual(String.class, Byte.TYPE) == false) goto L34;
        Byte r15 = com.larksuite.component.card.component.f.d(r1, r8);
        if ((r15 instanceof String) == false) goto L30;
        r10 = r15;
    L30:
        String r16 = (String) r10;
        if (r16 == null) goto L148;
        r2.add(r16);
        goto L148
    L34:
        if (Intrinsics.areEqual(String.class, Short.TYPE) == false) goto L43;
        Short r17 = com.larksuite.component.card.component.f.l(r1, r8);
        if ((r17 instanceof String) == false) goto L39;
        r10 = r17;
    L39:
        String r19 = (String) r10;
        if (r19 == null) goto L148;
        r2.add(r19);
        goto L148
    L43:
        if (Intrinsics.areEqual(String.class, Long.TYPE) == false) goto L52;
        Long r20 = com.larksuite.component.card.component.f.i(r1, r8);
        if ((r20 instanceof String) == false) goto L48;
        r10 = r20;
    L48:
        String r110 = (String) r10;
        if (r110 == null) goto L148;
        r2.add(r110);
        goto L148
    L52:
        if (Intrinsics.areEqual(String.class, Character.TYPE) == false) goto L61;
        Character r21 = com.larksuite.component.card.component.f.e(r1, r8);
        if ((r21 instanceof String) == false) goto L57;
        r10 = r21;
    L57:
        String r111 = (String) r10;
        if (r111 == null) goto L148;
        r2.add(r111);
        goto L148
    L61:
        if (Intrinsics.areEqual(String.class, Integer.TYPE) == false) goto L70;
        Integer r22 = com.larksuite.component.card.component.f.g(r1, r8);
        if ((r22 instanceof String) == false) goto L66;
        r10 = r22;
    L66:
        String r112 = (String) r10;
        if (r112 == null) goto L148;
        r2.add(r112);
        goto L148
    L70:
        if (Intrinsics.areEqual(String.class, String.class) == false) goto L77;
        String r23 = com.larksuite.component.card.component.f.m(r1, r8);
        if ((r23 instanceof String) == false) goto L75;
        r10 = r23;
    L75:
        if (r10 == null) goto L148;
        r2.add(r10);
        goto L148
    L77:
        ReadableMap r24 = com.larksuite.component.card.component.f.j(r1, r8);
        if (r24 == null) goto L148;
        if (Intrinsics.areEqual(String.class, TextProps.class) == false) goto L83;
        String r25 = (String) u(r24);
    L145:
        r2.add(r25);
        goto L148
    L83:
        if (Intrinsics.areEqual(String.class, ContentProps.class) == false) goto L86;
        r25 = (String) f(r24);
        goto L145
    L86:
        if (Intrinsics.areEqual(String.class, AtProps.class) == false) goto L89;
        r25 = (String) a(r24);
        goto L145
    L89:
        if (Intrinsics.areEqual(String.class, LinkProps.class) == false) goto L92;
        r25 = (String) k(r24);
        goto L145
    L92:
        if (Intrinsics.areEqual(String.class, UDIconContentProps.class) == false) goto L95;
        r25 = (String) v(r24);
        goto L145
    L95:
        if (Intrinsics.areEqual(String.class, EmojProps.class) == false) goto L98;
        r25 = (String) h(r24);
        goto L145
    L98:
        if (Intrinsics.areEqual(String.class, PlainTextProps.class) == false) goto L101;
        r25 = (String) s(r24);
        goto L145
    L101:
        if (Intrinsics.areEqual(String.class, TagProps.class) == false) goto L104;
        r25 = (String) t(r24);
        goto L145
    L104:
        if (Intrinsics.areEqual(String.class, ListItem.class) == false) goto L107;
        r25 = (String) l(r24);
        goto L145
    L107:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.class) == false) goto L110;
        r25 = (String) c(r24);
        goto L145
    L110:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.class) == false) goto L113;
        r25 = (String) g(r24);
        goto L145
    L113:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.a.class) == false) goto L116;
        r25 = (String) e(r24);
        goto L145
    L116:
        if (Intrinsics.areEqual(String.class, com.larksuite.component.card.component.image.a.class) == false) goto L119;
        r25 = (String) j(r24);
        goto L145
    L119:
        if (Intrinsics.areEqual(String.class, PersonProps.class) == false) goto L122;
        r25 = (String) r(r24);
        goto L145
    L122:
        if (Intrinsics.areEqual(String.class, Person.class) == false) goto L125;
        r25 = (String) q(r24);
        goto L145
    L125:
        if (Intrinsics.areEqual(String.class, ContainerPadding.class) == false) goto L128;
        r25 = (String) d(r24);
        goto L145
    L128:
        if (Intrinsics.areEqual(String.class, HeadingProps.class) == false) goto L131;
        r25 = (String) i(r24);
        goto L145
    L131:
        if (Intrinsics.areEqual(String.class, NumberTagProps.class) == false) goto L134;
        r25 = (String) p(r24);
        goto L145
    L134:
        if (Intrinsics.areEqual(String.class, AudioProps.class) == false) goto L137;
        r25 = (String) b(r24);
        goto L145
    L137:
        if (Intrinsics.areEqual(String.class, a.class) == false) goto L140;
        r25 = (String) n(r24);
        goto L145
    L140:
        if (Intrinsics.areEqual(String.class, MarkdownAudioState.class) == false) goto L143;
        r25 = (String) o(r24);
        goto L145
    L143:
        if (Intrinsics.areEqual(String.class, MarkdownAudioBgPadding.class) == false) goto L147;
        r25 = (String) m(r24);
        goto L145
    L147:
        throw new IllegalArgumentException("unsupported type: " + String.class);
    L150:
        ?? r26 = r2;
        AtProps r27 = d;
        String r29 = com.larksuite.component.card.component.f.n(r12, "content", r27.getContent());
        if (r29 != null) goto L153;
        r29 = r27.getContent();
    L153:
        String r30 = r29;
        Integer r113 = com.larksuite.component.card.component.f.h(r12, "maxLines", Integer.valueOf(r27.getMaxLines()));
        if (r113 == null) goto L156;
        int r114 = r113.intValue();
    L158:
        return new AtProps(r4, r5, r6, r7, r26, r30, r114);
    L156:
        r114 = r27.getMaxLines();
        goto L158
    L149:
        r2 = r0.getTextDecoration();
        goto L150
    }

    public final AudioProps b(ReadableMap r23) {
        ReadableMap r2 = com.larksuite.component.card.component.f.k(r23, "audioInfo");
        if (r2 != null) goto L5;
        a r3 = t.getAudioInfo();
    L73:
        a r5 = r3;
        ReadableMap r4 = com.larksuite.component.card.component.f.k(r23, "audioState");
        if (r4 != null) goto L76;
        MarkdownAudioState r6 = t.getAudioState();
    L144:
        MarkdownAudioState r7 = r6;
        AudioProps r8 = t;
        String r9 = com.larksuite.component.card.component.f.n(r23, "bgColor", r8.getBgColor());
        String r10 = com.larksuite.component.card.component.f.n(r23, "style", r8.getStyle());
        Boolean r11 = com.larksuite.component.card.component.f.c(r23, "showTime", r8.getShowTime());
        if (r11 != null) goto L147;
        r11 = r8.getShowTime();
    L147:
        Boolean r12 = r11;
        ReadableMap r13 = com.larksuite.component.card.component.f.k(r23, "icon");
        if (r13 != null) goto L150;
        UDIconContentProps r14 = r8.getIcon();
    L218:
        UDIconContentProps r15 = r14;
        Integer r16 = com.larksuite.component.card.component.f.h(r23, "originalTextSize", r8.getOriginalTextSize());
        if (r16 != null) goto L221;
        r16 = r8.getOriginalTextSize();
    L221:
        Integer r17 = r16;
        Integer r19 = com.larksuite.component.card.component.f.h(r23, "bgHeight", r8.getBgHeight());
        if (r19 != null) goto L224;
        r19 = r8.getBgHeight();
    L224:
        Integer r110 = r19;
        ReadableMap r20 = com.larksuite.component.card.component.f.k(r23, "bgPadding");
        if (r20 != null) goto L227;
        MarkdownAudioBgPadding r21 = r8.getBgPadding();
    L295:
        MarkdownAudioBgPadding r111 = r21;
        Integer r112 = com.larksuite.component.card.component.f.h(r23, "textSize", r8.getTextSize());
        String r113 = com.larksuite.component.card.component.f.n(r23, "textColor", r8.getTextColor());
        String r114 = com.larksuite.component.card.component.f.n(r23, "textBgColor", r8.getTextBgColor());
        ReadableArray r22 = com.larksuite.component.card.component.f.a(r23, "textDecoration");
        if (r22 == null) goto L447;
        ArrayList r24 = new ArrayList();
        int r115 = r22.size();
        int r116 = 0;
    L298:
        if (r116 >= r115) goto L446;
        int r117 = r115;
        MarkdownAudioBgPadding r25 = r111;
        Object r26 = null;
        if (Intrinsics.areEqual(String.class, Boolean.TYPE) == false) goto L310;
        Boolean r118 = com.larksuite.component.card.component.f.b(r22, r116);
        if ((r118 instanceof String) == false) goto L305;
        r26 = r118;
    L305:
        String r119 = (String) r26;
        if (r119 == null) goto L445;
        r24.add(r119);
    L445:
        r116 = r116 + 1;
        r115 = r117;
        r111 = r25;
        r22 = r22;
        goto L298
    L310:
        if (Intrinsics.areEqual(String.class, Double.TYPE) == false) goto L319;
        Double r120 = com.larksuite.component.card.component.f.f(r22, r116);
        if ((r120 instanceof String) == false) goto L315;
        r26 = r120;
    L315:
        String r121 = (String) r26;
        if (r121 == null) goto L445;
        r24.add(r121);
        goto L445
    L319:
        if (Intrinsics.areEqual(String.class, Byte.TYPE) == false) goto L328;
        Byte r122 = com.larksuite.component.card.component.f.d(r22, r116);
        if ((r122 instanceof String) == false) goto L324;
        r26 = r122;
    L324:
        String r123 = (String) r26;
        if (r123 == null) goto L445;
        r24.add(r123);
        goto L445
    L328:
        if (Intrinsics.areEqual(String.class, Short.TYPE) == false) goto L337;
        Short r124 = com.larksuite.component.card.component.f.l(r22, r116);
        if ((r124 instanceof String) == false) goto L333;
        r26 = r124;
    L333:
        String r125 = (String) r26;
        if (r125 == null) goto L445;
        r24.add(r125);
        goto L445
    L337:
        if (Intrinsics.areEqual(String.class, Long.TYPE) == false) goto L346;
        Long r126 = com.larksuite.component.card.component.f.i(r22, r116);
        if ((r126 instanceof String) == false) goto L342;
        r26 = r126;
    L342:
        String r127 = (String) r26;
        if (r127 == null) goto L445;
        r24.add(r127);
        goto L445
    L346:
        if (Intrinsics.areEqual(String.class, Character.TYPE) == false) goto L355;
        Character r128 = com.larksuite.component.card.component.f.e(r22, r116);
        if ((r128 instanceof String) == false) goto L351;
        r26 = r128;
    L351:
        String r129 = (String) r26;
        if (r129 == null) goto L445;
        r24.add(r129);
        goto L445
    L355:
        if (Intrinsics.areEqual(String.class, Integer.TYPE) == false) goto L364;
        Integer r130 = com.larksuite.component.card.component.f.g(r22, r116);
        if ((r130 instanceof String) == false) goto L360;
        r26 = r130;
    L360:
        String r131 = (String) r26;
        if (r131 == null) goto L445;
        r24.add(r131);
        goto L445
    L364:
        if (Intrinsics.areEqual(String.class, String.class) == false) goto L370;
        String r132 = com.larksuite.component.card.component.f.m(r22, r116);
        if ((r132 instanceof String) == true) goto L368;
        r132 = null;
    L368:
        if (r132 == null) goto L445;
        r24.add(r132);
        goto L445
    L370:
        ReadableMap r133 = com.larksuite.component.card.component.f.j(r22, r116);
        if (r133 == null) goto L445;
        if (Intrinsics.areEqual(String.class, TextProps.class) == false) goto L376;
        String r27 = (String) u(r133);
    L442:
        r24.add(r27);
        goto L445
    L376:
        if (Intrinsics.areEqual(String.class, ContentProps.class) == false) goto L379;
        r27 = (String) f(r133);
        goto L442
    L379:
        if (Intrinsics.areEqual(String.class, AtProps.class) == false) goto L382;
        r27 = (String) a(r133);
        goto L442
    L382:
        if (Intrinsics.areEqual(String.class, LinkProps.class) == false) goto L385;
        r27 = (String) k(r133);
        goto L442
    L385:
        if (Intrinsics.areEqual(String.class, UDIconContentProps.class) == false) goto L388;
        r27 = (String) v(r133);
        goto L442
    L388:
        if (Intrinsics.areEqual(String.class, EmojProps.class) == false) goto L391;
        r27 = (String) h(r133);
        goto L442
    L391:
        if (Intrinsics.areEqual(String.class, PlainTextProps.class) == false) goto L394;
        r27 = (String) s(r133);
        goto L442
    L394:
        if (Intrinsics.areEqual(String.class, TagProps.class) == false) goto L397;
        r27 = (String) t(r133);
        goto L442
    L397:
        if (Intrinsics.areEqual(String.class, ListItem.class) == false) goto L400;
        r27 = (String) l(r133);
        goto L442
    L400:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.class) == false) goto L403;
        r27 = (String) c(r133);
        goto L442
    L403:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.class) == false) goto L406;
        r27 = (String) g(r133);
        goto L442
    L406:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.a.class) == false) goto L409;
        r27 = (String) e(r133);
        goto L442
    L409:
        if (Intrinsics.areEqual(String.class, com.larksuite.component.card.component.image.a.class) == false) goto L412;
        r27 = (String) j(r133);
        goto L442
    L412:
        if (Intrinsics.areEqual(String.class, PersonProps.class) == false) goto L415;
        r27 = (String) r(r133);
        goto L442
    L415:
        if (Intrinsics.areEqual(String.class, Person.class) == false) goto L418;
        r27 = (String) q(r133);
        goto L442
    L418:
        if (Intrinsics.areEqual(String.class, ContainerPadding.class) == false) goto L421;
        r27 = (String) d(r133);
        goto L442
    L421:
        if (Intrinsics.areEqual(String.class, HeadingProps.class) == false) goto L424;
        r27 = (String) i(r133);
        goto L442
    L424:
        if (Intrinsics.areEqual(String.class, NumberTagProps.class) == false) goto L427;
        r27 = (String) p(r133);
        goto L442
    L427:
        if (Intrinsics.areEqual(String.class, AudioProps.class) == false) goto L434;
        r27 = (String) b(r133);
    L430:
        th = move-exception;
        throw th;
    L434:
        if (Intrinsics.areEqual(String.class, a.class) == false) goto L437;
        r27 = (String) n(r133);
        goto L442
    L437:
        if (Intrinsics.areEqual(String.class, MarkdownAudioState.class) == false) goto L440;
        r27 = (String) o(r133);
        goto L442
    L440:
        if (Intrinsics.areEqual(String.class, MarkdownAudioBgPadding.class) == false) goto L444;
        r27 = (String) m(r133);
        goto L442
    L444:
        throw new IllegalArgumentException("unsupported type: " + String.class);
    L446:
        MarkdownAudioBgPadding r29 = r111;
        List r30 = r24;
    L448:
        AudioProps r31 = t;
        String r32 = com.larksuite.component.card.component.f.n(r23, "content", r31.getContent());
        if (r32 != null) goto L451;
        r32 = r31.getContent();
    L451:
        String r134 = r32;
        Integer r0 = com.larksuite.component.card.component.f.h(r23, "maxLines", Integer.valueOf(r31.getMaxLines()));
        if (r0 == null) goto L454;
        int r1 = r0.intValue();
    L456:
        return new AudioProps(r5, r7, r9, r10, r12, r15, r17, r110, r29, r112, r113, r114, r30, r134, r1);
    L454:
        r1 = r31.getMaxLines();
        goto L456
    L447:
        r29 = r111;
        r30 = r8.getTextDecoration();
        goto L448
    L227:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, TextProps.class) == false) goto L230;
        r21 = (MarkdownAudioBgPadding) u(r20);
        goto L295
    L230:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, ContentProps.class) == false) goto L233;
        r21 = (MarkdownAudioBgPadding) f(r20);
        goto L295
    L233:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, AtProps.class) == false) goto L236;
        r21 = (MarkdownAudioBgPadding) a(r20);
        goto L295
    L236:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, LinkProps.class) == false) goto L239;
        r21 = (MarkdownAudioBgPadding) k(r20);
        goto L295
    L239:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, UDIconContentProps.class) == false) goto L242;
        r21 = (MarkdownAudioBgPadding) v(r20);
        goto L295
    L242:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, EmojProps.class) == false) goto L245;
        r21 = (MarkdownAudioBgPadding) h(r20);
        goto L295
    L245:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, PlainTextProps.class) == false) goto L248;
        r21 = (MarkdownAudioBgPadding) s(r20);
        goto L295
    L248:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, TagProps.class) == false) goto L251;
        r21 = (MarkdownAudioBgPadding) t(r20);
        goto L295
    L251:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, ListItem.class) == false) goto L254;
        r21 = (MarkdownAudioBgPadding) l(r20);
        goto L295
    L254:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, CardCodeBlockProps.class) == false) goto L257;
        r21 = (MarkdownAudioBgPadding) c(r20);
        goto L295
    L257:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, CardCodeBlockProps.b.class) == false) goto L260;
        r21 = (MarkdownAudioBgPadding) g(r20);
        goto L295
    L260:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, CardCodeBlockProps.b.a.class) == false) goto L263;
        r21 = (MarkdownAudioBgPadding) e(r20);
        goto L295
    L263:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, com.larksuite.component.card.component.image.a.class) == false) goto L266;
        r21 = (MarkdownAudioBgPadding) j(r20);
        goto L295
    L266:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, PersonProps.class) == false) goto L269;
        r21 = (MarkdownAudioBgPadding) r(r20);
        goto L295
    L269:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, Person.class) == false) goto L272;
        r21 = (MarkdownAudioBgPadding) q(r20);
        goto L295
    L272:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, ContainerPadding.class) == false) goto L275;
        r21 = (MarkdownAudioBgPadding) d(r20);
        goto L295
    L275:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, HeadingProps.class) == false) goto L278;
        r21 = (MarkdownAudioBgPadding) i(r20);
        goto L295
    L278:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, NumberTagProps.class) == false) goto L281;
        r21 = (MarkdownAudioBgPadding) p(r20);
        goto L295
    L281:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, AudioProps.class) == false) goto L284;
        r21 = (MarkdownAudioBgPadding) b(r20);
        goto L295
    L284:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, a.class) == false) goto L287;
        r21 = (MarkdownAudioBgPadding) n(r20);
        goto L295
    L287:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, MarkdownAudioState.class) == false) goto L290;
        r21 = (MarkdownAudioBgPadding) o(r20);
        goto L295
    L290:
        if (Intrinsics.areEqual(MarkdownAudioBgPadding.class, MarkdownAudioBgPadding.class) == false) goto L293;
        r21 = m(r20);
        goto L295
    L293:
        throw new IllegalArgumentException("unsupported type: " + MarkdownAudioBgPadding.class);
    L150:
        if (Intrinsics.areEqual(UDIconContentProps.class, TextProps.class) == false) goto L153;
        r14 = (UDIconContentProps) u(r13);
        goto L218
    L153:
        if (Intrinsics.areEqual(UDIconContentProps.class, ContentProps.class) == false) goto L156;
        r14 = (UDIconContentProps) f(r13);
        goto L218
    L156:
        if (Intrinsics.areEqual(UDIconContentProps.class, AtProps.class) == false) goto L159;
        r14 = (UDIconContentProps) a(r13);
        goto L218
    L159:
        if (Intrinsics.areEqual(UDIconContentProps.class, LinkProps.class) == false) goto L162;
        r14 = (UDIconContentProps) k(r13);
        goto L218
    L162:
        if (Intrinsics.areEqual(UDIconContentProps.class, UDIconContentProps.class) == false) goto L165;
        r14 = v(r13);
        goto L218
    L165:
        if (Intrinsics.areEqual(UDIconContentProps.class, EmojProps.class) == false) goto L168;
        r14 = (UDIconContentProps) h(r13);
        goto L218
    L168:
        if (Intrinsics.areEqual(UDIconContentProps.class, PlainTextProps.class) == false) goto L171;
        r14 = (UDIconContentProps) s(r13);
        goto L218
    L171:
        if (Intrinsics.areEqual(UDIconContentProps.class, TagProps.class) == false) goto L174;
        r14 = (UDIconContentProps) t(r13);
        goto L218
    L174:
        if (Intrinsics.areEqual(UDIconContentProps.class, ListItem.class) == false) goto L177;
        r14 = (UDIconContentProps) l(r13);
        goto L218
    L177:
        if (Intrinsics.areEqual(UDIconContentProps.class, CardCodeBlockProps.class) == false) goto L180;
        r14 = (UDIconContentProps) c(r13);
        goto L218
    L180:
        if (Intrinsics.areEqual(UDIconContentProps.class, CardCodeBlockProps.b.class) == false) goto L183;
        r14 = (UDIconContentProps) g(r13);
        goto L218
    L183:
        if (Intrinsics.areEqual(UDIconContentProps.class, CardCodeBlockProps.b.a.class) == false) goto L186;
        r14 = (UDIconContentProps) e(r13);
        goto L218
    L186:
        if (Intrinsics.areEqual(UDIconContentProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L189;
        r14 = (UDIconContentProps) j(r13);
        goto L218
    L189:
        if (Intrinsics.areEqual(UDIconContentProps.class, PersonProps.class) == false) goto L192;
        r14 = (UDIconContentProps) r(r13);
        goto L218
    L192:
        if (Intrinsics.areEqual(UDIconContentProps.class, Person.class) == false) goto L195;
        r14 = (UDIconContentProps) q(r13);
        goto L218
    L195:
        if (Intrinsics.areEqual(UDIconContentProps.class, ContainerPadding.class) == false) goto L198;
        r14 = (UDIconContentProps) d(r13);
        goto L218
    L198:
        if (Intrinsics.areEqual(UDIconContentProps.class, HeadingProps.class) == false) goto L201;
        r14 = (UDIconContentProps) i(r13);
        goto L218
    L201:
        if (Intrinsics.areEqual(UDIconContentProps.class, NumberTagProps.class) == false) goto L204;
        r14 = (UDIconContentProps) p(r13);
        goto L218
    L204:
        if (Intrinsics.areEqual(UDIconContentProps.class, AudioProps.class) == false) goto L207;
        r14 = (UDIconContentProps) b(r13);
        goto L218
    L207:
        if (Intrinsics.areEqual(UDIconContentProps.class, a.class) == false) goto L210;
        r14 = (UDIconContentProps) n(r13);
        goto L218
    L210:
        if (Intrinsics.areEqual(UDIconContentProps.class, MarkdownAudioState.class) == false) goto L213;
        r14 = (UDIconContentProps) o(r13);
        goto L218
    L213:
        if (Intrinsics.areEqual(UDIconContentProps.class, MarkdownAudioBgPadding.class) == false) goto L216;
        r14 = (UDIconContentProps) m(r13);
        goto L218
    L216:
        throw new IllegalArgumentException("unsupported type: " + UDIconContentProps.class);
    L76:
        if (Intrinsics.areEqual(MarkdownAudioState.class, TextProps.class) == false) goto L79;
        r6 = (MarkdownAudioState) u(r4);
        goto L144
    L79:
        if (Intrinsics.areEqual(MarkdownAudioState.class, ContentProps.class) == false) goto L82;
        r6 = (MarkdownAudioState) f(r4);
        goto L144
    L82:
        if (Intrinsics.areEqual(MarkdownAudioState.class, AtProps.class) == false) goto L85;
        r6 = (MarkdownAudioState) a(r4);
        goto L144
    L85:
        if (Intrinsics.areEqual(MarkdownAudioState.class, LinkProps.class) == false) goto L88;
        r6 = (MarkdownAudioState) k(r4);
        goto L144
    L88:
        if (Intrinsics.areEqual(MarkdownAudioState.class, UDIconContentProps.class) == false) goto L91;
        r6 = (MarkdownAudioState) v(r4);
        goto L144
    L91:
        if (Intrinsics.areEqual(MarkdownAudioState.class, EmojProps.class) == false) goto L94;
        r6 = (MarkdownAudioState) h(r4);
        goto L144
    L94:
        if (Intrinsics.areEqual(MarkdownAudioState.class, PlainTextProps.class) == false) goto L97;
        r6 = (MarkdownAudioState) s(r4);
        goto L144
    L97:
        if (Intrinsics.areEqual(MarkdownAudioState.class, TagProps.class) == false) goto L100;
        r6 = (MarkdownAudioState) t(r4);
        goto L144
    L100:
        if (Intrinsics.areEqual(MarkdownAudioState.class, ListItem.class) == false) goto L103;
        r6 = (MarkdownAudioState) l(r4);
        goto L144
    L103:
        if (Intrinsics.areEqual(MarkdownAudioState.class, CardCodeBlockProps.class) == false) goto L106;
        r6 = (MarkdownAudioState) c(r4);
        goto L144
    L106:
        if (Intrinsics.areEqual(MarkdownAudioState.class, CardCodeBlockProps.b.class) == false) goto L109;
        r6 = (MarkdownAudioState) g(r4);
        goto L144
    L109:
        if (Intrinsics.areEqual(MarkdownAudioState.class, CardCodeBlockProps.b.a.class) == false) goto L112;
        r6 = (MarkdownAudioState) e(r4);
        goto L144
    L112:
        if (Intrinsics.areEqual(MarkdownAudioState.class, com.larksuite.component.card.component.image.a.class) == false) goto L115;
        r6 = (MarkdownAudioState) j(r4);
        goto L144
    L115:
        if (Intrinsics.areEqual(MarkdownAudioState.class, PersonProps.class) == false) goto L118;
        r6 = (MarkdownAudioState) r(r4);
        goto L144
    L118:
        if (Intrinsics.areEqual(MarkdownAudioState.class, Person.class) == false) goto L121;
        r6 = (MarkdownAudioState) q(r4);
        goto L144
    L121:
        if (Intrinsics.areEqual(MarkdownAudioState.class, ContainerPadding.class) == false) goto L124;
        r6 = (MarkdownAudioState) d(r4);
        goto L144
    L124:
        if (Intrinsics.areEqual(MarkdownAudioState.class, HeadingProps.class) == false) goto L127;
        r6 = (MarkdownAudioState) i(r4);
        goto L144
    L127:
        if (Intrinsics.areEqual(MarkdownAudioState.class, NumberTagProps.class) == false) goto L130;
        r6 = (MarkdownAudioState) p(r4);
        goto L144
    L130:
        if (Intrinsics.areEqual(MarkdownAudioState.class, AudioProps.class) == false) goto L133;
        r6 = (MarkdownAudioState) b(r4);
        goto L144
    L133:
        if (Intrinsics.areEqual(MarkdownAudioState.class, a.class) == false) goto L136;
        r6 = (MarkdownAudioState) n(r4);
        goto L144
    L136:
        if (Intrinsics.areEqual(MarkdownAudioState.class, MarkdownAudioState.class) == false) goto L139;
        r6 = o(r4);
        goto L144
    L139:
        if (Intrinsics.areEqual(MarkdownAudioState.class, MarkdownAudioBgPadding.class) == false) goto L142;
        r6 = (MarkdownAudioState) m(r4);
        goto L144
    L142:
        throw new IllegalArgumentException("unsupported type: " + MarkdownAudioState.class);
    L5:
        if (Intrinsics.areEqual(a.class, TextProps.class) == false) goto L8;
        r3 = (a) u(r2);
        goto L73
    L8:
        if (Intrinsics.areEqual(a.class, ContentProps.class) == false) goto L11;
        r3 = (a) f(r2);
        goto L73
    L11:
        if (Intrinsics.areEqual(a.class, AtProps.class) == false) goto L14;
        r3 = (a) a(r2);
        goto L73
    L14:
        if (Intrinsics.areEqual(a.class, LinkProps.class) == false) goto L17;
        r3 = (a) k(r2);
        goto L73
    L17:
        if (Intrinsics.areEqual(a.class, UDIconContentProps.class) == false) goto L20;
        r3 = (a) v(r2);
        goto L73
    L20:
        if (Intrinsics.areEqual(a.class, EmojProps.class) == false) goto L23;
        r3 = (a) h(r2);
        goto L73
    L23:
        if (Intrinsics.areEqual(a.class, PlainTextProps.class) == false) goto L26;
        r3 = (a) s(r2);
        goto L73
    L26:
        if (Intrinsics.areEqual(a.class, TagProps.class) == false) goto L29;
        r3 = (a) t(r2);
        goto L73
    L29:
        if (Intrinsics.areEqual(a.class, ListItem.class) == false) goto L32;
        r3 = (a) l(r2);
        goto L73
    L32:
        if (Intrinsics.areEqual(a.class, CardCodeBlockProps.class) == false) goto L35;
        r3 = (a) c(r2);
        goto L73
    L35:
        if (Intrinsics.areEqual(a.class, CardCodeBlockProps.b.class) == false) goto L38;
        r3 = (a) g(r2);
        goto L73
    L38:
        if (Intrinsics.areEqual(a.class, CardCodeBlockProps.b.a.class) == false) goto L41;
        r3 = (a) e(r2);
        goto L73
    L41:
        if (Intrinsics.areEqual(a.class, com.larksuite.component.card.component.image.a.class) == false) goto L44;
        r3 = (a) j(r2);
        goto L73
    L44:
        if (Intrinsics.areEqual(a.class, PersonProps.class) == false) goto L47;
        r3 = (a) r(r2);
        goto L73
    L47:
        if (Intrinsics.areEqual(a.class, Person.class) == false) goto L50;
        r3 = (a) q(r2);
        goto L73
    L50:
        if (Intrinsics.areEqual(a.class, ContainerPadding.class) == false) goto L53;
        r3 = (a) d(r2);
        goto L73
    L53:
        if (Intrinsics.areEqual(a.class, HeadingProps.class) == false) goto L56;
        r3 = (a) i(r2);
        goto L73
    L56:
        if (Intrinsics.areEqual(a.class, NumberTagProps.class) == false) goto L59;
        r3 = (a) p(r2);
        goto L73
    L59:
        if (Intrinsics.areEqual(a.class, AudioProps.class) == false) goto L62;
        r3 = (a) b(r2);
        goto L73
    L62:
        if (Intrinsics.areEqual(a.class, a.class) == false) goto L65;
        r3 = n(r2);
        goto L73
    L65:
        if (Intrinsics.areEqual(a.class, MarkdownAudioState.class) == false) goto L68;
        r3 = (a) o(r2);
        goto L73
    L68:
        if (Intrinsics.areEqual(a.class, MarkdownAudioBgPadding.class) == false) goto L71;
        r3 = (a) m(r2);
        goto L73
    L71:
        throw new IllegalArgumentException("unsupported type: " + a.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList] */
    public final HeadingProps i(ReadableMap r7) {
        ReadableArray r8 = com.larksuite.component.card.component.f.a(r7, "elements");
        if (r8 == null) goto L150;
        ?? r0 = new ArrayList();
        int r1 = r8.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L152;
        Object r5 = null;
        if (Intrinsics.areEqual(ContentProps.class, Boolean.TYPE) == false) goto L16;
        Boolean r3 = com.larksuite.component.card.component.f.b(r8, r2);
        if ((r3 instanceof ContentProps) == false) goto L12;
        r5 = r3;
    L12:
        ContentProps r6 = (ContentProps) r5;
        if (r6 == null) goto L149;
        r0.add(r6);
    L149:
        r2 = r2 + 1;
        goto L5
    L16:
        if (Intrinsics.areEqual(ContentProps.class, Double.TYPE) == false) goto L25;
        Double r4 = com.larksuite.component.card.component.f.f(r8, r2);
        if ((r4 instanceof ContentProps) == false) goto L21;
        r5 = r4;
    L21:
        ContentProps r9 = (ContentProps) r5;
        if (r9 == null) goto L149;
        r0.add(r9);
        goto L149
    L25:
        if (Intrinsics.areEqual(ContentProps.class, Byte.TYPE) == false) goto L34;
        Byte r10 = com.larksuite.component.card.component.f.d(r8, r2);
        if ((r10 instanceof ContentProps) == false) goto L30;
        r5 = r10;
    L30:
        ContentProps r11 = (ContentProps) r5;
        if (r11 == null) goto L149;
        r0.add(r11);
        goto L149
    L34:
        if (Intrinsics.areEqual(ContentProps.class, Short.TYPE) == false) goto L43;
        Short r12 = com.larksuite.component.card.component.f.l(r8, r2);
        if ((r12 instanceof ContentProps) == false) goto L39;
        r5 = r12;
    L39:
        ContentProps r13 = (ContentProps) r5;
        if (r13 == null) goto L149;
        r0.add(r13);
        goto L149
    L43:
        if (Intrinsics.areEqual(ContentProps.class, Long.TYPE) == false) goto L52;
        Long r14 = com.larksuite.component.card.component.f.i(r8, r2);
        if ((r14 instanceof ContentProps) == false) goto L48;
        r5 = r14;
    L48:
        ContentProps r15 = (ContentProps) r5;
        if (r15 == null) goto L149;
        r0.add(r15);
        goto L149
    L52:
        if (Intrinsics.areEqual(ContentProps.class, Character.TYPE) == false) goto L61;
        Character r16 = com.larksuite.component.card.component.f.e(r8, r2);
        if ((r16 instanceof ContentProps) == false) goto L57;
        r5 = r16;
    L57:
        ContentProps r17 = (ContentProps) r5;
        if (r17 == null) goto L149;
        r0.add(r17);
        goto L149
    L61:
        if (Intrinsics.areEqual(ContentProps.class, Integer.TYPE) == false) goto L70;
        Integer r19 = com.larksuite.component.card.component.f.g(r8, r2);
        if ((r19 instanceof ContentProps) == false) goto L66;
        r5 = r19;
    L66:
        ContentProps r20 = (ContentProps) r5;
        if (r20 == null) goto L149;
        r0.add(r20);
        goto L149
    L70:
        if (Intrinsics.areEqual(ContentProps.class, String.class) == false) goto L78;
        String r21 = com.larksuite.component.card.component.f.m(r8, r2);
        if ((r21 instanceof ContentProps) == false) goto L75;
        r5 = r21;
    L75:
        ContentProps r22 = (ContentProps) r5;
        if (r22 == null) goto L149;
        r0.add(r22);
        goto L149
    L78:
        ReadableMap r23 = com.larksuite.component.card.component.f.j(r8, r2);
        if (r23 == null) goto L149;
        if (Intrinsics.areEqual(ContentProps.class, TextProps.class) == false) goto L84;
        ContentProps r24 = (ContentProps) u(r23);
    L146:
        r0.add(r24);
        goto L149
    L84:
        if (Intrinsics.areEqual(ContentProps.class, ContentProps.class) == false) goto L87;
        r24 = f(r23);
        goto L146
    L87:
        if (Intrinsics.areEqual(ContentProps.class, AtProps.class) == false) goto L90;
        r24 = (ContentProps) a(r23);
        goto L146
    L90:
        if (Intrinsics.areEqual(ContentProps.class, LinkProps.class) == false) goto L93;
        r24 = (ContentProps) k(r23);
        goto L146
    L93:
        if (Intrinsics.areEqual(ContentProps.class, UDIconContentProps.class) == false) goto L96;
        r24 = (ContentProps) v(r23);
        goto L146
    L96:
        if (Intrinsics.areEqual(ContentProps.class, EmojProps.class) == false) goto L99;
        r24 = (ContentProps) h(r23);
        goto L146
    L99:
        if (Intrinsics.areEqual(ContentProps.class, PlainTextProps.class) == false) goto L102;
        r24 = (ContentProps) s(r23);
        goto L146
    L102:
        if (Intrinsics.areEqual(ContentProps.class, TagProps.class) == false) goto L105;
        r24 = (ContentProps) t(r23);
        goto L146
    L105:
        if (Intrinsics.areEqual(ContentProps.class, ListItem.class) == false) goto L108;
        r24 = (ContentProps) l(r23);
        goto L146
    L108:
        if (Intrinsics.areEqual(ContentProps.class, CardCodeBlockProps.class) == false) goto L111;
        r24 = (ContentProps) c(r23);
        goto L146
    L111:
        if (Intrinsics.areEqual(ContentProps.class, CardCodeBlockProps.b.class) == false) goto L114;
        r24 = (ContentProps) g(r23);
        goto L146
    L114:
        if (Intrinsics.areEqual(ContentProps.class, CardCodeBlockProps.b.a.class) == false) goto L117;
        r24 = (ContentProps) e(r23);
        goto L146
    L117:
        if (Intrinsics.areEqual(ContentProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L120;
        r24 = (ContentProps) j(r23);
        goto L146
    L120:
        if (Intrinsics.areEqual(ContentProps.class, PersonProps.class) == false) goto L123;
        r24 = (ContentProps) r(r23);
        goto L146
    L123:
        if (Intrinsics.areEqual(ContentProps.class, Person.class) == false) goto L126;
        r24 = (ContentProps) q(r23);
        goto L146
    L126:
        if (Intrinsics.areEqual(ContentProps.class, ContainerPadding.class) == false) goto L129;
        r24 = (ContentProps) d(r23);
        goto L146
    L129:
        if (Intrinsics.areEqual(ContentProps.class, HeadingProps.class) == false) goto L132;
        r24 = (ContentProps) i(r23);
        goto L146
    L132:
        if (Intrinsics.areEqual(ContentProps.class, NumberTagProps.class) == false) goto L135;
        r24 = (ContentProps) p(r23);
        goto L146
    L135:
        if (Intrinsics.areEqual(ContentProps.class, AudioProps.class) == false) goto L138;
        r24 = (ContentProps) b(r23);
        goto L146
    L138:
        if (Intrinsics.areEqual(ContentProps.class, a.class) == false) goto L141;
        r24 = (ContentProps) n(r23);
        goto L146
    L141:
        if (Intrinsics.areEqual(ContentProps.class, MarkdownAudioState.class) == false) goto L144;
        r24 = (ContentProps) o(r23);
        goto L146
    L144:
        if (Intrinsics.areEqual(ContentProps.class, MarkdownAudioBgPadding.class) == false) goto L148;
        r24 = (ContentProps) m(r23);
        goto L146
    L148:
        throw new IllegalArgumentException("unsupported type: " + ContentProps.class);
    L152:
        return new HeadingProps(r0);
    L150:
        r0 = r.getElements();
        goto L152
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.List] */
    public final LinkProps k(ReadableMap r15) {
        LinkProps r0 = e;
        String r4 = com.larksuite.component.card.component.f.n(r15, "url", r0.getUrl());
        String r5 = com.larksuite.component.card.component.f.n(r15, "androidUrl", r0.getAndroidUrl());
        ReadableMap r1 = com.larksuite.component.card.component.f.k(r15, "icon");
        if (r1 != null) goto L5;
        UDIconContentProps r2 = r0.getIcon();
    L73:
        UDIconContentProps r6 = r2;
        Integer r7 = com.larksuite.component.card.component.f.h(r15, "textSize", r0.getTextSize());
        String r8 = com.larksuite.component.card.component.f.n(r15, "textColor", r0.getTextColor());
        String r9 = com.larksuite.component.card.component.f.n(r15, "textBgColor", r0.getTextBgColor());
        ReadableArray r3 = com.larksuite.component.card.component.f.a(r15, "textDecoration");
        if (r3 == null) goto L220;
        ?? r10 = new ArrayList();
        int r11 = r3.size();
        int r12 = 0;
    L76:
        if (r12 >= r11) goto L221;
        Object r13 = null;
        if (Intrinsics.areEqual(String.class, Boolean.TYPE) == false) goto L87;
        Boolean r14 = com.larksuite.component.card.component.f.b(r3, r12);
        if ((r14 instanceof String) == false) goto L83;
        r13 = r14;
    L83:
        String r16 = (String) r13;
        if (r16 == null) goto L219;
        r10.add(r16);
    L219:
        r12 = r12 + 1;
        goto L76
    L87:
        if (Intrinsics.areEqual(String.class, Double.TYPE) == false) goto L96;
        Double r17 = com.larksuite.component.card.component.f.f(r3, r12);
        if ((r17 instanceof String) == false) goto L92;
        r13 = r17;
    L92:
        String r19 = (String) r13;
        if (r19 == null) goto L219;
        r10.add(r19);
        goto L219
    L96:
        if (Intrinsics.areEqual(String.class, Byte.TYPE) == false) goto L105;
        Byte r110 = com.larksuite.component.card.component.f.d(r3, r12);
        if ((r110 instanceof String) == false) goto L101;
        r13 = r110;
    L101:
        String r111 = (String) r13;
        if (r111 == null) goto L219;
        r10.add(r111);
        goto L219
    L105:
        if (Intrinsics.areEqual(String.class, Short.TYPE) == false) goto L114;
        Short r112 = com.larksuite.component.card.component.f.l(r3, r12);
        if ((r112 instanceof String) == false) goto L110;
        r13 = r112;
    L110:
        String r113 = (String) r13;
        if (r113 == null) goto L219;
        r10.add(r113);
        goto L219
    L114:
        if (Intrinsics.areEqual(String.class, Long.TYPE) == false) goto L123;
        Long r114 = com.larksuite.component.card.component.f.i(r3, r12);
        if ((r114 instanceof String) == false) goto L119;
        r13 = r114;
    L119:
        String r115 = (String) r13;
        if (r115 == null) goto L219;
        r10.add(r115);
        goto L219
    L123:
        if (Intrinsics.areEqual(String.class, Character.TYPE) == false) goto L132;
        Character r116 = com.larksuite.component.card.component.f.e(r3, r12);
        if ((r116 instanceof String) == false) goto L128;
        r13 = r116;
    L128:
        String r117 = (String) r13;
        if (r117 == null) goto L219;
        r10.add(r117);
        goto L219
    L132:
        if (Intrinsics.areEqual(String.class, Integer.TYPE) == false) goto L141;
        Integer r118 = com.larksuite.component.card.component.f.g(r3, r12);
        if ((r118 instanceof String) == false) goto L137;
        r13 = r118;
    L137:
        String r119 = (String) r13;
        if (r119 == null) goto L219;
        r10.add(r119);
        goto L219
    L141:
        if (Intrinsics.areEqual(String.class, String.class) == false) goto L148;
        String r120 = com.larksuite.component.card.component.f.m(r3, r12);
        if ((r120 instanceof String) == false) goto L146;
        r13 = r120;
    L146:
        if (r13 == null) goto L219;
        r10.add(r13);
        goto L219
    L148:
        ReadableMap r121 = com.larksuite.component.card.component.f.j(r3, r12);
        if (r121 == null) goto L219;
        if (Intrinsics.areEqual(String.class, TextProps.class) == false) goto L154;
        String r122 = (String) u(r121);
    L216:
        r10.add(r122);
        goto L219
    L154:
        if (Intrinsics.areEqual(String.class, ContentProps.class) == false) goto L157;
        r122 = (String) f(r121);
        goto L216
    L157:
        if (Intrinsics.areEqual(String.class, AtProps.class) == false) goto L160;
        r122 = (String) a(r121);
        goto L216
    L160:
        if (Intrinsics.areEqual(String.class, LinkProps.class) == false) goto L163;
        r122 = (String) k(r121);
        goto L216
    L163:
        if (Intrinsics.areEqual(String.class, UDIconContentProps.class) == false) goto L166;
        r122 = (String) v(r121);
        goto L216
    L166:
        if (Intrinsics.areEqual(String.class, EmojProps.class) == false) goto L169;
        r122 = (String) h(r121);
        goto L216
    L169:
        if (Intrinsics.areEqual(String.class, PlainTextProps.class) == false) goto L172;
        r122 = (String) s(r121);
        goto L216
    L172:
        if (Intrinsics.areEqual(String.class, TagProps.class) == false) goto L175;
        r122 = (String) t(r121);
        goto L216
    L175:
        if (Intrinsics.areEqual(String.class, ListItem.class) == false) goto L178;
        r122 = (String) l(r121);
        goto L216
    L178:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.class) == false) goto L181;
        r122 = (String) c(r121);
        goto L216
    L181:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.class) == false) goto L184;
        r122 = (String) g(r121);
        goto L216
    L184:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.a.class) == false) goto L187;
        r122 = (String) e(r121);
        goto L216
    L187:
        if (Intrinsics.areEqual(String.class, com.larksuite.component.card.component.image.a.class) == false) goto L190;
        r122 = (String) j(r121);
        goto L216
    L190:
        if (Intrinsics.areEqual(String.class, PersonProps.class) == false) goto L193;
        r122 = (String) r(r121);
        goto L216
    L193:
        if (Intrinsics.areEqual(String.class, Person.class) == false) goto L196;
        r122 = (String) q(r121);
        goto L216
    L196:
        if (Intrinsics.areEqual(String.class, ContainerPadding.class) == false) goto L199;
        r122 = (String) d(r121);
        goto L216
    L199:
        if (Intrinsics.areEqual(String.class, HeadingProps.class) == false) goto L202;
        r122 = (String) i(r121);
        goto L216
    L202:
        if (Intrinsics.areEqual(String.class, NumberTagProps.class) == false) goto L205;
        r122 = (String) p(r121);
        goto L216
    L205:
        if (Intrinsics.areEqual(String.class, AudioProps.class) == false) goto L208;
        r122 = (String) b(r121);
        goto L216
    L208:
        if (Intrinsics.areEqual(String.class, a.class) == false) goto L211;
        r122 = (String) n(r121);
        goto L216
    L211:
        if (Intrinsics.areEqual(String.class, MarkdownAudioState.class) == false) goto L214;
        r122 = (String) o(r121);
        goto L216
    L214:
        if (Intrinsics.areEqual(String.class, MarkdownAudioBgPadding.class) == false) goto L218;
        r122 = (String) m(r121);
        goto L216
    L218:
        throw new IllegalArgumentException("unsupported type: " + String.class);
    L221:
        ?? r123 = r10;
        LinkProps r20 = e;
        String r21 = com.larksuite.component.card.component.f.n(r15, "content", r20.getContent());
        if (r21 != null) goto L224;
        r21 = r20.getContent();
    L224:
        String r124 = r21;
        Integer r125 = com.larksuite.component.card.component.f.h(r15, "maxLines", Integer.valueOf(r20.getMaxLines()));
        if (r125 == null) goto L227;
        int r126 = r125.intValue();
    L229:
        return new LinkProps(r4, r5, r6, r7, r8, r9, r123, r124, r126);
    L227:
        r126 = r20.getMaxLines();
        goto L229
    L220:
        r10 = r0.getTextDecoration();
        goto L221
    L5:
        if (Intrinsics.areEqual(UDIconContentProps.class, TextProps.class) == false) goto L8;
        r2 = (UDIconContentProps) u(r1);
        goto L73
    L8:
        if (Intrinsics.areEqual(UDIconContentProps.class, ContentProps.class) == false) goto L11;
        r2 = (UDIconContentProps) f(r1);
        goto L73
    L11:
        if (Intrinsics.areEqual(UDIconContentProps.class, AtProps.class) == false) goto L14;
        r2 = (UDIconContentProps) a(r1);
        goto L73
    L14:
        if (Intrinsics.areEqual(UDIconContentProps.class, LinkProps.class) == false) goto L17;
        r2 = (UDIconContentProps) k(r1);
        goto L73
    L17:
        if (Intrinsics.areEqual(UDIconContentProps.class, UDIconContentProps.class) == false) goto L20;
        r2 = v(r1);
        goto L73
    L20:
        if (Intrinsics.areEqual(UDIconContentProps.class, EmojProps.class) == false) goto L23;
        r2 = (UDIconContentProps) h(r1);
        goto L73
    L23:
        if (Intrinsics.areEqual(UDIconContentProps.class, PlainTextProps.class) == false) goto L26;
        r2 = (UDIconContentProps) s(r1);
        goto L73
    L26:
        if (Intrinsics.areEqual(UDIconContentProps.class, TagProps.class) == false) goto L29;
        r2 = (UDIconContentProps) t(r1);
        goto L73
    L29:
        if (Intrinsics.areEqual(UDIconContentProps.class, ListItem.class) == false) goto L32;
        r2 = (UDIconContentProps) l(r1);
        goto L73
    L32:
        if (Intrinsics.areEqual(UDIconContentProps.class, CardCodeBlockProps.class) == false) goto L35;
        r2 = (UDIconContentProps) c(r1);
        goto L73
    L35:
        if (Intrinsics.areEqual(UDIconContentProps.class, CardCodeBlockProps.b.class) == false) goto L38;
        r2 = (UDIconContentProps) g(r1);
        goto L73
    L38:
        if (Intrinsics.areEqual(UDIconContentProps.class, CardCodeBlockProps.b.a.class) == false) goto L41;
        r2 = (UDIconContentProps) e(r1);
        goto L73
    L41:
        if (Intrinsics.areEqual(UDIconContentProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L44;
        r2 = (UDIconContentProps) j(r1);
        goto L73
    L44:
        if (Intrinsics.areEqual(UDIconContentProps.class, PersonProps.class) == false) goto L47;
        r2 = (UDIconContentProps) r(r1);
        goto L73
    L47:
        if (Intrinsics.areEqual(UDIconContentProps.class, Person.class) == false) goto L50;
        r2 = (UDIconContentProps) q(r1);
        goto L73
    L50:
        if (Intrinsics.areEqual(UDIconContentProps.class, ContainerPadding.class) == false) goto L53;
        r2 = (UDIconContentProps) d(r1);
        goto L73
    L53:
        if (Intrinsics.areEqual(UDIconContentProps.class, HeadingProps.class) == false) goto L56;
        r2 = (UDIconContentProps) i(r1);
        goto L73
    L56:
        if (Intrinsics.areEqual(UDIconContentProps.class, NumberTagProps.class) == false) goto L59;
        r2 = (UDIconContentProps) p(r1);
        goto L73
    L59:
        if (Intrinsics.areEqual(UDIconContentProps.class, AudioProps.class) == false) goto L62;
        r2 = (UDIconContentProps) b(r1);
        goto L73
    L62:
        if (Intrinsics.areEqual(UDIconContentProps.class, a.class) == false) goto L65;
        r2 = (UDIconContentProps) n(r1);
        goto L73
    L65:
        if (Intrinsics.areEqual(UDIconContentProps.class, MarkdownAudioState.class) == false) goto L68;
        r2 = (UDIconContentProps) o(r1);
        goto L73
    L68:
        if (Intrinsics.areEqual(UDIconContentProps.class, MarkdownAudioBgPadding.class) == false) goto L71;
        r2 = (UDIconContentProps) m(r1);
        goto L73
    L71:
        throw new IllegalArgumentException("unsupported type: " + UDIconContentProps.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList] */
    public final ListItem l(ReadableMap r10) {
        ListItem r0 = j;
        Integer r1 = com.larksuite.component.card.component.f.h(r10, "level", Integer.valueOf(r0.getLevel()));
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        String r3 = com.larksuite.component.card.component.f.n(r10, "type", r0.getType());
        if (r3 != null) goto L9;
        r3 = r0.getType();
    L9:
        ReadableArray r4 = com.larksuite.component.card.component.f.a(r10, "items");
        if (r4 == null) goto L157;
        ?? r5 = new ArrayList();
        int r6 = r4.size();
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L159;
        Object r8 = null;
        if (Intrinsics.areEqual(ContentProps.class, Boolean.TYPE) == false) goto L23;
        Boolean r9 = com.larksuite.component.card.component.f.b(r4, r7);
        if ((r9 instanceof ContentProps) == false) goto L19;
        r8 = r9;
    L19:
        ContentProps r11 = (ContentProps) r8;
        if (r11 == null) goto L156;
        r5.add(r11);
    L156:
        r7 = r7 + 1;
        goto L12
    L23:
        if (Intrinsics.areEqual(ContentProps.class, Double.TYPE) == false) goto L32;
        Double r12 = com.larksuite.component.card.component.f.f(r4, r7);
        if ((r12 instanceof ContentProps) == false) goto L28;
        r8 = r12;
    L28:
        ContentProps r13 = (ContentProps) r8;
        if (r13 == null) goto L156;
        r5.add(r13);
        goto L156
    L32:
        if (Intrinsics.areEqual(ContentProps.class, Byte.TYPE) == false) goto L41;
        Byte r14 = com.larksuite.component.card.component.f.d(r4, r7);
        if ((r14 instanceof ContentProps) == false) goto L37;
        r8 = r14;
    L37:
        ContentProps r15 = (ContentProps) r8;
        if (r15 == null) goto L156;
        r5.add(r15);
        goto L156
    L41:
        if (Intrinsics.areEqual(ContentProps.class, Short.TYPE) == false) goto L50;
        Short r16 = com.larksuite.component.card.component.f.l(r4, r7);
        if ((r16 instanceof ContentProps) == false) goto L46;
        r8 = r16;
    L46:
        ContentProps r17 = (ContentProps) r8;
        if (r17 == null) goto L156;
        r5.add(r17);
        goto L156
    L50:
        if (Intrinsics.areEqual(ContentProps.class, Long.TYPE) == false) goto L59;
        Long r19 = com.larksuite.component.card.component.f.i(r4, r7);
        if ((r19 instanceof ContentProps) == false) goto L55;
        r8 = r19;
    L55:
        ContentProps r20 = (ContentProps) r8;
        if (r20 == null) goto L156;
        r5.add(r20);
        goto L156
    L59:
        if (Intrinsics.areEqual(ContentProps.class, Character.TYPE) == false) goto L68;
        Character r21 = com.larksuite.component.card.component.f.e(r4, r7);
        if ((r21 instanceof ContentProps) == false) goto L64;
        r8 = r21;
    L64:
        ContentProps r22 = (ContentProps) r8;
        if (r22 == null) goto L156;
        r5.add(r22);
        goto L156
    L68:
        if (Intrinsics.areEqual(ContentProps.class, Integer.TYPE) == false) goto L77;
        Integer r23 = com.larksuite.component.card.component.f.g(r4, r7);
        if ((r23 instanceof ContentProps) == false) goto L73;
        r8 = r23;
    L73:
        ContentProps r24 = (ContentProps) r8;
        if (r24 == null) goto L156;
        r5.add(r24);
        goto L156
    L77:
        if (Intrinsics.areEqual(ContentProps.class, String.class) == false) goto L85;
        String r25 = com.larksuite.component.card.component.f.m(r4, r7);
        if ((r25 instanceof ContentProps) == false) goto L82;
        r8 = r25;
    L82:
        ContentProps r26 = (ContentProps) r8;
        if (r26 == null) goto L156;
        r5.add(r26);
        goto L156
    L85:
        ReadableMap r27 = com.larksuite.component.card.component.f.j(r4, r7);
        if (r27 == null) goto L156;
        if (Intrinsics.areEqual(ContentProps.class, TextProps.class) == false) goto L91;
        ContentProps r29 = (ContentProps) u(r27);
    L153:
        r5.add(r29);
        goto L156
    L91:
        if (Intrinsics.areEqual(ContentProps.class, ContentProps.class) == false) goto L94;
        r29 = f(r27);
        goto L153
    L94:
        if (Intrinsics.areEqual(ContentProps.class, AtProps.class) == false) goto L97;
        r29 = (ContentProps) a(r27);
        goto L153
    L97:
        if (Intrinsics.areEqual(ContentProps.class, LinkProps.class) == false) goto L100;
        r29 = (ContentProps) k(r27);
        goto L153
    L100:
        if (Intrinsics.areEqual(ContentProps.class, UDIconContentProps.class) == false) goto L103;
        r29 = (ContentProps) v(r27);
        goto L153
    L103:
        if (Intrinsics.areEqual(ContentProps.class, EmojProps.class) == false) goto L106;
        r29 = (ContentProps) h(r27);
        goto L153
    L106:
        if (Intrinsics.areEqual(ContentProps.class, PlainTextProps.class) == false) goto L109;
        r29 = (ContentProps) s(r27);
        goto L153
    L109:
        if (Intrinsics.areEqual(ContentProps.class, TagProps.class) == false) goto L112;
        r29 = (ContentProps) t(r27);
        goto L153
    L112:
        if (Intrinsics.areEqual(ContentProps.class, ListItem.class) == false) goto L115;
        r29 = (ContentProps) l(r27);
        goto L153
    L115:
        if (Intrinsics.areEqual(ContentProps.class, CardCodeBlockProps.class) == false) goto L118;
        r29 = (ContentProps) c(r27);
        goto L153
    L118:
        if (Intrinsics.areEqual(ContentProps.class, CardCodeBlockProps.b.class) == false) goto L121;
        r29 = (ContentProps) g(r27);
        goto L153
    L121:
        if (Intrinsics.areEqual(ContentProps.class, CardCodeBlockProps.b.a.class) == false) goto L124;
        r29 = (ContentProps) e(r27);
        goto L153
    L124:
        if (Intrinsics.areEqual(ContentProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L127;
        r29 = (ContentProps) j(r27);
        goto L153
    L127:
        if (Intrinsics.areEqual(ContentProps.class, PersonProps.class) == false) goto L130;
        r29 = (ContentProps) r(r27);
        goto L153
    L130:
        if (Intrinsics.areEqual(ContentProps.class, Person.class) == false) goto L133;
        r29 = (ContentProps) q(r27);
        goto L153
    L133:
        if (Intrinsics.areEqual(ContentProps.class, ContainerPadding.class) == false) goto L136;
        r29 = (ContentProps) d(r27);
        goto L153
    L136:
        if (Intrinsics.areEqual(ContentProps.class, HeadingProps.class) == false) goto L139;
        r29 = (ContentProps) i(r27);
        goto L153
    L139:
        if (Intrinsics.areEqual(ContentProps.class, NumberTagProps.class) == false) goto L142;
        r29 = (ContentProps) p(r27);
        goto L153
    L142:
        if (Intrinsics.areEqual(ContentProps.class, AudioProps.class) == false) goto L145;
        r29 = (ContentProps) b(r27);
        goto L153
    L145:
        if (Intrinsics.areEqual(ContentProps.class, a.class) == false) goto L148;
        r29 = (ContentProps) n(r27);
        goto L153
    L148:
        if (Intrinsics.areEqual(ContentProps.class, MarkdownAudioState.class) == false) goto L151;
        r29 = (ContentProps) o(r27);
        goto L153
    L151:
        if (Intrinsics.areEqual(ContentProps.class, MarkdownAudioBgPadding.class) == false) goto L155;
        r29 = (ContentProps) m(r27);
        goto L153
    L155:
        throw new IllegalArgumentException("unsupported type: " + ContentProps.class);
    L159:
        return new ListItem(r2, r3, r5, com.larksuite.component.card.component.f.h(r10, "order", j.getOrder()));
    L157:
        r5 = r0.getItems();
        goto L159
    L5:
        r2 = r0.getLevel();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List] */
    public final NumberTagProps p(ReadableMap r15) {
        NumberTagProps r0 = s;
        String r4 = com.larksuite.component.card.component.f.n(r15, "url", r0.getUrl());
        Integer r1 = com.larksuite.component.card.component.f.h(r15, "originalTextSize", Integer.valueOf(r0.getOriginalTextSize()));
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        int r5 = r2;
        Integer r3 = com.larksuite.component.card.component.f.h(r15, "circleSize", Integer.valueOf(r0.getCircleSize()));
        if (r3 == null) goto L9;
        int r6 = r3.intValue();
    L10:
        int r7 = r6;
        String r8 = com.larksuite.component.card.component.f.n(r15, "tagBgColor", r0.getTagBgColor());
        Integer r9 = com.larksuite.component.card.component.f.h(r15, "textSize", r0.getTextSize());
        String r10 = com.larksuite.component.card.component.f.n(r15, "textColor", r0.getTextColor());
        String r11 = com.larksuite.component.card.component.f.n(r15, "textBgColor", r0.getTextBgColor());
        ReadableArray r12 = com.larksuite.component.card.component.f.a(r15, "textDecoration");
        if (r12 == null) goto L157;
        ?? r13 = new ArrayList();
        int r14 = r12.size();
        int r16 = 0;
    L13:
        if (r16 >= r14) goto L158;
        Object r17 = null;
        if (Intrinsics.areEqual(String.class, Boolean.TYPE) == false) goto L24;
        Boolean r19 = com.larksuite.component.card.component.f.b(r12, r16);
        if ((r19 instanceof String) == false) goto L20;
        r17 = r19;
    L20:
        String r110 = (String) r17;
        if (r110 == null) goto L156;
        r13.add(r110);
    L156:
        r16 = r16 + 1;
        goto L13
    L24:
        if (Intrinsics.areEqual(String.class, Double.TYPE) == false) goto L33;
        Double r111 = com.larksuite.component.card.component.f.f(r12, r16);
        if ((r111 instanceof String) == false) goto L29;
        r17 = r111;
    L29:
        String r112 = (String) r17;
        if (r112 == null) goto L156;
        r13.add(r112);
        goto L156
    L33:
        if (Intrinsics.areEqual(String.class, Byte.TYPE) == false) goto L42;
        Byte r113 = com.larksuite.component.card.component.f.d(r12, r16);
        if ((r113 instanceof String) == false) goto L38;
        r17 = r113;
    L38:
        String r114 = (String) r17;
        if (r114 == null) goto L156;
        r13.add(r114);
        goto L156
    L42:
        if (Intrinsics.areEqual(String.class, Short.TYPE) == false) goto L51;
        Short r115 = com.larksuite.component.card.component.f.l(r12, r16);
        if ((r115 instanceof String) == false) goto L47;
        r17 = r115;
    L47:
        String r116 = (String) r17;
        if (r116 == null) goto L156;
        r13.add(r116);
        goto L156
    L51:
        if (Intrinsics.areEqual(String.class, Long.TYPE) == false) goto L60;
        Long r117 = com.larksuite.component.card.component.f.i(r12, r16);
        if ((r117 instanceof String) == false) goto L56;
        r17 = r117;
    L56:
        String r118 = (String) r17;
        if (r118 == null) goto L156;
        r13.add(r118);
        goto L156
    L60:
        if (Intrinsics.areEqual(String.class, Character.TYPE) == false) goto L69;
        Character r119 = com.larksuite.component.card.component.f.e(r12, r16);
        if ((r119 instanceof String) == false) goto L65;
        r17 = r119;
    L65:
        String r120 = (String) r17;
        if (r120 == null) goto L156;
        r13.add(r120);
        goto L156
    L69:
        if (Intrinsics.areEqual(String.class, Integer.TYPE) == false) goto L78;
        Integer r121 = com.larksuite.component.card.component.f.g(r12, r16);
        if ((r121 instanceof String) == false) goto L74;
        r17 = r121;
    L74:
        String r122 = (String) r17;
        if (r122 == null) goto L156;
        r13.add(r122);
        goto L156
    L78:
        if (Intrinsics.areEqual(String.class, String.class) == false) goto L85;
        String r123 = com.larksuite.component.card.component.f.m(r12, r16);
        if ((r123 instanceof String) == false) goto L83;
        r17 = r123;
    L83:
        if (r17 == null) goto L156;
        r13.add(r17);
        goto L156
    L85:
        ReadableMap r124 = com.larksuite.component.card.component.f.j(r12, r16);
        if (r124 == null) goto L156;
        if (Intrinsics.areEqual(String.class, TextProps.class) == false) goto L91;
        String r125 = (String) u(r124);
    L153:
        r13.add(r125);
        goto L156
    L91:
        if (Intrinsics.areEqual(String.class, ContentProps.class) == false) goto L94;
        r125 = (String) f(r124);
        goto L153
    L94:
        if (Intrinsics.areEqual(String.class, AtProps.class) == false) goto L97;
        r125 = (String) a(r124);
        goto L153
    L97:
        if (Intrinsics.areEqual(String.class, LinkProps.class) == false) goto L100;
        r125 = (String) k(r124);
        goto L153
    L100:
        if (Intrinsics.areEqual(String.class, UDIconContentProps.class) == false) goto L103;
        r125 = (String) v(r124);
        goto L153
    L103:
        if (Intrinsics.areEqual(String.class, EmojProps.class) == false) goto L106;
        r125 = (String) h(r124);
        goto L153
    L106:
        if (Intrinsics.areEqual(String.class, PlainTextProps.class) == false) goto L109;
        r125 = (String) s(r124);
        goto L153
    L109:
        if (Intrinsics.areEqual(String.class, TagProps.class) == false) goto L112;
        r125 = (String) t(r124);
        goto L153
    L112:
        if (Intrinsics.areEqual(String.class, ListItem.class) == false) goto L115;
        r125 = (String) l(r124);
        goto L153
    L115:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.class) == false) goto L118;
        r125 = (String) c(r124);
        goto L153
    L118:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.class) == false) goto L121;
        r125 = (String) g(r124);
        goto L153
    L121:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.a.class) == false) goto L124;
        r125 = (String) e(r124);
        goto L153
    L124:
        if (Intrinsics.areEqual(String.class, com.larksuite.component.card.component.image.a.class) == false) goto L127;
        r125 = (String) j(r124);
        goto L153
    L127:
        if (Intrinsics.areEqual(String.class, PersonProps.class) == false) goto L130;
        r125 = (String) r(r124);
        goto L153
    L130:
        if (Intrinsics.areEqual(String.class, Person.class) == false) goto L133;
        r125 = (String) q(r124);
        goto L153
    L133:
        if (Intrinsics.areEqual(String.class, ContainerPadding.class) == false) goto L136;
        r125 = (String) d(r124);
        goto L153
    L136:
        if (Intrinsics.areEqual(String.class, HeadingProps.class) == false) goto L139;
        r125 = (String) i(r124);
        goto L153
    L139:
        if (Intrinsics.areEqual(String.class, NumberTagProps.class) == false) goto L142;
        r125 = (String) p(r124);
        goto L153
    L142:
        if (Intrinsics.areEqual(String.class, AudioProps.class) == false) goto L145;
        r125 = (String) b(r124);
        goto L153
    L145:
        if (Intrinsics.areEqual(String.class, a.class) == false) goto L148;
        r125 = (String) n(r124);
        goto L153
    L148:
        if (Intrinsics.areEqual(String.class, MarkdownAudioState.class) == false) goto L151;
        r125 = (String) o(r124);
        goto L153
    L151:
        if (Intrinsics.areEqual(String.class, MarkdownAudioBgPadding.class) == false) goto L155;
        r125 = (String) m(r124);
        goto L153
    L155:
        throw new IllegalArgumentException("unsupported type: " + String.class);
    L158:
        ?? r126 = r13;
        NumberTagProps r20 = s;
        String r21 = com.larksuite.component.card.component.f.n(r15, "content", r20.getContent());
        if (r21 != null) goto L161;
        r21 = r20.getContent();
    L161:
        String r127 = r21;
        Integer r128 = com.larksuite.component.card.component.f.h(r15, "maxLines", Integer.valueOf(r20.getMaxLines()));
        if (r128 == null) goto L164;
        int r129 = r128.intValue();
    L166:
        return new NumberTagProps(r4, r5, r7, r8, r9, r10, r11, r126, r127, r129);
    L164:
        r129 = r20.getMaxLines();
        goto L166
    L157:
        r13 = r0.getTextDecoration();
        goto L158
    L9:
        r6 = r0.getCircleSize();
        goto L10
    L5:
        r2 = r0.getOriginalTextSize();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.ArrayList] */
    public final PersonProps r(ReadableMap r19) {
        ReadableMap r2 = com.larksuite.component.card.component.f.k(r19, "person");
        if (r2 != null) goto L5;
        Person r3 = o.getPerson();
    L73:
        Person r5 = r3;
        PersonProps r4 = o;
        Boolean r6 = com.larksuite.component.card.component.f.c(r19, "showAvatar", Boolean.valueOf(r4.getShowAvatar()));
        if (r6 == null) goto L76;
        boolean r7 = r6.booleanValue();
    L77:
        boolean r8 = r7;
        Boolean r9 = com.larksuite.component.card.component.f.c(r19, "showName", Boolean.valueOf(r4.getShowName()));
        if (r9 == null) goto L80;
        boolean r10 = r9.booleanValue();
    L81:
        boolean r11 = r10;
        String r12 = com.larksuite.component.card.component.f.n(r19, "type", r4.getType());
        ReadableMap r13 = com.larksuite.component.card.component.f.k(r19, "containerPadding");
        if (r13 != null) goto L84;
        ContainerPadding r14 = r4.getContainerPadding();
    L152:
        ContainerPadding r15 = r14;
        Integer r16 = com.larksuite.component.card.component.f.h(r19, "textSize", r4.getTextSize());
        String r17 = com.larksuite.component.card.component.f.n(r19, "textColor", r4.getTextColor());
        String r110 = com.larksuite.component.card.component.f.n(r19, "textBgColor", r4.getTextBgColor());
        ReadableArray r20 = com.larksuite.component.card.component.f.a(r19, "textDecoration");
        if (r20 == null) goto L299;
        ?? r21 = new ArrayList();
        int r111 = r20.size();
        int r112 = 0;
    L155:
        if (r112 >= r111) goto L300;
        int r113 = r111;
        Object r114 = null;
        if (Intrinsics.areEqual(String.class, Boolean.TYPE) == false) goto L167;
        Boolean r115 = com.larksuite.component.card.component.f.b(r20, r112);
        if ((r115 instanceof String) == false) goto L162;
        r114 = r115;
    L162:
        String r116 = (String) r114;
        if (r116 == null) goto L298;
        r21.add(r116);
    L298:
        r112 = r112 + 1;
        r111 = r113;
        r20 = r20;
        goto L155
    L167:
        if (Intrinsics.areEqual(String.class, Double.TYPE) == false) goto L176;
        Double r117 = com.larksuite.component.card.component.f.f(r20, r112);
        if ((r117 instanceof String) == false) goto L172;
        r114 = r117;
    L172:
        String r118 = (String) r114;
        if (r118 == null) goto L298;
        r21.add(r118);
        goto L298
    L176:
        if (Intrinsics.areEqual(String.class, Byte.TYPE) == false) goto L185;
        Byte r119 = com.larksuite.component.card.component.f.d(r20, r112);
        if ((r119 instanceof String) == false) goto L181;
        r114 = r119;
    L181:
        String r120 = (String) r114;
        if (r120 == null) goto L298;
        r21.add(r120);
        goto L298
    L185:
        if (Intrinsics.areEqual(String.class, Short.TYPE) == false) goto L194;
        Short r121 = com.larksuite.component.card.component.f.l(r20, r112);
        if ((r121 instanceof String) == false) goto L190;
        r114 = r121;
    L190:
        String r122 = (String) r114;
        if (r122 == null) goto L298;
        r21.add(r122);
        goto L298
    L194:
        if (Intrinsics.areEqual(String.class, Long.TYPE) == false) goto L203;
        Long r123 = com.larksuite.component.card.component.f.i(r20, r112);
        if ((r123 instanceof String) == false) goto L199;
        r114 = r123;
    L199:
        String r124 = (String) r114;
        if (r124 == null) goto L298;
        r21.add(r124);
        goto L298
    L203:
        if (Intrinsics.areEqual(String.class, Character.TYPE) == false) goto L212;
        Character r125 = com.larksuite.component.card.component.f.e(r20, r112);
        if ((r125 instanceof String) == false) goto L208;
        r114 = r125;
    L208:
        String r126 = (String) r114;
        if (r126 == null) goto L298;
        r21.add(r126);
        goto L298
    L212:
        if (Intrinsics.areEqual(String.class, Integer.TYPE) == false) goto L221;
        Integer r127 = com.larksuite.component.card.component.f.g(r20, r112);
        if ((r127 instanceof String) == false) goto L217;
        r114 = r127;
    L217:
        String r128 = (String) r114;
        if (r128 == null) goto L298;
        r21.add(r128);
        goto L298
    L221:
        if (Intrinsics.areEqual(String.class, String.class) == false) goto L227;
        String r129 = com.larksuite.component.card.component.f.m(r20, r112);
        if ((r129 instanceof String) == true) goto L225;
        r129 = null;
    L225:
        if (r129 == null) goto L298;
        r21.add(r129);
        goto L298
    L227:
        ReadableMap r130 = com.larksuite.component.card.component.f.j(r20, r112);
        if (r130 == null) goto L298;
        if (Intrinsics.areEqual(String.class, TextProps.class) == false) goto L233;
        String r22 = (String) u(r130);
    L295:
        r21.add(r22);
        goto L298
    L233:
        if (Intrinsics.areEqual(String.class, ContentProps.class) == false) goto L236;
        r22 = (String) f(r130);
        goto L295
    L236:
        if (Intrinsics.areEqual(String.class, AtProps.class) == false) goto L239;
        r22 = (String) a(r130);
        goto L295
    L239:
        if (Intrinsics.areEqual(String.class, LinkProps.class) == false) goto L242;
        r22 = (String) k(r130);
        goto L295
    L242:
        if (Intrinsics.areEqual(String.class, UDIconContentProps.class) == false) goto L245;
        r22 = (String) v(r130);
        goto L295
    L245:
        if (Intrinsics.areEqual(String.class, EmojProps.class) == false) goto L248;
        r22 = (String) h(r130);
        goto L295
    L248:
        if (Intrinsics.areEqual(String.class, PlainTextProps.class) == false) goto L251;
        r22 = (String) s(r130);
        goto L295
    L251:
        if (Intrinsics.areEqual(String.class, TagProps.class) == false) goto L254;
        r22 = (String) t(r130);
        goto L295
    L254:
        if (Intrinsics.areEqual(String.class, ListItem.class) == false) goto L257;
        r22 = (String) l(r130);
        goto L295
    L257:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.class) == false) goto L260;
        r22 = (String) c(r130);
        goto L295
    L260:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.class) == false) goto L263;
        r22 = (String) g(r130);
        goto L295
    L263:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.a.class) == false) goto L266;
        r22 = (String) e(r130);
        goto L295
    L266:
        if (Intrinsics.areEqual(String.class, com.larksuite.component.card.component.image.a.class) == false) goto L269;
        r22 = (String) j(r130);
        goto L295
    L269:
        if (Intrinsics.areEqual(String.class, PersonProps.class) == false) goto L272;
        r22 = (String) r(r130);
        goto L295
    L272:
        if (Intrinsics.areEqual(String.class, Person.class) == false) goto L275;
        r22 = (String) q(r130);
        goto L295
    L275:
        if (Intrinsics.areEqual(String.class, ContainerPadding.class) == false) goto L278;
        r22 = (String) d(r130);
        goto L295
    L278:
        if (Intrinsics.areEqual(String.class, HeadingProps.class) == false) goto L281;
        r22 = (String) i(r130);
        goto L295
    L281:
        if (Intrinsics.areEqual(String.class, NumberTagProps.class) == false) goto L284;
        r22 = (String) p(r130);
        goto L295
    L284:
        if (Intrinsics.areEqual(String.class, AudioProps.class) == false) goto L287;
        r22 = (String) b(r130);
        goto L295
    L287:
        if (Intrinsics.areEqual(String.class, a.class) == false) goto L290;
        r22 = (String) n(r130);
        goto L295
    L290:
        if (Intrinsics.areEqual(String.class, MarkdownAudioState.class) == false) goto L293;
        r22 = (String) o(r130);
        goto L295
    L293:
        if (Intrinsics.areEqual(String.class, MarkdownAudioBgPadding.class) == false) goto L297;
        r22 = (String) m(r130);
        goto L295
    L297:
        throw new IllegalArgumentException("unsupported type: " + String.class);
    L300:
        ?? r131 = r21;
        PersonProps r23 = o;
        String r24 = com.larksuite.component.card.component.f.n(r19, "content", r23.getContent());
        if (r24 != null) goto L303;
        r24 = r23.getContent();
    L303:
        String r132 = r24;
        Integer r1 = com.larksuite.component.card.component.f.h(r19, "maxLines", Integer.valueOf(r23.getMaxLines()));
        if (r1 == null) goto L306;
        int r25 = r1.intValue();
    L308:
        return new PersonProps(r5, r8, r11, r12, r15, r16, r17, r110, r131, r132, r25);
    L306:
        r25 = r23.getMaxLines();
        goto L308
    L299:
        r21 = r4.getTextDecoration();
        goto L300
    L84:
        if (Intrinsics.areEqual(ContainerPadding.class, TextProps.class) == false) goto L87;
        r14 = (ContainerPadding) u(r13);
        goto L152
    L87:
        if (Intrinsics.areEqual(ContainerPadding.class, ContentProps.class) == false) goto L90;
        r14 = (ContainerPadding) f(r13);
        goto L152
    L90:
        if (Intrinsics.areEqual(ContainerPadding.class, AtProps.class) == false) goto L93;
        r14 = (ContainerPadding) a(r13);
        goto L152
    L93:
        if (Intrinsics.areEqual(ContainerPadding.class, LinkProps.class) == false) goto L96;
        r14 = (ContainerPadding) k(r13);
        goto L152
    L96:
        if (Intrinsics.areEqual(ContainerPadding.class, UDIconContentProps.class) == false) goto L99;
        r14 = (ContainerPadding) v(r13);
        goto L152
    L99:
        if (Intrinsics.areEqual(ContainerPadding.class, EmojProps.class) == false) goto L102;
        r14 = (ContainerPadding) h(r13);
        goto L152
    L102:
        if (Intrinsics.areEqual(ContainerPadding.class, PlainTextProps.class) == false) goto L105;
        r14 = (ContainerPadding) s(r13);
        goto L152
    L105:
        if (Intrinsics.areEqual(ContainerPadding.class, TagProps.class) == false) goto L108;
        r14 = (ContainerPadding) t(r13);
        goto L152
    L108:
        if (Intrinsics.areEqual(ContainerPadding.class, ListItem.class) == false) goto L111;
        r14 = (ContainerPadding) l(r13);
        goto L152
    L111:
        if (Intrinsics.areEqual(ContainerPadding.class, CardCodeBlockProps.class) == false) goto L114;
        r14 = (ContainerPadding) c(r13);
        goto L152
    L114:
        if (Intrinsics.areEqual(ContainerPadding.class, CardCodeBlockProps.b.class) == false) goto L117;
        r14 = (ContainerPadding) g(r13);
        goto L152
    L117:
        if (Intrinsics.areEqual(ContainerPadding.class, CardCodeBlockProps.b.a.class) == false) goto L120;
        r14 = (ContainerPadding) e(r13);
        goto L152
    L120:
        if (Intrinsics.areEqual(ContainerPadding.class, com.larksuite.component.card.component.image.a.class) == false) goto L123;
        r14 = (ContainerPadding) j(r13);
        goto L152
    L123:
        if (Intrinsics.areEqual(ContainerPadding.class, PersonProps.class) == false) goto L126;
        r14 = (ContainerPadding) r(r13);
        goto L152
    L126:
        if (Intrinsics.areEqual(ContainerPadding.class, Person.class) == false) goto L129;
        r14 = (ContainerPadding) q(r13);
        goto L152
    L129:
        if (Intrinsics.areEqual(ContainerPadding.class, ContainerPadding.class) == false) goto L132;
        r14 = d(r13);
        goto L152
    L132:
        if (Intrinsics.areEqual(ContainerPadding.class, HeadingProps.class) == false) goto L135;
        r14 = (ContainerPadding) i(r13);
        goto L152
    L135:
        if (Intrinsics.areEqual(ContainerPadding.class, NumberTagProps.class) == false) goto L138;
        r14 = (ContainerPadding) p(r13);
        goto L152
    L138:
        if (Intrinsics.areEqual(ContainerPadding.class, AudioProps.class) == false) goto L141;
        r14 = (ContainerPadding) b(r13);
        goto L152
    L141:
        if (Intrinsics.areEqual(ContainerPadding.class, a.class) == false) goto L144;
        r14 = (ContainerPadding) n(r13);
        goto L152
    L144:
        if (Intrinsics.areEqual(ContainerPadding.class, MarkdownAudioState.class) == false) goto L147;
        r14 = (ContainerPadding) o(r13);
        goto L152
    L147:
        if (Intrinsics.areEqual(ContainerPadding.class, MarkdownAudioBgPadding.class) == false) goto L150;
        r14 = (ContainerPadding) m(r13);
        goto L152
    L150:
        throw new IllegalArgumentException("unsupported type: " + ContainerPadding.class);
    L80:
        r10 = r4.getShowName();
        goto L81
    L76:
        r7 = r4.getShowAvatar();
        goto L77
    L5:
        if (Intrinsics.areEqual(Person.class, TextProps.class) == false) goto L8;
        r3 = (Person) u(r2);
        goto L73
    L8:
        if (Intrinsics.areEqual(Person.class, ContentProps.class) == false) goto L11;
        r3 = (Person) f(r2);
        goto L73
    L11:
        if (Intrinsics.areEqual(Person.class, AtProps.class) == false) goto L14;
        r3 = (Person) a(r2);
        goto L73
    L14:
        if (Intrinsics.areEqual(Person.class, LinkProps.class) == false) goto L17;
        r3 = (Person) k(r2);
        goto L73
    L17:
        if (Intrinsics.areEqual(Person.class, UDIconContentProps.class) == false) goto L20;
        r3 = (Person) v(r2);
        goto L73
    L20:
        if (Intrinsics.areEqual(Person.class, EmojProps.class) == false) goto L23;
        r3 = (Person) h(r2);
        goto L73
    L23:
        if (Intrinsics.areEqual(Person.class, PlainTextProps.class) == false) goto L26;
        r3 = (Person) s(r2);
        goto L73
    L26:
        if (Intrinsics.areEqual(Person.class, TagProps.class) == false) goto L29;
        r3 = (Person) t(r2);
        goto L73
    L29:
        if (Intrinsics.areEqual(Person.class, ListItem.class) == false) goto L32;
        r3 = (Person) l(r2);
        goto L73
    L32:
        if (Intrinsics.areEqual(Person.class, CardCodeBlockProps.class) == false) goto L35;
        r3 = (Person) c(r2);
        goto L73
    L35:
        if (Intrinsics.areEqual(Person.class, CardCodeBlockProps.b.class) == false) goto L38;
        r3 = (Person) g(r2);
        goto L73
    L38:
        if (Intrinsics.areEqual(Person.class, CardCodeBlockProps.b.a.class) == false) goto L41;
        r3 = (Person) e(r2);
        goto L73
    L41:
        if (Intrinsics.areEqual(Person.class, com.larksuite.component.card.component.image.a.class) == false) goto L44;
        r3 = (Person) j(r2);
        goto L73
    L44:
        if (Intrinsics.areEqual(Person.class, PersonProps.class) == false) goto L47;
        r3 = (Person) r(r2);
        goto L73
    L47:
        if (Intrinsics.areEqual(Person.class, Person.class) == false) goto L50;
        r3 = q(r2);
        goto L73
    L50:
        if (Intrinsics.areEqual(Person.class, ContainerPadding.class) == false) goto L53;
        r3 = (Person) d(r2);
        goto L73
    L53:
        if (Intrinsics.areEqual(Person.class, HeadingProps.class) == false) goto L56;
        r3 = (Person) i(r2);
        goto L73
    L56:
        if (Intrinsics.areEqual(Person.class, NumberTagProps.class) == false) goto L59;
        r3 = (Person) p(r2);
        goto L73
    L59:
        if (Intrinsics.areEqual(Person.class, AudioProps.class) == false) goto L62;
        r3 = (Person) b(r2);
        goto L73
    L62:
        if (Intrinsics.areEqual(Person.class, a.class) == false) goto L65;
        r3 = (Person) n(r2);
        goto L73
    L65:
        if (Intrinsics.areEqual(Person.class, MarkdownAudioState.class) == false) goto L68;
        r3 = (Person) o(r2);
        goto L73
    L68:
        if (Intrinsics.areEqual(Person.class, MarkdownAudioBgPadding.class) == false) goto L71;
        r3 = (Person) m(r2);
        goto L73
    L71:
        throw new IllegalArgumentException("unsupported type: " + Person.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List] */
    public final PlainTextProps s(ReadableMap r11) {
        PlainTextProps r0 = h;
        Integer r4 = com.larksuite.component.card.component.f.h(r11, "textSize", r0.getTextSize());
        String r5 = com.larksuite.component.card.component.f.n(r11, "textColor", r0.getTextColor());
        String r6 = com.larksuite.component.card.component.f.n(r11, "textBgColor", r0.getTextBgColor());
        ReadableArray r1 = com.larksuite.component.card.component.f.a(r11, "textDecoration");
        if (r1 == null) goto L149;
        ?? r2 = new ArrayList();
        int r3 = r1.size();
        int r7 = 0;
    L5:
        if (r7 >= r3) goto L150;
        Object r9 = null;
        if (Intrinsics.areEqual(String.class, Boolean.TYPE) == false) goto L16;
        Boolean r8 = com.larksuite.component.card.component.f.b(r1, r7);
        if ((r8 instanceof String) == false) goto L12;
        r9 = r8;
    L12:
        String r10 = (String) r9;
        if (r10 == null) goto L148;
        r2.add(r10);
    L148:
        r7 = r7 + 1;
        goto L5
    L16:
        if (Intrinsics.areEqual(String.class, Double.TYPE) == false) goto L25;
        Double r12 = com.larksuite.component.card.component.f.f(r1, r7);
        if ((r12 instanceof String) == false) goto L21;
        r9 = r12;
    L21:
        String r13 = (String) r9;
        if (r13 == null) goto L148;
        r2.add(r13);
        goto L148
    L25:
        if (Intrinsics.areEqual(String.class, Byte.TYPE) == false) goto L34;
        Byte r14 = com.larksuite.component.card.component.f.d(r1, r7);
        if ((r14 instanceof String) == false) goto L30;
        r9 = r14;
    L30:
        String r15 = (String) r9;
        if (r15 == null) goto L148;
        r2.add(r15);
        goto L148
    L34:
        if (Intrinsics.areEqual(String.class, Short.TYPE) == false) goto L43;
        Short r16 = com.larksuite.component.card.component.f.l(r1, r7);
        if ((r16 instanceof String) == false) goto L39;
        r9 = r16;
    L39:
        String r17 = (String) r9;
        if (r17 == null) goto L148;
        r2.add(r17);
        goto L148
    L43:
        if (Intrinsics.areEqual(String.class, Long.TYPE) == false) goto L52;
        Long r19 = com.larksuite.component.card.component.f.i(r1, r7);
        if ((r19 instanceof String) == false) goto L48;
        r9 = r19;
    L48:
        String r20 = (String) r9;
        if (r20 == null) goto L148;
        r2.add(r20);
        goto L148
    L52:
        if (Intrinsics.areEqual(String.class, Character.TYPE) == false) goto L61;
        Character r21 = com.larksuite.component.card.component.f.e(r1, r7);
        if ((r21 instanceof String) == false) goto L57;
        r9 = r21;
    L57:
        String r22 = (String) r9;
        if (r22 == null) goto L148;
        r2.add(r22);
        goto L148
    L61:
        if (Intrinsics.areEqual(String.class, Integer.TYPE) == false) goto L70;
        Integer r23 = com.larksuite.component.card.component.f.g(r1, r7);
        if ((r23 instanceof String) == false) goto L66;
        r9 = r23;
    L66:
        String r24 = (String) r9;
        if (r24 == null) goto L148;
        r2.add(r24);
        goto L148
    L70:
        if (Intrinsics.areEqual(String.class, String.class) == false) goto L77;
        String r25 = com.larksuite.component.card.component.f.m(r1, r7);
        if ((r25 instanceof String) == false) goto L75;
        r9 = r25;
    L75:
        if (r9 == null) goto L148;
        r2.add(r9);
        goto L148
    L77:
        ReadableMap r26 = com.larksuite.component.card.component.f.j(r1, r7);
        if (r26 == null) goto L148;
        if (Intrinsics.areEqual(String.class, TextProps.class) == false) goto L83;
        String r27 = (String) u(r26);
    L145:
        r2.add(r27);
        goto L148
    L83:
        if (Intrinsics.areEqual(String.class, ContentProps.class) == false) goto L86;
        r27 = (String) f(r26);
        goto L145
    L86:
        if (Intrinsics.areEqual(String.class, AtProps.class) == false) goto L89;
        r27 = (String) a(r26);
        goto L145
    L89:
        if (Intrinsics.areEqual(String.class, LinkProps.class) == false) goto L92;
        r27 = (String) k(r26);
        goto L145
    L92:
        if (Intrinsics.areEqual(String.class, UDIconContentProps.class) == false) goto L95;
        r27 = (String) v(r26);
        goto L145
    L95:
        if (Intrinsics.areEqual(String.class, EmojProps.class) == false) goto L98;
        r27 = (String) h(r26);
        goto L145
    L98:
        if (Intrinsics.areEqual(String.class, PlainTextProps.class) == false) goto L101;
        r27 = (String) s(r26);
        goto L145
    L101:
        if (Intrinsics.areEqual(String.class, TagProps.class) == false) goto L104;
        r27 = (String) t(r26);
        goto L145
    L104:
        if (Intrinsics.areEqual(String.class, ListItem.class) == false) goto L107;
        r27 = (String) l(r26);
        goto L145
    L107:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.class) == false) goto L110;
        r27 = (String) c(r26);
        goto L145
    L110:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.class) == false) goto L113;
        r27 = (String) g(r26);
        goto L145
    L113:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.a.class) == false) goto L116;
        r27 = (String) e(r26);
        goto L145
    L116:
        if (Intrinsics.areEqual(String.class, com.larksuite.component.card.component.image.a.class) == false) goto L119;
        r27 = (String) j(r26);
        goto L145
    L119:
        if (Intrinsics.areEqual(String.class, PersonProps.class) == false) goto L122;
        r27 = (String) r(r26);
        goto L145
    L122:
        if (Intrinsics.areEqual(String.class, Person.class) == false) goto L125;
        r27 = (String) q(r26);
        goto L145
    L125:
        if (Intrinsics.areEqual(String.class, ContainerPadding.class) == false) goto L128;
        r27 = (String) d(r26);
        goto L145
    L128:
        if (Intrinsics.areEqual(String.class, HeadingProps.class) == false) goto L131;
        r27 = (String) i(r26);
        goto L145
    L131:
        if (Intrinsics.areEqual(String.class, NumberTagProps.class) == false) goto L134;
        r27 = (String) p(r26);
        goto L145
    L134:
        if (Intrinsics.areEqual(String.class, AudioProps.class) == false) goto L137;
        r27 = (String) b(r26);
        goto L145
    L137:
        if (Intrinsics.areEqual(String.class, a.class) == false) goto L140;
        r27 = (String) n(r26);
        goto L145
    L140:
        if (Intrinsics.areEqual(String.class, MarkdownAudioState.class) == false) goto L143;
        r27 = (String) o(r26);
        goto L145
    L143:
        if (Intrinsics.areEqual(String.class, MarkdownAudioBgPadding.class) == false) goto L147;
        r27 = (String) m(r26);
        goto L145
    L147:
        throw new IllegalArgumentException("unsupported type: " + String.class);
    L150:
        ?? r29 = r2;
        PlainTextProps r30 = h;
        String r31 = com.larksuite.component.card.component.f.n(r11, "content", r30.getContent());
        if (r31 != null) goto L153;
        r31 = r30.getContent();
    L153:
        String r32 = r31;
        Integer r110 = com.larksuite.component.card.component.f.h(r11, "maxLines", Integer.valueOf(r30.getMaxLines()));
        if (r110 == null) goto L156;
        int r111 = r110.intValue();
    L158:
        return new PlainTextProps(r4, r5, r6, r29, r32, r111);
    L156:
        r111 = r30.getMaxLines();
        goto L158
    L149:
        r2 = r0.getTextDecoration();
        goto L150
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List] */
    public final TagProps t(ReadableMap r19) {
        TagProps r2 = i;
        String r6 = com.larksuite.component.card.component.f.n(r19, "content", r2.getContent());
        String r7 = com.larksuite.component.card.component.f.n(r19, "tagBGColorToken", r2.getTagBGColorToken());
        String r8 = com.larksuite.component.card.component.f.n(r19, "tagStyle", r2.getTagStyle());
        ReadableArray r3 = com.larksuite.component.card.component.f.a(r19, "textDecoration");
        if (r3 == null) goto L149;
        ?? r4 = new ArrayList();
        int r5 = r3.size();
        int r9 = 0;
    L5:
        if (r9 >= r5) goto L150;
        Object r11 = null;
        if (Intrinsics.areEqual(String.class, Boolean.TYPE) == false) goto L16;
        Boolean r10 = com.larksuite.component.card.component.f.b(r3, r9);
        if ((r10 instanceof String) == false) goto L12;
        r11 = r10;
    L12:
        String r12 = (String) r11;
        if (r12 == null) goto L148;
        r4.add(r12);
    L148:
        r9 = r9 + 1;
        goto L5
    L16:
        if (Intrinsics.areEqual(String.class, Double.TYPE) == false) goto L25;
        Double r13 = com.larksuite.component.card.component.f.f(r3, r9);
        if ((r13 instanceof String) == false) goto L21;
        r11 = r13;
    L21:
        String r14 = (String) r11;
        if (r14 == null) goto L148;
        r4.add(r14);
        goto L148
    L25:
        if (Intrinsics.areEqual(String.class, Byte.TYPE) == false) goto L34;
        Byte r15 = com.larksuite.component.card.component.f.d(r3, r9);
        if ((r15 instanceof String) == false) goto L30;
        r11 = r15;
    L30:
        String r16 = (String) r11;
        if (r16 == null) goto L148;
        r4.add(r16);
        goto L148
    L34:
        if (Intrinsics.areEqual(String.class, Short.TYPE) == false) goto L43;
        Short r17 = com.larksuite.component.card.component.f.l(r3, r9);
        if ((r17 instanceof String) == false) goto L39;
        r11 = r17;
    L39:
        String r110 = (String) r11;
        if (r110 == null) goto L148;
        r4.add(r110);
        goto L148
    L43:
        if (Intrinsics.areEqual(String.class, Long.TYPE) == false) goto L52;
        Long r20 = com.larksuite.component.card.component.f.i(r3, r9);
        if ((r20 instanceof String) == false) goto L48;
        r11 = r20;
    L48:
        String r111 = (String) r11;
        if (r111 == null) goto L148;
        r4.add(r111);
        goto L148
    L52:
        if (Intrinsics.areEqual(String.class, Character.TYPE) == false) goto L61;
        Character r21 = com.larksuite.component.card.component.f.e(r3, r9);
        if ((r21 instanceof String) == false) goto L57;
        r11 = r21;
    L57:
        String r112 = (String) r11;
        if (r112 == null) goto L148;
        r4.add(r112);
        goto L148
    L61:
        if (Intrinsics.areEqual(String.class, Integer.TYPE) == false) goto L70;
        Integer r22 = com.larksuite.component.card.component.f.g(r3, r9);
        if ((r22 instanceof String) == false) goto L66;
        r11 = r22;
    L66:
        String r113 = (String) r11;
        if (r113 == null) goto L148;
        r4.add(r113);
        goto L148
    L70:
        if (Intrinsics.areEqual(String.class, String.class) == false) goto L77;
        String r23 = com.larksuite.component.card.component.f.m(r3, r9);
        if ((r23 instanceof String) == false) goto L75;
        r11 = r23;
    L75:
        if (r11 == null) goto L148;
        r4.add(r11);
        goto L148
    L77:
        ReadableMap r24 = com.larksuite.component.card.component.f.j(r3, r9);
        if (r24 == null) goto L148;
        if (Intrinsics.areEqual(String.class, TextProps.class) == false) goto L83;
        String r25 = (String) u(r24);
    L145:
        r4.add(r25);
        goto L148
    L83:
        if (Intrinsics.areEqual(String.class, ContentProps.class) == false) goto L86;
        r25 = (String) f(r24);
        goto L145
    L86:
        if (Intrinsics.areEqual(String.class, AtProps.class) == false) goto L89;
        r25 = (String) a(r24);
        goto L145
    L89:
        if (Intrinsics.areEqual(String.class, LinkProps.class) == false) goto L92;
        r25 = (String) k(r24);
        goto L145
    L92:
        if (Intrinsics.areEqual(String.class, UDIconContentProps.class) == false) goto L95;
        r25 = (String) v(r24);
        goto L145
    L95:
        if (Intrinsics.areEqual(String.class, EmojProps.class) == false) goto L98;
        r25 = (String) h(r24);
        goto L145
    L98:
        if (Intrinsics.areEqual(String.class, PlainTextProps.class) == false) goto L101;
        r25 = (String) s(r24);
        goto L145
    L101:
        if (Intrinsics.areEqual(String.class, TagProps.class) == false) goto L104;
        r25 = (String) t(r24);
        goto L145
    L104:
        if (Intrinsics.areEqual(String.class, ListItem.class) == false) goto L107;
        r25 = (String) l(r24);
        goto L145
    L107:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.class) == false) goto L110;
        r25 = (String) c(r24);
        goto L145
    L110:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.class) == false) goto L113;
        r25 = (String) g(r24);
        goto L145
    L113:
        if (Intrinsics.areEqual(String.class, CardCodeBlockProps.b.a.class) == false) goto L116;
        r25 = (String) e(r24);
        goto L145
    L116:
        if (Intrinsics.areEqual(String.class, com.larksuite.component.card.component.image.a.class) == false) goto L119;
        r25 = (String) j(r24);
        goto L145
    L119:
        if (Intrinsics.areEqual(String.class, PersonProps.class) == false) goto L122;
        r25 = (String) r(r24);
        goto L145
    L122:
        if (Intrinsics.areEqual(String.class, Person.class) == false) goto L125;
        r25 = (String) q(r24);
        goto L145
    L125:
        if (Intrinsics.areEqual(String.class, ContainerPadding.class) == false) goto L128;
        r25 = (String) d(r24);
        goto L145
    L128:
        if (Intrinsics.areEqual(String.class, HeadingProps.class) == false) goto L131;
        r25 = (String) i(r24);
        goto L145
    L131:
        if (Intrinsics.areEqual(String.class, NumberTagProps.class) == false) goto L134;
        r25 = (String) p(r24);
        goto L145
    L134:
        if (Intrinsics.areEqual(String.class, AudioProps.class) == false) goto L137;
        r25 = (String) b(r24);
        goto L145
    L137:
        if (Intrinsics.areEqual(String.class, a.class) == false) goto L140;
        r25 = (String) n(r24);
        goto L145
    L140:
        if (Intrinsics.areEqual(String.class, MarkdownAudioState.class) == false) goto L143;
        r25 = (String) o(r24);
        goto L145
    L143:
        if (Intrinsics.areEqual(String.class, MarkdownAudioBgPadding.class) == false) goto L147;
        r25 = (String) m(r24);
        goto L145
    L147:
        throw new IllegalArgumentException("unsupported type: " + String.class);
    L150:
        ?? r26 = r4;
        TagProps r27 = i;
        Integer r29 = com.larksuite.component.card.component.f.h(r19, "originalTextSize", Integer.valueOf(r27.getOriginalTextSize()));
        if (r29 == null) goto L153;
        int r30 = r29.intValue();
    L154:
        int r114 = r30;
        Integer r31 = com.larksuite.component.card.component.f.h(r19, "index", Integer.valueOf(r27.getIndex()));
        if (r31 == null) goto L157;
        int r32 = r31.intValue();
    L158:
        int r115 = r32;
        Integer r33 = com.larksuite.component.card.component.f.h(r19, "textSize", Integer.valueOf(r27.getTextSize()));
        if (r33 == null) goto L161;
        int r34 = r33.intValue();
    L162:
        int r116 = r34;
        String r117 = com.larksuite.component.card.component.f.n(r19, "textColorToken", r27.getTextColorToken());
        String r118 = com.larksuite.component.card.component.f.n(r19, "textBGColorToken", r27.getTextBGColorToken());
        String r119 = com.larksuite.component.card.component.f.n(r19, "align", r27.getAlign());
        Integer r1 = com.larksuite.component.card.component.f.h(r19, "maxLines", Integer.valueOf(r27.getMaxLines()));
        if (r1 == null) goto L165;
        int r35 = r1.intValue();
    L167:
        return new TagProps(r6, r7, r8, r26, r114, r115, r116, r117, r118, r119, r35);
    L165:
        r35 = r27.getMaxLines();
        goto L167
    L161:
        r34 = r27.getTextSize();
        goto L162
    L157:
        r32 = r27.getIndex();
        goto L158
    L153:
        r30 = r27.getOriginalTextSize();
        goto L154
    L149:
        r4 = r2.getTextDecoration();
        goto L150
    }

    public final TextProps u(ReadableMap r30) {
        TextProps r0 = b;
        String r6 = com.larksuite.component.card.component.f.n(r30, "id", r0.getId());
        String r7 = com.larksuite.component.card.component.f.n(r30, "parentId", r0.getParentId());
        String r8 = com.larksuite.component.card.component.f.n(r30, "textColor", r0.getTextColor());
        Integer r9 = com.larksuite.component.card.component.f.h(r30, "textSize", r0.getTextSize());
        String r10 = com.larksuite.component.card.component.f.n(r30, "bgColor", r0.getBgColor());
        Integer r11 = com.larksuite.component.card.component.f.h(r30, "maxLines", r0.getMaxLines());
        Integer r12 = com.larksuite.component.card.component.f.h(r30, "textLines", r0.getTextLines());
        Float r1 = r0.getLineSpacing();
        if (r1 == null) goto L5;
        Double r4 = Double.valueOf(r1.floatValue());
    L6:
        Intrinsics.checkNotNullParameter(r30, "<this>");
        Intrinsics.checkNotNullParameter("lineSpacing", "key");
        Object r2 = r30.asHashMap().get("lineSpacing");
        if (r2 != null) goto L10;
    L25:
        if (r4 == null) goto L27;
        Float r13 = Float.valueOf((float) r4.doubleValue());
    L28:
        TextProps r3 = b;
        String r14 = com.larksuite.component.card.component.f.n(r30, "align", r3.getAlign());
        Integer r15 = com.larksuite.component.card.component.f.h(r30, "paddingLeft", r3.getPaddingLeft());
        Integer r16 = com.larksuite.component.card.component.f.h(r30, "paddingRight", r3.getPaddingRight());
        Integer r17 = com.larksuite.component.card.component.f.h(r30, "paddingTop", r3.getPaddingTop());
        Integer r19 = com.larksuite.component.card.component.f.h(r30, "paddingBottom", r3.getPaddingBottom());
        String r110 = com.larksuite.component.card.component.f.n(r30, "ellipsize", r3.getEllipsize());
        ReadableArray r5 = com.larksuite.component.card.component.f.a(r30, "contentProps");
        if (r5 == null) goto L170;
        ArrayList r20 = new ArrayList();
        int r21 = r5.size();
        int r22 = 0;
    L31:
        if (r22 >= r21) goto L169;
        int r23 = r21;
        Integer r29 = r15;
        if (Intrinsics.areEqual(ContentProps.class, Boolean.TYPE) == false) goto L42;
        Object r24 = com.larksuite.component.card.component.f.b(r5, r22);
        if ((r24 instanceof ContentProps) == true) goto L37;
        r24 = null;
    L37:
        ContentProps r25 = (ContentProps) r24;
        if (r25 == null) goto L168;
        r20.add(r25);
    L168:
        r22 = r22 + 1;
        r21 = r23;
        r5 = r5;
        r15 = r29;
        goto L31
    L42:
        if (Intrinsics.areEqual(ContentProps.class, Double.TYPE) == false) goto L50;
        Object r26 = com.larksuite.component.card.component.f.f(r5, r22);
        if ((r26 instanceof ContentProps) == true) goto L46;
        r26 = null;
    L46:
        ContentProps r27 = (ContentProps) r26;
        if (r27 == null) goto L168;
        r20.add(r27);
        goto L168
    L50:
        if (Intrinsics.areEqual(ContentProps.class, Byte.TYPE) == false) goto L58;
        Object r31 = com.larksuite.component.card.component.f.d(r5, r22);
        if ((r31 instanceof ContentProps) == true) goto L54;
        r31 = null;
    L54:
        ContentProps r32 = (ContentProps) r31;
        if (r32 == null) goto L168;
        r20.add(r32);
        goto L168
    L58:
        if (Intrinsics.areEqual(ContentProps.class, Short.TYPE) == false) goto L66;
        Object r33 = com.larksuite.component.card.component.f.l(r5, r22);
        if ((r33 instanceof ContentProps) == true) goto L62;
        r33 = null;
    L62:
        ContentProps r34 = (ContentProps) r33;
        if (r34 == null) goto L168;
        r20.add(r34);
        goto L168
    L66:
        if (Intrinsics.areEqual(ContentProps.class, Long.TYPE) == false) goto L74;
        Object r35 = com.larksuite.component.card.component.f.i(r5, r22);
        if ((r35 instanceof ContentProps) == true) goto L70;
        r35 = null;
    L70:
        ContentProps r36 = (ContentProps) r35;
        if (r36 == null) goto L168;
        r20.add(r36);
        goto L168
    L74:
        if (Intrinsics.areEqual(ContentProps.class, Character.TYPE) == false) goto L82;
        Object r37 = com.larksuite.component.card.component.f.e(r5, r22);
        if ((r37 instanceof ContentProps) == true) goto L78;
        r37 = null;
    L78:
        ContentProps r38 = (ContentProps) r37;
        if (r38 == null) goto L168;
        r20.add(r38);
        goto L168
    L82:
        if (Intrinsics.areEqual(ContentProps.class, Integer.TYPE) == false) goto L90;
        Object r39 = com.larksuite.component.card.component.f.g(r5, r22);
        if ((r39 instanceof ContentProps) == true) goto L86;
        r39 = null;
    L86:
        ContentProps r40 = (ContentProps) r39;
        if (r40 == null) goto L168;
        r20.add(r40);
        goto L168
    L90:
        if (Intrinsics.areEqual(ContentProps.class, String.class) == false) goto L97;
        Object r41 = com.larksuite.component.card.component.f.m(r5, r22);
        if ((r41 instanceof ContentProps) == true) goto L94;
        r41 = null;
    L94:
        ContentProps r42 = (ContentProps) r41;
        if (r42 == null) goto L168;
        r20.add(r42);
        goto L168
    L97:
        ReadableMap r43 = com.larksuite.component.card.component.f.j(r5, r22);
        if (r43 == null) goto L168;
        if (Intrinsics.areEqual(ContentProps.class, TextProps.class) == false) goto L103;
        ContentProps r44 = (ContentProps) u(r43);
    L165:
        r20.add(r44);
        goto L168
    L103:
        if (Intrinsics.areEqual(ContentProps.class, ContentProps.class) == false) goto L106;
        r44 = f(r43);
        goto L165
    L106:
        if (Intrinsics.areEqual(ContentProps.class, AtProps.class) == false) goto L109;
        r44 = (ContentProps) a(r43);
        goto L165
    L109:
        if (Intrinsics.areEqual(ContentProps.class, LinkProps.class) == false) goto L112;
        r44 = (ContentProps) k(r43);
        goto L165
    L112:
        if (Intrinsics.areEqual(ContentProps.class, UDIconContentProps.class) == false) goto L115;
        r44 = (ContentProps) v(r43);
        goto L165
    L115:
        if (Intrinsics.areEqual(ContentProps.class, EmojProps.class) == false) goto L118;
        r44 = (ContentProps) h(r43);
        goto L165
    L118:
        if (Intrinsics.areEqual(ContentProps.class, PlainTextProps.class) == false) goto L121;
        r44 = (ContentProps) s(r43);
        goto L165
    L121:
        if (Intrinsics.areEqual(ContentProps.class, TagProps.class) == false) goto L124;
        r44 = (ContentProps) t(r43);
        goto L165
    L124:
        if (Intrinsics.areEqual(ContentProps.class, ListItem.class) == false) goto L127;
        r44 = (ContentProps) l(r43);
        goto L165
    L127:
        if (Intrinsics.areEqual(ContentProps.class, CardCodeBlockProps.class) == false) goto L130;
        r44 = (ContentProps) c(r43);
        goto L165
    L130:
        if (Intrinsics.areEqual(ContentProps.class, CardCodeBlockProps.b.class) == false) goto L133;
        r44 = (ContentProps) g(r43);
        goto L165
    L133:
        if (Intrinsics.areEqual(ContentProps.class, CardCodeBlockProps.b.a.class) == false) goto L136;
        r44 = (ContentProps) e(r43);
        goto L165
    L136:
        if (Intrinsics.areEqual(ContentProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L139;
        r44 = (ContentProps) j(r43);
        goto L165
    L139:
        if (Intrinsics.areEqual(ContentProps.class, PersonProps.class) == false) goto L142;
        r44 = (ContentProps) r(r43);
        goto L165
    L142:
        if (Intrinsics.areEqual(ContentProps.class, Person.class) == false) goto L145;
        r44 = (ContentProps) q(r43);
        goto L165
    L145:
        if (Intrinsics.areEqual(ContentProps.class, ContainerPadding.class) == false) goto L148;
        r44 = (ContentProps) d(r43);
        goto L165
    L148:
        if (Intrinsics.areEqual(ContentProps.class, HeadingProps.class) == false) goto L151;
        r44 = (ContentProps) i(r43);
        goto L165
    L151:
        if (Intrinsics.areEqual(ContentProps.class, NumberTagProps.class) == false) goto L154;
        r44 = (ContentProps) p(r43);
        goto L165
    L154:
        if (Intrinsics.areEqual(ContentProps.class, AudioProps.class) == false) goto L157;
        r44 = (ContentProps) b(r43);
        goto L165
    L157:
        if (Intrinsics.areEqual(ContentProps.class, a.class) == false) goto L160;
        r44 = (ContentProps) n(r43);
        goto L165
    L160:
        if (Intrinsics.areEqual(ContentProps.class, MarkdownAudioState.class) == false) goto L163;
        r44 = (ContentProps) o(r43);
        goto L165
    L163:
        if (Intrinsics.areEqual(ContentProps.class, MarkdownAudioBgPadding.class) == false) goto L167;
        r44 = (ContentProps) m(r43);
        goto L165
    L167:
        throw new IllegalArgumentException("unsupported type: " + ContentProps.class);
    L169:
        Integer r210 = r15;
        List r45 = r20;
    L171:
        List r211 = r45;
        TextProps r46 = b;
        return new TextProps(r6, r7, r8, r9, r10, r11, r12, r13, r14, r210, r16, r17, r19, r110, r211, com.larksuite.component.card.component.f.c(r30, "atClickable", r46.getAtClickable()), com.larksuite.component.card.component.f.c(r30, "linkClickable", r46.getLinkClickable()), com.larksuite.component.card.component.f.c(r30, "disableAtStyle", r46.getDisableAtStyle()), com.larksuite.component.card.component.f.c(r30, "disableTagStyle", r46.getDisableTagStyle()), com.larksuite.component.card.component.f.c(r30, "disableNumberTagStyle", r46.getDisableNumberTagStyle()), com.larksuite.component.card.component.f.c(r30, "isTranslateElement", r46.isTranslateElement()), com.larksuite.component.card.component.f.c(r30, "inTable", r46.getInTable()));
    L170:
        r210 = r15;
        r45 = r3.getContentProps();
        goto L171
    L27:
        r13 = null;
        goto L28
    L10:
        if ((r2 instanceof Number) == false) goto L13;
        r4 = Double.valueOf(((Number) r2).doubleValue());
        goto L25
    L13:
        if ((r2 instanceof Boolean) == false) goto L20;
        if (((Boolean) r2).booleanValue() == false) goto L17;
        double r47 = 1.0d;
    L18:
        r4 = Double.valueOf(r47);
        goto L25
    L17:
        r47 = 0.0d;
        goto L18
    L20:
        if ((r2 instanceof String) == false) goto L25;
        r4 = Double.valueOf(CastDoubleProtector.parseDouble((String) r2));     // Catch: NumberFormatException -> L23
    L23:
        e = move-exception;
        Log.d("LynxDataExtension", "safeGetDouble exception: " + e.getMessage());
        goto L25
    L5:
        r4 = null;
        goto L6
    }

    public final TextProps w(ReadableMap r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        TraceEvent.beginSection("UniversalCardTextDataTransformer.transform");
        if (Intrinsics.areEqual(TextProps.class, TextProps.class) == false) goto L6;
        TextProps r5 = u(r4);
    L68:
        TraceEvent.endSection("UniversalCardTextDataTransformer.transform");
        return r5;
    L6:
        if (Intrinsics.areEqual(TextProps.class, ContentProps.class) == false) goto L9;
        r5 = (TextProps) f(r4);
        goto L68
    L9:
        if (Intrinsics.areEqual(TextProps.class, AtProps.class) == false) goto L12;
        r5 = (TextProps) a(r4);
        goto L68
    L12:
        if (Intrinsics.areEqual(TextProps.class, LinkProps.class) == false) goto L15;
        r5 = (TextProps) k(r4);
        goto L68
    L15:
        if (Intrinsics.areEqual(TextProps.class, UDIconContentProps.class) == false) goto L18;
        r5 = (TextProps) v(r4);
        goto L68
    L18:
        if (Intrinsics.areEqual(TextProps.class, EmojProps.class) == false) goto L21;
        r5 = (TextProps) h(r4);
        goto L68
    L21:
        if (Intrinsics.areEqual(TextProps.class, PlainTextProps.class) == false) goto L24;
        r5 = (TextProps) s(r4);
        goto L68
    L24:
        if (Intrinsics.areEqual(TextProps.class, TagProps.class) == false) goto L27;
        r5 = (TextProps) t(r4);
        goto L68
    L27:
        if (Intrinsics.areEqual(TextProps.class, ListItem.class) == false) goto L30;
        r5 = (TextProps) l(r4);
        goto L68
    L30:
        if (Intrinsics.areEqual(TextProps.class, CardCodeBlockProps.class) == false) goto L33;
        r5 = (TextProps) c(r4);
        goto L68
    L33:
        if (Intrinsics.areEqual(TextProps.class, CardCodeBlockProps.b.class) == false) goto L36;
        r5 = (TextProps) g(r4);
        goto L68
    L36:
        if (Intrinsics.areEqual(TextProps.class, CardCodeBlockProps.b.a.class) == false) goto L39;
        r5 = (TextProps) e(r4);
        goto L68
    L39:
        if (Intrinsics.areEqual(TextProps.class, com.larksuite.component.card.component.image.a.class) == false) goto L42;
        r5 = (TextProps) j(r4);
        goto L68
    L42:
        if (Intrinsics.areEqual(TextProps.class, PersonProps.class) == false) goto L45;
        r5 = (TextProps) r(r4);
        goto L68
    L45:
        if (Intrinsics.areEqual(TextProps.class, Person.class) == false) goto L48;
        r5 = (TextProps) q(r4);
        goto L68
    L48:
        if (Intrinsics.areEqual(TextProps.class, ContainerPadding.class) == false) goto L51;
        r5 = (TextProps) d(r4);
        goto L68
    L51:
        if (Intrinsics.areEqual(TextProps.class, HeadingProps.class) == false) goto L54;
        r5 = (TextProps) i(r4);
        goto L68
    L54:
        if (Intrinsics.areEqual(TextProps.class, NumberTagProps.class) == false) goto L57;
        r5 = (TextProps) p(r4);
        goto L68
    L57:
        if (Intrinsics.areEqual(TextProps.class, AudioProps.class) == false) goto L60;
        r5 = (TextProps) b(r4);
        goto L68
    L60:
        if (Intrinsics.areEqual(TextProps.class, a.class) == false) goto L63;
        r5 = (TextProps) n(r4);
        goto L68
    L63:
        if (Intrinsics.areEqual(TextProps.class, MarkdownAudioState.class) == false) goto L66;
        r5 = (TextProps) o(r4);
        goto L68
    L66:
        if (Intrinsics.areEqual(TextProps.class, MarkdownAudioBgPadding.class) == false) goto L71;
        r5 = (TextProps) m(r4);
        goto L68
    L71:
        throw new IllegalArgumentException("unsupported type: " + TextProps.class);
    }
}
