package com.bytedance.android.livesdk.chatroom.widget.landscape;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0004%&'(B\u0011\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b#\u0010$J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR*\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeClearStatusViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "", "introCardAutoDismiss", "startAutoDismissCountDown", "Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeClearStatusViewModel$c;", "getCurStatus", "Lcom/bytedance/android/live/core/utils/StateMachine;", "Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeClearStatusViewModel$a;", "Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeClearStatusViewModel$b;", "createStateMachine", "Lcom/bytedance/android/livesdk/chatroom/widget/landscape/w;", "toolbarView", "initToolbar", "introCard", "initIntroCard", "requestCardShow", "t", "onChanged", "onCleared", "Lio/reactivex/disposables/Disposable;", "autoDismissObservable", "Lio/reactivex/disposables/Disposable;", "toolbarDelegate", "Lcom/bytedance/android/livesdk/chatroom/widget/landscape/w;", "introCardDelegate", "stateMachine", "Lcom/bytedance/android/live/core/utils/StateMachine;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "a", "b", "c", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeClearStatusViewModel extends ViewModel implements Observer<KVData> {
    public static final Companion Companion = null;
    private static final String TAG = null;
    private Disposable autoDismissObservable;
    private final DataCenter dataCenter;
    private w introCardDelegate;
    private StateMachine<c, a, b> stateMachine;
    private w toolbarDelegate;

    public static final class Companion {
        public Companion() {
        }

        public static LandscapeClearStatusViewModel a(final DataCenter r6) {
            ViewModel r0 = null;
            if (r6 != null) goto L6;
            return null;
        L6:
            if (com.bytedance.android.livesdk.config.setting.f.a(r6) == false) goto L19;
            RoomContext.a r1 = RoomContext.Companion;
            RoomContext r5 = RoomContext.a.c(r1, r6, 0, 2);
            if (r5 == null) goto L12;
            com.bytedance.live.datacontext.j r7 = r5.getLandscapeClearStatusVM();
            if (r7 == null) goto L12;
            ViewModel r8 = (ViewModel) r7.getValue();
        L13:
            if (r8 != null) goto L19;
            RoomContext r2 = RoomContext.a.c(r1, r6, 0, 2);
            if (r2 == null) goto L19;
            com.bytedance.live.datacontext.j r3 = r2.getLandscapeClearStatusVM();
            if (r3 == null) goto L19;
            r3.e(new LandscapeClearStatusViewModel$Companion$getInstance$1(r6));
        L12:
            r8 = null;
        L19:
            RoomContext r9 = RoomContext.a.c(RoomContext.Companion, r6, 0, 2);
            if (r9 == null) goto L24;
            com.bytedance.live.datacontext.j r10 = r9.getLandscapeClearStatusVM();
            if (r10 == null) goto L24;
            ViewModel r11 = (ViewModel) r10.getValue();
        L26:
            if ((r11 instanceof LandscapeClearStatusViewModel) == false) goto L30;
            r0 = r11;
        L30:
            return (LandscapeClearStatusViewModel) r0;
        L24:
            r11 = null;
            goto L26
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.widget.landscape.LandscapeClearStatusViewModel$a$a, reason: collision with other inner class name */
        public static final class C0092a extends a {
            public C0092a() {
            }
        }

        public static final class b extends a {
            public b() {
            }
        }

        public static final class c extends a {
            public c() {
            }
        }

        public static final class d extends a {
            public d() {
            }
        }

        public a() {
        }
    }

    public static abstract class b {
        public final String a;

        public static final class a extends b {
            public a() {
                super("ClearInteraction");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.widget.landscape.LandscapeClearStatusViewModel$b$b, reason: collision with other inner class name */
        public static final class C0093b extends b {
            public C0093b() {
                super("ShowInteraction");
            }
        }

        public static final class c extends b {
            public c() {
                super("StartPartShow");
            }
        }

        public b(String r1) {
            this.a = r1;
        }
    }

    public static abstract class c {

        public static final class a extends c {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.widget.landscape.LandscapeClearStatusViewModel$c$c, reason: collision with other inner class name */
        public static final class C0094c extends c {
            public static final C0094c a = null;

            static {
                a = new C0094c();
            }

            public C0094c() {
            }
        }

        public c() {
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LandscapeClearStatusViewModel a;

        public d(LandscapeClearStatusViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            LandscapeClearStatusViewModel.access$introCardAutoDismiss(this.a);
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L7;
            if (r3 == null) goto L6;
            throw r3;
        L6:
            throw new Throwable();
        L7:
            LandscapeClearStatusViewModel.Companion.getClass();
            ALogger.e(LandscapeClearStatusViewModel.access$getTAG$cp(), String.valueOf(r3));
        }
    }

    static {
        Companion = new Companion();
        TAG = "LandscapeClearStatus";
    }

    private final c getCurStatus() {
        DataCenter r0 = this.dataCenter;
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.get("data_is_hiding_landscape_buttons", Boolean.FALSE);
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L8:
        if (r2 == false) goto L11;
        return c.a.a;
    L11:
        return c.C0094c.a;
    L7:
        r2 = false;
        goto L8
    }

    private final void introCardAutoDismiss() {
        StateMachine<c, a, b> r0 = this.stateMachine;
        if (r0 == null) goto L6;
        a.b r1 = new a.b();
        StateMachine.a r2 = StateMachine.c;
        r0.d(r1, null);
        return;
    }

    private final void startAutoDismissCountDown() {
        Disposable r0 = this.autoDismissObservable;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.dispose();
    L6:
        this.autoDismissObservable = Observable.timer(30, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), e.a);
    }

    public final StateMachine<c, a, b> createStateMachine() {
        StateMachine.a r0 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r1 = new AnonymousClass1(this);
        r0.getClass();
        return StateMachine.a.a(r1);
    }

    public void onCleared() {
        Disposable r0 = this.autoDismissObservable;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void requestCardShow() {
        StateMachine<c, a, b> r0 = this.stateMachine;
        if (r0 == null) goto L6;
        a.C0092a r1 = new a.C0092a();
        StateMachine.a r2 = StateMachine.c;
        r0.d(r1, null);
        return;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public LandscapeClearStatusViewModel(DataCenter r1) {
        this.dataCenter = r1;
    }

    public static final /* synthetic */ Disposable access$getAutoDismissObservable$p(LandscapeClearStatusViewModel r0) {
        return r0.autoDismissObservable;
    }

    public static final /* synthetic */ c access$getCurStatus(LandscapeClearStatusViewModel r0) {
        return r0.getCurStatus();
    }

    public static final /* synthetic */ w access$getIntroCardDelegate$p(LandscapeClearStatusViewModel r0) {
        return r0.introCardDelegate;
    }

    public static final /* synthetic */ w access$getToolbarDelegate$p(LandscapeClearStatusViewModel r0) {
        return r0.toolbarDelegate;
    }

    public static final /* synthetic */ void access$introCardAutoDismiss(LandscapeClearStatusViewModel r0) {
        r0.introCardAutoDismiss();
    }

    public static final /* synthetic */ void access$startAutoDismissCountDown(LandscapeClearStatusViewModel r0) {
        r0.startAutoDismissCountDown();
    }

    public final void initIntroCard(w r2) {
        Intrinsics.checkNotNullParameter(r2, "introCard");
        this.introCardDelegate = r2;
    }

    public final void initToolbar(w r3) {
        Intrinsics.checkNotNullParameter(r3, "toolbarView");
        this.stateMachine = createStateMachine();
        this.toolbarDelegate = r3;
        DataCenter r4 = this.dataCenter;
        if (r4 == null) goto L6;
        r4.observe("data_is_hiding_landscape_buttons", this, false);
        return;
    }

    public void onChanged(KVData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        String r0 = r5.getKey();
        if (r0.hashCode() == 1883240861) goto L8;
        return;
    L8:
        if (r0.equals("data_is_hiding_landscape_buttons") == false) goto L23;
        Object r6 = r5.getData();
        if ((r6 instanceof Boolean) == true) goto L12;
        r6 = null;
    L12:
        Boolean r7 = (Boolean) r6;
        if (r7 == null) goto L15;
        boolean r8 = r7.booleanValue();
    L16:
        ALogger.i(TAG, "isHide " + r8);
        StateMachine<c, a, b> r1 = this.stateMachine;
        if (r1 == null) goto L24;
        if (r8 == false) goto L20;
        Object r9 = new a.c();
    L21:
        StateMachine.a r2 = StateMachine.c;
        r1.d(r9, null);
        return;
    L20:
        r9 = new a.d();
        goto L21
    L24:
        return;
    L15:
        r8 = false;
        goto L16
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }

    public static final /* synthetic */ void access$setAutoDismissObservable$p(LandscapeClearStatusViewModel r0, Disposable r1) {
        r0.autoDismissObservable = r1;
    }

    public static final /* synthetic */ void access$setIntroCardDelegate$p(LandscapeClearStatusViewModel r0, w r1) {
        r0.introCardDelegate = r1;
    }

    public static final /* synthetic */ void access$setToolbarDelegate$p(LandscapeClearStatusViewModel r0, w r1) {
        r0.toolbarDelegate = r1;
    }
}
