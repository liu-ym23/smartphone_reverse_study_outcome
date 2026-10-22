package com.bytedance.android.live.broadcastgame.opengame.lynx;

import com.bytedance.android.live.broadcastgame.opengame.utils.j;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "prefix", "", LiveSlardarConstants.EXTRA_KEY_URL, "configPath", "invoke", "com/bytedance/android/live/broadcastgame/opengame/lynx/LynxOpenPlugin$onStart$2$1"}, k = 3, mv = {1, 4, 3})
public final class LynxOpenPlugin$onStart$$inlined$let$lambda$1 extends Lambda implements Function3<String, String, String, Unit> {
    final /* synthetic */ LynxOpenPlugin this$0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LynxOpenPlugin$onStart$$inlined$let$lambda$1 a;
        public final /* synthetic */ String b;

        public a(LynxOpenPlugin$onStart$$inlined$let$lambda$1 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            String r8 = (String) r7;
            int r9 = j.a;
            final com.bytedance.android.live.broadcastgame.opengame.lynx.a r11 = (com.bytedance.android.live.broadcastgame.opengame.lynx.a) JsonUtil.parse(j.d(this.b), new h().getType());
            if (r11 == null) goto L6;
            UtilityKotlinExtentionsKt.s(0, false, false, new LynxOpenPlugin$onStart$$inlined$let$lambda$1$1$2(r11, this), 7);
            return;
        }
    }

    public LynxOpenPlugin$onStart$$inlined$let$lambda$1(LynxOpenPlugin r1) {
        this.this$0 = r1;
        super(3);
    }

    public final void invoke(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "prefix");
        Intrinsics.checkNotNullParameter(r8, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r9, "configPath");
        LynxOpenPlugin r0 = this.this$0;
        r0.t = r7;
        r0.v = r9;
        if (StringsKt.isBlank(r9) == true) goto L5;
        Observable.just(r9).subscribeOn(Schedulers.io()).subscribe(new a(this, r9));
    L5:
        LynxOpenPlugin r11 = this.this$0;
        String r12 = StringsKt.replace$default(r8, r7, "", false, 4, null);
        if (r11.r != null) goto L8;
        r11.y();
    L8:
        com.bytedance.android.live.lynx.api.d r1 = r11.r;
        boolean r2 = true;
        if (r1 == null) goto L14;
        String r3 = r1.getUrl();
        if (r3 == null) goto L14;
        if (StringsKt.endsWith$default(r3, r12, false, 2, null) != true) goto L14;
    L24:
        com.bytedance.android.live.lynx.api.d r4 = r11.r;
        if (r4 == null) goto L33;
        r4.c(r12, r8, r11.x());
        return;
    L33:
        return;
    L14:
        com.bytedance.android.live.lynx.api.d r5 = r11.r;
        if (r5 == null) goto L17;
        String r6 = r5.getUrl();
    L18:
        if (r6 != null) goto L20;
    L23:
        if (r2 == true) goto L24;
        Iterator<T> r13 = r11.s.iterator();
    L29:
        if (r13.hasNext() == false) goto L40;
        com.bytedance.android.live.lynx.api.d r14 = (com.bytedance.android.live.lynx.api.d) r13.next();
        if (StringsKt.endsWith$default(r14.getUrl(), r12, false, 2, null) == false) goto L29;
        r14.c(r12, r8, r11.x());
        goto L29
    L40:
        return;
    L20:
        if (r6.length() == 0) goto L23;
        r2 = false;
        goto L23
    L17:
        r6 = null;
        goto L18
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((String) r1, (String) r2, (String) r3);
        return Unit.INSTANCE;
    }
}
