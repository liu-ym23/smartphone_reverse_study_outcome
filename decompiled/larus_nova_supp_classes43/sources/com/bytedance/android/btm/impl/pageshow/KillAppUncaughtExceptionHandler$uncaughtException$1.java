package com.bytedance.android.btm.impl.pageshow;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class KillAppUncaughtExceptionHandler$uncaughtException$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Thread $t;

    public KillAppUncaughtExceptionHandler$uncaughtException$1(Thread r1) {
        this.$t = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m883invoke() {
        return this.$t.getName();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m883invoke();
    }
}
