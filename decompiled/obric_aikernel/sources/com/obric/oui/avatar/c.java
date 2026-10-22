package com.obric.oui.avatar;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.TypedValue;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OAvatar.AvatarSize f6217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OAvatarQueueShape f6218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<Bitmap> f6219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6220d;

    public c() {
        this(null, null, null, 0, 15, null);
    }

    public c(OAvatar.AvatarSize r10, OAvatarQueueShape r11, ArrayList<Bitmap> r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "avatarSize");
        Intrinsics.checkNotNullParameter(r11, "shape");
        Intrinsics.checkNotNullParameter(r12, "avatarBitmapQueue");
        this.f6217a = r10;
        this.f6218b = r11;
        this.f6219c = r12;
        this.f6220d = r13;
    }

    public /* synthetic */ c(OAvatar.AvatarSize r10, OAvatarQueueShape r11, ArrayList r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = OAvatar.AvatarSize.DP_16;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = OAvatarQueueShape.Queue;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = new ArrayList();
    L12:
        if ((r14 & 8) == 0) goto L14;
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        r13 = MathKt.roundToInt(TypedValue.applyDimension(1, 3, r16.getDisplayMetrics()));
    L14:
        this(r10, r11, r12, r13);
    }

    public final ArrayList<Bitmap> a() {
        return this.f6219c;
    }

    public final OAvatar.AvatarSize b() {
        return this.f6217a;
    }

    public final int c() {
        return this.f6220d;
    }

    public final OAvatarQueueShape d() {
        return this.f6218b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof c) == false) goto L14;
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.f6217a, r11.f6217a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f6218b, r11.f6218b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f6219c, r11.f6219c) == true) goto L12;
        return false;
    L12:
        if (this.f6220d == r11.f6220d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        OAvatar.AvatarSize r10 = this.f6217a;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = r12 * 31;
        OAvatarQueueShape r14 = this.f6218b;
        if (r14 == null) goto L9;
        int r15 = r14.hashCode();
    L10:
        int r16 = (r13 + r15) * 31;
        ArrayList<Bitmap> r17 = this.f6219c;
        if (r17 == null) goto L14;
        r11 = r17.hashCode();
    L14:
        return ((r16 + r11) * 31) + Integer.hashCode(this.f6220d);
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    public String toString() {
        return "OAvatarInParam(avatarSize=" + this.f6217a + ", shape=" + this.f6218b + ", avatarBitmapQueue=" + this.f6219c + ", overLapSizePx=" + this.f6220d + ")";
    }
}
