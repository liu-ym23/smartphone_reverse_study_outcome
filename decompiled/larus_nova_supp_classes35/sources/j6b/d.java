package j6b;

import android.util.LruCache;
import android.view.View;
import com.bytedance.lark.pb.basic.v1.EngineEntity;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.bytedance.lark.pb.basic.v1.PreviewData;
import com.bytedance.lark.pb.basic.v1.RenderRouterEntity;
import com.bytedance.lark.pb.basic.v1.RichText;
import com.bytedance.lark.pb.basic.v1.SerCrypto;
import com.bytedance.lark.pb.basic.v1.URL;
import com.bytedance.lark.pb.basic.v1.URLPreviewBody;
import com.bytedance.lark.pb.basic.v1.URLPreviewComponent;
import com.bytedance.lark.pb.basic.v1.URLPreviewComponents;
import com.bytedance.lark.pb.basic.v1.URLPreviewPropertyData;
import com.bytedance.lark.pb.basic.v1.URLPreviewState;
import com.bytedance.lark.pb.basic.v1.URLPreviewStyleData;
import com.bytedance.lark.pb.basic.v1.URLPreviewTemplate;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.url.v1.PrivateDescriptionId2Entries;
import com.bytedance.lark.pb.url.v1.PushUrlPreviews;
import com.bytedance.lark.pb.url.v1.UrlPreviewEntries;
import com.bytedance.lark.pb.url.v1.UrlPreviewEntry;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntry;
import com.ss.android.lark.chat.preview.entity.component.Tag;
import com.ss.android.lark.chat.preview.entity.component.Theme;
import com.ss.android.lark.chat.preview.entity.component.property.EmptyProperty;
import com.ss.android.lark.chat.preview.entity.component.property.ImageProperty;
import com.ss.android.lark.chat.preview.entity.component.property.LinearLayoutProperty;
import com.ss.android.lark.chat.preview.entity.component.property.PreviewHeaderProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TextViewProperty;
import com.ss.android.lark.chat.preview.entity.component.property.VideoProperty;
import com.ss.android.lark.export.api.UrlPreviewApi;
import com.ss.android.lark.export.entity.CardComponent;
import com.ss.android.lark.export.entity.ExtTranslateInfo;
import com.ss.android.lark.export.entity.Justify;
import com.ss.android.lark.export.entity.Orientation;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.WidthMode;
import com.ss.android.lark.export.entity.preview.Border;
import com.ss.android.lark.export.entity.preview.Cipher;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.Crypto;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.FontType;
import com.ss.android.lark.export.entity.preview.Gradient;
import com.ss.android.lark.export.entity.preview.ImagePassThrough;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Padding;
import com.ss.android.lark.export.entity.preview.SizeLevel;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UnifiedHeaderInfo;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponents;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import com.ss.android.lark.export.entity.preview.UrlPreviewStyleData;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import com.ss.android.lark.export.entity.preview.ext.UrlPreviewEntityExt;
import com.ss.android.lark.export.flexlayout.FlexLayoutProperty;
import com.ss.android.lark.export.parser.ModelParserRenderRouterEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.Align;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.tangram.base.style.Value;
import com.ss.android.lark.tangram.base.style.ValueType;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.ttvideoengine.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static ImagePassThrough a(ImageSetPassThrough r10) {
        Cipher r0 = null;
        byte[] r1 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        ImagePassThrough.Companion.getClass();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r3 = r10.fs_unit;
        String r4 = r10.key;
        SerCrypto r2 = r10.crypto;
        if (r2 == null) goto L22;
        Crypto.Companion.getClass();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r6 = r2.type.getValue();
        com.bytedance.lark.pb.basic.v1.Cipher r5 = r2.cipher;
        if (r5 == null) goto L21;
        Cipher.Companion.getClass();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ByteString r7 = r5.secret;
        if (r7 == null) goto L12;
        byte[] r8 = r7.toByteArray();
    L13:
        ByteString r9 = r5.nonce;
        if (r9 == null) goto L16;
        byte[] r11 = r9.toByteArray();
    L17:
        ByteString r12 = r5.additional_data;
        if (r12 == null) goto L20;
        r1 = r12.toByteArray();
    L20:
        r0 = new Cipher(r8, r11, r1);
        goto L21
    L16:
        r11 = null;
        goto L17
    L12:
        r8 = null;
    L21:
        Crypto r13 = new Crypto(r6, r0);
    L24:
        return new ImagePassThrough(r3, r4, r13, r10.file_type.getValue(), r10.width.intValue(), r10.height.intValue());
    L22:
        r13 = null;
        goto L24
    }

    public static UnifiedHeaderInfo b(UrlPreviewEntity.UnifiedHeader r5) {
        ColorIcon r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        UrlPreviewEntity.ColorIcon r6 = r5.icon;
        if (r6 == null) goto L10;
        r0 = new ColorIcon(b.b(r6.icon), r6.favicon_url, h.c(r6.icon_color), f.d(r6.ud_icon));
    L10:
        return new UnifiedHeaderInfo(r0);
    }

    @JvmStatic
    public static final UrlInlinePreviewEntity c(UrlPreviewEntity r11) {
        Intrinsics.checkNotNullParameter(r11, "pbUrlPreviewEntity");
        boolean r1 = false;
        UrlPreviewEntityExt r2 = null;
        UrlInlinePreviewEntity.AppInfo r3 = null;
        UrlPreviewEntityExt.UrlPreviewComponentRootDisplayVariant r4 = null;
        if (r11.is_sdk_preview.booleanValue() == false) goto L19;
        UrlInlinePreviewEntity.Builder r0 = new UrlInlinePreviewEntity.Builder().sourceId(r11.source_id).previewId(r11.preview_id);
        URL r5 = r11.url;
        if (r5 != null) goto L7;
        Url r10 = null;
    L8:
        UrlInlinePreviewEntity.Builder r6 = r0.url(r10);
        Boolean r7 = r11.need_reload;
        if (r7 == null) goto L11;
        r1 = r7.booleanValue();
    L11:
        UrlInlinePreviewEntity.Builder r8 = r6.needReload(r1).title(r11.sdk_title).version(r11.version.intValue()).passThroughImage(a(r11.server_icon_image)).isSdkPreview(true);
        UrlPreviewEntity.AppInfo r9 = r11.app_info;
        if (r9 == null) goto L15;
        r3 = new UrlInlinePreviewEntity.AppInfo(r9.app_id, r9.scene_type);
    L15:
        UrlInlinePreviewEntity.Builder r12 = r8.appInfo(r3).headerInfo(b(r11.unified_header));
        Boolean r13 = r11.use_color_icon;
        if (r13 != null) goto L18;
        r13 = Boolean.FALSE;
    L18:
        Intrinsics.checkNotNull(r13);
        return r12.useColorIcon(r13.booleanValue()).build();
    L7:
        r10 = new Url(r5.url, r5.ios, r5.android, r5.pc, r5.web);
        goto L8
    L19:
        UrlInlinePreviewEntity.Builder r14 = new UrlInlinePreviewEntity.Builder().sourceId(r11.source_id).previewId(r11.preview_id);
        URL r15 = r11.url;
        if (r15 != null) goto L22;
        Url r16 = null;
    L23:
        UrlInlinePreviewEntity.Builder r17 = r14.url(r16);
        Boolean r18 = r11.need_reload;
        if (r18 == null) goto L26;
        boolean r19 = r18.booleanValue();
    L27:
        UrlInlinePreviewEntity.Builder r20 = r17.needReload(r19).title(r11.server_title).netIconKey(r11.server_icon_key).netUrlTag(r11.server_tag).udIcon(f.d(r11.ud_icon)).version(r11.version.intValue()).passThroughImage(a(r11.server_icon_image)).isSdkPreview(false);
        UrlPreviewEntity.AppInfo r21 = r11.app_info;
        if (r21 != null) goto L30;
        UrlInlinePreviewEntity.AppInfo r22 = null;
    L31:
        UrlInlinePreviewEntity.Builder r23 = r20.appInfo(r22).headerInfo(b(r11.unified_header));
        Boolean r24 = r11.use_color_icon;
        if (r24 != null) goto L34;
        r24 = Boolean.FALSE;
    L34:
        Intrinsics.checkNotNull(r24);
        UrlInlinePreviewEntity.Builder r25 = r23.useColorIcon(r24.booleanValue());
        UrlPreviewEntity.ExtInfo r26 = r11.ext_info;
        if (r26 == null) goto L37;
        UrlPreviewEntity.SingleCardMode r27 = r26.single_card_mode;
    L38:
        UrlInlinePreviewEntity.Builder r28 = r25.singleCardMode(r27);
        UrlPreviewEntity.ExtInfo r29 = r11.ext_info;
        if (r29 == null) goto L52;
        UrlPreviewEntity.LastUpdateInfo r30 = r29.last_update_info;
        if (r30 == null) goto L52;
        Long r31 = r30.last_update_timestamp;
        if (r31 == null) goto L52;
        if (r31.longValue() == 0) goto L52;
        long r32 = r30.last_update_timestamp.longValue();
        ThemeColor r33 = h.c(r30.text_color);
        Boolean r34 = r30.visible;
        if (r34 == null) goto L51;
        r1 = r34.booleanValue();
    L51:
        UrlInlinePreviewEntity.LastUpdateInfo r35 = new UrlInlinePreviewEntity.LastUpdateInfo(r32, r33, r1);
    L53:
        UrlInlinePreviewEntity.Builder r36 = r28.lastUpdateInfo(r35);
        UrlPreviewEntity.ExtInfo r110 = r11.ext_info;
        if (r110 == null) goto L65;
        UrlPreviewEntity.DocInfo r37 = r110.doc_info;
        if (r37 == null) goto L59;
        UrlPreviewEntityExt.DocInfo r38 = new UrlPreviewEntityExt.DocInfo(r37.file_name, r37.file_token, r37.file_type, r37.mount_point);
    L60:
        UrlPreviewEntity.ComponentRootDisplayVariant r111 = r110.component_root_display_variant;
        if (r111 == null) goto L63;
        r4 = new UrlPreviewEntityExt.UrlPreviewComponentRootDisplayVariant(r111.default_root_id, r111.compact_root_id);
    L63:
        r2 = new UrlPreviewEntityExt(r38, r4);
        goto L65
    L59:
        r38 = null;
    L65:
        return r36.ext(r2).build();
    L52:
        r35 = null;
        goto L53
    L37:
        r27 = null;
        goto L38
    L30:
        r22 = new UrlInlinePreviewEntity.AppInfo(r21.app_id, r21.scene_type);
        goto L31
    L26:
        r19 = false;
        goto L27
    L22:
        r16 = new Url(r15.url, r15.ios, r15.android, r15.pc, r15.web);
        goto L23
    }

    @JvmStatic
    public static final List<UrlPreViewEntries> e(PushUrlPreviews r11) {
        Intrinsics.checkNotNullParameter(r11, "pushUrlPreviews");
        ArrayList r0 = new ArrayList(r11.url_preview_entries.size());
        Iterator r12 = r11.url_preview_entries.values().iterator();
    L4:
        if (r12.hasNext() == false) goto L29;
        Map r1 = ((PrivateDescriptionId2Entries) r12.next()).entries;
        if (r1 == null) goto L4;
        Iterator r2 = r1.entrySet().iterator();
    L9:
        if (r2.hasNext() == false) goto L4;
        Map.Entry r3 = (Map.Entry) r2.next();
        Long r8 = (Long) r3.getKey();
        UrlPreviewEntries r4 = (UrlPreviewEntries) r3.getValue();
        ArrayList r9 = new ArrayList(r4.entries.size());
        List r5 = r4.entries;
        if (r5 == null) goto L18;
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L18;
        UrlPreviewEntry r7 = (UrlPreviewEntry) r6.next();
        UrlPreviewEntity r10 = r7.preview_entity;
        if (r10 == null) goto L14;
        r9.add(new UrlPreViewEntry(r7.offset.intValue(), r7.length.intValue(), r7.preview_id, c(r10)));
    L18:
        String r13 = r4.source_id;
        String r14 = r4.source_text_md5;
        UrlPreViewEntries.UrlPreViewSourceType.a r15 = UrlPreViewEntries.UrlPreViewSourceType.Companion;
        int r16 = r4.source_type.getValue();
        r15.getClass();
        if (r16 != 1) goto L21;
        UrlPreViewEntries.UrlPreViewSourceType r17 = UrlPreViewEntries.UrlPreViewSourceType.CHAT_ANNOUNCEMENT;
    L28:
        r0.add(new UrlPreViewEntries(r13, r14, r17, r8, r9));
        goto L9
    L21:
        if (r16 != 10) goto L23;
        r17 = UrlPreViewEntries.UrlPreViewSourceType.PERSONAL_SIG;
        goto L28
    L23:
        if (r16 == 11) goto L25;
        r17 = null;
        goto L28
    L25:
        r17 = UrlPreViewEntries.UrlPreViewSourceType.PRIVATE_DESCRIPTION;
        goto L28
    L29:
        return r0;
    }

    @JvmStatic
    public static final UrlCardPreviewEntity d(UrlPreviewEntity r96, boolean r97) {
        Intrinsics.checkNotNullParameter(r96, "pbUrlPreviewEntity");
        boolean r2 = r96.is_sdk_preview.booleanValue();
        Float r3 = Float.valueOf(100.0f);
        if (r2 == false) goto L144;
        UrlInlinePreviewEntity r9 = c(r96);
        int r4 = f.a;
        Intrinsics.checkNotNullParameter(r96, "pbUrlPreviewEntity");
        String r1 = r96.sdk_title;
        if (r1 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        UrlInlinePreviewEntity r22 = r9;
    L135:
        UrlPreviewBody r10 = null;
    L316:
        return new UrlCardPreviewEntity(r22, r10, null, 0);
    L13:
        String r6 = r96.preview_id;
        Url r8 = e.c(r96.url);
        HashMap r15 = new HashMap();
        UrlPreviewState.Type r11 = UrlPreviewState.Type.CARD;
        Intrinsics.checkNotNull(r6);
        r15.put(r6, new UrlPreviewState(r11, r6, r8, null, null, null));
        HashMap r7 = new HashMap();
        String r12 = r96.sdk_iframe_url;
        if (r12 != null) goto L16;
    L19:
        boolean r13 = true;
    L20:
        r22 = r9;
        if (r13 == false) goto L88;
        String r14 = r96.sdk_video_id;
        if (r14 != null) goto L25;
    L28:
        boolean r16 = true;
    L29:
        if (r16 == false) goto L88;
        URLPreviewComponent.VideoProperty.Site r17 = r96.sdk_site_type;
        HashMap r21 = r15;
        if (r17 != null) goto L33;
    L36:
        String r18 = r96.sdk_title;
        if (r18 != null) goto L39;
    L42:
        boolean r19 = true;
    L43:
        if (r19 == false) goto L45;
        r6 = r6;
        r7 = r7;
        UrlPreviewComponents r20 = null;
    L131:
        if (r20 != null) goto L133;
        HashMap r23 = r7;
        String r24 = r6;
    L138:
        Map r110 = null;
        Intrinsics.checkNotNull(r24);
        long r25 = 0;
        URLPreviewBody r0 = r96.preview_body;
        if (r0 == null) goto L141;
        Map r26 = r0.component_hang_point_pairs;
    L142:
        r10 = new UrlPreviewBody(r20, r110, r8, r24, r21, r23, r25, f.b(r26), 64, null);
        goto L316
    L141:
        r26 = null;
        goto L142
    L133:
        if (CollectionUtils.isEmpty(r20.getRootIds()) == false) goto L136;
        Log.e("[URLPreview]ModelParserUrlPreviewBody", "rootIds is null or empty previewId:" + r96.preview_id);
        goto L135
    L136:
        r23 = r7;
        r24 = r6;
        r23.put(r24, new UrlPreviewTemplate((String) ListProtector.get(r20.getRootIds(), 0), r20.getElements(), r20.getImageIds(), null, r20.getButtonIds(), r20.getRichTextIds(), r6));
        goto L138
    L45:
        ArrayList r27 = new ArrayList();
        HashMap r28 = new HashMap();
        ArrayList r111 = new ArrayList();
        ArrayList r29 = new ArrayList();
        ArrayList r210 = new ArrayList();
        r27.add("root");
        if (r97 == false) goto L48;
        List r62 = CollectionsKt.listOf("rootLayoutNoHeader");
    L49:
        Type r30 = Type.LINEAR_LAYOUT;
        Boolean r112 = Boolean.TRUE;
        Orientation r113 = Orientation.COLUMN;
        Align r71 = Align.STRETCH;
        Justify r48 = null;
        r28.put("rootLayout", new UrlPreviewComponent(r30, r112, null, r62, r112, new LinearLayoutProperty(r113, 8.0f, 0.0f, 12.0f, r48, r71, null, 84, null)));
        ArrayList r31 = new ArrayList();
        Value r37 = null;
        r31.add(new ThemeColor("imtoken_message_card_bg_body_embed", 0, new ThemeColor.Key(null, null, 0, 4, null)));
        Gradient.GradientType r32 = Gradient.GradientType.LINEAR;
        Gradient r33 = new Gradient(r32, new Gradient.Linear(0, r31));
        Type r34 = Type.EMPTY;
        SizeLevel r73 = SizeLevel.NORMAL;
        FontLevel r35 = null;
        Border r36 = null;
        Value r38 = null;
        Value r39 = null;
        String r114 = null;
        r28.put("root", new UrlPreviewComponent(r34, r112, new Style(r73, r35, null, r36, r33, r37, r38, r39, null, null, null, 0, 0, 0.0f, null, 32744, r48), CollectionsKt.listOf("rootLayout"), r112, new EmptyProperty(r34, r114, 2, r114)));
        ArrayList r40 = new ArrayList();
        String r41 = r96.sdk_icon_url;
        if (r41 != null) goto L52;
    L55:
        boolean r42 = true;
    L57:
        if (r42 == true) goto L59;
        r40.add("cover");
    L59:
        r40.add("contentLayout");
        FontLevel r74 = null;
        ValueType r115 = ValueType.POINT;
        r28.put("rootLayoutNoHeader", new UrlPreviewComponent(r30, r112, new Style(r73, r74, null, null, null, null, null, null, null, new Value(r115, Float.valueOf(600.0f)), null, 0, 0, 0.0f, null, 32254, null), r40, r112, new LinearLayoutProperty(Orientation.ROW, 8.0f, 325.0f, 0.0f, Justify.START, r71, null, 64, r74)));
        String r43 = r96.sdk_icon_url;
        if (r43 != null) goto L62;
    L65:
        boolean r44 = true;
    L66:
        if (r44 == true) goto L68;
        ArrayList r45 = new ArrayList();
        r45.add(new ThemeColor("bg/float-overlay", 0, new ThemeColor.Key(null, null, 0, 7, null)));
        Style r310 = new Style(null, null, null, new Border(null, Float.valueOf(4.0f), null, 5, null), new Gradient(r32, new Gradient.Linear(0, r45)), new Value(r115, Float.valueOf(88.0f)), new Value(r115, Float.valueOf(88.0f)), null, null, null, null, 0, 0, 0.0f, null, 32647, null);
        List r311 = CollectionsKt.emptyList();
        r28.put("cover", new UrlPreviewComponent(Type.IMAGE, r112, r310, r311, r112, new ImageProperty(null, null, null, r96.sdk_icon_url, null, null, 48, null)));
        r111.add("cover");
    L68:
        ArrayList r46 = new ArrayList();
        r28.put("contentLayout", new UrlPreviewComponent(r30, r112, new Style(null, null, null, null, null, null, null, null, null, null, null, 0, 1, 0.0f, null, 28671, null), r46, r112, new LinearLayoutProperty(r113, 4.0f, 0.0f, 0.0f, null, null, null, 124, null)));
        String r47 = r96.sdk_title;
        if (r47 != null) goto L71;
    L74:
        boolean r49 = true;
    L75:
        if (r49 == true) goto L78;
        if (r97 == true) goto L78;
        Type r312 = Type.TEXT;
        ThemeColor r50 = new ThemeColor("text_title", 0, new ThemeColor.Key(null, null, 0, 7, null));
        Border r313 = null;
        Value r410 = null;
        Value r411 = null;
        Gradient r314 = null;
        Value r412 = null;
        Style r51 = new Style(null, new FontLevel(FontType.BODY, 1), r50, r313, r314, null, r412, r410, null, r411, null, 0, 0, 0.0f, null, 32761, null);
        List r315 = CollectionsKt.emptyList();
        String r52 = r96.sdk_title;
        int r316 = 2;
        r28.put("title", new UrlPreviewComponent(r312, r112, r51, r315, r112, new TextViewProperty(r52, r316, null, 4, null)));
        r46.add("title");
    L78:
        String r53 = r96.sdk_description;
        if (r53 != null) goto L81;
    L84:
        boolean r211 = true;
    L85:
        if (r211 == true) goto L87;
        Type r317 = Type.TEXT;
        Gradient r318 = null;
        Value r413 = null;
        Style r54 = new Style(null, new FontLevel(FontType.BODY, 2), new ThemeColor("text_caption", 0, new ThemeColor.Key(null, null, 0, 7, null)), null, r318, null, r413, null, null, null, null, 0, 1, 0.0f, null, 28665, null);
        List r319 = CollectionsKt.emptyList();
        String r55 = r96.sdk_description;
        int r320 = 2;
        r28.put("description", new UrlPreviewComponent(r317, r112, r54, r319, r112, new TextViewProperty(r55, r320, null, 4, null)));
        r46.add("description");
    L87:
        r20 = new UrlPreviewComponents(r27, r28, r111, r29, r210);
        goto L131
    L81:
        if (r53.length() == 0) goto L84;
        r211 = false;
        goto L85
    L71:
        if (r47.length() == 0) goto L74;
        r49 = false;
        goto L75
    L62:
        if (r43.length() == 0) goto L65;
        r44 = false;
        goto L66
    L52:
        if (r41.length() == 0) goto L55;
        r42 = false;
        goto L57
    L48:
        ArrayList r56 = new ArrayList();
        r56.add("header");
        r56.add("rootLayoutNoHeader");
        Type r321 = Type.HEADER;
        Boolean r322 = Boolean.TRUE;
        ImageSet r323 = null;
        Tag r414 = null;
        String r415 = null;
        Boolean r416 = null;
        Boolean r417 = null;
        Theme r418 = null;
        PreviewHeaderProperty.HeaderType r419 = null;
        Integer r420 = null;
        ThemeColor r421 = null;
        ThemeColor r422 = null;
        String r423 = null;
        r28.put("header", new UrlPreviewComponent(r321, r322, null, CollectionsKt.emptyList(), r322, new PreviewHeaderProperty(r323, r96.sdk_domain, r414, r415, r416, r417, r418, r419, r420, r421, r422, r423, r96.sdk_favicon_url, null, f.d(r96.ud_icon), null, null, 110589, null)));
        r62 = r56;
        goto L49
    L39:
        if (r18.length() == 0) goto L42;
        r19 = false;
        goto L43
    L33:
        if (r17 == URLPreviewComponent.VideoProperty.Site.UNKNOWN) goto L36;
    L35:
        r7 = r7;
        String r57 = r96.sdk_site_name;
        if (r57 != null) goto L92;
    L95:
        boolean r58 = true;
    L96:
        if (r58 == false) goto L98;
        UrlPreviewComponents r116 = null;
    L130:
        r20 = r116;
        goto L131
    L98:
        ArrayList r59 = new ArrayList();
        LinkedHashMap r60 = new LinkedHashMap();
        ArrayList r212 = new ArrayList();
        ArrayList r213 = new ArrayList();
        ArrayList r214 = new ArrayList();
        r59.add("root");
        ArrayList r117 = new ArrayList();
        r117.add(new ThemeColor("imtoken_message_card_bg_body_embed", 0, new ThemeColor.Key(null, null, 0, 4, null)));
        Gradient r61 = new Gradient(Gradient.GradientType.LINEAR, new Gradient.Linear(0, r117));
        Type r118 = Type.EMPTY;
        Boolean r119 = Boolean.TRUE;
        String r63 = null;
        r60.put("root", new UrlPreviewComponent(r118, r119, new Style(SizeLevel.NORMAL, null, null, null, r61, null, null, null, null, null, null, 0, 0, 0.0f, null, 32744, null), CollectionsKt.listOf("rootLayout"), r119, new EmptyProperty(r118, r63, 2, r63)));
        ArrayList r64 = new ArrayList();
        String r65 = r96.sdk_icon_url;
        if (r65 != null) goto L101;
    L104:
        boolean r66 = true;
    L106:
        if (r66 == true) goto L108;
        r64.add("video");
    L108:
        r64.add("contentLayout");
        Type r67 = Type.LINEAR_LAYOUT;
        Style r120 = new Style(null, null, null, null, null, new Value(ValueType.PERCENTAGE, r3), null, null, null, null, null, 0, 0, 0.0f, null, 32735, null);
        Orientation r324 = Orientation.COLUMN;
        r60.put("rootLayout", new UrlPreviewComponent(r67, r119, r120, r64, r119, new LinearLayoutProperty(r324, 0.0f, 0.0f, 0.0f, Justify.START, Align.STRETCH, null, 64, null)));
        String r68 = r96.sdk_icon_url;
        if (r68 != null) goto L111;
    L114:
        boolean r69 = true;
    L115:
        if (r69 == true) goto L117;
        Type r325 = Type.VIDEO;
        Style r326 = new Style(null, null, null, null, null, null, new Value(ValueType.POINT, Float.valueOf(224.0f)), null, null, null, null, 0, 0, 0.0f, null, 32703, null);
        List r327 = CollectionsKt.emptyList();
        VideoProperty.Site.a r70 = VideoProperty.Site.Companion;
        int r72 = r96.sdk_site_type.getValue();
        r70.getClass();
        VideoProperty.Site r424 = VideoProperty.Site.a.a(r72);
        String r75 = r96.sdk_icon_url;
        String r76 = r96.sdk_iframe_url;
        long r425 = 0;
        r60.put("video", new UrlPreviewComponent(r325, r119, r326, r327, r119, new VideoProperty(r424, null, r75, r425, null, r96.sdk_video_id, r76, 26, null)));
    L117:
        ArrayList r77 = new ArrayList();
        r77.add("header");
        r77.add("title");
        r60.put("contentLayout", new UrlPreviewComponent(r67, r119, null, r77, r119, new LinearLayoutProperty(r324, 7.0f, 0.0f, 12.0f, null, null, null, 112, null)));
        if (r97 == false) goto L120;
        r116 = new UrlPreviewComponents(r59, r60, r212, r213, r214);
        goto L130
    L120:
        Theme r610 = null;
        PreviewHeaderProperty.HeaderType r611 = null;
        ThemeColor r612 = null;
        String r78 = null;
        Tag r613 = null;
        String r614 = null;
        Integer r615 = null;
        ThemeColor r616 = null;
        ImageSet r510 = null;
        r60.put("header", new UrlPreviewComponent(Type.HEADER, r119, null, CollectionsKt.emptyList(), r119, new PreviewHeaderProperty(r510, r96.sdk_site_name, r613, r614, r119, r119, r610, r611, r615, r612, r616, r78, r96.sdk_favicon_url, null, f.d(r96.ud_icon), null, null, 110541, null)));
        Type r79 = Type.TEXT;
        FontType r80 = FontType.BODY;
        ThemeColor r81 = new ThemeColor("text_caption", 0, new ThemeColor.Key(null, null, 0, 7, null));
        Border r82 = null;
        Gradient r83 = null;
        Style r328 = new Style(null, new FontLevel(r80, 2), r81, r82, r83, null, null, null, null, null, null, 0, 0, 0.0f, null, 32761, null);
        List r329 = CollectionsKt.emptyList();
        String r84 = r96.sdk_title;
        int r426 = 0;
        r60.put("title", new UrlPreviewComponent(r79, r119, r328, r329, r119, new TextViewProperty(r84, r426, null, 4, null)));
        String r85 = r96.sdk_description;
        if (r85 != null) goto L123;
    L126:
        boolean r215 = true;
    L127:
        if (r215 == true) goto L129;
        Gradient r330 = null;
        Value r331 = null;
        Style r86 = new Style(null, new FontLevel(r80, 2), new ThemeColor("text_caption", 0, new ThemeColor.Key(null, null, 0, 7, null)), null, r330, null, r331, null, null, null, null, 0, 1, 0.0f, null, 28665, null);
        List r87 = CollectionsKt.emptyList();
        String r121 = r96.sdk_description;
        int r332 = 2;
        r60.put("description", new UrlPreviewComponent(r79, r119, r86, r87, r119, new TextViewProperty(r121, r332, null, 4, null)));
        r77.add("description");
    L129:
        r116 = new UrlPreviewComponents(r59, r60, r212, r213, r214);
        goto L130
    L123:
        if (r85.length() == 0) goto L126;
        r215 = false;
        goto L127
    L111:
        if (r68.length() == 0) goto L114;
        r69 = false;
        goto L115
    L101:
        if (r65.length() == 0) goto L104;
        r66 = false;
        goto L106
    L92:
        if (r57.length() == 0) goto L95;
        r58 = false;
        goto L96
    L25:
        if (r14.length() == 0) goto L28;
        r16 = false;
    L88:
        r21 = r15;
        goto L35
    L16:
        if (r12.length() == 0) goto L19;
        r13 = false;
        goto L20
    L7:
        if (r1.length() == 0) goto L10;
        r5 = false;
        goto L11
    L144:
        UrlInlinePreviewEntity r88 = c(r96);
        URLPreviewBody r89 = r96.preview_body;
        String r90 = r96.preview_id;
        int r91 = f.a;
        Intrinsics.checkNotNullParameter(r90, "previewId");
        if (r89 != null) goto L148;
        UrlInlinePreviewEntity r216 = r88;
        Float r217 = r3;
        UrlPreviewBody r92 = null;
    L232:
        int r93 = ModelParserRenderRouterEntity.a;
        UrlPreviewEntity r94 = r96;
        RenderRouterEntity r95 = r94.render_router_entity;
        if (r95 != null) goto L235;
        UrlPreviewBody r122 = r92;
        com.ss.android.lark.export.entity.RenderRouterEntity r98 = null;
    L288:
        UrlPreviewEntity.ExtInfo r99 = r94.ext_info;
        if (r99 == null) goto L291;
        UrlPreviewEntity.TranslateInfo r123 = r99.translate_info;
    L292:
        if (r123 == null) goto L294;
        String r100 = r123.inline_replacement_element_id;
    L295:
        if (r100 == null) goto L297;
        ExtTranslateInfo r101 = new ExtTranslateInfo(r123.inline_replacement_element_id);
    L299:
        return new UrlCardPreviewEntity(r216, r122, r98, 0, r101);
    L297:
        r101 = null;
        goto L299
    L294:
        r100 = null;
        goto L295
    L291:
        r123 = null;
        goto L292
    L235:
        WidthMode.a r102 = WidthMode.Companion;
        String r103 = r95.width_mode;
        r102.getClass();
        WidthMode r104 = WidthMode.a.a(r103);
        HashMap r105 = new HashMap();
        ArrayList r106 = new ArrayList();
        r106.addAll(r95.elements.keySet());
        TCStyle.a r107 = new TCStyle.a();
        Value r108 = new Value(ValueType.POINT, Float.valueOf(edb.c.a(r104)));
        Intrinsics.checkNotNullParameter(r108, "maxWidth");
        r107.g = r108;
        Value r109 = new Value(ValueType.PERCENTAGE, r217);
        Intrinsics.checkNotNullParameter(r109, "width");
        r107.a = r109;
        TCStyle r124 = null;
        r105.put("root_empty_id_render_router", new CardComponent(com.ss.android.lark.export.entity.Type.EMPTY, r106, new TCStyle(r109, r107.b, r107.e, r107.f, r107.g, r107.h, 0, 0, 0.0f, r107.c, r107.d, r107.i), null));
        Iterator r125 = r95.elements.entrySet().iterator();
    L237:
        if (r125.hasNext() == false) goto L287;
        Map.Entry r126 = (Map.Entry) r125.next();
        EngineEntity r127 = (EngineEntity) r95.engine_entities.get(r126.getKey());
        if (r127 != null) goto L241;
        r92 = r92;
        r125 = r125;
    L286:
        r125 = r125;
        r92 = r92;
        r124 = null;
        goto L237
    L241:
        com.bytedance.lark.pb.basic.v1.CardComponent r128 = (com.bytedance.lark.pb.basic.v1.CardComponent) r126.getValue();
        Intrinsics.checkNotNullParameter(r127, "pbEngineEntity");
        if (r128 != null) goto L244;
        r92 = r92;
        r125 = r125;
    L284:
        if (r124 == null) goto L286;
        r105.put(r126.getKey(), r124);
        goto L286
    L244:
        ArrayList r129 = new ArrayList();
        r129.addAll(r128.child_ids);
        com.ss.android.lark.export.entity.Type.a r130 = com.ss.android.lark.export.entity.Type.Companion;
        int r131 = r128.type.getValue();
        r130.getClass();
        if (r131 != 0) goto L247;
        com.ss.android.lark.export.entity.Type r132 = com.ss.android.lark.export.entity.Type.FLEX_LAYOUT;
    L254:
        com.bytedance.lark.pb.basic.v1.CardComponent.Style r133 = r128.style;
        int r134 = cdb.a.a;
        if (r133 == null) goto L258;
        Value r333 = cdb.a.a(r133.width);
        Value r334 = cdb.a.a(r133.height);
        Value r335 = cdb.a.a(r133.min_width);
        Value r336 = cdb.a.a(r133.min_height);
        Value r337 = cdb.a.a(r133.max_width);
        Value r338 = cdb.a.a(r133.max_height);
        int r339 = r133.grow_weight.intValue();
        int r340 = r133.shrink_weight.intValue();
        Align.a r135 = Align.Companion;
        int r136 = r133.align_self.getValue();
        r135.getClass();
        r124 = new TCStyle(r333, r334, r335, r336, r337, r338, r339, r340, 0.0f, null, null, Align.a.a(r136), 1536, null);
    L258:
        com.bytedance.lark.pb.basic.v1.CardComponent.Type r137 = r128.type;
        if (r137 != null) goto L261;
        int r138 = -1;
    L263:
        if (r138 != 1) goto L265;
        com.bytedance.lark.pb.basic.v1.CardComponent.FlexLayoutProperty r139 = r128.flex_layout;
        if (r139 == null) goto L282;
        Orientation.a r140 = Orientation.Companion;
        int r141 = r139.orientation.getValue();
        r140.getClass();
        Orientation r341 = Orientation.a.a(r141);
        FlexLayoutProperty.FlexWrap.a r142 = FlexLayoutProperty.FlexWrap.Companion;
        int r143 = r139.flex_wrap.getValue();
        r142.getClass();
        FlexLayoutProperty.FlexWrap r342 = FlexLayoutProperty.FlexWrap.a.a(r143);
        float r343 = r139.main_axis_spacing.floatValue();
        float r344 = r139.cross_axis_spacing.floatValue();
        com.bytedance.lark.pb.basic.v1.CardComponent.Padding r144 = r139.padding;
        if (r144 == null) goto L280;
        Padding r345 = new Padding(r144.top.floatValue(), r144.right.floatValue(), r144.bottom.floatValue(), r144.left.floatValue());
    L281:
        Justify.a r145 = Justify.Companion;
        int r146 = r139.main_axis_justify.getValue();
        r145.getClass();
        Justify r346 = Justify.a.a(r146);
        Align.a r147 = Align.Companion;
        int r148 = r139.cross_axis_align.getValue();
        r147.getClass();
        FlexLayoutProperty r149 = new FlexLayoutProperty(r341, r342, r343, r344, r345, r346, Align.a.a(r148), r139.force_use_compact_mode.booleanValue());
    L283:
        r124 = new CardComponent(r132, r129, r124, r149);
        goto L284
    L280:
        r345 = null;
        goto L281
    L282:
        r92 = r92;
        r125 = r125;
        r149 = new FlexLayoutProperty(null, null, 0.0f, 0.0f, null, null, null, false, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
        goto L283
    L265:
        if (r138 != 2) goto L274;
        ModelParserRenderRouterEntity.CardEngineType.a r150 = ModelParserRenderRouterEntity.CardEngineType.Companion;
        int r151 = r128.engine.type.getValue();
        r150.getClass();
        if (r151 != 0) goto L270;
        ModelParserRenderRouterEntity.CardEngineType r152 = ModelParserRenderRouterEntity.CardEngineType.UNIVERSAL_CARD;
    L271:
        com.ss.android.lark.export.a<? extends q6c.e<? extends Props, ? extends View, ? extends r6c.a>> r153 = ((UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class)).getCardEngineComponentFactory(r152);
        if (r153 == null) goto L274;
        r92 = r92;
        r125 = r125;
        r149 = r153.c(r128.engine, r127);
        goto L283
    L270:
        r152 = ModelParserRenderRouterEntity.CardEngineType.UNIVERSAL_CARD;
    L274:
        r92 = r92;
        r125 = r125;
        r149 = null;
        goto L283
    L261:
        r138 = ModelParserRenderRouterEntity.a.a[r137.ordinal()];
        goto L263
    L247:
        if (r131 != 1) goto L249;
        r132 = com.ss.android.lark.export.entity.Type.ENGINE_VIEW;
        goto L254
    L249:
        if (r131 == 100) goto L251;
        r132 = com.ss.android.lark.export.entity.Type.FLEX_LAYOUT;
        goto L254
    L251:
        r132 = com.ss.android.lark.export.entity.Type.EMPTY;
        goto L254
    L287:
        r122 = r92;
        r94 = r96;
        r98 = new com.ss.android.lark.export.entity.RenderRouterEntity("root_empty_id_render_router", r105, new HashMap(r95.engine_entities), r104);
        goto L288
    L148:
        if (CollectionUtils.isEmpty(r89.states) == true) goto L150;
    L173:
        HashMap r154 = new HashMap();
        UrlPreviewComponents r347 = null;
        Map r348 = null;
        Url r349 = null;
        String r155 = r89.current_state_id;
        Map r156 = r89.states;
        int r157 = g.a;
        String r158 = "templates";
        Intrinsics.checkNotNullParameter(r154, "templates");
        if (r156 != null) goto L176;
        r216 = r88;
        r217 = r3;
        String r350 = r155;
        HashMap r351 = null;
    L231:
        r92 = new UrlPreviewBody(r347, r348, r349, r350, r351, r154, 0, f.b(r89.component_hang_point_pairs), 64, null);
        goto L232
    L176:
        HashMap r159 = new HashMap();
        Iterator r160 = r156.entrySet().iterator();
    L178:
        if (r160.hasNext() == false) goto L230;
        Map.Entry r161 = (Map.Entry) r160.next();
        Object r162 = r161.getKey();
        URLPreviewState r163 = (URLPreviewState) r161.getValue();
        Intrinsics.checkNotNullParameter(r154, r158);
        if (r163 != null) goto L182;
        UrlInlinePreviewEntity r218 = r88;
        Float r219 = r3;
        String r352 = r155;
        String r164 = r158;
        UrlPreviewState r165 = null;
    L229:
        r159.put(r162, r165);
        r160 = r160;
        r158 = r164;
        r88 = r218;
        r3 = r219;
        r155 = r352;
        goto L178
    L182:
        LruCache<String, URLPreviewTemplate> r166 = l.a;
        UrlPreviewTemplate r167 = l.a(r163.template_id);
        UrlPreviewState.Type.a r168 = UrlPreviewState.Type.Companion;
        int r169 = r163.type.getValue();
        r168.getClass();
        if (r169 != 0) goto L185;
        UrlPreviewState.Type r170 = UrlPreviewState.Type.CARD;
    L189:
        UrlPreviewState.Type r220 = r170;
        String r171 = r163.template_id;
        Url r221 = e.c(r163.card_url);
        LinkedHashMap<String, UrlPreviewAction> r222 = e.e(r163.actions, true);
        Map r172 = r163.styles;
        if (r172 != null) goto L192;
        r218 = r88;
        r164 = r158;
        HashMap r223 = null;
    L208:
        Map r173 = r163.properties;
        if (r173 != null) goto L211;
        r219 = r3;
        r352 = r155;
        HashMap r224 = null;
    L228:
        r165 = new UrlPreviewState(r220, r171, r221, r222, r223, r224);
        r154.put(r163.template_id, r167);
        goto L229
    L211:
        HashMap r174 = new HashMap();
        Iterator r175 = r173.entrySet().iterator();
    L213:
        if (r175.hasNext() == false) goto L227;
        Map.Entry r176 = (Map.Entry) r175.next();
        URLPreviewPropertyData r177 = (URLPreviewPropertyData) r176.getValue();
        if (r177 != null) goto L217;
        UrlPreviewPropertyData r178 = null;
    L226:
        r174.put(r176.getKey(), r178);
        int r179 = g.a;
        g.a(r167, r178, (String) r176.getKey());
        r175 = r175;
        r3 = r3;
        r155 = r155;
        goto L213
    L217:
        HashMap r180 = new HashMap();
        Iterator r181 = r177.preview_property_data.entrySet().iterator();
    L219:
        if (r181.hasNext() == false) goto L221;
        Map.Entry r225 = (Map.Entry) r181.next();
        r180.put(r225.getKey(), h.b((PreviewData) r225.getValue()));
        r181 = r181;
        goto L219
    L221:
        Type.a r182 = Type.Companion;
        int r183 = r177.type.getValue();
        r182.getClass();
        Type r184 = Type.a.a(r183);
        RichText r185 = r177.rich_text;
        i6b.a r186 = i6b.b.a;
        i6b.a r187 = i6b.b.a;
        if (r187 != null) goto L224;
        com.ss.android.lark.widget.richtext.RichText r188 = null;
    L225:
        r178 = new UrlPreviewPropertyData(r184, r180, r188);
        goto L226
    L224:
        r188 = r187.g().b(r185);
        goto L225
    L227:
        r219 = r3;
        r352 = r155;
        r224 = r174;
        goto L228
    L192:
        HashMap r189 = new HashMap();
        Iterator r190 = r172.entrySet().iterator();
    L194:
        if (r190.hasNext() == false) goto L207;
        Map.Entry r191 = (Map.Entry) r190.next();
        Iterator r226 = r190;
        URLPreviewStyleData r192 = (URLPreviewStyleData) r191.getValue();
        int r193 = h.a;
        if (r192 == null) goto L198;
        Map r194 = r192.preview_style_data;
    L199:
        if (r194 != null) goto L201;
        UrlInlinePreviewEntity r227 = r88;
        UrlPreviewStyleData r195 = null;
    L206:
        r189.put(r191.getKey(), r195);
        g.b(r167, r195, (String) r191.getKey());
        r158 = r158;
        r190 = r226;
        r88 = r227;
        goto L194
    L201:
        HashMap r196 = new HashMap();
        Iterator r197 = r192.preview_style_data.entrySet().iterator();
    L203:
        if (r197.hasNext() == false) goto L205;
        Map.Entry r228 = (Map.Entry) r197.next();
        r196.put(r228.getKey(), h.b((PreviewData) r228.getValue()));
        r197 = r197;
        r88 = r88;
        goto L203
    L205:
        r227 = r88;
        r195 = new UrlPreviewStyleData(r196);
        goto L206
    L198:
        r194 = null;
        goto L199
    L207:
        r218 = r88;
        r164 = r158;
        r223 = r189;
        goto L208
    L185:
        if (r169 == 1) goto L187;
        r170 = UrlPreviewState.Type.CARD;
        goto L189
    L187:
        r170 = UrlPreviewState.Type.ALERT;
        goto L189
    L230:
        r216 = r88;
        r217 = r3;
        r350 = r155;
        r351 = r159;
        goto L231
    L150:
        if (r89.components == null) goto L173;
        if (r90.length() != 0) goto L154;
        boolean r198 = true;
    L155:
        if (r198 == false) goto L157;
        r90 = "LocalUrlPreview_" + UUID.randomUUID();
    L157:
        Url r229 = e.c(r89.card_url);
        LinkedHashMap<String, UrlPreviewAction> r230 = e.e(r89.actions, false);
        HashMap r199 = new HashMap();
        r199.put(r90, new UrlPreviewState(UrlPreviewState.Type.CARD, r90, r229, r230, null, null));
        HashMap r1100 = new HashMap();
        URLPreviewComponents r200 = r89.components;
        if (r200 != null) goto L160;
    L164:
        URLPreviewComponents r201 = r89.components;
        if (r201 != null) goto L167;
        UrlPreviewComponents r231 = null;
    L172:
        r216 = r88;
        r217 = r3;
        r92 = new UrlPreviewBody(r231, r230, r229, r90, r199, r1100, 0, f.b(r89.component_hang_point_pairs), 64, null);
        goto L232
    L167:
        LinkedHashMap r202 = new LinkedHashMap();
        Iterator r203 = r201.elements.entrySet().iterator();
    L169:
        if (r203.hasNext() == false) goto L171;
        Map.Entry r204 = (Map.Entry) r203.next();
        r202.put(r204.getKey(), f.f((URLPreviewComponent) r204.getValue(), r96));
        goto L169
    L171:
        r231 = new UrlPreviewComponents(r201.root_ids, r202, r201.image_ids, r201.button_ids, r201.richtext_ids);
        goto L172
    L160:
        if (r200.root_ids.size() <= 0) goto L162;
        String r205 = (String) ListProtector.get(r200.root_ids, 0);
    L163:
        UrlPreviewTemplate r206 = (UrlPreviewTemplate) r1100.put(r90, new UrlPreviewTemplate(r205, a.a(r200.elements, r96), r200.image_ids, r200.at_ids, r200.button_ids, r200.richtext_ids, r90));
        goto L164
    L162:
        r205 = null;
        goto L163
    L154:
        r198 = false;
        goto L155
    }
}
