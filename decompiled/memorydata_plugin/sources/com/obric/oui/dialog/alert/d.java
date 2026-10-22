package com.obric.oui.dialog.alert;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B(\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/dialog/alert/OViewStyleController;", "Lcom/obric/oui/dialog/alert/StyleController;", "body", "Lkotlin/Function1;", "Landroid/widget/FrameLayout;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "parent", "", "(Lkotlin/jvm/functions/Function1;)V", "attachToDialog", "dialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "attachToParent", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<FrameLayout, Unit> f13796a;

    public d(Function1<? super FrameLayout, Unit> r3) {
        Function1<FrameLayout, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "body");
        this.f13796a = r4;
    }

    @Override // com.obric.oui.dialog.alert.e
    public void a(Context r3, FrameLayout r4) {
        Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        this.f13796a.invoke(r4);
    }

    @Override // com.obric.oui.dialog.alert.e
    public void a(b r1) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
    }
}
