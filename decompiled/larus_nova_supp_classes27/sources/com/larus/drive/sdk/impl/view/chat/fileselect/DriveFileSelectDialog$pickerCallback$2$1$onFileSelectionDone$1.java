package com.larus.drive.sdk.impl.view.chat.fileselect;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.model.chat.UploadFilePolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$pickerCallback$2$1$onFileSelectionDone$1", f = "DriveFileSelectDialog.kt", i = {0, 0, 0, 0}, l = {247}, m = "invokeSuspend", n = {"hasOverSizePic", "hasInvalidFileSize", "destination$iv$iv", "file"}, s = {"L$0", "L$1", "L$3", "L$5"})
public final class DriveFileSelectDialog$pickerCallback$2$1$onFileSelectionDone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DriveFileItem> $fileList;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ DriveFileSelectDialog this$0;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$pickerCallback$2$1$onFileSelectionDone$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$pickerCallback$2$1$onFileSelectionDone$1$1", f = "DriveFileSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<DriveFileItem> $handleList;
        final /* synthetic */ Ref.BooleanRef $hasInvalidFileSize;
        final /* synthetic */ Ref.BooleanRef $hasOverSizePic;
        int label;
        final /* synthetic */ DriveFileSelectDialog this$0;

        public AnonymousClass1(Ref.BooleanRef r1, DriveFileSelectDialog r2, Ref.BooleanRef r3, List<DriveFileItem> r4, Continuation<? super AnonymousClass1> r5) {
            this.$hasOverSizePic = r1;
            this.this$0 = r2;
            this.$hasInvalidFileSize = r3;
            this.$handleList = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$hasOverSizePic, this.this$0, this.$hasInvalidFileSize, this.$handleList, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L26;
            ResultKt.throwOnFailure(r11);
            if (this.$hasOverSizePic.element == false) goto L12;
            Context r12 = this.this$0.getContext();
            if (r12 == null) goto L12;
            StringBuilder r5 = new StringBuilder();
            DriveFileSelectDialog r6 = this.this$0;
            int r7 = DriveFileSelectDialog.t;
            long r8 = 1024;
            r5.append((((Number) r6.e.getValue()).longValue() / r8) / r8);
            r5.append("MB");
            String r13 = r12.getString(2131907896, new Object[]{r5.toString()});
            if (r13 == null) goto L12;
            DriveFileSelectDialog r4 = this.this$0;
            t19.s r9 = t19.s.a;
            Context r10 = r4.getContext();
            r9.getClass();
            t19.s.t(r10, r13);
        L12:
            if (this.$hasInvalidFileSize.element == false) goto L19;
            Context r14 = this.this$0.getContext();
            if (r14 == null) goto L19;
            StringBuilder r15 = new StringBuilder();
            long r16 = 1024;
            r15.append((UploadFilePolicy.d() / r16) / r16);
            r15.append("MB");
            String r17 = r14.getString(2131907893, new Object[]{r15.toString()});
            if (r17 == null) goto L19;
            DriveFileSelectDialog r0 = this.this$0;
            t19.s r1 = t19.s.a;
            Context r2 = r0.getContext();
            r1.getClass();
            t19.s.t(r2, r17);
        L19:
            if ((!this.$handleList.isEmpty()) == false) goto L24;
            Function1<? super List<DriveFileItem>, Unit> r18 = this.this$0.s;
            if (r18 == null) goto L24;
            r18.invoke(this.$handleList);
        L24:
            return Unit.INSTANCE;
        L26:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DriveFileSelectDialog$pickerCallback$2$1$onFileSelectionDone$1(List<DriveFileItem> r1, DriveFileSelectDialog r2, Continuation<? super DriveFileSelectDialog$pickerCallback$2$1$onFileSelectionDone$1> r3) {
        this.$fileList = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DriveFileSelectDialog$pickerCallback$2$1$onFileSelectionDone$1(this.$fileList, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x006f -> B:18:0x008f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0086 -> B:17:0x0089). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        LifecycleCoroutineScope r3 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        DriveFileItem r4 = (DriveFileItem) this.L$5;
        Iterator r5 = (Iterator) this.L$4;
        Collection r6 = (Collection) this.L$3;
        DriveFileSelectDialog r7 = (DriveFileSelectDialog) this.L$2;
        Ref.BooleanRef r8 = (Ref.BooleanRef) this.L$1;
        Ref.BooleanRef r9 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r20);
        Object r10 = r20;
        Ref.BooleanRef r11 = r8;
        DriveFileItem r12 = r4;
        DriveFileSelectDialog$pickerCallback$2$1$onFileSelectionDone$1 r13 = this;
    L17:
        long r14 = ((Number) r10).longValue();
    L18:
        Long r15 = Boxing.boxLong(r14);
        int r16 = DriveFileSelectDialog.t;
        com.larus.platform.api.u r17 = r7.aa0(r12, r15);
        if (r7.da0(r17, r14) != null) goto L21;
        DriveFileItem r18 = DriveFileSelectDialog.ea0(r12, r14);
    L26:
        if (r18 == null) goto L10;
        r6.add(r18);
    L10:
        if (r5.hasNext() == false) goto L28;
        r12 = (DriveFileItem) r5.next();
        int r110 = DriveFileSelectDialog.t;
        r7.getClass();
        if (DriveFileSelectDialog.X90(r12) == false) goto L14;
        r14 = r12.e();
        goto L18
    L14:
        r13.L$0 = r9;
        r13.L$1 = r11;
        r13.L$2 = r7;
        r13.L$3 = r6;
        r13.L$4 = r5;
        r13.L$5 = r12;
        r13.label = 1;
        r10 = DriveFileSelectDialog.S90(r7, r12, r13);
        if (r10 != r1) goto L17;
        return r1;
    L28:
        List r111 = (List) r6;
        DriveFileSelectDialog r21 = r13.this$0;
        int r22 = DriveFileSelectDialog.t;
        FragmentActivity r23 = r21.getActivity();
        if (r23 == null) goto L31;
        r3 = LifecycleOwnerKt.getLifecycleScope(r23);
    L31:
        if (r3 == null) goto L34;
        BuildersKt.launch$default(r3, Dispatchers.getMain(), null, new AnonymousClass1(r9, r13.this$0, r11, r111, null), 2, null);
    L34:
        return Unit.INSTANCE;
    L21:
        if (r17.f != FlowDriveFileType.IMAGE) goto L23;
        r9.element = true;
    L24:
        r18 = null;
        goto L26
    L23:
        r11.element = true;
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        Ref.BooleanRef r24 = new Ref.BooleanRef();
        Ref.BooleanRef r25 = new Ref.BooleanRef();
        List<DriveFileItem> r26 = this.$fileList;
        r7 = this.this$0;
        ArrayList r27 = new ArrayList();
        r9 = r24;
        r11 = r25;
        r5 = r26.iterator();
        r6 = r27;
        r13 = this;
        goto L10
    }
}
