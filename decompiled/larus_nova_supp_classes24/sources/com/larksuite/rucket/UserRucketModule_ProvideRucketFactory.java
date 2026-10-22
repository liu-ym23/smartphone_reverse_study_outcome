package com.larksuite.rucket;

import b38.a;
import b38.b;
import b38.c;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.rucket.core.RucketImpl;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import jdb.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UserRucketModule_ProvideRucketFactory implements Factory<b> {
    private final Provider<l> clientProvider;
    private final Provider<String> uidProvider;

    public b get() {
        return provideRucket((l) this.clientProvider.get(), (String) this.uidProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m354get() {
        return get();
    }

    public UserRucketModule_ProvideRucketFactory(Provider<l> r1, Provider<String> r2) {
        this.clientProvider = r1;
        this.uidProvider = r2;
    }

    public static UserRucketModule_ProvideRucketFactory create(Provider<l> r1, Provider<String> r2) {
        return new UserRucketModule_ProvideRucketFactory(r1, r2);
    }

    public static b provideRucket(l r3, String r4) {
        int r0 = c.a;
        Intrinsics.checkNotNullParameter(r3, "client");
        Intrinsics.checkNotNullParameter(r4, "uid");
        RucketImpl r1 = new RucketImpl();
        int r2 = a.a;
        Intrinsics.checkNotNullParameter(r4, "uid");
        if (((e) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(e.class)).B0(r4, "messenger.im.scoped_rucket") == false) goto L6;
        r1.a(new d38.a(r3));
        r1.a(new d38.c(r3));
        r1.a(new d38.e(r3));
    L6:
        return (b) Preconditions.checkNotNullFromProvides(r1);
    }
}
