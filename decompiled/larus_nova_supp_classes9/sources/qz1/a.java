package qz1;

import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftLabelTextView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ GiftLabelTextView a;
    public final /* synthetic */ Ref.LongRef b;

    public a(GiftLabelTextView r1, Ref.LongRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        Ref.LongRef r8 = this.b;
        long r0 = r8.element;
        if (r0 > 0) goto L10;
        GiftLabelTextView r9 = this.a;
        int r2 = GiftLabelTextView.c;
        r9.x(r0);
        Function0<Unit> r10 = this.a.b;
        if (r10 == null) goto L7;
        Unit r11 = (Unit) r10.invoke();
    L7:
        Disposable r13 = this.a.a;
        if (r13 == null) goto L12;
        r13.dispose();
        return;
    L12:
        return;
    L10:
        long r1 = r0 - u0.g.a;
        r8.element = r1;
        GiftLabelTextView r14 = this.a;
        int r3 = GiftLabelTextView.c;
        r14.x(r1);
    }
}
