package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.share.InteractivityShareAppLogger;
import com.bytedance.android.livesdk.interactivity.comment.share.api.InteractivityShareApi;
import com.bytedance.android.livesdk.interactivity.comment.share.binder.ShareItemInfoViewBinder;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.app.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InteractivityShareSectionProvider implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<InteractivityShareController, Object> {
    public static final String d = null;
    public static final String e = null;
    public View a;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public InteractivityShareController c;

    public final class InteractivityShareController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j implements com.bytedance.android.livesdk.interactivity.comment.share.a.InterfaceC0145a, ShareItemInfoViewBinder.a, ShareItemInfoViewBinder.b {
        public final RecyclerView c;
        public final ViewGroup d;
        public final HSImageView e;
        public final TextView f;
        public com.bytedance.android.livesdk.interactivity.comment.share.a g;
        public final a h;
        public boolean i;
        public final /* synthetic */ InteractivityShareSectionProvider j;

        public static final class a implements Runnable {
            public final /* synthetic */ InteractivityShareController a;

            public a(InteractivityShareController r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                UtilityKotlinExtentionsKt.t(this.a.f);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.share.a.InterfaceC0145a
        public final void C10() {
            UtilityKotlinExtentionsKt.w(this.d);
            ImageLoader.bindImage(this.e, InteractivityShareSectionProvider.d);
            UtilityKotlinExtentionsKt.t(this.c);
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.share.a.InterfaceC0145a
        public final void y10() {
            UtilityKotlinExtentionsKt.w(this.d);
            ImageLoader.bindImage(this.e, InteractivityShareSectionProvider.e);
            UtilityKotlinExtentionsKt.t(this.c);
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.share.a.InterfaceC0145a
        public final void Ux(Items r4) {
            Intrinsics.checkNotNullParameter(r4, "items");
            UtilityKotlinExtentionsKt.t(this.d);
            MultiTypeAdapter r0 = new MultiTypeAdapter(r4);
            r0.z2(com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a.class, new ShareItemInfoViewBinder(this, this));
            r0.z2(com.bytedance.android.livesdk.interactivity.comment.share.binder.a.class, new com.bytedance.android.livesdk.interactivity.comment.share.binder.b());
            this.c.setAdapter(r0);
            UtilityKotlinExtentionsKt.w(this.c);
            if (this.i == false) goto L8;
            UtilityKotlinExtentionsKt.w(this.f);
            com.bytedance.android.livesdk.sharedpref.e<Integer> r5 = com.bytedance.android.livesdk.interactivity.comment.utils.k.a;
            Integer r1 = (Integer) r5.getValue();
            if (r1.intValue() >= 3) goto L7;
            com.bytedance.android.livesdk.sharedpref.f.d(r5, Integer.valueOf(r1.intValue() + 1));
        L7:
            MainThreadPostUtils.c(this.h, 3000);
            this.i = false;
            return;
        L8:
            UtilityKotlinExtentionsKt.t(this.f);
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.share.binder.ShareItemInfoViewBinder.b
        public final void a(com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            if (r2.d == true) goto L6;
            r2.d = true;
            InteractivityShareAppLogger.e(r2);
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.share.binder.ShareItemInfoViewBinder.a
        public final void e(final com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a r9) {
            Intrinsics.checkNotNullParameter(r9, "item");
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.j.b;
            if (r1 == null) goto L68;
            Context r2 = r1.getContext();
            if (r2 == null) goto L72;
            String r3 = r9.d();
            boolean r4 = true;
            if (r3 != null) goto L10;
        L13:
            boolean r5 = true;
        L14:
            String r6 = null;
            if (r5 == true) goto L51;
            String r0 = r9.d();
            if (r0 != null) goto L66;
        L32:
            boolean r7 = false;
        L34:
            if (r7 == false) goto L36;
            ((IInteractivityInjectService) jc1.k.n(IInteractivityInjectService.class)).openMiniAppToShare(r0);
        L37:
            String r8 = r9.b();
            if (r8 != null) goto L40;
        L43:
            if (r4 == true) goto L46;
            int r10 = InteractivityShareAppLogger.a;
            com.bytedance.android.livesdk.interactivity.common.utils.b.a(r9.b(), new InteractivityShareSectionProvider$InteractivityShareController$handleItemClick$1(r9));
        L46:
            if (r9.c() == false) goto L69;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r11 = this.j.b;
            if (r11 == null) goto L70;
            r11.J();
            return;
        L70:
            return;
        L69:
            return;
        L40:
            if (r8.length() == 0) goto L43;
            r4 = false;
            goto L43
        L36:
            jc1.k.n(IBaseLiveActionHandler.class).handle(r2, r9.d());
            goto L37
        L66:
            Uri r13 = UriProtector.parse(r0);     // Catch: Throwable -> L21
        L22:
            if (r13 == null) goto L24;
            String r14 = r13.getHost();
        L26:
            if (Intrinsics.areEqual(r14, "microapp") == true) goto L33;
            if (r13 == null) goto L30;
            r6 = r13.getHost();
        L30:
            if (Intrinsics.areEqual(r6, "microgame") == false) goto L32;
        L33:
            r7 = true;
            goto L34
        L24:
            r14 = null;
        L21:
            r13 = null;
            goto L22
        L51:
            if (this.g == null) goto L61;
            Intrinsics.checkNotNullParameter(r9, "item");
            IRoomContextService r15 = jc1.k.f(IRoomContextService.class);
            if (r15 == null) goto L61;
            com.bytedance.android.livesdk.chatroom.o r16 = IRoomContextService.a.a(r15, null, 0, 3);
            if (r16 == null) goto L61;
            com.bytedance.live.datacontext.m r17 = r16.getRoom();
            if (r17 == null) goto L61;
            IRoom r18 = (IRoom) r17.getValue();
            if (r18 == null) goto L61;
            long r19 = r18.getRoomId();
            com.bytedance.android.livesdk.interactivity.comment.share.model.b r20 = new com.bytedance.android.livesdk.interactivity.comment.share.model.b();
            r20.roomId = r19;
            r20.itemType = r9.a;
            r20.itemId = r9.g();
            r20.extra = r9.e();
            InteractivityShareApi.a.getClass();
            ((InteractivityShareApi) com.bytedance.android.live.network.c.b().e(InteractivityShareApi.class)).shareItem(r20.a()).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.interactivity.comment.share.d(r19, r9), com.bytedance.android.livesdk.interactivity.comment.share.e.a);
        L61:
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r21 = this.j.b;
            if (r21 == null) goto L64;
            r21.J();
        L64:
            InteractivityShareAppLogger.d(r9);
            return;
        L10:
            if (r3.length() == 0) goto L13;
            r5 = false;
            goto L14
        L72:
            return;
        }

        public InteractivityShareController(InteractivityShareSectionProvider r2, View r3, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "panelBridge");
            this.j = r2;
            super(r3, r4);
            this.c = r3.findViewById(2131386090);
            this.d = (ViewGroup) r3.findViewById(2131371571);
            this.e = r3.findViewById(2131371607);
            this.f = (TextView) r3.findViewById(2131391075);
            this.h = new a(this);
            if (((Number) com.bytedance.android.livesdk.interactivity.comment.utils.k.a.getValue()).intValue() >= 3) goto L5;
            boolean r5 = true;
        L6:
            this.i = r5;
            return;
        L5:
            r5 = false;
            goto L6
        }
    }

    public static final class a {
    }

    public InteractivityShareSectionProvider() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    static {
        StringBuilder r0 = new StringBuilder("https://");
        LiveCommonConstants r2 = LiveCommonConstants.INSTANCE;
        r0.append(r2.getObjectTosPath());
        r0.append("/obj/live-android/ttlive_video_search_empty.png");
        d = r0.toString();
        e = "https://" + r2.getObjectTosPath() + "/obj/live-android/ttlive_video_search_error.png";
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        InteractivityShareController r0 = this.c;
        if (r0 == null) goto L6;
        MainThreadPostUtils.d(r0.h);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        View r0 = this.a;
        if (r0 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.b;
        if (r1 != null) goto L7;
    L9:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.b;
        if (r2 == null) goto L12;
        int r3 = r2.W();
    L13:
        com.bytedance.android.live.core.utils.a1.k(r0, r3);
        goto L14
    L12:
        r3 = 0;
        goto L13
    L7:
        if (r1.W() != 0) goto L9;
        r3 = InputPanelSectionContainer.m;
    L14:
        InteractivityShareController r4 = this.c;
        if (r4 == null) goto L28;
        com.bytedance.android.livesdk.interactivity.comment.share.a r5 = r4.g;
        if (r5 == null) goto L29;
        IRoomContextService r6 = jc1.k.f(IRoomContextService.class);
        if (r6 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.o r7 = IRoomContextService.a.a(r6, null, 0, 3);
        if (r7 == null) goto L31;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L32;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L33;
        long r10 = r9.getRoomId();
        InteractivityShareApi.a.getClass();
        Disposable r11 = ((InteractivityShareApi) com.bytedance.android.live.network.c.b().e(InteractivityShareApi.class)).getItemShareList(r10).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.interactivity.comment.share.b(r5), new com.bytedance.android.livesdk.interactivity.comment.share.c(r5));
        r5.b.add(r11);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return InputSectionType.INTERACTIVITY_SHARE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5) {
        Intrinsics.checkNotNullParameter(r5, "panelBridge");
        Activity r0 = r5.getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        this.b = r5;
        View r1 = LayoutInflater.from(r0).inflate(2131566063, null);
        InteractivityShareController r2 = new InteractivityShareController(this, r1, r5);
        RecyclerView r6 = r2.c;
        r6.setLayoutManager(new LinearLayoutManager(r6.getContext()));
        com.bytedance.android.livesdk.interactivity.comment.share.a r7 = new com.bytedance.android.livesdk.interactivity.comment.share.a();
        r2.g = r7;
        ((q46.b) r7).a = r2;
        Unit r8 = Unit.INSTANCE;
        this.c = r2;
        this.a = r1;
        return r1;
    }
}
