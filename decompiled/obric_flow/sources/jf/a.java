package jf;

import ai.j0;
import java.io.Serializable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import s8.h;
import td.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Serializable f18318b;

    public a(String r5) {
        this.f18317a = 1;
        this.f18318b = j0.C("APM6-", r5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        switch(this.f18317a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        boolean r10 = b.f22124a;
        String r11 = (String) this.f18318b;
        if (r10 == false) goto L8;
        io.reactivex.exceptions.a.m("APM-AsyncTask", "creating newThread " + r11);
    L8:
        return new Thread(new h(5, this, r5), r11);
    L10:
        return new Thread(r5, "AA InitThread#" + ((AtomicInteger) this.f18318b).getAndIncrement());
    }

    public a() {
        this.f18317a = 0;
        this.f18318b = new AtomicInteger(1);
    }
}
