package com.obric.aikernel.model_preset.impl.preset_res;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model_preset.api.DecryptType;
import com.obric.aikernel.model_preset.api.IModelPresetRes;
import com.obric.aikernel.model_preset.api.IModelPresetResKt;
import com.obric.aikernel.model_preset.api.PresetType;
import com.obric.aikernel.model_preset.impl.constant.PresetConstant;
import com.obric.aikernel.model_preset.impl.decrypt.PresetDecryptReEncryptKeySP;
import com.obric.aikernel.model_preset.impl.decrypt.api.IModelPresetDecrypt;
import com.obric.aikernel.model_preset.impl.decrypt.api.IModelPresetDecryptKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ModelPresetResImpl implements IModelPresetRes {
    public static final ModelPresetResImpl INSTANCE = null;
    private static final String TAG = "ModelPresetResImpl";
    private static final AtomicBoolean isInited = null;

    static {
        ModelPresetResImpl r10 = new ModelPresetResImpl();
        INSTANCE = r10;
        isInited = new AtomicBoolean(false);
        r10.init();
    }

    private ModelPresetResImpl() {
    }

    private final String getAssetsModelFileVirtualLink() {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L10
        PresetConstant r11 = PresetConstant.INSTANCE;     // Catch: Throwable -> L10
        if (r11.getAssetsModelFileVirtualFile().isDirectory() == false) goto L6;
        FilesKt.deleteRecursively(r11.getAssetsModelFileVirtualFile());     // Catch: Throwable -> L10
    L6:
        if (r11.getAssetsModelFileVirtualFile().exists() == true) goto L8;
        r11.getAssetsModelFileVirtualFile().createNewFile();     // Catch: Throwable -> L10
    L8:
        Object r12 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r13 = Result.m35exceptionOrNullimpl(r12);
        if (r13 == null) goto L15;
        AIKLog.INSTANCE.w(TAG, "getAssetsModelFileVirtualLink failed: " + r13.getMessage(), r13);
    L15:
        String r14 = PresetConstant.INSTANCE.getAssetsModelFileVirtualFile().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r14, "PresetConstant.assetsMod…eVirtualFile.absolutePath");
        return r14;
    L10:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @JvmStatic
    public static final ModelPresetResImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public List<String> allPresetModels() {
        return CollectionsKt.sorted(CollectionsKt.toList(PresetResViewer.INSTANCE.allPresetModelFiles().keySet()));
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public void clearDecryptData() {
        AIKLog.INSTANCE.w(TAG, "clearDecryptData", new Throwable());
        PresetDecryptReEncryptKeySP.INSTANCE.removeInvalidKeys(SetsKt.emptySet());
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m32constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(new File(PresetConstant.INSTANCE.getPRESET_DECRYPT_DIR()))));     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.m35exceptionOrNullimpl(r11);
        if (r12 == null) goto L13;
        AIKLog.INSTANCE.w(TAG, "delete decrypt dir failed", r12);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public String getDecryptPath(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        return PresetResViewer.INSTANCE.getDecryptPath(r10, r11);
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public DecryptType getDecryptType() {
        return PresetConstant.INSTANCE.getDecryptType();
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public String getPresetKeyInfo(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        return PresetResViewer.INSTANCE.getKeyInfo(r10, r11);
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public String getPresetLinkTargetPath(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        if (IModelPresetResKt.getModelPresetRes().isPresetEncrypted(r10, r11) == false) goto L8;
        if (IModelPresetResKt.getModelPresetRes().getDecryptType() != DecryptType.DecryptToFile) goto L8;
        return IModelPresetResKt.getModelPresetRes().getDecryptPath(r10, r11);
    L8:
        if (IModelPresetResKt.getModelPresetRes().getPresetType(r10, r11) != PresetType.Assets) goto L11;
        return getAssetsModelFileVirtualLink();
    L11:
        return IModelPresetResKt.getModelPresetRes().getPresetPath(r10, r11);
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public String getPresetPath(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        return PresetResViewer.INSTANCE.getPresetPath(r10, r11);
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public PresetType getPresetType(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        return PresetResViewer.INSTANCE.getPresetType(r10, r11);
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public String getReEncryptKeyInfo(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        return PresetDecryptReEncryptKeySP.INSTANCE.getReEncryptKey(r10, r11);
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public boolean hasPresetFile(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        return PresetResViewer.INSTANCE.hasPresetFile(r10, r11);
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public synchronized void init() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (isInited.compareAndSet(false, true) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        AIKLog r10 = AIKLog.INSTANCE;     // Catch: Throwable -> L12
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L12
        r11.append("init AndroidUserID=");     // Catch: Throwable -> L12
        AppContext r12 = AppContext.INSTANCE;     // Catch: Throwable -> L12
        r11.append(r12.getAikStore().g("main_host_user_id"));     // Catch: Throwable -> L12
        r10.d(TAG, r11.toString());     // Catch: Throwable -> L12
        if (r12.getAikStore().g("main_host_user_id") != 0) goto L10;
        PresetResViewer.INSTANCE.init();     // Catch: Throwable -> L12
        IModelPresetDecryptKt.getModelPresetDecrypt().init();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public boolean isPresetDecrypted(String r10) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        PresetResItem r11 = PresetResViewer.INSTANCE.allPresetModelFiles().get(r10);
        if (r11 == null) goto L23;
        Map<String, String> r12 = r11.getFileNameKeyInfoMap();
        if (r12 == null) goto L24;
        Set<String> r13 = r12.keySet();
        if (r13 != null) goto L9;
        return false;
    L9:
        if (r13.isEmpty() == false) goto L11;
    L10:
        boolean r14 = true;
    L17:
        if (r14 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        Iterator<T> r15 = r13.iterator();
    L13:
        if (r15.hasNext() == false) goto L10;
        if (INSTANCE.isPresetDecrypted(r10, (String) r15.next()) == true) goto L13;
        r14 = false;
        goto L17
    L24:
        return false;
    L23:
        return false;
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public boolean isPresetDecrypted(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        return PresetResViewer.INSTANCE.isDecrypted(r10, r11);
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public boolean isPresetEncrypted(String r10) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        PresetResItem r11 = PresetResViewer.INSTANCE.allPresetModelFiles().get(r10);
        Object r12 = null;
        if (r11 == null) goto L15;
        Map<String, String> r13 = r11.getFileNameKeyInfoMap();
        if (r13 == null) goto L15;
        Set<String> r14 = r13.keySet();
        if (r14 == null) goto L15;
        Iterator<T> r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L14;
        Object r16 = r15.next();
        ModelPresetResImpl r17 = INSTANCE;
        if (r17.isPresetEncrypted(r10, (String) r16) == false) goto L10;
        r12 = r16;
    L14:
        r12 = (String) r12;
    L15:
        if (r12 == null) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public boolean isPresetEncrypted(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        return PresetResViewer.INSTANCE.isEncrypted(r10, r11);
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public void startDecrypt(Collection<String> r10) {
        if (r10 != null) goto L4;
    L7:
        boolean r11 = true;
    L8:
        if (r11 == false) goto L10;
        return;
    L10:
        IModelPresetDecrypt r12 = IModelPresetDecryptKt.getModelPresetDecrypt();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r10.iterator();
    L12:
        if (r14.hasNext() == false) goto L16;
        Object r15 = r14.next();
        PresetResViewer r16 = PresetResViewer.INSTANCE;
        if (r16.hasUnDecryptedFile((String) r15) == false) goto L12;
        r13.add(r15);
        goto L12
    L16:
        r12.decryptPresetModel(CollectionsKt.toSet(r13));
        return;
    L4:
        if (r10.isEmpty() == true) goto L7;
        r11 = false;
        goto L8
    }

    @Override // com.obric.aikernel.model_preset.api.IModelPresetRes
    public Object waitDecrypting(Collection<String> r10, Continuation<? super Unit> r11) {
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == true) goto L11;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r10.iterator();
    L14:
        if (r14.hasNext() == false) goto L24;
        Object r15 = r14.next();
        String r16 = (String) r15;
        PresetResViewer r17 = PresetResViewer.INSTANCE;
        if (r17.isPresetModel(r16) == true) goto L18;
    L20:
        boolean r18 = false;
    L21:
        if (r18 == false) goto L14;
        r13.add(r15);
        goto L14
    L18:
        if (r17.hasUnDecryptedFile(r16) == false) goto L20;
        r18 = true;
        goto L21
    L24:
        if ((!r13.isEmpty()) == false) goto L29;
        Object r19 = IModelPresetDecryptKt.getModelPresetDecrypt().waitingDecrypting(r13, r11);
        if (r19 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        return r19;
    L29:
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L5:
        if (r10.isEmpty() == true) goto L8;
        r12 = false;
        goto L9
    }
}
