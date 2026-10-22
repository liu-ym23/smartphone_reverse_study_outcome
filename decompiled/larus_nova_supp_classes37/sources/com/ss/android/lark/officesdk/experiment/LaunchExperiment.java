package com.ss.android.lark.officesdk.experiment;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/officesdk/experiment/LaunchExperiment;", "", "desc", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "LAUNCH_ONLY_OFFICE_SDK", "LAUNCH_OFFICE_SDK_RUST_INIT", "LAUNCH_OFFICE_SDK_ALL", "LAUNCH_ALL_AFTER", "isBeforeFirstFeed", "", "Companion", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum LaunchExperiment extends Enum<LaunchExperiment> {
    public static final a Companion = null;
    public static final LaunchExperiment LAUNCH_ALL_AFTER = null;
    public static final LaunchExperiment LAUNCH_OFFICE_SDK_ALL = null;
    public static final LaunchExperiment LAUNCH_OFFICE_SDK_RUST_INIT = null;
    public static final LaunchExperiment LAUNCH_ONLY_OFFICE_SDK = null;
    public static final /* synthetic */ LaunchExperiment[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String desc;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<LaunchExperiment> getEntries() {
        return b;
    }

    static {
        LaunchExperiment r0 = new LaunchExperiment("LAUNCH_ONLY_OFFICE_SDK", 0, "office_sdk_only");
        LAUNCH_ONLY_OFFICE_SDK = r0;
        LaunchExperiment r1 = new LaunchExperiment("LAUNCH_OFFICE_SDK_RUST_INIT", 1, "office_sdk_rust_init");
        LAUNCH_OFFICE_SDK_RUST_INIT = r1;
        LaunchExperiment r3 = new LaunchExperiment("LAUNCH_OFFICE_SDK_ALL", 2, "office_sdk_all");
        LAUNCH_OFFICE_SDK_ALL = r3;
        LaunchExperiment r5 = new LaunchExperiment("LAUNCH_ALL_AFTER", 3, "office_sdk_lazy");
        LAUNCH_ALL_AFTER = r5;
        LaunchExperiment[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static LaunchExperiment[] values() {
        return (LaunchExperiment[]) a.clone();
    }

    public final boolean isBeforeFirstFeed() {
        if (this == LAUNCH_ALL_AFTER) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getDesc() {
        return this.desc;
    }

    @JvmStatic
    public static final LaunchExperiment toEnum(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        return LAUNCH_ALL_AFTER;
    L14:
        return LAUNCH_ONLY_OFFICE_SDK;
    L15:
        return LAUNCH_OFFICE_SDK_ALL;
    L12:
        return LAUNCH_ALL_AFTER;
    }

    public static LaunchExperiment valueOf(String r1) {
        return (LaunchExperiment) r27.a.a(LaunchExperiment.class, r1);
    }

    public LaunchExperiment(String r1, int r2, String r3) {
        super(r1, r2);
        this.desc = r3;
    }
}
