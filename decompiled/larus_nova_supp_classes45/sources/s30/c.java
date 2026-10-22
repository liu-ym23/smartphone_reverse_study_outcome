package s30;

import android.os.SystemClock;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.IUgSettingCallback;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements ObservableOnSubscribe {
    public final /* synthetic */ b a;
    public final /* synthetic */ WebcastRedirectReportInfo b;

    public static final class a implements IUgSettingCallback {
        public final /* synthetic */ c a;
        public final /* synthetic */ long b;
        public final /* synthetic */ ObservableEmitter c;

        public a(c r1, long r2, ObservableEmitter r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void onResult(Map<String, Object> r8) {
            if (r8 == null) goto L13;
            Object r9 = r8.get("data.common_info.extra.sjb_schema");
            if ((r9 instanceof JSONObject) == true) goto L6;
            r9 = null;
        L6:
            JSONObject r11 = (JSONObject) r9;
            if (r11 == null) goto L13;
            com.bytedance.android.live.browser.schema.core.d r0 = new com.bytedance.android.live.browser.schema.core.d(r11, null);
            if (r0.a() <= 0) goto L11;
            long r1 = r0.a();
        L12:
            this.a.b.a("ugsettings_source", GamePromoteDataContext.GAME_TYPE_MINI);
            long r3 = SystemClock.uptimeMillis() - this.b;
            WebcastRedirectReportInfo r12 = this.a.b;
            r12.getClass();
            Intrinsics.checkNotNullParameter("ugsettings_elapsed", "key");
            ((Map) r12.c.getValue()).put("ugsettings_elapsed", Long.valueOf(r3));
            com.bytedance.android.live.schema.api.utils.a.a("UGSettingsInterceptor", "hit by async, elapsed " + r3);
            ObservableEmitter r13 = this.c;
            int r4 = com.bytedance.android.live.browser.schema.core.c.d;
            com.bytedance.android.live.browser.schema.core.c r2 = com.bytedance.android.live.browser.schema.core.c.b.a(r0, this.a.a.c, r1, TimeUnit.SECONDS);
            this.a.a.a = r2;
            Unit r5 = Unit.INSTANCE;
            r13.onNext(r2);
            goto L13
        L11:
            r1 = 180;
        L13:
            this.c.onComplete();
        }
    }

    public c(b r1, WebcastRedirectReportInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<com.bytedance.android.live.browser.schema.core.c> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        long r0 = SystemClock.uptimeMillis();
        k.n(IMiddleWareHostContext.class).getUgSettingsByKey(0, CollectionsKt.listOf("data.common_info.extra.sjb_schema"), new a(this, r0, r6));
    }
}
