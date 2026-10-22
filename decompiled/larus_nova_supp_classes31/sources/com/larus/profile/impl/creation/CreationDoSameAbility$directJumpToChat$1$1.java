package com.larus.profile.impl.creation;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.api.creation.UserCreation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$directJumpToChat$1$1", f = "CreationDoSameAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDoSameAbility$directJumpToChat$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ sq9.p $doSameInitParams;
    final /* synthetic */ String $fileLocalPath;
    final /* synthetic */ String $mainBotId;
    final /* synthetic */ Map<String, String> $msgExtMap;
    final /* synthetic */ Bundle $routeBaseParams;
    final /* synthetic */ String $routePath;
    final /* synthetic */ UserCreation $userCreation;
    int label;
    final /* synthetic */ CreationDoSameAbility this$0;

    public CreationDoSameAbility$directJumpToChat$1$1(UserCreation r1, CreationDoSameAbility r2, sq9.p r3, Map<String, String> r4, String r5, String r6, Context r7, String r8, Bundle r9, Continuation<? super CreationDoSameAbility$directJumpToChat$1$1> r10) {
        this.$userCreation = r1;
        this.this$0 = r2;
        this.$doSameInitParams = r3;
        this.$msgExtMap = r4;
        this.$mainBotId = r5;
        this.$fileLocalPath = r6;
        this.$context = r7;
        this.$routePath = r8;
        this.$routeBaseParams = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new CreationDoSameAbility$directJumpToChat$1$1(this.$userCreation, this.this$0, this.$doSameInitParams, this.$msgExtMap, this.$mainBotId, this.$fileLocalPath, this.$context, this.$routePath, this.$routeBaseParams, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r19);
        final CreationDoSameAbility r3 = this.this$0;
        final Context r4 = this.$context;
        final String r5 = this.$routePath;
        final sq9.p r6 = this.$doSameInitParams;
        final Bundle r7 = this.$routeBaseParams;
        Function1 r1 = new k(r3, r4, r5, r6, r7);
        UserCreation r2 = this.$userCreation;
        if (r2.b == 3) goto L25;
        TplDetail r8 = is9.a.c(r2);
        boolean r9 = false;
        if (r8 == null) goto L14;
        Integer r10 = r8.a;
        if (r10 == null) goto L14;
        if (r10.intValue() != 2) goto L14;
        r9 = true;
    L14:
        if (r9 == true) goto L25;
        CreationDynamicInfo r11 = this.$userCreation.h;
        if (r11 == null) goto L20;
        TplInfo r12 = r11.e;
        if (r12 == null) goto L20;
        String r13 = r12.a;
    L22:
        if (Intrinsics.areEqual(r13, TplType.AI_REPLICA) == true) goto L25;
        CreationDoSameAbility r14 = this.this$0;
        String r15 = this.$mainBotId;
        com.larus.bmhome.actionbar.model.z0 r16 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(4);
        int r17 = CreationDoSameAbility.f;
        com.larus.bmhome.actionbar.model.z0 r18 = (com.larus.bmhome.actionbar.model.z0) r14.q(r15, r16).getFirst();
        CreationDoSameAbility r20 = this.this$0;
        sq9.p r21 = this.$doSameInitParams;
        UserCreation r110 = this.$userCreation;
        String r111 = this.$fileLocalPath;
        Map<String, String> r112 = this.$msgExtMap;
        r20.getClass();
        r20.z("directSendImage2ImageMsgWithRoute", Dispatchers.getDefault(), new CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1(r21, r20, r110, r18, r112, "avatar", r111, r1, null));
    L27:
        return Unit.INSTANCE;
    L20:
        r13 = null;
    L25:
        CreationDoSameAbility r22 = this.this$0;
        sq9.p r113 = this.$doSameInitParams;
        UserCreation r114 = this.$userCreation;
        Map<String, String> r115 = this.$msgExtMap;
        int r23 = CreationDoSameAbility.f;
        r22.getClass();
        r22.z("directSendAvatarMsgWithRoute", Dispatchers.getDefault(), new CreationDoSameAbility$directSendAvatarMsgWithRoute$1(r22, r114, r113, r115, r1, null));
        goto L27
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
