package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UserFieldsService_Factory implements Factory<UserFieldsService> {
    private final Provider<g> fgServiceProvider;
    private final Provider<a> repositoryProvider;

    public UserFieldsService get() {
        return newInstance((a) this.repositoryProvider.get(), (g) this.fgServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m437get() {
        return get();
    }

    public UserFieldsService_Factory(Provider<a> r1, Provider<g> r2) {
        this.repositoryProvider = r1;
        this.fgServiceProvider = r2;
    }

    public static UserFieldsService_Factory create(Provider<a> r1, Provider<g> r2) {
        return new UserFieldsService_Factory(r1, r2);
    }

    public static UserFieldsService newInstance(a r1, g r2) {
        return new UserFieldsService(r1, r2);
    }
}
