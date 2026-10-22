package com.bytedance.ies.abmock.fetch;

import com.bytedance.ies.abmock.settings.SettingsKey;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@SettingsKey(a = "abmock_download_monitor_sample_2")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083D¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/abmock/fetch/FetchABEventSettings;", "", "()V", "DEFAULT", "", "sample", "getSample", "()I", "sample$delegate", "Lkotlin/Lazy;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.bytedance.ies.abmock.a.c(a = true)
    public static final int f2746b = 0;
    private static final Lazy c = null;

    static {
        f2745a = new d();
        f2746b = 50;
        c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(FetchABEventSettings$sample$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private d() {
    }
}
