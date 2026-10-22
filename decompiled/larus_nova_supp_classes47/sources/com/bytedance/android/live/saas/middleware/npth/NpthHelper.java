package com.bytedance.android.live.saas.middleware.npth;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010\b\u001a\u00020\u00042\u001c\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00040\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/npth/NpthHelper;", "Lcom/bytedance/android/live/saas/middleware/npth/INpthHelper;", "()V", "addTags", "", "tags", "", "", "registerCrashCallback", "callback", "Lkotlin/Function2;", "Ljava/lang/Thread;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NpthHelper implements INpthHelper {
    public static final NpthHelper INSTANCE = null;

    private NpthHelper() {
    }

    static {
        INSTANCE = new NpthHelper();
    }

    @Override // com.bytedance.android.live.saas.middleware.npth.INpthHelper
    public void addTags(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "tags");
        Npth.addTags(r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.npth.INpthHelper
    public void registerCrashCallback(final Function2<? super String, ? super Thread, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Npth.registerCrashCallback(new AnonymousClass1(r2), CrashType.ALL);
    }
}
