package gn;

import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f17109a = null;

    static {
        int[] r5 = new int[ReadableType.values().length];
        f17109a = r5;
        r5[ReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f17109a[ReadableType.String.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
