package com.bytedance.android.btm.impl.page.model;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Deprecated(message = "use ActivityResumeOriginV2 instead.")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/btm/impl/page/model/ActivityResumeOrigin;", "", "Background", "BackActivity", "BackProcess", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum ActivityResumeOrigin extends Enum<ActivityResumeOrigin> {
    public static final ActivityResumeOrigin BackActivity = null;
    public static final ActivityResumeOrigin BackProcess = null;
    public static final ActivityResumeOrigin Background = null;
    public static final /* synthetic */ ActivityResumeOrigin[] a = null;

    static {
        ActivityResumeOrigin r1 = new ActivityResumeOrigin("Background", 0);
        Background = r1;
        ActivityResumeOrigin r10 = new ActivityResumeOrigin("BackActivity", 1);
        BackActivity = r10;
        ActivityResumeOrigin r11 = new ActivityResumeOrigin("BackProcess", 2);
        BackProcess = r11;
        a = new ActivityResumeOrigin[]{r1, r10, r11};
    }

    public static ActivityResumeOrigin valueOf(String r1) {
        return (ActivityResumeOrigin) r27.a.a(ActivityResumeOrigin.class, r1);
    }

    public static ActivityResumeOrigin[] values() {
        return (ActivityResumeOrigin[]) a.clone();
    }

    public ActivityResumeOrigin(String r1, int r10) {
        super(r1, r10);
    }
}
