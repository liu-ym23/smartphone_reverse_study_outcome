package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.pb.videochat.GetAdminSettingsResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;
    public final Lazy c;
    public final CoroutineScope d;
    public GetAdminSettingsResponse e;

    public a(MinutesUCCImpl r3) {
        Intrinsics.checkNotNullParameter(r3, "userComponentContext");
        this.a = r3;
        this.b = "MmAdminSettingsService";
        this.c = LazyKt.lazy(new MmAdminSettingsService$networkService$2(this));
        this.d = CoroutineScopeKt.CoroutineScope(MMCoroutines.a().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }
}
