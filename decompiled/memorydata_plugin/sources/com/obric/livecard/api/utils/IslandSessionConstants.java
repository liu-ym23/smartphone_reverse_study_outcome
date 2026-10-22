package com.obric.livecard.api.utils;

import com.obric.livecard.api.LiveCardType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/livecard/api/utils/IslandSessionConstants;", "", "()V", "FLAG_HIDE_BATTERY_ICON", "", "FLAG_NONE", "TYPE_NONE", "resolveFlags", "sessionType", "typeFromLiveCardType", "type", "Lcom/obric/livecard/api/LiveCardType;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IslandSessionConstants {
    public static final int FLAG_HIDE_BATTERY_ICON = 1;
    public static final int FLAG_NONE = 0;
    public static final IslandSessionConstants INSTANCE = null;
    public static final int TYPE_NONE = 0;

    static {
        INSTANCE = new IslandSessionConstants();
    }

    private IslandSessionConstants() {
    }

    public final int resolveFlags(int r2) {
        if (r2 != (LiveCardType.BATTERY.ordinal() + 1)) goto L5;
        return 1;
    L5:
        return 0;
    }

    public final int typeFromLiveCardType(LiveCardType r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.ordinal() + 1;
    }
}
