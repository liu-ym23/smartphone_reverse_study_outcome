package com.larus.bmhome.view.utils;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/view/utils/SwipingControlVm;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "swipingControlFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getSwipingControlFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "scrollToPlayingMusicCardFlow", "Lcom/larus/bmhome/view/utils/SwipingControlVm$TargetMusicCardInfo;", "getScrollToPlayingMusicCardFlow", "TargetMusicCardInfo", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwipingControlVm extends ViewModel {
    private final MutableSharedFlow<a> scrollToPlayingMusicCardFlow;
    private final MutableSharedFlow<Boolean> swipingControlFlow;

    public static final class a {
        public final int a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "TargetMusicCardInfo(targetPosition=" + this.a + ", messageId=" + this.b + ')';
        }

        public a(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "messageId");
            this.a = r2;
            this.b = r3;
        }
    }

    public SwipingControlVm() {
        BufferOverflow r0 = BufferOverflow.DROP_OLDEST;
        this.swipingControlFlow = SharedFlowKt.MutableSharedFlow(1, 0, r0);
        this.scrollToPlayingMusicCardFlow = SharedFlowKt.MutableSharedFlow(0, 1, r0);
    }

    public final MutableSharedFlow<a> getScrollToPlayingMusicCardFlow() {
        return this.scrollToPlayingMusicCardFlow;
    }

    public final MutableSharedFlow<Boolean> getSwipingControlFlow() {
        return this.swipingControlFlow;
    }
}
