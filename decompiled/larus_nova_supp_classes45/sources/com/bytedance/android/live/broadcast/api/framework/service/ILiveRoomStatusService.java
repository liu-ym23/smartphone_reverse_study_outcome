package com.bytedance.android.live.broadcast.api.framework.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.broadcast.api.framework.common.AnchorRoomStatus;
import com.bytedance.android.live.broadcast.api.framework.common.b;
import com.bytedance.android.live.core.arch.mvvm.d;
import com.bytedance.android.live.utility.ServiceLookup;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import yz.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcast.refactoring.framework.impl.service.LiveRoomStatusService")
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\bH&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0002H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u0019\u001a\u00020\u0018H&J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aH&J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001cH&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\n\u0010 \u001a\u0004\u0018\u00010\u0004H&J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0!H\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/service/ILiveRoomStatusService;", "Lcom/bytedance/android/live/base/IService;", "", "initPolicyContext", "Lzz/b;", "request", "", "requestRoomStateUpdate", "", "policyId", "Lcom/bytedance/android/live/broadcast/api/framework/common/b;", "activatePredefinedRoomStatusPolicy", "category", "activateRoomStatePoliciesWithCategory", "Lwz/a;", "provider", "Lcom/bytedance/android/live/broadcast/api/framework/common/a;", "registerProvider", "Luz/a;", "liveAnchorRoomStateContext", "setLiveAnchorRoomStateContext", "clearLiveAnchorRoomStateContext", "Lyz/a;", "getFloatWindowManager", "Lcom/bytedance/android/live/broadcast/api/framework/common/AnchorRoomStatus;", "getCurrentRoomState", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "getCurrentRoomStateWithOptional", "Lio/reactivex/Observable;", "getCurrentRoomStateWithLast", "Lxz/b;", "getRoomStatePolicyRepository", "getLastRoomStateRequest", "", "getValidContextProviders", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRoomStatusService extends IService {
    b activatePredefinedRoomStatusPolicy(String r1);

    b activateRoomStatePoliciesWithCategory(String r1);

    void clearLiveAnchorRoomStateContext();

    AnchorRoomStatus getCurrentRoomState();

    Observable<AnchorRoomStatus> getCurrentRoomStateWithLast();

    d<AnchorRoomStatus> getCurrentRoomStateWithOptional();

    a getFloatWindowManager();

    zz.b getLastRoomStateRequest();

    xz.b getRoomStatePolicyRepository();

    List<wz.a> getValidContextProviders();

    void initPolicyContext();

    com.bytedance.android.live.broadcast.api.framework.common.a registerProvider(wz.a r1);

    boolean requestRoomStateUpdate(zz.b r1);

    void setLiveAnchorRoomStateContext(uz.a r1);
}
