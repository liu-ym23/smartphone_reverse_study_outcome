package com.bytedance.ies.bullet.ui.common;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.airbnb.lottie.k;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.ies.bullet.prefetchv2.o;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.l;
import com.bytedance.ies.bullet.service.base.m;
import com.bytedance.ies.bullet.service.base.p;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;", "Lcom/bytedance/ies/bullet/ui/common/BulletCardView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/net/Uri;", LynxResourceModule.URI_KEY, "", "setStatusView", "(Landroid/net/Uri;)V", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "", "loadingDelayInMilliSeconds", "setLoadingDelay", "(J)V", "Lcom/bytedance/ies/bullet/service/base/p;", "loadingView", "setLoadingView", "(Lcom/bytedance/ies/bullet/service/base/p;)V", "setLoadingViewInternal$anniex_release", "(Landroid/view/View;)V", "setLoadingViewInternal", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nBulletContainerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BulletContainerView.kt\ncom/bytedance/ies/bullet/ui/common/BulletContainerView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,584:1\n1#2:585\n*E\n"})
public class BulletContainerView extends BulletCardView {
    public static final /* synthetic */ int L = 0;
    public View E;
    public Timer F;
    public f G;
    public long H;
    public boolean I;
    public View J;
    public View K;

    @JvmOverloads
    public BulletContainerView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final View getLoadingView() {
        getMCurrentScene();
        return this.E;
    }

    public static final /* synthetic */ View i(BulletContainerView r5) {
        return r5.getLoadingView();
    }

