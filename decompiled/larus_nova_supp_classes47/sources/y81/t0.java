package y81;

import android.widget.TextSwitcher;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t0<T> implements Consumer {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ String b;

    public t0(d0 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        long r0 = System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN);
        d0 r9 = this.a;
        long r2 = r9.f0 - r0;
        if (r2 <= 0) goto L10;
        long r1 = 60;
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        String r12 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r2 / r1), Long.valueOf(r2 % r1)}, 2));
        TextSwitcher r3 = this.a.Q;
        if (r3 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r3);
    L7:
        TextSwitcher r4 = this.a.Q;
        if (r4 == null) goto L18;
        r4.setCurrentText(r12);
        return;
    L18:
        return;
    L10:
        TextSwitcher r13 = r9.Q;
        if (r13 == null) goto L13;
        r13.setCurrentText(this.b);
    L13:
        Disposable r14 = this.a.z;
        if (r14 == null) goto L16;
        r14.dispose();
    L16:
        this.a.z = null;
    }
}
