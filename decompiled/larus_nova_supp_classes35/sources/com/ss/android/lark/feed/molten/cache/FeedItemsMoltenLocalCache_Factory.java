package com.ss.android.lark.feed.molten.cache;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedItemsMoltenLocalCache_Factory implements Factory<FeedItemsMoltenLocalCache> {

    public static final class a {
        public static final FeedItemsMoltenLocalCache_Factory a = null;

        static {
            a = new FeedItemsMoltenLocalCache_Factory();
        }
    }

    public FeedItemsMoltenLocalCache_Factory() {
    }

    public static FeedItemsMoltenLocalCache newInstance() {
        return new FeedItemsMoltenLocalCache();
    }

    public FeedItemsMoltenLocalCache get() {
        return newInstance();
    }

    public static FeedItemsMoltenLocalCache_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1184get() {
        return get();
    }
}
