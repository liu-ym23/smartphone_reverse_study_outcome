package com.larus.drive.sdk.impl.utils;

import com.larus.bmhome.rc.ResourceApi;
import com.larus.drive.sdk.api.file.DriveFileItem;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.RegisterDriveResourceHelper$createVideoFrameTask$1", f = "RegisterDriveResourceHelper.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
final class RegisterDriveResourceHelper$createVideoFrameTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DriveFileItem $item;
    final /* synthetic */ Function0<Unit> $onFailure;
    final /* synthetic */ Function1<String, Unit> $onSuccess;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.utils.RegisterDriveResourceHelper$createVideoFrameTask$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.utils.RegisterDriveResourceHelper$createVideoFrameTask$1$1", f = "RegisterDriveResourceHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onFailure;
        final /* synthetic */ Function1<String, Unit> $onSuccess;
        final /* synthetic */ dm9.a<Map<String, String>> $resp;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(dm9.a<? extends Map<String, String>> r1, Function0<Unit> r2, Function1<? super String, Unit> r3, Continuation<? super AnonymousClass1> r4) {
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
            if (this.label != 0) goto L19;
            ResultKt.throwOnFailure(r2);
            dm9.a<Map<String, String>> r3 = this.$resp;
            if ((r3 instanceof dm9.a.a) == false) goto L10;
            Function0<Unit> r4 = this.$onFailure;
            if (r4 == null) goto L15;
            r4.invoke();
        L15:
            return Unit.INSTANCE;
        L10:
            if ((r3 instanceof dm9.a.b) == false) goto L17;
            Function1<String, Unit> r5 = this.$onSuccess;
            if (r5 == null) goto L15;
            r5.invoke(null);
            goto L15
        L17:
            throw new NoWhenBranchMatchedException();
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RegisterDriveResourceHelper$createVideoFrameTask$1(CoroutineScope r1, DriveFileItem r2, Function0<Unit> r3, Function1<? super String, Unit> r4, Continuation<? super RegisterDriveResourceHelper$createVideoFrameTask$1> r5) {
        this.$scope = r1;
        this.$item = r2;
        this.$onFailure = r3;
        this.$onSuccess = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new RegisterDriveResourceHelper$createVideoFrameTask$1(this.$scope, this.$item, this.$onFailure, this.$onSuccess, r8);
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
        RegisterDriveResourceHelper$createVideoFrameTask$1$resp$1 r2 = new RegisterDriveResourceHelper$createVideoFrameTask$1$resp$1(this.$item, null);
        this.label = 1;
        r11.getClass();
        r10 = ResourceApi.a.a("/alice/resource/create_video_frame_task", r2, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
