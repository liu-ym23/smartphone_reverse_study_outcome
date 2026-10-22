package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedArrayValue extends ArrayValue {
    private final KotlinType type;

    public DeserializedArrayValue(List<? extends ConstantValue<?>> r10, final KotlinType r11) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
        super(r10, new AnonymousClass1(r11));
        this.type = r11;
    }

    public final KotlinType getType() {
        return this.type;
    }
}
