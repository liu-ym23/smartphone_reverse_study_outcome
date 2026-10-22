package com.larus.bmhome.bigimg;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.common_ui.image.CustomPhotoViewerDialog;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.i2;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.BigImagePhotoViewerDialog$performDownloadAction$1", f = "BigImagePhotoViewerDialog.kt", i = {}, l = {690}, m = "invokeSuspend", n = {}, s = {})
final class BigImagePhotoViewerDialog$performDownloadAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pos;
    int label;
    final /* synthetic */ BigImagePhotoViewerDialog this$0;

    public static final class a implements com.larus.platform.api.g1.c {
        public final /* synthetic */ BigImagePhotoViewerDialog a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function1<Continuation<? super Unit>, Object> d;

        public final void onGoSettingsDialogDismiss(boolean r1) {
        }

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
        }

        public a(BigImagePhotoViewerDialog r1, int r2, String r3, Function1<? super Continuation<? super Unit>, ? extends Object> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void onResult(boolean r3, List<String> r4, List<String> r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r4, "grantedList");
            Intrinsics.checkNotNullParameter(r5, "deniedList");
            if (r3 == false) goto L9;
            BigImagePhotoViewerDialog r7 = this.a;
            int r8 = this.b;
            String r9 = this.c;
            Function1<Continuation<? super Unit>, Object> r10 = this.d;
            if (r7.P0 == null) goto L7;
            ImageSave r0 = ImageSave.a;
            g0 r1 = new g0(r7, r9, r8, r10);
            r0.getClass();
            ImageSave.m(r9, r1);
            return;
        L7:
            r7.s(r8, r9, r10);
            return;
        }
    }

    public BigImagePhotoViewerDialog$performDownloadAction$1(BigImagePhotoViewerDialog r1, int r2, Continuation<? super BigImagePhotoViewerDialog$performDownloadAction$1> r3) {
        this.this$0 = r1;
        this.$pos = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BigImagePhotoViewerDialog$performDownloadAction$1(this.this$0, this.$pos, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        String r1 = "";
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        FragmentActivity r5 = null;
        if (r3 == 0) goto L8;
        if (r3 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L16:
        Message r14 = (Message) r13;
    L18:
        BigImagePhotoViewerDialog$performDownloadAction$1$checkBlock$1 r4 = new BigImagePhotoViewerDialog$performDownloadAction$1$checkBlock$1(this.this$0, r14, null);
        uo8.k r6 = ((CustomPhotoViewerDialog) this.this$0).o;
        if (r6 == null) goto L23;
        Map r7 = r6.a;
        if (r7 == null) goto L23;
        Object r8 = r7.get("chat_id");
    L25:
        if ((r8 instanceof String) == false) goto L27;
        String r9 = (String) r8;
    L28:
        uo8.k r10 = ((CustomPhotoViewerDialog) this.this$0).o;
        if (r10 == null) goto L33;
        Map r11 = r10.a;
        if (r11 == null) goto L33;
        Object r12 = r11.get("is_general_agent");
    L35:
        if ((r12 instanceof String) == false) goto L37;
        String r15 = (String) r12;
    L38:
        com.larus.platform.service.o r16 = com.larus.platform.service.o.a;
        BigImagePhotoViewerDialog r17 = this.this$0;
        int r18 = ((PhotoViewerDialog) r17).f;
        int r19 = BigImagePhotoViewerDialog.V0;
        JSONObject r20 = r17.h(r18);
        BigImagePhotoViewerDialog r110 = this.this$0;
        if (r9 == null) goto L41;
        r20.put("chat_id", r9);
    L41:
        if (r15 == null) goto L43;
        r20.put("is_general_agent", r15);
    L43:
        r20.put("click_method", "detail_click");
        r20.put("click_from", "click_download");
        if (r14 == null) goto L48;
        Map r21 = r14.getExt();
        if (r21 == null) goto L48;
        String r22 = (String) r21.get("creativity_scene");
    L50:
        if (Intrinsics.areEqual(r22, "avatar_image") == false) goto L52;
        String r23 = "replica";
    L53:
        r20.put("is_replica_gen", r23);
        if (r14 == null) goto L58;
        Map r24 = r14.getExt();
        if (r24 == null) goto L58;
        String r25 = (String) r24.get("creativity_scene");
    L59:
        r20.put("is_image_edit", Intrinsics.areEqual(r25, "ai_beautify_image") ? 1 : 0);
        r20.put("download_method", "click_icon");
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L70
        if (r14 == null) goto L67;
        Map r27 = r14.getExt();     // Catch: Throwable -> L70
        if (r27 == null) goto L67;
        String r28 = (String) r27.get("bot_state");     // Catch: Throwable -> L70
        if (r28 == null) goto L67;
        String r29 = new JSONObject(r28).optString("agent_id", "");     // Catch: Throwable -> L70
    L68:
        Object r30 = Result.constructor-impl(r29);     // Catch: Throwable -> L70
    L73:
        if (Result.isFailure-impl(r30) == false) goto L75;
        r30 = null;
    L75:
        String r31 = (String) r30;
        if (r31 != null) goto L78;
        r31 = "";
    L78:
        r20.put("agent_id", r31);
        if (r14 != null) goto L140;
    L87:
        String r111 = null;
    L88:
        Object r112 = Result.constructor-impl(r111);     // Catch: Throwable -> L85
    L92:
        if (Result.isFailure-impl(r112) == false) goto L94;
        r112 = null;
    L94:
        String r113 = (String) r112;
        if (r113 != null) goto L97;
        r113 = "";
    L97:
        r20.put("agent_tool", r113);
        Map<String, Pair<String, Integer>> r114 = r110.Z;
        if (r114 == null) goto L105;
        Pair<String, Integer> r115 = r114.get(String.valueOf(((PhotoViewerDialog) r110).f));
        if (r115 == null) goto L105;
        String r116 = (String) r115.getFirst();
        if (r116 == null) goto L105;
        r1 = r116;
    L105:
        r20.put("creation_id", r1);
        String r117 = r110.t;
        if (r117 == null) goto L108;
        r20.put("message_id", r117);
    L108:
        Unit r118 = Unit.INSTANCE;
        r16.reportEvent("picture_download", r20);
        int r119 = this.$pos;
        if (r119 < 0) goto L139;
        List r0 = ((CustomPhotoViewerDialog) this.this$0).n.k;
        if (r0 == null) goto L113;
        int r32 = r0.size();
    L114:
        if (r119 >= r32) goto L139;
        BigImagePhotoViewerDialog r120 = this.this$0;
        Uri r121 = ((CustomPhotoViewerDialog) r120).n.A2(((PhotoViewerDialog) r120).f);
        if (r121 == null) goto L119;
        String r122 = r121.toString();
        if (Build.VERSION.SDK_INT <= 29) goto L123;
    L132:
        BigImagePhotoViewerDialog r33 = this.this$0;
        int r34 = this.$pos;
        if (r33.P0 == null) goto L135;
        ImageSave r35 = ImageSave.a;
        g0 r36 = new g0(r33, r122, r34, r4);
        r35.getClass();
        ImageSave.m(r122, r36);
    L137:
        return Unit.INSTANCE;
    L135:
        r33.s(r34, r122, r4);
        goto L137
    L123:
        if (ContextCompat.checkSelfPermission(this.this$0.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L132;
        Context r37 = this.this$0.q;
        if ((r37 instanceof FragmentActivity) == false) goto L127;
        r5 = (FragmentActivity) r37;
    L127:
        FragmentActivity r38 = r5;
        if (r38 == null) goto L130;
        List r39 = CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE");
        i2 r40 = i2.b;
        a r41 = new a(this.this$0, this.$pos, r122, r4);
        JSONObject r123 = new JSONObject();
        r123.put("enter_method", "download");
        com.larus.platform.api.g1.a.b(r38, r39, r41, null, r123, 40);
        goto L137
    L130:
        return Unit.INSTANCE;
    L119:
        return Unit.INSTANCE;
    L113:
        r32 = 0;
    L139:
        return Unit.INSTANCE;
    L85:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L92
    L140:
        Map r124 = r14.getExt();     // Catch: Throwable -> L85
        if (r124 == null) goto L87;
        String r125 = (String) r124.get("fpa_common_param");     // Catch: Throwable -> L85
        if (r125 == null) goto L87;
        r111 = new JSONObject(r125).optString("agent_tool", "");     // Catch: Throwable -> L85
    L67:
        r29 = null;
    L70:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
    L58:
        r25 = null;
        goto L59
    L52:
        r23 = "pic";
    L48:
        r22 = null;
        goto L50
    L37:
        r15 = null;
    L33:
        r12 = null;
        goto L35
    L27:
        r9 = null;
    L23:
        r8 = null;
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        IChatRepoService r126 = RepoDispatcherDelegate.b.e();
        if (r126 == null) goto L17;
        int r44 = com.larus.utils.p0.a;
        String r45 = com.larus.utils.p0.a(this.this$0.t);
        if (r45 != null) goto L13;
        r45 = "0";
    L13:
        this.label = 1;
        r13 = r126.E1(r45, this);
        if (r13 != r2) goto L16;
        return r2;
    L17:
        r14 = null;
        goto L18
    }
}
