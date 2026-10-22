package com.ss.android.lark.profile_office.userprofile;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileRequest;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import com.bytedance.lark.pb.contact.v2.UpdateDoubaoInfoRequest;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.users.PatchUserMemoRequest;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeProfileModel implements c38.c<b> {

    @Inject
    public com.ss.android.lark.profile.core.di.a a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public final b38.b getScopedRucket() {
        com.ss.android.lark.profile.core.di.a r0 = this.a;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("netClientGetter");
        r0 = null;
    L7:
        return r0.Q4();
    }

    @Inject
    public OfficeProfileModel() {
        this.b = LazyKt.lazy(OfficeProfileModel$coreService$2.INSTANCE);
    }

    public final Object a(String r7, boolean r8, Continuation<? super q1c.b<GetDoubaoProfileResponse>> r9) {
        if ((r9 instanceof OfficeProfileModel$loadProfileByToken$1) == false) goto L7;
        OfficeProfileModel$loadProfileByToken$1 r0 = (OfficeProfileModel$loadProfileByToken$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = r0.Z$0;
        ResultKt.throwOnFailure(r10);
    L21:
        q1c.b r11 = q1c.c.a((com.larksuite.rucket.job.base.b) r10);
        if ((!(r11 instanceof q1c.b.a)) == false) goto L24;
        Log.i("OfficeProfileModel", "loadProfileByToken success, fromServer: " + r8 + ", edition: " + ((GetDoubaoProfileResponse) ((q1c.b.C0179b) r11).a).edition);
    L25:
        return r11;
    L24:
        Log.e("OfficeProfileModel", "loadProfileByToken error, fromServer: " + r8, ((q1c.b.a) r11).a);
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (r8 == false) goto L17;
        SyncDataStrategy r12 = SyncDataStrategy.FORCE_SERVER;
    L18:
        GetDoubaoProfileRequest.Builder r13 = new GetDoubaoProfileRequest.Builder().token(r7).sync_data_strategy(r12);
        Log.i("OfficeProfileModel", "start loadProfileByToken, token: " + r7 + ", fromServer: " + r8);
        RucketJob<GetDoubaoProfileResponse> r14 = ((b) getScopedRucket().create(b.class)).getOfficeProfile(r13.build());
        r0.Z$0 = r8;
        r0.label = 1;
        r10 = r14.awaitGet(r0);
        if (r10 != r2) goto L21;
        return r2;
    L17:
        r12 = SyncDataStrategy.LOCAL;
    L7:
        r0 = new OfficeProfileModel$loadProfileByToken$1(this, r9);
        goto L8
    }

    public final Object b(String r7, boolean r8, Continuation<? super q1c.b<GetDoubaoProfileResponse>> r9) {
        if ((r9 instanceof OfficeProfileModel$loadProfileByUserId$1) == false) goto L7;
        OfficeProfileModel$loadProfileByUserId$1 r0 = (OfficeProfileModel$loadProfileByUserId$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = r0.Z$0;
        ResultKt.throwOnFailure(r10);
    L21:
        q1c.b r11 = q1c.c.a((com.larksuite.rucket.job.base.b) r10);
        if ((!(r11 instanceof q1c.b.a)) == false) goto L24;
        Log.i("OfficeProfileModel", "loadProfileByUserId success, fromServer: " + r8 + ", edition: " + ((GetDoubaoProfileResponse) ((q1c.b.C0179b) r11).a).edition);
    L25:
        return r11;
    L24:
        Log.e("OfficeProfileModel", "loadProfileByUserId error, fromServer: " + r8, ((q1c.b.a) r11).a);
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (r8 == false) goto L17;
        SyncDataStrategy r12 = SyncDataStrategy.FORCE_SERVER;
    L18:
        GetDoubaoProfileRequest.Builder r13 = new GetDoubaoProfileRequest.Builder().user_id(r7).sync_data_strategy(r12);
        Log.i("OfficeProfileModel", "start loadProfileByUserId, userId: " + r7 + ", fromServer: " + r8);
        RucketJob<GetDoubaoProfileResponse> r14 = ((b) getScopedRucket().create(b.class)).getOfficeProfile(r13.build());
        r0.Z$0 = r8;
        r0.label = 1;
        r10 = r14.awaitGet(r0);
        if (r10 != r2) goto L21;
        return r2;
    L17:
        r12 = SyncDataStrategy.LOCAL;
    L7:
        r0 = new OfficeProfileModel$loadProfileByUserId$1(this, r9);
        goto L8
    }

    public final Object c(String r7, String r8, Continuation<? super q1c.b<Unit>> r9) {
        if ((r9 instanceof OfficeProfileModel$saveAlias$1) == false) goto L7;
        OfficeProfileModel$saveAlias$1 r0 = (OfficeProfileModel$saveAlias$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L17:
        q1c.b r11 = q1c.c.a((com.larksuite.rucket.job.base.b) r10);
        if ((!(r11 instanceof q1c.b.a)) == false) goto L20;
        Log.i("OfficeProfileModel", "saveAlias success");
    L21:
        return r11;
    L20:
        Log.e("OfficeProfileModel", "saveAlias error", ((q1c.b.a) r11).a);
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        PatchUserMemoRequest.Builder r12 = new PatchUserMemoRequest.Builder().target_user_id(r7).alias(r8);
        Log.i("OfficeProfileModel", "start saveAlias, userId: " + r7 + ", alias: " + r8);
        RucketJob r13 = RucketJob.map$default(((com.ss.android.lark.profile.core.service.a) this.b.getValue()).saveAlias(r12.m3002build()), null, OfficeProfileModel$saveAlias$result$1.INSTANCE, 1, null);
        r0.label = 1;
        r10 = r13.awaitGet(r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new OfficeProfileModel$saveAlias$1(this, r9);
        goto L8
    }

    public final Object d(String r7, String r8, Continuation<? super q1c.b<Unit>> r9) {
        if ((r9 instanceof OfficeProfileModel$updateDoubaoInfo$1) == false) goto L7;
        OfficeProfileModel$updateDoubaoInfo$1 r0 = (OfficeProfileModel$updateDoubaoInfo$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L17:
        q1c.b r11 = q1c.c.a((com.larksuite.rucket.job.base.b) r10);
        if ((!(r11 instanceof q1c.b.a)) == false) goto L20;
        Log.i("OfficeProfileModel", "updateDoubaoInfo success");
    L21:
        return r11;
    L20:
        Log.e("OfficeProfileModel", "updateDoubaoInfo error", ((q1c.b.a) r11).a);
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        UpdateDoubaoInfoRequest.Builder r12 = new UpdateDoubaoInfoRequest.Builder().user_id(r7).content(r8);
        Log.i("OfficeProfileModel", "start updateDoubaoInfo, userId: " + r7 + ", content: " + r8);
        RucketJob r13 = RucketJob.map$default(((b) getScopedRucket().create(b.class)).updateDoubaoInfo(r12.build()), null, OfficeProfileModel$updateDoubaoInfo$result$1.INSTANCE, 1, null);
        r0.label = 1;
        r10 = r13.awaitGet(r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new OfficeProfileModel$updateDoubaoInfo$1(this, r9);
        goto L8
    }
}
