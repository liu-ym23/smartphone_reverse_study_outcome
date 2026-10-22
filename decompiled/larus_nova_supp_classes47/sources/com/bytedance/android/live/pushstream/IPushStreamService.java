package com.bytedance.android.live.pushstream;

import android.content.Context;
import android.view.SurfaceView;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import hh1.v0;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.pushstream.PushStreamService")
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\nH&J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0016\u001a\u00020\u0002H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006H&J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006H&J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001fH&J\n\u0010$\u001a\u0004\u0018\u00010#H&J\u0016\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u00010%H&J\n\u0010(\u001a\u0004\u0018\u00010#H&J\n\u0010*\u001a\u0004\u0018\u00010)H&J\b\u0010,\u001a\u00020+H&J\u0014\u0010-\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%H&J\u0014\u0010.\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%H&¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/pushstream/IPushStreamService;", "Lcom/bytedance/android/live/base/IService;", "", "init", "Lcom/bytedance/android/live/pushstream/u;", "config", "Lcom/bytedance/android/live/pushstream/d;", "createLiveStreamWithConfig", "Landroid/content/Context;", "context", "Lfi6/a;", "Lei6/a;", "createGuestClient", "Lhh1/v0;", "createGuestAudioFactory", "Lqv0/a;", "getLiveStreamController", "getRecordLiveStream", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lwv0/a;", "createStreamSignHelper", "releaseRecordLiveStream", "getPushLiveStream", "getLiveRoomStreamCache", "Landroid/view/SurfaceView;", "surfaceView", "liveStream", "Lnv0/a;", "getCameraCaptureInst", "getVoiceRoomCameraCaptureInst", "Lcom/bytedance/android/live/pushstream/report/c;", "statusResultListener", "Lcom/bytedance/android/live/pushstream/report/a;", "getStreamReporter", "Lorg/json/JSONObject;", "getLiveCoreDebugInfo", "", "", "getFpsInfo", "getClientDebugInfo", "Luf2/d0$a;", "getLiveCoreBuilder", "", "getRenderFps", "getLastAudioCaptureLogMap", "getLastVideoCaptureLogMap", "livepushstream-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPushStreamService extends IService {
    v0 createGuestAudioFactory(Context r1);

    ei6.a createGuestClient(Context r1, fi6.a r2);

    d createLiveStreamWithConfig(u r1);

    wv0.a createStreamSignHelper(IRoom r1);

    nv0.a getCameraCaptureInst(SurfaceView r1, d r2);

    JSONObject getClientDebugInfo();

    Map<String, String> getFpsInfo();

    Map<String, String> getLastAudioCaptureLogMap();

    Map<String, String> getLastVideoCaptureLogMap();

    d0.a getLiveCoreBuilder();

    JSONObject getLiveCoreDebugInfo();

    d getLiveRoomStreamCache();

    qv0.a getLiveStreamController(Context r1);

    d getPushLiveStream();

    d getRecordLiveStream(Context r1);

    double getRenderFps();

    com.bytedance.android.live.pushstream.report.a getStreamReporter(IRoom r1, com.bytedance.android.live.pushstream.report.c r2);

    nv0.a getVoiceRoomCameraCaptureInst(SurfaceView r1, d r2);

    void init();

    void releaseRecordLiveStream();
}
