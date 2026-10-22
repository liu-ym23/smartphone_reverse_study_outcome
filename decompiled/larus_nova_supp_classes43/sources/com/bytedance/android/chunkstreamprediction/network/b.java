package com.bytedance.android.chunkstreamprediction.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b<T> {
    public final j a;
    public InterfaceC0111b<T> b;
    public final List<com.bytedance.android.chunkstreamprediction.network.a<T>> c;

    public class a implements com.bytedance.android.chunkstreamprediction.network.a<T> {
        public final /* synthetic */ com.bytedance.android.chunkstreamprediction.network.a a;
        public final /* synthetic */ b b;

        @Override // com.bytedance.android.chunkstreamprediction.network.a
        public final void onComplete() {
            Iterator r0 = ((ArrayList) this.b.c).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.chunkstreamprediction.network.a) r0.next()).onComplete();
            goto L4
        L6:
            this.a.onComplete();
        }

        @Override // com.bytedance.android.chunkstreamprediction.network.a
        public final void onFailed(Throwable r10) {
            HashMap r0 = new HashMap();
            this.b.getClass();
            ChunkDataException r1 = new ChunkDataException(r10, r0);
            Iterator r11 = ((ArrayList) this.b.c).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((com.bytedance.android.chunkstreamprediction.network.a) r11.next()).onFailed(r1);
            goto L4
        L6:
            this.a.onFailed(r1);
        }

        @Override // com.bytedance.android.chunkstreamprediction.network.a
        public final void onNext(T r10) {
            Iterator r0 = ((ArrayList) this.b.c).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.chunkstreamprediction.network.a) r0.next()).onNext(r10);
            goto L4
        L6:
            this.a.onNext(r10);
        }

        public a(b r1, com.bytedance.android.chunkstreamprediction.network.a r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.chunkstreamprediction.network.b$b, reason: collision with other inner class name */
    public interface InterfaceC0111b<T> {
        void call(b<T> r1, com.bytedance.android.chunkstreamprediction.network.a<T> r10);
    }

    public b(InterfaceC0111b<T> r10) {
        this.a = new j();
        this.c = new ArrayList();
        this.b = r10;
    }

    public final void a(com.bytedance.android.chunkstreamprediction.network.a<T> r10) {
        if (this.b == null) goto L5;
        this.a.getClass();
        this.b.call(this, new a(this, r10));
    L5:
        this.b = null;
    }
}
