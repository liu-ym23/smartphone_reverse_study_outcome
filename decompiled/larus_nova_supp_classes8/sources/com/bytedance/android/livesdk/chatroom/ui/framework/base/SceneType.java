package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/SceneType;", "", "ANCHOR_PORTRAIT", "AUDIENCE_LANDSCAPE", "AUDIENCE_PORTRAIT", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SceneType extends Enum<SceneType> {
    public static final SceneType ANCHOR_PORTRAIT = null;
    public static final SceneType AUDIENCE_LANDSCAPE = null;
    public static final SceneType AUDIENCE_PORTRAIT = null;
    public static final /* synthetic */ SceneType[] a = null;

    static {
        SceneType r1 = new SceneType("ANCHOR_PORTRAIT", 0);
        ANCHOR_PORTRAIT = r1;
        SceneType r2 = new SceneType("AUDIENCE_LANDSCAPE", 1);
        AUDIENCE_LANDSCAPE = r2;
        SceneType r3 = new SceneType("AUDIENCE_PORTRAIT", 2);
        AUDIENCE_PORTRAIT = r3;
        a = new SceneType[]{r1, r2, r3};
    }

    public static SceneType valueOf(String r1) {
        return (SceneType) r27.a.a(SceneType.class, r1);
    }

    public static SceneType[] values() {
        return (SceneType[]) a.clone();
    }

    public SceneType(String r1, int r2) {
        super(r1, r2);
    }
}
