package com.obric.capabilitykit;

import android.app.Application;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Process;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/execution/fileaccess/receiver/UriFileOpener;", "", "uriToOpen", "Landroid/net/Uri;", "forReceiver", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "receiverPackage", "", "(Landroid/net/Uri;Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;Ljava/lang/String;)V", "getForReceiver", "()Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "getReceiverPackage", "()Ljava/lang/String;", "getUriToOpen", "()Landroid/net/Uri;", "open", "", "receiverPid", "", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class u {
    public static final a d = null;
    private static final String e = "UriFileOpener";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f7630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IUriFileReceiver f7631b;
    private final String c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/capabilitykit/execution/fileaccess/receiver/UriFileOpener$Companion;", "", "()V", "TAG", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.receiver.UriFileOpener$open$1", f = "UriFileOpener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f7633b;

        public b(u r3, Continuation<? super b> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.f7633b = r3;
            super(2, r5);
        }

        public final Object a(al r3, Continuation<? super Unit> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), b.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return new b(this.f7633b, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7632a != 0) goto L15;
            ResultKt.throwOnFailure(r9);
            Logger.INSTANCE.e(u.e, "return failure to the receiver: " + this.f7633b.b() + " ---> URI " + this.f7633b.c());
            u r8 = this.f7633b;
            r8.a().onSessionReady(new UriFileAccessSession(4, "分享方未能开启 URI = " + r8.c(), null, 4, null));     // Catch: Throwable -> L7
            Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
            if (r11 == null) goto L13;
            Logger.INSTANCE.e(u.e, "cannot notify failure to the receiver; e=" + r11, r11);
        L13:
            return Unit.INSTANCE;
        L7:
            th = move-exception;
            r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L9
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.receiver.UriFileOpener$open$2", f = "UriFileOpener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssetFileDescriptor f7635b;
        public final /* synthetic */ u c;
        public final /* synthetic */ int d;

        public c(AssetFileDescriptor r3, u r4, int r5, Continuation<? super c> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.f7635b = r3;
            this.c = r4;
            this.d = r5;
            super(2, r7);
        }

        public final Object a(al r3, Continuation<? super Unit> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), c.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return new c(this.f7635b, this.c, this.d, r5);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7634a != 0) goto L27;
            ResultKt.throwOnFailure(r8);
            Logger.INSTANCE.i(u.e, "returning & closing opened fd/" + this.f7635b.hashCode() + " to the receiver: " + this.c.b() + " ---> URI " + this.c.c());
            this.c.a().onSessionReady(new UriFileAccessSession(0, "成功", this.f7635b));     // Catch: Throwable -> L7
            Object r9 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
            if (r10 == null) goto L12;
            Logger.INSTANCE.e(u.e, "cannot notify opened fd to the receiver; e=" + r10, r10);
        L12:
            int r11 = this.d;
            AssetFileDescriptor r0 = this.f7635b;
            u r2 = this.c;
            int r3 = Process.myPid();     // Catch: Throwable -> L19
            if (r11 != r3) goto L16;
            Logger r1 = Logger.INSTANCE;     // Catch: Throwable -> L19
            String r12 = "not closing fd because the sharer/receiver are with the same PID (" + r11 + ").";     // Catch: Throwable -> L19
        L17:
            r1.d(u.e, r12);     // Catch: Throwable -> L19
            Object r13 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L21:
            AssetFileDescriptor r7 = this.f7635b;
            Throwable r14 = Result.m1424exceptionOrNullimpl(r13);
            if (r14 == null) goto L25;
            Logger.INSTANCE.e(u.e, "cannot close opened fd/" + r7.hashCode() + "; e=" + r14, r14);
        L25:
            return Unit.INSTANCE;
        L16:
            r0.close();     // Catch: Throwable -> L19
            Logger r4 = Logger.INSTANCE;     // Catch: Throwable -> L19
            r12 = "sharer closed the shared fd/" + r0.hashCode() + " for URI: " + r2.c() + "; rcvPid=" + r11 + "; myPid=" + r3 + '.';     // Catch: Throwable -> L19
            r1 = r4;
        L19:
            th = move-exception;
            r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        L7:
            th = move-exception;
            r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L9
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        d = new a(null);
    }

    public u(Uri r3, IUriFileReceiver r4, String r5) {
        IUriFileReceiver r6 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r4, IUriFileReceiver.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "uriToOpen");
        Intrinsics.checkNotNullParameter(r6, "forReceiver");
        Intrinsics.checkNotNullParameter(r5, "receiverPackage");
        this.f7630a = r3;
        this.f7631b = r6;
        this.c = r5;
    }

    public final IUriFileReceiver a() {
        return this.f7631b;
    }

    public final void a(int r10) {
        AssetFileDescriptor r1 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getContentResolver().openAssetFileDescriptor(this.f7630a, "r");     // Catch: Exception -> L5
    L7:
        if (r1 != null) goto L9;
        Logger.INSTANCE.w(e, "openFd = null; UriFileOpener: " + this.c + " ---> URI " + this.f7630a);
        al r3 = ActionDispatcher.INSTANCE.getScope();
        Function2 r6 = new b(this, null);
    L10:
        kotlinx.coroutines.i.a(r3, null, null, r6, 3, null);
        return;
    L9:
        r3 = ActionDispatcher.INSTANCE.getScope();
        r6 = new c(r1, this, r10, null);
    L5:
        e = move-exception;
        Logger.INSTANCE.e(e, "failed to open URI " + this.f7630a + " (for " + this.c + "); e=" + e, e);
        r1 = null;
        goto L7
    }

    public final String b() {
        return this.c;
    }

    public final Uri c() {
        return this.f7630a;
    }
}
