package as1;

import androidx.lifecycle.Observer;
import com.bytedance.android.live.broadcast.api.model.AnchorVideoResolutionManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.pushstream.util.LiveStreamMonitorUtils;
import com.bytedance.android.livesdk.chatroom.utils.l0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends BasePerformanceStrategyTask {
    public b a;
    public Disposable b;
    public Disposable c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public long i;
    public final CompositeDisposable j;

    /* JADX INFO: renamed from: as1.a$a, reason: collision with other inner class name */
    public static final class C0000a<T> implements Observer {
        public final /* synthetic */ a a;

        public C0000a(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            KVData r6 = (KVData) r5;
            if (this.a.f == false) goto L6;
            int r7 = l0.a;
            l0.a((System.currentTimeMillis() - this.a.i) / ((long) BubbleId.PadCast), false);
            return;
        }
    }

    public interface b {
        void a(int r1, String r2);
    }

    public static final class c {
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.d = true;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            AnchorVideoResolutionManager.a r3 = (AnchorVideoResolutionManager.a) r2;
            this.a.f = false;
        }
    }

    static {
    }

    public final boolean onTriggerEnhance(int r1, Map<String, String> r2, IPerformanceStrategyMonitor r3) {
        Intrinsics.checkNotNullParameter(r2, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r3, "monitor");
        return false;
    }

    public a(CompositeDisposable r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "compositeDisposable");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.j = r2;
        this.d = true;
        this.e = true;
        this.g = -1;
        r3.observe("cmd_anchor_broadcast_start", new C0000a(this));
    }

    public final void a(int r5, @LiveStreamMonitorUtils.ChangeVideoFpsReason String r6) {
        if (Intrinsics.areEqual(r6, "anchor_degrade_level_two") == false) goto L6;
        this.i = System.currentTimeMillis();
    L8:
        b r0 = this.a;
        if (r0 == null) goto L12;
        r0.a(r5, r6);
        return;
    L12:
        return;
    L6:
        if (Intrinsics.areEqual(r6, "anchor_degrade_recover") == false) goto L8;
        int r1 = l0.a;
        l0.a((System.currentTimeMillis() - this.i) / ((long) BubbleId.PadCast), true);
        this.i = 0;
        goto L8
    }

    public final void onTriggerOrigin(Map<String, String> r2, IPerformanceStrategyMonitor r3) {
        Intrinsics.checkNotNullParameter(r2, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r3, "monitor");
        this.e = true;
        int r4 = this.g;
        if (r4 > 0) goto L5;
    L7:
        Disposable r5 = this.b;
        if (r5 == null) goto L10;
        r5.dispose();
    L10:
        this.h = 0;
        return;
    L5:
        if (this.f == false) goto L7;
        a(r4, "anchor_degrade_recover");
        this.f = false;
        goto L7
    }

    public final boolean onTriggerDegrade(int r11, Map<String, String> r12, IPerformanceStrategyMonitor r13) {
        Intrinsics.checkNotNullParameter(r12, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r13, "monitor");
        this.h = r11;
        String r4 = "";
        if (r11 != 1) goto L18;
        if (this.d == false) goto L18;
        int r6 = l0.a;
        String r7 = r12.get("temperature");
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        Intrinsics.checkNotNullParameter(r7, "temperature");
        Intrinsics.checkNotNullParameter("live_take_detail", "page");
        HashMap r8 = new HashMap();
        r8.put("temperature", r7);
        if (Intrinsics.areEqual("live_take_detail", "live_take_page") == false) goto L12;
        String r9 = "preview";
    L13:
        r8.put("from_page", r9);
        l0.b("livesdk_live_take_high_temperature_warning", r8);
        MainThreadPostUtils.b(new as1.b(2131914668));
        ALogger.e("LiveAnchorDegradeTask", "level 1 toast show");
        this.d = false;
        Disposable r10 = this.c;
        if (r10 == null) goto L16;
        r10.dispose();
    L16:
        Disposable r14 = Observable.timer(10, TimeUnit.MINUTES).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this));
        RxUtilKt.c(r14, this.j);
        this.c = r14;
        goto L18
    L12:
        r9 = "living";
    L18:
        if (this.h == 2) goto L20;
    L45:
        r13.updatePerformanceExecuteMonitor(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", SourceType.ANCHOR)}), r11);
        return true;
    L20:
        if (this.e == false) goto L32;
        int r15 = l0.a;
        String r16 = r12.get("ui_stall_rate");
        if (r16 != null) goto L24;
        r16 = "";
    L24:
        String r17 = r12.get("preview_fps");
        if (r17 != null) goto L27;
        r17 = "";
    L27:
        String r18 = r12.get("anchor_temperature_last_duration");
        if (r18 == null) goto L31;
        r4 = r18;
    L31:
        Intrinsics.checkNotNullParameter(r16, "uiStallRate");
        Intrinsics.checkNotNullParameter(r17, "fpsPreview");
        Intrinsics.checkNotNullParameter(r4, "duration");
        Intrinsics.checkNotNullParameter("live_take_detail", "page");
        HashMap r1 = new HashMap();
        r1.put("ui_stall_rate", r16);
        r1.put("fps_preview", r17);
        r1.put("duration", r4);
        l0.b("livesdk_live_take_high_temperature_degrade_warning", r1);
        MainThreadPostUtils.b(new as1.b(2131914669));
        ALogger.e("LiveAnchorDegradeTask", "level 2 toast show");
        this.e = false;
    L32:
        Disposable r19 = this.b;
        if (r19 == null) goto L35;
        r19.dispose();
    L35:
        Disposable r110 = xs2.b.a().b(AnchorVideoResolutionManager.a.class).subscribe(new e(this));
        RxUtilKt.c(r110, this.j);
        this.b = r110;
        d0.a r111 = k.n(IPushStreamService.class).getLiveCoreBuilder();
        if (r111 == null) goto L38;
        int r112 = r111.z();
    L39:
        this.g = r112;
        if (r112 <= 15) goto L43;
        if (r112 > 20) goto L43;
        a(15, "anchor_degrade_level_two");
        this.f = true;
    L43:
        if (r112 <= 20) goto L45;
        a(20, "anchor_degrade_level_two");
        this.f = true;
        goto L45
    L38:
        r112 = -1;
        goto L39
    }
}
