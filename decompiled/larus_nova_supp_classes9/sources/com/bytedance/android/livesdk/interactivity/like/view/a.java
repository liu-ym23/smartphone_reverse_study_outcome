package com.bytedance.android.livesdk.interactivity.like.view;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a extends View implements v32.b {
    public final List<v32.a> a;
    public boolean b;
    public final DataCenter c;

    @Override // v32.b
    public abstract /* synthetic */ View getTapView();

    public abstract /* synthetic */ View getView();

    @Override // v32.b
    public void clear() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((v32.a) r0.next()).clear();
        goto L4
    }

    @Override // v32.b
    public void init() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((v32.a) r0.next()).b(this.c);
        goto L4
    }

    @Override // v32.b
    public void load() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((v32.a) r0.next()).load();
        goto L4
    }

    @Override // v32.b
    public void unload() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((v32.a) r0.next()).unload();
        goto L4
    }

    public final List<v32.a> getControllerList() {
        return this.a;
    }

    public final DataCenter getDataCenter() {
        return this.c;
    }

    public final boolean getHasReportDiggDisable() {
        return this.b;
    }

    @Override // v32.b
    public final void c(v32.a r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        ((ArrayList) this.a).add(r2);
    }

    public final void setHasReportDiggDisable(boolean r1) {
        this.b = r1;
    }

    public a(Context r1, DataCenter r2) {
        super(r1);
        this.c = r2;
        this.a = new ArrayList();
    }
}
