package b2;

import com.bytedance.ai.bridge.ContainerType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f820a = null;

    static {
        int[] r5 = new int[ContainerType.values().length];
        r5[2] = 1;     // Catch: NoSuchFieldError -> L8
    L15:
        ContainerType r10 = ContainerType.f1800b;     // Catch: NoSuchFieldError -> L9
        r5[0] = 2;     // Catch: NoSuchFieldError -> L9
    L13:
        ContainerType r11 = ContainerType.f1800b;     // Catch: NoSuchFieldError -> L10
        r5[1] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        f820a = r5;
    }
}
