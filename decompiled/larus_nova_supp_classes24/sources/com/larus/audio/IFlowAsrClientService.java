package com.larus.audio;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.s2;
import com.larus.asr.t2;
import com.larus.asr.u2;
import com.larus.audio.asr.r;
import com.larus.audio.asr.r0;
import com.larus.audio.asr.w;
import com.larus.audio.audiov3.audio.record.AsrClientStatus;
import com.larus.audio.report.h;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h68.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\bg\u0018\u0000 I2\u00020\u0001:\u0001IJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&J8\u0010\u0013\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\rH&J\\\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b28\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u009a\u0001\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2:\b\u0002\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u001d2:\b\u0002\u0010$\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020%\u0018\u00010\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H&J\u001c\u0010&\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\u001bH&J\u0012\u0010'\u001a\u00020(2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010)\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010*\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0,H&J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0,H&J\u0012\u0010.\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010/\u001a\u0002002\u0006\u0010\f\u001a\u00020\rH&J6\u00101\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010\u00012\b\u00104\u001a\u0004\u0018\u00010\u00012\b\u00105\u001a\u0004\u0018\u00010\u0001H&J\u0010\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u000208H&J\u0018\u00109\u001a\u00020%2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001bH&J\u001a\u0010:\u001a\u0004\u0018\u00010%2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001bH&J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020%H&J\u0018\u0010=\u001a\u00020!2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001bH&JK\u0010>\u001a\u00020?2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010@\u001a\u00020A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00072%\b\u0002\u0010C\u001a\u001f\u0012\u0013\u0012\u00110E¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u0005\u0018\u00010DH&Jl\u0010>\u001a\u00020?2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u00072#\u0010C\u001a\u001f\u0012\u0013\u0012\u00110E¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u0005\u0018\u00010D2#\u0010G\u001a\u001f\u0012\u0013\u0012\u00110(¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\u0005\u0018\u00010DH\u0016¨\u0006J"}, d2 = {"Lcom/larus/audio/IFlowAsrClientService;", "", "getRecordStatus", "Lcom/larus/audio/audiov3/audio/record/AsrClientStatus;", "addAsrAudioDataListener", "", "listener", "Lcom/larus/audio/audiov3/asr/AsrAudioDataListener;", "releaseAudioRecordFinal", "addAsrStateListener", "Lcom/larus/audio/audiov3/asr/AsrStateListener;", "configTracer", "taskId", "", "tracer", "Lcom/larus/audio/report/IAsrTracer;", "setAsrRetryStrategy", "strategy", "Lcom/larus/audio/audiov3/asr/strategy/AsrRetryStrategy;", "configAsrSenseReporter", "asrMode", "language", "i", "", "botId", "startAsr", "asrData", "Lcom/larus/audio/audiov3/config/task/sami/asr/AsrConfig;", "dataSourceProvider", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "asrConfig", "Lcom/larus/audio/audiov3/task/asr/IAsrDataSource;", "asrListener", "Lcom/larus/audio/audiov3/task/asr/IAsrListener;", "taskProvider", "Lcom/larus/audio/audiov3/task/asr/IAsrTask;", "handleResend", "stopAsr", "", "cancelAsr", "releaseAsrTask", "getTaskIds", "", "getRunningTaskIds", "getAsrConfig", "getRecordAudioDuration", "", "updateScreenshotForAsr", "context", "id", "type", "param", "registerAsrTaskFactory", "factory", "Lcom/larus/audio/audiov3/task/asr/IAsrTaskFactory;", "createAsrTask", "createManagedAsrTask", "releaseManagedAsrTask", "task", "createDefaultAsrDataSource", "createAudioRecord", "Lcom/bytedance/flow_audio/api/foundation/record/IAudioRecord;", "config", "Lcom/bytedance/flow_audio/api/config/session/FlowAudioSessionConfig;", "audioDataListener", "firstAudioDataListener", "Lkotlin/Function1;", "", "data", "audioFileSaveResultListener", "success", "Companion", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface IFlowAsrClientService {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static IFlowAsrClientService a() {
            return (IFlowAsrClientService) ServiceManager.get().getService(IFlowAsrClientService.class);
        }
    }

    static {
        a = a.a;
    }

    void a(String r1, y58.a r2, Function2 r3, Function2 r4, com.larus.audio.asr.i r5);

    void b(String r1, y58.a r2);

    e c(String r1, y58.a r2);

    void d(n58.a r1);

    e e(String r1, y58.a r2);

    void f(String r1);

    y58.a g(String r1);

    void h(o58.b r1);

    void i(String r1, h r2);

    void j(String r1);

    r0 k(String r1, y58.a r2);

    r l(String r1, qw5.a r2, s2 r3, t2 r4, u2 r5);

    void m();

    List<String> n();

    List<String> o();

    long p(String r1);

    void q(String r1, String r2, Object r3, Object r4, Object r5);

    boolean r(String r1);

    void s(String r1, String r2, String r3, int r4, String r5);

    AsrClientStatus t();

    void u(w r1);

    void v(e r1);
}
