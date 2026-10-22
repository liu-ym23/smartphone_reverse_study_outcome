package kotlin.reflect.jvm.internal.impl.load.kotlin;

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

    public void writeClass(T r5) {
        Intrinsics.checkNotNullParameter(r5, "objectType");
        writeJvmTypeAsIs(r5);
    }

    public final void writeJvmTypeAsIs(T r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (this.jvmCurrentType == null) goto L5;
        return;
    L5:
        if (this.jvmCurrentTypeArrayLevel <= 0) goto L7;
        r5 = this.jvmTypeFactory.createFromString(StringsKt.D(this.jvmCurrentTypeArrayLevel, "[") + this.jvmTypeFactory.toString(r5));
    L7:
        this.jvmCurrentType = r5;
    }

    public void writeTypeVariable(Name r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "type");
        writeJvmTypeAsIs(r10);
    }
}
