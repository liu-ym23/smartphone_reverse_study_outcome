package com.obric.memorydata.memory.glasses;

import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0000\u001a\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0012H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"GLASSES_CONNECTION_GENERATION_KEY", "", "FORCE_DEBUG_PULL_KEY", "FORCE_HOTWORDS_SYNC_KEY", "FORCE_HOTWORDS_UPLOAD_KEY", "CLEAR_HOTWORDS_AFTER_DISCONNECT_KEY", "RECORD_REQUEST_HISTORY_KEY", "GLASSES_WINDOW_START_KEY", "GLASSES_WINDOW_END_KEY", "GLASSES_OBSERVATION_SYNC_INTERVAL_MINUTES", "", "GLASSES_OBSERVATION_SYNC_CONDITIONS", "", "Lcom/obric/memorydata/task/condition/Condition;", "getGLASSES_OBSERVATION_SYNC_CONDITIONS", "()Ljava/util/List;", "glassesObservationSyncConditions", "wearing", "", "cellularUploadEnabled", "glassesHotwordsDisconnectClearSpec", "Lcom/obric/memorydata/memory/glasses/GlassesHotwordsDisconnectClearSpec;", PendingPersonalInfoNotificationTask.KEY_GENERATION, "isDebug", "resolveGlassesObservationSyncWindow", "Lcom/obric/memorydata/memory/glasses/GlassesObservationSyncWindow;", "lastSuccessWindowEndMs", "currentTimeMs", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Condition> f10142a = null;

    static {
        f10142a = CollectionsKt.listOf(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE});
    }

    public static final b a(long r9, boolean r11) {
        List r4 = CollectionsKt.listOf(Condition.NETWORK_AVAILABLE);
        if (r11 == false) goto L5;
        long r0 = 2;
    L7:
        return new b("glasses_observation_sync", r9, r4, r0, ExistingTaskPolicy.REPLACE_IN_QUEUE);
    L5:
        r0 = 120;
        goto L7
    }

    public static final List<Condition> a(boolean r2, boolean r3) {
        if (r2 == false) goto L4;
        List<Condition> r4 = CollectionsKt.mutableListOf(new Condition[]{Condition.NETWORK_AVAILABLE});
    L5:
        if (r3 == true) goto L7;
        r4.add(Condition.WIFI_CONNECTED);
    L7:
        return r4;
    L4:
        r4 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(f10142a, Collection.class, "com.obric.memorydata.plugin"));
        goto L5
    }
}
