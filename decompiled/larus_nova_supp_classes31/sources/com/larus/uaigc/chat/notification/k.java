package com.larus.uaigc.chat.notification;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k {
    public final int a;
    public final String b;
    public final String c;
    public final long d;
    public final int e;
    public final String f;
    public final boolean g;
    public final Bundle h;

    public k(int r2, String r3, String r4, long r5, int r7, String r8, boolean r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r8, "messageId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
