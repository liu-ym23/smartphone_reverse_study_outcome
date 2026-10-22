package com.bytedance.android.live.platformplayer.playback;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.web.jsbridge2.f;
import java.util.Map;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LiveProgressBarWidget$seekMethodFactory$1 extends BaseJsBridgeMethodFactory {
    public final /* synthetic */ LiveProgressBarWidget a;

    public static final class a implements f.b {
        public final /* synthetic */ f a;

        public final f<?, ?> a() {
            return this.a;
        }

        public a(f r1) {
            this.a = r1;
        }
    }

    public LiveProgressBarWidget$seekMethodFactory$1(LiveProgressBarWidget r1) {
        this.a = r1;
    }

    public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        f r3 = (f) LazyKt.lazy(LazyThreadSafetyMode.NONE, new LiveProgressBarWidget$seekMethodFactory$1$provideStatefulMethods$registerMethod$2(this)).getValue();
        if (r3 == null) goto L10;
        if (((Widget) this.a).context != null) goto L11;
        ALogger.e("VSProgressBarWidget", "provideStatelessMethods: null context");
        return MapsKt.emptyMap();
    L11:
        return MapsKt.mapOf(TuplesKt.to("vsSeekHighLight", new a(r3)));
    L10:
        return MapsKt.emptyMap();
    }
}
