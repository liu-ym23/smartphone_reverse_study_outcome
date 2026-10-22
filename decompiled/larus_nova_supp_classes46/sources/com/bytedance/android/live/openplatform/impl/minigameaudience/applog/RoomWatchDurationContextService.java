package com.bytedance.android.live.openplatform.impl.minigameaudience.applog;

import android.os.SystemClock;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/applog/RoomWatchDurationContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "miniGameContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomWatchDurationContextService extends OpenPlatformContextService {
    public final String a;
    public long b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final a f;

    public static final class a implements OnMiniGameLifecycleChangeListener {
        public final /* synthetic */ RoomWatchDurationContextService a;

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void a() {
            this.a.c = true;
        }

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void b() {
            RoomWatchDurationContextService r0 = this.a;
            r0.c = false;
            r0.e = false;
        }

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void c() {
            RoomWatchDurationContextService r0 = this.a;
            if (r0.e == false) goto L5;
            return;
        L5:
            if (r0.c == true) goto L7;
            return;
        L7:
            if (r0.d == false) goto L12;
            r0.f();
            return;
        }

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void d() {
            RoomWatchDurationContextService r0 = this.a;
            r0.c = false;
            r0.e = false;
        }

        @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener
        public final void e() {
            RoomWatchDurationContextService r0 = this.a;
            if ((-1) == r0.b) goto L5;
            return;
        L5:
            if (r0.e == true) goto L9;
            r0.b = SystemClock.elapsedRealtime();
            return;
        }

        public a(RoomWatchDurationContextService r1) {
            this.a = r1;
        }
    }

    public final void f() {
        if (this.b > 0) goto L5;
        return;
    L5:
        long r0 = SystemClock.elapsedRealtime() - this.b;
        this.b = -1;
        AudienceMiniGameAppLogContextService r2 = (AudienceMiniGameAppLogContextService) getOpenPlatformContext().getService(AudienceMiniGameAppLogContextService.class);
        HashMap<String, String> r3 = new HashMap();
        r3.put("duration", String.valueOf(r0));
        Unit r1 = Unit.INSTANCE;
        r2.h("mp_live_watch_duration", r3);
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        int r0 = qo0.a.a;
        qo0.a.c(this.a, "onDestroy");
        f();
        this.b = -1;
        this.c = false;
        this.e = false;
    }

    public RoomWatchDurationContextService(OpenPlatformContext r3) {
        Intrinsics.checkNotNullParameter(r3, "miniGameContext");
        super(r3);
        this.a = "RoomWatchDurationManager";
        this.b = -1;
        this.f = new a(this);
    }
}
