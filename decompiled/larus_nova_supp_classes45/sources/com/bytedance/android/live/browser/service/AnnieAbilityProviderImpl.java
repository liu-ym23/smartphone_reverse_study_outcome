package com.bytedance.android.live.browser.service;

import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.q3;
import com.bytedance.android.livesdk.config.r00;
import com.bytedance.android.livesdk.config.s8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.android.livesdkapi.jsb.ExternalJsBridgeMethodInjector;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import w20.aa;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AnnieAbilityProviderImpl extends w8.a {
    public final Lazy a;
    public final com.bytedance.android.live.browser.v b;
    public final com.bytedance.android.live.browser.u c;
    public final com.bytedance.android.live.browser.w d;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ AnnieAbilityProviderImpl a;
        public final /* synthetic */ View b;

        public a(AnnieAbilityProviderImpl r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return this.a.b.provideClipMethod(this.b);
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.q {
        public final /* synthetic */ AnnieAbilityProviderImpl a;

        public b(AnnieAbilityProviderImpl r1) {
            this.a = r1;
        }

        public final <T> String a(T r3) {
            Intrinsics.checkNotNullParameter(r3, "value");
            Class<?> r0 = r3.getClass();
            if (Intrinsics.areEqual(r0, JsonObject.class) == true) goto L15;
            if (Intrinsics.areEqual(r0, JsonArray.class) == true) goto L15;
            if (Intrinsics.areEqual(r0, String.class) == false) goto L11;
            return r3.toString();
        L11:
            if ((r3 instanceof aa) == false) goto L18;
            return GsonProtectorUtils.toJson((Gson) this.a.a.getValue(), r3);
        L18:
            return GsonProtectorUtils.toJson(GsonHelper.get(), r3);
        L15:
            return r3.toString();
        }

        public final <T> T b(String r2, Type r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r3, "type");
            return (T) GsonProtectorUtils.fromJson(GsonHelper.get(), r2, r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function2 a;

        public c(Function2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            UserEvent r5 = (UserEvent) r4;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
            JSONObject r1 = new JSONObject();     // Catch: Throwable -> L15
            JSONObject r2 = new JSONObject();     // Catch: Throwable -> L15
            IBaseUser.Status r6 = r5.getStatus();     // Catch: Throwable -> L15
            if (r6 == null) goto L10;
            int r7 = com.bytedance.android.live.browser.service.b.a[r6.ordinal()];     // Catch: Throwable -> L15
            if (r7 != 1) goto L9;
            String r8 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        L13:
            r2.put("type", r8);     // Catch: Throwable -> L15
            r1.put("args", r2);     // Catch: Throwable -> L15
            this.a.invoke("loginStatusChange", r1);     // Catch: Throwable -> L15
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
            return;
        L9:
            if (r7 != 2) goto L10;
            r8 = "3";
        L10:
            r8 = "0";
        L15:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
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

    public static final class e<T> implements Predicate {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final boolean test(Object r2) {
            UserEvent r3 = (UserEvent) r2;
            Intrinsics.checkNotNullParameter(r3, "userEvent");
            if (r3.getStatus() != IBaseUser.Status.Login) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ Function2 a;

        public f(Function2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            UserEvent r5 = (UserEvent) r4;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
            JSONObject r7 = new JSONObject();     // Catch: Throwable -> L5
            JSONObject r0 = new JSONObject();     // Catch: Throwable -> L5
            r0.put("code", GamePromoteDataContext.GAME_TYPE_MOBILE);     // Catch: Throwable -> L5
            r7.put("args", r0);     // Catch: Throwable -> L5
            this.a.invoke("H5_loginStatus", r7);     // Catch: Throwable -> L5
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ Function2 a;

        public h(Function2 r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            IFollowPair r6 = (IFollowPair) r5;
            if (r6 == null) goto L16;
            JSONObject r0 = new JSONObject();
            JSONObject r1 = new JSONObject();
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
            r0.put("type", "follow");     // Catch: Throwable -> L11
            r1.put("user_id", r6.getUserIdString());     // Catch: Throwable -> L11
            String r3 = r6.getSecUserId();     // Catch: Throwable -> L11
            if (r3 != null) goto L9;
            r3 = null;
        L9:
            r1.put("sec_user_id", r3);     // Catch: Throwable -> L11
            r1.put("follow_status", r6.getFollowStatus());     // Catch: Throwable -> L11
            r0.put("args", r1);     // Catch: Throwable -> L11
            this.a.invoke("H5_userStatusChange", r0);     // Catch: Throwable -> L11
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public final com.bytedance.ies.web.jsbridge2.q n1() {
        return new b(this);
    }

    @Deprecated(message = "see more in LiveHybridMethodManager")
    public final Map N(RegisterPolicy r5) {
        Intrinsics.checkNotNullParameter(r5, "registerPolicy");
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r0 = ExternalJsBridgeMethodInjector.INSTANCE.getLegacyMethodsProviders().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Iterator r1 = ((Map) ((Function0) r0.next()).invoke()).entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        Map.Entry r2 = (Map.Entry) r1.next();
        r6.put(r2.getKey(), r2.getValue());
        goto L7
    L9:
        return r6;
    }

    public final List<Disposable> Y(Function2<? super String, Object, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        List<Disposable> r0 = CollectionsKt.mutableListOf(new Disposable[]{jc1.k.n(IMiddlewareUserService.class).user().m().onBackpressureLatest().filter(e.a).subscribe(new f(r5), g.a), jc1.k.n(IMiddlewareUserService.class).user().followStateChanged().subscribe(new h(r5), i.a)});
        Flowable r1 = jc1.k.n(IMiddlewareUserService.class).user().x();
        if (r1 == null) goto L5;
        Disposable r6 = r1.subscribe(new c(r5), d.a);
    L6:
        r0.add(r6);
        return r0;
    L5:
        r6 = null;
        goto L6
    }

    public final void l1(com.bytedance.ies.web.jsbridge2.d0 r3) {
        Intrinsics.checkNotNullParameter(r3, "jsBridge2");
        if (((Boolean) s8.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (r3.b == null) goto L11;
        IHostWebView r0 = jc1.k.n(IHostWebView.class);
        WebView r1 = r3.b;
        Intrinsics.checkNotNull(r1);
        com.bytedance.ies.web.jsbridge2.d0 r2 = (com.bytedance.ies.web.jsbridge2.d0) r0.createJsBridge2(r1.getContext(), r3);
        if (r2 == null) goto L12;
        r3.b(r2);
        return;
    L12:
        return;
    }

    @Deprecated(message = "see more in LiveHybridMethodManager")
    public final Map<String, y6.b<? extends com.bytedance.ies.web.jsbridge2.f<?, ?>>> provideStateFulFragmentMethods(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return this.b.provideStateFulFragmentMethods(r2);
    }

    public final com.bytedance.ies.web.jsbridge2.f.b w(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return new a(this, r2);
    }

    public final w8.d F1(HybridFragment r2, FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        if (((Boolean) r00.a.getValue()).booleanValue() == false) goto L6;
        return null;
    L6:
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = new com.bytedance.android.live.browser.service.f();
        return new com.bytedance.android.live.browser.service.d(this, r3, r4);
    }

    public final void G0(y6.e r22, FragmentActivity r23) {
        Intrinsics.checkNotNullParameter(r22, "shareInfo");
        Intrinsics.checkNotNullParameter(r23, "activity");
        IRoom r1 = com.bytedance.android.live.browser.utils.c.f();
        ShareParams.Builder r0 = ShareParams.builder().setUrl(r22.b).setDescription(r22.c).setImageUrl(r22.d);
        if (r1 != null) goto L5;
    L7:
        Boolean r2 = Boolean.TRUE;
    L8:
        ShareParams.Builder r3 = r0.setEnablePromotion(r2.booleanValue());
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.p.a(o3.i(null, Long.valueOf(r1.getRoomId())), r3);
    L11:
        jc1.k.n(ILiveMiddlewareShareService.class).share(new i81.a(null, r23, null, r3.build(), null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "AnnieNGInitHelper", LiveShareType.SHARE_DIALOG, null);
        return;
    L5:
        if (r1.getStreamType() != LiveMode.MEDIA) goto L7;
        r2 = (Boolean) q3.a.getValue();
        goto L8
    }

    @Deprecated(message = "see more in LiveHybridMethodManager")
    public final com.bytedance.android.annie.bridge.p X(FragmentActivity r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = PublishSubject.create();
        return new com.bytedance.android.live.browser.service.c(this, r3, r0, r4);
    }

    public final w8.d k1(ia.c r2, FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r2, KtvSubElement.CONTAINER);
        if (((Boolean) r00.a.getValue()).booleanValue() == false) goto L6;
        return null;
    L6:
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = new com.bytedance.android.live.browser.service.g();
        return new com.bytedance.android.live.browser.service.e(this, r3, r4);
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideDefaultStatefulMethods(com.bytedance.ies.web.jsbridge2.d0 r4, RegisterPolicy r5) {
        Intrinsics.checkNotNullParameter(r5, "registerPolicy");
        LinkedHashMap r6 = new LinkedHashMap();
        r6.putAll(this.b.provideDefaultStatefulMethods(r4, RegisterPolicy.DEFAULT));
        Iterator r7 = ExternalJsBridgeMethodInjector.INSTANCE.getStatefulMethodsProviders().iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Iterator r0 = ((Map) ((Function0) r7.next()).invoke()).entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L4;
        Map.Entry r1 = (Map.Entry) r0.next();
        r6.put(r1.getKey(), r1.getValue());
        goto L7
    L9:
        sl2.a.b.provideStatefulMethods(r6);
        return r6;
    }

    @Deprecated(message = "see more in LiveHybridMethodManager")
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideDefaultStatelessMethods(com.bytedance.ies.web.jsbridge2.d0 r4, RegisterPolicy r5) {
        Intrinsics.checkNotNullParameter(r5, "registerPolicy");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(this.b.provideDefaultStatelessMethods(r4, r5));
        Iterator r6 = ExternalJsBridgeMethodInjector.INSTANCE.getStatelessMethodsProviders().iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Iterator r7 = ((Map) ((Function0) r6.next()).invoke()).entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L4;
        Map.Entry r1 = (Map.Entry) r7.next();
        r0.put(r1.getKey(), r1.getValue());
        goto L7
    L9:
        return r0;
    }

    public final w8.e z0(JSBridgeManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        return new AnnieAbilityProviderImpl$createStatusDataProvider$1(this.b.a(r3, r2), r2);
    }

    public AnnieAbilityProviderImpl(com.bytedance.android.live.browser.v r2, com.bytedance.android.live.browser.u r3, com.bytedance.android.live.browser.w r4) {
        Intrinsics.checkNotNullParameter(r2, "jsBridgeService");
        Intrinsics.checkNotNullParameter(r3, "h5Service");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = LazyKt.lazy(AnnieAbilityProviderImpl$resultModelGson$2.INSTANCE);
    }
}
