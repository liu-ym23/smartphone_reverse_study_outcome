package kotlinx.metadata.internal.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f19186a = null;

    static {
        int[] r5 = new int[WireFormat$JavaType.values().length];
        f19186a = r5;
        r5[WireFormat$JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f19186a[WireFormat$JavaType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
