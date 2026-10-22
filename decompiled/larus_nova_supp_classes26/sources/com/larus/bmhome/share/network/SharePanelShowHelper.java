package com.larus.bmhome.share.network;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService$a;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class SharePanelShowHelper {
    public static final /* synthetic */ int d = 0;
    public final CoroutineScope a;
    public Deferred<BizResponse<SaveMessageShareInfo>> b;
    public Deferred<BizResponse<g>> c;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.share.panel.d {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ SharePanelShowHelper b;
        public final /* synthetic */ j c;
        public final /* synthetic */ com.larus.bmhome.share.panel.b d;
        public final /* synthetic */ Function1<i, Unit> e;

        @Override // com.larus.bmhome.share.panel.d
        public final boolean d(String r1, String r2, Boolean r3) {
            return true;
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void f() {
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void onDismiss() {
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void e(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        @Override // com.larus.bmhome.share.panel.d
        public final boolean b(Context r18, DialogFragment r19, View r20, jr9.a r21) {
            Intrinsics.checkNotNullParameter(r21, "shareItemConfig");
            if (this.a == false) goto L6;
            SharePanelShowHelper r3 = this.b;
            j r8 = this.c;
            com.larus.bmhome.share.panel.b r6 = this.d;
            Function1<i, Unit> r4 = this.e;
            BuildersKt.launch$default(r3.a, null, null, new SharePanelShowHelper$interceptItemClickForCodePreviewShare$1(r3, r4, r21, r6, r19, r8, null), 3, null);
            return true;
        L6:
            SharePanelShowHelper r5 = this.b;
            j r9 = this.c;
            com.larus.bmhome.share.panel.b r7 = this.d;
            Function1<i, Unit> r10 = this.e;
            BuildersKt.launch$default(r5.a, null, null, new SharePanelShowHelper$interceptItemClick$1(r5, r10, r21, r7, r19, r9, null), 3, null);
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(boolean r1, SharePanelShowHelper r2, j r3, com.larus.bmhome.share.panel.b r4, Function1<? super i, Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
    }

    public SharePanelShowHelper(CoroutineScope r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleScope");
        this.a = r2;
    }

    public static final Object a(SharePanelShowHelper r10, h r11, Continuation r12) {
        r10.getClass();
        if ((r12 instanceof SharePanelShowHelper$doRequestCodePreviewShareApi$1) == false) goto L7;
        SharePanelShowHelper$doRequestCodePreviewShareApi$1 r0 = (SharePanelShowHelper$doRequestCodePreviewShareApi$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        SharePanelShowHelper$doRequestCodePreviewShareApi$1 r8 = r0;
        Object r13 = r8.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r8.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        dm9.a.b r15 = (dm9.a) r13;
        if ((r15 instanceof dm9.a.b) == false) goto L22;
        BizResponse r16 = r15.a;
    L24:
        return r16;
    L22:
        if ((r15 instanceof dm9.a.a) == false) goto L26;
        FLogger.a.i("SharePanelShowHelper", String.valueOf(((dm9.a.a) r15).c));
        r16 = new BizResponse(-1, null, null, null, 14, null);
        goto L24
    L26:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        ShareCodePreviewApi.a r17 = ShareCodePreviewApi.a;
        SharePanelShowHelper$doRequestCodePreviewShareApi$result$1 r3 = new SharePanelShowHelper$doRequestCodePreviewShareApi$result$1(r11, null);
        r8.label = 1;
        r17.getClass();
        FlowHttpConnection r18 = FlowHttpConnection.a;
        r13 = FlowHttpConnection.g("Basic", ShareCodePreviewApi.class, r3, false, null, null, null, r8, 248);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r0 = new SharePanelShowHelper$doRequestCodePreviewShareApi$1(r10, r12);
        goto L8
    }

    public static final Object b(SharePanelShowHelper r16, String r17, String r18, Continuation r19) {
        r16.getClass();
        if ((r19 instanceof SharePanelShowHelper$doRequestMessageShareApi$1) == false) goto L7;
        SharePanelShowHelper$doRequestMessageShareApi$1 r1 = (SharePanelShowHelper$doRequestMessageShareApi$1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L28:
        dm9.a.b r5 = (dm9.a) r0;
        if ((r5 instanceof dm9.a.b) == false) goto L32;
        BizResponse r6 = r5.a;
    L38:
        return r6;
    L32:
        if ((r5 instanceof dm9.a.a) == false) goto L35;
        FLogger.a.i("SharePanelShowHelper", String.valueOf(((dm9.a.a) r5).c));
        r6 = new BizResponse(-1, null, null, null, 14, null);
        goto L38
    L35:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (r17.length() != 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L20;
    L36:
        r6 = new BizResponse(-1, null, null, new SaveMessageShareInfo(null, null, null, null, null, 31, null), 6, null);
        goto L38
    L20:
        if (r18.length() != 0) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L36;
        MessageShareApi.Companion r9 = MessageShareApi.a;
        f r12 = new f(r17, CollectionsKt.listOf(r18), Boxing.boxBoolean(z2.a.getShareConfig().g()), Boxing.boxBoolean(false), null, 16);
        r1.label = 1;
        r9.getClass();
        r0 = MessageShareApi.Companion.a(r12, r1);
        if (r0 != r3) goto L28;
        return r3;
    L22:
        r8 = false;
        goto L23
    L17:
        r7 = false;
    L7:
        r1 = new SharePanelShowHelper$doRequestMessageShareApi$1(r16, r19);
        goto L8
    }

    public final void c(FragmentActivity r20, j r21, ShareScene r22, com.larus.bmhome.share.panel.h r23, com.larus.bmhome.share.panel.b r24, String r25, String r26, by7.e r27, boolean r28, h r29, Function1<? super i, Unit> r30) {
        Intrinsics.checkNotNullParameter(r20, "activity");
        Intrinsics.checkNotNullParameter(r21, "loadingAbility");
        Intrinsics.checkNotNullParameter(r22, "shareScene");
        Intrinsics.checkNotNullParameter(r23, "eventParam");
        Intrinsics.checkNotNullParameter(r24, "shareContent");
        Intrinsics.checkNotNullParameter(r25, "conversationId");
        Intrinsics.checkNotNullParameter(r26, "messageId");
        Intrinsics.checkNotNullParameter(r27, "node");
        Intrinsics.checkNotNullParameter(r30, "continueShareCallback");
        if (r29 == null) goto L5;
        boolean r1 = true;
    L6:
        IShareService$a.g(ShareServiceDelegate.b, r20, r22, r24, r23, new b(r1, this, r21, r24, r30), r27, r28, 128);
        if (r29 == null) goto L10;
        BuildersKt.launch$default(this.a, null, null, new SharePanelShowHelper$tryShowSharePanel$2$1(this, r29, null), 3, null);
        return;
    L10:
        BuildersKt.launch$default(this.a, null, null, new SharePanelShowHelper$tryShowSharePanel$3(this, r25, r26, null), 3, null);
        return;
    L5:
        r1 = false;
        goto L6
    }
}
