package cf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f3602a;

    public s(b r8) {
        super("stream was reset: " + r8);
        this.f3602a = r8;
    }
}
