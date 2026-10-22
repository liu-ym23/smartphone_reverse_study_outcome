package com.obric.assistant.omnidetailpage;

import androidx.recyclerview.widget.DiffUtil;
import ifa.a;
import ifa.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/omnidetailpage/TaskDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskDiffCallback extends DiffUtil.ItemCallback<f> {
    public TaskDiffCallback() {
    }

    public final boolean areContentsTheSame(Object r9, Object r10) {
        f r11 = (f) r9;
        f r12 = (f) r10;
        Intrinsics.checkNotNullParameter(r11, "oldItem");
        Intrinsics.checkNotNullParameter(r12, "newItem");
        if ((r11 instanceof f.d) == false) goto L10;
        if ((r12 instanceof f.d) == false) goto L10;
        if (Intrinsics.areEqual(((f.d) r11).h, ((f.d) r12).h) == true) goto L10;
        return false;
    L10:
        if ((r11 instanceof f.e) == false) goto L19;
        if ((r12 instanceof f.e) == false) goto L19;
        f.e r0 = (f.e) r11;
        f.e r3 = (f.e) r12;
        if (Intrinsics.areEqual(r0.h, r3.h) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(r0.i, r3.i) == true) goto L19;
        return false;
    L19:
        if ((r11 instanceof f.c) == true) goto L21;
    L38:
        boolean r1 = true;
    L40:
        if (Intrinsics.areEqual(r11.b, r12.b) == true) goto L42;
        return false;
    L42:
        if (r11.c == r12.c) goto L44;
        return false;
    L44:
        if (r11.d == r12.d) goto L46;
        return false;
    L46:
        if (r11.e == r12.e) goto L48;
        return false;
    L48:
        if (r11.f == r12.f) goto L50;
        return false;
    L50:
        if (r11.g != r12.g) goto L62;
        if (r1 == false) goto L63;
        return true;
    L63:
        return false;
    L62:
        return false;
    L21:
        if ((r12 instanceof f.c) == false) goto L38;
        f.c r2 = (f.c) r11;
        f.c r4 = (f.c) r12;
        if (Intrinsics.areEqual(r2.h, r4.h) == true) goto L25;
    L37:
        r1 = false;
        goto L40
    L25:
        if (r2.i != r4.i) goto L37;
        List<a> r5 = r2.j;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L28:
        if (r7.hasNext() == false) goto L30;
        a r8 = (a) r7.next();
        r6.add(TuplesKt.to(r8.a, r8.d));
        goto L28
    L30:
        List<a> r13 = r4.j;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r15 = r13.iterator();
    L32:
        if (r15.hasNext() == false) goto L35;
        a r16 = (a) r15.next();
        r14.add(TuplesKt.to(r16.a, r16.d));
        goto L32
    L35:
        if (Intrinsics.areEqual(r6, r14) == false) goto L37;
        goto L37
    }

    public final boolean areItemsTheSame(Object r3, Object r4) {
        f r5 = (f) r3;
        f r6 = (f) r4;
        Intrinsics.checkNotNullParameter(r5, "oldItem");
        Intrinsics.checkNotNullParameter(r6, "newItem");
        if (r5.a == r6.a) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r5.b.getBlockId(), r6.b.getBlockId()) == false) goto L7;
        return true;
    }
}
