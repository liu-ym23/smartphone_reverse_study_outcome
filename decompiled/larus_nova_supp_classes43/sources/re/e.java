package re;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements td.e {
    public final MutableLiveData<Boolean> a;
    public final MutableLiveData<Boolean> b;
    public final MutableLiveData<Boolean> c;
    public final MutableLiveData<Pair<Integer, Integer>> d;
    public final MutableLiveData<Boolean> e;
    public final MutableLiveData<String> f;
    public final MutableLiveData<Boolean> g;
    public final MutableLiveData<Boolean> h;
    public final MutableLiveData<Boolean> i;
    public final MutableLiveData<Boolean> j;
    public final MutableLiveData<String> k;
    public final MutableLiveData<Boolean> l;
    public final MutableLiveData<Boolean> m;
    public final MutableLiveData<Boolean> n;
    public final MutableLiveData<Boolean> o;

    @Override // td.e
    public final MutableLiveData<Boolean> getFirstFrame() {
        return this.e;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getLiveEnd() {
        return this.m;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getPlayComplete() {
        return this.g;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getPlayPrepared() {
        return this.j;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getPlayResume() {
        return this.h;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getPlayerBlur() {
        return this.o;
    }

    @Override // td.e
    public final MutableLiveData<String> getPlayerMediaError() {
        return this.k;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getPlayerMute() {
        return this.i;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getPlaying() {
        return this.a;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getReleased() {
        return this.c;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getReset() {
        return this.n;
    }

    @Override // td.e
    public final MutableLiveData<String> getSeiUpdate() {
        return this.f;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> getStopped() {
        return this.b;
    }

    @Override // td.e
    public final MutableLiveData<Pair<Integer, Integer>> getVideoSizeChanged() {
        return this.d;
    }

    @Override // td.e
    public final MutableLiveData<Boolean> isSeiCropping() {
        return this.l;
    }

    public e(IRoomEventHub r10) {
        Intrinsics.checkNotNullParameter(r10, "realHub");
        this.a = r10.getPlaying();
        this.b = r10.getStopped();
        this.c = r10.getReleased();
        this.d = r10.getVideoSizeChanged();
        this.e = r10.getFirstFrame();
        this.f = r10.getSeiUpdate();
        this.g = r10.getPlayComplete();
        this.h = r10.getPlayResume();
        this.i = r10.getPlayerMute();
        this.j = r10.getPlayPrepared();
        this.k = r10.getPlayerMediaError();
        this.l = r10.isSeiCropping();
        this.m = r10.getRoomFinish();
        this.n = new MutableLiveData();
        this.o = new MutableLiveData();
    }
}
