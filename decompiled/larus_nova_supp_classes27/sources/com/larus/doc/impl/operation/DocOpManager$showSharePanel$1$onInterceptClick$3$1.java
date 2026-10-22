package com.larus.doc.impl.operation;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.larus.office.base.common.OfficePlatformHelper;
import com.larus.platform.service.IOfficePlatformService;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$showSharePanel$1$onInterceptClick$3$1", f = "DocOpManager.kt", i = {}, l = {668}, m = "invokeSuspend", n = {}, s = {})
public final class DocOpManager$showSharePanel$1$onInterceptClick$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $bizExtra;
    final /* synthetic */ Context $it;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ jr9.a $shareItemConfig;
    final /* synthetic */ DialogFragment $sharePanelDialog;
    int label;

    /* JADX INFO: renamed from: com.larus.doc.impl.operation.DocOpManager$showSharePanel$1$onInterceptClick$3$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$showSharePanel$1$onInterceptClick$3$1$1", f = "DocOpManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $feishuLink;
        final /* synthetic */ Context $it;
        final /* synthetic */ jr9.a $shareItemConfig;
        final /* synthetic */ DialogFragment $sharePanelDialog;
        int label;

        public AnonymousClass1(Context r1, String r2, DialogFragment r3, jr9.a r4, Continuation<? super AnonymousClass1> r5) {
            this.$it = r1;
            this.$feishuLink = r2;
            this.$sharePanelDialog = r3;
            this.$shareItemConfig = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$it, this.$feishuLink, this.$sharePanelDialog, this.$shareItemConfig, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            OfficePlatformHelper.a.b(this.$it, this.$feishuLink, this.$sharePanelDialog, this.$shareItemConfig);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DocOpManager$showSharePanel$1$onInterceptClick$3$1(String r1, Map<String, ? extends Object> r2, Context r3, DialogFragment r4, jr9.a r5, Continuation<? super DocOpManager$showSharePanel$1$onInterceptClick$3$1> r6) {
        this.$resourceId = r1;
        this.$bizExtra = r2;
        this.$it = r3;
        this.$sharePanelDialog = r4;
        this.$shareItemConfig = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DocOpManager$showSharePanel$1$onInterceptClick$3$1(this.$resourceId, this.$bizExtra, this.$it, this.$sharePanelDialog, this.$shareItemConfig, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        DocOpManager r12 = DocOpManager.a;
        String r13 = this.$resourceId;
        String r6 = OfficePlatformHelper.a.a(IOfficePlatformService.FeishuDocType.DOCX, r13);
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$it, r6, this.$sharePanelDialog, this.$shareItemConfig, null);
        this.label = 1;
        if (BuildersKt.withContext(r14, r2, this) != r0) goto L12;
        return r0;
    }
}
