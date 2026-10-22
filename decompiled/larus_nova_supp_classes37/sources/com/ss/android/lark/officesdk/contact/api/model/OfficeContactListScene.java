package com.ss.android.lark.officesdk.contact.api.model;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactListScene;", "", "<init>", "(Ljava/lang/String;I)V", "FULL_COLD", "INCR_SHORT", "contact-officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum OfficeContactListScene extends Enum<OfficeContactListScene> {
    public static final OfficeContactListScene FULL_COLD = null;
    public static final OfficeContactListScene INCR_SHORT = null;
    public static final /* synthetic */ OfficeContactListScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeContactListScene> getEntries() {
        return b;
    }

    static {
        OfficeContactListScene r0 = new OfficeContactListScene("FULL_COLD", 0);
        FULL_COLD = r0;
        OfficeContactListScene r1 = new OfficeContactListScene("INCR_SHORT", 1);
        INCR_SHORT = r1;
        OfficeContactListScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static OfficeContactListScene[] values() {
        return (OfficeContactListScene[]) a.clone();
    }

    public static OfficeContactListScene valueOf(String r1) {
        return (OfficeContactListScene) a.a(OfficeContactListScene.class, r1);
    }

    public OfficeContactListScene(String r1, int r2) {
        super(r1, r2);
    }
}
