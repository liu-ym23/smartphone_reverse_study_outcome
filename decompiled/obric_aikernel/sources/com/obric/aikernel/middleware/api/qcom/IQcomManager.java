package com.obric.aikernel.middleware.api.qcom;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public interface IQcomManager extends IService {
    boolean isIniting();

    Object waitInit(Continuation<? super Unit> r10);
}
