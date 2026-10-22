package com.bytedance.android.livesdk.followtool.utils;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.g2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.followtool.api.UserSettingApi;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import jc1.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class XTFollowSyncUtils {
    public static Disposable a;
    public static long b;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            Response r3 = (Response) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (((BaseResponse) r3).statusCode != 0) goto L8;
            Object r4 = ((BaseResponse) r3).data;
            if (r4 == null) goto L8;
            return h80.c.c(r4);
        L8:
            return h80.c.b;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PublishSubject a;
        public final /* synthetic */ Function0 b;

        public b(PublishSubject r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            SubscriberJsEvent r4 = (SubscriberJsEvent) r3;
            ALogger.i("XTFollowSyncUtils", "onJsEvent:" + r4);
            if (r4 == null) goto L7;
            Map r5 = r4.getParams();
            if (r5 == null) goto L7;
            Object r6 = r5.get("result");
        L9:
            if (Intrinsics.areEqual(r6, "success") == false) goto L11;
            this.a.onNext(Boolean.TRUE);
        L12:
            this.b.invoke();
            return;
        L11:
            this.a.onNext(Boolean.FALSE);
        L7:
            r6 = null;
            goto L9
        }
    }

    public static boolean c() {
        if (v.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) LiveConfigSettingKeys.SAAS_FOLLOW_AUTH_FREQ_DISABLE.getValue()).booleanValue() == false) goto L7;
        return true;
    }

    static {
    }

    public static Observable a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userOpenId");
        return ((UserSettingApi) com.bytedance.android.live.network.c.b().e(UserSettingApi.class)).getUserRelationSyncSwitch(r2).map(a.a).onErrorReturnItem(h80.c.b).observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable b(Context r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r6, "authType");
        Uri r7 = UriProtector.parse(((String) LiveConfigSettingKeys.SAAS_FOLLOW_AUTH_SCHEMA.getValue()) + "%3Fscene%3D" + r5 + "%26auth%3D" + r6);     // Catch: Exception -> L18
        ALogger.i("XTFollowSyncUtils", "openUrl " + r7);
        ILiveService r8 = TTLiveService.getLiveService();
        if (r8 == null) goto L17;
        if (r8.handleSchema(r4, r7) != true) goto L17;
        XTFollowSyncUtils$openFollowSyncDialog$disposeIfNeed$1 r9 = XTFollowSyncUtils$openFollowSyncDialog$disposeIfNeed$1.INSTANCE;
        r9.invoke();
        IRoomService r10 = k.f(IRoomService.class);
        if (r10 == null) goto L13;
        Room r11 = r10.getCurrentRoom();
        if (r11 == null) goto L13;
        long r0 = r11.getRoomId();
    L14:
        b = r0;
        XTFollowSyncPrefs r12 = XTFollowSyncPrefs.m;
        int r1 = r12.d() + 1;
        g2.c r2 = XTFollowSyncPrefs.g;
        KProperty[] r3 = XTFollowSyncPrefs.c;
        r2.c(r3[3], Integer.valueOf(r1));
        XTFollowSyncPrefs.h.c(r3[4], Integer.valueOf(r12.e() + 1));
        PublishSubject r13 = PublishSubject.create();
        a = k.n(IBrowserService.class).registerJsEventSubscriber("saas_follow_auth.auth_result").observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r13, r9));
        return r13;
    L13:
        r0 = 0;
    L17:
        return Observable.just(Boolean.FALSE);
    L19:
        return Observable.just(Boolean.FALSE);
    }
}
