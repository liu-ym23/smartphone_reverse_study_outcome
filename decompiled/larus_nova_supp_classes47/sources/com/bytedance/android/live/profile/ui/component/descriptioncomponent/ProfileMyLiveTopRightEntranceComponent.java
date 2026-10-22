package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.base.model.user.CarouselItem;
import com.bytedance.android.live.base.model.user.LynxContainer;
import com.bytedance.android.live.base.model.user.MyLiveCarouselItem;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileUpperArea;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.room.api.view.SimpleIndicatorTextSwitcher2;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileMyLiveTopRightEntranceComponent extends com.bytedance.android.live.profile.ui.base.k {
    public HSImageView b;
    public SimpleIndicatorTextSwitcher2 c;
    public Context d;
    public Disposable e;
    public boolean f;
    public final HashMap<String, Integer> g;
    public final com.bytedance.android.live.profile.ui.base.h h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CarouselItem a;
        public final /* synthetic */ ProfileMyLiveTopRightEntranceComponent b;
        public final /* synthetic */ NewProfileUser c;

        public a(CarouselItem r1, ProfileMyLiveTopRightEntranceComponent r2, NewProfileUser r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ProfileMyLiveTopRightEntranceComponent r5 = this.b;
            ProfileMyLiveTopRightEntranceComponent.j(r5, r5.getContext(), this.c, this.a);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ProfileMyLiveTopRightEntranceComponent a;
        public final /* synthetic */ NewProfileUser b;

        public b(ProfileMyLiveTopRightEntranceComponent r1, NewProfileUser r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            ProfileMyLiveTopRightEntranceComponent r5 = this.a;
            ProfileMyLiveTopRightEntranceComponent.j(r5, r5.getContext(), this.b, null);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ProfileMyLiveTopRightEntranceComponent a;
        public final /* synthetic */ NewProfileUser b;
        public final /* synthetic */ MyLiveCarouselItem c;

        public c(ProfileMyLiveTopRightEntranceComponent r1, NewProfileUser r2, MyLiveCarouselItem r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            ProfileMyLiveTopRightEntranceComponent r6 = this.a;
            Context r0 = r6.getContext();
            NewProfileUser r1 = this.b;
            List r2 = this.c.items;
            if (r2 == null) goto L9;
            int r3 = com.bytedance.android.livesdk.dsl.util.c.a;
            SimpleIndicatorTextSwitcher2 r4 = this.a.c;
            if (r4 == null) goto L7;
            int r7 = r4.getCurrentIndex();
        L8:
            CarouselItem r8 = (CarouselItem) com.bytedance.android.livesdk.dsl.util.c.f(r2, r7);
        L10:
            ProfileMyLiveTopRightEntranceComponent.j(r6, r0, r1, r8);
            return;
        L7:
            r7 = 0;
            goto L8
        L9:
            r8 = null;
            goto L10
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "newUser");
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        Disposable r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.MyLiveTopRightArea.INSTANCE;
    }

    public final Context getContext() {
        return this.d;
    }

    public ProfileMyLiveTopRightEntranceComponent(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.h = r2;
        this.g = new HashMap();
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r3) {
        this.d = r3.getContext();
        View r4 = ((com.bytedance.android.live.profile.ui.base.e) r3).f(2131567208, true);
        SimpleIndicatorTextSwitcher2 r0 = null;
        if (r4 == null) goto L5;
        HSImageView r1 = (HSImageView) r4.findViewById(2131389709);
    L6:
        this.b = r1;
        if (r4 == null) goto L9;
        r0 = (SimpleIndicatorTextSwitcher2) r4.findViewById(2131389707);
    L9:
        this.c = r0;
        if (r0 == null) goto L13;
        p81.e r5 = new p81.e();
        Intrinsics.checkNotNullParameter(r5, "style");
        r0.a = r5;
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(final NewProfileUser r10) {
        Intrinsics.checkNotNullParameter(r10, "user");
        ProfileUpperArea r0 = r10.upperArea;
        if (r0 == null) goto L57;
        final MyLiveCarouselItem r1 = r0.carousel;
        if (r1 == null) goto L60;
        py.k r2 = r1.icon;
        if (r2 == null) goto L10;
        int r3 = r2.getWidth();
    L11:
        if (r3 <= 0) goto L15;
        HSImageView r4 = this.b;
        if (r4 == null) goto L15;
        a1.p(r4, UtilityKotlinExtentionsKt.i(r1.icon.getWidth()));
    L15:
        ImageUtil.loadImage(this.b, r1.icon, 0);
        List r5 = r1.items;
        Disposable r6 = null;
        if (r5 != null) goto L18;
    L27:
        HSImageView r7 = this.b;
        if (r7 == null) goto L30;
        r7.setOnClickListener(new c(this, r10, r1));
    L30:
        List r8 = r1.items;
        if (r8 == null) goto L58;
        final ArrayList r9 = new ArrayList();
        Iterator r12 = r8.iterator();
    L34:
        if (r12.hasNext() == false) goto L42;
        CarouselItem r13 = (CarouselItem) r12.next();
        String r14 = r13.text;
        if (r14 == null) goto L38;
        p81.d r15 = new p81.d(r14, new a(r13, this, r10));
    L39:
        if (r15 == null) goto L34;
        r9.add(r15);
        goto L34
    L38:
        r15 = null;
        goto L39
    L42:
        if ((!r9.isEmpty()) == false) goto L59;
        Disposable r16 = this.e;
        if (r16 != null) goto L46;
    L50:
        this.e = com.bytedance.android.live.profile.ui.base.i.i(this.h, EnterExitStateType.ENTER_END, new ProfileMyLiveTopRightEntranceComponent$bindUserData$$inlined$let$lambda$1(r9, this, r1, r10));
        return;
    L46:
        if ((true ^ r16.isDisposed()) == false) goto L48;
        r6 = r16;
    L48:
        if (r6 == null) goto L50;
        r6.dispose();
        goto L50
    L59:
        return;
    L58:
        return;
    L18:
        if (r5.isEmpty() != true) goto L27;
        HSImageView r17 = this.b;
        if (r17 == null) goto L22;
        a1.n(r17, 0);
    L22:
        HSImageView r18 = this.b;
        if (r18 == null) goto L25;
        r18.setOnClickListener(new b(this, r10));
    L25:
        k(r10.baseProfileInfo.getIdStr(), null);
        return;
    L10:
        r3 = 0;
        goto L11
    L60:
        return;
    }

    public final void k(String r4, CarouselItem r5) {
        if (r5 == null) goto L10;
        Integer r1 = this.g.get(r5.scene);
        if (r1 == null) goto L10;
        if (r1.intValue() != 1) goto L10;
        return;
    L10:
        if (r5 == null) goto L14;
        String r2 = r5.scene;
        if (r2 == null) goto L14;
        this.g.put(r2, 1);
    L14:
        l("livesdk_my_live_page_message_show", r4, r5);
    }

    public static void l(String r3, String r4, CarouselItem r5) {
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("user_id", r4.toString());
        if (r5 == null) goto L6;
        String r6 = r5.scene;
        if (r6 == null) goto L6;
    L7:
        r0[1] = TuplesKt.to("message_content", r6);
        if (r5 == null) goto L10;
        String r7 = "have_message_notification";
    L11:
        r0[2] = TuplesKt.to("message_status", r7);
        r0[3] = TuplesKt.to("previous_page", "my_live");
        Map r8 = MapsKt.mapOf(r0);
        com.bytedance.android.livesdk.log.j0.l().sendLog(r3, r8, new Object[0]);
        return;
    L10:
        r7 = "no_message_notification";
    L6:
        r6 = "";
        goto L7
    }

    public static final void j(ProfileMyLiveTopRightEntranceComponent r7, Context r8, NewProfileUser r9, CarouselItem r10) {
        r7.getClass();
        if (r8 == null) goto L41;
        ProfileUpperArea r0 = r9.upperArea;
        if (r0 == null) goto L38;
        MyLiveCarouselItem r1 = r0.carousel;
        if (r1 == null) goto L39;
        LynxContainer r2 = r1.jumpContainer;
        if (r2 == null) goto L40;
        String r3 = r2.scheme;
        if (r3 == null) goto L42;
        String r4 = r2.extraJson;
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        Uri r5 = UriProtector.parse(r3);
        String r6 = UriProtector.getQueryParameter(r5, "url");
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        Uri.Builder r12 = UriProtector.parse(r6).buildUpon();
        if (r10 == null) goto L24;
        String r13 = r10.scene;
        if (r13 == null) goto L24;
    L30:
        if (r13 != null) goto L32;
        r13 = "";
    L32:
        r12.appendQueryParameter("default_scene", r13);
        String r14 = r12.build().toString();
        Uri.Builder r15 = i2.e(r5, "url").buildUpon();
        StringBuilder r16 = new StringBuilder("");
        com.bytedance.android.live.profile.ui.base.m r17 = com.bytedance.android.live.profile.ui.base.i.n(r7.h);
        if (r17 == null) goto L35;
        int r18 = r17.e();
    L36:
        r16.append((int) s1.G(r18));
        String r19 = r15.appendQueryParameter("height", r16.toString()).appendQueryParameter("url", r14).build().toString();
        jc1.k.n(IBaseBrowserService.class).showHybridDialog(r8, UriProtector.parse(r19), new e0(r4));
        l("livesdk_my_live_page_message_click", r9.baseProfileInfo.getIdStr(), r10);
        return;
    L35:
        r18 = 0;
    L24:
        ProfileUpperArea r20 = r9.upperArea;
        if (r20 == null) goto L29;
        MyLiveCarouselItem r22 = r20.carousel;
        if (r22 == null) goto L29;
        r13 = r22.backupScene;
    L29:
        r13 = null;
        goto L30
    L42:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    }
}
