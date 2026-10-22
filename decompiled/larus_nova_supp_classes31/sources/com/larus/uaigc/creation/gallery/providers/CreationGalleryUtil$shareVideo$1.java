package com.larus.uaigc.creation.gallery.providers;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.utils.IVideoShareService;
import com.larus.bmhome.utils.c4;
import com.larus.common_ui.dialog.l0;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.t3;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationGalleryUtil$shareVideo$1", f = "CreationGalleryUtil.kt", i = {0, 0}, l = {149}, m = "invokeSuspend", n = {"videoPlayData", "callback"}, s = {"L$2", "L$3"})
public final class CreationGalleryUtil$shareVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ l0 $loadingDialog;
    final /* synthetic */ sz9.c $params;
    final /* synthetic */ View $rootView;
    final /* synthetic */ nr9.g $shareVideoPlayData;
    final /* synthetic */ ShareScene $targetScene;
    int I$0;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;

    public CreationGalleryUtil$shareVideo$1(View r1, nr9.g r2, sz9.c r3, l0 r4, ShareScene r5, Continuation<? super CreationGalleryUtil$shareVideo$1> r6) {
        this.$rootView = r1;
        this.$shareVideoPlayData = r2;
        this.$params = r3;
        this.$loadingDialog = r4;
        this.$targetScene = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CreationGalleryUtil$shareVideo$1(this.$rootView, this.$shareVideoPlayData, this.$params, this.$loadingDialog, this.$targetScene, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r38) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L9;
        long r4 = this.J$1;
        long r6 = this.J$0;
        int r1 = this.I$0;
        sq9.i r3 = (sq9.i) this.L$10;
        t3 r8 = (t3) this.L$9;
        FragmentManager r9 = (FragmentManager) this.L$8;
        String r10 = (String) this.L$7;
        com.larus.bmhome.share.panel.h r11 = (com.larus.bmhome.share.panel.h) this.L$6;
        String r12 = (String) this.L$5;
        String r13 = (String) this.L$4;
        com.larus.bmhome.share.panel.d r14 = (com.larus.bmhome.share.panel.d) this.L$3;
        nr9.g r15 = (nr9.g) this.L$2;
        ShareScene r5 = (ShareScene) this.L$1;
        sz9.c r7 = (sz9.c) this.L$0;
        ResultKt.throwOnFailure(r38);     // Catch: Throwable -> L140
        sq9.i r29 = r3;
        ShareScene r24 = r5;
        long r25 = r4;
        long r27 = r6;
        String r32 = r10;
        com.larus.bmhome.share.panel.h r23 = r11;
        String r19 = r12;
        String r18 = r13;
        com.larus.bmhome.share.panel.d r22 = r14;
        int r31 = r1;
        sz9.c r16 = r7;
        Object r17 = r38;
    L98:
        Map r30 = (Map) r17;     // Catch: Throwable -> L140
        Integer r20 = r16.q;     // Catch: Throwable -> L140
        if (r15 == null) goto L101;
        String r34 = r15.a;     // Catch: Throwable -> L140
    L102:
        r8.Z0(r9, new sq9.j(null, r18, r19, null, null, r22, r23, r24, r25, r27, r29, r30, r31, r32, r20, r34, null, 65537));     // Catch: Throwable -> L140
        sz9.c r21 = r16;
    L104:
        if (r15 == null) goto L106;
        String r26 = r15.a;     // Catch: Throwable -> L140
    L107:
        com.larus.bmhome.share.panel.h r28 = r21.m;     // Catch: Throwable -> L140
        if (r28 == null) goto L110;
        String r33 = r28.h;     // Catch: Throwable -> L140
    L111:
        if (r28 == null) goto L113;
        String r35 = r28.g;     // Catch: Throwable -> L140
    L114:
        if (r28 == null) goto L116;
        String r36 = r28.d;     // Catch: Throwable -> L140
    L117:
        c4 r37 = r21.n;     // Catch: Throwable -> L140
        if (r37 == null) goto L121;
        String r39 = r37.g;     // Catch: Throwable -> L140
        if (r39 == null) goto L121;
    L122:
        String r40 = r39;
        if (r37 == null) goto L125;
        String r41 = r37.j;     // Catch: Throwable -> L140
    L126:
        if (r37 == null) goto L128;
        Integer r110 = r37.i;     // Catch: Throwable -> L140
    L129:
        if (r37 == null) goto L131;
        String r111 = r37.h;     // Catch: Throwable -> L140
    L132:
        if (r37 == null) goto L135;
        JSONObject r42 = r37.m;     // Catch: Throwable -> L140
        if (r42 == null) goto L135;
    L136:
        a4.k(r26, r33, r35, r36, r40, r41, r110, r111, r42);     // Catch: Throwable -> L140
        Unit r43 = Unit.INSTANCE;     // Catch: Throwable -> L140
    L138:
        Result.constructor-impl(r43);     // Catch: Throwable -> L140
    L143:
        return Unit.INSTANCE;
    L135:
        r42 = new JSONObject();     // Catch: Throwable -> L140
        goto L136
    L131:
        r111 = null;
        goto L132
    L128:
        r110 = null;
        goto L129
    L125:
        r41 = null;
    L121:
        r39 = "0";
        goto L122
    L116:
        r36 = null;
        goto L117
    L113:
        r35 = null;
        goto L114
    L110:
        r33 = null;
        goto L111
    L106:
        r26 = null;
        goto L107
    L101:
        r34 = null;
        goto L102
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r38);
        View r44 = this.$rootView;
        r15 = this.$shareVideoPlayData;
        sz9.c r45 = this.$params;
        l0 r46 = this.$loadingDialog;
        ShareScene r47 = this.$targetScene;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L140
        if (r44 == null) goto L137;
        Intrinsics.checkNotNullParameter(r44, "<this>");     // Catch: Throwable -> L140
        Fragment r49 = FragmentManager.findFragment(r44);     // Catch: Throwable -> L140
        if (r49 == null) goto L137;
        r9 = r49.getFragmentManager();     // Catch: Throwable -> L140
        if (r9 == null) goto L137;
        IVideoShareService r112 = (IVideoShareService) ServiceManager.get().getService(IVideoShareService.class);     // Catch: Throwable -> L140
        if (r112 == null) goto L28;
        CoroutineScope r113 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());     // Catch: Throwable -> L140
        Message r50 = r45.l;     // Catch: Throwable -> L140
        if (r50 == null) goto L23;
        String r51 = r50.getMessageId();     // Catch: Throwable -> L140
    L24:
        if (r51 != null) goto L26;
        String r210 = "";
    L27:
        com.larus.bmhome.share.panel.d r52 = IVideoShareService.a.a(r112, r44, r113, r46, r15, r210, r47, r45.m, r45.n, r45.j, null, 2816);     // Catch: Throwable -> L140
    L29:
        com.larus.bmhome.share.panel.d r53 = r45.o;     // Catch: Throwable -> L140
        if (r53 == null) goto L32;
        FLogger.a.i("CreationGalleryUtil", "shareVideo: 合并 clickInterceptor 与 videoCallback");     // Catch: Throwable -> L140
        com.larus.bmhome.share.panel.d r114 = new b(r53, r52);     // Catch: Throwable -> L140
    L33:
        IFlowSdkDepend r54 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L140
        if (r54 == null) goto L103;
        r54.r0();     // Catch: Throwable -> L140
        r8 = e2.a;
        if (r15 == null) goto L44;
        nr9.f r55 = r15.g;     // Catch: Throwable -> L140
        if (r55 == null) goto L44;
        String r56 = r55.b;     // Catch: Throwable -> L140
        if (r56 == null) goto L44;
        String r115 = r56;
    L45:
        if (r15 == null) goto L47;
        String r57 = r15.c;     // Catch: Throwable -> L140
    L49:
        if (o0.d(r57) == true) goto L52;
        r57 = null;
    L52:
        if (r57 != null) goto L58;
        if (r15 == null) goto L55;
        r57 = r15.h;     // Catch: Throwable -> L140
    L56:
        if (r57 != null) goto L58;
        String r116 = "";
    L59:
        com.larus.bmhome.share.panel.h r117 = r45.m;     // Catch: Throwable -> L140
        if (r15 == null) goto L64;
        Double r58 = r15.e;     // Catch: Throwable -> L140
        if (r58 == null) goto L64;
        int r59 = (int) r58.doubleValue();     // Catch: Throwable -> L140
    L65:
        if (r15 == null) goto L67;
        String r118 = r15.d;     // Catch: Throwable -> L140
    L68:
        if (r15 == null) goto L74;
        nr9.f r60 = r15.g;     // Catch: Throwable -> L140
        if (r60 == null) goto L74;
        Integer r61 = r60.d;     // Catch: Throwable -> L140
        if (r61 == null) goto L74;
        long r62 = r61.intValue();     // Catch: Throwable -> L140
    L75:
        if (r15 == null) goto L81;
        nr9.f r63 = r15.g;     // Catch: Throwable -> L140
        if (r63 == null) goto L81;
        Integer r64 = r63.e;     // Catch: Throwable -> L140
        if (r64 == null) goto L81;
        long r65 = r64.intValue();     // Catch: Throwable -> L140
    L82:
        long r211 = r65;
        Message r66 = r45.l;     // Catch: Throwable -> L140
        if (r66 == null) goto L85;
        String r67 = r66.getMessageId();     // Catch: Throwable -> L140
    L86:
        int r119 = r59;
        sq9.i r68 = new sq9.i("share", r67, null, 4);     // Catch: Throwable -> L140
        CreationGalleryUtil r69 = CreationGalleryUtil.a;     // Catch: Throwable -> L140
        Message r70 = r45.l;     // Catch: Throwable -> L140
        if (r70 == null) goto L89;
        String r71 = r70.getMessageId();     // Catch: Throwable -> L140
    L90:
        String r72 = r45.i;     // Catch: Throwable -> L140
        com.larus.bmhome.share.panel.h r73 = r45.m;     // Catch: Throwable -> L140
        if (r73 == null) goto L93;
        String r74 = r73.E;     // Catch: Throwable -> L140
    L94:
        this.L$0 = r45;     // Catch: Throwable -> L140
        this.L$1 = r47;     // Catch: Throwable -> L140
        this.L$2 = r15;     // Catch: Throwable -> L140
        this.L$3 = r114;     // Catch: Throwable -> L140
        this.L$4 = r115;     // Catch: Throwable -> L140
        this.L$5 = r116;     // Catch: Throwable -> L140
        this.L$6 = r117;     // Catch: Throwable -> L140
        this.L$7 = r118;     // Catch: Throwable -> L140
        this.L$8 = r9;     // Catch: Throwable -> L140
        this.L$9 = r8;     // Catch: Throwable -> L140
        this.L$10 = r68;     // Catch: Throwable -> L140
        this.I$0 = r119;     // Catch: Throwable -> L140
        long r75 = r62;
        this.J$0 = r75;     // Catch: Throwable -> L140
        this.J$1 = r211;     // Catch: Throwable -> L140
        this.label = 1;     // Catch: Throwable -> L140
        r17 = CreationGalleryUtil.a(r69, r71, r72, r74, this);     // Catch: Throwable -> L140
        if (r17 != r0) goto L97;
        return r0;
    L97:
        r25 = r211;
        r32 = r118;
        r24 = r47;
        r27 = r75;
        r31 = r119;
        r16 = r45;
        r29 = r68;
        r23 = r117;
        r19 = r116;
        r18 = r115;
        r22 = r114;
        goto L98
    L93:
        r74 = null;
        goto L94
    L89:
        r71 = null;
        goto L90
    L85:
        r67 = null;
    L81:
        r65 = -1;
    L74:
        r62 = -1;
        goto L75
    L67:
        r118 = null;
    L64:
        r59 = 0;
        goto L65
    L55:
        r57 = null;
    L58:
        r116 = r57;
        goto L59
    L47:
        r57 = null;
    L44:
        r115 = "";
        goto L45
    L103:
        r21 = r45;
        goto L104
    L32:
        r114 = r52;
        goto L33
    L26:
        r210 = r51;
        goto L27
    L23:
        r51 = null;
        goto L24
    L28:
        r52 = null;
    L137:
        r43 = null;
    L140:
        th = move-exception;
        Result.Companion r76 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L143
    }
}
