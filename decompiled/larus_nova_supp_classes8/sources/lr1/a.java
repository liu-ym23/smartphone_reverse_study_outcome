package lr1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int b = 0;
    public final DataCenter a;

    /* JADX INFO: renamed from: lr1.a$a, reason: collision with other inner class name */
    public static final class C0399a {
        @JvmStatic
        public static a a(DataCenter r3) {
            if (r3 != null) goto L7;
            return new a(null);
        L7:
            if (r3.has("data_center_vs_config_key") == true) goto L10;
            r3.put("data_center_vs_config_key", new a(r3));
        L10:
            return (a) r3.get("data_center_vs_config_key", new a(null));
        }
    }

    static {
    }

    public final int a() {
        if (this.a != null) goto L6;
        return 0;
    L6:
        if (PadConfigUtils.d() == false) goto L8;
        return 4;
    L8:
        PadConfigUtils.c();
        if (h.d(this.a, true) == false) goto L12;
        return 1;
    L12:
        if (h.d(this.a, true) == true) goto L17;
        return 2;
    L17:
        return 0;
    }

    public final float b() {
        int r0 = a();
        float r2 = 74.0f;
        if (r0 != 3) goto L5;
        ReplayDataContext.a r1 = ReplayDataContext.Companion;
        DataCenter r3 = this.a;
        r1.getClass();
        ReplayDataContext r4 = ReplayDataContext.a.b(r3);
        if (r4 == null) goto L33;
        j<Float> r5 = r4.getPlayerControllerBottomMargin();
        if (r5 == null) goto L33;
        Float r6 = (Float) r5.getValue();
        if (r6 == null) goto L33;
        r2 = r6.floatValue();
    L33:
        return 15.0f + r2;
    L5:
        if (r0 != 5) goto L7;
        ReplayDataContext.a r7 = ReplayDataContext.Companion;
        DataCenter r8 = this.a;
        r7.getClass();
        ReplayDataContext r9 = ReplayDataContext.a.b(r8);
        if (r9 == null) goto L34;
        j<Float> r10 = r9.getPlayerControllerBottomMargin();
        if (r10 == null) goto L34;
        Float r11 = (Float) r10.getValue();
        if (r11 == null) goto L34;
        r2 = r11.floatValue();
    L34:
        return (r2 + 20.0f) - 8.0f;
    L7:
        if (r0 != 7) goto L35;
        ReplayDataContext.a r12 = ReplayDataContext.Companion;
        DataCenter r13 = this.a;
        r12.getClass();
        ReplayDataContext r14 = ReplayDataContext.a.b(r13);
        if (r14 == null) goto L16;
        j<Float> r15 = r14.getPlayerControllerBottomMargin();
        if (r15 == null) goto L16;
        Float r16 = (Float) r15.getValue();
        if (r16 == null) goto L16;
        r2 = r16.floatValue();
    L16:
        r2 = r2 + 15.0f;
        goto L34
    L35:
        return 15.0f;
    }

    public a(DataCenter r1) {
        this.a = r1;
    }
}
