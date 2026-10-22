package ai;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends okhttp3.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f184c;

    public /* synthetic */ c0(int r5, Object r10, Object r11) {
        this.f182a = r5;
        this.f183b = r10;
        this.f184c = r11;
    }

    @Override // okhttp3.q0
    public final long contentLength() {
        switch(this.f182a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return ((ByteString) this.f183b).size();
    L7:
        return ((File) this.f183b).length();
    L9:
        return ((okhttp3.q0) this.f183b).contentLength();
    }

    @Override // okhttp3.q0
    public final okhttp3.h0 contentType() {
        Object r5 = this.f184c;
        switch(this.f182a) {
            case 0: goto L8;
            case 1: goto L7;
            default: goto L5;
        };
    L8:
        Pattern r10 = okhttp3.h0.e;
        return okhttp3.z.j((String) r5);
    L5:
        return (okhttp3.h0) r5;
    L7:
        return (okhttp3.h0) r5;
    }

    @Override // okhttp3.q0
    public final void writeTo(nu.k r5) {
        Object r10 = this.f183b;
        switch(this.f182a) {
            case 0: goto L15;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "sink");
        r5.F((ByteString) r10);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "sink");
        Logger r11 = nu.t.f20339a;
        File r12 = (File) r10;
        Intrinsics.checkNotNullParameter(r12, "$this$source");
        nu.d r13 = f4.b.p(new FileInputStream(r12));
        r5.G(r13);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r13, null);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    L15:
        ((okhttp3.q0) r10).writeTo(r5);
    }
}
