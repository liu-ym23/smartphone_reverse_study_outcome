package com.larus.doc.sdk.impl.generalbiz.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n39.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/ToolbarManager;", "", "<init>", "()V", "toolbarServiceDelegate", "Lcom/larus/doc/sdk/api/IToolbarService;", "setToolbarServiceDelegate", "", "delegate", "switchToNormalEditMode", "switchToReadOnlyMode", "notifyMoreAction", "type", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToolbarManager {
    public static final ToolbarManager INSTANCE = null;
    private static o toolbarServiceDelegate;

    static {
        INSTANCE = new ToolbarManager();
    }

    private ToolbarManager() {
    }

    public final void switchToNormalEditMode() {
        o r0 = toolbarServiceDelegate;
        if (r0 == null) goto L6;
        r0.switchToNormalEditMode();
        return;
    }

    public final void switchToReadOnlyMode() {
        o r0 = toolbarServiceDelegate;
        if (r0 == null) goto L6;
        r0.switchToReadOnlyMode();
        return;
    }

    public final void notifyMoreAction(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        o r0 = toolbarServiceDelegate;
        if (r0 == null) goto L6;
        r0.notifyMoreAction(r2);
        return;
    }

    public final void setToolbarServiceDelegate(o r1) {
        toolbarServiceDelegate = r1;
    }
}
