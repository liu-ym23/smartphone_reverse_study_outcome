package obric.flow.overlay;

import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import com.obric.flow.cardlistpage.R$id;
import com.obric.flow.cardlistpage.R$layout;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.p;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.z;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "obric.flow.overlay.AssistantOverlayService$AssistantBinder$setLauncherWindowToken$1$1", f = "AssistantOverlayService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AssistantOverlayService$AssistantBinder$setLauncherWindowToken$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ AssistantOverlayService $service;
    final /* synthetic */ IBinder $t;
    int label;

    public AssistantOverlayService$AssistantBinder$setLauncherWindowToken$1$1(AssistantOverlayService r5, IBinder r10, Continuation<? super AssistantOverlayService$AssistantBinder$setLauncherWindowToken$1$1> r11) {
        this.$service = r5;
        this.$t = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r5) {
        return new AssistantOverlayService$AssistantBinder$setLauncherWindowToken$1$1(this.$service, this.$t, r5);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r5) {
        return invoke2(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L89;
        ResultKt.throwOnFailure(r13);
        final AssistantOverlayService r14 = this.$service;
        IBinder r12 = this.$t;
        if (r14.f20529b == null) goto L28;
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("initOverlayWindow: Re-binding with new token. Removing old view.", "msg");
        org.koin.core.a r10 = su.a.f22013b;
        if (r10 == null) goto L27;
        ((ju.b) r10.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("AssistantOverlayService", "initOverlayWindow: Re-binding with new token. Removing old view.");
        CardFeedLayout r5 = r14.f20529b;     // Catch: Exception -> L17
        if (r5 == null) goto L14;
        p r11 = r5.G;     // Catch: Exception -> L17
        if (r11 == null) goto L14;
        r11.f(com.obric.flow.cardlistpage.ui.component.overlayanimator.a.f11644a);     // Catch: Exception -> L17
    L14:
        WindowManager r15 = r14.f20528a;     // Catch: Exception -> L17
        if (r15 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("windowManager");     // Catch: Exception -> L17
        r15 = null;
    L19:
        r15.removeViewImmediate(r14.f20529b);     // Catch: Exception -> L17
        r14.f20529b = null;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("Remove old view failed", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r16 = su.a.f22013b;
        if (r16 == null) goto L25;
        ((ju.b) r16.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("AssistantOverlayService", "Remove old view failed", e);
        goto L28
    L25:
        throw new IllegalStateException("KoinApplication has not been started");
    L27:
        throw new IllegalStateException("KoinApplication has not been started");
    L28:
        r14.g = r14.getResources().getDisplayMetrics().widthPixels;
        if (r14.f20529b != null) goto L45;
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("LayoutInflate overlayView", "msg");
        org.koin.core.a r17 = su.a.f22013b;
        if (r17 == null) goto L44;
        ((ju.b) r17.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("AssistantOverlayService", "LayoutInflate overlayView");
        View r18 = LayoutInflater.from(r14).inflate(R$layout.feeds, null);
        if ((r18 instanceof CardFeedLayout) == false) goto L35;
        CardFeedLayout r19 = (CardFeedLayout) r18;
    L36:
        if (r19 == null) goto L39;
        r19.setOnStatusBarAppearanceChanged(new AssistantOverlayService$initOverlayWindow$1$1(r14));
    L39:
        CardFeedLayout r20 = (CardFeedLayout) r18;
        r14.f20529b = r20;
        if (r20 == null) goto L45;
        r20.setLauncherCallback(new m.b(13));
        goto L45
    L35:
        r19 = null;
        goto L36
    L44:
        throw new IllegalStateException("KoinApplication has not been started");
    L45:
        CardFeedLayout r21 = r14.f20529b;
        if (r21 == null) goto L48;
        View r22 = r21.findViewById(R$id.container_view);
    L49:
        if (r22 == null) goto L52;
        r22.setTranslationX(-r14.g);
    L52:
        CardFeedLayout r23 = r14.f20529b;
        if (r23 == null) goto L56;
        r23.setOnOverlayStateChanged(new AssistantOverlayService$initOverlayWindow$3(r14));
    L56:
        WindowManager.LayoutParams r24 = new WindowManager.LayoutParams();
        r24.type = PointerIconCompat.TYPE_HAND;
        r24.token = r12;
        r24.format = -3;
        r24.flags = -2130705648;
        r24.width = -1;
        r24.height = -1;
        r24.gravity = GravityCompat.START;
        r24.layoutInDisplayCutoutMode = 1;
        r14.f20530c = r24;
        CardFeedLayout r25 = r14.f20529b;
        if (r25 == null) goto L90;
        r25.setSystemUiVisibility(1792);
    L90:
        WindowManager r26 = r14.f20528a;     // Catch: Exception -> L63
        if (r26 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("windowManager");     // Catch: Exception -> L63
        r26 = null;
    L65:
        CardFeedLayout r27 = r14.f20529b;     // Catch: Exception -> L63
        WindowManager.LayoutParams r28 = r14.f20530c;     // Catch: Exception -> L63
        if (r28 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("overlayLp");     // Catch: Exception -> L63
        r28 = null;
    L68:
        r26.addView(r27, r28);     // Catch: Exception -> L63
        CardFeedLayout r29 = r14.f20529b;     // Catch: Exception -> L63
        if (r29 == null) goto L77;
        p r30 = r29.G;     // Catch: Exception -> L63
        if (r30 == null) goto L77;
        z r31 = new z(false);     // Catch: Exception -> L63
        Intrinsics.checkNotNullParameter(r31, "intent");     // Catch: Exception -> L63
        r30.d(r31);     // Catch: Exception -> L63
    L77:
        String r110 = "initOverlayWindow launcherToken:" + r12;
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter(r110, "msg");
        org.koin.core.a r32 = su.a.f22013b;
        if (r32 == null) goto L85;
        ((ju.b) r32.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("AssistantOverlayService", r110);
        CardFeedLayout r111 = r14.f20529b;
        if (r111 == null) goto L83;
        r111.post(new com.obric.oui.lisitem.a(r14, 23));
    L83:
        return Unit.INSTANCE;
    L85:
        throw new IllegalStateException("KoinApplication has not been started");
    L63:
        e = move-exception;
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("Add view with new token failed", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r33 = su.a.f22013b;
        if (r33 == null) goto L87;
        ((ju.b) r33.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("AssistantOverlayService", "Add view with new token failed", e);
        goto L77
    L87:
        throw new IllegalStateException("KoinApplication has not been started");
    L48:
        r22 = null;
        goto L49
    L89:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r5) {
        return ((AssistantOverlayService$AssistantBinder$setLauncherWindowToken$1$1) create(r5)).invokeSuspend(Unit.INSTANCE);
    }
}
