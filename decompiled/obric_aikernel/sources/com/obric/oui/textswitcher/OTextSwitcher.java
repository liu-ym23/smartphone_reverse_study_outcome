package com.obric.oui.textswitcher;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher;
import com.obric.oui.common.util.i;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Timer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\b\u001a\u00020\u00038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/textswitcher/OTextSwitcher;", "Landroid/widget/TextSwitcher;", "", "Landroid/widget/ViewSwitcher$ViewFactory;", "i", "Lkotlin/Lazy;", "getDefaultViewFactory", "()Landroid/widget/ViewSwitcher$ViewFactory;", "defaultViewFactory", "Landroid/os/Handler;", "g", "getMUiHander", "()Landroid/os/Handler;", "mUiHander", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OTextSwitcher extends TextSwitcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.oui.textswitcher.a f7633c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f7634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Timer f7635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f7636i;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OTextSwitcher f7637c;

        a(OTextSwitcher r10) {
            this.f7637c = r10;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            Intrinsics.checkNotNullParameter(r10, BaseSwitches.V);
            i.a("the o textview switcher component had attach to window");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            Intrinsics.checkNotNullParameter(r10, BaseSwitches.V);
            i.a("the o textview switcher component had detach to window");
            this.f7637c.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OTextSwitcher(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OTextSwitcher(final Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.f7634g = LazyKt.lazy(OTextSwitcher$mUiHander$2.INSTANCE);
        this.f7636i = LazyKt.lazy(new OTextSwitcher$defaultViewFactory$2(this, r10));
        new a(this);
    }

    public /* synthetic */ OTextSwitcher(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ com.obric.oui.textswitcher.a a(OTextSwitcher r10) {
        return r10.f7633c;
    }

    private final ViewSwitcher.ViewFactory getDefaultViewFactory() {
        return (ViewSwitcher.ViewFactory) this.f7636i.getValue();
    }

    private final Handler getMUiHander() {
        return (Handler) this.f7634g.getValue();
    }

    public void b() {
        clearAnimation();     // Catch: Exception -> L7
        Timer r10 = this.f7635h;     // Catch: Exception -> L7
        if (r10 == null) goto L5;
        r10.cancel();     // Catch: Exception -> L7
    L5:
        this.f7635h = null;     // Catch: Exception -> L7
        Unit r11 = Unit.INSTANCE;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        i.a("Try exception occur " + e.getMessage());
        Unit r12 = Unit.INSTANCE;
    }
}
