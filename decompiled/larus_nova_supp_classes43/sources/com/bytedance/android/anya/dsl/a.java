package com.bytedance.android.anya.dsl;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.AnyaDSL;
import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@AnyaDSL
public final class a<STATE extends MVIState<?>, ACTION extends p> {
    public final List<b<STATE, ?, ?>> a;

    public a() {
        this.a = new ArrayList();
    }

    public final void a(Function2 r10, Function2 r11, RecyclerView r12, Function1 r13) {
        List<b<STATE, ?, ?>> r0 = this.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new b(r10, r11, r12, r13));
    }

    public static /* synthetic */ void b(a r1, final BaseMVIView r10, Function2 r11, Function2 r12, RecyclerView r13) {
        r1.a(r11, r12, r13, new MVIListAdapterDSLRegistry$register$1(r10));
    }
}
