package com.bytedance.android.live.room.navi.userinfo.flipper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.room.navi.userinfo.flipper.core.BaseTabFlipper;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo/flipper/UserInfoFlipperLayout;", "Lcom/bytedance/android/live/room/navi/userinfo/flipper/core/BaseTabFlipper;", "Lh91/a;", "tabFlipSynchronizer", "Lh91/a;", "getTabFlipSynchronizer", "()Lh91/a;", "setTabFlipSynchronizer", "(Lh91/a;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoFlipperLayout extends BaseTabFlipper {

    public static final class a {
    }

    static {
    }

    public UserInfoFlipperLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public UserInfoFlipperLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final h91.a getTabFlipSynchronizer() {
        return null;
    }

    public final void setTabFlipSynchronizer(h91.a r1) {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.flipper.core.BaseTabFlipper
    public final void c() {
        WeakReference<View> r0 = getDisplayView();
        if (r0 == null) goto L5;
        View r1 = r0.get();
    L6:
        getAdapter();
        setExpectAdapterCount(0);
        if (r1 == null) goto L18;
        BaseTabFlipper.LayoutParams r2 = com.bytedance.android.live.room.navi.userinfo.flipper.core.a.a(r1);
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.b != null) goto L14;
        return;
    L14:
        if (r2.a != null) goto L16;
        return;
    L16:
        b();
        setDisplayView(null);
        setCurShowPos(-1);
        a();
        e();
        return;
    L18:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public UserInfoFlipperLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ UserInfoFlipperLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
