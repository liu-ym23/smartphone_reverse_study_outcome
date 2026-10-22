package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.app.Application;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$handleAlbumMultiSelectionForVideoUpload$1", f = "MultiAttachmentSelectorComponent.kt", i = {0}, l = {848, 854, 856}, m = "invokeSuspend", n = {"resourceConfig"}, s = {"L$0"})
final class MultiAttachmentSelectorComponent$handleAlbumMultiSelectionForVideoUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ xp9.i $multiSelectItem;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$handleAlbumMultiSelectionForVideoUpload$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$handleAlbumMultiSelectionForVideoUpload$1$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ry9.a $resourceConfig;
        int label;
        final /* synthetic */ MultiAttachmentSelectorComponent this$0;

        public AnonymousClass1(MultiAttachmentSelectorComponent r1, ry9.a r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$resourceConfig = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$resourceConfig, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L31;
            ResultKt.throwOnFailure(r10);
            Function1<? super ry9.a, Unit> r11 = this.this$0.B;
            if (r11 == null) goto L7;
            r11.invoke(this.$resourceConfig);
        L7:
            MultiAttachmentSelectorComponent r12 = this.this$0;
            ry9.a r0 = this.$resourceConfig;
            r12.getClass();
            ArrayList<ResourceItemBean> r1 = r0.a;
            if ((r1 instanceof Collection) == true) goto L10;
        L12:
            Iterator<T> r2 = r1.iterator();
        L14:
            if (r2.hasNext() == false) goto L21;
            if (((ResourceItemBean) r2.next()).getResourceType() != ResourceType.VIDEO) goto L18;
            boolean r3 = true;
        L19:
            if (r3 == false) goto L14;
            boolean r4 = false;
        L22:
            if (r4 == true) goto L29;
            if (((Keva) r12.l.getValue()).getBoolean("video_reference_quota_notice_shown", false) == true) goto L29;
            ((Keva) r12.l.getValue()).storeBoolean("video_reference_quota_notice_shown", true);
            t19.s r5 = t19.s.a;
            AppHost.Companion r13 = AppHost.a;
            Application r6 = r13.getApplication();
            int r7 = mz9.a.a;
            t19.s.j(r5, r6, r13.getApplication().getString(2131899491), null, false, 28);
        L29:
            return Unit.INSTANCE;
        L18:
            r3 = false;
        L21:
            r4 = true;
            goto L22
        L10:
            if (r1.isEmpty() == false) goto L12;
        L31:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$handleAlbumMultiSelectionForVideoUpload$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$handleAlbumMultiSelectionForVideoUpload$1$3", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MultiAttachmentSelectorComponent this$0;

        public AnonymousClass3(MultiAttachmentSelectorComponent r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L29;
            ResultKt.throwOnFailure(r9);
            MultiAttachmentSelectorComponent r10 = this.this$0;
            if (r10.R == null) goto L15;
            ICoreInputAbility r11 = (ICoreInputAbility) r10.p.getValue();
            if (r11 == null) goto L9;
            r11.g2(1, true);
        L9:
            ICoreInputAbility r0 = MultiAttachmentSelectorComponent.U2(this.this$0);
            if (r0 == null) goto L12;
            ICoreInputAbility.b.d(r0, String.valueOf(this.this$0.R), false, false, null, null, false, 62);
        L12:
            py9.a r12 = (py9.a) this.this$0.q.getValue();
            if (r12 == null) goto L15;
            r12.Bl("tryShowUpdateDialog");
        L15:
            Function0<Unit> r13 = this.this$0.U;
            if (r13 == null) goto L18;
            r13.invoke();
        L18:
            MultiAttachmentSelectorComponent r14 = this.this$0;
            r14.R = null;
            r14.U = null;
            ys8.a r15 = r14.d4();
            if (r15 == null) goto L21;
            r15.c00(this.this$0.S);
        L21:
            this.this$0.S = -1;
            if (com.larus.platform.exp.g.a() == false) goto L27;
            ICoreInputAbility r16 = MultiAttachmentSelectorComponent.U2(this.this$0);
            if (r16 == null) goto L27;
            r16.C1(false, false, "multimodal_input");
        L27:
            return Unit.INSTANCE;
        L29:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MultiAttachmentSelectorComponent$handleAlbumMultiSelectionForVideoUpload$1(xp9.i r1, MultiAttachmentSelectorComponent r2, Continuation<? super MultiAttachmentSelectorComponent$handleAlbumMultiSelectionForVideoUpload$1> r3) {
        this.$multiSelectItem = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MultiAttachmentSelectorComponent$handleAlbumMultiSelectionForVideoUpload$1(this.$multiSelectItem, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r9);
    L32:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Iterator r2 = (Iterator) this.L$1;
        MultiAttachmentSelectorComponent r4 = (MultiAttachmentSelectorComponent) this.L$0;
        ResultKt.throwOnFailure(r9);
    L24:
        if (r2.hasNext() == false) goto L28;
        ResourceItemBean r6 = (ResourceItemBean) r2.next();
        this.L$0 = r4;
        this.L$1 = r2;
        this.label = 2;
        if (r4.BM(r6, this) != r0) goto L24;
        return r0;
    L28:
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        AnonymousClass3 r5 = new AnonymousClass3(this.this$0, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        if (BuildersKt.withContext(r3, r5, this) != r0) goto L32;
        return r0;
    L11:
        ry9.a r7 = (ry9.a) this.L$0;
        ResultKt.throwOnFailure(r9);
    L21:
        ArrayList<ResourceItemBean> r10 = r7.a;
        MultiAttachmentSelectorComponent r8 = this.this$0;
        r4 = r8;
        r2 = r10.iterator();
        goto L24
    L12:
        ResultKt.throwOnFailure(r9);
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("handleAlbumMultiSelectionForVideoUpload, selected_count=");
        xp9.i r13 = this.$multiSelectItem;
        List<AlbumSelectItem> r14 = r13.c;
        if (r14 == null) goto L15;
        int r15 = r14.size();
    L16:
        r12.append(r15);
        r11.i("MultiAttachmentSelector", r12.toString());
        r7 = MultiAttachmentSelectorComponent.L2(this.this$0, this.$multiSelectItem);     // Catch: Throwable -> L33
        MultiAttachmentSelectorComponent.P2(this.this$0);
        MainCoroutineDispatcher r16 = Dispatchers.getMain();
        AnonymousClass1 r17 = new AnonymousClass1(this.this$0, r7, null);
        this.L$0 = r7;
        this.label = 1;
        if (BuildersKt.withContext(r16, r17, this) != r0) goto L21;
        return r0;
    L33:
        th = move-exception;
        MultiAttachmentSelectorComponent.P2(this.this$0);
        throw th;
    L15:
        r15 = r13.a.size();
        goto L16
    }
}
