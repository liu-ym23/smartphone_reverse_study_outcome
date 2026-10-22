package com.larus.uaigc.createpage.slides;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.uaigc.createpage.component.input.CreationInputComponent;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ny9.s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\u000e"}, d2 = {"Lcom/larus/uaigc/createpage/slides/SlidesCreationInputComponent;", "Lcom/larus/uaigc/createpage/component/input/CreationInputComponent;", "<init>", "()V", "attachmentComponent", "", "isInterceptActionSendClick", "", "shouldUseCreationSendMessageFlow", "onSend", "onSendParams", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "Companion", "ReferenceImage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesCreationInputComponent extends CreationInputComponent {
    public static final /* synthetic */ int G = 0;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/uaigc/createpage/slides/SlidesCreationInputComponent$ReferenceImage;", "", "uri", "", "width", "", "height", "<init>", "(Ljava/lang/String;II)V", "getUri", "()Ljava/lang/String;", "getWidth", "()I", "getHeight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class b {

        @SerializedName("height")
        private final int height;

        @SerializedName("uri")
        private final String uri;

        @SerializedName("width")
        private final int width;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L12;
            return false;
        L12:
            if (this.width == r6.width) goto L15;
            return false;
        L15:
            if (this.height == r6.height) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.uri;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((r1 * 31) + this.width) * 31) + this.height;
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "ReferenceImage(uri=" + this.uri + ", width=" + this.width + ", height=" + this.height + ')';
        }

        public b() {
            this("", 0, 0);
        }

        public b(String r1, int r2, int r3) {
            this.uri = r1;
            this.width = r2;
            this.height = r3;
        }
    }

    static {
    }

    @Override // com.larus.uaigc.createpage.component.input.CreationInputComponent
    public final boolean p4() {
        return false;
    }

    @Override // com.larus.uaigc.createpage.component.input.CreationInputComponent
    public final void Y2() {
        k1a.b.b(this, new com.larus.uaigc.createpage.slides.b(this));
    }

    @Override // com.larus.uaigc.createpage.component.input.CreationInputComponent
    public final boolean d4() {
        return super.d4();
    }

    public SlidesCreationInputComponent() {
    }

    @Override // com.larus.uaigc.createpage.component.input.CreationInputComponent
    public final void e4(ICoreInputAbility.OnSendParams r14) {
        Intrinsics.checkNotNullParameter(r14, "onSendParams");
        FLogger.a.d("SlidesCreationInputComponent", "onSend: " + r14);
        ICoreInputAbility r0 = D3();
        boolean r1 = false;
        if (r0 == null) goto L5;
        r0.qp(false);
    L5:
        String r2 = r14.getContent();
        ArrayList r3 = new ArrayList();
        s r4 = C3();
        String r5 = "";
        if (r4 == null) goto L11;
        Bundle r6 = r4.a;
        if (r6 == null) goto L11;
        String r7 = r6.getString("query_image_ratio", "");
        if (r7 == null) goto L11;
    L12:
        ys8.a r8 = Q3();
        String r9 = null;
        if (r8 == null) goto L15;
        NestedFileContent r10 = r8.Wd();
    L17:
        if (r10 == null) goto L50;
        List r11 = r10.getEntities();
        if (r11 != null) goto L21;
    L23:
        boolean r12 = false;
    L24:
        if (r12 == false) goto L50;
        List r13 = r10.getEntities();
        if (r13 == null) goto L50;
        Iterator r15 = r13.iterator();
    L29:
        if (r15.hasNext() == false) goto L50;
        UplinkFileEntity r16 = (UplinkFileEntity) r15.next();
        Integer r17 = r16.getEntityType();
        int r18 = UplinkEntityType.EntityTypeImage.getValue();
        if (r17 == null) goto L29;
        if (r17.intValue() != r18) goto L29;
        UplinkEntityContent r19 = r16.getUplinkEntityContent();
        if (r19 == null) goto L29;
        Image r20 = r19.getUplinkImageInfo();
        if (r20 == null) goto L29;
        String r110 = r20.key;
        if (r110 != null) goto L42;
    L44:
        r110 = null;
    L45:
        ImageObj r21 = r20.imageOri;
        if (r110 == null) goto L49;
        if (r21 == null) goto L49;
        r3.add(new b(r110, r21.width, r21.height));
    L49:
        FLogger.a.w("SlidesCreationInputComponent", "onSend skip reference image: empty uri or imageOri");
        goto L29
    L42:
        if ((!StringsKt.isBlank(r110)) == false) goto L44;
    L21:
        if ((!r11.isEmpty()) != true) goto L23;
        r12 = true;
    L50:
        String r22 = GsonProtectorUtils.toJson(new Gson(), r3);
        FLogger.a.d("SlidesCreationInputComponent", "onSend queryImageListString=" + r22 + " queryImageRatio=" + r7 + " queryText=" + r2);
        s r23 = C3();
        if (r23 == null) goto L53;
        ChatParam r24 = r23.c();
    L54:
        s r25 = C3();
        if (r25 == null) goto L57;
        lr9.a r26 = (lr9.a) r25.g.getValue();
    L58:
        s r27 = C3();
        if (r27 == null) goto L61;
        String r28 = (String) r27.f.getValue();
    L62:
        i r111 = SmartRouter.buildRoute(getContext(), "//flow/slides_generate_image");
        r111.c.putExtra("gen_images_query_image_list", r22);
        r111.c.putExtra("gen_images_query_ratio", r7);
        r111.c.putExtra("gen_images_query_text", r2);
        r111.c.putExtra("slides_mob_config", r28);
        r111.c.putExtra("chat_param", r24);
        r111.d = 2130772381;
        r111.e = 2130772399;
        r111.e(80001);
        if (r26 == null) goto L65;
        String r29 = r26.e();
    L66:
        if (r29 != null) goto L68;
        r29 = "";
    L68:
        if (r26 == null) goto L70;
        String r30 = r26.f();
    L71:
        if (r30 != null) goto L73;
        r30 = "";
    L73:
        if (r26 == null) goto L75;
        Integer r31 = r26.g();
    L76:
        if (r26 == null) goto L78;
        String r32 = r26.b();
    L79:
        if (r32 != null) goto L81;
        r32 = "";
    L81:
        if (r26 == null) goto L83;
        Integer r112 = r26.c();
    L84:
        if (r26 == null) goto L86;
        String r113 = r26.a();
    L87:
        if (r113 != null) goto L89;
        r113 = "";
    L89:
        String r114 = r14.getScene();
        if (r114 != null) goto L92;
    L93:
        r1 = true;
    L94:
        if (r1 == false) goto L96;
        String r115 = "keyboard";
    L97:
        if (r24 == null) goto L99;
        String r33 = r24.a;
    L100:
        if (r33 != null) goto L102;
        r33 = "";
    L102:
        if (r24 == null) goto L104;
        String r34 = r24.b;
    L105:
        if (r34 != null) goto L107;
        r34 = "";
    L107:
        if (r26 == null) goto L109;
        r9 = r26.d();
    L109:
        if (r9 == null) goto L112;
        r5 = r9;
    L112:
        JSONObject r35 = new JSONObject();
        Intrinsics.checkNotNullParameter(r35, "params");
        r35.put("presentation_id", r29);     // Catch: JSONException -> L124
        r35.put("resource_id", r30);     // Catch: JSONException -> L124
        if (r31 == null) goto L116;
        r35.put("resource_type", r31.intValue());     // Catch: JSONException -> L124
    L116:
        r35.put("artifact_meta_id", r32);     // Catch: JSONException -> L124
        if (r112 == null) goto L119;
        r35.put("artifact_type", r112.intValue());     // Catch: JSONException -> L124
    L119:
        r35.put("aippt_task_id", r113);     // Catch: JSONException -> L124
        r35.put("current_page", "aippt_new_detail");     // Catch: JSONException -> L124
        if (r115 == null) goto L122;
        r35.put("scene", r115);     // Catch: JSONException -> L124
    L122:
        r35.put("conversation_id", r33);     // Catch: JSONException -> L124
        r35.put("bot_id", r34);     // Catch: JSONException -> L124
        r35.put("message_id", r5);     // Catch: JSONException -> L124
        r35.put("canvas_type", "aippt_new");     // Catch: JSONException -> L124
    L126:
        TrackParams r116 = new TrackParams().merge(r35);
        by7.a r36 = new by7.a("aippt_picture_query_send");
        r36.a.merge(r116);
        r36.b();
        return;
    L124:
        e = move-exception;
        FLogger.a.e("AIPPTGenerateImageHelper", "error in AIPPTGenerateImageHelper mobAIPPTPictureQuerySend " + e.getLocalizedMessage());
        goto L126
    L104:
        r34 = null;
        goto L105
    L99:
        r33 = null;
        goto L100
    L96:
        r115 = r14.getScene();
        goto L97
    L92:
        if (r114.length() != 0) goto L94;
    L86:
        r113 = null;
        goto L87
    L83:
        r112 = null;
        goto L84
    L78:
        r32 = null;
        goto L79
    L75:
        r31 = null;
        goto L76
    L70:
        r30 = null;
        goto L71
    L65:
        r29 = null;
        goto L66
    L61:
        r28 = null;
        goto L62
    L57:
        r26 = null;
        goto L58
    L53:
        r24 = null;
        goto L54
    L15:
        r10 = null;
    L11:
        r7 = "";
        goto L12
    }
}
