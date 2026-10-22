package androidx.room.compiler.processing;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/processing/XProcessingConfig;", "", "()V", "PROP_PREFIX", "", "STRICT_MODE", "", "getSTRICT_MODE", "()Z", "STRICT_MODE$delegate", "Lkotlin/Lazy;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class XProcessingConfig {
    public static final XProcessingConfig INSTANCE = null;
    private static final String PROP_PREFIX = "androidx.room.compiler.processing";
    private static final Lazy STRICT_MODE$delegate = null;

    static {
        INSTANCE = new XProcessingConfig();
        STRICT_MODE$delegate = LazyKt.lazy(XProcessingConfig$STRICT_MODE$2.INSTANCE);
    }

    private XProcessingConfig() {
    }

    public final boolean getSTRICT_MODE() {
        return ((Boolean) STRICT_MODE$delegate.getValue()).booleanValue();
    }
}
