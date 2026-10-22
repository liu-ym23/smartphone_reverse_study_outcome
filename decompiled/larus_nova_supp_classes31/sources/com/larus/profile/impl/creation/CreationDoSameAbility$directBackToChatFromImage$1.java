package com.larus.profile.impl.creation;

import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplButtonType;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$directBackToChatFromImage$1", f = "CreationDoSameAbility.kt", i = {0, 0, 0, 0, 1, 1, 1, 3}, l = {2282, 2287, 2324, 2330, 2331, 2342, 2355, 2356}, m = "invokeSuspend", n = {"msgExtMap", "targetInstructionItem", "entities", "job2", "msgExtMap", "targetInstructionItem", "entities", "sendConfig"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0"})
final class CreationDoSameAbility$directBackToChatFromImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionBarCreationType;
    final /* synthetic */ sq9.p $doSameInitParams;
    final /* synthetic */ String $fileLocalPath;
    final /* synthetic */ String $mainBotId;
    final /* synthetic */ UserCreation $userCreation;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ CreationDoSameAbility this$0;

    public CreationDoSameAbility$directBackToChatFromImage$1(CreationDoSameAbility r1, String r2, sq9.p r3, UserCreation r4, String r5, String r6, Continuation<? super CreationDoSameAbility$directBackToChatFromImage$1> r7) {
        this.this$0 = r1;
        this.$mainBotId = r2;
        this.$doSameInitParams = r3;
        this.$userCreation = r4;
        this.$actionBarCreationType = r5;
        this.$fileLocalPath = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CreationDoSameAbility$directBackToChatFromImage$1 r8 = new CreationDoSameAbility$directBackToChatFromImage$1(this.this$0, this.$mainBotId, this.$doSameInitParams, this.$userCreation, this.$actionBarCreationType, this.$fileLocalPath, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r58) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r58);
    L152:
        return Unit.INSTANCE;
    L7:
        ResultKt.throwOnFailure(r58);
    L148:
        final CreationDoSameAbility r0 = this.this$0;
        Function0 r1 = new j(r0);
        this.label = 8;
        if (CreationDoSameAbility.h(r0, "directBackToChatFromImage finish", r1, this) != r7) goto L152;
        return r7;
    L8:
        ResultKt.throwOnFailure(r58);
    L145:
        this.label = 7;
        if (DelayKt.delay(100, this) != r7) goto L148;
        return r7;
    L9:
        final CreationSendMessageConfig r2 = (CreationSendMessageConfig) this.L$0;
        ResultKt.throwOnFailure(r58);
    L139:
        final CreationDoSameAbility r3 = this.this$0;
        Function0 r4 = new h(r3, r2);
        this.L$0 = null;
        this.label = 5;
        if (CreationDoSameAbility.h(r3, "directBackToChatFromImage setResult", r4, this) != r7) goto L145;
        return r7;
    L10:
        ResultKt.throwOnFailure(r58);
        Object r5 = r58;
    L136:
        r2 = (CreationSendMessageConfig) r5;
        CreationDoSameAbility r6 = this.this$0;
        this.L$0 = r2;
        this.label = 4;
        if (CreationDoSameAbility.e(r6, r2, this) != r7) goto L139;
        return r7;
    L11:
        List r8 = (List) this.L$2;
        com.larus.bmhome.actionbar.model.z0 r9 = (com.larus.bmhome.actionbar.model.z0) this.L$1;
        Map r10 = (Map) this.L$0;
        ResultKt.throwOnFailure(r58);
        List r11 = r8;
        Map r41 = r10;
        Object r12 = r58;
    L51:
        UplinkFileEntity r13 = (UplinkFileEntity) r12;
        if (r13 == null) goto L54;
        Boxing.boxBoolean(r11.add(r13));
    L54:
        CustomMultiAttachmentInfo r47 = new CustomMultiAttachmentInfo("album", this.$doSameInitParams.c, new NestedFileContent(r11, null, false, null, 14, null), false, false, false, false, null, 248, null);
        CreationDoSameAbility r14 = this.this$0;
        UserCreation r15 = this.$userCreation;
        sq9.p r16 = this.$doSameInitParams;
        int r17 = CreationDoSameAbility.f;
        r14.getClass();
        String r18 = CreationDoSameAbility.j(r15, r16);
        if (r18 != null) goto L57;
        r18 = "";
    L57:
        if (r9 == null) goto L63;
        com.larus.bmhome.actionbar.model.r r19 = r9.q;
        if (r19 == null) goto L63;
        Integer r20 = r19.a;
        if (r20 == null) goto L63;
        int r29 = r20.intValue();
    L64:
        com.larus.bmhome.instruction.c2 r21 = com.larus.bmhome.instruction.c2.a;
        if (r9 == null) goto L67;
        String r22 = r9.b;
    L68:
        if (r22 != null) goto L70;
        String r23 = "";
    L71:
        if (r9 == null) goto L77;
        com.larus.bmhome.actionbar.model.r r24 = r9.q;
        if (r24 == null) goto L77;
        Integer r25 = r24.a;
        if (r25 == null) goto L77;
        String r26 = r25.toString();
    L78:
        if (r26 != null) goto L80;
        String r27 = "";
    L81:
        if (r9 == null) goto L85;
        com.larus.bmhome.actionbar.model.r r28 = r9.q;
        if (r28 == null) goto L85;
        Integer r110 = r28.a;
    L86:
        if (r9 == null) goto L115;
        com.larus.bmhome.actionbar.model.r r30 = r9.q;
        if (r30 == null) goto L115;
        com.larus.bmhome.actionbar.model.y r31 = r30.i;
        if (r31 == null) goto L115;
        ArrayList r32 = r31.a;
        if (r32 == null) goto L115;
        com.larus.bmhome.actionbar.model.z0 r33 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r32);
        if (r33 == null) goto L115;
        com.larus.bmhome.actionbar.model.r r34 = r33.q;
        if (r34 == null) goto L115;
        List r35 = r34.b;
        if (r35 == null) goto L115;
        Iterator r36 = r35.iterator();
    L101:
        if (r36.hasNext() == false) goto L111;
        Object r37 = r36.next();
        Integer r111 = ((com.larus.bmhome.actionbar.model.u) r37).b;
        if (r111 != null) goto L106;
    L108:
        boolean r112 = false;
    L109:
        if (r112 == false) goto L101;
    L112:
        com.larus.bmhome.actionbar.model.u r38 = (com.larus.bmhome.actionbar.model.u) r37;
        if (r38 == null) goto L115;
        List r113 = CollectionsKt.listOf(r38);
    L116:
        if (r9 == null) goto L118;
        com.larus.bmhome.actionbar.model.r r114 = r9.q;
    L119:
        com.larus.bmhome.actionbar.model.r r39 = r21.a(r110, r18, r113, r114, 0);
        if (r39 == null) goto L122;
        String r210 = HttpExtKt.p(r39);
    L124:
        if (r9 == null) goto L126;
        Long r211 = r9.a;
    L127:
        Map r212 = r21.b(r23, r27, r210, false, r41, r211);
        sq9.p r40 = this.$doSameInitParams;
        String r42 = r40.c;
        if (r42 != null) goto L130;
        String r43 = "";
    L131:
        final ICoreInputAbility.OnSendParams r44 = new ICoreInputAbility.OnSendParams(r18, "", null, null, null, r212, null, null, r29, false, null, false, false, false, null, null, null, null, false, r43, r41, null, null, null, r40.b, null, r47, null, null, null, null, null, null, -85459264, 1, null);
        this.this$0.getClass();
        if (CreationDoSameAbility.r() == false) goto L142;
        CreationDoSameAbility r45 = this.this$0;
        sq9.p r46 = this.$doSameInitParams;
        UserCreation r48 = this.$userCreation;
        String r49 = this.$actionBarCreationType;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        r5 = CreationDoSameAbility.c(r45, r44, r46, r48, r49, this);
        if (r5 != r7) goto L136;
        return r7;
    L142:
        final CreationDoSameAbility r50 = this.this$0;
        final sq9.p r51 = this.$doSameInitParams;
        final UserCreation r52 = this.$userCreation;
        Function0 r53 = new i(r50, r44, r51, r52);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 6;
        if (CreationDoSameAbility.h(r50, "directBackToChatFromImage setLegacyResult", r53, this) != r7) goto L145;
        return r7;
    L130:
        r43 = r42;
        goto L131
    L126:
        r211 = null;
        goto L127
    L122:
        r210 = null;
        goto L124
    L118:
        r114 = null;
        goto L119
    L106:
        if (r111.intValue() != 15) goto L108;
        r112 = true;
        goto L109
    L111:
        r37 = null;
    L115:
        r113 = null;
    L85:
        r110 = null;
        goto L86
    L80:
        r27 = r26;
    L77:
        r26 = null;
        goto L78
    L70:
        r23 = r22;
        goto L71
    L67:
        r22 = null;
    L63:
        r29 = 0;
        goto L64
    L12:
        Deferred r54 = (Deferred) this.L$3;
        List r55 = (List) this.L$2;
        com.larus.bmhome.actionbar.model.z0 r115 = (com.larus.bmhome.actionbar.model.z0) this.L$1;
        Map r116 = (Map) this.L$0;
        ResultKt.throwOnFailure(r58);
        List r56 = r55;
        com.larus.bmhome.actionbar.model.z0 r57 = r115;
        Map r59 = r116;
        Deferred r117 = r54;
        Object r60 = r58;
    L40:
        UplinkFileEntity r61 = (UplinkFileEntity) r60;
        if (r61 == null) goto L43;
    L45:
        if (r61 == null) goto L47;
        Boxing.boxBoolean(r56.add(r61));
    L47:
        this.L$0 = r59;
        this.L$1 = r57;
        this.L$2 = r56;
        this.L$3 = null;
        this.label = 2;
        r12 = r117.await(this);
        if (r12 != r7) goto L50;
        return r7;
    L50:
        r11 = r56;
        r41 = r59;
        r9 = r57;
        goto L51
    L43:
        if (Intrinsics.areEqual(this.$doSameInitParams.l, DoSameQuickMenuType.REPLACE_PIC) == false) goto L45;
        FLogger.a.w("CreationDoSameAbility", "directBackToChatFromImage stop, replace pic resource empty");
        goto L152
    L13:
        ResultKt.throwOnFailure(r58);
        CoroutineScope r62 = (CoroutineScope) this.L$0;
        Pair[] r63 = new Pair[2];
        r63[0] = TuplesKt.to("original_content_source", "use_template");
        JSONObject r118 = new JSONObject();
        sq9.p r119 = this.$doSameInitParams;
        UserCreation r120 = this.$userCreation;
        UserCreation r121 = r119.d;
        if (r121 == null) goto L16;
        String r122 = r121.a;
    L17:
        r118.put("id", r122);
        r118.put("recommend_from", r119.g);
        UserCreationTrackParams r123 = r120.n;
        if (r123 == null) goto L20;
        String r124 = r123.a;
    L21:
        r118.put("template_rec_req_id", r124);
        r118.put("template_rec_extra", r120.i);
        r118.put("from_template_id", r120.a);
        boolean r125 = IUgcAIGCService.a.v();
        r118.put("tpl_tag_type", r120.q(r125));
        if (r120.b == 3) goto L36;
        CreationDynamicInfo r126 = r120.h;
        if (r126 == null) goto L28;
        TplInfo r127 = r126.e;
        if (r127 == null) goto L28;
        String r128 = r127.a;
    L30:
        if (Intrinsics.areEqual(r128, TplType.AI_REPLICA) == true) goto L36;
        String r129 = r119.l;
        if (r129 == null) goto L35;
        String r130 = sq9.q.a(r129, r120, r125, false);
    L37:
        r118.put("tpl_button_type", r130);
        Unit r131 = Unit.INSTANCE;
        r63[1] = TuplesKt.to("creation_template", r118.toString());
        r59 = MapsKt.mapOf(r63);
        CreationDoSameAbility r132 = this.this$0;
        String r133 = this.$mainBotId;
        com.larus.bmhome.actionbar.model.z0 r134 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(4);
        int r135 = CreationDoSameAbility.f;
        com.larus.bmhome.actionbar.model.z0 r136 = (com.larus.bmhome.actionbar.model.z0) r132.q(r133, r134).getFirst();
        r56 = new ArrayList();
        r57 = r136;
        Deferred r137 = BuildersKt.async$default(r62, null, null, new CreationDoSameAbility$directBackToChatFromImage$1$job1$1(this.$doSameInitParams, this.$userCreation, this.this$0, null), 3, null);
        r117 = BuildersKt.async$default(r62, null, null, new CreationDoSameAbility$directBackToChatFromImage$1$job2$1(this.$fileLocalPath, null), 3, null);
        this.L$0 = r59;
        this.L$1 = r57;
        this.L$2 = r56;
        this.L$3 = r117;
        this.label = 1;
        r60 = r137.await(this);
        if (r60 != r7) goto L40;
        return r7;
    L35:
        r130 = null;
    L28:
        r128 = null;
    L36:
        r130 = TplButtonType.GEN_CREATE_AVATAR;
        goto L37
    L20:
        r124 = null;
        goto L21
    L16:
        r122 = null;
        goto L17
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
