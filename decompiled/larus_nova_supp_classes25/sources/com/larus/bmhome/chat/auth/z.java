package com.larus.bmhome.chat.auth;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.auth.model.PluginItem;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z implements Function1 {
    public final /* synthetic */ PluginListFragment a;

    public /* synthetic */ z(PluginListFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r14) {
        PluginListFragment r0 = this.a;
        List r15 = (List) r14;
        int r1 = PluginListFragment.k;
        Intrinsics.checkNotNullParameter(r15, "it");
        PluginListAdapter r2 = r0.U90();
        List r16 = CollectionsKt.toMutableList(r15);
        ListProtector.add(r16, 0, new PluginItem(null, null, null, null, null, null, null, null, 255, null));
        r2.submitList(r16);
        return Unit.INSTANCE;
    }
}
