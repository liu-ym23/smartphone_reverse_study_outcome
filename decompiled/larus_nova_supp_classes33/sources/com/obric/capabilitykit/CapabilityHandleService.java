package com.obric.capabilitykit;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
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
import com.obric.memorydata.sdk.entity.search.SearchError;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
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
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import wia.u;
import wia.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/CapabilityHandleService;", "Landroid/app/Service;", "()V", "binder", "Lcom/obric/capabilitykit/CapabilityHandleService$CapabilityHandleBinder;", "onBind", "Landroid/os/IBinder;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onCreate", "", "onDestroy", "CapabilityHandleBinder", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class CapabilityHandleService extends Service {
    private static final Map<String, List<String>> ALLOWED_PACKAGES = null;
    public static final a Companion = null;
    public static final String TAG = "CapabilityHandleService";
    private static final int VERSION = 1;
    private final CapabilityHandleBinder binder;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J*\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J&\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/obric/capabilitykit/CapabilityHandleService$CapabilityHandleBinder;", "Lcom/obric/capabilitykit/common/ICapabilityActionHandler$Stub;", "shouldEnsureCaller", "", "(Z)V", "doJobInternal", "", "calling", "Lcom/obric/capabilitykit/common/execution/IntentCalling;", "messageId", "", "jobId", "(Lcom/obric/capabilitykit/common/execution/IntentCalling;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureCaller", "getVersion", "", "handleAction", "s", "handleIntentCalling", "isTaskRunning", "onTransact", "code", "data", "Landroid/os/Parcel;", "reply", "flags", "openUriFile", "uri", "Landroid/net/Uri;", "forReceiver", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "receiverPackage", "stopAction", WindowEvent.Params.REASON, "stopComplexTask", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class CapabilityHandleBinder extends ICapabilityActionHandler.Stub {
        private final boolean shouldEnsureCaller;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder", f = "CapabilityHandleService.kt", i = {0, 0}, l = {118}, m = "doJobInternal", n = {"messageId", "jobId"}, s = {"L$0", "L$1"})
        public static final class a extends ContinuationImpl {
            public Object a;
            public Object b;
            public /* synthetic */ Object c;
            public final /* synthetic */ CapabilityHandleBinder d;
            public int e;

            public a(CapabilityHandleBinder r1, Continuation<? super a> r2) {
                this.d = r1;
                super(r2);
            }

            public final Object invokeSuspend(Object r2) {
                this.c = r2;
                this.e |= Integer.MIN_VALUE;
                return CapabilityHandleBinder.access$doJobInternal(this.d, null, null, null, this);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/Pair;", "", "Lkotlinx/coroutines/Job;", "it", "", "invoke", "(Lkotlin/Pair;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        public static final class b extends Lambda implements Function1<Pair<? extends String, ? extends Job>, Boolean> {
            public final /* synthetic */ String a;

            public b(String r1) {
                this.a = r1;
                super(1);
            }

            public final Boolean a(Pair<String, ? extends Job> r2) {
                Intrinsics.checkNotNullParameter(r2, "it");
                return Boolean.valueOf(Intrinsics.areEqual(r2.getFirst(), this.a));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return a((Pair) r1);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/Pair;", "", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "it", "", "invoke", "(Lkotlin/Pair;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        public static final class c extends Lambda implements Function1<Pair<? extends String, ? extends IntentFunction<?, ?>>, Boolean> {
            public final /* synthetic */ String a;

            public c(String r1) {
                this.a = r1;
                super(1);
            }

            public final Boolean a(Pair<String, ? extends IntentFunction<?, ?>> r2) {
                Intrinsics.checkNotNullParameter(r2, "it");
                return Boolean.valueOf(Intrinsics.areEqual(r2.getFirst(), this.a));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return a((Pair) r1);
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "byte", "", "invoke", "(B)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        public static final class d extends Lambda implements Function1<Byte, CharSequence> {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
                super(1);
            }

            public final CharSequence a(byte r4) {
                return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r4)}, 1));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return a(((Number) r1).byteValue());
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleAction$1$1$1", f = "CapabilityHandleService.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
        public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ IMAppAction b;

            public e(IMAppAction r1, Continuation<? super e> r2) {
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

            public final Object invokeSuspend(Object r8) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r8);
            L13:
                IMAppAction r9 = (IMAppAction) r8;
                Logger.INSTANCE.i(CapabilityHandleService.TAG, "sendActionExecuteResult: " + this.b.getQuestionId() + ' ' + r9.getContent());
                AtomicCapabilitySdk.INSTANCE.sendActionExecuteResult$capabilitykit_release(r9);
            L15:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r8);
                if (this.b.getReplyId() != 0) goto L15;
                ActionDispatcher r10 = ActionDispatcher.INSTANCE;
                IMAppAction r2 = this.b;
                this.a = 1;
                r8 = r10.onActionReceived(r2, this);
                if (r8 != r0) goto L13;
                return r0;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleIntentCalling$1$1$job$1", f = "CapabilityHandleService.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
        public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ CapabilityHandleBinder b;
            public final /* synthetic */ IntentCalling c;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;

            public f(CapabilityHandleBinder r1, IntentCalling r2, String r3, String r4, Continuation<? super f> r5) {
                this.b = r1;
                this.c = r2;
                this.d = r3;
                this.e = r4;
                super(2, r5);
            }

            public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new f(this.b, this.c, this.d, this.e, r8);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return a((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r6);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                CapabilityHandleBinder r7 = this.b;
                IntentCalling r2 = this.c;
                String r3 = this.d;
                String r4 = this.e;
                this.a = 1;
                if (CapabilityHandleBinder.access$doJobInternal(r7, r2, r3, r4, this) != r0) goto L12;
                return r0;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleIntentCalling$1$1$job$2", f = "CapabilityHandleService.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
        public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ CapabilityHandleBinder b;
            public final /* synthetic */ IntentCalling c;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;

            public g(CapabilityHandleBinder r1, IntentCalling r2, String r3, String r4, Continuation<? super g> r5) {
                this.b = r1;
                this.c = r2;
                this.d = r3;
                this.e = r4;
                super(2, r5);
            }

            public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new g(this.b, this.c, this.d, this.e, r8);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return a((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r6);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                CapabilityHandleBinder r7 = this.b;
                IntentCalling r2 = this.c;
                String r3 = this.d;
                String r4 = this.e;
                this.a = 1;
                if (CapabilityHandleBinder.access$doJobInternal(r7, r2, r3, r4, this) != r0) goto L12;
                return r0;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$openUriFile$1$1", f = "CapabilityHandleService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ Uri b;
            public final /* synthetic */ IUriFileReceiver c;
            public final /* synthetic */ String d;
            public final /* synthetic */ int e;

            public h(Uri r1, IUriFileReceiver r2, String r3, int r4, Continuation<? super h> r5) {
                this.b = r1;
                this.c = r2;
                this.d = r3;
                this.e = r4;
                super(2, r5);
            }

            public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new h(this.b, this.c, this.d, this.e, r8);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return a((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r12) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.a != 0) goto L15;
                ResultKt.throwOnFailure(r12);
                Logger.INSTANCE.d(CapabilityHandleService.TAG, "openUriFile: " + this.b + "; opening for receiver: " + this.c);
                y r13 = new y(this.b, this.c, this.d);
                int r0 = this.e;
                AssetFileDescriptor r2 = ContentResolverWrapper.openAssetFileDescriptor(AppHost.Companion.getApplication().getContentResolver(), r13.a, "r");     // Catch: Exception -> L7
            L9:
                if (r2 != null) goto L11;
                Logger.INSTANCE.w("UriFileOpener", "openFd = null; UriFileOpener: " + r13.c + " ---> URI " + r13.a);
                CoroutineScope r5 = ActionDispatcher.INSTANCE.getScope();
                Function2 r8 = new u$b(r13, null);
            L12:
                BuildersKt.launch$default(r5, null, null, r8, 3, null);
                return Unit.INSTANCE;
            L11:
                r5 = ActionDispatcher.INSTANCE.getScope();
                r8 = new u$c(r2, r13, r0, null);
            L7:
                e = move-exception;
                Logger.INSTANCE.e("UriFileOpener", "failed to open URI " + r13.a + " (for " + r13.c + "); e=" + e, e);
                r2 = null;
                goto L9
            L15:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$stopAction$1$1$1", f = "CapabilityHandleService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;

            public i(String r1, String r2, String r3, Continuation<? super i> r4) {
                this.b = r1;
                this.c = r2;
                this.d = r3;
                super(2, r4);
            }

            public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new i(this.b, this.c, this.d, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return a((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r8) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.a != 0) goto L25;
                ResultKt.throwOnFailure(r8);
                t r9 = t.a;
                String r0 = this.b;
                String r1 = this.c;
                String r2 = this.d;
                r9.getClass();
                Intrinsics.checkNotNullParameter(r0, "messageId");
                Intrinsics.checkNotNullParameter(r1, WindowEvent.Params.REASON);
                Intrinsics.checkNotNullParameter(r2, "jobId");
                Logger.INSTANCE.i("IntentExecutor", "ready to cancel task messageId " + r0 + ", reason=" + r1);
                t.d r10 = t.c;
                monitor-enter(r10);
                Set r3 = (Set) r10.get(r0);     // Catch: Throwable -> L21
                Pair r4 = null;
                Object r5 = null;
                if (r3 == null) goto L15;
                Iterator r6 = r3.iterator();     // Catch: Throwable -> L21
            L10:
                if (r6.hasNext() == false) goto L14;
                Object r7 = r6.next();     // Catch: Throwable -> L21
                if (Intrinsics.areEqual(((Pair) r7).getFirst(), r2) == false) goto L10;
                r5 = r7;
            L14:
                r4 = (Pair) r5;     // Catch: Throwable -> L21
            L15:
                monitor-exit(r10);
                if (r4 == null) goto L18;
                boolean r11 = ((IntentFunction) r4.getSecond()).cancelTask(r1);
                Logger.INSTANCE.i("IntentExecutor", "Task cancellation for messageId " + r0 + ", jobId " + r2 + ": " + r11 + ", reason=" + r1);
            L20:
                return Unit.INSTANCE;
            L18:
                Logger.INSTANCE.w("IntentExecutor", "No targetIntent found for messageId " + r0);
            L21:
                th = move-exception;
                throw th;
            L25:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public CapabilityHandleBinder(boolean r1) {
            this.shouldEnsureCaller = r1;
        }

        public static /* synthetic */ boolean a(Function1 r0, Object r1) {
            return doJobInternal$lambda$10$lambda$8(r0, r1);
        }

        public static final /* synthetic */ Object access$doJobInternal(CapabilityHandleBinder r0, IntentCalling r1, String r2, String r3, Continuation r4) {
            return r0.doJobInternal(r1, r2, r3, r4);
        }

        public static /* synthetic */ boolean b(Function1 r0, Object r1) {
            return doJobInternal$lambda$10$lambda$9(r0, r1);
        }

        private static final boolean doJobInternal$lambda$10$lambda$8(Function1 r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "$tmp0");
            return ((Boolean) r1.invoke(r2)).booleanValue();
        }

        private static final boolean doJobInternal$lambda$10$lambda$9(Function1 r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "$tmp0");
            return ((Boolean) r1.invoke(r2)).booleanValue();
        }

        private final boolean ensureCaller() {
            if (this.shouldEnsureCaller == true) goto L5;
            return true;
        L5:
            PackageManager r0 = AppHost.Companion.getApplication().getPackageManager();
            if (r0.checkSignatures(SearchError.ERR_UNKNOWN, Binder.getCallingUid()) != 0) goto L8;
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
            List r6 = (List) CapabilityHandleService.access$getALLOWED_PACKAGES$cp().get(r3);
            if (r3 != null) goto L24;
        L27:
            boolean r7 = true;
        L29:
            if (r7 == true) goto L48;
            if (r6 != null) goto L32;
        L35:
            boolean r8 = true;
        L36:
            if (r8 == true) goto L48;
            Signature[] r1 = r0.getPackageInfo(r3, 64).signatures;     // Catch: PackageManager.NameNotFoundException -> L46
            MessageDigest r9 = MessageDigest.getInstance("SHA-256");     // Catch: PackageManager.NameNotFoundException -> L46
            int r10 = r1.length;     // Catch: PackageManager.NameNotFoundException -> L46
            int r11 = 0;
        L39:
            if (r11 >= r10) goto L48;
            r9.update(r1[r11].toByteArray());     // Catch: PackageManager.NameNotFoundException -> L46
            if (r6.contains(ArraysKt.joinToString$default(r9.digest(), "", null, null, 0, null, d.a, 30, null)) == true) goto L44;
            r11 = r11 + 1;
            goto L39
        L44:
            return true;
        L46:
            e = move-exception;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "ensureCaller failed", e);
            goto L48
        L32:
            if (r6.isEmpty() == true) goto L35;
            r8 = false;
        L48:
            Logger.INSTANCE.e(CapabilityHandleService.TAG, r3 + " not in allowed packages");
            return false;
        L24:
            if (r3.length() == 0) goto L27;
            r7 = false;
            goto L29
        L16:
            if (PackageUtils.INSTANCE.isPrivilegedApp(r3) != true) goto L18;
            r5 = true;
            goto L19
        }

        public int getVersion() {
            return 1;
        }

        public boolean handleAction(String r8) {
            Logger r2 = Logger.INSTANCE;
            r2.w(CapabilityHandleService.TAG, "handleAction: AppAction is deprecated and is replaced by the AppIntent framework.");
            r2.d(CapabilityHandleService.TAG, "doAction: " + r8);     // Catch: Throwable -> L13
            IMAppAction r9 = (IMAppAction) UtilsKt.a().fromJson(r8, IMAppAction.class);     // Catch: Throwable -> L13
            if (r9 == null) goto L10;
            StringBuilder r1 = new StringBuilder("doAction questionId:");     // Catch: Throwable -> L13
            r1.append(r9.getQuestionId());     // Catch: Throwable -> L13
            r1.append(", dispatchStarted=");     // Catch: Throwable -> L13
            ActionDispatcher r0 = ActionDispatcher.INSTANCE;     // Catch: Throwable -> L13
            r1.append(r0.getDispatchStartedQuestion());     // Catch: Throwable -> L13
            r2.i(CapabilityHandleService.TAG, r1.toString());     // Catch: Throwable -> L13
            Long r3 = r9.getQuestionId();     // Catch: Throwable -> L13
            if (r3 == null) goto L8;
            long r4 = r3.longValue();     // Catch: Throwable -> L13
        L9:
            r0.launchWithTrace(r4, new e(r9, null));     // Catch: Throwable -> L13
            goto L10
        L8:
            r4 = -1;
        L10:
            if (r9 == null) goto L20;
            return true;
        L20:
            return false;
        L13:
            th = move-exception;
            Throwable r10 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (r10 == null) goto L17;
            Logger.INSTANCE.i(CapabilityHandleService.TAG, "handleAction fail: " + ExceptionsKt.stackTraceToString(r10));
        L17:
            return false;
        }

        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            Intrinsics.checkNotNullParameter(r5, "data");
        L9:
            th = move-exception;
            Logger.INSTANCE.w(CapabilityHandleService.TAG, "onTransact throws error. It is likely that an error occurred during parameter transferring. th=" + th, th);
            throw th;
        L4:
            if (ensureCaller() == true) goto L8;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "onTransact " + r4 + ", caller not matched.");     // Catch: Throwable -> L9
            return false;
        L8:
            return super.onTransact(r4, r5, r6, r7);
        }

        public boolean openUriFile(Uri r19, IUriFileReceiver r20, String r21) {
            if (ensureCaller() == true) goto L24;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "openUriFile: " + r19 + ", caller not matched.");
            return false;
        L24:
            Logger r2 = Logger.INSTANCE;     // Catch: Throwable -> L19
            r2.d(CapabilityHandleService.TAG, "openUriFile: " + r19 + ", receiver: " + r20 + ", receiverPackage&Pid: " + r21);     // Catch: Throwable -> L19
            if (r19 == null) goto L17;
            if (r20 == null) goto L17;
            if (r21 == null) goto L17;
            List r1 = StringsKt.split$default(r21, new String[]{";"}, false, 0, 6, null);     // Catch: Throwable -> L19
            if (r1.size() == 2) goto L15;
            r2.e(CapabilityHandleService.TAG, "openUriFile: " + r19 + ", unknown receiver pid");     // Catch: Throwable -> L19
            return false;
        L15:
            BuildersKt.launch$default(ActionDispatcher.INSTANCE.getScope(), null, null, new h(r19, r20, (String) r1.get(0), Integer.parseInt((String) r1.get(1)), null), 3, null);     // Catch: Throwable -> L19
            return true;
        L17:
            r2.e(CapabilityHandleService.TAG, "openUriFile: " + r19 + ", invalid params.");     // Catch: Throwable -> L19
            return false;
        L19:
            th = move-exception;
            Throwable r0 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (r0 == null) goto L23;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "openUriFile fail: " + ExceptionsKt.stackTraceToString(r0));
        L23:
            return false;
        }

        public boolean stopComplexTask(String r2) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            return stopAction(r2, "user stop in complex task");
        }

        public boolean handleIntentCalling(IntentCalling r14) {
            Logger r4 = Logger.INSTANCE;     // Catch: Throwable -> L36
            StringBuilder r6 = new StringBuilder("doIntent: name=");     // Catch: Throwable -> L36
            String r2 = null;
            if (r14 == null) goto L8;
            String r7 = r14.f;     // Catch: Throwable -> L36
        L9:
            r6.append(r7);     // Catch: Throwable -> L36
            r4.d(CapabilityHandleService.TAG, r6.toString());     // Catch: Throwable -> L36
            if (r14 != null) goto L12;
        L33:
            if (r14 == null) goto L44;
            return true;
        L44:
            return false;
        L12:
            r4.i(CapabilityHandleService.TAG, "handleIntentCalling questionId:" + r14.a);     // Catch: Throwable -> L36
            String r1 = String.valueOf(r14.a);     // Catch: Throwable -> L36
            String r5 = UUID.randomUUID().toString();     // Catch: Throwable -> L36
            r4.i(CapabilityHandleService.TAG, "handleIntentCalling jobId: " + r5);     // Catch: Throwable -> L36
            Map r0 = r14.k;     // Catch: Throwable -> L36
            if (r0 == null) goto L18;
            r2 = (String) r0.get(Ext.KEY_IS_PARALLEL);     // Catch: Throwable -> L36
        L18:
            if (Intrinsics.areEqual(r2, "true") == false) goto L21;
            CoroutineScope r3 = ActionDispatcher.INSTANCE.getParallelScope();     // Catch: Throwable -> L36
            Function2 r8 = new f(this, r14, r1, r5, null);     // Catch: Throwable -> L36
        L22:
            Job r9 = BuildersKt.launch$default(r3, null, null, r8, 3, null);     // Catch: Throwable -> L36
            com.obric.capabilitykit.c.b r10 = com.obric.capabilitykit.c.e;     // Catch: Throwable -> L36
            monitor-enter(r10);     // Catch: Throwable -> L36
            Object r11 = r10.get(r1);     // Catch: Throwable -> L30
            if (r11 != null) goto L27;
            r11 = new LinkedHashSet();     // Catch: Throwable -> L30
            r10.put(r1, r11);     // Catch: Throwable -> L30
        L27:
            ((Set) r11).add(TuplesKt.to(r5, r9));     // Catch: Throwable -> L30
            monitor-exit(r10);     // Catch: Throwable -> L36
            goto L33
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L36
        L21:
            r3 = ActionDispatcher.INSTANCE.getScope();     // Catch: Throwable -> L36
            r8 = new g(this, r14, r1, r5, null);     // Catch: Throwable -> L36
            goto L22
        L8:
            r7 = null;
        L36:
            th = move-exception;
            Throwable r15 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (r15 == null) goto L40;
            Logger.INSTANCE.i(CapabilityHandleService.TAG, "handleIntentCalling fail: " + ExceptionsKt.stackTraceToString(r15));
        L40:
            return false;
        }

        public int isTaskRunning(String r6, String r7) {
            Intrinsics.checkNotNullParameter(r6, "messageId");
            Intrinsics.checkNotNullParameter(r7, "jobId");
            com.obric.capabilitykit.c.b r0 = com.obric.capabilitykit.c.e;
            monitor-enter(r0);
            Set r1 = (Set) r0.get(r6);     // Catch: Throwable -> L27
            if (r1 == null) goto L24;
            Iterator r2 = r1.iterator();     // Catch: Throwable -> L27
        L8:
            if (r2.hasNext() == false) goto L12;
            Object r3 = r2.next();     // Catch: Throwable -> L27
            if (Intrinsics.areEqual(((Pair) r3).getFirst(), r7) == false) goto L8;
        L13:
            Pair r4 = (Pair) r3;     // Catch: Throwable -> L27
            if (r4 == null) goto L24;
            Job r5 = (Job) r4.component2();     // Catch: Throwable -> L27
            int r8 = 1;
            if (r5.isActive() == false) goto L18;
            Job.DefaultImpls.cancel$default(r5, null, 1, null);     // Catch: Throwable -> L27
        L18:
            t.a.getClass();     // Catch: Throwable -> L27
            Boolean r9 = t.c(r6, r7);     // Catch: Throwable -> L27
            if (Intrinsics.areEqual(r9, Boolean.TRUE) == true) goto L25;
            if (Intrinsics.areEqual(r9, Boolean.FALSE) == false) goto L24;
            r8 = 2;
        L25:
            monitor-exit(r0);
            return r8;
        L12:
            r3 = null;
        L24:
            r8 = 0;
        L27:
            th = move-exception;
            throw th;
        }

        public boolean stopAction(String r14, String r15) {
            Intrinsics.checkNotNullParameter(r14, "messageId");
            Intrinsics.checkNotNullParameter(r15, WindowEvent.Params.REASON);
            Logger r0 = Logger.INSTANCE;
            StringBuilder r1 = new StringBuilder("stopAction: ");
            r1.append(r14);
            r1.append(" reason: ");
            r1.append(r15);
            r1.append(" jobMap ");
            com.obric.capabilitykit.c.b r2 = com.obric.capabilitykit.c.e;
            r1.append(r2);
            r0.d(CapabilityHandleService.TAG, r1.toString());
            monitor-enter(r2);
            Set r3 = (Set) r2.get(r14);     // Catch: Throwable -> L19
            boolean r4 = true;
            if (r3 == null) goto L13;
            Iterator r5 = r3.iterator();     // Catch: Throwable -> L19
        L8:
            if (r5.hasNext() == false) goto L13;
            Pair r6 = (Pair) r5.next();     // Catch: Throwable -> L19
            String r7 = (String) r6.component1();     // Catch: Throwable -> L19
            Job r8 = (Job) r6.component2();     // Catch: Throwable -> L19
            if (r8.isActive() == false) goto L12;
            Job.DefaultImpls.cancel$default(r8, null, 1, null);     // Catch: Throwable -> L19
        L12:
            BuildersKt.launch$default(ActionDispatcher.INSTANCE.getScope(), null, null, new i(r14, r15, r7, null), 3, null);     // Catch: Throwable -> L19
        L13:
            if (com.obric.capabilitykit.c.e.remove(r14) != null) goto L17;
            r4 = false;
        L17:
            monitor-exit(r2);
            return r4;
        L19:
            th = move-exception;
            throw th;
        }

        private final Object doJobInternal(IntentCalling r6, String r7, String r8, Continuation<? super Unit> r9) {
            if ((r9 instanceof a) == false) goto L7;
            a r1 = (a) r9;
            int r2 = r1.e;
            if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
            r1.e = r2 - Integer.MIN_VALUE;
        L8:
            Object r10 = r1.c;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r1.e;
            if (r4 == 0) goto L14;
            if (r4 != 1) goto L13;
            r8 = (String) r1.b;
            r7 = (String) r1.a;
            ResultKt.throwOnFailure(r10);
        L17:
            Pair r11 = (Pair) r10;
            IntentResult r12 = (IntentResult) r11.getFirst();
            AtomicCapabilitySdk.INSTANCE.sendIntentExecutionResult$capabilitykit_release(r12, (IMAppAction) r11.getSecond());
            if (r12.isFinal() == false) goto L64;
            com.obric.capabilitykit.c.b r13 = com.obric.capabilitykit.c.e;
            monitor-enter(r13);
        L60:
            th = move-exception;
            throw th;
        L23:
            Logger.INSTANCE.i(CapabilityHandleService.TAG, "doJobInternal jobId: " + r8 + " isFinal = true " + r13);     // Catch: Throwable -> L60
            if (Build.VERSION.SDK_INT < 24) goto L31;
            Set r14 = (Set) r13.get(r7);     // Catch: Throwable -> L60
            if (r14 == null) goto L28;
            final b r0 = new b(r8);     // Catch: Throwable -> L60
            Boxing.boxBoolean(r14.removeIf(new wia.c(r0)));     // Catch: Throwable -> L60
        L28:
            t.a.getClass();     // Catch: Throwable -> L60
            Set r15 = (Set) t.c.get(r7);     // Catch: Throwable -> L60
            if (r15 == null) goto L58;
            final c r16 = new c(r8);     // Catch: Throwable -> L60
            Boxing.boxBoolean(r15.removeIf(new wia.d(r16)));     // Catch: Throwable -> L60
        L58:
            monitor-exit(r13);
            goto L64
        L31:
            Set r17 = (Set) r13.get(r7);     // Catch: Throwable -> L60
            Iterator r5 = null;
            if (r17 == null) goto L34;
            Iterator r18 = r17.iterator();     // Catch: Throwable -> L60
        L36:
            if (r18 != null) goto L38;
        L40:
            boolean r19 = false;
        L41:
            if (r19 == false) goto L45;
            if (Intrinsics.areEqual(((Pair) r18.next()).getFirst(), r8) == false) goto L36;
            r18.remove();     // Catch: Throwable -> L60
            goto L36
        L45:
            t.a.getClass();     // Catch: Throwable -> L60
            Set r20 = (Set) t.c.get(r7);     // Catch: Throwable -> L60
            if (r20 == null) goto L48;
            r5 = r20.iterator();     // Catch: Throwable -> L60
        L48:
            if (r5 != null) goto L50;
        L52:
            boolean r21 = false;
        L53:
            if (r21 == false) goto L58;
            if (Intrinsics.areEqual(((Pair) r5.next()).getFirst(), r8) == false) goto L48;
            r5.remove();     // Catch: Throwable -> L60
            goto L48
        L50:
            if (r5.hasNext() != true) goto L52;
            r21 = true;
            goto L53
        L38:
            if (r18.hasNext() != true) goto L40;
            r19 = true;
            goto L41
        L34:
            r18 = null;
        L64:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r10);
            s r22 = s.a;
            r1.a = r7;
            r1.b = r8;
            r1.e = 1;
            r10 = r22.a(r6, r8, r1);
            if (r10 != r3) goto L17;
            return r3;
        L7:
            r1 = new a(this, r9);
            goto L8
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        ALLOWED_PACKAGES = MapsKt.mapOf(TuplesKt.to("com.larus.nova", CollectionsKt.listOf("ff04b47ec9dd20b79f758af67a184926db00ac55cfd2a01e03fba9a1dca9de2a")));
    }

    public CapabilityHandleService() {
        this.binder = new CapabilityHandleBinder(true);
    }

    public static final /* synthetic */ Map access$getALLOWED_PACKAGES$cp() {
        return ALLOWED_PACKAGES;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        Logger.INSTANCE.i(TAG, "onBind");
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        AppHost.Companion.setAppHost(new u(getApplication()));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger.INSTANCE.i(TAG, "onDestroy");
    }
}
