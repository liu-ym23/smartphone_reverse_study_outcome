package com.obric.aikernel.model_decrypt.api.decrypt;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Pair;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public interface IModelCert extends IService {
    String[] allKeyAlias();

    boolean deleteAttestKey(String r10);

    Object fetchAttestCertChain(Continuation<? super Pair<String, String>> r10);

    String reEncryptFEK(String r10, String r11, String r12, boolean r13);
}
