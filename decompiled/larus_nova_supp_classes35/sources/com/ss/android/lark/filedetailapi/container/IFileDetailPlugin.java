package com.ss.android.lark.filedetailapi.container;

import android.content.Context;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IFileDetailPlugin {
    public static final int TYPE_HIGH = 1;
    public static final int TYPE_LOW = 3;
    public static final int TYPE_MIDDLE = 2;

    boolean canPreview(String r1);

    void checkAndInit();

    Fragment getLocalPreviewFragment(Context r1, String r2, String r3);

    int getPriority();
}
