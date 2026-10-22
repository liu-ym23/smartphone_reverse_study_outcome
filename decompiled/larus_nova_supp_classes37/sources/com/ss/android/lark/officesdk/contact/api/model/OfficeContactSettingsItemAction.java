package com.ss.android.lark.officesdk.contact.api.model;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactSettingsItemAction;", "", "<init>", "(Ljava/lang/String;I)V", "TOGGLE", "contact-officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum OfficeContactSettingsItemAction extends Enum<OfficeContactSettingsItemAction> {
    public static final OfficeContactSettingsItemAction TOGGLE = null;
    public static final /* synthetic */ OfficeContactSettingsItemAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeContactSettingsItemAction> getEntries() {
        return b;
    }

    static {
        OfficeContactSettingsItemAction r0 = new OfficeContactSettingsItemAction();
        TOGGLE = r0;
        OfficeContactSettingsItemAction[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public OfficeContactSettingsItemAction() {
        super("TOGGLE", 0);
    }

    public static OfficeContactSettingsItemAction[] values() {
        return (OfficeContactSettingsItemAction[]) a.clone();
    }

    public static OfficeContactSettingsItemAction valueOf(String r1) {
        return (OfficeContactSettingsItemAction) a.a(OfficeContactSettingsItemAction.class, r1);
    }
}
