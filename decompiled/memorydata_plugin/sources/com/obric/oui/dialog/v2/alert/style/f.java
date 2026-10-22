package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B(\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/OViewStyleController;", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "body", "Lkotlin/Function1;", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "dialogContainer", "", "(Lkotlin/jvm/functions/Function1;)V", "attachToHost", "host", "Lcom/obric/oui/dialog/v2/alert/style/AlertDialogHost;", "attachToParent", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<d, Unit> f13827a;

    public f(Function1<? super d, Unit> r3) {
        Function1<d, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "body");
        this.f13827a = r4;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.g
    public void a(Context r3, d r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "dialogContainer");
        this.f13827a.invoke(r6);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.g
    public void a(AbstractDialog r3) {
        g.a.a((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.g
    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "host");
        g.a.a((g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin"), r4);
    }
}
