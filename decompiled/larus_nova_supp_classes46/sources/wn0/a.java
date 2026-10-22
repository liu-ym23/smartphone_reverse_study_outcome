package wn0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.i;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.t;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.config.pb0;
import com.bytedance.android.livesdk.config.vb1;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.UITranslation;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tf0.o;
import vm2.d;
import vm2.h;
import zj0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final HashSet<f> a;
    public final HashMap<Class<? extends o>, Function3<Class<? extends o>, zj0.c, i, o>> b;
    public f c;
    public List<Integer> d;
    public f e;
    public final List<Integer> f;
    public final List<Integer> g;
    public o h;
    public final DataCenter i;
    public final c j;
    public final InteractAnimationController k;

    /* JADX INFO: renamed from: wn0.a$a, reason: collision with other inner class name */
    public static final class C0290a {
    }

    public interface b {
        void Ef(f r1, f.b r2, List r3, List r4, zj0.c r5);

        void Lk(f r1, f.b r2, List r3, List r4, zj0.c r5);

        int Ta();
    }

    public interface c extends b {
        Pair<Integer, Integer> D3();

        void h4(o r1);

        void h5();

        Pair<Integer, Integer> x3();
    }

    static {
    }

    public static com.bytedance.android.livesdk.chatroom.viewmodel.i c() {
        j r0 = m.d().s();
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue();
        if (r1 == null) goto L7;
        return r1.t();
    L7:
        return null;
    }

    public static List a(List r3) {
        ArrayList r0 = new ArrayList();
        if (r3 == null) goto L10;
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        int r1 = ((Number) r4.next()).intValue();
        if (r1 == 7) goto L6;
        r0.add(Integer.valueOf(r1));
    L10:
        return r0;
    }

    public a(DataCenter r2, c r3, InteractAnimationController r4) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.a = new HashSet();
        this.b = new HashMap();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public static Pair b(List r6, ClientUIInfo r7, int r8) {
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L17;
        if (r6 == null) goto L15;
        if (r6.contains(7) != true) goto L15;
        if (r7 == null) goto L15;
        List r9 = r7.getUiFeatureList();
        if (r9 == null) goto L15;
        if (r9.contains(4) != true) goto L15;
        return new Pair(r6, 21);
    L15:
        return new Pair(a(r6), Integer.valueOf(r8));
    L17:
        if (((vb1) h.f6.getValue(null, h.a[368(0x170, float:5.16E-43)])).a() == false) goto L33;
        if (r6 == null) goto L31;
        if (r6.contains(7) != true) goto L31;
        if (r7 == null) goto L31;
        UITranslation r10 = r7.getUiTranslation();
        if (r10 == null) goto L31;
        Long r11 = r10.getVertical();
        if (r11 == null) goto L31;
        if (((int) r11.longValue()) != 10000) goto L31;
        return new Pair(r6, 21);
    L31:
        return new Pair(a(r6), Integer.valueOf(r8));
    L33:
        return new Pair(a(r6), Integer.valueOf(r8));
    }

    public static void d(a r26, zj0.c r27, List r28, ClientUIInfo r29, boolean r30, List r31, int r32) {
        List r2 = null;
        if ((r32 & 4) == 0) goto L5;
        ClientUIInfo r0 = null;
    L7:
        if ((r32 & 8) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r32 & 16) == 0) goto L13;
        List r9 = null;
    L14:
        r26.getClass();
        Intrinsics.checkNotNullParameter(r27, "switchType");
        ln0.a r6 = yg0.h.a;
        Pair r7 = yg0.h.c(r27);
        int r8 = ((Number) r7.getFirst()).intValue();
        int r10 = ((Number) r7.getSecond()).intValue();
        long r11 = System.currentTimeMillis();
        boolean r13 = true;
        if (((Boolean) pb0.a.getValue()).booleanValue() == true) goto L17;
    L22:
        DataCenter r12 = r26.i;
        if (r12 == null) goto L27;
        Boolean r14 = (Boolean) r12.get("status_bar_is_visible", Boolean.TRUE);
        if (r14 == null) goto L27;
        boolean r18 = r14.booleanValue();
    L29:
        if (((Boolean) d.s2.getValue(null, d.a[172(0xac, float:2.41E-43)])).booleanValue() == false) goto L36;
        if (r10 != 0) goto L34;
    L35:
        r13 = false;
        goto L36
    L34:
        if (r8 == 9) goto L35;
    L36:
        if (r13 == true) goto L38;
        ALogger.i("ttlive_link_audio_layout", "scene or uiLayout invalid, scene=" + r8 + ", uiLayout=" + r10);
        return;
    L38:
        Lazy r15 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(r26.i, "VoiceLayoutSwitcher", "trySwitchLayout, scene = " + r8 + ", uiLayout = " + r10);
        Pair r16 = b(r28, r0, r10);
        List r17 = (List) r16.getFirst();
        int r19 = ((Number) r16.getSecond()).intValue();
        tf0.m r20 = b0.b();
        if ((r20 instanceof u) == true) goto L41;
        r20 = null;
    L41:
        u r21 = (u) r20;
        if (r21 == null) goto L44;
        r21.d = System.currentTimeMillis();
    L44:
        if (r21 == null) goto L46;
        r21.a = false;
    L46:
        Triple r5 = new Triple(0, 0, "MultiLinkVoiceChatLayoutSwitcher#trySwitchLayout, with switchType = " + r27);
        int r110 = r26.j.Ta();
        boolean r22 = gh0.a.d();
        if (r0 == null) goto L49;
        r2 = r0.getUiFeatureList();
    L49:
        yg0.h.k(new t(r19, r17, 0, r18, r110, r22, null, r5, r2, r26.i, 12), new wn0.b(r26, r4, r27, r11, r21, r8, r28), r9);
        return;
    L27:
        r18 = true;
        goto L29
    L17:
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.FALSE) == false) goto L22;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L27;
        r18 = false;
        goto L29
    L13:
        r9 = r31;
        goto L14
    L9:
        r4 = r30;
        goto L11
    L5:
        r0 = r29;
        goto L7
    }
}
