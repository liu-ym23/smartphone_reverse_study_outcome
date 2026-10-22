package com.bytedance.android.livesdk.interactivity.imagerecognition;

import android.content.Context;
import android.os.SystemClock;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.d8;
import com.bytedance.android.livesdk.config.f81;
import com.bytedance.android.livesdk.config.setting.l;
import com.bytedance.android.livesdk.config.y00;
import com.bytedance.android.livesdk.config.z81;
import com.bytedance.android.livesdk.interactivity.imagerecognition.util.ImageRecognitionUtil;
import com.bytedance.android.livesdk.utils.guide.LongPressGuideScene;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.StreamRecognitionCandidate;
import com.bytedance.android.livesdkapi.depend.model.live.StreamRecognitionContainers;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s32.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/imagerecognition/ImageRecognitionServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageRecognitionServiceWidget extends RoomRecyclableWidget {
    public ImageRecognitionTask a;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((StreamRecognitionCandidate) r2).priority), Integer.valueOf(((StreamRecognitionCandidate) r1).priority));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ImageRecognitionServiceWidget a;

        public b(ImageRecognitionServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r15) {
            com.bytedance.android.livesdk.interactivity.imagerecognition.a r16 = (com.bytedance.android.livesdk.interactivity.imagerecognition.a) r15;
            ImageRecognitionServiceWidget r0 = this.a;
            ImageRecognitionTask r1 = r0.a;
            if (r1 != null) goto L5;
        L7:
            int r2 = s32.b.a;
            DataCenter r3 = ((Widget) r0).dataCenter;
            ImageRecognitionEntry r4 = r16.b;
            Intrinsics.checkNotNullParameter(r4, "entry");
            if (r3 == null) goto L20;
            int r5 = s32.a.a[r4.ordinal()];
            if (r5 != 1) goto L13;
            ImageRecognitionButton r6 = s32.b.c(r3);
        L18:
            if (r6 == null) goto L20;
            boolean r7 = true;
        L21:
            if (r7 == false) goto L61;
            Map<Integer, ImageRecognitionBusiness> r8 = s32.c.a;
            int r9 = r16.a;
            ImageRecognitionBusiness r10 = (ImageRecognitionBusiness) ((HashMap) s32.c.a).get(Integer.valueOf(r9));
            if (r10 != null) goto L26;
            int r11 = f.a;
            f.a("no business for scene " + r16.a);
            return;
        L26:
            d8 r13 = (d8) y00.a.getValue();
            int r14 = r16.a;
            ImageRecognitionEntry r17 = r16.b;
            String r18 = r16.c;
            Context r19 = ((Widget) r0).context;
            Widget.WidgetCallback r110 = ((Widget) r0).widgetCallback;
            ImageRecognitionDialogFragment r20 = null;
            if (r110 == null) goto L31;
            WidgetManager r111 = r110.getWidgetManager();
            if (r111 == null) goto L31;
            FragmentManager r112 = r111.getParentFragmentManager();
        L32:
            final ImageRecognitionTask r21 = new ImageRecognitionTask(r13, r14, r17, r18, r10, r19, r112, new com.bytedance.android.livesdk.interactivity.imagerecognition.b(r0));
            String r113 = a0.p(((Widget) r0).dataCenter);
            if (r21.a != 0) goto L52;
            r21.a = 1;
            if (r21.c != null) goto L51;
            int r23 = ImageRecognitionDialogFragment.j;
            ImageRecognitionEntry r24 = r21.k;
            FragmentManager r25 = r21.o;
            Function0<Unit> r26 = new ImageRecognitionTask$openRecognitionDialog$1(r21);
            Intrinsics.checkNotNullParameter(r24, "entry");
            Intrinsics.checkNotNullParameter(r26, "onCancel");
            if (r25 != null) goto L57;
        L50:
            r21.c = r20;
            r21.d = SystemClock.elapsedRealtime() + r21.i.d();
            goto L51
        L57:
        L48:
            e = move-exception;
            SafetyGuard.a("open ImageRecognitionDialogFragment failed", e, null);
            goto L50
        L39:
            if (r25.isDestroyed() == true) goto L50;
            if (r25.isStateSaved() == true) goto L50;
            ImageRecognitionDialogFragment r27 = new ImageRecognitionDialogFragment(r24, r113, r26);     // Catch: Exception -> L48
            LandscapeRestrictionOperation r28 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L48
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r27, "ImageRecognitionDialogFragment", r28);     // Catch: Exception -> L48
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r25, r27, r28) == false) goto L55;
        L47:
            r20 = r27;
            goto L50
        L55:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L54
        L46:
            r27.show(r25, "ImageRecognitionDialogFragment");     // Catch: Exception -> L48
        L51:
            r21.b = System.currentTimeMillis();
            final ImageRecognitionTask$startRecognition$1 r114 = new ImageRecognitionTask$startRecognition$1(r21);
            int r29 = ImageRecognitionUtil.a;
            ImageRecognitionUtil.d(new ImageRecognitionTask$startRecognition$2(r114));
        L52:
            Unit r115 = Unit.INSTANCE;
            r0.a = r21;
            return;
        L31:
            r112 = null;
            goto L32
        L61:
            return;
        L13:
            if (r5 != 2) goto L16;
            r6 = s32.b.b(r3);
            goto L18
        L16:
            throw new NoWhenBranchMatchedException();
        L20:
            r7 = false;
            goto L21
        L5:
            if (r1.d() != true) goto L7;
            f.a("recognizing");
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ImageRecognitionServiceWidget a;

        public c(ImageRecognitionServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            IUserService r6 = k.f(IUserService.class);
            boolean r0 = true;
            if (r6 == null) goto L9;
            com.bytedance.android.livesdk.user.f r7 = r6.user();
            if (r7 == null) goto L9;
            if (r7.isLogin() != true) goto L9;
            boolean r8 = true;
        L11:
            if (((Widget) this.a).dataCenter != null) goto L13;
        L23:
            f.a("cannot show long press guide");
            return;
        L13:
            if (l.c() == true) goto L19;
            if (r8 == false) goto L16;
        L18:
            r0 = false;
            goto L19
        L16:
            if (((z81) f81.a.getValue()).a() == false) goto L18;
        L19:
            if (r0 == true) goto L23;
            int r9 = s32.b.a;
            if (s32.b.c(((Widget) this.a).dataCenter) == null) goto L23;
            bu2.a r10 = new bu2.a(LongPressGuideScene.STREAM_RECOGNITION, s1.B(2131917400));
            r10.a = ImageRecognitionServiceWidget$onLoad$3$1.INSTANCE;
            xs2.b.a().post(r10);
            f.b("send ShowLongPressGuideEvent");
            return;
        L9:
            r8 = false;
            goto L11
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        Map<Integer, ImageRecognitionBusiness> r0 = s32.c.a;
        ((HashMap) s32.c.a).clear();
        ImageRecognitionTask r1 = this.a;
        if (r1 == null) goto L5;
        r1.b();
    L5:
        this.a = null;
    }

    public ImageRecognitionServiceWidget() {
    }

    public final void onLoad(Object[] r8) {
        Integer r3 = null;
        RoomContext r9 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r9 == null) goto L20;
        m r10 = r9.getRoom();
        if (r10 == null) goto L20;
        Room r11 = (Room) r10.getValue();
        if (r11 == null) goto L20;
        RoomOthersData r13 = r11.others;
        if (r13 == null) goto L20;
        StreamRecognitionContainers r14 = r13.getRecognitionContainers();
        if (r14 == null) goto L20;
        List r0 = r14.recognitionCandidates;
        if (r0 == null) goto L15;
        List r1 = CollectionsKt.sortedWith(r0, new a());
    L16:
        r14.recognitionCandidates = r1;
        int r15 = f.a;
        StringBuilder r16 = new StringBuilder("recognitionCandidate num is ");
        if (r1 == null) goto L19;
        r3 = Integer.valueOf(r1.size());
    L19:
        r16.append(r3);
        f.b(r16.toString());
        goto L20
    L15:
        r1 = null;
    L20:
        s32.c.a(1, new d82.a());
        if (PluginType.Search.isInstalled() == false) goto L26;
        IHostAction r17 = k.f(IHostAction.class);
        if (r17 == null) goto L25;
        r17.registerLynxPhotoSearchResult();
    L25:
        s32.c.a(2, new e82.b());
    L27:
        ((ObservableSubscribeProxy) xs2.b.a().b(com.bytedance.android.livesdk.interactivity.imagerecognition.a.class).as(autoDispose())).subscribe(new b(this));
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.Z.getValue()).booleanValue() == true) goto L49;
        RoomContext r18 = getDataContext();
        if (r18 == null) goto L36;
        n r19 = r18.getExternalConfigJudger();
        if (r19 == null) goto L36;
        IExternalConfigJudger r2 = (IExternalConfigJudger) r19.getValue();
        if (r2 == null) goto L36;
        boolean r20 = IExternalConfigJudger.DefaultImpls.canUse$default(r2, EXTERNAL_CONFIG_TYPE.Gesture, "longPress", false, 4, null);
    L37:
        if (r20 != true) goto L50;
        RoomContext r21 = getDataContext();
        if (r21 == null) goto L45;
        n r23 = r21.getExternalConfigJudger();
        if (r23 == null) goto L45;
        IExternalConfigJudger r4 = (IExternalConfigJudger) r23.getValue();
        if (r4 == null) goto L45;
        boolean r24 = IExternalConfigJudger.DefaultImpls.canUse$default(r4, EXTERNAL_CONFIG_TYPE.Guide, "longPressGuide", false, 4, null);
    L46:
        if (r24 != true) goto L51;
        f.b("show long press guide in 10 seconds");
        ((ObservableSubscribeProxy) Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new c(this));
        return;
    L51:
        return;
    L45:
        r24 = true;
        goto L46
    L50:
        return;
    L36:
        r20 = true;
        goto L37
    L49:
        return;
    L26:
        f.a("search plugin has not installed yet");
        goto L27
    }
}
