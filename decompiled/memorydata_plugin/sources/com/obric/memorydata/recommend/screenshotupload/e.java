package com.obric.memorydata.recommend.screenshotupload;

import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J \u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/RawObservationImageUploadTaskRequestFactory;", "", "<init>", "()V", "forNewObservation", "Lcom/obric/memorydata/recommend/screenshotupload/RawObservationImageUploadTask;", "cellularEnabled", "", "enhancedTimelinessEnabled", "forSettingChange", "createTask", "existingTaskPolicy", "Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12556a = null;

    static {
        f12556a = new e();
    }

    private e() {
    }

    private final d a(boolean r3, boolean r4, ExistingTaskPolicy r5) {
        Condition[] r2 = new Condition[2];
        r2[0] = Condition.NETWORK_AVAILABLE;
        if (r4 == false) goto L5;
        Condition r0 = Condition.MEMORY_EXTRACT_POWER_CONTROL;
    L6:
        r2[1] = r0;
        List r6 = CollectionsKt.mutableListOf(r2);
        if (r4 == true) goto L9;
        r6.add(Condition.SCREEN_ON_OR_CHARGE);
    L9:
        if (r3 == true) goto L12;
        r6.add(Condition.WIFI_CONNECTED);
    L12:
        return new d(r6, r5);
    L5:
        r0 = Condition.COMMON_POWER_CONTROL;
        goto L6
    }

    public final d a(boolean r2, boolean r3) {
        return a(r2, r3, ExistingTaskPolicy.KEEP_IN_QUEUE);
    }

    public final d b(boolean r2, boolean r3) {
        return a(r2, r3, ExistingTaskPolicy.REPLACE_IN_QUEUE);
    }
}
