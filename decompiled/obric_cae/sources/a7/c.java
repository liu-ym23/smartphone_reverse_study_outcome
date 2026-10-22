package a7;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class c extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f78a;

    public c(Exception r8) {
        super(r8.getMessage(), r8.getCause());
        if ((r8 instanceof b7.b) == false) goto L6;
        this.f78a = ((b7.b) r8).f3131a;
        return;
    }
}
