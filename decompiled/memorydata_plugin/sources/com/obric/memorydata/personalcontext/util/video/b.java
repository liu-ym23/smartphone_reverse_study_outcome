package com.obric.memorydata.personalcontext.util.video;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/video/KeyFrame;", "", "index", "", "histogram", "Lcom/obric/memorydata/personalcontext/util/video/ColorHistogram;", "relatedIndex", "bitmap", "Landroid/graphics/Bitmap;", "valid", "", "<init>", "(ILcom/obric/memorydata/personalcontext/util/video/ColorHistogram;ILandroid/graphics/Bitmap;Z)V", "getIndex", "()I", "getHistogram", "()Lcom/obric/memorydata/personalcontext/util/video/ColorHistogram;", "getRelatedIndex", "setRelatedIndex", "(I)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getValid", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f12385b;
    private int c;
    private final Bitmap d;
    private final boolean e;

    public b(int r1, a r2, int r3, Bitmap r4, boolean r5) {
        this.f12384a = r1;
        this.f12385b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public /* synthetic */ b(int r7, a r8, int r9, Bitmap r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L7;
        if (r10 == null) goto L6;
        r11 = true;
        goto L7
    L6:
        r11 = false;
    L7:
        this(r7, r8, r9, r10, r11);
    }

    public final int a() {
        return this.f12384a;
    }

    public final void a(int r1) {
        this.c = r1;
    }

    public final a b() {
        return this.f12385b;
    }

    public final int c() {
        return this.c;
    }

    public final boolean d() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f12384a == r6.f12384a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f12385b, r6.f12385b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.f12384a) * 31;
        a r1 = this.f12385b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Integer.hashCode(this.c)) * 31;
        Bitmap r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + Boolean.hashCode(this.e);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "KeyFrame(index=" + this.f12384a + ", histogram=" + this.f12385b + ", relatedIndex=" + this.c + ", bitmap=" + this.d + ", valid=" + this.e + ')';
    }
}
