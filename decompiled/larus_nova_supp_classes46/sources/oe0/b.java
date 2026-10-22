package oe0;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final c a;
    public boolean b;
    public final CompositeDisposable c;
    public boolean d;
    public boolean e;
    public long f;
    public long g;
    public final i<ILinkPlayerInfoBridge> h;

    public static final class a {
    }

    static {
    }

    public final long b() {
        if (this.d == false) goto L11;
        if (this.e == false) goto L11;
        if (this.f <= 0) goto L11;
        return this.g + (SystemClock.elapsedRealtime() - this.f);
    L11:
        return this.g;
    }

    public b(y r4) {
        Intrinsics.checkNotNullParameter(r4, "userCenter");
        this.h = r4;
        c r0 = new c(this);
        this.a = r0;
        CompositeDisposable r1 = new CompositeDisposable();
        this.c = r1;
        r4.Q4(r0);
        d(r4.c);
        CPositionContext.a r5 = CPositionContext.Companion;
        r5.getContext();
        CPositionContext r2 = r5.getContext();
        if (r2 == null) goto L11;
        m<EnlargeGuestInfo> r3 = r2.getEnlargeGuestInfo();
        if (r3 == null) goto L11;
        Observable r6 = r3.a();
        if (r6 == null) goto L11;
        Disposable r7 = r6.subscribe(new oe0.a(this));
        if (r7 == null) goto L11;
        r1.add(r7);
    L11:
        CPositionContext r8 = r5.getContext();
        if (r8 == null) goto L19;
        m<EnlargeGuestInfo> r9 = r8.getEnlargeGuestInfo();
        if (r9 == null) goto L20;
        EnlargeGuestInfo r10 = (EnlargeGuestInfo) r9.getValue();
        if (r10 == null) goto L21;
        c(r10);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void c(EnlargeGuestInfo r5) {
        if (r5.getEnlargeGuestType() != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L5;
        boolean r6 = true;
    L6:
        boolean r0 = this.d;
        if (this.e == r6) goto L13;
        if (r6 == false) goto L10;
        a(r0, true);
    L11:
        this.e = r6;
        return;
    L10:
        a(r0, false);
        goto L11
    L13:
        return;
    L5:
        r6 = false;
        goto L6
    }

    public final void d(List<? extends ILinkPlayerInfoBridge> r7) {
        String r0 = je0.d.b0();
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
    L10:
        boolean r8 = false;
    L23:
        boolean r1 = this.d;
        boolean r4 = this.e;
        if (r1 == r8) goto L33;
        if (r8 == false) goto L27;
        a(true, r4);
    L28:
        this.d = r8;
        return;
    L27:
        a(false, r4);
        goto L28
    L33:
        return;
    L11:
        Iterator<T> r9 = r7.iterator();
    L12:
        Object r5 = null;
        if (r9.hasNext() == false) goto L20;
        Object r6 = r9.next();
        IBaseUser r10 = ((ILinkPlayerInfoBridge) r6).getUser();
        if (r10 == null) goto L18;
        r5 = r10.getIdString();
    L18:
        if (Intrinsics.areEqual(r5, r0) == false) goto L12;
        r5 = r6;
    L20:
        ILinkPlayerInfoBridge r11 = (ILinkPlayerInfoBridge) r5;
        if (r11 == null) goto L10;
        r8 = r11.isEnlarged();
        goto L23
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final void a(boolean r5, boolean r6) {
        if (r5 == false) goto L7;
        if (r6 == false) goto L7;
        this.f = SystemClock.elapsedRealtime();
        return;
    L7:
        if (this.f <= 0) goto L11;
        this.g += SystemClock.elapsedRealtime() - this.f;
        this.f = 0;
        return;
    }
}
