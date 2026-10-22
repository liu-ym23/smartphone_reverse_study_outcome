package com.ss.android.lark.chat.component.task;

import com.ss.android.lark.passportc.api.i;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SetLoginChatterTask_Factory implements Factory<SetLoginChatterTask> {
    private final Provider<i> multiOnlineFGProvider;

    public SetLoginChatterTask get() {
        return newInstance((i) this.multiOnlineFGProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m494get() {
        return get();
    }

    public SetLoginChatterTask_Factory(Provider<i> r1) {
        this.multiOnlineFGProvider = r1;
    }

    public static SetLoginChatterTask_Factory create(Provider<i> r1) {
        return new SetLoginChatterTask_Factory(r1);
    }

    public static SetLoginChatterTask newInstance(i r1) {
        return new SetLoginChatterTask(r1);
    }
}
