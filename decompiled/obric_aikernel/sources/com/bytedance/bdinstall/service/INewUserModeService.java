package com.bytedance.bdinstall.service;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface INewUserModeService {
    void addNewUserModeExtra(JSONObject r10);

    NUApi getApi();

    boolean isNewUserMode();

    void mapCustomParams(Map<String, String> r10);

    void start();

    <T> T tryReplaceService(Class<T> r10, T r11);
}
