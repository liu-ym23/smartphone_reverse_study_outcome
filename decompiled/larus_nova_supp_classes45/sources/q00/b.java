package q00;

import com.bytedance.android.live.broadcast.LiveBroadcastBaseClientCopy;
import com.bytedance.android.live.broadcast.api.model.q0;
import com.bytedance.android.live.broadcast.commerce.LiveBroadcastEffectApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdk.config.dt;
import com.bytedance.android.livesdk.config.ul;
import com.bytedance.android.livesdk.config.w1;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements q00.a {
    public Disposable a;
    public Boolean b;
    public Boolean c;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // q00.a
    public final boolean a() {
        if (Intrinsics.areEqual(((w1) ul.a.getValue()).b(), Boolean.TRUE) == true) goto L5;
        return false;
    L5:
        return m90.b.D.c(LiveEffectContextFactoryDelegate$Type.DEFAULT).booleanValue();
    }

    @Override // q00.a
    public final boolean c() {
        if (((Boolean) dt.a.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext r1 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT);
        boolean r2 = !r1.a().o(d0.a).isEmpty();
        boolean r4 = !r1.a().o(d0.c).isEmpty();
        ILiveEffectComposerManager r5 = r1.a();
        String r6 = d0.k;
        boolean r7 = !r5.o(r6).isEmpty();
        if (r7 == false) goto L17;
        Iterator<T> r8 = r1.a().o(r6).iterator();
        boolean r9 = false;
    L9:
        if (r8.hasNext() == false) goto L16;
        Sticker r11 = (Sticker) r8.next();
        Iterator r12 = r11.getUpdateKeys().iterator();
    L12:
        if (r12.hasNext() == false) goto L9;
        if ((!Intrinsics.areEqual(r1.a().G(r11.getEffectId(), (String) r12.next()), 0.0f)) == false) goto L12;
        r9 = true;
        goto L9
    L16:
        r7 = r9;
    L17:
        Iterator<T> r13 = r1.a().o(FileUtils.BEAUTY).iterator();
        boolean r14 = false;
    L19:
        if (r13.hasNext() == false) goto L26;
        Sticker r15 = (Sticker) r13.next();
        Iterator r16 = r15.getUpdateKeys().iterator();
    L22:
        if (r16.hasNext() == false) goto L19;
        if ((!Intrinsics.areEqual(r1.a().G(r15.getEffectId(), (String) r16.next()), 0.0f)) == false) goto L22;
        r14 = true;
        goto L19
    L26:
        Iterator<T> r17 = r1.a().o(d0.i).iterator();
        boolean r18 = false;
    L28:
        if (r17.hasNext() == false) goto L36;
        Sticker r19 = (Sticker) r17.next();
        Iterator r110 = r19.getUpdateKeys().iterator();
    L31:
        if (r110.hasNext() == false) goto L28;
        if ((!Intrinsics.areEqual(r1.a().G(r19.getEffectId(), (String) r110.next()), 0.0f)) == false) goto L31;
        r18 = true;
        goto L28
    L36:
        if (m90.b.a.c(r1.g).booleanValue() == true) goto L38;
        r18 = false;
    L38:
        Iterator<T> r21 = r1.a().o("livebody").iterator();
        boolean r111 = false;
    L40:
        if (r21.hasNext() == false) goto L48;
        Sticker r112 = (Sticker) r21.next();
        Iterator r113 = r112.getUpdateKeys().iterator();
    L43:
        if (r113.hasNext() == false) goto L40;
        if ((!Intrinsics.areEqual(r1.a().G(r112.getEffectId(), (String) r113.next()), 0.0f)) == false) goto L43;
        r111 = true;
        goto L40
    L48:
        if (m90.b.j.c(r1.g).booleanValue() == true) goto L50;
        r111 = false;
    L50:
        xs2.b r22 = xs2.b.a();
        if (r2 == true) goto L58;
        if (r14 == true) goto L58;
        if (r18 == true) goto L58;
        if (r7 == true) goto L58;
        if (r111 == true) goto L58;
        boolean r114 = false;
    L59:
        r22.post(new n90.a(r114));
        if (r2 == true) goto L68;
        if (r4 == true) goto L68;
        if (r14 == true) goto L68;
        if (r18 == true) goto L68;
        if (r7 == true) goto L68;
        if (r111 == true) goto L68;
        boolean r3 = false;
    L69:
        if (r3 == false) goto L71;
    L73:
        if (r3 == true) goto L75;
    L77:
        r1.b = r3;
        return !r3;
    L75:
        if (r1.b == true) goto L77;
        PthreadHandlerThreadV2 r23 = LiveEffectMonitor.a;
        LiveEffectMonitor.k(false);
        goto L77
    L71:
        if (r1.b == false) goto L73;
        PthreadHandlerThreadV2 r24 = LiveEffectMonitor.a;
        LiveEffectMonitor.k(true);
    L68:
        r3 = true;
    L58:
        r114 = true;
        goto L59
    }

    @Override // q00.a
    public final void d(boolean r11) {
        Boolean r0 = this.b;
        if (r0 != null) goto L5;
        this.b = Boolean.valueOf(c());
        boolean r1 = true;
    L6:
        if (r1 == true) goto L13;
        Boolean r2 = this.c;
        if (r2 != null) goto L10;
        this.c = Boolean.valueOf(a());
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
        if (r11 == true) goto L13;
        return;
    L10:
        r3 = !Intrinsics.areEqual(r2, Boolean.valueOf(a()));
    L13:
        this.b = Boolean.valueOf(c());
        this.c = Boolean.valueOf(a());
        List<String> r12 = LiveEffectContext.h;
        Sticker r13 = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(d0.a));
        if (r13 == null) goto L17;
        String r14 = r13.getName();
        if (r14 == null) goto L17;
    L18:
        ALogger.d("COMMODITY_NO_FILTER", "update commerce effect status, commerceEffectStatus: " + this.b + ", commerceNoFilterStatus: " + this.c);
        LiveBroadcastEffectApi r4 = (LiveBroadcastEffectApi) LiveBroadcastBaseClientCopy.a(LiveBroadcastEffectApi.class);
        Boolean r8 = this.b;
        if (r8 == null) goto L21;
        boolean r9 = r8.booleanValue();
    L22:
        Boolean r15 = this.c;
        if (r15 == null) goto L25;
        boolean r16 = r15.booleanValue();
    L26:
        this.a = r4.uploadBeautyParams(0, r14, -1, -1, -1, -1, r9, r16).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(c.a, d.a);
        xs2.b r17 = xs2.b.a();
        Boolean r5 = this.b;
        if (r5 == null) goto L29;
        r5.booleanValue();
    L29:
        Boolean r6 = this.c;
        if (r6 == null) goto L32;
        r6.booleanValue();
    L32:
        r17.post(new q0());
        return;
    L25:
        r16 = true;
        goto L26
    L21:
        r9 = true;
    L17:
        r14 = "";
        goto L18
    L5:
        r1 = !Intrinsics.areEqual(r0, Boolean.valueOf(c()));
        goto L6
    }
}
