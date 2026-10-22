package na2;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.publicscreen.stylesetting.ui.PublicScreenStyleSettingDialog;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.mock.FakeMessageListAdapter;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements PublicScreenConfigSliderView.a {
    public final /* synthetic */ PublicScreenStyleSettingDialog a;

    public a(PublicScreenStyleSettingDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView.a
    public final void a(int r6) {
        this.a.t.i(d52.a.class, r6);
        SpaceItemDecoration r0 = this.a.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spaceItemDecoration");
    L5:
        int r1 = q.a;
        if (r6 == 1) goto L10;
        if (r6 == 2) goto L9;
        int r3 = PublicScreenStyleHelper.c;
    L12:
        if (PublicScreenABHelper.h().itemGapFitResolution == false) goto L14;
        r3 = (int) (r3 * q.f(true));
    L14:
        r0.a = r3;
        FakeMessageListAdapter r2 = this.a.h;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L17:
        if (r6 == 0) goto L23;
        if (r6 == 1) goto L22;
        if (r6 != 2) goto L23;
        int r7 = 16;
    L24:
        r2.getClass();
        r2.c = UtilityKotlinExtentionsKt.h(r7);
        return;
    L22:
        r7 = 14;
    L23:
        r7 = 12;
        goto L24
    L9:
        r3 = PublicScreenStyleHelper.e;
        goto L12
    L10:
        r3 = PublicScreenStyleHelper.d;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView.a
    public final void b(float r5) {
        PublicScreenStyleSettingDialog r0 = this.a;
        float r6 = r0.t.c(r5);
        g52.e r1 = r0.i;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textConfig");
    L5:
        r1.i = r6;
        FakeMessageListAdapter r2 = r0.h;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L8:
        g52.e r3 = r0.i;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("textConfig");
    L11:
        r2.b = r3;
        r0.S90(r0.q, new y(r6));
    }
}
