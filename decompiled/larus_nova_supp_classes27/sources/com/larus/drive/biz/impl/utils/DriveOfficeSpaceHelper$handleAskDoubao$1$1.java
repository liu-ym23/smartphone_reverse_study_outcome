package com.larus.drive.biz.impl.utils;

import android.content.Context;
import com.larus.drive.sdk.api.file.DriveFileItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.utils.DriveOfficeSpaceHelper$handleAskDoubao$1$1", f = "DriveOfficeSpaceHelper.kt", i = {0}, l = {201}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class DriveOfficeSpaceHelper$handleAskDoubao$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DriveFileItem $driveFile;
    final /* synthetic */ Context $hostContext;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.utils.DriveOfficeSpaceHelper$handleAskDoubao$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.utils.DriveOfficeSpaceHelper$handleAskDoubao$1$1$1", f = "DriveOfficeSpaceHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $hostContext;
        int label;

        public AnonymousClass1(Context r1, Continuation<? super AnonymousClass1> r2) {
            this.$hostContext = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$hostContext, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            s r3 = s.a;
            Context r0 = this.$hostContext;
            r3.getClass();
            s.s(r0, 2131905570);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DriveOfficeSpaceHelper$handleAskDoubao$1$1(Context r1, DriveFileItem r2, Continuation<? super DriveOfficeSpaceHelper$handleAskDoubao$1$1> r3) {
        this.$hostContext = r1;
        this.$driveFile = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DriveOfficeSpaceHelper$handleAskDoubao$1$1 r0 = new DriveOfficeSpaceHelper$handleAskDoubao$1$1(this.$hostContext, this.$driveFile, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);
    L13:
        if (((Boolean) r7).booleanValue() == true) goto L16;
        BuildersKt.launch$default(r2, Dispatchers.getMain(), null, new AnonymousClass1(this.$hostContext, null), 2, null);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        DriveAskDoubaoChatLauncher r3 = DriveAskDoubaoChatLauncher.a;
        Context r4 = this.$hostContext;
        DriveFileItem r5 = this.$driveFile;
        int r6 = com.larus.office.experiment.d.a;
        boolean r9 = com.larus.office.experiment.d.a(r5.d);
        this.L$0 = r8;
        this.label = 1;
        Object r10 = r3.b(r4, r5, r9, this);
        if (r10 != r0) goto L11;
        return r0;
    L11:
        r2 = r8;
        r7 = r10;
        goto L13
    }
}
