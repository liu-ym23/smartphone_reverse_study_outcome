package com.obric.memorydata.ui.settingsharness;

import android.content.Context;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/OToastSettingsRejectionPresenter;", "Lcom/obric/memorydata/ui/settingsharness/SettingsRejectionPresenter;", "<init>", "()V", "present", "", "anchor", "Landroid/view/View;", "message", "Lcom/obric/memorydata/ui/settingsharness/SettingsText;", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13027a = null;

    static {
        f13027a = new a();
    }

    private a() {
    }

    @Override // com.obric.memorydata.ui.settingsharness.l
    public void a(View r8, q r9) {
        q r7 = (q) ZeusTransformUtils.wrapperContextForParams(r9, q.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "anchor");
        Intrinsics.checkNotNullParameter(r7, "message");
        com.obric.oui.toast.a.C0786a r1 = com.obric.oui.toast.a.f14807a;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "getContext(...)");
        com.obric.oui.toast.a.C0786a.a(r1, r2, m.a(r7, r8), 0, 4, null);
    }
}
