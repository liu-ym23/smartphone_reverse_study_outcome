package com.bytedance.android.live.revlink.link.core.service;

import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/i6;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/i6;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class LayoutChangeManager$attach$1 extends FunctionReferenceImpl implements Function1<i6, Unit> {
    public LayoutChangeManager$attach$1(l r8) {
        super(1, r8, l.class, "onLinkerMessage", "onLinkerMessage(Lcom/bytedance/android/livesdk/link/model/ILinkerMessage;)V", 0);
    }

    public final void invoke(i6 r8) {
        Intrinsics.checkNotNullParameter(r8, "p1");
        l r0 = (l) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "$this$sceneExt");
        if (((int) r8.getScene()) == 1) goto L7;
        Intrinsics.checkNotNullParameter(r8, "$this$sceneExt");
        if (((int) r8.getScene()) == 7) goto L7;
        return;
    L7:
        Intrinsics.checkNotNullParameter(r8, "$this$typeExt");
        if (((int) r8.getType2()) != 51) goto L46;
        IAnchorUpdateLayoutContent r9 = r8.getAnchorUpdateLayoutContent();
        if (r9 == null) goto L44;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r1 = (IAnchorUpdateLayoutContent.AnchorLayoutRange) ArraysKt.getOrNull(IAnchorUpdateLayoutContent.AnchorLayoutRange.values(), r9.getAnchorLayoutRange());
        if (r1 != null) goto L15;
        r1 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
    L15:
        IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r3 = (IAnchorUpdateLayoutContent.UpdateAnchorLayoutType) ArraysKt.getOrNull(IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.values(), r9.getUpdateLayoutType());
        if (r3 != null) goto L18;
        r3 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown;
    L18:
        r0.c.a(new o(r9.getLayoutDetails()), Constants.OperatorKey.MSG);
        int r4 = r9.getAnchorUILayout();
        if (r4 == o51.f.j.e.b) goto L21;
        String r6 = "";
        if (r4 != o51.f.b.e.b) goto L33;
        String r5 = r9.getUpdateUserID();
        String r10 = r9.getUpdateUserID();
        Intrinsics.checkNotNullParameter(r10, "$this$linkerID");
        Intrinsics.checkNotNullParameter(r10, "$this$linkerID");
        String r12 = com.bytedance.android.live.revlink.link.biz.service.j.a.a(r0, r10);
        if (r12 == null) goto L30;
        r6 = r12;
    L30:
        o51.e r2 = new o51.e.c(r5, r6, r1, r3);
    L31:
        o51.e r13 = r2;
    L40:
        if (r13 == null) goto L47;
        r0.c.f(r13, "ui layout change msg");
        return;
    L47:
        return;
    L33:
        if (r4 != o51.f.c.e.b) goto L39;
        String r7 = r9.getUpdateUserID();
        String r14 = r9.getUpdateUserID();
        Intrinsics.checkNotNullParameter(r14, "$this$linkerID");
        Intrinsics.checkNotNullParameter(r14, "$this$linkerID");
        String r15 = com.bytedance.android.live.revlink.link.biz.service.j.a.a(r0, r14);
        if (r15 == null) goto L38;
        r6 = r15;
    L38:
        r2 = new o51.e.d(r7, r6, r1, r3);
        goto L31
    L39:
        r13 = null;
        goto L40
    L21:
        if (r0.getContext().getScene() != 1) goto L23;
        r13 = h.a(r0);
        goto L40
    L23:
        r13 = o51.e.f.e;
        goto L40
    L44:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((i6) r1);
        return Unit.INSTANCE;
    }
}
