package com.bytedance.crypto.bridge;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IAccountBridge {
    String onGetUserId();

    Map<String, String> onGetXttTokenMap();

    boolean onIsAccountLogin();
}
