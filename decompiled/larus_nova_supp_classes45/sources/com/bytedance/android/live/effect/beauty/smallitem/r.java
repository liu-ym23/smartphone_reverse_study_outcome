package com.bytedance.android.live.effect.beauty.smallitem;

import android.os.Handler;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements LiveSmallItemBeautyHelper.b {
    public final /* synthetic */ LiveSmallItemBeautyAdapter a;

    public static final class a implements Runnable {
        public final /* synthetic */ r a;

        public a(r r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.notifyDataSetChanged();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
    public final void onError() {
    }

    public r(LiveSmallItemBeautyAdapter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
    public final void a(Sticker r2) {
        Intrinsics.checkNotNullParameter(r2, "sticker");
        ((Handler) this.a.f.getValue()).post(new a(this));
    }
}
