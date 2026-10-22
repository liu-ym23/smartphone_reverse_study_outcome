package j6b;

import com.bytedance.lark.pb.basic.v1.URLPreviewComponent;
import com.ss.android.lark.export.entity.preview.AvatarChatterInfo;
import com.ss.android.lark.export.entity.preview.ChatterInfos;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.FontType;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Item;
import com.ss.android.lark.export.entity.preview.Items;
import com.ss.android.lark.export.entity.preview.KeyTag;
import com.ss.android.lark.export.entity.preview.Padding;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.StringList;
import com.ss.android.lark.export.entity.preview.TagList;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.ThemeColors;
import com.ss.android.lark.tangram.base.style.Value;
import com.ss.android.lark.tangram.base.style.ValueType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static FontLevel a(URLPreviewComponent.FontLevel r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        FontType.a r1 = FontType.Companion;
        URLPreviewComponent.FontType r2 = r4.type;
        int r3 = 0;
        if (r2 == null) goto L8;
        int r5 = r2.getValue();
    L9:
        r1.getClass();
        if (r5 != 0) goto L12;
        FontType r6 = FontType.TITLE;
    L19:
        Integer r7 = r4.level;
        if (r7 == null) goto L23;
        r3 = r7.intValue();
    L23:
        return new FontLevel(r6, r3);
    L12:
        if (r5 != 1) goto L14;
        r6 = FontType.HEADLINE;
        goto L19
    L14:
        if (r5 == 2) goto L16;
        r6 = FontType.CAPTION;
        goto L19
    L16:
        r6 = FontType.BODY;
        goto L19
    L8:
        r5 = 0;
        goto L9
    }

    @JvmStatic
    public static final PreviewData b(com.bytedance.lark.pb.basic.v1.PreviewData r21) {
        if (r21 != null) goto L5;
        return null;
    L5:
        String r3 = r21.str;
        Integer r4 = r21.i32;
        Long r5 = r21.i64;
        Boolean r6 = r21.b;
        Float r7 = r21.f;
        com.bytedance.lark.pb.basic.v1.PreviewData.Items r2 = r21.items;
        if (r2 != null) goto L8;
        Items r8 = null;
    L15:
        ThemeColor r9 = c(r21.theme_color);
        Padding r10 = f.c(r21.padding);
        ImageSet r11 = b.b(r21.image_set);
        com.bytedance.lark.pb.basic.v1.PreviewData.ThemeColors r12 = r21.theme_colors;
        if (r12 != null) goto L18;
        ThemeColors r13 = null;
    L19:
        Value r14 = f(r21.layout_value);
        com.bytedance.lark.pb.basic.v1.PreviewData.ChatterInfos r15 = r21.chatter_infos;
        if (r15 != null) goto L22;
        ChatterInfos r16 = null;
    L23:
        com.bytedance.lark.pb.basic.v1.PreviewData.StringList r17 = r21.string_list;
        if (r17 != null) goto L26;
        StringList r18 = null;
    L27:
        URLPreviewComponent.AvatarProperty.ChatterInfo r1 = r21.chatter_info;
        StringList r19 = r18;
        if (r1 == null) goto L30;
        String r110 = r1.avatar_key;
    L31:
        if (r1 == null) goto L33;
        String r20 = r1.chatter_id;
    L34:
        AvatarChatterInfo r22 = new AvatarChatterInfo(r110, r20);
        FontLevel r23 = a(r21.font_level);
        com.bytedance.lark.pb.basic.v1.PreviewData.TagList r0 = r21.tag_list;
        if (r0 != null) goto L37;
        FontLevel r111 = r23;
        AvatarChatterInfo r24 = r22;
        ChatterInfos r25 = r16;
        TagList r26 = null;
    L43:
        return new PreviewData(r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r25, r19, r24, r111, r26);
    L37:
        ArrayList r112 = new ArrayList();
        Iterator r27 = r0.mixed_tags.iterator();
    L39:
        if (r27.hasNext() == false) goto L41;
        Iterator r28 = r27;
        URLPreviewComponent.TagListProperty.Tag r29 = (URLPreviewComponent.TagListProperty.Tag) r27.next();
        r112.add(new KeyTag(r29.tag, c(r29.text_color), c(r29.background_color)));
        r27 = r28;
        r22 = r22;
        r23 = r23;
        r16 = r16;
        goto L39
    L41:
        r111 = r23;
        r25 = r16;
        r26 = new TagList(r112);
        r24 = r22;
        goto L43
    L33:
        r20 = null;
        goto L34
    L30:
        r110 = null;
        goto L31
    L26:
        r18 = new StringList(r17.string_list);
        goto L27
    L22:
        r16 = new ChatterInfos(f.a(r15.chatter_infos));
        goto L23
    L18:
        r13 = new ThemeColors(d(r12.colors));
        goto L19
    L8:
        ArrayList r30 = new ArrayList();
        List r31 = r2.items;
        if (r31 == null) goto L14;
        Iterator r32 = r31.iterator();
    L12:
        if (r32.hasNext() == false) goto L14;
        URLPreviewComponent.Item r33 = (URLPreviewComponent.Item) r32.next();
        r30.add(new Item(r33.action_id, r33.text));
    L14:
        r8 = new Items(r30);
        goto L15
    }

    @JvmStatic
    public static final ThemeColor c(com.bytedance.lark.pb.basic.v1.ThemeColor r7) {
        Integer r0 = null;
        if (r7 != null) goto L5;
        return null;
    L5:
        com.bytedance.lark.pb.basic.v1.ThemeColor.Key r1 = r7.key;
        String r3 = r7.token;
        Integer r8 = r7.value;
        ThemeColor.KeyType.a r5 = ThemeColor.KeyType.Companion;
        if (r1 == null) goto L10;
        com.bytedance.lark.pb.basic.v1.ThemeColor.KeyType r6 = r1.type;
        if (r6 == null) goto L10;
        Integer r9 = Integer.valueOf(r6.getValue());
    L11:
        r5.getClass();
        ThemeColor.KeyType r10 = ThemeColor.KeyType.a.a(r9);
        if (r1 == null) goto L14;
        r0 = r1.value;
    L14:
        if (r1 == null) goto L18;
        Integer r2 = r1.alpha;
        if (r2 == null) goto L18;
        int r4 = r2.intValue();
    L20:
        return new ThemeColor(r3, r8, new ThemeColor.Key(r10, r0, r4));
    L18:
        r4 = 100;
    L10:
        r9 = null;
        goto L11
    }

    @JvmStatic
    public static final ArrayList<ThemeColor> d(List<com.bytedance.lark.pb.basic.v1.ThemeColor> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ArrayList<ThemeColor> r0 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        ThemeColor r1 = c((com.bytedance.lark.pb.basic.v1.ThemeColor) r3.next());
        if (r1 == null) goto L7;
        r0.add(r1);
        goto L7
    L11:
        return r0;
    }

    @JvmStatic
    public static final com.bytedance.lark.pb.basic.v1.ThemeColor e(ThemeColor r3) {
        com.bytedance.lark.pb.basic.v1.ThemeColor.Key r0 = null;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.getKey() == null) goto L18;
        if (r3.getKey().getType() == null) goto L18;
        if (r3.getKey().getValue() == null) goto L18;
        com.bytedance.lark.pb.basic.v1.ThemeColor.Key.Builder r1 = new com.bytedance.lark.pb.basic.v1.ThemeColor.Key.Builder();
        ThemeColor.KeyType r2 = r3.getKey().getType();
        if (r2 == null) goto L15;
        int r4 = r2.getValue();
    L16:
        r0 = r1.type(com.bytedance.lark.pb.basic.v1.ThemeColor.KeyType.fromValue(r4)).value(r3.getKey().getValue()).alpha(Integer.valueOf(r3.getKey().getAlpha())).build();
        goto L18
    L15:
        r4 = 1000;
    L18:
        return new com.bytedance.lark.pb.basic.v1.ThemeColor.Builder().token(r3.getToken()).value(r3.getValue()).key(r0).build();
    }

    @JvmStatic
    public static final Value f(URLPreviewComponent.Value r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        ValueType.a r1 = ValueType.Companion;
        int r2 = r3.type.getValue();
        r1.getClass();
        return new Value(ValueType.a.a(r2), r3.value);
    }
}
