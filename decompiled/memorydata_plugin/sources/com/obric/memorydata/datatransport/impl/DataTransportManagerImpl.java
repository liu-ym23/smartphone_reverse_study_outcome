package com.obric.memorydata.datatransport.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.datatransport.activity.DataExportActivity;
import com.obric.memorydata.datatransport.api.DataTransportManagerApi;
import com.obric.memorydata.datatransport.api.MemoryBuildExportRequest;
import com.obric.memorydata.datatransport.api.b;
import com.obric.memorydata.datatransport.api.e;
import com.obric.memorydata.datatransport.transfer.buildmemory.MemoryBuildDataPackageActivity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.migration.sdk.z;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0000H\u0007J)\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H\u0002¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\"\u0010#\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020*0)J\u000e\u0010+\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/datatransport/impl/DataTransportManagerImpl;", "Lcom/obric/memorydata/datatransport/api/DataTransportManagerApi;", "<init>", "()V", "TAG", "", "exportScope", "Lkotlinx/coroutines/CoroutineScope;", "mainHandler", "Landroid/os/Handler;", "getInst", "isUTDataCollectEnabled", "", "()Z", "setUTDataCollectEnabled", "(Z)V", "extensions", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/memorydata/datatransport/api/DataTransportExtension;", TypedValues.Custom.S_STRING, "resId", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "register", "", "extension", "unregister", "isDataExportEntryEnabled", "startExportActivity", "context", "Landroid/content/Context;", "startMemoryBuildDataPackageActivity", "exportBuildMemoryPackage", Ext.KEY_REQUEST, "Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;", "callback", "Lcom/obric/memorydata/datatransport/api/MemoryBuildExportCallback;", "getAllExportPaths", "", "Ljava/io/File;", "cleanAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataTransportManagerImpl implements DataTransportManagerApi {
    public static final DataTransportManagerImpl INSTANCE = null;
    private static final String TAG = "DataTransportManagerImpl";
    private static final al exportScope = null;
    private static final CopyOnWriteArrayList<b> extensions = null;
    private static volatile boolean isUTDataCollectEnabled;
    private static final Handler mainHandler = null;

    /* JADX INFO: renamed from: com.obric.memorydata.datatransport.impl.DataTransportManagerImpl$cleanAll$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.datatransport.impl.DataTransportManagerImpl", f = "DataTransportManagerImpl.kt", i = {0, 0, 0, 0, 0}, l = {158}, m = "cleanAll", n = {"this", "sb", "extension", "successCount", "failCount"}, s = {"L$0", "L$1", "L$3", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DataTransportManagerImpl this$0;

        AnonymousClass1(DataTransportManagerImpl r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.cleanAll((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.datatransport.impl.DataTransportManagerImpl$exportBuildMemoryPackage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.datatransport.impl.DataTransportManagerImpl$exportBuildMemoryPackage$2", f = "DataTransportManagerImpl.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ e $callback;
        final /* synthetic */ Context $context;
        final /* synthetic */ MemoryBuildExportRequest $request;
        int label;

        AnonymousClass2(MemoryBuildExportRequest r3, e r4, Context r5, Continuation<? super AnonymousClass2> r6) {
            e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$request = r3;
            this.$callback = r7;
            this.$context = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
            super(2, r9);
        }

        private static final void invokeSuspend$lambda$1$lambda$0(e r2, z r3) {
            e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
            String r5 = ((File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r3, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin")).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(r5, "getAbsolutePath(...)");
            r4.a(r5);
        }

        private static final void invokeSuspend$lambda$3$lambda$2(e r2, String r3) {
            ((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin")).b(r3);
        }

        private static final void invokeSuspend$lambda$5$lambda$4(e r2, String r3) {
            ((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin")).b(r3);
        }

        public static /* synthetic */ void lambda$423tcNh4LoJ6CPteiMtN2Mr2MPo(e r0, String r1) {
            invokeSuspend$lambda$5$lambda$4(r0, r1);
        }

        public static /* synthetic */ void lambda$TvWpWtfRWGFzwlPLwWivKwIRlzM(e r0, String r1) {
            invokeSuspend$lambda$3$lambda$2(r0, r1);
        }

        public static /* synthetic */ void lambda$Z6kPpMLJOVxliLgOveuUDEO4o6I(e r0, z r1) {
            invokeSuspend$lambda$1$lambda$0(r0, r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$request, this.$callback, this.$context, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L7
        L15:
            final z r15 = (z) ZeusTransformUtils.preCheckCast(r14, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            if (ZeusTransformUtils.instanceOf(r15, z.b.class) == false) goto L22;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransportManagerImpl.TAG, "exportBuildMemoryPackage success, path=" + ((File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r15, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin")).getAbsolutePath(), false, 4, null);     // Catch: Throwable -> L7
            final e r2 = this.$callback;     // Catch: Throwable -> L7
            if (r2 == null) goto L38;
            boolean r16 = DataTransportManagerImpl.access$getMainHandler$p().post(new $$Lambda$DataTransportManagerImpl$exportBuildMemoryPackage$2$Z6kPpMLJOVxliLgOveuUDEO4o6I(r2, r15));     // Catch: Throwable -> L7
        L20:
            Boxing.boxBoolean(r16);     // Catch: Throwable -> L7
        L38:
            return Unit.INSTANCE;
        L22:
            if (ZeusTransformUtils.instanceOf(r15, z.a.class) == false) goto L30;
            final String r17 = ((z.a) ZeusTransformUtils.preCheckCast(r15, z.a.class, "com.obric.memorydata.plugin")).a().b();     // Catch: Throwable -> L7
            if (r17 != null) goto L26;
            r17 = this.$context.getString(ZeusTransformUtils.mapRes(R.string.data_transport_export_failed_default, TypedValues.Custom.S_STRING, "data_transport_export_failed_default"));     // Catch: Throwable -> L7
            Intrinsics.checkNotNullExpressionValue(r17, "getString(...)");     // Catch: Throwable -> L7
        L26:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), DataTransportManagerImpl.TAG, "exportBuildMemoryPackage failed: " + r17, null, 4, null);     // Catch: Throwable -> L7
            final e r3 = this.$callback;     // Catch: Throwable -> L7
            if (r3 == null) goto L38;
            r16 = DataTransportManagerImpl.access$getMainHandler$p().post(new $$Lambda$DataTransportManagerImpl$exportBuildMemoryPackage$2$TvWpWtfRWGFzwlPLwWivKwIRlzM(r3, r17));     // Catch: Throwable -> L7
            goto L20
        L30:
            throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L7
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r14);
            com.obric.memorydata.datatransport.transfer.buildmemory.b r7 = com.obric.memorydata.datatransport.transfer.buildmemory.b.f9812a;     // Catch: Throwable -> L7
            MemoryBuildExportRequest r8 = this.$request;     // Catch: Throwable -> L7
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r14 = com.obric.memorydata.datatransport.transfer.buildmemory.b.a(r7, r8, null, r10, 2, null);     // Catch: Throwable -> L7
            if (r14 != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            final String r4 = th.getMessage();
            if (r4 != null) goto L34;
            r4 = this.$context.getString(ZeusTransformUtils.mapRes(R.string.data_transport_export_failed_default, TypedValues.Custom.S_STRING, "data_transport_export_failed_default"));
            Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        L34:
            RunLog.INSTANCE.error(DataTransportManagerImpl.TAG, "exportBuildMemoryPackage crashed", th);
            final e r13 = this.$callback;
            if (r13 == null) goto L38;
            Boxing.boxBoolean(DataTransportManagerImpl.access$getMainHandler$p().post(new $$Lambda$DataTransportManagerImpl$exportBuildMemoryPackage$2$423tcNh4LoJ6CPteiMtN2Mr2MPo(r13, r4)));
            goto L38
        }
    }

    static {
        INSTANCE = new DataTransportManagerImpl();
        exportScope = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        mainHandler = new Handler(Looper.getMainLooper());
        isUTDataCollectEnabled = true;
        extensions = new CopyOnWriteArrayList();
    }

    private DataTransportManagerImpl() {
    }

    public static final /* synthetic */ Handler access$getMainHandler$p() {
        return mainHandler;
    }

    private static final void exportBuildMemoryPackage$lambda$1$lambda$0(e r2) {
        ((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin")).a();
    }

    @JvmStatic
    public static final DataTransportManagerImpl getInst() {
        return INSTANCE;
    }

    public static /* synthetic */ void lambda$HPMo8lplPvSBJ_DnjhRTHusXztU(e r0) {
        exportBuildMemoryPackage$lambda$1$lambda$0(r0);
    }

    private final String string(int r3, Object... r4) {
        if (r4.length != 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r3);
    L10:
        Intrinsics.checkNotNull(r5);
        return r5;
    L9:
        r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r3, Arrays.copyOf(r4, r4.length));
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00e6 -> B:26:0x00e8). Please report as a decompilation issue!!! */
    public final Object cleanAll(Continuation<? super String> r23) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r1, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        boolean r9 = false;
        int r10 = 1;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        int r6 = r3.I$1;
        int r11 = r3.I$0;
        b r12 = (b) ZeusTransformUtils.preCheckCast(r3.L$3, b.class, "com.obric.memorydata.plugin");
        Iterator r13 = (Iterator) ZeusTransformUtils.preCheckCast(r3.L$2, Iterator.class, "com.obric.memorydata.plugin");
        StringBuilder r14 = (StringBuilder) ZeusTransformUtils.preCheckCast(r3.L$1, StringBuilder.class, "com.obric.memorydata.plugin");
        DataTransportManagerImpl r15 = (DataTransportManagerImpl) ZeusTransformUtils.preCheckCast(r3.L$0, DataTransportManagerImpl.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L14
    L26:
        boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Exception -> L14
        IRunLog r16 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        StringBuilder r7 = new StringBuilder().append("Cleaner result: ").append(r12.getClass().getSimpleName()).append(' ');     // Catch: Exception -> L14
        if (r0 == false) goto L29;
        boolean r8 = r10;
    L30:
        IRunLog.a.a(r16, TAG, r7.append(r8).toString(), false, 4, null);     // Catch: Exception -> L14
        r11 = r11 + 1;
        DataTransportManagerImpl r17 = r15;
    L20:
        if (r13.hasNext() == false) goto L37;
        r12 = (b) ZeusTransformUtils.preCheckCast(r13.next(), b.class, "com.obric.memorydata.plugin");
        r3.L$0 = r17;     // Catch: Exception -> L32
        r3.L$1 = r14;     // Catch: Exception -> L32
        r3.L$2 = r13;     // Catch: Exception -> L32
        r3.L$3 = r12;     // Catch: Exception -> L32
        r3.I$0 = r11;     // Catch: Exception -> L32
        r3.I$1 = r6;     // Catch: Exception -> L32
        r3.label = r10;     // Catch: Exception -> L32
        Object r18 = r12.a(r3);     // Catch: Exception -> L32
        if (r18 != r4) goto L25;
        return r4;
    L25:
        r15 = r17;
        r2 = r18;
    L32:
        e = e;
    L33:
        RunLog.INSTANCE.error(TAG, "Cleaner failed: " + r12.getClass().getSimpleName(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        int r19 = ZeusTransformUtils.mapRes(R.string.data_transport_clean_failed_item, TypedValues.Custom.S_STRING, "data_transport_clean_failed_item");
        Object[] r20 = new Object[2];
        r20[0] = r12.getClass().getSimpleName();
        String r21 = e.getMessage();
        if (r21 != null) goto L36;
        r10 = 1;
        r20[1] = r21;
        r14.append(r17.string(r19, r20)).append('\n');
        r6 = r6 + 1;
        r9 = false;
        goto L20
    L36:
        r10 = 1;
        r20[1] = "";
        r14.append(r17.string(r19, r20)).append('\n');
        r6 = r6 + 1;
        r9 = false;
        goto L20
    L37:
        int r22 = ZeusTransformUtils.mapRes(R.string.data_transport_clean_done, TypedValues.Custom.S_STRING, "data_transport_clean_done");
        Object[] r24 = new Object[2];
        r24[0] = Boxing.boxInt(r11);
        r24[r10] = Boxing.boxInt(r6);
        r14.append(r17.string(r22, r24));
        String r25 = r14.toString();
        Intrinsics.checkNotNullExpressionValue(r25, "toString(...)");
        return r25;
    L29:
        r8 = r9;
    L14:
        e = e;
        r17 = r15;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        StringBuilder r26 = new StringBuilder();
        r26.append(string(ZeusTransformUtils.mapRes(R.string.data_transport_clean_start, TypedValues.Custom.S_STRING, "data_transport_clean_start"), new Object[0])).append('\n');
        Iterator r27 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(extensions, Collection.class, "com.obric.memorydata.plugin")).iterator();
        Intrinsics.checkNotNullExpressionValue(r27, "iterator(...)");
        r14 = r26;
        r13 = r27;
        r6 = 0;
        r11 = 0;
        r17 = this;
    L7:
        r3 = new AnonymousClass1(this, r1);
        goto L8
    }

    @Override // com.obric.memorydata.datatransport.api.DataTransportManagerApi
    public void exportBuildMemoryPackage(Context r9, MemoryBuildExportRequest r10, e r11) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        final e r12 = (e) ZeusTransformUtils.wrapperContextForParams(r11, e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r10, Ext.KEY_REQUEST);
        if (r12 == null) goto L5;
        mainHandler.post(new $$Lambda$DataTransportManagerImpl$HPMo8lplPvSBJ_DnjhRTHusXztU(r12));
    L5:
        i.a(exportScope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r10, r12, r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final Map<String, File> getAllExportPaths() {
        Map<String, File> r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(extensions, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin");
        String r3 = r2.a();     // Catch: Exception -> L16
        if (r3 == null) goto L4;
        int r5 = 1;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        File r4 = new File(r3);     // Catch: Exception -> L16
        String r6 = r4.getName();     // Catch: Exception -> L16
    L12:
        if (r7.containsKey(r6) == false) goto L14;
        r6 = r4.getName() + '_' + r5;     // Catch: Exception -> L16
        r5 = r5 + 1;     // Catch: Exception -> L16
        goto L12
    L14:
        r7.put(r6, r4);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "Failed to get export paths from " + r2.getClass().getSimpleName(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L4
    L18:
        return r7;
    }

    @Override // com.obric.memorydata.datatransport.api.DataTransportManagerApi
    public boolean isDataExportEntryEnabled() {
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        boolean r5 = isUTDataCollectEnabled();
    L16:
        if (r5 == false) goto L18;
        return true;
    L18:
        if (com.obric.memorydata.database.c.b.f8850a.a() == false) goto L21;
        return true;
    L21:
        return false;
    L5:
        String r0 = AppContext.INSTANCE.getServerDeviceId();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
    L15:
        r5 = false;
        goto L16
    L11:
        if (AppSettingsManager.INSTANCE.getRecommendSettings().getCollectDid().contains(r0) == false) goto L15;
        if (isUTDataCollectEnabled() == false) goto L15;
        r5 = true;
        goto L16
    L8:
        r3 = false;
        goto L9
    }

    @Override // com.obric.memorydata.datatransport.api.DataTransportManagerApi
    public boolean isUTDataCollectEnabled() {
        return isUTDataCollectEnabled;
    }

    @Override // com.obric.memorydata.datatransport.api.DataTransportManagerApi
    public void register(b r2) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "extension");
        CopyOnWriteArrayList<b> r3 = extensions;
        if (r3.contains(r1) == true) goto L6;
        r3.add(r1);
        return;
    }

    @Override // com.obric.memorydata.datatransport.api.DataTransportManagerApi
    public void setUTDataCollectEnabled(boolean r1) {
        isUTDataCollectEnabled = r1;
    }

    @Override // com.obric.memorydata.datatransport.api.DataTransportManagerApi
    public void startExportActivity(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        ZeusTransformUtils.startActivity(r2, new Intent(r2, DataExportActivity.class), "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.datatransport.api.DataTransportManagerApi
    public void startMemoryBuildDataPackageActivity(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        MemoryBuildDataPackageActivity.Companion.a(r1);
    }

    @Override // com.obric.memorydata.datatransport.api.DataTransportManagerApi
    public void unregister(b r2) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "extension");
        extensions.remove(r1);
    }
}
