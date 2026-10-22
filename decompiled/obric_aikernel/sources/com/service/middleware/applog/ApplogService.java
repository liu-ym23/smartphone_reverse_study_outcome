package com.service.middleware.applog;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import oa.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface ApplogService extends IService {
    void onEvent(Context r10, String r11);

    void onEvent(Context r10, String r11, String r12);

    void onEvent(Context r10, String r11, String r12, String r13, long r14, long r15);

    void onEvent(Context r10, String r11, String r12, String r13, long r14, long r15, JSONObject r16);

    void onEvent(Context r10, String r11, String r12, String r13, long r14, long r15, boolean r16);

    void onEvent(Context r10, String r11, String r12, String r13, long r14, long r15, boolean r16, JSONObject r17);

    void registerHeaderCustomCallback(a r10);
}
