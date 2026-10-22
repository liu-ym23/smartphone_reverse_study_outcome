package com.obric.aikernel.model_preset.impl.decrypt;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model_decrypt.api.IDecryptFeature;
import com.obric.aikernel.model_decrypt.api.IDecryptFeatureKt;
import com.obric.aikernel.model_decrypt.api.callback.IKeyInfoDistribute;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelCert;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelCertKt;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelDecryptKt;
import com.obric.aikernel.model_preset.api.DecryptType;
import com.obric.aikernel.model_preset.api.PresetType;
import com.obric.aikernel.model_preset.impl.constant.PresetConstant;
import com.obric.aikernel.model_preset.impl.decrypt.api.IModelPresetDecrypt;
import com.obric.aikernel.model_preset.impl.ipc.OtherProcessDecryptUtils;
import com.obric.aikernel.model_preset.impl.preset_res.PresetResItem;
import com.obric.aikernel.model_preset.impl.preset_res.PresetResViewer;
import com.obric.aikernel.utils.e;
import com.obric.aikernel.utils.m;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.channels.f;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.q1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class PresetModelDecryptImpl implements IModelPresetDecrypt {
    public static final PresetModelDecryptImpl INSTANCE = null;
    private static final String TAG = "PresetModelDecryptImpl";
    private static final d<String> backgroundDecryptTaskChannel = null;
    private static final g1<Map<String, Boolean>> decryptingMapState = null;
    private static final d<String> foregroundDecryptTaskChannel = null;
    private static final AtomicBoolean inited = null;

    public static final class KeyInfoWrapper implements Closeable {
        private final String keyAlias;
        private final String keyInfo;

        public KeyInfoWrapper(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "keyAlias");
            Intrinsics.checkNotNullParameter(r11, "keyInfo");
            this.keyAlias = r10;
            this.keyInfo = r11;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L10
            if (this.keyAlias.length() <= 0) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L8;
            IModelCertKt.getModelCert().deleteAttestKey(this.keyAlias);     // Catch: Throwable -> L10
        L8:
            Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
            return;
        L5:
            r11 = false;
        L10:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            Result.m32constructorimpl(ResultKt.createFailure(th));
        }

        public final String getKeyAlias() {
            return this.keyAlias;
        }

        public final String getKeyInfo() {
            return this.keyInfo;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[PresetType.values().length];
            r10[PresetType.OS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r10[PresetType.Assets.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r10;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl$decryptModel$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl", f = "PresetModelDecryptImpl.kt", i = {0, 0}, l = {180}, m = "decryptModel", n = {"modelName", "presetResItem"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PresetModelDecryptImpl this$0;

        AnonymousClass1(PresetModelDecryptImpl r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return PresetModelDecryptImpl.access$decryptModel(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl$decryptPresetModelFile$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl", f = "PresetModelDecryptImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {270}, m = "decryptPresetModelFile", n = {"presetType", "modelName", "fileName", "fileTag", "presetKeyInfo", "presetPath", "decryptFile", "tempDecryptFile", "isDecryptToFile"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"})
    static final class C03681 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PresetModelDecryptImpl this$0;

        C03681(PresetModelDecryptImpl r10, Continuation<? super C03681> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return PresetModelDecryptImpl.access$decryptPresetModelFile(this.this$0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl$init$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl$init$1", f = "PresetModelDecryptImpl.kt", i = {2}, l = {66, 365, 82}, m = "invokeSuspend", n = {"modelName"}, s = {"L$0"})
    static final class C03691 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C03691(Continuation<? super C03691> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C03691(r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((C03691) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a0 -> B:16:0x002e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00c4 -> B:32:0x00c7). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L15;
            if (r12 == 1) goto L15;
            if (r12 == 2) goto L14;
            if (r12 != 3) goto L13;
            String r13 = (String) this.L$0;
            ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L10
        L32:
            Object r14 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L35:
            Throwable r15 = Result.m35exceptionOrNullimpl(r14);
            if (r15 == null) goto L38;
            AIKLog.INSTANCE.w(PresetModelDecryptImpl.TAG, "decrypt failed: " + r13 + ", " + r15.getMessage(), r15);
        L38:
            Result.m31boximpl(r14);
        L16:
            Object r16 = PresetModelDecryptImpl.access$getForegroundDecryptTaskChannel$p().e();
            if (g.i(r16) == false) goto L24;
            String r17 = (String) g.f(r16);
            if (r17 == null) goto L16;
            AIKLog.INSTANCE.d(PresetModelDecryptImpl.TAG, "pick foreground first: " + r17);
            PresetModelDecryptImpl r18 = PresetModelDecryptImpl.INSTANCE;
            this.L$0 = null;
            this.label = 1;
            if (PresetModelDecryptImpl.access$decryptModel(r18, r17, this) != r10) goto L16;
            return r10;
        L24:
            SelectImplementation r19 = new SelectImplementation(getContext());
            r19.e(PresetModelDecryptImpl.access$getForegroundDecryptTaskChannel$p().d(), new PresetModelDecryptImpl$init$1$1$1(null));
            r19.e(PresetModelDecryptImpl.access$getBackgroundDecryptTaskChannel$p().d(), new PresetModelDecryptImpl$init$1$1$2(null));
            this.L$0 = null;
            this.label = 2;
            r11 = r19.r(this);
            if (r11 != r10) goto L27;
            return r10;
        L27:
            r13 = (String) r11;
            if (r13 == null) goto L16;
            Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L10
            AIKLog.INSTANCE.d(PresetModelDecryptImpl.TAG, "decrypt: " + r13);     // Catch: Throwable -> L10
            PresetModelDecryptImpl r111 = PresetModelDecryptImpl.INSTANCE;     // Catch: Throwable -> L10
            this.L$0 = r13;     // Catch: Throwable -> L10
            this.label = 3;     // Catch: Throwable -> L10
            if (PresetModelDecryptImpl.access$decryptModel(r111, r13, this) != r10) goto L32;
            return r10;
        L10:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
            goto L35
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r11);
        L15:
            ResultKt.throwOnFailure(r11);
            goto L16
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl$requestKeyInfo$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl", f = "PresetModelDecryptImpl.kt", i = {0, 0, 1, 1, 1}, l = {333, 335}, m = "requestKeyInfo", n = {"modelName", "fileName", "modelName", "fileName", "keyAlias"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C03701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PresetModelDecryptImpl this$0;

        C03701(PresetModelDecryptImpl r10, Continuation<? super C03701> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return PresetModelDecryptImpl.access$requestKeyInfo(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl$waitingDecrypting$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl", f = "PresetModelDecryptImpl.kt", i = {0, 1}, l = {131, 137}, m = "waitingDecrypting", n = {"pendingModelStr", "pendingModelStr"}, s = {"L$0", "L$0"})
    static final class C03711 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PresetModelDecryptImpl this$0;

        C03711(PresetModelDecryptImpl r10, Continuation<? super C03711> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.waitingDecrypting(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl$waitingDecrypting$3, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl$waitingDecrypting$3", f = "PresetModelDecryptImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<Map<String, ? extends Boolean>, Continuation<? super Boolean>, Object> {
        final /* synthetic */ List<String> $pendingModelNames;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(List<String> r10, Continuation<? super AnonymousClass3> r11) {
            this.$pendingModelNames = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass3 r12 = new AnonymousClass3(this.$pendingModelNames, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Map<String, ? extends Boolean> r10, Continuation<? super Boolean> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Map<String, Boolean> r10, Continuation<? super Boolean> r11) {
            return ((AnonymousClass3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r10);
            Map r11 = (Map) this.L$0;
            Iterator<T> r12 = this.$pendingModelNames.iterator();
        L6:
            if (r12.hasNext() == false) goto L10;
            Object r13 = r12.next();
            if (r11.containsKey((String) r13) == false) goto L6;
        L11:
            if (r13 != null) goto L13;
            boolean r14 = true;
        L15:
            return Boxing.boxBoolean(r14);
        L13:
            r14 = false;
            goto L15
        L10:
            r13 = null;
            goto L11
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        PresetModelDecryptImpl r10 = new PresetModelDecryptImpl();
        INSTANCE = r10;
        inited = new AtomicBoolean(false);
        backgroundDecryptTaskChannel = f.b(Integer.MAX_VALUE, null, null, 6, null);
        foregroundDecryptTaskChannel = f.b(Integer.MAX_VALUE, null, null, 6, null);
        decryptingMapState = q1.a(MapsKt.emptyMap());
        r10.init();
    }

    private PresetModelDecryptImpl() {
    }

    public static final /* synthetic */ Object access$decryptModel(PresetModelDecryptImpl r10, String r11, Continuation r12) {
        return r10.decryptModel(r11, r12);
    }

    public static final /* synthetic */ Object access$decryptPresetModelFile(PresetModelDecryptImpl r10, PresetType r11, String r12, String r13, Continuation r14) {
        return r10.decryptPresetModelFile(r11, r12, r13, r14);
    }

    public static final /* synthetic */ d access$getBackgroundDecryptTaskChannel$p() {
        return backgroundDecryptTaskChannel;
    }

    public static final /* synthetic */ d access$getForegroundDecryptTaskChannel$p() {
        return foregroundDecryptTaskChannel;
    }

    public static final /* synthetic */ Object access$requestKeyInfo(PresetModelDecryptImpl r10, String r11, String r12, Continuation r13) {
        return r10.requestKeyInfo(r11, r12, r13);
    }

    private final void addDecryptTask(String r10, boolean r11) {
        AIKLog.INSTANCE.d(TAG, "addDecryptTask: modelName = " + r10 + ", isForegroundTask = " + r11);
        g1<Map<String, Boolean>> r12 = decryptingMapState;
        monitor-enter(r12);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(r12.getValue().get(r10), Boolean.valueOf(r11)) == true) goto L16;
        if (r11 == false) goto L9;
    L11:
        Map<String, Boolean> r13 = MapsKt.toMutableMap(r12.getValue());     // Catch: Throwable -> L19
        r13.put(r10, Boolean.valueOf(r11));     // Catch: Throwable -> L19
        r12.setValue(r13);     // Catch: Throwable -> L19
        if (r11 == false) goto L14;
        d<String> r14 = foregroundDecryptTaskChannel;     // Catch: Throwable -> L19
    L15:
        r14.E(r10);     // Catch: Throwable -> L19
        goto L16
    L14:
        r14 = backgroundDecryptTaskChannel;     // Catch: Throwable -> L19
        goto L15
    L9:
        if (r12.getValue().containsKey(r10) == false) goto L11;
    L16:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r12);
    }

    private final Object decryptModel(String r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r12 = (AnonymousClass1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        Iterator r17 = (Iterator) r12.L$3;
        Iterable r18 = (Iterable) r12.L$2;
        PresetResItem r19 = (PresetResItem) r12.L$1;
        String r20 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        String r21 = r20;
    L63:
    L42:
        th = move-exception;
        r10 = r21;
        Throwable th = th;
    L44:
        Result.Companion r110 = Result.Companion;
        Object r22 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L45:
        Throwable r23 = Result.m35exceptionOrNullimpl(r22);
        if (r23 == null) goto L48;
        AIKLog.INSTANCE.w(TAG, "decrypt failed: " + r10 + ", " + r23.getMessage(), r23);
    L48:
        g1<Map<String, Boolean>> r24 = decryptingMapState;
        monitor-enter(r24);
        Map<String, Boolean> r111 = MapsKt.toMutableMap(r24.getValue());     // Catch: Throwable -> L53
        r111.remove(r10);     // Catch: Throwable -> L53
        r24.setValue(r111);     // Catch: Throwable -> L53
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L53
        monitor-exit(r24);
        return r112;
    L53:
        th = move-exception;
        throw th;
    L33:
        if (r17.hasNext() == false) goto L37;
        String r25 = (String) r17.next();     // Catch: Throwable -> L42
        PresetModelDecryptImpl r26 = INSTANCE;     // Catch: Throwable -> L42
        PresetType r27 = r19.getPresetType();     // Catch: Throwable -> L42
        String r28 = r19.getModelName();     // Catch: Throwable -> L42
        r12.L$0 = r21;     // Catch: Throwable -> L42
        r12.L$1 = r19;     // Catch: Throwable -> L42
        r12.L$2 = r18;     // Catch: Throwable -> L42
        r12.L$3 = r17;     // Catch: Throwable -> L42
        r12.label = 1;     // Catch: Throwable -> L42
        if (r26.decryptPresetModelFile(r27, r28, r25, r12) != r15) goto L63;
        return r15;
    L37:
        r10 = r21;
    L38:
        r22 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L40:
        th = th;
    L14:
        th = th;
        r10 = r20;
        goto L44
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        g1<Map<String, Boolean>> r29 = decryptingMapState;
        monitor-enter(r29);
    L56:
        th = move-exception;
        throw th;
    L21:
        if (r29.getValue().containsKey(r10) == true) goto L25;
        AIKLog.INSTANCE.d(TAG, "not in decrypting list: " + r10);     // Catch: Throwable -> L56
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L56
        monitor-exit(r29);
        return r113;
    L25:
        Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L56
        monitor-exit(r29);
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L40
        PresetResItem r32 = PresetResViewer.INSTANCE.allPresetModelFiles().get(r10);     // Catch: Throwable -> L40
        if (r32 == null) goto L38;
        r18 = r32.getFileNameKeyInfoMap().keySet();     // Catch: Throwable -> L40
        r19 = r32;
        r21 = r10;
        r17 = r18.iterator();     // Catch: Throwable -> L40
    L7:
        r12 = new AnonymousClass1(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v115, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    private final Object decryptPresetModelFile(PresetType r26, String r27, String r28, Continuation<? super Boolean> r29) {
        PresetType r10 = r26;
        String r11 = r27;
        if ((r29 instanceof C03681) == false) goto L7;
        C03681 r12 = (C03681) r29;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L19;
        if (r16 != 1) goto L18;
        int r17 = r12.I$0;
        File r18 = (File) r12.L$7;
        File r19 = (File) r12.L$6;
        String r20 = (String) r12.L$5;
        String r21 = (String) r12.L$4;
        String r110 = (String) r12.L$3;
        String r111 = (String) r12.L$2;
        String r22 = (String) r12.L$1;
        PresetType r23 = (PresetType) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        String r24 = ", to = ";
        String r25 = "rename tempDecryptFile failed: ";
        String r30 = "inputStream";
        r110 = r110;
        String r112 = "";
        String r31 = r21;
        r17 = r17;
        r11 = r22;
        r10 = r23;
        String r113 = "tempDecryptFile.absolutePath";
        File r32 = r18;
        ?? r33 = r20;
    L311:
        Closeable r34 = (Closeable) r14;     // Catch: Throwable -> L205
        KeyInfoWrapper r114 = (KeyInfoWrapper) r34;     // Catch: Throwable -> L195
        if (r114.getKeyAlias().length() <= 0) goto L141;
        boolean r115 = true;
    L142:
        if (r115 == false) goto L186;
        if (r114.getKeyInfo().length() <= 0) goto L146;
        boolean r116 = true;
    L147:
        if (r116 == false) goto L186;
        if (r17 != 0) goto L305;
        boolean r35 = true;
        boolean r36 = true;
        boolean r37 = true;
        String r38 = IModelCertKt.getModelCert().reEncryptFEK(r110, r112, r31, false);     // Catch: Throwable -> L184
        if (r38.length() <= 0) goto L178;
        boolean r39 = true;
    L179:
        if (r39 == false) goto L181;
        PresetDecryptReEncryptKeySP.INSTANCE.saveReEncryptKey(r11, r111, r38);     // Catch: Throwable -> L184
    L181:
        if (r38.length() <= 0) goto L187;
        boolean r40 = true;
    L189:
        CloseableKt.closeFinally(r34, null);     // Catch: Throwable -> L203
        r17 = r17;
        r110 = r110;
        r33 = r36;
    L296:
        Object r41 = Result.m32constructorimpl(Boxing.boxBoolean(r40));     // Catch: Throwable -> L193
        ?? r42 = r33;
    L237:
        Throwable r43 = Result.m35exceptionOrNullimpl(r41);
        if (r43 == null) goto L240;
        AIKLog.INSTANCE.w(TAG, "decrypt failed: " + r110 + ", " + r43.getMessage(), r43);
    L240:
        Boolean r44 = Boxing.boxBoolean(false);
        if (Result.m38isFailureimpl(r41) == false) goto L243;
        r41 = r44;
    L243:
        boolean r45 = ((Boolean) r41).booleanValue();
        if (r45 == false) goto L273;
        if (r17 == 0) goto L273;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L255
        if (r19.exists() == true) goto L249;
    L252:
        ?? r117 = r42;
    L253:
        Object r47 = Result.m32constructorimpl(Boxing.boxBoolean(r117));     // Catch: Throwable -> L255
    L257:
        Boolean r48 = Boxing.boxBoolean(false);
        if (Result.m38isFailureimpl(r47) == false) goto L261;
        r47 = r48;
    L261:
        if (((Boolean) r47).booleanValue() == true) goto L288;
        AIKLog.INSTANCE.w(TAG, "delete decryptFile failed: " + r19 + ", exists = " + e.b(r19));
    L288:
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L265
        Object r50 = Result.m32constructorimpl(Boxing.boxBoolean(r32.renameTo(r19)));     // Catch: Throwable -> L265
    L267:
        boolean r51 = false;
        Boolean r52 = Boxing.boxBoolean(false);
        if (Result.m38isFailureimpl(r50) == false) goto L271;
        r50 = r52;
    L271:
        if (((Boolean) r50).booleanValue() == true) goto L273;
        AIKLog.INSTANCE.w(TAG, r25 + r32 + r24 + r19);
    L274:
        AIKLog r53 = AIKLog.INSTANCE;
        if (r51 == false) goto L277;
        StringBuilder r54 = new StringBuilder();
        r54.append("decrypt succeed ");
        r54.append(r110);
        r53.d(TAG, r54.toString());
    L279:
        return Boxing.boxBoolean(r51);
    L277:
        r54 = new StringBuilder();
        r54.append("decrypt failed ");
        r54.append(r110);
        r53.w(TAG, r54.toString());
    L265:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        r50 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L267
    L249:
        if (r19.delete() == true) goto L252;
        r117 = 0;
    L255:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r47 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L273:
        r51 = r45;
    L193:
        th = th;
    L236:
        Result.Companion r57 = Result.Companion;
        r41 = Result.m32constructorimpl(ResultKt.createFailure(th));
        r42 = r33;
    L187:
        r40 = false;
        r36 = r37;
        goto L189
    L178:
        r39 = false;
    L184:
        th = th;
    L197:
        Throwable r58 = th;
        r33 = r35;
    L307:
        throw r58;     // Catch: Throwable -> L199
    L199:
        th = move-exception;
        CloseableKt.closeFinally(r34, r58);     // Catch: Throwable -> L203
        throw th;     // Catch: Throwable -> L203
    L305:
        int r59 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];     // Catch: Throwable -> L172
        if (r59 != 1) goto L153;
        InputStream r60 = new FileInputStream(r33);     // Catch: Throwable -> L170
    L158:
        InputStream r61 = r60;
        IModelDecrypt r118 = IModelDecryptKt.getModelDecrypt();     // Catch: Throwable -> L163
        Intrinsics.checkNotNullExpressionValue(r61, r30);     // Catch: Throwable -> L163
        String r62 = r32.getAbsolutePath();     // Catch: Throwable -> L163
        Intrinsics.checkNotNullExpressionValue(r62, r113);     // Catch: Throwable -> L163
        r40 = r118.decryptModelFileByKeyInfo(r110, r61, r62, r114.getKeyAlias(), r114.getKeyInfo());     // Catch: Throwable -> L163
    L161:
        CloseableKt.closeFinally(r61, null);     // Catch: Throwable -> L170
        r36 = true;
    L163:
        th = move-exception;
        throw th;     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        CloseableKt.closeFinally(r61, th);     // Catch: Throwable -> L170
        throw th;     // Catch: Throwable -> L170
    L153:
        if (r59 != 2) goto L156;
        r60 = AppContext.INSTANCE.getContext().getAssets().open(r33);     // Catch: Throwable -> L170
        goto L158
    L156:
        throw new IllegalArgumentException("unknown preset type " + r10);     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        r58 = th;
        r33 = 1;
    L172:
        th = move-exception;
        r58 = th;
        r33 = 1;
        goto L307
    L146:
        r116 = false;
    L186:
        r37 = true;
        goto L187
    L141:
        r115 = false;
    L195:
        th = th;
        r35 = true;
    L203:
        th = th;
    L207:
        r17 = r17;
        r110 = r110;
    L205:
        th = th;
        r33 = 1;
    L14:
        th = th;
        r32 = r18;
        r24 = ", to = ";
        r25 = "rename tempDecryptFile failed: ";
    L16:
        r33 = 1;
        goto L236
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r14);
        String r119 = r10 + '/' + r11 + '/' + r28;
        AIKLog r63 = AIKLog.INSTANCE;
        r63.d(TAG, "start decrypt " + r119);
        PresetResViewer r64 = PresetResViewer.INSTANCE;
        String r120 = r64.getKeyInfo(r11, r28);
        String r65 = r64.getPresetPath(r11, r28);
        C03681 r121 = r12;
        File r66 = new File(r64.getDecryptPath(r11, r28));
        r113 = "tempDecryptFile.absolutePath";
        if (PresetConstant.INSTANCE.getDecryptType() != DecryptType.DecryptToFile) goto L22;
        r17 = 1;
    L23:
        if (r17 == 0) goto L35;
        File r67 = r66.getParentFile();
        if (r67 == null) goto L29;
        String r210 = "";
        if (e.b(r67) != true) goto L30;
        boolean r68 = true;
    L31:
        if (r68 == true) goto L36;
        File r69 = r66.getParentFile();
        if (r69 == null) goto L36;
        Boxing.boxBoolean(e.c(r69));
    L36:
        r32 = new File(r66.getParent(), r66.getName() + ".__de__");
        if (r120.length() != 0) goto L39;
        boolean r70 = true;
    L40:
        if (r70 == false) goto L292;
        if (r17 == 0) goto L292;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L44
        r63.d(TAG, r11 + '/' + r28 + " is not encrypted, just copy.");     // Catch: Throwable -> L44
        com.obric.aikernel.utils.f.f5592a.b(new File(r65), r32);     // Catch: Throwable -> L44
        r32.renameTo(r66);     // Catch: Throwable -> L44
        Object r72 = Result.m32constructorimpl(Boxing.boxBoolean(true));     // Catch: Throwable -> L44
    L47:
        if (Result.m35exceptionOrNullimpl(r72) == null) goto L49;
        AIKLog.INSTANCE.w(TAG, "rename tempDecryptFile failed: " + r32 + ", to = " + r66);
    L49:
        Boolean r73 = Boxing.boxBoolean(false);
        if (Result.m38isFailureimpl(r72) == true) goto L52;
        return r72;
    L52:
        return r73;
    L44:
        th = move-exception;
        Result.Companion r74 = Result.Companion;
        r72 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L292:
        Result.Companion r75 = Result.Companion;     // Catch: Throwable -> L233
        int[] r76 = WhenMappings.$EnumSwitchMapping$0;     // Catch: Throwable -> L233
        int r122 = r76[r26.ordinal()];     // Catch: Throwable -> L233
        if (r122 != 1) goto L315;
        InputStream r123 = new FileInputStream(r65);     // Catch: Throwable -> L233
    L331:
        IModelDecrypt r124 = IModelDecryptKt.getModelDecrypt();     // Catch: Throwable -> L222
        r24 = ", to = ";
        r30 = "inputStream";
        Intrinsics.checkNotNullExpressionValue(r123, r30);     // Catch: Throwable -> L220
        r25 = "rename tempDecryptFile failed: ";
        r110 = r119;
    L218:
        th = th;
        r66 = r66;
    L225:
        r33 = 1;
        Throwable r77 = th;
    L282:
        throw r77;     // Catch: Throwable -> L227
    L227:
        th = move-exception;
        CloseableKt.closeFinally(r123, r77);     // Catch: Throwable -> L231
        throw th;     // Catch: Throwable -> L231
    L231:
        th = th;
    L235:
        r19 = r66;
        goto L207
    L69:
        if (r124.checkModelIntegrity(r110, r123) == false) goto L280;
        Unit r125 = Unit.INSTANCE;     // Catch: Throwable -> L218
        CloseableKt.closeFinally(r123, null);     // Catch: Throwable -> L214
        if (r120.length() <= 0) goto L84;
        boolean r126 = true;
    L85:
        if (r126 == true) goto L325;
        File r211 = r66;
        r112 = r210;
    L318:
        r63.w(TAG, "will decrypt use key info, this will need network and cost more time. " + r110);     // Catch: Throwable -> L212
        PresetModelDecryptImpl r78 = INSTANCE;     // Catch: Throwable -> L212
        r121.L$0 = r10;     // Catch: Throwable -> L212
        r121.L$1 = r11;     // Catch: Throwable -> L212
        r121.L$2 = r28;     // Catch: Throwable -> L212
        r121.L$3 = r110;     // Catch: Throwable -> L212
        r121.L$4 = r120;     // Catch: Throwable -> L212
        r121.L$5 = r65;     // Catch: Throwable -> L212
        File r127 = r211;
        r121.L$6 = r127;     // Catch: Throwable -> L210
        r121.L$7 = r32;     // Catch: Throwable -> L210
        r121.I$0 = r17;     // Catch: Throwable -> L210
        r121.label = 1;     // Catch: Throwable -> L208
        r14 = r78.requestKeyInfo(r11, r28, r121);     // Catch: Throwable -> L210
        if (r14 != r15) goto L136;
        return r15;
    L136:
        r19 = r127;
        r31 = r120;
        r111 = r28;
        r33 = r65;
    L208:
        th = th;
        r33 = 1;
    L217:
        r17 = r17;
        r110 = r110;
        r19 = r127;
    L210:
        th = th;
    L216:
        r33 = 1;
    L212:
        th = th;
        r127 = r211;
        goto L216
    L325:
        r63.d(TAG, "will decrypt use FEKCipher");     // Catch: Throwable -> L123
        r211 = r66;
        r112 = r210;
        String r128 = IModelCertKt.getModelCert().reEncryptFEK(r110, r112, r120, true);     // Catch: Throwable -> L121
    L119:
        th = th;
    L125:
        r17 = r17;
        r110 = r110;
        r19 = r211;
        goto L16
    L90:
        if (r128.length() <= 0) goto L92;
        boolean r79 = true;
    L93:
        if (r79 == false) goto L318;
        if (r17 == 0) goto L115;
        int r80 = r76[r26.ordinal()];     // Catch: Throwable -> L119
        if (r80 != 1) goto L98;
        InputStream r81 = new FileInputStream(r65);     // Catch: Throwable -> L119
    L103:
        InputStream r82 = r81;
        IModelDecrypt r129 = IModelDecryptKt.getModelDecrypt();     // Catch: Throwable -> L108
        Intrinsics.checkNotNullExpressionValue(r82, r30);     // Catch: Throwable -> L108
        String r83 = r32.getAbsolutePath();     // Catch: Throwable -> L108
        Intrinsics.checkNotNullExpressionValue(r83, r113);     // Catch: Throwable -> L108
        r40 = r129.decryptModelFileByFEKCipher(r110, r82, r83, r128, true);     // Catch: Throwable -> L108
    L106:
        CloseableKt.closeFinally(r82, null);     // Catch: Throwable -> L119
    L117:
        r19 = r211;
    L74:
        r33 = 1;
    L108:
        th = move-exception;
        throw th;     // Catch: Throwable -> L111
    L111:
        th = move-exception;
        CloseableKt.closeFinally(r82, th);     // Catch: Throwable -> L119
        throw th;     // Catch: Throwable -> L119
    L98:
        if (r80 != 2) goto L101;
        r81 = AppContext.INSTANCE.getContext().getAssets().open(r65);     // Catch: Throwable -> L119
        goto L103
    L101:
        throw new IllegalArgumentException("unknown preset type " + r10);     // Catch: Throwable -> L119
    L115:
        PresetDecryptReEncryptKeySP.INSTANCE.saveReEncryptKey(r11, r28, r128);     // Catch: Throwable -> L119
        r40 = true;
        goto L117
    L92:
        r79 = false;
    L121:
        th = th;
        r33 = 1;
        r17 = r17;
        r110 = r110;
        r19 = r211;
    L123:
        th = th;
        r211 = r66;
        goto L125
    L84:
        r126 = false;
    L214:
        th = th;
        r127 = r66;
        goto L216
    L280:
        r63.d(TAG, "checkModelIntegrity failed: " + r110);     // Catch: Throwable -> L77
        CloseableKt.closeFinally(r123, null);     // Catch: Throwable -> L75
        r19 = r66;
        r40 = false;
    L75:
        th = th;
        r19 = r66;
        r17 = r17;
        r110 = r110;
    L77:
        th = move-exception;
        r77 = th;
        r66 = r66;
        r33 = 1;
    L220:
        th = th;
    L224:
        r25 = "rename tempDecryptFile failed: ";
        r110 = r119;
    L222:
        th = th;
        r24 = ", to = ";
        goto L224
    L315:
        if (r122 != 2) goto L62;
        r123 = AppContext.INSTANCE.getContext().getAssets().open(r65);     // Catch: Throwable -> L59
        goto L331
    L62:
        throw new IllegalArgumentException("unknown preset type " + r10);     // Catch: Throwable -> L59
    L59:
        th = th;
        r19 = r66;
        r17 = r17;
        r24 = ", to = ";
        r25 = "rename tempDecryptFile failed: ";
        r110 = r119;
    L233:
        th = th;
        r66 = r66;
        r24 = ", to = ";
        r25 = "rename tempDecryptFile failed: ";
        r110 = r119;
        r33 = 1;
        goto L235
    L39:
        r70 = false;
    L30:
        r68 = false;
        goto L31
    L29:
        r210 = "";
        goto L30
    L35:
        r210 = "";
        goto L36
    L22:
        r17 = 0;
    L7:
        r12 = new C03681(this, r29);
        goto L8
    }

    @JvmStatic
    public static final PresetModelDecryptImpl getInst() {
        return INSTANCE;
    }

    private final Object requestKeyInfo(String r10, String r11, Continuation<? super KeyInfoWrapper> r12) {
        if ((r12 instanceof C03701) == false) goto L7;
        C03701 r13 = (C03701) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        boolean r18 = true;
        if (r17 == 0) goto L16;
        if (r17 == 1) goto L15;
        if (r17 != 2) goto L14;
        String r19 = (String) r13.L$2;
        r11 = (String) r13.L$1;
        String r110 = (String) r13.L$0;
        ResultKt.throwOnFailure(r15);
        Object r20 = ((Result) r15).m41unboximpl();
    L33:
        Throwable r21 = Result.m35exceptionOrNullimpl(r20);
        if (r21 == null) goto L36;
        AIKLog.INSTANCE.w(TAG, "simpleRequestKeyInfo failed: " + r21.getMessage(), r21);
        IModelCertKt.getModelCert().deleteAttestKey(r19);
    L36:
        Set r22 = SetsKt.emptySet();
        if (Result.m38isFailureimpl(r20) == false) goto L39;
        r20 = r22;
    L39:
        Iterator r23 = ((Iterable) r20).iterator();
    L41:
        if (r23.hasNext() == false) goto L49;
        IKeyInfoDistribute.KeyInfoItem r24 = (IKeyInfoDistribute.KeyInfoItem) r23.next();
        if (Intrinsics.areEqual(r24.getModelName(), r110) == false) goto L41;
        if (Intrinsics.areEqual(r24.getFileName(), r11) == false) goto L41;
        return new KeyInfoWrapper(r19, r24.getKeyInfo());
    L49:
        return new KeyInfoWrapper("", "");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (String) r13.L$1;
        r10 = (String) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L19:
        Pair r25 = (Pair) r15;
        String r26 = (String) r25.component1();
        String r27 = (String) r25.component2();
        if (r26.length() <= 0) goto L22;
        boolean r28 = true;
    L23:
        if (r28 == false) goto L49;
        if (r27.length() > 0) goto L28;
        r18 = false;
    L28:
        if (r18 == false) goto L49;
        IDecryptFeature r29 = IDecryptFeatureKt.getDecryptFeature();
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.L$2 = r26;
        r13.label = 2;
        r20 = r29.mo18simpleRequestKeyInfoBWLJW6A(r26, r27, r10, r13);
        if (r20 != r16) goto L32;
        return r16;
    L32:
        r110 = r10;
        r19 = r26;
        goto L33
    L22:
        r28 = false;
        goto L23
    L16:
        ResultKt.throwOnFailure(r15);
        AIKLog.INSTANCE.d(TAG, "start requestKeyInfo /" + r10 + '/' + r11);
        IModelCert r30 = IModelCertKt.getModelCert();
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.label = 1;
        r15 = r30.fetchAttestCertChain(r13);
        if (r15 != r16) goto L19;
        return r16;
    L7:
        r13 = new C03701(this, r12);
        goto L8
    }

    @Override // com.obric.aikernel.model_preset.impl.decrypt.api.IModelPresetDecrypt
    public void decryptPresetModel(Collection<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "modelNames");
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        AIKLog.INSTANCE.d(TAG, "decryptPresetModel: modelNames = " + r10);
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        Object r13 = r12.next();
        if (PresetResViewer.INSTANCE.hasUnDecryptedFile((String) r13) == false) goto L7;
        r11.add(r13);
        goto L7
    L12:
        if (m.f5603a.a(AppContext.INSTANCE.getContext()) == false) goto L17;
        Iterator r14 = r11.iterator();
    L15:
        if (r14.hasNext() == false) goto L25;
        INSTANCE.addDecryptTask((String) r14.next(), false);
        goto L15
    L25:
        return;
    L17:
        OtherProcessDecryptUtils.INSTANCE.decryptPresetModel(r11);
    }

    @Override // com.obric.aikernel.model_preset.impl.decrypt.api.IModelPresetDecrypt
    public void init() {
        if (inited.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        AIKLog r10 = AIKLog.INSTANCE;
        StringBuilder r11 = new StringBuilder();
        r11.append("init AndroidUserID=");
        AppContext r12 = AppContext.INSTANCE;
        r11.append(r12.getAikStore().g("main_host_user_id"));
        r11.append(" mainprocess =");
        m r13 = m.f5603a;
        r11.append(r13.a(r12.getContext()));
        r10.d(TAG, r11.toString());
        if (r13.a(r12.getContext()) == true) goto L8;
    L10:
        r10.d(TAG, "this is not main process, do not execute decrypt task");
        return;
    L8:
        if (r12.getAikStore().g("main_host_user_id") != 0) goto L10;
        h.d(m0.a(z0.b()), null, null, new C03691(null), 3, null).A(AnonymousClass2.INSTANCE);
    }

    @Override // com.obric.aikernel.model_preset.impl.decrypt.api.IModelPresetDecrypt
    public Object waitingDecrypting(Collection<String> r17, Continuation<? super Unit> r18) {
        if ((r18 instanceof C03711) == false) goto L7;
        C03711 r10 = (C03711) r18;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r15 = (String) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L39:
        AIKLog.INSTANCE.d(TAG, "waitingDecrypting end " + r15);
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r12);
        ArrayList r16 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L18:
        if (r19.hasNext() == false) goto L23;
        Object r20 = r19.next();
        if (PresetResViewer.INSTANCE.hasUnDecryptedFile((String) r20) == false) goto L18;
        r16.add(r20);
        goto L18
    L23:
        if (r16.isEmpty() == true) goto L25;
        String r21 = CollectionsKt.joinToString$default(r16, ",", null, null, 0, null, null, 62, null);
        AIKLog.INSTANCE.d(TAG, "waitingDecrypting start " + r21);
        if (m.f5603a.a(AppContext.INSTANCE.getContext()) == false) goto L36;
        Iterator r22 = r16.iterator();
    L30:
        if (r22.hasNext() == false) goto L32;
        INSTANCE.addDecryptTask((String) r22.next(), true);
        goto L30
    L32:
        g1<Map<String, Boolean>> r23 = decryptingMapState;
        AnonymousClass3 r24 = new AnonymousClass3(r16, null);
        r10.L$0 = r21;
        r10.label = 1;
        if (kotlinx.coroutines.flow.e.q(r23, r24, r10) != r13) goto L35;
        return r13;
    L35:
        r15 = r21;
        goto L39
    L36:
        OtherProcessDecryptUtils r25 = OtherProcessDecryptUtils.INSTANCE;
        r10.L$0 = r21;
        r10.label = 2;
        if (r25.waitingDecrypting(r16, r10) != r13) goto L35;
        return r13;
    L25:
        return Unit.INSTANCE;
    L7:
        r10 = new C03711(this, r18);
        goto L8
    }
}
