package com.obric.memorydata.memory.ui.detail;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.memory.ui.data.MemoryItemType;
import com.obric.memorydata.memory.ui.list.MemoryListItemViewHolder;
import com.obric.memorydata.ui.recyclerview.OuiPagingDataAdapter;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryCorrelationAdapter;", "Lcom/obric/memorydata/ui/recyclerview/OuiPagingDataAdapter;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "Lcom/obric/memorydata/memory/ui/data/MemoryItemViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryCorrelationAdapter extends OuiPagingDataAdapter<com.obric.memorydata.memory.ui.data.a, com.obric.memorydata.memory.ui.data.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f10815a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryCorrelationAdapter$Companion;", "", "<init>", "()V", "DiffCallback", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryCorrelationAdapter$Companion$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class DiffCallback extends DiffUtil.ItemCallback<com.obric.memorydata.memory.ui.data.a> {
            public DiffCallback() {
            }

            /* JADX INFO: renamed from: areContentsTheSame, reason: avoid collision after fix types in other method */
            public boolean areContentsTheSame2(com.obric.memorydata.memory.ui.data.a r8, com.obric.memorydata.memory.ui.data.a r9) {
                Intrinsics.checkNotNullParameter(r8, "oldItem");
                Intrinsics.checkNotNullParameter(r9, "newItem");
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L17;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L17;
                if (Intrinsics.areEqual(((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getId(), ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getId()) == false) goto L72;
                if (((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getLastModifiedTime() != ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getLastModifiedTime()) goto L72;
                if (((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).c() != ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).c()) goto L72;
                if (((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).d() != ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).d()) goto L72;
                return true;
            L72:
                return false;
            L17:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L26;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L26;
                if (((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getId() != ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getId()) goto L72;
                if (((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getModifyTime() != ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getModifyTime()) goto L72;
                return true;
            L26:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L37;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L37;
                if (((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getId() != ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getId()) goto L72;
                if (((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getModifyTime() != ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getModifyTime()) goto L72;
                if (((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().d() != ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().d()) goto L72;
                return true;
            L37:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L46;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L46;
                if (Intrinsics.areEqual(((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getId(), ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getId()) == false) goto L72;
                if (((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getLastModifiedTime() != ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getLastModifiedTime()) goto L72;
                return true;
            L46:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.j.class) == false) goto L52;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.j.class) == false) goto L52;
                Object r7 = ((com.obric.memorydata.memory.ui.data.a.j) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.j.class, "com.obric.memorydata.plugin")).b();
                Object r10 = ((com.obric.memorydata.memory.ui.data.a.j) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.j.class, "com.obric.memorydata.plugin")).b();
            L73:
                return Intrinsics.areEqual(r7, r10);
            L52:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.k.class) == false) goto L57;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.k.class) == false) goto L57;
                r7 = ((com.obric.memorydata.memory.ui.data.a.k) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.k.class, "com.obric.memorydata.plugin")).b();
                r10 = ((com.obric.memorydata.memory.ui.data.a.k) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.k.class, "com.obric.memorydata.plugin")).b();
            L57:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.l.class) == false) goto L66;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.l.class) == false) goto L66;
                if (Intrinsics.areEqual(((com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin")).b(), ((com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin")).b()) == false) goto L72;
                if (((com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin")).c() != ((com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin")).c()) goto L72;
                return true;
            L66:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.d.class) == false) goto L71;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.d.class) == false) goto L71;
                r7 = ((com.obric.memorydata.memory.ui.data.a.d) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.d.class, "com.obric.memorydata.plugin")).b();
                r10 = ((com.obric.memorydata.memory.ui.data.a.d) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.d.class, "com.obric.memorydata.plugin")).b();
            L71:
                return Intrinsics.areEqual(r8, r9);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public /* synthetic */ boolean areContentsTheSame(com.obric.memorydata.memory.ui.data.a r3, com.obric.memorydata.memory.ui.data.a r4) {
                return areContentsTheSame2((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: areItemsTheSame, reason: avoid collision after fix types in other method */
            public boolean areItemsTheSame2(com.obric.memorydata.memory.ui.data.a r5, com.obric.memorydata.memory.ui.data.a r6) {
                Intrinsics.checkNotNullParameter(r5, "oldItem");
                Intrinsics.checkNotNullParameter(r6, "newItem");
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L10;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L10;
                Object r4 = ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getId();
                MemoryEntity r7 = ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b();
            L7:
                Object r8 = r7.getId();
            L51:
                return Intrinsics.areEqual(r4, r8);
            L10:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L18;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L18;
                if (((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getId() != ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getId()) goto L52;
                return true;
            L52:
                return false;
            L18:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L25;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L25;
                if (((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getId() != ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getId()) goto L52;
                return true;
            L25:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L30;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L30;
                r4 = ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getId();
                r7 = ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b();
            L30:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.j.class) == false) goto L35;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.j.class) == false) goto L35;
                r4 = ((com.obric.memorydata.memory.ui.data.a.j) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.j.class, "com.obric.memorydata.plugin")).b();
                r8 = ((com.obric.memorydata.memory.ui.data.a.j) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.j.class, "com.obric.memorydata.plugin")).b();
            L35:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.k.class) == false) goto L40;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.k.class) == false) goto L40;
                r4 = ((com.obric.memorydata.memory.ui.data.a.k) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.k.class, "com.obric.memorydata.plugin")).b();
                r8 = ((com.obric.memorydata.memory.ui.data.a.k) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.k.class, "com.obric.memorydata.plugin")).b();
            L40:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.l.class) == false) goto L45;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.l.class) == false) goto L45;
                r4 = ((com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin")).b();
                r8 = ((com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin")).b();
            L45:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.d.class) == false) goto L50;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.d.class) == false) goto L50;
                r4 = ((com.obric.memorydata.memory.ui.data.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.d.class, "com.obric.memorydata.plugin")).b();
                r8 = ((com.obric.memorydata.memory.ui.data.a.d) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.d.class, "com.obric.memorydata.plugin")).b();
            L50:
                return Intrinsics.areEqual(r5, r6);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public /* synthetic */ boolean areItemsTheSame(com.obric.memorydata.memory.ui.data.a r3, com.obric.memorydata.memory.ui.data.a r4) {
                return areItemsTheSame2((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"));
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10815a = new Companion(null);
    }

    public MemoryCorrelationAdapter() {
        super((DiffUtil.ItemCallback) ZeusTransformUtils.preCheckCast(new Companion.DiffCallback(), DiffUtil.ItemCallback.class, "com.obric.memorydata.plugin"), null, null, 6, null);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r4) {
        com.obric.memorydata.memory.ui.data.a r0 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(b(r4), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        MemoryItemType r1 = com.obric.memorydata.memory.ui.data.b.a(r0);
        if (r1 == null) goto L8;
        return r1.ordinal();
    L8:
        return super.a(r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public void a(com.obric.memorydata.memory.ui.data.c r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        ViewGroup.LayoutParams r0 = r6.c.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
    L12:
        com.obric.memorydata.memory.ui.data.a r5 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(b(r7), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L16;
        r6.b(r5);
        return;
    L16:
        return;
    L8:
        if (r7 != (d() - 2)) goto L10;
        int r2 = MathKt.roundToInt(TypedValue.applyDimension(1, 10, Resources.getSystem().getDisplayMetrics()));
    L11:
        r1.bottomMargin = r2;
        r6.c.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        goto L12
    L10:
        r2 = 0;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((com.obric.memorydata.memory.ui.data.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.c.class, "com.obric.memorydata.plugin"), r4);
    }

    public com.obric.memorydata.memory.ui.data.c b(ViewGroup r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        return (com.obric.memorydata.memory.ui.data.c) ZeusTransformUtils.preCheckCast(MemoryListItemViewHolder.Companion.a(MemoryListItemViewHolder.f11052a, r9, r10, null, MemoryListItemViewHolder.Companion.ItemRelatedPage.DETAIL_PAGE, false, 4, null), com.obric.memorydata.memory.ui.data.c.class, "com.obric.memorydata.plugin");
    }
}
