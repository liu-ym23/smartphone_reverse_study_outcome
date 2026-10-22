package com.ss.android.lark.passport_user.container;

import com.ss.android.lark.passportc.api.i;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.api.k;
import com.ss.android.lark.passportc.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;
import yzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CreateUserComponentTask_Factory implements Factory<CreateUserComponentTask> {
    private final Provider<b> larkUserListApiProvider;
    private final Provider<i> multiOnlineFGProvider;
    private final Provider<j> passportGlobalServiceProvider;
    private final Provider<k> passportStateManager2Provider;
    private final Provider<l> passportStateManagerProvider;

    public CreateUserComponentTask get() {
        return newInstance(this.multiOnlineFGProvider, this.passportStateManagerProvider, this.passportStateManager2Provider, this.passportGlobalServiceProvider, this.larkUserListApiProvider);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m686get() {
        return get();
    }

    public CreateUserComponentTask_Factory(Provider<i> r1, Provider<l> r2, Provider<k> r3, Provider<j> r4, Provider<b> r5) {
        this.multiOnlineFGProvider = r1;
        this.passportStateManagerProvider = r2;
        this.passportStateManager2Provider = r3;
        this.passportGlobalServiceProvider = r4;
        this.larkUserListApiProvider = r5;
    }

    public static CreateUserComponentTask_Factory create(Provider<i> r7, Provider<l> r8, Provider<k> r9, Provider<j> r10, Provider<b> r11) {
        return new CreateUserComponentTask_Factory(r7, r8, r9, r10, r11);
    }

    public static CreateUserComponentTask newInstance(Provider<i> r7, Provider<l> r8, Provider<k> r9, Provider<j> r10, Provider<b> r11) {
        return new CreateUserComponentTask(r7, r8, r9, r10, r11);
    }
}
