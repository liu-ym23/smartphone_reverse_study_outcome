package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface n {

    public interface a {
        void onCancel();

        void onFinish();
    }

    void RE(a r1);

    void V4(FragmentManager r1);

    void dismissDialog();
}
