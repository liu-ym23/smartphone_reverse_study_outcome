package com.ss.android.lark.chameleon.bridge;

import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface CallBackFunction {

    public static class Simple implements CallBackFunction {
        public Simple() {
        }

        @Override // com.ss.android.lark.chameleon.bridge.CallBackFunction
        public void onCallBack(JsonObject r1) {
        }

        @Override // com.ss.android.lark.chameleon.bridge.CallBackFunction
        public void onCallBack(NonProguard r1) {
        }

        @Override // com.ss.android.lark.chameleon.bridge.CallBackFunction
        public void onCallBack(String r1) {
        }
    }

    void onCallBack(JsonObject r1);

    void onCallBack(NonProguard r1);

    void onCallBack(String r1);
}
