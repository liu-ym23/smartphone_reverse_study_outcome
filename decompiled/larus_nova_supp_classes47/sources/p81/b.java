package p81;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.room.api.view.SimpleIndicatorTextSwitcher2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ SimpleIndicatorTextSwitcher2 a;
    public final /* synthetic */ Function1 b;

    public b(SimpleIndicatorTextSwitcher2 r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        ArrayList<d> r0 = this.a.b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L18;
        this.a.setCurrentIndex(((int) r5.longValue()) % this.a.b.size());
        SimpleIndicatorTextSwitcher2 r6 = this.a;
        d r2 = (d) ListProtector.get(r6.b, r6.getCurrentIndex());
        if (r2 == null) goto L15;
        String r3 = r2.a;
        if (r3 == null) goto L15;
    L16:
        r6.setText(r3);
        UtilityKotlinExtentionsKt.w(this.a);
        this.b.invoke(Integer.valueOf(this.a.getCurrentIndex()));
        return;
    L15:
        r3 = "";
        goto L16
    L18:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
