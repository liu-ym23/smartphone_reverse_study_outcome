package ld;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements ObservableOnSubscribe<sh6.b<Object>> {
    public final /* synthetic */ NextLiveData a;
    public final /* synthetic */ boolean b;

    public static final class a implements ttc.c {
        public final /* synthetic */ b a;
        public final /* synthetic */ Observer b;

        public a(b r1, C0178b r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void cancel() {
            this.a.a.removeObserver(this.b);
        }
    }

    /* JADX INFO: renamed from: ld.b$b, reason: collision with other inner class name */
    public static final class C0178b<T> implements Observer {
        public final /* synthetic */ ObservableEmitter a;

        public C0178b(ObservableEmitter r1) {
            this.a = r1;
        }

        public final void onChanged(T r10) {
            if (r10 == null) goto L4;
            this.a.onNext(new sh6.d(r10));
            return;
        L4:
            this.a.onNext(sh6.a.a);
        }
    }

    public final void subscribe(ObservableEmitter<sh6.b<Object>> r10) {
        Intrinsics.checkNotNullParameter(r10, "emitter");
        C0178b r0 = new C0178b(r10);
        r10.setCancellable(new a(this, r0));
        this.a.observeForever(r0, this.b);
    }

    public b(NextLiveData<Object> r1, boolean r10) {
        this.a = r1;
        this.b = r10;
    }
}
