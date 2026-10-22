package com.bytedance.android.livesdk.gift.fastgift;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g0 implements ToolbarComponentCheckInterface {
    public final /* synthetic */ ToolbarFastGiftBehavior a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ g0 a;
        public final /* synthetic */ Function0 b;

        public a(g0 r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L9;
            ALogger.i("NewToolbarLog", "[fastGift] loadToolbarFastGift onNext, call loadButton()");
            Disposable r3 = this.a.a.e;
            if (r3 == null) goto L7;
            r3.dispose();
        L7:
            this.b.invoke();
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            ALogger.i("NewToolbarLog", "[fastGift] loadToolbarFastGift onError, call loadButton()");
            this.a.invoke();
        }
    }

    public g0(ToolbarFastGiftBehavior r1) {
        this.a = r1;
    }

    public final boolean checkThenLoad(ToolbarMatchInterface r3, Function0<Unit> r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "loadButton");
        Intrinsics.checkNotNullParameter(r5, "stopLoadCallback");
        ALogger.i("NewToolbarLog", "[fastGift] checkThenLoad() method called");
        FragmentActivity r6 = ToolbarFastGiftBehavior.w(this.a);
        if (r6 == null) goto L7;
        FastGiftViewModel r7 = (FastGiftViewModel) ViewModelProviders.of(r6).get(FastGiftViewModel.class);
        r7.bindCurrentRoom(this.a.g.getDataCenter(), this.a.g.getRoom());
        ToolbarFastGiftBehavior r8 = this.a;
        r8.e = r7.getLoadToolbarFastGift().observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r4), new b(r4));
        return true;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }
}
