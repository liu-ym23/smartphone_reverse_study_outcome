package com.larus.bmhome.chat.component.bottom.core;

import android.os.Bundle;
import androidx.collection.LruCache;
import com.larus.asr.direct.IAsrDirectFillAbility;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.MultiAttachmentInfo;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.MessageMenu;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.action.PromptReplacementCfg;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import com.obric.assistant.spi.chat.IObricChatSPIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ko8.a;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z0 implements Function2 {
    public final /* synthetic */ CoreInputAbility a;

    public /* synthetic */ z0(CoreInputAbility r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r14v5, types: [com.larus.bmhome.chat.component.bottom.core.o1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invoke(Object r33, Object r34) {
        final CoreInputAbility r10 = this.a;
        final ICoreInputAbility.OnSendParams r11 = (ICoreInputAbility.OnSendParams) r33;
        Function0 r12 = (Function0) r34;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "onSendCallBack");
        FLogger.a.i("CoreInputAbility", "[onSend] invoked, scene:" + r11.getScene());
        String r1 = r11.getEnterMethod();
        String r2 = r11.getPreviousPage();
        String r6 = "";
        if (r11.getActionInstruction() != 1) goto L26;
        boolean r4 = !r11.getLocalIntercepted();
        String r23 = r11.getLocalInterceptInfo();
        r11.getLyricCreateType();
        if (r4 == false) goto L7;
        r10.getClass();
        goto L26
    L7:
        String r15 = r10.A().f1().p();
        String r5 = r10.y();
        if (r5 != null) goto L10;
        String r18 = "";
    L11:
        wc9.e r7 = r10.h();
        if (r7 == null) goto L17;
        String r8 = ic8.n.f(r7);
        if (r8 == null) goto L17;
        String r19 = r8;
    L18:
        com.larus.bmhome.instruction.g r9 = r10.A().vc();
        if (r9 == null) goto L24;
        String r13 = r9.c0();
        if (r13 == null) goto L24;
        String r20 = r13;
    L25:
        LruCache r14 = a.a;
        tx9.e2.a.b(new kr8.e("chat", r15, r1, IAIChatControlTraceService.a.nb(), r18, r19, r20, "1", "0", r23, null, 4225), null, 3);
    L24:
        r20 = "";
    L17:
        r19 = "";
        goto L18
    L10:
        r18 = r5;
    L26:
        LruCache r16 = a.a;
        String r17 = r11.getLyricCreateType();
        if (r17 != null) goto L29;
        r17 = "";
    L29:
        Intrinsics.checkNotNullParameter(r17, "value");
        IAIChatControlTraceService.a.hb(r17);
        if (r11.getLocalIntercepted() == true) goto L469;
        String r110 = StringsKt.trim(r11.getContent()).toString();
        final Ref.ObjectRef r21 = new Ref.ObjectRef();
        String r22 = r11.getScene();
        if (r22 != null) goto L35;
    L38:
        boolean r24 = true;
    L39:
        if (r24 == false) goto L41;
        String r25 = "keyboard";
    L44:
        r21.element = r25;
        boolean r111 = Intrinsics.areEqual(r25, "image_gen_suggest");
        final LinkedHashMap r26 = new LinkedHashMap();
        r26.put("enter_method_trace", r1);
        if (r2 != null) goto L47;
        r2 = "";
    L47:
        r26.put("previous_page_trace", r2);
        Map<String, String> r3 = r11.messageExt;
        if (r3 == null) goto L50;
        r26.putAll(r3);
    L50:
        ILegacyChatUiServiceDelegate r27 = ILegacyChatUiServiceDelegate.b;
        r26.putAll(r27.S8(new Pair[0]));
        r10.getClass();
        String r28 = com.larus.platform.service.z2.a.getLarkCliAppId();
        if ((!StringsKt.isBlank(r28)) == false) goto L53;
        r26.put("lark_appid", r28);
    L53:
        Regex r29 = com.larus.bmhome.chat.markdown.richtext.n.a;
        Intrinsics.checkNotNullParameter(r110, "content");
        if (r110.length() <= 0) goto L56;
        boolean r30 = true;
    L57:
        if (r30 == true) goto L59;
    L61:
        boolean r31 = false;
    L62:
        String r112 = "1";
        if (r31 == false) goto L65;
        r26.put("larkmention", "1");
    L65:
        r26.put("is_audio", String.valueOf(r11.getTextFromAudio()));
        if (r11.isInquiryText() == false) goto L69;
        r26.put("is_inquiry", String.valueOf(r11.isInquiryText()));
    L69:
        if (r11.isReedit() == false) goto L71;
        r26.put("sec_scene", "reedit");
    L71:
        int r32 = od8.h0.a;
        if (od8.h0.e(Integer.valueOf(r11.getActionInstruction())) == false) goto L76;
        Map<String, String> r35 = r27.B8();
        if (r35 == null) goto L76;
        r26.putAll(r35);
        Unit r36 = Unit.INSTANCE;
    L76:
        SuggestedAction r37 = r11.getSuggestedAction();
        if (r37 == null) goto L81;
        PromptReplacementCfg r38 = r37.getPromptReplacementCfg();
        if (r38 == null) goto L81;
        String r39 = r38.getReplacementKey();
    L82:
        if (r39 != null) goto L84;
    L87:
        boolean r40 = true;
    L88:
        if (r40 == true) goto L97;
        SuggestedAction r41 = r11.getSuggestedAction();
        if (r41 == null) goto L95;
        PromptReplacementCfg r42 = r41.getPromptReplacementCfg();
        if (r42 == null) goto L95;
        String r43 = r42.getReplacementKey();
        if (r43 == null) goto L95;
    L96:
        r26.put("prompt_modification", r43);
    L95:
        r43 = "";
    L97:
        SuggestedAction r44 = r11.getSuggestedAction();
        if (r44 == null) goto L100;
        String r45 = r44.getSuggestedActionKey();
    L102:
        if (com.larus.utils.o0.d(r45) == true) goto L104;
    L112:
        SuggestedAction r46 = r11.getSuggestedAction();
        if (r46 == null) goto L115;
        String r47 = r46.getChatAbility();
    L117:
        if (com.larus.utils.o0.d(r47) == false) goto L125;
        SuggestedAction r48 = r11.getSuggestedAction();
        if (r48 == null) goto L121;
        String r49 = r48.getChatAbility();
    L122:
        if (r49 != null) goto L124;
        r49 = "";
    L124:
        r26.put("suggested_chat_ability", r49);
        goto L125
    L121:
        r49 = null;
    L125:
        SuggestedAction r50 = r11.getSuggestedAction();
        if (r50 == null) goto L136;
        PromptReplacementCfg r51 = r50.getPromptReplacementCfg();
        if (r51 == null) goto L136;
        Map r52 = r51.getMsgExt();
        if (r52 == null) goto L136;
        Iterator r53 = r52.entrySet().iterator();
    L133:
        if (r53.hasNext() == false) goto L135;
        Map.Entry r54 = (Map.Entry) r53.next();
        r26.put(r54.getKey(), r54.getValue());
        goto L133
    L135:
        Unit r55 = Unit.INSTANCE;
    L136:
        paa.c r56 = (paa.c) r10.N.getValue();
        if (r56 == null) goto L139;
        r56.pU(r10.v(), r11.getContent(), r26);
        Unit r57 = Unit.INSTANCE;
    L139:
        Map<String, String> r58 = r11.getActionBarInstructionMap();
        if (r58 == null) goto L165;
        r26.putAll(r58);
        if (Intrinsics.areEqual(r58.get("action_bar_instruction_type"), "7") == false) goto L164;
        com.larus.bmhome.chat.component.list.u7 r59 = r10.A().u3();
        if (r59 == null) goto L158;
        List r60 = r59.zj();
        if (r60 == null) goto L158;
        Iterator r61 = r60.iterator();
    L149:
        if (r61.hasNext() == false) goto L156;
        Object r62 = r61.next();
        if (((Message) r62).getContentType() == 0) goto L153;
        boolean r63 = true;
    L154:
        if (r63 == false) goto L149;
    L157:
        Message r64 = (Message) r62;
    L159:
        ILegacyChatUiServiceDelegate r65 = ILegacyChatUiServiceDelegate.b;
        if (r64 == null) goto L162;
        String r66 = r64.getMessageId();
    L163:
        r65.M8(r26, r64, r65.d(r66));
        goto L164
    L162:
        r66 = null;
        goto L163
    L153:
        r63 = false;
        goto L154
    L156:
        r62 = null;
    L158:
        r64 = null;
    L164:
        Unit r67 = Unit.INSTANCE;
    L165:
        AttachmentInfo r68 = r11.getAttachment();
        if (r68 == null) goto L168;
        String r69 = r68.getActionBarKey();
    L169:
        if (r69 != null) goto L171;
    L174:
        boolean r70 = true;
    L175:
        if (r70 == true) goto L182;
        AttachmentInfo r71 = r11.getAttachment();
        if (r71 == null) goto L180;
        String r72 = r71.getActionBarKey();
        if (r72 == null) goto L180;
    L181:
        r26.put("action_bar_key", r72);
    L180:
        r72 = "";
    L182:
        Boolean r73 = r11.getVoiceMixInput();
        if (r73 != null) goto L185;
    L189:
        String r74 = r11.getLyricCreateType();
        if (r74 == null) goto L192;
        String r75 = (String) r26.put("gen_music_create_type", r74);
    L192:
        IAsrDirectFillAbility r76 = (IAsrDirectFillAbility) r10.M.getValue();
        if (r76 == null) goto L195;
        IAsrDirectFillAbility.DirectFillStatus r77 = r76.VY();
    L196:
        if (r77 != null) goto L198;
        int r78 = -1;
    L200:
        if (r78 == 1) goto L208;
        if (r78 != 2) goto L203;
        r26.put("sec_scene", "fill_back_edit");
        Unit r79 = Unit.INSTANCE;
    L210:
        if (r77 != IAsrDirectFillAbility.DirectFillStatus.FillBackClickSend) goto L212;
    L213:
        IAsrDirectFillAbility r80 = (IAsrDirectFillAbility) r10.M.getValue();
        if (r80 == null) goto L216;
        String r81 = r80.xl();
    L218:
        if (com.larus.utils.o0.d(r81) == false) goto L223;
        if (r81 != null) goto L221;
        r81 = "";
    L221:
        r26.put("asr_log_id", r81);
    L223:
        if (r110.length() != 0) goto L225;
        boolean r82 = true;
    L226:
        if (r82 == false) goto L255;
        String r83 = r11.getHint();
        MultiAttachmentInfo r84 = r11.getMultiAttachment();
        if (r84 == null) goto L230;
        String r85 = r84.getLocalMsgId();
    L231:
        if (r85 != null) goto L233;
    L236:
        boolean r86 = true;
    L237:
        if (r86 == true) goto L239;
    L243:
        boolean r87 = false;
    L245:
        if (r83.length() != 0) goto L247;
        boolean r88 = true;
    L248:
        if (r88 == false) goto L252;
        if (r87 == false) goto L252;
        FLogger.a.i("CoreInputAbility", "[onSend] has no hint and attachment, intercept sending");
        return Unit.INSTANCE;
    L252:
        if (StringsKt.contains$default(r83, r10.g.getString(2131906713), false, 2, null) == false) goto L254;
        r83 = StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(r83, r10.g.getString(2131906713), "", false, 4, null), " ", "", false, 4, null);
    L254:
        r21.element = "default_trending";
        MapsKt.plus(r26, TuplesKt.to("source", "hot_search"));
    L256:
        WeakReference r89 = MessageMenu.x;
        MessageMenu.a.a();
        if (r11.getReferenceInfo() == null) goto L305;
        ReferenceInfo r90 = r11.getReferenceInfo();
        if (r90 == null) goto L261;
        r90.setTraceExtra(MapsKt.mapOf(TuplesKt.to("suggested_click_from", "input_suggested")));
    L261:
        com.larus.bmhome.chat.component.list.u7 r0 = r10.A().u3();
        if (r0 == null) goto L278;
        List r91 = r0.zj();
        if (r91 == null) goto L278;
        Iterator r92 = r91.iterator();
    L267:
        if (r92.hasNext() == false) goto L276;
        Object r93 = r92.next();
        String r94 = ((Message) r93).getMessageId();
        ReferenceInfo r113 = r11.getReferenceInfo();
        if (r113 == null) goto L271;
        String r114 = r113.referencedMessageId;
    L273:
        if (Intrinsics.areEqual(r94, r114) == false) goto L267;
    L277:
        Message r95 = (Message) r93;
    L279:
        ILegacyChatUiServiceDelegate r96 = ILegacyChatUiServiceDelegate.b;
        ReferenceInfo r97 = r11.getReferenceInfo();
        if (r97 == null) goto L282;
        int r99 = r97.searchIndex;
    L283:
        Function0 r210 = r12;
        r96.O8(r26, r95, r99, Intrinsics.areEqual(r11.getSelectionTextAction(), "reference"));
        boolean r100 = com.larus.platform.service.z2.a.getBasicExperienceBugFixConfig().d;
        String r101 = r11.getSelectionTextAction();
        if (r101 == null) goto L306;
        int r102 = r101.hashCode();
        boolean r115 = r111;
        String r116 = r110;
        if (r102 == (-1165870106)) goto L302;
        if (r102 == 1101148556) goto L299;
        if (r102 == 1660791271) goto L293;
    L303:
        Unit r103 = Unit.INSTANCE;
    L307:
        com.larus.bmhome.chat.component.list.u7 r104 = r10.A().u3();
        if (r104 == null) goto L313;
        r104.w70();
        r104.TP(false);
        IObricChatSPIService r105 = (IObricChatSPIService) ServiceManager.get().getService(IObricChatSPIService.class);
        if (r105 == null) goto L313;
        r105.k(s1a.d.a(r10.a));
        Unit r106 = Unit.INSTANCE;
    L313:
        if (com.larus.platform.exp.g.a() == false) goto L315;
        r10.C1(false, false, "input_on_send");
        boolean r107 = true;
    L316:
        Ref.BooleanRef r117 = new Ref.BooleanRef();
        String r108 = ObricActionBarSendServiceDelegate.b.x(r26, r83, r11, (String) r21.element);
        if (r108 == null) goto L320;
        r83 = r108;
    L320:
        Iterator r109 = ((ArrayList) r10.B).iterator();
    L322:
        if (r109.hasNext() == false) goto L324;
        ((ICoreInputAbility.d) r109.next()).b(r11);
        goto L322
    L324:
        MultiAttachmentInfo r118 = r11.getMultiAttachment();
        if (r118 == null) goto L327;
        String r119 = r118.getLocalMsgId();
    L329:
        if (com.larus.utils.o0.d(r119) == false) goto L348;
        FLogger.a.i("CoreInputAbility", "[onSend] invoked, send multi attachments");
        Bundle r120 = r10.A().f1().a;
        if (r120 == null) goto L334;
        String r121 = r120.getString("click_from", "");
        if (r121 == null) goto L334;
    L336:
        if (r10.c1() == true) goto L338;
    L340:
        MultiAttachmentInfo r122 = r11.getMultiAttachment();
        if (r122 == null) goto L346;
        r121 = r122.getEnterMethod();
        if (r121 == null) goto L346;
    L345:
        r6 = r121;
    L346:
        r26.put("enter_method_trace", r6);
        ((com.larus.bmhome.chat.api.x) r10.F.getValue()).a(r10.A(), r116, r11, (String) r21.element, r26, new n1(r10, r11, r116, r117, r21, r26));
        boolean r310 = r107;
        boolean r123 = true;
        boolean r124 = true;
        Pair r311 = null;
    L407:
        if (r117.element == true) goto L472;
        uaa.a r125 = r10.A().AV();
        if (r125 == null) goto L412;
        r125.t8(r10.getBotId(), r10.v(), r124);
        Unit r126 = Unit.INSTANCE;
    L412:
        com.larus.bmhome.instruction.g r127 = r10.A().vc();
        if (r127 != null) goto L415;
    L417:
        boolean r128 = false;
    L418:
        if (r128 == false) goto L422;
        com.larus.bmhome.instruction.g r129 = r10.A().vc();
        if (r129 == null) goto L422;
        r129.A1();
        Unit r130 = Unit.INSTANCE;
    L422:
        com.larus.bmhome.chat.component.bottom.reference.a r131 = r10.A().g5();
        if (r131 != null) goto L425;
    L427:
        boolean r132 = false;
    L428:
        if (r132 == false) goto L435;
        com.larus.bmhome.chat.component.bottom.reference.a r133 = r10.A().g5();
        if (r133 == null) goto L432;
        r133.NR();
        Unit r134 = Unit.INSTANCE;
    L432:
        IFlowSdkDepend r135 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r135 == null) goto L435;
        r135.N();
        com.larus.home.impl.sdk.n1.a.h();
        Unit r136 = Unit.INSTANCE;
    L435:
        IAIChatControlTraceService.Companion r137 = IAIChatControlTraceService.a;
        r137.fb();
        com.larus.bmhome.instruction.g r138 = r10.A().vc();
        if (r138 == null) goto L438;
        Pair r139 = r138.F7();
    L439:
        r137.Pa(r139);
        if (r11.clearInputContent == false) goto L456;
        if (r10.Jd().n == false) goto L456;
        int r140 = com.larus.platform.service.z2.a.inputEnhance().a;
        if (r140 != r123) goto L446;
        r10.p80(r123);
    L452:
        if (r310 == false) goto L454;
        a9$a.a(r10.f, new r1(r10));
    L458:
        r210.invoke();
        return Unit.INSTANCE;
    L454:
        ICoreInputAbility.b.d(r10, "", false, false, null, null, false, 62);
        goto L458
    L446:
        if (r140 != 2) goto L452;
        if (com.larus.bmhome.utils.i.f(r10.h()) == false) goto L452;
        r10.p80(r123);
    L456:
        if (r10.f.Mb() == true) goto L458;
        r10.qp(false);
        goto L458
    L438:
        r139 = r311;
        goto L439
    L425:
        if (r131.GD() != r123) goto L427;
        r132 = true;
        goto L428
    L415:
        if (r127.Wa() != r123) goto L417;
        r128 = true;
        goto L418
    L472:
        return Unit.INSTANCE;
    L338:
        if (com.larus.utils.o0.d(r121) == false) goto L340;
    L334:
        r121 = "";
        goto L336
    L348:
        if (r11.getCustomMultiAttachment() == null) goto L376;
        CharSequence r141 = (CharSequence) r26.get("enter_method_trace");
        if (r141 != null) goto L352;
    L355:
        boolean r142 = true;
    L356:
        if (r142 == false) goto L364;
        CustomMultiAttachmentInfo r143 = r11.getCustomMultiAttachment();
        if (r143 == null) goto L363;
        String r144 = r143.getEnterMethod();
        if (r144 == null) goto L363;
        r6 = r144;
    L363:
        r26.put("enter_method_trace", r6);
    L364:
        CustomMultiAttachmentInfo r145 = r11.getCustomMultiAttachment();
        if (r145 == null) goto L370;
        if (r145.isSkipUpload() != true) goto L370;
        boolean r146 = true;
    L371:
        if (r146 == false) goto L373;
        r10.G0(r116, r11, (String) r21.element, r26, null, null);
    L374:
        r310 = r107;
        r123 = true;
        r311 = null;
    L405:
        r124 = false;
        goto L407
    L373:
        final String r147 = r116;
        IAIChatUgcAIGCService.a.a(r10.A(), r147, r11, r26, new o1(r10, r147, r11, r21, r26));
    L370:
        r146 = false;
        goto L371
    L352:
        if (r141.length() == 0) goto L355;
        r142 = false;
        goto L356
    L376:
        if (r11.getAttachment() == null) goto L396;
        FLogger.a.i("CoreInputAbility", "[onSend] invoked, send single attachments");
        CharSequence r148 = (CharSequence) r26.get("enter_method_trace");
        if (r148 != null) goto L380;
    L383:
        boolean r149 = true;
    L384:
        if (r149 == false) goto L392;
        AttachmentInfo r150 = r11.getAttachment();
        if (r150 == null) goto L391;
        String r151 = r150.getEnterMethod();
        if (r151 == null) goto L391;
        r6 = r151;
    L391:
        r26.put("enter_method_trace", r6);
    L392:
        AttachmentInfo r152 = r11.getAttachment();
        if (r152 == null) goto L471;
        String r153 = r116;
        r310 = r107;
        r123 = true;
        r311 = null;
        ((com.larus.bmhome.chat.api.x) r10.F.getValue()).b(r10.A(), r11, r153, r152, r26, r11.attachmentLocalMsgIds, r11.textLocalMsgId, new q1(r10, r152, r153, r117, r11, r21, r26, r115));
        r124 = true;
        goto L407
    L471:
        return Unit.INSTANCE;
    L380:
        if (r148.length() == 0) goto L383;
        r149 = false;
        goto L384
    L396:
        r310 = r107;
        r123 = true;
        r311 = null;
        FLogger.a.i("CoreInputAbility", "[onSend] invoked, send pure text");
        String r154 = (String) r21.element;
        gd8.g r155 = r10.A().h2();
        if (r155 == null) goto L399;
        gd8.g.a.b(r155, r10.v(), r83, r154, r26, false, null, r11.getReferenceInfo(), r11.getCreationSendTraceId(), null, r11.getSendClickTimestamp(), 1328);
    L399:
        com.larus.bmhome.chat.model.j1 r156 = r10.A().Y3();
        if (r156 == null) goto L402;
        r156.q();
    L402:
        com.larus.bmhome.chat.model.j1 r157 = r10.A().Y3();
        if (r157 == null) goto L405;
        r157.n();
        goto L405
    L327:
        r119 = null;
        goto L329
    L315:
        r107 = false;
        goto L316
    L293:
        if (r101.equals("auto_cite") == false) goto L303;
        if (r100 == false) goto L297;
        r26.put("select_text_action", new JSONObject().put("action", "question").toString());
    L297:
        r26.put("sec_scene", "choose_text_auto_cite");
        goto L303
    L299:
        if (r101.equals("rewrite") == false) goto L303;
        r26.put("select_text_action", new JSONObject().put("action", r101).toString());
        r26.put("sec_scene", "rewrite");
        Unit r158 = Unit.INSTANCE;
        goto L307
    L302:
        if (r101.equals("question") == false) goto L303;
        r26.put("select_text_action", new JSONObject().put("action", r101).toString());
        r26.put("sec_scene", "click_cite_button");
        Unit r159 = Unit.INSTANCE;
    L306:
        r116 = r110;
        r115 = r111;
        goto L307
    L282:
        r99 = 0;
        goto L283
    L271:
        r114 = null;
        goto L273
    L276:
        r93 = null;
    L278:
        r95 = null;
        goto L279
    L305:
        r210 = r12;
        goto L306
    L247:
        r88 = false;
        goto L248
    L239:
        if (r11.getAttachment() != null) goto L243;
        if (r11.getCustomMultiAttachment() != null) goto L243;
        r87 = true;
        goto L245
    L233:
        if (r85.length() == 0) goto L236;
        r86 = false;
        goto L237
    L230:
        r85 = null;
        goto L231
    L255:
        r83 = r110;
        goto L256
    L225:
        r82 = false;
        goto L226
    L216:
        r81 = null;
        goto L218
    L212:
        if (r77 != IAsrDirectFillAbility.DirectFillStatus.FillBackEdit) goto L223;
    L203:
        if (r78 != 3) goto L206;
        r26.put("sec_scene", "fill_back_clear");
    L206:
        Unit r160 = Unit.INSTANCE;
        goto L210
    L208:
        r26.put("sec_scene", "fill_back_click_send");
        Unit r161 = Unit.INSTANCE;
        goto L210
    L198:
        r78 = CoreInputAbility.b.a[r77.ordinal()];
        goto L200
    L195:
        r77 = null;
        goto L196
    L185:
        if (r73.booleanValue() == true) goto L188;
        r112 = "0";
    L188:
        String r162 = (String) r26.put("voice_mix_input", r112);
        goto L189
    L171:
        if (r69.length() == 0) goto L174;
        r70 = false;
        goto L175
    L168:
        r69 = null;
        goto L169
    L115:
        r47 = null;
        goto L117
    L104:
        if (r26.containsKey("suggested_action_key") == true) goto L112;
        SuggestedAction r163 = r11.getSuggestedAction();
        if (r163 == null) goto L108;
        String r164 = r163.getSuggestedActionKey();
    L109:
        if (r164 != null) goto L111;
        r164 = "";
    L111:
        r26.put("suggested_action_key", r164);
        goto L112
    L108:
        r164 = null;
        goto L109
    L100:
        r45 = null;
        goto L102
    L84:
        if (r39.length() == 0) goto L87;
        r40 = false;
    L81:
        r39 = null;
        goto L82
    L59:
        if ((!((ArrayList) com.larus.bmhome.chat.markdown.richtext.n.d(r110)).isEmpty()) == false) goto L61;
        r31 = true;
        goto L62
    L56:
        r30 = false;
        goto L57
    L41:
        r25 = r11.getScene();
        if (r25 != null) goto L44;
        r25 = "";
        goto L44
    L35:
        if (r22.length() == 0) goto L38;
        r24 = false;
        goto L39
    L469:
        return Unit.INSTANCE;
    }
}
