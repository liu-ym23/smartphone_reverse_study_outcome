package com.obric.aee.impl;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class SafeBundle {
    private Bundle impl;

    public SafeBundle(Bundle r10) {
        this.impl = r10;
    }

    public final Bundle detach() {
        monitor-enter(this);
        Bundle r10 = this.impl;     // Catch: Throwable -> L6
        this.impl = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final void putBoolean(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        monitor-enter(this);
        Bundle r12 = this.impl;     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        r12.putBoolean(r10, r11);     // Catch: Throwable -> L9
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putDouble(String r10, double r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        monitor-enter(this);
        Bundle r12 = this.impl;     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        r12.putDouble(r10, r11);     // Catch: Throwable -> L9
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putFloat(String r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        monitor-enter(this);
        Bundle r12 = this.impl;     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        r12.putFloat(r10, r11);     // Catch: Throwable -> L9
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putInt(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        monitor-enter(this);
        Bundle r12 = this.impl;     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        r12.putInt(r10, r11);     // Catch: Throwable -> L9
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putLong(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        monitor-enter(this);
        Bundle r12 = this.impl;     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        r12.putLong(r10, r11);     // Catch: Throwable -> L9
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putParcelable(String r10, Parcelable r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        monitor-enter(this);
        Bundle r12 = this.impl;     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        r12.putParcelable(r10, r11);     // Catch: Throwable -> L9
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putParcelableArrayList(String r10, ArrayList<? extends Parcelable> r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        monitor-enter(this);
        Bundle r12 = this.impl;     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        r12.putParcelableArrayList(r10, r11);     // Catch: Throwable -> L9
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putString(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        monitor-enter(this);
        Bundle r12 = this.impl;     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        r12.putString(r10, r11);     // Catch: Throwable -> L9
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
