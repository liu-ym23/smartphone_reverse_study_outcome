package com.larus.profile.impl;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.BatchUpdateUserCreationRequest;
import com.larus.platform.api.ModifiedUserCreationResponse;
import com.tencent.open.log.TraceLevel;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "", "Lcom/larus/platform/api/ModifiedUserCreationResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileRepo$batchUpdateUserCreation$2", f = "ProfileRepo.kt", i = {}, l = {363}, m = "invokeSuspend", n = {}, s = {})
final class ProfileRepo$batchUpdateUserCreation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends List<? extends ModifiedUserCreationResponse>>>, Object> {
    final /* synthetic */ List<String> $creationIdList;
    final /* synthetic */ Integer $privateStatus;
    final /* synthetic */ Integer $status;
    int label;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/network/http/HttpExtKt$httpPost2$2", "Lcom/google/gson/reflect/TypeToken;", "network_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class a extends TypeToken<List<? extends ModifiedUserCreationResponse>> {
        public a() {
        }
    }

    public ProfileRepo$batchUpdateUserCreation$2(List<String> r1, Integer r2, Integer r3, Continuation<? super ProfileRepo$batchUpdateUserCreation$2> r4) {
        this.$creationIdList = r1;
        this.$status = r2;
        this.$privateStatus = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ProfileRepo$batchUpdateUserCreation$2(this.$creationIdList, this.$status, this.$privateStatus, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<? extends List<ModifiedUserCreationResponse>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        BatchUpdateUserCreationRequest r14 = new BatchUpdateUserCreationRequest(this.$creationIdList, this.$status, this.$privateStatus);
        JSONObject r8 = new JSONObject(GsonProtectorUtils.toJson(new Gson(), r14));
        Map r9 = MapsKt.emptyMap();
        Type r6 = new a().getType();
        this.label = 1;
        r13 = HttpExtKt.m("Social", r6, "/alice/profile/creation/batch_update", r8, r9, false, this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
