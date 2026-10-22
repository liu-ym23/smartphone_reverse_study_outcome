package com.bytedance.android.ec.adapter.api.handler.viewinterface;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/handler/viewinterface/ECExternalViewGroupAction;", "", "(Ljava/lang/String;I)V", "Add", "Remove", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECExternalViewGroupAction extends Enum<ECExternalViewGroupAction> {
    private static final /* synthetic */ ECExternalViewGroupAction[] $VALUES = null;
    public static final ECExternalViewGroupAction Add = null;
    public static final ECExternalViewGroupAction Remove = null;

    static {
        ECExternalViewGroupAction r1 = new ECExternalViewGroupAction("Add", 0);
        Add = r1;
        ECExternalViewGroupAction r10 = new ECExternalViewGroupAction("Remove", 1);
        Remove = r10;
        $VALUES = new ECExternalViewGroupAction[]{r1, r10};
    }

    public static ECExternalViewGroupAction valueOf(String r1) {
        return (ECExternalViewGroupAction) a.a(ECExternalViewGroupAction.class, r1);
    }

    public static ECExternalViewGroupAction[] values() {
        return (ECExternalViewGroupAction[]) $VALUES.clone();
    }

    private ECExternalViewGroupAction(String r1, int r10) {
        super(r1, r10);
    }
}
