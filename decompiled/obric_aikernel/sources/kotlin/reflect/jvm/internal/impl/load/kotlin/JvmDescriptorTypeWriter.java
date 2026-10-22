package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public class JvmDescriptorTypeWriter<T> {
    private T jvmCurrentType;
    private int jvmCurrentTypeArrayLevel;
    private final JvmTypeFactory<T> jvmTypeFactory;

    public void writeArrayEnd() {
    }

    public void writeArrayType() {
        if (this.jvmCurrentType != null) goto L6;
        this.jvmCurrentTypeArrayLevel++;
        return;
    }

    public void writeClass(T r10) {
        Intrinsics.checkNotNullParameter(r10, "objectType");
        writeJvmTypeAsIs(r10);
    }

    protected final void writeJvmTypeAsIs(T r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        if (this.jvmCurrentType == null) goto L5;
        return;
    L5:
        if (this.jvmCurrentTypeArrayLevel <= 0) goto L7;
        r10 = this.jvmTypeFactory.createFromString(StringsKt.repeat("[", this.jvmCurrentTypeArrayLevel) + this.jvmTypeFactory.toString(r10));
    L7:
        this.jvmCurrentType = r10;
    }

    public void writeTypeVariable(Name r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
        writeJvmTypeAsIs(r11);
    }
}
