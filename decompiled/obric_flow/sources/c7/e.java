package c7;

import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.keva.KevaImpl;
import com.google.common.reflect.w;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.b0;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.container.ListContainerView;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNested;
import com.lynx.tasm.behavior.x;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.j;
import fn.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1137b;

    public /* synthetic */ e(Object r5, int r10) {
        this.f1136a = r10;
        this.f1137b = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r30) {
        switch(this.f1136a) {
            case 0: goto L327;
            case 1: goto L319;
            case 2: goto L305;
            case 3: goto L280;
            case 4: goto L253;
            case 5: goto L225;
            case 6: goto L119;
            case 7: goto L85;
            default: goto L4;
        };
    L4:
        android.support.v4.media.c r5 = (android.support.v4.media.c) ((i4.a) this.f1137b).f17502b;
        r5.getClass();
        long r10 = SystemClock.uptimeMillis();
        uq.a r11 = (uq.a) r5.f367a;
        r11.getClass();
        long r12 = SystemClock.uptimeMillis();
        boolean r13 = false;
        int r14 = 0;
    L5:
        ArrayList r15 = r11.f22426b;
        if (r14 >= r15.size()) goto L70;
        uq.d r16 = (uq.d) r15.get(r14);
        if (r16 != null) goto L10;
    L9:
        r14 = r14;
    L68:
        r14 = r14 + 1;
        r13 = false;
        goto L5
    L10:
        ArrayMap r17 = r11.f22425a;
        Long r18 = (Long) r17.get(r16);
        if (r18 != null) goto L14;
    L16:
        long r19 = r16.f22438h;
        if (r19 != 0) goto L19;
        r16.f22438h = r10;
        r16.a(r16.f22436b);
        goto L9
    L19:
        long r110 = r10 - r19;
        r16.f22438h = r10;
        if (r16.f22444n == false) goto L27;
        float r20 = r16.f22443m;
        if (r20 == Float.MAX_VALUE) goto L24;
        r16.f22442l.f22449i = r20;
        r16.f22443m = Float.MAX_VALUE;
    L24:
        r16.f22436b = (float) r16.f22442l.f22449i;
        r16.f22435a = 0.0f;
        r16.f22444n = r13;
        r14 = r14;
    L25:
        boolean r21 = true;
    L36:
        float r22 = Math.min(r16.f22436b, Float.MAX_VALUE);
        r16.f22436b = r22;
        float r23 = Math.max(r22, r16.g);
        r16.f22436b = r23;
        r16.a(r23);
        if (r21 == false) goto L68;
        r16.f = false;
        ThreadLocal r24 = uq.a.f;
        if (r24.get() != null) goto L41;
        r24.set(new uq.a());
    L41:
        uq.a r25 = (uq.a) r24.get();
        r25.f22425a.remove(r16);
        ArrayList r26 = r25.f22426b;
        int r27 = r26.indexOf(r16);
        if (r27 < 0) goto L44;
        r26.set(r27, null);
        r25.e = true;
    L44:
        r16.f22438h = 0;
        r16.f22437c = false;
        int r28 = 0;
    L45:
        ArrayList r29 = r16.f22440j;
        if (r28 >= r29.size()) goto L62;
        if (r29.get(r28) == null) goto L61;
        com.obric.oui.animation.easy.b r31 = (com.obric.oui.animation.easy.b) r29.get(r28);
        com.obric.oui.animation.easy.d r111 = r31.f11940a;
        r111.f11946c.remove(r31.f11941b);
        int r112 = r29.indexOf(r31);
        if (r112 < 0) goto L52;
        r29.set(r112, null);
    L52:
        ArrayList r32 = r16.f22441k;
        int r33 = r32.indexOf(r31.f11942c);
        if (r33 < 0) goto L55;
        r32.set(r33, null);
    L55:
        r111.g = null;
        if (r111.f11946c.isEmpty() == false) goto L61;
        w r34 = r111.f;
        if (r34 == null) goto L61;
        Intrinsics.checkNotNullParameter(r111, "animator");
        ((Function1) r34.d).invoke(r111);
    L61:
        r28 = r28 + 1;
        goto L45
    L62:
        int r35 = r29.size() - 1;
    L63:
        if (r35 < 0) goto L68;
        if (r29.get(r35) != null) goto L67;
        r29.remove(r35);
    L67:
        r35 = r35 - 1;
        goto L63
    L27:
        if (r16.f22443m == Float.MAX_VALUE) goto L29;
        uq.e r113 = r16.f22442l;
        double r114 = r113.f22449i;
        long r210 = r110 / 2;
        ym.b r36 = r113.a(r16.f22436b, r16.f22435a, r210);
        uq.e r37 = r16.f22442l;
        r37.f22449i = r16.f22443m;
        r16.f22443m = Float.MAX_VALUE;
        ym.b r38 = r37.a(r36.f23293a, r36.f23294b, r210);
        r16.f22436b = r38.f23293a;
        r16.f22435a = r38.f23294b;
    L30:
        float r39 = Math.max(r16.f22436b, r16.g);
        r16.f22436b = r39;
        float r40 = Math.min(r39, Float.MAX_VALUE);
        r16.f22436b = r40;
        float r41 = r16.f22435a;
        uq.e r42 = r16.f22442l;
        r42.getClass();
        if (Math.abs(r41) < r42.e) goto L33;
    L35:
        r21 = false;
        goto L36
    L33:
        if (Math.abs(r40 - ((float) r42.f22449i)) >= r42.d) goto L35;
        r16.f22436b = (float) r16.f22442l.f22449i;
        r16.f22435a = 0.0f;
        goto L25
    L29:
        ym.b r43 = r16.f22442l.a(r16.f22436b, r16.f22435a, r110);
        r16.f22436b = r43.f23293a;
        r16.f22435a = r43.f23294b;
        goto L30
    L14:
        if (r18.longValue() >= r12) goto L9;
        r17.remove(r16);
        goto L16
    L70:
        if (r11.e == false) goto L79;
        int r44 = r15.size() - 1;
    L72:
        if (r44 < 0) goto L77;
        if (r15.get(r44) != null) goto L76;
        r15.remove(r44);
    L76:
        r44 = r44 - 1;
        goto L72
    L77:
        r11.e = false;
    L79:
        if (r15.size() > 0) goto L81;
        return;
    L81:
        if (r11.d != null) goto L83;
        r11.d = new i4.a(r11.f22427c);
    L83:
        i4.a r45 = r11.d;
        ((Choreographer) r45.f17503c).postFrameCallback((e) r45.d);
        return;
    L85:
        qn.d r46 = (qn.d) this.f1137b;
        if (r46.f != (-1)) goto L88;
        r46.f = r30;
    L88:
        r46.f21550h++;
        if (r46.f21548b == false) goto L91;
        Choreographer.getInstance().postFrameCallback(this);
    L91:
        qn.d r47 = (qn.d) this.f1137b;
        long r48 = r47.g;
        if (r48 <= 0) goto L117;
        double r49 = (r30 - r48) / 1000000.0d;
        if (((long) r49) <= 0) goto L117;
        if (r47.f21553k != (-1)) goto L114;
        LynxContext r50 = (LynxContext) r47.f21547a.get();
        if (r50 == null) goto L111;
        float r51 = DeviceUtils.a(r50.a());
        if (Math.abs(r51 - 60.0f) < 5.1f) goto L111;
        if (Math.abs(r51 - 90.0f) >= 5.1f) goto L108;
        int r52 = 90;
    L112:
        r47.f21553k = r52;
        goto L114
    L108:
        if (Math.abs(r51 - 120.0f) >= 5.1f) goto L110;
        r52 = 120;
        goto L112
    L110:
        r52 = (int) r51;
    L111:
        r52 = 60;
    L114:
        if (r47.e.size() <= 20000) goto L116;
        r47.e.poll();
    L116:
        r47.e.add(Long.valueOf((long) (r49 * 100.0d)));
    L117:
        ((qn.d) this.f1137b).g = r30;
        return;
    L119:
        ja.d r115 = (ja.d) this.f1137b;
        jp.b r53 = (jp.b) r115.f18302b;
        if (r53.f18408i == false) goto L129;
        WeakReference r54 = r53.d;
        if (r54 == null) goto L124;
        View r55 = (View) r54.get();
    L125:
        if (r55 != null) goto L129;
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter("doFrame, view is null", "msg");
        if (rp.b.f21793a == null) goto L379;
        rp.a.b("AnimatableRunner", "doFrame, view is null");
        return;
    L379:
        return;
    L124:
        r55 = null;
    L129:
        jp.b r56 = (jp.b) r115.f18302b;
        if (r56.e != 0) goto L132;
        r56.e = r30;
    L132:
        long r57 = (r30 - r56.e) - r56.f18407h;
        int r58 = jp.a.f18402a[r56.f18404a.ordinal()];
        if (r58 == 1) goto L157;
        if (r58 == 2) goto L137;
    L135:
        jp.b r116 = r56;
    L194:
        List r59 = r116.f18406c;
        if (r59 != null) goto L197;
    L199:
        Iterator r60 = r59.iterator();
    L201:
        if (r60.hasNext() == false) goto L205;
        if (((fp.a) r60.next()).d == false) goto L201;
        Choreographer.getInstance().postFrameCallback(this);
        return;
    L205:
        Choreographer.getInstance().removeFrameCallback(this);
        int r61 = jp.a.f18403b[r116.f18405b.ordinal()];
        if (r61 != 1) goto L208;
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter("doFrame, 触发 loop", "msg");
        if (rp.b.f21793a == null) goto L223;
        rp.a.b("AnimatableRunner", "doFrame, 触发 loop");
    L223:
        ja.d.e(r115, false);
        Choreographer.getInstance().postFrameCallback(this);
        return;
    L208:
        if (r61 != 2) goto L210;
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter("doFrame, 触发 reverse", "msg");
        if (rp.b.f21793a == null) goto L219;
        rp.a.b("AnimatableRunner", "doFrame, 触发 reverse");
    L219:
        List r62 = CollectionsKt.reversed(r116.f18406c);
        Intrinsics.checkNotNullParameter(r62, "animationInfos");
        r116.f18406c = r62;
        ja.d.e(r115, true);
        Choreographer.getInstance().postFrameCallback(this);
        return;
    L210:
        if (r61 != 3) goto L384;
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter("endAnimationInternal, clearVelocity: true", "msg");
        if (rp.b.f21793a == null) goto L215;
        rp.a.b("AnimatableRunner", "endAnimationInternal, clearVelocity: true");
    L215:
        Choreographer.getInstance().removeFrameCallback((e) r115.f18301a);
        r116.a(true);
        r115.k("endAnimationInternal");
        return;
    L384:
        return;
    L197:
        if (r59.isEmpty() == false) goto L199;
    L137:
        if (r56.f != (-1)) goto L140;
        r56.f = 0;
    L140:
        if (r56.f < r56.f18406c.size()) goto L145;
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter("runSequentialAnimations, return case 1", "msg");
        if (rp.b.f21793a == null) goto L135;
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter("runSequentialAnimations, return case 1", "msg");
        Log.d("OEA_SDK", "AnimatableRunner->runSequentialAnimations, return case 1");
        goto L135
    L145:
        long r63 = (long) (r57 * r56.g);
        fp.a r64 = (fp.a) r56.f18406c.get(r56.f);
        boolean r65 = r64.a(r63);
        r64.d = !r65;
        if (r65 == false) goto L156;
        r116 = r56;
        r115.h("runSequentialAnimations 1", r57, r64, r30, false);
        int r66 = r116.f + 1;
        r116.f = r66;
        if (r66 < r116.f18406c.size()) goto L155;
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter("runSequentialAnimations, return case 2", "msg");
        if (rp.b.f21793a == null) goto L152;
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter("runSequentialAnimations, return case 2", "msg");
        Log.d("OEA_SDK", "AnimatableRunner->runSequentialAnimations, return case 2");
    L152:
        Function2 r67 = (Function2) r115.d;
        if (r67 == null) goto L194;
        Unit r68 = (Unit) r67.mo2invoke(Boolean.TRUE, null);
        goto L194
    L155:
        r116.e = 0;
        r116.f18407h = 0;
        r115.h("runSequentialAnimations 2", 0, (fp.a) r116.f18406c.get(r116.f), r30, true);
        goto L194
    L156:
        r116 = r56;
        r115.h("runSequentialAnimations 3", r57, r64, r30, true);
        goto L194
    L157:
        r116 = r56;
        List r69 = r116.f18406c;
        if (r69.size() <= 1) goto L169;
        ArrayList r70 = new ArrayList();
        Iterator r71 = r69.iterator();
    L161:
        if (r71.hasNext() == false) goto L166;
        Object r72 = r71.next();
        if (((fp.a) r72).d == false) goto L161;
        r70.add(r72);
        goto L161
    L166:
        if (r70.size() == 1) goto L169;
        boolean r117 = false;
    L170:
        Iterator r211 = r69.iterator();
        int r73 = 0;
        int r74 = 0;
    L172:
        if (r211.hasNext() == false) goto L184;
        Object r75 = r211.next();
        int r212 = r73 + 1;
        if (r73 >= 0) goto L176;
        CollectionsKt.throwIndexOverflow();
    L176:
        fp.a r76 = (fp.a) r75;
        if (r76.d == false) goto L182;
        long r213 = r57;
        int r118 = r74;
        List r214 = r69;
        if (r115.h("runParallelAnimations", r57, r76, r30, r117) == false) goto L181;
    L180:
        r74 = r118 + 1;
    L183:
        r73 = r212;
        r57 = r213;
        r69 = r214;
        goto L172
    L181:
        r74 = r118;
        goto L183
    L182:
        r213 = r57;
        r118 = r74;
        r214 = r69;
        goto L180
    L184:
        int r119 = r74;
        List r215 = r69;
        if (r117 == true) goto L194;
        if (r119 != r215.size()) goto L194;
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter("runParallelAnimations, all finished", "msg");
        if (rp.b.f21793a == null) goto L191;
        Intrinsics.checkNotNullParameter("AnimatableRunner", "tag");
        Intrinsics.checkNotNullParameter("runParallelAnimations, all finished", "msg");
        Log.d("OEA_SDK", "AnimatableRunner->runParallelAnimations, all finished");
    L191:
        Function2 r77 = (Function2) r115.d;
        if (r77 == null) goto L194;
        Unit r78 = (Unit) r77.mo2invoke(Boolean.TRUE, null);
    L169:
        r117 = true;
        goto L170
    L225:
        hn.g r79 = (hn.g) this.f1137b;
        if (r79.d < 0) goto L235;
        LynxBaseScrollViewNested r80 = r79.f;
        if (r80.f17351c == false) goto L233;
        if (r80.getScrollOffsetVertically() >= r80.getScrollRangeVertically()[1]) goto L243;
    L245:
        int r81 = r79.d;
        int[] r82 = {r81, r81};
        LynxBaseScrollViewNested r83 = r79.f;
        if (r83.f17351c == false) goto L248;
        int r84 = r83.getScrollY() + r82[1];
        int[] r85 = r83.getScrollRangeVertically();
        r83.scrollTo(r83.getScrollX(), Math.min(Math.max(r84, r85[0]), r85[1]));
    L250:
        if (r79.e == null) goto L387;
        Choreographer.getInstance().postFrameCallback(r79.e);
        return;
    L387:
        return;
    L248:
        int r86 = r83.getScrollX() + r82[0];
        int[] r87 = r83.getScrollRangeHorizontally();
        r83.scrollTo(Math.min(Math.max(r86, r87[0]), r87[1]), r83.getScrollY());
    L243:
        if (r79.e == null) goto L385;
        Choreographer.getInstance().removeFrameCallback(r79.e);
        r79.e = null;
        return;
    L385:
        return;
    L233:
        if (r80.getScrollOffsetHorizontally() < r80.getScrollRangeHorizontally()[1]) goto L245;
    L235:
        LynxBaseScrollViewNested r88 = r79.f;
        if (r88.f17351c == false) goto L241;
        if (r88.getScrollOffsetVertically() > r88.getScrollRangeVertically()[0]) goto L245;
    L241:
        if (r88.getScrollOffsetHorizontally() > r88.getScrollRangeHorizontally()[0]) goto L245;
    L253:
        i r89 = (i) this.f1137b;
        int r90 = r89.f16959b;
        UIListContainer r91 = (UIListContainer) r89.f;
        if (r90 > 0) goto L256;
    L257:
        if (r90 < 0) goto L259;
    L261:
        boolean r92 = false;
    L262:
        if (r92 == false) goto L267;
        int r93 = r89.f16959b;
        if (r91.f10567a == false) goto L266;
        ((ListContainerView) r91.getView()).scrollBy(0, r93);
        goto L267
    L266:
        ((ListContainerView) r91.getView()).scrollBy(r93, 0);
    L267:
        boolean r94 = r89.f16958a;
        if (r94 == false) goto L275;
        if (r92 == true) goto L273;
        if (r89.f16960c == true) goto L275;
    L273:
        if (((e) r89.d) == null) goto L388;
        Choreographer.getInstance().postFrameCallback((e) r89.d);
        return;
    L388:
        return;
    L275:
        if (r94 == false) goto L277;
        if (r92 == false) goto L277;
    L278:
        r89.a();
        return;
    L277:
        ((ListContainerView) UIListContainer.w(r91)).f10566x = false;
        ((ListContainerView) UIListContainer.c(r91)).setScrollState(1);
        goto L278
    L259:
        if (((ListContainerView) r91.getView()).b(-1) == false) goto L261;
    L260:
        r92 = true;
        goto L262
    L256:
        if (((ListContainerView) r91.getView()).b(1) == true) goto L260;
    L280:
        UIList r95 = (UIList) this.f1137b;
        boolean r96 = true;
        if (r95.B <= 0) goto L285;
        if (r95.c(1) == false) goto L285;
    L290:
        if (r96 == false) goto L296;
        if (r95.s == false) goto L294;
        ((RecyclerView) r95.getView()).scrollBy(0, r95.B);
        goto L296
    L294:
        ((RecyclerView) r95.getView()).scrollBy(r95.B, 0);
    L296:
        if (r95.A == false) goto L303;
        if (r96 == true) goto L301;
        if (r95.C == true) goto L303;
    L301:
        if (r95.P == null) goto L390;
        Choreographer.getInstance().postFrameCallback(r95.P);
        return;
    L390:
        return;
    L303:
        r95.l();
        return;
    L285:
        if (r95.B < 0) goto L287;
    L289:
        r96 = false;
        goto L290
    L287:
        if (r95.c(-1) == false) goto L289;
    L305:
        com.obric.flow.cardlistpage.apm.e r97 = (com.obric.flow.cardlistpage.apm.e) this.f1137b;
        if (r97.f11452c == false) goto L392;
        long r98 = r97.g;
        if (r98 == 0) goto L316;
        long r99 = r30;
        double r100 = (r99 - r98) / 1000000.0d;
        int r101 = r97.e;
        if (r101 >= 600) goto L313;
        r97.d[r101] = r100;
    L313:
        r97.e = r101 + 1;
        if (r100 <= (((Number) r97.f11454i.getValue()).doubleValue() + 0.5d)) goto L317;
        r97.f++;
    L317:
        r97.g = r99;
        Choreographer.getInstance().postFrameCallback(this);
        return;
    L316:
        r99 = r30;
        goto L317
    L392:
        return;
    L319:
        x r102 = (x) this.f1137b;
        LynxLog.b(2, r102.f10811b.f10213u, "onRootViewDraw ObserverHandler");
        b0 r103 = r102.f10811b;
        boolean r104 = r103.f;
        String r105 = r103.f10213u;
        if (r104 == true) goto L323;
        LynxLog.b(4, r105, "Lynx observerHandler failed since rootView not draw");
        return;
    L323:
        if (r103.f10208o == false) goto L325;
        LynxLog.b(3, r105, "Lynx observerHandler failed since inner function is delayed");
        return;
    L325:
        j.f(new x(r103, 0));
        return;
    L327:
        h r106 = (h) this.f1137b;
        if (r106.f1142i != (-1)) goto L330;
        r106.f1142i = r30;
    L330:
        r106.f1144k++;
        if (r106.f1139b == false) goto L333;
        Choreographer.getInstance().postFrameCallback(this);
    L333:
        h r107 = (h) this.f1137b;
        long r108 = r107.f1143j;
        if (r108 <= 0) goto L347;
        long r109 = r30 - r108;
        if ((r109 / 1000000) <= 0) goto L347;
        monitor-enter(r107);
    L343:
        th = move-exception;
        throw th;
    L341:
        if (r107.f.size() <= 20000) goto L345;
        r107.f.poll();     // Catch: Throwable -> L343
    L345:
        r107.f.add(Integer.valueOf(((int) r109) / KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD));     // Catch: Throwable -> L343
        monitor-exit(r107);     // Catch: Throwable -> L343
    L347:
        ((h) this.f1137b).f1143j = r30;
    }
}
