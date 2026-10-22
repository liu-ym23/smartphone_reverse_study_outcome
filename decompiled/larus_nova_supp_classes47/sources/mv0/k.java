package mv0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k extends qs0.a<IInteractService> implements qs0.i {

    public static final class a extends qs0.a<qd0.a> {
        public a(qd0.a r2) {
            Intrinsics.checkNotNullParameter(r2, "proxy");
            super(r2);
        }

        public final boolean k(boolean r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "uid");
            return ((qd0.a) this.a).B(r2);
        }
    }

    public static final class b extends qs0.a<iy.g> {
        public final boolean k() {
            return ((iy.g) this.a).isEngineOn();
        }

        public b(iy.g r2) {
            Intrinsics.checkNotNullParameter(r2, "proxy");
            super(r2);
        }

        public final boolean l(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uid");
            return ((iy.g) this.a).Do(r2);
        }
    }

    public static final class c extends qs0.a<xi0.a> {
        public final boolean k() {
            return ((xi0.a) this.a).isFightShowing();
        }

        public c(xi0.a r2) {
            Intrinsics.checkNotNullParameter(r2, "proxy");
            super(r2);
        }
    }

    public static final class d extends qs0.a<com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge>> {
        public final int l() {
            return ((com.bytedance.android.live.liveinteract.plantform.base.i) this.a).b();
        }

        public final List<ILinkPlayerInfoBridge> m() {
            return ((com.bytedance.android.live.liveinteract.plantform.base.i) this.a).c();
        }

        public final List<ILinkPlayerInfoBridge> n() {
            return ((com.bytedance.android.live.liveinteract.plantform.base.i) this.a).getOnlineUserList();
        }

        public d(com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2) {
            Intrinsics.checkNotNullParameter(r2, "proxy");
            super(r2);
        }

        public final ILinkPlayerInfoBridge k(String r3) {
            Intrinsics.checkNotNullParameter(r3, "userId");
            return ((com.bytedance.android.live.liveinteract.plantform.base.i) this.a).getGuestInfo(r3, null);
        }

        public final int o(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            return ((com.bytedance.android.live.liveinteract.plantform.base.i) this.a).O4(r2);
        }
    }

    public static final class e extends qs0.a<rj0.m> {
        public final boolean m() {
            return ((rj0.m) this.a).z();
        }

        public e(rj0.m r2) {
            Intrinsics.checkNotNullParameter(r2, "proxy");
            super(r2);
        }

        public final Pair<Boolean, Long> k(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            return ((rj0.m) this.a).M(r2);
        }

        public final void n(String r2) {
            Intrinsics.checkNotNullParameter(r2, "targetUserId");
            ((rj0.m) this.a).l(r2);
        }

        public final boolean l(boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "uid");
            return ((rj0.m) this.a).u(r2, r3);
        }
    }

    public k() {
        super(jc1.k.n(IInteractService.class));
    }

    @Override // qs0.i
    public final Boolean chatRoomIsOpen() {
        return Boolean.valueOf(((IInteractService) this.a).chatRoomIsOpen());
    }

    @Override // qs0.i
    public final a getAudioTalkService() {
        return new a(((IInteractService) this.a).getAudioTalkService());
    }

    @Override // qs0.i
    public final String getCurrentFunctionType() {
        return ((IInteractService) this.a).getCurrentFunctionType();
    }

    @Override // qs0.i
    public final int getCurrentScene() {
        return ((IInteractService) this.a).getCurrentScene();
    }

    @Override // qs0.i
    public final String getFunctionType2() {
        return ((IInteractService) this.a).getFunctionType2();
    }

    @Override // qs0.i
    public final String getLinkConnectionType() {
        return ((IInteractService) this.a).getLinkConnectionType();
    }

    @Override // qs0.i
    public final d getLinkUserInfoCenter() {
        com.bytedance.android.live.liveinteract.plantform.base.i r0 = ((IInteractService) this.a).getLinkUserInfoCenter();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new d(r0);
    }

    @Override // qs0.i
    public final e getVideoTalkService() {
        return new e(((IInteractService) this.a).getVideoTalkService());
    }

    @Override // qs0.i
    public final boolean isInLinkMicGameAnchorLinkMode() {
        return ((IInteractService) this.a).isInLinkMicGameAnchorLinkMode();
    }

    @Override // qs0.i
    public final c linkRoomFightService() {
        xi0.a r0 = ((IInteractService) this.a).linkRoomFightService();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new c(r0);
    }

    @Override // qs0.i
    public final String changeMode2String(int r2) {
        return ((IInteractService) this.a).changeMode2String(r2);
    }

    @Override // qs0.i
    public final b h(DataCenter r2) {
        iy.g r3 = ((IInteractService) this.a).getDynamicCenterService(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new b(r3);
    }

    @Override // qs0.i
    public final boolean isAnonymousUser(String r4) {
        IInteractService r0 = (IInteractService) this.a;
        Long r5 = StringsKt.toLongOrNull(r4);
        if (r5 == null) goto L5;
        long r1 = r5.longValue();
    L7:
        return r0.isAnonymousUser(Long.valueOf(r1));
    L5:
        r1 = 0;
        goto L7
    }

    @Override // qs0.i
    public final boolean isMicRoomHost(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return ((IInteractService) this.a).isMicRoomHost(r2);
    }

    @Override // qs0.i
    public final void g(long r3, IBaseUser r5) {
        IInteractService r0 = (IInteractService) this.a;
        if ((r5 instanceof User) == true) goto L5;
        r5 = null;
    L5:
        User r6 = (User) r5;
        if (r6 == null) goto L10;
        r0.prepareInvite(r3, r6, "card");
        return;
    }
}
