package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/l$b;", "callback", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "", "invoke", "(Lcom/bytedance/android/live/effect/avadjust/l$b;Lcom/bytedance/android/livesdkapi/depend/model/Sticker;)V", "notifyDownloadResultUiThread"}, k = 3, mv = {1, 4, 3})
final class LiveColorAdjustHelper$tryDownloadSticker$1 extends Lambda implements Function2<l.b, Sticker, Unit> {
    final /* synthetic */ boolean $uiThread;

    public static final class a implements Runnable {
        public final /* synthetic */ Sticker a;
        public final /* synthetic */ l.b b;

        public a(Sticker r1, l.b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        L19:
            return;
        L3:
            if (this.a == null) goto L7;
            l.b r0 = this.b;     // Catch: Throwable -> L11
            if (r0 == null) goto L16;
            r0.onSuccess();     // Catch: Throwable -> L11
        L16:
            return;
        L7:
            l.b r1 = this.b;     // Catch: Throwable -> L11
            if (r1 == null) goto L16;
            r1.onError();     // Catch: Throwable -> L11
            goto L16
        }
    }

    public LiveColorAdjustHelper$tryDownloadSticker$1(boolean r1) {
        this.$uiThread = r1;
        super(2);
    }

    public final void invoke(l.b r3, Sticker r4) {
        if (this.$uiThread == false) goto L9;
        if (r4 == null) goto L7;
        if (r3 == null) goto L11;
        r3.onSuccess();
        return;
    L11:
        return;
    L7:
        if (r3 == null) goto L13;
        r3.onError();
        return;
    L13:
        return;
    L9:
        AndroidSchedulers.mainThread().scheduleDirect(new a(r4, r3));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((l.b) r1, (Sticker) r2);
        return Unit.INSTANCE;
    }
}
