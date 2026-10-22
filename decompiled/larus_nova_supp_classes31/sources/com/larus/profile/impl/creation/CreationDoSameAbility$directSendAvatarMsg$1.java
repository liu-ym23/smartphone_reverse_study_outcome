package com.larus.profile.impl.creation;

import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplButtonType;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$directSendAvatarMsg$1", f = "CreationDoSameAbility.kt", i = {1}, l = {1873, 1879}, m = "invokeSuspend", n = {"sendConfig"}, s = {"L$0"})
final class CreationDoSameAbility$directSendAvatarMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ sq9.p $doSameInitParams;
    final /* synthetic */ UserCreation $userCreation;
    Object L$0;
    int label;
    final /* synthetic */ CreationDoSameAbility this$0;

    public CreationDoSameAbility$directSendAvatarMsg$1(CreationDoSameAbility r1, UserCreation r2, sq9.p r3, Continuation<? super CreationDoSameAbility$directSendAvatarMsg$1> r4) {
        this.this$0 = r1;
        this.$userCreation = r2;
        this.$doSameInitParams = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationDoSameAbility$directSendAvatarMsg$1(this.this$0, this.$userCreation, this.$doSameInitParams, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r50) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        CreationSendMessageConfig r1 = (CreationSendMessageConfig) this.L$0;
        ResultKt.throwOnFailure(r50);
    L114:
        FLogger.a.i("CreationDoSameAbility", "directSendAvatarMsg, cvsId is " + r1.getCvsId());
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r50);
        Object r2 = r50;
    L111:
        r1 = (CreationSendMessageConfig) r2;
        CreationDoSameAbility r3 = this.this$0;
        this.L$0 = r1;
        this.label = 2;
        if (CreationDoSameAbility.e(r3, r1, this) != r7) goto L114;
        return r7;
    L10:
        ResultKt.throwOnFailure(r50);
        JSONObject r4 = new JSONObject();
        sq9.p r5 = this.$doSameInitParams;
        UserCreation r6 = this.$userCreation;
        UserCreation r8 = r5.d;
        Long r9 = null;
        if (r8 == null) goto L13;
        String r10 = r8.a;
    L14:
        r4.put("id", r10);
        r4.put("recommend_from", r5.g);
        UserCreationTrackParams r11 = r6.n;
        if (r11 == null) goto L17;
        String r12 = r11.a;
    L18:
        r4.put("template_rec_req_id", r12);
        r4.put("template_rec_extra", r6.i);
        r4.put("from_template_id", r6.a);
        boolean r13 = IUgcAIGCService.a.v();
        r4.put("tpl_tag_type", r6.q(r13));
        if (r6.b == 3) goto L33;
        CreationDynamicInfo r14 = r6.h;
        if (r14 == null) goto L25;
        TplInfo r15 = r14.e;
        if (r15 == null) goto L25;
        String r16 = r15.a;
    L27:
        if (Intrinsics.areEqual(r16, TplType.AI_REPLICA) == true) goto L33;
        String r17 = r5.l;
        if (r17 == null) goto L32;
        String r18 = sq9.q.a(r17, r6, r13, false);
    L34:
        r4.put("tpl_button_type", r18);
        r4.put("actionbar_creation_type", "avatar");
        Map r33 = MapsKt.mapOf(TuplesKt.to("creation_template", r4.toString()));
        com.larus.bmhome.actionbar.model.z0 r19 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(11);
        String r20 = CreationDoSameAbility.f(this.this$0, this.$userCreation, this.$doSameInitParams);
        if (r20 != null) goto L38;
        r20 = "";
    L38:
        if (this.$userCreation.b != 3) goto L40;
        String r21 = CreationDoSameAbility.b(this.this$0, r19, r20);
    L41:
        if (r19 == null) goto L66;
        com.larus.bmhome.actionbar.model.r r110 = r19.q;
        if (r110 == null) goto L66;
        com.larus.bmhome.actionbar.model.j1 r111 = r110.e;
        if (r111 == null) goto L64;
        String r22 = this.$doSameInitParams.o;
        if (r22 != null) goto L49;
        r22 = this.$userCreation.h();
    L49:
        String r112 = r22;
        sq9.p r23 = this.$doSameInitParams;
        String r113 = r23.p;
        String r24 = r23.q;
        if (r24 != null) goto L55;
        Image r25 = this.$userCreation.g();
        if (r25 == null) goto L54;
        r24 = Boxing.boxLong(r25.c).toString();
        goto L55
    L54:
        String r26 = null;
    L56:
        String r27 = this.$doSameInitParams.r;
        if (r27 != null) goto L62;
        Image r28 = this.$userCreation.g();
        if (r28 == null) goto L61;
        r27 = Boxing.boxLong(r28.d).toString();
        goto L62
    L61:
        String r29 = null;
    L63:
        com.larus.bmhome.actionbar.model.j1 r114 = com.larus.bmhome.actionbar.model.j1.a(r111, null, null, null, r112, r113, r26, r29, null, null, 16285695);
    L65:
        com.larus.bmhome.actionbar.model.r r30 = com.larus.bmhome.actionbar.model.r.a(r110, null, null, r114, null, 4079);
    L67:
        com.larus.bmhome.instruction.c2 r115 = com.larus.bmhome.instruction.c2.a;
        if (r19 == null) goto L70;
        String r31 = r19.b;
    L71:
        if (r31 != null) goto L73;
        String r116 = "";
    L74:
        if (r19 == null) goto L80;
        com.larus.bmhome.actionbar.model.r r32 = r19.q;
        if (r32 == null) goto L80;
        Integer r34 = r32.a;
        if (r34 == null) goto L80;
        String r35 = r34.toString();
    L81:
        if (r35 != null) goto L83;
        String r117 = "";
    L84:
        if (r19 == null) goto L88;
        com.larus.bmhome.actionbar.model.r r36 = r19.q;
        if (r36 == null) goto L88;
        Integer r37 = r36.a;
    L89:
        com.larus.bmhome.actionbar.model.r r38 = com.larus.bmhome.instruction.j.a.b(r37, r20, null, r30);
        if (r38 == null) goto L92;
        String r118 = HttpExtKt.p(r38);
    L94:
        if (r19 == null) goto L96;
        r9 = r19.a;
    L96:
        Map r119 = r115.b(r116, r117, r118, false, r33, r9);
        String r120 = StringsKt.trim(r21).toString();
        if (r19 == null) goto L103;
        com.larus.bmhome.actionbar.model.r r39 = r19.q;
        if (r39 == null) goto L103;
        Integer r40 = r39.a;
        if (r40 == null) goto L103;
        int r210 = r40.intValue();
    L104:
        sq9.p r41 = this.$doSameInitParams;
        String r42 = r41.c;
        if (r42 != null) goto L107;
        String r310 = "";
    L108:
        ICoreInputAbility.OnSendParams r43 = new ICoreInputAbility.OnSendParams(r120, "", null, null, null, r119, null, null, r210, false, null, false, false, false, null, null, null, null, false, r310, r33, null, null, null, r41.b, null, null, null, null, null, null, null, null, -18350400, 1, null);
        CreationDoSameAbility r44 = this.this$0;
        sq9.p r45 = this.$doSameInitParams;
        UserCreation r46 = this.$userCreation;
        this.label = 1;
        r2 = CreationDoSameAbility.c(r44, r43, r45, r46, "avatar", this);
        if (r2 != r7) goto L111;
        return r7;
    L107:
        r310 = r42;
    L103:
        r210 = 0;
        goto L104
    L92:
        r118 = null;
    L88:
        r37 = null;
        goto L89
    L83:
        r117 = r35;
    L80:
        r35 = null;
        goto L81
    L73:
        r116 = r31;
        goto L74
    L70:
        r31 = null;
    L62:
        r29 = r27;
    L55:
        r26 = r24;
        goto L56
    L64:
        r114 = null;
    L66:
        r30 = null;
        goto L67
    L40:
        r21 = r20;
        goto L41
    L32:
        r18 = null;
    L25:
        r16 = null;
    L33:
        r18 = TplButtonType.GEN_CREATE_AVATAR;
        goto L34
    L17:
        r12 = null;
        goto L18
    L13:
        r10 = null;
        goto L14
    }
}
