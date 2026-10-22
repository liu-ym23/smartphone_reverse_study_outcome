package com.obric.aee.impl;

import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0015J.\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010\u0017j\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u0001`\u0018J\u0016\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/aee/impl/SafeBundle;", "", "impl", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "detach", "putBoolean", "", "key", "", EventBody.KEY_VALUE, "", "putDouble", "", "putFloat", "", "putInt", "", "putLong", "", "putParcelable", "Landroid/os/Parcelable;", "putParcelableArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "putString", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SafeBundle {
    private Bundle impl;

    public SafeBundle(Bundle r1) {
        this.impl = r1;
    }

    public final Bundle detach() {
        monitor-enter(this);
        Bundle r0 = this.impl;     // Catch: Throwable -> L6
        this.impl = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void putBoolean(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        monitor-enter(this);
        Bundle r0 = this.impl;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.putBoolean(r2, r3);     // Catch: Throwable -> L9
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putDouble(String r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        monitor-enter(this);
        Bundle r0 = this.impl;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.putDouble(r2, r3);     // Catch: Throwable -> L9
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putFloat(String r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        monitor-enter(this);
        Bundle r0 = this.impl;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.putFloat(r2, r3);     // Catch: Throwable -> L9
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putInt(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        monitor-enter(this);
        Bundle r0 = this.impl;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.putInt(r2, r3);     // Catch: Throwable -> L9
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putLong(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        monitor-enter(this);
        Bundle r0 = this.impl;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.putLong(r2, r3);     // Catch: Throwable -> L9
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putParcelable(String r3, Parcelable r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        monitor-enter(this);
        Bundle r0 = this.impl;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.putParcelable(r3, r5);     // Catch: Throwable -> L9
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putParcelableArrayList(String r2, ArrayList<? extends Parcelable> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        monitor-enter(this);
        Bundle r0 = this.impl;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.putParcelableArrayList(r2, r3);     // Catch: Throwable -> L9
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void putString(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        monitor-enter(this);
        Bundle r0 = this.impl;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.putString(r2, r3);     // Catch: Throwable -> L9
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
