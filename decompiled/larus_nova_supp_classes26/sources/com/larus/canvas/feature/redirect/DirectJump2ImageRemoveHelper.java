package com.larus.canvas.feature.redirect;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.canvas.feature.CreationCanvasActivity;
import com.larus.canvas.feature.component.logic.helper.g;
import com.larus.canvas.service.bean.IImageInfo;
import com.larus.canvas.service.bean.NetworkImage;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import java.io.File;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import xy9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class DirectJump2ImageRemoveHelper {
    public static final DirectJump2ImageRemoveHelper a = null;

    public static final class a implements xy9.a {
        public final /* synthetic */ b a;
        public final /* synthetic */ AppCompatActivity b;

        public final void closePage() {
            this.a.dismiss();
        }

        public final void a(Bundle r3) {
            Intrinsics.checkNotNullParameter(r3, "bundle");
            ImageEditDataWithMask r4 = r3.getSerializable("image_edit_data.with_mask");
            if ((r4 instanceof ImageEditDataWithMask) == false) goto L5;
            ImageEditDataWithMask r5 = r4;
        L6:
            if (r5 == null) goto L10;
            ImageRemoveDialogResultReceiverViewModel r0 = (ImageRemoveDialogResultReceiverViewModel) new ViewModelProvider(this.b).get(ImageRemoveDialogResultReceiverViewModel.class);
            if (r0 == null) goto L10;
            r0.onReceiveImageMaskResult(r5);
        L10:
            this.a.dismiss();
            return;
        L5:
            r5 = null;
            goto L6
        }

        public a(b r1, AppCompatActivity r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = new DirectJump2ImageRemoveHelper();
    }

    public DirectJump2ImageRemoveHelper() {
    }

    public final Object a(AppCompatActivity r8, MediaAttachment r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$3) == false) goto L7;
        DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$3 r0 = (DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$3) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L21
    L19:
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L28;
        FLogger.a.e("DirectJump2ImageRemoveHelper", "show image remove dialog fail,info is " + r13.getMessage());
    L28:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        Bundle r14 = f.c(new Pair[]{TuplesKt.to("media_attachment", r9), TuplesKt.to("ignore_image_size_check", Boxing.boxBoolean(true))});
        b r15 = IUgcAIGCService.a.E();
        r15.K00(r14, new a(r15, r8), 2131954324, 2131954377);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L21
        FragmentManager r17 = r8.getSupportFragmentManager();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L21
        r15.show(r17, "ImageRemoveDialogFragment");     // Catch: Throwable -> L21
        FLogger.a.i("DirectJump2ImageRemoveHelper", "canvas init show image remove dialog success");     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        if (DelayKt.delay(500, r0) != r2) goto L19;
        return r2;
    L21:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$3(this, r10);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, androidx.appcompat.app.AppCompatActivity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.appcompat.app.AppCompatActivity] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r5v14, types: [com.larus.canvas.feature.redirect.DirectJump2ImageRemoveHelper] */
    /* JADX WARN: Type inference failed for: r5v26, types: [com.larus.canvas.feature.redirect.DirectJump2ImageRemoveHelper] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object b(CreationCanvasActivity r27, Intent r28, Continuation r29) {
        ?? r0 = r27;
        if ((r29 instanceof DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$1) == false) goto L7;
        DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$1 r2 = (DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$1) r29;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        Long r9 = null;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 == 3) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        NetworkImage r6 = (NetworkImage) r2.L$1;
        AppCompatActivity r7 = (AppCompatActivity) r2.L$0;
        ResultKt.throwOnFailure(r1);
        NetworkImage r8 = r6;
        ?? r10 = r7;
        Object r11 = r1;
    L53:
        File r12 = (File) r11;
        if (r12 == null) goto L67;
        String r13 = r8.a;
        String r14 = r8.b;
        String r15 = y0.k(Uri.fromFile(r12));
        Integer r16 = r8.c;
        if (r16 == null) goto L58;
        Long r17 = Boxing.boxLong(r16.intValue());
    L59:
        Integer r18 = r8.d;
        if (r18 == null) goto L62;
        Long r19 = Boxing.boxLong(r18.intValue());
    L63:
        MediaAttachment r20 = new MediaAttachment(r14, r13, new ImageUploadInfo(r17, r19), null, r15, null, null, null, null, null, null, null, 4072, null);
        ?? r21 = a;
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 3;
        if (r21.a(r10, r20, r2) != r4) goto L67;
        return r4;
    L62:
        r19 = null;
        goto L63
    L58:
        r17 = null;
    L67:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r1);
        goto L67
    L18:
        ResultKt.throwOnFailure(r1);
        Bundle r22 = r28.getExtras();
        if (r22 == null) goto L67;
        if (r22.getInt("ai_beautify_id") != 3) goto L23;
        Bundle r23 = r28.getExtras();
        if (r23 == null) goto L27;
        IImageInfo r24 = (IImageInfo) r23.getParcelable("init_image_info");
    L29:
        if ((r24 instanceof NetworkImage) == false) goto L31;
        r8 = (NetworkImage) r24;
    L32:
        if (r8 == null) goto L67;
        if (o0.d(r8.e) == false) goto L49;
        String r110 = r8.a;
        String r111 = r8.b;
        String r25 = r8.e;
        if (r25 != null) goto L38;
        r25 = "";
    L38:
        String r112 = r25;
        Integer r26 = r8.c;
        if (r26 == null) goto L41;
        Long r30 = Boxing.boxLong(r26.intValue());
    L42:
        Integer r31 = r8.d;
        if (r31 == null) goto L45;
        r9 = Boxing.boxLong(r31.intValue());
    L45:
        MediaAttachment r32 = new MediaAttachment(r111, r110, new ImageUploadInfo(r30, r9), null, r112, null, null, null, null, null, null, null, 4072, null);
        ?? r33 = a;
        r2.label = 1;
        if (r33.a(r0, r32, r2) != r4) goto L67;
        return r4;
    L41:
        r30 = null;
        goto L42
    L49:
        if (o0.d(r8.b) == false) goto L67;
        String r34 = r8.b;
        r2.L$0 = r0;
        r2.L$1 = r8;
        r2.label = 2;
        r11 = g.b(r0, r34, r2);
        r10 = r0;
        if (r11 != r4) goto L53;
        return r4;
    L31:
        r8 = null;
        goto L32
    L27:
        r24 = null;
        goto L29
    L23:
        return Unit.INSTANCE;
    L7:
        r2 = new DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$1(this, r29);
        goto L8
    }
}
