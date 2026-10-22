package com.bytedance.android.live.profile.seeselftransition;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements ObservableOnSubscribe {
    public final /* synthetic */ String a;

    public static final class a implements OfflineResourceClient.a {
        public final /* synthetic */ f a;
        public final /* synthetic */ ObservableEmitter b;

        public final void onError(Throwable r3) {
            StringBuilder r0 = new StringBuilder("load file: ");
            r0.append(this.a.a);
            r0.append(" error: ");
            if (r3 == null) goto L5;
            String r4 = r3.getMessage();
        L6:
            r0.append(r4);
            ALogger.e("TransitionDialogManager", r0.toString());
            this.b.onNext(sh6.a.a);
            this.b.onComplete();
            return;
        L5:
            r4 = null;
            goto L6
        }

        public final void onSuccess(String r2) {
            this.b.onNext(sh6.c.a(r2));
            this.b.onComplete();
        }

        public a(f r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public f(String r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<sh6.b<String>> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        String r0 = this.a;
        a r1 = new a(this, r3);
        String r4 = i2.a;
        Intrinsics.checkNotNullParameter(r0, "key");
        Intrinsics.checkNotNullParameter(r1, "callback");
        boolean r5 = OfflineResourceClient.a;
        OfflineResourceClient.c(i2.b(r0), r1);
    }
}
