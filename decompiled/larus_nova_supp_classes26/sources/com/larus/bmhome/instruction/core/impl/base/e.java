package com.larus.bmhome.instruction.core.impl.base;

import com.larus.bmhome.actionbar.model.u;
import cq8.y;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ a0 a(e r6, u r7, c r8, Function1 r9) {
            return r6.k(r7, r8, r9, null, null);
        }
    }

    boolean a();

    String f();

    String g();

    int getType();

    String getWidgetId();

    void h(Integer r1);

    void i(String r1, boolean r2);

    void j();

    a0 k(u r1, c r2, Function1<? super y, Unit> r3, e r4, String r5);

    void l(Map<String, ?> r1);

    void m(y r1);

    a0 n(String r1);
}
