package com.ss.android.lark.chat.utils;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatSizeUtils$botInWorkplaceOpt$2 extends Lambda implements Function0<Boolean> {
    public static final ChatSizeUtils$botInWorkplaceOpt$2 INSTANCE = null;

    static {
        INSTANCE = new ChatSizeUtils$botInWorkplaceOpt$2();
    }

    public ChatSizeUtils$botInWorkplaceOpt$2() {
        super(0);
    }

    public final Boolean invoke() {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.workplace.open_bot.size_plugin_disalbed") == false) goto L5;
    L7:
        boolean r0 = false;
    L9:
        return Boolean.valueOf(r0);
    L5:
        if (ForsetiConfig.b() == false) goto L7;
        r0 = true;
        goto L9
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m723invoke() {
        return invoke();
    }
}
