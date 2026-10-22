package r;

import com.airbnb.lottie.model.DocumentData$Justification;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21629a = null;

    static {
        int[] r5 = new int[DocumentData$Justification.values().length];
        f21629a = r5;
        r5[DocumentData$Justification.LEFT_ALIGN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L10:
        f21629a[DocumentData$Justification.RIGHT_ALIGN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L12:
        f21629a[DocumentData$Justification.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
        return;
    }
}
