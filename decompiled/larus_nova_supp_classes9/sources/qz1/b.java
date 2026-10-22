package qz1;

import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftLabelTextView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ GiftLabelTextView a;
    public final /* synthetic */ Ref.LongRef b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public b(GiftLabelTextView r1, Ref.LongRef r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        Ref.LongRef r8 = this.b;
        long r0 = r8.element;
        if (r0 > 0) goto L7;
        GiftLabelTextView r9 = this.a;
        String r2 = this.c;
        String r3 = this.d;
        int r4 = GiftLabelTextView.c;
        r9.y(r0, r2, r3);
        Disposable r10 = this.a.a;
        if (r10 == null) goto L9;
        r10.dispose();
        return;
    L9:
        return;
    L7:
        long r1 = r0 - u0.g.a;
        r8.element = r1;
        GiftLabelTextView r11 = this.a;
        String r5 = this.c;
        String r13 = this.d;
        int r14 = GiftLabelTextView.c;
        r11.y(r1, r5, r13);
    }
}
