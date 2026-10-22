package com.larus.bmhome.chat.layout.holder.image.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.trace.ChatRenderTrace;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.arch.FlowListAdapter;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.uaigc.api.o;
import com.larus.uaigc.api.q;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.createpage.component.sendmessage.CreationSendUiEvent;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.larus.utils.y0;
import com.larus.utils.z0;
import ic8.n;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ny9.s;
import ny9.u;
import ny9.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AiCreationEditUtils {
    public static final AiCreationEditUtils a = null;

    public static final class a extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        public final /* synthetic */ Function1<Bitmap, Unit> a;
        public final /* synthetic */ Function1<String, Unit> b;

        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r2) {
            Intrinsics.checkNotNullParameter(r2, "dataSource");
            Function1<String, Unit> r3 = this.b;
            if (r3 == null) goto L6;
            r3.invoke("Bitmap download fails.");
            return;
        }

        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r4) {
            Intrinsics.checkNotNullParameter(r4, "dataSource");
            if (r4.isFinished() == false) goto L21;
            CloseableReference r5 = (CloseableReference) r4.getResult();
            if (r5 == null) goto L26;
            Object r0 = r5.get();     // Catch: Throwable -> L12 Exception -> L14
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.facebook.imagepipeline.image.CloseableBitmap");     // Catch: Throwable -> L12 Exception -> L14
            Bitmap r1 = ((CloseableBitmap) r0).getUnderlyingBitmap();     // Catch: Throwable -> L12 Exception -> L14
            if (r1 != null) goto L9;
        L18:
            r5.close();
            return;
        L9:
            if (r1.isRecycled() == true) goto L18;
            Bitmap r2 = r1.copy(z0.b(r1.getConfig()), r1.isMutable());     // Catch: Throwable -> L12 Exception -> L14
            Function1<Bitmap, Unit> r3 = this.a;     // Catch: Throwable -> L12 Exception -> L14
            Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L12 Exception -> L14
            r3.invoke(r2);     // Catch: Throwable -> L12 Exception -> L14
        L14:
            e = move-exception;
            Function1<String, Unit> r6 = this.b;     // Catch: Throwable -> L12
            if (r6 == null) goto L18;
            r6.invoke(e.toString());     // Catch: Throwable -> L12
            goto L18
        L26:
            return;
        L12:
            th = move-exception;
            r5.close();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Bitmap, Unit> r1, Function1<? super String, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = new AiCreationEditUtils();
    }

    public AiCreationEditUtils() {
    }

    public static u d() {
        Bundle r0 = new Bundle();
        Bundle r1 = new Bundle();
        r1.putString("enter_method", "ai_edit_picture_detail");
        Unit r2 = Unit.INSTANCE;
        r0.putBundle("instruction_hit_point_params", r1);
        return new u(new s(r0));
    }

    public static ChatFragment g(FragmentManager r2) {
        Iterator r3 = r2.getFragments().iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        ChatFragment r0 = (Fragment) r3.next();
        if ((r0 instanceof ChatFragment) == true) goto L8;
        AiCreationEditUtils r1 = a;
        FragmentManager r4 = r0.getChildFragmentManager();
        r1.getClass();
        ChatFragment r5 = g(r4);
        if (r5 == null) goto L4;
        return r5;
    L8:
        return r0;
    L12:
        return null;
    }

    public static CreationSendUiEvent c(String r19, boolean r20) {
        return new CreationSendUiEvent(r19, null, false, false, true, true, true, false, false, true, true, true, true, r20, true, 398, null);
    }

    public static final Object b(AiCreationEditUtils r4, String r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof AiCreationEditUtils$resolveImageResource$1) == false) goto L7;
        AiCreationEditUtils$resolveImageResource$1 r0 = (AiCreationEditUtils$resolveImageResource$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L22:
        com.larus.uaigc.api.s r9 = (com.larus.uaigc.api.s) ((com.larus.network.http.a) r7).b;
        if (r9 == null) goto L27;
        List r10 = r9.a();
        if (r10 == null) goto L27;
        q r11 = (q) CollectionsKt.firstOrNull(r10);
    L29:
        return r11;
    L27:
        r11 = null;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        IBachDetectCenterAbility.Companion r12 = IBachDetectCenterAbility.a;
        if (r12.b() == false) goto L19;
        Uri r3 = y0.j(r5);
        if (r3 == null) goto L19;
        r12.a(r3);
    L19:
        List r13 = CollectionsKt.listOf(r5);
        r0.label = 1;
        r7 = o.a(r13, true, r0);
        if (r7 != r8) goto L22;
        return r8;
    L7:
        r0 = new AiCreationEditUtils$resolveImageResource$1(r4, r6);
        goto L8
    }

    public static Bundle e(String r6, List r7, zs8.a r8, CreationSendMessageConfig r9) {
        Pair[] r0 = new Pair[5];
        r0[0] = TuplesKt.to("actionbar_instruction_prompt", r6);
        String r10 = null;
        if (r7 == null) goto L20;
        Iterator r11 = r7.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        Object r3 = r11.next();
        Integer r4 = ((com.larus.bmhome.actionbar.model.u) r3).b;
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L6;
    L17:
        com.larus.bmhome.actionbar.model.u r12 = (com.larus.bmhome.actionbar.model.u) r3;
        if (r12 == null) goto L20;
        r10 = r12.d;
        goto L20
    L11:
        if (r4.intValue() != 8) goto L13;
        r5 = true;
        goto L14
    L16:
        r3 = null;
    L20:
        r0[1] = TuplesKt.to("actionbar_instruction_default_params", r10);
        r0[2] = TuplesKt.to("actionbar_instruction_type", 16);
        r0[3] = TuplesKt.to("creation_send_message_config", r9);
        r0[4] = TuplesKt.to("instruction_hit_point_params", com.larus.utils.f.c(new Pair[]{TuplesKt.to("instruction_hit_point_params", v.a(r8))}));
        return com.larus.utils.f.c(r0);
    }

    public final Object f(String r6, Function1<? super Bitmap, Unit> r7, Function1<? super String, Unit> r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof AiCreationEditUtils$downloadByUrl$3) == false) goto L7;
        AiCreationEditUtils$downloadByUrl$3 r0 = (AiCreationEditUtils$downloadByUrl$3) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a r11 = (a) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L18:
        ImageRequest r12 = ImageRequestBuilder.newBuilderWithSource((Uri) r10).build();
        Fresco.getImagePipeline().fetchDecodedImage(r12, AppHost.a.getApplication()).subscribe(r11, UiThreadImmediateExecutorService.getInstance());
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        a r13 = new a(r7, r8);
        r0.L$0 = r13;
        r0.label = 1;
        Object r14 = ImageLoaderKt.r(r6, "bitmap_downloader", r0);
        if (r14 != r2) goto L17;
        return r2;
    L17:
        r10 = r14;
        r11 = r13;
    L7:
        r0 = new AiCreationEditUtils$downloadByUrl$3(this, r9);
        goto L8
    }

    public static void i(AiCreationEditUtils r14, Context r15, ic8.f r16, final q0 r17, CoroutineScope r18, com.larus.bmhome.actionbar.model.z0 r19, int r20, boolean r21) {
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "params");
        if ((r17 instanceof MessageAdapter) == false) goto L11;
        MessageAdapter r1 = (MessageAdapter) r17;
        final Fragment r4 = ((FlowListAdapter) r1).d;
        final ICoreInputAbility r5 = r1.p.v0();
        y r7 = r1.p.u0();
        if (r7 == null) goto L8;
        wc9.e r8 = r7.h();
    L9:
        wc9.e r9 = r8;
        h(r15, r16, r18, r19, r20, r21, null, String.valueOf(r1.k.a), r1.k.b, r9, new b(r5), new c(r4, r17, r5), new d(r4), new e(r4));
        return;
    L8:
        r8 = null;
        goto L9
    }

    public final Object j(Context r21, String r22, Map<String, String> r23, AttachmentInfo r24, r r25, String r26, String r27, String r28, wc9.e r29, boolean r30, Function0<Unit> r31, Continuation<? super Unit> r32) {
        if ((r32 instanceof AiCreationEditUtils$sendBeautifyMessageOpt$1) == false) goto L7;
        AiCreationEditUtils$sendBeautifyMessageOpt$1 r4 = (AiCreationEditUtils$sendBeautifyMessageOpt$1) r32;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r2 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        String r11 = "AiCreationEditUtils";
        if (r7 == 0) goto L20;
        if (r7 == 1) goto L19;
        if (r7 != 2) goto L18;
        boolean r0 = r4.Z$0;
        CreationSendMessageConfig r3 = (CreationSendMessageConfig) r4.L$4;
        AiCreationEditUtils r8 = (AiCreationEditUtils) r4.L$3;
        String r9 = (String) r4.L$2;
        Function0<Unit> r10 = (Function0) r4.L$1;
        Context r12 = (Context) r4.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L15
        Function0<Unit> r13 = r10;
        String r16 = "AiCreationEditUtils";
        FragmentActivity r14 = null;
    L92:
        if (r0 == true) goto L117;
        boolean r1 = r3.getClearInputContent();     // Catch: Throwable -> L115
        r8.getClass();     // Catch: Throwable -> L115
        Bundle r15 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("creation_send_ui_event", c(r9, r1))});     // Catch: Throwable -> L115
    L95:
        if ((r12 instanceof ContextWrapper) == false) goto L101;
        if ((r12 instanceof FragmentActivity) == true) goto L98;
        r12 = ((ContextWrapper) r12).getBaseContext();     // Catch: Throwable -> L115
        goto L95
    L98:
        FragmentActivity r17 = (FragmentActivity) r12;     // Catch: Throwable -> L115
    L106:
        if (r17 == null) goto L113;
        FragmentManager r18 = r17.getSupportFragmentManager();     // Catch: Throwable -> L115
        if (r18 == null) goto L113;
        ChatFragment r19 = g(r18);     // Catch: Throwable -> L115
        if (r19 == null) goto L113;
        r19.Lc(r15, 0, -1);     // Catch: Throwable -> L115
    L113:
        String r20 = r16;
        FLogger.a.w(r20, "dispatchCreationSendUiEventByBundle failed");     // Catch: Throwable -> L120
    L118:
        r13.invoke();     // Catch: Throwable -> L120
        Object r33 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L120
    L122:
        Throwable r34 = Result.exceptionOrNull-impl(r33);
        if (r34 == null) goto L126;
        FLogger.a.e(r20, "sendBeautifyMessageOpt failed", r34);
    L126:
        return Unit.INSTANCE;
    L120:
        th = th;
    L121:
        Result.Companion r35 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L122
    L101:
        if ((r12 instanceof FragmentActivity) == false) goto L104;
        FragmentActivity r36 = (FragmentActivity) r12;     // Catch: Throwable -> L115
    L105:
        r17 = r36;
        goto L106
    L104:
        r36 = r14;
    L117:
        r20 = r16;
        goto L118
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        boolean r37 = r4.Z$0;
        String r38 = (String) r4.L$8;
        Function0<Unit> r110 = (Function0) r4.L$7;
        wc9.e r111 = (wc9.e) r4.L$6;
        String r112 = (String) r4.L$5;
        r r113 = (r) r4.L$4;
        AttachmentInfo r39 = (AttachmentInfo) r4.L$3;
        Map<String, String> r40 = (Map) r4.L$2;
        String r41 = (String) r4.L$1;
        Context r114 = (Context) r4.L$0;
        ResultKt.throwOnFailure(r2);
        boolean r115 = r37;
        Function0<Unit> r42 = r110;
        String r116 = r112;
        String r117 = r38;
        Context r43 = r114;
        r r118 = r113;
        Map<String, String> r44 = r40;
        String r45 = r41;
    L64:
        List r46 = (List) r2;
        if (r46 == null) goto L74;
        String r47 = (String) CollectionsKt.firstOrNull(r46);
        if (r47 == null) goto L74;
        if (r47.length() <= 0) goto L71;
        boolean r119 = true;
    L72:
        if (r119 == true) goto L78;
    L77:
        r47 = null;
    L78:
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L15
        CreationSendMessageConfig.Companion.getClass();     // Catch: Throwable -> L15
        r16 = "AiCreationEditUtils";
        r11 = new CreationSendMessageConfig.a();     // Catch: Throwable -> L115
        r11.j(r111);     // Catch: Throwable -> L115
        r11.l(r117);     // Catch: Throwable -> L115
        r11.f(r47);     // Catch: Throwable -> L115
        r11.i(r45);     // Catch: Throwable -> L115
        r11.s("edit");     // Catch: Throwable -> L115
        r11.u("edit");     // Catch: Throwable -> L115
        r11.m("ai_edit_picture_detail");     // Catch: Throwable -> L115
        r11.r("chat");     // Catch: Throwable -> L115
        Integer r48 = r118.a;     // Catch: Throwable -> L115
        if (r48 == null) goto L83;
        int r49 = r48.intValue();     // Catch: Throwable -> L115
    L84:
        r11.d(Boxing.boxInt(r49));     // Catch: Throwable -> L115
        r11.c(r44);     // Catch: Throwable -> L115
        r11.e(r39);     // Catch: Throwable -> L115
        r11.n(d());     // Catch: Throwable -> L115
        String r50 = p0.a(r116);     // Catch: Throwable -> L115
        if (r50 == null) goto L87;
        Map r51 = MapsKt.mapOf(TuplesKt.to("creation_task_id", r50));     // Catch: Throwable -> L115
    L88:
        r11.t(r51);     // Catch: Throwable -> L115
        r11.b("image_edit");     // Catch: Throwable -> L115
        r3 = ((CreationSendMessageConfig.a) r11).a;     // Catch: Throwable -> L115
        ICreationWorkflowService.Companion r52 = ICreationWorkflowService.a;     // Catch: Throwable -> L115
        r4.L$0 = r43;     // Catch: Throwable -> L115
        r4.L$1 = r42;     // Catch: Throwable -> L115
        r4.L$2 = r117;     // Catch: Throwable -> L115
        r4.L$3 = this;     // Catch: Throwable -> L115
        r4.L$4 = r3;     // Catch: Throwable -> L115
        r14 = null;
        r4.L$5 = null;     // Catch: Throwable -> L115
        r4.L$6 = null;     // Catch: Throwable -> L115
        r4.L$7 = null;     // Catch: Throwable -> L115
        r4.L$8 = null;     // Catch: Throwable -> L115
        r4.Z$0 = r115;     // Catch: Throwable -> L115
        r4.label = 2;     // Catch: Throwable -> L115
        if (r52.W(r3, r4) != r6) goto L91;
        return r6;
    L91:
        r13 = r42;
        r8 = this;
        r12 = r43;
        r0 = r115;
        r9 = r117;
        goto L92
    L87:
        r51 = null;
        goto L88
    L83:
        r49 = 0;
    L115:
        th = th;
        r20 = r16;
        goto L121
    L71:
        r119 = false;
    L74:
        String r53 = r117;
    L76:
        r117 = r53;
        goto L77
    L20:
        ResultKt.throwOnFailure(r2);
        if (r29 == null) goto L33;
        r53 = r29.a;
        if (r53 == null) goto L33;
        if (r53.length() <= 0) goto L27;
        boolean r54 = true;
    L28:
        if (r54 == true) goto L31;
        r53 = null;
    L31:
        if (r53 == null) goto L33;
    L39:
        if (r53 != null) goto L41;
    L44:
        boolean r55 = true;
    L45:
        if (r55 == false) goto L48;
        FLogger.a.e("AiCreationEditUtils", "sendBeautifyMessageOpt cvsId is empty");
        return Unit.INSTANCE;
    L48:
        if (r28 != null) goto L50;
    L59:
        if (r29 == null) goto L75;
        r43 = r21;
        r4.L$0 = r43;
        r45 = r22;
        r4.L$1 = r45;
        r44 = r23;
        r4.L$2 = r44;
        r39 = r24;
        r4.L$3 = r39;
        r118 = r25;
        r4.L$4 = r118;
        r116 = r26;
        r4.L$5 = r116;
        r4.L$6 = r29;
        r4.L$7 = r31;
        r4.L$8 = r53;
        r115 = r30;
        r4.Z$0 = r115;
        r4.label = 1;
        Object r121 = n.c(r29, r4);
        if (r121 != r6) goto L63;
        return r6;
    L63:
        r111 = r29;
        r42 = r31;
        r117 = r53;
        r2 = r121;
        goto L64
    L75:
        r43 = r21;
        r45 = r22;
        r44 = r23;
        r39 = r24;
        r118 = r25;
        r116 = r26;
        r115 = r30;
        r111 = r29;
        r42 = r31;
        goto L76
    L50:
        if (r28.length() <= 0) goto L52;
        boolean r56 = true;
    L53:
        if (r56 == false) goto L55;
        String r57 = r28;
    L56:
        if (r57 == null) goto L59;
        r45 = r22;
        r44 = r23;
        r39 = r24;
        r118 = r25;
        r116 = r26;
        r115 = r30;
        r111 = r29;
        r117 = r53;
        r47 = r57;
        r43 = r21;
        r42 = r31;
        goto L78
    L55:
        r57 = null;
        goto L56
    L52:
        r56 = false;
        goto L53
    L41:
        if (r53.length() == 0) goto L44;
        r55 = false;
        goto L45
    L27:
        r54 = false;
    L33:
        if (r27.length() <= 0) goto L35;
        boolean r58 = true;
    L36:
        if (r58 == false) goto L38;
        r53 = r27;
        goto L39
    L38:
        r53 = null;
        goto L39
    L35:
        r58 = false;
    L15:
        th = th;
        r20 = r11;
    L7:
        r4 = new AiCreationEditUtils$sendBeautifyMessageOpt$1(this, r32);
        goto L8
    }

    public static void h(Context r19, ic8.f r20, CoroutineScope r21, com.larus.bmhome.actionbar.model.z0 r22, int r23, boolean r24, String r25, String r26, String r27, wc9.e r28, Function1 r29, Function4 r30, Function1 r31, Function0 r32) {
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r20, "params");
        Intrinsics.checkNotNullParameter(r26, "cvsId");
        Intrinsics.checkNotNullParameter(r31, "showDialogFragment");
        Intrinsics.checkNotNullParameter(r32, "dismissCreationPage");
        if (r21 == null) goto L6;
        BuildersKt.launch$default(r21, null, null, new AiCreationEditUtils$handleImageBeautifyAction$5(r20, r19, r22, r23, r21, r24, r25, r26, r27, r28, r30, r31, r32, r29, null), 3, null);
        return;
    }

    public static final Object a(AiCreationEditUtils r54, Context r55, boolean r56, String r57, String r58, Map r59, AttachmentInfo r60, r r61, f r62, String r63, String r64, String r65, wc9.e r66, Function1 r67, Function0 r68, Continuation r69) {
        r54.getClass();
        if ((r69 instanceof AiCreationEditUtils$handleDirectSendAction$1) == false) goto L7;
        AiCreationEditUtils$handleDirectSendAction$1 r2 = (AiCreationEditUtils$handleDirectSendAction$1) r69;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        AiCreationEditUtils$handleDirectSendAction$1 r12 = r2;
        Object r1 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r12.label;
        boolean r16 = false;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L91:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        wc9.e r0 = (wc9.e) r12.L$3;
        String r5 = (String) r12.L$2;
        String r6 = (String) r12.L$1;
        Context r13 = (Context) r12.L$0;
        ResultKt.throwOnFailure(r1);
        int r510 = 1;
        char r14 = 2;
    L24:
        String r7 = null;
        if (r0 == null) goto L38;
        String r8 = r0.a;
        if (r8 == null) goto L38;
        if (r8.length() <= 0) goto L31;
        boolean r9 = true;
    L32:
        if (r9 == true) goto L35;
        r8 = null;
    L35:
        if (r8 == null) goto L38;
        r6 = r8;
        goto L38
    L31:
        r9 = false;
    L38:
        if (r5 != null) goto L40;
    L49:
        e0 r10 = (e0) AuthModelDelegate.b.e().getValue();
        if (r10 == null) goto L54;
        LaunchInfo r11 = r10.a;
        if (r11 == null) goto L54;
        String r17 = r11.W();
    L55:
        if (r17 != null) goto L57;
        r17 = "7234781073513644036";
    L57:
        Pair[] r18 = new Pair[3];
        r18[0] = TuplesKt.to("argBotId", r17);
        r18[1] = TuplesKt.to("argBotType", Integer.valueOf(r510));
        r18[r14] = TuplesKt.to("creation_send_ui_event", c(r6, true));
        Bundle r19 = com.larus.utils.f.c(r18);
        if (r6 != null) goto L60;
    L66:
        i r20 = SmartRouter.buildRoute(r13, "//flow/chat_page");
        r20.c.putExtras(r19);
        r20.d = 2130772343;
        r20.e = 2130772399;
        r20.d();
        goto L91
    L60:
        if (r6.length() <= 0) goto L62;
        r16 = true;
    L62:
        if (r16 == false) goto L64;
        r7 = r6;
    L64:
        if (r7 == null) goto L66;
        r19.putString("argConversationId", r7);
    L54:
        r17 = null;
        goto L55
    L40:
        if (r5.length() <= 0) goto L42;
        boolean r21 = true;
    L43:
        if (r21 == true) goto L46;
        r5 = null;
    L46:
        if (r5 == null) goto L49;
        r17 = r5;
        goto L57
    L42:
        r21 = false;
        goto L43
    L16:
        ResultKt.throwOnFailure(r1);
        if (r56 == false) goto L75;
        ICreationPageService.a.getClass();
        if (ICreationPageService.a.a() == false) goto L67;
        Function0<Unit> r110 = new com.larus.bmhome.chat.layout.holder.image.utils.a();
        r12.L$0 = r55;
        r12.L$1 = r64;
        r12.L$2 = r65;
        r12.L$3 = r66;
        r12.label = 1;
        r510 = 1;
        r14 = 2;
        if (r54.j(r55, r57, r59, r60, r61, r63, r64, r65, r66, true, r110, r12) == r15) goto L92;
        r6 = r64;
        r5 = r65;
        r0 = r66;
        r13 = r55;
        goto L24
    L92:
        return r15;
    L67:
        e0 r22 = (e0) AuthModelDelegate.b.e().getValue();
        if (r22 == null) goto L73;
        LaunchInfo r23 = r22.a;
        if (r23 == null) goto L73;
        String r24 = r23.W();
        if (r24 == null) goto L73;
    L74:
        Bundle r25 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argBotId", r24), TuplesKt.to("argBotType", 1), TuplesKt.to("actionbar_instruction_template", r58), TuplesKt.to("instruction_hit_point_params", com.larus.utils.f.c(new Pair[]{TuplesKt.to("instruction_hit_point_params", v.a(r62))}))});
        i r26 = SmartRouter.buildRoute(r55, "//flow/chat_page");
        r26.c.putExtras(r25);
        r26.c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("actionbar_instruction_prompt", r57), TuplesKt.to("actionbar_instruction_type", 16), TuplesKt.to("actionbar_creation_type", "image_edit"), TuplesKt.to("actionbar_remote_image", r60)}));
        r26.d = 2130772343;
        r26.e = 2130772399;
        r26.d();
    L73:
        r24 = "7234781073513644036";
        goto L74
    L75:
        ICreationPageService.a.getClass();
        if (ICreationPageService.a.a() == false) goto L81;
        r12.label = 2;
        if (r54.j(r55, r57, r59, r60, r61, r63, r64, r65, r66, false, r68, r12) != r15) goto L91;
        return r15;
    L81:
        if (p0.a(r63) == null) goto L83;
        ChatRenderTrace.b.e(r64, MapsKt.mapOf(TuplesKt.to("creation_task_id", r63)));
    L83:
        if (r67 == null) goto L89;
        Integer r27 = r61.a;
        if (r27 == null) goto L87;
        int r28 = r27.intValue();
    L88:
        r67.invoke(new ICoreInputAbility.OnSendParams(r57, "", r60, null, null, r59, null, null, r28, false, "", false, false, false, null, null, null, null, false, "ai_edit_picture_detail", null, null, null, null, null, null, null, null, null, null, null, null, null, -802624, 1, null));
        goto L89
    L87:
        r28 = 0;
    L89:
        r68.invoke();
    L7:
        r2 = new AiCreationEditUtils$handleDirectSendAction$1(r54, r69);
        goto L8
    }
}
