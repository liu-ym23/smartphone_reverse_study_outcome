package com.obric.oui.textswitcher;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/textswitcher/OTextSwitcher;", "Landroid/widget/TextSwitcher;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/os/Handler;", "a", "Lkotlin/Lazy;", "getMUiHander", "()Landroid/os/Handler;", "mUiHander", "Landroid/widget/ViewSwitcher$ViewFactory;", "b", "getDefaultViewFactory", "()Landroid/widget/ViewSwitcher$ViewFactory;", "defaultViewFactory", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTextSwitcher extends TextSwitcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f14756c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f14757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f14758b;

    @JvmOverloads
    public OTextSwitcher(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    private final ViewSwitcher.ViewFactory getDefaultViewFactory() {
        return (ViewSwitcher.ViewFactory) this.f14758b.getValue();
    }

    private final Handler getMUiHander() {
        return (Handler) this.f14757a.getValue();
    }

    @JvmOverloads
    public OTextSwitcher(final Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.f14757a = LazyKt.lazy(OTextSwitcher$mUiHander$2.INSTANCE);
        this.f14758b = LazyKt.lazy(new OTextSwitcher$defaultViewFactory$2(r5, this));
    }
}
