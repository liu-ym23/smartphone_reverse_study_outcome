package com.obric.memorydata.ui.settingsharness;

import android.content.Context;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"resolve", "", "Lcom/obric/memorydata/ui/settingsharness/SettingsText;", "anchor", "Landroid/view/View;", "ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class m {
    public static final String a(q r2, View r3) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "anchor");
        if (ZeusTransformUtils.instanceOf(r4, q.a.class) == false) goto L6;
        return ((q.a) ZeusTransformUtils.preCheckCast(r4, q.a.class, "com.obric.memorydata.plugin")).a();
    L6:
        if (ZeusTransformUtils.instanceOf(r4, q.b.class) == false) goto L10;
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(((q.b) ZeusTransformUtils.preCheckCast(r4, q.b.class, "com.obric.memorydata.plugin")).a());
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        return r5;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
