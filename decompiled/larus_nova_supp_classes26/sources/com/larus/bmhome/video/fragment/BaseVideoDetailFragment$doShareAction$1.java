package com.larus.bmhome.video.fragment;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.save_share.VideoGenerateShareHelper;
import com.larus.common_ui.dialog.l0;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.api.t3;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.a5;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.fragment.BaseVideoDetailFragment$doShareAction$1", f = "BaseVideoDetailFragment.kt", i = {}, l = {556}, m = "invokeSuspend", n = {}, s = {})
final class BaseVideoDetailFragment$doShareAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleCoroutineScope $scope;
    final /* synthetic */ com.larus.bmhome.share.panel.h $sharePanelEventParam;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ BaseVideoDetailFragment<ViewBinding> this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.video.fragment.BaseVideoDetailFragment$doShareAction$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.video.fragment.BaseVideoDetailFragment$doShareAction$1$1", f = "BaseVideoDetailFragment.kt", i = {0, 1}, l = {503, 524}, m = "invokeSuspend", n = {"it", "callback"}, s = {"L$3", "L$6"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LifecycleCoroutineScope $scope;
        final /* synthetic */ com.larus.bmhome.share.panel.h $sharePanelEventParam;
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ BaseVideoDetailFragment<ViewBinding> this$0;

        public AnonymousClass1(BaseVideoDetailFragment<ViewBinding> r1, LifecycleCoroutineScope r2, com.larus.bmhome.share.panel.h r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$scope = r2;
            this.$sharePanelEventParam = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$scope, this.$sharePanelEventParam, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r38) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            long r3 = this.J$1;
            long r5 = this.J$0;
            int r4 = this.I$0;
            sq9.i r7 = (sq9.i) this.L$9;
            t3 r8 = (t3) this.L$8;
            FragmentManager r9 = (FragmentManager) this.L$7;
            com.larus.bmhome.share.panel.d r10 = (com.larus.bmhome.share.panel.d) this.L$6;
            String r11 = (String) this.L$5;
            ShareScene r12 = (ShareScene) this.L$4;
            String r13 = (String) this.L$3;
            String r14 = (String) this.L$2;
            com.larus.bmhome.share.panel.h r15 = (com.larus.bmhome.share.panel.h) this.L$1;
            BaseVideoDetailFragment<ViewBinding> r6 = (BaseVideoDetailFragment) this.L$0;
            ResultKt.throwOnFailure(r38);
            long r25 = r3;
            int r31 = r4;
            long r27 = r5;
            sq9.i r29 = r7;
            com.larus.bmhome.share.panel.d r22 = r10;
            String r32 = r11;
            ShareScene r24 = r12;
            String r19 = r13;
            String r18 = r14;
            com.larus.bmhome.share.panel.h r23 = r15;
            Object r16 = r38;
        L90:
            Map r30 = (Map) r16;
            nr9.g r0 = r6.e;
            if (r0 == null) goto L93;
            String r34 = r0.a;
        L94:
            r8.Z0(r9, new sq9.j(null, r18, r19, null, null, r22, r23, r24, r25, r27, r29, r30, r31, r32, null, r34, null, 81921));
        L95:
            nr9.g r17 = r6.e;
            if (r17 == null) goto L98;
            String r20 = r17.a;
        L99:
            c4 r21 = r6.f;
            String r26 = r21.b;
            String r28 = r21.a;
            String r33 = r21.c;
            String r35 = r21.g;
            if (r35 != null) goto L102;
            r35 = TriggerSendLoading.NO_LOADING;
        L102:
            String r36 = r35;
            String r110 = r21.j;
            Integer r111 = r21.i;
            String r112 = r21.h;
            JSONObject r37 = r21.m;
            if (r37 != null) goto L105;
            r37 = new JSONObject();
        L105:
            a4.k(r20, r26, r28, r33, r36, r110, r111, r112, r37);
        L109:
            return Unit.INSTANCE;
        L98:
            r20 = null;
            goto L99
        L93:
            r34 = null;
            goto L94
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            String r39 = (String) this.L$11;
            ShareScene r40 = (ShareScene) this.L$10;
            String r41 = (String) this.L$9;
            c4 r42 = (c4) this.L$8;
            View r43 = (View) this.L$7;
            nr9.g r113 = (nr9.g) this.L$6;
            l0 r114 = (l0) this.L$5;
            VideoGenerateShareHelper r115 = (VideoGenerateShareHelper) this.L$4;
            FragmentManager r116 = (FragmentManager) this.L$3;
            com.larus.bmhome.share.panel.h r117 = (com.larus.bmhome.share.panel.h) this.L$2;
            CoroutineScope r118 = (LifecycleCoroutineScope) this.L$1;
            BaseVideoDetailFragment<ViewBinding> r44 = (BaseVideoDetailFragment) this.L$0;
            ResultKt.throwOnFailure(r38);
            Object r45 = r38;
            String r210 = r39;
            ShareScene r211 = r40;
            String r212 = r41;
            c4 r213 = r42;
            View r214 = r43;
            nr9.g r215 = r113;
            l0 r216 = r114;
            VideoGenerateShareHelper r217 = r115;
            r9 = r116;
            CoroutineScope r218 = r118;
            Object r46 = r1;
            r6 = r44;
            com.larus.bmhome.share.panel.h r119 = r117;
        L34:
            VideoGenerateShareHelper.VideoShareCallback r120 = VideoGenerateShareHelper.f(r217, r214, r218, r216, r215, r212, r211, r213, null, r210, (Map) r45, 768);
            IFlowSdkDepend r47 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r47 == null) goto L95;
            r47.r0();
            r8 = e2.a;
            nr9.g r48 = r6.e;
            if (r48 == null) goto L44;
            nr9.f r49 = r48.g;
            if (r49 == null) goto L44;
            String r50 = r49.b;
            if (r50 == null) goto L44;
            String r121 = r50;
        L45:
            if (r48 == null) goto L47;
            String r51 = r48.c;
        L49:
            if (o0.d(r51) == true) goto L52;
            r51 = null;
        L52:
            if (r51 != null) goto L59;
            nr9.g r52 = r6.e;
            if (r52 == null) goto L56;
            r51 = r52.h;
        L57:
            if (r51 != null) goto L59;
            String r53 = "";
        L60:
            ShareScene r122 = ShareScene.VIDEO_VIEWER;
            nr9.g r54 = r6.e;
            if (r54 == null) goto L65;
            Double r55 = r54.e;
            if (r55 == null) goto L65;
            int r56 = (int) r55.doubleValue();
        L66:
            nr9.g r57 = r6.e;
            if (r57 == null) goto L69;
            String r123 = r57.d;
        L71:
            if (r57 == null) goto L77;
            nr9.f r58 = r57.g;
            if (r58 == null) goto L77;
            Integer r59 = r58.d;
            if (r59 == null) goto L77;
            long r60 = r59.intValue();
        L78:
            nr9.g r61 = r6.e;
            if (r61 == null) goto L85;
            nr9.f r62 = r61.g;
            if (r62 == null) goto L85;
            Integer r63 = r62.e;
            if (r63 == null) goto L85;
            long r64 = r63.intValue();
        L86:
            long r124 = r64;
            long r219 = r60;
            sq9.i r125 = new sq9.i(ShareChannel.SHARE, r6.f.b, null, 4);
            this.L$0 = r6;
            this.L$1 = r119;
            this.L$2 = r121;
            this.L$3 = r53;
            this.L$4 = r122;
            this.L$5 = r123;
            this.L$6 = r120;
            this.L$7 = r9;
            this.L$8 = r8;
            this.L$9 = r125;
            this.L$10 = null;
            this.L$11 = null;
            this.I$0 = r56;
            this.J$0 = r219;
            int r65 = r56;
            this.J$1 = r124;
            this.label = 2;
            r16 = r6.X90(this);
            Object r66 = r46;
            if (r16 != r66) goto L89;
            return r66;
        L89:
            r31 = r65;
            r25 = r124;
            r27 = r219;
            r19 = r53;
            r22 = r120;
            r32 = r123;
            r24 = r122;
            r29 = r125;
            r18 = r121;
            r23 = r119;
        L85:
            r64 = -1;
        L77:
            r60 = -1;
            goto L78
        L69:
            r123 = null;
        L65:
            r56 = 0;
            goto L66
        L56:
            r51 = null;
        L59:
            r53 = r51;
            goto L60
        L47:
            r51 = null;
        L44:
            r121 = r7;
            goto L45
        L10:
            ResultKt.throwOnFailure(r38);
            Fragment r67 = this.this$0.getParentFragment();
            if (r67 == null) goto L109;
            FragmentManager r68 = r67.getFragmentManager();
            if (r68 == null) goto L109;
            BaseVideoDetailFragment<ViewBinding> r69 = this.this$0;
            CoroutineScope r126 = this.$scope;
            com.larus.bmhome.share.panel.h r70 = this.$sharePanelEventParam;
            VideoGenerateShareHelper r127 = VideoGenerateShareHelper.a;
            T r71 = r69.p;
            if (r71 == 0) goto L107;
            View r72 = r71.getRoot();
            if (r72 == null) goto L107;
            l0 r128 = (l0) r69.o.getValue();
            nr9.g r129 = r69.e;
            c4 r73 = r69.f;
            String r130 = r73.b;
            if (r130 != null) goto L22;
            r130 = "";
        L22:
            ShareScene r131 = r69.da0();
            ICreationMetadataService.Companion r74 = ICreationMetadataService.a;
            c4 r75 = r69.f;
            Message r76 = r75.l;
            String r77 = r75.h;
            Integer r78 = r75.i;
            if (r78 == null) goto L25;
            int r79 = r78.intValue();
        L26:
            UserCreationFromIM r80 = r74.I(r76, r77, String.valueOf(r79));
            if (r80 == null) goto L29;
            String r81 = r80.getCreationId();
        L30:
            this.L$0 = r69;
            this.L$1 = r126;
            this.L$2 = r70;
            this.L$3 = r68;
            this.L$4 = r127;
            this.L$5 = r128;
            this.L$6 = r129;
            this.L$7 = r72;
            this.L$8 = r73;
            this.L$9 = r130;
            this.L$10 = r131;
            this.L$11 = r81;
            this.label = 1;
            r45 = r69.X90(this);
            r46 = r1;
            if (r45 != r46) goto L33;
            return r46;
        L33:
            r210 = r81;
            r213 = r73;
            r214 = r72;
            r215 = r129;
            r216 = r128;
            r217 = r127;
            r212 = r130;
            r211 = r131;
            r218 = r126;
            r9 = r68;
            r119 = r70;
            r6 = r69;
            goto L34
        L29:
            r81 = null;
            goto L30
        L25:
            r79 = 0;
        L107:
            return Unit.INSTANCE;
        }
    }

    public BaseVideoDetailFragment$doShareAction$1(BaseVideoDetailFragment<ViewBinding> r1, LifecycleCoroutineScope r2, com.larus.bmhome.share.panel.h r3, Continuation<? super BaseVideoDetailFragment$doShareAction$1> r4) {
        this.this$0 = r1;
        this.$scope = r2;
        this.$sharePanelEventParam = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BaseVideoDetailFragment$doShareAction$1(this.this$0, this.$scope, this.$sharePanelEventParam, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        String r3 = (String) this.L$7;
        ShareScene r4 = (ShareScene) this.L$6;
        c4 r5 = (c4) this.L$5;
        String r6 = (String) this.L$4;
        nr9.g r7 = (nr9.g) this.L$3;
        l0 r8 = (l0) this.L$2;
        View r9 = (View) this.L$1;
        VideoGenerateShareHelper r10 = (VideoGenerateShareHelper) this.L$0;
        ResultKt.throwOnFailure(r19);
        String r14 = r3;
        ShareScene r11 = r4;
        c4 r12 = r5;
        String r13 = r6;
        VideoGenerateShareHelper r15 = r10;
        Object r16 = r19;
        nr9.g r17 = r7;
        View r18 = r9;
    L6:
        l0 r20 = r8;
        VideoGenerateShareHelper.j(r15, r18, this.$scope, r20, r17, r13, r11, this.$sharePanelEventParam, r12, null, r14, (Map) r16, null, 4864);
    L39:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r19);
        a5 r21 = z2.a.getCreationShareSettings().c();
        int r22 = 0;
        if (r21 != null) goto L12;
    L14:
        boolean r23 = false;
    L16:
        if (r23 == false) goto L18;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new AnonymousClass1(this.this$0, this.$scope, this.$sharePanelEventParam, null), 3, null);
        goto L39
    L18:
        VideoGenerateShareHelper r24 = VideoGenerateShareHelper.a;
        T r25 = this.this$0.p;
        if (r25 == 0) goto L41;
        View r26 = r25.getRoot();
        if (r26 == null) goto L41;
        r8 = (l0) this.this$0.o.getValue();
        BaseVideoDetailFragment<ViewBinding> r27 = this.this$0;
        nr9.g r28 = r27.e;
        c4 r110 = r27.f;
        String r111 = r110.b;
        if (r111 != null) goto L26;
        r111 = "";
    L26:
        ShareScene r29 = r27.da0();
        ICreationMetadataService.Companion r112 = ICreationMetadataService.a;
        c4 r113 = this.this$0.f;
        Message r114 = r113.l;
        String r115 = r113.h;
        Integer r116 = r113.i;
        if (r116 == null) goto L29;
        r22 = r116.intValue();
    L29:
        UserCreationFromIM r30 = r112.I(r114, r115, String.valueOf(r22));
        if (r30 == null) goto L32;
        String r31 = r30.getCreationId();
    L33:
        BaseVideoDetailFragment<ViewBinding> r32 = this.this$0;
        this.L$0 = r24;
        this.L$1 = r26;
        this.L$2 = r8;
        this.L$3 = r28;
        this.L$4 = r111;
        this.L$5 = r110;
        this.L$6 = r29;
        this.L$7 = r31;
        this.label = 1;
        r16 = r32.X90(this);
        if (r16 != r1) goto L36;
        return r1;
    L36:
        r14 = r31;
        r18 = r26;
        r15 = r24;
        r17 = r28;
        r12 = r110;
        r13 = r111;
        r11 = r29;
        goto L6
    L32:
        r31 = null;
    L41:
        return Unit.INSTANCE;
    L12:
        if (r21.a() != true) goto L14;
        r23 = true;
        goto L16
    }
}
