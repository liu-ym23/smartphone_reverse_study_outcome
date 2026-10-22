package com.larus.uaigc.createpage.component.instruction;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.platform.api.creation.CustomInputInitData;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.createpage.processor.CreatePageSendMessageProcessor;
import com.larus.uaigc.service.ICreationReportService;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$finishAndSendMessages$1", f = "CreationEditorComponent.kt", i = {}, l = {4425, 4431}, m = "invokeSuspend", n = {}, s = {})
public final class CreationEditorComponent$finishAndSendMessages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ String $instructionParam;
    final /* synthetic */ String $localPath;
    final /* synthetic */ String $userInput;
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public CreationEditorComponent$finishAndSendMessages$1(CreationEditorComponent r1, String r2, Bundle r3, String r4, String r5, Continuation<? super CreationEditorComponent$finishAndSendMessages$1> r6) {
        this.this$0 = r1;
        this.$localPath = r2;
        this.$bundle = r3;
        this.$userInput = r4;
        this.$instructionParam = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CreationEditorComponent$finishAndSendMessages$1(this.this$0, this.$localPath, this.$bundle, this.$userInput, this.$instructionParam, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r51) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r10 = true;
        String r12 = null;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r51);
    L161:
        ny9.s r1 = this.this$0.W3();
        if (r1 == null) goto L171;
        com.larus.bmhome.actionbar.model.r r2 = r1.k();
        if (r2 == null) goto L171;
        Integer r3 = r2.a;
        if (r3 == null) goto L171;
        if (r3.intValue() != 4) goto L171;
        boolean r4 = true;
    L172:
        if (r4 == true) goto L197;
        ny9.s r5 = this.this$0.W3();
        if (r5 == null) goto L183;
        com.larus.bmhome.actionbar.model.r r6 = r5.k();
        if (r6 == null) goto L183;
        Integer r7 = r6.a;
        if (r7 == null) goto L183;
        if (r7.intValue() != 16) goto L183;
        boolean r8 = true;
    L184:
        if (r8 == true) goto L197;
        ny9.s r11 = this.this$0.W3();
        if (r11 == null) goto L195;
        com.larus.bmhome.actionbar.model.r r13 = r11.k();
        if (r13 == null) goto L195;
        Integer r14 = r13.a;
        if (r14 == null) goto L195;
        if (r14.intValue() != 28) goto L195;
    L196:
        if (r10 == true) goto L197;
    L230:
        return Unit.INSTANCE;
    L195:
        r10 = false;
    L183:
        r8 = false;
    L197:
        hy9.d r15 = ICreationReportService.a.j();
        ny9.u r16 = this.this$0.d4();
        if (r16 == null) goto L200;
        String r17 = r16.m();
    L201:
        ny9.u r18 = this.this$0.d4();
        if (r18 == null) goto L204;
        String r19 = r18.i();
    L205:
        ny9.u r20 = this.this$0.d4();
        if (r20 == null) goto L208;
        String r110 = r20.getEnterMethod();
    L209:
        ny9.u r21 = this.this$0.d4();
        if (r21 == null) goto L212;
        Integer r111 = Boxing.boxInt((int) (System.currentTimeMillis() - r21.b));
    L213:
        ny9.u r22 = this.this$0.d4();
        if (r22 == null) goto L216;
        String r112 = r22.f();
    L217:
        ny9.u r23 = this.this$0.d4();
        if (r23 == null) goto L220;
        String r24 = r23.p();
    L221:
        ny9.u r25 = this.this$0.d4();
        if (r25 == null) goto L224;
        String r26 = r25.j();
    L225:
        ny9.u r27 = this.this$0.d4();
        if (r27 == null) goto L228;
        r12 = r27.getBotId();
    L228:
        r15.h("complete", r111, r110, r17, r19, r112, r26, r24, new JSONObject(), null, r12);
        goto L230
    L224:
        r26 = null;
        goto L225
    L220:
        r24 = null;
        goto L221
    L216:
        r112 = null;
        goto L217
    L212:
        r111 = null;
        goto L213
    L208:
        r110 = null;
        goto L209
    L204:
        r19 = null;
        goto L205
    L200:
        r17 = null;
    L171:
        r4 = false;
        goto L172
    L10:
        ResultKt.throwOnFailure(r51);
        CreationEditorComponent r28 = this.this$0;
        com.larus.bmhome.actionbar.model.p1 r29 = r28.g1;
        if (r29 == null) goto L13;
        String r30 = r29.c;
    L14:
        String r31 = "";
        if (r30 != null) goto L17;
        r30 = "";
    L17:
        String r32 = r28.y6(r30);
        py9.a r33 = this.this$0.c4();
        if (r33 == null) goto L20;
        Map<String, String> r34 = r33.Jw(r32);
    L21:
        CreationEditorComponent r35 = this.this$0;
        String r36 = this.$localPath;
        r35.getClass();
        if (r36 != null) goto L24;
    L27:
        boolean r37 = true;
    L28:
        if (r37 == false) goto L30;
        AttachmentInfo r113 = null;
    L46:
        boolean r38 = this.this$0.V5();
        Bundle r39 = this.$bundle;
        if (r39 == null) goto L49;
        String r40 = r39.getString("creation_send_trace_id");
    L50:
        if (r40 != null) goto L52;
        ConcurrentHashMap r41 = ko8.b.a;
        String r42 = UUID.randomUUID().toString();
    L53:
        if (r40 != null) goto L55;
    L58:
        boolean r43 = true;
    L59:
        if (r43 == false) goto L65;
        ConcurrentHashMap r44 = ko8.b.a;
        if (r113 == null) goto L63;
        String r45 = "single_attachment";
    L64:
        ko8.b.d(r42, r45);
        goto L65
    L63:
        r45 = "text";
    L65:
        ny9.s r46 = this.this$0.W3();
        if (r46 != null) goto L68;
    L70:
        boolean r47 = false;
    L71:
        if (r47 == false) goto L83;
        String r48 = StringsKt.trim(this.$userInput).toString();
        ny9.s r49 = this.this$0.W3();
        if (r49 == null) goto L77;
        CustomInputInitData r50 = r49.g();
        if (r50 == null) goto L77;
        String r52 = r50.b();
    L78:
        if (r52 != null) goto L81;
        r52 = "";
    L81:
        if (Intrinsics.areEqual(r48, StringsKt.trim(r52).toString()) == false) goto L91;
    L92:
        boolean r210 = false;
    L93:
        com.larus.bmhome.instruction.j r114 = IAIChatUgcAIGCService.a.e0();
        ny9.s r53 = this.this$0.W3();
        if (r53 == null) goto L98;
        com.larus.bmhome.actionbar.model.z0 r54 = r53.f();
        if (r54 == null) goto L98;
        String r55 = r54.b;
    L99:
        if (r55 != null) goto L101;
        String r115 = "";
    L102:
        String r56 = this.$instructionParam;
        ny9.s r57 = this.this$0.W3();
        if (r57 == null) goto L107;
        com.larus.bmhome.actionbar.model.z0 r58 = r57.f();
        if (r58 == null) goto L107;
        Long r211 = r58.a;
    L108:
        Map r116 = r114.b(r115, "16", r56, r210, null, r211);
        String r59 = this.this$0.i4().getInstructionInputBoxHint();
        if (r59 != null) goto L111;
        String r117 = "";
    L112:
        ny9.s r60 = this.this$0.W3();
        if (r60 == null) goto L115;
        boolean r212 = r60.D();
    L116:
        ny9.s r61 = this.this$0.W3();
        if (r61 == null) goto L119;
        boolean r310 = r61.y();
    L120:
        ny9.u r62 = this.this$0.d4();
        if (r62 == null) goto L123;
        String r63 = r62.getEnterMethod();
    L124:
        if (r63 != null) goto L126;
        String r311 = "";
    L127:
        ny9.u r64 = this.this$0.d4();
        if (r64 == null) goto L130;
        String r312 = r64.b();
    L131:
        ICoreInputAbility.OnSendParams r65 = new ICoreInputAbility.OnSendParams(r32, r117, r113, null, null, r116, null, null, 16, false, null, false, r212, false, null, null, null, null, r310, r311, r34, null, "edit", "edit", r312, null, null, null, null, null, null, null, null, -31199552, 1, null);
        py9.a r66 = this.this$0.c4();
        if (r66 == null) goto L134;
        CreatePageSendMessageProcessor r67 = r66.Ck();
    L135:
        if (r38 == false) goto L143;
        if (r67 == null) goto L161;
        Bundle r68 = this.$bundle;
        if (r68 != null) goto L140;
        r68 = com.larus.utils.f.c(new Pair[0]);
    L140:
        Bundle r69 = r68;
        this.label = 1;
        if (ny9.d.a.a(r67, r69, r65, false, r42, this, 4) != r9) goto L161;
        return r9;
    L143:
        py9.a r70 = this.this$0.c4();
        if (r70 == null) goto L161;
        CreatePageSendMessageProcessor r71 = r70.Ck();
        if (r71 == null) goto L161;
        Bundle r72 = this.$bundle;
        if (r72 != null) goto L150;
        r72 = com.larus.utils.f.c(new Pair[0]);
    L150:
        String r73 = this.$instructionParam;
        if (r73 == null) goto L154;
        r31 = r73;
    L154:
        String r74 = this.$localPath;
        py9.a r75 = this.this$0.c4();
        if (r75 == null) goto L157;
        Map<String, String> r76 = r75.Jw(r32);
    L158:
        this.label = 2;
        if (ny9.d.a.b(r71, r72, r31, r74, r32, r76, r42, this) != r9) goto L161;
        return r9;
    L157:
        r76 = null;
        goto L158
    L134:
        r67 = null;
        goto L135
    L130:
        r312 = null;
        goto L131
    L126:
        r311 = r63;
        goto L127
    L123:
        r63 = null;
        goto L124
    L119:
        r310 = false;
        goto L120
    L115:
        r212 = false;
        goto L116
    L111:
        r117 = r59;
    L107:
        r211 = null;
        goto L108
    L101:
        r115 = r55;
    L98:
        r55 = null;
    L91:
        r210 = true;
    L77:
        r52 = null;
        goto L78
    L83:
        String r77 = StringsKt.trim(this.$userInput).toString();
        ny9.s r78 = this.this$0.W3();
        if (r78 == null) goto L86;
        String r79 = r78.q();
    L87:
        if (r79 != null) goto L90;
        r79 = "";
    L90:
        if (Intrinsics.areEqual(r77, StringsKt.trim(r79).toString()) == true) goto L92;
    L86:
        r79 = null;
        goto L87
    L68:
        if (r46.z() != true) goto L70;
        r47 = true;
        goto L71
    L55:
        if (r40.length() == 0) goto L58;
        r43 = false;
        goto L59
    L52:
        r42 = r40;
        goto L53
    L49:
        r40 = null;
        goto L50
    L30:
        Uri r80 = UriProtector.parse(r36);
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L33;
    L35:
        String r81 = r80.getPath();
        if (r81 != null) goto L39;
        r81 = "";
    L39:
        if (r81.length() != 0) goto L41;
        boolean r82 = true;
    L42:
        if (r82 == false) goto L44;
    L43:
        String r118 = r36;
    L45:
        r113 = new AttachmentInfo(true, "", null, null, r118, null, "", null, null, null, null, null, null, null, null, null, null, 130956, null);
        goto L46
    L44:
        r118 = r81;
        goto L45
    L41:
        r82 = false;
        goto L42
    L33:
        if (Intrinsics.areEqual(r80.getScheme(), "file") == true) goto L35;
    L24:
        if (r36.length() == 0) goto L27;
        r37 = false;
        goto L28
    L20:
        r34 = null;
        goto L21
    L13:
        r30 = null;
        goto L14
    }
}
