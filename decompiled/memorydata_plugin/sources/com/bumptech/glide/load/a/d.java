package com.bumptech.glide.load.a;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class d implements o<File, ByteBuffer> {

    private static final class a implements com.bumptech.glide.load.data.d<ByteBuffer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f591a;

        a(File r1) {
            this.f591a = r1;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority r2, com.bumptech.glide.load.data.d.a<? super ByteBuffer> r3) {
            com.bumptech.glide.load.data.d.a r4 = (com.bumptech.glide.load.data.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.data.d.a.class, "com.obric.memorydata.plugin");
            r4.a(com.bumptech.glide.util.a.a(this.f591a));     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            if (Log.isLoggable("ByteBufferFileLoader", 3) == false) goto L9;
            Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
        L9:
            r4.a(e);
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void c() {
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    public static class b implements p<File, ByteBuffer> {
        public b() {
        }

        @Override // com.bumptech.glide.load.a.p
        public o<File, ByteBuffer> a(s r1) {
            return new d();
        }
    }

    public d() {
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<ByteBuffer> a2(File r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        return new o.a(new com.bumptech.glide.e.d(r1), new a(r1));
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a<ByteBuffer> a(File r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(File r1) {
        return true;
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(File r3) {
        return a2((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"));
    }
}
