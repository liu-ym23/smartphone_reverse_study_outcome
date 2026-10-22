package oa;

import com.google.gson.stream.JsonToken;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f20420a = null;

    static {
        int[] r5 = new int[JsonToken.values().length];
        f20420a = r5;
        r5[JsonToken.BOOLEAN.ordinal()] = 1;
        r5[JsonToken.NULL.ordinal()] = 2;
        r5[JsonToken.NUMBER.ordinal()] = 3;
    }
}
