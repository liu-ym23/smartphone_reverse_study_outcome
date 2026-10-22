package com.obric.memorydata.sdk.awareness.model;

import com.google.gson.Gson;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"locationInfoGson", "Lcom/google/gson/Gson;", "withCompatibleDefaults", "Lcom/obric/memorydata/sdk/awareness/model/LocationInfo$AoiInfo;", "memoryDataSDK_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Gson f12828a = null;

    static {
        f12828a = new Gson();
    }

    public static final /* synthetic */ Gson a() {
        return f12828a;
    }

    public static final /* synthetic */ LocationInfo.AoiInfo a(LocationInfo.AoiInfo r0) {
        return b(r0);
    }

    private static final LocationInfo.AoiInfo b(LocationInfo.AoiInfo r4) {
        String r0 = r4.getAoiId();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r4.getAoiName();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r3 = r4.getAoiType();
        if (r3 == null) goto L13;
        r1 = r3;
    L13:
        return r4.copy(r0, r2, r1);
    }
}
