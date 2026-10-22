package zj0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm.VoiceCommonMultiLinkWindowManager;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class f extends d {
    public final List<Integer> h;

    public static final class a extends f {
        public static final a i = null;

        public a() {
            super(0, 0, 0, 0, 0, "EmptyVoiceWindow", zj0.a.class, null);
        }

        static {
            i = new a();
        }
    }

    public static final class b extends f {
        public b(int r12, int r13, int r14, List r15, int r16) {
            if ((r16 & 1) == 0) goto L5;
            int r3 = 0;
        L7:
            if ((r16 & 2) == 0) goto L9;
            int r4 = 0;
        L11:
            if ((r16 & 4) == 0) goto L13;
            int r5 = 1;
        L15:
            if ((r16 & 16) == 0) goto L17;
            List r10 = null;
        L18:
            super(r3, r4, r5, 0, 2131363980, "MultiLinkVoiceCommonWindow", VoiceCommonMultiLinkWindowManager.class, r10);
            return;
        L17:
            r10 = r15;
            goto L18
        L13:
            r5 = r14;
            goto L15
        L9:
            r4 = r13;
            goto L11
        L5:
            r3 = r12;
            goto L7
        }
    }

    @Override // zj0.d
    public final String toString() {
        return this.e + "(scene=" + this.a + ",uiLayout=" + this.b + ",seiVer=" + this.c + ", playModes=" + this.h + ')';
    }

    public f(int r1, int r2, int r3, int r4, int r5, String r6, Class r7, List r8) {
        super(r1, r2, r3, r4, r5, r6, r7);
        this.h = r8;
    }
}
