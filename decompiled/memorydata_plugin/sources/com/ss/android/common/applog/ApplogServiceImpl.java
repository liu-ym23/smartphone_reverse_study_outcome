package com.ss.android.common.applog;

import android.content.Context;
import android.util.Log;
import com.service.middleware.applog.ApplogService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ApplogServiceImpl implements ApplogService {
    public static final String TAG = "ApplogServiceImpl";
    public static volatile com.service.middleware.applog.a cachedHeaderCustomTimelyCallback = null;
    public static volatile boolean isServicePrepared = false;

    static {
    }

    public ApplogServiceImpl() {
    }

    public static void handleCachedData() {
        if (isServicePrepared == true) goto L6;
        return;
    L6:
        if (cachedHeaderCustomTimelyCallback == null) goto L9;
        AppLog.a(cachedHeaderCustomTimelyCallback);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (isServicePrepared == false) goto L5;
        ac.a(r1, r3);
        return;
    L5:
        Log.e(TAG, "ApplogService not prepared!");
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r2, String r3, String r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (isServicePrepared == false) goto L5;
        ac.a(r1, r3, r4);
        return;
    L5:
        Log.e(TAG, "ApplogService not prepared!");
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r10, String r11, String r12, String r13, long r14, long r16) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (isServicePrepared == false) goto L5;
        ac.a(r1, r11, r12, r13, r14, r16);
        return;
    L5:
        Log.e(TAG, "ApplogService not prepared!");
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r11, String r12, String r13, String r14, long r15, long r17, JSONObject r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        if (isServicePrepared == false) goto L5;
        ac.a(r1, r12, r13, r14, r15, r17, r19);
        return;
    L5:
        Log.e(TAG, "ApplogService not prepared!");
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r11, String r12, String r13, String r14, long r15, long r17, boolean r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        if (isServicePrepared == false) goto L5;
        ac.a(r1, r12, r13, r14, r15, r17, r19);
        return;
    L5:
        Log.e(TAG, "ApplogService not prepared!");
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r12, String r13, String r14, String r15, long r16, long r18, boolean r20, JSONObject r21) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        if (isServicePrepared == false) goto L5;
        ac.a(r1, r13, r14, r15, r16, r18, r20, r21);
        return;
    L5:
        Log.e(TAG, "ApplogService not prepared!");
    }

    @Override // com.service.middleware.applog.ApplogService
    public void registerHeaderCustomCallback(com.service.middleware.applog.a r2) {
        com.service.middleware.applog.a r1 = (com.service.middleware.applog.a) ZeusTransformUtils.wrapperContextForParams(r2, com.service.middleware.applog.a.class, "com.obric.memorydata.plugin");
        if (isServicePrepared == false) goto L5;
        AppLog.a(r1);
        return;
    L5:
        cachedHeaderCustomTimelyCallback = r1;
    }
}
