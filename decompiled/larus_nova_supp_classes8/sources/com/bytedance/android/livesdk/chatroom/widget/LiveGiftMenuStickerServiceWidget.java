package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/LiveGiftMenuStickerServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "a", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGiftMenuStickerServiceWidget extends RoomRecyclableWidget {
    public static final /* synthetic */ int i = 0;
    public final CompositeDisposable a;
    public final List<a> b;
    public final Map<String, Sticker> c;
    public Disposable d;
    public long e;
    public JSONArray f;
    public Disposable g;
    public boolean h;

    public static final class a {
        public final zg1.p a;
        public boolean b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            zg1.p r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = r1 * 31;
            boolean r3 = this.b;
            ?? r4 = r3;
            if (r3 == false) goto L10;
            r4 = 1;
        L10:
            return r2 + r4;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "ChangeStickerTask(event=" + this.a + ", isRunning=" + this.b + ")";
        }

        public a(zg1.p r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a = r2;
            this.b = false;
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveGiftMenuStickerServiceWidget a;

        public c(LiveGiftMenuStickerServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            LiveGiftMenuStickerServiceWidget r5 = this.a;
            int r0 = LiveGiftMenuStickerServiceWidget.i;
            r5.getClass();
            List r6 = LiveEffectContext.h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().b("zongyiyouxi", "LiveGiftMenuStickerServiceWidgetclearStickerTimer");
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        this.e = 0;
        this.h = false;
        this.f = new JSONArray();
        Disposable r0 = this.g;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a.clear();
        ((ArrayList) this.b).clear();
        ((LinkedHashMap) this.c).clear();
        Disposable r1 = this.d;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public final void zq() {
        a r0 = (a) CollectionsKt.firstOrNull(this.b);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.b == false) goto L8;
        return;
    L8:
        r0.b = true;
        zg1.p r2 = r0.a;
        if (r2.c == false) goto L17;
        Map<String, Sticker> r3 = this.c;
        LinkedHashMap r4 = (LinkedHashMap) r3;
        Sticker r5 = (Sticker) r4.get(r2.b);
        if (r5 == null) goto L16;
        xq(r5);
        PthreadHandlerThreadV2 r6 = LiveEffectMonitor.a;
        LiveEffectMonitor.i(true, r0.a.b, true, "");
        zg1.q r7 = r0.a.d;
        if (r7 == null) goto L15;
        zg1.q.a.a(r7, true);
    L15:
        yq(r0);
        return;
    L16:
        List r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).d().fetchEffect(r0.a.b, new n0(this, r0));
        return;
    L17:
        List r8 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate.Type.DEFAULT).a().b("zongyiyouxi", "LiveGiftMenuStickerServiceWidgetdoConsumeEvent");
        PthreadHandlerThreadV2 r9 = LiveEffectMonitor.a;
        LiveEffectMonitor.i(false, "", true, "");
        yq(r0);
    }

    public LiveGiftMenuStickerServiceWidget() {
        this.a = new CompositeDisposable();
        this.b = new ArrayList();
        this.c = new LinkedHashMap();
        this.f = new JSONArray();
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getGiftMessageChannelStatus();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        this.h = r3;
        return;
    L9:
        r3 = false;
        goto L10
    }

    public static final void wq(LiveGiftMenuStickerServiceWidget r4) {
        r4.getClass();
        r4.e = System.currentTimeMillis();
        IBrowserService r0 = jc1.k.f(IBrowserService.class);
        if (r0 == null) goto L5;
        JSONObject r1 = new JSONObject();
        r1.put("data", new JSONArray(r4.f.toString()));
        r0.sendEventToAllJsBridges("live.notifyGiftMessage", r1);
    L5:
        r4.f = new JSONArray();
    }

    public final void onLoad(Object[] r5) {
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L11;
        com.bytedance.live.datacontext.m r7 = r6.getGiftMessageChannelStatus();
        if (r7 == null) goto L11;
        Observable r8 = r7.a();
        if (r8 == null) goto L11;
        Disposable r9 = r8.subscribe(new r0(this));
        if (r9 == null) goto L11;
        RxUtilKt.c(r9, this.a);
    L11:
        IGiftServiceExternal r10 = jc1.k.f(IGiftServiceExternal.class);
        if (r10 == null) goto L18;
        Observable r11 = r10.observeGiftMsgContent();
        if (r11 == null) goto L18;
        Disposable r12 = r11.subscribe(new q0(this));
        if (r12 == null) goto L18;
        RxUtilKt.c(r12, this.a);
    L18:
        RxUtilKt.c(xs2.b.a().b(zg1.p.class).subscribe(new o0(this)), this.a);
    }

    public final void xq(Sticker r5) {
        List r0 = LiveEffectContext.h;
        LiveEffectContextFactoryDelegate.Type r1 = LiveEffectContextFactoryDelegate.Type.DEFAULT;
        LiveEffectContext.a.a(r1).a().b("zongyiyouxi", "LiveGiftMenuStickerServiceWidget");
        LiveEffectContext.a.a(r1).a().a("zongyiyouxi", r5, "LiveGiftMenuStickerServiceWidget");
        Disposable r6 = this.d;
        if (r6 == null) goto L5;
        r6.dispose();
    L5:
        this.d = Observable.timer(((Long) LiveEffectSettings.LIVE_EFFECT_GIFT_MENU_STICKER_MAX_DURATION.getValue()).longValue(), TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
    }

    public final void yq(a r2) {
        ((ArrayList) this.b).remove(r2);
        zq();
    }
}
