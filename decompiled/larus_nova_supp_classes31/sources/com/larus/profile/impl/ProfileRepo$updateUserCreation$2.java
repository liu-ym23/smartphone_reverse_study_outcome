package com.larus.profile.impl;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.ModifiedUserCreationResponse;
import com.larus.profile.api.IProfileApi;
import com.larus.profile.api.bean.UpdateUserCreationContent;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/api/ModifiedUserCreationResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileRepo$updateUserCreation$2", f = "ProfileRepo.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
final class ProfileRepo$updateUserCreation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends ModifiedUserCreationResponse>>, Object> {
    final /* synthetic */ UpdateUserCreationContent $content;
    final /* synthetic */ String $creationId;
    final /* synthetic */ boolean $isDeletePublic;
    final /* synthetic */ Integer $privateStatus;
    final /* synthetic */ Integer $status;
    int label;

    public ProfileRepo$updateUserCreation$2(Integer r1, boolean r2, Integer r3, String r4, UpdateUserCreationContent r5, Continuation<? super ProfileRepo$updateUserCreation$2> r6) {
        this.$status = r1;
        this.$isDeletePublic = r2;
        this.$privateStatus = r3;
        this.$creationId = r4;
        this.$content = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ProfileRepo$updateUserCreation$2(this.$status, this.$isDeletePublic, this.$privateStatus, this.$creationId, this.$content, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<ModifiedUserCreationResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r14 = true;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L18:
        com.larus.network.http.a r2 = (com.larus.network.http.a) r1;
        if ((r2 instanceof com.larus.network.http.y) == false) goto L38;
        Integer r3 = this.$status;
        if (r3 == null) goto L29;
        if (r3.intValue() != 3) goto L29;
        if (this.$isDeletePublic == false) goto L29;
        IProfileApi.a.h().postValue(Boxing.boxBoolean(false));
    L29:
        if (this.$privateStatus == null) goto L38;
        MutableLiveData<Boolean> r4 = IProfileApi.a.h();
        Integer r5 = this.$privateStatus;
        if (r5 != null) goto L34;
    L36:
        r14 = false;
    L37:
        r4.postValue(Boxing.boxBoolean(r14));
        goto L38
    L34:
        if (r5.intValue() != 1) goto L36;
    L38:
        return r2;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r16);
        JSONObject r6 = new JSONObject();
        String r7 = this.$creationId;
        UpdateUserCreationContent r8 = this.$content;
        Integer r9 = this.$status;
        Integer r10 = this.$privateStatus;
        r6.put("creation_id", r7);
        if (r8 == null) goto L11;
        r6.put("content", new JSONObject(GsonProtectorUtils.toJson(new Gson(), r8)));
    L11:
        if (r9 == null) goto L13;
        r6.put("status", r9.intValue());
    L13:
        if (r10 == null) goto L15;
        r6.put("private_status", r10.intValue());
    L15:
        Unit r11 = Unit.INSTANCE;
        this.label = 1;
        r1 = HttpExtKt.k("Social", ModifiedUserCreationResponse.class, "/alice/profile/creation/update", r6, null, null, true, null, null, null, this, 944);
        if (r1 != r13) goto L18;
        return r13;
    }
}
