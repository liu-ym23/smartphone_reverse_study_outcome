package z60;

import com.bytedance.android.live.core.setting.d6;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends a {
    public d() {
    }

    @Override // z60.a
    public final void a(Map<String, ? extends Object> r3, Map<String, ? extends Object> r4) {
        Map<String, Long> r0 = a70.b.a;
        StringBuilder r1 = new StringBuilder("添加数据为：");
        Integer r2 = null;
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        r1.append(r5);
        r1.append("，删除数据长度为：");
        if (r3 == null) goto L9;
        r2 = Integer.valueOf(r3.size());
    L9:
        r1.append(r2);
        String r6 = r1.toString();
        Intrinsics.checkNotNullParameter(r6, "msg");
        if (a70.b.c("_MAIN", r6) == false) goto L13;
        d6.c("SettingReportMonitor", r6);
        return;
    L13:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // z60.a
    public final void b(boolean r9, boolean r11, Map<String, ? extends Object> r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r12, "deleteMap");
        Intrinsics.checkNotNullParameter(r13, "updateOrAdd");
        int r1 = !r9 ? 1 : 0;
        if (r11 == false) goto L5;
        String r14 = "full";
    L6:
        a70.c.a(r1, r14, "frontier", a70.b.b(), r13.size(), r12.size(), "update数据");
        return;
    L5:
        r14 = "incr";
        goto L6
    }
}
