package com.larus.uaigc.chat.markdown.image.component;

import android.app.Activity;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.uaigc.utils.DataConverterKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.component.VideoEditorComponent$goCreationIndependentPage$1", f = "VideoEditorComponent.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
public final class VideoEditorComponent$goCreationIndependentPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imageUrl;
    int label;
    final /* synthetic */ VideoEditorComponent this$0;

    public static final class a implements zs8.a {
        public final /* synthetic */ BotModel a;
        public final /* synthetic */ boolean b;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String b() {
            return "chat";
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getEnterMethod() {
            return "ai_edit_picture_overview";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String getBotId() {
            if (this.b == false) goto L9;
            e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
            if (r0 == null) goto L21;
            LaunchInfo r1 = r0.a;
            if (r1 != null) goto L23;
            return null;
        L23:
            return r1.W();
        L21:
            return null;
        L9:
            BotModel r2 = this.a;
            if (r2 == null) goto L15;
            String r3 = r2.getBotId();
            if (r3 == null) goto L15;
            return r3;
        L15:
            e0 r4 = (e0) AuthModelDelegate.b.e().getValue();
            if (r4 == null) goto L25;
            LaunchInfo r5 = r4.a;
            if (r5 != null) goto L20;
            return null;
        L20:
            return r5.W();
        L25:
            return null;
        }

        public final String getChatType() {
            BotModel r0 = this.a;
            if (r0 != null) goto L7;
            return "default";
        L7:
            return DataConverterKt.b(r0);
        }

        public a(BotModel r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public VideoEditorComponent$goCreationIndependentPage$1(VideoEditorComponent r1, String r2, Continuation<? super VideoEditorComponent$goCreationIndependentPage$1> r3) {
        this.this$0 = r1;
        this.$imageUrl = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VideoEditorComponent$goCreationIndependentPage$1(this.this$0, this.$imageUrl, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r66) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r9 = "";
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r66);
        Object r1 = r66;
    L16:
        BotModel r2 = (BotModel) r1;
    L17:
        boolean r3 = this.this$0.O();
        z0 r4 = this.this$0.P();
        AppHost.Companion r5 = AppHost.a;
        Activity r13 = r5.a().getCurrentActivity();
        String r6 = null;
        if (r13 == null) goto L43;
        VideoEditorComponent r7 = this.this$0;
        String r10 = this.$imageUrl;
        if (r4 == null) goto L43;
        ICreationWorkflowService.Companion r11 = ICreationWorkflowService.a;
        if (r3 == false) goto L30;
        wc9.e r12 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r12 == null) goto L26;
        String r14 = r12.a;
    L27:
        if (r14 == null) goto L31;
        String r15 = r14;
    L32:
        if (r3 == false) goto L38;
        e0 r16 = (e0) AuthModelDelegate.b.e().getValue();
        if (r16 == null) goto L41;
        LaunchInfo r17 = r16.a;
        if (r17 == null) goto L41;
        String r18 = r17.W();
    L40:
        String r19 = r18;
    L42:
        r11.f0(new ny9.b(false, r13, r4, new ChatParam(r15, r19, null, null, null, 252), r3, false, null, null, r10, null, null, null, null, null, null, null, null, null, null, false, false, new a(r2, r3), null, com.larus.utils.f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "generated_img_edit")}), false, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, r7.N(), null, r7.M(), null, null, false, -10486047, 241663));
    L41:
        r19 = null;
        goto L42
    L38:
        if (r2 == null) goto L41;
        r18 = r2.getBotId();
    L31:
        r15 = r9;
        goto L32
    L26:
        r14 = null;
        goto L27
    L30:
        r9 = r7.K();
    L43:
        hy9.d r20 = ICreationReportService.a.j();
        String r21 = r5.getApplication().getString(2131906331);
        if (r2 == null) goto L46;
        String r110 = r2.getBotId();
    L48:
        if (r4 == null) goto L54;
        r r22 = r4.q;
        if (r22 == null) goto L54;
        Integer r23 = r22.a;
        if (r23 == null) goto L54;
        String r111 = r23.toString();
    L55:
        if (r4 == null) goto L59;
        r r24 = r4.q;
        if (r24 == null) goto L59;
        r6 = r24.g;
    L59:
        IAIChatControlTraceService.Companion r25 = IAIChatControlTraceService.a;
        hy9.d.a.a(r20, r21, null, null, "picture_overview", "single_function", r110, null, r111, r6, r25.bb(r25.gb()), null, null, null, null, null, null, null, null, null, null, null, 4193350);
        return Unit.INSTANCE;
    L54:
        r111 = null;
        goto L55
    L46:
        r110 = null;
        goto L48
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r66);
        r2 = this.this$0.a();
        if (r2 != null) goto L17;
        IBotRepoService r26 = RepoDispatcherDelegate.b.b();
        String r27 = this.this$0.L();
        if (r27 != null) goto L13;
        r27 = "";
    L13:
        this.label = 1;
        r1 = IBotRepoService.b.a(r26, r27, false, null, false, this, 30);
        if (r1 != r8) goto L16;
        return r8;
    }
}
