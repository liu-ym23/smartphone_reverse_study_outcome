package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
class ImmutableMapEntry<K, V> extends ImmutableEntry<K, V> {

    static final class NonTerminalImmutableBiMapEntry<K, V> extends NonTerminalImmutableMapEntry<K, V> {
        private final transient ImmutableMapEntry<K, V> nextInValueBucket;

        NonTerminalImmutableBiMapEntry(K r1, V r2, ImmutableMapEntry<K, V> r3, ImmutableMapEntry<K, V> r4) {
            super(r1, r2, r3);
            this.nextInValueBucket = r4;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return this.nextInValueBucket;
        }
    }

    static class NonTerminalImmutableMapEntry<K, V> extends ImmutableMapEntry<K, V> {
        private final transient ImmutableMapEntry<K, V> nextInKeyBucket;

        NonTerminalImmutableMapEntry(K r1, V r2, ImmutableMapEntry<K, V> r3) {
            super(r1, r2);
            this.nextInKeyBucket = r3;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        final ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.nextInKeyBucket;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        final boolean isReusable() {
            return false;
        }
    }

    ImmutableMapEntry(ImmutableMapEntry<K, V> r2) {
        super(r2.getKey(), r2.getValue());
    }

    ImmutableMapEntry(K r1, V r2) {
        super(r1, r2);
        o.a(r1, r2);
    }

    static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(int r0) {
        return new ImmutableMapEntry[r0];
    }

    ImmutableMapEntry<K, V> getNextInKeyBucket() {
        return null;
    }

    ImmutableMapEntry<K, V> getNextInValueBucket() {
        return null;
    }

    boolean isReusable() {
        return true;
    }
}
