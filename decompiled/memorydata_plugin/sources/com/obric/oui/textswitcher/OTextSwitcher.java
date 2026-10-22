package com.obric.oui.textswitcher;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.common.util.m;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Timer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u001a\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006$"}, d2 = {"Lcom/obric/oui/textswitcher/OTextSwitcher;", "Landroid/widget/TextSwitcher;", "Lcom/obric/oui/textswitcher/IOTextSwitcher;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defaultViewFactory", "Landroid/widget/ViewSwitcher$ViewFactory;", "getDefaultViewFactory", "()Landroid/widget/ViewSwitcher$ViewFactory;", "defaultViewFactory$delegate", "Lkotlin/Lazy;", "hadStart", "", "mOTextSwitcherTimer", "Ljava/util/Timer;", "mUiHander", "Landroid/os/Handler;", "getMUiHander", "()Landroid/os/Handler;", "mUiHander$delegate", "oTextSwitcherSpec", "Lcom/obric/oui/textswitcher/TextSwitcherSpec;", "textSwitcherOnAttachStateChangeListener", "com/obric/oui/textswitcher/OTextSwitcher$textSwitcherOnAttachStateChangeListener$1", "Lcom/obric/oui/textswitcher/OTextSwitcher$textSwitcherOnAttachStateChangeListener$1;", "build", "", "spec", "safeUpdateText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "startAfterBuild", "stopAnim", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTextSwitcher extends TextSwitcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f14715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14716b;
    private final Lazy c;
    private Timer d;
    private final Lazy e;
    private final a f;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/oui/textswitcher/OTextSwitcher$textSwitcherOnAttachStateChangeListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", BaseSwitches.V, "Landroid/view/View;", "onViewDetachedFromWindow", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTextSwitcher f14717a;

        a(OTextSwitcher r1) {
            this.f14717a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r1) {
            Intrinsics.checkNotNullParameter(r1, BaseSwitches.V);
            m.a("the o textview switcher component had attach to window");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, BaseSwitches.V);
            m.a("the o textview switcher component had detach to window");
            this.f14717a.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OTextSwitcher(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OTextSwitcher(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        this.c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(OTextSwitcher$mUiHander$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        this.e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OTextSwitcher$defaultViewFactory$2(r5, this), Function0.class, "com.obric.memorydata.plugin"));
        this.f = new a(this);
    }

    public /* synthetic */ OTextSwitcher(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ d a(OTextSwitcher r0) {
        return r0.f14715a;
    }

    private final ViewSwitcher.ViewFactory getDefaultViewFactory() {
        return (ViewSwitcher.ViewFactory) ZeusTransformUtils.preCheckCast(this.e.getValue(), ViewSwitcher.ViewFactory.class, "com.obric.memorydata.plugin");
    }

    private final Handler getMUiHander() {
        return (Handler) ZeusTransformUtils.preCheckCast(this.c.getValue(), Handler.class, "com.obric.memorydata.plugin");
    }

    public void a() {
        this.f14716b = false;
        clearAnimation();     // Catch: Exception -> L9
        Timer r0 = this.d;     // Catch: Exception -> L9
        if (r0 == null) goto L7;
        r0.cancel();     // Catch: Exception -> L9
    L7:
        this.d = null;     // Catch: Exception -> L9
        Unit r2 = Unit.INSTANCE;     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        m.a(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        Throwable r3 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
        Unit r4 = Unit.INSTANCE;
    }
}
