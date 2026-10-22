package com.bytedance.android.anya.dsl;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.AnyaDSL;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIRecyclerViewAdapter;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.i0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.t0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@AnyaDSL
public final class b<SUPER_STATE extends MVIState<?>, ITEM_STATE extends MVIState<?>, ITEM_ACTION extends p> {
    public final Function2<i0<SUPER_STATE>, SUPER_STATE, t0<SUPER_STATE, ITEM_STATE>> a;
    public final Function2<ViewGroup, Integer, BaseMVIListItem<ITEM_STATE, ?>> b;
    public final RecyclerView c;
    public final Function1<Function2<? super ViewGroup, ? super Integer, ? extends BaseMVIListItem<ITEM_STATE, ITEM_ACTION>>, MVIRecyclerViewAdapter<ITEM_STATE>> d;

    public b(Function2 r1, Function2 r10, RecyclerView r11, Function1 r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
