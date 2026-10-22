package com.larus.profile.impl.creation;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.creation.UserCreation;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$jumpToAIBeautifyDoSame$2$1", f = "CreationDoSameAbility.kt", i = {1}, l = {1430, 1438}, m = "invokeSuspend", n = {"sendConfig"}, s = {"L$0"})
final class CreationDoSameAbility$jumpToAIBeautifyDoSame$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ sq9.p $doSameInitParams;
    final /* synthetic */ String $fileLocalPath;
    final /* synthetic */ p $hitPointData;
    final /* synthetic */ String $instructionDefaultParams;
    final /* synthetic */ String $prompt;
    final /* synthetic */ UserCreation $userCreation;
    Object L$0;
    int label;
    final /* synthetic */ CreationDoSameAbility this$0;

    public CreationDoSameAbility$jumpToAIBeautifyDoSame$2$1(CreationDoSameAbility r1, String r2, String r3, String r4, p r5, sq9.p r6, UserCreation r7, Context r8, Continuation<? super CreationDoSameAbility$jumpToAIBeautifyDoSame$2$1> r9) {
        this.this$0 = r1;
        this.$prompt = r2;
        this.$fileLocalPath = r3;
        this.$instructionDefaultParams = r4;
        this.$hitPointData = r5;
        this.$doSameInitParams = r6;
        this.$userCreation = r7;
        this.$context = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new CreationDoSameAbility$jumpToAIBeautifyDoSame$2$1(this.this$0, this.$prompt, this.$fileLocalPath, this.$instructionDefaultParams, this.$hitPointData, this.$doSameInitParams, this.$userCreation, this.$context, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r53) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r10 = "7234781073513644036";
        String r11 = null;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        CreationSendMessageConfig r1 = (CreationSendMessageConfig) this.L$0;
        ResultKt.throwOnFailure(r53);
    L118:
        if (CreationDoSameAbility.g(this.this$0) == false) goto L131;
        com.bytedance.router.i r2 = SmartRouter.buildRoute(this.$context, "//flow/chat_page");
        Pair[] r3 = new Pair[4];
        String r4 = this.$doSameInitParams.h;
        if (r4 != null) goto L129;
        com.larus.bmhome.chat.api.e0 r5 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r5 == null) goto L126;
        LaunchInfo r6 = r5.a;
        if (r6 == null) goto L126;
        r11 = r6.W();
    L126:
        if (r11 == null) goto L130;
        r10 = r11;
    L130:
        r3[0] = TuplesKt.to("argBotId", r10);
        r3[1] = TuplesKt.to("argBotType", Boxing.boxInt(1));
        r3[2] = TuplesKt.to("argPreviousPage", this.$doSameInitParams.b);
        r3[3] = TuplesKt.to("creation_send_ui_event", CreationDoSameAbility.d(this.this$0, r1));
        r2.c.putExtras(com.larus.utils.f.c(r3));
        r2.d = 2130772401;
        r2.e = 2130772399;
        r2.d();
    L133:
        return Unit.INSTANCE;
    L129:
        r10 = r4;
        goto L130
    L131:
        FLogger.a.w("CreationDoSameAbility", "jumpToAIBeautifyDoSame route skipped, fragment inactive");
        goto L133
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r53);
        Object r7 = r53;
    L114:
        CreationSendMessageConfig r15 = (CreationSendMessageConfig) r7;
        CreationDoSameAbility r9 = this.this$0;
        p r12 = this.$hitPointData;
        int r13 = CreationDoSameAbility.f;
        r9.getClass();
        r1 = CreationSendMessageConfig.copy$default(r15, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ny9.u(new ny9.s(com.larus.utils.f.c(new Pair[]{TuplesKt.to("instruction_hit_point_params", ny9.v.a(r12))}))), null, null, null, null, null, null, false, null, null, false, false, null, 134201343, null);
        CreationDoSameAbility r14 = this.this$0;
        this.L$0 = r1;
        this.label = 2;
        if (CreationDoSameAbility.e(r14, r1, this) != r8) goto L118;
        return r8;
    L10:
        ResultKt.throwOnFailure(r53);
        CreationDoSameAbility r16 = this.this$0;
        String r17 = this.$prompt;
        String r18 = this.$fileLocalPath;
        String r19 = this.$instructionDefaultParams;
        p r20 = this.$hitPointData;
        int r21 = CreationDoSameAbility.f;
        r16.getClass();
        String r22 = "";
        if (r17 != null) goto L13;
        String r110 = "";
    L14:
        if (r18 != null) goto L16;
    L19:
        boolean r23 = true;
    L20:
        if (r23 == false) goto L22;
        AttachmentInfo r111 = null;
    L52:
        com.larus.bmhome.instruction.c2 r112 = com.larus.bmhome.instruction.c2.a;
        if (r19 != null) goto L55;
    L58:
        boolean r24 = true;
    L59:
        if (r24 == true) goto L110;
        com.larus.bmhome.chat.api.e0 r25 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r25 == null) goto L67;
        LaunchInfo r26 = r25.a;
        if (r26 == null) goto L67;
        String r27 = r26.W();
        if (r27 == null) goto L67;
    L68:
        List r28 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r27);
        if (r28 == null) goto L88;
        Iterator r29 = r28.iterator();
    L72:
        if (r29.hasNext() == false) goto L84;
        Object r30 = r29.next();
        com.larus.bmhome.actionbar.model.r r31 = ((com.larus.bmhome.actionbar.model.z0) r30).q;
        if (r31 == null) goto L81;
        Integer r32 = r31.a;
        if (r32 == null) goto L81;
        if (r32.intValue() != 4) goto L81;
        boolean r33 = true;
    L82:
        if (r33 == false) goto L72;
    L85:
        com.larus.bmhome.actionbar.model.z0 r34 = (com.larus.bmhome.actionbar.model.z0) r30;
        if (r34 == null) goto L88;
        com.larus.bmhome.actionbar.model.r r35 = r34.q;
    L89:
        if (r35 == null) goto L108;
        List r36 = r35.b;
        if (r36 == null) goto L108;
        Iterator r37 = r36.iterator();
    L94:
        if (r37.hasNext() == false) goto L104;
        Object r38 = r37.next();
        Integer r39 = ((com.larus.bmhome.actionbar.model.u) r38).b;
        if (r39 != null) goto L99;
    L101:
        boolean r40 = false;
    L102:
        if (r40 == false) goto L94;
    L105:
        com.larus.bmhome.actionbar.model.u r41 = (com.larus.bmhome.actionbar.model.u) r38;
        if (r41 == null) goto L108;
        r41.d = r19;
        goto L108
    L99:
        if (r39.intValue() != 8) goto L101;
        r40 = true;
        goto L102
    L104:
        r38 = null;
    L108:
        if (r35 == null) goto L110;
        String r210 = HttpExtKt.p(r35);
    L111:
        ICoreInputAbility.OnSendParams r42 = new ICoreInputAbility.OnSendParams(r110, "", r111, null, null, r112.b("coco_instruction", "4", r210, false, null, null), null, null, 4, false, "", false, false, false, null, null, null, null, false, r20.getEnterMethod(), null, null, "edit", "edit", r20.b(), null, null, null, null, null, null, null, null, -30148416, 1, null);
        CreationDoSameAbility r43 = this.this$0;
        sq9.p r44 = this.$doSameInitParams;
        UserCreation r45 = this.$userCreation;
        this.label = 1;
        r7 = CreationDoSameAbility.c(r43, r42, r44, r45, "image_edit", this);
        if (r7 != r8) goto L114;
        return r8;
    L81:
        r33 = false;
        goto L82
    L84:
        r30 = null;
    L88:
        r35 = null;
    L67:
        r27 = "7234781073513644036";
    L110:
        r210 = null;
        goto L111
    L55:
        if (r19.length() == 0) goto L58;
        r24 = false;
        goto L59
    L22:
        Uri r46 = UriProtector.parse(r18);
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L25
        Object r48 = Result.constructor-impl(vqc.d.d(AppHost.a.getApplication(), r46));     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r48) == false) goto L30;
        r48 = null;
    L30:
        String r49 = (String) r48;
        if (r49 != null) goto L34;
        r49 = "";
    L34:
        if (r49.length() != 0) goto L36;
        boolean r50 = true;
    L37:
        if (r50 == false) goto L50;
        String r51 = r46.getPath();
        if (r51 == null) goto L43;
        r22 = r51;
    L43:
        if (r22.length() != 0) goto L45;
        boolean r52 = true;
    L46:
        if (r52 == true) goto L49;
        r18 = r22;
    L49:
        String r211 = r18;
    L51:
        r111 = new AttachmentInfo(true, "", null, null, r211, null, "edit", null, null, null, null, null, null, null, null, null, null, 130956, null);
        goto L52
    L45:
        r52 = false;
        goto L46
    L50:
        r211 = r49;
        goto L51
    L36:
        r50 = false;
    L25:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        r48 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L16:
        if (r18.length() == 0) goto L19;
        r23 = false;
        goto L20
    L13:
        r110 = r17;
        goto L14
    }
}
