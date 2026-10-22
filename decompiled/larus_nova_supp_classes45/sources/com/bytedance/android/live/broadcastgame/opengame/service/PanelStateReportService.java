package com.bytedance.android.live.broadcastgame.opengame.service;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.message.ReviewApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0001:\u0001\u0007B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/PanelStateReportService;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/p;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "PanelState", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelStateReportService implements y10.a, com.bytedance.android.live.broadcastgame.opengame.panel.i, p {
    public final Lazy a;
    public final Lazy b;
    public boolean c;
    public final Lazy d;
    public final PanelStateReportService$lifecycleObserver$1 e;
    public final PluginContext f;

    public static final class PanelState {
        public EnumC0084PanelState a;
        public final String b;
        public final long c;

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.service.PanelStateReportService$PanelState$PanelState, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/PanelStateReportService$PanelState$PanelState;", "", "Show", "Hide", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum EnumC0084PanelState extends Enum<EnumC0084PanelState> {
            public static final EnumC0084PanelState Hide = null;
            public static final EnumC0084PanelState Show = null;
            public static final /* synthetic */ EnumC0084PanelState[] a = null;

            static {
                EnumC0084PanelState r1 = new EnumC0084PanelState("Show", 0);
                Show = r1;
                EnumC0084PanelState r2 = new EnumC0084PanelState("Hide", 1);
                Hide = r2;
                a = new EnumC0084PanelState[]{r1, r2};
            }

            public static EnumC0084PanelState valueOf(String r1) {
                return (EnumC0084PanelState) r27.a.a(EnumC0084PanelState.class, r1);
            }

            public static EnumC0084PanelState[] values() {
                return (EnumC0084PanelState[]) a.clone();
            }

            public EnumC0084PanelState(String r1, int r2) {
                super(r1, r2);
            }
        }

        public static final class a<T> implements Consumer {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Response r2 = (Response) r1;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ EnumC0084PanelState a;

            public b(EnumC0084PanelState r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                ALogger.d("ReportHelper", "report: " + this.a + ' ' + ((Throwable) r3).getMessage());
            }
        }

        public final Disposable a(EnumC0084PanelState r6) {
            if (StringsKt.isBlank(this.b) == false) goto L5;
        L21:
            return null;
        L5:
            if (this.c <= 0) goto L21;
            if (this.a != r6) goto L10;
            boolean r0 = false;
        L11:
            if (r0 == false) goto L21;
            int r1 = f.a[r6.ordinal()];
            if (r1 != 1) goto L15;
            Lazy r2 = LiveOpenGameClient.d;
            Observable<Response<Object>> r3 = ((ReviewApi) LiveOpenGameClient.a.a().a(ReviewApi.class)).reportPanelShow(this.b, this.c);
        L23:
            return r3.subscribe(a.a, new b(r6));
        L15:
            if (r1 != 2) goto L18;
            Lazy r4 = LiveOpenGameClient.d;
            r3 = ((ReviewApi) LiveOpenGameClient.a.a().a(ReviewApi.class)).reportPanelHide(this.b, this.c);
            goto L23
        L18:
            throw new NoWhenBranchMatchedException();
        L10:
            this.a = r6;
            r0 = true;
            goto L11
        }

        public PanelState(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "appId");
            this.b = r2;
            this.c = r3;
            this.a = EnumC0084PanelState.Hide;
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void c() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    @Override // y10.a
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onBackPressed() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onPanelCancel() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void a() {
        if (this.f.m() != PluginType.LYNX) goto L5;
    L6:
        Context r0 = this.f.getContext();
        if ((r0 instanceof AppCompatActivity) == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L14;
        ((AppCompatActivity) r0).getLifecycle().addObserver(this.e);
        return;
    L14:
        return;
    L5:
        if (this.f.m() == PluginType.SONIC_GAME) goto L6;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void b() {
        if (this.f.m() != PluginType.LYNX) goto L5;
    L6:
        Context r0 = this.f.getContext();
        if ((r0 instanceof AppCompatActivity) == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        ((AppCompatActivity) r0).getLifecycle().removeObserver(this.e);
    L12:
        d();
        return;
    L5:
        if (this.f.m() != PluginType.SONIC_GAME) goto L12;
        goto L6
    }

    public final void d() {
        PanelState r0 = (PanelState) this.d.getValue();
        r0.getClass();
        r0.a(PanelState.EnumC0084PanelState.Hide);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
        d();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        d();
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.live.broadcastgame.opengame.service.PanelStateReportService$lifecycleObserver$1] */
    public PanelStateReportService(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        new CompositeDisposable();
        this.f = r2;
        this.a = LazyKt.lazy(new PanelStateReportService$appId$2(this));
        this.b = LazyKt.lazy(new PanelStateReportService$roomId$2(this));
        this.d = LazyKt.lazy(new PanelStateReportService$panelState$2(this));
        this.e = new PanelStateReportService$lifecycleObserver$1(this);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r2) {
        PanelState r3 = (PanelState) this.d.getValue();
        r3.getClass();
        r3.a(PanelState.EnumC0084PanelState.Show);
    }
}
