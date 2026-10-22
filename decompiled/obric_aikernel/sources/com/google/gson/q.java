package com.google.gson;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q<T> {

    class a extends q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f4276a;

        a(q r10) {
            this.f4276a = r10;
        }

        @Override // com.google.gson.q
        public T b(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L7;
            r10.K();
            return null;
        L7:
            return (T) this.f4276a.b(r10);
        }

        @Override // com.google.gson.q
        public void d(com.google.gson.stream.a r10, T r11) {
            if (r11 != null) goto L4;
            r10.B();
            return;
        L4:
            this.f4276a.d(r10, r11);
        }
    }

    public q() {
    }

    public final q<T> a() {
        return new a(this);
    }

    public abstract T b(i6.a r10);

    public final i c(T r10) {
        e6.g r11 = new e6.g();     // Catch: IOException -> L4
        d(r11, r10);     // Catch: IOException -> L4
        return r11.e0();
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public abstract void d(com.google.gson.stream.a r10, T r11);
}
