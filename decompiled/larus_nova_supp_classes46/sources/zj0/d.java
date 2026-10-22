package zj0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import hh1.t0;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class d implements t0 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;
    public final Class<? extends o> f;
    public final int g;

    public static final class a extends d {
        public static final a h = null;

        public a() {
            super(0, 0, 0, 0, 0, "EmptyWindow", zj0.a.class);
        }

        static {
            h = new a();
        }
    }

    public static final class b extends d {
        public b(int r11, int r12, int r13, int r14, int r15, int r16) {
            if ((r16 & 1) == 0) goto L5;
            int r3 = 0;
        L7:
            if ((r16 & 2) == 0) goto L9;
            int r4 = 0;
        L11:
            if ((r16 & 4) == 0) goto L13;
            int r5 = 1;
        L15:
            if ((r16 & 8) == 0) goto L17;
            int r6 = 0;
        L19:
            if ((r16 & 16) == 0) goto L21;
            int r9 = 0;
        L22:
            super(r3, r4, r5, r6, "MultiLinkCommonWindow", CommonMultiLinkWindowManager.class, r9);
            return;
        L21:
            r9 = r15;
            goto L22
        L17:
            r6 = r14;
            goto L19
        L13:
            r5 = r13;
            goto L15
        L9:
            r4 = r12;
            goto L11
        L5:
            r3 = r11;
            goto L7
        }
    }

    public final boolean b() {
        int r0 = this.b;
        if (r0 != 3) goto L5;
    L23:
        return true;
    L5:
        if (r0 == 6) goto L23;
        if (r0 == 11) goto L23;
        if (r0 == 12) goto L23;
        if (r0 == 3) goto L23;
        if (r0 == 109) goto L23;
        if (r0 == 110) goto L23;
        if (r0 == 111) goto L23;
        if (r0 == 112) goto L23;
        if (r0 == 43) goto L23;
        return false;
    }

    public final boolean c() {
        if (this.a != 16) goto L11;
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L11;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L11;
        if (r1.isLiveTypeAudio() == true) goto L11;
        return true;
    L11:
        return false;
    }

    public final boolean isDynamic() {
        int r0 = this.b;
        if (r0 != 7) goto L5;
    L12:
        return true;
    L5:
        if (r0 == 2) goto L12;
        if (r0 == 15) goto L12;
        if (r0 == 113) goto L12;
        return false;
    }

    public String toString() {
        return this.e + "(scene=" + this.a + ",uiLayout=" + this.b + ",seiVer=" + this.c + ')';
    }

    public final int a() {
        return this.b;
    }

    public d(int r1, int r2, int r3, int r4, String r5, Class r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public /* synthetic */ d(int r9, int r10, int r11, int r12, int r13, String r14, Class r15) {
        this(r9, r10, r11, r12, r14, r15, 0);
    }
}
