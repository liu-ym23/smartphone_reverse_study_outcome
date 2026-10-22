package com.ss.android.lark.chat.api.service.impl.smartreply;

import b38.b;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SmartApplyAnswerService_Factory implements Factory<SmartApplyAnswerService> {
    private final Provider<b> rucketProvider;

    public SmartApplyAnswerService get() {
        return newInstance((b) this.rucketProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m100get() {
        return get();
    }

    public SmartApplyAnswerService_Factory(Provider<b> r1) {
        this.rucketProvider = r1;
    }

    public static SmartApplyAnswerService_Factory create(Provider<b> r1) {
        return new SmartApplyAnswerService_Factory(r1);
    }

    public static SmartApplyAnswerService newInstance(b r1) {
        return new SmartApplyAnswerService(r1);
    }
}
