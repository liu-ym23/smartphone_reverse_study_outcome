package d0;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class e implements com.bumptech.glide.load.data.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f16539b;

    public /* synthetic */ e(Object r5, int r10) {
        this.f16538a = r10;
        this.f16539b = r5;
    }

    private final void a() {
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        int r5 = this.f16538a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class c() {
        switch(this.f16538a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        return ByteBuffer.class;
    L5:
        return this.f16539b.getClass();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int r5 = this.f16538a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource d() {
        switch(this.f16538a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return DataSource.LOCAL;
    L7:
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(Priority r5, com.bumptech.glide.load.data.d r10) {
        switch(this.f16538a) {
            case 0: goto L14;
            default: goto L4;
        };
    L4:
        r10.f(this.f16539b);
        return;
    L14:
        r10.f(q0.b.a((File) this.f16539b));
        return;
    L8:
        e = move-exception;
        if (Log.isLoggable("ByteBufferFileLoader", 3) == false) goto L12;
        Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
    L12:
        r10.a(e);
    }
}
