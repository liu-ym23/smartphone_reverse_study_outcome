package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.livesdkapi.barrage.ChangeSettingSource;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class b {
    public final o a;
    public final a b;

    public interface a {
        void dR();

        void sendLog(String r1, Map<String, String> r2);

        void yR(ChangeSettingSource r1);
    }

    public abstract int a();

    public void b() {
    }

    public void c(LayoutInflater r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
    }

    public void d() {
    }

    public void e() {
    }

    public final void f(Map r3) {
        Intrinsics.checkNotNullParameter("livesdk_preview_bullet_comment_setting_change", "name");
        this.b.sendLog("livesdk_preview_bullet_comment_setting_change", r3);
    }

    public b(o r2, SimpleZDanmakuSettingDialogFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuSetting");
        Intrinsics.checkNotNullParameter(r3, "panelCallback");
        this.a = r2;
        this.b = r3;
    }
}
