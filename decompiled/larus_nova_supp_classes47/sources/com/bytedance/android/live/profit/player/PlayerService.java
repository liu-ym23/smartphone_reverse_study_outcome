package com.bytedance.android.live.profit.player;

import android.content.Context;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.profit.player.profilepreview.ProfilePreviewEvent;
import com.bytedance.android.live.profit.util.AssetUtilsKt;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.io.InputStreamReader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PlayerService implements d, com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final Lazy b;
    public final p c;
    public uu0.b d;
    public final PublishSubject<ProfilePreviewEvent> e;
    public final BehaviorSubject<sh6.b<com.bytedance.android.live.profit.player.a>> f;
    public final com.bytedance.android.live.revenue.core.a g;
    public final yz0.k h;
    public final com.bytedance.android.livesdk.revenue.service.message.d i;

    public final class a implements com.bytedance.android.livesdk.revenue.player.b {
        public final /* synthetic */ PlayerService a;

        public final boolean isAnchor() {
            return this.a.h.isAnchor();
        }

        public a(PlayerService r1) {
            this.a = r1;
        }

        public final s<o> K(String r2) {
            Intrinsics.checkNotNullParameter(r2, "path");
            return this.a.K(r2);
        }
    }

    @Override // com.bytedance.android.live.profit.player.d
    public final e Qh() {
        return (e) this.b.getValue();
    }

    @Override // com.bytedance.android.live.profit.player.d
    public final Class<? extends Widget> Hm() {
        if (((Boolean) r.d.getValue(null, r.a[2])).booleanValue() == false) goto L6;
        return LynxAlphaPlayerWidgetNew.class;
    L6:
        return LynxAlphaPlayerWidget.class;
    }

    public final void onStart() {
        com.bytedance.android.live.revenue.core.a r0 = this.g;
        r0.b(d.class, r0.getScope());
    }

    public final void onStop() {
        this.a.clear();
    }

    @Override // com.bytedance.android.live.profit.player.d
    public final uu0.b Me() {
        return this.d;
    }

    @Override // com.bytedance.android.live.profit.player.d
    public final p f1() {
        return this.c;
    }

    @Override // com.bytedance.android.live.profit.player.d
    public final PublishSubject x1() {
        return this.e;
    }

    @Override // com.bytedance.android.live.profit.player.d
    public final s<o> K(String r4) {
        Intrinsics.checkNotNullParameter(r4, "path");
        String r5 = r4 + File.separator + "config.json";
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        PolarisFileWrapper r2 = new PolarisFileWrapper(r5);     // Catch: Throwable -> L12
        InputStreamReader r3 = new InputStreamReader(new PolarisFileInputStreamWrapper(r2), Charsets.UTF_8);     // Catch: Throwable -> L12
        o.a r6 = (o.a) GsonHelper.get().fromJson(r3, o.a.class);     // Catch: Throwable -> L7
        CloseableKt.closeFinally(r3, null);     // Catch: Throwable -> L12
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r7) == true) goto L18;
        r0 = r7;
    L18:
        o.a r8 = (o.a) r0;
        if (r8 != null) goto L25;
        int r9 = s.a;
        Throwable r10 = Result.exceptionOrNull-impl(r7);
        if (r10 != null) goto L24;
        r10 = new Throwable("config.json parse failed");
    L24:
        return s.a.a(r10);
    L25:
        o.b r12 = r8.a();
        if (r12 != null) goto L29;
        int r13 = s.a;
        return s.a.a(new Throwable("no portrait config"));
    L29:
        int r14 = s.a;
        return new s.c(new o(r12.a()));
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.bytedance.android.live.profit.player.d
    public final void Nc(com.bytedance.android.live.profit.player.a r2) {
        Intrinsics.checkNotNullParameter(r2, "playData");
        this.f.onNext(sh6.c.a(r2));
    }

    @Override // com.bytedance.android.live.profit.player.d
    public final uu0.a hd(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        uu0.b r0 = this.d;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.b.getEnablePreview() == true) goto L8;
        return null;
    L8:
        if ((r0 instanceof uu0.b.a) == false) goto L11;
        uu0.a r2 = new EnterEffectProfilePreviewView(r4, (uu0.b.a) r0);
    L13:
        if (r2 == null) goto L18;
        this.d = null;
        return r2;
    L18:
        return null;
    L11:
        if ((r0 instanceof uu0.b.C0330b) == false) goto L16;
        r2 = com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).getGiftTrayPreviewView(r4, r0);
        goto L13
    L16:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.live.profit.player.d
    public final void no(uu0.b r1) {
        this.d = r1;
    }

    @Override // com.bytedance.android.live.profit.player.d
    public final Disposable lh(long r3, n r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        com.bytedance.android.livesdk.revenue.message.i r0 = this.i.getMessageManager();
        if (r0 != null) goto L7;
        return Disposables.disposed();
    L7:
        return vh6.c.b(com.bytedance.android.livesdk.revenue.player.a.class).ac(r3, r5, r0);
    }

    public PlayerService(com.bytedance.android.live.revenue.core.a r2, yz0.k r3, com.bytedance.android.livesdk.revenue.service.message.d r4) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "messageManagerService");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        CompositeDisposable r5 = new CompositeDisposable();
        this.a = r5;
        this.b = LazyKt.lazy(new PlayerService$textRenderUtils$2(this));
        this.c = new p(r5);
        this.e = PublishSubject.create();
        this.f = BehaviorSubject.create();
    }

    @Override // com.bytedance.android.live.profit.player.d
    public final void w1(IAssetsManager r7, long r8, int r10, Function2 r12) {
        Intrinsics.checkNotNullParameter(r7, "assetManager");
        Intrinsics.checkNotNullParameter(r12, "callback");
        AssetUtilsKt.a(r7, r8, 4, r10, r12);
    }
}
