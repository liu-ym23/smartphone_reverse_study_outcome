package j6b;

import com.ss.android.lark.chat.preview.entity.component.property.AvatarProperty;
import com.ss.android.lark.chat.preview.entity.component.property.ButtonProperty;
import com.ss.android.lark.chat.preview.entity.component.property.ChattersPreviewProperty;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.chat.preview.entity.component.property.IGProperty;
import com.ss.android.lark.chat.preview.entity.component.property.ImageProperty;
import com.ss.android.lark.chat.preview.entity.component.property.OverSizeTextProperty;
import com.ss.android.lark.chat.preview.entity.component.property.PreviewHeaderProperty;
import com.ss.android.lark.chat.preview.entity.component.property.RichTextProperty;
import com.ss.android.lark.chat.preview.entity.component.property.SpinButtonProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TagListProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TextViewProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TimeProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TimeZoneProperty;
import com.ss.android.lark.chat.preview.entity.component.property.VideoProperty;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.export.entity.preview.UrlPreviewStyleData;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Type.values().length];
            r0[Type.CARD_CONTAINER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L59:
            r0[Type.HEADER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L71:
            r0[Type.RICHTEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L45:
            r0[Type.IMAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L47:
            r0[Type.CHATTERS_PREVIEW.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L55:
            r0[Type.BUTTON.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L65:
            r0[Type.ICON_BUTTON.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L51:
            r0[Type.TEXT_BUTTON.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L61:
            r0[Type.TIME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L63:
            r0[Type.TEXT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L41:
            r0[Type.TAG_LIST.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L57:
            r0[Type.SPIN_BUTTON.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L69:
            r0[Type.AVATAR.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L39:
            r0[Type.VIDEO.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L49:
            r0[Type.DOC_IMAGE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L67:
            r0[Type.TIME_ZONE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L43:
            r0[Type.OVERSIZED_TEXT.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L20:
            a = r0;
        }
    }

    static {
    }

    public static void a(UrlPreviewTemplate r2, UrlPreviewPropertyData r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "componentId");
        if (r2 == null) goto L137;
        Map<String, UrlPreviewComponent> r5 = r2.getElements();
        BaseProperty r0 = null;
        if (r5 == null) goto L7;
        UrlPreviewComponent r6 = r5.get(r4);
    L8:
        if (r3 == null) goto L10;
        Type r7 = r3.getType();
    L11:
        if (r7 != null) goto L13;
        int r8 = -1;
    L14:
        switch(r8) {
            case 1: goto L128;
            case 2: goto L120;
            case 3: goto L112;
            case 4: goto L104;
            case 5: goto L96;
            case 6: goto L88;
            case 7: goto L88;
            case 8: goto L88;
            case 9: goto L80;
            case 10: goto L72;
            case 11: goto L64;
            case 12: goto L56;
            case 13: goto L48;
            case 14: goto L40;
            case 15: goto L32;
            case 16: goto L24;
            case 17: goto L16;
            default: goto L167;
        };
    L16:
        if (r6 == null) goto L18;
        BaseProperty r9 = r6.getProperty();
    L20:
        if ((r9 instanceof OverSizeTextProperty) == false) goto L22;
        r0 = (OverSizeTextProperty) r9;
    L22:
        if (r0 == null) goto L138;
        r0.patchData(r3);
        return;
    L138:
        return;
    L18:
        r9 = null;
        goto L20
    L24:
        if (r6 == null) goto L26;
        BaseProperty r10 = r6.getProperty();
    L28:
        if ((r10 instanceof TimeZoneProperty) == false) goto L30;
        r0 = (TimeZoneProperty) r10;
    L30:
        if (r0 == null) goto L140;
        r0.patchData(r3);
        return;
    L140:
        return;
    L26:
        r10 = null;
        goto L28
    L32:
        if (r6 == null) goto L34;
        BaseProperty r11 = r6.getProperty();
    L36:
        if ((r11 instanceof DocImageProperty) == false) goto L38;
        r0 = (DocImageProperty) r11;
    L38:
        if (r0 == null) goto L142;
        r0.patchData(r3);
        return;
    L142:
        return;
    L34:
        r11 = null;
        goto L36
    L40:
        if (r6 == null) goto L42;
        BaseProperty r12 = r6.getProperty();
    L44:
        if ((r12 instanceof VideoProperty) == false) goto L46;
        r0 = (VideoProperty) r12;
    L46:
        if (r0 == null) goto L144;
        r0.patchData(r3);
        return;
    L144:
        return;
    L42:
        r12 = null;
        goto L44
    L48:
        if (r6 == null) goto L50;
        BaseProperty r13 = r6.getProperty();
    L52:
        if ((r13 instanceof AvatarProperty) == false) goto L54;
        r0 = (AvatarProperty) r13;
    L54:
        if (r0 == null) goto L146;
        r0.patchData(r3);
        return;
    L146:
        return;
    L50:
        r13 = null;
        goto L52
    L56:
        if (r6 == null) goto L58;
        BaseProperty r14 = r6.getProperty();
    L60:
        if ((r14 instanceof SpinButtonProperty) == false) goto L62;
        r0 = (SpinButtonProperty) r14;
    L62:
        if (r0 == null) goto L148;
        r0.patchData(r3);
        return;
    L148:
        return;
    L58:
        r14 = null;
        goto L60
    L64:
        if (r6 == null) goto L66;
        BaseProperty r15 = r6.getProperty();
    L68:
        if ((r15 instanceof TagListProperty) == false) goto L70;
        r0 = (TagListProperty) r15;
    L70:
        if (r0 == null) goto L150;
        r0.patchData(r3);
        return;
    L150:
        return;
    L66:
        r15 = null;
        goto L68
    L72:
        if (r6 == null) goto L74;
        BaseProperty r16 = r6.getProperty();
    L76:
        if ((r16 instanceof TextViewProperty) == false) goto L78;
        r0 = (TextViewProperty) r16;
    L78:
        if (r0 == null) goto L152;
        r0.patchData(r3);
        return;
    L152:
        return;
    L74:
        r16 = null;
        goto L76
    L80:
        if (r6 == null) goto L82;
        BaseProperty r17 = r6.getProperty();
    L84:
        if ((r17 instanceof TimeProperty) == false) goto L86;
        r0 = (TimeProperty) r17;
    L86:
        if (r0 == null) goto L154;
        r0.patchData(r3);
        return;
    L154:
        return;
    L82:
        r17 = null;
        goto L84
    L88:
        if (r6 == null) goto L90;
        BaseProperty r18 = r6.getProperty();
    L92:
        if ((r18 instanceof ButtonProperty) == false) goto L94;
        r0 = (ButtonProperty) r18;
    L94:
        if (r0 == null) goto L156;
        r0.patchData(r3);
        return;
    L156:
        return;
    L90:
        r18 = null;
        goto L92
    L96:
        if (r6 == null) goto L98;
        BaseProperty r19 = r6.getProperty();
    L100:
        if ((r19 instanceof ChattersPreviewProperty) == false) goto L102;
        r0 = (ChattersPreviewProperty) r19;
    L102:
        if (r0 == null) goto L158;
        r0.patchData(r3);
        return;
    L158:
        return;
    L98:
        r19 = null;
        goto L100
    L104:
        if (r6 == null) goto L106;
        BaseProperty r20 = r6.getProperty();
    L108:
        if ((r20 instanceof ImageProperty) == false) goto L110;
        r0 = (ImageProperty) r20;
    L110:
        if (r0 == null) goto L160;
        r0.patchData(r3);
        return;
    L160:
        return;
    L106:
        r20 = null;
        goto L108
    L112:
        if (r6 == null) goto L114;
        BaseProperty r21 = r6.getProperty();
    L116:
        if ((r21 instanceof RichTextProperty) == false) goto L118;
        r0 = (RichTextProperty) r21;
    L118:
        if (r0 == null) goto L162;
        r0.patchData(r3);
        return;
    L162:
        return;
    L114:
        r21 = null;
        goto L116
    L120:
        if (r6 == null) goto L122;
        BaseProperty r22 = r6.getProperty();
    L124:
        if ((r22 instanceof PreviewHeaderProperty) == false) goto L126;
        r0 = (PreviewHeaderProperty) r22;
    L126:
        if (r0 == null) goto L164;
        r0.patchData(r3);
        return;
    L164:
        return;
    L122:
        r22 = null;
        goto L124
    L128:
        if (r6 == null) goto L130;
        BaseProperty r23 = r6.getProperty();
    L132:
        if ((r23 instanceof IGProperty) == false) goto L134;
        r0 = (IGProperty) r23;
    L134:
        if (r0 == null) goto L166;
        r0.patchData(r3);
        return;
    L166:
        return;
    L130:
        r23 = null;
        goto L132
    L167:
        return;
    L13:
        r8 = a.a[r7.ordinal()];
        goto L14
    L10:
        r7 = null;
        goto L11
    L7:
        r6 = null;
        goto L8
    }

    @JvmStatic
    public static final void b(UrlPreviewTemplate r1, UrlPreviewStyleData r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "componentId");
        if (r1 == null) goto L13;
        Map<String, UrlPreviewComponent> r4 = r1.getElements();
        if (r4 == null) goto L7;
        UrlPreviewComponent r5 = r4.get(r3);
    L8:
        if (r5 == null) goto L14;
        Style r6 = r5.getStyle();
        if (r6 == null) goto L15;
        r6.patchData(r2);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r5 = null;
        goto L8
    }
}
