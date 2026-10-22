package com.bytedance.android.live.saas.middleware.npth;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H&J&\u0010\u0007\u001a\u00020\u00032\u001c\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/npth/INpthHelper;", "", "addTags", "", "tags", "", "", "registerCrashCallback", "callback", "Lkotlin/Function2;", "Ljava/lang/Thread;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public interface INpthHelper {
    void addTags(Map<String, String> r1);

    void registerCrashCallback(Function2<? super String, ? super Thread, Unit> r1);
}
