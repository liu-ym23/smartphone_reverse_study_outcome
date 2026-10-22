package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.mock.FakeMessageListAdapter;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements PublicScreenConfigSliderView.a {
    public final /* synthetic */ AnchorPublicScreenConfigDialog a;

    public a(AnchorPublicScreenConfigDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView.a
    public final void a(int r6) {
        AnchorPublicScreenConfigDialog r0 = this.a;
        r0.u = r6;
        SpaceItemDecoration r1 = r0.g;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceItemDecoration");
    L5:
        int r2 = q.a;
        int r3 = this.a.u;
        if (r3 == 1) goto L10;
        if (r3 == 2) goto L9;
        int r4 = PublicScreenStyleHelper.c;
    L12:
        if (PublicScreenABHelper.h().itemGapFitResolution == false) goto L14;
        r4 = (int) (r4 * q.f(true));
    L14:
        r1.a = r4;
        FakeMessageListAdapter r5 = this.a.h;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L17:
        if (r6 == 0) goto L23;
        if (r6 == 1) goto L22;
        if (r6 != 2) goto L23;
        int r7 = 16;
    L24:
        r5.getClass();
        r5.c = UtilityKotlinExtentionsKt.h(r7);
        return;
    L22:
        r7 = 14;
    L23:
        r7 = 12;
        goto L24
    L9:
        r4 = PublicScreenStyleHelper.e;
        goto L12
    L10:
        r4 = PublicScreenStyleHelper.d;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView.a
    public final void b(float r5) {
        AnchorPublicScreenConfigDialog r0 = this.a;
        float r1 = ((r0.z * r5) + 1.0f) * q.d(true, true);
        g52.e r6 = r0.i;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textConfig");
    L5:
        r6.i = r1;
        FakeMessageListAdapter r7 = r0.h;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L8:
        g52.e r3 = r0.i;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("textConfig");
    L11:
        r7.b = r3;
        r0.T90(r0.q, new y(r1));
    }
}
