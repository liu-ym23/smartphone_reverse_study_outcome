package j6b;

import com.bytedance.lark.pb.basic.v1.Border;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.bytedance.lark.pb.basic.v1.Gradient;
import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.bytedance.lark.pb.basic.v1.PreviewHangPointPair;
import com.bytedance.lark.pb.basic.v1.RichText;
import com.bytedance.lark.pb.basic.v1.URLPreviewComponent;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.ss.android.lark.chat.entity.preview.DocType;
import com.ss.android.lark.chat.preview.entity.component.Direction;
import com.ss.android.lark.chat.preview.entity.component.Tag;
import com.ss.android.lark.chat.preview.entity.component.Theme;
import com.ss.android.lark.chat.preview.entity.component.property.AvatarProperty;
import com.ss.android.lark.chat.preview.entity.component.property.ButtonProperty;
import com.ss.android.lark.chat.preview.entity.component.property.ChattersPreviewProperty;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.chat.preview.entity.component.property.EmptyProperty;
import com.ss.android.lark.chat.preview.entity.component.property.IGProperty;
import com.ss.android.lark.chat.preview.entity.component.property.ImageContainerProperty;
import com.ss.android.lark.chat.preview.entity.component.property.ImageProperty;
import com.ss.android.lark.chat.preview.entity.component.property.LinearLayoutProperty;
import com.ss.android.lark.chat.preview.entity.component.property.OverSizeTextProperty;
import com.ss.android.lark.chat.preview.entity.component.property.PreviewHeaderProperty;
import com.ss.android.lark.chat.preview.entity.component.property.RichTextProperty;
import com.ss.android.lark.chat.preview.entity.component.property.SpinButtonProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TagListProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TextViewProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TimeProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TimeZoneProperty;
import com.ss.android.lark.chat.preview.entity.component.property.UDLoadingProperty;
import com.ss.android.lark.chat.preview.entity.component.property.VideoProperty;
import com.ss.android.lark.export.engine.EngineProperty;
import com.ss.android.lark.export.entity.Justify;
import com.ss.android.lark.export.entity.Orientation;
import com.ss.android.lark.export.entity.preview.AvatarChatterInfo;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Item;
import com.ss.android.lark.export.entity.preview.KeyTag;
import com.ss.android.lark.export.entity.preview.Padding;
import com.ss.android.lark.export.entity.preview.SizeLevel;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.flexlayout.FlexLayoutProperty;
import com.ss.android.lark.tangram.base.style.Align;
import com.ss.android.lark.tangram.base.style.Value;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[URLPreviewComponent.Type.values().length];
            r0[URLPreviewComponent.Type.EMPTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L36
        L79:
            r0[URLPreviewComponent.Type.CARD_CONTAINER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L37
        L89:
            r0[URLPreviewComponent.Type.LINEAR_LAYOUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L38
        L95:
            r0[URLPreviewComponent.Type.FLEX_LAYOUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L39
        L99:
            r0[URLPreviewComponent.Type.HEADER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L40
        L103:
            r0[URLPreviewComponent.Type.RICHTEXT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L41
        L111:
            r0[URLPreviewComponent.Type.IMAGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L42
        L71:
            r0[URLPreviewComponent.Type.CHATTERS_PREVIEW.ordinal()] = 8;     // Catch: NoSuchFieldError -> L43
        L81:
            r0[URLPreviewComponent.Type.BUTTON.ordinal()] = 9;     // Catch: NoSuchFieldError -> L44
        L83:
            r0[URLPreviewComponent.Type.ICON_BUTTON.ordinal()] = 10;     // Catch: NoSuchFieldError -> L45
        L91:
            r0[URLPreviewComponent.Type.TEXT_BUTTON.ordinal()] = 11;     // Catch: NoSuchFieldError -> L46
        L109:
            r0[URLPreviewComponent.Type.TIME.ordinal()] = 12;     // Catch: NoSuchFieldError -> L47
        L115:
            r0[URLPreviewComponent.Type.TEXT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L48
        L63:
            r0[URLPreviewComponent.Type.TAG_LIST.ordinal()] = 14;     // Catch: NoSuchFieldError -> L49
        L69:
            r0[URLPreviewComponent.Type.SPIN_BUTTON.ordinal()] = 15;     // Catch: NoSuchFieldError -> L50
        L87:
            r0[URLPreviewComponent.Type.AVATAR.ordinal()] = 16;     // Catch: NoSuchFieldError -> L51
        L93:
            r0[URLPreviewComponent.Type.VIDEO.ordinal()] = 17;     // Catch: NoSuchFieldError -> L52
        L97:
            r0[URLPreviewComponent.Type.DOC_IMAGE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L53
        L105:
            r0[URLPreviewComponent.Type.LOADING.ordinal()] = 19;     // Catch: NoSuchFieldError -> L54
        L67:
            r0[URLPreviewComponent.Type.TIME_ZONE.ordinal()] = 20;     // Catch: NoSuchFieldError -> L55
        L75:
            r0[URLPreviewComponent.Type.OVERSIZED_TEXT.ordinal()] = 21;     // Catch: NoSuchFieldError -> L56
        L77:
            r0[URLPreviewComponent.Type.ENGINE.ordinal()] = 22;     // Catch: NoSuchFieldError -> L57
        L85:
            r0[URLPreviewComponent.Type.IMAGE_CONTAINER.ordinal()] = 23;     // Catch: NoSuchFieldError -> L58
        L29:
            a = r0;
            int[] r1 = new int[URLPreviewComponent.ImageContainerProperty.ContentMode.values().length];
            r1[URLPreviewComponent.ImageContainerProperty.ContentMode.SCALE_TO_FILL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L59
        L107:
            r1[URLPreviewComponent.ImageContainerProperty.ContentMode.SCALE_ASPECT_FIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L60
        L113:
            r1[URLPreviewComponent.ImageContainerProperty.ContentMode.SCALE_ASPECT_FILL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L61
        L65:
            r1[URLPreviewComponent.ImageContainerProperty.ContentMode.CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L62
        L34:
            b = r1;
        }
    }

    static {
    }

    @JvmStatic
    public static final ArrayList<ChatterPreviewChatterInfo> a(List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> r7) {
        Intrinsics.checkNotNullParameter(r7, "pbChatterInfoList");
        ArrayList<ChatterPreviewChatterInfo> r0 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        URLPreviewComponent.ChattersPreviewProperty.ChatterInfo r1 = (URLPreviewComponent.ChattersPreviewProperty.ChatterInfo) r8.next();
        String r3 = r1.avatar_key;
        String r4 = r1.chatter_id;
        String r5 = r1.name;
        ChatterPreviewChatterInfo.ChatterType.a r6 = ChatterPreviewChatterInfo.ChatterType.Companion;
        int r2 = r1.type.getValue();
        r6.getClass();
        if (r2 != 0) goto L8;
        ChatterPreviewChatterInfo.ChatterType r9 = ChatterPreviewChatterInfo.ChatterType.UNKNOWN;
    L12:
        r0.add(new ChatterPreviewChatterInfo(r3, r4, r5, r9));
        goto L4
    L8:
        if (r2 == 1) goto L10;
        r9 = ChatterPreviewChatterInfo.ChatterType.UNKNOWN;
        goto L12
    L10:
        r9 = ChatterPreviewChatterInfo.ChatterType.USER;
        goto L12
    L13:
        return r0;
    }

    public static HashMap b(Map r18) {
        if (r18 == null) goto L34;
        HashMap r1 = new HashMap();
        Iterator r2 = r18.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L28;
        Map.Entry r3 = (Map.Entry) r2.next();
        Object r4 = r3.getKey();
        Map r5 = ((PreviewHangPointPair) r3.getValue()).url_preview_hang_point_map;
        if (r5 == null) goto L25;
        LinkedHashMap r6 = new LinkedHashMap(MapsKt.mapCapacity(r5.size()));
        Iterator r7 = r5.entrySet().iterator();
    L11:
        if (r7.hasNext() == false) goto L26;
        Map.Entry r8 = (Map.Entry) r7.next();
        Object r9 = r8.getKey();
        PreviewHangPoint r10 = (PreviewHangPoint) r8.getValue();
        if (r10 != null) goto L15;
        com.ss.android.lark.export.entity.PreviewHangPoint r11 = null;
    L24:
        r6.put(r9, r11);
        goto L11
    L15:
        String r12 = r10.url;
        String r13 = (String) r8.getKey();
        String r14 = r10.preview_id;
        Boolean r15 = r10.need_local_preview;
        if (r15 == null) goto L18;
        boolean r16 = r15.booleanValue();
    L19:
        Boolean r17 = r10.is_lazy_load;
        if (r17 == null) goto L22;
        boolean r19 = r17.booleanValue();
    L23:
        r11 = new com.ss.android.lark.export.entity.PreviewHangPoint(r12, r13, null, r14, r16, r19, null);
        goto L24
    L22:
        r19 = false;
        goto L23
    L18:
        r16 = false;
    L26:
        r1.put(r4, r6);
        goto L6
    L25:
        r6 = null;
        goto L26
    L28:
        return r1;
    L34:
        return null;
    }

    @JvmStatic
    public static final Padding c(URLPreviewComponent.Padding r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        return new Padding(r4.top.floatValue(), r4.right.floatValue(), r4.bottom.floatValue(), r4.left.floatValue());
    }

    @JvmStatic
    public static final UDIcon d(com.bytedance.lark.pb.basic.v1.UDIcon r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return new UDIcon(r3.key, h.c(r3.color), r3.unicode);
    }

    @JvmStatic
    public static final com.bytedance.lark.pb.basic.v1.UDIcon e(UDIcon r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new com.bytedance.lark.pb.basic.v1.UDIcon.Builder().key(r2.getKey()).color(h.e(r2.getThemeColor())).unicode(r2.getUnicode()).build();
    }

    @JvmStatic
    public static final UrlPreviewComponent f(URLPreviewComponent r47, UrlPreviewEntity r48) {
        if (r47 != null) goto L5;
        return null;
    L5:
        URLPreviewComponent.Type r3 = r47.type;
        int r4 = -1;
        if (r3 != null) goto L8;
        int r5 = -1;
    L10:
        switch(r5) {
            case 1: goto L284;
            case 2: goto L279;
            case 3: goto L274;
            case 4: goto L269;
            case 5: goto L247;
            case 6: goto L230;
            case 7: goto L207;
            case 8: goto L197;
            case 9: goto L193;
            case 10: goto L189;
            case 11: goto L185;
            case 12: goto L181;
            case 13: goto L177;
            case 14: goto L168;
            case 15: goto L145;
            case 16: goto L133;
            case 17: goto L129;
            case 18: goto L93;
            case 19: goto L92;
            case 20: goto L56;
            case 21: goto L46;
            case 22: goto L31;
            case 23: goto L12;
            default: goto L11;
        };
    L11:
        i6b.a r1 = i6b.b.a;
        i6b.a r2 = i6b.b.a;
        if (r2 == null) goto L292;
        com.ss.android.lark.officesdk.integrator.im.f r6 = r2.d();
    L293:
        if (r6 == null) goto L297;
        Type.a r7 = Type.Companion;
        int r8 = r47.type.getValue();
        r7.getClass();
        com.ss.android.lark.export.c r9 = r6.b(Type.a.a(r8));
        if (r9 == null) goto L297;
        BaseProperty r10 = r9.b();
    L298:
        BaseProperty r14 = r10;
    L299:
        if (r14 != null) goto L301;
        return null;
    L301:
        Type.a r11 = Type.Companion;
        int r12 = r47.type.getValue();
        r11.getClass();
        Type r13 = Type.a.a(r12);
        Boolean r15 = r47.can_skip_when_unknown;
        URLPreviewComponent.Style r16 = r47.style;
        int r17 = h.a;
        if (r16 != null) goto L304;
        Style r18 = null;
    L330:
        return new UrlPreviewComponent(r13, r15, r18, r47.child_ids, r47.is_font_zoomable, r14);
    L304:
        SizeLevel.a r19 = SizeLevel.Companion;
        int r20 = r16.size_level.getValue();
        r19.getClass();
        if (r20 == 0) goto L311;
        if (r20 == 1) goto L310;
        if (r20 == 2) goto L309;
        SizeLevel r21 = SizeLevel.NORMAL;
    L312:
        SizeLevel r28 = r21;
        FontLevel r29 = h.a(r16.font_level);
        ThemeColor r30 = h.c(r16.text_color_v2);
        Border r22 = r16.border;
        if (r22 == null) goto L315;
        com.ss.android.lark.export.entity.preview.Border r31 = new com.ss.android.lark.export.entity.preview.Border(r22.width, r22.corner_radius, h.c(r22.color_v2));
    L316:
        Gradient r23 = r16.background_color;
        if (r23 != null) goto L319;
        com.ss.android.lark.export.entity.preview.Gradient r32 = null;
    L328:
        Value r33 = h.f(r16.width);
        Value r34 = h.f(r16.height);
        Value r35 = h.f(r16.min_width);
        Value r36 = h.f(r16.min_height);
        Value r37 = h.f(r16.max_width);
        Value r38 = h.f(r16.max_height);
        int r39 = r16.grow_weight.intValue();
        int r40 = r16.shrink_weight.intValue();
        float r41 = r16.aspect_ratio.intValue() / 100.0f;
        Align.a r24 = Align.Companion;
        int r25 = r16.align_self.getValue();
        r24.getClass();
        r18 = new Style(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, Align.a.a(r25));
        goto L330
    L319:
        com.ss.android.lark.export.entity.preview.Gradient.GradientType.a r26 = com.ss.android.lark.export.entity.preview.Gradient.GradientType.Companion;
        int r27 = r23.type.getValue();
        r26.getClass();
        if (r27 != 0) goto L322;
        com.ss.android.lark.export.entity.preview.Gradient.GradientType r42 = com.ss.android.lark.export.entity.preview.Gradient.GradientType.LINEAR;
    L323:
        Gradient.Linear r43 = r23.linear;
        if (r43 != null) goto L326;
        com.ss.android.lark.export.entity.preview.Gradient.Linear r44 = new com.ss.android.lark.export.entity.preview.Gradient.Linear(0, null);
    L327:
        r32 = new com.ss.android.lark.export.entity.preview.Gradient(r42, r44);
        goto L328
    L326:
        r44 = new com.ss.android.lark.export.entity.preview.Gradient.Linear(r43.deg, h.d(r43.colors_v2));
        goto L327
    L322:
        r42 = com.ss.android.lark.export.entity.preview.Gradient.GradientType.LINEAR;
        goto L323
    L315:
        r31 = null;
        goto L316
    L309:
        r21 = SizeLevel.LARGE;
        goto L312
    L310:
        r21 = SizeLevel.SMALL;
        goto L312
    L311:
        r21 = SizeLevel.NORMAL;
    L297:
        r10 = null;
        goto L298
    L292:
        r6 = null;
        goto L293
    L12:
        URLPreviewComponent.ImageContainerProperty r45 = r47.image_container;
        if (r45 != null) goto L15;
        r10 = new ImageContainerProperty(null, null, null);
        goto L298
    L15:
        ImageSet r46 = b.b(r45.background);
        String r49 = r45.action_id;
        URLPreviewComponent.ImageContainerProperty.ContentMode r50 = r45.content_mode;
        if (r50 == null) goto L19;
        r4 = a.b[r50.ordinal()];
    L19:
        if (r4 == 1) goto L29;
        if (r4 != 2) goto L22;
        ImageContainerProperty.ContentMode r51 = ImageContainerProperty.ContentMode.SCALE_ASPECT_FIT;
    L30:
        BaseProperty r52 = new ImageContainerProperty(r46, r49, r51);
    L272:
        r10 = r52;
        goto L298
    L22:
        if (r4 != 3) goto L24;
        r51 = ImageContainerProperty.ContentMode.SCALE_ASPECT_FILL;
        goto L30
    L24:
        if (r4 == 4) goto L26;
        r51 = null;
        goto L30
    L26:
        r51 = ImageContainerProperty.ContentMode.CENTER;
        goto L30
    L29:
        r51 = ImageContainerProperty.ContentMode.SCALE_TO_FILL;
        goto L30
    L31:
        EngineProperty.EngineType.a r53 = EngineProperty.EngineType.Companion;
        int r54 = r47.engine.type.getValue();
        r53.getClass();
        if (r54 == 0) goto L38;
        if (r54 == 1) goto L37;
        if (r54 == 2) goto L36;
        EngineProperty.EngineType r55 = EngineProperty.EngineType.MESSAGE;
    L39:
        i6b.a r56 = i6b.b.a;
        i6b.a r57 = i6b.b.a;
        if (r57 == null) goto L297;
        com.ss.android.lark.officesdk.integrator.im.f r58 = r57.d();
        if (r58 == null) goto L297;
        com.ss.android.lark.export.d r59 = r58.a(r55);
        if (r59 == null) goto L297;
        r10 = r59.b();
        goto L298
    L36:
        r55 = EngineProperty.EngineType.TURTLE_CANVAS;
        goto L39
    L37:
        r55 = EngineProperty.EngineType.DOC_COMPONENT;
        goto L39
    L38:
        r55 = EngineProperty.EngineType.MESSAGE;
        goto L39
    L46:
        URLPreviewComponent.OversizedTextProperty r60 = r47.oversized_text;
        if (r60 == null) goto L55;
        String r61 = r60.text;
        int r62 = r60.number_of_lines.intValue();
        int r63 = r60.font_size.intValue();
        OverSizeTextProperty.FontWeight.a r110 = OverSizeTextProperty.FontWeight.Companion;
        int r64 = r60.font_weight.getValue();
        r110.getClass();
        if (r64 == 0) goto L53;
        if (r64 == 1) goto L52;
        OverSizeTextProperty.FontWeight r65 = OverSizeTextProperty.FontWeight.REGULAR;
    L54:
        r52 = new OverSizeTextProperty(r61, r62, r63, r65);
        goto L272
    L52:
        r65 = OverSizeTextProperty.FontWeight.SEMI_BOLD;
        goto L54
    L53:
        r65 = OverSizeTextProperty.FontWeight.REGULAR;
        goto L54
    L55:
        r10 = new OverSizeTextProperty(null, 0, 0, null, 15, null);
        goto L298
    L56:
        URLPreviewComponent.TimeZoneProperty r66 = r47.time_zone;
        if (r66 == null) goto L91;
        TimeZoneProperty.TimeZoneType.a r67 = TimeZoneProperty.TimeZoneType.Companion;
        int r68 = r66.time_zone_type.getValue();
        r67.getClass();
        TimeZoneProperty.TimeZoneType r69 = TimeZoneProperty.TimeZoneType.a.a(r68);
        TimeZoneProperty.FormatType.a r70 = TimeZoneProperty.FormatType.Companion;
        int r71 = r66.format_type.getValue();
        r70.getClass();
        if (r71 == 0) goto L63;
        if (r71 == 1) goto L62;
        TimeZoneProperty.FormatType r72 = TimeZoneProperty.FormatType.LONG;
    L64:
        TimeZoneProperty.FormatType r111 = r72;
        TimeZoneProperty.TimePrecisionType.a r73 = TimeZoneProperty.TimePrecisionType.Companion;
        int r74 = r66.time_precision_type.getValue();
        r73.getClass();
        if (r74 == 0) goto L71;
        if (r74 == 1) goto L70;
        if (r74 == 2) goto L69;
        TimeZoneProperty.TimePrecisionType r75 = TimeZoneProperty.TimePrecisionType.MINUTE;
    L72:
        TimeZoneProperty.TimePrecisionType r112 = r75;
        TimeZoneProperty.TimeStyle.a r76 = TimeZoneProperty.TimeStyle.Companion;
        int r77 = r66.time_style.getValue();
        r76.getClass();
        if (r77 == 1) goto L77;
        if (r77 == 2) goto L76;
        TimeZoneProperty.TimeStyle r78 = TimeZoneProperty.TimeStyle.DEFAULT;
    L78:
        TimeZoneProperty.TimeStyle r113 = r78;
        TimeZoneProperty.DatePrecisionType.a r79 = TimeZoneProperty.DatePrecisionType.Companion;
        int r80 = r66.date_precision_type.getValue();
        r79.getClass();
        if (r80 == 0) goto L83;
        if (r80 == 1) goto L82;
        TimeZoneProperty.DatePrecisionType r81 = TimeZoneProperty.DatePrecisionType.DAY_TYPE;
    L84:
        TimeZoneProperty.DatePrecisionType r114 = r81;
        TimeZoneProperty.DateStatusType.a r82 = TimeZoneProperty.DateStatusType.Companion;
        int r83 = r66.date_status_type.getValue();
        r82.getClass();
        if (r83 == 0) goto L89;
        if (r83 == 1) goto L88;
        TimeZoneProperty.DateStatusType r84 = TimeZoneProperty.DateStatusType.RELATIVE;
    L90:
        BaseProperty r85 = new TimeZoneProperty(r69, r111, r112, r113, r114, r84, r66.start_time_stamp.longValue(), r66.end_time_stamp.longValue(), r66.enable_gmt.booleanValue());
    L277:
        r14 = r85;
        goto L299
    L88:
        r84 = TimeZoneProperty.DateStatusType.RELATIVE;
        goto L90
    L89:
        r84 = TimeZoneProperty.DateStatusType.ABSOLUTE;
        goto L90
    L82:
        r81 = TimeZoneProperty.DatePrecisionType.MONTH_TYPE;
        goto L84
    L83:
        r81 = TimeZoneProperty.DatePrecisionType.DAY_TYPE;
        goto L84
    L76:
        r78 = TimeZoneProperty.TimeStyle.BY_24_HOUR;
        goto L78
    L77:
        r78 = TimeZoneProperty.TimeStyle.BY_12_HOUR;
        goto L78
    L69:
        r75 = TimeZoneProperty.TimePrecisionType.HOUR;
        goto L72
    L70:
        r75 = TimeZoneProperty.TimePrecisionType.MINUTE;
        goto L72
    L71:
        r75 = TimeZoneProperty.TimePrecisionType.SECOND;
        goto L72
    L62:
        r72 = TimeZoneProperty.FormatType.LONG;
        goto L64
    L63:
        r72 = TimeZoneProperty.FormatType.SHORT;
        goto L64
    L91:
        r10 = new TimeZoneProperty(null, null, null, null, null, null, 0, 0, false, 511, null);
        goto L298
    L92:
        r10 = new UDLoadingProperty();
        goto L298
    L93:
        URLPreviewComponent.DocImageProperty r86 = r47.doc_image;
        if (r48 == null) goto L100;
        UrlPreviewEntity.ExtInfo r87 = r48.ext_info;
        if (r87 == null) goto L100;
        UrlPreviewEntity.DocInfo r88 = r87.doc_info;
        if (r88 == null) goto L100;
        String r115 = r88.file_token;
    L101:
        DocType.a r89 = DocType.Companion;
        if (r86 == null) goto L106;
        Doc.Type r90 = r86.doc_type;
        if (r90 == null) goto L106;
        int r91 = r90.getValue();
    L107:
        r89.getClass();
        DocType r92 = DocType.a.a(r91);
        if (r86 == null) goto L110;
        String r116 = r86.thumbnail_url;
    L111:
        if (r86 == null) goto L113;
        String r117 = r86.secret_url;
    L114:
        if (r86 == null) goto L116;
        Integer r118 = r86.secret_type;
    L117:
        if (r86 == null) goto L119;
        String r119 = r86.secret_key;
    L120:
        if (r86 == null) goto L122;
        String r120 = r86.secret_nonce;
    L123:
        if (r86 == null) goto L127;
        Boolean r93 = r86.support_preview;
        if (r93 == null) goto L127;
        boolean r121 = r93.booleanValue();
    L128:
        r10 = new DocImageProperty(r92, r115, r116, r117, r118, r119, r120, r121);
    L127:
        r121 = false;
        goto L128
    L122:
        r120 = null;
        goto L123
    L119:
        r119 = null;
        goto L120
    L116:
        r118 = null;
        goto L117
    L113:
        r117 = null;
        goto L114
    L110:
        r116 = null;
    L106:
        r91 = 0;
    L100:
        r115 = null;
        goto L101
    L129:
        URLPreviewComponent.VideoProperty r94 = r47.video;
        if (r94 == null) goto L132;
        VideoProperty.Site.a r95 = VideoProperty.Site.Companion;
        int r96 = r94.site.getValue();
        r95.getClass();
        r52 = new VideoProperty(VideoProperty.Site.a.a(r96), b.b(r94.cover_image), r94.cover_image_url, r94.duration.longValue(), r94.src_url, r94.vid, r94.iframe_url);
        goto L272
    L132:
        r10 = new VideoProperty(VideoProperty.Site.UNKNOWN, null, BuildConfig.FLAVOR, 0, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        goto L298
    L133:
        URLPreviewComponent.AvatarProperty r97 = r47.avatar;
        if (r97 == null) goto L138;
        URLPreviewComponent.AvatarProperty.ChatterInfo r98 = r97.chatter_info;
        if (r98 == null) goto L138;
        String r99 = r98.avatar_key;
    L139:
        if (r97 == null) goto L143;
        URLPreviewComponent.AvatarProperty.ChatterInfo r100 = r97.chatter_info;
        if (r100 == null) goto L143;
        String r101 = r100.chatter_id;
    L144:
        r52 = new AvatarProperty(new AvatarChatterInfo(r99, r101));
    L143:
        r101 = null;
    L138:
        r99 = null;
        goto L139
    L145:
        URLPreviewComponent.SpinButtonProperty r102 = r47.spin_button;
        ArrayList r103 = new ArrayList();
        if (r102 == null) goto L154;
        List r104 = r102.items;
        if (r104 == null) goto L154;
        Iterator r105 = r104.iterator();
    L151:
        if (r105.hasNext() == false) goto L154;
        URLPreviewComponent.Item r106 = (URLPreviewComponent.Item) r105.next();
        r103.add(new Item(r106.action_id, r106.text));
    L154:
        if (r102 == null) goto L156;
        com.bytedance.lark.pb.basic.v1.ImageSet r107 = r102.icon;
    L157:
        ImageSet r108 = b.b(r107);
        if (r102 == null) goto L160;
        Long r109 = r102.selected_index;
    L161:
        Direction.a r122 = Direction.Companion;
        if (r102 == null) goto L166;
        URLPreviewComponent.Direction r123 = r102.direction;
        if (r123 == null) goto L166;
        int r124 = r123.getValue();
    L167:
        r122.getClass();
        BaseProperty r125 = new SpinButtonProperty(r108, r103, r109, Direction.a.a(r124));
    L175:
        r10 = r125;
    L166:
        r124 = Direction.LTR.getValue();
        goto L167
    L160:
        r109 = null;
        goto L161
    L156:
        r107 = null;
        goto L157
    L168:
        URLPreviewComponent.TagListProperty r126 = r47.tag_list;
        if (r126 == null) goto L176;
        ArrayList r127 = new ArrayList();
        Iterator r128 = r126.mixed_tags.iterator();
    L172:
        if (r128.hasNext() == false) goto L174;
        URLPreviewComponent.TagListProperty.Tag r129 = (URLPreviewComponent.TagListProperty.Tag) r128.next();
        r127.add(new KeyTag(r129.tag, h.c(r129.text_color), h.c(r129.background_color)));
        goto L172
    L174:
        r125 = new TagListProperty(r126.tags, r127, r126.number_of_lines.intValue());
        goto L175
    L176:
        r10 = new TagListProperty(null, null, 0, 7, null);
        goto L298
    L177:
        URLPreviewComponent.TextProperty r130 = r47.text;
        if (r130 == null) goto L180;
        r52 = new TextViewProperty(r130.text, r130.number_of_lines.intValue(), r130.action_id);
        goto L272
    L180:
        r10 = new TextViewProperty(BuildConfig.FLAVOR, 0, null, 4, null);
        goto L298
    L181:
        URLPreviewComponent.TimeProperty r131 = r47.time;
        if (r131 == null) goto L184;
        r52 = new TimeProperty(r131.start_time_stamp, r131.is_countdown, r131.ntp_action_id, r131.is_end, r131.end_time_stamp);
        goto L272
    L184:
        r14 = new TimeProperty(0L, Boolean.FALSE, null, null, 0L);
        goto L299
    L185:
        URLPreviewComponent.TextButtonProperty r132 = r47.text_button;
        if (r132 == null) goto L188;
        r52 = new ButtonProperty(null, r132.text, null, r132.action_id, r132.is_disable, null, 32, null);
        goto L272
    L188:
        r10 = new ButtonProperty(null, null, null, null, null, null, 63, null);
        goto L298
    L189:
        URLPreviewComponent.IconButtonProperty r133 = r47.icon_button;
        if (r133 == null) goto L192;
        r52 = new ButtonProperty(b.b(r133.icon), null, null, r133.action_id, r133.is_disable, d(r133.ud_icon));
        goto L272
    L192:
        r10 = new ButtonProperty(null, null, null, null, null, null, 63, null);
        goto L298
    L193:
        URLPreviewComponent.ButtonProperty r134 = r47.button;
        if (r134 == null) goto L196;
        ImageSet r135 = b.b(r134.icon);
        String r136 = r134.text;
        Direction.a r137 = Direction.Companion;
        int r138 = r134.direction.getValue();
        r137.getClass();
        r52 = new ButtonProperty(r135, r136, Direction.a.a(r138), r134.action_id, r134.is_disable, d(r134.ud_icon));
        goto L272
    L196:
        r10 = new ButtonProperty(null, null, null, null, null, null, 63, null);
        goto L298
    L197:
        URLPreviewComponent.ChattersPreviewProperty r139 = r47.chatters_preview;
        if (r139 == null) goto L206;
        Theme.a r140 = Theme.Companion;
        int r141 = r139.theme.getValue();
        r140.getClass();
        Theme r142 = Theme.a.a(r141);
        Integer r143 = r139.chatters_count;
        ArrayList<ChatterPreviewChatterInfo> r144 = a(r139.chatter_infos);
        Integer r145 = r139.max_show_count;
        ChattersPreviewProperty.ChattersMode.a r146 = ChattersPreviewProperty.ChattersMode.Companion;
        int r147 = r139.chatters_mode.getValue();
        r146.getClass();
        if (r147 == 0) goto L204;
        if (r147 == 1) goto L203;
        ChattersPreviewProperty.ChattersMode r148 = ChattersPreviewProperty.ChattersMode.DYNAMIC;
    L205:
        r52 = new ChattersPreviewProperty(r142, r143, r144, r145, r148, r139.title);
        goto L272
    L203:
        r148 = ChattersPreviewProperty.ChattersMode.DYNAMIC;
        goto L205
    L204:
        r148 = ChattersPreviewProperty.ChattersMode.STATIC;
        goto L205
    L206:
        r10 = new ChattersPreviewProperty(null, null, null, null, null, null, 63, null);
        goto L298
    L207:
        URLPreviewComponent.ImageProperty r149 = r47.image;
        if (r149 == null) goto L210;
        com.bytedance.lark.pb.basic.v1.ImageSet r150 = r149.image;
    L211:
        ImageSet r151 = b.b(r150);
        if (r149 == null) goto L214;
        String r152 = r149.alt;
    L215:
        if (r149 == null) goto L217;
        com.bytedance.lark.pb.basic.v1.UDIcon r153 = r149.ud_icon;
    L218:
        UDIcon r154 = d(r153);
        if (r149 == null) goto L221;
        String r155 = r149.image_url;
    L222:
        if (r149 == null) goto L224;
        com.bytedance.lark.pb.basic.v1.ImageSet r156 = r149.dm_image;
    L225:
        ImageSet r157 = b.b(r156);
        if (r149 == null) goto L228;
        String r158 = r149.dm_image_url;
    L229:
        r52 = new ImageProperty(r151, r152, r154, r155, r157, r158);
        goto L272
    L228:
        r158 = null;
        goto L229
    L224:
        r156 = null;
        goto L225
    L221:
        r155 = null;
        goto L222
    L217:
        r153 = null;
        goto L218
    L214:
        r152 = null;
        goto L215
    L210:
        r150 = null;
        goto L211
    L230:
        URLPreviewComponent.RichTextProperty r159 = r47.richtext;
        i6b.a r160 = i6b.b.a;
        i6b.a r161 = i6b.b.a;
        if (r161 != null) goto L233;
        r10 = new RichTextProperty(null, 0, null, 6, null);
        goto L298
    L233:
        com.ss.android.lark.officesdk.integrator.im.e r162 = r161.g();
        if (r159 == null) goto L236;
        RichText r163 = r159.richtext;
    L237:
        com.ss.android.lark.widget.richtext.RichText r164 = r162.b(r163);
        if (r159 == null) goto L242;
        Integer r165 = r159.number_of_lines;
        if (r165 == null) goto L242;
        int r166 = r165.intValue();
    L243:
        if (r159 == null) goto L245;
        URLPreviewComponent.RichTextProperty.RichTextTheme r167 = r159.theme;
    L246:
        r125 = new RichTextProperty(r164, r166, r167);
        goto L175
    L245:
        r167 = null;
    L242:
        r166 = 0;
        goto L243
    L236:
        r163 = null;
        goto L237
    L247:
        URLPreviewComponent.PreviewHeaderProperty r168 = r47.header;
        if (r168 == null) goto L268;
        ImageSet r169 = b.b(r168.icon_key);
        String r170 = r168.title;
        Tag.a r171 = Tag.Companion;
        int r172 = r168.lark_tag.getValue();
        r171.getClass();
        Tag r173 = Tag.a.a(r172);
        String r174 = r168.child_component_id;
        Boolean r175 = r168.is_need_copy_link;
        Boolean r176 = r168.is_need_close;
        Theme.a r177 = Theme.Companion;
        int r178 = r168.theme.getValue();
        r177.getClass();
        Theme r179 = Theme.a.a(r178);
        PreviewHeaderProperty.HeaderType.a r180 = PreviewHeaderProperty.HeaderType.Companion;
        int r181 = r168.type.getValue();
        r180.getClass();
        if (r181 == 0) goto L254;
        if (r181 == 1) goto L253;
        PreviewHeaderProperty.HeaderType r182 = PreviewHeaderProperty.HeaderType.NORMAL;
    L255:
        PreviewHeaderProperty.HeaderType r183 = r182;
        Integer r184 = r168.number_of_lines;
        ThemeColor r185 = h.c(r168.tag_color);
        ThemeColor r186 = h.c(r168.tag_text_color);
        String r187 = r168.header_tag;
        String r188 = r168.favicon_url;
        ThemeColor r210 = h.c(r168.icon_color);
        UDIcon r211 = d(r168.ud_icon);
        Integer r189 = r168.icon_size;
        if (r189 != null) goto L258;
    L266:
        int r190 = 16;
    L267:
        r10 = new PreviewHeaderProperty(r169, r170, r173, r174, r175, r176, r179, r183, r184, r185, r186, r187, r188, r210, r211, Integer.valueOf(r190), b.b(r168.dm_icon));
        goto L298
    L258:
        if (r189.intValue() <= 0) goto L260;
        boolean r191 = true;
    L261:
        if (r191 == true) goto L264;
        r189 = null;
    L264:
        if (r189 == null) goto L266;
        r190 = r189.intValue();
        goto L267
    L260:
        r191 = false;
        goto L261
    L253:
        r182 = PreviewHeaderProperty.HeaderType.HEADLINES;
        goto L255
    L254:
        r182 = PreviewHeaderProperty.HeaderType.NORMAL;
        goto L255
    L268:
        r10 = new PreviewHeaderProperty(null, null, null, null, null, null, null, null, null, null, null, BuildConfig.FLAVOR, null, null, null, null, null, 126976, null);
        goto L298
    L269:
        URLPreviewComponent.FlexLayoutProperty r192 = r47.flex_layout;
        if (r192 == null) goto L273;
        Orientation.a r193 = Orientation.Companion;
        int r194 = r192.orientation.getValue();
        r193.getClass();
        Orientation r195 = Orientation.a.a(r194);
        FlexLayoutProperty.FlexWrap.a r196 = FlexLayoutProperty.FlexWrap.Companion;
        int r197 = r192.flex_wrap.getValue();
        r196.getClass();
        FlexLayoutProperty.FlexWrap r198 = FlexLayoutProperty.FlexWrap.a.a(r197);
        float r199 = r192.main_axis_spacing.floatValue();
        float r1100 = r192.cross_axis_spacing.floatValue();
        Padding r1101 = c(r192.padding);
        Justify.a r200 = Justify.Companion;
        int r201 = r192.main_axis_justify.getValue();
        r200.getClass();
        Justify r1102 = Justify.a.a(r201);
        Align.a r202 = Align.Companion;
        int r203 = r192.cross_axis_align.getValue();
        r202.getClass();
        r52 = new FlexLayoutProperty(r195, r198, r199, r1100, r1101, r1102, Align.a.a(r203), r192.force_use_compact_mode.booleanValue());
        goto L272
    L273:
        r10 = new FlexLayoutProperty(null, null, 0.0f, 0.0f, null, null, null, false, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
        goto L298
    L274:
        URLPreviewComponent.LinearLayoutProperty r204 = r47.linear_layout;
        if (r204 == null) goto L278;
        Orientation.a r205 = Orientation.Companion;
        int r206 = r204.orientation.getValue();
        r205.getClass();
        Orientation r207 = Orientation.a.a(r206);
        float r1103 = r204.spacing.floatValue();
        float r1104 = r204.wrap_width.floatValue();
        float r1105 = r204.padding.floatValue();
        Justify.a r208 = Justify.Companion;
        int r209 = r204.main_axis_justify.getValue();
        r208.getClass();
        Justify r1106 = Justify.a.a(r209);
        Align.a r212 = Align.Companion;
        int r213 = r204.cross_axis_align.getValue();
        r212.getClass();
        r85 = new LinearLayoutProperty(r207, r1103, r1104, r1105, r1106, Align.a.a(r213), c(r204.side_padding));
        goto L277
    L278:
        r10 = new LinearLayoutProperty(null, 0.0f, 0.0f, 0.0f, null, null, null, 127, null);
        goto L298
    L279:
        URLPreviewComponent.CardContainerProperty r214 = r47.card_container;
        Type r215 = Type.CARD_CONTAINER;
        if (r214 == null) goto L282;
        com.bytedance.lark.pb.basic.v1.ThemeColor r216 = r214.mask_color;
    L283:
        r52 = new IGProperty(r215, h.c(r216));
        goto L272
    L282:
        r216 = null;
        goto L283
    L284:
        URLPreviewComponent.EmptyProperty r217 = r47.empty;
        Type r218 = Type.EMPTY;
        if (r217 == null) goto L287;
        String r219 = r217.action_id;
    L288:
        r52 = new EmptyProperty(r218, r219);
        goto L272
    L287:
        r219 = null;
        goto L288
    L8:
        r5 = a.a[r3.ordinal()];
        goto L10
    }
}
