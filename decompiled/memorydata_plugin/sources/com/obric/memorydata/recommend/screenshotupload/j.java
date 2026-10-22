package com.obric.memorydata.recommend.screenshotupload;

import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.impl.settings.AppSettingsManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"VIEW_TREE_CONTEXT_ENABLED", "", "getVIEW_TREE_CONTEXT_ENABLED", "()Z", "recommend_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class j {
    public static final boolean a() {
        if (AppSettingsManager.INSTANCE.getRecommendSettings().getObservationCollectViewTree() == 1) goto L5;
    L9:
        return false;
    L5:
        if (AppContext.INSTANCE.isDebug() == false) goto L7;
        return true;
    L7:
        if (com.obric.memorydata.database.c.b.f8850a.a() == false) goto L9;
        return true;
    }
}
