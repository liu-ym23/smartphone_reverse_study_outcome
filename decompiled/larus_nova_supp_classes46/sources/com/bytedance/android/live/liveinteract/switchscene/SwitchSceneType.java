package com.bytedance.android.live.liveinteract.switchscene;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/switchscene/SwitchSceneType;", "", "Request", "Message", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SwitchSceneType extends Enum<SwitchSceneType> {
    public static final SwitchSceneType Message = null;
    public static final SwitchSceneType Request = null;
    public static final /* synthetic */ SwitchSceneType[] a = null;

    static {
        SwitchSceneType r1 = new SwitchSceneType("Request", 0);
        Request = r1;
        SwitchSceneType r2 = new SwitchSceneType("Message", 1);
        Message = r2;
        a = new SwitchSceneType[]{r1, r2};
    }

    public static SwitchSceneType valueOf(String r1) {
        return (SwitchSceneType) a.a(SwitchSceneType.class, r1);
    }

    public static SwitchSceneType[] values() {
        return (SwitchSceneType[]) a.clone();
    }

    public SwitchSceneType(String r1, int r2) {
        super(r1, r2);
    }
}
