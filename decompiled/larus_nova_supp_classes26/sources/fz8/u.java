package fz8;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.chat.job.impl.ui.ChatJobTimePickerViewKt$createTimeWheelColumn$2$1;
import com.larus.chat.job.impl.ui.TimeWheelAdapter;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u {
    public static final RecyclerView a(Context r15, List r16, Object r17, boolean r18, int r19, ViewGroup.LayoutParams r20, int r21, float r22, Function1 r23, final Function1 r24) {
        Integer r1 = Integer.valueOf(r16.indexOf(r17));
        if (r1.intValue() < 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        final int r3 = r1.intValue();
    L13:
        if (r18 == true) goto L15;
    L18:
        final TimeWheelAdapter r4 = new TimeWheelAdapter(r16, r3, r18, r19, r22, gz8.g.b(r15), gz8.g.c(r15), r23);
        final LinearLayoutManager r6 = new LinearLayoutManager(r15, 1, false);
        final LinearSnapHelper r5 = new LinearSnapHelper();
        RecyclerView r7 = new RecyclerView(r15);
        r7.setLayoutManager(r6);
        r7.setAdapter(r4);
        r7.setItemAnimator(null);
        r7.setOverScrollMode(2);
        r7.setClipToPadding(false);
        r7.setPadding(0, r21, 0, r21);
        r7.setLayoutParams(r20);
        r5.attachToRecyclerView(r7);
        r7.addOnScrollListener(new ChatJobTimePickerViewKt$createTimeWheelColumn$2$1(r5, r4, r24));
        r7.post(new t(r6, r3, r4));
        return r7;
    L15:
        if (r16.size() <= 1) goto L18;
        r3 = r3 + (1073741823 - (1073741823 % r16.size()));
        goto L18
    L12:
        r3 = 0;
        goto L13
    L5:
        r2 = false;
        goto L7
    }
}
