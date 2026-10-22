package com.ss.android.lark.keyboard.plugin.tool.voice;

import android.content.Context;
import com.ss.android.lark.biz.im.api.param.IMConstants;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class KeyboardVoiceModule {
    public static final Lazy a = null;

    public interface a {
        IMConstants.NetworkLevel getCurNetWorkLevel();

        Locale getCurrentLocale();

        c getProfileDependency();

        d getVcDependency();

        boolean isCurrentFeatureEnable(String r1);

        boolean isEn();

        boolean isFeatureGatingEnable(String r1);

        boolean isZh();
    }

    public interface b {
    }

    public interface c {
        void a(Context r1, String r2);
    }

    public interface d {
        void a();

        void b();
    }

    static {
        a = LazyKt.lazy(KeyboardVoiceModule$dependency$2.INSTANCE);
    }

    public static final a a() {
        return (a) a.getValue();
    }
}
