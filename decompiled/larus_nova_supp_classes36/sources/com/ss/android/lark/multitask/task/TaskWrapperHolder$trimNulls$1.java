package com.ss.android.lark.multitask.task;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/multitask/task/TaskWrapper;", "invoke", "(Lcom/ss/android/lark/multitask/task/TaskWrapper;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class TaskWrapperHolder$trimNulls$1 extends Lambda implements Function1<e, Boolean> {
    public static final TaskWrapperHolder$trimNulls$1 INSTANCE = null;

    static {
        INSTANCE = new TaskWrapperHolder$trimNulls$1();
    }

    public TaskWrapperHolder$trimNulls$1() {
        super(1);
    }

    public final Boolean invoke(e r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if ((r2 instanceof b) == true) goto L5;
    L7:
        boolean r3 = false;
    L9:
        return Boolean.valueOf(r3);
    L5:
        if (((b) r2).a() != null) goto L7;
        r3 = true;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((e) r1);
    }
}
