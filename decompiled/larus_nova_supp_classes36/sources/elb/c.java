package elb;

import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements ObservableOnSubscribe {
    public final /* synthetic */ com.ss.android.lark.image.uploader.entity.b a;
    public final /* synthetic */ ImageUploadTask b;

    public c(com.ss.android.lark.image.uploader.entity.b r1, ImageUploadTask r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<com.ss.android.lark.image.uploader.entity.b> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        glb.b r0 = glb.b.a;
        com.ss.android.lark.image.uploader.entity.b r1 = this.a;
        r0.getClass();
        glb.b.e(r1);
        long r2 = System.currentTimeMillis();
        int r3 = blb.c.a;
        blb.c.c(this.a, this.b);
        com.ss.android.lark.image.uploader.entity.b r4 = this.a;
        r4.m = blb.c.a(r4.j, r4.a, r2);
        glb.b.f(this.a);
        r6.onNext(this.a);
        r6.onComplete();
    }
}
