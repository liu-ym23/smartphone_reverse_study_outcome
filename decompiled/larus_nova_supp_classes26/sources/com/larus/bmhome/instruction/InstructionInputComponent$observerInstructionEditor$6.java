package com.larus.bmhome.instruction;

import android.content.Context;
import android.text.InputFilter;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.instruction.core.model.CustomMenuJumpType;
import com.larus.bmhome.view.actionbar.custom.CustomActionBar;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel;
import com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModelFactory;
import com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$observerInstructionEditor$6", f = "InstructionInputComponent.kt", i = {}, l = {1671}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$observerInstructionEditor$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ InstructionInputComponent a;

        public a(InstructionInputComponent r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object emit(Object r29, Continuation r30) {
            int r0 = ((Number) r29).intValue();
            FLogger r1 = FLogger.a;
            r1.d("InstructionInputComponent", "instructionEditorViewStatus = " + r0);
            InstructionInputComponent r4 = this.a;
            String r5 = InstructionInputComponent.Z2;
            r4.getClass();
            r1.d("InstructionInputComponent", "onInstructionEditorViewStatusChanged, currentInstructionType = " + r4.Q1() + " , status = " + r0);
            z2 r6 = z2.a;
            if (z2.c4() == false) goto L15;
            com.larus.bmhome.chat.model.n r7 = r4.b2;
            if (r7 != null) goto L7;
        L9:
            boolean r8 = false;
        L10:
            if (r8 == true) goto L14;
            if (r0 != 0) goto L15;
            if (r4.V1 <= 0) goto L15;
        L14:
            boolean r9 = true;
        L17:
            if (r0 == 0) goto L19;
        L25:
            if (r0 != 1) goto L27;
            boolean r10 = true;
        L28:
            r4.S1 = r10;
            Integer r11 = null;
            if (r10 == false) goto L429;
            Integer r12 = r4.a4().getCurrentOpenFrom();
            String r13 = "";
            if (r12 != null) goto L34;
        L35:
            com.larus.bmhome.chat.component.bottom.attachment.g1 r14 = r4.f70();
            if (r14 == null) goto L43;
            com.larus.bmhome.chat.component.bottom.attachment.g1 r15 = r4.f70();
            if (r15 == null) goto L41;
            String r16 = r15.uM();
            if (r16 == null) goto L41;
        L42:
            r14.b2(r16);
        L41:
            r16 = "";
        L43:
            int r17 = od8.h0.a;
            if (od8.h0.g(r4.a4().getInstructionType()) == false) goto L70;
            Integer r18 = r4.a4().getCurrentOpenFrom();
            if (r18 != null) goto L49;
        L60:
            if (r18 == null) goto L70;
            if (r18.intValue() != 4) goto L70;
            com.larus.bmhome.view.actionbar.edit.b r19 = r4.P1;
            if (r19 == null) goto L67;
            r19.i(0);
            Unit r20 = Unit.INSTANCE;
        L67:
            com.larus.bmhome.view.actionbar.edit.b r21 = r4.P1;
            if (r21 == null) goto L70;
            r21.k();
            Unit r22 = Unit.INSTANCE;
            goto L70
        L49:
            if (r18.intValue() != 3) goto L60;
            com.larus.bmhome.chat.component.bottom.attachment.g1 r23 = r4.f70();
            if (r23 == null) goto L53;
            int r24 = com.larus.bmhome.chat.component.bottom.attachment.g1.a.b(r23);
        L54:
            com.larus.bmhome.view.actionbar.edit.b r110 = r4.P1;
            if (r110 == null) goto L70;
            if (r24 <= 0) goto L58;
            int r25 = 8;
        L59:
            r110.i(r25);
            Unit r26 = Unit.INSTANCE;
            goto L70
        L58:
            r25 = 0;
            goto L59
        L53:
            r24 = 0;
        L70:
            com.larus.bmhome.chat.component.bottom.reference.a r27 = r4.g5();
            if (r27 != null) goto L73;
        L75:
            boolean r28 = false;
        L76:
            if (r28 == false) goto L80;
            com.larus.bmhome.chat.component.bottom.reference.a r31 = r4.g5();
            if (r31 == null) goto L80;
            r31.sZ();
            Unit r32 = Unit.INSTANCE;
        L80:
            CustomActionBar r33 = r4.P0;
            if (r33 == null) goto L83;
            r33.W(false);
            Unit r34 = Unit.INSTANCE;
        L83:
            InstructionEditorViewModel r35 = r4.a4();
            if (r35 == null) goto L86;
            Integer r36 = r35.getInstructionType();
        L87:
            com.larus.bmhome.chat.component.bottom.attachment.g1 r111 = r4.f70();
            if (r111 == null) goto L97;
            if (r36 != null) goto L92;
        L94:
            boolean r37 = false;
        L95:
            r111.rv(r37);
            Unit r38 = Unit.INSTANCE;
            goto L97
        L92:
            if (r36.intValue() != 4) goto L94;
            r37 = true;
        L97:
            if (r36 != null) goto L100;
        L101:
            if (r36 != null) goto L104;
        L105:
            if (r36 != null) goto L108;
        L109:
            if (r36 != null) goto L112;
        L113:
            if (r36 != null) goto L116;
        L131:
            if (r36 != null) goto L134;
        L149:
            if (r36 != null) goto L152;
        L153:
            ICoreInputAbility r39 = r4.G3();
            if (r39 == null) goto L157;
            r39.Rk();
            Unit r40 = Unit.INSTANCE;
        L157:
            if (od8.h0.a(r36) == false) goto L181;
            ICoreInputAbility r2 = r4.G3();
            if (r2 == null) goto L161;
            r2.Dr(true);
            Unit r3 = Unit.INSTANCE;
        L161:
            Integer r41 = r4.a4().getCurrentOpenFrom();
            if (r41 != null) goto L165;
        L166:
            Integer r42 = r4.a4().getCurrentOpenFrom();
            if (r42 != null) goto L170;
        L363:
            InstructionEditorViewModel r43 = r4.a4();
            if (r43 == null) goto L371;
            Integer r44 = r43.getCurrentOpenFrom();
            if (r44 == null) goto L371;
            if (r44.intValue() != 1) goto L371;
            boolean r45 = true;
        L372:
            if (r45 == false) goto L412;
            qaa.a r46 = r4.h4();
            if (r46 == null) goto L382;
            com.larus.bmhome.actionbar.model.z0 r47 = r4.a4().getCurrentCustomActionBarItem();
            if (r47 == null) goto L378;
            String r48 = r47.b;
        L380:
            if (r46.k60(r48) != true) goto L382;
            boolean r49 = true;
        L383:
            if (r49 == true) goto L498;
            InstructionEditorViewModel r50 = r4.a4();
            if (r50 == null) goto L388;
            Integer r51 = r50.getCurrentActionBarId();
        L389:
            if (r51 == null) goto L391;
            boolean r52 = r6.y0(r51.intValue());
        L392:
            if (r52 == false) goto L400;
            ObricActionBarSendServiceDelegate r53 = ObricActionBarSendServiceDelegate.b;
            com.larus.bmhome.actionbar.model.z0 r54 = r4.a4().getCurrentCustomActionBarItem();
            if (r54 == null) goto L396;
            String r55 = r54.b;
        L398:
            if (r53.a(r55) == true) goto L400;
            boolean r56 = true;
        L401:
            if (r56 == false) goto L412;
            Intrinsics.checkNotNullParameter(r4, "<this>");
            if (Intrinsics.areEqual(((CustomActionBarViewModel) new ViewModelProvider(com.larus.ui.arch.component.internal.attach.a.b(r4, r4), new CustomActionBarViewModelFactory()).get(CustomActionBarViewModel.class)).getActionBarAlwaysOnTop(), Boolean.TRUE) == true) goto L405;
        L409:
            ICoreInputAbility r57 = r4.G3();
            if (r57 == null) goto L412;
            r57.p80(true);
            Unit r58 = Unit.INSTANCE;
            goto L412
        L405:
            if (CollectionsKt.contains(r4.W2, r36) == false) goto L409;
            ICoreInputAbility r59 = r4.G3();
            if (r59 == null) goto L412;
            r59.p80(false);
            Unit r60 = Unit.INSTANCE;
            goto L412
        L396:
            r55 = r11;
        L400:
            r56 = false;
            goto L401
        L391:
            r52 = true;
            goto L392
        L388:
            r51 = r11;
        L498:
            return Unit.INSTANCE;
        L378:
            r48 = r11;
        L382:
            r49 = false;
        L412:
            vp8.k r61 = r4.m;
            if (r61 == null) goto L419;
            Iterator r62 = ((ArrayList) r61.a).iterator();
        L416:
            if (r62.hasNext() == false) goto L418;
            ((vp8.g) r62.next()).n();
            goto L416
        L418:
            Unit r63 = Unit.INSTANCE;
        L419:
            ICoreInputAbility r64 = r4.G3();
            if (r64 == null) goto L422;
            r64.eo();
            Unit r65 = Unit.INSTANCE;
        L422:
            com.larus.bmhome.view.actionbar.edit.b r66 = r4.P1;
            if (r66 == null) goto L425;
            r66.onViewShow();
            Unit r67 = Unit.INSTANCE;
        L425:
            ICoreInputAbility r68 = r4.G3();
            if (r68 == null) goto L428;
            r68.uh(r0);
            Unit r69 = Unit.INSTANCE;
        L428:
            r4.k4(true);
            Unit r70 = Unit.INSTANCE;
        L477:
            ICoreInputAbility r71 = r4.G3();
            if (r71 == null) goto L480;
            r71.zM();
            Unit r72 = Unit.INSTANCE;
        L480:
            qaa.a r73 = r4.h4();
            if (r73 == null) goto L493;
            boolean r74 = r4.S1;
            InstructionEditorViewModel r75 = r4.a4();
            if (r75 == null) goto L487;
            com.larus.bmhome.actionbar.model.z0 r76 = r75.getCurrentCustomActionBarItem();
            if (r76 == null) goto L487;
            String r77 = r76.b;
        L488:
            InstructionEditorViewModel r78 = r4.a4();
            if (r78 == null) goto L491;
            r11 = r78.getInstructionType();
        L491:
            r73.Fo(r74, r77, r11);
            Unit r79 = Unit.INSTANCE;
        L487:
            r77 = r11;
        L493:
            if (r4.Q1() == 0) goto L495;
            r4.x = r4.Q1();
        L495:
            if (r0 != 0) goto L498;
            r4.V1 = RangesKt.coerceAtLeast(r4.V1 - 1, 0);
        L371:
            r45 = false;
            goto L372
        L170:
            if (r42.intValue() != 2) goto L363;
        L171:
            ICoreInputAbility r80 = r4.G3();
            if (r80 == null) goto L174;
            r80.zk("chat_action_bar");
            Unit r81 = Unit.INSTANCE;
        L174:
            ChatControlTrace r82 = ChatControlTrace.b;
            com.larus.bmhome.chat.component.cvs.y r83 = r4.u0();
            if (r83 == null) goto L179;
            wc9.e r84 = r83.h();
            if (r84 == null) goto L179;
            String r85 = r84.a;
        L180:
            r82.sb(r85, "action_bar");
        L179:
            r85 = null;
            goto L180
        L165:
            if (r41.intValue() == 1) goto L171;
        L181:
            if (r36 != null) goto L184;
        L186:
            boolean r86 = false;
        L187:
            if (r86 == false) goto L217;
            com.larus.bmhome.actionbar.model.r r87 = r4.a4().getCurrentInstructionConf();
            if (r87 == null) goto L191;
            List r88 = r87.b;
        L192:
            List r89 = r88;
            if (r89 != null) goto L195;
        L198:
            boolean r90 = true;
        L199:
            if (r90 == false) goto L217;
            ICoreInputAbility r91 = r4.G3();
            if (r91 == null) goto L203;
            r91.Dr(true);
            Unit r92 = Unit.INSTANCE;
        L203:
            Integer r93 = r4.a4().getCurrentOpenFrom();
            if (r93 != null) goto L207;
        L208:
            Integer r94 = r4.a4().getCurrentOpenFrom();
            if (r94 == null) goto L363;
            if (r94.intValue() != 2) goto L363;
        L213:
            Intrinsics.checkNotNullParameter(r4, "<this>");
            Context r95 = com.larus.ui.arch.component.internal.attach.a.b(r4, r4).getContext();
            if (r95 == null) goto L363;
            Intrinsics.checkNotNullParameter(r4, "<this>");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(r4, r4)), Dispatchers.getMain(), null, new InstructionInputComponent$openGaokaoPreferenceDialog$1(r4, r95, null), 2, null);
            goto L363
        L207:
            if (r93.intValue() == 1) goto L213;
        L195:
            if (r89.isEmpty() == true) goto L198;
            r90 = false;
            goto L199
        L191:
            r88 = null;
        L217:
            if (r36 != null) goto L220;
        L222:
            boolean r96 = false;
        L223:
            if (r96 == false) goto L274;
            ICoreInputAbility r97 = r4.G3();
            if (r97 == null) goto L227;
            r97.Dr(true);
            Unit r98 = Unit.INSTANCE;
        L227:
            Integer r99 = r4.a4().getCurrentOpenFrom();
            if (r99 != null) goto L231;
        L232:
            Integer r100 = r4.a4().getCurrentOpenFrom();
            if (r100 == null) goto L363;
            if (r100.intValue() != 2) goto L363;
        L237:
            ChatControlTrace r112 = ChatControlTrace.b;
            com.larus.bmhome.chat.component.cvs.y r101 = r4.u0();
            if (r101 == null) goto L242;
            wc9.e r102 = r101.h();
            if (r102 == null) goto L242;
            String r210 = r102.a;
        L243:
            com.larus.bmhome.chat.component.cvs.y r103 = r4.u0();
            if (r103 == null) goto L248;
            BotModel r104 = r103.j0();
            if (r104 == null) goto L248;
            String r211 = r104.getBotId();
        L249:
            com.larus.bmhome.chat.component.cvs.y r105 = r4.u0();
            if (r105 == null) goto L254;
            wc9.e r106 = r105.h();
            if (r106 == null) goto L254;
            String r212 = ic8.n.f(r106);
        L255:
            String r213 = r4.f1().p();
            String r214 = r4.M10();
            com.larus.bmhome.chat.component.bottom.reference.a r107 = r4.g5();
            if (r107 == null) goto L258;
            String r215 = r107.wf();
        L259:
            com.larus.bmhome.chat.component.bottom.reference.a r108 = r4.g5();
            if (r108 == null) goto L264;
            ReferenceInfo r109 = r108.T6();
            if (r109 == null) goto L264;
            String r216 = r109.referencedMessageId;
        L265:
            r112.Bb(r210, r211, "chat_action_bar", r212, r213, r214, r215, r216);
            com.larus.bmhome.chat.component.bottom.multimodal.g r113 = (com.larus.bmhome.chat.component.bottom.multimodal.g) r4.K.getValue();
            if (r113 == null) goto L363;
            com.larus.bmhome.actionbar.model.r r114 = r4.c4();
            if (r114 == null) goto L272;
            com.larus.bmhome.actionbar.model.j1 r115 = r114.e;
            if (r115 == null) goto L272;
            String r116 = r115.f;
        L273:
            com.larus.bmhome.chat.component.bottom.multimodal.f1.c r117 = new com.larus.bmhome.chat.component.bottom.multimodal.f1.c(Intrinsics.areEqual(r116, "1"), 5);
            com.larus.bmhome.chat.component.bottom.multimodal.g1 r118 = new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.InstructionDocumentRead, false);
            LinkedHashMap r119 = new LinkedHashMap();
            r119.put("upload_file_click_from", "chat_action_bar");
            Unit r120 = Unit.INSTANCE;
            r113.n90(new com.larus.bmhome.chat.component.bottom.multimodal.e1(r117, r118, null, r119, 4));
        L272:
            r116 = null;
        L264:
            r216 = null;
            goto L265
        L258:
            r215 = null;
        L254:
            r212 = null;
        L248:
            r211 = null;
        L242:
            r210 = null;
            goto L243
        L231:
            if (r99.intValue() == 1) goto L237;
        L274:
            if (r36 != null) goto L277;
        L279:
            boolean r121 = false;
        L281:
            if (r121 == false) goto L338;
            com.larus.bmhome.actionbar.model.z0 r122 = r4.yF();
            if (r122 == null) goto L289;
            com.larus.bmhome.actionbar.model.r r123 = r122.q;
            if (r123 == null) goto L289;
            com.larus.bmhome.actionbar.model.j1 r124 = r123.e;
            if (r124 == null) goto L289;
            Integer r125 = r124.j;
        L290:
            r1.i("InstructionInputComponent", "handlePodcastInstruction: podcastScene = " + r125);
            int r126 = CustomMenuJumpType.PARSE_LINK.getValue();
            if (r125 != null) goto L294;
        L301:
            int r127 = CustomMenuJumpType.UPLOAD_FILE.getValue();
            if (r125 == null) goto L363;
            if (r125.intValue() != r127) goto L363;
            com.larus.bmhome.chat.component.bottom.multimodal.g r128 = (com.larus.bmhome.chat.component.bottom.multimodal.g) r4.K.getValue();
            if (r128 == null) goto L363;
            com.larus.bmhome.chat.component.bottom.multimodal.f1.c r129 = new com.larus.bmhome.chat.component.bottom.multimodal.f1.c(false, 6);
            com.larus.bmhome.chat.component.bottom.multimodal.g1 r130 = new com.larus.bmhome.chat.component.bottom.multimodal.g1(false, MultimodalBizScene.PodcastFile, false);
            com.larus.bmhome.actionbar.model.z0 r131 = r4.yF();
            if (r131 == null) goto L315;
            com.larus.bmhome.actionbar.model.r r132 = r131.q;
            if (r132 == null) goto L315;
            com.larus.bmhome.actionbar.model.h1 r133 = r132.c;
            if (r133 == null) goto L315;
            String r134 = r133.c;
        L316:
            Pair[] r135 = new Pair[3];
            com.larus.bmhome.actionbar.model.z0 r136 = r4.yF();
            if (r136 == null) goto L319;
            String r137 = r136.b;
        L320:
            if (r137 != null) goto L322;
            r137 = "";
        L322:
            r135[0] = TuplesKt.to("action_bar_key", r137);
            com.larus.bmhome.actionbar.model.z0 r138 = r4.yF();
            if (r138 == null) goto L325;
            String r139 = r138.e;
        L326:
            if (r139 != null) goto L328;
            r139 = "";
        L328:
            r135[1] = TuplesKt.to("action_bar_option_text", r139);
            com.larus.bmhome.actionbar.model.z0 r140 = r4.yF();
            if (r140 == null) goto L333;
            Map r141 = r140.H;
            if (r141 == null) goto L333;
            String r142 = (String) r141.get("action_bar_option_id");
        L334:
            if (r142 == null) goto L337;
            r13 = r142;
        L337:
            r135[2] = TuplesKt.to("action_bar_option_id", r13);
            r128.n90(new com.larus.bmhome.chat.component.bottom.multimodal.e1(r129, r130, new com.larus.bmhome.chat.component.bottom.multimodal.h1(r134, MapsKt.mapOf(r135), null, 4), null, 8));
            Unit r143 = Unit.INSTANCE;
        L362:
            r11 = null;
        L333:
            r142 = null;
            goto L334
        L325:
            r139 = null;
            goto L326
        L319:
            r137 = null;
        L315:
            r134 = null;
            goto L316
        L294:
            if (r125.intValue() != r126) goto L301;
            ICoreInputAbility r144 = r4.G3();
            if (r144 == null) goto L298;
            r144.Dr(false);
            Unit r145 = Unit.INSTANCE;
        L298:
            ICoreInputAbility r146 = r4.G3();
            if (r146 == null) goto L363;
            ICoreInputAbility.b.e(r146, "onInstructionEditorViewStatusChanged", null, false, 2);
            Unit r147 = Unit.INSTANCE;
        L289:
            r125 = null;
            goto L290
        L338:
            ICoreInputAbility r148 = r4.G3();
            if (r148 == null) goto L341;
            r148.Dr(false);
            Unit r149 = Unit.INSTANCE;
        L341:
            qaa.a r150 = r4.h4();
            if (r150 != null) goto L344;
        L346:
            boolean r151 = false;
        L347:
            if (r151 == false) goto L357;
            qaa.a r152 = r4.h4();
            if (r152 != null) goto L351;
        L353:
            boolean r153 = false;
        L354:
            if (r153 == false) goto L357;
            boolean r154 = false;
        L358:
            if (r154 == false) goto L362;
            ICoreInputAbility r155 = r4.G3();
            if (r155 == null) goto L362;
            r11 = null;
            ICoreInputAbility.b.e(r155, "onInstructionEditorViewStatusChanged", null, false, 2);
            Unit r156 = Unit.INSTANCE;
            goto L363
        L351:
            if (r152.Fs() == true) goto L353;
            r153 = true;
        L357:
            r154 = true;
            goto L358
        L344:
            if (r150.z0() != true) goto L346;
            r151 = true;
            goto L347
        L277:
            if (r36.intValue() != 25) goto L279;
            r121 = true;
            goto L281
        L220:
            if (r36.intValue() != 8) goto L222;
            r96 = true;
            goto L223
        L184:
            if (r36.intValue() != 23) goto L186;
            r86 = true;
            goto L187
        L152:
            if (r36.intValue() == 1) goto L157;
        L134:
            if (r36.intValue() != 5) goto L149;
            Keva r157 = (Keva) r4.z.getValue();
            String r158 = InstructionInputComponent.Z2 + '5';
            int r159 = InstructionInputComponent.a3;
            int r160 = r157.getInt(r158, r159);
            if (r160 == r159) goto L138;
            r4.R4(r160);
            goto L149
        L138:
            com.larus.bmhome.actionbar.model.r r161 = r4.a4().getCurrentInstructionConf();
            if (r161 == null) goto L146;
            Integer r162 = r161.k;
            if (r162 == null) goto L146;
            if (r162.intValue() != 1) goto L146;
            boolean r163 = true;
        L147:
            if (r163 == false) goto L149;
            r4.R4(2);
        L146:
            r163 = false;
            goto L147
        L116:
            if (r36.intValue() != 25) goto L131;
        L117:
            qaa.a r164 = r4.h4();
            if (r164 == null) goto L126;
            com.larus.bmhome.actionbar.model.z0 r165 = r4.a4().getCurrentCustomActionBarItem();
            if (r165 == null) goto L122;
            String r166 = r165.b;
        L124:
            if (r164.k60(r166) != true) goto L126;
            boolean r167 = true;
        L127:
            if (r167 == true) goto L498;
            r4.R4(1);
            goto L131
        L122:
            r166 = null;
        L126:
            r167 = false;
            goto L127
        L112:
            if (r36.intValue() == 22) goto L117;
        L108:
            if (r36.intValue() == 9) goto L117;
        L104:
            if (r36.intValue() == 5) goto L117;
        L100:
            if (r36.intValue() == 3) goto L117;
        L86:
            r36 = null;
            goto L87
        L73:
            if (r27.i9() != true) goto L75;
            r28 = true;
            goto L76
        L34:
            if (r12.intValue() == 3) goto L43;
        L429:
            ICoreInputAbility r168 = r4.G3();
            if (r168 == null) goto L432;
            r168.uh(r0);
            Unit r169 = Unit.INSTANCE;
        L432:
            ICoreInputAbility r170 = r4.G3();
            if (r170 == null) goto L435;
            r170.rE();
            Unit r171 = Unit.INSTANCE;
        L435:
            com.larus.bmhome.chat.component.bottom.reference.a r172 = r4.g5();
            if (r172 != null) goto L438;
        L440:
            boolean r173 = false;
        L441:
            if (r173 == false) goto L445;
            CustomActionBar r174 = r4.P0;
            if (r174 == null) goto L445;
            r174.W(true);
            Unit r175 = Unit.INSTANCE;
        L445:
            InstructionEditorViewModel r176 = r4.a4();
            if (r176 == null) goto L448;
            Integer r177 = r176.getCurrentActionBarId();
        L449:
            if (r177 == null) goto L451;
            boolean r178 = r6.y0(r177.intValue());
        L452:
            if (r178 == false) goto L460;
            if (r9 == true) goto L460;
            ICoreInputAbility r179 = r4.G3();
            if (r179 == null) goto L457;
            r179.p80(true);
            Unit r180 = Unit.INSTANCE;
        L457:
            ICoreInputAbility r181 = r4.G3();
            if (r181 == null) goto L468;
            r181.Jc(r4.getContext());
            Unit r182 = Unit.INSTANCE;
        L468:
            vp8.k r183 = r4.m;
            if (r183 == null) goto L471;
            r183.e();
            Unit r184 = Unit.INSTANCE;
        L471:
            va8.o r185 = r4.D3();
            if (r185 == null) goto L474;
            r185.oD(new InputFilter[0]);
            Unit r186 = Unit.INSTANCE;
        L474:
            r4.S7();
            va8.o r187 = r4.D3();
            if (r187 == null) goto L477;
            r187.ra();
            Unit r188 = Unit.INSTANCE;
        L460:
            rp8.d r189 = s1a.d.a(r4).a(rp8.d.class);
            if (r189 == null) goto L463;
            CharSequence r190 = r189.f;
        L464:
            if (r190 == null) goto L468;
            ICoreInputAbility r191 = r4.G3();
            if (r191 == null) goto L468;
            r191.Rk();
            Unit r192 = Unit.INSTANCE;
            goto L468
        L463:
            r190 = null;
            goto L464
        L451:
            r178 = true;
            goto L452
        L448:
            r177 = null;
            goto L449
        L438:
            if (r172.i9() == true) goto L440;
            r173 = true;
            goto L441
        L27:
            r10 = false;
            goto L28
        L19:
            if (r4.x != 5) goto L25;
            Keva r193 = (Keva) r4.z.getValue();
            String r194 = InstructionInputComponent.Z2 + r4.x;
            ICoreInputAbility r195 = r4.G3();
            if (r195 == null) goto L23;
            int r196 = r195.Rp();
        L24:
            r193.storeInt(r194, r196);
            goto L25
        L23:
            r196 = InstructionInputComponent.a3;
            goto L24
        L7:
            if (r7.d != true) goto L9;
            r8 = true;
        L15:
            r9 = false;
            goto L17
        }
    }

    public InstructionInputComponent$observerInstructionEditor$6(InstructionInputComponent r1, Continuation<? super InstructionInputComponent$observerInstructionEditor$6> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InstructionInputComponent$observerInstructionEditor$6(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        InstructionInputComponent r6 = this.this$0;
        String r2 = InstructionInputComponent.Z2;
        InstructionEditorViewModel r7 = r6.a4();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.d1<Integer> r8 = r7.getInstructionEditorViewStatus();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
