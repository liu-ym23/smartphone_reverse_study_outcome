package com.obric.oui.sheet.v2;

import android.content.Context;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"SHEET_LANDSCAPE_MAX_CONTENT_HEIGHT", "", "SHEET_LANDSCAPE_MAX_WIDTH", "SHEET_PADDING_BOTTOM", "SHEET_PADDING_BOTTOM_WITH_THREE_BTN_MODE", "getSheetMaxWidth", "context", "Landroid/content/Context;", "expected", "getTargetDimAmount", "", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class b {
    public static final float a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        if ((ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        return 0.5f;
    L8:
        return 0.16f;
    L5:
        r4 = false;
        goto L6
    }

    public static final int a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (j.f13505a.a(r4) == true) goto L5;
        return r3;
    L5:
        return RangesKt.coerceAtMost(r3, h.a(r4, 480));
    }
}
