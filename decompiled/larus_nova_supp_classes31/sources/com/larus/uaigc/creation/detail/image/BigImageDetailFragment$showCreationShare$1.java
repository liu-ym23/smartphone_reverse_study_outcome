package com.larus.uaigc.creation.detail.image;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.common_ui.image.ImageAdapter;
import com.larus.bmhome.share.ShareScene;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment$showCreationShare$1", f = "BigImageDetailFragment.kt", i = {0}, l = {1094}, m = "invokeSuspend", n = {"it"}, s = {"L$2"})
final class BigImageDetailFragment$showCreationShare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $enterFrom;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ BigImageDetailFragment this$0;

    public BigImageDetailFragment$showCreationShare$1(BigImageDetailFragment r1, String r2, Continuation<? super BigImageDetailFragment$showCreationShare$1> r3) {
        this.this$0 = r1;
        this.$enterFrom = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BigImageDetailFragment$showCreationShare$1(this.this$0, this.$enterFrom, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r32) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        FragmentManager r4 = (FragmentManager) this.L$2;
        String r5 = (String) this.L$1;
        BigImageDetailFragment r6 = (BigImageDetailFragment) this.L$0;
        ResultKt.throwOnFailure(r32);
        Object r7 = r32;
    L16:
        UserCreationFromIM r8 = (UserCreationFromIM) r7;
        IFlowSdkDepend r9 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r9 == null) goto L99;
        r9.r0();
        e2 r10 = e2.a;
        ImageAdapter r11 = r6.d;
        String r12 = null;
        if (r11 == null) goto L25;
        List r13 = r11.b;
        if (r13 == null) goto L25;
        n1 r14 = (n1) ListProtector.get(r13, 0);
        if (r14 == null) goto L25;
        String r15 = r14.a;
    L26:
        String r16 = String.valueOf(r15);
        ImageAdapter r17 = r6.d;
        if (r17 == null) goto L33;
        List r18 = r17.b;
        if (r18 == null) goto L33;
        n1 r19 = (n1) ListProtector.get(r18, 0);
        if (r19 == null) goto L33;
        String r20 = r19.c;
    L34:
        String r110 = String.valueOf(r20);
        ImageAdapter r21 = r6.d;
        if (r21 == null) goto L41;
        List r22 = r21.b;
        if (r22 == null) goto L41;
        n1 r23 = (n1) ListProtector.get(r22, 0);
        if (r23 == null) goto L41;
        String r111 = r23.d;
    L42:
        uo8.k r24 = r6.F.c;
        if (r24 == null) goto L47;
        Map r25 = r24.a;
        if (r25 == null) goto L47;
        Object r26 = r25.get("message");
    L49:
        if ((r26 instanceof Message) == false) goto L51;
        Message r27 = (Message) r26;
    L52:
        if (r27 != null) goto L54;
    L56:
        r3 = false;
    L57:
        if (r3 == true) goto L66;
        ImageAdapter r28 = r6.d;
        if (r28 == null) goto L66;
        List r29 = r28.b;
        if (r29 == null) goto L66;
        n1 r30 = (n1) ListProtector.get(r29, 0);
        if (r30 == null) goto L66;
        String r112 = r30.e;
    L67:
        com.larus.bmhome.share.panel.h r113 = BigImageDetailFragment.X90(r6, "creation_detail");
        ShareScene r114 = ShareScene.IMAGE_VIEWER_REPORT;
        ImageAdapter r31 = r6.d;
        if (r31 == null) goto L76;
        List r33 = r31.b;
        if (r33 == null) goto L76;
        n1 r34 = (n1) ListProtector.get(r33, 0);
        if (r34 == null) goto L76;
        Long r35 = r34.g;
        if (r35 == null) goto L76;
        long r210 = r35.longValue();
    L77:
        ImageAdapter r36 = r6.d;
        if (r36 == null) goto L86;
        List r37 = r36.b;
        if (r37 == null) goto L86;
        n1 r38 = (n1) ListProtector.get(r37, 0);
        if (r38 == null) goto L86;
        Long r39 = r38.f;
        if (r39 == null) goto L86;
        long r115 = r39.longValue();
    L87:
        sq9.i r40 = new sq9.i(r5, r6.F.k, null, 4);
        if (r8 == null) goto L90;
        iz9.c.a.getClass();
        Map r211 = iz9.c.e(r8, null);
    L91:
        Object r41 = CollectionsKt.firstOrNull(r6.F.a);
        if ((r41 instanceof zo8.b) == false) goto L94;
        zo8.b r42 = (zo8.b) r41;
    L95:
        if (r42 == null) goto L97;
        r12 = r42.i;
    L97:
        r10.Z0(r4, new sq9.j(null, r16, r110, r111, r112, null, r113, r114, r115, r210, r40, r211, 0, null, null, null, r12, 61473));
        goto L99
    L94:
        r42 = null;
        goto L95
    L90:
        r211 = null;
    L86:
        r115 = -1;
    L76:
        r210 = -1;
    L66:
        r112 = null;
        goto L67
    L54:
        if (ap8.a.c(r27) != true) goto L56;
    L51:
        r27 = null;
    L47:
        r26 = null;
    L41:
        r111 = null;
    L33:
        r20 = null;
    L25:
        r15 = null;
    L99:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r32);
        Fragment r43 = this.this$0.getParentFragment();
        if (r43 == null) goto L99;
        FragmentManager r44 = r43.getFragmentManager();
        if (r44 == null) goto L99;
        r6 = this.this$0;
        String r45 = this.$enterFrom;
        String r46 = r6.F.k;
        this.L$0 = r6;
        this.L$1 = r45;
        this.L$2 = r44;
        this.label = 1;
        r7 = r6.ea0(r46, this);
        if (r7 != r1) goto L15;
        return r1;
    L15:
        r4 = r44;
        r5 = r45;
        goto L16
    }
}
