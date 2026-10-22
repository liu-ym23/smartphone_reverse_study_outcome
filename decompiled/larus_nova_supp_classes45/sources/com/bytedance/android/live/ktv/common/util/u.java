package com.bytedance.android.live.ktv.common.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface u {
    void attachFromWindow(String r1);

    void detachFromWindow(String r1);

    boolean isVHPaused();

    boolean isVHSelected();

    String name();

    void onVHPaused();

    void onVHResume();

    void onVHSelected();

    void onVHUnBind();

    void onVHUnSelected();
}
