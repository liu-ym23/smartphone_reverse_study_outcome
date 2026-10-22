package com.bytedance.android.live.room.api.messagewindow.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/model/CommonCardInitScene;", "", "ROOM_ENTER", "ROOM_MSG", "RELOAD", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommonCardInitScene extends Enum<CommonCardInitScene> {
    public static final CommonCardInitScene RELOAD = null;
    public static final CommonCardInitScene ROOM_ENTER = null;
    public static final CommonCardInitScene ROOM_MSG = null;
    public static final /* synthetic */ CommonCardInitScene[] a = null;

    static {
        CommonCardInitScene r1 = new CommonCardInitScene("ROOM_ENTER", 0);
        ROOM_ENTER = r1;
        CommonCardInitScene r2 = new CommonCardInitScene("ROOM_MSG", 1);
        ROOM_MSG = r2;
        CommonCardInitScene r3 = new CommonCardInitScene("RELOAD", 2);
        RELOAD = r3;
        a = new CommonCardInitScene[]{r1, r2, r3};
    }

    public static CommonCardInitScene valueOf(String r1) {
        return (CommonCardInitScene) a.a(CommonCardInitScene.class, r1);
    }

    public static CommonCardInitScene[] values() {
        return (CommonCardInitScene[]) a.clone();
    }

    public CommonCardInitScene(String r1, int r2) {
        super(r1, r2);
    }
}