    private final void setStatusView(Uri r5) {
        com.bytedance.ies.bullet.core.e r10 = getBulletContext();
        if (r10 == null) goto L5;
        r10.f5308w.getClass();
    L5:
        String r11 = null;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L9
        if (r5 == null) goto L11;
        String r13 = io.reactivex.exceptions.a.h(r5, "url");     // Catch: Throwable -> L9
    L12:
        if (r13 != null) goto L14;
        r13 = "";
    L14:
        Object r14 = Result.m124constructorimpl(Uri.parse(r13));     // Catch: Throwable -> L9
    L18:
        if (Result.m130isFailureimpl(r14) == false) goto L20;
        r14 = null;
    L20:
        Uri r15 = (Uri) r14;
        if (r15 == null) goto L23;
        String r16 = io.reactivex.exceptions.a.h(r15, "loading_style");
    L24:
        boolean r17 = Intrinsics.areEqual(r16, "host");
        if (r15 == null) goto L27;
        r11 = io.reactivex.exceptions.a.h(r15, "error_page_style");
    L27:
        boolean r18 = Intrinsics.areEqual(r11, "host");
        String r19 = "default_bid";
        if (r17 == false) goto L30;
        String r20 = "default_bid";
    L31:
        if (r18 == true) goto L34;
        r19 = getBid();
    L34:
        tc.c r21 = tc.c.f22119c;
        if (tc.c.f22119c.a(p.class, r20) != null) goto L42;
        if (tc.c.f22119c.a(p.class, r19) != null) goto L40;
        return;
    L40:
        throw new ClassCastException();
    L42:
        throw new ClassCastException();
    L30:
        r20 = getBid();
        goto L31
    L23:
        r16 = null;
        goto L24
    L11:
        r13 = null;
    L9:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v6 */
    public final void j(Uri r26, Bundle r27, com.bytedance.ies.bullet.core.e r28, rb.b r29, n r30) {
        Intrinsics.checkNotNullParameter(r26, LynxResourceModule.URI_KEY);
        if (r29 != null) goto L5;
        rb.b r13 = new rb.b();
    L6:
        Intrinsics.checkNotNullParameter(BulletContainerView.class, "clazz");
        r13.b(BulletContainerView.class, new rb.a(this));
        Intrinsics.checkNotNullParameter(r26, LynxResourceModule.URI_KEY);
        long r14 = System.currentTimeMillis();
        com.bytedance.ies.bullet.interaction.predefine.fileLoader.a r5 = vb.a.f22567a;
        Intrinsics.checkNotNullParameter(r26, LynxResourceModule.URI_KEY);
        ConcurrentHashMap r10 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r11 == null) goto L9;
        xb.c r12 = (xb.c) r11.a(xb.c.class);
    L10:
        Uri r15 = Uri.parse(Uri.decode(r26.toString()));
        if (r12 == null) goto L13;
        boolean r16 = Intrinsics.areEqual(r12.f23010c, Boolean.TRUE);
    L15:
        if (r16 == false) goto L21;
        com.bytedance.ies.bullet.interaction.predefine.fileLoader.a r17 = new com.bytedance.ies.bullet.interaction.predefine.fileLoader.a(r12);
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        vb.a.f22567a = r17;
        Intrinsics.checkNotNullParameter(r15, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r12, "metaModelConfig");
        String r18 = r15.getQueryParameter("predefine");     // Catch: Exception -> L24
        if (r18 == null) goto L21;
        if (r18.length() == 0) goto L21;
        vb.a.b(r12, r15);     // Catch: Exception -> L24
        vb.a.a(r15, StringsKt.K(r18, new String[]{","}, 0, 6));     // Catch: Exception -> L24
    L24:
        e = move-exception;
        int r19 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        String r20 = e.getMessage();
        if (r20 != null) goto L28;
        r20 = "";
    L28:
        int r21 = 12;
        String r22 = null;
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPredefine", "findTargetJsFile error:".concat(r20), null, 12);
    L29:
        g();
        if (r28 != null) goto L36;
        boolean r23 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r24 = new StringBuilder("BulletContainerView.loadUri, sessionId=");
        if (r27 == null) goto L34;
        String r25 = r27.getString("__x_session_id");
    L35:
        r24.append(r25);
        com.bytedance.ies.bullet.service.base.b.a(2, r24.toString(), "XPreRender");
        Lazy r31 = com.bytedance.ies.bullet.core.f.f5312b;
        int r110 = 12;
        this.d = td.b.b().b(getBid(), r26, r27, false, null);
    L37:
        com.bytedance.ies.bullet.core.e r32 = this.d;
        if (r32 == null) goto L75;
        String r33 = getSessionId();
        if (r28 == null) goto L47;
        rd.b r34 = r28.e;
        if (r34 == null) goto L47;
        Uri r35 = ((com.bytedance.ies.bullet.service.sdk.b) r34).f6135c;
        if (r35 == null) goto L47;
        String r36 = r35.toString();
        if (r36 == null) goto L47;
    L55:
        Intrinsics.checkNotNullParameter(r33, "sessionId");
        Intrinsics.checkNotNullParameter(r36, "schema");
        boolean r37 = true;
        if (r32.B == false) goto L58;
    L60:
        r32.f = this.f6170h;
        com.bytedance.ies.bullet.service.monitor.b r38 = r32.f5293c;
        ?? r111 = 0;
        if (r38 == null) goto L63;
        r38.c(r14, false);
    L63:
        com.bytedance.ies.bullet.service.monitor.b r39 = r32.f5293c;
        if (r39 == null) goto L67;
        r39.i(Long.valueOf(this.e));
    L67:
        if (r32.B == true) goto L69;
        Context r40 = getContext();
        Scenes r41 = this.f;
        Intrinsics.checkNotNullParameter(r40, "callee");
        Intrinsics.checkNotNullParameter(r41, "scenes");
        String r112 = r32.getSessionId();
        r32.f5311z.getClass();
        Intrinsics.checkNotNullParameter(r40, "callee");
        Intrinsics.checkNotNullParameter(r112, "sessionId");
        Intrinsics.checkNotNullParameter(r41, "scenes");
        h.f.b(new k(r40, r112, r41, 2), h.f.g);
    L69:
        if (r27 != null) goto L71;
    L73:
        r37 = false;
    L74:
        r32.D = r37;
    L76:
        this.f6176n = r26;
        ConcurrentHashMap r42 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r43 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r43 == null) goto L87;
        xc.f r44 = (xc.f) r43.a(xc.f.class);
        if (r44 == null) goto L87;
        if (r44.e() == true) goto L87;
        boolean r45 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r46 = this.d;
        if (r46 == null) goto L85;
        String r47 = r46.getSessionId();
    L86:
        com.bytedance.ies.bullet.service.base.b.e(r47, "Missing monitor callback", "XView", LogLevel.f5955c);
    L100:
        if (this.f6186y.contains(r30) == false) goto L102;
    L104:
        com.bytedance.ies.bullet.core.e r48 = this.d;
        if (r48 == null) goto L138;
        ug.a.d(r48, r22, r22, r111);
        if (r48.B == false) goto L109;
        Boolean r49 = Boolean.TRUE;
    L110:
        rd.b r50 = r48.g.f21723a;
        Boolean r51 = Boolean.FALSE;
        vd.a r52 = new vd.a(r50, "enable_prefetch", r51);
        boolean r53 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "BulletCardView.loadUri, disablePrefetch=" + r49, r22);
        if (Intrinsics.areEqual(r49, r51) == true) goto L113;
    L119:
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.prefetchv2.p.class, "cls");
        if (((com.bytedance.ies.bullet.prefetchv2.p) yc.a.a(com.bytedance.ies.bullet.prefetchv2.p.class, "default_bid")) != null) goto L122;
    L133:
        String r54 = (String) new vd.a(r48.g.f21723a, "subres_prefix", r22).f22372b;
        if (r54 == null) goto L138;
        if (r54.length() <= 0) goto L138;
        wc.d r55 = new wc.d();
        r55.f22825a = CollectionsKt.emptyList();
        List r56 = CollectionsKt.toList(StringsKt.K(r54, new String[]{","}, r111, 6));
        Intrinsics.checkNotNullParameter(r56, "<set-?>");
        r55.f22825a = r56;
        Log.d("TAG", "sub res prefix: " + r55.f22825a);
        ((rc.a) getServiceContext()).b(wc.d.class, r55);
        goto L138
    L122:
        if (r48.A != null) goto L133;
        String r57 = this.f6170h;
        Intrinsics.checkNotNullParameter(r26, "schemaUri");
        Intrinsics.checkNotNullParameter(r57, "bid");
        Intrinsics.checkNotNullParameter(r48, "bulletContext");
        rd.b r58 = r48.e;
        if (r58 == null) goto L128;
        LinkedHashMap r59 = ((com.bytedance.ies.bullet.service.sdk.b) r58).f6143o;
        if (r59 == null) goto L128;
        String r60 = (String) r59.get("enable_prefetch");
    L130:
        if (Intrinsics.areEqual(r60, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L132;
        ExecutorService r61 = o.f5870a;
        o.b(r26, r57, r48.e, r48.f5303q, r48.getSessionId(), 2);
    L132:
        r48.A = r26;
    L128:
        r60 = r22;
        goto L130
    L113:
        if (Intrinsics.areEqual(r52.f22372b, Boolean.TRUE) == true) goto L119;
        tc.c r62 = tc.c.f22119c;
        if (tc.c.f22119c.a(l.class, this.f6170h) == null) goto L119;
        throw new ClassCastException();
    L109:
        r49 = (Boolean) new vd.a(r48.g.f21723a, "disable_prefetch", Boolean.FALSE).f22372b;
    L138:
        zj.b.a(r26);
        if (r28 == null) goto L141;
        com.bytedance.ies.bullet.core.c r63 = r28.f5308w;
    L142:
        if (r63 == 0) goto L145;
        r63.f5274a = r111;
    L145:
        e(r26, r27, r13);
        return;
    L141:
        r63 = r22;
        goto L142
    L102:
        if (Intrinsics.areEqual(this, r30) == true) goto L104;
        this.f6186y.add(r30);
        goto L104
    L85:
        r47 = r22;
    L87:
        com.bytedance.ies.bullet.core.e r64 = this.d;
        if (r64 == null) goto L92;
        com.bytedance.ies.bullet.service.monitor.b r65 = r64.f5293c;
        if (r65 == null) goto L92;
        Object r66 = r65.l();
    L93:
        if (r66 == null) goto L100;
        if (this.f6186y.contains(r66) == true) goto L100;
        if (Intrinsics.areEqual(this, r66) == true) goto L100;
        this.f6186y.add(r66);
    L92:
        r66 = r22;
        goto L93
    L71:
        if (r27.getBoolean("ignore_orientation_change", false) != true) goto L73;
    L58:
        if (Intrinsics.areEqual((Boolean) new vd.a(r32.g.f21723a, "use_card_mode", Boolean.FALSE).f22372b, Boolean.TRUE) == false) goto L60;
        r32.B = true;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XInit", "useCardMode is true", r22, r110);
    L47:
        if (r28 == null) goto L51;
        Uri r67 = r28.f5297k;
        if (r67 == null) goto L51;
        String r68 = r67.toString();
    L52:
        if (r68 != null) goto L54;
        r36 = "";
        goto L55
    L54:
        r36 = r68;
    L51:
        r68 = r22;
        goto L52
    L75:
        r111 = 0;
        goto L76
    L34:
        r25 = r22;
        goto L35
    L36:
        r110 = r21;
        this.d = r28;
        Lazy r69 = com.bytedance.ies.bullet.core.f.f5312b;
        td.b.b().c(r28);
    L21:
        r21 = 12;
        r22 = null;
        goto L29
    L13:
        r16 = false;
        goto L15
    L9:
        r12 = null;
        goto L10
    L5:
        r13 = r29;
        goto L6
    }

    public final void k() {
        View r5 = this.E;
        if (r5 == null) goto L6;
        r5.setVisibility(8);
    L6:
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r11 = getBulletContext();
        if (r11 == null) goto L9;
        String r12 = r11.getSessionId();
    L10:
        com.bytedance.ies.bullet.service.base.b.b(8, r12, "hide loading", "XView");
        return;
    L9:
        r12 = null;
        goto L10
    }

    public final void l() {
        getMCurrentScene();
        View r5 = this.E;
        if (r5 == null) goto L6;
        r5.setVisibility(0);
    L6:
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r11 = getBulletContext();
        if (r11 == null) goto L9;
        String r12 = r11.getSessionId();
    L10:
        com.bytedance.ies.bullet.service.base.b.b(8, r12, "show loading", "XView");
        return;
    L9:
        r12 = null;
        goto L10
    }

    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, com.bytedance.ies.bullet.core.n
    public final void n() {
        super.n();
        KeyEvent.Callback r5 = this.E;
        if ((r5 instanceof m) == false) goto L6;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.IReleasable");
        ((m) r5).release();
        return;
    }

    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, com.bytedance.ies.bullet.core.n
    public final void o(Uri r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        super.o(r5, r10);
    }

    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, com.bytedance.ies.bullet.core.n
    public final void p(Uri r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        super.p(r5, r10);
        this.I = true;
        f r11 = this.G;
        String r12 = null;
        if (r11 == null) goto L5;
        r11.cancel();
        this.G = null;
    L5:
        Timer r13 = this.F;
        if (r13 == null) goto L8;
        r13.cancel();
        this.F = null;
    L8:
        k();
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r15 = getBulletContext();
        if (r15 == null) goto L11;
        r12 = r15.getSessionId();
    L11:
        com.bytedance.ies.bullet.service.base.b.b(8, r12, "hide error page", "XView");
    }

    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, com.bytedance.ies.bullet.core.n
    public final void r(Uri r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "e");
        super.r(r10, r11);
        boolean r12 = true;
        this.I = true;
        f r13 = this.G;
        View r5 = null;
        String r14 = null;
        View r15 = null;
        r15 = null;
        r15 = null;
        r5 = null;
        r5 = null;
        if (r13 == null) goto L5;
        r13.cancel();
        this.G = null;
    L5:
        Timer r16 = this.F;
        if (r16 == null) goto L8;
        r16.cancel();
        this.F = null;
    L8:
        k();
        h r17 = getKitView();
        if (r17 == null) goto L12;
        SccConfig.SccLevel r18 = r17.b();
        if (r18 == null) goto L12;
    L13:
        int r19 = r18.ordinal();
        String r20 = "default_bid";
        String r21 = "page";
        if (r19 != 1) goto L16;
        View r22 = this.J;
        if (r22 == null) goto L64;
        r22.setVisibility(8);
        removeView(r22);
    L79:
        View r23 = this.J;
        if (r23 == null) goto L87;
        r23.setVisibility(0);
        addView(r23);
        return;
    L87:
        return;
    L64:
        if (getMCurrentScene() != Scenes.f5283c) goto L66;
        r21 = OpenPageMethod.APP_POPUP;
    L66:
        com.bytedance.ies.bullet.core.e r24 = getBulletContext();
        if (r24 == null) goto L77;
        Intrinsics.checkNotNullParameter(r24, "<this>");
        Lazy r110 = com.bytedance.ies.bullet.secure.f.f5904c;
        com.bytedance.ies.bullet.secure.f r111 = wn.h.e();
        String r25 = r24.f;
        if (r25 == null) goto L72;
        r20 = r25;
    L72:
        com.bytedance.ies.bullet.secure.e r26 = r111.a(r20);
        if (r26 == null) goto L77;
        Function3 r27 = r26.f5902b;
        if (r27 == null) goto L77;
        r5 = (View) r27.invoke(getContext(), r21, new BulletContainerView$showSecureNoticeView$1(this));
    L77:
        this.J = r5;
        goto L79
    L16:
        if (r19 == 2) goto L39;
        com.bytedance.ies.bullet.core.e r112 = getBulletContext();
        if (r112 == null) goto L83;
        rd.e r113 = r112.g;
        if (r113 == null) goto L84;
        rd.b r114 = r113.f21723a;
        if (getMCurrentScene() != Scenes.e) goto L24;
    L26:
        r12 = false;
    L28:
        if (Intrinsics.areEqual(new vd.a(r114, "show_error", Boolean.valueOf(r12)).f22372b, Boolean.TRUE) == false) goto L85;
        getMCurrentScene();
        com.bytedance.ies.bullet.core.e r28 = getBulletContext();
        if (r28 == null) goto L34;
        com.bytedance.ies.bullet.service.monitor.b r29 = r28.f5293c;
        if (r29 == null) goto L34;
        r29.J();
    L34:
        boolean r30 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r31 = getBulletContext();
        if (r31 == null) goto L37;
        r14 = r31.getSessionId();
    L37:
        com.bytedance.ies.bullet.service.base.b.b(8, r14, "show error page", "XView");
        return;
    L85:
        return;
    L24:
        if (getMCurrentScene() == Scenes.f) goto L26;
    L84:
        return;
    L83:
        return;
    L39:
        View r32 = this.K;
        if (r32 == null) goto L42;
        r32.setVisibility(8);
        removeView(r32);
    L57:
        View r33 = this.K;
        if (r33 == null) goto L86;
        r33.setVisibility(0);
        addView(r33);
        return;
    L86:
        return;
    L42:
        if (getMCurrentScene() != Scenes.f5283c) goto L44;
        r21 = OpenPageMethod.APP_POPUP;
    L44:
        com.bytedance.ies.bullet.core.e r34 = getBulletContext();
        if (r34 == null) goto L55;
        Intrinsics.checkNotNullParameter(r34, "<this>");
        Lazy r115 = com.bytedance.ies.bullet.secure.f.f5904c;
        com.bytedance.ies.bullet.secure.f r116 = wn.h.e();
        String r35 = r34.f;
        if (r35 == null) goto L50;
        r20 = r35;
    L50:
        com.bytedance.ies.bullet.secure.e r36 = r116.a(r20);
        if (r36 == null) goto L55;
        Function3 r37 = r36.f5901a;
        if (r37 == null) goto L55;
        r15 = (View) r37.invoke(getContext(), r21, new BulletContainerView$showSecureDenyView$1(this));
    L55:
        this.K = r15;
    L12:
        r18 = SccConfig.SccLevel.f5894a;
        goto L13
    }

    public final void setLoadingDelay(long r5) {
        if (r5 < 0) goto L6;
        this.H = r5;
        return;
    }

    public final void setLoadingView(p r5) {
        Intrinsics.checkNotNullParameter(r5, "loadingView");
    }

    public final void setLoadingViewInternal$anniex_release(View r5) {
        Intrinsics.checkNotNullParameter(r5, "loadingView");
        View r10 = this.E;
        if (r10 == null) goto L5;
        removeView(r10);
    L5:
        r5.setVisibility(0);
        addView(r5);
        this.E = r5;
    }

    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, com.bytedance.ies.bullet.core.n
    public final void u(Uri r10, com.bytedance.ies.bullet.core.container.e r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.URI_KEY);
        super.u(r10, r11);
        Scenes r12 = getMCurrentScene();
        Scenes r5 = Scenes.e;
        if (r12 != r5) goto L5;
        setStatusView(r10);
    L5:
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.core.e r14 = getBulletContext();
        Object r15 = null;
        if (r14 == null) goto L8;
        String r16 = r14.getSessionId();
    L9:
        com.bytedance.ies.bullet.service.base.b.b(8, r16, "hide error page", "XView");
        if (getMCurrentScene() != r5) goto L12;
    L14:
        boolean r17 = false;
    L15:
        com.bytedance.ies.bullet.core.e r18 = getBulletContext();
        if (r18 == null) goto L23;
        Boolean r19 = (Boolean) new vd.a(r18.g.f21723a, "show_loading", null).f22372b;
        if (r19 == null) goto L20;
        r17 = r19.booleanValue();
    L20:
        rd.b r20 = r18.g.f21723a;
        Intrinsics.checkNotNullParameter(r20, "data");
        Intrinsics.checkNotNullParameter("loading_duration", STGroup.DICT_KEY);
        vd.a r21 = new vd.a(r15, 4);
        r21.j(r20, "loading_duration", null);
        Long r110 = (Long) r21.f22372b;
        if (r110 == null) goto L23;
        long r22 = r110.longValue();
    L24:
        com.bytedance.ies.bullet.core.e r111 = getBulletContext();
        if (r111 == null) goto L38;
        com.bytedance.ies.bullet.core.c r112 = r111.f5308w;
        if (r112 == null) goto L38;
        if (r112.f5274a != true) goto L38;
        if (this.f6182u.get() != 3) goto L38;
        l();
        if (r22 == 0) goto L48;
        View r23 = getLoadingView();
        if (r23 == null) goto L49;
        r23.postDelayed(new d(this, 1), r22);
        return;
    L49:
        return;
    L48:
        return;
    L38:
        this.I = false;
        if (this.F != null) goto L50;
        if (r17 == false) goto L51;
        this.F = new Timer();
        f r24 = this.G;
        if (r24 == null) goto L44;
        r24.cancel();
    L44:
        f r25 = new f(this, r22);
        this.G = r25;
        Timer r113 = this.F;
        if (r113 == null) goto L52;
        r113.schedule(r25, this.H);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L23:
        r22 = 0;
        goto L24
    L12:
        if (getMCurrentScene() == Scenes.f) goto L14;
        r17 = true;
        goto L15
    L8:
        r16 = null;
        goto L9
    }

    @Override // com.bytedance.ies.bullet.ui.common.BulletCardView, com.bytedance.ies.bullet.core.n
    public final void v(Uri r5, h r10, rd.e r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "schemaModelUnion");
        super.v(r5, r10, r11);
        r11.getClass();
    }

    @JvmOverloads
    public BulletContainerView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ BulletContainerView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public BulletContainerView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.H = 500;
        new BulletContainerView$errorReloadMethod$1(this);
        setMCurrentScene(Scenes.e);
    }
}
