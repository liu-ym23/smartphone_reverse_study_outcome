package com.obric.memorydata.utils.handler;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/utils/handler/GlobalHandlerUtil;", "Lcom/obric/memorydata/utils/handler/AbstractHandlerInstance;", "<init>", "()V", "getHandlerThreadName", "", "Companion", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlobalHandlerUtil extends AbstractHandlerInstance {
    public static final Companion Companion = null;
    private static final Lazy<GlobalHandlerUtil> instance$delegate = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/utils/handler/GlobalHandlerUtil$Companion;", "", "<init>", "()V", "instance", "Lcom/obric/memorydata/utils/handler/GlobalHandlerUtil;", "getInstance", "()Lcom/obric/memorydata/utils/handler/GlobalHandlerUtil;", "instance$delegate", "Lkotlin/Lazy;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final GlobalHandlerUtil getInstance() {
            return (GlobalHandlerUtil) ZeusTransformUtils.preCheckCast(GlobalHandlerUtil.access$getInstance$delegate$cp().getValue(), GlobalHandlerUtil.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$GlobalHandlerUtil$wqew1ShvHiXEqLbv3xgmd6QJoM8.INSTANCE);
    }

    private GlobalHandlerUtil() {
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    private static final GlobalHandlerUtil instance_delegate$lambda$0() {
        return new GlobalHandlerUtil();
    }

    public static /* synthetic */ GlobalHandlerUtil lambda$wqew1ShvHiXEqLbv3xgmd6QJoM8() {
        return instance_delegate$lambda$0();
    }

    @Override // com.obric.memorydata.utils.handler.AbstractHandlerInstance
    public String getHandlerThreadName() {
        return "GlobalHandlerUtil";
    }
}
