package com.bytedance.android.live.room.share.summersinging;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"onPermissionGranted", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class GroupPhotoShareLayoutViewHolder$trySaveImg$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0 $onFailure;
    final /* synthetic */ Function1 $onSuccess;
    final /* synthetic */ l this$0;

    public static final class a<V> implements Callable {
        public final /* synthetic */ GroupPhotoShareLayoutViewHolder$trySaveImg$1 a;
        public final /* synthetic */ Bitmap b;

        public a(GroupPhotoShareLayoutViewHolder$trySaveImg$1 r1, Bitmap r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.concurrent.Callable
        public final String call() {
            GroupPhotoShareLayoutViewHolder$trySaveImg$1 r0 = this.a;
            return com.bytedance.android.livesdk.share.g.d(r0.$context, this.b, r0.this$0.d.SD());
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GroupPhotoShareLayoutViewHolder$trySaveImg$1 a;

        public b(GroupPhotoShareLayoutViewHolder$trySaveImg$1 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            String r5 = (String) r4;
            if (r5 != null) goto L5;
        L12:
            ALogger.e("GroupPhotoShareLayoutViewHolder", "save bitmap error, url is null or empty");
            f2.b(2131917216, 0);
            Function0 r6 = this.a.$onFailure;
            if (r6 == null) goto L15;
            Unit r7 = (Unit) r6.invoke();
        L15:
            Disposable r8 = this.a.this$0.c;
            if (r8 == null) goto L18;
            r8.dispose();
        L18:
            this.a.this$0.b = false;
            return;
        L5:
            if (r5.length() <= 0) goto L7;
            boolean r1 = true;
        L8:
            if (r1 != true) goto L12;
            Function1 r2 = this.a.$onSuccess;
            if (r2 == null) goto L15;
            Unit r9 = (Unit) r2.invoke(r5);
            goto L15
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ GroupPhotoShareLayoutViewHolder$trySaveImg$1 a;

        public c(GroupPhotoShareLayoutViewHolder$trySaveImg$1 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            StringBuilder r0 = new StringBuilder("save bitmap error: ");
            if (r4 == null) goto L5;
            String r5 = r4.getMessage();
        L6:
            r0.append(r5);
            ALogger.e("GroupPhotoShareLayoutViewHolder", r0.toString());
            f2.b(2131917216, 0);
            Function0 r6 = this.a.$onFailure;
            if (r6 == null) goto L9;
            Unit r7 = (Unit) r6.invoke();
        L9:
            Disposable r8 = this.a.this$0.c;
            if (r8 == null) goto L12;
            r8.dispose();
        L12:
            this.a.this$0.b = false;
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public GroupPhotoShareLayoutViewHolder$trySaveImg$1(l r1, Context r2, Function1 r3, Function0 r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$onSuccess = r3;
        this.$onFailure = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1112invoke() {
        Bitmap r0 = com.bytedance.android.livesdk.share.g.a(this.this$0.d.fD());
        l r1 = this.this$0;
        r1.c = Single.fromCallable(new a(this, r0)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1112invoke();
        return Unit.INSTANCE;
    }
}
