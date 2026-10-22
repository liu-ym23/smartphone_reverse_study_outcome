package kotlinx.serialization.json.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.q;
import kotlinx.serialization.json.u;
import kotlinx.serialization.json.x;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final x f19427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f19428k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f19429l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19430m;

    public k(kotlinx.serialization.json.b r5, x r10) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r10, "value");
        super(r5, r10, null, null);
        this.f19427j = r10;
        List r11 = CollectionsKt.toList(r10.f19451a.keySet());
        this.f19428k = r11;
        this.f19429l = r11.size() * 2;
        this.f19430m = -1;
    }

    @Override // kotlinx.serialization.json.internal.i, kotlinx.serialization.json.internal.a
    public final kotlinx.serialization.json.l O(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        if ((this.f19430m % 2) != 0) goto L9;
        int r10 = kotlinx.serialization.json.m.f19441a;
        if (r5 != null) goto L11;
        return u.INSTANCE;
    L11:
        return new q(r5, true);
    L9:
        return (kotlinx.serialization.json.l) MapsKt.getValue(this.f19427j, r5);
    }

    @Override // kotlinx.serialization.json.internal.i, kotlinx.serialization.json.internal.a
    public final String Q(kotlinx.serialization.descriptors.g r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        List r11 = this.f19428k;
        return (String) r11.get(r10 / 2);
    }

    @Override // kotlinx.serialization.json.internal.i, kotlinx.serialization.json.internal.a
    public final kotlinx.serialization.json.l T() {
        return this.f19427j;
    }

    @Override // kotlinx.serialization.json.internal.i
    public final x V() {
        return this.f19427j;
    }

    @Override // kotlinx.serialization.json.internal.i, eu.a
    public final int l(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        int r10 = this.f19430m;
        if (r10 >= (this.f19429l - 1)) goto L6;
        int r11 = r10 + 1;
        this.f19430m = r11;
        return r11;
    L6:
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.i, kotlinx.serialization.json.internal.a, eu.a
    public final void u(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
    }
}
