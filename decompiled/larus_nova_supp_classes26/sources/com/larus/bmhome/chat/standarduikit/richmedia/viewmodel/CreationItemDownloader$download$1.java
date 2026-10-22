package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import android.view.View;
import com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService;
import com.larus.bmhome.chat.block.base.config.RichMediaCreationImageButtonAction;
import com.larus.bmhome.chat.block.base.config.RichMediaCreationVideoButtonAction;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaKind;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.CreationItemDownloader$download$1", f = "RichMediaItemDownloadDispatcher.kt", i = {}, l = {77, GuidePriority.VLM_REALTIME_CALL_PRIORITY}, m = "invokeSuspend", n = {}, s = {})
public final class CreationItemDownloader$download$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $anchor;
    final /* synthetic */ CreationItem $creationItem;
    final /* synthetic */ f0 $currentDependency;
    final /* synthetic */ fn8.c $item;
    final /* synthetic */ Function0<Unit> $onCompleted;
    final /* synthetic */ CoroutineScope $scope;
    int label;
    final /* synthetic */ CreationItemDownloader this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RichMediaKind.values().length];
            r0[RichMediaKind.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RichMediaKind.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public CreationItemDownloader$download$1(fn8.c r1, View r2, CreationItemDownloader r3, CreationItem r4, f0 r5, CoroutineScope r6, Function0<Unit> r7, Continuation<? super CreationItemDownloader$download$1> r8) {
        this.$item = r1;
        this.$anchor = r2;
        this.this$0 = r3;
        this.$creationItem = r4;
        this.$currentDependency = r5;
        this.$scope = r6;
        this.$onCompleted = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CreationItemDownloader$download$1(this.$item, this.$anchor, this.this$0, this.$creationItem, this.$currentDependency, this.$scope, this.$onCompleted, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r18);
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
    L21:
        this.$onCompleted.invoke();
        goto L23
    L10:
        ResultKt.throwOnFailure(r18);
        RichMediaKind r1 = this.$item.c;
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L18;
        if (r2 != 2) goto L17;
        IRichMediaCreationClickService.Companion r3 = IRichMediaCreationClickService.a;
        RichMediaCreationVideoButtonAction r4 = RichMediaCreationVideoButtonAction.DOWNLOAD;
        View r5 = this.$anchor;
        CreationItemDownloader r6 = this.this$0;
        Message r7 = r6.a;
        CreationItem r8 = this.$creationItem;
        int r9 = ((Number) r6.e.invoke(this.$item)).intValue();
        boolean r10 = this.$currentDependency.l();
        kc8.q r11 = this.$currentDependency.g();
        CoroutineScope r12 = this.$scope;
        Function0<Unit> r13 = this.$onCompleted;
        fn8.c r14 = this.$item;
        CreationItemDownloader r16 = this.this$0;
        JSONObject r17 = j0.b(r14, r16.a, r16.b, ((Number) r16.d.invoke(r14)).intValue()).b();
        this.label = 2;
        if (r3.b(r4, r5, r7, r8, r9, r10, r11, r12, r13, r17, this) != r15) goto L23;
        return r15;
    L17:
        throw new NoWhenBranchMatchedException();
    L18:
        IRichMediaCreationClickService.Companion r19 = IRichMediaCreationClickService.a;
        RichMediaCreationImageButtonAction r20 = RichMediaCreationImageButtonAction.DOWNLOAD;
        View r21 = this.$anchor;
        CreationItemDownloader r22 = this.this$0;
        Message r23 = r22.a;
        CreationItem r24 = this.$creationItem;
        int r25 = ((Number) r22.e.invoke(this.$item)).intValue();
        String r26 = this.$currentDependency.getCurrentPage();
        String r27 = this.$currentDependency.b();
        Boolean r110 = Boxing.boxBoolean(this.$currentDependency.d());
        boolean r111 = this.$currentDependency.l();
        kc8.q r112 = this.$currentDependency.g();
        CoroutineScope r113 = this.$scope;
        fn8.c r28 = this.$item;
        CreationItemDownloader r29 = this.this$0;
        JSONObject r114 = j0.b(r28, r29.a, r29.b, ((Number) r29.d.invoke(r28)).intValue()).b();
        this.label = 1;
        if (r19.f(r20, r21, r23, r24, r25, r26, r27, r110, r111, r112, r113, r114, this) != r15) goto L21;
        return r15;
    }
}
