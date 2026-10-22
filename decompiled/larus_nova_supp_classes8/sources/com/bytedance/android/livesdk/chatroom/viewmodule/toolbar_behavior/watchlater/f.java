package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import com.bytedance.android.livesdkapi.depend.model.live.ILLPanelWidget;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public final long a;
    public final Function1<List<ILLPanelWidget>, Unit> b;
    public final CompositeDisposable c;
    public final String d;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof f) == false) goto L14;
        f r7 = (f) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        Function1<List<ILLPanelWidget>, Unit> r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        CompositeDisposable r6 = this.c;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        String r9 = this.d;
        if (r9 == null) goto L14;
        r3 = r9.hashCode();
    L14:
        return r8 + r3;
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "LLPanelRequestParams(roomId=" + this.a + ", onSuccess=" + this.b + ", cd=" + this.c + ", requestTag=" + this.d + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(long r2, Function1<? super List<ILLPanelWidget>, Unit> r4, CompositeDisposable r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        Intrinsics.checkNotNullParameter(r5, "cd");
        Intrinsics.checkNotNullParameter(r6, "requestTag");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
