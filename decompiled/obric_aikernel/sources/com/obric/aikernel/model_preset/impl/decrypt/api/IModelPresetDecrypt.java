package com.obric.aikernel.model_preset.impl.decrypt.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.Collection;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public interface IModelPresetDecrypt extends IService {
    void decryptPresetModel(Collection<String> r10);

    void init();

    Object waitingDecrypting(Collection<String> r10, Continuation<? super Unit> r11);
}
