package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new;

import androidx.lifecycle.ViewModel;
import bp1.j;
import com.bytedance.android.live.base.model.message.l5;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ContainerContextEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ListActionEnum;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.g0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f3;
import com.bytedance.android.livesdk.config.wh1;
import com.bytedance.android.livesdk.r5;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarPlatformService;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentSkin;
import com.bytedance.android.livesdkapi.depend.model.live.toolbar.IBlockComponent;
import com.bytedance.android.livesdkapi.depend.model.live.toolbar.IToolbarPermutation;
import com.bytedance.android.livesdkapi.depend.model.live.toolbar.IToolbarPermutationRule;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.room.handler.toolbar.LiveTbArchUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ot2.c;
import ot2.e;
import tlc.d;
import vlc.l;
import zo1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class BottomToolbarViewModel implements c, l {
    public IRoom a;
    public final Lazy b;
    public NewToolbarOriginalDataManager c;
    public final CompositeDisposable d;
    public final ComponentConfigManager e;
    public final ToolbarOperateManager f;
    public ap1.a g;
    public final Lazy h;
    public final long i;
    public final DataCenter j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ BottomToolbarViewModel a;

        public a(BottomToolbarViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            final NewToolbarOriginalDataManager.a r10 = (NewToolbarOriginalDataManager.a) r9;
            if (r10 == null) goto L84;
            q.c = -1;
            final BottomToolbarViewModel r0 = this.a;
            r0.getClass();
            boolean r2 = true;
            if ((r10 instanceof NewToolbarOriginalDataManager.b) == false) goto L35;
            String r1 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG();
            StringBuilder r5 = new StringBuilder("onToolbarEvent:");
            NewToolbarOriginalDataManager.b r3 = (NewToolbarOriginalDataManager.b) r10;
            s r6 = r3.c;
            if (r6 == null) goto L10;
            String r7 = r6.toString();
        L11:
            r5.append(r7);
            r5.append("-");
            r5.append(r3.d.toString());
            r5.append("-");
            r5.append(r10.a);
            r5.append("-");
            r5.append(r10.b);
            ALogger.i(r1, r5.toString());
            switch(r10.a) {
                case 1: goto L33;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L18;
                case 6: goto L15;
                case 7: goto L14;
                default: goto L85;
            };
        L14:
            final ToolbarOperateManager r11 = r0.f;
            final s r4 = r3.d;
            r11.getClass();
            Intrinsics.checkNotNullParameter(r4, "model");
            r11.d("refresh", r4, new ToolbarOperateManager$refreshToolbarComponent$1(r11, r4), new ToolbarOperateManager$refreshToolbarComponent$2(r11, r4));
            return;
        L15:
            s r8 = r3.c;
            if (r8 == null) goto L73;
            r0.f.h(r8);
            r0.f.a(r3.c);
            r0.f.d("switch", r3.d, new BottomToolbarViewModel$onToolbarEvent$$inlined$let$lambda$1(r0, r10), null);
            return;
        L73:
            return;
        L18:
            ToolbarOperateManager r12 = r0.f;
            s r13 = r3.d;
            Integer r14 = r10.b;
            r12.getClass();
            Intrinsics.checkNotNullParameter(r13, "toolbarButton");
            if (r14 != null) goto L22;
        L24:
            r2 = false;
        L25:
            ListActionEnum r15 = ListActionEnum.UPDATE;
            if (r2 == false) goto L28;
            ot2.a.b r16 = ot2.a.b.a;
        L29:
            r12.g(r15, r16, r13);
            return;
        L28:
            r16 = ot2.a.a.a;
            goto L29
        L22:
            if (r14.intValue() != 1) goto L24;
        L30:
            r0.f.h(r3.d);
            ToolbarOperateManager r17 = r0.f;
            s r18 = r3.d;
            r17.getClass();
            Intrinsics.checkNotNullParameter(r18, "toolbarButton");
            r17.g(ListActionEnum.REMOVE, ot2.a.b.a, r18);
            return;
        L31:
            r0.f.h(r3.d);
            return;
        L32:
            r0.f.h(r3.d);
            r0.f.a(r3.d);
            return;
        L33:
            r0.f.d("up", r3.d, new BottomToolbarViewModel$onToolbarEvent$1(r0), null);
            return;
        L85:
            return;
        L10:
            r7 = null;
            goto L11
        L35:
            if ((r10 instanceof NewToolbarOriginalDataManager.c) == false) goto L80;
            ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "onToolbarEvent:" + r10.a + "-" + r10.b);
            int r19 = r10.a;
            if (r19 != 100) goto L39;
            final ToolbarOperateManager r20 = r0.f;
            NewToolbarOriginalDataManager.c r21 = (NewToolbarOriginalDataManager.c) r10;
            List<s> r22 = r21.c;
            final e r23 = r21.d;
            r20.e.clear();
            if (r22 == null) goto L61;
            Iterator<T> r24 = r22.iterator();
        L51:
            if (r24.hasNext() == false) goto L61;
            final s r25 = (s) r24.next();
            ap1.a r26 = r20.b;
            if (r26 == null) goto L56;
            r26.recordComponentStart(r25.a);
        L56:
            if (r20.f(r25) == false) goto L60;
            r25.m = true;
            r20.b(r25);
            ap1.a r27 = r20.b;
            if (r27 == null) goto L60;
            r27.recordComponentEnd(r25.a);
        L60:
            r20.d("roomEnter", r25, new ToolbarOperateManager$initToolbarData$$inlined$forEach$lambda$1(r25, r20, r23), new ToolbarOperateManager$initToolbarData$$inlined$forEach$lambda$2(r20, r23));
        L61:
            k.n(IToolbarPlatformService.class).onInitToolbarData(r0.j);
            if (r0.b() == false) goto L64;
            return;
        L64:
            if (((Boolean) r5.a.getValue()).booleanValue() == false) goto L83;
            r0.j.put("data_is_toolbar_inited", Boolean.TRUE);
            return;
        L83:
            return;
        L39:
            if (r19 != 101) goto L86;
            ToolbarOperateManager r28 = r0.f;
            List<s> r29 = ((NewToolbarOriginalDataManager.c) r10).c;
            r28.getClass();
            if (r29 == null) goto L81;
            Iterator<T> r30 = r29.iterator();
        L45:
            if (r30.hasNext() == false) goto L87;
            r28.a((s) r30.next());
            goto L45
        L87:
            return;
        L81:
            return;
        L86:
            return;
        L80:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            if (v.a() == true) goto L9;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
            ALogger.e(r0.getTAG(), "Action Event Crash.");
            q.b("Action Event Crash.");
            if (r5 != null) goto L7;
            r5 = new Throwable(r0.getTAG());
        L7:
            SafetyGuard.a(null, r5, "NewToolbarLog Action Crash");
            return;
        L9:
            throw r5;
        }
    }

    public final z a() {
        return (z) this.h.getValue();
    }

    public final boolean b() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    public final void onCleared() {
        this.d.clear();
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "vm clear finish this is :" + hashCode());
    }

    public final n getCheckManager() {
        return a();
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.d;
    }

    public BottomToolbarViewModel(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.j = r4;
        this.b = LazyKt.lazy(new BottomToolbarViewModel$isAnchor$2(this));
        this.d = new CompositeDisposable();
        ComponentConfigManager r0 = new ComponentConfigManager();
        this.e = r0;
        ToolbarOperateManager r1 = new ToolbarOperateManager(r4);
        this.f = r1;
        this.h = LazyKt.lazy(BottomToolbarViewModel$checkManager$2.INSTANCE);
        a().clear();
        o r5 = j.b(r4);
        if (r5 == null) goto L7;
        com.bytedance.live.datacontext.j r6 = r5.getMessageManager();
        if (r6 == null) goto L7;
        r6.c(new AnonymousClass1(this));
    L7:
        Intrinsics.checkNotNullParameter(r0, "componentConfigManager");
        r1.c = r0;
        z r7 = a();
        Intrinsics.checkNotNullParameter(r7, "checkManagerNew");
        r1.g = r7;
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "ViewModel init finish");
        this.i = 5;
    }

    public final s findContainButtonById(int r5) {
        NewToolbarOriginalDataManager r0 = this.c;
        Object r1 = null;
        if (r0 == null) goto L36;
        Collection r2 = r0.d;
        if (r2 != null) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        if (r2 == null) goto L37;
        Collection r3 = r2;
        NewToolbarOriginalDataManager r4 = this.c;
        if (r4 == null) goto L17;
        List r6 = r4.c;
        if (r6 != null) goto L15;
        r6 = CollectionsKt.emptyList();
    L15:
        if (r6 == null) goto L17;
    L18:
        List r7 = CollectionsKt.plus(r3, r6);
        if (r7 == null) goto L38;
        Iterator r8 = r7.iterator();
    L22:
        if (r8.hasNext() == false) goto L30;
        Object r9 = r8.next();
        if (((s) r9).a != r5) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L22;
        r1 = r9;
        goto L30
    L26:
        r10 = false;
    L30:
        return (s) r1;
    L38:
        return null;
    L17:
        r6 = CollectionsKt.emptyList();
        goto L18
    L37:
        return null;
    L36:
        return null;
    }

    public final int getComponentByGroupId(int r4) {
        ToolbarOperateManager r0 = this.f;
        ot2.a.a r1 = ot2.a.a.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "container");
        ContainerContextEnv r2 = r0.d.get(r1);
        if (r2 == null) goto L10;
        f<s> r3 = r2.e;
        if (r3 == null) goto L7;
        Integer r5 = r3.getComponentByGroupId(r4);
    L8:
        if (r5 == null) goto L10;
        return r5.intValue();
    L7:
        r5 = null;
    L10:
        return -1;
    }

    public final int getComponentIndex(int r4) {
        ToolbarOperateManager r0 = this.f;
        ot2.a.a r1 = ot2.a.a.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "container");
        ContainerContextEnv r2 = r0.d.get(r1);
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.g(r4);
    }

    public final List<ToolbarButton> getFoldButtons(Boolean r6) {
        List<s> r0 = this.f.e(ot2.a.b.a, "showing");
        List r1 = CollectionsKt.plus(r0, this.f.e(ot2.a.a.a, "ready"));
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        s r4 = (s) r3.next();
        if (r6 == null) goto L8;
        boolean r5 = r6.booleanValue();
    L9:
        ToolbarButton r7 = f3.b(r4, r5, true);
        if (r7 == null) goto L4;
        r2.add(r7);
        goto L4
    L8:
        r5 = b();
        goto L9
    L12:
        return r2;
    }

    public final a0 getToolbarConfig(int r2) {
        return this.e.getToolbarConfig(r2);
    }

    public final boolean isComponentShowing(int r4) {
        ToolbarOperateManager r0 = this.f;
        ot2.a.a r1 = ot2.a.a.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "container");
        ContainerContextEnv r2 = r0.d.get(r1);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.c(r4) != true) goto L7;
        return true;
    }

    public final void onMessage(d r14) {
        if (LiveTbArchUtils.INSTANCE.enableOpt(this.j) == false) goto L6;
        return;
    L6:
        if ((r14 instanceof l5) == true) goto L8;
        return;
    L8:
        NewToolbarOriginalDataManager r0 = this.c;
        boolean r1 = false;
        if (r0 == null) goto L44;
        l5 r5 = (l5) r14;
        Intrinsics.checkNotNullParameter(r5, "message");
        m r2 = j.b(r0.i).getRoom();
        if (r2 == null) goto L19;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L19;
        ILiveToolbarData r4 = r3.getToolbarData();
        if (r4 == null) goto L19;
        IToolbarPermutation r6 = r4.getRules();
        if (r6 == null) goto L19;
        List r7 = r6.getBlockList();
    L20:
        if (r7 != null) goto L22;
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "onMessage filter, block list is null not filter! ");
    L40:
        boolean r8 = false;
    L41:
        if (r8 != true) goto L44;
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "onMessage filter, block list component is " + r5.getComponentType());
        return;
    L22:
        Iterator r9 = r7.iterator();
    L24:
        if (r9.hasNext() == false) goto L39;
        IBlockComponent r10 = (IBlockComponent) r9.next();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r11 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        String r12 = r11.getTAG();
        StringBuilder r13 = new StringBuilder("onMessage filter, for each toolbarData item is ");
        if (r10 == null) goto L28;
        Integer r15 = r10.getComponentType();
    L29:
        r13.append(r15);
        ALogger.i(r12, r13.toString());
        if (r10 == null) goto L32;
        Integer r16 = r10.getComponentType();
    L33:
        int r17 = r5.getComponentType();
        if (r16 == null) goto L24;
        if (r16.intValue() != r17) goto L24;
        ALogger.i(r11.getTAG(), "onMessage filter, filterMessageFormBlockList ");
        r8 = true;
        goto L41
    L32:
        r16 = null;
        goto L33
    L28:
        r15 = null;
        goto L29
    L39:
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "onMessage filter, filterMessageFormBlockList " + r7.toString());
    L19:
        r7 = null;
    L44:
        NewToolbarOriginalDataManager r18 = this.c;
        if (r18 == null) goto L64;
        l5 r19 = (l5) r14;
        Intrinsics.checkNotNullParameter(r19, "message");
        if (com.bytedance.android.live.core.utils.a0.c(r18.i) == false) goto L61;
        m r20 = j.b(r18.i).getRoom();
        if (r20 == null) goto L60;
        IRoom r21 = (IRoom) r20.getValue();
        if (r21 == null) goto L60;
        ILiveToolbarData r22 = r21.getToolbarData();
        if (r22 == null) goto L60;
        IToolbarPermutation r23 = r22.getRules();
        if (r23 == null) goto L60;
        List r24 = r23.getDemandList();
        if (r24 == null) goto L60;
        if (r24.contains(Integer.valueOf(r19.getComponentType())) == true) goto L61;
    L60:
        r1 = true;
    L61:
        if (r1 != true) goto L64;
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "onMessage filter, component is " + r19.getComponentType());
        return;
    L64:
        l5 r25 = (l5) r14;
        StringBuilder r26 = new StringBuilder("Receive msg:");
        r26.append(r25.getComponentType());
        r26.append(" ");
        r26.append(r25.getText());
        r26.append(" ");
        int r27 = r25.getEventType();
        if (r27 == 1) goto L75;
        if (r27 == 2) goto L74;
        if (r27 == 3) goto L73;
        if (r27 == 4) goto L72;
        if (r27 == 5) goto L71;
        String r28 = "unknown action：" + String.valueOf(r25.getEventType());
    L76:
        r26.append(r28);
        r26.append(" ");
        int r29 = r25.getOpType();
        if (r29 == 0) goto L81;
        if (r29 == 1) goto L80;
        String r30 = String.valueOf(r25.getOpType());
    L82:
        r26.append(r30);
        r26.append(" ");
        r26.append(r25.getMsgLogId());
        if (v.a() == false) goto L85;
        r26.append(" ");
        r26.append(r25.getExtraData());
    L85:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r31 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        ALogger.i(r31.getTAG(), r26.toString());
        this.j.put("data_toolbar_control_message", r14);
        NewToolbarOriginalDataManager r110 = this.c;
        if (r110 == null) goto L143;
        Intrinsics.checkNotNullParameter(r25, "message");
        s r32 = f3.a(r25);
        if (((Boolean) wh1.a.getValue()).booleanValue() == true) goto L90;
    L96:
        Map<Integer, ? extends IToolbarComponentSkin> r33 = r110.e;
        if (r33 == null) goto L101;
        IToolbarComponentSkin r34 = r33.get(Integer.valueOf(r32.a));
        if (r34 == null) goto L101;
        r32.h = r34;
        boolean r35 = r110.b.booleanValue();
        SkinLoader.c.getClass();
        r32.i = SkinLoader.a.a(r35, r34);
    L101:
        int r36 = r25.getEventType();
        if (r36 == 1) goto L133;
        if (r36 == 2) goto L131;
        if (r36 == 3) goto L128;
        if (r36 == 4) goto L120;
        if (r36 != 5) goto L149;
        int r37 = r25.getOpType();
        List<String> r38 = r110.f;
        if (r38 != null) goto L111;
    L119:
        r110.g.a(new NewToolbarOriginalDataManager.b(r32, 5, Integer.valueOf(r37)));
        return;
    L111:
        if (r38.contains(String.valueOf(r32.a)) != true) goto L119;
        ArrayList<s> r39 = r110.c;
        if (r39 == null) goto L119;
        if (r39.remove(r32) != true) goto L119;
        r32.l.b = true;
        ArrayList<s> r40 = r110.c;
        if (r40 == null) goto L119;
        r40.add(r32);
        goto L119
    L149:
        return;
    L120:
        z r41 = r110.j;
        r41.getClass();
        Intrinsics.checkNotNullParameter(r32, "model");
        Map.Entry<z.a, Runnable> r42 = r41.g(r32.a);
        if (r42 == null) goto L123;
        Runnable r43 = r41.d.remove(r42.getKey());
    L123:
        r110.f(r32);
        ArrayList<s> r44 = r110.d;
        if (r44 == null) goto L126;
        r44.remove(r32);
    L126:
        r110.g.a(new NewToolbarOriginalDataManager.b(r32, 4, null));
        return;
    L128:
        if (r110.d(r25) == true) goto L150;
        r110.h(r25);
        r110.a(r32, r25.getOpType());
        return;
    L150:
        return;
    L131:
        r110.e(r32, r25.getOpType());
        return;
    L133:
        if (r110.d(r25) == true) goto L151;
        r110.h(r25);
        r110.a(r32, r25.getOpType());
        return;
    L151:
        return;
    L90:
        if (g0.a(r32) == false) goto L96;
        if (v.a() == false) goto L94;
        String r111 = r32.toString() + r32.d;
    L95:
        ALogger.i(r31.getTAG(), "filter msg " + r111);
        return;
    L94:
        r111 = r32.toString();
        goto L95
    L143:
        return;
    L80:
        r30 = "toMore";
        goto L82
    L81:
        r30 = "toToolbar";
        goto L82
    L71:
        r28 = "UPDATE";
        goto L76
    L72:
        r28 = "NoPermission";
        goto L76
    L73:
        r28 = "HasPermission";
        goto L76
    L74:
        r28 = "DOWN";
        goto L76
    L75:
        r28 = "UP";
        goto L76
    }

    public final void onRoomUiDestory(boolean r4) {
        this.d.clear();
        if (r4 == true) goto L5;
        this.e.b();
        a().a();
    L5:
        ToolbarOperateManager r5 = this.f;
        r5.getClass();
        Intrinsics.checkNotNullParameter("onRoomExit", "event");
        Iterator<Map.Entry<ot2.a, ContainerContextEnv>> r1 = r5.d.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().getValue().a();
        goto L7
    L9:
        Iterator<Map.Entry<Integer, Disposable>> r2 = r5.f.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        r2.next().getValue().dispose();
        goto L11
    L13:
        r5.f.clear();
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "onRoomExit");
    }

    public final List p5(ot2.a.a r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        List<s> r4 = this.f.e(r3, "showing");
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(Integer.valueOf(((s) r5.next()).a));
        goto L4
    L6:
        return r0;
    }

    public final void refreshExistComponent(int r6) {
        NewToolbarOriginalDataManager r0 = this.c;
        if (r0 == null) goto L27;
        ArrayList<s> r1 = r0.c;
        if (r1 == null) goto L17;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        if (((s) r3).a != r6) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L8;
    L16:
        s r5 = (s) r3;
    L18:
        if (r5 != null) goto L20;
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.getTAG(), "refresh data is null - " + r6);
        return;
    L20:
        r0.g.a(new NewToolbarOriginalDataManager.b(r5, r5, 7, null));
        return;
    L12:
        r4 = false;
        goto L13
    L15:
        r3 = null;
        goto L16
    L17:
        r5 = null;
        goto L18
    }

    public final void register(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.e.d(r2);
    }

    public final void Kl(final IRoom r6, final e r7) {
        Intrinsics.checkNotNullParameter(r6, "room");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        ALogger.i(r0.getTAG(), "onRoomEnter");
        IToolbarPlatformService r1 = k.f(IToolbarPlatformService.class);
        if (r1 == null) goto L5;
        r1.registerPlaceHold(this.j, a());
    L5:
        com.bytedance.android.livesdk.chatroom.k r2 = j.a(this.j, 2);
        List r3 = null;
        if (r2 == null) goto L10;
        com.bytedance.live.datacontext.j r4 = r2.a();
        if (r4 == null) goto L10;
        ViewModel r5 = (ViewModel) r4.getValue();
    L12:
        if ((r5 instanceof ap1.a) == true) goto L14;
        r5 = null;
    L14:
        ap1.a r8 = (ap1.a) r5;
        this.g = r8;
        this.f.b = r8;
        this.a = r6;
        NewToolbarOriginalDataManager r9 = new NewToolbarOriginalDataManager(this.j, a(), this);
        this.c = r9;
        PropertyOwner r10 = r9.h;
        if (r10 == null) goto L19;
        Disposable r11 = r10.subscribe(new a(this), b.a);
        if (r11 == null) goto L19;
        RxUtilKt.c(r11, this.d);
    L19:
        q.a.clear();
        ILiveToolbarData r12 = r6.getToolbarData();
        if (r12 == null) goto L26;
        IToolbarPermutation r13 = r12.getRules();
        if (r13 == null) goto L26;
        IToolbarPermutationRule r14 = r13.getGeneral();
        if (r14 == null) goto L26;
        r3 = r14.getComponentSequence();
    L26:
        if (r3 != null) goto L28;
        r0.g(r0.i(), r0.d(), "componentSequence RuleDataNull");
    L28:
        ILiveToolbarData r15 = r6.getToolbarData();
        if (r15 == null) goto L31;
        int r16 = r15.getMaxCountLandscape();
    L32:
        if (r16 > 0) goto L34;
        r0.g(r0.i(), r0.d(), "maxCountLandscape SizeIsZero");
    L34:
        ILiveToolbarData r17 = r6.getToolbarData();
        if (r17 == null) goto L39;
        Integer r18 = r17.getMaxCount();
        if (r18 == null) goto L39;
        int r19 = r18.intValue();
    L40:
        if (r19 > 0) goto L42;
        r0.g(r0.i(), r0.d(), "maxCount SizeIsZeroP");
    L42:
        k.n(IToolbarPlatformService.class).doubleCheckToolbarData(false, r6, this.j, new BottomToolbarViewModel$onRoomUiLoadFinished$3(this, r7, r6));
        return;
    L39:
        r19 = 0;
        goto L40
    L31:
        r16 = 0;
    L10:
        r5 = null;
        goto L12
    }

    public final void initContainer(ot2.a r6, ot2.d r7) {
        Intrinsics.checkNotNullParameter(r6, "container");
        ToolbarOperateManager r1 = this.f;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "container");
        if (r1.d.get(r6) == null) goto L5;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b;
        ALogger.e(r0.getTAG(), "error to add container duplicate.");
        r0.g(r0.i(), r0.e(), "ContainerDuplicate");
    L5:
        DataCenter r2 = r1.h;
        HashMap<ot2.a, ContainerContextEnv> r3 = r1.d;
        ContainerContextEnv r4 = new ContainerContextEnv();
        r4.f = r2;
        r4.a = r1.c;
        r4.c = r7;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool.e.a(r6, r4);
        Unit r8 = Unit.INSTANCE;
        r3.put(r6, r4);
    }
}
