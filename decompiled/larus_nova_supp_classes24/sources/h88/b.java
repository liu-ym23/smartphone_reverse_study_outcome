package h88;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.MajorState;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.im.service.audio.AudioSessionType;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class b implements t1a.c {
    public final String a;
    public final String b;
    public String c;
    public boolean d;
    public AudioSessionType e;
    public boolean f;
    public boolean g;
    public boolean h;
    public ThemeType i;
    public RealtimeCallParam j;
    public int k;
    public MajorState l;
    public boolean m;
    public boolean n;
    public String o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public RealtimePageMode u;
    public boolean v;

    public static final class a {
    }

    static {
    }

    public final RealtimeCallParam a() {
        RealtimeCallParam r0 = this.j;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("callParam");
        return null;
    }

    public String toString() {
        return "localCallId:" + this.a + ",taskId:" + this.b + ",isMainBot:" + this.d + ",avSessionType:" + this.e + ",useNewConn: " + this.f + ",isShowChooseSceneButton:" + this.h + ",themeType:" + this.i + ",currentState:" + this.k + ",muted:" + this.m + ",paused:" + this.n + ",endMethod:" + this.o;
    }

    public b() {
        this.a = UUID.randomUUID().toString();
        this.b = UUID.randomUUID().toString();
        this.c = "";
        this.e = AudioSessionType.RTC;
        this.i = ThemeType.DEFAULT;
        this.k = -1;
        this.l = MajorState.c.c;
        this.u = RealtimePageMode.FULL_SCREEN;
    }
}
