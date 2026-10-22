package es1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.JoinChorusConcertStatus;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final Map<Long, a> h = null;
    public static final Set<Long> i = null;
    public static final C0384a j = null;
    public boolean a;
    public int b;
    public boolean c;
    public View d;
    public View e;
    public Pair<Integer, Integer> f;
    public int g;

    /* JADX INFO: renamed from: es1.a$a, reason: collision with other inner class name */
    public static final class C0384a {
        public C0384a() {
        }

        public final synchronized void a(long r7) {
            monitor-enter(this);
            ALogger.d("VSChorusConcertHelper", "clearInstance roomId:" + r7);     // Catch: Throwable -> L29
            a.i.add(Long.valueOf(r7));     // Catch: Throwable -> L29
            Map<Long, a> r0 = a.h;     // Catch: Throwable -> L29
            a r1 = (a) ((LinkedHashMap) r0).get(Long.valueOf(r7));     // Catch: Throwable -> L29
            if (r1 == null) goto L26;
            a.c("destroy");     // Catch: Throwable -> L29
            View r2 = r1.d;     // Catch: Throwable -> L29
            if (r2 == null) goto L14;
            ViewParent r4 = r2.getParent();     // Catch: Throwable -> L29
            if ((r4 instanceof ViewGroup) == true) goto L11;
            r4 = null;
        L11:
            ViewGroup r5 = (ViewGroup) r4;     // Catch: Throwable -> L29
            if (r5 == null) goto L14;
            r5.removeView(r2);     // Catch: Throwable -> L29
        L14:
            r1.d = null;     // Catch: Throwable -> L29
            IKtvService r3 = k.f(IKtvService.class);     // Catch: Throwable -> L29
            if (r3 == null) goto L17;
            r3.destroyChorusService();     // Catch: Throwable -> L29
        L17:
            View r6 = r1.e;     // Catch: Throwable -> L29
            if (r6 == null) goto L25;
            ViewParent r8 = r6.getParent();     // Catch: Throwable -> L29
            if ((r8 instanceof ViewGroup) == true) goto L22;
            r8 = null;
        L22:
            ViewGroup r9 = (ViewGroup) r8;     // Catch: Throwable -> L29
            if (r9 == null) goto L25;
            r9.removeView(r6);     // Catch: Throwable -> L29
        L25:
            r1.e = null;     // Catch: Throwable -> L29
        L26:
            r0.remove(Long.valueOf(r7));     // Catch: Throwable -> L29
            monitor-exit(this);
            return;
        L29:
            th = move-exception;
            throw th;
        }

        public final synchronized void b(long r4) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (((LinkedHashMap) a.h).get(Long.valueOf(r4)) == null) goto L7;
            a(r4);     // Catch: Throwable -> L9
            ALogger.d("VSChorusConcertHelper", "cache already exit, force clear roomId:" + r4);     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
        }

        public final synchronized a c(long r3, Context r5, boolean r6) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r5, "context");     // Catch: Throwable -> L16
            ALogger.w("VSChorusConcertHelper", "getInstance needCreate:" + r6 + " roomId:" + r3 + ". ");     // Catch: Throwable -> L16
            if (r6 == false) goto L7;
        L10:
            Map<Long, a> r7 = a.h;     // Catch: Throwable -> L16
            Long r4 = Long.valueOf(r3);     // Catch: Throwable -> L16
            LinkedHashMap r8 = (LinkedHashMap) r7;     // Catch: Throwable -> L16
            Object r9 = r8.get(r4);     // Catch: Throwable -> L16
            if (r9 != null) goto L13;
            r9 = new a();     // Catch: Throwable -> L16
            r8.put(r4, r9);     // Catch: Throwable -> L16
        L13:
            a r10 = (a) r9;     // Catch: Throwable -> L16
        L14:
            monitor-exit(this);
            return r10;
        L7:
            if (((Boolean) VSSettingKeys.LIVE_VS_CHORUS_UNNECESSARY_CREATE_HELPER.getValue()).booleanValue() == true) goto L10;
            r10 = (a) ((LinkedHashMap) a.h).get(Long.valueOf(r3));     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;
        public final /* synthetic */ View d;
        public final /* synthetic */ ViewGroup e;
        public final /* synthetic */ ViewGroup f;

        public b(a r1, View r2, View r3, View r4, ViewGroup r5, ViewGroup r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void a() {
            View r0 = this.b;
            ViewParent r1 = r0.getParent();
            Integer r3 = null;
            if ((r1 instanceof ViewGroup) == true) goto L5;
            r1 = null;
        L5:
            ViewGroup r2 = (ViewGroup) r1;
            if (r2 == null) goto L8;
            r2.removeView(r0);
        L8:
            Pair<Integer, Integer> r4 = this.a.f;
            if (r4 != null) goto L11;
        L16:
            this.a.b(this.c);
        L17:
            this.a.b(this.c);
            FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(this.d.getWidth(), this.d.getHeight());
            Pair<Integer, Integer> r6 = this.a.f;
            int r7 = 0;
            if (r6 == null) goto L22;
            Integer r8 = (Integer) r6.getFirst();
            if (r8 == null) goto L22;
            int r9 = r8.intValue();
        L23:
            r5.leftMargin = r9;
            Pair<Integer, Integer> r10 = this.a.f;
            if (r10 == null) goto L28;
            Integer r11 = (Integer) r10.getSecond();
            if (r11 == null) goto L28;
            int r12 = r11.intValue();
        L29:
            r5.topMargin = r12;
            a r13 = this.a;
            StringBuilder r14 = new StringBuilder("attachOverlayOnRender width:");
            r14.append(this.d.getWidth());
            r14.append(" height:");
            r14.append(this.d.getHeight());
            r14.append(" leftMargin:");
            r14.append(r5.leftMargin);
            r14.append(" topMargin:");
            r14.append(r5.topMargin);
            r14.append(" pair.left:");
            Pair<Integer, Integer> r15 = this.a.f;
            if (r15 == null) goto L32;
            Integer r16 = (Integer) r15.getFirst();
        L33:
            r14.append(r16);
            r14.append(" pair.right:");
            Pair<Integer, Integer> r17 = this.a.f;
            if (r17 == null) goto L36;
            r3 = (Integer) r17.getSecond();
        L36:
            r14.append(r3);
            String r18 = r14.toString();
            r13.getClass();
            a.c(r18);
            this.b.setLayoutParams(r5);
            this.a.getClass();     // Catch: Exception -> L43
            a.c("attachOverlayOnRender and addview now");     // Catch: Exception -> L43
            int r19 = this.e.indexOfChild(this.f);     // Catch: Exception -> L43
            if (r19 == (-1)) goto L41;
            r7 = r19;
        L41:
            this.e.addView(this.b, r7 + 1);     // Catch: Exception -> L43
            this.b.requestLayout();     // Catch: Exception -> L43
        L45:
            this.a.e = this.b;
            return;
        L43:
            e = move-exception;
            this.a.getClass();
            a.c("attachOverlayOnRender exception: " + e);
            goto L45
        L32:
            r16 = null;
        L28:
            r12 = 0;
        L22:
            r9 = 0;
            goto L23
        L11:
            if (((Number) r4.getFirst()).intValue() != 0) goto L17;
            Pair<Integer, Integer> r20 = this.a.f;
            if (r20 == null) goto L17;
            if (((Number) r20.getSecond()).intValue() != 0) goto L17;
            goto L16
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        j = new C0384a();
        h = new LinkedHashMap();
        i = new LinkedHashSet();
    }

    public a() {
        this.b = JoinChorusConcertStatus.NOT_JOINED.getValue();
    }

    public static void c(String r1) {
        ALogger.i("VSChorusConcertHelper", r1);
    }

    public final void b(View r3) {
        Intrinsics.checkNotNullParameter(r3, "originPlayerView");
        if (this.g == 0) goto L6;
        c("initLandPlayerSize return cause landScapeAnimState != MatchRoomLandScapeAnimUtil.ANIM_STATE_HIDE");
        return;
    L6:
        this.f = new Pair(Integer.valueOf((int) r3.getX()), Integer.valueOf((int) r3.getY()));
        c("initLandPlayerSize " + this.f);
    }

    public final void a(View r9, ViewGroup r10, View r11) {
        Intrinsics.checkNotNullParameter(r9, "surface");
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "originPlayerView");
        c("attachSurfaceView " + r9);
        ViewParent r0 = r11.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r7 = (ViewGroup) r0;
        if (r7 != null) goto L8;
        return;
    L8:
        r11.post(new b(this, r9, r11, r11, r10, r7));
    }
}
