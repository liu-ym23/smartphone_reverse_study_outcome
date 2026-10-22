package com.ss.android.lark.keyboard.biz.send.inject;

import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.DoubaoFileInfo;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UpLinkState;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.send.inject.SendInnerEndPlugin$initAttachmentStateFlow$1", f = "SendInnerEndPlugin.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
final class SendInnerEndPlugin$initAttachmentStateFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SendInnerEndPlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ SendInnerEndPlugin a;

        public a(SendInnerEndPlugin r1) {
            this.a = r1;
        }

        public final Object emit(Object r13, Continuation r14) {
            List r15 = (List) r13;
            Log.d("SendInnerEndPlugin", "uplinkFileEntity size : " + r15.size());
            SendInnerEndPlugin r16 = this.a;
            SendInnerEndPlugin.a r1 = SendInnerEndPlugin.q;
            r16.getClass();
            if (r15.isEmpty() == true) goto L36;
            Iterator<T> r17 = r15.iterator();
        L7:
            if (r17.hasNext() == false) goto L36;
            UplinkFileEntity r3 = (UplinkFileEntity) r17.next();
            String r2 = "";
            if (r3.getDoubaoFileInfo() != null) goto L10;
            String r4 = r16.a.c.getId();
            if (r4 == null) goto L7;
            String r5 = r3.getFileIdentifier();
            if (r5 != null) goto L25;
            String r6 = "";
        L27:
            if (r6.length() != 0) goto L29;
            boolean r7 = true;
        L30:
            if (r7 == true) goto L31;
            if (r16.g.add(r6) == false) goto L7;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r16.a.a), null, null, new SendInnerEndPlugin$tryUploadNewEntities$1$1(r16, r3, r4, r6, null), 3, null);
            goto L7
        L31:
            Log.e("SendInnerEndPlugin", "tryUploadNewEntities: uploadId is empty.");
            goto L7
        L29:
            r7 = false;
            goto L30
        L25:
            r6 = r5;
            goto L27
        L10:
            StringBuilder r8 = new StringBuilder("[DoubaoFile] skip pre-upload, attachment=");
            r8.append(r3.getFileIdentifier());
            r8.append(", storageType=");
            DoubaoFileInfo r9 = r3.getDoubaoFileInfo();
            if (r9 == null) goto L13;
            Integer r10 = r9.getStorageType();
        L14:
            r8.append(r10);
            Log.i("SendInnerEndPlugin", r8.toString());
            LinkedHashSet<String> r11 = r16.h;
            String r12 = r3.getFileIdentifier();
            if (r12 == null) goto L18;
            r2 = r12;
        L18:
            r11.remove(r2);
            r3.setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
            r3.setUpLinkProcess(100);
            goto L7
        L13:
            r10 = null;
        L36:
            return Unit.INSTANCE;
        }
    }

    public SendInnerEndPlugin$initAttachmentStateFlow$1(SendInnerEndPlugin r1, Continuation<? super SendInnerEndPlugin$initAttachmentStateFlow$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SendInnerEndPlugin$initAttachmentStateFlow$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L14:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        i1 r6 = (i1) this.this$0.n.getValue();
        if (r6 == null) goto L16;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L14;
        return r0;
    L16:
        return Unit.INSTANCE;
    }
}
