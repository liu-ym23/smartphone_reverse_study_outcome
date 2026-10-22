package com.bytedance.android.accessibilityLib_Core.processor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/processor/TraverseFromType;", "", "None", "InternalVisitViewGlobalLayoutChange", "ActivityCreated_PageIn", "ActivityPostResumed", "FragmentCreated", "FragmentGlobalLayoutChange", "ActivityGlobalLayoutChange", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum TraverseFromType extends Enum<TraverseFromType> {
    public static final TraverseFromType ActivityCreated_PageIn = null;
    public static final TraverseFromType ActivityGlobalLayoutChange = null;
    public static final TraverseFromType ActivityPostResumed = null;
    public static final TraverseFromType FragmentCreated = null;
    public static final TraverseFromType FragmentGlobalLayoutChange = null;
    public static final TraverseFromType InternalVisitViewGlobalLayoutChange = null;
    public static final TraverseFromType None = null;
    public static final /* synthetic */ TraverseFromType[] a = null;

    static {
        TraverseFromType r1 = new TraverseFromType("None", 0);
        None = r1;
        TraverseFromType r10 = new TraverseFromType("InternalVisitViewGlobalLayoutChange", 1);
        InternalVisitViewGlobalLayoutChange = r10;
        TraverseFromType r11 = new TraverseFromType("ActivityCreated_PageIn", 2);
        ActivityCreated_PageIn = r11;
        TraverseFromType r12 = new TraverseFromType("ActivityPostResumed", 3);
        ActivityPostResumed = r12;
        TraverseFromType r13 = new TraverseFromType("FragmentCreated", 4);
        FragmentCreated = r13;
        TraverseFromType r14 = new TraverseFromType("FragmentGlobalLayoutChange", 5);
        FragmentGlobalLayoutChange = r14;
        TraverseFromType r15 = new TraverseFromType("ActivityGlobalLayoutChange", 6);
        ActivityGlobalLayoutChange = r15;
        a = new TraverseFromType[]{r1, r10, r11, r12, r13, r14, r15};
    }

    public static TraverseFromType valueOf(String r1) {
        return (TraverseFromType) r27.a.a(TraverseFromType.class, r1);
    }

    public static TraverseFromType[] values() {
        return (TraverseFromType[]) a.clone();
    }

    public TraverseFromType(String r1, int r10) {
        super(r1, r10);
    }
}
