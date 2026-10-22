package com.larus.drive.sdk.impl.utils;

import com.larus.bmhome.rc.CreateVideoFrameTaskRequest;
import com.larus.bmhome.rc.ResourceApi;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.network.bean.BizResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0018\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "", "Lcom/larus/bmhome/rc/ResourceApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.RegisterDriveResourceHelper$createVideoFrameTask$1$resp$1", f = "RegisterDriveResourceHelper.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
public final class RegisterDriveResourceHelper$createVideoFrameTask$1$resp$1 extends SuspendLambda implements Function2<ResourceApi, Continuation<? super BizResponse<Map<String, ? extends String>>>, Object> {
    final /* synthetic */ DriveFileItem $item;
    private /* synthetic */ Object L$0;
    int label;

    public RegisterDriveResourceHelper$createVideoFrameTask$1$resp$1(DriveFileItem r1, Continuation<? super RegisterDriveResourceHelper$createVideoFrameTask$1$resp$1> r2) {
        this.$item = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RegisterDriveResourceHelper$createVideoFrameTask$1$resp$1 r0 = new RegisterDriveResourceHelper$createVideoFrameTask$1$resp$1(this.$item, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ResourceApi r1, Continuation<? super BizResponse<Map<String, String>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ResourceApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ResourceApi r7 = (ResourceApi) this.L$0;
        CreateVideoFrameTaskRequest r2 = new CreateVideoFrameTaskRequest(this.$item.b, 17);
        this.label = 1;
        r6 = r7.createVideoFrameWork(r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
