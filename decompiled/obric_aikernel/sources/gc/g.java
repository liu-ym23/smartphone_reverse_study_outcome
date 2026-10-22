package gc;

import kotlin.PublishedApi;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
public abstract class g implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public long f9106c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public h f9107g;

    public g() {
        this(0, k.f9116g);
    }

    public g(long r10, h r11) {
        this.f9106c = r10;
        this.f9107g = r11;
    }
}
