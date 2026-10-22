package com.obric.aiproactive.ui.progress;

import android.app.PendingIntent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/aiproactive/ui/progress/MobileUsePlayerTarget;", "", "pendingIntent", "Landroid/app/PendingIntent;", "<init>", "(Landroid/app/PendingIntent;)V", "getPendingIntent", "()Landroid/app/PendingIntent;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PendingIntent f6854a;

    public y(PendingIntent r2) {
        Intrinsics.checkNotNullParameter(r2, "pendingIntent");
        this.f6854a = r2;
    }

    public final PendingIntent a() {
        return this.f6854a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, y.class) == true) goto L8;
        return false;
    L8:
        y r6 = (y) ZeusTransformUtils.preCheckCast(r5, y.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6854a, r6.f6854a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f6854a.hashCode();
    }

    public String toString() {
        return "MobileUsePlayerTarget(pendingIntent=" + this.f6854a + ')';
    }
}
