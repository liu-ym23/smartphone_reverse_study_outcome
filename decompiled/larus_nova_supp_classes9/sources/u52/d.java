package u52;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.speech.speechengine.SpeechEngine;
import com.bytedance.speech.speechengine.SpeechEngineGenerator;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import u52.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class d<T extends g> {
    public static final /* synthetic */ int g = 0;
    public final AtomicInteger a;
    public volatile String b;
    public final SpeechEngine c;
    public volatile boolean d;
    public T e;
    public final String f;

    public static final class a {
    }

    static {
    }

    public final boolean d() {
        int r0 = this.a.get();
        if (r0 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 3) goto L8;
        return false;
    }

    public final boolean h() {
        if (this.d == true) goto L5;
        return false;
    L5:
        i();
        this.a.set(2);
        int r0 = this.c.sendDirective(IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW, BuildConfig.FLAVOR);
        if (r0 != 0) goto L14;
        e("start engine success");
        String r8 = this.f;
        int r9 = w52.a.a;
        Intrinsics.checkNotNullParameter(r8, "engineName");
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r2 == null) goto L12;
        m r3 = r2.getRoom();
        if (r3 == null) goto L12;
        Room r4 = (Room) r3.getValue();
    L13:
        LiveMonitor.a r5 = InteractivityMonitor.a(InteractivityMonitor.Event.SpeechEngineStart, r4, null);
        r5.l(0);
        r5.m("start engine success");
        r5.e("engine_name", r8);
        r5.a().report();
        return d();
    L12:
        r4 = null;
        goto L13
    L14:
        this.a.set(1);
        f("start engine failed. code=" + r0);
        String r10 = this.f;
        int r11 = w52.a.a;
        Intrinsics.checkNotNullParameter(r10, "engineName");
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L19;
        m r7 = r6.getRoom();
        if (r7 == null) goto L19;
        Room r13 = (Room) r7.getValue();
    L20:
        LiveMonitor.a r14 = InteractivityMonitor.a(InteractivityMonitor.Event.SpeechEngineStart, r13, null);
        r14.l(r0);
        r14.m("start engine failed");
        r14.e("engine_name", r10);
        r14.a().report();
        return false;
    L19:
        r13 = null;
        goto L20
    }

    public final void i() {
        if (this.d == true) goto L5;
        return;
    L5:
        this.c.sendDirective(2001, BuildConfig.FLAVOR);
    }

    public boolean a() {
        return d();
    }

    public d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.f = r2;
        this.a = new AtomicInteger(0);
        this.c = SpeechEngineGenerator.getInstance();
    }

    public static PolarisFileWrapper c(String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        PolarisFileWrapper r1 = null;
        if (r0 == false) goto L11;
        return null;
    L11:
        File r2 = jc1.a.b().getFilesDir();
        if (r2 != null) goto L14;
        return null;
    L14:
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2, r4);
        if (r3.exists() == true) goto L25;
        r3.mkdir();     // Catch: Exception -> L19
        r1 = r3;
    L22:
        return r1;
    L19:
        e = move-exception;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("create dir " + r3.getPath() + " failed", e);
        goto L22
    L25:
        return r3;
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c(this.f + ": " + r3);
    }

    public final void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.a(this.f + ": " + r3);
    }

    public final void b(byte[] r2, Integer r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.d == true) goto L7;
        return;
    L7:
        if (a() == false) goto L32;
        if (r3 == null) goto L10;
        int r4 = r3.intValue();
    L11:
        int r5 = this.c.feedAudio(r2, r4);
        if (r5 == 0) goto L33;
        StringBuilder r6 = new StringBuilder("feed audio error. ret=");
        r6.append(r5);
        r6.append(" state=");
        int r7 = this.a.get();
        if (r7 != 0) goto L16;
        String r8 = "invalid";
    L29:
        r6.append(r8);
        f(r6.toString());
        return;
    L16:
        if (r7 != 1) goto L18;
        r8 = "idle";
        goto L29
    L18:
        if (r7 != 2) goto L20;
        r8 = "starting";
        goto L29
    L20:
        if (r7 != 3) goto L22;
        r8 = "running";
        goto L29
    L22:
        if (r7 == 4) goto L24;
        r8 = CardLockInfo.sUNKNOWN;
        goto L29
    L24:
        r8 = "stopping";
        goto L29
    L33:
        return;
    L10:
        r4 = r2.length;
        goto L11
    }

    public void g(int r8, byte[] r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Room r1 = null;
        switch(r8) {
            case 1001: goto L23;
            case 1002: goto L19;
            case 1003: goto L27;
            default: goto L33;
        };
    L19:
        String r10 = new String(r9, Charsets.UTF_8);
        this.a.set(1);
        e(this.f + " on engine stop. reqId=" + r10);
        T r11 = this.e;
        if (r11 == null) goto L22;
        r11.onStop(r10);
    L22:
        this.b = null;
        return;
    L23:
        String r13 = new String(r9, Charsets.UTF_8);
        this.b = r13;
        this.a.set(3);
        e(this.f + " on engine start. req=" + r13);
        T r14 = this.e;
        if (r14 == null) goto L32;
        r14.onStart(r13);
        return;
    L32:
        return;
    L27:
        e r15 = (e) GsonHelper.get().fromJson(new String(r9, Charsets.UTF_8), e.class);     // Catch: Exception -> L7
    L9:
        if (r15 == null) goto L29;
        this.a.set(4);
        f(this.f + " on engine error. " + GsonProtectorUtils.toJson(GsonHelper.get(), r15));
        T r16 = this.e;
        if (r16 == null) goto L13;
        r16.c(r15);
    L13:
        String r17 = this.f;
        int r2 = r15.a();
        String r3 = r15.b();
        String r18 = r15.c();
        int r4 = w52.a.a;
        Intrinsics.checkNotNullParameter(r17, "engineName");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L18;
        m r5 = r0.getRoom();
        if (r5 == null) goto L18;
        r1 = (Room) r5.getValue();
    L18:
        LiveMonitor.a r19 = InteractivityMonitor.a(InteractivityMonitor.Event.SpeechEngineError, r1, r18);
        r19.l(r2);
        r19.m(r3);
        r19.e("engine_name", r17);
        r19.a().report();
        return;
    L29:
        return;
    L7:
        e = move-exception;
        SafetyGuard.a("AnchorAsr get engine error failed", e, null);
        r15 = null;
        goto L9
    }
}
