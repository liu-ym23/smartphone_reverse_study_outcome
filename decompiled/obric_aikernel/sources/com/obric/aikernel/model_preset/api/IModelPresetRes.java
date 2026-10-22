package com.obric.aikernel.model_preset.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public interface IModelPresetRes extends IService {
    List<String> allPresetModels();

    void clearDecryptData();

    String getDecryptPath(String r10, String r11);

    DecryptType getDecryptType();

    String getPresetKeyInfo(String r10, String r11);

    String getPresetLinkTargetPath(String r10, String r11);

    String getPresetPath(String r10, String r11);

    PresetType getPresetType(String r10, String r11);

    String getReEncryptKeyInfo(String r10, String r11);

    boolean hasPresetFile(String r10, String r11);

    void init();

    boolean isPresetDecrypted(String r10);

    boolean isPresetDecrypted(String r10, String r11);

    boolean isPresetEncrypted(String r10);

    boolean isPresetEncrypted(String r10, String r11);

    void startDecrypt(Collection<String> r10);

    Object waitDecrypting(Collection<String> r10, Continuation<? super Unit> r11);
}
