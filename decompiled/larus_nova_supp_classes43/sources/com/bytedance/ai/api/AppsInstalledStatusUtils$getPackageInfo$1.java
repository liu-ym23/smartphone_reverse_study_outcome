package com.bytedance.ai.api;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.api.AppsInstalledStatusUtils$getPackageInfo$1", f = "AppsInstalledStatusUtils.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
public final class AppsInstalledStatusUtils$getPackageInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ String $packageName;
    int label;

    /* JADX INFO: renamed from: com.bytedance.ai.api.AppsInstalledStatusUtils$getPackageInfo$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.api.AppsInstalledStatusUtils$getPackageInfo$1$1", f = "AppsInstalledStatusUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ PackageInfo $info;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Boolean, Unit> r1, PackageInfo r10, Continuation<? super AnonymousClass1> r11) {
            this.$callback = r1;
            this.$info = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$callback, this.$info, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r10);
            Function1<Boolean, Unit> r11 = this.$callback;
            PackageInfo r0 = this.$info;
            boolean r1 = false;
            if (r0 == null) goto L15;
            ApplicationInfo r12 = r0.applicationInfo;
            if (r12 == null) goto L9;
            Boolean r13 = Boxing.boxBoolean(r12.enabled);
        L10:
            if (r13 == null) goto L12;
            boolean r14 = r13.booleanValue();
        L13:
            if (r14 == false) goto L15;
            r1 = true;
            goto L15
        L12:
            r14 = false;
            goto L13
        L9:
            r13 = null;
        L15:
            r11.invoke(Boxing.boxBoolean(r1));
            return Unit.INSTANCE;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppsInstalledStatusUtils$getPackageInfo$1(String r1, Function1<? super Boolean, Unit> r10, Continuation<? super AppsInstalledStatusUtils$getPackageInfo$1> r11) {
        this.$packageName = r1;
        this.$callback = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppsInstalledStatusUtils$getPackageInfo$1(this.$packageName, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r10);     // Catch: PackageManager.NameNotFoundException -> L7
    L18:
    L17:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r10);
        PackageManager r11 = AppHost.a.getApplication().getPackageManager();
        PackageInfo r12 = r11.getPackageInfo(this.$packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L7
        MainCoroutineDispatcher r13 = Dispatchers.getMain();     // Catch: PackageManager.NameNotFoundException -> L7
        AnonymousClass1 r14 = new AnonymousClass1(this.$callback, r12, null);     // Catch: PackageManager.NameNotFoundException -> L7
        this.label = 1;     // Catch: PackageManager.NameNotFoundException -> L7
        if (BuildersKt.withContext(r13, r14, this) != r0) goto L18;
        return r0;
    L7:
        e = move-exception;
        e.printStackTrace();
        this.$callback.invoke(Boxing.boxBoolean(false));
        goto L17
    }
}
