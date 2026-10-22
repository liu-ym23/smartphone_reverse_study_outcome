package ie;

import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends c {
    @Override // ie.c
    public final int a() {
        return c().nextInt();
    }

    @Override // ie.c
    public final int b() {
        return c().nextInt(2147418112);
    }

    public abstract Random c();
}
