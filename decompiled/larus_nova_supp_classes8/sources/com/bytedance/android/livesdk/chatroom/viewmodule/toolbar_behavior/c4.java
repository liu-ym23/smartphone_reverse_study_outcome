package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.utils.image.ImageTag;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.o90;
import com.bytedance.android.livesdk.message.model.nh;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c4 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public final String a;
    public Room b;
    public DataCenter c;
    public vlc.d d;
    public HSImageView e;
    public Disposable f;
    public HSImageView g;
    public HSImageView h;
    public Disposable i;
    public final Context j;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            jc1.k.n(IOpenPlatformAudienceService.class).recordSnowFlakeShown();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ c4 a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ Function2 c;
        public final /* synthetic */ Function0 d;

        public final void onFailure(String r1, Throwable r2) {
            Function0 r3 = this.b;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }

        public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
            ImageInfo r6 = (ImageInfo) r4;
            Function2 r7 = this.c;
            if (r7 == null) goto L7;
            Boolean r8 = (Boolean) r7.invoke(r6, r5);
            if (r8 == null) goto L7;
            boolean r9 = r8.booleanValue();
        L8:
            c4.b(this.a, r5, this.d, this.b);
            if (r9 == false) goto L13;
            if (r5 == null) goto L14;
            r5.start();
            return;
        L14:
            return;
        L13:
            return;
        L7:
            r9 = true;
            goto L8
        }

        public b(c4 r1, Function0 r2, Function2 r3, Function0 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final Context getContext() {
        return this.j;
    }

    public c4(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.j = r2;
        this.a = "ToolbarOpenPlatformMiniAppBehavior";
        new nh();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3) {
        HSImageView r0 = this.g;
        if (r0 == null) goto L5;
        r0.post(a.a);
    L5:
        jc1.k.n(IOpenPlatformAudienceService.class).onSnowFlakeShow(r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r2) {
        Intrinsics.checkNotNullParameter(r2, "command");
        if ((r2 instanceof pp1.i) == false) goto L10;
        Object r3 = ((pp1.i) r2).a;
        if ((r3 instanceof nh) == false) goto L11;
        if (r3 == null) goto L9;
        nh r4 = (nh) r3;
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.OpenPlatformCardMessage");
    L11:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "v");
        Context r7 = this.j;
        Long r1 = null;
        if ((r7 instanceof FragmentActivity) == true) goto L6;
        r7 = null;
    L6:
        if (((FragmentActivity) r7) != null) goto L8;
        return;
    L8:
        if (com.bytedance.android.livesdk.utils.c1.b(this.c) == false) goto L10;
    L11:
        Room r8 = this.b;
        if (r8 == null) goto L14;
        IUser r9 = r8.author();
    L15:
        if (r9 == null) goto L36;
        JSONObject r10 = new JSONObject();
        Room r0 = this.b;
        if (r0 == null) goto L21;
        IUser r2 = r0.author();
        if (r2 == null) goto L21;
        String r3 = r2.getIdString();
    L22:
        r10.put("anchor_id", String.valueOf(r3));
        Room r4 = this.b;
        if (r4 == null) goto L25;
        r1 = Long.valueOf(r4.id);
    L25:
        r10.put("room_id", String.valueOf(r1));
        if (com.bytedance.android.livesdk.utils.c1.b(this.c) == false) goto L28;
        Map r5 = com.bytedance.android.livesdk.utils.c1.e(this.c);
    L29:
        ILiveDouPlusService r11 = jc1.k.n(ILiveDouPlusService.class);
        HashMap r12 = new HashMap();
        r12.put("refer", "link");
        r12.put("ad_extra_data", r10.toString());
        if (r5 != null) goto L32;
    L35:
        r11.logEvent(true, "live_ad", "applet_click", r12);
        int r13 = com.bytedance.android.livesdk.utils.x1.a;
        goto L36
    L32:
        if (r5.isEmpty() == true) goto L35;
        r12.putAll(r5);
        goto L35
    L28:
        r5 = com.bytedance.android.livesdk.utils.c1.f(this.c);
    L21:
        r3 = null;
    L36:
        jc1.k.n(IOpenPlatformAudienceService.class).reportMpLiveLinkClick();
        jc1.k.n(IOpenPlatformAudienceService.class).openSnowFlake();
        return;
    L14:
        r9 = null;
        goto L15
    L10:
        if (com.bytedance.android.livesdk.utils.c1.c(this.c) == false) goto L36;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void onHide(boolean r2) {
        jc1.k.n(IOpenPlatformAudienceService.class).onSnowFlakeHide(r2);
        jc1.k.n(IOpenPlatformAudienceService.class).deleteMiniAppMountInfo();
        HSImageView r3 = this.e;
        if (r3 == null) goto L9;
        DraweeController r4 = r3.getController();
        if (r4 == null) goto L9;
        Animatable r5 = r4.getAnimatable();
        if (r5 == null) goto L9;
        r5.stop();
    L9:
        HSImageView r6 = this.h;
        if (r6 == null) goto L17;
        DraweeController r7 = r6.getController();
        if (r7 == null) goto L18;
        Animatable r8 = r7.getAnimatable();
        if (r8 == null) goto L19;
        r8.stop();
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        jc1.k.n(IInteractGameService.class).setAudienceMiniAppReady(false);
        Disposable r4 = this.i;
        if (r4 == null) goto L5;
        r4.dispose();
    L5:
        Disposable r5 = this.f;
        if (r5 == null) goto L9;
        r5.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r13, DataCenter r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        Intrinsics.checkNotNullParameter(r14, "dataCenter");
        this.e = r13.findViewById(2131381527);
        this.g = r13.findViewById(2131381528);
        ev1.q r0 = ev1.q.d;
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L5;
        int r1 = 2131243765;
    L6:
        mo0.a r2 = jc1.k.n(IOpenPlatformAudienceService.class).getOpenPlatformImageLoader();
        if (r2 == null) goto L9;
        r2.a(this.g, r1, new mo0.b(ImageTag.SNOW_FLAKE, null, false, false, 30));
    L9:
        this.h = r13.findViewById(2131381521);
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L17;
        HSImageView r3 = this.h;
        if (r3 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r3);
    L14:
        HSImageView r4 = r13.findViewById(2131381522);
        this.h = r4;
        if (r4 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r4);
    L17:
        ko0.e.e.getClass();
        String r5 = o90.a.getValue().h();
        if (ko0.e.a.b() == false) goto L27;
        if (r5 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        if (r6 == true) goto L27;
        boolean r7 = true;
    L28:
        Disposable r8 = null;
        if (r7 == true) goto L32;
        r5 = null;
    L32:
        if (r5 == null) goto L41;
        HSImageView r9 = this.h;
        if (r9 == null) goto L38;
        GenericDraweeHierarchy r10 = r9.getHierarchy();
        if (r10 == null) goto L38;
        r10.setFadeDuration(0);
    L38:
        mo0.a r11 = jc1.k.n(IOpenPlatformAudienceService.class).getOpenPlatformImageLoader();
        if (r11 == null) goto L41;
        r11.b(this.h, r5, new mo0.b(ImageTag.SPREAD_FLOWERS, new b4(this), false, true, 10));
    L41:
        int r12 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(this.g);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(r13);
        Room r15 = (Room) r14.get("data_room", null);
        this.b = r15;
        this.c = r14;
        if (ht2.g.f(r15, 6, true) == false) goto L44;
        ht2.g.c(6, this.b, null);
    L44:
        this.d = (vlc.d) r14.get("data_message_manager", null);
        jc1.k.n(IInteractGameService.class).setAudienceMiniAppReady(true);
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r16 = AudienceMiniAppDataContext.a.a();
        if (r16 == null) goto L51;
        com.bytedance.live.datacontext.n r17 = r16.getToolbarEvent();
        if (r17 == null) goto L51;
        Observable r18 = r17.a();
        if (r18 == null) goto L51;
        r8 = r18.subscribe(new g4(this));
    L51:
        this.i = r8;
        return;
    L21:
        if (r5.length() == 0) goto L24;
        r6 = false;
    L27:
        r7 = false;
        goto L28
    L5:
        r1 = 2131251239;
        goto L6
    }

    public static void b(c4 r2, Animatable r3, Function0 r4, Function0 r5) {
        r2.getClass();
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        ((AnimatedDrawable2) r3).setAnimationListener(new f4(r4, r5, r3, null));
        return;
    }

    public final void a(ImageTag r9, HSImageView r10, String r11, Function2<? super ImageInfo, ? super Animatable, Boolean> r12, Function0<Unit> r13, Function0<Unit> r14) {
        if (r10 == null) goto L7;
        mo0.a r0 = jc1.k.n(IOpenPlatformAudienceService.class).getOpenPlatformImageLoader();
        if (r0 == null) goto L8;
        r0.b(r10, r11, new mo0.b(r9, new b(this, r14, r12, r13), true, true, 2));
        return;
    L8:
        return;
    }
}
