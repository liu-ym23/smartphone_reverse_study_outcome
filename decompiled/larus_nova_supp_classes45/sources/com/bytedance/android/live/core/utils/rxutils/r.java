package com.bytedance.android.live.core.utils.rxutils;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r<T> implements ObservableOnSubscribe {
    public final /* synthetic */ DataCenter a;
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;

    public static final class a implements ttc.c {
        public final /* synthetic */ r a;
        public final /* synthetic */ Observer b;

        public a(r r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void cancel() {
            this.a.a.removeObserver(this.b);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ r a;
        public final /* synthetic */ ObservableEmitter b;

        public b(r r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            this.a.b.invoke(this.b, ((KVData) r3).getData());
        }
    }

    public r(DataCenter r1, Function2 r2, String r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void subscribe(ObservableEmitter<Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        b r0 = new b(this, r5);
        this.a.observeForever(this.c, r0, this.d);
        r5.setCancellable(new a(this, r0));
    }
}
