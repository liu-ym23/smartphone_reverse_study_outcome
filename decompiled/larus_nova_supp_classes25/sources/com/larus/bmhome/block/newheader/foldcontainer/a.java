package com.larus.bmhome.block.newheader.foldcontainer;

import android.animation.AnimatorSet;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.chat.zoom.IZoomInAnimationProvider;
import com.larus.bmhome.chat.zoom.ZoomInAnimationAction;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEndStrategy;
import com.larus.bmhome.chat.zoom.ZoomInAnimationEnqueueStrategy;
import com.larus.bmhome.chat.zoom.ZoomInAnimationState;
import com.larus.bmhome.utils.z;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.d;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y;
import com.obric.assistant.spi.complextask.ComplexTaskDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import fh8.t;
import ib8.b0;
import ib8.c;
import ib8.c0;
import ib8.d0;
import ib8.g;
import ib8.q;
import ib8.s;
import ib8.w;
import ib8.w0;
import ib8.x;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kb8.i;
import kb8.m;
import kb8.n;
import kb8.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import lb8.h;
import nb8.k;
import nb8.l;
import po8.e;
import so8.j;
import so8.r;
import so8.u;
import so8.v;
import tk8.f;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements hb8.a {
    public static final /* synthetic */ int y = 0;
    public ib8.b a;
    public g b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public Message g;
    public int h;
    public boolean i;
    public String j;
    public boolean k;
    public boolean l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final e p;
    public c q;
    public DeepThinkFoldStatus r;
    public Boolean s;
    public final Lazy t;
    public final Lazy u;
    public final w v;
    public final b w;
    public final Lazy x;

    /* JADX INFO: renamed from: com.larus.bmhome.block.newheader.foldcontainer.a$a, reason: collision with other inner class name */
    public static final class C0033a {
    }

    public static final class b implements com.larus.bmhome.block.newheader.foldcontainer.b {
        public final /* synthetic */ a a;

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final f f() {
            return null;
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final void c() {
            g r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.U1();
            return;
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final h d() {
            return (mb8.c.a) ((mb8.c) this.a.m.getValue()).c.getValue();
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final n e() {
            return (m.a) ((m) this.a.n.getValue()).e.getValue();
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final l g() {
            return (k.a) ((k) this.a.o.getValue()).f.getValue();
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final com.larus.bmhome.chat.standarduikit.vlm.view.b i() {
            return (do8.w.b) ((do8.w) this.a.u.getValue()).j.getValue();
        }

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final void b(String r53) {
            Intrinsics.checkNotNullParameter(r53, "clickPosition");
            ib8.b r1 = this.a.a;
            boolean r2 = false;
            if (r1 == null) goto L9;
            c0 r4 = r1.a;
            if (r4 == null) goto L9;
            if (r4.h != true) goto L9;
            boolean r5 = true;
        L10:
            if (r5 == false) goto L12;
            return;
        L12:
            if (r1 == null) goto L20;
            c0 r3 = r1.a;
            if (r3 == null) goto L20;
            Function0<Boolean> r6 = r3.g;
            if (r6 == null) goto L20;
            if (((Boolean) r6.invoke()).booleanValue() != true) goto L20;
            boolean r7 = true;
        L21:
            if (r7 == false) goto L23;
            return;
        L23:
            ib8.b r8 = this.a.a;
            if (r8 == null) goto L33;
            mb8.a r9 = r8.c;
            if (r9 == null) goto L33;
            List<jc8.a> r10 = r9.a;
            if (r10 == null) goto L33;
            jc8.a r11 = (jc8.a) CollectionsKt.firstOrNull(r10);
            if (r11 == null) goto L33;
            Block r12 = r11.a;
            if (r12 == null) goto L33;
        L34:
            ib8.b r13 = this.a.a;
            if (r13 == null) goto L40;
            c0 r14 = r13.a;
            if (r14 == null) goto L40;
            Message r15 = r14.d;
            if (r15 == null) goto L40;
        L41:
            FLogger.a.i("FoldContainerViewModel", "onClickExpandAllOrHeadTitle, clickPos: " + r53 + ", msgId: " + r15.getMessageId() + ", blockType: " + r12.getBlockType());
            ComplexTaskDelegate r16 = ComplexTaskDelegate.b;
            String r17 = r16.e(r15, r12);
            if (r17 != null) goto L45;
            r17 = "";
        L45:
            if (r16.f(r15) == false) goto L58;
            if (o0.d(r17) == false) goto L58;
            IFlowSdkDepend r18 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r18 == null) goto L117;
            r18.P();
            Fragment r19 = ChatServiceImpl.a.f();
            if (r19 == null) goto L118;
            t1a.b r20 = s1a.a.g(r19);
            if (r20 == null) goto L119;
            u7 r21 = r20.getAbility(u7.class);
            if (r21 == null) goto L120;
            r21.kx(r17, true);
            return;
        L120:
            return;
        L119:
            return;
        L118:
            return;
        L117:
            return;
        L58:
            if (r15.getMessageStatusLocal() != 21) goto L91;
            Set r22 = SetsKt.setOf(new String[]{"1", "true"});
            Map r23 = r15.getExt();
            if (r23 == null) goto L62;
            String r24 = (String) r23.get("need_lazy_load");
        L64:
            if (CollectionsKt.contains(r22, r24) == false) goto L91;
            if (this.a.p.a() == DeepThinkFoldStatus.CompleteExpand) goto L91;
            a r25 = this.a;
            if (r25.i == true) goto L114;
            String r26 = r15.getConversationId();
            if (r26 != null) goto L73;
            return;
        L73:
            if ((!StringsKt.isBlank(r26)) == false) goto L75;
            String r27 = r26;
        L76:
            if (r27 == null) goto L115;
            String r28 = r15.getMessageId();
            if (r28 != null) goto L81;
            return;
        L81:
            if ((!StringsKt.isBlank(r28)) == false) goto L83;
            String r29 = r28;
        L84:
            if (r29 == null) goto L116;
            r25.i = true;
            g r30 = r25.b;
            if (r30 == null) goto L89;
            r30.g(null);
        L89:
            int r31 = r25.h;
            d.e().s(r27, r29, new b0(new WeakReference(r25), r31, r29, r27, r53));
            return;
        L116:
            return;
        L83:
            r29 = null;
            goto L84
        L115:
            return;
        L75:
            r27 = null;
            goto L76
        L114:
            return;
        L62:
            r24 = null;
        L91:
            a r32 = this.a;
            ib8.b r33 = r32.a;
            if (r33 == null) goto L98;
            c0 r34 = r33.a;
            if (r34 == null) goto L98;
            if (r34.e != true) goto L98;
            boolean r35 = true;
        L99:
            if (r35 == false) goto L108;
            if (r33 == null) goto L106;
            c0 r36 = r33.a;
            if (r36 == null) goto L106;
            if (r36.i != true) goto L106;
            r2 = true;
        L106:
            if (r2 == false) goto L108;
            return;
        L108:
            g r37 = r32.b;
            if (r37 == null) goto L122;
            r37.g(new d0(true, r53));
            return;
        L122:
            return;
        L98:
            r35 = false;
        L40:
            r15 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
        L33:
            r12 = new Block(0, null, null, null, false, null, null, null, 255, null);
        L20:
            r7 = false;
        L9:
            r5 = false;
            goto L10
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final void h(st8.a r4, CustomMarkdownTextView r5) {
            Intrinsics.checkNotNullParameter(r4, "anchorView");
            ib8.b r0 = this.a.a;
            boolean r1 = false;
            if (r0 == null) goto L11;
            c0 r2 = r0.a;
            if (r2 == null) goto L11;
            Message r3 = r2.d;
            if (r3 == null) goto L11;
            if (com.larus.im.bean.message.a.f0(r3) != true) goto L11;
            r1 = true;
        L11:
            if (r1 == false) goto L13;
            LongClickSource r6 = LongClickSource.Thinking;
        L14:
            a r7 = this.a;
            g r8 = r7.b;
            if (r8 == null) goto L24;
            ib8.b r9 = r7.a;
            if (r9 == null) goto L21;
            c0 r10 = r9.a;
            if (r10 == null) goto L21;
            Message r11 = r10.d;
        L22:
            r8.b(r11, r4, r5, r6);
            return;
        L21:
            r11 = null;
            goto L22
        L24:
            return;
        L13:
            r6 = LongClickSource.Content;
            goto L14
        }

        @Override // com.larus.bmhome.block.newheader.foldcontainer.b
        public final void a(int r2, int r3, Interpolator r4) {
            Intrinsics.checkNotNullParameter(r4, "animationInterpolator");
            g r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.a(r2, r3, r4);
            return;
        }
    }

    static {
    }

    public final ib8.a a() {
        ib8.b r1 = this.a;
        if (r1 != null) goto L5;
    L41:
        i r16 = null;
    L42:
        ib8.b r2 = this.a;
        if (r2 != null) goto L45;
    L68:
        lb8.g r15 = null;
    L70:
        if (this.f == false) goto L95;
        r r3 = (r) this.t.getValue();
        r3.getClass();
        Set r6 = so8.w.a;
        so8.k r7 = r3.e;
        if (r7 == null) goto L75;
        String r8 = r7.a;
        if (r8 == null) goto L75;
    L76:
        so8.w.a(r8);
        v r9 = r3.a;
        ((ArrayList) r9.a).clear();
        ((LinkedHashMap) r9.b).clear();
        ((LinkedHashMap) r3.k).clear();
        r3.a(ZoomInAnimationState.IDLE);
        View r10 = r3.c;
        if (r10 == null) goto L83;
        so8.k r11 = r3.e;
        if (r11 == null) goto L83;
        IZoomInAnimationProvider r12 = r11.d;
        if (r12 == null) goto L83;
        r12.e(r10);
    L83:
        r3.c = null;
        r3.e = null;
        so8.f r4 = (so8.f) r3.h.getValue();
        AnimatorSet r13 = r4.a;
        if (r13 == null) goto L86;
        r13.cancel();
    L86:
        FrameLayout r14 = r4.c;
        if (r14 == null) goto L89;
        r14.removeAllViews();
    L89:
        FrameLayout r17 = r4.c;
        if (r17 == null) goto L92;
        e1.o(r17);
    L92:
        ViewGroup r5 = r4.d;
        if (r5 == null) goto L241;
        r5.setAlpha(1.0f);
    L241:
        ib8.b r18 = this.a;
        if (r18 == null) goto L246;
        c0 r19 = r18.a;
        if (r19 == null) goto L246;
        boolean r20 = r19.e;
    L247:
        if (r18 == null) goto L255;
        c0 r21 = r18.a;
        if (r21 == null) goto L255;
        ib8.m r22 = r21.c;
        if (r22 == null) goto L255;
        Function1<DeepThinkFoldStatus, String> r23 = r22.b;
        if (r23 == null) goto L255;
        String r24 = (String) r23.invoke(this.p.a());
    L256:
        if (r24 != null) goto L258;
        String r110 = "";
    L259:
        z r25 = z.a;
        e r26 = this.p;
        Message r27 = this.g;
        String r28 = this.d;
        String r111 = this.e;
        ib8.b r29 = this.a;
        if (r29 == null) goto L262;
        c0 r112 = r29.a;
    L263:
        DeepThinkFoldStatus r113 = r26.a();
        boolean r114 = this.i;
        r25.getClass();
        w0 r30 = z.b(r26, r20, r27, r28, r111, r110, r112, r113, r114);
        ib8.b r31 = this.a;
        if (r31 == null) goto L270;
        c0 r32 = r31.a;
        if (r32 == null) goto L270;
        if (r32.h != true) goto L270;
        boolean r33 = true;
    L271:
        if (r33 == false) goto L273;
        Message r34 = null;
        r30 = w0.a(r30, null, 447);
    L274:
        w0 r210 = r30;
        ib8.b r35 = this.a;
        if (r35 == null) goto L279;
        c0 r36 = r35.a;
        if (r36 == null) goto L279;
        boolean r211 = r36.e;
    L280:
        r r38 = (r) this.t.getValue();
        ib8.b r37 = this.a;
        if (r37 == null) goto L287;
        c0 r39 = r37.a;
        if (r39 == null) goto L287;
        if (r39.t != true) goto L287;
        boolean r40 = true;
    L288:
        if (r40 == true) goto L323;
        if (r37 == null) goto L320;
        c0 r41 = r37.a;
        if (r41 == null) goto L320;
        Message r42 = r41.d;
        if (r42 == null) goto L320;
        boolean r43 = this.p.b();
        Regex r44 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r42, "<this>");
        if (r42.getMessageStatusLocal() != 23) goto L298;
    L301:
        boolean r45 = true;
    L302:
        ib8.b r46 = this.a;
        if (r46 == null) goto L307;
        c0 r47 = r46.a;
        if (r47 == null) goto L307;
        boolean r48 = r47.e;
    L308:
        boolean r49 = !r48;
        if (com.larus.bmhome.chat.bean.d.e0(r42) == true) goto L313;
        if (r45 == false) goto L313;
        boolean r50 = false;
    L314:
        if (r43 == false) goto L320;
        if (r49 == false) goto L320;
        if (r50 == false) goto L320;
        if (com.larus.im.bean.message.a.f0(r42) == false) goto L320;
        boolean r51 = true;
    L321:
        if (r51 == false) goto L323;
        boolean r212 = true;
    L324:
        ib8.b r52 = this.a;
        if (r52 == null) goto L329;
        c0 r53 = r52.a;
        if (r53 == null) goto L329;
        boolean r213 = r53.e;
    L330:
        if (r52 == null) goto L336;
        c0 r54 = r52.a;
        if (r54 == null) goto L336;
        Message r55 = r54.d;
        if (r55 == null) goto L336;
        boolean r214 = com.larus.im.bean.message.a.f0(r55);
    L337:
        ib8.b r56 = this.a;
        if (r56 == null) goto L342;
        c0 r57 = r56.a;
        if (r57 == null) goto L342;
        boolean r58 = r57.i;
    L344:
        if (this.p.b() == false) goto L347;
        if (r58 == true) goto L347;
        boolean r59 = true;
    L348:
        ib8.b r60 = this.a;
        if (r60 == null) goto L354;
        c0 r61 = r60.a;
        if (r61 == null) goto L354;
        Message r62 = r61.d;
        if (r62 == null) goto L354;
    L355:
        ib8.b r63 = this.a;
        if (r63 == null) goto L365;
        mb8.a r64 = r63.c;
        if (r64 == null) goto L365;
        List<jc8.a> r65 = r64.a;
        if (r65 == null) goto L365;
        jc8.a r66 = (jc8.a) CollectionsKt.firstOrNull(r65);
        if (r66 == null) goto L365;
        Block r67 = r66.a;
        if (r67 == null) goto L365;
    L366:
        ComplexTaskDelegate r68 = ComplexTaskDelegate.b;
        if (r68.f(r62) == false) goto L381;
        ib8.b r69 = this.a;
        if (r69 == null) goto L375;
        c0 r70 = r69.a;
        if (r70 == null) goto L375;
        if (r70.e != true) goto L375;
        boolean r71 = true;
    L376:
        if (r71 == false) goto L381;
        if (r68.c(r62, r67) == true) goto L380;
        boolean r215 = true;
    L382:
        ib8.b r72 = this.a;
        if (r72 == null) goto L387;
        c0 r73 = r72.a;
        if (r73 == null) goto L387;
        boolean r74 = r73.e;
    L388:
        boolean r310 = !r74;
        if (r72 == null) goto L391;
        Message r216 = r72.f;
    L392:
        if (r72 == null) goto L396;
        c0 r75 = r72.a;
        if (r75 == null) goto L396;
        boolean r217 = r75.p;
    L397:
        int r410 = c7.b(16);
        int r411 = c7.b(12);
        c r76 = this.q;
        ib8.b r77 = this.a;
        if (r77 == null) goto L402;
        c0 r78 = r77.a;
        if (r78 == null) goto L402;
        boolean r311 = r78.j;
    L403:
        boolean r79 = this.f;
        if (r77 == null) goto L408;
        c0 r80 = r77.a;
        if (r80 == null) goto L408;
        boolean r81 = r80.e;
    L409:
        boolean r312 = !r81;
        if (r77 == null) goto L415;
        c0 r82 = r77.a;
        if (r82 == null) goto L415;
        Function0<Integer> r83 = r82.l;
        if (r83 == null) goto L415;
    L416:
        Function0<Integer> r313 = r83;
        if (r77 == null) goto L421;
        c0 r84 = r77.a;
        if (r84 == null) goto L421;
        boolean r314 = r84.n;
    L422:
        if (r77 == null) goto L428;
        c0 r85 = r77.a;
        if (r85 == null) goto L428;
        if (r85.t != true) goto L428;
        boolean r86 = true;
    L429:
        if (r86 == true) goto L441;
        if (r77 == null) goto L434;
        c0 r87 = r77.a;
        if (r87 == null) goto L434;
        boolean r88 = r87.o;
    L435:
        if (r88 == false) goto L441;
        if (r76.d == DeepThinkFoldStatus.CompleteFold) goto L441;
        if (this.p.b() == true) goto L441;
        boolean r315 = true;
    L442:
        ib8.b r89 = this.a;
        if (r89 == null) goto L447;
        c0 r90 = r89.a;
        if (r90 == null) goto L447;
        Message r316 = r90.q;
    L448:
        if (r89 == null) goto L452;
        c0 r91 = r89.a;
        if (r91 == null) goto L452;
        Message r412 = r91.r;
    L453:
        if (r89 == null) goto L457;
        c0 r92 = r89.a;
        if (r92 == null) goto L457;
        Message r413 = r92.s;
    L458:
        if (r89 == null) goto L462;
        c0 r93 = r89.a;
        if (r93 == null) goto L462;
        boolean r414 = r93.k;
    L463:
        ib8.n r115 = new ib8.n(r211, r212, r216, r210, r217, r215, r213, r214, r310, r76, r79, r312, r311, r313, r314, r315, r38, r316, r412, r413, null, false, false, r410, r411, false, 0, r414, 484442112);
        ib8.b r94 = this.a;
        if (r94 != null) goto L466;
    L547:
        Message r116 = r34;
    L548:
        ib8.b r95 = this.a;
        if (r95 != null) goto L551;
    L553:
        Message r117 = r34;
    L554:
        ib8.a r96 = new ib8.a(r115, r15, r16, r116, r117, null, 32);
        Message r97 = this.g;
        if (r97 == null) goto L557;
        r34 = r97.getMessageId();
    L557:
        this.c = r34;
        this.f = false;
        this.l = false;
        return r96;
    L551:
        if (r95.e == null) goto L553;
        r117 = ((do8.w) this.u.getValue()).g();
        goto L554
    L466:
        if (r94.d == null) goto L547;
        k r99 = (k) this.o.getValue();
        nb8.m r100 = r99.a;
        if (r100 == null) goto L470;
        Message r101 = r100.b;
    L471:
        r99.b = r101;
        if (r100 == null) goto L478;
        String r102 = r100.c;
        if (r102 == null) goto L478;
        if (StringsKt.isBlank(r102) != true) goto L478;
        boolean r103 = true;
    L479:
        if (r103 == false) goto L481;
        boolean r218 = false;
    L507:
        nb8.m r104 = r99.a;
        if (r104 == null) goto L510;
        boolean r219 = r104.g;
    L511:
        if (r104 == null) goto L514;
        fh8.f r105 = r104.a;
        if (r105 == null) goto L514;
    L515:
        fh8.f r220 = r105;
        if (r104 == null) goto L519;
        Message r106 = r104.b;
        if (r106 == null) goto L519;
    L520:
        Message r221 = r106;
        nb8.m r107 = r99.a;
        if (r107 == null) goto L526;
        String r108 = r107.c;
        if (r108 == null) goto L526;
        String r222 = r108;
    L527:
        if (r107 == null) goto L530;
        t.a r109 = r107.d;
        if (r109 == null) goto L530;
    L531:
        t.a r223 = r109;
        nb8.m r118 = r99.a;
        if (r118 == null) goto L534;
        boolean r224 = r118.e;
    L535:
        if (r118 == null) goto L537;
        Message r225 = r118.h;
    L538:
        Message r119 = new nb8.i(r224, r225, r218, r220, r221, r222, r219, r223);
        Message r120 = r99.b;
        if (r120 == null) goto L541;
        Message r121 = r120.getMessageId();
    L542:
        r99.c = r121;
        nb8.m r122 = r99.a;
        if (r122 == null) goto L545;
        boolean r123 = r122.e;
    L546:
        r99.e = !r123;
        r116 = r119;
        goto L548
    L545:
        r123 = false;
        goto L546
    L541:
        r121 = r34;
        goto L542
    L537:
        r225 = r34;
        goto L538
    L534:
        r224 = false;
    L530:
        r109 = new t.a();
    L526:
        r222 = "";
    L519:
        r106 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L514:
        r105 = new fh8.f(0);
        goto L515
    L510:
        r219 = false;
        goto L511
    L481:
        nb8.m r124 = r99.a;
        if (r124 != null) goto L484;
    L486:
        boolean r125 = false;
    L487:
        if (r125 == false) goto L489;
        r218 = true;
        goto L507
    L489:
        Message r126 = r99.b;
        if (r126 != null) goto L492;
    L494:
        boolean r127 = false;
    L495:
        if (r127 == true) goto L497;
    L505:
        boolean r128 = false;
    L506:
        r218 = r128;
        goto L507
    L497:
        if (r99.e == false) goto L504;
        String r129 = r99.c;
        Message r130 = r99.b;
        if (r130 == null) goto L501;
        Message r131 = r130.getMessageId();
    L503:
        if ((!Intrinsics.areEqual(r129, r131)) == false) goto L505;
    L501:
        r131 = r34;
    L504:
        r128 = true;
        goto L506
    L492:
        if (com.larus.im.bean.message.a.f0(r126) != true) goto L494;
        r127 = true;
        goto L495
    L484:
        if (r124.f != true) goto L486;
        r125 = true;
    L478:
        r103 = false;
        goto L479
    L470:
        r101 = r34;
    L462:
        r414 = false;
    L457:
        r413 = r34;
    L452:
        r412 = r34;
    L447:
        r316 = r34;
    L434:
        r88 = false;
    L441:
        r315 = false;
    L428:
        r86 = false;
    L421:
        r314 = false;
    L415:
        r83 = new ib8.r();
    L408:
        r81 = false;
    L402:
        r311 = false;
    L396:
        r217 = true;
        goto L397
    L391:
        r216 = r34;
    L387:
        r74 = false;
        goto L388
    L380:
        r215 = false;
    L375:
        r71 = false;
    L381:
        r215 = r59;
    L365:
        r67 = new Block(0, null, null, null, false, null, null, null, 255, null);
    L354:
        r62 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L347:
        r59 = false;
    L342:
        r58 = true;
    L336:
        r214 = false;
    L329:
        r213 = false;
    L313:
        r50 = true;
    L307:
        r48 = false;
        goto L308
    L298:
        if (r42.getMessageStatusLocal() == 22) goto L301;
        r45 = false;
    L320:
        r51 = false;
    L323:
        r212 = false;
    L287:
        r40 = false;
    L279:
        r211 = false;
        goto L280
    L273:
        r34 = null;
    L270:
        r33 = false;
        goto L271
    L262:
        r112 = null;
        goto L263
    L258:
        r110 = r24;
    L255:
        r24 = null;
    L246:
        r20 = false;
    L75:
        r8 = "";
        goto L76
    L95:
        ib8.b r132 = this.a;
        if (r132 == null) goto L241;
        c0 r133 = r132.a;
        if (r133 == null) goto L241;
        List<jc8.a> r134 = r133.a;
        if (r134 == null) goto L241;
        Iterator<T> r135 = r134.iterator();
    L103:
        if (r135.hasNext() == false) goto L241;
        jc8.a r136 = (jc8.a) r135.next();
        r r137 = (r) this.t.getValue();
        j r138 = new j(r136);
        r137.getClass();
        Intrinsics.checkNotNullParameter(r138, "input");
        jc8.a r139 = r138.a;
        String r140 = r139.getClass().getName();
        so8.t r141 = so8.t.a;
        Intrinsics.checkNotNull(r140);
        Intrinsics.checkNotNullParameter(r140, "blockBizModelClassName");
        List r142 = (List) ((LinkedHashMap) so8.t.b).get(r140);
        if (r142 == null) goto L103;
        Iterator r143 = r142.iterator();
    L108:
        if (r143.hasNext() == false) goto L103;
        IZoomInAnimationProvider r144 = (IZoomInAnimationProvider) r143.next();
        String r145 = r144.a(r139);
        Set r146 = so8.w.a;
        Intrinsics.checkNotNullParameter(r145, "animationID");
        if (so8.w.a.contains(r145) == true) goto L108;
        if (r144.g(r139, r137.i) == false) goto L108;
        so8.k r147 = new so8.k(r145, r138, r144.f(r139), r144, r144.b(r139));
        so8.k r148 = r137.e;
        if (r148 == null) goto L116;
        String r149 = r148.a;
    L118:
        if (Intrinsics.areEqual(r145, r149) == false) goto L120;
        r137.c(r147, "dispatchInput");
        goto L108
    L120:
        FLogger.a.d("ZoomInAnimationManager", "enqueue wait animation queue");
        ZoomInAnimationState r150 = r137.d.a;
        ZoomInAnimationAction r151 = r147.c;
        ZoomInAnimationAction r152 = ZoomInAnimationAction.HIDE;
        if (r151 != r152) goto L136;
        v r153 = r137.a;
        String r154 = r147.a;
        r153.getClass();
        Intrinsics.checkNotNullParameter(r154, "animationId");
        List r155 = r153.a;
        ArrayList r156 = new ArrayList();
        Iterator r157 = ((ArrayList) r155).iterator();
    L124:
        if (r157.hasNext() == false) goto L128;
        Object r158 = r157.next();
        if (Intrinsics.areEqual(((so8.k) r158).a, r154) == false) goto L124;
        r156.add(r158);
        goto L124
    L128:
        ((ArrayList) r153.a).removeAll(r156);
        Iterator r159 = r156.iterator();
    L130:
        if (r159.hasNext() == false) goto L108;
        so8.k r160 = (so8.k) r159.next();
        Set r161 = (Set) ((LinkedHashMap) r153.b).get(r160.c);
        if (r161 != null) goto L134;
        r161 = new LinkedHashSet();
    L134:
        r161.remove(r160.a);
        goto L130
    L136:
        if (r150 == ZoomInAnimationState.IDLE) goto L138;
    L141:
        boolean r162 = true;
    L143:
        if (r147.e.c != ZoomInAnimationEnqueueStrategy.SKIP_IF_BUSY) goto L145;
        boolean r163 = true;
    L146:
        if (r163 == false) goto L149;
        if (r162 == true) goto L108;
    L149:
        so8.k r164 = r137.e;
        if (r164 == null) goto L152;
        String r165 = r164.a;
    L153:
        if (r164 == null) goto L157;
        so8.c r166 = r164.e;
        if (r166 == null) goto L157;
        ZoomInAnimationEndStrategy r167 = r166.d;
    L159:
        if (r150 != ZoomInAnimationState.STAY) goto L161;
    L164:
        boolean r168 = true;
    L165:
        if (r168 == false) goto L172;
        if (r165 == null) goto L172;
        if (Intrinsics.areEqual(r147.a, r165) == true) goto L172;
        if (r167 != ZoomInAnimationEndStrategy.PASSIVE_WAIT) goto L172;
        boolean r169 = true;
    L173:
        so8.k r170 = r137.e;
        if (r170 == null) goto L176;
        so8.k r171 = so8.k.a(r170, r152);
    L177:
        if (r169 == false) goto L210;
        Runnable r172 = r137.g;
        if (r172 == null) goto L181;
        SoftReference r173 = y.a;
        Intrinsics.checkNotNullParameter(r172, "action");
        y.a(r172);
    L181:
        r137.g = new so8.n(r137, r171);
        so8.b r174 = r137.d;
        ZoomInAnimationState r175 = r174.a;
        long r176 = r174.b;
        int r177 = r.b.a[r175.ordinal()];
        long r226 = 1000;
        if (r177 != 1) goto L184;
        long r178 = Math.abs(System.currentTimeMillis() - r176);
        so8.k r179 = r137.e;
        if (r179 == null) goto L203;
        so8.c r180 = r179.e;
        if (r180 == null) goto L203;
        r226 = r180.b;
    L203:
        long r181 = Math.abs(200 - r178) + r226;
    L205:
        if (r181 <= 0) goto L209;
        Runnable r182 = r137.g;
        if (r182 == null) goto L210;
        SoftReference r183 = y.a;
        Intrinsics.checkNotNullParameter(r182, "action");
        y.d(r182, r181);
        goto L210
    L209:
        r137.c(r171, "passive hide");
        goto L210
    L184:
        if (r177 != 2) goto L196;
        long r184 = Math.abs(System.currentTimeMillis() - r176);
        so8.k r185 = r137.e;
        if (r185 == null) goto L192;
        so8.c r186 = r185.e;
        if (r186 == null) goto L192;
        r226 = r186.b;
    L192:
        if (r184 <= r226) goto L194;
        boolean r187 = true;
    L195:
        if (r187 == true) goto L196;
        r181 = Math.abs(r226 - r184);
        goto L205
    L194:
        r187 = false;
    L196:
        r181 = 0;
    L210:
        v r188 = r137.a;
        r188.getClass();
        Intrinsics.checkNotNullParameter(r147, "zoomInItem");
        Set r189 = (Set) ((LinkedHashMap) r188.b).get(r147.c);
        if (r189 != null) goto L213;
        r189 = new LinkedHashSet();
    L213:
        r188.b.put(r147.c, r189);
        if (r189.contains(r147.a) == false) goto L238;
        Iterator r190 = ((ArrayList) r188.a).iterator();
        int r191 = 0;
    L217:
        if (r190.hasNext() == false) goto L227;
        so8.k r192 = (so8.k) r190.next();
        if (Intrinsics.areEqual(r192.a, r147.a) == true) goto L221;
    L223:
        boolean r193 = false;
    L224:
        if (r193 == true) goto L228;
        r191 = r191 + 1;
    L228:
        CollectionsKt.removeAll(r188.a, new u(r147));
        if (r191 >= 0) goto L231;
    L233:
        r191 = ((ArrayList) r188.a).size();
    L234:
        ListProtector.add(r188.a, r191, r147);
        Set r194 = (Set) ((LinkedHashMap) r188.b).get(r147.c);
        if (r194 != null) goto L237;
        r194 = new LinkedHashSet();
    L237:
        r188.b.put(r147.c, r194);
        r194.add(r147.a);
        goto L108
    L231:
        if (r191 > ((ArrayList) r188.a).size()) goto L233;
    L221:
        if (r192.c != r147.c) goto L223;
        r193 = true;
        goto L224
    L227:
        r191 = -1;
        goto L228
    L238:
        ((ArrayList) r188.a).add(r147);
        r189.add(r147.a);
        goto L108
    L176:
        r171 = null;
    L172:
        r169 = false;
        goto L173
    L161:
        if (r150 == ZoomInAnimationState.ZOOM_IN) goto L164;
        r168 = false;
    L157:
        r167 = null;
        goto L159
    L152:
        r165 = null;
        goto L153
    L145:
        r163 = false;
        goto L146
    L138:
        if (((ArrayList) r137.a.a).isEmpty() == false) goto L141;
        r162 = false;
        goto L143
    L116:
        r149 = null;
        goto L118
    L45:
        if (r2.c == null) goto L68;
        mb8.c r195 = (mb8.c) this.m.getValue();
        r195.getClass();
        mb8.a r196 = r195.a;
        if (r196 == null) goto L50;
        List<jc8.a> r197 = r196.a;
        if (r197 == null) goto L50;
    L51:
        List<jc8.a> r198 = r197;
        mb8.a r199 = r195.a;
        if (r199 == null) goto L54;
        Message r200 = r199.c;
    L55:
        if (r199 == null) goto L57;
        boolean r201 = r199.e;
    L58:
        if (r199 == null) goto L60;
        fh8.d r202 = r199.f;
    L61:
        if (r199 == null) goto L63;
        kc8.b r1100 = r199.d;
    L64:
        if (r199 == null) goto L66;
        boolean r1101 = r199.b;
    L67:
        r15 = new lb8.g(r198, r200, r201, r202, r1100, r1101);
        goto L70
    L66:
        r1101 = false;
        goto L67
    L63:
        r1100 = null;
        goto L64
    L60:
        r202 = null;
        goto L61
    L57:
        r201 = false;
        goto L58
    L54:
        r200 = null;
    L50:
        r197 = CollectionsKt.emptyList();
        goto L51
    L5:
        if (r1.b == null) goto L41;
        m r203 = (m) this.n.getValue();
        boolean r204 = r203.d;
        kb8.a r205 = r203.a;
        if (r205 == null) goto L9;
        List<String> r206 = r205.c;
    L10:
        if (r206 == null) goto L25;
        int r207 = r206.size();
        StringBuilder r208 = new StringBuilder();
        Iterator<T> r209 = r206.iterator();
        int r227 = 0;
    L13:
        if (r209.hasNext() == false) goto L24;
        Object r1102 = r209.next();
        int r1103 = r227 + 1;
        if (r227 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        String r1104 = (String) r1102;
        if (r227 >= r207) goto L23;
        if (r227 >= (r207 - 1)) goto L22;
        r208.append("“" + r1104 + "”、");
        goto L23
    L22:
        r208.append("“" + r1104 + 8221);
    L23:
        r227 = r1103;
        goto L13
    L24:
        String r228 = r208.toString();
    L26:
        List<kb8.u> r229 = r203.c;
        kb8.a r230 = r203.a;
        if (r230 == null) goto L29;
        o r231 = r230.e;
    L30:
        if (r230 == null) goto L32;
        boolean r1105 = r230.g;
    L33:
        if (r230 == null) goto L35;
        boolean r1106 = r230.f;
    L36:
        if (r230 == null) goto L39;
        DeepThinkFoldStatus r232 = r230.h;
        if (r232 == null) goto L39;
    L40:
        r16 = new i(r204, r228, r229, r231, r1106, r1105, r232);
    L39:
        r232 = DeepThinkFoldStatus.CompleteExpand;
        goto L40
    L35:
        r1106 = false;
        goto L36
    L32:
        r1105 = false;
        goto L33
    L29:
        r231 = null;
        goto L30
    L25:
        r228 = "";
        goto L26
    L9:
        r206 = null;
        goto L10
    }

    public final void b() {
        if (this.j != null) goto L5;
        return;
    L5:
        final int r0 = this.h;
        final WeakReference r1 = new WeakReference(this);
        new Handler(Looper.getMainLooper()).post(new q(r1, r0));
    }

    @Override // hb8.a
    public final void f() {
        this.h++;
        this.i = false;
        this.j = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.s = null;
        ((m) this.n.getValue()).f();
        ((k) this.o.getValue()).e = false;
        e r0 = this.p;
        r0.b = null;
        ((ArrayList) r0.c).clear();
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [ib8.w] */
    public a() {
        this.m = LazyKt.lazy(new ib8.o());
        this.n = LazyKt.lazy(new s());
        this.o = LazyKt.lazy(new ib8.t());
        this.p = new e();
        this.q = new c(false, null, null, 15);
        this.t = LazyKt.lazy(new ib8.u());
        this.u = LazyKt.lazy(new ib8.v());
        this.v = new w(this);
        this.w = new b(this);
        this.x = LazyKt.lazy(new x(this));
    }
}
