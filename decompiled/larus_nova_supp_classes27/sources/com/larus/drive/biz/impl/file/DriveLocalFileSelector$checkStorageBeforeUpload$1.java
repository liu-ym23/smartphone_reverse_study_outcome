package com.larus.drive.biz.impl.file;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.platform.api.IFlowDriveSdkService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.c2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.file.DriveLocalFileSelector$checkStorageBeforeUpload$1", f = "DriveLocalFileSelector.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class DriveLocalFileSelector$checkStorageBeforeUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ Function0<Unit> $func;
    int label;

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.file.DriveLocalFileSelector$checkStorageBeforeUpload$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.file.DriveLocalFileSelector$checkStorageBeforeUpload$1$1", f = "DriveLocalFileSelector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $func;
        int label;

        public AnonymousClass1(Function0<Unit> r1, Continuation<? super AnonymousClass1> r2) {
            this.$func = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$func, r3);
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
            this.$func.invoke();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DriveLocalFileSelector$checkStorageBeforeUpload$1(Fragment r1, Function0<Unit> r2, Continuation<? super DriveLocalFileSelector$checkStorageBeforeUpload$1> r3) {
        this.$fragment = r1;
        this.$func = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DriveLocalFileSelector$checkStorageBeforeUpload$1(this.$fragment, this.$func, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L26:
        com.larus.platform.api.p r13 = (com.larus.platform.api.p) r12;
    L28:
        if (r13 != null) goto L30;
    L44:
    L40:
        e = move-exception;
        FLogger.a.e("DriveLocalFileSelector", "checkStorageBeforeUpload toast failed2[" + e + ']', e);
    L43:
        return Unit.INSTANCE;
    L35:
        if (this.$fragment.isAdded() == false) goto L43;
        if (this.$fragment.isStateSaved() == true) goto L43;
        t19.s r14 = t19.s.a;     // Catch: Exception -> L40
        FragmentActivity r2 = this.$fragment.getActivity();     // Catch: Exception -> L40
        String r3 = this.$fragment.getString(2131905400);     // Catch: Exception -> L40
        r14.getClass();     // Catch: Exception -> L40
        t19.s.t(r2, r3);     // Catch: Exception -> L40
        goto L43
    L30:
        if (r13.c >= r13.b) goto L44;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.$fragment), Dispatchers.getMain(), null, new AnonymousClass1(this.$func, null), 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        Lazy r15 = t.a;
        if (t.i() == false) goto L21;
        String r16 = StringsKt.replace$default(this.$fragment.getString(2131907892), "%s", String.valueOf(((c2) t.b.getValue()).j()), false, 4, null);
    L17:
        e = move-exception;
        FLogger.a.e("DriveLocalFileSelector", "checkStorageBeforeUpload toast failed1[" + e + ']', e);
    L20:
        return Unit.INSTANCE;
    L12:
        if (this.$fragment.isAdded() == false) goto L20;
        if (this.$fragment.isStateSaved() == true) goto L20;
        t19.s r4 = t19.s.a;     // Catch: Exception -> L17
        FragmentActivity r5 = this.$fragment.getActivity();     // Catch: Exception -> L17
        r4.getClass();     // Catch: Exception -> L17
        t19.s.t(r5, r16);     // Catch: Exception -> L17
        goto L20
    L21:
        IFlowDriveSdkService r17 = (IFlowDriveSdkService) ServiceManager.get().getService(IFlowDriveSdkService.class);
        if (r17 == null) goto L27;
        this.label = 1;
        r12 = r17.d(this);
        if (r12 != r0) goto L26;
        return r0;
    L27:
        r13 = null;
        goto L28
    }
}
