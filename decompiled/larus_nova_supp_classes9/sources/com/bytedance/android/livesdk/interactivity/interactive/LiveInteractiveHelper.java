package com.bytedance.android.livesdk.interactivity.interactive;

import android.animation.Animator;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.o5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.interactive.episode.EpisodeInteractiveDialog;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.vs.model.VSBannerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.interact.IAbsCardWindow;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/LiveInteractiveHelper;", "Lcom/bytedance/android/livesdk/interactivity/interactive/LiveInteractivePresenter$IView;", "Landroid/content/Context;", "getContext", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveInteractiveHelper implements LiveInteractivePresenter.IView {
    public static final /* synthetic */ int r = 0;
    public final NextLiveData<Boolean> a;
    public int b;
    public HybridCard c;
    public LiveInteractivePresenter d;
    public com.bytedance.android.livesdk.chatroom.x<String, String> e;
    public View f;
    public EpisodeInteractiveDialog g;
    public IAbsCardWindow h;
    public final CompositeDisposable i;
    public int j;
    public int k;
    public boolean l;
    public Integer m;
    public final boolean n;
    public final DataCenter o;
    public final Context p;
    public final com.bytedance.android.livesdk.interactivity.interactive.b q;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ LiveInteractiveHelper a;
        public final /* synthetic */ long b;

        public b(LiveInteractiveHelper r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r7) {
            JSONObject r8 = (JSONObject) r7;
            JSONObject r9 = new JSONObject();
            r9.put("type", "change_camera_id");
            JSONObject r0 = new JSONObject();
            long r1 = this.b;
            vr1.u r3 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.a.o, null, 2);
            if (r3 == null) goto L11;
            Room r4 = r3.j0();
            if (r4 == null) goto L11;
            IEpisodeExtraInfo r5 = r4.getEpisodeComponentData();
            if (r5 == null) goto L11;
            if (r1 != r5.getDefaultCameraId()) goto L11;
            Object r2 = 0L;
        L12:
            r0.put("cameraId", r2);
            r9.put("data", r0);
            return r9;
        L11:
            r2 = String.valueOf(this.b);
            goto L12
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveInteractiveHelper a;

        public c(LiveInteractiveHelper r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            JSONObject r4 = (JSONObject) r3;
            Intrinsics.checkNotNullParameter(r4, "json");
            HybridCard r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.sendJsEvent("H5_roomStatusChange", r4);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ LiveInteractiveHelper a;
        public final /* synthetic */ long b;

        public e(LiveInteractiveHelper r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r7) {
            JSONObject r8 = (JSONObject) r7;
            JSONObject r0 = new JSONObject();
            r0.put("type", "sei");
            JSONObject r1 = new JSONObject();
            LiveInteractiveHelper r2 = this.a;
            int r3 = LiveInteractiveHelper.r;
            r1.put("room_id", String.valueOf(r2.i()));
            DataCenter r4 = this.a.o;
            int r5 = o82.i.a;
            vr1.u r6 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r4, null, 2);
            if (r6 == null) goto L5;
            long r9 = r6.d1();
        L6:
            r1.put("time_point", r9 / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
            r1.put("speed", 1.0d);
            r1.put("sei_ts", this.b);
            r1.put("extra", r8);
            r0.put("data", r1);
            r0.put("log", LiveInteractiveHelper.a(this.a));
            Iterator<Map.Entry<String, String>> r10 = this.a.g().entrySet().iterator();
        L8:
            if (r10.hasNext() == false) goto L10;
            Map.Entry<String, String> r11 = r10.next();
            r0.put(r11.getKey(), r11.getValue());
            goto L8
        L10:
            return r0;
        L5:
            r9 = 0;
            goto L6
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LiveInteractiveHelper a;
        public final /* synthetic */ long b;

        public f(LiveInteractiveHelper r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            JSONObject r6 = (JSONObject) r5;
            Intrinsics.checkNotNullParameter(r6, "json");
            this.a.o("H5_roomStatusChange", r6);
            if (this.a.c == null) goto L6;
            o82.h.b("[" + this.a.hashCode() + "]notify vs sei event, sei time: " + this.b);
            o82.h.b("[" + this.a.hashCode() + "]notify vs sei event, data: " + r6);
            StringBuilder r0 = new StringBuilder("[");
            r0.append(this.a.hashCode());
            r0.append("]vs sei event");
            o82.h.a(r0.toString(), r6);
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r3) {
            ALogger.i("LiveInteractiveHelper", "send sei fail cause:" + ((Throwable) r3).getMessage());
        }
    }

    public static final class h<T, R> implements Function {
        public final /* synthetic */ LiveInteractiveHelper a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ float d;

        public h(LiveInteractiveHelper r1, String r2, long r3, float r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final Object apply(Object r6) {
            JSONObject r0 = new JSONObject();
            r0.put("type", this.b);
            JSONObject r1 = new JSONObject();
            LiveInteractiveHelper r2 = this.a;
            int r3 = LiveInteractiveHelper.r;
            r1.put("room_id", String.valueOf(r2.i()));
            r1.put("time_point", this.c);
            r1.put("speed", this.d);
            r1.put("sei_ts", o82.i.c(this.a.o));
            r1.put("extra", (JSONObject) r6);
            r0.put("data", r1);
            r0.put("log", LiveInteractiveHelper.a(this.a));
            Iterator<Map.Entry<String, String>> r7 = this.a.g().entrySet().iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Map.Entry<String, String> r4 = r7.next();
            r0.put(r4.getKey(), r4.getValue());
            goto L4
        L6:
            return r0;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ LiveInteractiveHelper a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public i(LiveInteractiveHelper r1, String r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            JSONObject r8 = (JSONObject) r7;
            Intrinsics.checkNotNullParameter(r8, "json");
            this.a.o("H5_roomStatusChange", r8);
            if (this.a.c == null) goto L6;
            StringBuilder r0 = new StringBuilder("[");
            r0.append(this.a.hashCode());
            r0.append("]notify vs play event, type: ");
            r0.append(this.b);
            r0.append(", time point: ");
            long r4 = 60;
            r0.append(this.c / r4);
            r0.append(":");
            r0.append(this.c % r4);
            o82.h.b(r0.toString());
            o82.h.b("[" + this.a.hashCode() + "]notify vs play event, data: " + r8);
            o82.h.a("vs play event", r8);
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class k<T, R> implements Function {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final Object apply(Object r2) {
            JsonObject r3 = (JsonObject) r2;
            Intrinsics.checkNotNullParameter(r3, "extra");
            return GsonProtectorUtils.toJson(GsonHelper.get(), r3);
        }
    }

    public static final class l<T, R> implements Function {
        public final /* synthetic */ LiveInteractiveHelper a;

        public l(LiveInteractiveHelper r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "json");
            JSONObject r0 = new JSONObject();
            r0.put("type", "refresh");
            r0.put("data", r5);
            r0.put("log", LiveInteractiveHelper.a(this.a));
            return r0;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ LiveInteractiveHelper a;
        public final /* synthetic */ com.bytedance.android.live.base.model.message.n b;

        public m(LiveInteractiveHelper r1, com.bytedance.android.live.base.model.message.n r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            JSONObject r4 = (JSONObject) r3;
            o82.h.c("[" + this.a.hashCode() + "]H5_roomStatusChange" + r4);
            o82.h.a("LiveInteractiveMessage", this.b.extra());
            this.a.o("H5_roomStatusChange", r4);
        }
    }

    public static final class n<T> implements Consumer {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class o<T, R> implements Function {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final Object apply(Object r2) {
            JsonObject r3 = (JsonObject) r2;
            Intrinsics.checkNotNullParameter(r3, "extra");
            return GsonProtectorUtils.toJson(GsonHelper.get(), r3);
        }
    }

    public static final class p<T, R> implements Function {
        public final /* synthetic */ LiveInteractiveHelper a;

        public p(LiveInteractiveHelper r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "json");
            JSONObject r0 = new JSONObject();
            r0.put("type", "refresh");
            r0.put("data", r5);
            r0.put("log", LiveInteractiveHelper.a(this.a));
            return r0;
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ LiveInteractiveHelper a;
        public final /* synthetic */ ku2.b b;

        public q(LiveInteractiveHelper r1, ku2.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            JSONObject r4 = (JSONObject) r3;
            o82.h.c("[" + this.a.hashCode() + "]H5_roomStatusChange" + r4);
            o82.h.a("InRoomBannerMessage", this.b.extra());
            this.a.o("H5_roomStatusChange", r4);
        }
    }

    public static final class r<T> implements Consumer {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class s<T, R> implements Function {
        public static final s a = null;

        static {
            a = new s();
        }

        public s() {
        }

        public final Object apply(Object r2) {
            JsonObject r3 = (JsonObject) r2;
            Intrinsics.checkNotNullParameter(r3, "extra");
            return GsonProtectorUtils.toJson(GsonHelper.get(), r3);
        }
    }

    public static final class t<T, R> implements Function {
        public final /* synthetic */ LiveInteractiveHelper a;

        public t(LiveInteractiveHelper r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "json");
            JSONObject r0 = new JSONObject();
            r0.put("type", "refresh");
            r0.put("data", r5);
            r0.put("log", LiveInteractiveHelper.a(this.a));
            return r0;
        }
    }

    public static final class u<T> implements Consumer {
        public final /* synthetic */ LiveInteractiveHelper a;
        public final /* synthetic */ o5 b;

        public u(LiveInteractiveHelper r1, o5 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            JSONObject r5 = (JSONObject) r4;
            o82.h.c("H5_roomStatusChange" + r5);
            o82.h.a("VSInteractiveMessage", this.b.extra());
            this.a.o("H5_roomStatusChange", r5);
        }
    }

    public static final class v<T> implements Consumer {
        public static final v a = null;

        static {
            a = new v();
        }

        public v() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class w implements Animator.AnimatorListener {
        public final /* synthetic */ Runnable a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public w(x r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.run();
        }
    }

    public static final class x implements Runnable {
        public final /* synthetic */ LiveInteractiveHelper a;
        public final /* synthetic */ View b;

        public x(LiveInteractiveHelper r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            boolean r2 = false;
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L5;
            this.b.setVisibility(8);
            this.a.j = 0;
        L14:
            if (this.b.getLayoutParams() == null) goto L33;
            DataCenter r0 = this.a.o;
            if (r0 == null) goto L19;
            r0.put("data_vs_interactive_widget_region", null);
        L19:
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L28;
            LiveInteractiveHelper r1 = this.a;
            DataCenter r3 = r1.o;
            if (r3 == null) goto L31;
            IAbsCardWindow r4 = r1.h;
            if (r4 != null) goto L25;
        L27:
            r3.put("data_live_interactive_component_show", Boolean.valueOf(r2));
            goto L31
        L25:
            if (r4.isShowingWindow() != true) goto L27;
            r2 = true;
        L31:
            com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().o(this.a.o);
            return;
        L28:
            DataCenter r5 = this.a.o;
            if (r5 == null) goto L31;
            r5.put("data_live_interactive_component_show", Boolean.FALSE);
            goto L31
        L33:
            return;
        L5:
            IAbsCardWindow r6 = this.a.h;
            if (r6 == null) goto L14;
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L11;
            r6 = null;
        L11:
            if (r6 == null) goto L14;
            r6.dismissWindow();
            this.a.j = 0;
            goto L14
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

    public static final class y implements Runnable {
        public final /* synthetic */ LiveInteractiveHelper a;
        public final /* synthetic */ View b;

        public y(LiveInteractiveHelper r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            int[] r0 = new int[2];
            this.b.getLocationOnScreen(r0);
            DataCenter r1 = this.a.o;
            int r3 = r0[0];
            r1.put("data_vs_interactive_widget_region", new RectF(r3, r0[1], r3 + this.b.getLayoutParams().width, r0[1] + this.b.getLayoutParams().height));
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

    public static final class z implements Animator.AnimatorListener {
        public final /* synthetic */ View a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public z(View r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            o82.h.b("setHybridComponentVisible[" + hashCode() + "]; anim cancel, view=" + this.a.hashCode());
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.setAlpha(1);
            o82.h.b("setHybridComponentVisible[" + hashCode() + "]; anim finish, view=" + this.a.hashCode());
        }
    }

    static {
    }

    public boolean c() {
        return true;
    }

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public String j() {
        return "live_";
    }

    public LiveInteractivePresenter e() {
        return new LiveInteractivePresenter();
    }

    public final long f() {
        DataCenter r0 = this.o;
        if (r0 == null) goto L20;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
        if (r1 == null) goto L20;
        IBaseUser r2 = r1.getOwner();
        if (r2 == null) goto L20;
        String r3 = r2.getIdString();
        if (r3 == null) goto L20;
        Intrinsics.checkNotNullParameter(r3, "$this$safeToLong");
        if (r3.length() != 0) goto L13;
        boolean r4 = true;
    L14:
        Long r5 = null;
        if (r4 == false) goto L23;
    L18:
        if (r5 == null) goto L20;
        return r5.longValue();
    L23:
        r5 = Long.valueOf(CastLongProtector.parseLong(r3));     // Catch: Throwable -> L22
        goto L18
    L13:
        r4 = false;
    L20:
        return 0;
    }

    public final Lifecycle getLifecycleCompat() {
        return this.q.u9();
    }

    public final String getLogTag() {
        return this.q.getTag();
    }

    public km1.a h() {
        vr1.u r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.o, null, 2);
        if (r0 == null) goto L5;
        ViewModel r1 = r0.c();
    L7:
        if ((r1 instanceof EpisodeInteractiveContext) == true) goto L9;
        r1 = null;
    L9:
        EpisodeInteractiveContext r2 = (EpisodeInteractiveContext) r1;
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.n<km1.a> r3 = r2.getLiveInteractiveInfo();
        if (r3 != null) goto L14;
        return null;
    L14:
        return (km1.a) r3.getValue();
    L15:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    public final long i() {
        DataCenter r0 = this.o;
        if (r0 == null) goto L7;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
        if (r1 == null) goto L7;
        return r1.getRoomId();
    L7:
        return 0;
    }

    public final void release() {
        o82.h.b("[" + hashCode() + "]release hybrid component");
        View r0 = this.f;
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L9;
        r1.removeAllViews();
    L9:
        if (h() != null) goto L15;
        o82.h.b("[" + hashCode() + "]release hybridCard also");
        HybridCard r2 = this.c;
        if (r2 == null) goto L13;
        r2.release();
    L13:
        this.c = null;
        return;
    }

    public Map<String, String> g() {
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public Context getContext() {
        return this.p;
    }

    public final DataCenter getDataCenter() {
        return this.o;
    }

    public static final JSONObject a(LiveInteractiveHelper r9) {
        r9.getClass();
        JSONObject r0 = new JSONObject();
        if (r9.o == null) goto L31;
        com.bytedance.android.livesdk.log.filter.o r1 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().j(am2.x.class);
        boolean r2 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().i(r1);
        String r5 = BuildConfig.FLAVOR;
        if (r2 == true) goto L8;
        String r3 = BuildConfig.FLAVOR;
    L24:
        r0.put("enter_from_merge", r5).put("enter_method", r3).put("event_page", "live_detail").put("room_id", String.valueOf(r9.i())).put("anchor_id", String.valueOf(r9.f()));
        Iterator<Map.Entry<String, String>> r4 = r9.g().entrySet().iterator();
    L26:
        if (r4.hasNext() == false) goto L28;
        Map.Entry<String, String> r6 = r4.next();
        r0.put(r6.getKey(), r6.getValue());
        goto L26
    L28:
        IRoom r10 = (IRoom) r9.o.get("data_room", null);
        if (r10 == null) goto L31;
        r0.put("request_id", r10.getRequestId()).put("log_pb", r10.getLog_pb());
        goto L31
    L8:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().o(r1, "enter_from") == false) goto L10;
        String r7 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().a(r1, "enter_from");
    L12:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().o(r1, "source") == false) goto L14;
        String r8 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().a(r1, "source");
    L15:
        HashMap r11 = new HashMap();
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().dataMapping(r7, r8, r11);
        String r13 = (String) r11.get("enter_from_merge");
        if (r13 != null) goto L18;
        r13 = BuildConfig.FLAVOR;
    L18:
        String r14 = (String) r11.get("enter_method");
        if (r14 == null) goto L22;
        r5 = r14;
    L22:
        String r15 = r5;
        r5 = r13;
        r3 = r15;
        goto L24
    L14:
        r8 = BuildConfig.FLAVOR;
        goto L15
    L10:
        r7 = BuildConfig.FLAVOR;
    L31:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void HR(com.bytedance.android.live.base.model.message.n r3) {
        if (this.q.isVisible() == false) goto L12;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.c != null) goto L8;
        return;
    L8:
        if (r3.extra() == null) goto L15;
        ((SingleSubscribeProxy) Single.just(r3.extra()).observeOn(Schedulers.io()).map(k.a).map(new l(this)).observeOn(AndroidSchedulers.mainThread()).as(this.q.s7())).subscribe(new m(this, r3), n.a);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void Nj(long r3) {
        ((SingleSubscribeProxy) Single.just(new JSONObject()).observeOn(Schedulers.io()).map(new b(this, r3)).observeOn(AndroidSchedulers.mainThread()).as(this.q.s7())).subscribe(new c(this), d.a);
    }

    public final String b(String r5) {
        Uri r6 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().E(UriProtector.parse(r5), this.o);
        if (r6 == null) goto L13;
        Uri.Builder r7 = r6.buildUpon();
        if (r7 == null) goto L13;
        Uri.Builder r8 = r7.appendQueryParameter("request_page", "top");
        if (r8 == null) goto L13;
        String r1 = fq1.t.a().getCurrentUserId();
        if (r1 != null) goto L12;
        r1 = BuildConfig.FLAVOR;
    L12:
        Uri.Builder r9 = r8.appendQueryParameter("user_id", r1);
    L14:
        if (r9 == null) goto L19;
        Uri.Builder r2 = r9.appendQueryParameter("room_id", String.valueOf(i()));
        if (r2 == null) goto L19;
        r2.appendQueryParameter("anchor_id", String.valueOf(f()));
    L19:
        if (r9 == null) goto L26;
        if (this.n == false) goto L23;
        String r3 = "0";
    L24:
        r9.appendQueryParameter("is_hor", r3);
        goto L26
    L23:
        r3 = "1";
    L26:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.o).isPaidLive() == false) goto L33;
        if (r9 == null) goto L29;
        r9.appendQueryParameter("is_paidlive", "1");
    L29:
        if (r9 == null) goto L31;
        r9.appendQueryParameter("ticket_session_id", String.valueOf(com.bytedance.android.livesdk.vscore_api.paidlive.b.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.o).J0(), this.o)));
    L31:
        if (r9 == null) goto L33;
        r9.appendQueryParameter("watch_paidlive_status", com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.o).J0().q(this.o));
    L33:
        Iterator<Map.Entry<String, String>> r4 = g().entrySet().iterator();
    L35:
        if (r4.hasNext() == false) goto L39;
        Map.Entry<String, String> r10 = r4.next();
        if (r9 == null) goto L35;
        r9.appendQueryParameter(r10.getKey(), r10.getValue());
        goto L35
    L39:
        if (r9 == null) goto L50;
        String r11 = r9.toString();
        if (r11 != null) goto L44;
        return BuildConfig.FLAVOR;
    L44:
        return r11;
    L50:
        return BuildConfig.FLAVOR;
    L13:
        r9 = null;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void jP(long r3) {
        ((SingleSubscribeProxy) Single.just(new JSONObject()).observeOn(Schedulers.io()).map(new e(this, r3)).observeOn(AndroidSchedulers.mainThread()).as(this.q.s7())).subscribe(new f(this, r3), g.a);
    }

    public final void l(IBannerInfo r5) {
        o82.h.b("[" + hashCode() + "]on banner data");
        this.q.ol();
        if (this.q.isVisible() == false) goto L41;
        if (r5 == null) goto L41;
        VSBannerInfo r0 = r5.castToOrNull(VSBannerInfo.class);
        String r2 = null;
        if (r0 == null) goto L8;
        String r1 = r0.getH5Url();
    L10:
        if (TextUtils.isEmpty(r1) == true) goto L41;
        release();
        VSBannerInfo r3 = r5.castToOrNull(VSBannerInfo.class);
        boolean r4 = false;
        if (r3 == null) goto L15;
        boolean r6 = r3.isLynxContainerEnabled();
    L16:
        if (r6 == false) goto L25;
        VSBannerInfo r7 = r5.castToOrNull(VSBannerInfo.class);
        if (r7 == null) goto L21;
        r2 = r7.getLynxUrl();
    L21:
        if (TextUtils.isEmpty(r2) == true) goto L25;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().q() == false) goto L25;
        r4 = true;
    L25:
        if (r4 == false) goto L29;
        VSBannerInfo r8 = r5.castToOrNull(VSBannerInfo.class);
        if (r8 == null) goto L33;
        r8.getLynxUrl();
    L33:
        if (Intrinsics.areEqual((Boolean) this.a.getValue(), Boolean.TRUE) == false) goto L35;
        k(r5, r4, this.f);
        return;
    L35:
        o82.h.b("[" + hashCode() + "]onBannerData contentView hasn't init, wait");
        NextLiveData<Boolean> r9 = this.a;
        FragmentActivity r10 = this.p;
        if (r10 == null) goto L40;
        r9.observe(r10, new d0(this, r5, r4));
        return;
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L29:
        VSBannerInfo r11 = r5.castToOrNull(VSBannerInfo.class);
        if (r11 == null) goto L33;
        r11.getH5Url();
        goto L33
    L15:
        r6 = false;
        goto L16
    L8:
        r1 = null;
    L41:
        o82.h.b("[" + hashCode() + "]banner data is empty");
    }

    public final void m(boolean r4) {
        if (this.c == null) goto L9;
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L6
        r1.put("foreground", r4);     // Catch: Exception -> L6
        r0.put("type", "app");     // Catch: Exception -> L6
        r0.put("args", r1);     // Catch: Exception -> L6
        o("H5_appStateChange", r0);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final void p(boolean r6) {
        View r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        o82.h.b("setHybridComponentGone[" + hashCode() + "];withAnim=" + r6 + ", view=" + r0.hashCode());
        x r1 = new x(this, r0);
        if (r6 == false) goto L8;
        r0.animate().alpha(0).setDuration(200).setListener(new w(r1)).start();
    L10:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L12;
        return;
    L12:
        if (this.b != 1) goto L38;
        EpisodeInteractiveDialog r7 = this.g;
        if (r7 == null) goto L32;
        Handler r2 = DialogLancet.resolveDialogHandler(r7);
        if (r2 != null) goto L18;
    L20:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L23 Exception -> L25
    L29:
        DialogLancet.afterDialogDismiss(r7);
        goto L32
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L23
        if (r3 == null) goto L29;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L18:
        if (Looper.myLooper() == r2.getLooper()) goto L20;
        r2.post(DialogLancet.createDismissRunnable(r7));
    L32:
        o82.h.b("setHybridComponentGone[" + hashCode() + "] hide dialog");
        return;
    L38:
        return;
    L8:
        r0.setAlpha(0);
        r1.run();
        goto L10
    }

    public final void s(boolean r8) {
        if (this.o != null) goto L5;
        return;
    L5:
        if (this.f != null) goto L8;
        return;
    L8:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L10;
    L19:
        View r0 = this.f;
        if (r0 != null) goto L22;
        return;
    L22:
        boolean r4 = false;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L25;
        r0.setVisibility(0);
    L33:
        HybridCard r3 = this.c;
        if (r3 == null) goto L36;
        UtilityKotlinExtentionsKt.w(r3);
    L36:
        this.j = 1;
        if (this.n == true) goto L40;
        r0.post(new y(this, r0));
    L40:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L49;
        DataCenter r5 = this.o;
        if (r5 == null) goto L52;
        IAbsCardWindow r6 = this.h;
        if (r6 != null) goto L46;
    L48:
        r5.put("data_live_interactive_component_show", Boolean.valueOf(r4));
        goto L52
    L46:
        if (r6.isShowingWindow() != true) goto L48;
        r4 = true;
    L52:
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().o(this.o);
        if (r8 == false) goto L59;
        ViewPropertyAnimator r9 = r0.animate().alpha(1);
        if (this.n == false) goto L57;
        int r1 = 200;
    L58:
        r9.setDuration(r1).setListener(new z(r0)).start();
        return;
    L57:
        r1 = 300;
        goto L58
    L59:
        r0.setAlpha(1);
        o82.h.b("setHybridComponentVisible[" + hashCode() + "]; anim false, view=" + r0.hashCode());
        return;
    L49:
        DataCenter r7 = this.o;
        if (r7 == null) goto L52;
        r7.put("data_live_interactive_component_show", Boolean.TRUE);
        goto L52
    L25:
        IAbsCardWindow r10 = this.h;
        if (r10 == null) goto L33;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L31;
        r10 = null;
    L31:
        if (r10 == null) goto L33;
        r10.showWindow();
        goto L33
    L10:
        if (this.b != 1) goto L19;
        EpisodeInteractiveDialog r2 = this.g;
        if (r2 != null) goto L14;
    L18:
        o82.h.b("setHybridComponentVisible[" + hashCode() + "] show dialog");
        goto L19
    L14:
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L62;
        DialogLancet.handleBlockedDialogShow(r2);
        goto L18
    L62:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L61
    L17:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
        goto L18
    }

    public void t(km1.a r4) {
        Intrinsics.checkNotNullParameter(r4, "interactiveInfo");
        ViewModel r1 = null;
        vr1.u r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.o, null, 2);
        if (r0 == null) goto L5;
        ViewModel r2 = r0.c();
    L7:
        if ((r2 instanceof EpisodeInteractiveContext) == false) goto L10;
        r1 = r2;
    L10:
        EpisodeInteractiveContext r3 = (EpisodeInteractiveContext) r1;
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.n<km1.a> r5 = r3.getLiveInteractiveInfo();
        if (r5 == null) goto L17;
        r5.setValue(r4);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void ux(o5 r3) {
        if (this.q.isVisible() == false) goto L24;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.c != null) goto L8;
        return;
    L8:
        if (r3.extra() == null) goto L27;
        DataCenter r0 = this.o;
        if (r0 == null) goto L22;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
        if (r1 == null) goto L22;
        IRoomAuthStatus r2 = r1.getRoomAuthStatus();
        if (r2 == null) goto L22;
        ju2.d r4 = r2.castToOrNull(ju2.d.class);
        if (r4 == null) goto L22;
        if (r4.isEnableEpisodeInteractive() == true) goto L22;
        o82.h.b("abandon Interact Message cuzz of auth.interactiveComponent is hidden");
        return;
    L22:
        ((SingleSubscribeProxy) Single.just(r3.extra()).observeOn(Schedulers.io()).map(s.a).map(new t(this)).observeOn(AndroidSchedulers.mainThread()).as(this.q.s7())).subscribe(new u(this, r3), v.a);
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void wz(ku2.b r3) {
        if (this.q.isVisible() == false) goto L24;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.c != null) goto L8;
        return;
    L8:
        if (r3.extra() == null) goto L27;
        DataCenter r0 = this.o;
        if (r0 == null) goto L22;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
        if (r1 == null) goto L22;
        IRoomAuthStatus r2 = r1.getRoomAuthStatus();
        if (r2 == null) goto L22;
        ju2.d r4 = r2.castToOrNull(ju2.d.class);
        if (r4 == null) goto L22;
        if (r4.isEnableEpisodeInteractive() == true) goto L22;
        o82.h.b("abandon Interact Message cuzz of auth.interactiveComponent is hidden");
        return;
    L22:
        ((SingleSubscribeProxy) Single.just(r3.extra()).observeOn(Schedulers.io()).map(o.a).map(new p(this)).observeOn(AndroidSchedulers.mainThread()).as(this.q.s7())).subscribe(new q(this, r3), r.a);
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void zP(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        JSONObject r1 = new JSONObject();
        r1.put("url", r5);     // Catch: JSONException -> L5
    L7:
        o82.h.b("[" + hashCode() + "]H5_VSVoteListClosed: url: " + r5);
        StringBuilder r0 = new StringBuilder("[");
        r0.append(hashCode());
        r0.append("]vs panel close event");
        o82.h.a(r0.toString(), r5);
        o("H5_VSVoteListClosed", r1);
        return;
    L5:
        e = move-exception;
        ALogger.e("LiveInteractiveHelper", e);
        goto L7
    }

    public final void o(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "data");
        HybridCard r0 = this.c;
        if (r0 == null) goto L6;
        r0.sendJsEvent(r2, r3);
        return;
    }

    public final void k(IBannerInfo r10, boolean r11, View r13) {
        o82.h.b("start initHybridComponentForAnnie[" + hashCode() + "], contentView:" + r13 + ",bannerInfo:" + r10);
        km1.a r0 = h();
        View r4 = null;
        if (r0 != null) goto L5;
    L27:
        Context r1 = this.p;
        if (r1 == null) goto L54;
        o82.g r6 = new o82.g(!r11);
        String r7 = BuildConfig.FLAVOR;
        if (r11 == false) goto L43;
        VSBannerInfo r14 = r10.castToOrNull(VSBannerInfo.class);
        if (r14 == null) goto L35;
        String r15 = r14.getLynxUrl();
        if (r15 == null) goto L35;
    L36:
        Uri.Builder r16 = x6.a.d(b(r15)).buildUpon();
        VSBannerInfo r8 = r10.castToOrNull(VSBannerInfo.class);
        if (r8 == null) goto L42;
        String r9 = r8.getH5Url();
        if (r9 == null) goto L42;
        r7 = r9;
    L42:
        Uri r17 = r16.appendQueryParameter("fallback_url", b(r7)).build();
    L50:
        o82.h.b("[" + hashCode() + "]load url: " + r17);
        HybridCard r18 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().getHybridCard(r1, r17, new c0(r6, r17, this, r10));
        if (r18 == null) goto L53;
        a7.a.a(r18, null, null, 3);
    L53:
        o82.h.b("obtainHybridComponentForAnnie[" + hashCode() + "]: obtain instance " + r18);
    L56:
        if (r18 == null) goto L95;
        this.c = r18;
        r18.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r18.getParent() == null) goto L65;
        o82.h.b("initHybridComponentForAnnie[" + hashCode() + "]: HybridCard has parentView which need to be removed");
        ViewParent r19 = r18.getParent();
        if ((r19 instanceof ViewGroup) == true) goto L62;
        r19 = null;
    L62:
        ViewGroup r110 = (ViewGroup) r19;
        if (r110 == null) goto L65;
        r110.removeView(r18);
    L65:
        boolean r111 = r13 instanceof ViewGroup;
        if (r111 == true) goto L68;
        View r20 = null;
    L69:
        ViewGroup r21 = (ViewGroup) r20;
        if (r21 == null) goto L72;
        r21.addView(r18, 0);
    L72:
        StringBuilder r112 = new StringBuilder("initHybridComponentForAnnie[");
        r112.append(hashCode());
        r112.append("], after add view, contentView now childCount:");
        if (r111 == true) goto L75;
        View r113 = null;
    L76:
        ViewGroup r114 = (ViewGroup) r113;
        if (r114 == null) goto L79;
        Integer r115 = Integer.valueOf(r114.getChildCount());
    L80:
        r112.append(r115);
        o82.h.b(r112.toString());
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L95;
        View r116 = new View(this.p);
        r116.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if ((r13 instanceof FrameLayout) == false) goto L86;
        r4 = r13;
    L86:
        FrameLayout r5 = (FrameLayout) r4;
        if (r5 == null) goto L89;
        r5.addView(r116);
    L89:
        if (r13 == null) goto L91;
        r13.setFocusable(true);
    L91:
        if (r13 == null) goto L93;
        r13.setFocusableInTouchMode(true);
    L93:
        r116.setBackground(new ColorDrawable(0));
        r3.a(r13, "活动入口");
        goto L95
    L79:
        r115 = null;
        goto L80
    L75:
        r113 = r13;
        goto L76
    L68:
        r20 = r13;
    L95:
        if (this.c != null) goto L97;
        o82.h.b("[" + hashCode() + "]register interactive jsb failed");
    L112:
        b20("init", 0, 1.0f, new JSONObject());
        return;
    L97:
        o82.h.b("[" + hashCode() + "]register interactive jsb");
        HybridCard r117 = this.c;
        if (r117 == null) goto L100;
        r117.registerMethod("interactiveBannerShow", new e0(this));
    L100:
        HybridCard r118 = this.c;
        if (r118 == null) goto L103;
        r118.registerMethod("interactiveSetStorage", new f0(this));
    L103:
        HybridCard r119 = this.c;
        if (r119 == null) goto L106;
        r119.registerMethod("interactiveGetStorage", new g0(this));
    L106:
        HybridCard r120 = this.c;
        if (r120 == null) goto L109;
        r120.registerMethod("getSeiInfo", new h0(this));
    L109:
        EpisodeInteractiveDialog r121 = this.g;
        if (r121 == null) goto L112;
        r121.setOnDismissListener(new i0(this));
    L35:
        r15 = BuildConfig.FLAVOR;
        goto L36
    L43:
        VSBannerInfo r122 = r10.castToOrNull(VSBannerInfo.class);
        if (r122 == null) goto L49;
        String r123 = r122.getH5Url();
        if (r123 == null) goto L49;
        r7 = r123;
    L49:
        r17 = x6.a.b(b(r7));
        goto L50
    L54:
        String r124 = "obtainHybridComponentForAnnie[" + hashCode() + "]: return null";
        RuntimeException r125 = new RuntimeException("obtainHybridComponentForAnnie null");
        Intrinsics.checkNotNullParameter(r124, "msg");
        Intrinsics.checkNotNullParameter(r125, "exception");
        ALogger.e("LiveInteractive", r124, r125);
    L55:
        r18 = null;
        goto L56
    L5:
        if (Intrinsics.areEqual(r0.a, r10) == false) goto L27;
        r18 = r0.d;
        if (r18 == null) goto L55;
        boolean r126 = r0.c;
        vr1.u r23 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.o, null, 2);
        if (r23 != null) goto L11;
    L12:
        vr1.u r127 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.o, null, 2);
        if (r127 == null) goto L15;
        boolean r128 = r127.isPortraitInteraction();
    L16:
        r0.c = r128;
        StringBuilder r129 = new StringBuilder("[");
        r129.append(hashCode());
        r129.append("]roomHorizontalChange: is_horizontal: ");
        DataCenter r2 = this.o;
        if (r2 == null) goto L19;
        Boolean r3 = Boolean.valueOf(com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r2, true));
    L20:
        r129.append(r3);
        o82.h.b(r129.toString());
        JSONObject r130 = new JSONObject();
        DataCenter r24 = this.o;
        if (r24 != null) goto L23;
    L25:
        int r25 = 1;
    L26:
        r130.put("is_horizontal", r25);
        Unit r26 = Unit.INSTANCE;
        r18.sendJsEvent("roomHorizontalChange", r130);
        o82.h.b("obtainHybridComponentForAnnie[" + hashCode() + "]: reuse hybrid card, sendRoomHorizontalChangeJSEvent");
        goto L56
    L23:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r24, true) != true) goto L25;
        r25 = 0;
        goto L26
    L19:
        r3 = null;
        goto L20
    L15:
        r128 = false;
        goto L16
    L11:
        if (r126 == r23.isPortraitInteraction()) goto L56;
        goto L12
    }

    public LiveInteractiveHelper(boolean r2, DataCenter r3, Context r4, com.bytedance.android.livesdk.interactivity.interactive.b r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.n = r2;
        this.o = r3;
        this.p = r4;
        this.q = r5;
        this.a = new NextLiveData();
        this.i = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void b20(String r8, long r9, float r11, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r8, "type");
        Intrinsics.checkNotNullParameter(r13, "extra");
        ((SingleSubscribeProxy) Single.just(r13).observeOn(Schedulers.io()).map(new h(this, r8, r9, r11)).observeOn(AndroidSchedulers.mainThread()).as(this.q.s7())).subscribe(new i(this, r8, r9), j.a);
    }
}
