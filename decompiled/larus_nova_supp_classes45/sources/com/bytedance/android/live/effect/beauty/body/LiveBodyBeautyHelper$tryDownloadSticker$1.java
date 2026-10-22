package com.bytedance.android.live.effect.beauty.body;

import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/LiveSmallItemBeautyHelper$b;", "callback", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "", "invoke", "(Lcom/bytedance/android/live/effect/LiveSmallItemBeautyHelper$b;Lcom/bytedance/android/livesdkapi/depend/model/Sticker;)V", "notifyDownloadResultUiThread"}, k = 3, mv = {1, 4, 3})
final class LiveBodyBeautyHelper$tryDownloadSticker$1 extends Lambda implements Function2<LiveSmallItemBeautyHelper.b, Sticker, Unit> {
    final /* synthetic */ boolean $uiThread;

    public static final class a implements Runnable {
        public final /* synthetic */ Sticker a;
        public final /* synthetic */ LiveSmallItemBeautyHelper.b b;

        public a(Sticker r1, LiveSmallItemBeautyHelper.b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Sticker r0 = this.a;     // Catch: Throwable -> L11
            if (r0 == null) goto L7;
            LiveSmallItemBeautyHelper.b r1 = this.b;     // Catch: Throwable -> L11
            if (r1 == null) goto L16;
            r1.a(r0);     // Catch: Throwable -> L11
        L16:
            return;
        L7:
            LiveSmallItemBeautyHelper.b r2 = this.b;     // Catch: Throwable -> L11
            if (r2 == null) goto L16;
            r2.onError();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public LiveBodyBeautyHelper$tryDownloadSticker$1(boolean r1) {
        this.$uiThread = r1;
        super(2);
    }

    public final void invoke(LiveSmallItemBeautyHelper.b r3, Sticker r4) {
        if (this.$uiThread == false) goto L9;
        if (r4 == null) goto L7;
        if (r3 == null) goto L11;
        r3.a(r4);
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
        invoke((LiveSmallItemBeautyHelper.b) r1, (Sticker) r2);
        return Unit.INSTANCE;
    }
}
