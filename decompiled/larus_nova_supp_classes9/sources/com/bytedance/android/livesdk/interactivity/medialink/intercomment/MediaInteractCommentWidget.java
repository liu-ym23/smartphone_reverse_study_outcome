package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.e80;
import com.bytedance.android.livesdk.config.u51;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/MediaInteractCommentWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/b;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaInteractCommentWidget extends LiveWidget implements com.bytedance.android.livesdk.interactivity.medialink.intercomment.b {
    public static final /* synthetic */ int p = 0;
    public MediaInteractCommentDataContext a;
    public final CompositeDisposable b;
    public final RoomContext c;
    public final boolean d;
    public hy.e e;
    public int f;
    public final d g;
    public long h;
    public boolean i;
    public int j;
    public final j k;
    public final k l;
    public final int m;
    public final ViewGroup n;
    public final Function0<ViewGroup> o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MediaInteractCommentWidget a;

        public b(MediaInteractCommentWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            MediaInteractCommentWidget.wq(this.a);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MediaInteractCommentWidget a;

        public c(MediaInteractCommentWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            MediaInteractCommentWidget r4 = this.a;
            int r0 = MediaInteractCommentWidget.p;
            r4.Bq();
        }
    }

    static {
    }

    public MediaInteractCommentWidget() {
        throw null;
    }

    public final void Bq() {
        Integer r3 = null;
        boolean r4 = true;
        if (this.d == true) goto L5;
    L26:
        boolean r0 = false;
    L28:
        if (this.d == false) goto L30;
    L52:
        boolean r1 = false;
    L53:
        ViewGroup r2 = yq();
        if (r0 == true) goto L56;
        if (r1 == false) goto L69;
        if (r2 == null) goto L71;
        this.g.c(false);
        if (r2.getVisibility() == 0) goto L71;
        r2.setVisibility(0);
    L71:
        MediaInteractCommentDataContext r5 = this.a;
        if (r5 == null) goto L81;
        MutableLiveData<Boolean> r6 = r5.getShowInterCommentIcon();
        if (r6 == null) goto L82;
        if (r0 == true) goto L79;
        if (r1 == true) goto L79;
        r4 = false;
    L79:
        r6.setValue(Boolean.valueOf(r4));
        return;
    L82:
        return;
    L81:
        return;
    L69:
        if (r2 == null) goto L71;
        r2.setVisibility(8);
        goto L71
    L56:
        if (this.i == false) goto L58;
    L60:
        if (r2 == null) goto L71;
        if (r2.getVisibility() == 0) goto L71;
        r2.setVisibility(0);
        goto L71
    L58:
        if (this.j == 0) goto L60;
        this.i = true;
        this.g.c(true);
        goto L60
    L30:
        if (Aq(this.m) == false) goto L52;
        MediaInteractCommentDataContext r7 = this.a;
        if (r7 == null) goto L36;
        LiveData<Integer> r8 = r7.getInterComState();
        if (r8 == null) goto L36;
        r3 = (Integer) r8.getValue();
    L36:
        if (r3 == null) goto L52;
        if (r3.intValue() != 4) goto L52;
        hy.e r9 = this.e;
        if (r9 == null) goto L45;
        List r10 = r9.getOnlineUserList();
        if (r10 == null) goto L45;
        int r11 = r10.size();
    L46:
        if (r11 > 2) goto L52;
        if (Intrinsics.areEqual(((u51) e80.a.getValue()).commentAudienceStatusSync, Boolean.TRUE) == false) goto L52;
        if (e92.a.a() == true) goto L52;
        r1 = true;
    L45:
        r11 = 0;
        goto L46
    L5:
        if (Aq(this.m) == true) goto L16;
        MediaInteractCommentDataContext r13 = this.a;
        if (r13 == null) goto L11;
        LiveData<Integer> r14 = r13.getInterComState();
        if (r14 == null) goto L11;
        Integer r15 = (Integer) r14.getValue();
    L12:
        if (r15 == null) goto L26;
        if (r15.intValue() != 4) goto L26;
    L11:
        r15 = null;
    L16:
        hy.e r16 = this.e;
        if (r16 == null) goto L21;
        List r17 = r16.getOnlineUserList();
        if (r17 == null) goto L21;
        int r18 = r17.size();
    L22:
        if (r18 > 2) goto L26;
        if (e92.a.a() == true) goto L26;
        r0 = true;
    L21:
        r18 = 0;
        goto L22
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.intercomment.b
    public final boolean a0() {
        MediaInteractCommentDataContext r0 = this.a;
        if (r0 == null) goto L7;
        LiveData<Integer> r1 = r0.getInterComState();
        if (r1 == null) goto L7;
        Integer r2 = (Integer) r1.getValue();
    L8:
        if (r2 != null) goto L11;
    L13:
        return false;
    L11:
        if (r2.intValue() != 4) goto L13;
        return true;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.intercomment.b
    public final void ao() {
        MediaInteractCommentDataContext r0 = this.a;
        if (r0 == null) goto L7;
        LiveData<Integer> r1 = r0.getInterComState();
        if (r1 == null) goto L7;
        Integer r2 = (Integer) r1.getValue();
    L8:
        int r3 = 2131251947;
        if (r2 != null) goto L12;
    L20:
        if (r2 != null) goto L23;
    L31:
        Bq();
        return;
    L23:
        if (r2.intValue() != 0) goto L31;
        MediaInteractCommentView r4 = zq();
        if (r4 == null) goto L31;
        boolean r5 = !this.d;
        HSImageView r6 = r4.a(2131379789);
        if (r5 == true) goto L30;
        r3 = 2131251942;
    L30:
        ImageLoader.bindDrawableResource(r6, r3);
        goto L31
    L12:
        if (r2.intValue() != 4) goto L20;
        MediaInteractCommentView r7 = zq();
        if (r7 == null) goto L31;
        boolean r8 = !this.d;
        HSImageView r9 = r7.a(2131379789);
        if (r8 == true) goto L19;
        r3 = 2131251945;
    L19:
        ImageLoader.bindDrawableResource(r9, r3);
    L7:
        r2 = null;
        goto L8
    }

    public final ViewGroup yq() {
        ViewGroup r0 = this.n;
        if (r0 != null) goto L9;
        Function0<ViewGroup> r1 = this.o;
        if (r1 != null) goto L10;
        return null;
    L10:
        return (ViewGroup) r1.invoke();
    L9:
        return r0;
    }

    public final void onCreate() {
        super.onCreate();
        Pair r0 = com.bytedance.live.datacontext.d.a(new MediaInteractCommentWidget$onCreate$dataPair$1(this));
        this.a = (MediaInteractCommentDataContext) r0.getFirst();
        com.bytedance.live.datacontext.b.a((DataContext) r0.getFirst(), MediaInteractCommentDataContext.TAG);
        ((MediaInteractCommentDataContext) r0.getFirst()).getService().d(this);
        this.b.add((Disposable) r0.getSecond());
        if (this.m != 17) goto L11;
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r1 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if (r1 == null) goto L7;
        hy.e r2 = r1.Np();
    L8:
        this.e = r2;
        if (r2 == null) goto L11;
        r2.i(this.k);
        goto L11
    L7:
        r2 = null;
    L11:
        MediaInteractCommentDataContext r3 = this.a;
        if (r3 == null) goto L16;
        LiveData<Integer> r4 = r3.getInterComState();
        if (r4 == null) goto L16;
        r4.observeForever(this.l);
    L16:
        Bq();
        MediaInteractCommentDataContext r5 = this.a;
        if (r5 == null) goto L25;
        com.bytedance.live.datacontext.k<Object> r6 = r5.getOnIconClickEvent();
        if (r6 == null) goto L25;
        PublishSubject r7 = r6.onEvent();
        if (r7 == null) goto L25;
        Disposable r8 = r7.subscribe(new b(this));
        if (r8 == null) goto L25;
        this.b.add(r8);
    L25:
        ViewGroup r9 = yq();
        if (r9 == null) goto L28;
        r9.setOnClickListener(x0.a(new AnonymousClass3(this)));
    L28:
        u51 r10 = (u51) e80.a.getValue();
        Boolean r11 = r10.commentIntroEnable;
        Boolean r13 = Boolean.TRUE;
        int r14 = 1;
        if (Intrinsics.areEqual(r11, r13) == false) goto L37;
        Integer r15 = r10.commentIntroVersion;
        if (r15 == null) goto L33;
        int r16 = r15.intValue();
    L35:
        if (r16 <= ((Number) com.bytedance.android.livesdk.sharedpref.b.a3.getValue()).intValue()) goto L37;
        boolean r17 = true;
    L38:
        if (r17 == false) goto L46;
        com.bytedance.android.livesdk.sharedpref.e r18 = com.bytedance.android.livesdk.sharedpref.b.b3;
        if (((Boolean) r18.getValue()).booleanValue() == true) goto L42;
        com.bytedance.android.livesdk.sharedpref.f.d(r18, r13);
    L42:
        com.bytedance.android.livesdk.sharedpref.e r19 = com.bytedance.android.livesdk.sharedpref.b.a3;
        Integer r20 = r10.commentIntroVersion;
        if (r20 == null) goto L45;
        r14 = r20.intValue();
    L45:
        Integer r21 = Integer.valueOf(r14);
        r19.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r19, r21);
    L46:
        RoomContext r23 = this.c;
        if (r23 == null) goto L56;
        com.bytedance.live.datacontext.m r24 = r23.getCleanMode();
        if (r24 == null) goto L56;
        Observable r25 = r24.a();
        if (r25 == null) goto L56;
        Disposable r26 = r25.subscribe(new c(this));
        if (r26 == null) goto L56;
        RxUtilKt.c(r26, this.b);
    L56:
        if (this.d == true) goto L59;
        u.l().addSendLogFilter(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.interactivity.medialink.intercomment.c.class), com.bytedance.android.livesdk.interactivity.medialink.intercomment.c.a);
        return;
    L59:
        return;
    L33:
        r16 = 1;
    L37:
        r17 = false;
        goto L38
    }

    public final void onDestroy() {
        super.onDestroy();
        ViewGroup r0 = yq();
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.b.dispose();
        MediaInteractCommentDataContext r1 = this.a;
        if (r1 == null) goto L10;
        LiveData<Integer> r2 = r1.getInterComState();
        if (r2 == null) goto L10;
        r2.removeObserver(this.l);
    L10:
        hy.e r3 = this.e;
        if (r3 == null) goto L14;
        r3.h(this.k);
    L14:
        if (this.d == true) goto L17;
        u.l().removeSendLogFilter(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.interactivity.medialink.intercomment.c.class));
        return;
    }

    public final MediaInteractCommentView zq() {
        ViewGroup r0 = yq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (MediaInteractCommentView) r0.findViewById(2131375500);
    }

    public MediaInteractCommentWidget(Function0 r3) {
        this.m = 17;
        RoomContext r0 = null;
        this.n = null;
        this.o = r3;
        this.b = new CompositeDisposable();
        RoomContext r4 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r4 instanceof RoomContext) == false) goto L6;
        r0 = r4;
    L6:
        RoomContext r1 = r0;
        this.c = r1;
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.i r5 = r1.isAnchor();
        if (r5 == null) goto L13;
        Boolean r6 = (Boolean) r5.getValue();
        if (r6 == null) goto L13;
        boolean r7 = r6.booleanValue();
    L14:
        this.d = r7;
        this.g = new d();
        this.k = new j(this);
        this.l = new k(this);
        return;
    L13:
        r7 = false;
        goto L14
    }

    public static final void wq(MediaInteractCommentWidget r9) {
        MediaInteractCommentDataContext r0 = r9.a;
        if (r0 == null) goto L8;
        LiveData<Integer> r1 = r0.getInterComState();
        if (r1 == null) goto L8;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L8;
    L9:
        int r3 = r2.intValue();
        if (r9.d == true) goto L15;
        if (r3 != 4) goto L13;
        f2.b(2131920268, 0);
    L13:
        r9.g.getClass();
        d.b(r3, false);
        return;
    L15:
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L35;
        f2.b(2131920269, 0);
    L50:
        if (r9.d == false) goto L57;
        r9.g.getClass();
        d.b(r3, true);
        return;
    L57:
        return;
    L35:
        if (r3 != 4) goto L50;
        z0 r4 = z0.a();
        Context r5 = r9.getContext();
        r4.getClass();
        com.bytedance.android.livesdk.widget.x0.b r6 = new com.bytedance.android.livesdk.widget.x0.b(r5, 4);
        r6.m(2131920273);
        if (r9.f < 3) goto L39;
    L47:
        int r7 = 2131920272;
    L48:
        r6.l(r7);
        r6.i(0, 2131920806, new l(r9));
        r6.i(1, 2131915442, m.a);
        r6.n();
        goto L50
    L39:
        if (System.currentTimeMillis() > r9.h) goto L41;
    L43:
        boolean r8 = false;
    L44:
        if (r8 == true) goto L47;
        r7 = 2131920271;
        goto L48
    L41:
        if ((System.currentTimeMillis() - r9.h) > 30000) goto L43;
        r8 = true;
        goto L44
    L17:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.b3.getValue()).booleanValue() == false) goto L24;
        MediaInteractCommentInviteDialog r10 = new MediaInteractCommentInviteDialog(((Widget) r9).context, new o(r9));
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r10);
    L29:
        MediaInteractCommentView r11 = r9.zq();
        if (r11 == null) goto L32;
        r11.a(2131379784).setVisibility(8);
    L32:
        com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.b.Z2;
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, 2);
        goto L50
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L53
    L22:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        goto L29
    L24:
        if (r9.d == false) goto L26;
        r9.g.getClass();
        d.e(false, false);
    L26:
        MediaInteractCommentDataContext r14 = r9.a;
        if (r14 == null) goto L29;
        r14.invite();
    L8:
        r2 = 0;
        goto L9
    }

    public static final void xq(MediaInteractCommentWidget r2) {
        r2.getClass();
        String r0 = ((u51) e80.a.getValue()).commentIntroLynxUrl;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r0) == true) goto L9;
        jc1.k.n(ILiveActionHandler.class).handle(((Widget) r2).context, r0);
        return;
    }

    public final boolean Aq(int r3) {
        if (r3 != 17) goto L18;
        RoomContext r4 = this.c;
        if (r4 == null) goto L18;
        com.bytedance.live.datacontext.m r5 = r4.getRoom();
        if (r5 == null) goto L18;
        Room r6 = (Room) r5.getValue();
        if (r6 == null) goto L18;
        Map r7 = r6.anchorAbMap;
        if (r7 == null) goto L18;
        if (r7.containsKey("chat_intercommunicate_multi_anchor") == true) goto L16;
        r7 = null;
    L16:
        if (r7 == null) goto L18;
        return Intrinsics.areEqual((String) r7.get("chat_intercommunicate_multi_anchor"), "2");
    L18:
        return false;
    }
}
