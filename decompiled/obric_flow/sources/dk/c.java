package dk;

import android.content.Context;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f16659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Serializable f16660b;

    public c() {
        this.f16659a = new ArrayList();
        this.f16660b = new ArrayList();
    }

    public c(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f16659a = r5;
    }
}
