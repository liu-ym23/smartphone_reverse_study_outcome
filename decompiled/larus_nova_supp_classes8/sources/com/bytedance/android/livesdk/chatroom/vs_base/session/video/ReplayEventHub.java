package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.depend.live.vs.IVideoEventHub;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ReplayEventHub implements IVideoEventHub, wr1.a {
    public final MutableLiveData<Pair<Boolean, Long>> A;
    public Function1<? super ReplayVideoMetrics.Behavior, Unit> B;
    public final NextLiveData<Boolean> a;
    public final NextLiveData<Boolean> b;
    public final ReplayEventHub$firstFrameWithTime$1 c;
    public final NextLiveData<Pair<Integer, Integer>> d;
    public final NextLiveData<String> e;
    public final NextLiveData<Boolean> f;
    public final MutableLiveData<Boolean> g;
    public final MutableLiveData<Boolean> h;
    public final MutableLiveData<Boolean> i;
    public final NextLiveData<Boolean> j;
    public final MutableLiveData<Integer> k;
    public final MutableLiveData<Map<String, String>> l;
    public final MutableLiveData<Boolean> m;
    public final MutableLiveData<Boolean> n;
    public final NextLiveData<Boolean> o;
    public final MutableLiveData<Episode> p;
    public final MutableLiveData<Episode> q;
    public final MutableLiveData<Episode> r;
    public final MutableLiveData<Boolean> s;
    public final MutableLiveData<Boolean> t;
    public final MutableLiveData<Boolean> u;
    public final MutableLiveData<Long> v;
    public final MutableLiveData<String> w;
    public final NextLiveData<Boolean> x;
    public final MutableLiveData<Boolean> y;
    public final NextLiveData<Boolean> z;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.chatroom.vs_base.session.video.ReplayEventHub$firstFrameWithTime$1] */
    public ReplayEventHub() {
        this.a = new NextLiveData();
        this.b = new NextLiveData();
        this.c = new ReplayEventHub$firstFrameWithTime$1(this);
        this.d = new NextLiveData();
        this.e = new NextLiveData();
        NextLiveData<Boolean> r0 = new NextLiveData();
        Boolean r1 = Boolean.FALSE;
        r0.setValue(r1);
        Unit r2 = Unit.INSTANCE;
        this.f = r0;
        this.g = new MutableLiveData();
        this.h = new MutableLiveData();
        this.i = new MutableLiveData();
        this.j = new NextLiveData();
        MutableLiveData<Integer> r3 = new MutableLiveData();
        r3.setValue(0);
        this.k = r3;
        this.l = new MutableLiveData();
        this.m = new MutableLiveData();
        this.n = new MutableLiveData();
        NextLiveData<Boolean> r4 = new NextLiveData();
        r4.setValue(r1);
        this.o = r4;
        this.p = new MutableLiveData();
        this.q = new MutableLiveData();
        this.r = new MutableLiveData();
        this.s = new MutableLiveData();
        this.t = new MutableLiveData();
        new MutableLiveData();
        this.u = new MutableLiveData();
        this.v = new MutableLiveData();
        this.w = new MutableLiveData();
        new MutableLiveData();
        new MutableLiveData();
        new MutableLiveData();
        this.x = new NextLiveData();
        this.y = new MutableLiveData();
        NextLiveData<Boolean> r5 = new NextLiveData();
        r5.setValue(r1);
        this.z = r5;
        this.A = new MutableLiveData();
    }

    @Override // wr1.a
    public final MutableLiveData<Map<String, String>> a() {
        return this.l;
    }

    public final MutableLiveData getFirstFrame() {
        return this.b;
    }

    public final MutableLiveData getPlayPrepared() {
        return this.a;
    }

    public final MutableLiveData getPlayerMediaError() {
        return this.e;
    }

    public final MutableLiveData<Boolean> getPlayerMute() {
        return this.g;
    }

    public final MutableLiveData getPlaying() {
        return this.f;
    }

    public final MutableLiveData getVideoSizeChanged() {
        return this.d;
    }
}
