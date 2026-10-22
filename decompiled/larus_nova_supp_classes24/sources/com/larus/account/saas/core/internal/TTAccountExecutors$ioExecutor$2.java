package com.larus.account.saas.core.internal;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TTAccountExecutors$ioExecutor$2 extends Lambda implements Function0<ExecutorService> {
    public static final TTAccountExecutors$ioExecutor$2 INSTANCE = null;

    static {
        INSTANCE = new TTAccountExecutors$ioExecutor$2();
    }

    public TTAccountExecutors$ioExecutor$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final ExecutorService m369invoke() {
        return PThreadExecutorsUtils.newCachedThreadPool(new e());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m369invoke();
    }
}
