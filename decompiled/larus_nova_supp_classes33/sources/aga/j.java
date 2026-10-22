package aga;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.account.base.api.ILoginService;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.f0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.utils.y;
import com.obric.assistant.audio.service.ObricAssistantBaseServiceDelegate;
import com.obric.assistant.chat.IObricChatContextService;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.common.utils.a0;
import com.obric.assistant.common.utils.p;
import com.obric.assistant.common.utils.z;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.ISystemKeySettings;
import com.obric.assistant.state.api.v2.ObricStateService;
import com.obric.assistant.t1;
import com.obric.assistant.voice.n;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static final class a {
        public final t1a.b a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "AiKeyInputContext(vContext=" + this.a + ", isMainChatHost=" + this.b + ')';
        }

        public a(t1a.b r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "vContext");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final a a;
        public final int b;
        public final int c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "VisibleInputCandidate(context=" + this.a + ", fragmentDepth=" + this.b + ", visibleBottom=" + this.c + ", visibleArea=" + this.d + ')';
        }

        public final a getContext() {
            return this.a;
        }

        public b(a r2, int r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
        a = LazyKt.lazy(new d());
        b = LazyKt.lazy(new e());
    }

    public static maa.e e() {
        t1a.b r0 = IObricChatContextService.a.a(ObricChatContextServiceDelegate.b);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAbility(maa.e.class);
    }

    public static boolean h() {
        Object r0 = AppHost.a.getApplication().getSystemService("display");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        if (((DisplayManager) r0).getDisplay(0).getRotation() == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean i() {
        AppHost.Companion r0 = AppHost.a;
        if (r0.a().isAppBackground() == false) goto L5;
        return false;
    L5:
        Activity r1 = r0.a().getCurrentActivity();
        if (r1 != null) goto L9;
        return false;
    L9:
        if ((r1 instanceof cea.a) == true) goto L11;
        return false;
    L11:
        if (r1.isFinishing() == false) goto L13;
        return false;
    L13:
        if (r1.isDestroyed() == true) goto L18;
        return true;
    L18:
        return false;
    }

    public static void k() {
        FLogger.a.i("AiIsland-SessionUtils", "showEmptyAsrToast");
        SoftReference r0 = y.a;
        Runnable r1 = new i();
        Intrinsics.checkNotNullParameter(r1, "action");
        y.c(r1);
    }

    public static void m() {
        FLogger.a.i("AiIsland-SessionUtils", "tryInterruptTts");
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().n(false);
        ObricAssistantBaseServiceDelegate.b.a();
    }

    public static a c(FragmentActivity r3) {
        ArrayList r0 = new ArrayList();
        Iterator r4 = CollectionsKt.asReversedMutable(r3.getSupportFragmentManager().getFragments()).iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        Fragment r1 = (Fragment) r4.next();
        Intrinsics.checkNotNull(r1);
        b(r1, 0, r0);
        goto L4
    L7:
        return j(r0);
    }

    public static t1a.b f(Fragment r5) {
        if (r5.isAdded() == true) goto L5;
    L39:
        return null;
    L5:
        if (r5.isVisible() == false) goto L39;
        t1a.b r6 = s1a.a.g(r5);
        if (r6.getAbility(maa.e.class) != null) goto L10;
        return null;
    L10:
        o r0 = r6.getAbility(o.class);
        if (r0 == null) goto L15;
        com.larus.bmhome.chat.component.bottom.core.a r1 = r0.Uv();
        if (r1 == null) goto L15;
        View r2 = r1.r();
    L16:
        boolean r3 = false;
        if (r2 != null) goto L19;
    L24:
        boolean r4 = false;
    L25:
        if (r4 == false) goto L39;
        ViewParent r7 = r2.getParent();
        if ((r7 instanceof ViewGroup) == false) goto L29;
        ViewGroup r8 = (ViewGroup) r7;
    L30:
        if (r8 != null) goto L32;
    L37:
        if (r3 == false) goto L39;
        return r6;
    L32:
        if (r8.getVisibility() != 0) goto L34;
        boolean r9 = true;
    L35:
        if (r9 != true) goto L37;
        r3 = true;
        goto L37
    L34:
        r9 = false;
        goto L35
    L29:
        r8 = null;
        goto L30
    L19:
        if (r2.getVisibility() != 0) goto L21;
        boolean r10 = true;
    L22:
        if (r10 != true) goto L24;
        r4 = true;
        goto L25
    L21:
        r10 = false;
    L15:
        r2 = null;
        goto L16
    }

    public static t1a.b g(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ObricChatContextServiceDelegate r0 = ObricChatContextServiceDelegate.b;
        if (r0.c(r2) == true) goto L16;
        Iterator r3 = r2.getSupportFragmentManager().getFragments().iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Fragment r1 = (Fragment) r3.next();
        Intrinsics.checkNotNull(r1);
        t1a.b r4 = d(r1, 0);
        if (r4 == null) goto L7;
        return r4;
    L11:
        return null;
    L16:
        return r0.b(r2);
    }

    public static a j(List r3) {
        b r4 = (b) CollectionsKt.maxWithOrNull(r3, ComparisonsKt.compareBy(new Function1[]{new f(), new g(), new h()}));
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.getContext();
    }

    public static void l(int r1) {
        int r0 = a0.a;
        t0.e(new z(r1));
    }

    public static int a(boolean r11, boolean r12) {
        boolean r0 = true;
        if (r12 == true) goto L15;
        if (r11 == true) goto L15;
        ISystemKeySettings r13 = (ISystemKeySettings) b.getValue();
        if (r13 != null) goto L8;
    L10:
        boolean r14 = false;
    L11:
        if (r14 == true) goto L15;
        return -12;
    L8:
        if (r13.isAiKeyEnabledWhenScreenOff() != true) goto L10;
        r14 = true;
    L15:
        if (h() == false) goto L26;
        IAssistantChatWindow r15 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r15 != null) goto L19;
    L21:
        boolean r16 = false;
    L22:
        if (r16 == true) goto L26;
        return -11;
    L19:
        if (r15.isWindowMode() != true) goto L21;
        r16 = true;
    L26:
        if (i() == false) goto L29;
        return -1;
    L29:
        Lazy r17 = a;
        if (((AudioManager) r17.getValue()).getMode() == 2) goto L34;
        if (((AudioManager) r17.getValue()).getMode() == 1) goto L34;
    L38:
        if (ILoginService.a.getAccountInfo().a == true) goto L42;
        return -3;
    L42:
        if (p.g() == true) goto L44;
    L47:
        ISystemKeySettings r18 = (ISystemKeySettings) b.getValue();
        if (r18 != null) goto L50;
    L52:
        boolean r19 = false;
    L53:
        if (r19 == false) goto L57;
        return -14;
    L57:
        if (ObricStateService.a.a() == false) goto L61;
        return -6;
    L61:
        if (n.a == false) goto L64;
        return -7;
    L64:
        int r110 = f0.a;
        AppHost.Companion r111 = AppHost.a;
        if (f0.a(r111.getApplication()) == true) goto L69;
        return -8;
    L69:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L77;
        if (t1.a.i() == true) goto L77;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L77;
        return -9;
    L77:
        if (AudioServiceDelegate.a.P().isRecording() == false) goto L80;
        return -10;
    L80:
        IAssistantChatWindow r2 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r2 != null) goto L83;
    L85:
        boolean r3 = false;
    L86:
        if (r3 == false) goto L89;
        return -15;
    L89:
        Integer r4 = null;
        if (Build.VERSION.SDK_INT < 29) goto L131;
        long r5 = System.currentTimeMillis();
        Object r6 = r111.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.app.ActivityManager");
        String r112 = r111.getApplication().getPackageName();
        List<ActivityManager.RecentTaskInfo> r7 = ((ActivityManager) r6).getRecentTasks(Integer.MAX_VALUE, 1);
        Intrinsics.checkNotNull(r7);
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L93:
        if (r9.hasNext() == false) goto L101;
        Object r10 = r9.next();
        ComponentName r20 = ((ActivityManager.RecentTaskInfo) r10).baseActivity;
        if (r20 == null) goto L97;
        String r21 = r20.getPackageName();
    L99:
        if (Intrinsics.areEqual(r21, r112) == false) goto L93;
        r8.add(r10);
        goto L93
    L97:
        r21 = null;
        goto L99
    L101:
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r22 = r8.iterator();
    L103:
        if (r22.hasNext() == false) goto L105;
        r113.add(Integer.valueOf(((ActivityManager.RecentTaskInfo) r22.next()).taskId));
        goto L103
    L105:
        List r23 = AppHost.a.a().m();
        ListIterator r24 = r23.listIterator(r23.size());
    L107:
        if (r24.hasPrevious() == false) goto L118;
        Object r25 = r24.previous();
        Activity r26 = (Activity) r25;
        if ((r26 instanceof FragmentActivity) == true) goto L111;
    L115:
        boolean r27 = false;
    L116:
        if (r27 == false) goto L107;
    L119:
        Activity r28 = (FragmentActivity) r25;
        Activity r29 = AppHost.a.a().getCurrentActivity();
        FLogger r30 = FLogger.a;
        StringBuilder r31 = new StringBuilder("findLastStartedActivity -> hostTaskIdList:");
        r31.append(r113);
        r31.append(",result=");
        r31.append(r28);
        r31.append(':');
        if ((r28 instanceof Activity) == false) goto L122;
        Activity r32 = r28;
    L123:
        if (r32 == null) goto L125;
        Integer r33 = Integer.valueOf(r32.getTaskId());
    L126:
        r31.append(r33);
        r31.append(", cur=");
        r31.append(r29);
        r31.append(':');
        if (r29 == null) goto L129;
        Integer r114 = Integer.valueOf(r29.getTaskId());
    L130:
        r31.append(r114);
        r31.append(",cost:");
        r31.append(System.currentTimeMillis() - r5);
        r30.d("AiIsland-SessionUtils", r31.toString());
    L135:
        if (r28 == null) goto L142;
        a r115 = c(r28);
        if (r115 == null) goto L142;
        com.larus.bmhome.chat.component.cvs.y r116 = r115.a.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r116 == null) goto L142;
        BotModel r34 = r116.j0();
        wc9.e r117 = r116.h();
        if (vb8.a.c(r34) == true) goto L153;
        if (r117 != null) goto L147;
    L149:
        boolean r35 = false;
    L150:
        if (r35 == true) goto L153;
        r0 = false;
        goto L153
    L147:
        if (r117.h() != true) goto L149;
        r35 = true;
    L153:
        if (r0 == false) goto L170;
        FLogger r36 = FLogger.a;
        StringBuilder r37 = new StringBuilder("current chat input disabled: botId=");
        if (r34 == null) goto L157;
        String r38 = r34.getBotId();
    L158:
        r37.append(r38);
        r37.append(", botStatus=");
        if (r34 == null) goto L161;
        Integer r39 = r34.getBotStatus();
    L162:
        r37.append(r39);
        r37.append(", conversationId=");
        if (r117 == null) goto L165;
        String r40 = r117.a;
    L166:
        r37.append(r40);
        r37.append(", conversationStatus=");
        if (r117 == null) goto L169;
        r4 = r117.t;
    L169:
        r37.append(r4);
        r36.i("AiIsland-SessionUtils", r37.toString());
        goto L170
    L165:
        r40 = null;
        goto L166
    L161:
        r39 = null;
        goto L162
    L157:
        r38 = null;
    L170:
        if (r0 == false) goto L173;
        return -16;
    L173:
        return 0;
    L142:
        r0 = false;
        goto L170
    L129:
        r114 = null;
        goto L130
    L125:
        r33 = null;
        goto L126
    L122:
        r32 = null;
        goto L123
    L111:
        if (r113.contains(Integer.valueOf(r26.getTaskId())) == false) goto L113;
    L114:
        r27 = true;
        goto L116
    L113:
        if (r26.getTaskId() != 0) goto L115;
    L118:
        r25 = null;
        goto L119
    L131:
        Activity r118 = r111.a().getCurrentActivity();
        if ((r118 instanceof FragmentActivity) == true) goto L134;
        r118 = null;
    L134:
        r28 = (FragmentActivity) r118;
        goto L135
    L83:
        if (r2.isNewGlobalPanelBlockedByPermission() != true) goto L85;
        r3 = true;
        goto L86
    L50:
        if (r18.isAiKeyFingerPrintEnrolling() != true) goto L52;
        r19 = true;
        goto L53
    L44:
        if (com.obric.assistant.common.utils.y.e() == true) goto L47;
        FLogger.a.i("AiIsland-SessionUtils", "!hitOptimizeScene");
        return -4;
    L34:
        if (com.obric.assistant.common.utils.y.e() == true) goto L38;
        return -2;
    }

    public static t1a.b d(Fragment r3, int r4) {
        if (r3.isAdded() == true) goto L5;
    L19:
        return null;
    L5:
        if (r3.isVisible() == false) goto L19;
        t1a.b r0 = f(r3);
        if (r0 == null) goto L11;
        return r0;
    L11:
        if (r4 < 4) goto L13;
        return null;
    L13:
        Iterator r5 = r3.getChildFragmentManager().getFragments().iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Fragment r1 = (Fragment) r5.next();
        Intrinsics.checkNotNull(r1);
        t1a.b r2 = d(r1, r4 + 1);
        if (r2 == null) goto L15;
        return r2;
    }

    public static void b(Fragment r5, int r6, List r7) {
        if (r5.isAdded() == true) goto L5;
        return;
    L5:
        if (r5.isVisible() == true) goto L8;
        return;
    L8:
        if (r6 >= 4) goto L13;
        Iterator r0 = CollectionsKt.asReversedMutable(r5.getChildFragmentManager().getFragments()).iterator();
    L11:
        if (r0.hasNext() == false) goto L13;
        Fragment r1 = (Fragment) r0.next();
        Intrinsics.checkNotNull(r1);
        b(r1, r6 + 1, r7);
    L13:
        t1a.b r2 = f(r5);
        if (r2 == null) goto L34;
        o r3 = r2.getAbility(o.class);
        if (r3 == null) goto L34;
        va8.b r4 = r3.rX();
        if (r4 == null) goto L34;
        View r8 = r4.a;
        if (r8 == null) goto L34;
        Rect r9 = new Rect();
        if (r8.isShown() == false) goto L34;
        if (r8.getAlpha() <= 0.0f) goto L34;
        if (r8.getWindowVisibility() != 0) goto L34;
        if (r8.getGlobalVisibleRect(r9) == false) goto L34;
        if (r9.isEmpty() == true) goto L34;
        b r10 = new b(new a(r2, r5 instanceof xe8.a), r6, r9.bottom, r9.width() * r9.height());
    L35:
        if (r10 == null) goto L40;
        ((ArrayList) r7).add(r10);
        return;
    L40:
        return;
    L34:
        r10 = null;
        goto L35
    }
}
