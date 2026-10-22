package com.larus.canvas.feature.component.logic.provider;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.u1;
import com.larus.bmhome.chat.trace.ReeditType;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.canvas.impl.databinding.LarusLayoutCanvasGenerateBottomProviderBinding;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.e0;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.e2;
import tx9.m0;
import tx9.o0;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i extends com.larus.gallery.api.t<ky8.a> implements zp9.r {
    public final j f;
    public LarusLayoutCanvasGenerateBottomProviderBinding g;
    public final CoroutineScope h;
    public ValueAnimator i;
    public boolean j;

    public final boolean m() {
        return false;
    }

    public final void A() {
        LarusLayoutCanvasGenerateBottomProviderBinding r0 = this.g;
        if (r0 == null) goto L7;
        CreationOperateContainerView r1 = r0.c;
        if (r1 == null) goto L7;
        r1.setByPublisher(z2.a.getCreationPublishConfig().b());
    L7:
        LarusLayoutCanvasGenerateBottomProviderBinding r2 = this.g;
        String r3 = null;
        if (r2 == null) goto L12;
        ConstraintLayout r4 = r2.c;
        if (r4 == null) goto L12;
        final View r5 = r4.findViewById(2131383028);
    L13:
        LarusLayoutCanvasGenerateBottomProviderBinding r6 = this.g;
        if (r6 == null) goto L18;
        ConstraintLayout r7 = r6.c;
        if (r7 == null) goto L18;
        View r8 = r7.findViewById(2131383424);
    L19:
        if (r5 == null) goto L21;
        e1.d(r5, new c(this, r5));
    L21:
        if (r8 == null) goto L23;
        e1.d(r8, new d(this));
    L23:
        Map<String, Integer> r9 = this.f.e;
        ky8.a r10 = (ky8.a) ((com.larus.gallery.api.t) this).d;
        if (r10 == null) goto L26;
        r3 = r10.a;
    L26:
        Integer r11 = r9.get(r3);
        if (r11 == null) goto L29;
        C(Integer.valueOf(r11.intValue()), "bindPublishButton-state");
        return;
    L29:
        C(1, "bindPublishButton-default");
        return;
    L18:
        r8 = null;
    L12:
        r5 = null;
        goto L13
    }

    public final PublisherCreation B() {
        Map<String, String> r1 = this.f.f;
        ky8.a r2 = (ky8.a) ((com.larus.gallery.api.t) this).d;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.a;
    L6:
        String r5 = r1.get(r4);
        ky8.a r6 = (ky8.a) ((com.larus.gallery.api.t) this).d;
        if (r6 == null) goto L11;
        UserCreationFromIM r7 = r6.o;
        if (r7 == null) goto L11;
        Integer r8 = r7.getCreationType();
    L12:
        ky8.a r9 = (ky8.a) ((com.larus.gallery.api.t) this).d;
        if (r9 == null) goto L17;
        UserCreationFromIM r10 = r9.o;
        if (r10 == null) goto L17;
        String r11 = r10.getRefContent();
    L18:
        ky8.a r12 = (ky8.a) ((com.larus.gallery.api.t) this).d;
        if (r12 == null) goto L23;
        UserCreationFromIM r13 = r12.o;
        if (r13 == null) goto L23;
        String r14 = r13.getPrompt();
    L24:
        Object r15 = ((com.larus.gallery.api.t) this).d;
        ky8.a r16 = (ky8.a) r15;
        if (r16 == null) goto L27;
        String r17 = r16.g;
    L28:
        ky8.a r18 = (ky8.a) r15;
        if (r18 == null) goto L31;
        Long r19 = r18.b;
    L32:
        ky8.a r20 = (ky8.a) r15;
        if (r20 == null) goto L35;
        Long r110 = r20.d;
    L36:
        ky8.a r21 = (ky8.a) r15;
        if (r21 == null) goto L39;
        String r111 = r21.c;
    L40:
        ky8.a r22 = (ky8.a) r15;
        if (r22 == null) goto L44;
        r3 = r22.p;
    L44:
        return new PublisherCreation(r5, r8, null, r3, r14, r17, r11, null, r111, false, null, r19, r110, Boolean.TRUE, 1668, null);
    L39:
        r111 = null;
        goto L40
    L35:
        r110 = null;
        goto L36
    L31:
        r19 = null;
        goto L32
    L27:
        r17 = null;
    L23:
        r14 = null;
    L17:
        r11 = null;
    L11:
        r8 = null;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public final void u() {
        if (z2.a.getCreationPublishConfig().b() == false) goto L6;
        e0.a.c1(this);
        return;
    }

    public final void v() {
        LarusLayoutCanvasGenerateBottomProviderBinding r0 = this.g;
        if (r0 == null) goto L7;
        CommonDownLoadLayout r1 = r0.d;
        if (r1 == null) goto L7;
        r1.onDestroy();
    L7:
        ValueAnimator r2 = this.i;
        if (r2 == null) goto L10;
        r2.cancel();
    L10:
        this.i = null;
    }

    public i(j r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        this.f = r2;
        this.h = CoroutineScopeKt.MainScope();
        this.j = true;
        if (z2.a.getCreationPublishConfig().b() == false) goto L6;
        e0.a.e1(this);
        return;
    }

    public final void X0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "creationId");
    }

    public final void bZ(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final View p(ViewGroup r8) {
        ConstraintLayout r9 = LayoutInflater.from(getContext()).inflate(2131562771, r8, false);
        int r0 = 2131362380;
        if (ViewBindings.findChildViewById(r9, 2131362380) == null) goto L42;
        ConstraintLayout r1 = r9;
        CreationOperateContainerView r2 = (CreationOperateContainerView) ViewBindings.findChildViewById(r9, 2131368277);
        if (r2 == null) goto L40;
        CommonDownLoadLayout r3 = ViewBindings.findChildViewById(r9, 2131370179);
        if (r3 == null) goto L39;
        this.g = new LarusLayoutCanvasGenerateBottomProviderBinding(r1, r1, r2, r3);
        if (r1 == null) goto L11;
        i0.a.getClass();
        int r10 = i0.e() + i5.h();
        int r4 = r1.getPaddingStart();
        int r5 = r1.getPaddingTop();
        int r6 = r1.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r1.getClass().getSimpleName() + ",source:,start:" + r4 + ",top:" + r5 + ",end:" + r6 + ",bottom:" + r10);
        r1.setPaddingRelative(r4, r5, r6, r10);
    L11:
        LarusLayoutCanvasGenerateBottomProviderBinding r11 = this.g;
        if (r11 == null) goto L14;
        CommonDownLoadLayout r12 = r11.d;
    L15:
        e1.d(r12, new e(this));
        if (this.f.g == false) goto L35;
        LarusLayoutCanvasGenerateBottomProviderBinding r13 = this.g;
        if (r13 == null) goto L26;
        CommonDownLoadLayout r14 = r13.d;
        if (r14 == null) goto L26;
        ViewGroup.LayoutParams r7 = r14.getLayoutParams();
        if (r7 == null) goto L25;
        r7.height = i5.g0();
        r14.setLayoutParams(r7);
        goto L26
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L26:
        LarusLayoutCanvasGenerateBottomProviderBinding r15 = this.g;
        if (r15 == null) goto L35;
        ConstraintLayout r16 = r15.c;
        if (r16 == null) goto L35;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L34;
        r17.height = i5.g0();
        r16.setLayoutParams(r17);
        goto L35
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L35:
        LarusLayoutCanvasGenerateBottomProviderBinding r18 = this.g;
        if (r18 != null) goto L38;
        return null;
    L38:
        return r18.a;
    L14:
        r12 = null;
        goto L15
    L39:
        r0 = 2131370179;
        goto L42
    L40:
        r0 = 2131368277;
    L42:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }

    public final void yE(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public static final Object y(i r12, Continuation r13) {
        r12.getClass();
        if ((r13 instanceof CanvasBottomProvider$addCreation$1) == false) goto L7;
        CanvasBottomProvider$addCreation$1 r0 = (CanvasBottomProvider$addCreation$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r8 = true;
        Long r10 = null;
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L16;
        if (r2 != 3) goto L15;
        ResultKt.throwOnFailure(r14);
    L62:
        return r14;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r14);
    L38:
        zp9.a r15 = (zp9.a) r14;
        if (r15 != null) goto L41;
    L43:
        r8 = false;
    L44:
        if (r8 == true) goto L49;
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        CanvasBottomProvider$addCreation$3 r4 = new CanvasBottomProvider$addCreation$3(r12, r15, null);
        r0.label = 3;
        r14 = BuildersKt.withContext(r3, r4, r0);
        if (r14 != r7) goto L62;
        return r7;
    L49:
        t19.s r16 = t19.s.a;
        Context r5 = r12.getContext();
        Context r6 = r12.getContext();
        if (r6 == null) goto L55;
        Resources r9 = r6.getResources();
        if (r9 == null) goto L55;
        String r11 = r9.getString(2131900634);
        if (r11 == null) goto L55;
    L56:
        r16.getClass();
        t19.s.p(r5, r11);
        ky8.a r17 = (ky8.a) ((com.larus.gallery.api.t) r12).d;
        if (r17 == null) goto L59;
        r10 = r17.d;
    L59:
        m0.a(String.valueOf(r10), null, null, null, null, false, null, null, null, 2046);
        return Unit.INSTANCE;
    L55:
        r11 = "";
        goto L56
    L41:
        if (r15.a != true) goto L43;
    L17:
        int r18 = r0.I$0;
        ResultKt.throwOnFailure(r14);
    L25:
        e0 r19 = e0.a;
        ky8.a r20 = (ky8.a) ((com.larus.gallery.api.t) r12).d;
        if (r20 == null) goto L28;
        Long r21 = r20.b;
    L29:
        if (r20 == null) goto L31;
        Long r22 = r20.d;
    L32:
        if (r20 == null) goto L34;
        String r23 = r20.c;
    L35:
        Integer r110 = Boxing.boxInt(r18);
        r0.label = 2;
        r14 = r19.c(r21, r22, r23, r110, r0);
        if (r14 != r7) goto L38;
        return r7;
    L34:
        r23 = null;
        goto L35
    L31:
        r22 = null;
        goto L32
    L28:
        r21 = null;
        goto L29
    L18:
        ResultKt.throwOnFailure(r14);
        PublisherCreation r111 = r12.B();
        if (z2.a.getCreationPublishConfig().b() == false) goto L21;
        new u1();
        u1.a(r111, new PublisherTrackParams("canvas_preview", String.valueOf(r12.f.i.get("recommend_from")), String.valueOf(r12.f.i.get("template_rec_req_id"))));
        return Unit.INSTANCE;
    L21:
        MainCoroutineDispatcher r112 = Dispatchers.getMain();
        CanvasBottomProvider$addCreation$2 r24 = new CanvasBottomProvider$addCreation$2(r12, 3, null);
        r0.I$0 = 1;
        r0.label = 1;
        if (BuildersKt.withContext(r112, r24, r0) == r7) goto L63;
        r18 = 1;
        goto L25
    L63:
        return r7;
    L7:
        r0 = new CanvasBottomProvider$addCreation$1(r12, r13);
        goto L8
    }

    public final void C(Integer r6, String r7) {
        FLogger r0 = FLogger.a;
        r0.i(((com.larus.gallery.api.t) this).a, "refreshButtonStatus " + r6 + " from:" + r7);
        if (r6 == null) goto L27;
        r6.intValue();
        int r1 = 0;
        if (com.larus.bmhome.utils.u.h() == true) goto L7;
    L9:
        boolean r8 = false;
    L10:
        r0.i(((com.larus.gallery.api.t) this).a, "refreshButtonStatus enable " + r8);
        LarusLayoutCanvasGenerateBottomProviderBinding r2 = this.g;
        if (r2 == null) goto L18;
        CreationOperateContainerView r3 = r2.c;
        if (r3 == null) goto L18;
        if (r8 == false) goto L16;
        int r4 = r6.intValue();
    L17:
        r3.r1(r4);
        goto L18
    L16:
        r4 = 0;
    L18:
        ky8.a r5 = (ky8.a) ((com.larus.gallery.api.t) this).d;
        if (r5 == null) goto L28;
        String r9 = r5.a;
        if (r9 == null) goto L29;
        Map<String, Integer> r10 = this.f.e;
        if (r8 == false) goto L25;
        r1 = r6.intValue();
    L25:
        r10.put(r9, Integer.valueOf(r1));
        return;
    L29:
        return;
    L28:
        return;
    L7:
        if (AccountService.a.isLogin().booleanValue() == false) goto L9;
        r8 = true;
        goto L10
    }

    public final void w(Object r4, int r5) {
        ky8.a r6 = (ky8.a) r4;
        Intrinsics.checkNotNullParameter(r6, "data");
        ((com.larus.gallery.api.t) this).d = r6;
        boolean r1 = true;
        if (r5 != this.f.a) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L33;
        if (this.j == false) goto L33;
        this.j = false;
        if (Intrinsics.areEqual(r6.a, "origin") == false) goto L17;
        LarusLayoutCanvasGenerateBottomProviderBinding r8 = this.g;
        if (r8 == null) goto L62;
        ConstraintLayout r9 = r8.b;
        if (r9 == null) goto L63;
        e1.q(r9);
        return;
    L63:
        return;
    L62:
        return;
    L17:
        LarusLayoutCanvasGenerateBottomProviderBinding r10 = this.g;
        if (r10 == null) goto L22;
        ConstraintLayout r11 = r10.b;
        if (r11 == null) goto L22;
        e1.x(r11);
    L22:
        LarusLayoutCanvasGenerateBottomProviderBinding r12 = this.g;
        if (r12 == null) goto L31;
        CommonDownLoadLayout r13 = r12.d;
        if (r13 == null) goto L31;
        CoroutineScope r14 = this.h;
        ky8.a r2 = (ky8.a) ((com.larus.gallery.api.t) this).d;
        if (r2 == null) goto L29;
        String r3 = r2.f;
    L30:
        r13.S5(r14, new com.larus.bmhome.bigimg.download.d.a(String.valueOf(r3)));
        goto L31
    L29:
        r3 = null;
    L31:
        A();
        return;
    L33:
        if (Intrinsics.areEqual(r6.a, "origin") == false) goto L47;
        LarusLayoutCanvasGenerateBottomProviderBinding r15 = this.g;
        if (r15 == null) goto L44;
        ConstraintLayout r16 = r15.b;
        if (r16 == null) goto L44;
        if (r16.getVisibility() != 0) goto L41;
        boolean r17 = true;
    L42:
        if (r17 != true) goto L44;
    L45:
        if (r1 == false) goto L66;
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r18.setDuration(this.f.c);
        r18.addUpdateListener(new a(this));
        r18.addListener(new g(this));
        this.i = r18;
        r18.start();
        return;
    L66:
        return;
    L41:
        r17 = false;
    L44:
        r1 = false;
        goto L45
    L47:
        LarusLayoutCanvasGenerateBottomProviderBinding r19 = this.g;
        if (r19 == null) goto L57;
        ConstraintLayout r20 = r19.b;
        if (r20 == null) goto L57;
        if (r20.getVisibility() != 0) goto L54;
        boolean r21 = true;
    L55:
        if (r21 == true) goto L57;
    L58:
        if (r1 == false) goto L60;
        ValueAnimator r22 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r22.setDuration(this.f.c);
        r22.addUpdateListener(new b(this));
        r22.addListener(new h(this));
        this.i = r22;
        r22.start();
        return;
    L60:
        A();
        return;
    L54:
        r21 = false;
    L57:
        r1 = false;
        goto L58
    L5:
        r7 = false;
        goto L7
    }

    public static final Object z(i r35, boolean r36, Continuation r37) {
        r35.getClass();
        if ((r37 instanceof CanvasBottomProvider$setCreationPrivacy$1) == false) goto L7;
        CanvasBottomProvider$setCreationPrivacy$1 r3 = (CanvasBottomProvider$setCreationPrivacy$1) r37;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        String r9 = "";
        String r12 = null;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        ResultKt.throwOnFailure(r2);
    L145:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r1 = r3.I$1;
        int r7 = r3.I$0;
        String r10 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L117:
        Pair r8 = (Pair) r2;
        if (r8 == null) goto L120;
        Boolean r11 = (Boolean) r8.getFirst();
    L122:
        if (Intrinsics.areEqual(r11, Boxing.boxBoolean(true)) == true) goto L126;
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        CanvasBottomProvider$setCreationPrivacy$3 r14 = new CanvasBottomProvider$setCreationPrivacy$3(r35, r7, null);
        r3.L$0 = null;
        r3.label = 3;
        if (BuildersKt.withContext(r13, r14, r3) != r5) goto L145;
        return r5;
    L126:
        if (r1 != 2) goto L132;
        Context r15 = r35.getContext();
        if (r15 == null) goto L137;
        Resources r16 = r15.getResources();
        if (r16 == null) goto L137;
        r12 = r16.getString(2131900633);
    L137:
        t19.s r17 = t19.s.a;
        Context r0 = r35.getContext();
        if (r12 == null) goto L141;
        r9 = r12;
    L141:
        r17.getClass();
        t19.s.p(r0, r9);
        if (r1 != 2) goto L145;
        e0.a.X0(r10);
        goto L145
    L132:
        Context r18 = r35.getContext();
        if (r18 == null) goto L137;
        Resources r19 = r18.getResources();
        if (r19 == null) goto L137;
        r12 = r19.getString(2131900634);
        goto L137
    L120:
        r11 = null;
        goto L122
    L17:
        r1 = r3.I$1;
        r7 = r3.I$0;
        boolean r110 = r3.Z$0;
        ResultKt.throwOnFailure(r2);
    L36:
        Map<String, String> r20 = r35.f.f;
        ky8.a r111 = (ky8.a) ((com.larus.gallery.api.t) r35).d;
        if (r111 == null) goto L39;
        String r112 = r111.a;
    L40:
        String r21 = r20.get(r112);
        if (r21 == null) goto L150;
        ky8.a r113 = (ky8.a) ((com.larus.gallery.api.t) r35).d;
        if (r113 == null) goto L48;
        UserCreationFromIM r114 = r113.o;
        if (r114 == null) goto L48;
        String r115 = r114.getCreationId();
    L49:
        ky8.a r116 = (ky8.a) ((com.larus.gallery.api.t) r35).d;
        if (r116 == null) goto L52;
        String r117 = r116.c;
    L53:
        String r118 = String.valueOf(r117);
        String r119 = String.valueOf(r35.f.i.get("current_page"));
        if (r110 == false) goto L56;
        String r22 = "1";
    L57:
        ky8.a r23 = (ky8.a) ((com.larus.gallery.api.t) r35).d;
        if (r23 == null) goto L60;
        String r24 = r23.e;
    L61:
        if (r110 == false) goto L63;
        String r25 = TriggerSendLoading.NO_LOADING;
    L64:
        if (r23 == null) goto L84;
        UserCreationFromIM r26 = r23.o;
        if (r26 == null) goto L146;
        Integer r27 = r26.getCreationType();
        if (r27 != null) goto L70;
        String r29 = "";
    L85:
        ky8.a r28 = (ky8.a) ((com.larus.gallery.api.t) r35).d;
        if (r28 == null) goto L90;
        UserCreationFromIM r30 = r28.o;
        if (r30 == null) goto L90;
        Integer r31 = r30.getCreationType();
    L91:
        if (r31 != null) goto L94;
    L95:
        if (r31 != null) goto L98;
    L100:
        if (r31 != null) goto L103;
    L105:
        String r32 = "replica";
    L107:
        String r210 = r32;
        ky8.a r33 = (ky8.a) ((com.larus.gallery.api.t) r35).d;
        if (r33 == null) goto L112;
        UserCreationFromIM r34 = r33.o;
        if (r34 == null) goto L112;
        String r211 = r34.getCreationId();
    L113:
        e2.a.b(new o0(r119, null, r115, r118, r24, r210, r22, r25, String.valueOf(r35.f.i.get("recommend_from")), r211, String.valueOf(r35.f.i.get("template_rec_req_id")), null, null, r29, null, Boxing.boxInt(0), null, null, 438277), null, 3);
        e0 r38 = e0.a;
        r3.L$0 = r21;
        r3.I$0 = r7;
        r3.I$1 = r1;
        r3.label = 2;
        Object r39 = r38.h(r21, r1, r3);
        if (r39 == r5) goto L152;
        r10 = r21;
        r2 = r39;
        goto L117
    L152:
        return r5;
    L112:
        r211 = null;
        goto L113
    L103:
        if (r31.intValue() != 4) goto L105;
        r32 = "image_edit";
        goto L107
    L98:
        if (r31.intValue() != 5) goto L100;
    L106:
        r32 = ReeditType.IMAGE;
        goto L107
    L94:
        if (r31.intValue() == 2) goto L106;
    L90:
        r31 = null;
        goto L91
    L70:
        switch(r27.intValue()) {
            case 1: goto L82;
            case 2: goto L81;
            case 3: goto L80;
            case 4: goto L79;
            case 5: goto L79;
            case 6: goto L78;
            case 7: goto L77;
            case 8: goto L76;
            case 9: goto L75;
            case 10: goto L74;
            case 11: goto L73;
            case 12: goto L72;
            default: goto L148;
        };
    L72:
        String r40 = "refaudio2video";
    L83:
        r29 = r40;
        goto L85
    L73:
        r40 = "videoimagedmixed2video";
        goto L83
    L74:
        r40 = "avatar2video";
        goto L83
    L75:
        r40 = "image2video_extend";
        goto L83
    L76:
        r40 = "text2video_extend";
        goto L83
    L77:
        r40 = "image2video";
        goto L83
    L78:
        r40 = "text2video";
        goto L83
    L79:
        r40 = CreativeScene.IMAGE_TO_IMAGE;
        goto L83
    L80:
        r40 = "avatar2image";
        goto L83
    L81:
        r40 = "text2image";
        goto L83
    L82:
        r40 = "text2music";
        goto L83
    L148:
        r29 = "";
        goto L85
    L146:
        r29 = "";
        goto L85
    L84:
        r29 = "";
        goto L85
    L63:
        r25 = "1";
        goto L64
    L60:
        r24 = null;
        goto L61
    L56:
        r22 = TriggerSendLoading.NO_LOADING;
        goto L57
    L52:
        r117 = null;
    L48:
        r115 = null;
        goto L49
    L150:
        return Unit.INSTANCE;
    L39:
        r112 = null;
        goto L40
    L18:
        ResultKt.throwOnFailure(r2);
        if (r36 == false) goto L21;
    L23:
        if (r36 == false) goto L25;
        int r41 = 3;
    L26:
        if (r36 == false) goto L28;
        int r42 = 2;
    L29:
        if (r36 == false) goto L31;
        int r120 = 2;
    L32:
        MainCoroutineDispatcher r121 = Dispatchers.getMain();
        CanvasBottomProvider$setCreationPrivacy$2 r122 = new CanvasBottomProvider$setCreationPrivacy$2(r35, r120, null);
        r3.Z$0 = r36;
        r3.I$0 = r41;
        r3.I$1 = r42;
        r3.label = 1;
        if (BuildersKt.withContext(r121, r122, r3) == r5) goto L151;
        r110 = r36;
        r1 = r42;
        r7 = r41;
        goto L36
    L151:
        return r5;
    L31:
        r120 = 3;
        goto L32
    L28:
        r42 = 1;
        goto L29
    L25:
        r41 = 2;
        goto L26
    L21:
        if (z2.a.getCreationPublishConfig().b() == false) goto L23;
        new u1();
        u1.a(r35.B(), new PublisherTrackParams("picture_detail", String.valueOf(r35.f.i.get("recommend_from")), String.valueOf(r35.f.i.get("template_rec_req_id"))));
        return Unit.INSTANCE;
    L7:
        r3 = new CanvasBottomProvider$setCreationPrivacy$1(r35, r37);
        goto L8
    }

    public final void i20(UserCreation r7, long r8, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r7, "userCreation");
        Intrinsics.checkNotNullParameter(r12, "taskId");
        zp9.r.a.a(r7, r12);
        ky8.a r0 = (ky8.a) ((com.larus.gallery.api.t) this).d;
        String r1 = null;
        if (r0 == null) goto L5;
        Long r2 = r0.b;
    L6:
        if (r0 == null) goto L8;
        Long r3 = r0.d;
    L9:
        if (r0 == null) goto L11;
        r1 = r0.c;
    L11:
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.longValue() != r8) goto L37;
        if (r3 != null) goto L18;
        return;
    L18:
        if (r3.longValue() == r10) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual(r1, r12) == false) goto L39;
        ky8.a r9 = (ky8.a) ((com.larus.gallery.api.t) this).d;
        if (r9 == null) goto L33;
        String r11 = r9.a;
        if (r11 == null) goto L33;
        this.f.e.put(r11, 3);
        C(3, "onPublishSuccess");
        Fragment r13 = this.f.h;
        if (r13 == null) goto L30;
        FragmentActivity r4 = r13.getActivity();
        if (r4 == null) goto L30;
        IUgcAIGCService.Companion r5 = IUgcAIGCService.a;
        r5.y();
        r5.J(r7, r4, new View(getContext()), r4, true);
    L30:
        String r14 = r7.a;
        if (r14 == null) goto L33;
        this.f.f.put(r11, r14);
    L33:
        com.larus.gallery.api.w r15 = ((com.larus.gallery.api.t) this).e;
        if (r15 == null) goto L40;
        r15.Rf(com.larus.gallery.api.p.c.a);
        return;
    L40:
        return;
    L39:
        return;
    L37:
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }
}
