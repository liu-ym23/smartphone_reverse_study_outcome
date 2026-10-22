package com.obric.memorydata.memory.ui.list;

import android.view.View;
import android.view.ViewParent;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u0003H\u0002¨\u0006\b"}, d2 = {"setCardContentPressed", "", "view", "Landroid/view/View;", "pressed", "", "findParentCardListItem", "Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class bb {
    private static final DeviceAdaptiveCardListItem a(View r2) {
    L2:
        ViewParent r3 = r2.getParent();
        if (ZeusTransformUtils.instanceOf(r3, View.class) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r3, DeviceAdaptiveCardListItem.class) == true) goto L7;
        r2 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
        goto L2
    L7:
        return (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r3, DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    public static final /* synthetic */ void a(View r0, boolean r1) {
        b(r0, r1);
    }

    private static final void b(View r0, boolean r1) {
        DeviceAdaptiveCardListItem r2 = a(r0);
        if (r2 != null) goto L5;
        return;
    L5:
        r2.setContentChecked(r1);
        if (r1 == true) goto L9;
        r2.a();
        return;
    }
}
