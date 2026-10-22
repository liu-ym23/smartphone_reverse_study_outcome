package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.presenter.AnchorStickerPresenter;
import com.bytedance.android.livesdk.chatroom.presenter.StickerPresenter;
import com.bytedance.android.livesdk.chatroom.ui.AbsInteractionFragment;
import com.bytedance.android.livesdk.chatroom.ui.SimpleInputDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.StickerDecorationDialogFragment;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.ew;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.android.livesdkapi.depend.model.live.DecorationDetail;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u00020\u0006:\u0003\u000e\u000f\u0010B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/AnchorStickerWrapperWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/StickerWrapperWidget;", "Lcom/bytedance/android/livesdk/chatroom/presenter/AnchorStickerPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/widget/u$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/w0;", "Lzg1/t2;", "event", "", "onEventV2", "onEvent", "<init>", "()V", "a", "b", "c", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorStickerWrapperWidget extends StickerWrapperWidget implements AnchorStickerPresenter.IView, com.bytedance.android.livesdk.chatroom.widget.u.b, w0 {
    public static final String C = null;
    public static long D;
    public static long E;
    public static final a F = null;
    public RoomDecoration A;
    public final e B;
    public boolean k;
    public boolean l;
    public String m;
    public int n;
    public com.bytedance.android.livesdk.chatroom.model.e3 o;
    public Disposable p;
    public Disposable q;
    public List<RoomDecoration> r;
    public final c s;
    public SimpleInputDialogFragment t;
    public int u;
    public final Map<Long, b> v;
    public StickerDecorationDialogFragment w;
    public boolean x;
    public boolean y;
    public RoomDecoration z;

    public static final class a {
        public a() {
        }

        public static final void a(a r0, long r1) {
            r0.getClass();
            AnchorStickerWrapperWidget.E = r1;
            xs2.b.a().post(new zg1.b3(null));
        }

        public static final void b(a r0, long r1) {
            r0.getClass();
            AnchorStickerWrapperWidget.D = r1;
            xs2.b.a().post(new zg1.b3(null));
        }
    }

    public static final class b {
        public final long a;
        public final int b;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L10;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b;
        }

        public final String toString() {
            return "StickerInfo(startUseTime=" + this.a + ", stickerType=" + this.b + ")";
        }

        public b(long r1, int r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public final class c extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d {
        public final /* synthetic */ AnchorStickerWrapperWidget b;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d
        public final int a() {
            return 2131384095;
        }

        public c(AnchorStickerWrapperWidget r1) {
            this.b = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            Intrinsics.checkNotNullParameter(r7, "v");
            int r8 = com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.a.a;
            NewBroadcastMonitor.a r9 = NewBroadcastMonitor.c("ttlive_anchor_sticker_panel_event", null, null, 14);
            r9.l(0);
            r9.a().report();
            DataCenter r10 = ((Widget) this.b).dataCenter;
            if (r10 == null) goto L11;
            Integer r11 = (Integer) r10.get("data_link_state", 0);
            if (gd0.v.a(r11.intValue(), 64) == false) goto L7;
        L8:
            com.bytedance.android.live.core.utils.f2.b(2131918918, 0);
            return;
        L7:
            if (gd0.v.a(r11.intValue(), 4) == true) goto L8;
        L11:
            if (com.bytedance.android.live.core.utils.z.k(((Widget) this.b).dataCenter) == false) goto L13;
        L14:
            com.bytedance.android.livesdk.chatroom.helper.c.a.getClass();
            LinkedHashMap r12 = new LinkedHashMap();
            com.bytedance.android.livesdk.chatroom.helper.c.a.a(r12, jc1.k.n(IInteractService.class).getCurrentScene());
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_prop_click", r12, new Object[]{Room.class});
        L15:
            this.b.Iq().l0(true);
            AnchorStickerWrapperWidget r13 = this.b;
            if ((((Widget) r13).context instanceof FragmentActivity) == true) goto L18;
        L27:
            ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
            throw null;
        L18:
            if (r13.w != null) goto L20;
            int r0 = StickerDecorationDialogFragment.h;
            DataCenter r1 = ((Widget) r13).dataCenter;
            com.bytedance.android.livesdk.chatroom.model.e3 r3 = r13.o;
            StickerDecorationDialogFragment r4 = new StickerDecorationDialogFragment();
            r4.f = r1;
            r4.e = r3;
            r4.setOnDismissListener(new com.bytedance.android.livesdk.chatroom.viewmodule.a(this));
            Unit r2 = Unit.INSTANCE;
            r13.w = r4;
        L20:
            AnchorStickerWrapperWidget r14 = this.b;
            StickerDecorationDialogFragment r5 = r14.w;
            if (r5 == null) goto L27;
            FragmentActivity r15 = ((Widget) r14).context;
            if (r15 == null) goto L26;
            r5.T90(r15.getSupportFragmentManager(), this.b.o);
            this.b.x = true;
            goto L27
        L26:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L13:
            if (com.bytedance.android.live.core.utils.z.g(((Widget) this.b).dataCenter) == false) goto L15;
            goto L14
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
        public final void p4(View r2, DataCenter r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            super.p4(r2, r3);
            r2.findViewById(2131384095);
            ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
            new WeakReference(this);
            throw null;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ AnchorStickerWrapperWidget a;
        public final /* synthetic */ DecorationDetail b;

        public d(AnchorStickerWrapperWidget r1, DecorationDetail r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            DecorationDetail r0 = this.b;
            if (r0 == null) goto L11;
            RoomDecoration r1 = r0.getTextDecoration();
            if (r1 == null) goto L7;
            this.a.wq(r1);
            AnchorStickerPresenter r2 = this.a.Iq();
            r2.p0(r2.k0(r1), r1.getId());
            this.a.Cq(r1);
        L7:
            RoomDecoration r3 = r0.getImageDecoration();
            if (r3 == null) goto L12;
            this.a.wq(r3);
            this.a.Cq(r3);
            return;
        L12:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements SimpleInputDialogFragment.c {
        public final /* synthetic */ AnchorStickerWrapperWidget a;

        public e(AnchorStickerWrapperWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.SimpleInputDialogFragment.c
        public final void h4(String r2) {
            Intrinsics.checkNotNullParameter(r2, "input");
            this.a.t = null;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.SimpleInputDialogFragment.c
        public final void onConfirm(String r2) {
            Intrinsics.checkNotNullParameter(r2, "input");
            AnchorStickerWrapperWidget.Eq(this.a, r2);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ AnchorStickerWrapperWidget a;

        public f(AnchorStickerWrapperWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            AnchorStickerWrapperWidget r0 = this.a;
            r0.onEventV2((zg1.t2) r2);
        }
    }

    public static final class g implements IAnnouncementService.AnnouncementStickerSetCallback {
        public final /* synthetic */ AnchorStickerWrapperWidget a;
        public final /* synthetic */ IAnnouncementService b;
        public final /* synthetic */ RoomDecoration c;

        public final void setAnnouncementSticker(String r5) {
            Intrinsics.checkNotNullParameter(r5, "content");
            StickerPresenter r0 = this.a.yq();
            if ((r0 instanceof AnchorStickerPresenter) == true) goto L6;
            r0 = null;
        L6:
            if (((AnchorStickerPresenter) r0) == null) goto L8;
            IAnnouncementService.DefaultImpls.getAnnouncementInfo$default(this.b, ((Widget) this.a).context, null, 2, null);
        L8:
            this.c.setContent(r5);
            this.a.wq(this.c);
        }

        public g(AnchorStickerWrapperWidget r1, IAnnouncementService r2, RoomDecoration r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final void MN() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final int getLayoutId() {
        return 2131568007;
    }

    public final String getSpm() {
        return "a100.a100.a108";
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    static {
        F = new a();
        C = "AnchorStickerWrapperWidget";
    }

    public final void Kq() {
        JSONArray r0 = new JSONArray();
        Iterator r1 = ((ArrayList) this.e).iterator();
        String r2 = "";
        String r6 = "";
        String r7 = r6;
        String r10 = r7;
    L4:
        if (r1.hasNext() == false) goto L9;
        com.bytedance.android.livesdk.chatroom.widget.u r3 = (com.bytedance.android.livesdk.chatroom.widget.u) r1.next();
        r0.put(r3.getDecorationInfo());
        if (r3.getRoomDecoration().isTextSticker() == true) goto L7;
        r7 = r3.getDecorationInfo().toString();
        r10 = r3.getStickerInfoMonitor();
        goto L4
    L7:
        r6 = r3.getDecorationInfo().toString();
        r2 = r3.getStickerInfoMonitor();
        goto L4
    L9:
        AnchorStickerPresenter r4 = Iq();
        Disposable r5 = r4.p;
        if (r5 == null) goto L12;
        r5.dispose();
    L12:
        com.bytedance.android.livesdk.service.l.d().getClass();
        r4.p = ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).setDecorationV2(r4.i, r6, r7, SystemClock.uptimeMillis()).compose(RxUtil.rxSchedulerHelper()).delay(300, TimeUnit.MILLISECONDS).subscribe(new com.bytedance.android.livesdk.chatroom.presenter.c(r4, r2, r10), new com.bytedance.android.livesdk.chatroom.presenter.d(r4));
    }

    public final void Pm() {
        SimpleInputDialogFragment r0 = this.t;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAdded() == false) goto L10;
        r0.h.setText("");
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget, com.bytedance.android.livesdk.chatroom.widget.u.b
    public final void vd() {
        if (this.x == false) goto L5;
        this.y = true;
        return;
    L5:
        this.y = false;
        Lq();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget, com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final void ve() {
        this.s.onClick(((Widget) this).contentView);
    }

    public AnchorStickerWrapperWidget() {
        this.m = "";
        this.r = CollectionsKt.emptyList();
        this.s = new c(this);
        this.v = new LinkedHashMap();
        this.B = new e(this);
    }

    public final List<RoomDecoration> Gq() {
        if (isViewValid() == false) goto L5;
        List<com.bytedance.android.livesdk.chatroom.widget.u> r0 = this.e;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r1.add(((com.bytedance.android.livesdk.chatroom.widget.u) r2.next()).getRoomDecoration());
        goto L8
    L10:
        return r1;
    L5:
        return CollectionsKt.emptyList();
    }

    public final void H00() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) this.e).iterator();
    L7:
        if (r0.hasNext() == false) goto L14;
        com.bytedance.android.livesdk.chatroom.widget.u r1 = (com.bytedance.android.livesdk.chatroom.widget.u) r0.next();
        if (r1.getType() != 1) goto L7;
        String r2 = r1.getRoomDecoration().getContent();
        r1.z = r2;
        r1.c.setText(r2);
        if (r1.j.getVisibility() != 0) goto L7;
        r1.i(r1.j, r1.z);
        goto L7
    }

    public final AnchorStickerPresenter Iq() {
        AnchorStickerPresenter r0 = yq();
        if (r0 == null) goto L7;
        return r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.presenter.AnchorStickerPresenter");
    }

    public final void Lq() {
        List<RoomDecoration> r0 = Gq();
        Kq();
        String r1 = GsonProtectorUtils.toJson(GsonHelper.get(), r0);
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.b.R;
        String r3 = this.h;
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.S;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.w0
    public final void hideKeyboard() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        SimpleInputDialogFragment r0 = this.t;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.h == null) goto L13;
        com.bytedance.android.livesdk.utils.t2.a(r0.getContext(), r0.h);
        return;
    }

    public final void ir() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) this.e).iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        com.bytedance.android.livesdk.chatroom.widget.u r1 = (com.bytedance.android.livesdk.chatroom.widget.u) r0.next();
        if (r1.getType() != 1) goto L7;
        AnchorStickerPresenter r2 = Iq();
        String r3 = r1.getRoomDecoration().getContent();
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        r2.p0(r3, r1.getRoomDecoration().getId());
        goto L7
    }

    public final void kv() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) this.e).iterator();
    L7:
        if (r0.hasNext() == false) goto L16;
        com.bytedance.android.livesdk.chatroom.widget.u r1 = (com.bytedance.android.livesdk.chatroom.widget.u) r0.next();
        if (r1.getType() != 1) goto L7;
        r1.e();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DecorationDetail r2 = null;
        Object r0 = ((Widget) this).dataCenter.get("data_room", null);
        Intrinsics.checkNotNull(r0);
        Room r1 = (Room) r0;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.i = r1;
        com.bytedance.android.live.core.utils.z.n(((Widget) this).dataCenter);
        User r3 = this.i.getOwner();
        if (r3 == null) goto L5;
        String r4 = r3.getIdStr();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.h = r4;
    L5:
        Room r5 = this.i;
        long r6 = r5.id;
        User r7 = r5.getOwner();
        if (r7 == null) goto L8;
        r7.getIdStr();
    L8:
        RoomOthersData r8 = this.i.others;
        if (r8 == null) goto L11;
        r2 = r8.getDecoDetail();
    L11:
        AnchorStickerPresenter r9 = new AnchorStickerPresenter(r6, r2, this.i.getLivePlatformSource());
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.g = r9;
        yq().g0(this);
        y3.f(((Widget) this).dataCenter).p(ToolbarButton.DECORATION.extended(), this.s);
        L7(zg1.t2.class, new f(this));
        ((Widget) this).dataCenter.observe("cmd_update_sticker_position", this, true).observe("cmd_update_sticker_visible", this).observe("data_room_audio_chat_ui_layout", this);
        if (ho1.a.o(getComponentContext()) == false) goto L15;
        ho1.a.p(getComponentContext(), w0.class, this);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final void onDestroy() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        SimpleInputDialogFragment r0 = this.t;
        if (r0 != null) goto L5;
    L8:
        a r1 = F;
        a.a(r1, 0);
        a.b(r1, 0);
        Disposable r2 = this.p;
        if (r2 != null) goto L11;
    L13:
        Disposable r3 = this.q;
        if (r3 != null) goto L16;
    L18:
        super.onDestroy();
        String r4 = "use";
        if (this.l == false) goto L21;
        Object r5 = "use";
    L23:
        if (this.k == true) goto L26;
        r4 = "unused";
    L26:
        long r6 = this.i.id;
        HashMap r7 = new HashMap();
        User r8 = this.i.getOwner();
        if (r8 == null) goto L29;
        r7.put("anchor_id", r8.getIdStr());
    L29:
        r7.put("room_id", String.valueOf(r6));
        r7.put("use_status", r4);
        com.bytedance.android.livesdk.log.g r9 = com.bytedance.android.livesdk.log.u.l();
        am2.x r10 = new am2.x();
        r10.b = "live_take_detail";
        r10.e = "other";
        r10.a = "live_take";
        r9.sendLog("live_picture_prop_use", r7, new Object[]{r10, new am2.z()});
        r7.put("use_status", r5);
        com.bytedance.android.livesdk.log.g r11 = com.bytedance.android.livesdk.log.u.l();
        am2.x r12 = new am2.x();
        r12.b = "live_take_detail";
        r12.e = "other";
        r12.a = "live_take";
        r11.sendLog("live_character_prop_use", r7, new Object[]{r12, new am2.z()});
        Map<Long, b> r13 = this.v;
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator r15 = ((LinkedHashMap) r13).entrySet().iterator();
    L31:
        if (r15.hasNext() == false) goto L40;
        Map.Entry r16 = (Map.Entry) r15.next();
        if (((Number) r16.getKey()).longValue() != 0) goto L35;
    L37:
        boolean r17 = false;
    L38:
        if (r17 == false) goto L31;
        r14.put(r16.getKey(), r16.getValue());
        goto L31
    L35:
        if (((b) r16.getValue()).a == 0) goto L37;
        r17 = true;
        goto L38
    L40:
        Iterator r18 = r14.entrySet().iterator();
    L42:
        if (r18.hasNext() == false) goto L44;
        Jq(((Number) ((Map.Entry) r18.next()).getKey()).longValue());
        goto L42
    L44:
        ((LinkedHashMap) this.v).clear();
        h70.b r19 = getComponentContext();
        if (r19 == null) goto L54;
        ho1.a.q(r19, w0.class);
        return;
    L54:
        return;
    L21:
        r5 = "unused";
        goto L23
    L16:
        if (r3.isDisposed() == true) goto L18;
        r3.dispose();
        goto L18
    L11:
        if (r2.isDisposed() == true) goto L13;
        r2.dispose();
        goto L13
    L5:
        if (r0.h == null) goto L8;
        com.bytedance.android.livesdk.utils.t2.a(r0.getContext(), r0.h);
        goto L8
    }

    public final void ry() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) this.e).iterator();
    L7:
        if (r0.hasNext() == false) goto L16;
        com.bytedance.android.livesdk.chatroom.widget.u r1 = (com.bytedance.android.livesdk.chatroom.widget.u) r0.next();
        if (r1.getType() != 1) goto L7;
        r1.j();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget, com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final com.bytedance.android.livesdk.chatroom.model.e3 Qn() {
        return this.o;
    }

    public static FragmentActivity Fq(Context r1) {
        if ((r1 instanceof FragmentActivity) == false) goto L7;
        return (FragmentActivity) r1;
    L7:
        if ((r1 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return Fq(((ContextWrapper) r1).getBaseContext());
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final void Aq(KVData r4) {
        Intrinsics.checkNotNullParameter(r4, "kvData");
        String r0 = r4.getKey();
        int r1 = r0.hashCode();
        if (r1 == (-929264481)) goto L26;
        if (r1 == 421233308) goto L16;
        if (r1 == 2144644902) goto L10;
        return;
    L10:
        if (r0.equals("data_room_audio_chat_ui_layout") == false) goto L55;
        this.c[1] = this.u;
        Iterator r5 = ((ArrayList) this.e).iterator();
    L13:
        if (r5.hasNext() == false) goto L67;
        ((com.bytedance.android.livesdk.chatroom.widget.u) r5.next()).m(this.c);
        goto L13
    L67:
        return;
    L55:
        return;
    L16:
        if (r0.equals("cmd_update_sticker_position") == false) goto L56;
        zg1.c3 r6 = (zg1.c3) r4.getData();
        if (isViewValid() == true) goto L20;
        return;
    L20:
        if (((Widget) this).context == null) goto L63;
        if (r6 == null) goto L64;
        ((Widget) this).contentView.post(new com.bytedance.android.livesdk.chatroom.viewmodule.c(this, r6));
        return;
    L64:
        return;
    L63:
        return;
    L56:
        return;
    L26:
        if (r0.equals("cmd_update_sticker_visible") == false) goto L59;
        Boolean r7 = (Boolean) r4.getData();
        ALogger.e(C, "onDecorationVisibleChanged visible: " + r7 + ", mIsAnchor: true");
        if (isViewValid() == false) goto L60;
        if (r7 != null) goto L32;
        return;
    L32:
        if (r7.booleanValue() == false) goto L39;
        Iterator<RoomDecoration> r8 = this.r.iterator();
    L35:
        if (r8.hasNext() == false) goto L37;
        wq(r8.next());
        goto L35
    L37:
        vd();
        this.r = CollectionsKt.emptyList();
        return;
    L39:
        if (((ArrayList) this.e).isEmpty() == true) goto L66;
        this.r = Gq();
        Iterator r9 = ((ArrayList) this.e).iterator();
    L43:
        if (r9.hasNext() == false) goto L49;
        com.bytedance.android.livesdk.chatroom.widget.u r2 = (com.bytedance.android.livesdk.chatroom.widget.u) r9.next();
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L48;
        ((ViewGroup) r3).removeView(r2);
        r9.remove();
        goto L43
    L48:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L49:
        Kq();
        return;
    L66:
        return;
    L60:
        return;
    }

    public final void Aw(String r5) {
        Intrinsics.checkNotNullParameter(r5, "text");
        if (isViewValid() == true) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) this.e).iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        com.bytedance.android.livesdk.chatroom.widget.u r1 = (com.bytedance.android.livesdk.chatroom.widget.u) r0.next();
        if (r1.getType() != 1) goto L7;
        r1.setText(r5);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final void Cq(RoomDecoration r9) {
        Intrinsics.checkNotNullParameter(r9, "decoration");
        boolean r1 = false;
        if (r9.getType() != 1) goto L5;
        boolean r0 = true;
    L6:
        HashMap r3 = new HashMap();
        r3.put("room_id", String.valueOf(this.i.id));
        User r4 = this.i.getOwner();
        if (r4 == null) goto L9;
        r3.put("anchor_id", r4.getIdStr());
    L9:
        r3.put("prop_id", String.valueOf(r9.getId()));
        Room r5 = this.i;
        if (r5 == null) goto L12;
        LiveMode r6 = r5.getStreamType();
    L13:
        int r7 = com.bytedance.android.live.core.utils.h1.a;
        r3.put("live_type", com.bytedance.android.live.core.utils.i1.a(r6));
        if (r0 == false) goto L23;
        String r8 = Iq().k0(r9);
        r3.put("words", r8);
        int r10 = jc1.k.n(IInteractService.class).getCurrentScene();
        com.bytedance.android.livesdk.chatroom.helper.c.a.getClass();
        com.bytedance.android.livesdk.chatroom.helper.c.a.a(r3, r10);
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L18;
        String r11 = SourceType.ANCHOR;
    L19:
        r3.put("user_type", r11);
        if (StringsKt.isBlank(r8) == false) goto L23;
        ALogger.w(C, "sticker show text sticker usage, empty content, aborting");
        return;
    L18:
        r11 = "user";
    L23:
        com.bytedance.android.livesdk.log.g r12 = com.bytedance.android.livesdk.log.u.l();
        if (r0 == false) goto L26;
        String r2 = "live_character_prop_show";
    L27:
        am2.x r13 = new am2.x();
        r13.b = "live_take_detail";
        r13.e = "other";
        r13.a = "live_take";
        r12.sendLog(r2, r3, new Object[]{r13, new am2.z()});
        if (r9.getType() != 1) goto L30;
        r1 = true;
    L30:
        if (r1 == false) goto L32;
        Disposable r14 = this.p;
    L33:
        if (r14 != null) goto L35;
    L37:
        Disposable r15 = Observable.timer(30, TimeUnit.SECONDS).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.chatroom.viewmodule.b(this, r9));
        if (r1 == false) goto L40;
        this.p = r15;
    L41:
        this.v.put(Long.valueOf(r9.getId()), new b(System.currentTimeMillis(), r9.getType()));
        return;
    L40:
        this.q = r15;
        goto L41
    L35:
        if (r14.isDisposed() == true) goto L37;
        r14.dispose();
        goto L37
    L32:
        r14 = this.q;
        goto L33
    L26:
        r2 = "live_picture_prop_show";
        goto L27
    L12:
        r6 = null;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public final void Fx(com.bytedance.android.livesdk.chatroom.model.e3 r3) {
        this.o = r3;
        xs2.b.a().post(new zg1.b3(r3));
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.u.b
    public final void Jb(boolean r5) {
        StickerWrapperWidget.a r0 = this.a;
        if (r0 == null) goto L5;
        ((AbsInteractionFragment) r0).kb0(r5);
        return;
    L5:
        LayerEventDispatcher r1 = o70.c.a(Integer.valueOf(((Widget) this).dataCenter.hashCode()));
        if (r1 == null) goto L10;
        r1.b(new bh1.a(r5, com.bytedance.android.live.core.utils.z.e(((Widget) this).dataCenter, false)));
        return;
    }

    public final void Jq(long r8) {
        b r0 = (b) ((LinkedHashMap) this.v).get(Long.valueOf(r8));
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == 0) goto L16;
        long r1 = (System.currentTimeMillis() - r0.a) / ((long) BubbleId.PadCast);
        if (r1 <= 0) goto L13;
        com.bytedance.android.livesdk.chatroom.helper.c.a r3 = com.bytedance.android.livesdk.chatroom.helper.c.a;
        int r2 = r0.b;
        r3.getClass();
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("prop_id", String.valueOf(r8));
        r4.put("use_time", String.valueOf(r1));
        if (r2 != 1) goto L11;
        String r5 = "character";
    L12:
        r4.put("prop_type", r5);
        r4.put("event_page", "live_take_detail");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_prop_use_time", r4, new Object[]{Room.class});
        goto L13
    L11:
        r5 = "picture";
    L13:
        this.v.remove(Long.valueOf(r8));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final void OS(DecorationDetail r3) {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L6;
        r0.post(new d(this, r3));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget, com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final boolean Z5(long r9) {
        com.bytedance.android.livesdk.chatroom.model.e3 r0 = this.o;
        if (r0 == null) goto L5;
        final RoomDecoration r10 = r0.a(r9);
    L7:
        if (r10 != null) goto L9;
    L28:
        return false;
    L9:
        if (isViewValid() == false) goto L28;
        RoomSpecificSceneTypeInfo r1 = this.i.getSceneTypeInfo();
        if (r1 != null) goto L13;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == true) goto L28;
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L26;
        Integer r4 = (Integer) r3.get("data_link_state", 0);
        if (gd0.v.a(r4.intValue(), 64) == false) goto L23;
    L24:
        com.bytedance.android.live.core.utils.f2.b(2131918918, 0);
        return false;
    L23:
        if (gd0.v.a(r4.intValue(), 4) == true) goto L24;
    L26:
        UtilityKotlinExtentionsKt.s(0, false, false, new AnchorStickerWrapperWidget$addStickerById$1(this, r10), 7);
        return true;
    L13:
        if (r1.isLandscapeVertical() != true) goto L15;
        r2 = true;
        goto L16
    L5:
        r10 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget, com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final boolean fi(long r12) {
        if (isViewValid() == true) goto L5;
        return false;
    L5:
        Iterator r0 = ((ArrayList) this.e).iterator();
    L6:
        final RoomDecoration r4 = null;
        if (r0.hasNext() == false) goto L14;
        Object r2 = r0.next();
        if (((com.bytedance.android.livesdk.chatroom.widget.u) r2).getRoomDecoration().getId() != r12) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L6;
    L15:
        com.bytedance.android.livesdk.chatroom.widget.u r3 = (com.bytedance.android.livesdk.chatroom.widget.u) r2;
        if (r3 == null) goto L18;
        r4 = r3.getRoomDecoration();
    L18:
        if (r4 != null) goto L20;
        return false;
    L20:
        UtilityKotlinExtentionsKt.s(0, false, false, new AnchorStickerWrapperWidget$removeStickerById$1(this, r4), 7);
        return true;
    L11:
        r5 = false;
        goto L12
    L14:
        r2 = null;
        goto L15
    }

    @Deprecated(message = "贴纸技术优化")
    public final void onEvent(zg1.t2 r4) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r4 == null) goto L33;
        RoomDecoration r5 = r4.a;
        if (r5 == null) goto L34;
        RoomDecoration.TextComposeOption r0 = r5.selectedComposeOption;
        if (r0 != null) goto L12;
    L20:
        IAnnouncementService r1 = jc1.k.f(IAnnouncementService.class);
        if (r5.getSubType() != 1) goto L26;
        if (r1 == null) goto L26;
        if (r1.enable() == false) goto L26;
        r1.operateAnnouncementFromStickPanel(((Widget) this).context, new g(this, r1, r5));
    L28:
        if (r5.isTextSticker() == false) goto L30;
        this.z = r5;
    L31:
        Cq(r5);
        return;
    L30:
        this.A = r5;
    L26:
        wq(r5);
        goto L28
    L12:
        if (r0.isCustomEdit() == false) goto L14;
    L15:
        int r2 = AnchorStickerPresenter.u;
        if (r5.getMaxLength() > 0) goto L18;
        int r3 = 8;
    L19:
        this.n = r3;
        String r6 = r0.getCustomText();
        r0.isTimeText();
        Eq(this, r6);
        goto L20
    L18:
        r3 = r5.getMaxLength();
        goto L19
    L14:
        if (r0.isTimeText() == false) goto L20;
    L34:
        return;
    }

    public final void onEventV2(zg1.t2 r2) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r2 == null) goto L15;
        RoomDecoration r3 = r2.a;
        if (r3 == null) goto L16;
        wq(r3);
        if (r3.isTextSticker() == false) goto L12;
        this.z = r3;
    L13:
        Cq(r3);
        return;
    L12:
        this.A = r3;
        goto L13
    L16:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.u.b
    public final void q8(RoomDecoration r10) {
        Intrinsics.checkNotNullParameter(r10, "roomDecoration");
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (r10.isTextSticker() == false) goto L8;
        Disposable r0 = this.p;
    L9:
        if (r0 != null) goto L11;
    L13:
        Bq(r10, true);
        if (r10.isTextSticker() == false) goto L19;
        String r1 = Iq().k0(r10);
        AnchorStickerPresenter r4 = Iq();
        r4.j = "";
        r4.s = false;
        com.bytedance.android.livesdk.chatroom.helper.c.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "decorationText");
        HashMap r5 = new HashMap();
        com.bytedance.android.livesdk.chatroom.helper.c.a.a(r5, jc1.k.n(IInteractService.class).getCurrentScene());
        RoomContext.Companion.getClass();
        RoomContext r7 = RoomContext.a.a(null, 0);
        Intrinsics.checkNotNull(r7);
        Room r8 = (Room) r7.getRoom().getValue();
        if (r8 == null) goto L18;
        LiveMode r9 = r8.getStreamType();
        int r11 = com.bytedance.android.live.core.utils.h1.a;
        r5.put("live_type", com.bytedance.android.live.core.utils.i1.a(r9));
    L18:
        r5.put("words", r1);
        r5.put("prop_id", String.valueOf(Long.valueOf(r10.getId())));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_prop_delete", r5, new Object[]{Room.class});
        Iq().j0("");
    L19:
        Room r2 = this.i;
        int r3 = com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.a.a;
        if (r2 == null) goto L27;
        JSONObject r6 = new JSONObject();
        r6.put("room_id", String.valueOf(r2.id));
        LiveMode r12 = r2.getStreamType();
        int r13 = com.bytedance.android.live.core.utils.h1.a;
        r6.put("live_type", com.bytedance.android.live.core.utils.i1.a(r12));
        r6.put("source", "live_take_detail");
        r6.put("sticker_id", String.valueOf(r10.getId()));
        if (r10.isTextSticker() == false) goto L25;
        r6.put("sticker_type", "text");
        r6.put("sticker_content", r10.getContent());
    L26:
        NewBroadcastMonitor.a r14 = NewBroadcastMonitor.c("ttlive_anchor_delete_sticker", null, null, 14);
        ((LiveMonitor.a) r14).e = r6;
        r14.a().report();
        goto L27
    L25:
        r6.put("sticker_type", "image");
    L27:
        Jq(r10.getId());
        return;
    L11:
        if (r0.isDisposed() == true) goto L13;
        r0.dispose();
        goto L13
    L8:
        r0 = this.q;
        goto L9
    }

    public final void showToast(String r3) {
        Intrinsics.checkNotNullParameter(r3, "toast");
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L7;
        ALogger.e(C, "show toast in non ui thread");
        return;
    L7:
        if (isViewValid() == true) goto L9;
        return;
    L9:
        IESUIUtils.displayToast(((Widget) this).context, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final int zq(int r3) {
        if (ew.a.getValue().booleanValue() == false) goto L7;
        int r0 = this.c[1];
        if (r0 <= 0) goto L7;
        return r0;
    L7:
        return r3;
    }

    public static void Eq(AnchorStickerWrapperWidget r2, String r3) {
        if (r2.Iq().l == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        r3 = r2.m;
    L8:
        if (r3 != null) goto L10;
    L12:
        Context r4 = ((Widget) r2).context;
        IESUIUtils.displayToast(r4, r4.getString(2131916150, new Object[]{Integer.valueOf(r2.n)}));
        return;
    L10:
        if (r3.length() > r2.n) goto L12;
        r2.Iq().p0(r3, D);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final void Bq(RoomDecoration r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "decoration");
        super.Bq(r4, r5);
        if (1 != r4.getType()) goto L6;
        a.b(F, 0);
        return;
    L6:
        if (2 != r4.getType()) goto L10;
        a.a(F, 0);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.u.b
    public final void Lf(String r6, RoomDecoration r7) {
        Intrinsics.checkNotNullParameter(r6, "text");
        Intrinsics.checkNotNullParameter(r7, "roomDecoration");
        if (isViewValid() == false) goto L46;
        com.bytedance.android.livesdk.chatroom.model.e3 r0 = Iq().n;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L18;
        Context r8 = ((Widget) this).context;
        AnchorStickerPresenter r9 = Iq();
        com.bytedance.android.livesdk.chatroom.model.e3 r2 = r9.n;
        if (r2 == null) goto L16;
        String r10 = r2.g();
    L17:
        IESUIUtils.displayToast(r8, r10);
        return;
    L16:
        r10 = r9.h0(2131916147);
        goto L17
    L18:
        if (r7 != null) goto L20;
    L23:
        int r11 = 8;
    L24:
        this.n = r11;
        ((Widget) this).dataCenter.put("data_pre_show_keyboard", Boolean.TRUE);
        SimpleInputDialogFragment r12 = this.t;
        if (r12 != null) goto L36;
        FragmentActivity r13 = Fq(((Widget) this).context);
        if (r13 == null) goto L44;
        SimpleInputDialogFragment r14 = SimpleInputDialogFragment.S90(r6, ((Widget) this).context.getString(2131916150, new Object[]{Integer.valueOf(this.n)}), this.n, true);
        this.t = r14;
        r14.f = this.B;
        FragmentManager r15 = r13.getSupportFragmentManager();     // Catch: IllegalStateException -> L35
        String r3 = C;     // Catch: IllegalStateException -> L35
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: IllegalStateException -> L35
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, r3, r4);     // Catch: IllegalStateException -> L35
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r14, r4) == true) goto L47;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L33:
        r14.show(r15, r3);     // Catch: IllegalStateException -> L35
        return;
    L47:
        return;
    L35:
        this.t = null;
        return;
    L44:
        return;
    L36:
        r12.updateInput(r6);
        return;
    L20:
        if (r7.getMaxLength() <= 0) goto L23;
        r11 = r7.getMaxLength();
        goto L24
    L8:
        if (r0.i() == true) goto L11;
        r1 = false;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget
    public final void xq(RoomDecoration r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "roomDecoration");
        if (((Widget) this).containerView != null) goto L6;
        return;
    L6:
        if (r9.getImage() == null) goto L8;
    L10:
        ViewGroup r1 = ((Widget) this).containerView;
        if (r1 == null) goto L33;
        com.bytedance.android.livesdk.chatroom.widget.u r11 = new com.bytedance.android.livesdk.chatroom.widget.u(r1, r9, true, this.c, this, null);
        if (r9.getType() != 1) goto L15;
        r11.setText(Iq().k0(r9));
        this.m = r9.getContent();
        Iq().j0(Iq().k0(r9));
    L15:
        ((ArrayList) this.e).add(r11);
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L31;
        ((ViewGroup) r0).addView(r11);
        if (1 != r9.getType()) goto L21;
        a.b(F, r9.getId());
    L24:
        if (1 == r9.getType()) goto L26;
        return;
    L26:
        if (Iq().s == false) goto L28;
        r11.j();
        return;
    L28:
        r11.e();
        return;
    L21:
        if (2 != r9.getType()) goto L24;
        a.a(F, r9.getId());
        goto L24
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L8:
        if (r9.getNinePatchImage() != null) goto L10;
    }
}
