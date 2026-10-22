package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livehostapi.business.depend.dislike.RecommendToFriendsParams;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendReasonInputDialogFragment;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/LongPressPanelPromptWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongPressPanelPromptWidget extends MiddlewareRoomWidget {
    public static final /* synthetic */ int b = 0;
    public final CompositeDisposable a;

    public static final class a {
    }

    public final class b implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.LongPressPanelPromptWidget$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lmt1/b;", "p1", "", "invoke", "(Lmt1/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<mt1.b, Unit> {
        public AnonymousClass1(LongPressPanelPromptWidget r8) {
            super(1, r8, LongPressPanelPromptWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/dislike/event/ShowPromptDialogEvent;)V", 0);
        }

        public final void invoke(mt1.b r18) {
            LongPressPanelPromptWidget r2 = (LongPressPanelPromptWidget) ((CallableReference) this).receiver;
            int r3 = LongPressPanelPromptWidget.b;
            DataCenter r4 = ((Widget) r2).dataCenter;
            if (r4 == null) goto L65;
            Room r5 = com.bytedance.android.live.core.utils.z.o(r4);
            if (r5 == null) goto L69;
            if (r18 != null) goto L9;
            return;
        L9:
            if (r18.b != r5.getRoomId()) goto L70;
            com.bytedance.android.livesdk.log.filter.n0 r6 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
            if (r6 != null) goto L14;
        L31:
            String r7 = "";
            String r10 = r7;
            String r11 = r10;
        L32:
            com.bytedance.android.livesdk.log.filter.o r8 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
            if (r8 == null) goto L40;
            Map r9 = r8.getMap();
            if (r9 == null) goto L40;
            String r12 = (String) r9.get("request_id");
            if (r12 == null) goto L40;
            String r13 = r12;
        L41:
            com.bytedance.android.livesdk.chatroom.ui.framework.c r14 = ho1.a.d(r2.getComponentContext());
            Boolean r15 = null;
            if (r14 == null) goto L44;
            FragmentManager r16 = r14.ea();
        L45:
            if (r16 != null) goto L47;
            return;
        L47:
            if (r5.getOwner() == null) goto L68;
            User r17 = r5.getOwner();
            if (r17 == null) goto L51;
            String r19 = r17.getIdStr();
        L52:
            long r20 = r5.getRoomId();
            User r110 = r5.getOwner();
            if (r110 == null) goto L56;
            r15 = Boolean.valueOf(r110.isFollowing());
        L56:
            if (r15.booleanValue() == false) goto L58;
            String r21 = "1";
        L59:
            String r111 = r21;
            LiveMode r112 = r5.getStreamType();
            if (r18.a == false) goto L62;
            String r22 = "more_function";
        L63:
            RecommendToFriendsParams r113 = new RecommendToFriendsParams(r19, r20, r10, r11, r111, r13, r112, false, r22);
            r113.setActionType(r7);
            r113.setFromMorePanel(r18.a);
            int r23 = RecommendLiveHelper.a;
            RecommendLiveHelper.m(r16, r113, ((Widget) r2).dataCenter, r18.c);
            return;
        L62:
            r22 = r18.c;
            goto L63
        L58:
            r21 = "0";
            goto L59
        L51:
            r19 = null;
            goto L52
        L68:
            return;
        L44:
            r16 = null;
        L40:
            r13 = "";
            goto L41
        L14:
            if ((r6 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L31;
            com.bytedance.android.livesdk.log.filter.n0 r24 = r6;
            if (((com.bytedance.android.livesdk.log.filter.a) r24).b.containsKey("enter_from_merge") == false) goto L19;
            String r25 = (String) ((com.bytedance.android.livesdk.log.filter.a) r24).b.get("enter_from_merge");
            if (r25 == null) goto L19;
        L21:
            if (((com.bytedance.android.livesdk.log.filter.a) r24).b.containsKey("enter_method") == false) goto L24;
            String r26 = (String) ((com.bytedance.android.livesdk.log.filter.a) r24).b.get("enter_method");
            if (r26 == null) goto L24;
        L26:
            if (((com.bytedance.android.livesdk.log.filter.a) r24).b.containsKey("action_type") == false) goto L29;
            r7 = (String) ((com.bytedance.android.livesdk.log.filter.a) r24).b.get("action_type");
            if (r7 == null) goto L29;
        L30:
            r10 = r25;
            r11 = r26;
        L29:
            r7 = "";
        L24:
            r26 = "";
        L19:
            r25 = "";
            goto L21
        L70:
            return;
        L69:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((mt1.b) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.LongPressPanelPromptWidget$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lmt1/c;", "p1", "", "invoke", "(Lmt1/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<mt1.c, Unit> {
        public AnonymousClass2(LongPressPanelPromptWidget r8) {
            super(1, r8, LongPressPanelPromptWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/dislike/event/ShowRecommendReasonDialogEvent;)V", 0);
        }

        public final void invoke(final mt1.c r5) {
            final LongPressPanelPromptWidget r0 = (LongPressPanelPromptWidget) ((CallableReference) this).receiver;
            int r1 = LongPressPanelPromptWidget.b;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = ho1.a.d(r0.getComponentContext());
            if (r2 == null) goto L22;
            FragmentManager r3 = r2.ea();
            if (r3 == null) goto L23;
            int r4 = RecommendLiveHelper.a;
            DataCenter r6 = ((Widget) r0).dataCenter;
            if (r6 == null) goto L10;
            com.bytedance.android.live.core.utils.z.o(r6);
        L10:
            if (r5 == null) goto L12;
            boolean r7 = r5.a;
        L13:
            Function2<Boolean, String, Unit> r8 = new LongPressPanelPromptWidget$onEvent$1(r0, r5);
            Intrinsics.checkNotNullParameter(r3, "fragmentManager");
            Intrinsics.checkNotNullParameter(r8, "dismissAction");
            int r9 = RecommendReasonInputDialogFragment.g;
            Intrinsics.checkNotNullParameter(r8, "dismissAction");
            RecommendReasonInputDialogFragment r10 = new RecommendReasonInputDialogFragment();
            r10.d = r7;
            r10.e = r8;
            LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, "RecommendReasonInputDialogFragment", r11);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r10, r11) == true) goto L24;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
        L17:
            r10.show(r3, "RecommendReasonInputDialogFragment");
            return;
        L24:
            return;
        L12:
            r7 = false;
            goto L13
        L23:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((mt1.c) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public LongPressPanelPromptWidget() {
        this.a = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        L7(mt1.b.class, new b(new AnonymousClass1(this)));
        int r0 = RecommendLiveHelper.a;
        if (RecommendLiveHelper.e() == false) goto L6;
        L7(mt1.c.class, new b(new AnonymousClass2(this)));
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.a.clear();
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }
}
