package k8;

import ai.j0;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18626c;
    public final Object d;

    public a(int r5, String r10, int r11) {
        this.f18624a = 1;
        Intrinsics.checkNotNullParameter(r10, "unifyErrorMsg");
        this.f18625b = r5;
        this.d = r10;
        this.f18626c = r5 + r11;
    }

    public String toString() {
        switch(this.f18624a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return j0.n(new StringBuilder("RetryTimesPolicy{mMaxRetryTime=4, mCurrRetryTime="), this.f18626c, '}');
    }

    public a(Context r5) {
        this.f18624a = 0;
        this.f18625b = 0;
        this.d = r5;
    }
}
