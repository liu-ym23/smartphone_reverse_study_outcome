package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u001d\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J\u0016\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/list/UserTabList;", "T", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "()V", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "", "(ILjava/lang/Object;)V", "addAll", "elements", "", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserTabList<T> extends ArrayList<T> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public UserTabList() {
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T r2) {
        if (contains(r2) == false) goto L7;
        return false;
    L7:
        return super.add(r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        T r1 = r5.next();
        if ((!contains(r1)) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        if ((!r0.isEmpty()) == true) goto L12;
        r0 = null;
    L12:
        if (r0 != null) goto L21;
        return false;
    L21:
        return super.addAll(r0);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int r1) {
        return (T) removeAt(r1);
    }

    public /* bridge */ Object removeAt(int r1) {
        return super.remove(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int r2, T r3) {
        if (contains(r3) == false) goto L5;
        return;
    L5:
        super.add(r2, r3);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int r4, Collection<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        T r1 = r6.next();
        if ((!contains(r1)) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        if ((!r0.isEmpty()) == true) goto L12;
        r0 = null;
    L12:
        if (r0 != null) goto L21;
        return false;
    L21:
        return super.addAll(r4, r0);
    }
}
