package com.larus.profile.impl.creation;

import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UpdateCountScene;
import com.larus.profile.impl.ProfileRepo;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationTemplateComponent$jumpChatPageByMakeSame$2", f = "CreationTemplateComponent.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
final class CreationTemplateComponent$jumpChatPageByMakeSame$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserCreation $userCreation;
    int label;

    public CreationTemplateComponent$jumpChatPageByMakeSame$2(UserCreation r1, Continuation<? super CreationTemplateComponent$jumpChatPageByMakeSame$2> r2) {
        this.$userCreation = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationTemplateComponent$jumpChatPageByMakeSame$2(this.$userCreation, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r16);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r16);
        Lazy<ProfileRepo> r1 = ProfileRepo.b;
        ProfileRepo r2 = ProfileRepo.a.a();
        String r3 = this.$userCreation.a;
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        this.label = 1;
        r2.getClass();
        JSONObject r5 = new JSONObject();
        r5.put("entity_id", r3);
        r5.put("name_space", UpdateCountScene.CREATION_USAGE_COUNT);
        r5.put("operator", 1);
        Unit r4 = Unit.INSTANCE;
        Object r6 = HttpExtKt.k("Social", String.class, "/alice/profile/creation/report_counter", r5, null, null, false, null, null, null, this, 1008);
        if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        r6 = Unit.INSTANCE;
    L15:
        if (r6 != r13) goto L18;
        return r13;
    }
}
