package n3;

import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.ai.settings.provider.RelaxConfig;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RelaxConfig f20200a = null;

    static {
        f20200a = AISDKSettingConfigManager.INSTANCE.getRELAX_CONFIG().getValue();
    }
}
