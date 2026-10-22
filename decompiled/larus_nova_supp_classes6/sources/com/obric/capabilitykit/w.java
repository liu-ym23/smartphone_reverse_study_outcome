package com.obric.capabilitykit;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.logger.Logger;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.logger.InteractorReportInitializer;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class w {
    public static final w a = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/capabilitykit/execution/fileaccess/sharer/UriShareInternalHelper$UriReceiver$1", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver$Stub;", "onSessionReady", "", "fileAccess", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public final class a extends IUriFileReceiver.Stub {
        public final /* synthetic */ Function1<UriFileAccessSession, Unit> a;

        /* JADX INFO: renamed from: com.obric.capabilitykit.w$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$UriReceiver$1$onSessionReady$1", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0002a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ UriFileAccessSession b;
            public final /* synthetic */ Function1<UriFileAccessSession, Unit> c;

            /* JADX WARN: Multi-variable type inference failed */
            public C0002a(UriFileAccessSession r1, Function1<? super UriFileAccessSession, Unit> r2, Continuation<? super C0002a> r3) {
                this.b = r1;
                this.c = r2;
                super(2, r3);
            }

            public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C0002a(this.b, this.c, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return a((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.a != 0) goto L10;
                ResultKt.throwOnFailure(r2);
                UriFileAccessSession r3 = this.b;
                if (r3 == null) goto L8;
                this.c.invoke(r3);
            L8:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super UriFileAccessSession, Unit> r1) {
            this.a = r1;
        }

        @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver
        public void onSessionReady(UriFileAccessSession r8) {
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C0002a(r8, this.a, null), 3, null);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper", f = "UriShareInternalHelper.kt", i = {0, 0, 2, 2, 3}, l = {75, 80, 89, 97}, m = "handleReturnedFd", n = {"fd", "iStreamHandler", "fd", "iStream", "errorCode"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
    public static final class b extends ContinuationImpl {
        public Object a;
        public Object b;
        public int c;
        public /* synthetic */ Object d;
        public final /* synthetic */ w e;
        public int f;

        public b(w r1, Continuation<? super b> r2) {
            this.e = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.d = r2;
            this.f |= IWakeupSessionConstant.RC_ERROR;
            w r3 = this.e;
            w r0 = w.a;
            return r3.b(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$2", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        public int a;
        private /* synthetic */ Object b;
        public final /* synthetic */ InputStream c;
        public final /* synthetic */ AssetFileDescriptor d;

        public c(InputStream r1, AssetFileDescriptor r2, Continuation<? super c> r3) {
            this.c = r1;
            this.d = r2;
            super(2, r3);
        }

        public final Object a(CoroutineScope r1, Continuation<? super Result<Unit>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            c r0 = new c(this.c, this.d, r5);
            r0.b = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return a((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L23;
            ResultKt.throwOnFailure(r6);
            CoroutineScope r7 = (CoroutineScope) this.b;
            this.c.close();     // Catch: Throwable -> L7
            Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L12;
            Logger.INSTANCE.e("UriShareHelper", "closing input stream raised error: " + r9, r9);
        L12:
            AssetFileDescriptor r10 = this.d;
            r10.close();     // Catch: Throwable -> L15
            Logger.INSTANCE.d("UriShareHelper", "receiver closed the shared fd/" + r10.hashCode() + '.');     // Catch: Throwable -> L15
            Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            Throwable r0 = Result.exceptionOrNull-impl(r11);
            if (r0 == null) goto L21;
            Logger.INSTANCE.e("UriShareHelper", "closing fd raised error: " + r0, r0);
        L21:
            return Result.box-impl(r11);
        L15:
            th = move-exception;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
        L7:
            th = move-exception;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L9
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ljava/io/FileInputStream;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$iStream$1", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FileInputStream>, Object> {
        public int a;
        public final /* synthetic */ AssetFileDescriptor b;

        public d(AssetFileDescriptor r1, Continuation<? super d> r2) {
            this.b = r1;
            super(2, r2);
        }

        public final Object a(CoroutineScope r1, Continuation<? super FileInputStream> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new d(this.b, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return a((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return this.b.createInputStream();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$iStream$2", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ AssetFileDescriptor b;

        public e(AssetFileDescriptor r1, Continuation<? super e> r2) {
            this.b = r1;
            super(2, r2);
        }

        public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new e(this.b, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return a((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.b.close();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper", f = "UriShareInternalHelper.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {ITaskManager.Stub.TRANSACTION_getTemplateIdNotNullEventTasks, ITaskManager.Stub.TRANSACTION_getEventTaskExecutionRecordById}, m = "openInputStreamByPackage", n = {"this", "uriPackageName", "uri", "onGranted", "this", "uriPackageName", "uri"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
    public static final class f extends ContinuationImpl {
        public Object a;
        public Object b;
        public Object c;
        public Object d;
        public /* synthetic */ Object e;
        public final /* synthetic */ w f;
        public int g;

        public f(w r1, Continuation<? super f> r2) {
            this.f = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.e = r2;
            this.g |= IWakeupSessionConstant.RC_ERROR;
            return this.f.d(null, null, null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper", f = "UriShareInternalHelper.kt", i = {}, l = {129}, m = "startUriSession$capabilitykit_release", n = {}, s = {})
    public static final class g extends ContinuationImpl {
        public /* synthetic */ Object a;
        public final /* synthetic */ w b;
        public int c;

        public g(w r1, Continuation<? super g> r2) {
            this.b = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.a = r2;
            this.c |= IWakeupSessionConstant.RC_ERROR;
            return this.b.c(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$startUriSession$session$1", f = "UriShareInternalHelper.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UriFileAccessSession>, Object> {
        public int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Uri c;

        public h(String r1, Uri r2, Continuation<? super h> r3) {
            this.b = r1;
            this.c = r2;
            super(2, r3);
        }

        public final Object a(CoroutineScope r1, Continuation<? super UriFileAccessSession> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new h(this.b, this.c, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return a((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L22:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            w r8 = w.a;
            String r2 = this.b;
            Uri r3 = this.c;
            this.a = 1;
            r8.getClass();
            j r9 = new j(IntrinsicsKt.intercepted(this), 1);
            r9.C();
            AtomicCapabilitySdk.INSTANCE.requestUriFileAccess$capabilitykit_release(r3, r2, new a(new i(r9)));     // Catch: Exception -> L11
        L17:
            r7 = r9.B();
            if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
            DebugProbesKt.probeCoroutineSuspended(this);
        L20:
            if (r7 != r0) goto L22;
            return r0;
        L11:
            e = move-exception;
            Logger.INSTANCE.e("UriShareHelper", "requestUriFileAccess; exception=" + e, e);
            r9.resumeWith(Result.constructor-impl(new UriFileAccessSession(7, null, 6)));     // Catch: Throwable -> L15
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "session", "", "invoke", "(Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public final class i extends Lambda implements Function1<UriFileAccessSession, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<UriFileAccessSession> a;

        /* JADX WARN: Multi-variable type inference failed */
        public i(kotlinx.coroutines.i<? super UriFileAccessSession> r1) {
            this.a = r1;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            a((UriFileAccessSession) r1);
            return Unit.INSTANCE;
        }

        public final void a(UriFileAccessSession r3) {
            Intrinsics.checkNotNullParameter(r3, "session");
            kotlinx.coroutines.i<UriFileAccessSession> r0 = this.a;
            r0.resumeWith(Result.constructor-impl(r3));     // Catch: Throwable -> L5
            Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L8:
            if (Result.exceptionOrNull-impl(r1) == null) goto L15;
            AssetFileDescriptor r4 = r3.c;
            if (r4 == null) goto L16;
            r4.close();
            return;
        L16:
            return;
        L15:
            return;
        L5:
            th = move-exception;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L8
        }
    }

    static {
        a = new w();
    }

    public w() {
    }

    public static int a(String r2, Uri r3) {
        AtomicCapabilitySdk.INSTANCE.stopUriFileAccess$capabilitykit_release(r3, r2);     // Catch: Exception -> L4
        return 0;
    L4:
        e = move-exception;
        Logger.INSTANCE.e("UriShareHelper", "requestUriFileAccess; exception=" + e, e);
        return 1;
    }

    public final Object b(AssetFileDescriptor r11, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r12, Continuation<? super Integer> r13) {
        if ((r13 instanceof b) == false) goto L7;
        b r0 = (b) r13;
        int r1 = r0.f;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r0.f = r1 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r14 = r0.d;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.f;
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L23;
        if (r3 == 2) goto L22;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        int r15 = r0.c;
        ResultKt.throwOnFailure(r14);
    L43:
        return Boxing.boxInt(r15);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        InputStream r16 = (InputStream) r0.b;
        AssetFileDescriptor r17 = (AssetFileDescriptor) r0.a;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L20
    L35:
        AssetFileDescriptor r18 = r17;
        InputStream r19 = r16;
        r15 = 0;
    L39:
        CoroutineDispatcher r4 = Dispatchers.getIO();
        c r5 = new c(r19, r18, null);
        r0.a = null;
        r0.b = null;
        r0.c = r15;
        r0.f = 4;
        if (BuildersKt.withContext(r4, r5, r0) != r2) goto L43;
        return r2;
    L20:
        Exception e2 = e;
    L38:
        Logger.INSTANCE.e("UriShareHelper", "handle input stream raised error: " + e2, e2);
        r18 = r17;
        r19 = r16;
        r15 = 6;
        goto L39
    L22:
        ResultKt.throwOnFailure(r14);
    L49:
        return Boxing.boxInt(5);
    L23:
        r12 = (Function2) r0.b;
        r11 = (AssetFileDescriptor) r0.a;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L44
    L30:
        InputStream r110 = (InputStream) r14;     // Catch: Exception -> L44
        Logger.INSTANCE.i("UriShareHelper", "the client is handling the returned InputStream...");     // Catch: Exception -> L36
        r0.a = r11;     // Catch: Exception -> L36
        r0.b = r110;     // Catch: Exception -> L36
        r0.f = 3;     // Catch: Exception -> L36
        if (r12.invoke(r110, r0) != r2) goto L34;
        return r2;
    L34:
        r17 = r11;
        r16 = r110;
    L36:
        e = move-exception;
        r17 = r11;
        r16 = r110;
        e2 = e;
        goto L38
    L26:
        ResultKt.throwOnFailure(r14);
        CoroutineDispatcher r111 = Dispatchers.getIO();     // Catch: Exception -> L44
        d r6 = new d(r11, null);     // Catch: Exception -> L44
        r0.a = r11;     // Catch: Exception -> L44
        r0.b = r12;     // Catch: Exception -> L44
        r0.f = 1;     // Catch: Exception -> L44
        r14 = BuildersKt.withContext(r111, r6, r0);     // Catch: Exception -> L44
        if (r14 != r2) goto L30;
        return r2;
    L44:
        e = move-exception;
        Logger.INSTANCE.e("UriShareHelper", "cannot open input stream; error: " + e, e);
        CoroutineDispatcher r112 = Dispatchers.getIO();
        e r113 = new e(r11, null);
        r0.a = null;
        r0.b = null;
        r0.f = 2;
        if (BuildersKt.withContext(r112, r113, r0) != r2) goto L49;
        return r2;
    L7:
        r0 = new b(this, r13);
        goto L8
    }

    public final Object c(String r5, Uri r6, Continuation<? super UriFileAccessSession> r7) {
        if ((r7 instanceof g) == false) goto L7;
        g r0 = (g) r7;
        int r1 = r0.c;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r0.c = r1 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r8 = r0.a;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        UriFileAccessSession r9 = (UriFileAccessSession) r8;
        if (r9 != null) goto L21;
        Logger.INSTANCE.e("UriShareHelper", "startUriSession: withTimeoutOrNull exceeds timeout: 3000ms ");
        return new UriFileAccessSession(9, "访问文件超时", 4);
    L21:
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        h r10 = new h(r5, r6, null);
        r0.c = 1;
        r8 = TimeoutKt.c(InteractorReportInitializer.REPORT_EVENT_DELAY_MS, r10, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new g(this, r7);
        goto L8
    }

    public final Object d(String r8, Uri r9, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r10, Continuation<? super Integer> r11) {
        if ((r11 instanceof f) == false) goto L7;
        f r0 = (f) r11;
        int r1 = r0.g;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r0.g = r1 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r12 = r0.e;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.g;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Uri r13 = (Uri) r0.c;
        String r14 = (String) r0.b;
        w r15 = (w) r0.a;
        ResultKt.throwOnFailure(r12);
    L31:
        int r16 = ((Number) r12).intValue();
        r15.getClass();
        if (r16 == 0) goto L34;
        a(r14, r13);
        return Boxing.boxInt(r16);
    L34:
        return Boxing.boxInt(a(r14, r13));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r17 = (Function2) r0.d;
        r9 = (Uri) r0.c;
        r8 = (String) r0.b;
        w r4 = (w) r0.a;
        ResultKt.throwOnFailure(r12);
        Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r18 = r17;
        r15 = r4;
        Object r5 = r12;
    L20:
        UriFileAccessSession r6 = (UriFileAccessSession) r5;
        AssetFileDescriptor r7 = r6.c;
        int r19 = r6.a;
        if (r19 != 0) goto L23;
        if (r7 == null) goto L26;
        r0.a = r15;
        r0.b = r8;
        r0.c = r9;
        r0.d = null;
        r0.g = 2;
        r12 = r15.b(r7, r18, r0);
        if (r12 != r2) goto L30;
        return r2;
    L30:
        Uri r20 = r9;
        r14 = r8;
        r13 = r20;
        goto L31
    L26:
        return Boxing.boxInt(1);
    L23:
        return Boxing.boxInt(r19);
    L16:
        ResultKt.throwOnFailure(r12);
        r0.a = this;
        r0.b = r8;
        r0.c = r9;
        r0.d = r10;
        r0.g = 1;
        Object r110 = c(r8, r9, r0);
        if (r110 != r2) goto L19;
        return r2;
    L19:
        r5 = r110;
        r18 = r10;
        r15 = this;
    L7:
        r0 = new f(this, r11);
        goto L8
    }
}
