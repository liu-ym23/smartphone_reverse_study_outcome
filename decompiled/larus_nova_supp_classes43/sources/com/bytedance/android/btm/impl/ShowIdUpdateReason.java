package com.bytedance.android.btm.impl;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/btm/impl/ShowIdUpdateReason;", "", "(Ljava/lang/String;I)V", "ActivityPreStart", "ActivityPreResume", "ManualPageShow", "PageInfoResume", "btm-impl_cnRelease"}, k = 1, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final enum ShowIdUpdateReason extends Enum<ShowIdUpdateReason> {
    private static final /* synthetic */ ShowIdUpdateReason[] $VALUES = null;
    public static final ShowIdUpdateReason ActivityPreResume = null;
    public static final ShowIdUpdateReason ActivityPreStart = null;
    public static final ShowIdUpdateReason ManualPageShow = null;
    public static final ShowIdUpdateReason PageInfoResume = null;

    static {
        ShowIdUpdateReason r1 = new ShowIdUpdateReason("ActivityPreStart", 0);
        ActivityPreStart = r1;
        ShowIdUpdateReason r10 = new ShowIdUpdateReason("ActivityPreResume", 1);
        ActivityPreResume = r10;
        ShowIdUpdateReason r11 = new ShowIdUpdateReason("ManualPageShow", 2);
        ManualPageShow = r11;
        ShowIdUpdateReason r12 = new ShowIdUpdateReason("PageInfoResume", 3);
        PageInfoResume = r12;
        $VALUES = new ShowIdUpdateReason[]{r1, r10, r11, r12};
    }

    public static ShowIdUpdateReason valueOf(String r1) {
        return (ShowIdUpdateReason) r27.a.a(ShowIdUpdateReason.class, r1);
    }

    public static ShowIdUpdateReason[] values() {
        return (ShowIdUpdateReason[]) $VALUES.clone();
    }

    private ShowIdUpdateReason(String r1, int r10) {
        super(r1, r10);
    }
}
