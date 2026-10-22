package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.api.publicscreen.a$a, reason: collision with other inner class name */
    public interface InterfaceC0093a {
        void a(Integer r1, Integer r2);

        void onCancel();
    }

    void V4(FragmentManager r1);

    void dismissDialog();

    void fP(InterfaceC0093a r1);
}
