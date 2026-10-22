package com.bumptech.glide.load.resource.a;

import com.bumptech.glide.load.data.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class a implements e<ByteBuffer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f823a;

    /* JADX INFO: renamed from: com.bumptech.glide.load.resource.a.a$a, reason: collision with other inner class name */
    public static class C0067a implements e.a<ByteBuffer> {
        public C0067a() {
        }

        @Override // com.bumptech.glide.load.data.e.a
        public /* synthetic */ e<ByteBuffer> a(ByteBuffer r3) {
            return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public e<ByteBuffer> a2(ByteBuffer r1) {
            return new a(r1);
        }

        @Override // com.bumptech.glide.load.data.e.a
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer r1) {
        this.f823a = r1;
    }

    @Override // com.bumptech.glide.load.data.e
    public /* synthetic */ ByteBuffer a() {
        return c();
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
    }

    public ByteBuffer c() {
        this.f823a.position(0);
        return this.f823a;
    }
}
