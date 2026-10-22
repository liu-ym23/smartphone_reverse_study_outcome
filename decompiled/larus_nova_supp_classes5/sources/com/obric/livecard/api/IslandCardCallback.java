package com.obric.livecard.api;

import android.os.Bundle;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J!\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH'J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/obric/livecard/api/IslandCardCallback;", "", "onSessionActive", "", "session", "Lcom/obric/livecard/api/entity/IslandSession;", "onSessionCreate", "onSessionDestroy", "reason", "", "(Lcom/obric/livecard/api/entity/IslandSession;Ljava/lang/Integer;)V", "onSessionDisplayStatusChanged", "status", "onSessionInactive", "onSessionStatusChanged", "onWidgetShow", "Landroid/os/Bundle;", "widget", "Lcom/obric/livecard/api/entity/IslandWidget;", "Companion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IslandCardCallback {
    public static final Companion Companion = null;
    public static final int LIVE_CARD_DISABLE = 4;
    public static final int NO_PERMISSION = 3;
    public static final int ON_LIVE_CARD_DIED = 1;
    public static final int ON_LIVE_CARD_PLUGIN_DISCONNECTED = 6;
    public static final int ON_LIVE_CARD_SLIDE_UP_CANCEL = 2;
    public static final int ON_LIVE_CARD_SWIPE_TO_CANCEL = 5;

    static {
        Companion = Companion.$$INSTANCE;
    }

    void onSessionActive(IslandSession r1);

    void onSessionCreate(IslandSession r1);

    void onSessionDestroy(IslandSession r1, Integer r2);

    void onSessionDisplayStatusChanged(IslandSession r1, int r2);

    void onSessionInactive(IslandSession r1);

    void onSessionStatusChanged(IslandSession r1, int r2);

    Bundle onWidgetShow(IslandWidget r1);
}
