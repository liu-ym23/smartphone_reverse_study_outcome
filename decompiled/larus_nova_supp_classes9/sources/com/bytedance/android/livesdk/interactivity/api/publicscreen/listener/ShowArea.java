package com.bytedance.android.livesdk.interactivity.api.publicscreen.listener;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/listener/ShowArea;", BuildConfig.FLAVOR, "Scroll", "Fold", "Float", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShowArea extends Enum<ShowArea> {
    public static final ShowArea Float = null;
    public static final ShowArea Fold = null;
    public static final ShowArea Scroll = null;
    public static final /* synthetic */ ShowArea[] a = null;

    static {
        ShowArea r1 = new ShowArea("Scroll", 0);
        Scroll = r1;
        ShowArea r2 = new ShowArea("Fold", 1);
        Fold = r2;
        ShowArea r3 = new ShowArea("Float", 2);
        Float = r3;
        a = new ShowArea[]{r1, r2, r3};
    }

    public static ShowArea valueOf(String r1) {
        return (ShowArea) a.a(ShowArea.class, r1);
    }

    public static ShowArea[] values() {
        return (ShowArea[]) a.clone();
    }

    public ShowArea(String r1, int r2) {
        super(r1, r2);
    }
}
