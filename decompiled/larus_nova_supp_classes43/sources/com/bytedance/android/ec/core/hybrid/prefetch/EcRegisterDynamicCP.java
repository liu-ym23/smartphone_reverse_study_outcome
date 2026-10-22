package com.bytedance.android.ec.core.hybrid.prefetch;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class EcRegisterDynamicCP implements com.bytedance.android.ec.adapter.api.h {
    public long a;
    public long b;
    public long c;
    public boolean d;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/EcRegisterDynamicCP$Companion$PreloadDynamicErrorCode;", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PreloadDynamicErrorCode {
        }
    }

    static {
    }

    public EcRegisterDynamicCP() {
    }

    public final void a(String r11, Integer r12) {
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        Job r13 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new EcRegisterDynamicCP$reportPreloadDynamic$scope$1(this, r11, false, r12, null), 2, null);
        NativePrefetchUtil.c.postDelayed(new d(r13), 1000);
    }
}
