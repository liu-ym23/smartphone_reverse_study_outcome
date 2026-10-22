package m4;

import com.google.gson.stream.JsonToken;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f19979a = null;

    static {
        int[] r5 = new int[JsonToken.values().length];
        f19979a = r5;
        r5[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
    L16:
        f19979a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
    L20:
        f19979a[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
    L26:
        f19979a[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
    L18:
        f19979a[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
    L22:
        f19979a[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
        return;
    }
}
