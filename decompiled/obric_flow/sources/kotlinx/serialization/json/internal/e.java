package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.w;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f19421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19422b;

    public e(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        this.f19421a = new w(r5, new JsonElementMarker$origin$1(this));
    }
}
