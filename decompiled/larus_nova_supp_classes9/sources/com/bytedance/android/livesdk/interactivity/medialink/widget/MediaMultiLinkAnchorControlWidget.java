package com.bytedance.android.livesdk.interactivity.medialink.widget;

import am2.x;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.anchorlink.network.model.AnchorApplyData;
import com.bytedance.android.live.anchorlink.network.model.AnchorPermitData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkReplyResult;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService;
import com.bytedance.android.livesdk.interactivity.medialink.contract.AnchorLinkInitType;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiLinkAnchorControlContext;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.MediaAnchorLinkInviteFragment;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.MediaLinkDialog;
import com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.IMediaMultiLinkAnchorControlView;
import com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.MediaMultiLinkAnchorControlPresenter;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.BattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInviteContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerReplyContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkmicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import e92.l;
import e92.m;
import ey.j;
import ey.k;
import fy.h;
import fy.i;
import gd0.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/MediaMultiLinkAnchorControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Ley/j;", "Lx82/a;", "Lcom/bytedance/android/livesdk/interactivity/medialink/widget/presenter/IMediaMultiLinkAnchorControlView;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkAnchorControlWidget extends LiveWidget implements j, x82.a, IMediaMultiLinkAnchorControlView {
    public k a;
    public final nc0.b b;
    public final CompositeDisposable c;
    public Room d;
    public hy.a e;
    public MediaMultiLinkAnchorControlPresenter f;
    public MediaLinkDialog g;
    public final l.a h;
    public l i;
    public MediaMultiLinkAnchorControlContext j;
    public com.bytedance.android.livesdk.interactivity.medialink.contract.d k;
    public final a l;

    public static final class a extends hy.f.a {
        public final /* synthetic */ MediaMultiLinkAnchorControlWidget a;

        public a(MediaMultiLinkAnchorControlWidget r1) {
            this.a = r1;
        }

        public final void p(List<? extends Object> r5) {
            com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a r0 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0;
            r0.getClass();
            com.bytedance.android.livesdk.interactivity.medialink.contract.a r1 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
            if (r1 == null) goto L15;
            this.a.getClass();
            r0.getClass();
            com.bytedance.android.livesdk.interactivity.medialink.contract.a r2 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
            if (r2 == null) goto L7;
            boolean r3 = r2.k0(256);
        L8:
            if (r3 == false) goto L11;
            r1.onMultiAnchorStateChange(2);
            return;
        L11:
            if (Lists.isEmpty(r5) == true) goto L13;
            r1.onMultiAnchorStateChange(1);
            return;
        L13:
            r1.onMultiAnchorStateChange(0);
            return;
        L7:
            r3 = false;
            goto L8
        }

        public final void a(int r3, List r4) {
            Intrinsics.checkNotNullParameter(r4, "list");
            if (r3 == 17) goto L5;
            return;
        L5:
            CopyOnWriteArrayList r5 = (CopyOnWriteArrayList) r4;
            if (r5.size() != 1) goto L18;
            IBaseUser r6 = ((AnchorLinkUser) ListProtector.get(r5, 0)).getUser();
            if (r6 == null) goto L10;
            String r7 = r6.getIdString();
        L11:
            Room r0 = this.a.d;
            if (r0 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("mRoom");
        L15:
            if (Intrinsics.areEqual(r7, r0.getOwnerUserIdString()) == false) goto L18;
            p(new ArrayList());
            return;
        L10:
            r7 = null;
        L18:
            p(r5);
        }

        public final void c(int r2, List<User> r3) {
            Intrinsics.checkNotNullParameter(r3, "list");
            if (r2 == 17) goto L5;
            return;
        L5:
            p(r3);
        }

        public final void d(int r2, List<AnchorLinkUser> r3) {
            Intrinsics.checkNotNullParameter(r3, "list");
            if (r2 == 17) goto L5;
            return;
        L5:
            ((Widget) this.a).dataCenter.put("DATA_ANCHOR_LINK_USERS", r3);
        }
    }

    public static final class b implements hy.g {
        public b() {
        }

        public final long getChannelId() {
            return m.b();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.medialink.widget.MediaMultiLinkAnchorControlWidget$onCreate$5, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/interactivity/medialink/contract/MediaMultiLinkAnchorControlContext;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function0<MediaMultiLinkAnchorControlContext> {
        public static final AnonymousClass5 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass5();
        }

        public AnonymousClass5() {
            super(0, MediaMultiLinkAnchorControlContext.class, "<init>", "<init>()V", 0);
        }

        public final MediaMultiLinkAnchorControlContext invoke() {
            return new MediaMultiLinkAnchorControlContext();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m747invoke() {
            return invoke();
        }
    }

    public final void An(fy.j r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public final void Ec(fy.g r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public final void Fp(if r2) {
        Intrinsics.checkNotNullParameter(r2, "linkerMessage");
    }

    public final void H7(fy.b r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public final void Nb(fy.c r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public final void Oi(i r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final String getSpm() {
        return "a100.a100.a207";
    }

    public final void rc(fy.c r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public final void tj(fy.b r2, AnchorApplyData r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "applyResult");
    }

    public final void tl(fy.b r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public final void ub(i r2, AnchorPermitData r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "permitData");
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.b
    public final hy.e Np() {
        hy.a r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkUserCenter");
    L5:
        return r0;
    }

    public final void onDestroy() {
        nc0.b r0 = this.b;
        if (r0 == null) goto L5;
        r0.a(17, this);
    L5:
        xq();
        super.onDestroy();
        MediaMultiLinkAnchorControlPresenter r1 = this.f;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L8:
        r1.detachView();
        hy.a r2 = this.e;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkUserCenter");
    L11:
        vlc.d r3 = r2.j;
        if (r3 == null) goto L14;
        r3.removeMessageListener(r2);
    L14:
        r2.h.dispose();
        r2.i.clear();
        ((CopyOnWriteArrayList) r2.a).clear();
        ((CopyOnWriteArrayList) r2.b).clear();
        r2.e.clear();
        r2.c.clear();
        r2.d.clear();
        this.h.b("MultiLinkAnchorControlWidget onDestory");
        this.c.clear();
    }

    public final void xq() {
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r0 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r0 == null) goto L5;
        r0.m();
    L5:
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r1 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r1 == null) goto L10;
        DialogFragment r2 = r1.rg();
        if (r2 == null) goto L10;
        wq(r2);
    L10:
        MediaLinkDialog r3 = this.g;
        if (r3 == null) goto L14;
        wq(r3);
        return;
    }

    public MediaMultiLinkAnchorControlWidget() {
        ey.g.a.getClass();
        this.b = ey.g.a.a();
        this.c = new CompositeDisposable();
        this.h = new l.a();
        this.k = new com.bytedance.android.livesdk.interactivity.medialink.contract.d(null, null, null, null, 2047);
        this.l = new a(this);
    }

    public final void onCreate() {
        super.onCreate();
        x8.a.b("MediaLinkTracer", "MediaMultiLinkAnchorControlWidget onCreate", false);
        this.d = (Room) ((Widget) this).dataCenter.get("data_room", new Room());
        nc0.b r0 = this.b;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(((Widget) this).dataCenter, "dataCenter");
        this.a = new nc0.j(r0.d.linkOutManager());
        this.b.b(17, this);
    L5:
        hy.a r1 = new hy.a(((Widget) this).dataCenter, new b());
        r1.attach();
        r1.i(this.l);
        Unit r2 = Unit.INSTANCE;
        this.e = r1;
        Room r3 = this.d;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L8:
        MediaMultiLinkAnchorControlPresenter r4 = new MediaMultiLinkAnchorControlPresenter(r3, this.a);
        r4.g0(this);
        this.f = r4;
        Pair r5 = com.bytedance.live.datacontext.d.a(AnonymousClass5.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r5.getFirst(), MediaLinkContext.class);
        ((MediaMultiLinkAnchorControlContext) r5.getFirst()).getLinkService().d(this);
        RxUtilKt.c((Disposable) r5.getSecond(), this.c);
        this.j = (MediaMultiLinkAnchorControlContext) r5.getFirst();
    }

    @Override // x82.a
    public final com.bytedance.android.livesdk.interactivity.medialink.contract.d getConnectionContext() {
        return this.k;
    }

    @Override // x82.a
    public final k getLinkOutManager() {
        return this.a;
    }

    public static void wq(DialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void Ci(fy.c r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        hy.a r0 = Np();
        Iterator r1 = r0.c.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        User r2 = (User) r1.next();
        if (TextUtils.equals(r2.getCastSecUid(), r7.e) == false) goto L4;
        r0.k(r2);
    L9:
        if (r7.b != this.h.a) goto L43;
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r3 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r3 == null) goto L13;
        boolean r4 = r3.k0(256);
    L14:
        if (r4 == true) goto L43;
        CopyOnWriteArrayList r5 = r0.c;
        if (r5 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == false) goto L43;
        String r8 = r7.h;
        if (r8 != null) goto L26;
    L29:
        boolean r9 = true;
    L31:
        if ((!r9) == true) goto L43;
        if (m.c() == false) goto L35;
        x8.a.b("MediaLinkTracer", "intercept cancelSuccess reset", false);
        goto L43
    L35:
        MediaMultiLinkAnchorControlContext r10 = this.j;
        if (r10 == null) goto L42;
        com.bytedance.live.datacontext.i<w82.a> r11 = r10.getLogParams();
        if (r11 == null) goto L42;
        w82.a r13 = (w82.a) r11.getValue();
        if (r13 == null) goto L42;
        r13.a = null;
    L42:
        r0.clear(false);
        this.h.b("onCancelInviteSuccess");
        goto L43
    L26:
        if (r8.length() == 0) goto L29;
        r9 = false;
        goto L31
    L18:
        if (r5.isEmpty() == true) goto L21;
        r6 = false;
        goto L22
    L13:
        r4 = false;
    L43:
        r0.b(4, "cancel_success_callback");
    }

    @Override // x82.a
    public final boolean N(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        hy.a r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkUserCenter");
    L6:
        return r0.N(r3);
    }

    public final void P5(if r14) {
        Intrinsics.checkNotNullParameter(r14, "linkerMessage");
        if (r14.mScene == 17) goto L6;
        return;
    L6:
        if (r14.mInvite != null) goto L8;
        return;
    L8:
        Boolean r0 = Boolean.valueOf(v.a(jc1.k.n(IInteractService.class).getLinkMode(), 32));
        if (r0.booleanValue() == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L16;
        r0.booleanValue();
        yq(r14);
        return;
    L16:
        if (m.b() != 0) goto L18;
    L21:
        MediaMultiLinkAnchorControlContext r1 = this.j;
        if (r1 == null) goto L28;
        com.bytedance.live.datacontext.i<w82.a> r2 = r1.getLogParams();
        if (r2 == null) goto L28;
        w82.a r3 = (w82.a) r2.getValue();
        if (r3 == null) goto L28;
        r3.a = String.valueOf(r14.getMessageId());
    L28:
        this.h.a = r14.getLinkerId();
        l.a r4 = this.h;
        LinkerInviteContent r5 = r14.mInvite;
        if (r5 == null) goto L31;
        Intrinsics.checkNotNullParameter(r5, "$this$fromUid");
        String r6 = r5.get_fromUid();
    L32:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r4.c = r6;
        l.a r7 = this.h;
        BattleLinkerInviteMessageExtra r8 = r14.getBattleLinkerInviteMessageExtra();
        if (r8 == null) goto L35;
        int r9 = r8.getInviteType();
    L36:
        r7.c(r9);
        l.a r10 = this.h;
        Room r11 = this.d;
        if (r11 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L39:
        String r13 = r11.getOwnerUserIdString();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r15 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r15 == null) goto L42;
        r15.m();
    L42:
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r16 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r16 == null) goto L47;
        DialogFragment r17 = r16.rg();
        if (r17 == null) goto L47;
        wq(r17);
    L47:
        MediaLinkDialog r18 = new MediaLinkDialog();
        r18.k = this;
        MediaAnchorLinkInviteFragment r19 = new MediaAnchorLinkInviteFragment();
        r19.f = new u82.e(r19);
        r19.d = r18;
        r19.v = s1.B(2131920250);
        if (r14.getMType() != 3) goto L50;
        r19.o = 1;
    L50:
        r19.B = r14;
        r19.u = r18.T90().getId();
        r19.t = r14.getLinkerId();
        if (r14.getBattleLinkerInviteMessageExtra() == null) goto L53;
        r19.w = r14.getBattleLinkerInviteMessageExtra().getInviteType();
        r19.x = r14.getBattleLinkerInviteMessageExtra().getMatchType();
    L53:
        r19.q = r14.mInvite.get_fromUid();
        LinkerInviteContent r20 = r14.mInvite;
        r19.r = r20.secFromUserId;
        r19.y = r20.mInviteSource;
        if (ey.c.a(r14) == false) goto L76;
        List r21 = r14.mInvite.mInviteeFollowUsers;
        if (r21 == null) goto L67;
        List r23 = r21;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r25 = r23.iterator();
    L59:
        if (r25.hasNext() == false) goto L65;
        IBaseUser r26 = ((AnchorLinkUser) r25.next()).getUser();
        if (r26 == null) goto L63;
        String r27 = r26.getIdString();
    L64:
        r24.add(r27);
        goto L59
    L63:
        r27 = null;
        goto L64
    L65:
        String r28 = CollectionsKt.joinToString$default(r24, null, null, null, 0, null, null, 63, null);
        if (r28 == null) goto L67;
    L68:
        r19.C = r28;
        Iterator r29 = r14.mInvite.mInviterUsers.iterator();
    L70:
        if (r29.hasNext() == false) goto L76;
        AnchorLinkUser r30 = (AnchorLinkUser) r29.next();
        if (r30.getUser() == null) goto L70;
        if (n0.a(r30.getMUser().getIdStr(), r14.mInvite.get_fromUid()) == false) goto L70;
        r19.p = r30;
    L67:
        r28 = BuildConfig.FLAVOR;
    L76:
        r18.e = r19;
        Unit r110 = Unit.INSTANCE;
        this.g = r18;
        FragmentActivity r111 = ContextUtil.contextToFragmentActivity(((Widget) this).context);
        if (r111 == null) goto L100;
        FragmentManager r112 = r111.getSupportFragmentManager();
        if (r112 == null) goto L101;
        MediaLinkDialog r31 = this.g;
        if (r31 == null) goto L102;
        LandscapeRestrictionOperation r33 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r31, "MediaLinkDialog", r33);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r112, r31, r33) == true) goto L103;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L88
    L86:
        r31.show(r112, "MediaLinkDialog");
        return;
    L103:
        return;
    L102:
        return;
    L101:
        return;
    L100:
        return;
    L35:
        r9 = 0;
        goto L36
    L31:
        r6 = null;
        goto L32
    L18:
        if (m.b() == r14.getLinkerId()) goto L21;
        yq(r14);
    }

    public final void T5(fy.e r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        l.a r0 = this.h;
        r0.b = r3.e;
        r0.c(r3.d);
        l.a r1 = this.h;
        String r4 = r3.h.getOwnerUserIdString();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
    }

    public final void Vd(fy.e r14) {
        Intrinsics.checkNotNullParameter(r14, "params");
        int r0 = x8.a.a;
        x8.a.b("MediaLinkTracer", "link onInviteTimeOut, " + r14.c + ' ' + r14.h.getOwnerUserIdString() + " inviteSource=" + r14.m, false);
        if (m.b() == 0) goto L12;
        IMediaLinkOutService r1 = (IMediaLinkOutService) jc1.k.f(IMediaLinkOutService.class);
        if (r1 != null) goto L7;
    L8:
        k r2 = this.a;
        if (r2 == null) goto L14;
        long r3 = m.b();
        long r5 = r14.c;
        String r7 = r14.h.getOwnerUserIdString();
        String r8 = r14.g;
        Intrinsics.checkNotNullParameter(r7, "toUserId");
        Intrinsics.checkNotNullParameter(r8, "secToUserId");
        Intrinsics.checkNotNullParameter("invite_apply_timeout", "reqSrc");
        r2.c(new fy.c(17, r3, r5, r7, r8, 0, "invite_apply_timeout", null));
        return;
    L14:
        return;
    L7:
        if (r1.isUserInMediaLink(r14.h.getOwnerUserIdString()) != true) goto L8;
        return;
    }

    public final void qe(if r19) {
        Intrinsics.checkNotNullParameter(r19, "linkerMessage");
        if (r19.mScene == 17) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r2 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r2 == null) goto L11;
        if (v.a(r2.getCurrentMode(), 4) == false) goto L11;
        return;
    L11:
        if (this.h.a == r19.getLinkerId()) goto L13;
        return;
    L13:
        LinkerReplyContent r3 = r19.mReply;
        if (r3 != null) goto L16;
        return;
    L16:
        String r4 = r3.toast;
        if (r4 != null) goto L19;
    L24:
        LinkerReplyContent r5 = r19.mReply;
        if (r5 != null) goto L27;
    L73:
        hy.a r6 = Np();
        Iterator r10 = r6.c.iterator();
    L75:
        if (r10.hasNext() == false) goto L83;
        User r11 = (User) r10.next();
        String r13 = r11.getIdStr();
        LinkerReplyContent r14 = r19.mReply;
        if (r14 == null) goto L79;
        String r15 = r14.getToUserId();
    L81:
        if (Intrinsics.areEqual(r13, r15) == false) goto L75;
    L84:
        LinkerReplyContent r16 = r19.mReply;
        if (r16 != null) goto L87;
    L94:
        Room r7 = this.d;
        if (r7 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L97:
        String r8 = r7.getOwnerUserIdString();
        LinkerReplyContent r9 = r19.mReply;
        if (r9 == null) goto L100;
        String r17 = r9.getFromUserId();
    L102:
        if ((!Intrinsics.areEqual(r8, r17)) == false) goto L105;
        return;
    L105:
        if (r19.getMType() != 5) goto L108;
        if (r11 == null) goto L108;
        r6.k(r11);
    L108:
        LinkerReplyContent r18 = r19.mReply;
        if (r18 != null) goto L111;
    L113:
        hy.a r20 = Np();
        if (r19.mScene != 17) goto L120;
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r21 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r21 == null) goto L120;
        if (r21.k0(256) != true) goto L120;
        boolean r23 = true;
    L121:
        if (r23 == true) goto L138;
        hy.a r24 = r20;
        CopyOnWriteArrayList r25 = r24.c;
        if (r25 != null) goto L125;
    L128:
        boolean r26 = true;
    L129:
        if (r26 == false) goto L138;
        LinkerReplyContent r1 = r19.mReply;
        if (r1 != null) goto L133;
    L134:
        this.h.b("onReceiveReply disagree");
        MediaMultiLinkAnchorControlContext r27 = this.j;
        if (r27 == null) goto L137;
        ((w82.a) r27.getLogParams().getValue()).a = null;
    L137:
        r24.clear(false);
        goto L138
    L133:
        if (r1.replyStatus == 1) goto L138;
    L125:
        if (r25.isEmpty() == true) goto L128;
        r26 = false;
    L138:
        r20.b(4, "receive_reply");
        return;
    L120:
        r23 = false;
        goto L121
    L111:
        if (r18.replyStatus != 1) goto L113;
        xq();
        goto L113
    L100:
        r17 = null;
        goto L102
    L87:
        if (r16.replyStatus != 1) goto L94;
        if (m.d() == true) goto L91;
        Intrinsics.checkNotNullParameter(r19, "message");
        com.bytedance.android.livesdk.interactivity.medialink.contract.d r110 = new com.bytedance.android.livesdk.interactivity.medialink.contract.d(AnchorLinkInitType.REPLY_AGREE_MSG, "manual_link", "manual_link", new com.bytedance.android.livesdk.interactivity.medialink.contract.d.a(0, 6), 1928);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.k = r110;
        l.a r28 = this.h;
        r28.getClass();
        this.i = new l(r28);
    L91:
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r29 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r29 == null) goto L94;
        int r30 = com.bytedance.android.livesdk.interactivity.medialink.contract.e.c;
        r29.gq(new com.bytedance.android.livesdk.interactivity.medialink.contract.e(new com.bytedance.android.livesdk.interactivity.medialink.contract.f(this.i, this.k), null, 2));
        goto L94
    L79:
        r15 = null;
        goto L81
    L83:
        r11 = null;
        goto L84
    L27:
        if (r5.replyStatus != 1) goto L73;
        MultiChannelInfo r31 = r5.multiChannelInfo;
        if (r31 != null) goto L31;
    L41:
        Room r33 = this.d;
        if (r33 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L44:
        String r34 = r33.getOwnerUserIdString();
        LinkerReplyContent r111 = r19.mReply;
        if (r111 == null) goto L47;
        String r112 = r111.getFromUserId();
    L49:
        if (Intrinsics.areEqual(r34, r112) == false) goto L73;
        l.a r35 = this.h;
        LinkerReplyContent r113 = r19.mReply;
        if (r113 == null) goto L65;
        LinkmicInfo r114 = r113.fromLinkmicInfo;
        if (r114 == null) goto L65;
        Intrinsics.checkNotNullParameter(r114, "$this$getLinkerID");
        String r115 = r114.getMInteractIdStr();
        if (r115 != null) goto L57;
    L60:
        boolean r116 = true;
    L61:
        if (r116 == false) goto L63;
        String r117 = String.valueOf(r114.getMInteractId());
    L64:
        if (r117 == null) goto L65;
    L66:
        r35.getClass();
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        r35.g = r117;
        l.a r36 = this.h;
        LinkerReplyContent r118 = r19.mReply;
        if (r118 == null) goto L71;
        LinkmicInfo r119 = r118.fromLinkmicInfo;
        if (r119 == null) goto L71;
        String r120 = r119.getMRtcInfo();
    L72:
        r36.h = r120;
    L71:
        r120 = null;
        goto L72
    L63:
        r117 = r114.getMInteractIdStr();
        goto L64
    L57:
        if (r115.length() == 0) goto L60;
        r116 = false;
    L65:
        r117 = BuildConfig.FLAVOR;
        goto L66
    L47:
        r112 = null;
        goto L49
    L31:
        if (r31.getUseMultiChannel() == false) goto L41;
        Map r121 = r31.getChannelMap();
        if (r121 != null) goto L35;
    L38:
        boolean r122 = true;
    L39:
        if (r122 == true) goto L41;
        this.h.d = r31;
        goto L41
    L35:
        if (r121.isEmpty() == true) goto L38;
        r122 = false;
        goto L39
    L19:
        if (r4.length() <= 0) goto L21;
        boolean r37 = true;
    L22:
        if (r37 == false) goto L24;
        f2.c(r4, 0);
        goto L24
    L21:
        r37 = false;
        goto L22
    }

    public final void yq(if r15) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r0 == null) goto L20;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L21;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L22;
        k r13 = this.a;
        if (r13 == null) goto L23;
        long r3 = r15.getLinkerId();
        long r4 = r2.id;
        LinkerInviteContent r5 = r15.mInvite;
        if (r5 == null) goto L13;
        Intrinsics.checkNotNullParameter(r5, "$this$fromUid");
        String r8 = r5.get_fromUid();
    L14:
        LinkerInviteContent r16 = r15.mInvite;
        if (r16 == null) goto L17;
        String r17 = r16.secFromUserId;
    L18:
        r13.d(new fy.j(17, r3, r4, 4, r8, r17, null, null, new fy.a(0)));
        return;
    L17:
        r17 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void K8(fy.j r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r3.i.g == false) goto L6;
        return;
    L6:
        if (m.d() == true) goto L19;
        hy.a r5 = this.e;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkUserCenter");
    L10:
        r5.j();
        MediaMultiLinkAnchorControlContext r6 = this.j;
        if (r6 == null) goto L17;
        com.bytedance.live.datacontext.i<w82.a> r7 = r6.getLogParams();
        if (r7 == null) goto L17;
        w82.a r8 = (w82.a) r7.getValue();
        if (r8 == null) goto L17;
        r8.a = null;
    L17:
        this.h.b("onReplyFailed");
    L19:
        if ((r4 instanceof ApiServerException) == false) goto L29;
        ApiServerException r9 = (ApiServerException) r4;
        String r10 = r9.getPrompt();
        if (r10 != null) goto L23;
        return;
    L23:
        if (r10.length() <= 0) goto L25;
        boolean r11 = true;
    L26:
        if (r11 != true) goto L31;
        f2.c(r9.getPrompt(), 0);
        return;
    L31:
        return;
    L25:
        r11 = false;
        goto L26
    }

    @Override // x82.a
    public final void Mn(String r3, dy.a r4) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        Intrinsics.checkNotNullParameter(r4, "source");
        int r5 = x8.a.a;
        x8.a.b("MediaLinkTracer", "unloadModule reason=".concat(r3), false);
        this.h.b("finishMultiLink ".concat(r3));
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r6 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r6 == null) goto L6;
        r6.K4(256);
        return;
    }

    public final void Th(fy.e r8, Throwable r9) {
        Intrinsics.checkNotNullParameter(r8, "params");
        if ((r9 instanceof ApiServerException) == true) goto L5;
        Throwable r10 = null;
    L7:
        if (((ApiServerException) r10) == null) goto L15;
        int r11 = ((ApiServerException) r9).getErrorCode();
        if (r11 != 4004129) goto L12;
        HashMap r13 = new HashMap();
        r13.put("connection_type", "anchor");
        r13.put("control_user", "inviter");
        u.l().sendLog("livesdk_connection_anchor_control_toast_show", r13, new Object[]{Room.class, x.class});
        return;
    L12:
        if (r11 != 4004130) goto L17;
        HashMap r14 = new HashMap();
        r14.put("connection_type", "anchor");
        r14.put("control_user", "invitee");
        u.l().sendLog("livesdk_connection_anchor_control_toast_show", r14, new Object[]{Room.class, x.class});
        return;
    L17:
        return;
    L15:
        return;
    L5:
        r10 = r9;
        goto L7
    }

    public final void mn(int r6, if r7) {
        Intrinsics.checkNotNullParameter(r7, "linkerMessage");
        if (r7.mScene == 17) goto L5;
        return;
    L5:
        long r0 = this.h.a;
        if (r0 == 0) goto L11;
        if (r0 == r7.getLinkerId()) goto L11;
        return;
    L11:
        if (r7.getMType() != 9) goto L18;
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r8 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r8 != null) goto L15;
    L17:
        f2.b(2131920246, 1);
        goto L18
    L15:
        if (v.a(r8.getCurrentMode(), 256) == true) goto L17;
        jg(r6, "receive_link_message_9", false);
    L18:
        xq();
    }

    public final void Ah(fy.j r10, LinkReplyResult r11, long r13) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "replyResult");
        int r14 = r10.d;
        if (r14 != 4) goto L5;
        return;
    L5:
        fy.a r1 = r10.i;
        if (r1.g == false) goto L12;
        if (r14 != 1) goto L9;
        this.h.a(r11, r1);
        l.a r15 = this.h;
        r15.getClass();
        this.i = new l(r15);
    L9:
        int r16 = x8.a.a;
        x8.a.b("MediaLinkTracer", "replyMultiAnchor success " + r14 + ' ' + r1, false);
        return;
    L12:
        if (r14 != 1) goto L17;
        this.h.a(r11, r1);
        fy.a r17 = r10.i;
        Intrinsics.checkNotNullParameter(r11, "replyResult");
        Intrinsics.checkNotNullParameter(r17, "replyParams");
        com.bytedance.android.livesdk.interactivity.medialink.contract.d r18 = new com.bytedance.android.livesdk.interactivity.medialink.contract.d(AnchorLinkInitType.REPLY_AGREE_API, "manual_link", "manual_link", new com.bytedance.android.livesdk.interactivity.medialink.contract.d.a(r17.d, 6), 1928);
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        this.k = r18;
        l.a r19 = this.h;
        r19.getClass();
        this.i = new l(r19);
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r110 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r110 == null) goto L28;
        int r111 = com.bytedance.android.livesdk.interactivity.medialink.contract.e.c;
        r110.gq(new com.bytedance.android.livesdk.interactivity.medialink.contract.e(new com.bytedance.android.livesdk.interactivity.medialink.contract.f(this.i, this.k), null, 2));
    L28:
        if (r10.d == 4) goto L31;
        xq();
        return;
    L31:
        return;
    L17:
        if (m.c() == false) goto L19;
        x8.a.b("MediaLinkTracer", "intercept reply rejected reset", false);
        goto L28
    L19:
        MediaMultiLinkAnchorControlContext r112 = this.j;
        if (r112 == null) goto L26;
        com.bytedance.live.datacontext.i<w82.a> r113 = r112.getLogParams();
        if (r113 == null) goto L26;
        w82.a r114 = (w82.a) r113.getValue();
        if (r114 == null) goto L26;
        r114.a = null;
    L26:
        Np().clear(false);
        goto L28
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.contract.b
    public final void jg(int r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "reqSrc");
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r1 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r1 != null) goto L5;
    L25:
        if (r15 == true) goto L34;
        MediaMultiLinkAnchorControlContext r16 = this.j;
        if (r16 == null) goto L33;
        com.bytedance.live.datacontext.i<w82.a> r17 = r16.getLogParams();
        if (r17 == null) goto L33;
        w82.a r18 = (w82.a) r17.getValue();
        if (r18 == null) goto L33;
        r18.a = null;
    L33:
        this.h.b("finishMultiAnchor " + r14);
        Np().clear(false);
    L34:
        xq();
        return;
    L5:
        if (r13 != 17) goto L18;
        if (r1.k0(256) == false) goto L18;
        LiveWidget r19 = r1.Yf();
        if ((r19 instanceof MediaMultiLinkAnchorWidget) == true) goto L11;
        r19 = null;
    L11:
        MediaMultiLinkAnchorWidget r110 = (MediaMultiLinkAnchorWidget) r19;
        if (r110 == null) goto L25;
        if (N(ey.c.b()) == false) goto L16;
        r110.Cq(r14);
        goto L25
    L16:
        r110.Yu(r14, r15);
    L18:
        if (TextUtils.equals(r14, "receive_link_message_9") == false) goto L25;
        MediaMultiLinkAnchorControlPresenter r111 = this.f;
        if (r111 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L22:
        r111.getClass();
        Intrinsics.checkNotNullParameter(r14, "reqSrc");
        nc0.b r112 = r111.e;
        if (r112 == null) goto L25;
        com.bytedance.android.live.revenuelink.connect.l r113 = r112.d.linkInManager();
        Intrinsics.checkNotNullParameter(r113, "real");
        h r0 = new h(m.b(), 17, r14, false, null, ey.b.a(r14), 216);
        Intrinsics.checkNotNullParameter(r0, "leaveParams");
        r113.a(r0);
        goto L25
    }

    public final void zm(fy.e r2, long r3, LinkInviteResult r5, ey.l r6) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r5, "inviteResult");
        l.a r4 = this.h;
        r4.a = r5.getChannelId();
        w82.b.e(r2, r2.h);
        if (m.b() <= 0) goto L8;
        User r7 = r2.h.getOwner();
        if (r7 == null) goto L9;
        Np().e(r7);
        return;
    L9:
        return;
    }
}
