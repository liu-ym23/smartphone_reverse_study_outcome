package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveMultiLinkService;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e0 implements ILiveMultiLinkService {
    public final HashMap<String, uf2.f.b> a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            qe0.a r2 = (qe0.a) r1;
            this.a.invoke();
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            ALogger.e("onMultiLinkAudiencePreInitRtc", (Throwable) r2);
        }
    }

    public static int a() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L20;
        com.bytedance.android.live.liveinteract.plantform.base.i r1 = r0.getLinkUserInfoCenter();
        if (r1 == null) goto L20;
        List r2 = r1.getOnlineUserList();
        if (r2 == null) goto L20;
        Iterator r3 = r2.iterator();
    L9:
        Object r4 = null;
        if (r3.hasNext() == false) goto L17;
        Object r5 = r3.next();
        IBaseUser r6 = ((ILinkPlayerInfoBridge) r5).getUser();
        if (r6 == null) goto L15;
        r4 = r6.getIdString();
    L15:
        if (Intrinsics.areEqual(r4, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L9;
        r4 = r5;
    L17:
        ILinkPlayerInfoBridge r7 = (ILinkPlayerInfoBridge) r4;
        if (r7 == null) goto L20;
        return r7.getLinkType();
    L20:
        return 0;
    }

    public e0() {
        this.a = new HashMap();
    }

    public final boolean isAudioLinkType() {
        if (a() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isVideoOrAvatarLinkType() {
        int r0 = a();
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 3) goto L10;
        return false;
    L10:
        return true;
    }

    public final void onAudioRelease(String r3) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        uf2.f.b r4 = this.a.remove(r3);
        if (r4 == null) goto L6;
        ALogger.i("LiveMultiLinkService", "release renderSink " + r4);
        r4.release();
        return;
    }

    public final Disposable onMultiLinkAudiencePreInitRtc(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        return xs2.b.a().b(qe0.a.class).subscribe(new a(r3), b.a);
    }

    public final void onAudioData(String r1, ByteBuffer r2, int r3, int r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r1, "roomId");
        uf2.f.b r7 = this.a.get(r1);
        if (r7 != null) goto L11;
        IInteractService r8 = jc1.k.f(IInteractService.class);
        if (r8 == null) goto L7;
        uf2.d0 r9 = r8.getLiveCore(r6);
    L8:
        if (r9 == null) goto L10;
        r9.h();
    L10:
        ALogger.i("LiveMultiLinkService", "create renderSink null");
        r7 = null;
        goto L11
    L7:
        r9 = null;
    L11:
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r10 = ILiveWrappedLivePusher.a.b();
        if (r10 == null) goto L14;
        r10.getTimeUtils();
    L14:
        if (r7 == null) goto L17;
        long r11 = 0 / ((long) 1000000);
        r7.a();
        return;
    }
}
