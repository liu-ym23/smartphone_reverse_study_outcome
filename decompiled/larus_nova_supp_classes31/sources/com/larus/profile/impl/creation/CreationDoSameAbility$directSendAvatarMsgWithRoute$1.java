package com.larus.profile.impl.creation;

import android.os.Bundle;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$directSendAvatarMsgWithRoute$1", f = "CreationDoSameAbility.kt", i = {0, 0, 0, 0, 0, 2}, l = {2577, 2618, 2624, 2625, 2633}, m = "invokeSuspend", n = {"targetActionBarItem", "content", "screenText", "instructionConf", "url", "sendConfig"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0"})
final class CreationDoSameAbility$directSendAvatarMsgWithRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ sq9.p $doSameInitParams;
    final /* synthetic */ Map<String, String> $messageExt;
    final /* synthetic */ Function1<Bundle, Unit> $openRoute;
    final /* synthetic */ UserCreation $userCreation;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ CreationDoSameAbility this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public CreationDoSameAbility$directSendAvatarMsgWithRoute$1(CreationDoSameAbility r1, UserCreation r2, sq9.p r3, Map<String, String> r4, Function1<? super Bundle, Unit> r5, Continuation<? super CreationDoSameAbility$directSendAvatarMsgWithRoute$1> r6) {
        this.this$0 = r1;
        this.$userCreation = r2;
        this.$doSameInitParams = r3;
        this.$messageExt = r4;
        this.$openRoute = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CreationDoSameAbility$directSendAvatarMsgWithRoute$1(this.this$0, this.$userCreation, this.$doSameInitParams, this.$messageExt, this.$openRoute, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r66) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L12;
        if (r0 == 5) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r66);
    L166:
        return Unit.INSTANCE;
    L13:
        final CreationSendMessageConfig r1 = (CreationSendMessageConfig) this.L$0;
        ResultKt.throwOnFailure(r66);
    L159:
        final CreationDoSameAbility r2 = this.this$0;
        final Function1<Bundle, Unit> r3 = this.$openRoute;
        Function0 r4 = new l(r3, r2, r1);
        this.L$0 = null;
        this.label = 4;
        if (CreationDoSameAbility.h(r2, "directSendAvatarMsgWithRoute open", r4, this) != r7) goto L166;
        return r7;
    L14:
        ResultKt.throwOnFailure(r66);
        Object r5 = r66;
    L156:
        r1 = (CreationSendMessageConfig) r5;
        CreationDoSameAbility r6 = this.this$0;
        this.L$0 = r1;
        this.label = 3;
        if (CreationDoSameAbility.e(r6, r1, this) != r7) goto L159;
        return r7;
    L15:
        String r8 = (String) this.L$4;
        com.larus.bmhome.actionbar.model.r r9 = (com.larus.bmhome.actionbar.model.r) this.L$3;
        String r11 = (String) this.L$2;
        String r12 = (String) this.L$1;
        com.larus.bmhome.actionbar.model.z0 r13 = (com.larus.bmhome.actionbar.model.z0) this.L$0;
        ResultKt.throwOnFailure(r66);
        Object r10 = r66;
        String r40 = r8;
    L75:
        com.larus.uaigc.api.s r14 = (com.larus.uaigc.api.s) ((com.larus.network.http.a) r10).b;
        if (r14 == null) goto L80;
        List<com.larus.uaigc.api.q> r15 = r14.a();
        if (r15 == null) goto L80;
        com.larus.uaigc.api.q r16 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r15);
    L81:
        if (r16 == null) goto L83;
        String r17 = r16.c();
    L84:
        if (r17 != null) goto L86;
        String r30 = "";
    L87:
        if (r16 == null) goto L97;
        com.larus.uaigc.api.p r18 = r16.b();
        if (r18 == null) goto L97;
        com.larus.uaigc.api.n r19 = r18.a();
        if (r19 == null) goto L97;
        com.larus.uaigc.api.m r20 = r19.a();
        if (r20 == null) goto L97;
        Long r21 = r20.a();
        if (r21 == null) goto L97;
        int r22 = (int) r21.longValue();
    L98:
        if (r16 == null) goto L108;
        com.larus.uaigc.api.p r23 = r16.b();
        if (r23 == null) goto L108;
        com.larus.uaigc.api.n r24 = r23.a();
        if (r24 == null) goto L108;
        com.larus.uaigc.api.m r25 = r24.a();
        if (r25 == null) goto L108;
        Long r26 = r25.b();
        if (r26 == null) goto L108;
        int r27 = (int) r26.longValue();
    L109:
        AttachmentInfo r31 = new AttachmentInfo(true, r30, Boxing.boxInt(r22), Boxing.boxInt(r27), "", "", "edit", null, null, null, null, r40, null, null, null, null, null, 128896, null);
        com.larus.bmhome.actionbar.model.r r28 = r9;
    L70:
        String r29 = r11;
        if (r13 == null) goto L116;
        com.larus.bmhome.actionbar.model.r r32 = r13.q;
        if (r32 == null) goto L116;
        Integer r33 = r32.a;
        if (r33 == null) goto L116;
        int r37 = r33.intValue();
    L117:
        com.larus.bmhome.instruction.c2 r110 = com.larus.bmhome.instruction.c2.a;
        if (r13 == null) goto L120;
        String r34 = r13.b;
    L121:
        if (r34 != null) goto L123;
        String r111 = "";
    L124:
        if (r13 == null) goto L130;
        com.larus.bmhome.actionbar.model.r r35 = r13.q;
        if (r35 == null) goto L130;
        Integer r36 = r35.a;
        if (r36 == null) goto L130;
        String r38 = r36.toString();
    L131:
        if (r38 != null) goto L133;
        String r112 = "";
    L134:
        if (r13 == null) goto L138;
        com.larus.bmhome.actionbar.model.r r39 = r13.q;
        if (r39 == null) goto L138;
        Integer r41 = r39.a;
    L139:
        com.larus.bmhome.actionbar.model.r r42 = com.larus.bmhome.instruction.j.a.b(r41, r12, null, r28);
        if (r42 == null) goto L142;
        String r113 = HttpExtKt.p(r42);
    L143:
        Map<String, String> r43 = this.$messageExt;
        if (r13 == null) goto L146;
        Long r210 = r13.a;
    L147:
        Map r310 = r110.b(r111, r112, r113, false, r43, r210);
        sq9.p r44 = this.$doSameInitParams;
        String r45 = r44.c;
        if (r45 != null) goto L150;
        String r48 = "";
    L151:
        final ICoreInputAbility.OnSendParams r46 = new ICoreInputAbility.OnSendParams(r29, "", r31, null, null, r310, null, null, r37, false, null, false, false, false, null, null, null, null, false, r48, this.$messageExt, null, null, null, r44.b, null, null, null, null, null, null, null, null, -18350400, 1, null);
        CreationDoSameAbility r47 = this.this$0;
        int r49 = CreationDoSameAbility.f;
        r47.getClass();
        if (CreationDoSameAbility.r() == false) goto L162;
        CreationDoSameAbility r50 = this.this$0;
        sq9.p r51 = this.$doSameInitParams;
        UserCreation r52 = this.$userCreation;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.label = 2;
        r5 = CreationDoSameAbility.c(r50, r46, r51, r52, "avatar", this);
        if (r5 != r7) goto L156;
        return r7;
    L162:
        CreationDoSameAbility r53 = this.this$0;
        final Function1<Bundle, Unit> r54 = this.$openRoute;
        Function0 r55 = new m(r54, r46);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.label = 5;
        if (CreationDoSameAbility.h(r53, "directSendAvatarMsgWithRoute legacyOpen", r55, this) != r7) goto L166;
        return r7;
    L150:
        r48 = r45;
        goto L151
    L146:
        r210 = null;
        goto L147
    L142:
        r113 = null;
    L138:
        r41 = null;
        goto L139
    L133:
        r112 = r38;
    L130:
        r38 = null;
        goto L131
    L123:
        r111 = r34;
        goto L124
    L120:
        r34 = null;
    L116:
        r37 = 0;
    L108:
        r27 = 0;
    L97:
        r22 = 0;
        goto L98
    L86:
        r30 = r17;
        goto L87
    L83:
        r17 = null;
    L80:
        r16 = null;
        goto L81
    L16:
        ResultKt.throwOnFailure(r66);
        r13 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(11);
        String r56 = CreationDoSameAbility.f(this.this$0, this.$userCreation, this.$doSameInitParams);
        if (r56 != null) goto L19;
        r12 = "";
    L21:
        if (this.$userCreation.b != 3) goto L23;
        r11 = CreationDoSameAbility.b(this.this$0, r13, r12);
    L24:
        if (r13 == null) goto L49;
        com.larus.bmhome.actionbar.model.r r114 = r13.q;
        if (r114 == null) goto L49;
        com.larus.bmhome.actionbar.model.j1 r57 = r114.e;
        if (r57 == null) goto L47;
        String r58 = this.$doSameInitParams.o;
        if (r58 != null) goto L32;
        r58 = this.$userCreation.h();
    L32:
        String r211 = r58;
        sq9.p r59 = this.$doSameInitParams;
        String r60 = r59.p;
        String r61 = r59.q;
        if (r61 != null) goto L38;
        Image r62 = this.$userCreation.g();
        if (r62 == null) goto L37;
        r61 = Boxing.boxLong(r62.c).toString();
        goto L38
    L37:
        String r212 = null;
    L39:
        String r63 = this.$doSameInitParams.r;
        if (r63 != null) goto L45;
        Image r64 = this.$userCreation.g();
        if (r64 == null) goto L44;
        r63 = Boxing.boxLong(r64.d).toString();
        goto L45
    L44:
        String r213 = null;
    L46:
        com.larus.bmhome.actionbar.model.j1 r115 = com.larus.bmhome.actionbar.model.j1.a(r57, null, null, null, r211, r60, r212, r213, null, null, 16285695);
    L48:
        r28 = com.larus.bmhome.actionbar.model.r.a(r114, null, null, r115, null, 4079);
    L50:
        CreationDynamicInfo r65 = this.$userCreation.h;
        if (r65 == null) goto L55;
        TplInfo r67 = r65.e;
        if (r67 == null) goto L55;
        String r68 = r67.a;
    L57:
        if (Intrinsics.areEqual(r68, TplType.AI_REPLICA) == true) goto L71;
        TplDetail r69 = is9.a.c(this.$userCreation);
        if (r69 == null) goto L66;
        Integer r70 = r69.a;
        if (r70 == null) goto L66;
        if (r70.intValue() != 2) goto L66;
        boolean r71 = true;
    L67:
        if (r71 == true) goto L71;
        r31 = null;
    L66:
        r71 = false;
    L71:
        String r72 = this.$userCreation.e();
        List r73 = CollectionsKt.listOf(r72);
        this.L$0 = r13;
        this.L$1 = r12;
        this.L$2 = r11;
        this.L$3 = r28;
        this.L$4 = r72;
        this.label = 1;
        r10 = com.larus.uaigc.api.o.a(r73, true, this);
        if (r10 != r7) goto L74;
        return r7;
    L74:
        r9 = r28;
        r40 = r72;
    L55:
        r68 = null;
    L45:
        r213 = r63;
    L38:
        r212 = r61;
        goto L39
    L47:
        r115 = null;
    L49:
        r28 = null;
        goto L50
    L23:
        r11 = r12;
        goto L24
    L19:
        r12 = r56;
        goto L21
    }
}
