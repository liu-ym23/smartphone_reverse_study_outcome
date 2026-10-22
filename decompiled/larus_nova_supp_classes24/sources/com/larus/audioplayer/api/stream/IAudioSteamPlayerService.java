package com.larus.audioplayer.api.stream;

import c88.a;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.doc.impl.DocFragment;
import kotlin.Metadata;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&Jj\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH&J\u001c\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\tH&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH&J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\tH&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0016\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010!H&J\n\u0010\"\u001a\u0004\u0018\u00010#H&¨\u0006$"}, d2 = {"Lcom/larus/audioplayer/api/stream/IAudioSteamPlayerService;", "", "addInterceptor", "", "interceptor", "Lcom/larus/audioplayer/api/stream/IStreamPlayerInterceptor;", "removeInterceptor", "start", "appletId", "", "title", "artist", "coverUrl", "url", "uuid", "listener", "Lcom/larus/audioplayer/api/IOnStreamPlayerStatesChangeListener;", "inputTimeOff", "", "scene", "extra", "Lorg/json/JSONObject;", "reason", "pause", "resume", "stop", "getCurPlayingStatus", "getCurPlayTime", "", "changePlaySpeed", "newPlaySpeed", "", "getCurPlaying", "Lkotlin/Pair;", "getCurrentAudioSteamData", "Lcom/larus/audioplayer/api/stream/AudioSteamData;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface IAudioSteamPlayerService {
    void a(String r1, String r2);

    long b(String r1);

    void c(String r1, String r2, String r3, String r4, String r5, String r6, int r7, String r8, JSONObject r9);

    String d(String r1);

    void e(String r1, String r2);

    a f();

    void g(DocFragment.d r1);

    Pair<String, String> h();

    void i(DocFragment.d r1);

    void j(String r1, String r2);

    void k(String r1, float r2);
}
