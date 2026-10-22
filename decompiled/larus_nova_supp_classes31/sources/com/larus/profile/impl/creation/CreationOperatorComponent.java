package com.larus.profile.impl.creation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.bigimg.template.CommonTemplateLayout;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.community.api.ICommunityService;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationOperatorComponent {
    public final View a;
    public final ViewGroup b;
    public final com.larus.bmhome.view.e2 c;
    public final UserCreation d;
    public final LifecycleCoroutineScope e;
    public final j2 f;
    public final Integer g;
    public final gs9.d h;
    public final boolean i;
    public final String j;

    public static final class a {
    }

    static {
    }

    public final void a() {
        LifecycleCoroutineScope r0 = this.e;
        if (r0 == null) goto L6;
        BuildersKt.launch$default(r0, null, null, new CreationOperatorComponent$deleteCreation$1(this, null), 3, null);
        return;
    }

    public final boolean b() {
        boolean r0 = com.larus.platform.service.z2.a.getCreationPublishConfig().b();
        FLogger.a.i("CreationOperatorComponent", "isByPublisher isValid:" + this.i + ", enableEnterPublisher:" + r0);
        if (this.i == false) goto L6;
        if (r0 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public final void c() {
        final ViewGroup r10 = this.b;
        if (r10 == null) goto L13;
        ArrayList r12 = new ArrayList();
        r12.add(new com.larus.bmhome.view.screenmenu.l0(2131899197, 2131899197, null, null, null, 2131103136, null, 2131240225, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        r12.add(new com.larus.bmhome.view.screenmenu.l0(2131900631, 2131900631, null, null, null, 2131102650, null, 2131243601, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        View r11 = CreateMenu.f(new CreateMenu(r10.getContext()), r12, 0, false, null, null, null, null, new g1(this, r10), 510);
        Balloon r1 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r10, r11, false, null, null, null, null, 124);
        ViewGroup.LayoutParams r2 = r11.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
    L8:
        if (r3 == null) goto L11;
        r3.setMarginEnd((-i5.T()) + i5.h());
    L11:
        r1.v(r10, i5.Q(), i5.E());
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void d(String r9) {
        if (b() == false) goto L25;
        UserCreation r0 = this.d;
        if (r0 == null) goto L17;
        ICommunityService.Companion r2 = ICommunityService.a;
        PublisherCreation r1 = zp9.d.g(r0, this.j);
        gs9.d r4 = this.h;
        if (r4 == null) goto L11;
        gs9.b r5 = r4.f;
        if (r5 == null) goto L11;
        String r6 = r5.g;
    L12:
        UserCreationTrackParams r7 = this.d.n;
        if (r7 == null) goto L15;
        String r8 = r7.a;
    L16:
        r2.a1(r1, new PublisherTrackParams("creation_detail", r6, r8));
    L18:
        UserCreation r3 = this.d;
        if (r3 == null) goto L23;
        CreationDynamicInfo r10 = r3.h;
        if (r10 == null) goto L23;
        String r11 = r10.d;
    L24:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CreationOperatorComponent$reportPicClickAddCreation$1(r11, this, r9, null), 3, null);
        return;
    L23:
        r11 = null;
        goto L24
    L15:
        r8 = null;
    L11:
        r6 = null;
        goto L12
    L17:
        FLogger.a.e("CreationOperatorComponent", "currentCreation is null");
        goto L18
    L25:
        e(false);
        UserCreation r12 = this.d;
        if (r12 == null) goto L30;
        CreationDynamicInfo r13 = r12.h;
        if (r13 == null) goto L30;
        String r14 = r13.d;
    L31:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CreationOperatorComponent$reportPicClickAddCreation$1(r14, this, r9, null), 3, null);
        return;
    L30:
        r14 = null;
        goto L31
    }

    public final void e(boolean r29) {
        if (r29 == false) goto L5;
        int r2 = 3;
    L6:
        f(r2);
        Integer r3 = this.g;
        String r4 = "creation_private";
        if (r3 != null) goto L10;
    L12:
        String r9 = "creation_list";
    L13:
        UserCreation r5 = this.d;
        if (r5 == null) goto L16;
        String r10 = r5.a;
    L17:
        String r11 = this.j;
        if (r5 == null) goto L20;
        String r13 = zp9.d.d(r5);
    L21:
        UserCreation r6 = this.d;
        if (r6 == null) goto L24;
        String r21 = zp9.d.c(r6);
    L25:
        String r7 = "1";
        if (r29 == false) goto L28;
        String r14 = "1";
    L29:
        if (r29 == false) goto L31;
        String r15 = "0";
    L32:
        gs9.d r8 = this.h;
        if (r8 == null) goto L37;
        gs9.b r12 = r8.f;
        if (r12 == null) goto L37;
        String r16 = r12.g;
    L38:
        UserCreation r17 = this.d;
        if (r17 == null) goto L43;
        CreationDynamicInfo r18 = r17.h;
        if (r18 == null) goto L43;
        String r19 = r18.d;
    L44:
        if (r17 == null) goto L46;
        String r110 = r17.a;
    L47:
        if (r17 == null) goto L51;
        UserCreationTrackParams r20 = r17.n;
        if (r20 == null) goto L51;
        String r111 = r20.a;
    L52:
        tx9.e2.a.b(new tx9.o0("creation_detail", r9, r10, r11, r19, r13, r14, r15, r16, r110, r111, null, null, r21, null, null, null, null, 503809), null, 3);
        if (r29 == false) goto L55;
        int r22 = 2;
    L57:
        if (r29 == false) goto L59;
        int r23 = 2;
    L60:
        Integer r1 = Integer.valueOf(r23);
        if (r1 != null) goto L64;
    L66:
        if (r1 != null) goto L68;
        int r24 = 2;
    L71:
        String r25 = "";
    L72:
        Integer r112 = Integer.valueOf(r23);
        if (r112 != null) goto L76;
    L78:
        if (r112 != null) goto L81;
    L83:
        r7 = "";
    L84:
        Integer r0 = this.g;
        if (r0 != null) goto L88;
    L90:
        r4 = "creation_list";
    L91:
        tx9.m0.c(r25, r7, "creation_detail", r4);
        LifecycleCoroutineScope r26 = this.e;
        if (r26 == null) goto L95;
        BuildersKt.launch$default(r26, null, null, new CreationOperatorComponent$setCreationPrivacy$1(this, r23, r29, r22, null), 3, null);
        return;
    L95:
        return;
    L88:
        if (r0.intValue() != 2) goto L90;
    L81:
        if (r112.intValue() != 1) goto L83;
    L76:
        if (r112.intValue() != r24) goto L78;
        r7 = "0";
        goto L84
    L68:
        r24 = 2;
        if (r1.intValue() != 2) goto L71;
        r25 = "go_public";
        goto L72
    L64:
        if (r1.intValue() != 1) goto L66;
        r25 = "already_public";
        r24 = 2;
        goto L72
    L59:
        r23 = 1;
        goto L60
    L55:
        r22 = 3;
    L51:
        r111 = null;
        goto L52
    L46:
        r110 = null;
    L43:
        r19 = null;
    L37:
        r16 = null;
        goto L38
    L31:
        r15 = "1";
        goto L32
    L28:
        r14 = "0";
        goto L29
    L24:
        r21 = null;
        goto L25
    L20:
        r13 = null;
        goto L21
    L16:
        r10 = null;
        goto L17
    L10:
        if (r3.intValue() != 2) goto L12;
        r9 = "creation_private";
        goto L13
    L5:
        r2 = 2;
        goto L6
    }

    public final void f(int r5) {
        int r1 = 0;
        if (com.larus.bmhome.utils.u.h() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        com.larus.bmhome.view.e2 r2 = this.c;
        if (r2 == null) goto L19;
        if (r0 == true) goto L12;
    L17:
        r2.r1(r1);
        return;
    L12:
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L17;
        r1 = 2;
        goto L17
    L16:
        r1 = 3;
        goto L17
    L19:
        return;
    L5:
        if (AccountService.a.isLogin().booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }

    public /* synthetic */ CreationOperatorComponent(Context r16, CommonTemplateLayout r17, ViewGroup r18, CreationOperateContainerView r19, UserCreation r20, LifecycleCoroutineScope r21, j2 r22, Integer r23, gs9.d r24, boolean r25, int r26) {
        if ((r26 & 2) == 0) goto L5;
        CommonTemplateLayout r5 = null;
    L7:
        if ((r26 & 4) == 0) goto L9;
        ViewGroup r6 = null;
    L11:
        if ((r26 & 8) == 0) goto L13;
        CreationOperateContainerView r7 = null;
    L15:
        if ((r26 & 16) == 0) goto L17;
        UserCreation r8 = null;
    L19:
        if ((r26 & 32) == 0) goto L21;
        LifecycleCoroutineScope r9 = null;
    L23:
        if ((r26 & 64) == 0) goto L25;
        j2 r10 = null;
    L27:
        if ((r26 & 128) == 0) goto L29;
        Integer r11 = 2;
    L31:
        if ((r26 & 256) == 0) goto L33;
        gs9.d r12 = null;
    L35:
        if ((r26 & 512) == 0) goto L37;
        boolean r13 = false;
    L38:
        this(r16, r5, r6, r7, r8, r9, r10, r11, r12, r13, null);
        return;
    L37:
        r13 = r25;
        goto L38
    L33:
        r12 = r24;
        goto L35
    L29:
        r11 = r23;
        goto L31
    L25:
        r10 = r22;
        goto L27
    L21:
        r9 = r21;
        goto L23
    L17:
        r8 = r20;
        goto L19
    L13:
        r7 = r19;
        goto L15
    L9:
        r6 = r18;
        goto L11
    L5:
        r5 = r17;
        goto L7
    }

    public CreationOperatorComponent(Context r2, View r3, ViewGroup r4, com.larus.bmhome.view.e2 r5, UserCreation r6, LifecycleCoroutineScope r7, j2 r8, Integer r9, gs9.d r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        if (r5 == null) goto L6;
        r5.setByPublisher(b());
        return;
    }
}
