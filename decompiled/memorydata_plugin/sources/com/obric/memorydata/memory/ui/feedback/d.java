package com.obric.memorydata.memory.ui.feedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/FeedbackOption;", "", AnnotatedPrivateKey.LABEL, "", BuildConfig.FLAVOR, "", "<init>", "(Ljava/lang/String;Z)V", "getLabel", "()Ljava/lang/String;", "getSelected", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10934b;

    public d(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, AnnotatedPrivateKey.LABEL);
        this.f10933a = r2;
        this.f10934b = r3;
    }

    public static /* synthetic */ d a(d r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.f10933a;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.f10934b;
    L9:
        return r0.a(r1, r2);
    }

    public final d a(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, AnnotatedPrivateKey.LABEL);
        return new d(r1, r2);
    }

    public final String a() {
        return this.f10933a;
    }

    public final boolean b() {
        return this.f10934b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10933a, r6.f10933a) == true) goto L12;
        return false;
    L12:
        if (this.f10934b == r6.f10934b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f10933a.hashCode() * 31) + Boolean.hashCode(this.f10934b);
    }

    public String toString() {
        return "FeedbackOption(label=" + this.f10933a + ", selected=" + this.f10934b + ')';
    }
}
