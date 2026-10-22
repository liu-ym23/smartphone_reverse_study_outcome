package com.larus.uaigc.createpage.component.instruction;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.CreationPublishExtra;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$observerInstructionEditor$10", f = "CreationEditorComponent.kt", i = {}, l = {2948}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$observerInstructionEditor$10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationEditorComponent a;

        public a(CreationEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r11, Continuation r12) {
            com.larus.bmhome.view.actionbar.edit.m r13 = (com.larus.bmhome.view.actionbar.edit.m) r11;
            if (r13 == null) goto L63;
            CreationEditorComponent r14 = this.a;
            int r0 = CreationEditorComponent.g2;
            r14.getClass();
            TemplateInfo$TemplateInfo r1 = r13.a;
            String r2 = r1.c;
            String r3 = "";
            if (r2 != null) goto L7;
            r2 = "";
        L7:
            r14.k0 = r2;
            UserCreation r4 = r1.j;
            boolean r5 = false;
            if (r4 != null) goto L10;
            r3 = null;
        L37:
            Uri r15 = r13.b;
            if (r15 == null) goto L40;
            String r16 = r15.toString();
        L42:
            if (r16 != null) goto L44;
        L47:
            boolean r17 = true;
        L48:
            if (r17 == true) goto L50;
        L52:
            boolean r18 = false;
        L53:
            boolean r19 = !r18;
            FLogger.a.i("CreationEditorComponent", "showIme:" + r19);
            ICoreInputAbility r6 = r14.a4();
            if (r6 == null) goto L63;
            r6.tw(r14.k0, r19);
            if (r14.k0.length() <= 0) goto L58;
            r5 = true;
        L58:
            if (r5 == false) goto L60;
            r14.j6(3);
        L60:
            if (r19 == false) goto L63;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), null, null, new CreationEditorComponent$onImageTemplateSelected$1$1(r14, null), 3, null);
            goto L63
        L50:
            if (com.larus.utils.o0.d(r3) == false) goto L52;
            r18 = true;
            goto L53
        L44:
            if (r16.length() == 0) goto L47;
            r17 = false;
            goto L48
        L40:
            r16 = null;
            goto L42
        L10:
            CreationPublishExtra r7 = r4.p;
            if (r7 == null) goto L13;
            boolean r8 = Intrinsics.areEqual(r7.b, Boolean.FALSE);
        L14:
            if (r8 == false) goto L24;
            UserCreationRefContent r9 = r4.o;
            if (r9 == null) goto L33;
            List<ImageInfo> r10 = r9.a();
            if (r10 == null) goto L33;
            ImageInfo r20 = (ImageInfo) CollectionsKt.getOrNull(r10, 0);
            if (r20 == null) goto L33;
            Image r21 = r20.h;
            if (r21 == null) goto L33;
            String r22 = r21.a;
        L34:
            if (r22 == null) goto L37;
            r3 = r22;
        L33:
            r22 = null;
            goto L34
        L24:
            UserCreationRefContent r23 = r4.o;
            if (r23 == null) goto L33;
            List<ImageInfo> r24 = r23.a();
            if (r24 == null) goto L33;
            ImageInfo r25 = (ImageInfo) CollectionsKt.getOrNull(r24, 0);
            if (r25 == null) goto L33;
            Image r26 = r25.c;
            if (r26 == null) goto L33;
            r22 = r26.a;
            goto L34
        L13:
            r8 = false;
        L63:
            return Unit.INSTANCE;
        }
    }

    public CreationEditorComponent$observerInstructionEditor$10(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$observerInstructionEditor$10> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$observerInstructionEditor$10(this.this$0, r3);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CreationEditorComponent r6 = this.this$0;
        int r2 = CreationEditorComponent.g2;
        kotlinx.coroutines.flow.d1 r7 = r6.i4().getInstructionPhotoTemplatePrompt();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
