package pp1;

import android.text.Spannable;
import com.bytedance.android.live.base.model.message.a5;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e {
    public static final /* synthetic */ int o = 0;
    public Spannable a;
    public final String b;
    public final a5 c;
    public final String d;
    public final int e;
    public final py.k f;
    public final py.k g;
    public final int h;
    public final int i;
    public Map<String, String> j;
    public final int k;
    public final String l;
    public final py.k m;
    public final py.k n;

    public static final class a {

        /* JADX INFO: renamed from: pp1.c$a$a, reason: collision with other inner class name */
        public static final class C0410a {
            public final String a;
            public int b;
            public final Map<String, String> c;
            public final int d;

            public final c a() {
                return new c(this.a, null, null, this.b, null, null, 0, 0, this.c, this.d, 7168);
            }

            public C0410a() {
                this.b = 5;
                this.c = new LinkedHashMap();
                this.d = 1;
            }

            public C0410a(String r2) {
                Intrinsics.checkNotNullParameter(r2, "plainText");
                this();
                this.a = r2;
            }
        }

        public static c a(String r13) {
            Intrinsics.checkNotNullParameter(r13, "text");
            return new c(r13, null, null, 0, null, null, 0, 0, null, 0, 8190);
        }
    }

    static {
    }

    public final String toString() {
        return "IconBubbleCommand(scheme=" + this.d + ", duration=" + this.e + ", actionType=" + this.h + ", messageType=" + this.i + ')';
    }

    public /* synthetic */ c(String r18, a5 r19, String r20, int r21, py.k r22, py.k r23, int r24, int r25, Map r26, int r27, int r28) {
        if ((r28 & 2) == 0) goto L5;
        a5 r5 = null;
    L7:
        if ((r28 & 4) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r28 & 8) == 0) goto L13;
        int r7 = 5;
    L15:
        if ((r28 & 16) == 0) goto L17;
        py.k r8 = null;
    L19:
        if ((r28 & 32) == 0) goto L21;
        py.k r9 = null;
    L23:
        if ((r28 & 64) == 0) goto L25;
        int r10 = 0;
    L27:
        if ((r28 & 128) == 0) goto L29;
        int r11 = 0;
    L31:
        if ((r28 & 256) == 0) goto L33;
        Map r12 = MapsKt.emptyMap();
    L35:
        if ((r28 & 512) == 0) goto L37;
        int r13 = 1;
    L38:
        this(r18, r5, r6, r7, r8, r9, r10, r11, r12, r13, null, null, null);
        return;
    L37:
        r13 = r27;
        goto L38
    L33:
        r12 = r26;
        goto L35
    L29:
        r11 = r25;
        goto L31
    L25:
        r10 = r24;
        goto L27
    L21:
        r9 = r23;
        goto L23
    L17:
        r8 = r22;
        goto L19
    L13:
        r7 = r21;
        goto L15
    L9:
        r6 = r20;
        goto L11
    L5:
        r5 = r19;
        goto L7
    }

    public c(String r1, a5 r2, String r3, int r4, py.k r5, py.k r6, int r7, int r8, Map<String, String> r9, int r10, String r11, py.k r12, py.k r13) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = r11;
        this.m = r12;
        this.n = r13;
    }
}
