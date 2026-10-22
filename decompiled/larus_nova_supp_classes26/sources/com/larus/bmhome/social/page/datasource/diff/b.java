package com.larus.bmhome.social.page.datasource.diff;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.larus.bmhome.social.page.datasource.event.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class b<Item, Event extends com.larus.bmhome.social.page.datasource.event.a<Item>> {
    public final DiffUtil.ItemCallback<Item> a;
    public final ListUpdateCallback b;
    public final CopyOnWriteArraySet<c<Item>> c;

    public abstract Object b(Event r1, Continuation<? super Unit> r2);

    public abstract List<Item> c();

    public final void d(List<? extends Item> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        if (this.c.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.c.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((c) r0.next()).onChanged(r3);
        goto L7
    }

    public b(DiffUtil.ItemCallback r2, com.larus.bmhome.chat.list.datasource.adapter.PagingAdapterListUpdateCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "diffCallback");
        Intrinsics.checkNotNullParameter(r3, "updateCallback");
        this.a = r2;
        this.b = r3;
        this.c = new CopyOnWriteArraySet();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.social.page.datasource.diff.IPagingAdapterDiffer$buildCallback$1] */
    public final IPagingAdapterDiffer$buildCallback$1 a(List r3, final List r4) {
        Intrinsics.checkNotNullParameter(r3, "oldList");
        Intrinsics.checkNotNullParameter(r4, "newList");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        final List r5 = Collections.unmodifiableList(r3);
        Intrinsics.checkNotNullParameter(r4, "<this>");
        final List r0 = Collections.unmodifiableList(r4);
        return new IPagingAdapterDiffer$buildCallback$1(r5, r4, r0, this);
    }
}
