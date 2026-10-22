package com.larus.drive.sdk.impl.utils;

import com.larus.bmhome.rc.FlowResource;
import com.larus.bmhome.rc.ResourceApi;
import com.larus.bmhome.rc.ResourceRegisterData;
import com.larus.bmhome.rc.ResourceRegisterRequest;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.network.bean.BizResponse;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0018\u00010\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "", "Lcom/larus/bmhome/rc/ResourceRegisterData;", "Lcom/larus/bmhome/rc/ResourceApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.RegisterDriveResourceHelper$registerDriveResource$1$resp$1", f = "RegisterDriveResourceHelper.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
public final class RegisterDriveResourceHelper$registerDriveResource$1$resp$1 extends SuspendLambda implements Function2<ResourceApi, Continuation<? super BizResponse<Map<String, ? extends ResourceRegisterData>>>, Object> {
    final /* synthetic */ DriveFileItem $item;
    final /* synthetic */ Ref.IntRef $resourceType;
    final /* synthetic */ String $sceneId;
    private /* synthetic */ Object L$0;
    int label;

    public RegisterDriveResourceHelper$registerDriveResource$1$resp$1(String r1, DriveFileItem r2, Ref.IntRef r3, Continuation<? super RegisterDriveResourceHelper$registerDriveResource$1$resp$1> r4) {
        this.$sceneId = r1;
        this.$item = r2;
        this.$resourceType = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        RegisterDriveResourceHelper$registerDriveResource$1$resp$1 r0 = new RegisterDriveResourceHelper$registerDriveResource$1$resp$1(this.$sceneId, this.$item, this.$resourceType, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(ResourceApi r1, Continuation<? super BizResponse<Map<String, ResourceRegisterData>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ResourceApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        return r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        ResourceApi r15 = (ResourceApi) this.L$0;
        ResourceRegisterRequest r2 = new ResourceRegisterRequest("4", this.$sceneId, CollectionsKt.listOf(new FlowResource(this.$item.b, Boxing.boxInt(this.$resourceType.element), null, null, 12, null)), null, 8, null);
        this.label = 1;
        r14 = r15.register(r2, this);
        if (r14 != r0) goto L11;
        return r0;
    }
}
