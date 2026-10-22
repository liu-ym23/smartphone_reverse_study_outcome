package com.obric.memorydata.recommend.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/recommend/settings/BlockMemoryRuleChangePublisher;", "", "changePublisher", "Lcom/obric/memorydata/recommend/settings/RecorderSettingsChangePublisher;", "<init>", "(Lcom/obric/memorydata/recommend/settings/RecorderSettingsChangePublisher;)V", "publishAfterInsert", "", "insertId", "", "publishAfterRowsChanged", "changedRows", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f12600a;

    public e(m r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "changePublisher");
        this.f12600a = r4;
    }

    public final void a(int r1) {
        if (r1 <= 0) goto L5;
        this.f12600a.publish("content://com.obric.memorydata.memory.ailabprovider/recorder_settings/block_rules");
        return;
    }

    public final void a(long r3) {
        if (r3 <= 0) goto L6;
        this.f12600a.publish("content://com.obric.memorydata.memory.ailabprovider/recorder_settings/block_rules");
        return;
    }
}
