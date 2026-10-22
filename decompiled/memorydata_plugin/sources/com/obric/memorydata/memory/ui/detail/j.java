package com.obric.memorydata.memory.ui.detail;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ImageViewerExifPolicy;", "", "<init>", "()V", "ORIENTATION_FLIP_HORIZONTAL", "", "ORIENTATION_ROTATE_180", "ORIENTATION_FLIP_VERTICAL", "ORIENTATION_TRANSPOSE", "ORIENTATION_ROTATE_90", "ORIENTATION_TRANSVERSE", "ORIENTATION_ROTATE_270", "resolve", "Lcom/obric/memorydata/memory/ui/detail/ImageViewerExifTransform;", "orientation", "orientedDimensions", "Lkotlin/Pair;", "width", "height", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f10859a = null;

    static {
        f10859a = new j();
    }

    private j() {
    }

    public final k a(int r6) {
        switch(r6) {
            case 2: goto L12;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            default: goto L13;
        };
    L13:
        return new k(0.0f, false);
    L14:
        return new k(270.0f, false);
    L15:
        return new k(270.0f, true);
    L16:
        return new k(90.0f, false);
    L17:
        return new k(90.0f, true);
    L18:
        return new k(180.0f, true);
    L19:
        return new k(180.0f, false);
    L12:
        return new k(0.0f, true);
    }

    public final Pair<Integer, Integer> a(int r3, int r4, int r5) {
        float r2 = a(r5).a();
        boolean r0 = true;
        if (r2 != 90.0f) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
    L14:
        Integer r7 = Integer.valueOf(r4);
        Integer r8 = Integer.valueOf(r3);
    L16:
        return TuplesKt.to(r7, r8);
    L8:
        if (r2 == 270.0f) goto L11;
        r0 = false;
    L11:
        if (r0 == true) goto L14;
        r7 = Integer.valueOf(r3);
        r8 = Integer.valueOf(r4);
        goto L16
    L5:
        r6 = false;
        goto L6
    }
}
