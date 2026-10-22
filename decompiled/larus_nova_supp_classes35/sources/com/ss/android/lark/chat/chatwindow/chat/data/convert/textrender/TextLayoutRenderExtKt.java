package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import android.content.Context;
import android.text.Layout;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.m;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.coremdbiz.facade.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.tencent.qqmusic.third.api.contract.Keys;
import h7b.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import w4b.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TextLayoutRenderExtKt {
    public static final f a = null;
    public static final CoroutineScope b = null;

    static {
        a = new f();
        b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static final boolean b(RichText r9, final n r10) {
        Intrinsics.checkNotNullParameter(r9, "richText");
        Intrinsics.checkNotNullParameter(r10, "config");
        if (p.a() == false) goto L20;
        List r0 = r9.getMarkdownIds();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L20;
        LarkContextExtend.a r2 = LarkContextExtend.s;
        int r3 = ((Number) r2.b(new TextLayoutRenderExtKt$preloadMovableDocumentV2$maxWidth$1(r10))).intValue();
        if (r3 <= 0) goto L20;
        if (r3 == Integer.MAX_VALUE) goto L20;
        r10.a(r10.f.b(com.ss.android.lark.coremd.base.parse.c.a(r2, TextLayoutRenderExtKt$preloadMovableDocumentV2$1.INSTANCE)));
        BuildersKt.launch$default(b, null, null, new TextLayoutRenderExtKt$preloadMovableDocumentV2$2(r9, r10, null), 3, null);
        return true;
    L7:
        if (r0.isEmpty() == true) goto L10;
        r1 = false;
    L20:
        return false;
    }

    public static final CharSequence a(z2b.b r1, RichText r2, n r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "richText");
        Intrinsics.checkNotNullParameter(r3, "config");
        return r1.a(new m(r2, r3));
    }

    public static final Layout f(z2b.b r1, RichText r2, n r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "richText");
        Intrinsics.checkNotNullParameter(r3, "config");
        return r1.b(new com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.p(a(r1, r2, r3), r3));
    }

    public static final Layout c(z2b.b r10, f5b.b r11, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r12, Context r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "message");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r12, "params");
        a.getClass();
        Intrinsics.checkNotNullParameter(r11, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r12, "params");
        Message r0 = r11.getMessage();
        Message.Type r1 = r0.getType();
        Message.Type r2 = Message.Type.TEXT;
        if (r1 == r2) goto L8;
        if (r1 == Message.Type.POST) goto L8;
    L40:
        RichText r4 = null;
    L112:
        if (r4 != null) goto L115;
        return null;
    L115:
        return e(r10, r4, r12, r13);
    L8:
        if (r12.k == false) goto L13;
        TranslateInfo r3 = r11.getTranslateInfo();
        if (r3 == null) goto L12;
        Content r5 = r3.getTranslateContent();
    L15:
        if ((r5 instanceof BaseTextContent) == false) goto L40;
        r4 = ((BaseTextContent) r5).getRichText();
        if ((r5 instanceof PostContent) == false) goto L20;
        PostContent r6 = (PostContent) r5;
    L21:
        if (r6 == null) goto L23;
        String r7 = r6.getTitle();
    L24:
        boolean r8 = true;
        if (r7 != null) goto L27;
    L30:
        boolean r9 = true;
    L31:
        boolean r14 = !r9;
        if (r11.getMessage().getStreamStatus() != MessageStreamStatus.Transport) goto L34;
        boolean r15 = true;
    L36:
        if (i.l(r4) == false) goto L42;
        if (r14 == true) goto L42;
        if (r15 == true) goto L42;
        Log.e("TextLayoutRender", "rich-text is null , msg id is:" + r0.getId());
    L42:
        if (r12.c == false) goto L44;
    L49:
        boolean r16 = true;
    L50:
        r12.c = r16;
        r12.d = r0.isFromMe();
        List<String> r17 = r0.getReadAtChatterIds();
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r12.a = r17;
        List<String> r18 = r0.getAtBotIds();
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r12.b = r18;
        if (r0.getStatus() != Message.Status.DELETED) goto L53;
    L58:
        boolean r19 = true;
    L59:
        r12.e = r19;
        r12.f = r0.isSecret();
        d0 r110 = l.a;
        if (r5 != null) goto L62;
    L65:
        boolean r111 = false;
    L66:
        r12.i = r111;
        MessageEditInfo r112 = r0.getEditInfo();
        if (r112 != null) goto L69;
    L71:
        boolean r113 = false;
    L72:
        r12.r = r113;
        r12.g = r0.isFlag();
        if (r15 == false) goto L85;
        if (r4 == null) goto L76;
        ArrayList r114 = r4.getMyAIRunningToolsIds();
    L77:
        if (r114 != null) goto L79;
    L82:
        boolean r115 = true;
    L83:
        if (r115 == false) goto L85;
        boolean r116 = true;
    L86:
        r12.w = r116;
        r12.P = r15;
        if (r12.c0 == false) goto L89;
    L97:
        boolean r117 = false;
    L98:
        if (r117 == true) goto L100;
    L110:
        r8 = false;
    L111:
        r12.a0 = r8;
        goto L112
    L100:
        if (r0.isFromMe() == false) goto L110;
        if (r0.getDlpState() == MessageDLPState.BLOCK) goto L110;
        if (r0.isCleaned() == true) goto L110;
        if (r0.getType() != r2) goto L111;
        if (r0.isIncludeDocUrl() == false) goto L110;
    L89:
        if (r12.b0 == true) goto L97;
        if (r12.d0 == true) goto L97;
        if (r12.e0 == true) goto L97;
        if (r12.f0 == true) goto L97;
        r117 = true;
        goto L98
    L79:
        if (r114.isEmpty() == true) goto L82;
        r115 = false;
        goto L83
    L76:
        r114 = null;
    L85:
        r116 = false;
        goto L86
    L69:
        if (r112.isEdited() != true) goto L71;
        r113 = true;
        goto L72
    L62:
        if ((r5 instanceof PostContent) == false) goto L65;
        r111 = ((PostContent) r5).isGroupAnnouncement();
        goto L66
    L53:
        if (r0.isSecret() == true) goto L55;
    L57:
        r19 = false;
        goto L59
    L55:
        if (r0.isBurned() == false) goto L57;
    L44:
        if (r11.isPreMessage() == true) goto L49;
        if (r11.getMessage().isSecret() == true) goto L49;
        r16 = false;
        goto L50
    L34:
        r15 = false;
        goto L36
    L27:
        if (r7.length() == 0) goto L30;
        r9 = false;
        goto L31
    L23:
        r7 = null;
        goto L24
    L20:
        r6 = null;
        goto L21
    L12:
        r5 = null;
        goto L15
    L13:
        r5 = r11.getMessage().getContent();
        goto L15
    }

    public static final Layout d(z2b.b r9, y6b.a<?> r10, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r11, Context r12) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r11, "params");
        a.getClass();
        Intrinsics.checkNotNullParameter(r10, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r11, "params");
        if ((r10.b() instanceof BaseTextContentVO) == true) goto L6;
    L35:
        RichText r3 = null;
    L111:
        if (r3 != null) goto L114;
        return null;
    L114:
        return e(r9, r3, r11, r12);
    L6:
        if (r11.k == false) goto L8;
        Object r0 = ((BaseTextContentVO) r10.b()).g;
    L10:
        if ((r0 instanceof BaseTextContentVO) == false) goto L35;
        BaseTextContentVO r2 = (BaseTextContentVO) r0;
        r3 = r2.g();
        Intrinsics.checkNotNull(r3);
        T r4 = r2.a;
        if ((r4 instanceof PostContent) == false) goto L15;
        PostContent r5 = (PostContent) r4;
    L16:
        if (r5 == null) goto L18;
        String r6 = r5.getTitle();
    L19:
        boolean r7 = true;
        if (r6 != null) goto L22;
    L25:
        boolean r8 = true;
    L26:
        boolean r13 = !r8;
        if (r10.L() != MessageStreamStatus.Transport) goto L29;
        boolean r14 = true;
    L31:
        if (i.l(r3) == false) goto L36;
        if (r13 == true) goto L36;
        if (r14 == true) goto L36;
        Log.e("TextLayoutRender", "Parsing Layout， richText is null, id:" + r10.getId());
    L36:
        List<String> r15 = ((BaseTextContentVO) r10.b()).o;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r11.a = r15;
        List<String> r16 = ((BaseTextContentVO) r10.b()).n;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r11.b = r16;
        if (r11.c == false) goto L39;
    L44:
        boolean r17 = true;
    L45:
        r11.c = r17;
        r11.d = r10.h();
        if (r10.K() != Message.Status.DELETED) goto L48;
        boolean r18 = true;
    L49:
        r11.e = r18;
        r11.f = r10.U();
        d0 r19 = l.a;
        if (r0 != null) goto L52;
    L55:
        boolean r1 = false;
    L56:
        r11.i = r1;
        ValidateIMFileResult r20 = r10.N();
        if (r20 == null) goto L59;
        IMFileResult r21 = r20.getResultType();
    L60:
        MessagePermissionUtil.ReceiveAuthorizationState r22 = MessagePermissionUtil.h(r21);
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r11.B = r22;
        r11.C = r10.N();
        MessageEditInfo r23 = r10.u();
        if (r23 != null) goto L63;
    L65:
        boolean r24 = false;
    L66:
        r11.r = r24;
        if ((r10 instanceof y6b.c) == false) goto L69;
        y6b.c r25 = (y6b.c) r10;
    L70:
        if (r25 == null) goto L72;
        boolean r26 = r25.V1;
    L73:
        r11.g = r26;
        if (r14 == false) goto L84;
        ArrayList r27 = r3.getMyAIRunningToolsIds();
        if (r27 != null) goto L78;
    L81:
        boolean r28 = true;
    L82:
        if (r28 == false) goto L84;
        boolean r29 = true;
    L85:
        r11.w = r29;
        if (r11.c0 == false) goto L88;
    L96:
        boolean r30 = false;
    L97:
        if (r30 == true) goto L99;
    L109:
        r7 = false;
    L110:
        r11.a0 = r7;
        goto L111
    L99:
        if (r10.h() == false) goto L109;
        if (r10.t() == MessageDLPState.BLOCK) goto L109;
        if (r10.O() == true) goto L109;
        if (r10.getType() != Message.Type.TEXT) goto L110;
        if (r10.e() == false) goto L109;
    L88:
        if (r11.b0 == true) goto L96;
        if (r11.d0 == true) goto L96;
        if (r11.e0 == true) goto L96;
        if (r11.f0 == true) goto L96;
        r30 = true;
        goto L97
    L78:
        if (r27.isEmpty() == true) goto L81;
        r28 = false;
    L84:
        r29 = false;
        goto L85
    L72:
        r26 = false;
        goto L73
    L69:
        r25 = null;
        goto L70
    L63:
        if (r23.isEdited() != true) goto L65;
        r24 = true;
        goto L66
    L59:
        r21 = null;
        goto L60
    L52:
        if ((r0 instanceof PostContentVO) == false) goto L55;
        r1 = ((PostContentVO) r0).i();
        goto L56
    L48:
        r18 = false;
        goto L49
    L39:
        if (r10.isPreMessage() == true) goto L44;
        if (r10.U() == true) goto L44;
        r17 = false;
        goto L45
    L29:
        r14 = false;
        goto L31
    L22:
        if (r6.length() == 0) goto L25;
        r8 = false;
        goto L26
    L18:
        r6 = null;
        goto L19
    L15:
        r5 = null;
        goto L16
    L8:
        r0 = (com.ss.android.lark.chat.base.view.vo.message.f) r10.b();
        goto L10
    }

    public static final Layout e(z2b.b r4, RichText r5, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r6, Context r7) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "richText");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        TextLayoutRender.d r3 = new TextLayoutRender.d(r7, r5);
        Intrinsics.checkNotNullParameter(r6, "params");
        r3.c = r6;
        CharSequence r8 = r4.a(new TextLayoutRender.e(r3));
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        TextLayoutRender.f r0 = new TextLayoutRender.f(r7, r8);
        Intrinsics.checkNotNullParameter(r6, "params");
        r0.c = r6;
        return r4.b(new TextLayoutRender.g(r0));
    }
}
