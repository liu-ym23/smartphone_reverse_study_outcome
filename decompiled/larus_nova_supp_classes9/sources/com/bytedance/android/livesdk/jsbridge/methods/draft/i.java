package com.bytedance.android.livesdk.jsbridge.methods.draft;

import android.content.Context;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements ObservableOnSubscribe {
    public final /* synthetic */ k a;
    public final /* synthetic */ b b;
    public final /* synthetic */ Context c;

    public static final class a implements jz.b {
        public final /* synthetic */ ObservableEmitter a;

        public a(ObservableEmitter r1) {
            this.a = r1;
        }
    }

    public i(k r1, f r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(ObservableEmitter<Integer> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        int r0 = c.b;     // Catch: Exception -> L5
        b r1 = this.b;     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r1, "draft");     // Catch: Exception -> L5
        jz.f r2 = new c(r1).a();     // Catch: Exception -> L5
        IHostBusiness r3 = this.a.a;     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L5
        r3.publishVideo(this.c, r2, new a(r5));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r5.onError(e);
    }
}
