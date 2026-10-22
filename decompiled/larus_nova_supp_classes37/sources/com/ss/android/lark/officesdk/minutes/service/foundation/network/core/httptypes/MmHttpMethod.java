package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpMethod;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "PUT", "DELETE", "PATCH", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmHttpMethod extends Enum<MmHttpMethod> {
    public static final MmHttpMethod DELETE = null;
    public static final MmHttpMethod GET = null;
    public static final MmHttpMethod PATCH = null;
    public static final MmHttpMethod POST = null;
    public static final MmHttpMethod PUT = null;
    public static final /* synthetic */ MmHttpMethod[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmHttpMethod> getEntries() {
        return b;
    }

    static {
        MmHttpMethod r0 = new MmHttpMethod("GET", 0);
        GET = r0;
        MmHttpMethod r1 = new MmHttpMethod("POST", 1);
        POST = r1;
        MmHttpMethod r3 = new MmHttpMethod("PUT", 2);
        PUT = r3;
        MmHttpMethod r5 = new MmHttpMethod("DELETE", 3);
        DELETE = r5;
        MmHttpMethod r7 = new MmHttpMethod("PATCH", 4);
        PATCH = r7;
        MmHttpMethod[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static MmHttpMethod[] values() {
        return (MmHttpMethod[]) a.clone();
    }

    public static MmHttpMethod valueOf(String r1) {
        return (MmHttpMethod) a.a(MmHttpMethod.class, r1);
    }

    public MmHttpMethod(String r1, int r2) {
        super(r1, r2);
    }
}
