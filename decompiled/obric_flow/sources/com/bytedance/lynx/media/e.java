package com.bytedance.lynx.media;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.widget.FrameLayout;
import com.bytedance.lynx.media.playable.IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType;
import com.lynx.base.log.LynxLog;
import com.ss.ttvideoengine.DataSource;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import g8.g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sf.a f6820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f6821b;

    public e(final Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5);
        this.f6821b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LynxMediaEngineBaseView$mAudioFocusManager$2(r5));
    }

    private final qf.a getMAudioFocusManager() {
        return (qf.a) this.f6821b.getValue();
    }

    public final void a(a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        LynxLog.b(2, "LynxMediaEngineBaseView", "invoke abandonAudioFocus");
        if (this.f6820a == null) goto L8;
        qf.a r10 = getMAudioFocusManager();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "listener");
        AudioFocusRequest r11 = r10.f21507b;
        if (r11 == null) goto L9;
        r10.f21506a.abandonAudioFocusRequest(r11);
        return;
    L9:
        return;
    }

    public final void b(g r5) {
        sf.a r10 = this.f6820a;
        if (r10 == null) goto L13;
        LynxLog.b(2, "LynxMediaEngineBaseView", "invoke pause");
        uf.b r11 = ((sf.d) r10).f21895b;
        if (r11 != null) goto L7;
    L10:
        if (r5 == null) goto L14;
        r5.f(0, 0, null);
        return;
    L14:
        return;
    L7:
        if (r11.c() == false) goto L10;
        r11.f22339b.l();
        goto L10
    }

    public abstract boolean c();

    public abstract void d();

    public final void e(a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        LynxLog.b(2, "LynxMediaEngineBaseView", "invoke requestAudioFocus");
        if (this.f6820a == null) goto L6;
        qf.a r10 = getMAudioFocusManager();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "listener");
        AudioAttributes r11 = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        AudioFocusRequest r12 = new AudioFocusRequest.Builder(1).setAudioAttributes(r11).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(r5).build();
        r10.f21507b = r12;
        Intrinsics.checkNotNull(r12);
        r10.f21506a.requestAudioFocus(r12);
        return;
    }

    public abstract void f(g r5);

    public final void g(g r5) {
        sf.a r10 = this.f6820a;
        if (r10 == null) goto L13;
        LynxLog.b(2, "LynxMediaEngineBaseView", "invoke stop");
        uf.b r11 = ((sf.d) r10).f21895b;
        if (r11 != null) goto L7;
    L10:
        if (r5 == null) goto L14;
        r5.f(0, 0, null);
        return;
    L14:
        return;
    L7:
        if (r11.c() == false) goto L10;
        r11.f22339b.o();
        goto L10
    }

    public final sf.a getMediaView() {
        return this.f6820a;
    }

    public final void setDataSource(DataSource r5) {
        if (r5 == null) goto L9;
        sf.a r10 = this.f6820a;
        if (r10 == null) goto L10;
        LynxLog.b(2, "LynxMediaEngineBaseView", "trigger setDataSource");
        Intrinsics.checkNotNullParameter(r5, "dataSource");
        uf.b r11 = ((sf.d) r10).f21895b;
        if (r11 == null) goto L11;
        r11.setDataSource(r5);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void setLoop(boolean r5) {
        sf.a r10 = this.f6820a;
        if (r10 == null) goto L6;
        LynxLog.b(2, "LynxMediaEngineBaseView", "invoke setLoop " + r5);
        r10.a(MapsKt.mapOf(TuplesKt.to("loop", Boolean.valueOf(r5))));
        return;
    }

    public final void setMediaVideoEngineCallback(rf.a r5) {
        if (r5 == null) goto L9;
        sf.a r10 = this.f6820a;
        if (r10 == null) goto L10;
        LynxLog.b(2, "LynxMediaEngineBaseView", "trigger setVideoEngineInfoListener");
        Intrinsics.checkNotNullParameter(r5, "callback");
        uf.b r11 = ((sf.d) r10).f21895b;
        if (r11 == null) goto L11;
        r11.setMediaVideoEngineCallback(r5);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void setMediaView(sf.a r5) {
        this.f6820a = r5;
    }

    public final void setMuted(boolean r5) {
        sf.a r10 = this.f6820a;
        if (r10 == null) goto L6;
        LynxLog.b(2, "LynxMediaEngineBaseView", "invoke setMuted " + r5);
        r10.a(MapsKt.mapOf(TuplesKt.to("muted", Boolean.valueOf(r5))));
        return;
    }

    public final void setPlayOptions(Map<Integer, ? extends Pair<? extends Object, ? extends IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType>> r5) {
        Intrinsics.checkNotNullParameter(r5, "options");
        sf.a r10 = this.f6820a;
        if (r10 == null) goto L6;
        LynxLog.b(2, "LynxMediaEngineBaseView", "trigger setPlayOptions");
        ((sf.d) r10).k(r5);
        return;
    }

    public abstract void setPlayParams(Map<String, ? extends Object> r5);

    public final void setResolution(String r5) {
        Intrinsics.checkNotNullParameter(r5, "resolution");
        sf.a r10 = this.f6820a;
        if (r10 == null) goto L6;
        LynxLog.b(2, "LynxMediaEngineBaseView", "invoke setResolution " + r5);
        r10.a(MapsKt.mapOf(TuplesKt.to("resolution", r5)));
        return;
    }

    public final void setSpeed(float r5) {
        sf.a r10 = this.f6820a;
        if (r10 == null) goto L6;
        LynxLog.b(2, "LynxMediaEngineBaseView", "invoke setSpeed " + r5);
        r10.a(MapsKt.mapOf(TuplesKt.to("speed", Float.valueOf(r5))));
        return;
    }

    public final void setVideoEngineCallback(VideoEngineCallback r5) {
        if (r5 == null) goto L9;
        sf.a r10 = this.f6820a;
        if (r10 == null) goto L10;
        LynxLog.b(2, "LynxMediaEngineBaseView", "trigger setVideoEngineCallback");
        Intrinsics.checkNotNullParameter(r5, "callback");
        uf.b r11 = ((sf.d) r10).f21895b;
        if (r11 == null) goto L11;
        r11.setVideoEngineCallback(r5);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void setVideoEngineInfoListener(VideoEngineInfoListener r5) {
        if (r5 == null) goto L9;
        sf.a r10 = this.f6820a;
        if (r10 == null) goto L10;
        LynxLog.b(2, "LynxMediaEngineBaseView", "trigger setVideoEngineInfoListener");
        Intrinsics.checkNotNullParameter(r5, "callback");
        uf.b r11 = ((sf.d) r10).f21895b;
        if (r11 == null) goto L11;
        r11.setVideoEngineInfoListener(r5);
        return;
    L11:
        return;
    L10:
        return;
    }
}
