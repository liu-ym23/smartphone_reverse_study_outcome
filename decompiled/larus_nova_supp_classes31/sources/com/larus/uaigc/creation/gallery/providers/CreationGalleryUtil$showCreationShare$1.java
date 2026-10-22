package com.larus.uaigc.creation.gallery.providers;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.share.ShareScene;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationGalleryUtil$showCreationShare$1", f = "CreationGalleryUtil.kt", i = {0}, l = {432}, m = "invokeSuspend", n = {"it"}, s = {"L$2"})
final class CreationGalleryUtil$showCreationShare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $enterFrom;
    final /* synthetic */ sz9.c $params;
    final /* synthetic */ View $rootView;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public CreationGalleryUtil$showCreationShare$1(View r1, sz9.c r2, String r3, Continuation<? super CreationGalleryUtil$showCreationShare$1> r4) {
        this.$rootView = r1;
        this.$params = r2;
        this.$enterFrom = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationGalleryUtil$showCreationShare$1(this.$rootView, this.$params, this.$enterFrom, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r31) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        Unit r4 = null;
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L9;
        FragmentManager r1 = (FragmentManager) this.L$2;
        String r5 = (String) this.L$1;
        sz9.c r6 = (sz9.c) this.L$0;
        ResultKt.throwOnFailure(r31);     // Catch: Throwable -> L80
        Object r7 = r31;
    L23:
        UserCreationFromIM r8 = (UserCreationFromIM) r7;     // Catch: Throwable -> L80
        IFlowSdkDepend r9 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L80
        if (r9 == null) goto L78;
        r9.r0();     // Catch: Throwable -> L80
        e2 r10 = e2.a;
        n1 r11 = r6.a;     // Catch: Throwable -> L80
        if (r11 == null) goto L30;
        String r12 = r11.a;     // Catch: Throwable -> L80
    L31:
        String r13 = String.valueOf(r12);     // Catch: Throwable -> L80
        n1 r14 = r6.a;     // Catch: Throwable -> L80
        if (r14 == null) goto L34;
        String r15 = r14.c;     // Catch: Throwable -> L80
    L35:
        String r16 = String.valueOf(r15);     // Catch: Throwable -> L80
        n1 r17 = r6.a;     // Catch: Throwable -> L80
        if (r17 == null) goto L38;
        String r18 = r17.d;     // Catch: Throwable -> L80
    L39:
        Message r19 = r6.l;     // Catch: Throwable -> L80
        if (r19 != null) goto L42;
    L44:
        r3 = false;
    L45:
        if (r3 == true) goto L55;
        Integer r20 = r6.c;     // Catch: Throwable -> L80
        if (r20 != null) goto L50;
    L52:
        n1 r21 = r6.a;     // Catch: Throwable -> L80
        if (r21 == null) goto L55;
        String r110 = r21.e;     // Catch: Throwable -> L80
    L56:
        com.larus.bmhome.share.panel.h r111 = CreationGalleryUtil.b("creation_detail", r6);     // Catch: Throwable -> L80
        ShareScene r112 = ShareScene.IMAGE_VIEWER_REPORT;     // Catch: Throwable -> L80
        n1 r22 = r6.a;     // Catch: Throwable -> L80
        long r23 = -1;
        if (r22 == null) goto L61;
        Long r24 = r22.g;     // Catch: Throwable -> L80
        if (r24 == null) goto L61;
        long r25 = r24.longValue();     // Catch: Throwable -> L80
    L62:
        n1 r26 = r6.a;     // Catch: Throwable -> L80
        if (r26 == null) goto L67;
        Long r27 = r26.f;     // Catch: Throwable -> L80
        if (r27 == null) goto L67;
        r23 = r27.longValue();     // Catch: Throwable -> L80
    L67:
        long r113 = r23;
        Message r28 = r6.l;     // Catch: Throwable -> L80
        if (r28 == null) goto L70;
        String r29 = r28.getMessageId();     // Catch: Throwable -> L80
    L71:
        sq9.i r30 = new sq9.i(r5, r29, null, 4);     // Catch: Throwable -> L80
        if (r8 == null) goto L77;
        iz9.c r32 = iz9.c.a;     // Catch: Throwable -> L80
        JSONObject r33 = r6.f;     // Catch: Throwable -> L80
        if (r33 == null) goto L76;
        r4 = r33.optString("creation_task_id");     // Catch: Throwable -> L80
    L76:
        r32.getClass();     // Catch: Throwable -> L80
        r4 = iz9.c.e(r8, r4);     // Catch: Throwable -> L80
    L77:
        r10.Z0(r1, new sq9.j(null, r13, r16, r18, r110, null, r111, r112, r113, r25, r30, r4, 0, null, r6.q, null, r6.e, 45089));     // Catch: Throwable -> L80
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L80
        goto L78
    L70:
        r29 = null;
    L61:
        r25 = -1;
        goto L62
    L50:
        if (r20.intValue() != 3) goto L52;
    L55:
        r110 = null;
        goto L56
    L42:
        if (ap8.a.c(r19) != true) goto L44;
    L38:
        r18 = null;
        goto L39
    L34:
        r15 = null;
        goto L35
    L30:
        r12 = null;
    L78:
        Result.constructor-impl(r4);     // Catch: Throwable -> L80
    L83:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r31);
        View r34 = this.$rootView;
        r6 = this.$params;
        String r35 = this.$enterFrom;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L80
        Fragment r37 = ViewExtKt.f(r34);     // Catch: Throwable -> L80
        if (r37 == null) goto L78;
        FragmentManager r38 = r37.getFragmentManager();     // Catch: Throwable -> L80
        if (r38 == null) goto L78;
        CreationGalleryUtil r39 = CreationGalleryUtil.a;     // Catch: Throwable -> L80
        Message r40 = r6.l;     // Catch: Throwable -> L80
        if (r40 == null) goto L18;
        String r41 = r40.getMessageId();     // Catch: Throwable -> L80
    L19:
        String r42 = r6.i;     // Catch: Throwable -> L80
        this.L$0 = r6;     // Catch: Throwable -> L80
        this.L$1 = r35;     // Catch: Throwable -> L80
        this.L$2 = r38;     // Catch: Throwable -> L80
        this.label = 1;     // Catch: Throwable -> L80
        r7 = r39.e(r41, r42, this);     // Catch: Throwable -> L80
        if (r7 != r0) goto L22;
        return r0;
    L22:
        r1 = r38;
        r5 = r35;
        goto L23
    L18:
        r41 = null;
    L80:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L83
    }
}
