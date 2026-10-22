package com.obric.memorydata.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/sdk/MemorySdkUtils;", "", "<init>", "()V", GsonUtil.TAG, "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGSON", "()Lcom/google/gson/Gson;", "GSON$delegate", "Lkotlin/Lazy;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f12832b = null;

    static {
        f12831a = new c();
        f12832b = LazyKt.lazy($$Lambda$c$FosDwIuojJIK4QbSG_LvkrGRHN4.INSTANCE);
    }

    private c() {
    }

    private static final Gson b() {
        return new GsonBuilder().create();
    }

    public static /* synthetic */ Gson lambda$FosDwIuojJIK4QbSG_LvkrGRHN4() {
        return b();
    }

    public final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f12832b.getValue(), Gson.class, "com.obric.memorydata.plugin");
    }
}
