package com.larus.community.impl.publish;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;
import tx9.e2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishFragment$publish$1", f = "CreationPublishFragment.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
public final class CreationPublishFragment$publish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $caption;
    final /* synthetic */ int $captionCount;
    final /* synthetic */ boolean $isPublic;
    final /* synthetic */ PublisherCreation $publishCreation;
    final /* synthetic */ Integer $refImageCount;
    int label;
    final /* synthetic */ CreationPublishFragment this$0;

    /* JADX INFO: renamed from: com.larus.community.impl.publish.CreationPublishFragment$publish$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/platform/api/creation/UserCreation;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishFragment$publish$1$1", f = "CreationPublishFragment.kt", i = {0, 0}, l = {194}, m = "invokeSuspend", n = {"it", "currentPublishCreation"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<UserCreation, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $caption;
        final /* synthetic */ int $captionCount;
        final /* synthetic */ boolean $isPublic;
        final /* synthetic */ PublisherCreation $publishCreation;
        final /* synthetic */ Integer $refImageCount;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ CreationPublishFragment this$0;

        public AnonymousClass1(CreationPublishFragment r1, PublisherCreation r2, String r3, boolean r4, int r5, Integer r6, Continuation<? super AnonymousClass1> r7) {
            this.this$0 = r1;
            this.$publishCreation = r2;
            this.$caption = r3;
            this.$isPublic = r4;
            this.$captionCount = r5;
            this.$refImageCount = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r8 = new AnonymousClass1(this.this$0, this.$publishCreation, this.$caption, this.$isPublic, this.$captionCount, this.$refImageCount, r11);
            r8.L$0 = r10;
            return r8;
        }

        public final Object invoke(UserCreation r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((UserCreation) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r33) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            FragmentActivity r5 = null;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            String r3 = (String) this.L$5;
            String r4 = (String) this.L$4;
            String r6 = (String) this.L$3;
            String r7 = (String) this.L$2;
            PublisherCreation r8 = (PublisherCreation) this.L$1;
            UserCreation r9 = (UserCreation) this.L$0;
            ResultKt.throwOnFailure(r33);
            Object r11 = r33;
            String r17 = r3;
            String r15 = r4;
            String r26 = r6;
            String r14 = r7;
        L42:
            String r16 = (String) r11;
            if (r8 == null) goto L47;
            Integer r10 = r8.getCreationType();
            if (r10 == null) goto L47;
            String r18 = zp9.y.b(r10.intValue());
        L48:
            boolean r12 = o0.d(this.$caption);
            boolean r13 = this.$isPublic;
            this.this$0.getClass();
            if (r8 == null) goto L51;
            String r22 = r8.getCreationId();
        L52:
            PublisherTrackParams r20 = this.this$0.g;
            if (r20 == null) goto L55;
            String r23 = r20.c();
        L56:
            PublisherTrackParams r21 = this.this$0.g;
            if (r21 == null) goto L59;
            String r24 = r21.b();
        L60:
            e2.a.b(new tx9.o0("publish_creation_page", r14, r15, r16, r17, r18, "0", "1", r24, r22, r23, null, null, r26, Boxing.boxInt(r12 ? 1 : 0), Boxing.boxInt(this.$captionCount), Boxing.boxInt(r13 ? 1 : 0), this.$refImageCount, 12289), null, 3);
            CreationPublishFragment r25 = this.this$0;
            FragmentActivity r27 = r25.getActivity();
            if (r9 == null) goto L130;
            if (r27 == null) goto L130;
            int r28 = e29.d.a;
            Intrinsics.checkNotNullParameter(r9, "userCreation");
            ICommunityHostBehaviorProvider r30 = e29.d.c();
            if (r30 == null) goto L66;
            r30.n(r9);
        L66:
            z2 r31 = z2.a;
            boolean r32 = r31.getCreationPublishConfig().a();
            boolean r34 = r31.f1().f();
            boolean r110 = m29.a.a;
            m29.a.c("CreationPublishFragment", "publish success, enablePublishDefaultLandCreationTab:" + r32 + ",showCreationTab:" + r34 + ' ');
            com.larus.community.impl.publish.viewmodel.h r111 = (com.larus.community.impl.publish.viewmodel.h) r25.V90().getPublisherCreationFlow().getValue();
            if (r111 == null) goto L69;
            PublisherCreation r112 = r111.a;
        L70:
            if (r112 == null) goto L72;
            boolean r113 = Intrinsics.areEqual(r112.getCanvasMode(), Boolean.TRUE);
        L73:
            if (r113 == false) goto L91;
            Set<zp9.r> r35 = f29.a.a;
            Long r36 = r112.getCanvasId();
            long r37 = 0;
            if (r36 == null) goto L77;
            long r38 = r36.longValue();
        L78:
            Long r40 = r112.getCanvasSubId();
            if (r40 == null) goto L81;
            r37 = r40.longValue();
        L81:
            String r41 = r112.getTaskId();
            if (r41 != null) goto L84;
            r41 = "";
        L84:
            Intrinsics.checkNotNullParameter(r9, "userCreation");
            Intrinsics.checkNotNullParameter(r41, "taskId");
            Iterator<T> r42 = f29.a.a.iterator();
        L86:
            if (r42.hasNext() == false) goto L88;
            ((zp9.r) r42.next()).i20(r9, r38, r37, r41);
            goto L86
        L88:
            com.larus.platform.service.e0.a.f();
            FragmentActivity r43 = r25.getActivity();
            if (r43 == null) goto L130;
            r43.finish();
            goto L130
        L77:
            r38 = 0;
            goto L78
        L91:
            if (r32 == false) goto L121;
            if (r34 == false) goto L121;
            Intrinsics.checkNotNullParameter(r27, "currentActivity");
            Intrinsics.checkNotNullParameter(r9, "userCreation");
            ICommunityHostBehaviorProvider r44 = e29.d.c();
            if (r44 == null) goto L96;
            r44.k(r27, r9);
            boolean r45 = true;
        L97:
            if (r45 == true) goto L122;
            Iterator r46 = CollectionsKt.asReversed(AppHost.a.a().g()).iterator();
        L100:
            if (r46.hasNext() == false) goto L113;
            Object r47 = r46.next();
            FragmentActivity r114 = (Activity) r47;
            if (r114 != r27) goto L104;
        L110:
            boolean r115 = false;
        L111:
            if (r115 == false) goto L100;
        L115:
            if ((r47 instanceof FragmentActivity) == false) goto L117;
            r5 = (FragmentActivity) r47;
        L117:
            if (r5 == null) goto L120;
            r27 = r5;
        L120:
            com.bytedance.router.i r48 = SmartRouter.buildRoute(r27, "//flow/community_create");
            r48.c.putExtra("is_side_bar", "1");
            r48.c.putExtra("clear_dialog_fragment", "1");
            r48.c.putExtra("creation", r9);
            r48.c.addFlags(67108864);
            r48.d();
            goto L122
        L104:
            if ((r114 instanceof FragmentActivity) == false) goto L110;
            FragmentActivity r116 = r114;
            if (r116.isFinishing() == true) goto L110;
            if (r116.isDestroyed() == true) goto L110;
            r115 = true;
            goto L111
        L113:
            r47 = null;
        L122:
            Set<zp9.r> r50 = f29.a.a;
            Intrinsics.checkNotNullParameter(r9, "userCreation");
            Iterator<T> r51 = f29.a.a.iterator();
        L124:
            if (r51.hasNext() == false) goto L126;
            ((zp9.r) r51.next()).bZ(r9);
            goto L124
        L126:
            com.larus.platform.service.e0.a.f();
            FragmentActivity r52 = r25.getActivity();
            if (r52 == null) goto L130;
            r52.finish();
            goto L130
        L96:
            r45 = false;
        L121:
            t19.s r53 = t19.s.a;
            Application r54 = AppHost.a.getApplication();
            r53.getClass();
            t19.s.o(r54, 2131908627, false);
            goto L122
        L72:
            r113 = false;
            goto L73
        L69:
            r112 = null;
        L130:
            return Unit.INSTANCE;
        L59:
            r24 = null;
            goto L60
        L55:
            r23 = null;
            goto L56
        L51:
            r22 = null;
        L47:
            r18 = null;
            goto L48
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r33);
            r9 = (UserCreation) this.L$0;
            if (r9 == null) goto L11;
            CreationPublishFragment r55 = this.this$0;
            int r56 = CreationPublishFragment.h;
            com.larus.community.impl.publish.viewmodel.h r57 = (com.larus.community.impl.publish.viewmodel.h) r55.V90().getPublisherCreationFlow().getValue();
            if (r57 == null) goto L15;
            r8 = r57.a;
        L16:
            PublisherTrackParams r58 = this.this$0.g;
            if (r58 == null) goto L19;
            String r60 = r58.a();
        L20:
            if (r8 == null) goto L24;
            Integer r61 = r8.getCreationType();
            if (r61 == null) goto L24;
            String r62 = zp9.y.a(r61.intValue());
        L25:
            if (r8 == null) goto L27;
            String r63 = r8.getCreationId();
        L28:
            PublisherCreation r117 = this.$publishCreation;
            if (r117 == null) goto L31;
            boolean r118 = Intrinsics.areEqual(r117.getCanvasMode(), Boxing.boxBoolean(true));
        L32:
            if (r118 == false) goto L34;
            String r119 = String.valueOf(this.$publishCreation.getCanvasSubId());
        L38:
            CreationPublishFragment r120 = this.this$0;
            this.L$0 = r9;
            this.L$1 = r8;
            this.L$2 = r60;
            this.L$3 = r62;
            this.L$4 = r63;
            this.L$5 = r119;
            this.label = 1;
            r11 = CreationPublishFragment.U90(r120, this);
            if (r11 != r1) goto L41;
            return r1;
        L41:
            r15 = r63;
            r26 = r62;
            r14 = r60;
            r17 = r119;
            goto L42
        L34:
            PublisherCreation r121 = this.$publishCreation;
            if (r121 == null) goto L37;
            r119 = r121.getMessageId();
            goto L38
        L37:
            r119 = null;
            goto L38
        L31:
            r118 = false;
            goto L32
        L27:
            r63 = null;
        L24:
            r62 = null;
            goto L25
        L19:
            r60 = null;
            goto L20
        L15:
            r8 = null;
            goto L16
        L11:
            return Unit.INSTANCE;
        }
    }

    public CreationPublishFragment$publish$1(CreationPublishFragment r1, PublisherCreation r2, String r3, boolean r4, int r5, Integer r6, Continuation<? super CreationPublishFragment$publish$1> r7) {
        this.this$0 = r1;
        this.$publishCreation = r2;
        this.$caption = r3;
        this.$isPublic = r4;
        this.$captionCount = r5;
        this.$refImageCount = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new CreationPublishFragment$publish$1(this.this$0, this.$publishCreation, this.$caption, this.$isPublic, this.$captionCount, this.$refImageCount, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CreationPublishFragment r13 = this.this$0;
        int r2 = CreationPublishFragment.h;
        i1<UserCreation> r14 = r13.V90().getSuccessUserCreationFlow();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, this.$publishCreation, this.$caption, this.$isPublic, this.$captionCount, this.$refImageCount, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r14, r3, this) != r0) goto L12;
        return r0;
    }
}
