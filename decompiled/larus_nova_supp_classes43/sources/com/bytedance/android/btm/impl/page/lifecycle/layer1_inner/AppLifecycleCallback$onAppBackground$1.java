package com.bytedance.android.btm.impl.page.lifecycle.layer1_inner;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class AppLifecycleCallback$onAppBackground$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $activityClassName;

    public AppLifecycleCallback$onAppBackground$1(String r1) {
        this.$activityClassName = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m710invoke();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m710invoke() {
        return this.$activityClassName;
    }
}
