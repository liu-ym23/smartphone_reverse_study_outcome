package ag8;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.m1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.api.l0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.d5;
import com.larus.bmhome.chat.layout.widget.i0;
import com.larus.bmhome.chat.list.cell.send_image.SendImageCell;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r implements i0 {
    public final /* synthetic */ SendImageCell a;
    public final /* synthetic */ Image b;

    public static final class a implements zs8.a {
        public a() {
        }

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String b() {
            return "chat";
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getBotId() {
            return null;
        }

        public final String getChatType() {
            return null;
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getEnterMethod() {
            return "click_image_edit_button";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }
    }

    public static final class b implements zs8.a {
        public b() {
        }

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String b() {
            return "chat";
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getBotId() {
            return null;
        }

        public final String getChatType() {
            return null;
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getEnterMethod() {
            return "ai_edit_picture_overview";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }
    }

    @Override // com.larus.bmhome.chat.layout.widget.i0
    public final void a() {
        s r1 = (s) ((BaseMessageListCell) this.a).d;
        if (r1 == null) goto L9;
        Message r2 = r1.a;
        if (r2 == null) goto L9;
        Map r3 = r2.getBusinessExt();
        if (r3 == null) goto L9;
        String r4 = (String) r3.get("message_case_mode");
    L11:
        if (Intrinsics.areEqual(r4, "1") == false) goto L17;
        t19.s r5 = t19.s.a;
        AppHost.Companion r6 = AppHost.a;
        Application r7 = r6.getApplication();
        String r8 = r6.getApplication().getString(2131909395);
        if (r8 != null) goto L15;
        r8 = "";
    L15:
        r5.getClass();
        t19.s.t(r7, r8);
        return;
    L17:
        SendImageCell r9 = this.a;
        int r10 = SendImageCell.t;
        r9.getClass();
        q0 r11 = lf8.a.b(r9);
        if (r11 == null) goto L24;
        l0 r12 = r11.D9();
        if (r12 == null) goto L24;
        com.larus.bmhome.instruction.g r13 = (com.larus.bmhome.instruction.g) r12.invoke();
        if (r13 == null) goto L24;
        Pair r14 = r13.N8();
    L25:
        if (r14 == null) goto L96;
        SendImageCell r15 = this.a;
        Image r16 = this.b;
        Activity r21 = AppHost.a.a().getCurrentActivity();
        if (r21 == null) goto L80;
        z0 r59 = (z0) r14.getFirst();
        Message r17 = r15.f;
        if (r17 == null) goto L35;
        Map r18 = r17.getExt();
        if (r18 == null) goto L35;
        m1 r19 = ic8.j.d(r18);
        if (r19 == null) goto L35;
        MediaAttachment r20 = r19.d;
    L36:
        if (r20 == null) goto L38;
        String r22 = r20.getMaskUri();
    L40:
        if (o0.d(r22) == false) goto L69;
        if (r20 == null) goto L43;
        String r23 = r20.getUri();
    L45:
        if (o0.d(r23) == false) goto L69;
        if (r20 == null) goto L49;
        String r24 = r20.getUri();
    L51:
        if (r20 == null) goto L53;
        String r25 = r20.getUrl();
    L54:
        if (r20 == null) goto L60;
        ImageUploadInfo r26 = r20.getImageUploadInfo();
        if (r26 == null) goto L60;
        Long r27 = r26.getWidth();
        if (r27 == null) goto L60;
        int r28 = (int) r27.longValue();
    L61:
        if (r20 == null) goto L67;
        ImageUploadInfo r29 = r20.getImageUploadInfo();
        if (r29 == null) goto L67;
        Long r30 = r29.getHeight();
        if (r30 == null) goto L67;
        int r31 = (int) r30.longValue();
    L68:
        r16 = new Image(r24, null, null, new ImageObj(r25, r28, r31, null, null, 24, null), null, null, null, null, null, null, null, null, null, null, 16374, null);
    L79:
        Image r210 = r16;
        ICreationWorkflowService.a.f0(new ny9.b(false, r21, r59, SendImageCell.o(r15, ((Boolean) r14.getSecond()).booleanValue()), ((Boolean) r14.getSecond()).booleanValue(), false, null, null, null, null, null, null, null, null, r210, null, null, null, null, false, false, new a(), null, com.larus.utils.f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "send_img_edit")}), false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, (ChatPageContext) lf8.a.c(r15, ChatPageContext.class), null, lf8.a.d(r15), null, null, false, -10502175, 241663));
    L67:
        r31 = 0;
    L60:
        r28 = 0;
        goto L61
    L53:
        r25 = null;
        goto L54
    L49:
        r24 = null;
        goto L51
    L43:
        r23 = null;
    L69:
        d5 r32 = r15.q;
        if (r32 != null) goto L72;
        r16 = null;
        goto L79
    L72:
        if (r32.c == false) goto L79;
        Uri r33 = r32.b;
        if (r33 == null) goto L76;
        String r211 = r33.toString();
    L77:
        r16 = Image.copy$default(r16, null, null, null, null, null, r211, null, null, null, null, null, null, null, null, 16351, null);
        goto L79
    L76:
        r211 = null;
        goto L77
    L38:
        r22 = null;
    L35:
        r20 = null;
    L80:
        hy9.d r34 = ICreationReportService.a.j();
        Context r35 = lf8.a.getContext(r15);
        if (r35 == null) goto L83;
        String r36 = r35.getString(2131906324);
    L84:
        String r110 = r15.r().getBotId();
        com.larus.bmhome.actionbar.model.r r37 = ((z0) r14.getFirst()).q;
        if (r37 == null) goto L89;
        Integer r38 = r37.a;
        if (r38 == null) goto L89;
        String r111 = r38.toString();
    L90:
        com.larus.bmhome.actionbar.model.r r39 = ((z0) r14.getFirst()).q;
        if (r39 == null) goto L93;
        String r112 = r39.g;
    L94:
        ChatControlTrace r40 = ChatControlTrace.b;
        r40.getClass();
        hy9.d.a.a(r34, r36, null, null, "picture_overview", "edit_entrance", r110, null, r111, r112, r40.bb(ChatControlTrace.y), null, null, null, null, null, null, null, null, null, null, null, 4193350);
        return;
    L93:
        r112 = null;
    L89:
        r111 = null;
        goto L90
    L83:
        r36 = null;
        goto L84
    L96:
        return;
    L24:
        r14 = null;
    L9:
        r4 = null;
        goto L11
    }

    @Override // com.larus.bmhome.chat.layout.widget.i0
    public final void b() {
        SendImageCell r1 = this.a;
        int r2 = SendImageCell.t;
        Pair r3 = r1.s();
        if (r3 == null) goto L5;
        boolean r8 = ((Boolean) r3.getSecond()).booleanValue();
    L6:
        Pair r4 = this.a.s();
        if (r4 == null) goto L82;
        z0 r5 = (z0) r4.getFirst();
        if (r5 == null) goto L83;
        SendImageCell r6 = this.a;
        Image r9 = this.b;
        Activity r7 = AppHost.a.a().getCurrentActivity();
        if (r7 == null) goto L66;
        Message r10 = r6.f;
        if (r10 == null) goto L19;
        Map r11 = r10.getExt();
        if (r11 == null) goto L19;
        m1 r12 = ic8.j.d(r11);
        if (r12 == null) goto L19;
        MediaAttachment r13 = r12.d;
    L20:
        if (r13 == null) goto L22;
        String r14 = r13.getMaskUri();
    L24:
        if (o0.d(r14) == false) goto L53;
        if (r13 == null) goto L27;
        String r15 = r13.getUri();
    L29:
        if (o0.d(r15) == false) goto L53;
        if (r13 == null) goto L33;
        String r16 = r13.getUri();
    L35:
        if (r13 == null) goto L37;
        String r23 = r13.getUrl();
    L38:
        if (r13 == null) goto L44;
        ImageUploadInfo r17 = r13.getImageUploadInfo();
        if (r17 == null) goto L44;
        Long r18 = r17.getWidth();
        if (r18 == null) goto L44;
        int r24 = (int) r18.longValue();
    L45:
        if (r13 == null) goto L51;
        ImageUploadInfo r19 = r13.getImageUploadInfo();
        if (r19 == null) goto L51;
        Long r20 = r19.getHeight();
        if (r20 == null) goto L51;
        int r25 = (int) r20.longValue();
    L52:
        Image r110 = new Image(r16, null, null, new ImageObj(r23, r24, r25, null, null, 24, null), null, null, null, null, null, null, null, null, null, null, 16374, null);
    L64:
        ICreationWorkflowService.a.f0(new ny9.b(false, r7, r5, SendImageCell.o(r6, r8), r8, false, null, null, null, null, null, null, null, null, r110, null, null, null, null, false, false, new b(), null, com.larus.utils.f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "send_img_edit")}), false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, (ChatPageContext) lf8.a.c(r6, ChatPageContext.class), null, lf8.a.d(r6), null, null, false, -10502175, 241663));
    L51:
        r25 = 0;
    L44:
        r24 = 0;
        goto L45
    L37:
        r23 = null;
        goto L38
    L33:
        r16 = null;
        goto L35
    L27:
        r15 = null;
    L53:
        d5 r21 = r6.q;
        if (r21 != null) goto L56;
        r110 = null;
        goto L64
    L56:
        if (r21.c == false) goto L62;
        Uri r22 = r21.b;
        if (r22 == null) goto L60;
        String r111 = r22.toString();
    L61:
        r9 = Image.copy$default(r9, null, null, null, null, null, r111, null, null, null, null, null, null, null, null, 16351, null);
        goto L62
    L60:
        r111 = null;
    L62:
        r110 = r9;
        goto L64
    L22:
        r14 = null;
    L19:
        r13 = null;
    L66:
        hy9.d r26 = ICreationReportService.a.j();
        Context r27 = lf8.a.getContext(r6);
        if (r27 == null) goto L69;
        String r28 = r27.getString(2131906331);
    L70:
        String r29 = r6.r().getBotId();
        com.larus.bmhome.actionbar.model.r r30 = r5.q;
        if (r30 == null) goto L75;
        Integer r31 = r30.a;
        if (r31 == null) goto L75;
        String r112 = r31.toString();
    L76:
        com.larus.bmhome.actionbar.model.r r32 = r5.q;
        if (r32 == null) goto L79;
        String r113 = r32.g;
    L80:
        ChatControlTrace r33 = ChatControlTrace.b;
        r33.getClass();
        hy9.d.a.a(r26, r28, null, null, "picture_overview", "single_function", r29, null, r112, r113, r33.bb(ChatControlTrace.y), null, null, null, null, null, null, null, null, null, null, null, 4193350);
        return;
    L79:
        r113 = null;
    L75:
        r112 = null;
        goto L76
    L69:
        r28 = null;
        goto L70
    L83:
        return;
    L82:
        return;
    L5:
        r8 = false;
        goto L6
    }

    public r(SendImageCell r1, Image r2) {
        this.a = r1;
        this.b = r2;
    }
}
