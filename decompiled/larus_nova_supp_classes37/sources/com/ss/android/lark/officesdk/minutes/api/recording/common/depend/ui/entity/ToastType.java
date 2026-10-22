package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity;

import com.ss.android.lark.passport.base.core.log.LevelTypes;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/ToastType;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "SUCCESS", LevelTypes.TYPE_ERROR, "WARNING", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum ToastType extends Enum<ToastType> {
    public static final ToastType ERROR = null;
    public static final ToastType NORMAL = null;
    public static final ToastType SUCCESS = null;
    public static final ToastType WARNING = null;
    public static final /* synthetic */ ToastType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ToastType> getEntries() {
        return b;
    }

    static {
        ToastType r0 = new ToastType("NORMAL", 0);
        NORMAL = r0;
        ToastType r1 = new ToastType("SUCCESS", 1);
        SUCCESS = r1;
        ToastType r3 = new ToastType(LevelTypes.TYPE_ERROR, 2);
        ERROR = r3;
        ToastType r5 = new ToastType("WARNING", 3);
        WARNING = r5;
        ToastType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ToastType[] values() {
        return (ToastType[]) a.clone();
    }

    public static ToastType valueOf(String r1) {
        return (ToastType) a.a(ToastType.class, r1);
    }

    public ToastType(String r1, int r2) {
        super(r1, r2);
    }
}
