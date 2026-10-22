package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.app.Application;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.uaigc.bean.createpage.component.mediacontainer.UIStatus;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$toastVideoCheckFailed$2", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MultiAttachmentSelectorComponent$toastVideoCheckFailed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResourceItemBean $bean;
    final /* synthetic */ ic8.n0 $processResult;
    final /* synthetic */ boolean $retainForRetry;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProcessFileResultCode.values().length];
            r0[ProcessFileResultCode.PREPARE_OVER_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ProcessFileResultCode.PREPARE_OVER_META_LIMIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ProcessFileResultCode.PREPARE_OVER_DURATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ProcessFileResultCode.PREPARE_OVER_STORAGE_FREE_SPACE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public MultiAttachmentSelectorComponent$toastVideoCheckFailed$2(ic8.n0 r1, boolean r2, MultiAttachmentSelectorComponent r3, ResourceItemBean r4, Continuation<? super MultiAttachmentSelectorComponent$toastVideoCheckFailed$2> r5) {
        this.$processResult = r1;
        this.$retainForRetry = r2;
        this.this$0 = r3;
        this.$bean = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MultiAttachmentSelectorComponent$toastVideoCheckFailed$2(this.$processResult, this.$retainForRetry, this.this$0, this.$bean, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r11);
        FLogger.a.w("MultiAttachmentSelector", "[toastVideoCheckFailed] processResult = " + this.$processResult.b);
        ProcessFileResultCode r12 = this.$processResult.b;
        if (r12 != null) goto L7;
        int r13 = -1;
    L9:
        if (r13 != 1) goto L11;
        t19.s r14 = t19.s.a;
        Application r0 = AppHost.a.getApplication();
        r14.getClass();
        t19.s.s(r0, 2131910959);
    L22:
        if (this.$retainForRetry == false) goto L24;
        this.this$0.G.add(this.$bean.getKey());
        this.this$0.e4(this.$bean.getKey()).setValue(new ry9.k(this.$bean.getKey(), ry9.j.f.b, 0, false, false, false, 60));
    L31:
        return Unit.INSTANCE;
    L24:
        MultiAttachmentSelectorComponent r15 = this.this$0;
        String r1 = this.$bean.getKey();
        Image r2 = this.$bean.getImage();
        if (r2 == null) goto L28;
        String r3 = r2.localResPath;
        if (r3 == null) goto L28;
    L29:
        r15.w60(r1, r3, null);
        this.this$0.N.setValue(new ry9.f(this.$bean.getKey(), 0, null, UIStatus.STATUS_DELETE, 6));
    L28:
        r3 = "";
        goto L29
    L11:
        if (r13 != 2) goto L13;
        t19.s r16 = t19.s.a;
        Application r4 = AppHost.a.getApplication();
        r16.getClass();
        t19.s.s(r4, 2131910958);
        goto L22
    L13:
        if (r13 != 3) goto L15;
        t19.s r17 = t19.s.a;
        Application r5 = AppHost.a.getApplication();
        r17.getClass();
        t19.s.s(r5, 2131910898);
        goto L22
    L15:
        if (r13 == 4) goto L17;
        t19.s r18 = t19.s.a;
        Application r6 = AppHost.a.getApplication();
        r18.getClass();
        t19.s.s(r6, 2131908214);
        goto L22
    L17:
        t19.s r19 = t19.s.a;
        Application r7 = AppHost.a.getApplication();
        r19.getClass();
        t19.s.b(r7, 2131907891, false);
        goto L22
    L7:
        r13 = a.a[r12.ordinal()];
        goto L9
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
