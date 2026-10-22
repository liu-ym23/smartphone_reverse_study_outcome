package com.bytedance.android.livesdk.interactivity;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.MsgOptPanel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.OptItem;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.utils.PSMessageTypeMap;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p82.a0;
import p82.y;
import p82.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s implements Runnable {
    public final /* synthetic */ q a;
    public final /* synthetic */ DataCenter b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ s a;

        public a(s r1) {
            this.a = r1;
        }

        public final void accept(Object r19) {
            com.bytedance.android.livesdk.interactivity.api.entity.l r0 = (com.bytedance.android.livesdk.interactivity.api.entity.l) r19;
            s r2 = this.a;
            q r3 = r2.a;
            DataCenter r4 = r2.b;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r0, "event");
            ALogger.d("PSOperatePanel", "processPanelRequest");
            ((ArrayList) r3.a).clear();
            ((ArrayList) r3.b).clear();
            ((ArrayList) r3.c).clear();
            Boolean r6 = PSMessageTypeMap.a;
            List r7 = PSMessageTypeMap.b(r0.b.getMessageMethod());
            Unit r8 = null;
            if (r7 == null) goto L17;
            Iterator<T> r10 = r7.iterator();
        L6:
            if (r10.hasNext() == false) goto L13;
            T r11 = r10.next();
            if (((PanelItemSymbol) r11) != PanelItemSymbol.REPLY) goto L10;
            boolean r13 = true;
        L11:
            if (r13 == false) goto L6;
        L14:
            PanelItemSymbol r14 = r11;
            if (r14 == null) goto L17;
            r14.setArea(PanelItemShowArea.TOP);
            goto L17
        L10:
            r13 = false;
            goto L11
        L13:
            r11 = (T) null;
        L17:
            RoomContext r15 = r3.d;
            if (r15 == null) goto L61;
            if (r7 == null) goto L61;
            Iterator<T> r9 = r7.iterator();
        L22:
            if (r9.hasNext() == false) goto L61;
            switch(r.b[((PanelItemSymbol) r9.next()).ordinal()]) {
                case 1: goto L40;
                case 2: goto L39;
                case 3: goto L38;
                case 4: goto L37;
                case 5: goto L36;
                case 6: goto L35;
                case 7: goto L34;
                case 8: goto L33;
                case 9: goto L32;
                case 10: goto L31;
                case 11: goto L30;
                case 12: goto L29;
                case 13: goto L28;
                case 14: goto L27;
                default: goto L26;
            };
        L27:
            p82.a r16 = new p82.w(r15, r4);
        L41:
            Intrinsics.checkNotNullParameter(r16, "item");
            MsgOptPanel r17 = r3.f;
            if (r17 == null) goto L51;
            List<OptItem> r18 = r17.itemList;
            if (r18 == null) goto L51;
            Iterator<T> r110 = r18.iterator();
        L47:
            if (r110.hasNext() == false) goto L51;
            OptItem r111 = (OptItem) r110.next();
            if (r111.itemId != r16.d.getId()) goto L47;
            r16.d.setPriority(r111.priority);
        L51:
            int r20 = r.a[r16.d.getArea().ordinal()];
            if (r20 != 1) goto L54;
            ((ArrayList) r3.a).add(r16);
            goto L22
        L54:
            if (r20 != 2) goto L56;
            ((ArrayList) r3.b).add(r16);
            goto L22
        L56:
            if (r20 != 3) goto L22;
            ((ArrayList) r3.c).add(r16);
            goto L22
        L28:
            r16 = new p82.m(r4, r15, r3.e);
            goto L41
        L29:
            r16 = new p82.b(r15);
            goto L41
        L30:
            r16 = new p82.x(r15);
            goto L41
        L31:
            r16 = new p82.p(r15);
            goto L41
        L32:
            r16 = new p82.v(r15);
            goto L41
        L33:
            r16 = new p82.o(r15);
            goto L41
        L34:
            r16 = new p82.r();
            goto L41
        L35:
            r16 = new p82.t(r15);
            goto L41
        L36:
            r16 = new y(r15);
            goto L41
        L37:
            r16 = new z();
            goto L41
        L38:
            r16 = new a0(r4, r15);
            goto L41
        L39:
            r16 = new p82.s();
            goto L41
        L40:
            r16 = new p82.u(r15);
            goto L41
        L26:
            throw new NoWhenBranchMatchedException();
        L61:
            List<com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> r5 = r3.a;
            ArrayList r21 = new ArrayList();
            Iterator r23 = ((ArrayList) r5).iterator();
        L63:
            if (r23.hasNext() == false) goto L67;
            Object r24 = r23.next();
            if (((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r24).b(r0) == false) goto L63;
            r21.add(r24);
            goto L63
        L67:
            List<? extends com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> r25 = CollectionsKt.toMutableList(r21);
            List<com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> r26 = r3.b;
            ArrayList r27 = new ArrayList();
            Iterator r28 = ((ArrayList) r26).iterator();
        L69:
            if (r28.hasNext() == false) goto L73;
            Object r112 = r28.next();
            if (((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r112).b(r0) == false) goto L69;
            r27.add(r112);
            goto L69
        L73:
            List<? extends com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> r29 = CollectionsKt.toMutableList(r27);
            List<com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> r30 = r3.c;
            ArrayList r113 = new ArrayList();
            Iterator r31 = ((ArrayList) r30).iterator();
        L75:
            if (r31.hasNext() == false) goto L79;
            Object r114 = r31.next();
            if (((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r114).b(r0) == false) goto L75;
            r113.add(r114);
            goto L75
        L79:
            List<? extends com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a> r33 = r25;
            Iterator<T> r115 = r33.iterator();
        L81:
            if (r115.hasNext() == false) goto L88;
            T r116 = r115.next();
            if (((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r116).a() != PanelItemSymbol.SECRET_CHAT) goto L85;
            boolean r117 = true;
        L86:
            if (r117 == false) goto L81;
        L89:
            if (r116 == null) goto L104;
            Iterator<T> r34 = r33.iterator();
        L92:
            if (r34.hasNext() == false) goto L99;
            T r118 = r34.next();
            if (((com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r118).a() != PanelItemSymbol.REPLY) goto L96;
            boolean r119 = true;
        L97:
            if (r119 == false) goto L92;
        L100:
            com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a r120 = (com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a) r118;
            if (r120 == null) goto L104;
            r120.a().setArea(PanelItemShowArea.MIDDLE);
            r25.remove(r120);
            r29.add(r120);
            goto L104
        L96:
            r119 = false;
            goto L97
        L99:
            r118 = null;
        L104:
            if (r29.isEmpty() == true) goto L106;
        L112:
            Collections.sort(r25, r3.i);
            Collections.sort(r29, r3.i);
            Collections.sort(r113, r3.i);
            FragmentActivity r35 = r3.e;
            if (r35 == null) goto L130;
            Intrinsics.checkNotNullParameter(r35, "<set-?>");
            r0.c = r35;
            int r36 = PSOperatePanelDialog.n;
            Intrinsics.checkNotNullParameter(r25, "topList");
            Intrinsics.checkNotNullParameter(r29, "midList");
            Intrinsics.checkNotNullParameter(r113, "bottomList");
            Intrinsics.checkNotNullParameter(r0, "event");
            PSOperatePanelDialog r37 = new PSOperatePanelDialog();
            Intrinsics.checkNotNullParameter(r25, "<set-?>");
            r37.d = r25;
            Intrinsics.checkNotNullParameter(r29, "<set-?>");
            r37.e = r29;
            Intrinsics.checkNotNullParameter(r113, "<set-?>");
            r37.f = r113;
            r37.g = r0;
            Intrinsics.checkNotNullParameter(r35, "context");
            if ((r35 instanceof FragmentActivity) == true) goto L117;
            FragmentActivity r38 = null;
        L118:
            FragmentActivity r39 = r38;
            if (r39 == null) goto L125;
            FragmentManager r40 = r39.getSupportFragmentManager();
            LandscapeRestrictionOperation r41 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r37, "PSOperatePanel", r41);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r40, r37, r41) == false) goto L135;
        L126:
            com.bytedance.android.livesdk.interactivity.api.publicscreen.r r43 = r0.d;
            if (r43 == null) goto L129;
            r43.onSuccess();
            r8 = Unit.INSTANCE;
        L129:
            if (r8 == null) goto L130;
            return;
        L135:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L134
        L124:
            r37.show(r40, "PSOperatePanel");
            goto L126
        L125:
            ALogger.e("PSOperatePanel", "context is " + r35);
            goto L126
        L117:
            r38 = r35;
        L130:
            ALogger.e("PSOperatePanel", "context is null");
            com.bytedance.android.livesdk.interactivity.api.publicscreen.r r1 = r0.d;
            if (r1 == null) goto L187;
            r1.onFailed();
            Unit r44 = Unit.INSTANCE;
            return;
        L187:
            return;
        L106:
            if (q.b(r25, PanelItemSymbol.OPEN_PROFILE_SYMBOL) == false) goto L112;
            if (q.b(r113, PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL) == false) goto L112;
            ALogger.d("PSOperatePanel", "only two item, failed");
            com.bytedance.android.livesdk.interactivity.api.publicscreen.r r45 = r0.d;
            if (r45 == null) goto L184;
            r45.onFailed();
            return;
        L184:
            return;
        L85:
            r117 = false;
            goto L86
        L88:
            r116 = null;
            goto L89
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            StringBuilder r0 = new StringBuilder("rxbus error,message:");
            r0.append(r4.getMessage());
            r0.append(", cause:");
            Throwable r5 = r4.getCause();
            if (r5 == null) goto L5;
            String r6 = r5.getMessage();
        L6:
            r0.append(r6);
            ALogger.d("PSOperatePanel", r0.toString());
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public s(q r1, DataCenter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q r0 = this.a;     // Catch: Throwable -> L6
        r0.g = xs2.b.a().b(com.bytedance.android.livesdk.interactivity.api.entity.l.class).subscribe(new a(this), b.a);     // Catch: Throwable -> L6
        q r1 = this.a;     // Catch: Throwable -> L6
        Disposable r2 = r1.g;     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        r1.h.add(r2);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
