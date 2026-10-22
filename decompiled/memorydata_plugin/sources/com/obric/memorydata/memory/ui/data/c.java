package com.obric.memorydata.memory.ui.data;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.utils.ba;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\"\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItemViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "currentMemoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "getCurrentMemoryItem", "()Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "setCurrentMemoryItem", "(Lcom/obric/memorydata/memory/ui/data/MemoryItem;)V", "trackClick", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "reaction", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$ReactionType;", "trackShow", "currentPage", "", "previousPage", "bind", "memoryItem", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class c extends RecyclerView.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f10794a;

    public c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    public static /* synthetic */ void a(c r0, AppEntity r1, String r2, String r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.a(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackShow");
    }

    public a a() {
        return this.f10794a;
    }

    public final void a(AppEntity r4, MemoryEventTracker.ReactionType r5) {
        Intrinsics.checkNotNullParameter(r4, "appEntity");
        Intrinsics.checkNotNullParameter(r5, "reaction");
        MemoryEventTracker r0 = MemoryEventTracker.f10515a;
        int r6 = r5.getValue();
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "getContext(...)");
        Activity r7 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r3), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, BaseMemoryActivity.class) == false) goto L5;
        BaseMemoryActivity r8 = (BaseMemoryActivity) ZeusTransformUtils.preCheckCast(r7, BaseMemoryActivity.class, "com.obric.memorydata.plugin");
    L6:
        if (r8 == null) goto L9;
        String r9 = r8.getEnterFrom();
        if (r9 == null) goto L9;
    L10:
        r0.a(r4, r6, r9);
        return;
    L9:
        r9 = "";
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    public final void a(AppEntity r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "appEntity");
        Intrinsics.checkNotNullParameter(r13, "currentPage");
        MemoryEventTracker r1 = MemoryEventTracker.f10515a;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r11, "getContext(...)");
        Activity r15 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r11), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, BaseMemoryActivity.class) == false) goto L5;
        BaseMemoryActivity r16 = (BaseMemoryActivity) ZeusTransformUtils.preCheckCast(r15, BaseMemoryActivity.class, "com.obric.memorydata.plugin");
    L6:
        if (r16 == null) goto L9;
        String r17 = r16.getEnterFrom();
        if (r17 == null) goto L9;
    L10:
        MemoryEventTracker.a(r1, r12, r17, r13, r14, null, null, null, 112, null);
        return;
    L9:
        r17 = "";
        goto L10
    L5:
        r16 = null;
        goto L6
    }

    public void a(a r1) {
        this.f10794a = r1;
    }

    public void b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "memoryItem");
        a(r2);
    }
}
