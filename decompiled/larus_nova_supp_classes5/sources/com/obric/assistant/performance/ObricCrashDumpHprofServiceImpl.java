package com.obric.assistant.performance;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricCrashDumpHprofConfig;
import com.obric.assistant.t1;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J2\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0002J \u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0002¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/performance/ObricCrashDumpHprofServiceImpl;", "Lcom/obric/assistant/performance/IObricCrashDumpHprofService;", "<init>", "()V", "init", "", "handleCrash", EffectConfiguration.KEY_TYPE, "Lcom/bytedance/crash/CrashType;", "crash", "", "thread", "Ljava/lang/Thread;", "crashStackPatterns", "", "matchCrashStack", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricCrashDumpHprofServiceImpl implements IObricCrashDumpHprofService {
    public static final Set<String> b = null;

    /* JADX INFO: renamed from: com.obric.assistant.performance.ObricCrashDumpHprofServiceImpl$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.performance.ObricCrashDumpHprofServiceImpl$init$1", f = "ObricCrashDumpHprofServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricCrashDumpHprofServiceImpl this$0;

        public AnonymousClass1(ObricCrashDumpHprofServiceImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L34;
            ResultKt.throwOnFailure(r6);
            ObricCrashDumpHprofConfig r7 = t1.a.getObricCrashDumpHprofConfig();     // Catch: Exception -> L29
            FLogger r2 = FLogger.a;     // Catch: Exception -> L29
            r2.i("ObricCrashDumpHprofServiceImpl", "init, config=" + r7);     // Catch: Exception -> L29
            if (r7.getEnableJavaCrashDump() == true) goto L9;
            r2.i("ObricCrashDumpHprofServiceImpl", "init ignored, crash dump disabled");     // Catch: Exception -> L29
            return Unit.INSTANCE;
        L9:
            List r8 = r7.getJavaCrashStackPattern();     // Catch: Exception -> L29
            if (r8 != null) goto L12;
            r8 = CollectionsKt.emptyList();     // Catch: Exception -> L29
        L12:
            Set r9 = SetsKt.plus(ObricCrashDumpHprofServiceImpl.b, r8);     // Catch: Exception -> L29
            ArrayList r1 = new ArrayList();     // Catch: Exception -> L29
            Iterator r10 = r9.iterator();     // Catch: Exception -> L29
        L14:
            if (r10.hasNext() == false) goto L27;
            String r3 = (String) r10.next();     // Catch: Exception -> L29
            String r4 = null;
            if (r3 == null) goto L25;
            String r5 = StringsKt.trim(r3).toString();     // Catch: Exception -> L29
            if (r5 == null) goto L25;
            if (r5.length() <= 0) goto L22;
            boolean r11 = true;
        L23:
            if (r11 == false) goto L25;
            r4 = r5;
            goto L25
        L22:
            r11 = false;
        L25:
            if (r4 == null) goto L14;
            r1.add(r4);     // Catch: Exception -> L29
            goto L14
        L27:
            final Set r12 = CollectionsKt.toSet(r1);     // Catch: Exception -> L29
            FLogger r13 = FLogger.a;     // Catch: Exception -> L29
            r13.i("ObricCrashDumpHprofServiceImpl", "init, crashStackPatterns=" + r12);     // Catch: Exception -> L29
            final ObricCrashDumpHprofServiceImpl r14 = this.this$0;     // Catch: Exception -> L29
            Npth.registerCrashCallback(new d(r14, r12), CrashType.JAVA);     // Catch: Exception -> L29
            r13.i("ObricCrashDumpHprofServiceImpl", "init success");     // Catch: Exception -> L29
        L32:
            return Unit.INSTANCE;
        L29:
            e = move-exception;
            FLogger.a.e("ObricCrashDumpHprofServiceImpl", "init error: " + e);
            goto L32
        L34:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ObricCrashDumpHprofServiceImpl() {
    }

    static {
        b = SetsKt.setOf("recycled bitmap");
    }

    public final void init() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(this, null), 3, null);
    }
}
