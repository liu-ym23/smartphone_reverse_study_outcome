package com.obric.aiproactive.ui.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/util/UserScrollReportGate;", "", "<init>", "()V", "touchInProgress", "", "userScrollObserved", "onTouchDown", "", "onScrolled", "onTouchEnd", "consumeOnIdle", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6899b;

    public q() {
    }

    public final void a() {
        this.f6898a = true;
        this.f6899b = false;
    }

    public final void b() {
        if (this.f6898a == false) goto L6;
        this.f6899b = true;
        return;
    }

    public final void c() {
        this.f6898a = false;
    }

    public final boolean d() {
        boolean r0 = this.f6899b;
        this.f6899b = false;
        this.f6898a = false;
        return r0;
    }
}
