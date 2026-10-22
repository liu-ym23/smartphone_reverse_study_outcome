package com.bytedance.android.live.broadcast.api.framework.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import xz.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcast.refactoring.framework.impl.service.LiveAVResourceService")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\b\u0010\u000e\u001a\u00020\u0006H&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH&J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0004H&J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/service/ILiveAVResourceService;", "Lcom/bytedance/android/live/base/IService;", "", "initPolicy", "Lzz/a;", "request", "", "requestAVResourceChange", "Lwz/a;", "provider", "Lcom/bytedance/android/live/broadcast/api/framework/common/a;", "registerProvider", "getAudioCaptureState", "getAudioMuteState", "getVideoCaptureState", "Lio/reactivex/Observable;", "getAudioCaptureStateWithLast", "getAudioMuteStateWithLast", "getVideoCaptureStateWithLast", "", "identityId", "byPassMonitorStart", "releaseByPassMonitor", "Lxz/a;", "getAVStatePolicyRepository", "getLastAVResourceRequest", "", "getValidContextProviders", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveAVResourceService extends IService {
    void byPassMonitorStart(String r1);

    a getAVStatePolicyRepository();

    boolean getAudioCaptureState();

    Observable<Boolean> getAudioCaptureStateWithLast();

    boolean getAudioMuteState();

    Observable<Boolean> getAudioMuteStateWithLast();

    zz.a getLastAVResourceRequest();

    List<wz.a> getValidContextProviders();

    boolean getVideoCaptureState();

    Observable<Boolean> getVideoCaptureStateWithLast();

    void initPolicy();

    com.bytedance.android.live.broadcast.api.framework.common.a registerProvider(wz.a r1);

    void releaseByPassMonitor(String r1);

    boolean requestAVResourceChange(zz.a r1);
}
