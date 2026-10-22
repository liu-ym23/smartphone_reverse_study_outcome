package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/CloseDialogSource;", BuildConfig.FLAVOR, "Default", "ClickBack", "SaveDraft", "Publish", "SaveLocal", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CloseDialogSource extends Enum<CloseDialogSource> {
    public static final CloseDialogSource ClickBack = null;
    public static final CloseDialogSource Default = null;
    public static final CloseDialogSource Publish = null;
    public static final CloseDialogSource SaveDraft = null;
    public static final CloseDialogSource SaveLocal = null;
    public static final /* synthetic */ CloseDialogSource[] a = null;

    static {
        CloseDialogSource r1 = new CloseDialogSource("Default", 0);
        Default = r1;
        CloseDialogSource r2 = new CloseDialogSource("ClickBack", 1);
        ClickBack = r2;
        CloseDialogSource r3 = new CloseDialogSource("SaveDraft", 2);
        SaveDraft = r3;
        CloseDialogSource r4 = new CloseDialogSource("Publish", 3);
        Publish = r4;
        CloseDialogSource r5 = new CloseDialogSource("SaveLocal", 4);
        SaveLocal = r5;
        a = new CloseDialogSource[]{r1, r2, r3, r4, r5};
    }

    public static CloseDialogSource valueOf(String r1) {
        return (CloseDialogSource) r27.a.a(CloseDialogSource.class, r1);
    }

    public static CloseDialogSource[] values() {
        return (CloseDialogSource[]) a.clone();
    }

    public CloseDialogSource(String r1, int r2) {
        super(r1, r2);
    }
}
