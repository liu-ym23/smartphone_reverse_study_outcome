package com.obric.oui.panel.header;

import android.content.Context;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f7009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7011e;

    private b(Context r10, boolean r11, int r12) {
        this.f7009c = r10;
        this.f7010d = r11;
        this.f7011e = r12;
        this.f7008b = true;
    }

    /* synthetic */ b(Context r10, boolean r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static /* synthetic */ Context b(b r10, Context r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = r10.f7010d;
    L7:
        return r10.a(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateThemedContext");
    }

    protected final Context a(Context r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "baseContext");
        if (this.f7011e != 0) goto L10;
        if (r11 == false) goto L7;
        ContextThemeWrapper r12 = new ContextThemeWrapper(r10, k.OBasicPanelDayNightSwitch);
    L8:
        this.f7007a = r12;
        return r12;
    L7:
        r12 = new ContextThemeWrapper(r10, k.OBasicPanelConstLight);
        goto L8
    L10:
        return new ContextThemeWrapper(r10, this.f7011e);
    }

    public final boolean c() {
        return this.f7008b;
    }

    public final Context d() {
        Context r10 = this.f7007a;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return b(this, this.f7009c, false, 2, null);
    }

    public abstract View e();
}
