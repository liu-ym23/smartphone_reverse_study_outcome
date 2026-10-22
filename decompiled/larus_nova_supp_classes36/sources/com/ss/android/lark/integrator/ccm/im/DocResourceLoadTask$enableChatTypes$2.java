package com.ss.android.lark.integrator.ccm.im;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/integrator/ccm/im/PreloadDocConfig;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class DocResourceLoadTask$enableChatTypes$2 extends Lambda implements Function0<PreloadDocConfig> {
    public static final DocResourceLoadTask$enableChatTypes$2 INSTANCE = null;

    static {
        INSTANCE = new DocResourceLoadTask$enableChatTypes$2();
    }

    public DocResourceLoadTask$enableChatTypes$2() {
        super(0);
    }

    public final PreloadDocConfig invoke() {
        return (PreloadDocConfig) SettingManager.getInstance().get(PreloadDocConfig.class);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m886invoke() {
        return invoke();
    }
}
