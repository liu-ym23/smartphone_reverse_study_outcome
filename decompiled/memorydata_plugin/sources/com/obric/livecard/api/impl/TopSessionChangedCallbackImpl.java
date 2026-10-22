package com.obric.livecard.api.impl;

import android.os.SystemClock;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.livecard.api.ITopSessionChangedCallback;
import com.obric.livecard.api.entity.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/obric/livecard/api/impl/TopSessionChangedCallbackImpl;", "Lcom/obric/livecard/api/ITopSessionChangedCallback$Stub;", "Lcom/obric/livecard/api/impl/OnLiveCardServiceDiedListener;", "delegate", "Lcom/obric/livecard/api/impl/OnTopCardChangedListener;", "(Lcom/obric/livecard/api/impl/OnTopCardChangedListener;)V", "getDelegate", "()Lcom/obric/livecard/api/impl/OnTopCardChangedListener;", LocationMonitorConst.TAG, "", "getTag", "()J", "getId", "onServiceDied", "", "onTopSessionChanged", "session", "Lcom/obric/livecard/api/entity/IslandSession;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TopSessionChangedCallbackImpl extends ITopSessionChangedCallback.Stub implements OnLiveCardServiceDiedListener {
    private final OnTopCardChangedListener delegate;
    private final long tag;

    public TopSessionChangedCallbackImpl(OnTopCardChangedListener r3) {
        OnTopCardChangedListener r4 = (OnTopCardChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, OnTopCardChangedListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "delegate");
        this.delegate = r4;
        this.tag = SystemClock.elapsedRealtime();
    }

    public final OnTopCardChangedListener getDelegate() {
        return this.delegate;
    }

    @Override // com.obric.livecard.api.ITopSessionChangedCallback
    public long getId() {
        return this.tag;
    }

    public final long getTag() {
        return this.tag;
    }

    @Override // com.obric.livecard.api.impl.OnLiveCardServiceDiedListener
    public void onServiceDied() {
        this.delegate.onServiceDied();
    }

    @Override // com.obric.livecard.api.ITopSessionChangedCallback
    public void onTopSessionChanged(IslandSession r1) {
        this.delegate.onTopSessionChanged(r1);
    }
}
