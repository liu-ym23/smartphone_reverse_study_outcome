package com.bytedance.android.livesdk.jsbridge.methods.draft;

import android.content.Context;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements ObservableOnSubscribe {
    public final /* synthetic */ k a;
    public final /* synthetic */ b b;
    public final /* synthetic */ Context c;

    public static final class a implements jz.a {
        public final /* synthetic */ ObservableEmitter a;

        public a(ObservableEmitter r1) {
            this.a = r1;
        }
    }

    public j(k r1, f r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(ObservableEmitter<Integer> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        jz.f r0 = new jz.f();     // Catch: Exception -> L8
        String r1 = this.b.a();     // Catch: Exception -> L8
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");     // Catch: Exception -> L8
        r0.c = r1;     // Catch: Exception -> L8
        r0.d = 360000;     // Catch: Exception -> L8
        IHostBusiness r2 = this.a.a;     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L8
        r2.checkImportVideo(this.c, r0, new a(r5));     // Catch: Exception -> L8
        return;
    L7:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        r5.onError(e);
    }
}
