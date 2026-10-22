package oab;

import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.custom.repeat.ChooseRepeatFragment;
import com.ss.android.lark.custom.repeat.entity.RruleListItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class c implements AdapterView.OnItemClickListener {
    public long a;

    public c() {
        this.a = 0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r6, View r7, int r8, long r9) {
        long r10 = SystemClock.uptimeMillis();
        if ((r10 - this.a) <= 1000) goto L11;
        com.ss.android.lark.custom.repeat.f r0 = (com.ss.android.lark.custom.repeat.f) this;
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "view");
        ChooseRepeatFragment r11 = r0.b;
        if (r11.e == r8) goto L9;
        r11.e = r8;
        mab.e r12 = r11.f;
        if (r12 == null) goto L9;
        r12.notifyDataSetChanged();
    L9:
        ChooseRepeatFragment r13 = r0.b;
        ChooseRepeatFragment.S90(r13, ((RruleListItem) ListProtector.get(r13.g, r13.e)).getRrule());
        this.a = r10;
        return;
    }
}
