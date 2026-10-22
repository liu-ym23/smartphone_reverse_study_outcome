package rs8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.BaseTextAnswerActionButton;
import com.larus.bmhome.view.f2;
import com.larus.bmhome.view.h4;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x {
    public static final g b(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r2 = r1.getTag(2131385961);
        if ((r2 instanceof g) == true) goto L7;
        return null;
    L7:
        return (g) r2;
    }

    public static final int c(String r2, Map<String, Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "actionbarPriorityIndex");
        int r0 = r2.hashCode();
        if (r0 == (-1772571018)) goto L17;
        if (r0 == (-1287261771)) goto L13;
        if (r0 != (-1287190283)) goto L21;
        if (r2.equals("regen_prev") == false) goto L21;
    L15:
        r2 = "switch-regenerate";
    L21:
        if (r2.length() != 0) goto L23;
        boolean r1 = true;
    L25:
        if (r1 == false) goto L27;
        return Integer.MAX_VALUE;
    L27:
        LinkedHashMap r4 = (LinkedHashMap) r3;
        Integer r5 = (Integer) r4.get(r2);
        if (r5 != null) goto L33;
        r5 = (Integer) r4.get("others");
        if (r5 != null) goto L33;
        return Integer.MAX_VALUE;
    L33:
        return r5.intValue();
    L23:
        r1 = false;
        goto L25
    L13:
        if (r2.equals("regen_next") == true) goto L15;
    L17:
        if (r2.equals("switch_group_msg") == false) goto L21;
        r2 = "crowd-test-switch";
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(boolean r25, Context r26, List r27, List r28, ViewGroup r29, boolean r30, boolean r31) {
        Intrinsics.checkNotNullParameter(r26, "context");
        Intrinsics.checkNotNullParameter(r27, "newActions");
        Intrinsics.checkNotNullParameter(r28, "oldActions");
        Intrinsics.checkNotNullParameter(r29, "viewContainer");
        FLogger r15 = FLogger.a;
        StringBuilder r10 = new StringBuilder();
        r10.append("oldActions: " + CollectionsKt.joinToString$default(r28, null, "[", "]", 0, null, new v(), 25, null));
        r10.append('\n');
        r10.append("newActions: " + CollectionsKt.joinToString$default(r27, null, "[", "]", 0, null, new w(), 25, null));
        r10.append('\n');
        Unit r2 = Unit.INSTANCE;
        r15.i("MessageActionBar_DIFF", r10.toString());
        ArrayList r0 = (ArrayList) r28;
        int r3 = Math.min(r0.size(), r27.size());
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L23;
        g r5 = (g) ListProtector.get(r0, r4);
        g r6 = (g) ListProtector.get(r27, r4);
        if (r5.getId() == r6.getId()) goto L8;
    L18:
        BaseTextAnswerActionButton r7 = h4.a(r6, r26);
        r7.a(r6, r30, r31);
        r29.removeViewAt(r4);
        ViewGroup r8 = r7.getRoot();
        r29.addView(r8, r4);
        if (r25 == false) goto L21;
        r8.setTag(2131385961, r6);
    L21:
        r4 = r4 + 1;
        goto L4
    L8:
        if (r5.getClass() != r6.getClass()) goto L18;
        View r9 = r29.getChildAt(r4);
        if ((r9 instanceof f2) == false) goto L12;
        f2 r11 = (f2) r9;
    L13:
        if (r11 == null) goto L15;
        r11.a(r6, r30, r31);
    L15:
        if (r25 == false) goto L21;
        r9.setTag(2131385961, r6);
        goto L21
    L12:
        r11 = null;
        goto L13
    L23:
        if (r0.size() <= r27.size()) goto L30;
        int r1 = r0.size() - 1;
        int r12 = r27.size();
        if (r12 > r1) goto L37;
    L26:
        r29.removeViewAt(r1);
        if (r1 == r12) goto L47;
        r1 = r1 - 1;
        goto L26
    L47:
        return;
    L37:
        return;
    L30:
        if (r0.size() >= r27.size()) goto L46;
        int r13 = r0.size();
        int r14 = r27.size();
    L32:
        if (r13 >= r14) goto L48;
        g r16 = (g) ListProtector.get(r27, r13);
        BaseTextAnswerActionButton r17 = h4.a(r16, r26);
        r17.a(r16, r30, r31);
        ViewGroup r18 = r17.getRoot();
        r29.addView(r18);
        if (r25 == false) goto L36;
        r18.setTag(2131385961, r16);
    L36:
        r13 = r13 + 1;
        goto L32
    L48:
        return;
    }
}
