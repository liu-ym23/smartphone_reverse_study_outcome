package com.obric.memorydata.memory.ui.list;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.ui.data.MemoryItemType;
import com.obric.memorydata.ui.recyclerview.OuiPagingDataAdapter;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001e2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001:\u0001\u001eB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J,\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0014\u001a\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListAdapter;", "Lcom/obric/memorydata/ui/recyclerview/OuiPagingDataAdapter;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder;", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "itemRelatedPage", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;", "isTimeLineMode", "", "<init>", "(Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "getItemViewType", "currentQuery", "", "updateSearchQuery", ChatMessage.TYPE_QUERY, "refreshTimeView", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryListAdapter extends OuiPagingDataAdapter<com.obric.memorydata.memory.ui.data.a, MemoryListItemViewHolder<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f11044a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SelectionStateManager f11045b;
    private final MemoryListItemViewHolder.Companion.ItemRelatedPage c;
    private final boolean d;
    private String e;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListAdapter$Companion;", "", "<init>", "()V", "PAYLOAD_EDIT_MODE", "", "PAYLOAD_SELECTION", "PAYLOAD_QUERY_CHANGED", "PAYLOAD_TIME_CHANGED", "PAYLOAD_THEME_CHANGED", "Payload", "DiffCallback", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListAdapter$Companion$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class DiffCallback extends DiffUtil.ItemCallback<com.obric.memorydata.memory.ui.data.a> {
            public DiffCallback() {
            }

            /* JADX INFO: renamed from: areContentsTheSame, reason: avoid collision after fix types in other method */
            public boolean areContentsTheSame2(com.obric.memorydata.memory.ui.data.a r8, com.obric.memorydata.memory.ui.data.a r9) {
                Intrinsics.checkNotNullParameter(r8, "oldItem");
                Intrinsics.checkNotNullParameter(r9, "newItem");
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L17;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L17;
                if (Intrinsics.areEqual(((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getId(), ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getId()) == false) goto L76;
                if (((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getLastModifiedTime() != ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b().getLastModifiedTime()) goto L76;
                if (((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).c() != ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).c()) goto L76;
                if (((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).d() != ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).d()) goto L76;
                return true;
            L76:
                return false;
            L17:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L26;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L26;
                if (((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getId() != ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getId()) goto L76;
                if (((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getModifyTime() != ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getModifyTime()) goto L76;
                return true;
            L26:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L37;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L37;
                if (((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getId() != ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getId()) goto L76;
                if (((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getModifyTime() != ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getModifyTime()) goto L76;
                if (((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().d() != ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().d()) goto L76;
                return true;
            L37:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L46;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L46;
                if (((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b().getId() != ((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b().getId()) goto L76;
                if (((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b().getModifyTime() != ((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b().getModifyTime()) goto L76;
                return true;
            L46:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L55;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L55;
                if (Intrinsics.areEqual(((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getId(), ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getId()) == false) goto L76;
                if (((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getLastModifiedTime() != ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getLastModifiedTime()) goto L76;
                return true;
            L55:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.k.class) == false) goto L61;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.k.class) == false) goto L61;
                Object r7 = ((com.obric.memorydata.memory.ui.data.a.k) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.k.class, "com.obric.memorydata.plugin")).b();
                Object r10 = ((com.obric.memorydata.memory.ui.data.a.k) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.k.class, "com.obric.memorydata.plugin")).b();
            L77:
                return Intrinsics.areEqual(r7, r10);
            L61:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.l.class) == false) goto L70;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.l.class) == false) goto L70;
                if (Intrinsics.areEqual(((com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin")).b(), ((com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin")).b()) == false) goto L76;
                if (((com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin")).c() != ((com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin")).c()) goto L76;
                return true;
            L70:
                if (ZeusTransformUtils.instanceOf(r8, com.obric.memorydata.memory.ui.data.a.d.class) == false) goto L75;
                if (ZeusTransformUtils.instanceOf(r9, com.obric.memorydata.memory.ui.data.a.d.class) == false) goto L75;
                r7 = ((com.obric.memorydata.memory.ui.data.a.d) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.data.a.d.class, "com.obric.memorydata.plugin")).b();
                r10 = ((com.obric.memorydata.memory.ui.data.a.d) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.d.class, "com.obric.memorydata.plugin")).b();
            L75:
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
            L53:
                return Intrinsics.areEqual(r4, r8);
            L10:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L18;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L18;
                if (((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getId() != ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getId()) goto L54;
                return true;
            L54:
                return false;
            L18:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L25;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L25;
                if (((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getId() != ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b().getId()) goto L54;
                return true;
            L25:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L32;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L32;
                if (((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b().getId() != ((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b().getId()) goto L54;
                return true;
            L32:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L37;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L37;
                r4 = ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getId();
                r7 = ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b();
            L37:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.k.class) == false) goto L42;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.k.class) == false) goto L42;
                r4 = ((com.obric.memorydata.memory.ui.data.a.k) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.k.class, "com.obric.memorydata.plugin")).b();
                r8 = ((com.obric.memorydata.memory.ui.data.a.k) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.k.class, "com.obric.memorydata.plugin")).b();
            L42:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.l.class) == false) goto L47;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.l.class) == false) goto L47;
                r4 = ((com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin")).b();
                r8 = ((com.obric.memorydata.memory.ui.data.a.l) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.l.class, "com.obric.memorydata.plugin")).b();
            L47:
                if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.d.class) == false) goto L52;
                if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.d.class) == false) goto L52;
                r4 = ((com.obric.memorydata.memory.ui.data.a.d) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.d.class, "com.obric.memorydata.plugin")).b();
                r8 = ((com.obric.memorydata.memory.ui.data.a.d) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.d.class, "com.obric.memorydata.plugin")).b();
            L52:
                return Intrinsics.areEqual(r5, r6);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public /* synthetic */ boolean areItemsTheSame(com.obric.memorydata.memory.ui.data.a r3, com.obric.memorydata.memory.ui.data.a r4) {
                return areItemsTheSame2((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"));
            }
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListAdapter$Companion$Payload;", "", "key", "", EventBody.KEY_VALUE, "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f11046a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Object f11047b;

            public a(String r2, Object r3) {
                Intrinsics.checkNotNullParameter(r2, "key");
                this.f11046a = r2;
                this.f11047b = r3;
            }

            public final String a() {
                return this.f11046a;
            }

            public final Object b() {
                return this.f11047b;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f11046a, r6.f11046a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f11047b, r6.f11047b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r0 = this.f11046a.hashCode() * 31;
                Object r1 = this.f11047b;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "Payload(key=" + this.f11046a + ", value=" + this.f11047b + ')';
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11044a = new Companion(null);
    }

    public MemoryListAdapter(SelectionStateManager r8, MemoryListItemViewHolder.Companion.ItemRelatedPage r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "selectionManager");
        Intrinsics.checkNotNullParameter(r9, "itemRelatedPage");
        super((DiffUtil.ItemCallback) ZeusTransformUtils.preCheckCast(new Companion.DiffCallback(), DiffUtil.ItemCallback.class, "com.obric.memorydata.plugin"), null, null, 6, null);
        this.f11045b = r8;
        this.c = r9;
        this.d = r10;
        this.e = "";
    }

    public /* synthetic */ MemoryListAdapter(SelectionStateManager r1, MemoryListItemViewHolder.Companion.ItemRelatedPage r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = MemoryListItemViewHolder.Companion.ItemRelatedPage.LIST_PAGE;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = false;
    L8:
        this(r1, r2, r3);
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

    public final void a() {
        a(0, d(), new Companion.a("time_changed", 0));
    }

    public void a(MemoryListItemViewHolder<?> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        com.obric.memorydata.memory.ui.data.a r1 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(b(r3), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r2.b(r1);
        return;
    }

    public void a(MemoryListItemViewHolder<?> r6, int r7, List<? extends Object> r8) {
        List<Object> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r9, "payloads");
        if (r9.isEmpty() == false) goto L6;
        super.a((RecyclerView.v) ZeusTransformUtils.preCheckCast(r6, RecyclerView.v.class, "com.obric.memorydata.plugin"), r7, r9);
        return;
    L6:
        com.obric.memorydata.memory.ui.data.a r10 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(b(r7), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L9;
        return;
    L9:
        r6.a(r10);
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r11.hasNext() == false) goto L47;
        Object r0 = r11.next();
        if (ZeusTransformUtils.instanceOf(r0, Companion.a.class) == false) goto L11;
        String r2 = ((Companion.a) ZeusTransformUtils.preCheckCast(r0, Companion.a.class, "com.obric.memorydata.plugin")).a();
        Boolean r4 = null;
        String r5 = null;
        switch(r2.hashCode()) {
            case -1866220872: goto L38;
            case -1715965556: goto L35;
            case -919847102: goto L31;
            case 535353917: goto L22;
            case 748987966: goto L18;
            default: goto L11;
        };
    L18:
        if (r2.equals("theme_changed") == false) goto L11;
        r6.c(r10);
        goto L11
    L22:
        if (r2.equals("query_changed") == false) goto L11;
        Object r1 = ((Companion.a) ZeusTransformUtils.preCheckCast(r0, Companion.a.class, "com.obric.memorydata.plugin")).b();
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L27;
        r5 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L27:
        if (r5 != null) goto L29;
        r5 = this.e;
    L29:
        r10.a(CollectionsKt.listOf(r5));
        r6.a(r10, r10.a());
        goto L11
    L31:
        if (r2.equals("time_changed") == false) goto L11;
        r6.d(r10);
        goto L11
    L35:
        if (r2.equals("selection") == false) goto L11;
    L40:
        Object r3 = ((Companion.a) ZeusTransformUtils.preCheckCast(r0, Companion.a.class, "com.obric.memorydata.plugin")).b();
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L43;
        r4 = (Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin");
    L43:
        if (r4 == null) goto L45;
        boolean r12 = r4.booleanValue();
    L46:
        r6.a(r10, r12);
        goto L11
    L45:
        r12 = ((Boolean) ZeusTransformUtils.preCheckCast(this.f11045b.b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        goto L46
    L38:
        if (r2.equals("edit_mode") == true) goto L40;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((MemoryListItemViewHolder) ZeusTransformUtils.preCheckCast(r3, MemoryListItemViewHolder.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4, List r5) {
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        a((MemoryListItemViewHolder) ZeusTransformUtils.preCheckCast(r3, MemoryListItemViewHolder.class, "com.obric.memorydata.plugin"), r4, r6);
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, ChatMessage.TYPE_QUERY);
        if (Intrinsics.areEqual(this.e, r5) == true) goto L6;
        this.e = r5;
        a(0, d(), new Companion.a("query_changed", r5));
        return;
    }

    public MemoryListItemViewHolder<?> b(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        return MemoryListItemViewHolder.f11052a.a(r8, r9, this.f11045b, this.c, this.d);
    }
}
