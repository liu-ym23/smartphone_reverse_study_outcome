package com.ss.android.lark.featuregating;

import com.ss.android.lark.storage.kv.flash.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements e {
    public a() {
    }

    public final String[] a() {
        String[] r0 = FileFgCenter.c;
        return (String[]) FileFgCenter.d.a.keySet().toArray(new String[0]);
    }

    public final boolean contains(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        String[] r0 = FileFgCenter.c;
        return FileFgCenter.d.a(r2);
    }

    public final void remove(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        throw new UnsupportedOperationException("FileFgCenterSource remove() not support");
    }

    public final boolean getBoolean(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        String[] r3 = FileFgCenter.c;
        return FileFgCenter.d.a(r1);
    }

    public final long getLong(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        throw new UnsupportedOperationException("FileFgCenterSource getLong() not support");
    }

    public final String getString(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        throw new UnsupportedOperationException("FileFgCenterSource getString() not support");
    }
}
