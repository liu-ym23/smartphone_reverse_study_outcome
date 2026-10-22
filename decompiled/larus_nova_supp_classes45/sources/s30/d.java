package s30;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements ObservableOnSubscribe {
    public final /* synthetic */ b a;
    public final /* synthetic */ WebcastRedirectReportInfo b;

    public d(b r1, WebcastRedirectReportInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<com.bytedance.android.live.browser.schema.core.c> r7) {
        Intrinsics.checkNotNullParameter(r7, "emitter");
        Object r0 = k.n(IMiddleWareHostContext.class).getUgSettingsByKey(0, "data.common_info.extra.sjb_schema");
        if ((r0 instanceof JSONObject) == true) goto L5;
        r0 = null;
    L5:
        JSONObject r1 = (JSONObject) r0;
        if (r1 == null) goto L12;
        com.bytedance.android.live.browser.schema.core.d r2 = new com.bytedance.android.live.browser.schema.core.d(r1, null);
        if (r2.a() <= 0) goto L10;
        long r3 = r2.a();
    L11:
        this.b.a("ugsettings_source", GamePromoteDataContext.GAME_TYPE_MOBILE);
        com.bytedance.android.live.schema.api.utils.a.a("UGSettingsInterceptor", "hit by sync");
        int r4 = com.bytedance.android.live.browser.schema.core.c.d;
        com.bytedance.android.live.browser.schema.core.c r5 = com.bytedance.android.live.browser.schema.core.c.b.a(r2, this.a.c, r3, TimeUnit.SECONDS);
        this.a.a = r5;
        Unit r6 = Unit.INSTANCE;
        r7.onNext(r5);
        goto L12
    L10:
        r3 = 180;
    L12:
        r7.onComplete();
    }
}
