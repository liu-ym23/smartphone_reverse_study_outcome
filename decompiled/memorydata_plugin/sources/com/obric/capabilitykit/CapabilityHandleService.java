package com.obric.capabilitykit;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.ICapabilityActionHandler;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/CapabilityHandleService;", "Landroid/app/Service;", "()V", "binder", "Lcom/obric/capabilitykit/CapabilityHandleService$CapabilityHandleBinder;", "onBind", "Landroid/os/IBinder;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onCreate", "", "onDestroy", "CapabilityHandleBinder", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class CapabilityHandleService extends PluginService {
    private static final Map<String, List<String>> ALLOWED_PACKAGES = null;
    public static final a Companion = null;
    public static final String TAG = "CapabilityHandleService";
    private static final int VERSION = 1;
    private final CapabilityHandleBinder binder;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J*\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J&\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/obric/capabilitykit/CapabilityHandleService$CapabilityHandleBinder;", "Lcom/obric/capabilitykit/common/ICapabilityActionHandler$Stub;", "shouldEnsureCaller", "", "(Z)V", "doJobInternal", "", "calling", "Lcom/obric/capabilitykit/common/execution/IntentCalling;", "messageId", "", "jobId", "(Lcom/obric/capabilitykit/common/execution/IntentCalling;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureCaller", "getVersion", "", "handleAction", "s", "handleIntentCalling", "isTaskRunning", "onTransact", "code", "data", "Landroid/os/Parcel;", "reply", "flags", "openUriFile", "uri", "Landroid/net/Uri;", "forReceiver", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "receiverPackage", "stopAction", InfoRequestQPSOptTraceLogger.REASON, "stopComplexTask", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class CapabilityHandleBinder extends ICapabilityActionHandler.Stub {
        private final boolean shouldEnsureCaller;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder", f = "CapabilityHandleService.kt", i = {0, 0}, l = {118}, m = "doJobInternal", n = {"messageId", "jobId"}, s = {"L$0", "L$1"})
        public static final class a extends ContinuationImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f7443a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f7444b;
            public /* synthetic */ Object c;
            public final /* synthetic */ CapabilityHandleBinder d;
            public int e;

            public a(CapabilityHandleBinder r3, Continuation<? super a> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.d = r3;
                super(r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                this.c = r2;
                this.e |= Integer.MIN_VALUE;
                return CapabilityHandleBinder.access$doJobInternal(this.d, null, null, null, this);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/Job;", "invoke", "(Lkotlin/Pair;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class b extends Lambda implements Function1<Pair<? extends String, ? extends bx>, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f7445a;

            public b(String r1) {
                this.f7445a = r1;
                super(1);
            }

            public final Boolean a(Pair<String, ? extends bx> r2) {
                Intrinsics.checkNotNullParameter(r2, "it");
                return Boolean.valueOf(Intrinsics.areEqual(r2.getFirst(), this.f7445a));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Boolean invoke(Pair<? extends String, ? extends bx> r3) {
                return a((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin"));
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "invoke", "(Lkotlin/Pair;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class c extends Lambda implements Function1<Pair<? extends String, ? extends IntentFunction<?, ?>>, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f7446a;

            public c(String r1) {
                this.f7446a = r1;
                super(1);
            }

            public final Boolean a(Pair<String, ? extends IntentFunction<?, ?>> r2) {
                Intrinsics.checkNotNullParameter(r2, "it");
                return Boolean.valueOf(Intrinsics.areEqual(r2.getFirst(), this.f7446a));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Boolean invoke(Pair<? extends String, ? extends IntentFunction<?, ?>> r3) {
                return a((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin"));
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "byte", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class d extends Lambda implements Function1<Byte, CharSequence> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f7447a = null;

            static {
                f7447a = new d();
            }

            public d() {
                super(1);
            }

            public final CharSequence a(byte r3) {
                String r2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
                Intrinsics.checkNotNullExpressionValue(r2, "java.lang.String.format(format, *args)");
                return r2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ CharSequence invoke(Byte r3) {
                return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).byteValue());
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleAction$1$1$1", f = "CapabilityHandleService.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
        public static final class e extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7448a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ IMAppAction f7449b;

            public e(IMAppAction r3, Continuation<? super e> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.f7449b = r3;
                super(2, r5);
            }

            public final Object a(al r3, Continuation<? super Unit> r4) {
                return ((e) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return new e(this.f7449b, r4);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r8) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.f7448a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r8);
            L13:
                IMAppAction r9 = (IMAppAction) ZeusTransformUtils.preCheckCast(r8, IMAppAction.class, "com.obric.memorydata.plugin");
                Logger.INSTANCE.i(CapabilityHandleService.TAG, "sendActionExecuteResult: " + this.f7449b.getQuestionId() + ' ' + r9.getContent());
                AtomicCapabilitySdk.INSTANCE.sendActionExecuteResult$capabilitykit_release(r9);
            L15:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r8);
                if (this.f7449b.getReplyId() != 0) goto L15;
                ActionDispatcher r10 = ActionDispatcher.INSTANCE;
                IMAppAction r2 = this.f7449b;
                Intrinsics.checkNotNullExpressionValue(r2, "action");
                this.f7448a = 1;
                r8 = r10.onActionReceived(r2, this);
                if (r8 != r0) goto L13;
                return r0;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleIntentCalling$1$1$job$1", f = "CapabilityHandleService.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
        public static final class f extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7450a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CapabilityHandleBinder f7451b;
            public final /* synthetic */ IntentCalling c;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;

            public f(CapabilityHandleBinder r3, IntentCalling r4, String r5, String r6, Continuation<? super f> r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                this.f7451b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
                super(2, r8);
            }

            public final Object a(al r3, Continuation<? super Unit> r4) {
                return ((f) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), f.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                return new f(this.f7451b, this.c, this.d, this.e, r5);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.f7450a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r6);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                CapabilityHandleBinder r7 = this.f7451b;
                IntentCalling r2 = this.c;
                String r3 = this.d;
                String r4 = this.e;
                this.f7450a = 1;
                if (CapabilityHandleBinder.access$doJobInternal(r7, r2, r3, r4, this) != r0) goto L12;
                return r0;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleIntentCalling$1$1$job$2", f = "CapabilityHandleService.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
        public static final class g extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7452a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CapabilityHandleBinder f7453b;
            public final /* synthetic */ IntentCalling c;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;

            public g(CapabilityHandleBinder r3, IntentCalling r4, String r5, String r6, Continuation<? super g> r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                this.f7453b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
                super(2, r8);
            }

            public final Object a(al r3, Continuation<? super Unit> r4) {
                return ((g) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), g.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                return new g(this.f7453b, this.c, this.d, this.e, r5);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.f7452a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r6);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                CapabilityHandleBinder r7 = this.f7453b;
                IntentCalling r2 = this.c;
                String r3 = this.d;
                String r4 = this.e;
                this.f7452a = 1;
                if (CapabilityHandleBinder.access$doJobInternal(r7, r2, r3, r4, this) != r0) goto L12;
                return r0;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$openUriFile$1$1", f = "CapabilityHandleService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class h extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7454a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Uri f7455b;
            public final /* synthetic */ IUriFileReceiver c;
            public final /* synthetic */ String d;
            public final /* synthetic */ int e;

            public h(Uri r3, IUriFileReceiver r4, String r5, int r6, Continuation<? super h> r7) {
                IUriFileReceiver r8 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r4, IUriFileReceiver.class, "com.obric.memorydata.plugin");
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                this.f7455b = r3;
                this.c = r8;
                this.d = r5;
                this.e = r6;
                super(2, r9);
            }

            public final Object a(al r3, Continuation<? super Unit> r4) {
                return ((h) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), h.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                return new h(this.f7455b, this.c, this.d, this.e, r5);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7454a != 0) goto L7;
                ResultKt.throwOnFailure(r4);
                Logger.INSTANCE.d(CapabilityHandleService.TAG, "openUriFile: " + this.f7455b + "; opening for receiver: " + this.c);
                new u(this.f7455b, this.c, this.d).a(this.e);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$stopAction$1$1$1", f = "CapabilityHandleService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class i extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f7456a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f7457b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;

            public i(String r3, String r4, String r5, Continuation<? super i> r6) {
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                this.f7457b = r3;
                this.c = r4;
                this.d = r5;
                super(2, r7);
            }

            public final Object a(al r3, Continuation<? super Unit> r4) {
                return ((i) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), i.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return new i(this.f7457b, this.c, this.d, r5);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f7456a != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                t.f7622a.a(this.f7457b, this.c, this.d);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public CapabilityHandleBinder(boolean r1) {
            this.shouldEnsureCaller = r1;
        }

        public static final /* synthetic */ Object access$doJobInternal(CapabilityHandleBinder r2, IntentCalling r3, String r4, String r5, Continuation r6) {
            return r2.doJobInternal(r3, r4, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
        }

        private final Object doJobInternal(IntentCalling r5, String r6, String r7, Continuation<? super Unit> r8) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r9, a.class) == false) goto L7;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            int r1 = r0.e;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.e = r1 - Integer.MIN_VALUE;
        L8:
            Object r4 = r0.c;
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.e;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            r7 = (String) ZeusTransformUtils.preCheckCast(r0.f7444b, String.class, "com.obric.memorydata.plugin");
            r6 = (String) ZeusTransformUtils.preCheckCast(r0.f7443a, String.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r4);
        L17:
            Pair r11 = (Pair) ZeusTransformUtils.preCheckCast(r4, Pair.class, "com.obric.memorydata.plugin");
            IntentResult<?> r12 = (IntentResult) ZeusTransformUtils.preCheckCast(r11.getFirst(), IntentResult.class, "com.obric.memorydata.plugin");
            AtomicCapabilitySdk.INSTANCE.sendIntentExecutionResult$capabilitykit_release(r12, (IMAppAction) ZeusTransformUtils.preCheckCast(r11.getSecond(), IMAppAction.class, "com.obric.memorydata.plugin"));
            if (r12.isFinal() == false) goto L64;
            com.obric.capabilitykit.c r13 = com.obric.capabilitykit.c.f7476a;
            LinkedHashMap<String, Set<Pair<String, bx>>> r14 = r13.c();
            monitor-enter(r14);
        L60:
            th = move-exception;
            throw th;
        L23:
            Logger.INSTANCE.i(CapabilityHandleService.TAG, "doJobInternal jobId: " + r7 + " isFinal = true " + r13.c());     // Catch: Throwable -> L60
            if (Build.VERSION.SDK_INT < 24) goto L31;
            Set r15 = (Set) ZeusTransformUtils.preCheckCast(r13.c().get(r6), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
            if (r15 == null) goto L28;
            final b r16 = new b(r7);     // Catch: Throwable -> L60
            Boxing.boxBoolean(r15.removeIf(new $$Lambda$CapabilityHandleService$CapabilityHandleBinder$CTQ9_QXayqEGsvkQKDhP922QY20(r16)));     // Catch: Throwable -> L60
        L28:
            Set r17 = (Set) ZeusTransformUtils.preCheckCast(t.f7622a.b().get(r6), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
            if (r17 == null) goto L58;
            final c r18 = new c(r7);     // Catch: Throwable -> L60
            Boxing.boxBoolean(r17.removeIf(new $$Lambda$CapabilityHandleService$CapabilityHandleBinder$ykN7FP37zbNk7vJdghrOZDmT4mg(r18)));     // Catch: Throwable -> L60
        L58:
            monitor-exit(r14);
            goto L64
        L31:
            Set r19 = (Set) ZeusTransformUtils.preCheckCast(r13.c().get(r6), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
            Iterator r20 = null;
            if (r19 == null) goto L34;
            Iterator r21 = r19.iterator();     // Catch: Throwable -> L60
        L36:
            if (r21 != null) goto L38;
        L40:
            boolean r3 = false;
        L41:
            if (r3 == false) goto L45;
            if (Intrinsics.areEqual(((Pair) ZeusTransformUtils.preCheckCast(r21.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), r7) == false) goto L36;
            r21.remove();     // Catch: Throwable -> L60
            goto L36
        L45:
            Set r22 = (Set) ZeusTransformUtils.preCheckCast(t.f7622a.b().get(r6), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
            if (r22 == null) goto L48;
            r20 = r22.iterator();     // Catch: Throwable -> L60
        L48:
            if (r20 != null) goto L50;
        L52:
            boolean r23 = false;
        L53:
            if (r23 == false) goto L58;
            if (Intrinsics.areEqual(((Pair) ZeusTransformUtils.preCheckCast(r20.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), r7) == false) goto L48;
            r20.remove();     // Catch: Throwable -> L60
            goto L48
        L50:
            if (r20.hasNext() != true) goto L52;
            r23 = true;
            goto L53
        L38:
            if (r21.hasNext() != true) goto L40;
            r3 = true;
            goto L41
        L34:
            r21 = null;
        L64:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r4);
            s r24 = s.f7605a;
            r0.f7443a = r6;
            r0.f7444b = r7;
            r0.e = 1;
            r4 = r24.a(r5, r7, r0);
            if (r4 != r10) goto L17;
            return r10;
        L7:
            r0 = new a(this, r9);
            goto L8
        }

        private static final boolean doJobInternal$lambda$10$lambda$8(Function1 r2, Object r3) {
            Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "$tmp0");
            return ((Boolean) ZeusTransformUtils.preCheckCast(r4.invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        private static final boolean doJobInternal$lambda$10$lambda$9(Function1 r2, Object r3) {
            Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "$tmp0");
            return ((Boolean) ZeusTransformUtils.preCheckCast(r4.invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        private final boolean ensureCaller() {
            if (this.shouldEnsureCaller == true) goto L5;
            return true;
        L5:
            PackageManager r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageManager();
            if (r0.checkSignatures(1000, Binder.getCallingUid()) != 0) goto L8;
            return true;
        L8:
            String r3 = r0.getNameForUid(Binder.getCallingUid());
            if (r3 == null) goto L14;
            if (r0.checkSignatures("android", r3) != 0) goto L14;
            return true;
        L14:
            if (r3 != null) goto L16;
        L18:
            boolean r5 = false;
        L19:
            if (r5 == true) goto L21;
            return false;
        L21:
            List r2 = (List) ZeusTransformUtils.preCheckCast(CapabilityHandleService.access$getALLOWED_PACKAGES$cp().get(r3), List.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L24;
        L27:
            boolean r6 = true;
        L29:
            if (r6 == true) goto L48;
            if (r2 != null) goto L32;
        L35:
            boolean r7 = true;
        L36:
            if (r7 == true) goto L48;
            Signature[] r1 = r0.getPackageInfo(r3, 64).signatures;     // Catch: PackageManager.NameNotFoundException -> L46
            MessageDigest r8 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);     // Catch: PackageManager.NameNotFoundException -> L46
            Intrinsics.checkNotNullExpressionValue(r1, "signatures");     // Catch: PackageManager.NameNotFoundException -> L46
            int r9 = r1.length;     // Catch: PackageManager.NameNotFoundException -> L46
            int r10 = 0;
        L39:
            if (r10 >= r9) goto L48;
            r8.update(r1[r10].toByteArray());     // Catch: PackageManager.NameNotFoundException -> L46
            byte[] r11 = r8.digest();     // Catch: PackageManager.NameNotFoundException -> L46
            Intrinsics.checkNotNullExpressionValue(r11, "messageDigest.digest()");     // Catch: PackageManager.NameNotFoundException -> L46
            if (r2.contains(ArraysKt.joinToString$default(r11, "", null, null, 0, null, d.f7447a, 30, null)) == true) goto L44;
            r10 = r10 + 1;
            goto L39
        L44:
            return true;
        L46:
            e = move-exception;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "ensureCaller failed", e);
            goto L48
        L32:
            if (r2.isEmpty() == true) goto L35;
            r7 = false;
        L48:
            Logger.INSTANCE.e(CapabilityHandleService.TAG, r3 + " not in allowed packages");
            return false;
        L24:
            if (r3.length() == 0) goto L27;
            r6 = false;
            goto L29
        L16:
            if (PackageUtils.INSTANCE.isPrivilegedApp(r3) != true) goto L18;
            r5 = true;
            goto L19
        }

        public static /* synthetic */ boolean lambda$CTQ9_QXayqEGsvkQKDhP922QY20(Function1 r0, Object r1) {
            return doJobInternal$lambda$10$lambda$8(r0, r1);
        }

        public static /* synthetic */ boolean lambda$ykN7FP37zbNk7vJdghrOZDmT4mg(Function1 r0, Object r1) {
            return doJobInternal$lambda$10$lambda$9(r0, r1);
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int getVersion() {
            return 1;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleAction(String r7) {
            Logger r6 = Logger.INSTANCE;
            r6.w(CapabilityHandleService.TAG, "handleAction: AppAction is deprecated and is replaced by the AppIntent framework.");
            r6.d(CapabilityHandleService.TAG, "doAction: " + r7);     // Catch: Throwable -> L13
            IMAppAction r8 = (IMAppAction) ZeusTransformUtils.preCheckCast(UtilsKt.getGson().fromJson(r7, IMAppAction.class), IMAppAction.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
            if (r8 == null) goto L10;
            Intrinsics.checkNotNullExpressionValue(r8, "action");     // Catch: Throwable -> L13
            StringBuilder r2 = new StringBuilder().append("doAction questionId:").append(r8.getQuestionId()).append(", dispatchStarted=");     // Catch: Throwable -> L13
            ActionDispatcher r3 = ActionDispatcher.INSTANCE;     // Catch: Throwable -> L13
            r6.i(CapabilityHandleService.TAG, r2.append(r3.getDispatchStartedQuestion()).toString());     // Catch: Throwable -> L13
            Long r9 = r8.getQuestionId();     // Catch: Throwable -> L13
            if (r9 == null) goto L8;
            long r4 = r9.longValue();     // Catch: Throwable -> L13
        L9:
            r3.launchWithTrace(r4, new e(r8, null));     // Catch: Throwable -> L13
            goto L10
        L8:
            r4 = -1;
        L10:
            if (r8 == null) goto L20;
            return true;
        L20:
            return false;
        L13:
            th = move-exception;
            Throwable r10 = Result.m1424exceptionOrNullimpl(Result.m1421constructorimpl(ResultKt.createFailure(th)));
            if (r10 == null) goto L17;
            Logger.INSTANCE.i(CapabilityHandleService.TAG, "handleAction fail: " + ExceptionsKt.stackTraceToString(r10));
        L17:
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleIntentCalling(IntentCalling r14) {
            Logger r1 = Logger.INSTANCE;     // Catch: Throwable -> L36
            StringBuilder r3 = new StringBuilder().append("doIntent: name=");     // Catch: Throwable -> L36
            String r4 = null;
            if (r14 == null) goto L8;
            String r5 = r14.getIntentName();     // Catch: Throwable -> L36
        L9:
            r1.d(CapabilityHandleService.TAG, r3.append(r5).toString());     // Catch: Throwable -> L36
            if (r14 != null) goto L12;
        L33:
            if (r14 == null) goto L44;
            return true;
        L44:
            return false;
        L12:
            r1.i(CapabilityHandleService.TAG, "handleIntentCalling questionId:" + r14.getQuestionId());     // Catch: Throwable -> L36
            String r2 = String.valueOf(r14.getQuestionId());     // Catch: Throwable -> L36
            String r6 = UUID.randomUUID().toString();     // Catch: Throwable -> L36
            Intrinsics.checkNotNullExpressionValue(r6, "randomUUID().toString()");     // Catch: Throwable -> L36
            r1.i(CapabilityHandleService.TAG, "handleIntentCalling jobId: " + r6);     // Catch: Throwable -> L36
            Map<String, String> r7 = r14.getExt();     // Catch: Throwable -> L36
            if (r7 == null) goto L18;
            r4 = (String) ZeusTransformUtils.preCheckCast(r7.get(Ext.KEY_IS_PARALLEL), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        L18:
            if (Intrinsics.areEqual(r4, "true") == false) goto L21;
            al r8 = ActionDispatcher.INSTANCE.getParallelScope();     // Catch: Throwable -> L36
            CoroutineContext r9 = null;
            CoroutineStart r11 = null;
            Function2 r12 = new f(this, r14, r2, r6, null);     // Catch: Throwable -> L36
        L20:
            bx r13 = kotlinx.coroutines.i.a(r8, r9, r11, r12, 3, null);     // Catch: Throwable -> L36
            com.obric.capabilitykit.c r10 = com.obric.capabilitykit.c.f7476a;     // Catch: Throwable -> L36
            LinkedHashMap<String, Set<Pair<String, bx>>> r15 = r10.c();     // Catch: Throwable -> L36
            monitor-enter(r15);     // Catch: Throwable -> L36
            LinkedHashMap<String, Set<Pair<String, bx>>> r16 = r10.c();     // Catch: Throwable -> L30
            Set<Pair<String, bx>> r17 = r16.get(r2);     // Catch: Throwable -> L30
            if (r17 != null) goto L27;
            r17 = new LinkedHashSet();     // Catch: Throwable -> L30
            r16.put(r2, r17);     // Catch: Throwable -> L30
        L27:
            ((Set) ZeusTransformUtils.preCheckCast(r17, Set.class, "com.obric.memorydata.plugin")).add(TuplesKt.to(r6, r13));     // Catch: Throwable -> L30
            monitor-exit(r15);     // Catch: Throwable -> L36
            goto L33
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L36
        L21:
            r8 = ActionDispatcher.INSTANCE.getScope();     // Catch: Throwable -> L36
            r9 = null;
            r11 = null;
            r12 = new g(this, r14, r2, r6, null);     // Catch: Throwable -> L36
            goto L20
        L8:
            r5 = null;
        L36:
            th = move-exception;
            Throwable r18 = Result.m1424exceptionOrNullimpl(Result.m1421constructorimpl(ResultKt.createFailure(th)));
            if (r18 == null) goto L40;
            Logger.INSTANCE.i(CapabilityHandleService.TAG, "handleIntentCalling fail: " + ExceptionsKt.stackTraceToString(r18));
        L40:
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int isTaskRunning(String r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "messageId");
            Intrinsics.checkNotNullParameter(r9, "jobId");
            com.obric.capabilitykit.c r7 = com.obric.capabilitykit.c.f7476a;
            LinkedHashMap<String, Set<Pair<String, bx>>> r0 = r7.c();
            monitor-enter(r0);
            Set r10 = (Set) ZeusTransformUtils.preCheckCast(r7.c().get(r8), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            int r1 = 1;
            if (r10 == null) goto L24;
            Intrinsics.checkNotNullExpressionValue(r10, "jobMap[messageId]");     // Catch: Throwable -> L27
            Iterator r11 = r10.iterator();     // Catch: Throwable -> L27
        L8:
            if (r11.hasNext() == false) goto L12;
            Object r3 = r11.next();     // Catch: Throwable -> L27
            if (Intrinsics.areEqual(((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin")).getFirst(), r9) == false) goto L8;
        L13:
            Pair r12 = (Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            if (r12 == null) goto L24;
            bx r13 = (bx) ZeusTransformUtils.preCheckCast(r12.component2(), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            if (r13.a() == false) goto L18;
            bx.a.a(r13, null, 1, null);     // Catch: Throwable -> L27
        L18:
            Boolean r14 = t.f7622a.a(r8, r9);     // Catch: Throwable -> L27
            if (Intrinsics.areEqual(r14, Boolean.TRUE) == true) goto L25;
            if (Intrinsics.areEqual(r14, Boolean.FALSE) == false) goto L24;
            r1 = 2;
        L25:
            monitor-exit(r0);
            return r1;
        L12:
            r3 = null;
        L24:
            r1 = 0;
        L27:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler.Stub, android.os.Binder
        public boolean onTransact(int r3, Parcel r4, Parcel r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "data");
        L9:
            th = move-exception;
            Logger.INSTANCE.w(CapabilityHandleService.TAG, "onTransact throws error. It is likely that an error occurred during parameter transferring. th=" + th, th);
            throw th;
        L4:
            if (ensureCaller() == true) goto L8;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "onTransact " + r3 + ", caller not matched.");     // Catch: Throwable -> L9
            return false;
        L8:
            return super.onTransact(r3, r4, r5, r6);
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean openUriFile(Uri r19, IUriFileReceiver r20, String r21) {
            IUriFileReceiver r8 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r20, IUriFileReceiver.class, "com.obric.memorydata.plugin");
            if (ensureCaller() == true) goto L24;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "openUriFile: " + r19 + ", caller not matched.");
            return false;
        L24:
            Logger r12 = Logger.INSTANCE;     // Catch: Throwable -> L19
            r12.d(CapabilityHandleService.TAG, "openUriFile: " + r19 + ", receiver: " + r8 + ", receiverPackage&Pid: " + r21);     // Catch: Throwable -> L19
            if (r19 == null) goto L17;
            if (r8 == null) goto L17;
            if (r21 == null) goto L17;
            List r1 = StringsKt.split$default(r21, new String[]{";"}, false, 0, 6, null);     // Catch: Throwable -> L19
            if (r1.size() == 2) goto L15;
            r12.e(CapabilityHandleService.TAG, "openUriFile: " + r19 + ", unknown receiver pid");     // Catch: Throwable -> L19
            return false;
        L15:
            kotlinx.coroutines.i.a(ActionDispatcher.INSTANCE.getScope(), null, null, new h(r19, r8, (String) ZeusTransformUtils.preCheckCast(r1.get(0), String.class, "com.obric.memorydata.plugin"), Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r1.get(1), String.class, "com.obric.memorydata.plugin")), null), 3, null);     // Catch: Throwable -> L19
            return true;
        L17:
            r12.e(CapabilityHandleService.TAG, "openUriFile: " + r19 + ", invalid params.");     // Catch: Throwable -> L19
            return false;
        L19:
            th = move-exception;
            Throwable r0 = Result.m1424exceptionOrNullimpl(Result.m1421constructorimpl(ResultKt.createFailure(th)));
            if (r0 == null) goto L23;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "openUriFile fail: " + ExceptionsKt.stackTraceToString(r0));
        L23:
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean stopAction(String r13, String r14) {
            Intrinsics.checkNotNullParameter(r13, "messageId");
            Intrinsics.checkNotNullParameter(r14, InfoRequestQPSOptTraceLogger.REASON);
            Logger r12 = Logger.INSTANCE;
            StringBuilder r0 = new StringBuilder().append("stopAction: ").append(r13).append(" reason: ").append(r14).append(" jobMap ");
            com.obric.capabilitykit.c r1 = com.obric.capabilitykit.c.f7476a;
            r12.d(CapabilityHandleService.TAG, r0.append(r1.c()).toString());
            LinkedHashMap<String, Set<Pair<String, bx>>> r15 = r1.c();
            monitor-enter(r15);
            Set r2 = (Set) ZeusTransformUtils.preCheckCast(r1.c().get(r13), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            boolean r3 = true;
            if (r2 == null) goto L13;
            Intrinsics.checkNotNullExpressionValue(r2, "jobMap[messageId]");     // Catch: Throwable -> L19
            Iterator r4 = r2.iterator();     // Catch: Throwable -> L19
        L8:
            if (r4.hasNext() == false) goto L13;
            Pair r5 = (Pair) ZeusTransformUtils.preCheckCast(r4.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            String r6 = (String) ZeusTransformUtils.preCheckCast(r5.component1(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            bx r7 = (bx) ZeusTransformUtils.preCheckCast(r5.component2(), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            if (r7.a() == false) goto L12;
            bx.a.a(r7, null, 1, null);     // Catch: Throwable -> L19
        L12:
            kotlinx.coroutines.i.a(ActionDispatcher.INSTANCE.getScope(), null, null, new i(r13, r14, r6, null), 3, null);     // Catch: Throwable -> L19
        L13:
            if (com.obric.capabilitykit.c.f7476a.c().remove(r13) != null) goto L17;
            r3 = false;
        L17:
            monitor-exit(r15);
            return r3;
        L19:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean stopComplexTask(String r2) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            return stopAction(r2, "user stop in complex task");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/CapabilityHandleService$Companion;", "", "()V", "ALLOWED_PACKAGES", "", "", "", "TAG", "VERSION", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
        ALLOWED_PACKAGES = MapsKt.mapOf(TuplesKt.to("com.larus.nova", CollectionsKt.listOf("ff04b47ec9dd20b79f758af67a184926db00ac55cfd2a01e03fba9a1dca9de2a")));
    }

    public CapabilityHandleService() {
        this.binder = new CapabilityHandleBinder(true);
    }

    public static final /* synthetic */ Map access$getALLOWED_PACKAGES$cp() {
        return ALLOWED_PACKAGES;
    }

    public IBinder onBind(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        Logger.INSTANCE.i(TAG, "onBind");
        return this.binder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        AppHost.Companion r0 = AppHost.Companion;
        Application r4 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "application");
        r0.setAppHost(new l(r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Service*/.onDestroy();
        Logger.INSTANCE.i(TAG, "onDestroy");
    }
}
