package com.obric.aikernel.model_decrypt.impl.filemeta;

import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.store.IStoreManager;
import com.obric.aikernel.middleware.api.store.StoreManager;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelCertKt;
import com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager;
import com.obric.aikernel.model_decrypt.api.filemeta.ModelFileMetaData;
import com.obric.aikernel.model_preset.api.DecryptType;
import com.obric.aikernel.model_preset.api.IModelPresetResKt;
import com.obric.aikernel.utils.GsonExtKt;
import com.obric.aikernel.utils.e;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.channels.f;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class ModelFileMetaDataManagerImpl implements IModelFileMetaDataManager {
    public static final ModelFileMetaDataManagerImpl INSTANCE = null;
    private static final String TAG = "ModelFileMetaDataManager";
    private static final ConcurrentHashMap<String, ModelFileMetaData> cachedMetaData = null;
    private static final d<Runnable> ioEventChannel = null;
    private static final boolean isObricType = false;
    private static final t7.a modelFileMetaStore = null;

    /* JADX INFO: renamed from: com.obric.aikernel.model_decrypt.impl.filemeta.ModelFileMetaDataManagerImpl$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.filemeta.ModelFileMetaDataManagerImpl$1", f = "ModelFileMetaDataManagerImpl.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0028 -> B:15:0x002b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L11;
            if (r12 != 1) goto L10;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L7
        L15:
            ModelFileMetaDataManagerImpl.access$onIOEvent(ModelFileMetaDataManagerImpl.INSTANCE, (Runnable) r10);     // Catch: Throwable -> L7
            Object r13 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L18:
            Throwable r14 = Result.m35exceptionOrNullimpl(r13);
            if (r14 != null) goto L20;
        L12:
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L7
            d r16 = ModelFileMetaDataManagerImpl.access$getIoEventChannel$p();     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r10 = r16.t(this);     // Catch: Throwable -> L7
            if (r10 != r11) goto L15;
            return r11;
        L20:
            AIKLog.INSTANCE.w(ModelFileMetaDataManagerImpl.TAG, "handle io event failed: " + r14.getMessage(), r14);
        L7:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
            goto L18
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r10);
            goto L12
        }
    }

    static {
        INSTANCE = new ModelFileMetaDataManagerImpl();
        modelFileMetaStore = IStoreManager.a.a(StoreManager.INSTANCE, "AIKernel_model_file_meta", 0, 2, null);
        cachedMetaData = new ConcurrentHashMap();
        boolean r10 = com.obric.aikernel.api.b.f4431a.e().a();
        isObricType = r10;
        ioEventChannel = f.b(Integer.MAX_VALUE, null, null, 6, null);
        AIKLog.INSTANCE.d(TAG, "init: isObricType = " + r10);
        h.d(m0.a(z0.b()), null, null, new AnonymousClass1(null), 3, null);
    }

    private ModelFileMetaDataManagerImpl() {
    }

    public static /* synthetic */ void a(String r10, ModelFileMetaData r11) {
        updateFileMeta$lambda$8(r10, r11);
    }

    public static final /* synthetic */ d access$getIoEventChannel$p() {
        return ioEventChannel;
    }

    public static final /* synthetic */ void access$onIOEvent(ModelFileMetaDataManagerImpl r10, Runnable r11) {
        r10.onIOEvent(r11);
    }

    private final Set<String> allKeys() {
        LinkedHashSet r10 = new LinkedHashSet();
        Set<String> r11 = cachedMetaData.keySet();
        Intrinsics.checkNotNullExpressionValue(r11, "cachedMetaData.keys");
        r10.addAll(r11);
        CollectionsKt.addAll(r10, modelFileMetaStore.e());
        return r10;
    }

    public static /* synthetic */ void b(String r10) {
        deleteFileMeta$lambda$14(r10);
    }

    private final void deleteFileMeta(final String r10) {
        AIKLog.INSTANCE.d(TAG, "deleteFileMeta: filePath = " + r10);
        cachedMetaData.remove(r10);
        ioEventChannel.E(new a(r10));
    }

    private static final void deleteFileMeta$lambda$14(String r10) {
        Intrinsics.checkNotNullParameter(r10, "$filePath");
        t7.a r11 = modelFileMetaStore;
        if (r11.contains(r10) == true) goto L5;
        AIKLog.INSTANCE.d(TAG, "delete: not exists " + r10);
        return;
    L5:
        if (r11.f(new String[]{r10}) == true) goto L9;
        AIKLog.INSTANCE.w(TAG, "delete: failed " + r10);
        return;
    }

    private final ModelFileMetaData getFileMeta(String r10) {
        ModelFileMetaData r11 = cachedMetaData.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        AIKLog.INSTANCE.d(TAG, "getFileMeta " + r10);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L15
        String r13 = modelFileMetaStore.a(r10);     // Catch: Throwable -> L15
        if (r13.length() <= 0) goto L9;
        boolean r14 = true;
    L10:
        if (r14 == false) goto L12;
        ModelFileMetaData r15 = (ModelFileMetaData) GsonExtKt.a().k(r13, ModelFileMetaData.class);     // Catch: Throwable -> L15
    L13:
        Object r16 = Result.m32constructorimpl(r15);     // Catch: Throwable -> L15
    L17:
        Throwable r17 = Result.m35exceptionOrNullimpl(r16);
        if (r17 == null) goto L21;
        AIKLog.INSTANCE.w(TAG, "getFileMeta: failed " + r10 + ", " + r17.getMessage(), r17);
    L21:
        if (Result.m38isFailureimpl(r16) == false) goto L23;
        r16 = null;
    L23:
        ModelFileMetaData r18 = (ModelFileMetaData) r16;
        if (r18 == null) goto L29;
        cachedMetaData.put(r10, r18);
        return r18;
    L29:
        return null;
    L12:
        r15 = null;
        goto L13
    L9:
        r14 = false;
    L15:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    @JvmStatic
    public static final ModelFileMetaDataManagerImpl getInst() {
        return INSTANCE;
    }

    private final void onIOEvent(Runnable r10) {
        r10.run();
    }

    private final void updateFileMeta(final String r10, final ModelFileMetaData r11) {
        cachedMetaData.put(r10, r11);
        if (modelFileMetaStore.contains(r10) == false) goto L5;
        AIKLog r12 = AIKLog.INSTANCE;
        StringBuilder r13 = new StringBuilder();
        String r14 = "updateFileMeta: filePath = ";
    L6:
        r13.append(r14);
        r13.append(r10);
        r13.append(", metaData = ");
        r13.append(r11);
        r12.d(TAG, r13.toString());
        ioEventChannel.E(new b(r10, r11));
        return;
    L5:
        r12 = AIKLog.INSTANCE;
        r13 = new StringBuilder();
        r14 = "addFileMeta: filePath = ";
        goto L6
    }

    private static final void updateFileMeta$lambda$8(String r10, ModelFileMetaData r11) {
        Intrinsics.checkNotNullParameter(r10, "$filePath");
        Intrinsics.checkNotNullParameter(r11, "$metaData");
        t7.a r12 = modelFileMetaStore;
        String r13 = GsonExtKt.a().t(r11);
        Intrinsics.checkNotNullExpressionValue(r13, "GSON.toJson(metaData)");
        r12.b(r10, r13);
    }

    @Override // com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager
    public synchronized void batchAction(Function0<Unit> r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "action");     // Catch: Throwable -> L6
        r10.invoke();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager
    public synchronized void checkWhetherRemoveKeyAlias(String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "keyAlias");     // Catch: Throwable -> L28
        boolean r11 = false;
        if (r10.length() != 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        Iterator<T> r13 = allKeys().iterator();     // Catch: Throwable -> L28
    L13:
        if (r13.hasNext() == false) goto L24;
        ModelFileMetaData r14 = INSTANCE.getFileMeta((String) r13.next());     // Catch: Throwable -> L28
        if (r14 == null) goto L13;
        if (r14.isEncryptResource() == false) goto L13;
        if (r14.isDecrypted() == true) goto L13;
        if (Intrinsics.areEqual(r14.getDecryptKeyAlias(), r10) == false) goto L13;
        r11 = true;
        goto L13
    L24:
        if (r11 == true) goto L26;
        IModelCertKt.getModelCert().deleteAttestKey(r10);     // Catch: Throwable -> L28
    L26:
        monitor-exit(this);
        return;
    L7:
        r12 = false;
    L28:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager
    public synchronized void delete(File r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "file");     // Catch: Throwable -> L6
        String r11 = r10.getAbsolutePath();     // Catch: Throwable -> L6
        Intrinsics.checkNotNullExpressionValue(r11, "file.absolutePath");     // Catch: Throwable -> L6
        deleteFileMeta(r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager
    public synchronized ModelFileMetaData get(File r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "file");     // Catch: Throwable -> L6
        String r11 = r10.getAbsolutePath();     // Catch: Throwable -> L6
        Intrinsics.checkNotNullExpressionValue(r11, "file.absolutePath");     // Catch: Throwable -> L6
        ModelFileMetaData r12 = getFileMeta(r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager
    public synchronized boolean isFileExistedAndReady(File r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "file");     // Catch: Throwable -> L63
        String r11 = r10.getAbsolutePath();     // Catch: Throwable -> L63
        Intrinsics.checkNotNullExpressionValue(r11, "file.absolutePath");     // Catch: Throwable -> L63
        ModelFileMetaData r12 = getFileMeta(r11);     // Catch: Throwable -> L63
        boolean r13 = false;
        if (r12 != null) goto L9;
        AIKLog.INSTANCE.w(TAG, "isFileExistedAndDecrypted: meta is null " + r10);     // Catch: Throwable -> L63
        monitor-exit(this);
        return false;
    L9:
        if (r12.isPreset() == false) goto L42;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L30
        Path r15 = Paths.get(r10.getAbsolutePath(), new String[0]);     // Catch: Throwable -> L30
        if (Files.isSymbolicLink(r15) == false) goto L28;
        String r16 = Files.readSymbolicLink(r15).toString();     // Catch: Throwable -> L30
        if (IModelPresetResKt.getModelPresetRes().isPresetEncrypted(r12.getModelName(), r12.getFileName()) == false) goto L18;
        if (IModelPresetResKt.getModelPresetRes().getDecryptType() != DecryptType.DecryptToFile) goto L18;
    L27:
        String r17 = IModelPresetResKt.getModelPresetRes().getPresetLinkTargetPath(r12.getModelName(), r12.getFileName());     // Catch: Throwable -> L30
        r13 = Intrinsics.areEqual(r16, r17);     // Catch: Throwable -> L30
        AIKLog.INSTANCE.w(TAG, "link not match. cur is " + r16 + " vs " + r17);     // Catch: Throwable -> L30
    L18:
        if (e.b(r10) == true) goto L23;
        AIKLog.INSTANCE.d(TAG, "not exits: " + r10);     // Catch: Throwable -> L30
        monitor-exit(this);
        return false;
    L23:
        if (e.a(r10) == true) goto L27;
        AIKLog.INSTANCE.d(TAG, "cannot read " + r10);     // Catch: Throwable -> L30
        monitor-exit(this);
        return false;
    L28:
        Object r18 = Result.m32constructorimpl(Boolean.valueOf(r13));     // Catch: Throwable -> L30
    L32:
        Throwable r19 = Result.m35exceptionOrNullimpl(r18);     // Catch: Throwable -> L63
        if (r19 == null) goto L35;
        AIKLog.INSTANCE.w(TAG, "isFileExistedAndDecrypted failed: " + r19.getMessage(), r19);     // Catch: Throwable -> L63
    L35:
        Boolean r20 = Boolean.FALSE;     // Catch: Throwable -> L63
        if (Result.m38isFailureimpl(r18) == false) goto L38;
        r18 = r20;
    L38:
        boolean r21 = ((Boolean) r18).booleanValue();     // Catch: Throwable -> L63
        monitor-exit(this);
        return r21;
    L30:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L63
        r18 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
        goto L32
    L42:
        if (e.b(r10) == true) goto L47;
        AIKLog.INSTANCE.d(TAG, "not exits: " + r10);     // Catch: Throwable -> L63
        monitor-exit(this);
        return false;
    L47:
        if (e.a(r10) == true) goto L52;
        AIKLog.INSTANCE.d(TAG, "cannot read " + r10);     // Catch: Throwable -> L63
        monitor-exit(this);
        return false;
    L52:
        if (isObricType == false) goto L59;
        if (r12.isEncryptResource() == true) goto L56;
    L57:
        r13 = true;
    L61:
        monitor-exit(this);
        return r13;
    L56:
        if (r12.isDecrypted() == false) goto L61;
    L59:
        if (r12.getFEKCipher().length() <= 0) goto L61;
    L63:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager
    public synchronized void removeAllSubFileMeta(File r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "parentDir");     // Catch: Throwable -> L23
        AIKLog.INSTANCE.d(TAG, "removeAllSubFileMeta: " + r10);     // Catch: Throwable -> L23
        String r11 = r10.getAbsolutePath();     // Catch: Throwable -> L23
        LinkedHashSet r12 = new LinkedHashSet();     // Catch: Throwable -> L23
        Set<String> r13 = allKeys();     // Catch: Throwable -> L23
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L23
        Iterator<T> r15 = r13.iterator();     // Catch: Throwable -> L23
    L5:
        if (r15.hasNext() == false) goto L9;
        Object r16 = r15.next();     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r11, "parentDirPath");     // Catch: Throwable -> L23
        if (StringsKt.startsWith$default((String) r16, r11, false, 2, null) == false) goto L5;
        r14.add(r16);     // Catch: Throwable -> L23
        goto L5
    L9:
        Iterator r17 = r14.iterator();     // Catch: Throwable -> L23
    L11:
        if (r17.hasNext() == false) goto L16;
        String r18 = (String) r17.next();     // Catch: Throwable -> L23
        AIKLog.INSTANCE.d(TAG, "removeAllSubFileMeta: remove sub file " + r18);     // Catch: Throwable -> L23
        ModelFileMetaDataManagerImpl r19 = INSTANCE;     // Catch: Throwable -> L23
        ModelFileMetaData r20 = r19.getFileMeta(r18);     // Catch: Throwable -> L23
        if (r20 == null) goto L15;
        r12.add(r20.getDecryptKeyAlias());     // Catch: Throwable -> L23
    L15:
        r19.deleteFileMeta(r18);     // Catch: Throwable -> L23
        goto L11
    L16:
        Iterator r21 = r12.iterator();     // Catch: Throwable -> L23
    L17:
        if (r21.hasNext() == false) goto L21;
        INSTANCE.checkWhetherRemoveKeyAlias((String) r21.next());     // Catch: Throwable -> L23
        goto L17
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager
    public synchronized void update(File r28, boolean r29, Function1<? super ModelFileMetaData, ModelFileMetaData> r30) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r28, "file");     // Catch: Throwable -> L41
        Intrinsics.checkNotNullParameter(r30, "metaData");     // Catch: Throwable -> L41
        ModelFileMetaData r10 = get(r28);     // Catch: Throwable -> L41
        ModelFileMetaData r11 = r30.invoke(r10);     // Catch: Throwable -> L41
        if (r11 != null) goto L7;
    L39:
        monitor-exit(this);
        return;
    L7:
        if (Intrinsics.areEqual(r11, r10) == true) goto L39;
        if (r10 == null) goto L10;
        String r12 = r10.getDecryptKeyAlias();     // Catch: Throwable -> L41
    L11:
        String r15 = r11.getDecryptKeyAlias();     // Catch: Throwable -> L41
        boolean r21 = true;
        if (r11.isEncryptResource() == false) goto L16;
        if (r11.isDecrypted() == true) goto L16;
    L26:
        String r13 = r28.getAbsolutePath();     // Catch: Throwable -> L41
        Intrinsics.checkNotNullExpressionValue(r13, "file.absolutePath");     // Catch: Throwable -> L41
        updateFileMeta(r13, r11);     // Catch: Throwable -> L41
        String r26 = r15;
    L30:
        if (r12 != null) goto L32;
    L35:
        if (r21 == true) goto L39;
        if (Intrinsics.areEqual(r12, r26) == true) goto L39;
        checkWhetherRemoveKeyAlias(r12);     // Catch: Throwable -> L41
        goto L39
    L32:
        if (r12.length() == 0) goto L35;
        r21 = false;
    L16:
        if (r11.getDecryptKeyAlias().length() <= 0) goto L18;
        boolean r14 = true;
    L19:
        if (r14 == false) goto L21;
    L27:
        String r16 = r28.getAbsolutePath();     // Catch: Throwable -> L41
        Intrinsics.checkNotNullExpressionValue(r16, "file.absolutePath");     // Catch: Throwable -> L41
        r26 = r15;
        updateFileMeta(r16, ModelFileMetaData.copy$default(r11, null, null, null, false, 0, false, false, null, null, "", "", null, false, false, 14847, null));     // Catch: Throwable -> L41
        if (r29 == false) goto L30;
        checkWhetherRemoveKeyAlias(r11.getDecryptKeyAlias());     // Catch: Throwable -> L41
        goto L30
    L21:
        if (r11.getDecryptKeyInfo().length() <= 0) goto L23;
        boolean r17 = true;
    L24:
        if (r17 == false) goto L26;
    L23:
        r17 = false;
        goto L24
    L18:
        r14 = false;
        goto L19
    L10:
        r12 = null;
    L41:
        th = move-exception;
        throw th;
    }
}
