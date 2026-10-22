package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.gallery.api.GalleryType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class SetPrivateAction implements o {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[SourceType.values().length];
            r0[SourceType.CREATION_RECORD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L12:
            r0[SourceType.CREATION_CARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L5:
            a = r0;
            int[] r1 = new int[GalleryType.values().length];
            r1[GalleryType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L7:
            b = r1;
        }
    }

    static {
    }

    public SetPrivateAction() {
    }

    public static void g(l0 r22) {
        xy8.d r13 = r22.a;
        xy8.e r14 = r13.m;
        UserCreation r1 = null;
        if (r14 == null) goto L5;
        xy8.e r8 = xy8.e.a(r14, null, null, null, null, null, false, 1023);
    L6:
        UserCreation r15 = r13.n;
        if (r15 == null) goto L9;
        r1 = UserCreation.c(r15, 2, null, null, null, null, null, 131063);
    L9:
        r22.e.Rf(new com.larus.gallery.api.p.j(xy8.d.a(r13, null, null, null, null, null, null, r8, r1, null, 0, 118783), false));
        FLogger.a.i("SetPrivateAction", "updatePreviewData: isPublished=false, itemKey=" + r13.b);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public static final void b(SetPrivateAction r2, l0 r3) {
        r2.getClass();
        PreviewToolbarView r4 = r3.f;
        if (r4 == null) goto L5;
        r4.b(ToolbarButtonType.SET_PRIVATE, new w());
    L5:
        PreviewToolbarView r5 = r3.f;
        if (r5 == null) goto L9;
        r5.b(ToolbarButtonType.PUBLISH, new x());
        return;
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof SetPrivateAction$execute$1) == false) goto L7;
        SetPrivateAction$execute$1 r0 = (SetPrivateAction$execute$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r15);
    L53:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r15);
    L58:
        return Unit.INSTANCE;
    L17:
        xy8.d r16 = (xy8.d) r0.L$1;
        l0 r5 = (l0) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L35:
        String r17 = (String) r15;
        xy8.d r18 = r16;
        r13 = r5;
        String r6 = r17;
    L36:
        if (r6 != null) goto L38;
    L39:
        r4 = true;
    L41:
        if (r4 == false) goto L44;
        FLogger.a.w("SetPrivateAction", "creationId is null, itemKey=" + r18.b);
        return Unit.INSTANCE;
    L44:
        FLogger r7 = FLogger.a;
        r7.i("SetPrivateAction", "execute: sourceType=" + r18.a + ", creationId=" + r6);
        int r9 = b.a[r18.a.ordinal()];
        if (r9 == 1) goto L54;
        if (r9 == 2) goto L49;
        r7.w("SetPrivateAction", "设为私密不支持 sourceType=" + r18.a);
        return Unit.INSTANCE;
    L49:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
        if (e(r13, r6, r0) != r2) goto L53;
        return r2;
    L54:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (f(r13, r6, r0) != r2) goto L58;
        return r2;
    L38:
        if (r6.length() != 0) goto L41;
    L18:
        ResultKt.throwOnFailure(r15);
        r18 = r13.a;
        xy8.e r8 = r18.m;
        if (r8 == null) goto L21;
        r6 = r8.a;
    L22:
        if (r6 != null) goto L24;
    L27:
        boolean r10 = true;
    L28:
        if (r10 == false) goto L36;
        xy8.e r11 = r18.m;
        if (r11 == null) goto L36;
        r0.L$0 = r13;
        r0.L$1 = r18;
        r0.label = 1;
        Object r12 = d(r11, r0);
        if (r12 != r2) goto L34;
        return r2;
    L34:
        r5 = r13;
        r16 = r18;
        r15 = r12;
        goto L35
    L24:
        if (r6.length() == 0) goto L27;
        r10 = false;
        goto L28
    L21:
        r6 = null;
    L7:
        r0 = new SetPrivateAction$execute$1(this, r14);
        goto L8
    }

    public final Object d(xy8.e r10, Continuation<? super String> r11) {
        if ((r11 instanceof SetPrivateAction$resolveCreationIdFromMessage$1) == false) goto L7;
        SetPrivateAction$resolveCreationIdFromMessage$1 r2 = (SetPrivateAction$resolveCreationIdFromMessage$1) r11;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r12 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = true;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        String r13 = (String) r2.L$1;
        String r7 = (String) r2.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
    L28:
        String r14 = (String) r12;     // Catch: Throwable -> L14
        if (r14 != null) goto L31;
    L34:
        if (r6 == false) goto L36;
        return null;
    L36:
        String r15 = r7 + '_' + r13;     // Catch: Throwable -> L14
        UserCreationFromIM r16 = (UserCreationFromIM) ((LinkedHashMap) DataConverterKt.c(r14, r7)).get(r15);     // Catch: Throwable -> L14
        if (r16 == null) goto L39;
        FLogger.a.i("SetPrivateAction", "resolveCreationIdFromMessage: 找到 creationId=" + r16.getCreationId());     // Catch: Throwable -> L14
        String r17 = r16.getCreationId();     // Catch: Throwable -> L14
    L40:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L14
    L43:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L47;
        FLogger.a.e("SetPrivateAction", "resolveCreationIdFromMessage error", r19);
    L47:
        if (Result.isFailure-impl(r18) == false) goto L50;
        return null;
    L50:
        return r18;
    L39:
        FLogger.a.w("SetPrivateAction", "resolveCreationIdFromMessage: 未找到匹配项, key=" + r15);     // Catch: Throwable -> L14
        r17 = null;
        goto L40
    L31:
        if (r14.length() == 0) goto L34;
        r6 = false;
        goto L34
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        String r110 = r10.c;
        if (r110 != null) goto L21;
        return null;
    L21:
        r13 = r10.e;
        if (r13 != null) goto L24;
        return null;
    L24:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L14
        IChatRepoService r9 = RepoDispatcherDelegate.b.e();     // Catch: Throwable -> L14
        r2.L$0 = r110;     // Catch: Throwable -> L14
        r2.L$1 = r13;     // Catch: Throwable -> L14
        r2.label = 1;     // Catch: Throwable -> L14
        Object r20 = r9.w1(r110, r2);     // Catch: Throwable -> L14
        if (r20 != r4) goto L27;
        return r4;
    L27:
        r7 = r110;
        r12 = r20;
    L14:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new SetPrivateAction$resolveCreationIdFromMessage$1(this, r11);
        goto L8
    }

    public static void c(l0 r9, xy8.d r10, String r11) {
        if (r9.i == false) goto L5;
        String r12 = "more_panel_click";
    L6:
        xy8.e r0 = r10.m;
        Integer r1 = null;
        if (r0 == null) goto L10;
        String r2 = r0.e;
        if (r2 == null) goto L10;
    L13:
        String r3 = "";
        if (r2 != null) goto L16;
        r2 = "";
    L16:
        if (r0 == null) goto L19;
        String r4 = r0.c;
        if (r4 == null) goto L19;
    L23:
        if (r4 != null) goto L25;
        r4 = "";
    L25:
        int r5 = r10.q;
        if (r10.a != SourceType.USER_SEND) goto L28;
        String r6 = "user";
    L30:
        if (b.b[r10.e.ordinal()] != 1) goto L32;
        String r7 = "video_detail";
    L33:
        xy8.e r8 = r10.m;
        if (r8 == null) goto L36;
        r1 = r8.b;
    L36:
        if (r1 == null) goto L38;
        String r13 = zp9.y.b(r1.intValue());
    L39:
        if (r1 == null) goto L41;
        r3 = zp9.y.a(r1.intValue());
    L41:
        JSONObject r14 = new JSONObject();
        r14.put("creation_id", r11);
        r14.put("creation_task_id", r2);
        r14.put(MusicAppletPage.KEY_MESSAGE_ID, r4);
        r14.put("position", r5);
        r14.put("user_type", r6);
        r14.put("click_method", r12);
        r14.put("current_page", r7);
        r14.put("sub_type", r3);
        r14.put("type", r13);
        r14.put("from_status", "1");
        r14.put("to_status", TriggerSendLoading.NO_LOADING);
        Iterator<Map.Entry<String, Object>> r15 = r10.f.entrySet().iterator();
    L43:
        if (r15.hasNext() == false) goto L47;
        Map.Entry<String, Object> r16 = r15.next();
        String r17 = r16.getKey();
        Object r18 = r16.getValue();
        if (r14.has(r17) == true) goto L43;
        r14.put(r17, r18);
        goto L43
    L47:
        FLogger.a.i("SetPrivateAction", "reportCreationPublicStatus: params=" + r14);
        com.larus.platform.service.o.a.reportEvent("creation_public_status", r14);
        return;
    L38:
        r13 = "";
        goto L39
    L32:
        r7 = "picture_detail";
        goto L33
    L28:
        r6 = "bot";
    L19:
        xy8.f r19 = r10.l;
        if (r19 == null) goto L22;
        r4 = r19.a;
        goto L23
    L22:
        r4 = null;
    L10:
        if (r0 == null) goto L12;
        r2 = r0.a;
        goto L13
    L12:
        r2 = null;
        goto L13
    L5:
        r12 = "detail_click";
        goto L6
    }

    public final Object e(l0 r10, String r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof SetPrivateAction$setPrivateViaCreationCard$1) == false) goto L7;
        SetPrivateAction$setPrivateViaCreationCard$1 r0 = (SetPrivateAction$setPrivateViaCreationCard$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r5 = true;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        String r14 = (String) r0.L$1;
        l0 r15 = (l0) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L31:
        t19.s r16 = t19.s.a;
        Context r17 = r15.getContext();
        r16.getClass();
        t19.s.o(r17, 2131900633, false);
        com.larus.platform.service.e0.a.X0(r14);
    L37:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (String) r0.L$1;
        r10 = (l0) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        Pair r18 = (Pair) r13;
        if (r18 != null) goto L22;
    L24:
        r5 = false;
    L25:
        String r4 = null;
        if (r5 == false) goto L32;
        FLogger.a.i("SetPrivateAction", "setPrivateViaCreationCard success: " + r11);
        MutableSharedFlow<com.larus.bmhome.share.panel.k> r19 = com.larus.bmhome.share.panel.l.a;
        com.larus.bmhome.share.panel.l.a(com.larus.bmhome.share.panel.k.b.a);
        g(r10);
        MainCoroutineDispatcher r110 = Dispatchers.getMain();
        SetPrivateAction$setPrivateViaCreationCard$2 r6 = new SetPrivateAction$setPrivateViaCreationCard$2(this, r10, null);
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.label = 2;
        if (BuildersKt.withContext(r110, r6, r0) != r2) goto L30;
        return r2;
    L30:
        String r8 = r11;
        r15 = r10;
        r14 = r8;
        goto L31
    L32:
        FLogger r111 = FLogger.a;
        StringBuilder r7 = new StringBuilder("setPrivateViaCreationCard failed: ");
        r7.append(r11);
        r7.append(", ");
        if (r18 == null) goto L35;
        r4 = (String) r18.getSecond();
    L35:
        r7.append(r4);
        r111.w("SetPrivateAction", r7.toString());
        goto L37
    L22:
        if (((Boolean) r18.getFirst()).booleanValue() != true) goto L24;
    L16:
        ResultKt.throwOnFailure(r13);
        c(r10, r10.a, r11);
        com.larus.platform.service.e0 r112 = com.larus.platform.service.e0.a;
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.label = 1;
        r13 = r112.h(r11, 2, r0);
        if (r13 != r2) goto L19;
        return r2;
    L7:
        r0 = new SetPrivateAction$setPrivateViaCreationCard$1(this, r12);
        goto L8
    }

    public final Object f(l0 r11, String r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof SetPrivateAction$setPrivateViaCreationRecord$1) == false) goto L7;
        SetPrivateAction$setPrivateViaCreationRecord$1 r0 = (SetPrivateAction$setPrivateViaCreationRecord$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        String r15 = (String) r0.L$1;
        l0 r16 = (l0) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L44:
        t19.s r17 = t19.s.a;
        Context r18 = r16.getContext();
        r17.getClass();
        t19.s.o(r18, 2131900633, false);
        com.larus.platform.service.e0.a.X0(r15);
    L50:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r15 = (String) r0.L$1;
        r16 = (l0) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L32:
        Pair r19 = (Pair) r14;
    L34:
        if (r19 != null) goto L36;
    L38:
        r4 = false;
    L39:
        String r5 = null;
        if (r4 == false) goto L45;
        FLogger.a.i("SetPrivateAction", "setPrivateViaCreationRecord success: " + r15);
        MutableSharedFlow<com.larus.bmhome.share.panel.k> r110 = com.larus.bmhome.share.panel.l.a;
        com.larus.bmhome.share.panel.l.a(com.larus.bmhome.share.panel.k.b.a);
        g(r16);
        MainCoroutineDispatcher r111 = Dispatchers.getMain();
        SetPrivateAction$setPrivateViaCreationRecord$2 r6 = new SetPrivateAction$setPrivateViaCreationRecord$2(this, r16, null);
        r0.L$0 = r16;
        r0.L$1 = r15;
        r0.label = 3;
        if (BuildersKt.withContext(r111, r6, r0) != r2) goto L44;
        return r2;
    L45:
        FLogger r112 = FLogger.a;
        StringBuilder r7 = new StringBuilder("setPrivateViaCreationRecord failed: ");
        r7.append(r15);
        r7.append(", ");
        if (r19 == null) goto L48;
        r5 = (String) r19.getSecond();
    L48:
        r7.append(r5);
        r112.w("SetPrivateAction", r7.toString());
        goto L50
    L36:
        if (((Boolean) r19.getFirst()).booleanValue() != true) goto L38;
    L17:
        r12 = (String) r0.L$1;
        r11 = (l0) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L21:
        r19 = (Pair) r14;
        if (r19 != null) goto L24;
    L26:
        boolean r8 = false;
    L27:
        if (r8 == true) goto L33;
        FLogger.a.w("SetPrivateAction", "setPrivateViaCreationRecord: 首次失败，重试: " + r12);
        com.larus.platform.service.e0 r113 = com.larus.platform.service.e0.a;
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.label = 2;
        r14 = r113.h(r12, 2, r0);
        if (r14 != r2) goto L31;
        return r2;
    L31:
        String r9 = r12;
        r16 = r11;
        r15 = r9;
        goto L32
    L33:
        String r10 = r12;
        r16 = r11;
        r15 = r10;
        goto L34
    L24:
        if (((Boolean) r19.getFirst()).booleanValue() != true) goto L26;
        r8 = true;
        goto L27
    L18:
        ResultKt.throwOnFailure(r14);
        c(r11, r11.a, r12);
        com.larus.platform.service.e0 r114 = com.larus.platform.service.e0.a;
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.label = 1;
        r14 = r114.h(r12, 2, r0);
        if (r14 != r2) goto L21;
        return r2;
    L7:
        r0 = new SetPrivateAction$setPrivateViaCreationRecord$1(this, r13);
        goto L8
    }
}
