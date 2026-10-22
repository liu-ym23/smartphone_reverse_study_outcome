package com.bytedance.ai.resource;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AppletResourceTool$loadImage$2$2", f = "AppletResourceTool.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppletResourceTool$loadImage$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AtomicReference<kotlinx.coroutines.i<Bitmap>> $contRef;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $url;
    int label;

    public static final class a implements Function1<IIvyAIPackageResourceService.a, Unit> {
        public final /* synthetic */ AtomicReference<kotlinx.coroutines.i<Bitmap>> a;

        public a(AtomicReference<kotlinx.coroutines.i<Bitmap>> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10) {
            IIvyAIPackageResourceService.a r11 = (IIvyAIPackageResourceService.a) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            kotlinx.coroutines.i<Bitmap> r0 = this.a.getAndSet(null);
            if (r0 == null) goto L14;
            if (r0.isActive() == false) goto L14;
            IIvyAIPackageResourceService.a.a r12 = r11.e;
            if (r12 == null) goto L12;
            byte[] r13 = r12.a;
            if (r13 == null) goto L12;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(BitmapFactory.decodeByteArray(r13, 0, r13.length)));
        L12:
            r0.resumeWith(Result.constructor-impl(null));
        L14:
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function1<Throwable, Unit> {
        public final /* synthetic */ AtomicReference<kotlinx.coroutines.i<Bitmap>> a;

        public b(AtomicReference<kotlinx.coroutines.i<Bitmap>> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10) {
            Throwable r11 = (Throwable) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            com.bytedance.ai.utils.g.a.e("AppletResourceLoader", "loadImage error: " + r11.getMessage());
            kotlinx.coroutines.i<Bitmap> r12 = this.a.getAndSet(null);
            if (r12 == null) goto L8;
            if (r12.isActive() == false) goto L8;
            r12.resumeWith(Result.constructor-impl(null));
        L8:
            return Unit.INSTANCE;
        }
    }

    public AppletResourceTool$loadImage$2$2(String r1, String r10, AtomicReference<kotlinx.coroutines.i<Bitmap>> r11, Continuation<? super AppletResourceTool$loadImage$2$2> r12) {
        this.$sessionId = r1;
        this.$url = r10;
        this.$contRef = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletResourceTool$loadImage$2$2(this.$sessionId, this.$url, this.$contRef, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        AppletResourceTool r11 = AppletResourceTool.a;
        String r0 = this.$sessionId;
        String r1 = this.$url;
        AtomicReference<kotlinx.coroutines.i<Bitmap>> r12 = this.$contRef;
        a r13 = new a(r12);
        b r14 = new b(r12);
        r11.getClass();
        AppletResourceTool.q(r0, r1, r13, r14, false);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
