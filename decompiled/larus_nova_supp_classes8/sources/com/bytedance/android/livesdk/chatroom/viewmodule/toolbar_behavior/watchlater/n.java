package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import com.bytedance.android.livesdkapi.depend.model.live.IWatchLaterData;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n {
    public final long a;
    public final String b;
    public final Function1<IWatchLaterData, Unit> c;
    public final CompositeDisposable d;
    public final String e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof n) == false) goto L16;
        n r7 = (n) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        Function1<IWatchLaterData, Unit> r6 = this.c;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        CompositeDisposable r9 = this.d;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        String r12 = this.e;
        if (r12 == null) goto L18;
        r3 = r12.hashCode();
    L18:
        return r11 + r3;
    L13:
        r10 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "WatchLaterRequestParams(roomId=" + this.a + ", reqFrom=" + this.b + ", onSuccess=" + this.c + ", cd=" + this.d + ", requestTag=" + this.e + ")";
    }

    public n(long r2, String r4, Function1<? super IWatchLaterData, Unit> r5, CompositeDisposable r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        Intrinsics.checkNotNullParameter(r5, "onSuccess");
        Intrinsics.checkNotNullParameter(r6, "cd");
        Intrinsics.checkNotNullParameter(r7, "requestTag");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
