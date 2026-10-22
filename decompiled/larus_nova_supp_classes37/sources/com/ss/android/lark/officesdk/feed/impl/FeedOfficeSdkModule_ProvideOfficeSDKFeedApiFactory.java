package com.ss.android.lark.officesdk.feed.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FeedOfficeSdkModule_ProvideOfficeSDKFeedApiFactory implements Factory<qtb.b> {
    private final b module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public qtb.b m71get() {
        return provideOfficeSDKFeedApi(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m71get();
    }

    public FeedOfficeSdkModule_ProvideOfficeSDKFeedApiFactory(b r1) {
        this.module = r1;
    }

    public static FeedOfficeSdkModule_ProvideOfficeSDKFeedApiFactory create(b r1) {
        return new FeedOfficeSdkModule_ProvideOfficeSDKFeedApiFactory(r1);
    }

    public static qtb.b provideOfficeSDKFeedApi(b r0) {
        r0.getClass();
        return (qtb.b) Preconditions.checkNotNullFromProvides(new FlowFeedApiProxy());
    }
}
