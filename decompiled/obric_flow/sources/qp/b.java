package qp;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof b) == false) goto L18;
        ((b) r5).getClass();
        if (Float.compare(67.45f, 67.45f) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(51.16f, 51.16f) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(34.86f, 34.86f) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(22.07f, 22.07f) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(13.36f, 13.36f) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(4.64f, 4.64f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.b(13.36f, androidx.constraintlayout.motion.widget.a.b(22.07f, androidx.constraintlayout.motion.widget.a.b(34.86f, androidx.constraintlayout.motion.widget.a.b(51.16f, Float.hashCode(67.45f) * 31, 31), 31), 31), 31);
        return Float.hashCode(4.64f) + r5;
    }

    public final String toString() {
        return "ControlPoint(handleLarge=67.45, distanceOuter=51.16, distanceInner=34.86, handleMedium=22.07, curveInner=13.36, curveOuter=4.64)";
    }
}
