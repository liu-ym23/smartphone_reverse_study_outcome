package com.airbnb.lottie.model.content;

/* JADX INFO: loaded from: classes.dex */
public final enum MergePaths$MergePathsMode extends Enum<MergePaths$MergePathsMode> {
    public static final MergePaths$MergePathsMode ADD = null;
    public static final MergePaths$MergePathsMode EXCLUDE_INTERSECTIONS = null;
    public static final MergePaths$MergePathsMode INTERSECT = null;
    public static final MergePaths$MergePathsMode MERGE = null;
    public static final MergePaths$MergePathsMode SUBTRACT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MergePaths$MergePathsMode[] f1286a = null;

    static {
        MergePaths$MergePathsMode r5 = new MergePaths$MergePathsMode("MERGE", 0);
        MERGE = r5;
        MergePaths$MergePathsMode r10 = new MergePaths$MergePathsMode("ADD", 1);
        ADD = r10;
        MergePaths$MergePathsMode r11 = new MergePaths$MergePathsMode("SUBTRACT", 2);
        SUBTRACT = r11;
        MergePaths$MergePathsMode r12 = new MergePaths$MergePathsMode("INTERSECT", 3);
        INTERSECT = r12;
        MergePaths$MergePathsMode r13 = new MergePaths$MergePathsMode("EXCLUDE_INTERSECTIONS", 4);
        EXCLUDE_INTERSECTIONS = r13;
        f1286a = new MergePaths$MergePathsMode[]{r5, r10, r11, r12, r13};
    }

    public static MergePaths$MergePathsMode forId(int r5) {
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L21;
        if (r5 == 3) goto L19;
        if (r5 == 4) goto L17;
        if (r5 == 5) goto L15;
        return MERGE;
    L15:
        return EXCLUDE_INTERSECTIONS;
    L17:
        return INTERSECT;
    L19:
        return SUBTRACT;
    L21:
        return ADD;
    L23:
        return MERGE;
    }

    public static MergePaths$MergePathsMode valueOf(String r5) {
        return (MergePaths$MergePathsMode) Enum.valueOf(MergePaths$MergePathsMode.class, r5);
    }

    public static MergePaths$MergePathsMode[] values() {
        return (MergePaths$MergePathsMode[]) f1286a.clone();
    }
}
