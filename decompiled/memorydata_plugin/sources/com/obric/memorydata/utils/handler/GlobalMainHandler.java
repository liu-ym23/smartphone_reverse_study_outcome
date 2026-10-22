package com.obric.memorydata.utils.handler;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/utils/handler/GlobalMainHandler;", "", "<init>", "()V", "Companion", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalMainHandler {
    public static final Companion Companion = null;
    private static final Lazy<Handler> instance$delegate = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/utils/handler/GlobalMainHandler$Companion;", "", "<init>", "()V", "instance", "Landroid/os/Handler;", "getInstance", "()Landroid/os/Handler;", "instance$delegate", "Lkotlin/Lazy;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Handler getInstance() {
            return (Handler) ZeusTransformUtils.preCheckCast(GlobalMainHandler.access$getInstance$delegate$cp().getValue(), Handler.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$GlobalMainHandler$ZP8aAW_D1nfZKw4cgaKDkS3p5O0.INSTANCE);
    }

    public GlobalMainHandler() {
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    private static final Handler instance_delegate$lambda$0() {
        return Handler.createAsync(Looper.getMainLooper());
    }

    public static /* synthetic */ Handler lambda$ZP8aAW_D1nfZKw4cgaKDkS3p5O0() {
        return instance_delegate$lambda$0();
    }
}
