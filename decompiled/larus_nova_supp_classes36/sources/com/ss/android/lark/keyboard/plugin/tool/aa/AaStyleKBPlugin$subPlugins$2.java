package com.ss.android.lark.keyboard.plugin.tool.aa;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.aa.subplugins.a;
import com.ss.android.lark.keyboard.plugin.tool.aa.subplugins.b;
import com.ss.android.lark.keyboard.plugin.tool.aa.subplugins.c;
import com.ss.android.lark.keyboard.plugin.tool.aa.subplugins.d;
import com.ss.android.lark.keyboard.plugin.tool.aa.subplugins.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/keyboard/plugin/tool/aa/subplugins/BaseTextStylePlugin;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class AaStyleKBPlugin$subPlugins$2 extends Lambda implements Function0<List<? extends a>> {
    final /* synthetic */ AaStyleKBPlugin this$0;

    public AaStyleKBPlugin$subPlugins$2(AaStyleKBPlugin r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final List<a> m1129invoke() {
        this.this$0.getClass();
        List r0 = CollectionsKt.listOf(new Pair[]{TuplesKt.to(new b(), Reflection.getOrCreateKotlinClass(b.class).getSimpleName()), TuplesKt.to(new c(), Reflection.getOrCreateKotlinClass(c.class).getSimpleName()), TuplesKt.to(new d(), Reflection.getOrCreateKotlinClass(d.class).getSimpleName()), TuplesKt.to(new f(), Reflection.getOrCreateKotlinClass(f.class).getSimpleName())});
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add((a) ((Pair) r2.next()).getFirst());
        goto L4
    L6:
        return r1;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1129invoke();
    }
}
