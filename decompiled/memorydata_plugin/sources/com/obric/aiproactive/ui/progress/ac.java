package com.obric.aiproactive.ui.progress;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/ui/progress/StatusActionPresentation;", "", "textRes", "", "iconRes", "colorRes", "<init>", "(III)V", "getTextRes", "()I", "getIconRes", "getColorRes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6798b;
    private final int c;

    public ac(int r1, int r2, int r3) {
        this.f6797a = r1;
        this.f6798b = r2;
        this.c = r3;
    }

    public final int a() {
        return this.f6797a;
    }

    public final int b() {
        return this.f6798b;
    }

    public final int c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ac.class) == true) goto L8;
        return false;
    L8:
        ac r6 = (ac) ZeusTransformUtils.preCheckCast(r5, ac.class, "com.obric.memorydata.plugin");
        if (this.f6797a == r6.f6797a) goto L12;
        return false;
    L12:
        if (this.f6798b == r6.f6798b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f6797a) * 31) + Integer.hashCode(this.f6798b)) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "StatusActionPresentation(textRes=" + this.f6797a + ", iconRes=" + this.f6798b + ", colorRes=" + this.c + ')';
    }
}
