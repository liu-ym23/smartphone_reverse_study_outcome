package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmStringCheckUtil {
    public boolean a;
    public StringCheckoutErrorType b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/MmStringCheckUtil$StringCheckoutErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "SAME", "NULL_OR_EMPTY", "NULL", "NOT_DEFINE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum StringCheckoutErrorType extends Enum<StringCheckoutErrorType> {
        public static final StringCheckoutErrorType NOT_DEFINE = null;
        public static final StringCheckoutErrorType NULL = null;
        public static final StringCheckoutErrorType NULL_OR_EMPTY = null;
        public static final StringCheckoutErrorType SAME = null;
        public static final /* synthetic */ StringCheckoutErrorType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<StringCheckoutErrorType> getEntries() {
            return b;
        }

        static {
            StringCheckoutErrorType r0 = new StringCheckoutErrorType("SAME", 0);
            SAME = r0;
            StringCheckoutErrorType r1 = new StringCheckoutErrorType("NULL_OR_EMPTY", 1);
            NULL_OR_EMPTY = r1;
            StringCheckoutErrorType r3 = new StringCheckoutErrorType("NULL", 2);
            NULL = r3;
            StringCheckoutErrorType r5 = new StringCheckoutErrorType("NOT_DEFINE", 3);
            NOT_DEFINE = r5;
            StringCheckoutErrorType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static StringCheckoutErrorType[] values() {
            return (StringCheckoutErrorType[]) a.clone();
        }

        public static StringCheckoutErrorType valueOf(String r1) {
            return (StringCheckoutErrorType) r27.a.a(StringCheckoutErrorType.class, r1);
        }

        public StringCheckoutErrorType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public MmStringCheckUtil(String r1) {
    }
}
