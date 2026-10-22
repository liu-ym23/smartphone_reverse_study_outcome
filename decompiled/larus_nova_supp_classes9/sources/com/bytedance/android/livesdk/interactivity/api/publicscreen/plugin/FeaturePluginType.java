package com.bytedance.android.livesdk.interactivity.api.publicscreen.plugin;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/plugin/FeaturePluginType;", BuildConfig.FLAVOR, "ChatRoomAuth", "AudioMessagePlay", "ChatLike", "FloatMessageExit", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FeaturePluginType extends Enum<FeaturePluginType> {
    public static final FeaturePluginType AudioMessagePlay = null;
    public static final FeaturePluginType ChatLike = null;
    public static final FeaturePluginType ChatRoomAuth = null;
    public static final FeaturePluginType FloatMessageExit = null;
    public static final /* synthetic */ FeaturePluginType[] a = null;

    static {
        FeaturePluginType r1 = new FeaturePluginType("ChatRoomAuth", 0);
        ChatRoomAuth = r1;
        FeaturePluginType r2 = new FeaturePluginType("AudioMessagePlay", 1);
        AudioMessagePlay = r2;
        FeaturePluginType r3 = new FeaturePluginType("ChatLike", 2);
        ChatLike = r3;
        FeaturePluginType r4 = new FeaturePluginType("FloatMessageExit", 3);
        FloatMessageExit = r4;
        a = new FeaturePluginType[]{r1, r2, r3, r4};
    }

    public static FeaturePluginType valueOf(String r1) {
        return (FeaturePluginType) a.a(FeaturePluginType.class, r1);
    }

    public static FeaturePluginType[] values() {
        return (FeaturePluginType[]) a.clone();
    }

    public FeaturePluginType(String r1, int r2) {
        super(r1, r2);
    }
}
