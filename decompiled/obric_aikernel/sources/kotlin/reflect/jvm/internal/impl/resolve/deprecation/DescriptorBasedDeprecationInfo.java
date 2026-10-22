package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DescriptorBasedDeprecationInfo extends DeprecationInfo {
    public DescriptorBasedDeprecationInfo() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationInfo
    public boolean getPropagatesToOverrides() {
        return true;
    }
}
