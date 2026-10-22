package com.ss.android.common.applog;

import android.content.Context;
import android.util.Log;
import com.service.middleware.applog.ApplogService;
import dd.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApplogServiceImpl implements ApplogService {
    public static final String TAG = "ApplogServiceImpl";
    public static volatile a cachedHeaderCustomTimelyCallback = null;
    public static volatile boolean isServicePrepared = false;

    public ApplogServiceImpl() {
    }

    public static void handleCachedData() {
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r8, String r10) {
        if (isServicePrepared == false) goto L5;
        l6.a.s0("event_v1", 0, 0, false, null);
        return;
    L5:
        Log.e(TAG, "ApplogService not prepared!");
    }

    @Override // com.service.middleware.applog.ApplogService
    public void registerHeaderCustomCallback(a r8) {
        if (isServicePrepared == false) goto L6;
        int r10 = od.a.f9776a;
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r8, String r10, String r11) {
        if (isServicePrepared == false) goto L5;
        l6.a.s0("event_v1", 0, 0, false, null);
        return;
    L5:
        Log.e(TAG, "ApplogService not prepared!");
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r8, String r10, String r11, String r12, long r13, long r14) {
        if (isServicePrepared == false) goto L5;
        l6.a.s0(r10, r13, r14, false, null);
        return;
    L5:
        Log.e(TAG, "ApplogService not prepared!");
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r10, String r11, String r12, String r13, long r14, long r15, JSONObject r17) {
        if (isServicePrepared == false) goto L5;
        l6.a.s0(r11, r14, r15, false, r17);
        return;
    L5:
        Log.e(TAG, "ApplogService not prepared!");
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r10, String r11, String r12, String r13, long r14, long r15, boolean r17) {
        if (isServicePrepared == false) goto L5;
        l6.a.s0(r11, r14, r15, r17, null);
        return;
    L5:
        Log.e(TAG, "ApplogService not prepared!");
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r8, String r10, String r11, String r12, long r13, long r14, boolean r16, JSONObject r17) {
        if (isServicePrepared == false) goto L5;
        l6.a.s0(r10, r13, r14, r16, r17);
        return;
    L5:
        Log.e(TAG, "ApplogService not prepared!");
    }
}
