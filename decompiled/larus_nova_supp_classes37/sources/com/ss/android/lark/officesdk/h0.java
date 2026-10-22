package com.ss.android.lark.officesdk;

import com.ss.android.lark.passportc.dwarf.UserScope;
import dagger.Lazy;
import dagger.hilt.dwarf.spi.DwarfSPI;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class h0 implements DwarfSPI {

    @Inject
    public Lazy<Map<Class<?>, Provider<Object>>> a;

    @Inject
    public h0() {
    }

    public final <T> T get(Class<T> r2) {
        Provider r3 = (Provider) ((Map) this.a.get()).get(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return (T) r3.get();
    }
}
