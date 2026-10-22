package hq;

import android.os.Bundle;
import android.view.View;
import com.obric.flow.cardlistpage.mvi.MviLogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f17357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f17358b;

    public a(View r5, Bundle r10) {
        this.f17357a = r5;
        this.f17358b = r10;
    }

    @Override // hq.h
    public final String a() {
        return toString();
    }

    @Override // hq.h
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        View r11 = r10.f17357a;
        if (Intrinsics.areEqual(this.f17357a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17358b, r10.f17358b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        View r10 = this.f17357a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Bundle r13 = this.f17358b;
        if (r13 == null) goto L11;
        r5 = r13.hashCode();
    L11:
        return r12 + r5;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "DispatchExternalLongClickMenuClick(contentView=" + this.f17357a + ", bundle=" + this.f17358b + ")";
    }
}
