package com.larus.drive.sdk.impl.utils;

import com.larus.bmhome.rc.ResourceApi;
import com.larus.bmhome.rc.ResourceRegisterData;
import com.larus.drive.sdk.api.file.DriveFileItem;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.RegisterDriveResourceHelper$registerDriveResource$1", f = "RegisterDriveResourceHelper.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
public final class RegisterDriveResourceHelper$registerDriveResource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DriveFileItem $item;
    final /* synthetic */ Function0<Unit> $onFailure;
    final /* synthetic */ Function1<String, Unit> $onSuccess;
    final /* synthetic */ Ref.IntRef $resourceType;
    final /* synthetic */ String $sceneId;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.utils.RegisterDriveResourceHelper$registerDriveResource$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.utils.RegisterDriveResourceHelper$registerDriveResource$1$1", f = "RegisterDriveResourceHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onFailure;
        final /* synthetic */ Function1<String, Unit> $onSuccess;
        final /* synthetic */ dm9.a<Map<String, ResourceRegisterData>> $resp;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(dm9.a<? extends Map<String, ResourceRegisterData>> r1, Function0<Unit> r2, Function1<? super String, Unit> r3, Continuation<? super AnonymousClass1> r4) {
            this.$resp = r1;
            this.$onFailure = r2;
            this.$onSuccess = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$resp, this.$onFailure, this.$onSuccess, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L28;
            ResultKt.throwOnFailure(r2);
            dm9.a.b r3 = this.$resp;
            if ((r3 instanceof dm9.a.a) == false) goto L10;
            Function0<Unit> r4 = this.$onFailure;
            if (r4 == null) goto L24;
            r4.invoke();
        L24:
            return Unit.INSTANCE;
        L10:
            if ((r3 instanceof dm9.a.b) == false) goto L26;
            Map r5 = (Map) r3.a.getData();
            if (r5 != null) goto L16;
            Function0<Unit> r6 = this.$onFailure;
            if (r6 == null) goto L24;
            r6.invoke();
            goto L24
        L16:
            Function1<String, Unit> r0 = this.$onSuccess;
            if (r0 == null) goto L24;
            ResourceRegisterData r7 = (ResourceRegisterData) CollectionsKt.firstOrNull(r5.values());
            if (r7 == null) goto L21;
            String r8 = r7.getResourceId();
        L22:
            r0.invoke(r8);
            goto L24
        L21:
            r8 = null;
            goto L22
        L26:
            throw new NoWhenBranchMatchedException();
        L28:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RegisterDriveResourceHelper$registerDriveResource$1(CoroutineScope r1, String r2, DriveFileItem r3, Ref.IntRef r4, Function0<Unit> r5, Function1<? super String, Unit> r6, Continuation<? super RegisterDriveResourceHelper$registerDriveResource$1> r7) {
        this.$scope = r1;
        this.$sceneId = r2;
        this.$item = r3;
        this.$resourceType = r4;
        this.$onFailure = r5;
        this.$onSuccess = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new RegisterDriveResourceHelper$registerDriveResource$1(this.$scope, this.$sceneId, this.$item, this.$resourceType, this.$onFailure, this.$onSuccess, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        BuildersKt.launch$default(this.$scope, Dispatchers.getMain(), null, new AnonymousClass1((dm9.a) r10, this.$onFailure, this.$onSuccess, null), 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ResourceApi.a r11 = ResourceApi.a;
        RegisterDriveResourceHelper$registerDriveResource$1$resp$1 r2 = new RegisterDriveResourceHelper$registerDriveResource$1$resp$1(this.$sceneId, this.$item, this.$resourceType, null);
        this.label = 1;
        r11.getClass();
        r10 = ResourceApi.a.a("/alice/resource/register", r2, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
