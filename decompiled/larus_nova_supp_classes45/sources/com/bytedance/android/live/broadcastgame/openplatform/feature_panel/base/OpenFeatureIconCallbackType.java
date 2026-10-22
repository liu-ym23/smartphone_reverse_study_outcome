package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/base/OpenFeatureIconCallbackType;", "", "START_BUTTON", "DEBUG_BUTTON", "ITEM_CONTENT", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenFeatureIconCallbackType extends Enum<OpenFeatureIconCallbackType> {
    public static final OpenFeatureIconCallbackType DEBUG_BUTTON = null;
    public static final OpenFeatureIconCallbackType ITEM_CONTENT = null;
    public static final OpenFeatureIconCallbackType START_BUTTON = null;
    public static final /* synthetic */ OpenFeatureIconCallbackType[] a = null;

    static {
        OpenFeatureIconCallbackType r1 = new OpenFeatureIconCallbackType("START_BUTTON", 0);
        START_BUTTON = r1;
        OpenFeatureIconCallbackType r2 = new OpenFeatureIconCallbackType("DEBUG_BUTTON", 1);
        DEBUG_BUTTON = r2;
        OpenFeatureIconCallbackType r3 = new OpenFeatureIconCallbackType("ITEM_CONTENT", 2);
        ITEM_CONTENT = r3;
        a = new OpenFeatureIconCallbackType[]{r1, r2, r3};
    }

    public static OpenFeatureIconCallbackType valueOf(String r1) {
        return (OpenFeatureIconCallbackType) a.a(OpenFeatureIconCallbackType.class, r1);
    }

    public static OpenFeatureIconCallbackType[] values() {
        return (OpenFeatureIconCallbackType[]) a.clone();
    }

    public OpenFeatureIconCallbackType(String r1, int r2) {
        super(r1, r2);
    }
}
