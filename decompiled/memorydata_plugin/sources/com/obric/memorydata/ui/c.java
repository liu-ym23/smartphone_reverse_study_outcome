package com.obric.memorydata.ui;

import android.app.Activity;
import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/ui/FloatingTitleBarTransition;", "", "<init>", "()V", "notifyLaunch", "", "activity", "Landroid/app/Activity;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "shouldNotifyLaunch", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12990a = null;

    static {
        f12990a = new c();
    }

    private c() {
    }

    private final boolean a(Intent r2) {
        if ((r2.getFlags() & 403177472) == 0) goto L6;
        return false;
    L6:
        if (r2.getComponent() == null) goto L9;
        return true;
    L9:
        return false;
    }

    public final void a(Activity r3, Intent r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        if (a(r4) == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L8;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        OFloatingTitleBar r6 = r2.getCurrentFloatingTitleBar();
        if (r6 != null) goto L14;
        return;
    L14:
        com.obric.oui.titlebar.floating.a.f14784a.a(r5, r6, r2.getCurrentFloatingTitleBarActionHost());
        return;
    L8:
        r2 = null;
        goto L9
    }
}
