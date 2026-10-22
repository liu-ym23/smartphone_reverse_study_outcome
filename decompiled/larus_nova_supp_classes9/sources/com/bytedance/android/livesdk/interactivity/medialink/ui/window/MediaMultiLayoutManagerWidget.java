package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiAnchorLinkmicLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import com.bytedance.android.livesdkapi.model.AnchorInteractInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/MediaMultiLayoutManagerWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomWidget;", "Lx82/e;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLayoutManagerWidget extends RoomWidget implements x82.e {
    public final CompositeDisposable b;
    public f92.f c;
    public UILayout d;
    public Map<Long, String> e;
    public Map<Long, String> f;
    public int g;
    public int h;
    public int i;
    public UILayout j;
    public final a k;
    public final gy.f l;

    @Override // x82.e
    public final void ah() {
        MediaMultiAnchorWindowV2 r0 = this.k.j();
        if (r0 == null) goto L7;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L7;
        int r2 = r1.width;
    L8:
        MediaMultiAnchorWindowV2 r3 = this.k.j();
        if (r3 == null) goto L13;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L13;
        int r5 = r4.height;
    L15:
        if (r2 == this.h) goto L17;
    L18:
        Map<Long, String> r6 = this.e;
        if (r6 == null) goto L28;
        String r7 = r6.get(Long.valueOf(this.g));
        if (r7 == null) goto L29;
        gy.f r8 = this.l;
        if (r8 == null) goto L25;
        r8.d0(r7, "adjustWindowList", 0, 0, null);
    L25:
        this.i = r5;
        this.h = r2;
        return;
    L29:
        return;
    L28:
        return;
    L17:
        if (r5 != this.i) goto L18;
        return;
    L13:
        r5 = 0;
    L7:
        r2 = -1;
        goto L8
    }

    public final void wq() {
        Map<Long, String> r0 = this.f;
        if (r0 == null) goto L9;
        String r1 = r0.get(Long.valueOf(this.g));
        if (r1 == null) goto L9;
        gy.f r2 = this.l;
        if (r2 == null) goto L9;
        gy.f.a.a(r2, r1);
    L9:
        Map<Long, String> r3 = this.e;
        if (r3 == null) goto L17;
        String r4 = r3.get(Long.valueOf(this.g));
        if (r4 == null) goto L18;
        gy.f r5 = this.l;
        if (r5 == null) goto L19;
        r5.Q(r4, "handlePushModeChange");
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        this.b.clear();
    }

    @Override // x82.e
    public final f92.f Q8() {
        return this.c;
    }

    @Override // x82.e
    public final UILayout getDefaultUILayout() {
        return this.j;
    }

    @Override // x82.e
    public final UILayout getUILayout() {
        return this.d;
    }

    @Override // x82.e
    public final void Oe(SeiAppData r3) {
        AnchorInteractInfo r4 = r3.getAnchorInteractInfo();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getLayoutType() == 1) goto L7;
        UILayout r5 = UILayout.Normal;
    L8:
        this.d = r5;
        int r6 = b.b[r5.ordinal()];
        if (r6 != 1) goto L11;
        f92.f r7 = new f92.g();
    L16:
        this.c = r7;
        return;
    L11:
        if (r6 != 2) goto L14;
        r7 = new f92.a();
        goto L16
    L14:
        throw new NoWhenBranchMatchedException();
    L7:
        r5 = UILayout.Enlarge;
        goto L8
    }

    @Override // x82.e
    public final void of(int r2) {
        if (r2 != this.g) goto L5;
        return;
    L5:
        this.g = r2;
        wq();
    }

    public MediaMultiLayoutManagerWidget(a r2, gy.f r3) {
        Intrinsics.checkNotNullParameter(r2, "windowManager");
        this.k = r2;
        this.l = r3;
        this.b = new CompositeDisposable();
        this.c = new f92.g();
        UILayout r4 = UILayout.Normal;
        this.d = r4;
        this.g = -1;
        this.h = -1;
        this.j = r4;
    }

    @Override // x82.e
    public final void kg(UILayout r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "uiLayout");
        Intrinsics.checkNotNullParameter(r4, "source");
        this.d = r3;
        int r0 = b.a[r3.ordinal()];
        if (r0 != 1) goto L5;
        f92.f r1 = new f92.g();
    L10:
        this.c = r1;
        if (r5 == false) goto L14;
        this.k.g(r3, r4);
        return;
    L14:
        return;
    L5:
        if (r0 != 2) goto L8;
        r1 = new f92.a();
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void xq(Map<Long, String> r8, Map<Long, String> r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "logID");
        this.e = r8;
        this.f = r9;
        ArrayList r13 = new ArrayList();
        MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode[] r14 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.values();
        int r0 = r14.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L29;
        MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode r3 = r14[r2];
        if (r3 == MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamModeUnknown) goto L28;
        String r4 = null;
        if (r9 == null) goto L10;
        String r5 = r9.get(Long.valueOf(r3.ordinal()));
    L11:
        boolean r6 = true;
        if (r5 != null) goto L14;
    L17:
        boolean r7 = true;
    L18:
        if (r7 == true) goto L27;
        if (r8 == null) goto L21;
        r4 = r8.get(Long.valueOf(r3.ordinal()));
    L21:
        if (r4 != null) goto L23;
    L26:
        if (r6 == false) goto L28;
    L23:
        if (r4.length() == 0) goto L26;
        r6 = false;
    L27:
        r13.add(Integer.valueOf(r3.ordinal()));
        goto L28
    L14:
        if (r5.length() == 0) goto L17;
        r7 = false;
        goto L18
    L10:
        r5 = null;
    L28:
        r2 = r2 + 1;
        goto L3
    L29:
        r13.size();
        wq();
    }
}
