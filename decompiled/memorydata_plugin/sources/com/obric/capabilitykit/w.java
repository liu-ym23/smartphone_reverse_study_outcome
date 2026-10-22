package com.obric.capabilitykit;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.EventsUtils;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlinx.coroutines.ah;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002¢\u0006\u0002\u0010\rJ=\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016JE\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\"\u0010\u001c\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJE\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\"\u0010\u001c\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J#\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0080@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/execution/fileaccess/sharer/UriShareInternalHelper;", "", "()V", "TAG", "", "URI_OPEN_WAIT_TIME_MILLIS", "", "UriReceiver", "com/obric/capabilitykit/execution/fileaccess/sharer/UriShareInternalHelper$UriReceiver$1", "onSession", "Lkotlin/Function1;", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "", "(Lkotlin/jvm/functions/Function1;)Lcom/obric/capabilitykit/execution/fileaccess/sharer/UriShareInternalHelper$UriReceiver$1;", "handleReturnedFd", "", "fd", "Landroid/content/res/AssetFileDescriptor;", "iStreamHandler", "Lkotlin/Function2;", "Ljava/io/InputStream;", "Lkotlin/coroutines/Continuation;", "(Landroid/content/res/AssetFileDescriptor;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInputStreamByEntity", "entity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "uri", "Landroid/net/Uri;", "onGranted", "(Lcom/obric/capabilitykit/entity/app/AppEntity;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openInputStreamByPackage", "uriPackageName", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startUriSession", ObricMemoryConstants.KEY_PACKAGE_NAME, "startUriSession$capabilitykit_release", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startUriSessionInternal", "stopUriSession", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f7636a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7637b = "UriShareHelper";
    private static final long c = 3000;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/capabilitykit/execution/fileaccess/sharer/UriShareInternalHelper$UriReceiver$1", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver$Stub;", "onSessionReady", "", "fileAccess", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends IUriFileReceiver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<UriFileAccessSession, Unit> f7638a;

        /* JADX INFO: renamed from: com.obric.capabilitykit.w$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$UriReceiver$1$onSessionReady$1", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0370a extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7639a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UriFileAccessSession f7640b;
            public final /* synthetic */ Function1<UriFileAccessSession, Unit> c;

            public C0370a(UriFileAccessSession r3, Function1<? super UriFileAccessSession, Unit> r4, Continuation<? super C0370a> r5) {
                Function1<UriFileAccessSession, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.f7640b = r3;
                this.c = r6;
                super(2, r7);
            }

            public final Object a(al r3, Continuation<? super Unit> r4) {
                return ((C0370a) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C0370a.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return new C0370a(this.f7640b, this.c, r4);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7639a != 0) goto L10;
                ResultKt.throwOnFailure(r2);
                UriFileAccessSession r3 = this.f7640b;
                if (r3 == null) goto L8;
                this.c.invoke(r3);
            L8:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public a(Function1<? super UriFileAccessSession, Unit> r3) {
            this.f7638a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver
        public void onSessionReady(UriFileAccessSession r8) {
            kotlinx.coroutines.i.a(am.a(ba.c()), null, null, new C0370a(r8, this.f7638a, null), 3, null);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper", f = "UriShareInternalHelper.kt", i = {0, 0, 2, 2, 3}, l = {75, 80, 89, 97}, m = "handleReturnedFd", n = {"fd", "iStreamHandler", "fd", "iStream", "errorCode"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f7641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f7642b;
        public int c;
        public /* synthetic */ Object d;
        public final /* synthetic */ w e;
        public int f;

        public b(w r3, Continuation<? super b> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.e = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.d = r2;
            this.f |= Integer.MIN_VALUE;
            return w.a(this.e, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$2", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<al, Continuation<? super Result<? extends Unit>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f7644b;
        public final /* synthetic */ InputStream c;
        public final /* synthetic */ AssetFileDescriptor d;

        public c(InputStream r3, AssetFileDescriptor r4, Continuation<? super c> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.c = r3;
            this.d = r4;
            super(2, r6);
        }

        public final Object a(al r3, Continuation<? super Result<Unit>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), c.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            c r0 = new c(this.c, this.d, r5);
            r0.f7644b = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Result<? extends Unit>> r4) {
            return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7643a != 0) goto L23;
            ResultKt.throwOnFailure(r5);
            al r6 = (al) ZeusTransformUtils.preCheckCast(this.f7644b, al.class, "com.obric.memorydata.plugin");
            this.c.close();     // Catch: Throwable -> L7
            Object r7 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
            if (r8 == null) goto L12;
            Logger.INSTANCE.e(w.f7637b, "closing input stream raised error: " + r8, r8);
        L12:
            AssetFileDescriptor r4 = this.d;
            r4.close();     // Catch: Throwable -> L15
            Logger.INSTANCE.d(w.f7637b, "receiver closed the shared fd/" + r4.hashCode() + '.');     // Catch: Throwable -> L15
            Object r9 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
            if (r10 == null) goto L21;
            Logger.INSTANCE.e(w.f7637b, "closing fd raised error: " + r10, r10);
        L21:
            return Result.m1420boximpl(r9);
        L15:
            th = move-exception;
            r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        L7:
            th = move-exception;
            r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L9
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Ljava/io/FileInputStream;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$iStream$1", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<al, Continuation<? super FileInputStream>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssetFileDescriptor f7646b;

        public d(AssetFileDescriptor r3, Continuation<? super d> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.f7646b = r3;
            super(2, r5);
        }

        public final Object a(al r3, Continuation<? super FileInputStream> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), d.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return new d(this.f7646b, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super FileInputStream> r4) {
            return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7645a != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return this.f7646b.createInputStream();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$iStream$2", f = "UriShareInternalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssetFileDescriptor f7648b;

        public e(AssetFileDescriptor r3, Continuation<? super e> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.f7648b = r3;
            super(2, r5);
        }

        public final Object a(al r3, Continuation<? super Unit> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return new e(this.f7648b, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7647a != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.f7648b.close();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper", f = "UriShareInternalHelper.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {47, EventsUtils.FEAT_TYPE_ACTIVITY_PAUSED_TIMEOUT}, m = "openInputStreamByPackage", n = {"this", "uriPackageName", "uri", "onGranted", "this", "uriPackageName", "uri"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
    public static final class f extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f7649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f7650b;
        public Object c;
        public Object d;
        public /* synthetic */ Object e;
        public final /* synthetic */ w f;
        public int g;

        public f(w r3, Continuation<? super f> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.e = r2;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper", f = "UriShareInternalHelper.kt", i = {}, l = {129}, m = "startUriSession$capabilitykit_release", n = {}, s = {})
    public static final class g extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f7651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f7652b;
        public int c;

        public g(w r3, Continuation<? super g> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.f7652b = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.f7651a = r2;
            this.c |= Integer.MIN_VALUE;
            return this.f7652b.a(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$startUriSession$session$1", f = "UriShareInternalHelper.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<al, Continuation<? super UriFileAccessSession>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7654b;
        public final /* synthetic */ Uri c;

        public h(String r3, Uri r4, Continuation<? super h> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.f7654b = r3;
            this.c = r4;
            super(2, r6);
        }

        public final Object a(al r3, Continuation<? super UriFileAccessSession> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), h.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return new h(this.f7654b, this.c, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super UriFileAccessSession> r4) {
            return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.f7653a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            w r6 = w.f7636a;
            String r2 = this.f7654b;
            Uri r3 = this.c;
            this.f7653a = 1;
            r5 = w.a(r6, r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "session", "Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function1<UriFileAccessSession, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.n<UriFileAccessSession> f7655a;

        public i(kotlinx.coroutines.n<? super UriFileAccessSession> r3) {
            this.f7655a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
            super(1);
        }

        public final void a(UriFileAccessSession r2) {
            Intrinsics.checkNotNullParameter(r2, "session");
            kotlinx.coroutines.n<UriFileAccessSession> r1 = this.f7655a;
            r1.resumeWith(Result.m1421constructorimpl(r2));     // Catch: Throwable -> L5
            Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L8:
            if (Result.m1424exceptionOrNullimpl(r3) == null) goto L15;
            AssetFileDescriptor r4 = r2.getFd();
            if (r4 == null) goto L16;
            r4.close();
            return;
        L16:
            return;
        L15:
            return;
        L5:
            th = move-exception;
            r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L8
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(UriFileAccessSession r3) {
            a((UriFileAccessSession) ZeusTransformUtils.preCheckCast(r3, UriFileAccessSession.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    static {
        f7636a = new w();
    }

    private w() {
    }

    private final int a(String r2, Uri r3) {
        AtomicCapabilitySdk.INSTANCE.stopUriFileAccess$capabilitykit_release(r3, r2);     // Catch: Exception -> L4
        return 0;
    L4:
        e = move-exception;
        Logger.INSTANCE.e(f7637b, "requestUriFileAccess; exception=" + e, e);
        return 1;
    }

    public static final /* synthetic */ a a(w r2, Function1 r3) {
        return r2.a((Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin"));
    }

    private final a a(Function1<? super UriFileAccessSession, Unit> r2) {
        return new a((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(AssetFileDescriptor r11, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r12, Continuation<? super Integer> r13) {
        Function2 r14 = (Function2) ZeusTransformUtils.wrapperContextForParams(r12, Function2.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r15, b.class, "com.obric.memorydata.plugin");
        int r2 = r0.f;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f = r2 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.d;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.f;
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L23;
        if (r3 == 2) goto L22;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        int r17 = r0.c;
        ResultKt.throwOnFailure(r10);
    L44:
        return Boxing.boxInt(r17);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        InputStream r18 = (InputStream) ZeusTransformUtils.preCheckCast(r0.f7642b, InputStream.class, "com.obric.memorydata.plugin");
        AssetFileDescriptor r19 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r0.f7641a, AssetFileDescriptor.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L20
    L35:
        int r110 = 0;
    L36:
        InputStream r9 = r18;
        r17 = r110;
        ah r1 = ba.c();
        c r4 = new c(r9, r19, null);
        r0.f7641a = null;
        r0.f7642b = null;
        r0.c = r17;
        r0.f = 4;
        if (kotlinx.coroutines.i.a(r1, r4, r0) != r16) goto L44;
        return r16;
    L20:
        Exception e2 = e;
    L39:
        Logger.INSTANCE.e(f7637b, "handle input stream raised error: " + e2, e2);
        r110 = 6;
        goto L36
    L22:
        ResultKt.throwOnFailure(r10);
    L50:
        return Boxing.boxInt(5);
    L23:
        r14 = (Function2) ZeusTransformUtils.preCheckCast(r0.f7642b, Function2.class, "com.obric.memorydata.plugin");
        r11 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r0.f7641a, AssetFileDescriptor.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L45
    L30:
        Intrinsics.checkNotNullExpressionValue(r10, "fd: AssetFileDescriptor,…)\n            }\n        }");     // Catch: Exception -> L45
        InputStream r111 = (InputStream) ZeusTransformUtils.preCheckCast(r10, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L45
        Logger.INSTANCE.i(f7637b, "the client is handling the returned InputStream...");     // Catch: Exception -> L37
        r0.f7641a = r11;     // Catch: Exception -> L37
        r0.f7642b = r111;     // Catch: Exception -> L37
        r0.f = 3;     // Catch: Exception -> L37
        if (r14.invoke(r111, r0) != r16) goto L34;
        return r16;
    L34:
        r19 = r11;
        r18 = r111;
    L37:
        e = move-exception;
        AssetFileDescriptor r20 = r11;
        r18 = r111;
        e2 = e;
        r19 = r20;
        goto L39
    L26:
        ResultKt.throwOnFailure(r10);
        ah r112 = ba.c();     // Catch: Exception -> L45
        d r5 = new d(r11, null);     // Catch: Exception -> L45
        r0.f7641a = r11;     // Catch: Exception -> L45
        r0.f7642b = r14;     // Catch: Exception -> L45
        r0.f = 1;     // Catch: Exception -> L45
        r10 = kotlinx.coroutines.i.a(r112, r5, r0);     // Catch: Exception -> L45
        if (r10 != r16) goto L30;
        return r16;
    L45:
        e = move-exception;
        Logger.INSTANCE.e(f7637b, "cannot open input stream; error: " + e, e);
        ah r113 = ba.c();
        e r114 = new e(r11, null);
        r0.f7641a = null;
        r0.f7642b = null;
        r0.f = 2;
        if (kotlinx.coroutines.i.a(r113, r114, r0) != r16) goto L50;
        return r16;
    L7:
        r0 = new b(this, r15);
        goto L8
    }

    public static final /* synthetic */ Object a(w r2, AssetFileDescriptor r3, Function2 r4, Continuation r5) {
        return r2.a(r3, (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(w r2, String r3, Uri r4, Continuation r5) {
        return r2.b(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(String r9, Uri r10, Continuation<? super UriFileAccessSession> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.o r12 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r8), 1);
        r12.e();
        AtomicCapabilitySdk.INSTANCE.requestUriFileAccess$capabilitykit_release(r10, r9, a(f7636a, new i(r12)));     // Catch: Exception -> L5
    L11:
        Object r13 = r12.h();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L14:
        return r13;
    L5:
        e = move-exception;
        Logger.INSTANCE.e(f7637b, "requestUriFileAccess; exception=" + e, e);
        r12.resumeWith(Result.m1421constructorimpl(new UriFileAccessSession(7, null, null, 6, null)));     // Catch: Throwable -> L9
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final Object a(AppEntity r3, Uri r4, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Integer> r6) {
        Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Continuation<? super Integer> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        String r9 = r3.getPackageName();
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Logger.INSTANCE.e(f7637b, "no sharer package found in entity.");
        return Boxing.boxInt(3);
    L10:
        return a(r9, r4, r7, r8);
    L5:
        r0 = false;
        goto L6
    }

    public final Object a(String r7, Uri r8, Continuation<? super UriFileAccessSession> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, g.class) == false) goto L7;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r10, g.class, "com.obric.memorydata.plugin");
        int r2 = r0.c;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r0.c = r2 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f7651a;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        UriFileAccessSession r12 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r6, UriFileAccessSession.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L21;
        Logger.INSTANCE.e(f7637b, "startUriSession: withTimeoutOrNull exceeds timeout: 3000ms ");
        return new UriFileAccessSession(9, "访问文件超时", null, 4, null);
    L21:
        return r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        h r13 = new h(r7, r8, null);
        r0.c = 1;
        r6 = da.b(3000, r13, r0);
        if (r6 != r11) goto L17;
        return r11;
    L7:
        r0 = new g(this, r10);
        goto L8
    }

    public final Object a(String r9, Uri r10, Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super Integer> r12) {
        Function2<? super InputStream, ? super Continuation<? super Unit>, ? extends Object> r13 = (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, f.class) == false) goto L7;
        f r1 = (f) ZeusTransformUtils.preCheckCast(r14, f.class, "com.obric.memorydata.plugin");
        int r3 = r1.g;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r1.g = r3 - Integer.MIN_VALUE;
    L8:
        Object r15 = r1.e;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r1.g;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        Uri r8 = (Uri) ZeusTransformUtils.preCheckCast(r1.c, Uri.class, "com.obric.memorydata.plugin");
        r9 = (String) ZeusTransformUtils.preCheckCast(r1.f7650b, String.class, "com.obric.memorydata.plugin");
        w r16 = (w) ZeusTransformUtils.preCheckCast(r1.f7649a, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
    L30:
        int r17 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r17 == 0) goto L33;
        r16.a(r9, r8);
        return Boxing.boxInt(r17);
    L33:
        return Boxing.boxInt(r16.a(r9, r8));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = (Function2) ZeusTransformUtils.preCheckCast(r1.d, Function2.class, "com.obric.memorydata.plugin");
        r10 = (Uri) ZeusTransformUtils.preCheckCast(r1.c, Uri.class, "com.obric.memorydata.plugin");
        r9 = (String) ZeusTransformUtils.preCheckCast(r1.f7650b, String.class, "com.obric.memorydata.plugin");
        w this = (w) ZeusTransformUtils.preCheckCast(r1.f7649a, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
    L19:
        UriFileAccessSession r18 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r15, UriFileAccessSession.class, "com.obric.memorydata.plugin");
        AssetFileDescriptor r0 = r18.getFd();
        if (r18.getStatus() != 0) goto L22;
        if (r0 == null) goto L25;
        r1.f7649a = this;
        r1.f7650b = r9;
        r1.c = r10;
        r1.d = null;
        r1.g = 2;
        r15 = this.a(r0, r13, r1);
        if (r15 != r4) goto L29;
        return r4;
    L29:
        Uri r7 = r10;
        r16 = this;
        r8 = r7;
        goto L30
    L25:
        return Boxing.boxInt(1);
    L22:
        return Boxing.boxInt(r18.getStatus());
    L16:
        ResultKt.throwOnFailure(r15);
        r1.f7649a = this;
        r1.f7650b = r9;
        r1.c = r10;
        r1.d = r13;
        r1.g = 1;
        r15 = a(r9, r10, r1);
        if (r15 != r4) goto L19;
        return r4;
    L7:
        r1 = new f(this, r14);
        goto L8
    }
}
