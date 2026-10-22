package w92;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.u;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.q;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.h;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.ChatLikeLinkedHashMap;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.api.ChatLikeApi;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.DislikeItem;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.LikeItem;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.f;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.g;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.view.PSAudienceOperatePanelDialog;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.view.PSAudienceOperateSubPanelDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements l {
    public final List<k> a;
    public final List<k> b;
    public MiddlewareRoomContext c;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.api.a d;
    public final CompositeDisposable e;
    public PSAudienceOperatePanelDialog f;
    public PSAudienceOperateSubPanelDialog g;
    public t h;
    public q i;
    public final PropertyOwner<com.bytedance.android.live.base.model.data.b> j;
    public final b k;
    public final DataCenter l;

    /* JADX INFO: renamed from: w92.a$a, reason: collision with other inner class name */
    public static final class C0292a {
    }

    public static final class b<T> implements Comparator {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r3, Object r4) {
            return (int) (((k) r4).a().getPriority() - ((k) r3).a().getPriority());
        }
    }

    public static final class c implements f {
        public final /* synthetic */ a a;

        @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.f
        public final void onDismiss() {
            q r0 = this.a.i;
            if (r0 == null) goto L5;
            r0.a();
        L5:
            a r1 = this.a;
            r1.h = null;
            r1.i = null;
            r1.g = null;
        }

        public c(a r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l
    public final void a() {
        PSAudienceOperatePanelDialog r1 = this.f;     // Catch: Exception -> L22
        if (r1 != null) goto L29;
    L12:
        PSAudienceOperateSubPanelDialog r2 = this.g;     // Catch: Exception -> L22
        if (r2 != null) goto L25;
    L20:
        this.f = null;     // Catch: Exception -> L22
        this.g = null;     // Catch: Exception -> L22
        return;
    L25:
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L22
        Throwable r3 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L22
        if (r3 == null) goto L20;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L22
        goto L20
    L29:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L22
        Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L22
        if (r4 == null) goto L12;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L22
    L22:
        e = move-exception;
        SafetyGuard.a(null, e, "PSAudiencePanelDialog dismiss error");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l
    public final void c() {
        if (this.g != null) goto L37;
        List<k> r0 = this.b;
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((ArrayList) r0).iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        if (((k) r3).canShow() == false) goto L6;
        r1.add(r3);
        goto L6
    L10:
        Collections.sort(r1, this.k);
        int r4 = PSAudienceOperateSubPanelDialog.i;
        t r5 = this.h;
        Intrinsics.checkNotNullParameter(r1, "innerList");
        PSAudienceOperateSubPanelDialog r6 = new PSAudienceOperateSubPanelDialog();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r6.d = r1;
        r6.g = r5;
        this.g = r6;
        c r7 = new c(this);
        Intrinsics.checkNotNullParameter(r7, "listener");
        r6.h = r7;
        PSAudienceOperateSubPanelDialog r8 = this.g;     // Catch: Exception -> L24
        if (r8 == null) goto L38;
        Activity r9 = com.bytedance.android.live.core.utils.a.d();     // Catch: Exception -> L24
        if ((r9 instanceof FragmentActivity) == true) goto L16;
        r9 = null;
    L16:
        FragmentActivity r10 = (FragmentActivity) r9;     // Catch: Exception -> L24
        if (r10 == null) goto L39;
        FragmentManager r11 = r10.getSupportFragmentManager();     // Catch: Exception -> L24
        LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L24
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, "PSAudience OperateSubPanel", r13);     // Catch: Exception -> L24
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r8, r13) == true) goto L40;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L22:
        r8.show(r11, "PSAudience OperateSubPanel");     // Catch: Exception -> L24
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L24:
        e = move-exception;
        SafetyGuard.a(null, e, "PSAudienceSubPanelDialog show error");
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l
    public final void destroy() {
        ((ArrayList) this.a).clear();
        ((ArrayList) this.b).clear();
        this.e.clear();
        PSAudienceOperatePanelDialog r1 = this.f;     // Catch: Throwable -> L12 Exception -> L14
        if (r1 != null) goto L30;
    L16:
        PSAudienceOperateSubPanelDialog r2 = this.g;     // Catch: Throwable -> L12 Exception -> L14
        if (r2 != null) goto L34;
    L26:
        this.f = null;
        this.g = null;
        return;
    L34:
        r2.dismissAllowingStateLoss();     // Catch: Throwable -> L12 Exception -> L20
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L12 Exception -> L14
        Throwable r3 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L12 Exception -> L14
        if (r3 == null) goto L26;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L12 Exception -> L14
    L30:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L8 Throwable -> L12
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L12 Exception -> L14
        Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L12 Exception -> L14
        if (r4 == null) goto L16;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L12 Exception -> L14
    L14:
        e = move-exception;
        SafetyGuard.a(null, e, "PSAudienceManager onDestory, dismiss error");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.f = null;
        this.g = null;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l
    public final boolean p() {
        if (this.f == null) goto L5;
    L8:
        return true;
    L5:
        if (this.g != null) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l
    public final PropertyOwner<com.bytedance.android.live.base.model.data.b> d() {
        return this.j;
    }

    public a(DataCenter r2) {
        this.l = r2;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.e = new CompositeDisposable();
        this.j = new PropertyOwner(new com.bytedance.android.live.base.model.data.b());
        this.k = b.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l
    public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.api.b r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.d = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l
    public final boolean e(t r18, View r19, q r20) {
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r19, "view");
        Activity r6 = com.bytedance.android.live.core.utils.a.d();
        if ((r6 instanceof FragmentActivity) == true) goto L5;
        r6 = null;
    L5:
        FragmentActivity r7 = (FragmentActivity) r6;
        if (this.f != null) goto L177;
        if (r7 == null) goto L221;
        IMiddlewareUserService r8 = jc1.k.f(IMiddlewareUserService.class);
        if (r8 != null) goto L11;
    L14:
        boolean r9 = false;
    L15:
        if (r9 == false) goto L222;
        this.h = r18;
        this.i = r20;
        ((ArrayList) this.a).clear();
        ((ArrayList) this.b).clear();
        MiddlewareRoomContext r10 = this.c;
        long r11 = 0;
        if (r10 == null) goto L24;
        m r13 = r10.getRoom();
        if (r13 == null) goto L24;
        Room r14 = (Room) r13.getValue();
        if (r14 == null) goto L24;
        long r15 = r14.getRoomId();
    L25:
        t r16 = this.h;
        if (r16 == null) goto L28;
        r11 = r16.getMessageId();
    L28:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r17 = com.bytedance.android.livesdk.interactivity.api.q.i();
        if ((r17 instanceof PublicScreenContext) == true) goto L31;
        r17 = null;
    L31:
        PublicScreenContext r110 = (PublicScreenContext) r17;
        if (r110 == null) goto L44;
        i<ChatLikeLinkedHashMap> r111 = r110.getLocalLikeStatusInfoMap();
        if (r111 == null) goto L44;
        ChatLikeLinkedHashMap r112 = (ChatLikeLinkedHashMap) r111.getValue();
        if (r112 == null) goto L44;
        com.bytedance.android.live.base.model.data.b r113 = (com.bytedance.android.live.base.model.data.b) r112.get(Long.valueOf(r11));
        if (r113 == null) goto L44;
        l r114 = com.bytedance.android.livesdk.interactivity.api.q.a();
        if (r114 == null) goto L44;
        PropertyOwner<com.bytedance.android.live.base.model.data.b> r115 = r114.d();
        if (r115 == null) goto L44;
        r115.a(r113);
    L44:
        ChatLikeApi.a.getClass();
        ChatLikeApi r116 = (ChatLikeApi) com.bytedance.android.live.network.c.b().e(ChatLikeApi.class);
        if (r116 == null) goto L53;
        Observable<com.bytedance.android.livesdk.interactivity.publicscreen.panel.model.b> r21 = r116.getChatMsgStatus(Long.valueOf(r15), String.valueOf(r11));
        if (r21 == null) goto L53;
        Observable r23 = r21.compose(RxUtil.rxSchedulerHelper());
        if (r23 == null) goto L53;
        Disposable r24 = r23.subscribe(new d(r11), e.a);
        if (r24 == null) goto L53;
        this.e.add(r24);
    L53:
        boolean r25 = h.a;
        AudiencePanelItemSymbol r26 = AudiencePanelItemSymbol.AT;
        r26.setShowOutside(true);
        Unit r117 = Unit.INSTANCE;
        List r27 = CollectionsKt.listOf(new AudiencePanelItemSymbol[]{AudiencePanelItemSymbol.PROFILE, AudiencePanelItemSymbol.LIKE, AudiencePanelItemSymbol.DISLIKE, r26, AudiencePanelItemSymbol.MORE, AudiencePanelItemSymbol.COPY, AudiencePanelItemSymbol.REPORT, AudiencePanelItemSymbol.SECRET_CHAT});
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.a r28 = this.d;
        if (r28 == null) goto L77;
        List<u> r29 = r28.itemList;
        if (r29 == null) goto L77;
        Iterator<T> r30 = r29.iterator();
    L59:
        if (r30.hasNext() == false) goto L77;
        u r118 = (u) r30.next();
        Iterator r119 = r27.iterator();
    L62:
        if (r119.hasNext() == false) goto L59;
        AudiencePanelItemSymbol r120 = (AudiencePanelItemSymbol) r119.next();
        if (r120.getId() != r118.itemId) goto L62;
        r120.setShowOutside(r118.showOutside);
        r120.setCanShow(r118.canShow);
        List<String> r31 = r118.insideName;
        if (r31 != null) goto L68;
    L70:
        List<String> r33 = r118.outsideName;
        if (r33 != null) goto L73;
    L75:
        r120.setPriority(r118.priority);
        goto L59
    L73:
        if ((!r33.isEmpty()) == false) goto L75;
        r120.setOutsideName(r33);
        goto L75
    L68:
        if ((!r31.isEmpty()) == false) goto L70;
        r120.setInsideName(r31);
    L77:
        ArrayList r34 = new ArrayList();
        Iterator r35 = r27.iterator();
    L79:
        if (r35.hasNext() == false) goto L83;
        Object r36 = r35.next();
        if (((AudiencePanelItemSymbol) r36).getCanShow() == false) goto L79;
        r34.add(r36);
        goto L79
    L83:
        Iterator r37 = r34.iterator();
    L85:
        if (r37.hasNext() == false) goto L105;
        switch(w92.b.a[((AudiencePanelItemSymbol) r37.next()).ordinal()]) {
            case 1: goto L97;
            case 2: goto L96;
            case 3: goto L95;
            case 4: goto L94;
            case 5: goto L93;
            case 6: goto L92;
            case 7: goto L91;
            case 8: goto L90;
            default: goto L89;
        };
    L90:
        com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b r38 = new com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.i(this.l);
    L98:
        Intrinsics.checkNotNullParameter(r38, "item");
        if (r38.e.getShowOutside() == false) goto L101;
        ((ArrayList) this.a).add(r38);
    L102:
        t r39 = this.h;
        if (r39 == null) goto L85;
        Intrinsics.checkNotNullParameter(r39, "message");
        r38.c = r39;
        goto L85
    L101:
        ((ArrayList) this.b).add(r38);
        goto L102
    L91:
        r38 = new com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.h();
        goto L98
    L92:
        r38 = new com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.c();
        goto L98
    L93:
        r38 = new com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.d();
        goto L98
    L94:
        r38 = new com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.a();
        goto L98
    L95:
        r38 = new DislikeItem(this.c);
        goto L98
    L96:
        r38 = new LikeItem(this.c);
        goto L98
    L97:
        r38 = new g();
        goto L98
    L89:
        throw new NoWhenBranchMatchedException();
    L105:
        List<k> r40 = this.b;
        if ((r40 instanceof Collection) == true) goto L108;
    L110:
        Iterator r41 = ((ArrayList) r40).iterator();
    L112:
        if (r41.hasNext() == false) goto L116;
        if (((k) r41.next()).canShow() == false) goto L112;
        boolean r43 = false;
    L117:
        if (r43 == false) goto L124;
        Iterator r44 = ((ArrayList) this.a).iterator();
    L120:
        if (r44.hasNext() == false) goto L124;
        if (((k) r44.next()).a() != AudiencePanelItemSymbol.MORE) goto L120;
        r44.remove();
    L124:
        List<k> r45 = this.a;
        ArrayList r46 = new ArrayList();
        Iterator r47 = ((ArrayList) r45).iterator();
    L126:
        if (r47.hasNext() == false) goto L130;
        Object r48 = r47.next();
        if (((k) r48).canShow() == false) goto L126;
        r46.add(r48);
        goto L126
    L130:
        List<? extends k> r49 = CollectionsKt.toMutableList(r46);
        List<k> r50 = this.b;
        List<? extends k> r51 = r49;
        Iterator<T> r53 = r51.iterator();
    L132:
        if (r53.hasNext() == false) goto L139;
        Object r121 = r53.next();
        if (((k) r121).a() != AudiencePanelItemSymbol.SECRET_CHAT) goto L136;
        boolean r122 = true;
    L137:
        if (r122 == false) goto L132;
    L140:
        if (r121 == null) goto L154;
        Iterator<T> r54 = r51.iterator();
    L143:
        if (r54.hasNext() == false) goto L150;
        Object r55 = r54.next();
        if (((k) r55).a() != AudiencePanelItemSymbol.AT) goto L147;
        boolean r123 = true;
    L148:
        if (r123 == false) goto L143;
    L151:
        k r56 = (k) r55;
        if (r56 == null) goto L154;
        boolean r124 = false;
        r56.a().setShowOutside(false);
        r49.remove(r56);
        ((ArrayList) r50).add(r56);
    L155:
        Collections.sort(r49, this.k);
        if (r49.isEmpty() == false) goto L158;
        return r124;
    L158:
        int r57 = PSAudienceOperatePanelDialog.m;
        Intrinsics.checkNotNullParameter(r49, "outerList");
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r19, "view");
        PSAudienceOperatePanelDialog r4 = new PSAudienceOperatePanelDialog();
        Intrinsics.checkNotNullParameter(r49, "<set-?>");
        r4.d = r49;
        r4.e = r18;
        r4.j = r19;
        this.f = r4;
        w92.c r0 = new w92.c(this, r20);
        Intrinsics.checkNotNullParameter(r0, "listener");
        r4.l = r0;
        PSAudienceOperatePanelDialog r1 = this.f;     // Catch: Exception -> L174
        if (r1 == null) goto L176;
        Activity r3 = com.bytedance.android.live.core.utils.a.d();     // Catch: Exception -> L174
        if ((r3 instanceof FragmentActivity) == true) goto L164;
        r3 = null;
    L164:
        FragmentActivity r5 = (FragmentActivity) r3;     // Catch: Exception -> L174
        if (r5 == null) goto L176;
        if (r5.isFinishing() == true) goto L176;
        FragmentManager r58 = r5.getSupportFragmentManager();     // Catch: Exception -> L174
        LandscapeRestrictionOperation r59 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L174
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "PSAudienceOperatePanel_Log", r59);     // Catch: Exception -> L174
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r58, r1, r59) == true) goto L176;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L179
    L172:
        r1.show(r58, "PSAudienceOperatePanel_Log");     // Catch: Exception -> L174
    L176:
        return true;
    L174:
        e = move-exception;
        SafetyGuard.a(null, e, "PSAudiencePanelDialog show error");
        goto L176
    L147:
        r123 = false;
        goto L148
    L150:
        r55 = null;
    L154:
        r124 = false;
        goto L155
    L136:
        r122 = false;
        goto L137
    L139:
        r121 = null;
    L116:
        r43 = true;
        goto L117
    L108:
        if (((ArrayList) r40).isEmpty() == false) goto L110;
    L24:
        r15 = 0;
        goto L25
    L222:
        return false;
    L11:
        if (r8.user().isLogin() == true) goto L13;
        com.bytedance.android.livesdk.user.e r60 = r8.user();
        com.bytedance.android.livesdk.user.l.a r125 = new com.bytedance.android.livesdk.user.l.a();
        r125.a = s1.B(2131915990);
        r125.d = "live_comment_click";
        r125.c = -1;
        r60.login(r7, new com.bytedance.android.livesdk.user.l(r125)).subscribe(new com.bytedance.android.livesdk.user.h());
        goto L14
    L13:
        r9 = true;
        goto L15
    L221:
        return false;
    L177:
        return false;
    }
}
