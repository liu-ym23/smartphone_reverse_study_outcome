package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/httptypes/MmHttpContentType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "JSON", "FORM_URL_ENCODED", "CUSTOM", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmHttpContentType extends Enum<MmHttpContentType> {
    public static final MmHttpContentType CUSTOM = null;
    public static final MmHttpContentType FORM_URL_ENCODED = null;
    public static final MmHttpContentType JSON = null;
    public static final /* synthetic */ MmHttpContentType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<MmHttpContentType> getEntries() {
        return b;
    }

    static {
        MmHttpContentType r0 = new MmHttpContentType("JSON", 0, "application/json");
        JSON = r0;
        MmHttpContentType r1 = new MmHttpContentType("FORM_URL_ENCODED", 1, "application/x-www-form-urlencoded;charset=utf-8");
        FORM_URL_ENCODED = r1;
        MmHttpContentType r2 = new MmHttpContentType("CUSTOM", 2, "custom");
        CUSTOM = r2;
        MmHttpContentType[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static MmHttpContentType[] values() {
        return (MmHttpContentType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MmHttpContentType valueOf(String r1) {
        return (MmHttpContentType) a.a(MmHttpContentType.class, r1);
    }

    public MmHttpContentType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
