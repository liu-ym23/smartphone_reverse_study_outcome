package com.google.common.collect;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class Lists$StringAsImmutableList extends ImmutableList<Character> {
    private final String string;

    public Lists$StringAsImmutableList(String r5) {
        this.string = r5;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object get(int r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(Object r5) {
        if ((r5 instanceof Character) == true) goto L7;
        return -1;
    L7:
        return this.string.indexOf(((Character) r5).charValue());
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(Object r5) {
        if ((r5 instanceof Character) == true) goto L7;
        return -1;
    L7:
        return this.string.lastIndexOf(((Character) r5).charValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.string.length();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public /* bridge */ /* synthetic */ List subList(int r5, int r10) {
        return subList(r5, r10);
    }

    @Override // java.util.List
    public Character get(int r5) {
        com.google.common.base.b0.l(r5, size());
        return Character.valueOf(this.string.charAt(r5));
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public ImmutableList<Character> subList(int r5, int r10) {
        com.google.common.base.b0.p(r5, r10, size());
        String r11 = this.string.substring(r5, r10);
        r11.getClass();
        return new Lists$StringAsImmutableList(r11);
    }
}
