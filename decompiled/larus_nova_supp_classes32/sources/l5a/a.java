package l5a;

import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderRequest;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.animax.loader.AnimaXLoaderScheme;
import com.lynx.clay.embedding.engine.loader.ResourceLoaderCallback;
import com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl;
import u4a.i;
import u4a.k;
import u4a.l;
import u4a.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements k {
    public final ResourceLoaderImpl a;

    /* JADX INFO: renamed from: l5a.a$a, reason: collision with other inner class name */
    public class C0096a extends ResourceLoaderCallback {
        public final /* synthetic */ l a;

        @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderCallback
        public final void destroy() {
        }

        public C0096a(l r3) {
            this.a = r3;
            super(0);
        }

        @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderCallback
        public final void onFailed(String r4) {
            ((AnimaXLoaderCompletionHandler) this.a).a(AnimaXLoaderResponse.b(new Throwable("LottieLoader failed with error: " + r4)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderCallback
        public final void onSucceeded(byte[] r2) {
            if (r2 == null) goto L4;
            AnimaXLoaderResponse r3 = AnimaXLoaderResponse.a(r2);
        L5:
            ((AnimaXLoaderCompletionHandler) this.a).a(r3);
            return;
        L4:
            r3 = AnimaXLoaderResponse.b(new Throwable("Failed to load raw data with LottieLoader"));
            goto L5
        }
    }

    public a() {
        this.a = ResourceLoaderImpl.create();
    }

    @Override // u4a.k
    public final AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.HTTP;
    }

    @Override // u4a.k
    public final void a(m r7, l r8) {
        AnimaXLoaderRequest r9 = (AnimaXLoaderRequest) r7;
        String r2 = r9.b();
        if (r9.a() == null) goto L6;
        i.a(new AnimaXLoaderRequest(r2, r9.c), r8);
        return;
    L6:
        C0096a r3 = new C0096a(r8);
        this.a.load(2, r2, r3, false, false);
    }
}
