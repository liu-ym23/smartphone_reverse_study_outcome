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
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.o5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.lynx.api.Jsb2MethodFinder;
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
import com.bytedance.ies.bullet.kit.web.SSWebView;
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
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/LiveInteractiveAnnieXHelper;", "Lcom/bytedance/android/livesdk/interactivity/interactive/LiveInteractivePresenter$IView;", "Landroid/content/Context;", "getContext", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveInteractiveAnnieXHelper implements LiveInteractivePresenter.IView {
    public static final /* synthetic */ int t = 0;
    public final NextLiveData<Boolean> a;
    public int b;
    public WebView c;
    public Object d;
    public Object e;
    public LiveInteractivePresenter f;
    public com.bytedance.android.livesdk.chatroom.x<String, String> g;
    public View h;
    public EpisodeInteractiveDialog i;
    public IAbsCardWindow j;
    public final CompositeDisposable k;
    public int l;
    public int m;
    public boolean n;
    public Integer o;
    public final boolean p;
    public final DataCenter q;
    public final Context r;
    public final com.bytedance.android.livesdk.interactivity.interactive.b s;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;
        public final /* synthetic */ long b;

        public b(LiveInteractiveAnnieXHelper r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r7) {
            JSONObject r8 = (JSONObject) r7;
            JSONObject r9 = new JSONObject();
            r9.put("type", "change_camera_id");
            JSONObject r0 = new JSONObject();
            long r1 = this.b;
            vr1.u r3 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.a.q, null, 2);
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;

        public c(LiveInteractiveAnnieXHelper r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            JSONObject r5 = (JSONObject) r4;
            Intrinsics.checkNotNullParameter(r5, "json");
            com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().x(this.a.d, "H5_roomStatusChange", r5);
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;
        public final /* synthetic */ long b;

        public e(LiveInteractiveAnnieXHelper r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r7) {
            JSONObject r8 = (JSONObject) r7;
            JSONObject r0 = new JSONObject();
            r0.put("type", "sei");
            JSONObject r1 = new JSONObject();
            LiveInteractiveAnnieXHelper r2 = this.a;
            int r3 = LiveInteractiveAnnieXHelper.t;
            r1.put("room_id", String.valueOf(r2.i()));
            DataCenter r4 = this.a.q;
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
            r0.put("log", LiveInteractiveAnnieXHelper.a(this.a));
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;
        public final /* synthetic */ long b;

        public f(LiveInteractiveAnnieXHelper r1, long r2) {
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ float d;

        public h(LiveInteractiveAnnieXHelper r1, String r2, long r3, float r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final Object apply(Object r6) {
            JSONObject r0 = new JSONObject();
            r0.put("type", this.b);
            JSONObject r1 = new JSONObject();
            LiveInteractiveAnnieXHelper r2 = this.a;
            int r3 = LiveInteractiveAnnieXHelper.t;
            r1.put("room_id", String.valueOf(r2.i()));
            r1.put("time_point", this.c);
            r1.put("speed", this.d);
            r1.put("sei_ts", o82.i.c(this.a.q));
            r1.put("extra", (JSONObject) r6);
            r0.put("data", r1);
            r0.put("log", LiveInteractiveAnnieXHelper.a(this.a));
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public i(LiveInteractiveAnnieXHelper r1, String r2, long r3) {
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;

        public l(LiveInteractiveAnnieXHelper r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "json");
            JSONObject r0 = new JSONObject();
            r0.put("type", "refresh");
            r0.put("data", r5);
            r0.put("log", LiveInteractiveAnnieXHelper.a(this.a));
            return r0;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;
        public final /* synthetic */ com.bytedance.android.live.base.model.message.n b;

        public m(LiveInteractiveAnnieXHelper r1, com.bytedance.android.live.base.model.message.n r2) {
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;

        public p(LiveInteractiveAnnieXHelper r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "json");
            JSONObject r0 = new JSONObject();
            r0.put("type", "refresh");
            r0.put("data", r5);
            r0.put("log", LiveInteractiveAnnieXHelper.a(this.a));
            return r0;
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;
        public final /* synthetic */ ku2.b b;

        public q(LiveInteractiveAnnieXHelper r1, ku2.b r2) {
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;

        public t(LiveInteractiveAnnieXHelper r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "json");
            JSONObject r0 = new JSONObject();
            r0.put("type", "refresh");
            r0.put("data", r5);
            r0.put("log", LiveInteractiveAnnieXHelper.a(this.a));
            return r0;
        }
    }

    public static final class u<T> implements Consumer {
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;
        public final /* synthetic */ o5 b;

        public u(LiveInteractiveAnnieXHelper r1, o5 r2) {
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;
        public final /* synthetic */ View b;

        public x(LiveInteractiveAnnieXHelper r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            boolean r2 = false;
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L5;
            this.b.setVisibility(8);
            this.a.l = 0;
        L14:
            if (this.b.getLayoutParams() == null) goto L33;
            DataCenter r0 = this.a.q;
            if (r0 == null) goto L19;
            r0.put("data_vs_interactive_widget_region", null);
        L19:
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L28;
            LiveInteractiveAnnieXHelper r1 = this.a;
            DataCenter r3 = r1.q;
            if (r3 == null) goto L31;
            IAbsCardWindow r4 = r1.j;
            if (r4 != null) goto L25;
        L27:
            r3.put("data_live_interactive_component_show", Boolean.valueOf(r2));
            goto L31
        L25:
            if (r4.isShowingWindow() != true) goto L27;
            r2 = true;
        L31:
            com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().o(this.a.q);
            return;
        L28:
            DataCenter r5 = this.a.q;
            if (r5 == null) goto L31;
            r5.put("data_live_interactive_component_show", Boolean.FALSE);
            goto L31
        L33:
            return;
        L5:
            IAbsCardWindow r6 = this.a.j;
            if (r6 == null) goto L14;
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L11;
            r6 = null;
        L11:
            if (r6 == null) goto L14;
            r6.dismissWindow();
            this.a.l = 0;
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
        public final /* synthetic */ LiveInteractiveAnnieXHelper a;
        public final /* synthetic */ View b;

        public y(LiveInteractiveAnnieXHelper r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            int[] r0 = new int[2];
            this.b.getLocationOnScreen(r0);
            DataCenter r1 = this.a.q;
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
        DataCenter r0 = this.q;
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
        return this.s.u9();
    }

    public final String getLogTag() {
        return this.s.getTag();
    }

    public com.bytedance.android.livesdk.interactivity.interactive.c h() {
        vr1.u r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.q, null, 2);
        if (r0 == null) goto L5;
        ViewModel r1 = r0.c();
    L7:
        if ((r1 instanceof EpisodeInteractiveContext) == true) goto L9;
        r1 = null;
    L9:
        EpisodeInteractiveContext r2 = (EpisodeInteractiveContext) r1;
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.interactive.c> r3 = r2.getLiveInteractiveAnnieXInfo();
        if (r3 != null) goto L14;
        return null;
    L14:
        return (com.bytedance.android.livesdk.interactivity.interactive.c) r3.getValue();
    L15:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    public final long i() {
        DataCenter r0 = this.q;
        if (r0 == null) goto L7;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
        if (r1 == null) goto L7;
        return r1.getRoomId();
    L7:
        return 0;
    }

    public final void release() {
        o82.h.b("[" + hashCode() + "]release hybrid component");
        View r0 = this.h;
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L9;
        r1.removeAllViews();
    L9:
        if (h() != null) goto L12;
        o82.h.b("[" + hashCode() + "]release hybridCard also");
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().s(this.d);
        this.c = null;
        this.d = null;
        return;
    }

    public Map<String, String> g() {
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public Context getContext() {
        return this.r;
    }

    public final DataCenter getDataCenter() {
        return this.q;
    }

    public static final JSONObject a(LiveInteractiveAnnieXHelper r9) {
        r9.getClass();
        JSONObject r0 = new JSONObject();
        if (r9.q == null) goto L31;
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
        IRoom r10 = (IRoom) r9.q.get("data_room", null);
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
        if (this.s.isVisible() == false) goto L12;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.c != null) goto L8;
        return;
    L8:
        if (r3.extra() == null) goto L15;
        ((SingleSubscribeProxy) Single.just(r3.extra()).observeOn(Schedulers.io()).map(k.a).map(new l(this)).observeOn(AndroidSchedulers.mainThread()).as(this.s.s7())).subscribe(new m(this, r3), n.a);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void Nj(long r3) {
        ((SingleSubscribeProxy) Single.just(new JSONObject()).observeOn(Schedulers.io()).map(new b(this, r3)).observeOn(AndroidSchedulers.mainThread()).as(this.s.s7())).subscribe(new c(this), d.a);
    }

    public final String b(String r5) {
        Uri r6 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().E(UriProtector.parse(r5), this.q);
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
        if (this.p == false) goto L23;
        String r3 = "0";
    L24:
        r9.appendQueryParameter("is_hor", r3);
        goto L26
    L23:
        r3 = "1";
    L26:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.q).isPaidLive() == false) goto L33;
        if (r9 == null) goto L29;
        r9.appendQueryParameter("is_paidlive", "1");
    L29:
        if (r9 == null) goto L31;
        r9.appendQueryParameter("ticket_session_id", String.valueOf(com.bytedance.android.livesdk.vscore_api.paidlive.b.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.q).J0(), this.q)));
    L31:
        if (r9 == null) goto L33;
        r9.appendQueryParameter("watch_paidlive_status", com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.q).J0().q(this.q));
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
        ((SingleSubscribeProxy) Single.just(new JSONObject()).observeOn(Schedulers.io()).map(new e(this, r3)).observeOn(AndroidSchedulers.mainThread()).as(this.s.s7())).subscribe(new f(this, r3), g.a);
    }

    public final void l(IBannerInfo r5) {
        o82.h.b("[" + hashCode() + "]on banner data");
        this.s.ol();
        if (this.s.isVisible() == false) goto L41;
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
        k(r5, r4, this.h);
        return;
    L35:
        o82.h.b("[" + hashCode() + "]onBannerData contentView hasn't init, wait");
        NextLiveData<Boolean> r9 = this.a;
        FragmentActivity r10 = this.r;
        if (r10 == null) goto L40;
        r9.observe(r10, new com.bytedance.android.livesdk.interactivity.interactive.f(this, r5, r4));
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
        View r0 = this.h;
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
        EpisodeInteractiveDialog r7 = this.i;
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
        if (this.q != null) goto L5;
        return;
    L5:
        if (this.h != null) goto L8;
        return;
    L8:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L10;
    L19:
        View r0 = this.h;
        if (r0 != null) goto L22;
        return;
    L22:
        boolean r4 = false;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L25;
        r0.setVisibility(0);
    L33:
        WebView r3 = this.c;
        if (r3 == null) goto L36;
        UtilityKotlinExtentionsKt.w(r3);
    L36:
        this.l = 1;
        if (this.p == true) goto L40;
        r0.post(new y(this, r0));
    L40:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == false) goto L49;
        DataCenter r5 = this.q;
        if (r5 == null) goto L52;
        IAbsCardWindow r6 = this.j;
        if (r6 != null) goto L46;
    L48:
        r5.put("data_live_interactive_component_show", Boolean.valueOf(r4));
        goto L52
    L46:
        if (r6.isShowingWindow() != true) goto L48;
        r4 = true;
    L52:
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().o(this.q);
        if (r8 == false) goto L59;
        ViewPropertyAnimator r9 = r0.animate().alpha(1);
        if (this.p == false) goto L57;
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
        DataCenter r7 = this.q;
        if (r7 == null) goto L52;
        r7.put("data_live_interactive_component_show", Boolean.TRUE);
        goto L52
    L25:
        IAbsCardWindow r10 = this.j;
        if (r10 == null) goto L33;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().h() == true) goto L31;
        r10 = null;
    L31:
        if (r10 == null) goto L33;
        r10.showWindow();
        goto L33
    L10:
        if (this.b != 1) goto L19;
        EpisodeInteractiveDialog r2 = this.i;
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

    public void t(com.bytedance.android.livesdk.interactivity.interactive.c r4) {
        Intrinsics.checkNotNullParameter(r4, "interactiveInfo");
        ViewModel r1 = null;
        vr1.u r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.q, null, 2);
        if (r0 == null) goto L5;
        ViewModel r2 = r0.c();
    L7:
        if ((r2 instanceof EpisodeInteractiveContext) == false) goto L10;
        r1 = r2;
    L10:
        EpisodeInteractiveContext r3 = (EpisodeInteractiveContext) r1;
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.interactive.c> r5 = r3.getLiveInteractiveAnnieXInfo();
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
        if (this.s.isVisible() == false) goto L24;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.c != null) goto L8;
        return;
    L8:
        if (r3.extra() == null) goto L27;
        DataCenter r0 = this.q;
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
        ((SingleSubscribeProxy) Single.just(r3.extra()).observeOn(Schedulers.io()).map(s.a).map(new t(this)).observeOn(AndroidSchedulers.mainThread()).as(this.s.s7())).subscribe(new u(this, r3), v.a);
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void wz(ku2.b r3) {
        if (this.s.isVisible() == false) goto L24;
        if (r3 != null) goto L6;
        return;
    L6:
        if (this.c != null) goto L8;
        return;
    L8:
        if (r3.extra() == null) goto L27;
        DataCenter r0 = this.q;
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
        ((SingleSubscribeProxy) Single.just(r3.extra()).observeOn(Schedulers.io()).map(o.a).map(new p(this)).observeOn(AndroidSchedulers.mainThread()).as(this.s.s7())).subscribe(new q(this, r3), r.a);
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

    public final void o(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "data");
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().x(this.d, r3, r4);
    }

    public final void k(final IBannerInfo r23, final boolean r24, View r25) {
        o82.h.b("start initHybridComponentForAnnie[" + hashCode() + "], contentView:" + r25 + ",bannerInfo:" + r23);
        Jsb2MethodFinder r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().A();
        this.e = r0;
        if (r0 != null) goto L5;
        o82.h.b("[" + hashCode() + "]register interactive jsb failed");
    L8:
        com.bytedance.android.livesdk.interactivity.interactive.c r1 = h();
        View r13 = null;
        if (r1 != null) goto L11;
    L36:
        Context r15 = this.r;
        if (r15 == null) goto L60;
        final o82.g r14 = new o82.g(!r24);
        String r2 = BuildConfig.FLAVOR;
        if (r24 == false) goto L52;
        VSBannerInfo r3 = r23.castToOrNull(VSBannerInfo.class);
        if (r3 == null) goto L44;
        String r4 = r3.getLynxUrl();
        if (r4 == null) goto L44;
    L45:
        Uri.Builder r5 = x6.a.d(b(r4)).buildUpon();
        VSBannerInfo r6 = r23.castToOrNull(VSBannerInfo.class);
        if (r6 == null) goto L51;
        String r7 = r6.getH5Url();
        if (r7 == null) goto L51;
        r2 = r7;
    L51:
        Uri r8 = r5.appendQueryParameter("fallback_url", b(r2)).build();
    L59:
        final Uri r9 = r8;
        o82.h.b("[" + hashCode() + "]load url: " + r9);
        vr1.j r16 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i();
        Object r10 = this.e;
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("key1", "value1");
        Unit r17 = Unit.INSTANCE;
        this.d = r16.c(r15, r9, r10, r11, new LiveInteractiveAnnieXHelper$obtainHybridComponentForAnnie$$inlined$let$lambda$1(r14, r9, this, r24, r23), new LiveInteractiveAnnieXHelper$obtainHybridComponentForAnnie$$inlined$let$lambda$2(r14, this, r24, r23));
        o82.h.b("obtainHybridComponentForAnnie[" + hashCode() + "]: obtain instance " + this.c);
        SSWebView r18 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().d(this.d);
    L61:
        if (r18 == null) goto L99;
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().i(this.d, this.e);
        this.c = r18;
        r18.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r18.getParent() == null) goto L70;
        o82.h.b("initHybridComponentForAnnie[" + hashCode() + "]: HybridCard has parentView which need to be removed");
        ViewParent r19 = r18.getParent();
        if ((r19 instanceof ViewGroup) == true) goto L67;
        r19 = null;
    L67:
        ViewGroup r20 = (ViewGroup) r19;
        if (r20 == null) goto L70;
        r20.removeView(r18);
    L70:
        boolean r21 = r25 instanceof ViewGroup;
        if (r21 == true) goto L73;
        View r26 = null;
    L74:
        ViewGroup r27 = (ViewGroup) r26;
        if (r27 == null) goto L77;
        r27.addView(r18, 0);
    L77:
        StringBuilder r28 = new StringBuilder("initHybridComponentForAnnie[");
        r28.append(hashCode());
        r28.append("], after add view, contentView now childCount:");
        if (r21 == true) goto L80;
        View r29 = null;
    L81:
        ViewGroup r30 = (ViewGroup) r29;
        if (r30 == null) goto L84;
        Integer r31 = Integer.valueOf(r30.getChildCount());
    L85:
        r28.append(r31);
        o82.h.b(r28.toString());
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L99;
        View r33 = new View(this.r);
        r33.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if ((r25 instanceof FrameLayout) == false) goto L91;
        r13 = r25;
    L91:
        FrameLayout r110 = (FrameLayout) r13;
        if (r110 == null) goto L94;
        r110.addView(r33);
    L94:
        if (r25 == null) goto L96;
        r25.setFocusable(true);
    L96:
        if (r25 == null) goto L98;
        r25.setFocusableInTouchMode(true);
    L98:
        r33.setBackground(new ColorDrawable(0));
        r3.a(r25, "活动入口");
        goto L99
    L84:
        r31 = null;
        goto L85
    L80:
        r29 = r25;
        goto L81
    L73:
        r26 = r25;
    L99:
        b20("init", 0, 1.0f, new JSONObject());
        return;
    L44:
        r4 = BuildConfig.FLAVOR;
        goto L45
    L52:
        VSBannerInfo r34 = r23.castToOrNull(VSBannerInfo.class);
        if (r34 == null) goto L58;
        String r35 = r34.getH5Url();
        if (r35 == null) goto L58;
        r2 = r35;
    L58:
        r8 = x6.a.b(b(r2));
        goto L59
    L60:
        String r36 = "obtainHybridComponentForAnnie[" + hashCode() + "]: return null";
        RuntimeException r37 = new RuntimeException("obtainHybridComponentForAnnie null");
        Intrinsics.checkNotNullParameter(r36, "msg");
        Intrinsics.checkNotNullParameter(r37, "exception");
        ALogger.e("LiveInteractive", r36, r37);
        r18 = null;
        goto L61
    L11:
        if (Intrinsics.areEqual(r1.a, r23) == false) goto L36;
        Object r38 = r1.c;
        if (r38 == null) goto L34;
        boolean r39 = r1.b;
        vr1.u r40 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.q, null, 2);
        if (r40 != null) goto L17;
    L18:
        vr1.u r41 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.q, null, 2);
        if (r41 == null) goto L21;
        boolean r43 = r41.isPortraitInteraction();
    L22:
        r1.b = r43;
        StringBuilder r44 = new StringBuilder("[");
        r44.append(hashCode());
        r44.append("]roomHorizontalChange: is_horizontal: ");
        DataCenter r45 = this.q;
        if (r45 == null) goto L25;
        Boolean r46 = Boolean.valueOf(com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r45, true));
    L26:
        r44.append(r46);
        o82.h.b(r44.toString());
        vr1.j r47 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i();
        JSONObject r48 = new JSONObject();
        DataCenter r49 = this.q;
        if (r49 != null) goto L29;
    L31:
        int r50 = 1;
    L32:
        r48.put("is_horizontal", r50);
        Unit r51 = Unit.INSTANCE;
        r47.x(r38, "roomHorizontalChange", r48);
        o82.h.b("obtainHybridComponentForAnnie[" + hashCode() + "]: reuse hybrid card, sendRoomHorizontalChangeJSEvent");
    L33:
        Unit r53 = Unit.INSTANCE;
    L35:
        this.d = r38;
        r18 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().d(this.d);
        goto L61
    L29:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r49, true) != true) goto L31;
        r50 = 0;
        goto L32
    L25:
        r46 = null;
        goto L26
    L21:
        r43 = false;
        goto L22
    L17:
        if (r39 == r40.isPortraitInteraction()) goto L33;
    L34:
        r38 = null;
        goto L35
    L5:
        o82.h.b("[" + hashCode() + "]register interactive jsb");
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().a(this.e, "interactiveBannerShow", new com.bytedance.android.livesdk.interactivity.interactive.g(this));
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().a(this.e, "interactiveSetStorage", new com.bytedance.android.livesdk.interactivity.interactive.h(this));
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().a(this.e, "interactiveGetStorage", new com.bytedance.android.livesdk.interactivity.interactive.i(this));
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().a(this.e, "getSeiInfo", new com.bytedance.android.livesdk.interactivity.interactive.j(this));
        EpisodeInteractiveDialog r54 = this.i;
        if (r54 == null) goto L8;
        r54.setOnDismissListener(new com.bytedance.android.livesdk.interactivity.interactive.k(this));
        goto L8
    }

    public LiveInteractiveAnnieXHelper(boolean r2, DataCenter r3, Context r4, com.bytedance.android.livesdk.interactivity.interactive.b r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.p = r2;
        this.q = r3;
        this.r = r4;
        this.s = r5;
        this.a = new NextLiveData();
        this.k = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter.IView
    public final void b20(String r8, long r9, float r11, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r8, "type");
        Intrinsics.checkNotNullParameter(r13, "extra");
        ((SingleSubscribeProxy) Single.just(r13).observeOn(Schedulers.io()).map(new h(this, r8, r9, r11)).observeOn(AndroidSchedulers.mainThread()).as(this.s.s7())).subscribe(new i(this, r8, r9), j.a);
    }
}
