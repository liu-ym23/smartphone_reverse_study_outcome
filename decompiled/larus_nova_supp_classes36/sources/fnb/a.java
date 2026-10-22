package fnb;

import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.bytedance.lark.pb.basic.v1.ThemeColor;
import com.bytedance.lark.pb.basic.v1.UDIcon;
import com.bytedance.lark.pb.basic.v1.URL;
import com.bytedance.lark.pb.basic.v1.URLPreviewBody;
import com.bytedance.lark.pb.basic.v1.URLPreviewComponent;
import com.bytedance.lark.pb.basic.v1.URLPreviewComponents;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.DriveFileType;
import com.ss.android.lark.chat.preview.service.d;
import com.ss.android.lark.chat.preview.service.impl.UrlPreviewService;
import com.ss.android.lark.core.keyboard.KeyboardBaseModuleDependencyImpl;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.utils.FileType;
import dagger.Lazy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w4b.f;
import wxa.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class a implements f {
    public final Lazy<UrlPreviewService> a;
    public final Lazy<d> b;

    public final void b() {
    }

    public final xcb.a c(Map<String, e> r22) {
        Intrinsics.checkNotNullParameter(r22, "driveFiles");
        int r2 = vhb.a.a;
        Intrinsics.checkNotNullParameter(r22, "driveFiles");
        LinkedHashMap r1 = new LinkedHashMap();
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<Map.Entry<String, e>> r0 = r22.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L76;
        Map.Entry<String, e> r4 = r0.next();
        String r5 = r4.getKey();
        e r6 = r4.getValue();
        String r7 = "flow-drive-" + UUID.randomUUID();
        UrlPreviewHangPoint.Builder r8 = new UrlPreviewHangPoint.Builder();
        String r9 = r6.e;
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        UrlPreviewHangPoint.Builder r10 = r8.url(r9).preview_id(r7);
        Boolean r11 = Boolean.TRUE;
        UrlPreviewHangPoint.Builder r12 = r10.need_local_preview(r11);
        Boolean r13 = Boolean.FALSE;
        r1.put(r5, r12.is_lazy_load(r13).send_scene(UrlPreviewHangPoint.SendScene.DOUBAO_CLOUD_DRIVE_CHOOSE).build());
        int r14 = vhb.a.a;
        UrlPreviewEntity.Builder r15 = new UrlPreviewEntity.Builder().source_id(UUID.randomUUID().toString()).preview_id(r7).is_sdk_preview(r13);
        URL.Builder r16 = new URL.Builder();
        String r17 = r6.e;
        if (r17 != null) goto L11;
        r17 = "";
    L11:
        UrlPreviewEntity.Builder r18 = r15.url(r16.url(r17).build()).version(0);
        boolean r19 = Intrinsics.areEqual(r6.getType(), DriveFileType.IMAGE.getValue());
        Float r110 = Float.valueOf(100.0f);
        if (r19 == false) goto L14;
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put("root", new URLPreviewComponent.Builder().type(URLPreviewComponent.Type.EMPTY).can_skip_when_unknown(r11).is_font_zoomable(r11).style(new URLPreviewComponent.Style.Builder().background_color(vhb.a.a()).width(new URLPreviewComponent.Value(URLPreviewComponent.ValueType.PERCENTAGE, r110)).aspect_ratio(1).build()).child_ids(CollectionsKt.listOf("docImage")).empty(new URLPreviewComponent.EmptyProperty.Builder().build()).build());
        r20.put("docImage", new URLPreviewComponent.Builder().type(URLPreviewComponent.Type.DOC_IMAGE).can_skip_when_unknown(r11).is_font_zoomable(r11).doc_image(new URLPreviewComponent.DocImageProperty.Builder().build()).build());
        URLPreviewBody r21 = new URLPreviewBody.Builder().components(new URLPreviewComponents.Builder().root_ids(CollectionsKt.listOf("root")).elements(r20).build()).build();
    L74:
        LinkedHashMap r23 = r3;
        r23.put(r7, r18.preview_body(r21).ext_info(new UrlPreviewEntity.ExtInfo.Builder().doc_info(new UrlPreviewEntity.DocInfo.Builder().file_token(r6.f).file_name(r6.c).build()).build()).build());
        r3 = r23;
        r0 = r0;
        r1 = r1;
        goto L4
    L14:
        LinkedHashMap r24 = new LinkedHashMap();
        r24.put("root", new URLPreviewComponent.Builder().type(URLPreviewComponent.Type.EMPTY).can_skip_when_unknown(r11).is_font_zoomable(r11).style(new URLPreviewComponent.Style.Builder().background_color(vhb.a.a()).width(new URLPreviewComponent.Value(URLPreviewComponent.ValueType.PERCENTAGE, r110)).build()).child_ids(CollectionsKt.listOf("rootLayout")).empty(new URLPreviewComponent.EmptyProperty.Builder().build()).build());
        URLPreviewComponent.Builder r25 = new URLPreviewComponent.Builder();
        URLPreviewComponent.Type r111 = URLPreviewComponent.Type.LINEAR_LAYOUT;
        URLPreviewComponent.Builder r26 = r25.type(r111).can_skip_when_unknown(r11).is_font_zoomable(r11).child_ids(CollectionsKt.listOf(new String[]{"title", "bottomLayout"}));
        URLPreviewComponent.LinearLayoutProperty.Builder r27 = new URLPreviewComponent.LinearLayoutProperty.Builder().orientation(URLPreviewComponent.Orientation.COLUMN);
        Float r28 = Float.valueOf(12.0f);
        r24.put("rootLayout", r26.linear_layout(r27.spacing(r28).padding(r28).cross_axis_align(URLPreviewComponent.Align.STRETCH).build()).build());
        URLPreviewComponent.Builder r29 = new URLPreviewComponent.Builder();
        URLPreviewComponent.Type r30 = URLPreviewComponent.Type.TEXT;
        URLPreviewComponent.Builder r31 = r29.type(r30).can_skip_when_unknown(r11).is_font_zoomable(r11).style(new URLPreviewComponent.Style.Builder().font_level(new URLPreviewComponent.FontLevel.Builder().type(URLPreviewComponent.FontType.TITLE).level(1).build()).text_color_v2(new ThemeColor.Builder().token("text_title").build()).build());
        URLPreviewComponent.TextProperty.Builder r32 = new URLPreviewComponent.TextProperty.Builder();
        String r33 = FileUtils.n(r6.c);
        if (r33 != null) goto L17;
        r33 = "";
    L17:
        r24.put("title", r31.text(r32.text(r33).number_of_lines(2).build()).build());
        r24.put("bottomLayout", new URLPreviewComponent.Builder().type(r111).can_skip_when_unknown(r11).is_font_zoomable(r11).child_ids(CollectionsKt.listOf(new String[]{"icon", "typeText"})).linear_layout(new URLPreviewComponent.LinearLayoutProperty.Builder().orientation(URLPreviewComponent.Orientation.ROW).spacing(Float.valueOf(6.0f)).cross_axis_align(URLPreviewComponent.Align.MIDDLE).build()).build());
        String r34 = r6.getType();
        if (r34 != null) goto L20;
        r34 = "";
    L20:
        boolean r112 = true;
        if (StringsKt.equals(r34, "ai_doc", true) == false) goto L24;
        String r35 = "file-ai_doc";
    L64:
        URLPreviewComponent.Builder r113 = new URLPreviewComponent.Builder().type(URLPreviewComponent.Type.IMAGE).can_skip_when_unknown(r11).is_font_zoomable(r11);
        URLPreviewComponent.Style.Builder r114 = new URLPreviewComponent.Style.Builder();
        URLPreviewComponent.Value.Builder r115 = new URLPreviewComponent.Value.Builder();
        URLPreviewComponent.ValueType r36 = URLPreviewComponent.ValueType.POINT;
        r24.put("icon", r113.style(r114.width(r115.type(r36).value(Float.valueOf(20.0f)).build()).height(new URLPreviewComponent.Value.Builder().type(r36).value(Float.valueOf(20.0f)).build()).build()).image(new URLPreviewComponent.ImageProperty.Builder().ud_icon(new UDIcon.Builder().key(r35).build()).build()).build());
        URLPreviewComponent.Builder r37 = new URLPreviewComponent.Builder().type(r30).can_skip_when_unknown(r11).is_font_zoomable(r11).style(new URLPreviewComponent.Style.Builder().font_level(new URLPreviewComponent.FontLevel.Builder().type(URLPreviewComponent.FontType.BODY).level(2).build()).text_color_v2(new ThemeColor.Builder().token("text_caption").build()).build());
        URLPreviewComponent.TextProperty.Builder r38 = new URLPreviewComponent.TextProperty.Builder();
        String r39 = r6.b;
        if (r39 != null) goto L72;
        String r40 = r6.getType();
        if (r40 == null) goto L69;
        r39 = r40.toUpperCase(Locale.ROOT);
    L70:
        if (r39 != null) goto L72;
        String r41 = "";
    L73:
        r24.put("typeText", r37.text(r38.text(r41).number_of_lines(1).build()).build());
        r21 = new URLPreviewBody.Builder().components(new URLPreviewComponents.Builder().root_ids(CollectionsKt.listOf("root")).elements(r24).build()).build();
        goto L74
    L69:
        r39 = null;
    L72:
        r41 = r39;
        goto L73
    L24:
        if (StringsKt.equals(r34, "ai_slides", true) == false) goto L27;
        r35 = "file-ai_slides";
        goto L64
    L27:
        if (StringsKt.equals(r34, "ai_sheet", true) == false) goto L30;
        r35 = "file-ai_sheet";
        goto L64
    L30:
        if (StringsKt.equals(r34, "others", true) == false) goto L33;
        r35 = "file-others";
        goto L64
    L33:
        if (r34.length() > 0) goto L36;
        r112 = false;
    L36:
        if (r112 == false) goto L38;
        FileType r42 = FileType.getFileTypeBySuffix(".".concat(r34));
    L39:
        if (r42 != null) goto L41;
        int r43 = -1;
    L42:
        switch(r43) {
            case 1: goto L63;
            case 2: goto L62;
            case 3: goto L61;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L56;
            case 9: goto L55;
            case 10: goto L54;
            case 11: goto L53;
            case 12: goto L52;
            case 13: goto L51;
            case 14: goto L50;
            case 15: goto L49;
            case 16: goto L48;
            case 17: goto L47;
            case 18: goto L46;
            case 19: goto L45;
            case 20: goto L44;
            default: goto L43;
        };
    L43:
        r35 = "file-unknown_colorful";
        goto L64
    L44:
        r35 = "file-folder_colorful";
        goto L64
    L45:
        r35 = "file-msg_colorful";
        goto L64
    L46:
        r35 = "file-eml_colorful";
        goto L64
    L47:
        r35 = "file-pages_colorful";
        goto L64
    L48:
        r35 = "file-numbers_colorful";
        goto L64
    L49:
        r35 = "file-keynote_colorful";
        goto L64
    L50:
        r35 = "file-ae_colorful";
        goto L64
    L51:
        r35 = "file-sketch_colorful";
        goto L64
    L52:
        r35 = "file-ai_colorful";
        goto L64
    L53:
        r35 = "file-android_colorful";
        goto L64
    L54:
        r35 = "file-text_colorful";
        goto L64
    L55:
        r35 = "file-audio_colorful";
        goto L64
    L56:
        r35 = "file-video_colorful";
        goto L64
    L57:
        r35 = "file-image_colorful";
        goto L64
    L58:
        r35 = "file-ps_colorful";
        goto L64
    L59:
        r35 = "file-zip_colorful";
        goto L64
    L60:
        r35 = "file-excel_colorful";
        goto L64
    L61:
        r35 = "file-word_colorful";
        goto L64
    L62:
        r35 = "file-ppt_colorful";
        goto L64
    L63:
        r35 = "file-pdf_colorful";
        goto L64
    L41:
        r43 = vhb.a.C0335a.a[r42.ordinal()];
        goto L42
    L38:
        r42 = FileType.TYPE_UNKNOWN;
        goto L39
    L76:
        return new xcb.a(r1, r3);
    }

    @Inject
    public a(Lazy<UrlPreviewService> r2, Lazy<d> r3) {
        Intrinsics.checkNotNullParameter(r2, "lazeUrlPreviewService");
        Intrinsics.checkNotNullParameter(r3, "lazeUrlPreviewPush");
        this.a = r2;
        this.b = r3;
        new ConcurrentHashMap();
    }

    public final Object a(List<PreviewHangPoint> r2, Continuation<? super Map<String, UrlCardPreviewEntity>> r3) {
        return ((UrlPreviewService) this.a.get()).b(r2, r3);
    }

    public final void d(String r2, long r3, long r5, KeyboardBaseModuleDependencyImpl.getTempPreview.1 r7) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ((UrlPreviewService) this.a.get()).getClass();
        UrlPreviewService.d(r2, r3, r5, r7);
    }
}
