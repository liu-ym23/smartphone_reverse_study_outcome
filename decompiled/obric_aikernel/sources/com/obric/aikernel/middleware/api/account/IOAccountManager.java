package com.obric.aikernel.middleware.api.account;

import com.bytedance.news.common.service.manager.IService;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IOAccountManager extends IService {
    ArrayList<String> addTokenHost();

    void init();

    Map<String, String> xttTokenMap();
}
