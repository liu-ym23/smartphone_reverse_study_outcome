package com.bytedance.android.live.room;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface g {

    public interface a {
        void a(String r1);
    }

    public interface b {
        void b(String r1, String r2, IThemeShowArea r3, ThemeUpLoadListener r4, int r5);

        void c();

        void e(String r1, String r2, String r3);

        void g(String r1, int r2);

        void h();

        void onCanceled();

        void onError(String r1);
    }
}
