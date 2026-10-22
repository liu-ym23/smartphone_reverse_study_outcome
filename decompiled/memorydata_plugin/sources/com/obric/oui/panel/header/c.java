package com.obric.oui.panel.header;

import android.content.Context;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B#\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u0005H\u0004J\u0006\u0010(\u001a\u00020\u0003J\b\u0010)\u001a\u00020$H&J\u0006\u0010*\u001a\u00020$R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0001\u0007+,-./01¨\u00062"}, d2 = {"Lcom/obric/oui/panel/header/BasicPanelHeader;", "", "context", "Landroid/content/Context;", "useAutoSwitchTheme", "", "themeResId", "", "(Landroid/content/Context;ZI)V", "closeClickListenerOnPad", "Landroid/view/View$OnClickListener;", "getCloseClickListenerOnPad", "()Landroid/view/View$OnClickListener;", "setCloseClickListenerOnPad", "(Landroid/view/View$OnClickListener;)V", "getContext", "()Landroid/content/Context;", "forceSupportSwipeToClose", "getForceSupportSwipeToClose", "()Z", "setForceSupportSwipeToClose", "(Z)V", "getThemeResId", "()I", "setThemeResId", "(I)V", "themedContext", "titleOnPad", "", "getTitleOnPad", "()Ljava/lang/String;", "setTitleOnPad", "(Ljava/lang/String;)V", "getUseAutoSwitchTheme", "setUseAutoSwitchTheme", "viewOnPad", "Landroid/view/View;", "generateThemedContext", "baseContext", "autoSwitchDayNight", "getThemedContext", "getView", "getViewOnPad", "Lcom/obric/oui/panel/header/BasicPanelDefaultHeader;", "Lcom/obric/oui/panel/header/BasicPanelCustomViewHeader;", "Lcom/obric/oui/panel/header/BasicPanelDragHeader;", "Lcom/obric/oui/panel/header/BasicPanelNormalTitleBarHeader;", "Lcom/obric/oui/panel/header/BasicPanelTextTitleBarHeader;", "Lcom/obric/oui/panel/header/BasicPanelCompoundTitleBarHeader;", "Lcom/obric/oui/panel/header/BasicPanelButtonTitleBarHeader;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14283b;
    private int c;
    private Context d;
    private boolean e;

    private c(Context r3, boolean r4, int r5) {
        this.f14282a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f14283b = r4;
        this.c = r5;
        this.e = true;
    }

    public /* synthetic */ c(Context r2, boolean r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r3, r4, null);
    }

    public /* synthetic */ c(Context r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static /* synthetic */ Context a(c r2, Context r3, boolean r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r4 = r2.f14283b;
    L8:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.a(r7, r4), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateThemedContext");
    }

    public final Context a(Context r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "baseContext");
        if (this.c == 0) goto L7;
        ContextThemeWrapper r8 = new ContextThemeWrapper(r7, this.c);
    L11:
        return (Context) ZeusTransformUtils.preCheckCast(r8, Context.class, "com.obric.memorydata.plugin");
    L7:
        if (r6 == false) goto L9;
        r8 = new ContextThemeWrapper(r7, ZeusTransformUtils.mapRes(R.style.OBasicPanelDayNightSwitch, "style", "OBasicPanelDayNightSwitch"));
    L10:
        this.d = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(r8, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        goto L11
    L9:
        r8 = new ContextThemeWrapper(r7, ZeusTransformUtils.mapRes(R.style.OBasicPanelConstLight, "style", "OBasicPanelConstLight"));
        goto L10
    }

    public abstract View a();

    public final boolean b() {
        return this.e;
    }

    public final Context c() {
        Context r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(this, this.f14282a, false, 2, null), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    public final Context getContext() {
        return this.f14282a;
    }
}
