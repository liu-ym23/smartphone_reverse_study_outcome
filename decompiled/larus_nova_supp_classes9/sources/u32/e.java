package u32;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements i {
    public boolean a;
    public boolean b;
    public boolean c;
    public final Disposable d;
    public final vlc.d e;
    public final l f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            mk1.a r7 = (mk1.a) r6;
            e r0 = this.a;
            int r3 = (int) 2;
            boolean r2 = false;
            if (r7.a == r3) goto L5;
            boolean r1 = true;
        L6:
            r0.a = r1;
            IRoomAuthStatusStyle r4 = r7.c;
            if (r4 == null) goto L9;
            Integer r5 = Integer.valueOf(r4.getUnableStyle());
        L10:
            r0.e(r5);
            l r8 = this.a.f;
            if (r8 != null) goto L13;
            return;
        L13:
            if (r7.a == r3) goto L15;
            r2 = true;
        L15:
            r8.setDoubleLikeEnable(r2);
            return;
        L9:
            r5 = null;
            goto L10
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // u32.i
    public final void clear() {
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // u32.i
    public final boolean a() {
        return this.c;
    }

    @Override // u32.i
    public final boolean c() {
        return this.a;
    }

    @Override // u32.i
    public final boolean d() {
        return this.b;
    }

    @Override // u32.i
    public final void b(boolean r1) {
        this.c = r1;
    }

    public final void e(Integer r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        boolean r1 = true;
        if ((r4.intValue() & 1) == 1) goto L7;
        return;
    L7:
        if ((r4.intValue() & 2) == 0) goto L9;
        boolean r0 = true;
    L10:
        this.b = r0;
        if ((r4.intValue() & 4) != 0) goto L14;
        r1 = false;
    L14:
        this.c = r1;
        return;
    L9:
        r0 = false;
        goto L10
    }

    public e(Room r2, vlc.d r3, l r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.e = r3;
        this.f = r4;
        boolean r6 = false;
        if (r2 == null) goto L10;
        RoomAuthStatus r0 = r2.getRoomAuthStatus();
        if (r0 == null) goto L10;
        if (r0.getEnableDigg() == true) goto L10;
        boolean r1 = false;
    L11:
        this.a = r1;
        this.b = true;
        this.c = true;
        if (r2 != null) goto L14;
    L21:
        Disposable r7 = null;
        if (r2 == null) goto L30;
        RoomAuthStatus r8 = r2.getRoomAuthStatus();
        if (r8 == null) goto L30;
        RoomAuthStatus.RoomAuthSpecialStyle r9 = r8.roomAuthSpecialStyle;
        if (r9 == null) goto L30;
        RoomAuthStatus.Style r10 = r9.likeStyle;
        if (r10 == null) goto L30;
        Integer r11 = Integer.valueOf(r10.getUnableStyle());
    L31:
        e(r11);
        lk1.c.i2.getClass();
        com.bytedance.android.live.core.arch.mvvm.d r13 = lk1.c.a.a(r5).observeStatusChanged("room_auth_digg");
        if (r13 == null) goto L34;
        r7 = r13.subscribe(new a(this));
    L34:
        this.d = r7;
        return;
    L30:
        r11 = null;
        goto L31
    L14:
        if (r2.isMediaRoom() != true) goto L21;
        if (this.a == true) goto L18;
    L20:
        this.a = r6;
        goto L21
    L18:
        if (z.b(r5).b == false) goto L20;
        r6 = true;
    L10:
        r1 = true;
        goto L11
    }
}
