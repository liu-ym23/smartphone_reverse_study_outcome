package vab;

import com.ss.android.lark.im.sdk.ImSdkProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final boolean a = false;
    public static final boolean b = false;
    public static final boolean c = false;

    static {
        a = ImSdkProxy.c().isFeatureGatingEnable("messagecard.translate.support");
        b = ImSdkProxy.c().isFeatureGatingEnable("messagecard.translate.force_enable_translate");
        c = ImSdkProxy.c().isFeatureGatingEnable("messenger.setting.mention_user_group");
    }
}
