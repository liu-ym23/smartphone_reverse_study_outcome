package com.larus.contextwindow.impl.actionbar;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.actionbar.api.IActionBarProvider;
import com.larus.bmhome.view.actionbar.custom.router.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ss8.e;
import w29.d;
import w29.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/contextwindow/impl/actionbar/ContextWindowActionBarProvider;", "Lcom/larus/bmhome/view/actionbar/api/IActionBarProvider;", "<init>", "()V", "provideSegments", "", "Lcom/larus/bmhome/view/actionbar/api/IActionBarSegment;", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "provideSchemaRouterProcessors", "Lcom/larus/bmhome/view/actionbar/custom/router/IOpenBySchemaRouterProcessor;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowActionBarProvider implements IActionBarProvider {
    public ContextWindowActionBarProvider() {
    }

    public final List<b> a() {
        return CollectionsKt.listOf(new d());
    }

    public final List<e> b(t1a.b r2, Context r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        return CollectionsKt.listOf(new f(r2, r3));
    }
}
