package com.ss.android.lark.integrator.im.impl.feed;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeFeedService_Factory implements Factory<com.ss.android.lark.integrator.im.impl.feed.a> {

    public static final class a {
        public static final OfficeFeedService_Factory a = null;

        static {
            a = new OfficeFeedService_Factory();
        }
    }

    public OfficeFeedService_Factory() {
    }

    public static com.ss.android.lark.integrator.im.impl.feed.a newInstance() {
        return new com.ss.android.lark.integrator.im.impl.feed.a();
    }

    public com.ss.android.lark.integrator.im.impl.feed.a get() {
        return newInstance();
    }

    public static OfficeFeedService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m908get() {
        return get();
    }
}
