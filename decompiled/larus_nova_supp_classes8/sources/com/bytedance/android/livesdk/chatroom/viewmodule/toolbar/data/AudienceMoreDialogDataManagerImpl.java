package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import android.content.Context;
import com.bytedance.android.livesdk.a4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AddWidgetLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AdminOpDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AdminRecordUpdateLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AssembledSettingLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.CastScreenLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.CommerceDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.CommonSlotMoreLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.ConfigCompatFixLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.ControlDataDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.DislikeDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.FollowerShareLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.GIftConsumeRemindLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.IMEntranceMoreDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.LittlePluginLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.LiveFloatWindowPlayLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.MarketingWidgetPinLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.MinorRefundLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.MoreMixShareLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.MoreShareDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.NewClearScreenDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.OpenInteractGameLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.PadAndPcPlayLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.PlayQualityOptLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.PublicScreenAudienceConfigLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.ShakeMatchLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.ShareToDailyDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.StarGraphLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.SwitchAccountLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.TempAreaDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.VSOgcDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.VipIMLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.a11;
import com.bytedance.android.livesdk.config.a60;
import com.bytedance.android.livesdk.config.gc;
import com.bytedance.android.livesdk.config.setting.o;
import com.bytedance.android.livesdk.config.setting.t;
import com.bytedance.android.livesdk.config.vy;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdk.player.listen.ToolbarListenOnlyLoader;
import com.bytedance.android.livesdk.room.placeholder.behavior.p;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import nm1.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class AudienceMoreDialogDataManagerImpl implements f {
    public final CompositeDisposable a;
    public boolean b;
    public boolean c;
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.e d;
    public final g<a2, e> e;
    public Function1<? super String, Unit> f;
    public final DataCenter g;
    public final Context h;

    public static final class a implements g.b<a2> {
        public final /* synthetic */ AudienceMoreDialogDataManagerImpl a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
        public final String debugName() {
            return "Behavior Filter";
        }

        public a(AudienceMoreDialogDataManagerImpl r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.b
        public final boolean a(a2 r5) {
            Intrinsics.checkNotNullParameter(r5, "button");
            if ((r5 instanceof ToolbarButton) == false) goto L6;
            c0.b r6 = this.a.d().t((ToolbarButton) r5);
        L12:
            boolean r1 = false;
            if (r6 != null) goto L15;
            boolean r2 = true;
        L17:
            if ((r6 instanceof p) == false) goto L23;
            y r7 = ((p) r6).a;
            if (r7 == null) goto L22;
            r1 = r7.b80();
        L22:
            return !r1;
        L23:
            return r2;
        L15:
            r2 = false;
            goto L17
        L6:
            if ((r5 instanceof ExtendedToolbarButton) == false) goto L9;
            r6 = this.a.d().s((ExtendedToolbarButton) r5);
            goto L12
        L9:
            if ((r5 instanceof e) == false) goto L11;
            r6 = this.a.d().s(((e) r5).m);
            goto L12
        L11:
            r6 = null;
            goto L12
        }
    }

    public static final class b implements g.i<e> {
        public final /* synthetic */ AudienceMoreDialogDataManagerImpl a;

        public b(AudienceMoreDialogDataManagerImpl r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.i
        public final void a(List<e> r13) {
            Intrinsics.checkNotNullParameter(r13, "list");
            AudienceMoreDialogDataManagerImpl r0 = this.a;
            Unit r3 = null;
            if (r0.b == false) goto L5;
        L41:
            ArrayList r1 = new ArrayList(r13);
            this.a.getClass();
            ArrayList r2 = (ArrayList) r13;
            r2.clear();
            LinkedList r6 = new LinkedList(r1);
            Iterator<ToolbarButton> r4 = mp1.a.a.a().iterator();
        L43:
            if (r4.hasNext() == false) goto L60;
            ToolbarButton r7 = r4.next();
            Iterator r8 = r6.iterator();
        L46:
            if (r8.hasNext() == false) goto L55;
            Object r9 = r8.next();
            e r10 = (e) r9;
            if ((r10 instanceof e) == true) goto L50;
        L52:
            boolean r11 = false;
        L53:
            if (r11 == false) goto L46;
        L56:
            e r12 = (e) r9;
            if (r12 == null) goto L43;
            r6.remove(r12);
            r2.add(r12);
            goto L43
        L50:
            if (r10.e() != r7) goto L52;
            r11 = true;
            goto L53
        L55:
            r9 = null;
            goto L56
        L60:
            if (o.a() == false) goto L74;
            Iterator r5 = CollectionsKt.reversed(r6).iterator();
        L63:
            if (r5.hasNext() == false) goto L68;
            e r14 = (e) r5.next();
            if (r14.i == 1) goto L66;
            r2.add(r14);
            goto L63
        L66:
            ListProtector.add(r13, 0, r14);
            goto L63
        L68:
            Iterator<T> r15 = r13.iterator();
        L70:
            if (r15.hasNext() == false) goto L112;
            e r16 = (e) r15.next();
            if (r16.i != 1) goto L70;
            r16.i = 2;
            goto L70
        L112:
            return;
        L74:
            Iterator r17 = r6.iterator();
        L76:
            if (r17.hasNext() == false) goto L113;
            r2.add((e) r17.next());
            goto L76
        L113:
            return;
        L5:
            if (t.a() == false) goto L11;
            MorePanelDynamicControllerViewModel.Companion r18 = MorePanelDynamicControllerViewModel.Companion;
            DataCenter r19 = r0.g;
            r18.getClass();
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c r20 = MorePanelDynamicControllerViewModel.Companion.a(r19);
            if (r20 == null) goto L11;
            if (r20.needDynamicSort() != true) goto L11;
            boolean r21 = true;
        L12:
            if (r21 == false) goto L41;
            ArrayList r22 = new ArrayList();
            ArrayList r23 = new ArrayList();
            Iterator<T> r24 = r13.iterator();
        L15:
            if (r24.hasNext() == false) goto L22;
            Object r25 = r24.next();
            if (((e) r25).i != 1) goto L19;
            boolean r26 = true;
        L20:
            if (r26 == false) goto L15;
            r23.add(r25);
            goto L15
        L19:
            r26 = false;
            goto L20
        L22:
            Iterator r27 = r23.iterator();
        L24:
            if (r27.hasNext() == false) goto L29;
            e r28 = (e) r27.next();
            ((ArrayList) r13).remove(r28);
            if (o.a() == false) goto L28;
            r28.i = 2;
        L28:
            r22.add(r28);
            goto L24
        L29:
            AudienceMoreDialogDataManagerImpl r29 = this.a;
            r29.getClass();
            Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L35
            MorePanelDynamicControllerViewModel.Companion r31 = MorePanelDynamicControllerViewModel.Companion;     // Catch: Throwable -> L35
            DataCenter r32 = r29.g;     // Catch: Throwable -> L35
            r31.getClass();     // Catch: Throwable -> L35
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c r33 = MorePanelDynamicControllerViewModel.Companion.a(r32);     // Catch: Throwable -> L35
            if (r33 == null) goto L33;
            r33.dynamicSort(TypeIntrinsics.asMutableList(r13));     // Catch: Throwable -> L35
            r3 = Unit.INSTANCE;     // Catch: Throwable -> L35
        L33:
            Result.constructor-impl(r3);     // Catch: Throwable -> L35
        L37:
            Iterator r34 = CollectionsKt.reversed(r22).iterator();
        L39:
            if (r34.hasNext() == false) goto L78;
            ListProtector.add(r13, 0, (e) r34.next());
            goto L39
        L78:
            return;
        L35:
            th = move-exception;
            Result.Companion r35 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L11:
            r21 = false;
            goto L12
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.f
    public final void a() {
        Iterator r0 = this.e.a.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g.c) r0.next()).d();
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.f
    public final void b() {
        this.a.clear();
        Iterator r0 = this.e.a.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g.c) r0.next()).onUnLoad();
        goto L4
    }

    public final x3 d() {
        if (this.c == false) goto L9;
        g3 r0 = y3.f(this.g);
        if (r0 == null) goto L8;
        return r0;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    L9:
        c0 r1 = y3.i(this.g);
        if (r1 == null) goto L14;
        return (x3) r1;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }

    public void e() {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.e r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        this.e.a(new ConfigCompatFixLoader(r0));
        this.e.a(new CommonSlotMoreLoader(r0));
        this.e.a(new CommerceDynamicLoader(r0, this.h));
        this.e.a(new AdminOpDynamicLoader(r0));
        this.e.a(new NewClearScreenDynamicLoader(r0));
        this.e.a(new TempAreaDynamicLoader(r0, d(), this.h, new AudienceMoreDialogDataManagerImpl$initDynamicButtonLoaders$1(this)));
        this.e.a(new ControlDataDynamicLoader(r0, this.h, new AudienceMoreDialogDataManagerImpl$initDynamicButtonLoaders$2(this)));
        this.e.a(new DislikeDynamicLoader(r0));
        this.e.a(new VipIMLoader(r0));
        this.e.a(new IMEntranceMoreDynamicLoader(r0));
        if (u40.a.c(this.b) == true) goto L12;
        w r1 = (w) pm1.h.d.c(w.class);
        if (r1 == null) goto L12;
        VSOgcDynamicLoader r2 = r1.d(r0);
        if (r2 == null) goto L12;
        this.e.a(r2);
    L12:
        this.e.a(new StarGraphLoader(r0));
        if (o.b() == false) goto L15;
        this.e.a(new MoreShareDynamicLoader(r0));
    L15:
        this.e.a(new LittlePluginLoader(this.h, r0, new AudienceMoreDialogDataManagerImpl$initDynamicButtonLoaders$4(this)));
        this.e.a(new OpenInteractGameLoader(r0, new AudienceMoreDialogDataManagerImpl$initDynamicButtonLoaders$5(this)));
        this.e.a(new CastScreenLoader(r0, new AudienceMoreDialogDataManagerImpl$initDynamicButtonLoaders$6(this)));
        if (vy.a.getValue().getEnabled() == false) goto L18;
        this.e.a(new GIftConsumeRemindLoader(r0));
    L18:
        this.e.a(new ShareToDailyDynamicLoader(this.h, r0));
        this.e.a(new LiveFloatWindowPlayLoader(r0));
        if (((a11) a4.a.getValue()).b() == false) goto L21;
        this.e.a(new ToolbarListenOnlyLoader(r0));
    L21:
        this.e.a(new MinorRefundLoader(r0));
        this.e.a(new AddWidgetLoader(r0));
        this.e.a(new PadAndPcPlayLoader(r0));
        this.e.a(new AdminRecordUpdateLoader(r0, new AudienceMoreDialogDataManagerImpl$initDynamicButtonLoaders$7(this)));
        this.e.a(new AssembledSettingLoader(r0));
        this.e.a(new PlayQualityOptLoader(r0, this.h));
        this.e.a(new MarketingWidgetPinLoader(r0));
        this.e.a(new PublicScreenAudienceConfigLoader(r0));
        this.e.a(new FollowerShareLoader(r0));
        this.e.a(new SwitchAccountLoader(r0));
        if (a60.a.getValue().booleanValue() == false) goto L25;
        this.e.a(new ShakeMatchLoader(r0));
    L25:
        if (MoreMixSharePanelUtils.INSTANCE.isSettingEnable() == false) goto L27;
        this.e.a(new MoreMixShareLoader(this.h, r0));
    L27:
        IEnterGuideService r3 = k.f(IEnterGuideService.class);
        if (r3 == null) goto L33;
        AbsMiddlewareDynamicLoader r4 = r3.getAudienceToolbarMoreLoader(this.h, r0);
        if (r4 == null) goto L34;
        this.e.a(r4);
        return;
    L34:
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void f() {
        g<a2, e> r0 = this.e;
        g.b r1 = new a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "filter");
        g.e<T> r3 = new g.e();
        r0.b = r3;
        r3.a.add((Handler) r1);
        g<a2, e> r2 = this.e;
        g.b r4 = new cp1.a(this.g);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "filter");
        r2.c.a.add((Handler) r4);
    }

    public void g() {
        g<a2, e> r0 = this.e;
        b r1 = new b(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "sorter");
        r0.d = r1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.f
    public final List<e> getData() {
        g<a2, e> r0 = this.e;
        r0.getClass();
        ArrayList r1 = new ArrayList();
        g.C0062g<T> r2 = r0.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "list");
        Iterator r3 = r2.a.iterator();
    L3:
        boolean r4 = r3.hasNext();
        int r5 = g.f;
        if (r4 == false) goto L7;
        g.c r6 = (g.c) r3.next();
        List r7 = r6.c();
        g.a.a("Loader " + r6.debugName() + " load data:", r7);
        r1.addAll(r7);
        goto L3
    L7:
        if (((Boolean) gc.a.getValue()).booleanValue() == false) goto L9;
        LinkedHashSet r8 = new LinkedHashSet(r1);
        r1.clear();
        r1.addAll(r8);
    L9:
        r0.b.a(r1);
        g.d<T, R> r9 = r0.e;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "list");
        ArrayList r10 = new ArrayList();
        Iterator r11 = r1.iterator();
    L11:
        if (r11.hasNext() == false) goto L20;
        a2 r12 = (a2) r11.next();
        g.h<R> r13 = r9.a;
        if (r13 == 0) goto L11;
        if (r12 == null) goto L19;
        e r14 = r13.a(r12);
        if (r14 == null) goto L11;
        r10.add(r14);
        goto L11
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L20:
        r0.c.a(r10);
        g.i<R> r15 = r0.d;
        if (r15 == 0) goto L23;
        r15.a(r10);
    L23:
        g.a.a("Final Data:", r10);
        return r10;
    }

    public final Context getContext() {
        return this.h;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.f
    public final void c(Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "updateFunc");
        this.f = r5;
        DataCenter r6 = this.g;
        Boolean r0 = Boolean.FALSE;
        this.b = ((Boolean) r6.get("data_is_anchor", r0)).booleanValue();
        this.c = ((Boolean) this.g.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        this.d = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.e(this.g);
        e();
        f();
        g();
        boolean r7 = ((Boolean) this.g.get("data_is_anchor", r0)).booleanValue();
        this.b = r7;
        g<a2, e> r1 = this.e;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.f r2 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.f(this.g, r7);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "convert");
        g.d<T, R> r8 = r1.e;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r2, "converter");
        r8.a = r2;
    }

    public AudienceMoreDialogDataManagerImpl(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.g = r2;
        this.h = r3;
        this.a = new CompositeDisposable();
        this.c = true;
        this.e = new g();
    }
}
