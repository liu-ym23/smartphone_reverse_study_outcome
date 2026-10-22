package com.obric.memorydata.personalcontext;

import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.intelligence.api.UserProfileLabel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/EntitySyncTaskDataProvider;", "Lcom/obric/memorydata/personalcontext/task/IEntitySyncTaskDataProvider;", "<init>", "()V", "getSleepMoments", "", "", "getSleepStartTimeOffsetDelayTime", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f12227a = null;

    static {
        f12227a = new k();
    }

    private k() {
    }

    public List<String> a() {
        return (List) ZeusTransformUtils.preCheckCast(CollectionsKt.arrayListOf(new String[]{UserProfileLabel.INSTANCE.querySleepMoment(), UserProfileLabel.INSTANCE.queryWakeupMoment()}), List.class, "com.obric.memorydata.plugin");
    }

    public String b() {
        String r6 = UserProfileLabel.INSTANCE.querySleepMoment();
        if (ZeusTransformUtils.instanceOf(r6, String.class) == true) goto L6;
        r6 = null;
    L6:
        if (r6 == null) goto L11;
        Integer r7 = com.obric.memorydata.utils.r.c(r6);
        if (r7 != null) goto L10;
        return null;
    L10:
        return com.obric.memorydata.utils.r.a((int) ((((((long) ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue()) * 60000) + 600000) % WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) / 60000));
    L11:
        return null;
    }
}
