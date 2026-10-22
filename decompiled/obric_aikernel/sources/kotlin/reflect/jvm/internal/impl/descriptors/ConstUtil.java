package kotlin.reflect.jvm.internal.impl.descriptors;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class ConstUtil {
    public static final ConstUtil INSTANCE = null;

    static {
        INSTANCE = new ConstUtil();
    }

    private ConstUtil() {
    }

    @JvmStatic
    public static final boolean canBeUsedForConstVal(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        return ConstUtilKt.canBeUsedForConstVal(r10);
    }
}
