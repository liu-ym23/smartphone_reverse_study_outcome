package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0000¨\u0006\f"}, d2 = {"resolveMemorySettingsVisibility", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsVisibility;", "systemHasContextAwarenessEntry", "", "aiLabEnabled", "screenMemoryShown", "voiceMemoryShown", "proactiveEntryVisible", "resolveMemorySettingsAppItems", "", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsAppItem;", "lifelogVisible", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class n {
    public static final m a(boolean r8, boolean r9, boolean r10, boolean r11, boolean r12) {
        List<i> r6 = a(r12, r10);
        if (r8 == true) goto L6;
        if (r9 == false) goto L6;
        boolean r13 = true;
    L7:
        if (r8 == true) goto L10;
        if (r11 == false) goto L10;
        boolean r2 = true;
    L12:
        return new m(r13, r2, r10, r12, !((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty(), r6);
    L10:
        r2 = false;
    L6:
        r13 = false;
        goto L7
    }

    public static final List<i> a(boolean r7, boolean r8) {
        List r0 = CollectionsKt.createListBuilder();
        if (r7 == false) goto L5;
        r0.add(MemorySettingsAppEntry.PROACTIVE);
    L5:
        if (r8 == false) goto L7;
        r0.add(MemorySettingsAppEntry.LIFELOG);
    L7:
        List r9 = CollectionsKt.build(r0);
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L21;
        Object r3 = r11.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        MemorySettingsAppEntry r5 = (MemorySettingsAppEntry) ZeusTransformUtils.preCheckCast(r3, MemorySettingsAppEntry.class, "com.obric.memorydata.plugin");
        if (r9.size() != 1) goto L16;
        MemorySettingsCardPosition r6 = MemorySettingsCardPosition.SINGLE;
    L19:
        r1.add(new i(r5, r6));
        r2 = r4;
        goto L9
    L16:
        if (r2 != 0) goto L18;
        r6 = MemorySettingsCardPosition.TOP;
        goto L19
    L18:
        r6 = MemorySettingsCardPosition.BOTTOM;
        goto L19
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }
}
