package com.obric.memorydata.recommend.ui.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/ShieldContentDiffCallback;", "Lcom/obric/oui/orecyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i extends com.obric.oui.orecyclerview.widget.i.e<a> {
    public i() {
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(a r4, a r5) {
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        if (ZeusTransformUtils.instanceOf(r4, a.c.class) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r5, a.c.class) == false) goto L9;
        String r3 = ((a.c) ZeusTransformUtils.preCheckCast(r4, a.c.class, "com.obric.memorydata.plugin")).a();
        String r6 = ((a.c) ZeusTransformUtils.preCheckCast(r5, a.c.class, "com.obric.memorydata.plugin")).a();
    L21:
        return Intrinsics.areEqual(r3, r6);
    L9:
        if (ZeusTransformUtils.instanceOf(r4, a.b.class) == false) goto L14;
        if (ZeusTransformUtils.instanceOf(r5, a.b.class) == false) goto L14;
        r3 = ((a.b) ZeusTransformUtils.preCheckCast(r4, a.b.class, "com.obric.memorydata.plugin")).a();
        r6 = ((a.b) ZeusTransformUtils.preCheckCast(r5, a.b.class, "com.obric.memorydata.plugin")).a();
    L14:
        if (ZeusTransformUtils.instanceOf(r4, a.C0686a.class) == true) goto L16;
        return false;
    L16:
        if (ZeusTransformUtils.instanceOf(r5, a.C0686a.class) == true) goto L18;
        return false;
    L18:
        if (((a.C0686a) ZeusTransformUtils.preCheckCast(r4, a.C0686a.class, "com.obric.memorydata.plugin")).a().getId() != ((a.C0686a) ZeusTransformUtils.preCheckCast(r5, a.C0686a.class, "com.obric.memorydata.plugin")).a().getId()) goto L24;
        return true;
    L24:
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.i.e
    public /* synthetic */ boolean a(a r3, a r4) {
        return a2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public boolean b2(a r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "oldItem");
        Intrinsics.checkNotNullParameter(r3, "newItem");
        if (ZeusTransformUtils.instanceOf(r2, a.c.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r3, a.c.class) == false) goto L8;
        return Intrinsics.areEqual(((a.c) ZeusTransformUtils.preCheckCast(r2, a.c.class, "com.obric.memorydata.plugin")).a(), ((a.c) ZeusTransformUtils.preCheckCast(r3, a.c.class, "com.obric.memorydata.plugin")).a());
    L8:
        if (ZeusTransformUtils.instanceOf(r2, a.b.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, a.b.class) == false) goto L13;
    L20:
        return Intrinsics.areEqual(r2, r3);
    L13:
        if (ZeusTransformUtils.instanceOf(r2, a.C0686a.class) == true) goto L15;
    L17:
        return false;
    L15:
        if (ZeusTransformUtils.instanceOf(r3, a.C0686a.class) == false) goto L17;
        goto L17
    }

    @Override // com.obric.oui.orecyclerview.widget.i.e
    public /* synthetic */ boolean b(a r3, a r4) {
        return b2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin"));
    }
}
