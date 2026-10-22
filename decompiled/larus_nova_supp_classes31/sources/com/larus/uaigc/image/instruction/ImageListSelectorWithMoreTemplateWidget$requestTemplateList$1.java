package com.larus.uaigc.image.instruction;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.larus.bmhome.actionbar.model.n;
import com.larus.bmhome.actionbar.model.w;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.service.e0;
import com.larus.uaigc.avatar.instruction.t;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderV2Binding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
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
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.image.instruction.ImageListSelectorWithMoreTemplateWidget$requestTemplateList$1", f = "ImageListSelectorWithMoreTemplateWidget.kt", i = {}, l = {401}, m = "invokeSuspend", n = {}, s = {})
final class ImageListSelectorWithMoreTemplateWidget$requestTemplateList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageListSelectorWithMoreTemplateWidget this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.image.instruction.ImageListSelectorWithMoreTemplateWidget$requestTemplateList$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/platform/api/creation/CreationFeedCacheEntity;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.image.instruction.ImageListSelectorWithMoreTemplateWidget$requestTemplateList$1$1", f = "ImageListSelectorWithMoreTemplateWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CreationFeedCacheEntity, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ImageListSelectorWithMoreTemplateWidget this$0;

        public AnonymousClass1(ImageListSelectorWithMoreTemplateWidget r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public final Object invoke(CreationFeedCacheEntity r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CreationFeedCacheEntity) r1, (Continuation) r2);
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [android.view.ViewGroup, com.larus.uaigc.image.instruction.ImageListSelectorWithMoreTemplateWidget] */
        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L53;
            ResultKt.throwOnFailure(r7);
            boolean r1 = false;
            CreationFeedCacheEntity r8 = e0.a.b1("2", false);
            FrameLayout r0 = null;
            if (r8 == null) goto L7;
            final zp9.c r9 = r8.getListData();
        L8:
            if (r9 == null) goto L18;
            List<UserCreation> r2 = r9.c();
            if (r2 == null) goto L18;
            UserCreation r3 = (UserCreation) CollectionsKt.firstOrNull(r2);
            if (r3 == null) goto L18;
            UserCreationContent r4 = r3.e;
            if (r4 == null) goto L18;
            UserCreationImage r5 = r4.a;
            if (r5 == null) goto L18;
            ImageInfo r6 = r5.a;
        L19:
            FLogger r10 = FLogger.a;
            StringBuilder r11 = new StringBuilder("v2 requestTemplateList firstCoverUrl is null ? ");
            if (r6 != null) goto L22;
            r1 = true;
        L22:
            r11.append(r1);
            r10.i("ImageListSelectorWithMoreTemplateWidget", r11.toString());
            LarusItemActionbarImageTemplateCoverHolderV2Binding r12 = this.this$0.j;
            if (r12 == null) goto L31;
            if (r6 == null) goto L29;
            Image r13 = r6.b;
            if (r13 == null) goto L29;
            String r14 = r13.a;
            if (r14 == null) goto L29;
        L30:
            t.a(r12, r14);
        L29:
            r14 = "";
        L31:
            n r15 = ImageListSelectorWithMoreTemplateWidget.o6(this.this$0);
            if (r15 == null) goto L47;
            List r16 = r15.d;
            if (r16 == null) goto L47;
            w r17 = (w) CollectionsKt.firstOrNull(r16);
            if (r17 == null) goto L47;
            ?? r18 = this.this$0;
            String r19 = r17.b;
            if (r19 == null) goto L47;
            if (TextUtils.isEmpty(r19) == true) goto L44;
            LarusItemActionbarImageTemplateCoverHolderV2Binding r20 = r18.j;
            if (r20 == null) goto L47;
            t.b(r20, r19);
            goto L47
        L44:
            LarusItemActionbarImageTemplateCoverHolderV2Binding r21 = r18.j;
            if (r21 == null) goto L47;
            t.b(r21, r18.getResources().getString(2131906382));
        L47:
            final ImageListSelectorWithMoreTemplateWidget r22 = this.this$0;
            LarusItemActionbarImageTemplateCoverHolderV2Binding r23 = r22.j;
            if (r23 == null) goto L50;
            r0 = r23.a;
        L50:
            e1.d(r0, new i(r9, r22));
            return Unit.INSTANCE;
        L18:
            r6 = null;
            goto L19
        L7:
            r9 = null;
            goto L8
        L53:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ImageListSelectorWithMoreTemplateWidget$requestTemplateList$1(ImageListSelectorWithMoreTemplateWidget r1, Continuation<? super ImageListSelectorWithMoreTemplateWidget$requestTemplateList$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageListSelectorWithMoreTemplateWidget$requestTemplateList$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        i1<CreationFeedCacheEntity> r7 = e0.a.i1("2");
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
