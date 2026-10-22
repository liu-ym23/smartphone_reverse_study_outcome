package com.service.middleware.applog;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import dd.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface ApplogService extends IService {
    void onEvent(Context r8, String r10);

    void onEvent(Context r8, String r10, String r11);

    void onEvent(Context r8, String r10, String r11, String r12, long r13, long r14);

    void onEvent(Context r8, String r10, String r11, String r12, long r13, long r14, JSONObject r15);

    void onEvent(Context r8, String r10, String r11, String r12, long r13, long r14, boolean r15);

    void onEvent(Context r8, String r10, String r11, String r12, long r13, long r14, boolean r15, JSONObject r16);

    void registerHeaderCustomCallback(a r8);
}
