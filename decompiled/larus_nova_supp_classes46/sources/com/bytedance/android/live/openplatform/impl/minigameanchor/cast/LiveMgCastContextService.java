package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.h0;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.model.t;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.MiniGameAnchorApi;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame.LiveMgXplayRtcContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.LiveMgMountContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.v;
import com.bytedance.android.live.openplatform.impl.minigamecommon.event.BridgeContextService;
import com.bytedance.android.livesdk.config.c90;
import com.bytedance.android.livesdk.interactivity.api.settings.config.q;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.UserDslBadgeUtils;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.message.SuffixText;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import r52.p0;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\tB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/cast/LiveMgCastContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMgCastContextService extends OpenPlatformContextService implements Observer<KVData>, vlc.l {
    public static final /* synthetic */ int o = 0;
    public com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c a;
    public Disposable b;
    public com.bytedance.android.live.openplatform.impl.minigameanchor.cast.h c;
    public com.bytedance.android.live.openplatform.impl.minigameanchor.cast.a d;
    public final Set<Long> e;
    public View f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final LimitedSizeHashMap<Long, Object> k;
    public boolean l;
    public Rect m;
    public Rect n;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ LiveMgCastContextService a;

        public b(LiveMgCastContextService r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r4 = (List) r3;
            Intrinsics.checkNotNullParameter(r4, "msgList");
            LiveMgCastContextService r0 = this.a;
            int r1 = LiveMgCastContextService.o;
            return r0.h(r4);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveMgCastContextService a;

        public c(LiveMgCastContextService r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            LiveMgCastContextService r0 = this.a;
            int r1 = LiveMgCastContextService.o;
            r0.m((List) r3);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LiveMgCastContextService a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Rect c;
        public final /* synthetic */ Rect d;
        public final /* synthetic */ JSONObject e;

        public d(LiveMgCastContextService r1, String r2, Rect r3, Rect r4, JSONObject r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r5) {
            Response r6 = (Response) r5;
            int r0 = qo0.a.a;
            qo0.a.a("LiveMgCastContextService", "request game/startCast success: " + ((yq0.h) r6.data));
            if (r6.statusCode == 0) goto L5;
        L7:
            this.a.p(this.b, this.c, this.d, this.e);
            return;
        L5:
            if (((yq0.h) r6.data).a() != 2) goto L7;
            f2.c(((yq0.h) r6.data).b(), 0);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LiveMgCastContextService a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Rect c;
        public final /* synthetic */ Rect d;
        public final /* synthetic */ JSONObject e;

        public e(LiveMgCastContextService r1, String r2, Rect r3, Rect r4, JSONObject r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r5) {
            qo0.a.b("LiveMgCastContextService", "request game/startCast fail", (Throwable) r5);
            this.a.p(this.b, this.c, this.d, this.e);
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ LiveMgCastContextService a;
        public final /* synthetic */ boolean b;

        public f(LiveMgCastContextService r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            XplayExternalContext r0 = XplayExternalContext.Companion.getContext();
            if (r0 == null) goto L28;
            n r1 = r0.getInteractPlayContainer();
            if (r1 == null) goto L29;
            ViewGroup r2 = (ViewGroup) r1.getValue();
            if (r2 == null) goto L30;
            ViewParent r3 = null;
            if (this.b == false) goto L23;
            LiveMgCastContextService r4 = this.a;
            r4.f = new zq0.a(r2.getContext(), r2.getHeight());
            View r5 = this.a.f;
            if (r5 == null) goto L31;
            ViewGroup.LayoutParams r6 = r2.getLayoutParams();
            int r7 = RangesKt.coerceAtLeast(s1.w(), s1.y());
            if (r6 == null) goto L15;
            r6.height = r7 - s1.f(52.0f);
        L15:
            r2.setLayoutParams(r6);
            ViewParent r8 = r5.getParent();
            if ((r8 instanceof ViewGroup) == false) goto L19;
            r3 = r8;
        L19:
            ViewGroup r9 = (ViewGroup) r3;
            if (r9 == null) goto L22;
            r9.removeView(r5);
        L22:
            r2.addView(r5);
            return;
        L31:
            return;
        L23:
            View r10 = this.a.f;
            if (r10 == null) goto L26;
            r2.removeView(r10);
        L26:
            this.a.f = null;
            return;
        L30:
            return;
        L29:
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

    public static final class g implements Runnable {
        public final /* synthetic */ LiveMgCastContextService a;

        public g(LiveMgCastContextService r1) {
            this.a = r1;
        }

        public final void a() {
            LiveMgCastContextService r0 = this.a;
            int r1 = LiveMgCastContextService.o;
            r0.getClass();
            qo0.a.c("LiveMgCastContextService", "startLiveCast");
            AnchorMiniGameDataContext.Companion.getClass();
            AnchorMiniGameDataContext r2 = AnchorMiniGameDataContext.a.a();
            if (r2 == null) goto L11;
            m<Boolean> r3 = r2.getOpenCamera();
            if (r3 == null) goto L11;
            Observable r4 = r3.a();
            if (r4 == null) goto L11;
            Disposable r5 = r4.subscribe(new com.bytedance.android.live.openplatform.impl.minigameanchor.cast.g(r0));
            if (r5 == null) goto L11;
            r0.autoDispose(r5);
        L11:
            AnchorMiniGameDataContext r6 = AnchorMiniGameDataContext.a.a();
            if (r6 == null) goto L16;
            m<Rect> r7 = r6.getLittleWindowRect();
            if (r7 == null) goto L16;
            r7.setValue(r0.n);
        L16:
            DataCenter r8 = r0.getOpenPlatformContext().getDataCenter();
            if (r8 == null) goto L19;
            r8.observe("cmd_anchor_broadcast_end", r0);
        L19:
            DataCenter r9 = r0.getOpenPlatformContext().getDataCenter();
            if (r9 == null) goto L23;
            r9.observe("data_link_state", r0);
        L23:
            if (r0.l == false) goto L29;
            if (r0.a != null) goto L27;
            r0.a = new k();
        L27:
            r0.o();
            return;
        L29:
            if (r0.i == false) goto L35;
            if (r0.a != null) goto L33;
            r0.a = new com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame.b();
        L33:
            LiveMgXplayRtcContextService.f((LiveMgXplayRtcContextService) r0.getOpenPlatformContext().getService(LiveMgXplayRtcContextService.class), r0.j, r0.m);
            r0.j(null);
            return;
        L35:
            if (r0.j == false) goto L41;
            if (r0.a != null) goto L39;
            r0.a = new com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame.c();
        L39:
            r0.o();
            return;
        L41:
            if (r0.a != null) goto L43;
            r0.a = new l();
        L43:
            r0.o();
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

    public static final class h implements Runnable {
        public final /* synthetic */ LiveMgCastContextService a;

        public h(LiveMgCastContextService r1) {
            this.a = r1;
        }

        public final void a() {
            LiveMgCastContextService.f(this.a);
            LiveMgCastContextService r0 = this.a;
            if (r0.i == false) goto L5;
            ((LiveMgXplayRtcContextService) r0.getOpenPlatformContext().getService(LiveMgXplayRtcContextService.class)).g();
        L6:
            LiveMgCastContextService r1 = this.a;
            com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c r2 = r1.a;
            if (r2 == null) goto L9;
            r2.setRadioMode(false);
        L9:
            r1.a = null;
            r1.n(false);
            r1.dispose();
            Disposable r3 = r1.b;
            if (r3 == null) goto L12;
            r3.dispose();
        L12:
            r1.b = null;
            r1.k.clear();
            r1.h = false;
            r1.g = false;
            AnchorMiniGameDataContext.Companion.getClass();
            AnchorMiniGameDataContext r4 = AnchorMiniGameDataContext.a.a();
            if (r4 == null) goto L17;
            m<Boolean> r5 = r4.getOpenCamera();
            if (r5 == null) goto L17;
            r5.setValue((Boolean) c90.a.getValue());
        L17:
            DataCenter r6 = this.a.getOpenPlatformContext().getDataCenter();
            if (r6 == null) goto L21;
            r6.removeObserver(this.a);
            return;
        L21:
            return;
        L5:
            jc1.k.n(IBroadcastService.class).stopCast(0);
            j.a(false);
            goto L6
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

    static {
    }

    public final void g() {
        int r0 = v.a;
        com.bytedance.android.live.openplatform.impl.minigameanchor.cast.h r1 = this.c;
        if (r1 == null) goto L5;
        Context r2 = r1.getContext();
    L7:
        if (v.b(r2) == false) goto L32;
        com.bytedance.android.live.openplatform.impl.minigameanchor.cast.h r3 = this.c;
        if (r3 == null) goto L27;
        Handler r4 = DialogLancet.resolveDialogHandler(r3);
        if (r4 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r3);
        goto L27
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r5 == null) goto L24;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r4.getLooper()) goto L15;
        r4.post(DialogLancet.createDismissRunnable(r3));
    L27:
        this.c = null;
        return;
    L32:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final boolean i() {
        if (jc1.k.n(IBroadcastService.class).isCasting() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.i == true) goto L8;
        return false;
    }

    public final void o() {
        t r0 = new t();
        r0.d = new t.b();
        r0.a = 4;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r1 = AnchorMiniGameDataContext.a.a();
        if (r1 == null) goto L7;
        n<c0> r2 = r1.getMicroGameInfo();
        if (r2 == null) goto L7;
        c0 r3 = (c0) r2.getValue();
    L7:
        String r4 = r0.b;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.b = r4;
        this.m.width();
        this.m.height();
        r0.c = getOpenPlatformContext().getContext();
        AnchorMiniGameDataContext r5 = AnchorMiniGameDataContext.a.a();
        if (r5 == null) goto L12;
        n<c0> r6 = r5.getMicroGameInfo();
        if (r6 == null) goto L12;
        c0 r7 = (c0) r6.getValue();
    L12:
        jc1.k.n(IBroadcastService.class).startCast(r0);
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        g();
        super.onDestroy();
    }

    public LiveMgCastContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.e = new LinkedHashSet();
        this.k = new LimitedSizeHashMap(((q) p0.a.getValue()).e() * 2);
        this.m = new Rect();
        this.n = new Rect();
    }

    public static final void f(LiveMgCastContextService r4) {
        if (r4.h == false) goto L7;
        com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c r0 = r4.a;
        if (r0 == null) goto L7;
        r0.a(0);
    L7:
        com.bytedance.android.live.openplatform.impl.minigameanchor.cast.a r1 = r4.d;
        if (r1 == null) goto L15;
        d0 r2 = r1.c;
        if (r2 == null) goto L12;
        r2.H();
    L12:
        r1.c = null;
        Handler r3 = r1.b;
        if (r3 == null) goto L15;
        r3.post(new com.bytedance.android.live.openplatform.impl.minigameanchor.cast.b(r1));
    L15:
        r4.d = null;
    }

    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> h(List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r10) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L25;
        Object r1 = r11.next();
        com.bytedance.android.livesdk.interactivity.api.entity.f r2 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r1;
        boolean r4 = false;
        if (this.k.containsKey(Long.valueOf(r2.o())) == true) goto L23;
        this.k.put(Long.valueOf(r2.o()), null);
        String r3 = r2.b.getMessageMethod();
        boolean r5 = Intrinsics.areEqual(r3, "WebcastChatMessage");
        if (Intrinsics.areEqual(r3, "WebcastGiftMessage") == false) goto L11;
    L16:
        boolean r6 = true;
    L17:
        boolean r7 = Intrinsics.areEqual(r3, "WebcastRoomMessage");
        boolean r8 = Intrinsics.areEqual(r3, "WebcastMemberMessage");
        if (r5 == true) goto L22;
        if (r6 == true) goto L22;
        if (r8 == true) goto L22;
        if (r7 == false) goto L23;
    L22:
        r4 = true;
        goto L23
    L11:
        if (Intrinsics.areEqual(r3, "WebcastDoodleGiftMessage") == true) goto L16;
        if (Intrinsics.areEqual(r3, "GiftGroupMessage") == true) goto L16;
        r6 = false;
    L23:
        if (r4 == false) goto L4;
        r0.add(r1);
        goto L4
    L25:
        return r0;
    }

    public final void j(String r7) {
        BridgeContextService r0 = (BridgeContextService) getOpenPlatformContext().getService(BridgeContextService.class);
        Bundle r1 = new Bundle();
        if (this.i == false) goto L5;
        boolean r2 = true;
    L6:
        r1.putBoolean("key_is_success", r2);
        if (r2 == false) goto L12;
        if (this.i == true) goto L12;
        r1.putParcelable("key_surface", null);
    L12:
        if (r2 == true) goto L14;
        JSONObject r3 = new JSONObject();
        r3.put("err_msg", "start liveCast error");
        Unit r5 = Unit.INSTANCE;
        r1.putString("key_extra", r3.toString());
    L14:
        if (r7 == null) goto L16;
        JSONObject r4 = new JSONObject();
        r4.put("err_msg", r7);
        Unit r8 = Unit.INSTANCE;
        r1.putString("key_extra", r4.toString());
    L16:
        Unit r9 = Unit.INSTANCE;
        r0.g("command_live_cast_start", r1);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void k(s42.d r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        m(h(r2.getMessageList()));
        Disposable r0 = this.b;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        PublishSubject r3 = r2.i();
        if (r3 == null) goto L14;
        Observable r4 = r3.map(new b(this));
        if (r4 == null) goto L14;
        Observable r5 = r4.observeOn(AndroidSchedulers.mainThread());
        if (r5 == null) goto L14;
        Disposable r6 = r5.subscribe(new c(this));
    L15:
        this.b = r6;
        return;
    L14:
        r6 = null;
        goto L15
    }

    public final void m(List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r14) {
        ArrayList<String> r0 = new ArrayList();     // Catch: JSONException -> L104
        Iterator<T> r15 = r14.iterator();     // Catch: JSONException -> L104
    L4:
        if (r15.hasNext() == false) goto L102;
        com.bytedance.android.livesdk.interactivity.api.entity.f r1 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r15.next();     // Catch: JSONException -> L104
        Iterator r2 = UserDslBadgeUtils.e(r1.x()).iterator();     // Catch: JSONException -> L104
    L6:
        int r4 = 1;
        if (r2.hasNext() == false) goto L17;
        Object r3 = r2.next();     // Catch: JSONException -> L104
        Integer r7 = ((h0) r3).b.getImageType();     // Catch: JSONException -> L104
        if (r7 != null) goto L12;
    L14:
        boolean r8 = false;
    L15:
        if (r8 == false) goto L6;
    L18:
        h0 r5 = (h0) r3;     // Catch: JSONException -> L104
        if (r5 == null) goto L21;
        py.k r6 = r5.b;     // Catch: JSONException -> L104
    L22:
        if (r6 == null) goto L26;
        List r9 = r6.getUrls();     // Catch: JSONException -> L104
        if (r9 == null) goto L26;
        String r10 = (String) CollectionsKt.firstOrNull(r9);     // Catch: JSONException -> L104
    L27:
        Spannable r11 = r1.q();     // Catch: JSONException -> L104
        if (r11 != null) goto L31;
        String r12 = "";
    L34:
        String r13 = r1.b.getMessageMethod();     // Catch: JSONException -> L104
        if (Intrinsics.areEqual(r13, "WebcastGiftMessage") == false) goto L37;
    L54:
        boolean r16 = true;
    L55:
        boolean r17 = Intrinsics.areEqual(r13, "WebcastMemberMessage");     // Catch: JSONException -> L104
        if (r16 == false) goto L58;
        int r18 = 1;
    L61:
        IBaseUser r19 = r1.x();     // Catch: JSONException -> L104
        if (r19 == null) goto L66;
        py.d r20 = r19.getUserHonor();     // Catch: JSONException -> L104
        if (r20 == null) goto L66;
        Integer r21 = Integer.valueOf(r20.getLevel());     // Catch: JSONException -> L104
    L71:
        if (r21 == null) goto L73;
        int r22 = r21.intValue();     // Catch: JSONException -> L104
    L74:
        c4 r23 = r1.b;     // Catch: JSONException -> L104
        int r110 = 21;
        if ((r23 instanceof c4) == false) goto L82;
        if (r23 == null) goto L81;
        if (TextUtils.equals(r23.getBizScene(), "mirco_game_open") == false) goto L82;
        r22 = 21;
    L83:
        va r24 = r1.b;     // Catch: JSONException -> L104
        if ((r24 instanceof va) == false) goto L100;
        if (r24 == null) goto L98;
        SuffixText r25 = r24.getOrInitPublicAreaCommon().getSuffixText();     // Catch: JSONException -> L104
        if (r25 == null) goto L100;
        String r26 = r25.getTags();     // Catch: JSONException -> L104
        if (r26 == null) goto L100;
        if (StringsKt.contains$default(r26, "launch_game", false, 2, null) == false) goto L93;
    L96:
        r22 = r110;
        goto L100
    L93:
        if (StringsKt.contains$default(r26, "pay_game", false, 2, null) == true) goto L96;
        r110 = r22;
        goto L96
    L98:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.IMemberMessage");     // Catch: JSONException -> L104
    L100:
        if (r2.a(r1.q().toString()) == false) goto L4;
        JSONObject r27 = new JSONObject();     // Catch: JSONException -> L104
        r27.put("message_content", r12);     // Catch: JSONException -> L104
        r27.put("badge_url", r10);     // Catch: JSONException -> L104
        r27.put("type", r4);     // Catch: JSONException -> L104
        r27.put("user_level", r22);     // Catch: JSONException -> L104
        Unit r28 = Unit.INSTANCE;     // Catch: JSONException -> L104
        r0.add(r27.toString());     // Catch: JSONException -> L104
        goto L4
    L81:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.IRoomMessage");     // Catch: JSONException -> L104
    L82:
        r4 = r18;
        goto L83
    L73:
        r22 = -1;
    L66:
        if (r6 == null) goto L70;
        py.k.b r29 = r6.getImageContent();     // Catch: JSONException -> L104
        if (r29 == null) goto L70;
        r21 = Integer.valueOf((int) r29.getLevel());     // Catch: JSONException -> L104
    L70:
        r21 = null;
        goto L71
    L58:
        if (r17 == false) goto L60;
        r18 = 2;
        goto L61
    L60:
        r18 = 0;
        goto L61
    L37:
        if (Intrinsics.areEqual(r13, "WebcastDoodleGiftMessage") == true) goto L54;
        if (Intrinsics.areEqual(r13, "GiftGroupMessage") == true) goto L54;
        tlc.d r30 = r1.b;     // Catch: JSONException -> L104
        if (Intrinsics.areEqual(r30.getMessageMethod(), "WebcastRoomMessage") == true) goto L43;
    L50:
        boolean r31 = false;
    L51:
        if (r31 == true) goto L54;
        r16 = false;
        goto L55
    L43:
        if ((r30 instanceof c4) == true) goto L45;
        r30 = null;
    L45:
        c4 r32 = (c4) r30;     // Catch: JSONException -> L104
        if (r32 == null) goto L50;
        if (r32.isGiftTypeMessage() != true) goto L50;
        r31 = true;
        goto L51
    L31:
        if (Build.VERSION.SDK_INT < 24) goto L33;
        r12 = Html.toHtml(r11, 0);     // Catch: JSONException -> L104
        goto L34
    L33:
        r12 = Html.toHtml(r11);     // Catch: JSONException -> L104
    L26:
        r10 = null;
        goto L27
    L21:
        r6 = null;
        goto L22
    L12:
        if (r7.intValue() != 1) goto L14;
        r8 = true;
        goto L15
    L17:
        r3 = null;
        goto L18
    L102:
        BridgeContextService r111 = (BridgeContextService) getOpenPlatformContext().getService(BridgeContextService.class);     // Catch: JSONException -> L104
        Bundle r33 = new Bundle();     // Catch: JSONException -> L104
        r33.putStringArrayList("key_live_messages", r0);     // Catch: JSONException -> L104
        Unit r34 = Unit.INSTANCE;     // Catch: JSONException -> L104
        r111.g("command_live_cast_update_message", r33);     // Catch: JSONException -> L104
        return;
    }

    public final void n(boolean r3) {
        i0.c().post(new f(this, r3));
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L33;
        String r0 = r6.getKey();
        int r1 = r0.hashCode();
        if (r1 == (-1677062600)) goto L30;
        if (r1 == 872172481) goto L17;
        if (r1 == 1633140397) goto L12;
        return;
    L12:
        if (r0.equals("data_room_text_message_presenter") == false) goto L34;
        s42.d r7 = (s42.d) r6.getData(null);
        if (r7 == null) goto L35;
        k(r7);
        return;
    L35:
        return;
    L34:
        return;
    L17:
        if (r0.equals("data_link_state") == false) goto L37;
        Integer r8 = (Integer) r6.getData();
        boolean r2 = false;
        if (r8 != null) goto L21;
        r8 = 0;
    L21:
        int r9 = r8.intValue();
        int r3 = qo0.a.a;
        qo0.a.c("LiveMgCastContextService", "update linkState: " + r9);
        if (r9 == 32) goto L26;
        if (r9 == 0) goto L26;
        f2.c("当前场景不支持小游戏，已为你取消挂载", 0);
        LiveMgMountContextService r10 = (LiveMgMountContextService) getOpenPlatformContext().getService(LiveMgMountContextService.class);
        int r4 = LiveMgMountContextService.h;
        r10.n(null);
        return;
    L26:
        if (r9 != 32) goto L28;
        r2 = true;
    L28:
        this.l = r2;
        q("", "data_link_state change " + r9);
        i0.c().postDelayed(new com.bytedance.android.live.openplatform.impl.minigameanchor.cast.e(this), 2500);
        return;
    L37:
        return;
    L30:
        if (r0.equals("cmd_anchor_broadcast_end") == false) goto L40;
        g();
        return;
    L40:
        return;
    }

    public final void onMessage(tlc.d r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = r4.getMessageMethod();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.hashCode() == 654092662) goto L11;
        return;
    L11:
        if (r0.equals("WebcastRoomStatsMessage") == true) goto L13;
        return;
    L13:
        if ((r4 instanceof mk) == true) goto L15;
        r4 = null;
    L15:
        mk r5 = (mk) r4;
        if (r5 == null) goto L23;
        BridgeContextService r1 = (BridgeContextService) getOpenPlatformContext().getService(BridgeContextService.class);
        Bundle r2 = new Bundle();
        r2.putString("key_live_audience_message", r5.getDisplayMiddle());
        Unit r6 = Unit.INSTANCE;
        r1.g("command_live_cast_audience_message", r2);
        return;
    }

    public final void q(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        int r0 = qo0.a.a;
        qo0.a.c("LiveMgCastContextService", "stopLiveCast appId: " + r3 + " source:" + r4);
        i0.c().post(new h(this));
    }

    public final void l(String r10, Rect r11, Rect r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, "appId");
        Intrinsics.checkNotNullParameter(r11, "liveCastRect");
        Intrinsics.checkNotNullParameter(r12, "cameraLittleWindowRect");
        Intrinsics.checkNotNullParameter(r13, "extraParam");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L5
        r1.put("cast_width", r11.width());     // Catch: Throwable -> L5
        r1.put("cast_height", r11.height());     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(r1.toString());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        String r3 = (String) r2;
        Lazy r4 = LiveOpenPlatformMgClient.c;
        MiniGameAnchorApi r5 = (MiniGameAnchorApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAnchorApi.class);
        long r6 = getOpenPlatformContext().getRoomId();
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        autoDispose(r5.requestGameStartCast(r6, r10, r3).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r10, r11, r12, r13), new e(this, r10, r11, r12, r13)));
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final void p(String r2, Rect r3, Rect r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "liveCastRect");
        Intrinsics.checkNotNullParameter(r4, "cameraLittleWindowRect");
        Intrinsics.checkNotNullParameter(r5, "extraParam");
        this.m = r3;
        this.n = r4;
        this.i = r5.optBoolean("is_cloud_game", false);
        this.j = r5.optBoolean("is_cloud_mix", false);
        this.h = r5.optBoolean("is_landScape", false);
        int r6 = qo0.a.a;
        qo0.a.c("LiveMgCastContextService", "startLiveCastInit isCloudGame: " + this.i + ", isCloudMix: " + this.j + ", isLandscapeGame: " + this.h);
        this.l = zq0.b.a();
        i0.c().post(new g(this));
    }
}
