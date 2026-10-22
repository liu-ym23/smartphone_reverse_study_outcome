package com.larus.uaigc.createpage.component.helper;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.service.g;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.helper.VideoEditorPickPhotoHelper$initObservers$1", f = "VideoEditorPickPhotoHelper.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
final class VideoEditorPickPhotoHelper$initObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ f this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.helper.VideoEditorPickPhotoHelper$initObservers$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.helper.VideoEditorPickPhotoHelper$initObservers$1$1", f = "VideoEditorPickPhotoHelper.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ f this$0;

        /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.helper.VideoEditorPickPhotoHelper$initObservers$1$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ f a;

            public a(f r1) {
                this.a = r1;
            }

            public final Object emit(Object r21, Continuation r22) {
                b r0 = (b) r21;
                f r1 = this.a;
                Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L27
                k2 r3 = k2.a;     // Catch: Throwable -> L27
                String r5 = null;
                if (r3.x() == false) goto L22;
                FLogger.a.i("VideoEditorPickPhotoHelper", "use SDK album, start multiPick");     // Catch: Throwable -> L27
                Map<String, ? extends Object> r4 = r1.f;     // Catch: Throwable -> L27
                if (r4 == null) goto L9;
                Object r6 = r4.get("chat_type");     // Catch: Throwable -> L27
            L11:
                if ((r6 instanceof String) == false) goto L13;
                String r10 = (String) r6;     // Catch: Throwable -> L27
            L14:
                Map<String, ? extends Object> r7 = r1.f;     // Catch: Throwable -> L27
                if (r7 == null) goto L17;
                Object r8 = r7.get("bot_id");     // Catch: Throwable -> L27
            L19:
                if ((r8 instanceof String) == false) goto L21;
                r5 = (String) r8;     // Catch: Throwable -> L27
            L21:
                r3.p(new kq9.e(r5, null, 0, r10, null, "click_video_edit_action_bar", null, null, null, null, null, null, 4054));     // Catch: Throwable -> L27
                Context r9 = r1.a.getContext();     // Catch: Throwable -> L27
                ActivityResultLauncher<Intent> r11 = r1.j;     // Catch: Throwable -> L27
                AlbumSettingConfig.a r12 = new AlbumSettingConfig.a();     // Catch: Throwable -> L27
                r12.d = r1.c;     // Catch: Throwable -> L27
                r12.i = true;     // Catch: Throwable -> L27
                r12.r = true;     // Catch: Throwable -> L27
                r12.s = true;     // Catch: Throwable -> L27
                r12.t = r1.d;     // Catch: Throwable -> L27
                r12.f = "click_video_edit_action_bar";     // Catch: Throwable -> L27
                r12.v = r1.e;     // Catch: Throwable -> L27
                r12.c = true;     // Catch: Throwable -> L27
                r12.y = true;     // Catch: Throwable -> L27
                r3.h(r9, r11, r12.a());     // Catch: Throwable -> L27
                r5 = Unit.INSTANCE;     // Catch: Throwable -> L27
            L25:
                Object r13 = Result.constructor-impl(r5);     // Catch: Throwable -> L27
            L29:
                Throwable r14 = Result.exceptionOrNull-impl(r13);
                if (r14 == null) goto L33;
                r14.printStackTrace();
                g.a.ensureNotReachHere(r14);
            L33:
                return Unit.INSTANCE;
            L17:
                r8 = null;
                goto L19
            L13:
                r10 = null;
                goto L14
            L9:
                r6 = null;
                goto L11
            L22:
                FLogger.a.i("VideoEditorPickPhotoHelper", "use system album, start multiPick");     // Catch: Throwable -> L27
                ActivityResultLauncher<String> r15 = r1.i;     // Catch: Throwable -> L27
                if (r15 == null) goto L25;
                r15.launch("video/*");     // Catch: Throwable -> L27
                r5 = Unit.INSTANCE;     // Catch: Throwable -> L27
            L27:
                th = move-exception;
                Result.Companion r16 = Result.Companion;
                r13 = Result.constructor-impl(ResultKt.createFailure(th));
                goto L29
            }
        }

        public AnonymousClass1(f r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
            f r6 = this.this$0;
            a1 r2 = r6.h;
            a r3 = new a(r6);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public VideoEditorPickPhotoHelper$initObservers$1(f r1, Continuation<? super VideoEditorPickPhotoHelper$initObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VideoEditorPickPhotoHelper$initObservers$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        f r8 = this.this$0;
        Fragment r2 = r8.a;
        Lifecycle.State r3 = Lifecycle.State.STARTED;
        AnonymousClass1 r4 = new AnonymousClass1(r8, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.b(r2, r3, r4, this) != r0) goto L12;
        return r0;
    }
}
