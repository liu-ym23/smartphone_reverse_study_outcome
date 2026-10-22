package o82;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.m;
import com.bytedance.android.live.base.model.message.n;
import com.bytedance.android.live.base.model.message.o5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.model.z3;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.VSOptimizeUtils;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.model.VSOptimizeConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((Boolean) r1).booleanValue() == false) goto L6;
            this.a.invoke();
            return;
        }
    }

    @JvmStatic
    public static final int a() {
        return s1.f(175.0f);
    }

    @JvmStatic
    public static final int b() {
        return s1.f(130.0f);
    }

    static {
    }

    @JvmStatic
    public static final long c(DataCenter r4) {
        if (r4 != null) goto L17;
        long r0 = 0;
    L15:
        return r0 / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
    L17:
        MutableLiveData r5 = r.i().getSeiUpdate();     // Catch: JSONException -> L12
        if (r5 == null) goto L10;
        String r6 = (String) r5.getValue();     // Catch: JSONException -> L12
        if (r6 == null) goto L10;
        LiveSeiUtil.i.getClass();     // Catch: JSONException -> L12
        r0 = LiveSeiUtil.c(r6).optLong("ts", p6.b());     // Catch: JSONException -> L12
    L16:
    L10:
        r0 = p6.b();     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        ALogger.e("LiveInteractiveUtils", e);
        r0 = p6.b();
        goto L15
    }

    @JvmStatic
    public static final Disposable e(DataCenter r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "consumer");
        u r5 = r.u(r3, null, 2);
        if (r5 == null) goto L5;
        z3 r6 = r5.I();
    L6:
        if (r6 != null) goto L10;
        r4.invoke();
        return null;
    L10:
        if (((Boolean) r6.d.b.a).booleanValue() == false) goto L14;
        r4.invoke();
        return null;
    L14:
        return r6.d.b.delay(((VSOptimizeConfig) VSOptimizeUtils.a.getValue()).getInteractionLazyTime(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r4));
    L5:
        r6 = null;
        goto L6
    }

    @JvmStatic
    public static final void d(tlc.d r3, Function1<? super n, Unit> r4, Function1<? super o5, Unit> r5, Function1<? super ku2.b, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "onInteractiveMessage");
        Intrinsics.checkNotNullParameter(r5, "onVSInteractiveMessage");
        Intrinsics.checkNotNullParameter(r6, "onRoomBannerMessage");
        ku2.a r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getMessageMethod();
    L7:
        if (Intrinsics.areEqual(r1, xq1.b.a(ku2.e.i)) == false) goto L15;
        if ((r3 instanceof n) == true) goto L11;
        r3 = null;
    L11:
        n r7 = (n) r3;
        if (r7 == null) goto L36;
        r4.invoke(r7);
        return;
    L36:
        return;
    L15:
        if (Intrinsics.areEqual(r1, xq1.b.a(ku2.e.g)) == false) goto L23;
        if ((r3 instanceof o5) == true) goto L19;
        r3 = null;
    L19:
        o5 r8 = (o5) r3;
        if (r8 == null) goto L38;
        r5.invoke(r8);
        return;
    L38:
        return;
    L23:
        if (Intrinsics.areEqual(r1, xq1.b.a(ku2.e.h)) == true) goto L25;
        return;
    L25:
        if ((r3 instanceof vh7.c) == true) goto L27;
        r3 = null;
    L27:
        vh7.c r9 = (vh7.c) r3;
        if (r9 == null) goto L30;
        r0 = m.a(r9, ku2.b.class);
    L30:
        ku2.b r2 = (ku2.b) r0;
        if (r2 == null) goto L41;
        int r10 = r2.getPosition();
        ku2.b.Companion.getClass();
        if (r10 != 6) goto L42;
        r6.invoke(r2);
        return;
    L42:
        return;
    L41:
        return;
    L5:
        r1 = null;
        goto L7
    }
}
