package com.xiphias.browser.scanner.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJD\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u0013¨\u0006\u0018"}, d2 = {"Lcom/xiphias/browser/scanner/util/UiUtils;", "", "<init>", "()V", "syncCardListItemSelectionState", "", "listItem", "Lcom/obric/oui/lisitem/OCardListItem;", "checked", "", "isActivityDestroyed", "context", "Landroid/content/Context;", "showPopoverSmartlyAtLocationInContainer", "container", "Landroid/view/ViewGroup;", "popover", "Lcom/obric/oui/popover/v2/OPopover;", "anchorX", "", "anchorY", "popoverGravity", "isMiddle", "yOffset", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f16358a = null;

    static {
        f16358a = new c();
    }

    private c() {
    }

    public final boolean a(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (ZeusTransformUtils.instanceOf(r3, Activity.class) == true) goto L5;
        return true;
    L5:
        if (((Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.memorydata.plugin")).isFinishing() == false) goto L7;
        return true;
    L7:
        if (Build.VERSION.SDK_INT >= 17) goto L9;
    L11:
        return false;
    L9:
        if (((Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.memorydata.plugin")).isDestroyed() == false) goto L11;
        return true;
    }
}
