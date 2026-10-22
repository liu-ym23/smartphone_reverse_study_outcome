package okhttp3;

import java.util.ArrayList;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteString f20660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f20661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f20662c;

    public i0() {
        String r5 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r5, "boundary");
        ByteString.Companion.getClass();
        this.f20660a = nu.m.c(r5);
        this.f20661b = k0.e;
        this.f20662c = new ArrayList();
    }

    public final void a(c0 r5, q0 r10) {
        Intrinsics.checkNotNullParameter(r10, "body");
        Intrinsics.checkNotNullParameter(r10, "body");
        String r11 = null;
        if (r5 == null) goto L5;
        String r12 = r5.b("Content-Type");
    L6:
        if (r12 != null) goto L15;
        if (r5 == null) goto L9;
        r11 = r5.b("Content-Length");
    L9:
        if (r11 != null) goto L13;
        j0 r13 = new j0(r5, r10);
        Intrinsics.checkNotNullParameter(r13, "part");
        this.f20662c.add(r13);
        return;
    L13:
        throw new IllegalArgumentException("Unexpected header: Content-Length");
    L15:
        throw new IllegalArgumentException("Unexpected header: Content-Type");
    L5:
        r12 = null;
        goto L6
    }

    public final void b(h0 r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (Intrinsics.areEqual(r5.f20658b, "multipart") == false) goto L7;
        this.f20661b = r5;
        return;
    L7:
        throw new IllegalArgumentException(("multipart != " + r5).toString());
    }
}
