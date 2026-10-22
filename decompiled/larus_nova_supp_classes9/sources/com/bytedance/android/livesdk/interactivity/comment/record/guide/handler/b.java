package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import com.ss.android.socialbase.downloader.exception.BaseException;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements ObservableOnSubscribe {
    public final /* synthetic */ List a;

    public static final class a implements e72.b.InterfaceC0228b {
        public final /* synthetic */ ObservableEmitter a;

        public a(ObservableEmitter r1) {
            this.a = r1;
        }

        @Override // e72.b.InterfaceC0228b
        public final void onProgress(int r2) {
            this.a.onNext(Integer.valueOf((r2 * 90) / 100));
        }

        @Override // e72.b.InterfaceC0228b
        public final void onSuccess(List<Pair<String, String>> r2) {
            Intrinsics.checkNotNullParameter(r2, "downloadPairList");
            this.a.onComplete();
        }

        @Override // e72.b.InterfaceC0228b
        public final void a(List<Pair<String, String>> r2, BaseException r3) {
            Intrinsics.checkNotNullParameter(r2, "downloadPairList");
            ObservableEmitter r4 = this.a;
            if (r3 != null) goto L6;
            r3 = new RuntimeException("download failed.");
        L6:
            r4.onError(r3);
        }
    }

    public b(List r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<Integer> r4) {
        Intrinsics.checkNotNullParameter(r4, "emitter");
        e72.b r0 = new e72.b(this.a, new a(r4));
        if (r0.a == true) goto L7;
        r0.a = true;
        r0.a();
        return;
    }
}
