package com.obric.aikernel.model_preset.impl.constant;

import com.obric.aikernel.model_preset.api.DecryptType;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public final class PresetConstant {
    public static final PresetConstant INSTANCE = null;
    public static final String KEY_INFO_FILE_NAME = "__keyinfo.json";
    private static final Lazy PRESET_DECRYPT_DIR$delegate = null;
    public static final String PRESET_MODULE_ASSETS_DIR = "aikernel/preset_models";
    public static final String PRESET_MODULE_OS_DIR = "/cust_model/aik_models";
    private static final Lazy assetsModelFileVirtualFile$delegate = null;
    private static final Lazy decryptType$delegate = null;

    static {
        INSTANCE = new PresetConstant();
        PRESET_DECRYPT_DIR$delegate = LazyKt.lazy(PresetConstant$PRESET_DECRYPT_DIR$2.INSTANCE);
        decryptType$delegate = LazyKt.lazy(PresetConstant$decryptType$2.INSTANCE);
        assetsModelFileVirtualFile$delegate = LazyKt.lazy(PresetConstant$assetsModelFileVirtualFile$2.INSTANCE);
    }

    private PresetConstant() {
    }

    public final File getAssetsModelFileVirtualFile() {
        return (File) assetsModelFileVirtualFile$delegate.getValue();
    }

    public final DecryptType getDecryptType() {
        return (DecryptType) decryptType$delegate.getValue();
    }

    public final String getPRESET_DECRYPT_DIR() {
        return (String) PRESET_DECRYPT_DIR$delegate.getValue();
    }
}
