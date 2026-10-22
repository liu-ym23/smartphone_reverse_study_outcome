package com.obric.memorydata.personalcontext.external;

import com.obric.memorydata.utils.handler.AbstractHandlerInstance;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/ExternalDataCollectorHandler;", "Lcom/obric/memorydata/utils/handler/AbstractHandlerInstance;", "<init>", "()V", "getHandlerThreadName", "", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f extends AbstractHandlerInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12127a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy<f> f12128b = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/ExternalDataCollectorHandler$Companion;", "", "<init>", "()V", "instance", "Lcom/obric/memorydata/personalcontext/external/ExternalDataCollectorHandler;", "getInstance", "()Lcom/obric/memorydata/personalcontext/external/ExternalDataCollectorHandler;", "instance$delegate", "Lkotlin/Lazy;", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final f a() {
            return (f) ZeusTransformUtils.preCheckCast(f.a().getValue(), f.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f12127a = new a(null);
        f12128b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$f$mNq013DXzs48A8jb95wNiMWlT0U.INSTANCE);
    }

    public f() {
    }

    public static final /* synthetic */ Lazy a() {
        return f12128b;
    }

    private static final f b() {
        return new f();
    }

    public static /* synthetic */ f lambda$mNq013DXzs48A8jb95wNiMWlT0U() {
        return b();
    }

    @Override // com.obric.memorydata.utils.handler.AbstractHandlerInstance
    public String getHandlerThreadName() {
        return "ExternalDataCollectorHandler";
    }
}
