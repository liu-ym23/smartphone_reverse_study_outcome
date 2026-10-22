package com.larus.bmhome.floatchat.component;

import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u001a\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/floatchat/component/FoldHandlerVM;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/floatchat/component/FoldHandlerVMState;", "<init>", "()V", "foldFloatChat", "", "needAnim", "", "from", "", "toHalfScreen", "toNineSplitScreen", "toFullScreen", "setDragging", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FoldHandlerVM extends ComponentViewModel<FoldHandlerVMState> {
    public static final a Companion = null;
    private static final String TAG = "FoldHandlerVM";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ FoldHandlerVMState No(boolean r0, FoldHandlerVMState r1) {
        return toNineSplitScreen$lambda$2(r0, r1);
    }

    public static /* synthetic */ FoldHandlerVMState Oo(boolean r0, FoldHandlerVMState r1) {
        return foldFloatChat$lambda$0(r0, r1);
    }

    public static /* synthetic */ FoldHandlerVMState Po(boolean r0, FoldHandlerVMState r1) {
        return toHalfScreen$lambda$1(r0, r1);
    }

    public static /* synthetic */ FoldHandlerVMState Qo(boolean r0, FoldHandlerVMState r1) {
        return toFullScreen$lambda$3(r0, r1);
    }

    public static /* synthetic */ FoldHandlerVMState So(FoldHandlerVMState r0) {
        return setDragging$lambda$4(r0);
    }

    public final void setDragging() {
        FLogger.a.i(TAG, "setDragging");
        setStateImmediate(new f0());
    }

    public FoldHandlerVM() {
    }

    private static final FoldHandlerVMState setDragging$lambda$4(FoldHandlerVMState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setStateImmediate");
        return r2.copy(4, false);
    }

    private static final FoldHandlerVMState foldFloatChat$lambda$0(boolean r1, FoldHandlerVMState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setStateImmediate");
        return r2.copy(0, r1);
    }

    private static final FoldHandlerVMState toFullScreen$lambda$3(boolean r1, FoldHandlerVMState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setStateImmediate");
        return r2.copy(3, r1);
    }

    private static final FoldHandlerVMState toHalfScreen$lambda$1(boolean r1, FoldHandlerVMState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setStateImmediate");
        return r2.copy(1, r1);
    }

    private static final FoldHandlerVMState toNineSplitScreen$lambda$2(boolean r1, FoldHandlerVMState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setStateImmediate");
        return r2.copy(2, r1);
    }

    public final void foldFloatChat(final boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        FLogger.a.i(TAG, "foldFloatChat, needAnim = " + r4 + " from: " + r5);
        setStateImmediate(new b0(r4));
    }

    public final void toFullScreen(final boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        FLogger.a.i(TAG, "toFullScreen, needAnim = " + r4 + ", from = " + r5);
        setStateImmediate(new e0(r4));
    }

    public final void toHalfScreen(final boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        FLogger.a.i(TAG, "expandToHalfScreen, needAnim = " + r4 + " from:" + r5);
        setStateImmediate(new c0(r4));
    }

    public final void toNineSplitScreen(final boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        FLogger.a.i(TAG, "toNineSplitScreen, needAnim = " + r4 + ", from = " + r5);
        setStateImmediate(new d0(r4));
    }

    public static /* synthetic */ void foldFloatChat$default(FoldHandlerVM r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.foldFloatChat(r1, r2);
    }

    public static /* synthetic */ void toFullScreen$default(FoldHandlerVM r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = "";
    L8:
        r0.toFullScreen(r1, r2);
    }

    public static /* synthetic */ void toHalfScreen$default(FoldHandlerVM r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.toHalfScreen(r1, r2);
    }

    public static /* synthetic */ void toNineSplitScreen$default(FoldHandlerVM r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = "";
    L8:
        r0.toNineSplitScreen(r1, r2);
    }
}
