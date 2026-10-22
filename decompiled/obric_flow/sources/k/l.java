package k;

import com.airbnb.lottie.model.content.MergePaths$MergePathsMode;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18535a = null;

    static {
        int[] r5 = new int[MergePaths$MergePathsMode.values().length];
        f18535a = r5;
        r5[MergePaths$MergePathsMode.MERGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L14:
        f18535a[MergePaths$MergePathsMode.ADD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L18:
        f18535a[MergePaths$MergePathsMode.SUBTRACT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L22:
        f18535a[MergePaths$MergePathsMode.INTERSECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L16:
        f18535a[MergePaths$MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
        return;
    }
}
