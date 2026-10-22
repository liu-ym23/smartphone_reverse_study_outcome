package com.larus.bmhome.chat.standarduikit.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.layout.widget.AppletWidget;
import com.larus.bmhome.chat.layout.widget.u;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import go8.a;
import go8.f;
import go8.g;
import ho8.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ro8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J;\u0010\u0019\u001a\u00020\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020!J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020\u0016H\u0002J\u0006\u0010(\u001a\u00020\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/widget/view/WidgetView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/widget/view/WidgetViewInput;", "Lcom/larus/bmhome/chat/standarduikit/widget/view/WidgetViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "widgetBindData", "Lcom/larus/bmhome/chat/layout/widget/AppletBindData;", "appletView", "Lcom/larus/bmhome/chat/layout/widget/AppletWidget;", "getAppletView", "()Lcom/larus/bmhome/chat/layout/widget/AppletWidget;", "appletView$delegate", "Lkotlin/Lazy;", "output", "getAppletWidget", "bindLongClickListener", "", "listener", "Landroid/view/View$OnLongClickListener;", "updateRadius", "topLeftRadius", "", "topRightRadius", "botLeftRadius", "botRightRadius", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getMaxWidth", "", "setMaxWidth", "value", "bindData", "input", "setupWidgetEventCallback", "setupExpose", "onViewRecycled", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetView extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public u a;
    public final Lazy b;
    public g c;

    private final AppletWidget getAppletView() {
        return (AppletWidget) this.b.getValue();
    }

    public final void c() {
        AppletWidget r0 = getAppletView();
        u r1 = this.a;
        String r2 = null;
        if (r1 == null) goto L5;
        Fragment r3 = r1.g;
    L6:
        if (r1 == null) goto L8;
        String r4 = r1.b;
    L10:
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        if (r1 == null) goto L14;
        String r6 = r1.c;
    L15:
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        if (r1 == null) goto L19;
        String r7 = r1.d;
    L20:
        if (r7 != null) goto L22;
        r7 = "";
    L22:
        if (r1 == null) goto L24;
        String r8 = r1.e;
    L25:
        if (r8 != null) goto L27;
        r8 = "";
    L27:
        if (r1 == null) goto L29;
        r2 = r1.a;
    L29:
        if (r2 != null) goto L31;
        r2 = "";
    L31:
        if (r1 == null) goto L33;
        int r9 = r1.h;
    L34:
        if (r1 == null) goto L36;
        boolean r10 = r1.l;
    L37:
        r0.e(r3, r2, r4, r6, r7, r8, r9, r10);
        return;
    L36:
        r10 = true;
        goto L37
    L33:
        r9 = -1;
        goto L34
    L24:
        r8 = null;
        goto L25
    L19:
        r7 = null;
        goto L20
    L14:
        r6 = null;
        goto L15
    L8:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final AppletWidget getAppletWidget() {
        return getAppletView();
    }

    public final int getMaxWidth() {
        return getAppletView().getMaxWidth();
    }

    public WidgetView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void b(b r2) {
        setOnLongClickListener(r2);
        AppletWidget r0 = getAppletView();
        r0.q = r2;
        r0.i(r2);
    }

    public final void setMaxWidth(int r2) {
        getAppletView().setMaxWidth(r2);
    }

    public WidgetView(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = LazyKt.lazy(new a(r2));
        addView(getAppletView(), new ViewGroup.LayoutParams(-2, -2));
    }

    public final void a(f r4, c.b r5) {
        Intrinsics.checkNotNullParameter(r4, "input");
        Intrinsics.checkNotNullParameter(r5, "output");
        getAppletView().setMaxWidth(r4.a);
        getAppletView().b(r4.c);
        this.a = r4.c;
        this.c = r5;
        if (getAppletView().getWidgetEventCallback() != null) goto L6;
        getAppletView().setWidgetEventCallback(new go8.c(this));
    L6:
        ExposeXTrackerExtKt.b(this, new go8.b(this));
        float r6 = r4.d;
        getAppletView().j(Float.valueOf(r6), Float.valueOf(r6), Float.valueOf(r6), Float.valueOf(r6));
    }
}
