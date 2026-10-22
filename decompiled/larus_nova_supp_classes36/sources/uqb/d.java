package uqb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements SingleOnSubscribe {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: uqb.d$a$a, reason: collision with other inner class name */
        public static final class C0333a implements uqb.a {
            public final /* synthetic */ SingleEmitter<c> a;

            public C0333a(SingleEmitter<c> r1) {
                this.a = r1;
            }

            @Override // uqb.a
            public final void a(c r3) {
                Intrinsics.checkNotNullParameter(r3, "templateInfo");
                int r0 = d.a;
                Log.i("TemplateManager", "onSuccess " + r3.c);
                this.a.onSuccess(r3);
            }

            @Override // uqb.a
            public final void onFailed(Throwable r3) {
                Intrinsics.checkNotNullParameter(r3, "throwable");
                int r0 = d.a;
                Log.w("TemplateManager", "onFailed", r3);
                if (this.a.isDisposed() == true) goto L6;
                this.a.onError(r3);
                return;
            }
        }

        public a(b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(SingleEmitter<c> r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            this.a.a(this.b, new C0333a(r4));
        }
    }

    static {
    }

    public static Single a(String r6, List r7) {
        Intrinsics.checkNotNullParameter(r6, "templatePath");
        Intrinsics.checkNotNullParameter(r7, "templateLoaders");
        int r0 = r7.size();
        Publisher[] r1 = new Publisher[r0];
        Iterator r8 = r7.iterator();
        int r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L10;
        Object r3 = r8.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r1[r2] = Single.create(new a((b) r3, r6)).toFlowable();
        r2 = r4;
        goto L4
    L10:
        return Flowable.concatArrayDelayError((Publisher[]) Arrays.copyOf(r1, r0)).subscribeOn(LarkRxSchedulers.io()).firstOrError().observeOn(LarkRxSchedulers.mainThread());
    }
}
