package com.larus.profile.impl.creation;

import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplButtonType;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.service.IUgcAIGCService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$directBackToChatFromAvatar$1", f = "CreationDoSameAbility.kt", i = {0, 0, 0, 0, 0, 0, 2}, l = {2079, 2121, 2127, 2128, 2139, 2152, 2153}, m = "invokeSuspend", n = {"msgExtMap", "targetActionBarItem", "content", "screenText", "instructionConf", "url", "sendConfig"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0"})
final class CreationDoSameAbility$directBackToChatFromAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ sq9.p $doSameInitParams;
    final /* synthetic */ UserCreation $userCreation;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ CreationDoSameAbility this$0;

    public CreationDoSameAbility$directBackToChatFromAvatar$1(CreationDoSameAbility r1, UserCreation r2, sq9.p r3, Continuation<? super CreationDoSameAbility$directBackToChatFromAvatar$1> r4) {
        this.this$0 = r1;
        this.$userCreation = r2;
        this.$doSameInitParams = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationDoSameAbility$directBackToChatFromAvatar$1(this.this$0, this.$userCreation, this.$doSameInitParams, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r85) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r85);
    L192:
        return Unit.INSTANCE;
    L7:
        ResultKt.throwOnFailure(r85);
    L188:
        final CreationDoSameAbility r0 = this.this$0;
        Function0 r1 = new g(r0);
        this.label = 7;
        if (CreationDoSameAbility.h(r0, "directBackToChatFromAvatar finish", r1, this) != r7) goto L192;
        return r7;
    L8:
        ResultKt.throwOnFailure(r85);
    L185:
        this.label = 6;
        if (DelayKt.delay(100, this) != r7) goto L188;
        return r7;
    L9:
        final CreationSendMessageConfig r2 = (CreationSendMessageConfig) this.L$0;
        ResultKt.throwOnFailure(r85);
    L179:
        final CreationDoSameAbility r3 = this.this$0;
        Function0 r4 = new e(r3, r2);
        this.L$0 = null;
        this.label = 4;
        if (CreationDoSameAbility.h(r3, "directBackToChatFromAvatar setResult", r4, this) != r7) goto L185;
        return r7;
    L10:
        ResultKt.throwOnFailure(r85);
        Object r5 = r85;
    L176:
        r2 = (CreationSendMessageConfig) r5;
        CreationDoSameAbility r6 = this.this$0;
        this.L$0 = r2;
        this.label = 3;
        if (CreationDoSameAbility.e(r6, r2, this) != r7) goto L179;
        return r7;
    L11:
        String r8 = (String) this.L$5;
        com.larus.bmhome.actionbar.model.r r9 = (com.larus.bmhome.actionbar.model.r) this.L$4;
        String r10 = (String) this.L$3;
        String r11 = (String) this.L$2;
        com.larus.bmhome.actionbar.model.z0 r12 = (com.larus.bmhome.actionbar.model.z0) this.L$1;
        Map r13 = (Map) this.L$0;
        ResultKt.throwOnFailure(r85);
        Object r14 = r85;
        String r39 = r8;
    L95:
        com.larus.uaigc.api.s r15 = (com.larus.uaigc.api.s) ((com.larus.network.http.a) r14).b;
        if (r15 == null) goto L100;
        List<com.larus.uaigc.api.q> r16 = r15.a();
        if (r16 == null) goto L100;
        com.larus.uaigc.api.q r17 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r16);
    L101:
        if (r17 == null) goto L103;
        String r18 = r17.c();
    L104:
        if (r18 != null) goto L106;
        String r29 = "";
    L107:
        if (r17 == null) goto L117;
        com.larus.uaigc.api.p r19 = r17.b();
        if (r19 == null) goto L117;
        com.larus.uaigc.api.n r20 = r19.a();
        if (r20 == null) goto L117;
        com.larus.uaigc.api.m r21 = r20.a();
        if (r21 == null) goto L117;
        Long r22 = r21.a();
        if (r22 == null) goto L117;
        int r23 = (int) r22.longValue();
    L118:
        if (r17 == null) goto L128;
        com.larus.uaigc.api.p r24 = r17.b();
        if (r24 == null) goto L128;
        com.larus.uaigc.api.n r25 = r24.a();
        if (r25 == null) goto L128;
        com.larus.uaigc.api.m r26 = r25.a();
        if (r26 == null) goto L128;
        Long r27 = r26.b();
        if (r27 == null) goto L128;
        int r28 = (int) r27.longValue();
    L129:
        String r48 = r10;
        AttachmentInfo r50 = new AttachmentInfo(true, r29, Boxing.boxInt(r23), Boxing.boxInt(r28), "", "", "edit", null, null, null, null, r39, null, null, null, null, null, 128896, null);
        Map r68 = r13;
    L130:
        if (r12 == null) goto L136;
        com.larus.bmhome.actionbar.model.r r30 = r12.q;
        if (r30 == null) goto L136;
        Integer r31 = r30.a;
        if (r31 == null) goto L136;
        int r56 = r31.intValue();
    L137:
        com.larus.bmhome.instruction.c2 r110 = com.larus.bmhome.instruction.c2.a;
        if (r12 == null) goto L140;
        String r32 = r12.b;
    L141:
        if (r32 != null) goto L143;
        String r111 = "";
    L144:
        if (r12 == null) goto L150;
        com.larus.bmhome.actionbar.model.r r33 = r12.q;
        if (r33 == null) goto L150;
        Integer r34 = r33.a;
        if (r34 == null) goto L150;
        String r35 = r34.toString();
    L151:
        if (r35 != null) goto L153;
        String r112 = "";
    L154:
        if (r12 == null) goto L158;
        com.larus.bmhome.actionbar.model.r r36 = r12.q;
        if (r36 == null) goto L158;
        Integer r37 = r36.a;
    L159:
        com.larus.bmhome.actionbar.model.r r38 = com.larus.bmhome.instruction.j.a.b(r37, r11, null, r9);
        if (r38 == null) goto L162;
        String r113 = HttpExtKt.p(r38);
    L164:
        if (r12 == null) goto L166;
        Long r114 = r12.a;
    L167:
        Map r53 = r110.b(r111, r112, r113, false, r68, r114);
        sq9.p r40 = this.$doSameInitParams;
        String r41 = r40.c;
        if (r41 != null) goto L170;
        String r67 = "";
    L171:
        final ICoreInputAbility.OnSendParams r42 = new ICoreInputAbility.OnSendParams(r48, "", r50, null, null, r53, null, null, r56, false, null, false, false, false, null, null, null, null, false, r67, r68, null, null, null, r40.b, null, null, null, null, null, null, null, null, -18350400, 1, null);
        CreationDoSameAbility r43 = this.this$0;
        int r44 = CreationDoSameAbility.f;
        r43.getClass();
        if (CreationDoSameAbility.r() == false) goto L182;
        CreationDoSameAbility r45 = this.this$0;
        sq9.p r46 = this.$doSameInitParams;
        UserCreation r47 = this.$userCreation;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.label = 2;
        r5 = CreationDoSameAbility.c(r45, r42, r46, r47, "avatar", this);
        if (r5 != r7) goto L176;
        return r7;
    L182:
        final CreationDoSameAbility r49 = this.this$0;
        final sq9.p r51 = this.$doSameInitParams;
        final UserCreation r52 = this.$userCreation;
        Function0 r54 = new f(r49, r42, r51, r52);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.label = 5;
        if (CreationDoSameAbility.h(r49, "directBackToChatFromAvatar setLegacyResult", r54, this) != r7) goto L185;
        return r7;
    L170:
        r67 = r41;
        goto L171
    L166:
        r114 = null;
        goto L167
    L162:
        r113 = null;
    L158:
        r37 = null;
        goto L159
    L153:
        r112 = r35;
    L150:
        r35 = null;
        goto L151
    L143:
        r111 = r32;
        goto L144
    L140:
        r32 = null;
    L136:
        r56 = 0;
    L128:
        r28 = 0;
    L117:
        r23 = 0;
        goto L118
    L106:
        r29 = r18;
        goto L107
    L103:
        r18 = null;
    L100:
        r17 = null;
        goto L101
    L12:
        ResultKt.throwOnFailure(r85);
        JSONObject r55 = new JSONObject();
        sq9.p r57 = this.$doSameInitParams;
        UserCreation r58 = this.$userCreation;
        UserCreation r115 = r57.d;
        if (r115 == null) goto L15;
        String r116 = r115.a;
    L16:
        r55.put("id", r116);
        r55.put("recommend_from", r57.g);
        UserCreationTrackParams r117 = r58.n;
        if (r117 == null) goto L19;
        String r118 = r117.a;
    L20:
        r55.put("template_rec_req_id", r118);
        r55.put("template_rec_extra", r58.i);
        r55.put("from_template_id", r58.a);
        boolean r119 = IUgcAIGCService.a.v();
        r55.put("tpl_tag_type", r58.q(r119));
        if (r58.b == 3) goto L35;
        CreationDynamicInfo r120 = r58.h;
        if (r120 == null) goto L27;
        TplInfo r121 = r120.e;
        if (r121 == null) goto L27;
        String r122 = r121.a;
    L29:
        if (Intrinsics.areEqual(r122, TplType.AI_REPLICA) == true) goto L35;
        String r59 = r57.l;
        if (r59 == null) goto L34;
        String r60 = sq9.q.a(r59, r58, r119, false);
    L36:
        r55.put("tpl_button_type", r60);
        Map r61 = MapsKt.mapOf(TuplesKt.to("creation_template", r55.toString()));
        r12 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(11);
        String r62 = CreationDoSameAbility.f(this.this$0, this.$userCreation, this.$doSameInitParams);
        if (r62 != null) goto L39;
        String r123 = "";
    L41:
        if (this.$userCreation.b != 3) goto L43;
        r10 = CreationDoSameAbility.b(this.this$0, r12, r123);
    L44:
        if (r12 == null) goto L70;
        com.larus.bmhome.actionbar.model.r r124 = r12.q;
        if (r124 == null) goto L70;
        com.larus.bmhome.actionbar.model.j1 r63 = r124.e;
        if (r63 == null) goto L68;
        String r64 = this.$doSameInitParams.o;
        if (r64 != null) goto L52;
        r64 = this.$userCreation.h();
    L52:
        String r210 = r64;
        sq9.p r65 = this.$doSameInitParams;
        String r66 = r65.p;
        String r69 = r65.q;
        if (r69 != null) goto L58;
        Image r70 = this.$userCreation.g();
        String r86 = r123;
        if (r70 == null) goto L57;
        r69 = Boxing.boxLong(r70.c).toString();
    L59:
        String r211 = r69;
    L60:
        String r71 = this.$doSameInitParams.r;
        if (r71 != null) goto L66;
        Image r72 = this.$userCreation.g();
        if (r72 == null) goto L65;
        r71 = Boxing.boxLong(r72.d).toString();
        goto L66
    L65:
        String r212 = null;
    L67:
        com.larus.bmhome.actionbar.model.j1 r125 = com.larus.bmhome.actionbar.model.j1.a(r63, null, null, null, r210, r66, r211, r212, null, null, 16285695);
    L69:
        r9 = com.larus.bmhome.actionbar.model.r.a(r124, null, null, r125, null, 4079);
    L71:
        CreationDynamicInfo r73 = this.$userCreation.h;
        if (r73 == null) goto L76;
        TplInfo r74 = r73.e;
        if (r74 == null) goto L76;
        String r75 = r74.a;
    L78:
        if (Intrinsics.areEqual(r75, TplType.AI_REPLICA) == true) goto L91;
        TplDetail r76 = is9.a.c(this.$userCreation);
        if (r76 == null) goto L87;
        Integer r77 = r76.a;
        if (r77 == null) goto L87;
        if (r77.intValue() != 2) goto L87;
        boolean r78 = true;
    L88:
        if (r78 == true) goto L91;
        r11 = r86;
        r68 = r61;
        r48 = r10;
        r50 = null;
    L87:
        r78 = false;
    L91:
        String r79 = this.$userCreation.e();
        List r80 = CollectionsKt.listOf(r79);
        this.L$0 = r61;
        this.L$1 = r12;
        r11 = r86;
        this.L$2 = r11;
        this.L$3 = r10;
        this.L$4 = r9;
        this.L$5 = r79;
        this.label = 1;
        r14 = com.larus.uaigc.api.o.a(r80, true, this);
        if (r14 != r7) goto L94;
        return r7;
    L94:
        r13 = r61;
        r39 = r79;
    L76:
        r75 = null;
    L66:
        r212 = r71;
        goto L67
    L57:
        r211 = null;
        goto L60
    L58:
        r86 = r123;
        goto L59
    L68:
        r86 = r123;
        r125 = null;
    L70:
        r86 = r123;
        r9 = null;
        goto L71
    L43:
        r10 = r123;
        goto L44
    L39:
        r123 = r62;
        goto L41
    L34:
        r60 = null;
    L27:
        r122 = null;
    L35:
        r60 = TplButtonType.GEN_CREATE_AVATAR;
        goto L36
    L19:
        r118 = null;
        goto L20
    L15:
        r116 = null;
        goto L16
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
