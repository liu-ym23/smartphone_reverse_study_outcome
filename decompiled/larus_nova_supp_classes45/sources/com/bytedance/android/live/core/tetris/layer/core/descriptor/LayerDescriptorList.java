package com.bytedance.android.live.core.tetris.layer.core.descriptor;

import h70.b;
import j70.h;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/descriptor/LayerDescriptorList;", "Ljava/util/ArrayList;", "Lj70/h;", "Lh70/b;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LayerDescriptorList extends ArrayList<h<? extends b>> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public LayerDescriptorList() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r2) {
        if ((r2 instanceof h) == true) goto L7;
        return false;
    L7:
        return contains((h) r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r2) {
        if ((r2 instanceof h) == true) goto L7;
        return -1;
    L7:
        return indexOf((h) r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r2) {
        if ((r2 instanceof h) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((h) r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r2) {
        if ((r2 instanceof h) == true) goto L7;
        return false;
    L7:
        return remove((h) r2);
    }

    public /* bridge */ h removeAt(int r1) {
        return remove(r1);
    }

    public /* bridge */ boolean contains(h r1) {
        return super.contains(r1);
    }

    public /* bridge */ int indexOf(h r1) {
        return super.indexOf(r1);
    }

    public /* bridge */ int lastIndexOf(h r1) {
        return super.lastIndexOf(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ h<? extends b> remove(int r1) {
        return removeAt(r1);
    }

    public /* bridge */ boolean remove(h r1) {
        return super.remove(r1);
    }
}
