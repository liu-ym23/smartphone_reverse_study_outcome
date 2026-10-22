package com.obric.aikernel.model_preset.impl.preset_res;

import android.content.res.AssetManager;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model_preset.api.DecryptType;
import com.obric.aikernel.model_preset.api.PresetType;
import com.obric.aikernel.model_preset.impl.constant.PresetConstant;
import com.obric.aikernel.model_preset.impl.decrypt.PresetDecryptReEncryptKeySP;
import com.obric.aikernel.model_preset.impl.util.KeyInfoExportUtil;
import com.obric.aikernel.utils.e;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class PresetResViewer {
    public static final PresetResViewer INSTANCE = null;
    private static final String TAG = "PresetResViewer";
    private static final AtomicBoolean isInited = null;
    private static final ConcurrentHashMap<String, PresetResItem> presetResMap = null;

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

    static {
        PresetResViewer r10 = new PresetResViewer();
        INSTANCE = r10;
        presetResMap = new ConcurrentHashMap();
        isInited = new AtomicBoolean(false);
        r10.init();
    }

    private PresetResViewer() {
    }

    public static /* synthetic */ void a(Function2 r10, Object r11, Object r12) {
        init$lambda$1$lambda$0(r10, r11, r12);
    }

    private final void buildPresetFromAssets() {
        AssetManager r14 = AppContext.INSTANCE.getContext().getAssets();
        String[] r10 = r14.list(PresetConstant.PRESET_MODULE_ASSETS_DIR);
        if (r10 == null) goto L47;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L61;
        String r13 = r10[r12];
        Intrinsics.checkNotNullExpressionValue(r13, "modelName");
        PresetResItem r15 = new PresetResItem(r13, new LinkedHashMap(), PresetType.Assets);
        String[] r16 = r14.list("aikernel/preset_models/" + r13);
        if (r16 != null) goto L10;
        r16 = new String[0];
    L10:
        if (ArraysKt.contains(r16, PresetConstant.KEY_INFO_FILE_NAME) == false) goto L32;
        Object r17 = null;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L21
        InputStream r19 = AppContext.INSTANCE.getContext().getAssets().open("aikernel/preset_models/" + r13 + "/__keyinfo.json");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullExpressionValue(r19, "it");     // Catch: Throwable -> L16
        String r110 = StringsKt.decodeToString(ByteStreamsKt.readBytes(r19));     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r19, null);     // Catch: Throwable -> L21
        Object r20 = Result.m32constructorimpl(KeyInfoExportUtil.INSTANCE.exportKeyInfo(r13, r110));     // Catch: Throwable -> L21
    L23:
        Throwable r111 = Result.m35exceptionOrNullimpl(r20);
        if (r111 == null) goto L27;
        AIKLog.INSTANCE.w(TAG, r13 + " read keyinfo failed: " + r111.getMessage(), r111);
    L27:
        if (Result.m38isFailureimpl(r20) == true) goto L30;
        r17 = r20;
    L30:
        Map r21 = (Map) r17;
        if (r21 == null) goto L32;
    L33:
        ArrayList r22 = new ArrayList();
        int r112 = r16.length;
        int r113 = 0;
    L34:
        if (r113 >= r112) goto L39;
        String r114 = r16[r113];
        if ((!Intrinsics.areEqual(r114, PresetConstant.KEY_INFO_FILE_NAME)) == false) goto L38;
        r22.add(r114);
    L38:
        r113 = r113 + 1;
        goto L34
    L39:
        Iterator r23 = r22.iterator();
    L41:
        if (r23.hasNext() == false) goto L46;
        String r24 = (String) r23.next();
        Map<String, String> r25 = r15.getFileNameKeyInfoMap();
        Intrinsics.checkNotNullExpressionValue(r24, "fileName");
        String r115 = (String) r21.get(r24);
        if (r115 != null) goto L45;
        r115 = "";
    L45:
        r25.put(r24, r115);
        goto L41
    L46:
        presetResMap.put(r13, r15);
        r12 = r12 + 1;
        goto L5
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r19, th);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r20 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L32:
        r21 = MapsKt.emptyMap();
        goto L33
    L61:
        return;
    }

    private final void buildPresetFromOS() {
        File[] r10 = new File(PresetConstant.PRESET_MODULE_OS_DIR).listFiles();
        if (r10 == null) goto L45;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L57;
        File r13 = r10[r12];
        String r14 = r13.getName();
        if (presetResMap.containsKey(r14) == false) goto L9;
        AIKLog.INSTANCE.d(TAG, "already has key: " + r14);
    L44:
        r12 = r12 + 1;
        goto L5
    L9:
        Intrinsics.checkNotNullExpressionValue(r14, "modelName");
        PresetResItem r15 = new PresetResItem(r14, new LinkedHashMap(), PresetType.OS);
        Object r16 = null;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L16
        File r18 = new File(r13, PresetConstant.KEY_INFO_FILE_NAME);     // Catch: Throwable -> L16
        if (r18.exists() == false) goto L13;
        Map<String, String> r19 = KeyInfoExportUtil.INSTANCE.exportKeyInfo(r14, FilesKt.readText$default(r18, null, 1, null));     // Catch: Throwable -> L16
    L14:
        Object r110 = Result.m32constructorimpl(r19);     // Catch: Throwable -> L16
    L18:
        Throwable r111 = Result.m35exceptionOrNullimpl(r110);
        if (r111 == null) goto L22;
        AIKLog.INSTANCE.w(TAG, r14 + " read keyinfo failed: " + r111.getMessage(), r111);
    L22:
        if (Result.m38isFailureimpl(r110) == true) goto L25;
        r16 = r110;
    L25:
        Map r20 = (Map) r16;
        if (r20 != null) goto L28;
        r20 = MapsKt.emptyMap();
    L28:
        String[] r21 = r13.list();
        if (r21 == null) goto L43;
        ArrayList r22 = new ArrayList();
        int r112 = r21.length;
        int r113 = 0;
    L31:
        if (r113 >= r112) goto L36;
        String r114 = r21[r113];
        if ((!Intrinsics.areEqual(r114, PresetConstant.KEY_INFO_FILE_NAME)) == false) goto L35;
        r22.add(r114);
    L35:
        r113 = r113 + 1;
        goto L31
    L36:
        Iterator r23 = r22.iterator();
    L38:
        if (r23.hasNext() == false) goto L43;
        String r24 = (String) r23.next();
        Map<String, String> r25 = r15.getFileNameKeyInfoMap();
        Intrinsics.checkNotNullExpressionValue(r24, "fileName");
        String r115 = (String) r20.get(r24);
        if (r115 != null) goto L42;
        r115 = "";
    L42:
        r25.put(r24, r115);
    L43:
        presetResMap.put(r14, r15);
        goto L44
    L13:
        r19 = MapsKt.emptyMap();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r110 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L18
    L57:
        return;
    }

    private static final void init$lambda$1$lambda$0(Function2 r10, Object r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "$tmp0");
        r10.invoke(r11, r12);
    }

    private final void removeInvalidDecryptModels() {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L42
        PresetConstant r11 = PresetConstant.INSTANCE;     // Catch: Throwable -> L42
        if (r11.getDecryptType() == DecryptType.DecryptToFile) goto L8;
        File r12 = new File(r11.getPRESET_DECRYPT_DIR());     // Catch: Throwable -> L42
        if (r12.exists() == false) goto L40;
        FilesKt.deleteRecursively(r12);     // Catch: Throwable -> L42
    L40:
        Object r13 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L44:
        Throwable r14 = Result.m35exceptionOrNullimpl(r13);
        if (r14 == null) goto L60;
        AIKLog.INSTANCE.e(TAG, "removeInvalidDecryptModels failed: " + r14.getMessage(), r14);
        return;
    L60:
        return;
    L8:
        String[] r15 = new File(r11.getPRESET_DECRYPT_DIR()).list();     // Catch: Throwable -> L42
        if (r15 == null) goto L40;
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L42
        int r17 = r15.length;     // Catch: Throwable -> L42
        int r18 = 0;
    L11:
        if (r18 >= r17) goto L22;
        String r19 = r15[r18];     // Catch: Throwable -> L42
        PresetResViewer r20 = INSTANCE;     // Catch: Throwable -> L42
        Intrinsics.checkNotNullExpressionValue(r19, "modelName");     // Catch: Throwable -> L42
        if (r20.isPresetModel(r19) == true) goto L15;
    L18:
        boolean r21 = true;
    L19:
        if (r21 == false) goto L21;
        r16.add(r19);     // Catch: Throwable -> L42
    L21:
        r18 = r18 + 1;     // Catch: Throwable -> L42
        goto L11
    L15:
        if (r20.isEncrypted(r19) == false) goto L18;
        r21 = false;
        goto L19
    L22:
        Iterator r22 = r16.iterator();     // Catch: Throwable -> L42
    L24:
        if (r22.hasNext() == false) goto L40;
        String r23 = (String) r22.next();     // Catch: Throwable -> L42
        AIKLog r24 = AIKLog.INSTANCE;     // Catch: Throwable -> L42
        r24.d(TAG, "removeInvalidDecryptModels " + r23 + " is not preset encrypt model");     // Catch: Throwable -> L42
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L35
        File r26 = new File(PresetConstant.INSTANCE.getPRESET_DECRYPT_DIR(), r23);     // Catch: Throwable -> L35
        if (r26.isFile() == false) goto L30;
        boolean r27 = r26.delete();     // Catch: Throwable -> L35
    L33:
        r24.d(TAG, "removeInvalidDecryptModels delete " + r23 + ", result = " + r27);     // Catch: Throwable -> L35
        Object r28 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r29 = Result.m35exceptionOrNullimpl(r28);     // Catch: Throwable -> L42
        if (r29 == null) goto L24;
        AIKLog.INSTANCE.e(TAG, "removeInvalidDecryptModels delete " + r23 + " failed: " + r29.getMessage(), r29);     // Catch: Throwable -> L42
        goto L24
    L30:
        if (r26.isDirectory() == false) goto L32;
        r27 = FilesKt.deleteRecursively(r26);     // Catch: Throwable -> L35
        goto L33
    L32:
        r24.w(TAG, r26 + " is not file or dir");     // Catch: Throwable -> L35
        r27 = false;
        goto L33
    L35:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L42
        r28 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L44
    }

    private final void removeRedundantSP() {
        LinkedHashSet r10 = new LinkedHashSet();
        Iterator<T> r11 = INSTANCE.allPresetModelFiles().values().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        PresetResItem r12 = (PresetResItem) r11.next();
        Iterator<T> r13 = r12.getFileNameKeyInfoMap().keySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L4;
        String r14 = (String) r13.next();
        r10.add(TuplesKt.to(r12.getModelName(), r14));
        goto L7
    L9:
        PresetDecryptReEncryptKeySP.INSTANCE.removeInvalidKeys(r10);
    }

    public final Map<String, PresetResItem> allPresetModelFiles() {
        return presetResMap;
    }

    public final String getDecryptPath(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        return PresetConstant.INSTANCE.getPRESET_DECRYPT_DIR() + '/' + r10 + '/' + r11;
    }

    public final String getKeyInfo(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        PresetResItem r12 = presetResMap.get(r10);
        if (r12 == null) goto L7;
        Map<String, String> r13 = r12.getFileNameKeyInfoMap();
        if (r13 == null) goto L7;
        String r14 = r13.get(r11);
    L8:
        if (r14 != null) goto L11;
        return "";
    L11:
        return r14;
    L7:
        r14 = null;
        goto L8
    }

    public final String getPresetPath(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        PresetResItem r12 = presetResMap.get(r10);
        if (r12 == null) goto L5;
        PresetType r13 = r12.getPresetType();
    L6:
        if (r13 != null) goto L8;
        int r14 = -1;
    L10:
        if (r14 != 1) goto L12;
        StringBuilder r15 = new StringBuilder();
        String r16 = "/cust_model/aik_models/";
    L16:
        r15.append(r16);
        r15.append(r10);
        r15.append('/');
        r15.append(r11);
        return r15.toString();
    L12:
        if (r14 == 2) goto L14;
        return "";
    L14:
        r15 = new StringBuilder();
        r16 = "aikernel/preset_models/";
        goto L16
    L8:
        r14 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        goto L10
    L5:
        r13 = null;
        goto L6
    }

    public final PresetType getPresetType(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        PresetResItem r12 = presetResMap.get(r10);
        if (r12 != null) goto L7;
        return PresetType.None;
    L7:
        if (r12.getFileNameKeyInfoMap().containsKey(r11) == false) goto L10;
        return r12.getPresetType();
    L10:
        return PresetType.None;
    }

    public final boolean hasPresetFile(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        PresetResItem r12 = presetResMap.get(r10);
        if (r12 == null) goto L10;
        Map<String, String> r13 = r12.getFileNameKeyInfoMap();
        if (r13 == null) goto L10;
        if (r13.containsKey(r11) != true) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean hasUnDecryptedFile(String r10) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        PresetResItem r11 = presetResMap.get(r10);
        if (r11 == null) goto L20;
        Map<String, String> r12 = r11.getFileNameKeyInfoMap();
        if (r12 == null) goto L20;
        if (r12.isEmpty() == true) goto L20;
        Iterator<Map.Entry<String, String>> r13 = r12.entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L20;
        String r14 = r13.next().getKey();
        PresetResViewer r15 = INSTANCE;
        if (r15.hasPresetFile(r10, r14) == true) goto L15;
    L17:
        boolean r16 = false;
    L18:
        if (r16 == false) goto L11;
        boolean r17 = true;
    L21:
        if (r17 == false) goto L44;
        PresetResItem r18 = presetResMap.get(r10);
        if (r18 == null) goto L44;
        Map<String, String> r19 = r18.getFileNameKeyInfoMap();
        if (r19 == null) goto L44;
        Set<String> r20 = r19.keySet();
        if (r20 == null) goto L44;
        if (r20.isEmpty() == false) goto L31;
    L30:
        boolean r21 = false;
    L37:
        Boolean r22 = Boolean.valueOf(r21);
        if (r22.booleanValue() == true) goto L41;
        r22 = null;
    L41:
        if (r22 == null) goto L44;
        r22.booleanValue();
        return true;
    L31:
        Iterator<T> r23 = r20.iterator();
    L33:
        if (r23.hasNext() == false) goto L30;
        if ((!e.b(new File(INSTANCE.getDecryptPath(r10, (String) r23.next())))) == false) goto L33;
        r21 = true;
    L44:
        return false;
    L15:
        if (r15.isEncrypted(r10, r14) == false) goto L17;
        r16 = true;
    L20:
        r17 = false;
        goto L21
    }

    public final void init() {
        if (isInited.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        buildPresetFromOS();
        AIKLog r10 = AIKLog.INSTANCE;
        StringBuilder r11 = new StringBuilder();
        r11.append("preset models: ");
        ConcurrentHashMap<String, PresetResItem> r12 = presetResMap;
        r11.append(r12.keySet());
        r10.d(TAG, r11.toString());
        Collection<PresetResItem> r13 = r12.values();
        Intrinsics.checkNotNullExpressionValue(r13, "presetResMap.values");
        Iterator<T> r14 = r13.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        final PresetResItem r15 = (PresetResItem) r14.next();
        Map<String, String> r16 = r15.getFileNameKeyInfoMap();
        final Function2<String, String, Unit> r17 = new PresetResViewer$init$1$1(r15);
        r16.forEach(new a(r17));
        goto L7
    L9:
        removeInvalidDecryptModels();
        removeRedundantSP();
    }

    public final boolean isDecrypted(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        if (isEncrypted(r10, r11) == true) goto L6;
        return true;
    L6:
        if (PresetConstant.INSTANCE.getDecryptType() != DecryptType.DecryptToFile) goto L9;
        return e.b(new File(getDecryptPath(r10, r11)));
    L9:
        if (PresetDecryptReEncryptKeySP.INSTANCE.getReEncryptKey(r10, r11).length() > 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final boolean isEncrypted(String r10) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        PresetResItem r11 = allPresetModelFiles().get(r10);
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
        PresetResViewer r17 = INSTANCE;
        if (r17.isEncrypted(r10, (String) r16) == false) goto L10;
        r12 = r16;
    L14:
        r12 = (String) r12;
    L15:
        if (r12 == null) goto L17;
        return true;
    L17:
        return false;
    }

    public final boolean isEncrypted(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        if (getKeyInfo(r10, r11).length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPresetModel(String r10) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        return presetResMap.containsKey(r10);
    }
}
