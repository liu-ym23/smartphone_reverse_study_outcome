package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UserFieldsRepositoryV2_Factory implements Factory<d> {
    private final Provider<l> rustClientProvider;

    public d get() {
        return newInstance((l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m436get() {
        return get();
    }

    public UserFieldsRepositoryV2_Factory(Provider<l> r1) {
        this.rustClientProvider = r1;
    }

    public static UserFieldsRepositoryV2_Factory create(Provider<l> r1) {
        return new UserFieldsRepositoryV2_Factory(r1);
    }

    public static d newInstance(l r1) {
        return new d(r1);
    }
}
