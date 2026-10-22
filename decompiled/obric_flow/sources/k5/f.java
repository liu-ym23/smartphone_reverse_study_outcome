package k5;

import com.google.gson.stream.JsonToken;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18614a = null;

    static {
        int[] r5 = new int[JsonToken.values().length];
        r5[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r5[JsonToken.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        f18614a = r5;
    }
}
