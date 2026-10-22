package com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.RomUtils;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.AuthorityParam;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.message.params.e;
import com.ss.android.lark.biz.im.api.message.params.l;
import com.ss.android.lark.biz.im.api.message.params.o;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutRenderConfigs;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.c;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.widget.light.g;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import w4b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatTextLayoutPreCalculator implements a {
    public final com.ss.android.lark.auditsdk.v2.receivecheck.a a;
    public final z2b.b b;
    public final m2b.a c;
    public final Map<Class<? extends l>, l> d;
    public final WeakReference<Context> e;
    public boolean f;
    public b.InterfaceC0038b g;

    @Override // com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a
    public final void a(boolean r1) {
        this.f = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a
    public final void b(f5b.b r20) {
        Intrinsics.checkNotNullParameter(r20, "messageInfo");
        if (this.f == true) goto L5;
        return;
    L5:
        if (this.b != null) goto L7;
        return;
    L7:
        if (this.c == null) goto L196;
        Message.Type r3 = r20.getMessage().getType();
        Context r4 = this.e.get();
        if (r4 != null) goto L12;
        return;
    L12:
        if (r3 != Message.Type.TEXT) goto L14;
    L15:
        int r5 = com.ss.android.lark.chat.chatwindow.chat.model.preload.a.a;
        Message r6 = r20.getMessage();
        Intrinsics.checkNotNullParameter(r6, "message");
        if (r6.getCharacterLength() < 1000) goto L18;
        boolean r7 = true;
    L19:
        int r8 = c.a;
        Intrinsics.checkNotNullParameter(r20, "messageInfo");
        r20.getMessage().getType();
        BaseTextContent r2 = (BaseTextContent) r20.getMessage().getContent();
        RichText r9 = r2.getRichText();
        if (r9 == null) goto L22;
        List r10 = r9.getImageIds();
    L23:
        List r11 = r10;
        if (r11 != null) goto L26;
    L29:
        boolean r12 = true;
    L30:
        if (r12 == false) goto L44;
        RichText r13 = r2.getRichText();
        if (r13 == null) goto L34;
        List r14 = r13.getMediaIds();
    L35:
        List r15 = r14;
        if (r15 != null) goto L38;
    L41:
        boolean r16 = true;
    L42:
        if (r16 == false) goto L44;
        boolean r17 = true;
    L45:
        BaseTextContent r18 = (BaseTextContent) r20.getMessage().getContent();
        com.ss.android.lark.auditsdk.v2.receivecheck.a r19 = this.a;
        Lazy r110 = AuthorityParamPatcher.a;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        String r111 = BuildConfig.FLAVOR;
        if (r17 == false) goto L48;
        Map r21 = new LinkedHashMap();
    L76:
        final ValidateIMFileResult r22 = (ValidateIMFileResult) r19.b(r21, true).get(r20.getId());
        final Ref.ObjectRef r23 = new Ref.ObjectRef();
        u r24 = MessagePermissionUtil.a;
        r23.element = new ValidateResult(ResultType.ALLOW);
        final Ref.BooleanRef r25 = new Ref.BooleanRef();
        r25.element = true;
        if (r3 != Message.Type.POST) goto L83;
        r23.element = MessagePermissionUtil.b();
        Message r26 = r20.getMessage();
        Chat r112 = this.c.getChat();
        if (r112 == null) goto L81;
        String r113 = r112.getAnonymousId();
    L82:
        r25.element = MessagePermissionUtil.d(r26, r113, (ValidateResult) r23.element);
        goto L83
    L81:
        r113 = null;
    L83:
        Map<Class<? extends l>, l> r27 = this.d;
        if (r27 == null) goto L86;
        l r28 = r27.get(e.class);
    L88:
        if ((r28 instanceof e) == false) goto L90;
        e r29 = (e) r28;
    L91:
        if (r29 == null) goto L99;
        o r114 = r29.b;
        if (r114 == null) goto L99;
        if (r20.getMessage().isFromMe() == false) goto L97;
        int r115 = r114.a;
    L98:
        Integer r116 = Integer.valueOf(r115);
    L100:
        int r117 = TextLayoutRender.j;
        if (TextLayoutRender.c.a() == false) goto L121;
        RichText r30 = r18.getRichText();
        com.ss.android.lark.coremd.base.parse.b r31 = com.ss.android.lark.coremd.base.parse.c.a(IMContextExtend.A, new ChatTextLayoutPreCalculator$onSaveToDataStore$1$permissionApply$1(r23, r25, r22));
        if (r29 == null) goto L105;
        List r32 = r29.a;
    L106:
        n r33 = TextLayoutRenderConfigs.d(this.c, r20, false, r32, r116);
        r33.a(r33.f.b(r31));
        c(r30, r33);
        if (r7 == false) goto L109;
        r18.setNeedReParseLayout(true);
    L109:
        TranslateInfo r34 = r20.getTranslateInfo();
        if (r34 == null) goto L112;
        BaseTextContent r35 = (BaseTextContent) r34.getTranslateContent();
    L113:
        if (r35 == null) goto L115;
        RichText r36 = r35.getRichText();
    L116:
        if (r36 == null) goto L118;
        n r1 = TextLayoutRenderConfigs.d(this.c, r20, true, r32, r116);
        r1.a(r1.f.b(r31));
        c(r36, r1);
    L118:
        if (r7 == false) goto L191;
        if (r35 == null) goto L192;
        r35.setNeedReParseLayout(true);
        return;
    L192:
        return;
    L191:
        return;
    L115:
        r36 = null;
        goto L116
    L112:
        r35 = null;
        goto L113
    L105:
        r32 = null;
        goto L106
    L121:
        Chat r37 = this.c.getChat();
        if (r37 != null) goto L124;
    L126:
        boolean r38 = false;
    L127:
        Chat r118 = this.c.getChat();
        if (r118 == null) goto L130;
        String r119 = r118.getAnonymousId();
    L131:
        if (r119 == null) goto L134;
        r111 = r119;
    L134:
        b r120 = new b();
        r120.c = false;
        r120.l = r111;
        r120.h = r38;
        r120.A = true;
        r120.a((ValidateResult) r23.element);
        r120.C = r22;
        if (r22 == null) goto L137;
        IMFileResult r121 = r22.getResultType();
    L138:
        MessagePermissionUtil.ReceiveAuthorizationState r122 = MessagePermissionUtil.h(r121);
        Intrinsics.checkNotNullParameter(r122, "receiveAuthorizationState");
        r120.B = r122;
        r120.o = r25.element;
        r120.p = r20.getId();
        ChatChatter r123 = r20.getMessageSender();
        if (r123 == null) goto L141;
        String r124 = r123.getTenantId();
    L142:
        r120.q = r124;
        r120.t = r116;
        Map<Class<? extends l>, l> r125 = this.d;
        if (r125 == null) goto L145;
        l r126 = r125.get(g3b.c.class);
    L147:
        if ((r126 instanceof g3b.c) == false) goto L149;
        g3b.c r127 = (g3b.c) r126;
    L150:
        if (r127 == null) goto L152;
        boolean r128 = false;
        r120.Z = false;
    L153:
        if (r7 == false) goto L155;
        r120.m = r128;
    L155:
        r120.G = this.g;
        z2b.b r129 = this.b;
        if (r129 == null) goto L158;
        Layout r130 = TextLayoutRenderExtKt.c(r129, r20, r120, r4);
    L159:
        int r131 = g.a;
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.richtext.textlayoutrender") == true) goto L162;
        r18.setContentLayout(r130);
    L162:
        if (r7 == false) goto L165;
        r18.setNeedReParseLayout(true);
    L165:
        if (r20.getTranslateInfo() == null) goto L194;
        BaseTextContent r39 = (BaseTextContent) r20.getTranslateInfo().getTranslateContent();
        b r132 = new b();
        r132.a((ValidateResult) r23.element);
        r132.o = r25.element;
        r132.p = r20.getId();
        ChatChatter r40 = r20.getMessageSender();
        if (r40 == null) goto L169;
        String r41 = r40.getTenantId();
    L170:
        r132.q = r41;
        r132.l = r111;
        r132.A = true;
        r132.k = true;
        r132.h = r38;
        if (r22 == null) goto L173;
        IMFileResult r42 = r22.getResultType();
    L174:
        MessagePermissionUtil.ReceiveAuthorizationState r43 = MessagePermissionUtil.h(r42);
        Intrinsics.checkNotNullParameter(r43, "receiveAuthorizationState");
        r132.B = r43;
        r132.C = r22;
        r132.t = r116;
        if (r7 == false) goto L177;
        r132.m = false;
    L177:
        r132.G = this.g;
        Intrinsics.checkNotNull(r39);
        z2b.b r44 = this.b;
        if (r44 == null) goto L180;
        Layout r45 = TextLayoutRenderExtKt.c(r44, r20, r132, r4);
    L182:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.richtext.textlayoutrender") == true) goto L184;
        r39.setContentLayout(r45);
    L184:
        if (r7 == false) goto L195;
        r39.setNeedReParseLayout(true);
        return;
    L195:
        return;
    L180:
        r45 = null;
        goto L182
    L173:
        r42 = null;
        goto L174
    L169:
        r41 = null;
        goto L170
    L194:
        return;
    L158:
        r130 = null;
        goto L159
    L152:
        r128 = false;
        goto L153
    L149:
        r127 = null;
        goto L150
    L145:
        r126 = null;
        goto L147
    L141:
        r124 = null;
        goto L142
    L137:
        r121 = null;
        goto L138
    L130:
        r119 = null;
        goto L131
    L124:
        if (r37.isSuper() != true) goto L126;
        r38 = true;
        goto L127
    L97:
        r115 = r114.b;
    L99:
        r116 = null;
        goto L100
    L90:
        r29 = null;
        goto L91
    L86:
        r28 = null;
        goto L88
    L48:
        Lazy r46 = AuthorityParamPatcher.a;
        if (Intrinsics.areEqual(((w4b.c.o) r46.getValue()).userId(), BuildConfig.FLAVOR) == true) goto L53;
        String r133 = ((w4b.c.o) r46.getValue()).userId();
        if (r133 == null) goto L53;
        long r134 = CastLongProtector.parseLong(r133);
    L54:
        String r135 = r20.getMessage().getChatId();
        AuthorityParam.a r136 = new AuthorityParam.a();
        r136.a = r20.getId();
        ChatChatter r47 = r20.getMessageSender();
        if (r47 == null) goto L59;
        String r48 = r47.getId();
        if (r48 == null) goto L59;
        int r137 = AuthorityParam.j;
        Long r49 = Long.valueOf(AuthorityParam.Companion.a(r48, AuthorityParam.Companion.AuthScene.AUTHORITY_PARAM_PATCHER));
    L60:
        r136.d = r49;
        ChatChatter r50 = r20.getMessageSender();
        if (r50 == null) goto L65;
        String r51 = r50.getTenantId();
        if (r51 == null) goto L65;
        int r52 = AuthorityParam.j;
        Long r53 = Long.valueOf(AuthorityParam.Companion.a(r51, AuthorityParam.Companion.AuthScene.AUTHORITY_PARAM_PATCHER));
    L66:
        r136.c = r53;
        r136.f = r134;
        int r54 = AuthorityParam.j;
        String r55 = ((w4b.c.o) r46.getValue()).fe();
        AuthorityParam.Companion.AuthScene r56 = AuthorityParam.Companion.AuthScene.AUTHORITY_PARAM_PATCHER;
        r136.e = AuthorityParam.Companion.a(r55, r56);
        AuthorityParam.AuthorityExtraParam r57 = new AuthorityParam.AuthorityExtraParam(r20.isPreMessage(), r20.getMessage().isFromMe(), r20.getMessage().isMultiResourceAuth());
        Intrinsics.checkNotNullParameter(r57, "authorityExtraParam");
        r136.i = r57;
        r136.b = r135;
        List<String> r58 = r20.getAuthFileKeys();
        Intrinsics.checkNotNullParameter(r58, "fileKeys");
        r136.h = r58;
        AuthorityParam r59 = r136.a();
        if (r20.getMessageSender() != null) goto L69;
        AuthorityParam.Companion.b(r56, "tenant id is null for chatter is null");
    L75:
        r21 = MapsKt.mapOf(new Pair(r20.getId(), r59));
        goto L76
    L69:
        ChatChatter r60 = r20.getMessageSender();
        if (r60 == null) goto L72;
        String r61 = r60.getTenantId();
    L73:
        if (r61 != null) goto L75;
        AuthorityParam.Companion.b(r56, "tenant id is null fo chatter not null");
        goto L75
    L72:
        r61 = null;
    L65:
        r53 = null;
    L59:
        r49 = null;
    L53:
        r134 = 0;
        goto L54
    L38:
        if (r15.isEmpty() == true) goto L41;
        r16 = false;
        goto L42
    L34:
        r14 = null;
    L44:
        r17 = false;
        goto L45
    L26:
        if (r11.isEmpty() == true) goto L29;
        r12 = false;
        goto L30
    L22:
        r10 = null;
        goto L23
    L18:
        r7 = false;
        goto L19
    L14:
        if (r3 == Message.Type.POST) goto L15;
        return;
    }

    public final void c(RichText r3, n r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextLayoutRenderExtKt.b(r3, r4) == false) goto L7;
        return;
    L7:
        int r0 = com.ss.android.lark.chat.chatwindow.chat.model.preload.a.a;
        if (Build.VERSION.SDK_INT == 31) goto L10;
        boolean r1 = false;
    L11:
        if (r1 == true) goto L13;
    L15:
        z2b.b r2 = this.b;
        if (r2 == null) goto L19;
        TextLayoutRenderExtKt.f(r2, r3, r4);
        return;
    L19:
        return;
    L13:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.close_pre_layout.reverse") == true) goto L15;
        return;
    L10:
        r1 = RomUtils.g();
        goto L11
    }

    public ChatTextLayoutPreCalculator(Context r2, com.ss.android.lark.auditsdk.v2.receivecheck.a r3, w2b.b r4, m2b.a r5, Map r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "authorityChecker");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = new WeakReference(r2);
    }
}
