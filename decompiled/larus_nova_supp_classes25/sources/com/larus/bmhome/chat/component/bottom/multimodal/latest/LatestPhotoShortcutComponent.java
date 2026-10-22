package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.g1;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.input.impl.databinding.LarusLayoutLatestPhotoShortcutViewBinding;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.SafeExtKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00012\b\u0016\u0018\u0000 N2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002NOB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000205H\u0016J\b\u00109\u001a\u000205H\u0016J\b\u0010:\u001a\u000205H\u0016J\u0010\u0010;\u001a\u0002052\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u000205H\u0002J \u0010?\u001a\u000205*\u00020,2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u0002050AH\u0002J\b\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u000205H\u0002J\b\u0010E\u001a\u000205H\u0002J\u0016\u0010F\u001a\u000205*\u00020.2\b\b\u0002\u0010G\u001a\u00020CH\u0002J\u001c\u0010H\u001a\u000205*\u00020.2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020CH\u0002J\u0018\u0010L\u001a\u0002052\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020CH\u0003J\u0018\u0010M\u001a\u0002052\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020CH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b(\u0010)R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006P"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ILatestPhotoShortcutAbility;", "<init>", "()V", "viewModel", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutViewModel;", "getViewModel", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "trace", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutTrace;", "getTrace", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutTrace;", "trace$delegate", "Lkotlin/Lazy;", "multimodalAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "shortcutShowGate", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutShowGate;", "getShortcutShowGate", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutShowGate;", "shortcutShowGate$delegate", "messageProcessor", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutMsgProcessor;", "getMessageProcessor", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutMsgProcessor;", "messageProcessor$delegate", "stub", "Landroid/view/ViewStub;", "shortcutViewBinding", "Lcom/larus/input/impl/databinding/LarusLayoutLatestPhotoShortcutViewBinding;", "lastShowTime", "", "onConversationChanged", "com/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutComponent$onConversationChanged$1", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutComponent$onConversationChanged$1;", "onViewCreated", "", "view", "Landroid/view/View;", "onAttach", "onResume", "onStop", "dismiss", "from", "", "triggerShow", "inflateStub", "onNext", "Lkotlin/Function1;", "latestPhotoShortcutEnabled", "", "recordDisplayDuration", "observeLatestPhotoViewState", "removeShortcutView", "skipAnimation", "showShortcutView", "uri", "Landroid/net/Uri;", "skipAttachment", "inflateAndShowShortcutView", "send", "Companion", "ActionOnGesture", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public class LatestPhotoShortcutComponent extends BaseContentWidget implements com.larus.bmhome.chat.component.bottom.multimodal.latest.a {
    public static final /* synthetic */ int x = 0;
    public final com.larus.ui.arch.vm.internal.l m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public ViewStub t;
    public LarusLayoutLatestPhotoShortcutViewBinding u;
    public long v;
    public final c w;

    public final class a implements LatestPhotoShortcutGestureLayout.a {
        public final Uri a;
        public final boolean b;
        public final /* synthetic */ LatestPhotoShortcutComponent c;

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutGestureLayout.a
        public final void a() {
            FLogger.a.i("LatestPhotoShortcutComponent", "[onRightSwipe]");
            LatestPhotoShortcutComponent r0 = this.c;
            int r1 = LatestPhotoShortcutComponent.x;
            r0.Y2().handleEvent(LatestPhotoShortcutEvent.b.a);
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutGestureLayout.a
        public final void b() {
            FLogger.a.i("LatestPhotoShortcutComponent", "[onTouchDown]");
            LatestPhotoShortcutComponent r0 = this.c;
            int r1 = LatestPhotoShortcutComponent.x;
            r0.Y2().handleEvent(LatestPhotoShortcutEvent.c.a);
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutGestureLayout.a
        public final void c() {
            FLogger.a.i("LatestPhotoShortcutComponent", "[onWindowFocusLost]");
            this.c.g0("LatestPhotoShortcutComponent#onWindowFocusLost");
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutGestureLayout.a
        public final void d() {
            FLogger.a.i("LatestPhotoShortcutComponent", "[onTouchUp]");
            LatestPhotoShortcutComponent r0 = this.c;
            int r1 = LatestPhotoShortcutComponent.x;
            r0.Y2().handleEvent(LatestPhotoShortcutEvent.d.a);
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutGestureLayout.a
        public final void onClick() {
            FLogger.a.i("LatestPhotoShortcutComponent", "[onClick]");
            LatestPhotoShortcutComponent r1 = this.c;
            int r3 = LatestPhotoShortcutComponent.x;
            r1.Y2().handleEvent(LatestPhotoShortcutEvent.b.a);
            g0 r2 = (g0) this.c.n.getValue();
            int r4 = g0.e;
            TrackParams r5 = new TrackParams().merge(r2.a());
            by7.a r6 = new by7.a("new_picture_guide_click");
            r6.a.merge(r5);
            r6.b();
            LatestPhotoShortcutComponent r7 = this.c;
            Uri r8 = this.a;
            boolean r9 = this.b;
            com.larus.bmhome.chat.component.cvs.y r10 = (com.larus.bmhome.chat.component.cvs.y) r7.q.getValue();
            if (r10 == null) goto L5;
            BotModel r11 = r10.j0();
        L6:
            if (r11 == null) goto L8;
            List r12 = r11.getBotConf();
        L10:
            if (r12 == null) goto L26;
            Iterator r13 = r12.iterator();
        L13:
            if (r13.hasNext() == false) goto L22;
            Object r14 = r13.next();
            BotConfItem r15 = (BotConfItem) r14;
            if (Intrinsics.areEqual(r15.getConfGroupKey(), "disable_function") == true) goto L17;
        L19:
            boolean r16 = false;
        L20:
            if (r16 == false) goto L13;
        L23:
            BotConfItem r17 = (BotConfItem) r14;
            if (r17 == null) goto L26;
            String r18 = r17.getConfValue();
        L27:
            boolean r19 = Intrinsics.areEqual(r18, "1");
            FLogger.a.i("LatestPhotoShortcutComponent", "[send] skipAttachment:" + r9 + ", attachmentPanelDisabledByBotConf:" + r19);
            LruCache r20 = ko8.a.a;
            com.larus.bmhome.chat.component.cvs.y r21 = (com.larus.bmhome.chat.component.cvs.y) r7.q.getValue();
            if (r21 == null) goto L30;
            String r22 = r21.Y1();
        L31:
            ko8.a.k(r22, "new_picture_guide_click");
            if (r9 == true) goto L36;
            if (r19 == true) goto L36;
            boolean r23 = false;
        L37:
            ICoreInputAbility r24 = (ICoreInputAbility) r7.p.getValue();
            if (r24 != null) goto L40;
        L42:
            boolean r25 = false;
        L43:
            boolean r26 = !r25;
            com.larus.bmhome.chat.component.bottom.multimodal.g r27 = (com.larus.bmhome.chat.component.bottom.multimodal.g) r7.o.getValue();
            if (r27 == null) goto L52;
            r27.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.C0050a(r8, null, 2)), new g1(!r23, MultimodalBizScene.ChatLatestPhoto, r26), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("upload_file_click_from", "new_picture_guide_click"), TuplesKt.to("enter_method_trace", "new_picture_guide_click"), TuplesKt.to("scene", "album")}), null, 20));
            return;
        L52:
            return;
        L40:
            if (r24.gj() != true) goto L42;
            r25 = true;
        L36:
            r23 = true;
            goto L37
        L30:
            r22 = null;
            goto L31
        L17:
            if (Intrinsics.areEqual(r15.getConfKey(), "disable_attachment_area") == false) goto L19;
            r16 = true;
            goto L20
        L22:
            r14 = null;
        L26:
            r18 = null;
            goto L27
        L8:
            r12 = null;
            goto L10
        L5:
            r11 = null;
            goto L6
        }

        public a(LatestPhotoShortcutComponent r2, Uri r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "uri");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public static final class b {
    }

    public static final class c implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
        public final /* synthetic */ LatestPhotoShortcutComponent a;

        public c(LatestPhotoShortcutComponent r1) {
            this.a = r1;
        }

        public final void c(Object r3) {
            Intrinsics.checkNotNullParameter((wc9.e) r3, "new");
            LatestPhotoShortcutComponent r4 = this.a;
            int r0 = LatestPhotoShortcutComponent.x;
            if (r4.h3() == false) goto L5;
            FLogger.a.i("LatestPhotoShortcutComponent", "[onConversationChanged] latest photo shortcut enabled");
            this.a.Y2().handleEvent(new LatestPhotoShortcutEvent.a(this.a.getContext()));
            return;
        L5:
            FLogger.a.i("LatestPhotoShortcutComponent", "[onConversationChanged] latest photo shortcut disabled");
        }
    }

    public static final class d implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public d(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class e implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public e(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class f implements Function0<ViewModelProvider.Factory> {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutComponent$onResume$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(Object r8) {
            super(0, r8, LatestPhotoShortcutComponent.class, "triggerShow", "triggerShow()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m70invoke() {
            LatestPhotoShortcutComponent r0 = (LatestPhotoShortcutComponent) ((CallableReference) this).receiver;
            int r1 = LatestPhotoShortcutComponent.x;
            if (r0.h3() == false) goto L7;
            FLogger.a.i("LatestPhotoShortcutComponent", "[onResume] latest photo shortcut enabled");
            r0.Y2().handleEvent(new LatestPhotoShortcutEvent.a(r0.getContext()));
            com.larus.bmhome.chat.component.cvs.y r2 = (com.larus.bmhome.chat.component.cvs.y) r0.q.getValue();
            if (r2 == null) goto L9;
            r2.lQ(r0.w);
            return;
        L9:
            return;
        L7:
            FLogger.a.i("LatestPhotoShortcutComponent", "[onResume] latest photo shortcut disabled");
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m70invoke();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final LatestPhotoShortcutViewModel Y2() {
        return (LatestPhotoShortcutViewModel) this.m.getValue();
    }

    public final void onResume() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        AnonymousClass1 r2 = new AnonymousClass1(this);
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "dispatcher");
        View r0 = r1.getView();
        if (r0 == null) goto L6;
        SafeExtKt.a(r0, r2, 300, r3);
        return;
    }

    public final void onStop() {
        FLogger.a.i("LatestPhotoShortcutComponent", "[onStop]");
        LarusLayoutLatestPhotoShortcutViewBinding r0 = this.u;
        if (r0 == null) goto L6;
        m3(r0, true);
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.bmhome.chat.component.bottom.multimodal.latest.a.class);
    }

    public LatestPhotoShortcutComponent() {
        this.m = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(LatestPhotoShortcutViewModel.class), Reflection.getOrCreateKotlinClass(LatestPhotoShortcutViewState.class), new d(this), new e(this), f.a);
        this.n = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.multimodal.latest.d(this));
        this.o = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.multimodal.latest.e(this));
        this.p = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.multimodal.latest.f(this));
        this.q = LazyKt.lazy(new g(this));
        this.r = LazyKt.lazy(new h(this));
        this.s = LazyKt.lazy(new i(this));
        this.v = -1;
        this.w = new c(this);
    }

    public final boolean h3() {
        Context r0 = getContext();
        Intrinsics.checkNotNullParameter(r0, "context");
        if (Build.VERSION.SDK_INT < 33) goto L8;
        if (ContextCompat.checkSelfPermission(r0, "android.permission.READ_MEDIA_IMAGES") == 0) goto L9;
    L10:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L15;
        FLogger.a.i("LatestPhotoShortcutComponent", "[latestPhotoShortcutEnabled] disabled, permission denied");
        return false;
    L15:
        ICoreInputAbility r2 = (ICoreInputAbility) this.p.getValue();
        if (r2 != null) goto L18;
    L20:
        boolean r3 = false;
    L21:
        if (r3 == true) goto L24;
        FLogger.a.i("LatestPhotoShortcutComponent", "[latestPhotoShortcutEnabled] disabled, sendImageEnabled:false");
        return false;
    L24:
        com.larus.bmhome.chat.component.cvs.y r4 = (com.larus.bmhome.chat.component.cvs.y) this.q.getValue();
        if (r4 == null) goto L37;
        wc9.e r5 = r4.h();
        if (r5 == null) goto L37;
        Intrinsics.checkNotNullParameter(r5, "conversation");
        boolean r6 = com.larus.bmhome.utils.i.f(r5);
        com.larus.platform.model.chat.z r7 = z2.a.latestPhotoShortcutConfig();
        if (r6 == false) goto L32;
        boolean r8 = r7.a;
    L33:
        if (r8 == true) goto L36;
        FLogger.a.i("LatestPhotoShortcutComponent", "[latestPhotoShortcutEnabled] disabled, enabledByBotType:false");
        return false;
    L36:
        return true;
    L32:
        r8 = r7.b;
    L37:
        FLogger.a.e("LatestPhotoShortcutComponent", "[latestPhotoShortcutEnabled] disabled, conversation is null");
        com.larus.bmhome.chat.component.cvs.y r9 = (com.larus.bmhome.chat.component.cvs.y) this.q.getValue();
        if (r9 == null) goto L40;
        r9.rh(new com.larus.bmhome.chat.component.bottom.multimodal.latest.b(), this.w);
    L40:
        return false;
    L18:
        if (r2.Qd(false) != true) goto L20;
        r3 = true;
    L9:
        r1 = true;
        goto L12
    L8:
        if (ContextCompat.checkSelfPermission(r0, "android.permission.READ_EXTERNAL_STORAGE") != 0) goto L10;
        goto L9
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.latest.a
    public final void g0(String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        FLogger.a.i("LatestPhotoShortcutComponent", "[dismiss] from:" + r4);
        Y2().handleEvent(LatestPhotoShortcutEvent.b.a);
    }

    public final void onViewCreated(View r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        if ((r7 instanceof ViewStub) == false) goto L5;
        this.t = (ViewStub) r7;
        ComponentViewModel.onEach$default(Y2(), null, null, new LatestPhotoShortcutComponent$observeLatestPhotoViewState$1(this, null), 3, null);
        return;
    L5:
        FLogger.a.e("LatestPhotoShortcutComponent", "[onViewCreated] view is expected to be a ViewStub");
    }

    public static void m3(final LarusLayoutLatestPhotoShortcutViewBinding r2, boolean r3) {
        if (r3 == false) goto L4;
        e1.o(r2.a);
        return;
    L4:
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r2.a, View.ALPHA, new float[]{1.0f, 0.0f});
        r4.setDuration(200);
        r4.setInterpolator(new DecelerateInterpolator());
        Intrinsics.checkNotNull(r4);
        d2a.g.c(r4, new j(r2));
        r4.start();
    }
}
