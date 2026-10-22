package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
class ImmutableMapEntry<K, V> extends ImmutableEntry<K, V> {

    public static final class NonTerminalImmutableBiMapEntry<K, V> extends NonTerminalImmutableMapEntry<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient ImmutableMapEntry f8823b;

        public NonTerminalImmutableBiMapEntry(K r5, V r10, ImmutableMapEntry<K, V> r11, ImmutableMapEntry<K, V> r12) {
            super(r5, r10, r11);
            this.f8823b = r12;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        public ImmutableMapEntry<K, V> getNextInValueBucket() {
            return this.f8823b;
        }
    }

    public static class NonTerminalImmutableMapEntry<K, V> extends ImmutableMapEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient ImmutableMapEntry f8824a;

        public NonTerminalImmutableMapEntry(K r5, V r10, ImmutableMapEntry<K, V> r11) {
            super(r5, r10);
            this.f8824a = r11;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        public final ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.f8824a;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        public final boolean isReusable() {
            return false;
        }
    }

    public ImmutableMapEntry(K r5, V r10) {
        super(r5, r10);
        p7.p(r5, r10);
    }

    public static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(int r5) {
        return new ImmutableMapEntry[r5];
    }

    public ImmutableMapEntry<K, V> getNextInKeyBucket() {
        return null;
    }

    public ImmutableMapEntry<K, V> getNextInValueBucket() {
        return null;
    }

    public boolean isReusable() {
        return true;
    }

    public ImmutableMapEntry(ImmutableMapEntry<K, V> r5) {
        super(r5.getKey(), r5.getValue());
    }
}
