package com.ss.android.lark.passportc.api;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class w extends z {
    public final String c;

    @Override // com.ss.android.lark.passportc.api.z
    public final String a() {
        return this.c;
    }

    public w(List r2) {
        Intrinsics.checkNotNullParameter(r2, "expectedBackgroundUserList");
        super(r2, false);
        this.c = "OfflineForeground";
    }
}
