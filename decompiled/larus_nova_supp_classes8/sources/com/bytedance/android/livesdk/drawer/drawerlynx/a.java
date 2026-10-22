package com.bytedance.android.livesdk.drawer.drawerlynx;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/drawerlynx/a;", "", "Lcom/google/gson/JsonObject;", "trackContext", "Lcom/google/gson/JsonObject;", "getTrackContext", "()Lcom/google/gson/JsonObject;", "setTrackContext", "(Lcom/google/gson/JsonObject;)V", "Lcom/bytedance/android/livesdk/drawer/drawerlynx/e;", "context", "Lcom/bytedance/android/livesdk/drawer/drawerlynx/e;", "getContext", "()Lcom/bytedance/android/livesdk/drawer/drawerlynx/e;", "setContext", "(Lcom/bytedance/android/livesdk/drawer/drawerlynx/e;)V", "", "Lcom/bytedance/android/livesdk/feed/feed/e;", "tabData", "Ljava/util/List;", "getTabData", "()Ljava/util/List;", "setTabData", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "originTrackContext", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getOriginTrackContext", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setOriginTrackContext", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("context")
    private e context;

    @SerializedName("origin_track_context")
    private Room originTrackContext;

    @SerializedName("tab_data")
    private List<? extends com.bytedance.android.livesdk.feed.feed.e> tabData;

    @SerializedName("track_context")
    private JsonObject trackContext;

    public a() {
        this(null, null, null, 15);
    }

    public final e getContext() {
        return this.context;
    }

    public a(JsonObject r3, e r4, List r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = null;
    L11:
        this.trackContext = r3;
        this.context = r4;
        this.tabData = r5;
        this.originTrackContext = null;
    }
}
