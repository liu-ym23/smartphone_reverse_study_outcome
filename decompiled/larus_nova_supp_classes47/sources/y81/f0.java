package y81;

import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.incentiveinfo.model.BizStatus;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0<T> implements Consumer {
    public final /* synthetic */ d0 a;

    public f0(d0 r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        d0 r6 = (d0) r5;
        TextSwitcher r7 = this.a.Q;
        View r0 = null;
        if (r7 == null) goto L5;
        View r8 = r7.getCurrentView();
    L7:
        if ((r8 instanceof TextView) == false) goto L10;
        r0 = r8;
    L10:
        TextView r1 = (TextView) r0;
        if (r1 == null) goto L14;
        r1.setTextColor(s1.h(2131101254));
    L14:
        if (this.a.Z != BizStatus.END.getValue()) goto L17;
        this.a.m();
        return;
    L17:
        return;
    L5:
        r8 = null;
        goto L7
    }
}
