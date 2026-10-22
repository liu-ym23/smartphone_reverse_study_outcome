package q;

import com.airbnb.lottie.model.content.ShapeStroke$LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke$LineJoinType;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21435a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f21436b = null;

    static {
        int[] r5 = new int[ShapeStroke$LineJoinType.values().length];
        f21436b = r5;
        r5[ShapeStroke$LineJoinType.BEVEL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
    L21:
        f21436b[ShapeStroke$LineJoinType.MITER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
    L23:
        f21436b[ShapeStroke$LineJoinType.ROUND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
    L8:
        int[] r10 = new int[ShapeStroke$LineCapType.values().length];
        f21435a = r10;
        r10[ShapeStroke$LineCapType.BUTT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
    L29:
        f21435a[ShapeStroke$LineCapType.ROUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
    L19:
        f21435a[ShapeStroke$LineCapType.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        return;
    }
}
