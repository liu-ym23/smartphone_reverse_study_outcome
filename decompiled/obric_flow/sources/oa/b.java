package oa;

import com.bytedance.geckox.gson.BooleanTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lynx.tasm.utils.c;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f20421b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f20422c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f20423a;

    static {
        f20422c = new c(13);
        f20421b = new b();
    }

    public b() {
        f20422c.getClass();
        GsonBuilder r5 = new GsonBuilder();
        Class r10 = Boolean.TYPE;
        r5.registerTypeAdapter(r10, new BooleanTypeAdapter());
        r5.registerTypeAdapter(r10, new BooleanTypeAdapter());
        this.f20423a = r5.create();
    }
}
