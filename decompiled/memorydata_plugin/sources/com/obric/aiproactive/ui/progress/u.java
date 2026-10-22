package com.obric.aiproactive.ui.progress;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006J\u001f\u0010\u0015\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\fJ\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/aiproactive/ui/progress/MobileUseNavigationGate;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "binding", "Lcom/obric/aiproactive/ui/progress/MobileUseRowBinding;", TypedValues.AttributesType.S_TARGET, "Ljava/lang/Object;", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "resolvingAttempt", "Lcom/obric/aiproactive/ui/progress/MobileUseNavigationAttempt;", "sendingAttempt", BuildConfig.CHANNEL, "", "(Lcom/obric/aiproactive/ui/progress/MobileUseRowBinding;Ljava/lang/Object;)V", "availableBinding", "beginFreshResolution", "clickedBinding", "currentBinding", "beginSend", "attempt", "freshTarget", "(Lcom/obric/aiproactive/ui/progress/MobileUseNavigationAttempt;Ljava/lang/Object;)Ljava/lang/Object;", "finishSend", "finishFreshResolution", "clear", "invalidate", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f6849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f6850b;
    private long c;
    private t d;
    private t e;

    public u() {
    }

    public final t a(z r5, z r6) {
        Intrinsics.checkNotNullParameter(r5, "clickedBinding");
        z r0 = this.f6849a;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r5, r6) == true) goto L8;
    L18:
        return null;
    L8:
        if (Intrinsics.areEqual(r5, r0) == false) goto L18;
        if (this.f6850b == null) goto L18;
        if (this.d != null) goto L18;
        if (this.e != null) goto L18;
        long r1 = this.c + 1;
        this.c = r1;
        t r7 = new t(r5, r1);
        this.d = r7;
        return r7;
    }

    public final z a() {
        z r0 = this.f6849a;
        if (this.f6850b != null) goto L5;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L14;
        return null;
    L14:
        return r0;
    L5:
        if (this.d != null) goto L9;
        if (this.e != null) goto L9;
        r2 = true;
        goto L10
    }

    public final T a(t r4, T r5) {
        Intrinsics.checkNotNullParameter(r4, "attempt");
        if (Intrinsics.areEqual(this.d, r4) == true) goto L5;
        return null;
    L5:
        this.d = null;
        if (r5 != null) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(this.f6849a, r4.a()) == true) goto L11;
    L15:
        return null;
    L11:
        if (this.e != null) goto L15;
        this.e = r4;
        return r5;
    }

    public final void a(t r2) {
        Intrinsics.checkNotNullParameter(r2, "attempt");
        if (Intrinsics.areEqual(this.e, r2) == false) goto L6;
        this.e = null;
        return;
    }

    public final void a(z r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        if (Intrinsics.areEqual(this.f6849a, r2) == false) goto L6;
        this.f6850b = null;
        return;
    }

    public final void b() {
        update(null, null);
    }

    public final void b(t r2) {
        Intrinsics.checkNotNullParameter(r2, "attempt");
        if (Intrinsics.areEqual(this.d, r2) == false) goto L6;
        this.d = null;
        return;
    }

    public final void update(z r2, T r3) {
        this.f6849a = r2;
        if (r2 == null) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L10;
        r3 = null;
    L10:
        this.f6850b = r3;
        this.d = null;
        this.e = null;
        return;
    L5:
        r4 = false;
        goto L7
    }
}
