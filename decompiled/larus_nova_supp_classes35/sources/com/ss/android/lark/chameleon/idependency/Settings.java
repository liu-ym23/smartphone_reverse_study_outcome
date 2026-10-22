package com.ss.android.lark.chameleon.idependency;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/idependency/Settings;", BuildConfig.FLAVOR, "()V", "sSettings", "Lcom/ss/android/lark/chameleon/idependency/ISettings;", "getSSettings", "()Lcom/ss/android/lark/chameleon/idependency/ISettings;", "setSSettings", "(Lcom/ss/android/lark/chameleon/idependency/ISettings;)V", "isDDXMLEnabled", BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Settings {
    public static final Settings INSTANCE = null;
    private static ISettings sSettings;

    static {
        INSTANCE = new Settings();
    }

    private Settings() {
    }

    @JvmStatic
    public static final boolean isDDXMLEnabled() {
        ISettings r0 = sSettings;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isDDXMLEnabled() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final ISettings getSSettings() {
        return sSettings;
    }

    public final void setSSettings(ISettings r1) {
        sSettings = r1;
    }
}
