package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class DeleteAction implements o {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GalleryType.values().length];
            r0[GalleryType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    public DeleteAction() {
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r19, Continuation<? super Unit> r20) {
        l0 r0 = r19;
        if ((r20 instanceof DeleteAction$execute$1) == false) goto L7;
        DeleteAction$execute$1 r2 = (DeleteAction$execute$1) r20;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = true;
        String r8 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        String r7 = (String) r2.L$4;
        String r9 = (String) r2.L$3;
        String r10 = (String) r2.L$2;
        xy8.d r11 = (xy8.d) r2.L$1;
        l0 r12 = (l0) r2.L$0;
        ResultKt.throwOnFailure(r1);
        String r15 = r7;
        r0 = r12;
        String r16 = r9;
        xy8.d r13 = r11;
    L44:
        Pair r14 = (Pair) r1;
        if (r14 != null) goto L47;
    L49:
        r6 = false;
    L50:
        if (r6 == false) goto L52;
        FLogger.a.i("DeleteAction", "deleteCreation success: " + r10);
        t19.s r17 = t19.s.a;
        Context r18 = r0.getContext();
        r17.getClass();
        t19.s.o(r18, 2131900648, false);
        b(r0, r13, r10, r15, r16, "1");
        com.larus.platform.service.e0.a.X0(r10);
        r0.e.Rf(com.larus.gallery.api.p.g.a);
    L57:
        return Unit.INSTANCE;
    L52:
        FLogger r21 = FLogger.a;
        StringBuilder r22 = new StringBuilder("deleteCreation failed: ");
        r22.append(r10);
        r22.append(", ");
        if (r14 == null) goto L55;
        r8 = (String) r14.getSecond();
    L55:
        r22.append(r8);
        r21.w("DeleteAction", r22.toString());
        b(r0, r13, r10, r15, r16, TriggerSendLoading.NO_LOADING);
        goto L57
    L47:
        if (((Boolean) r14.getFirst()).booleanValue() != true) goto L49;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        xy8.d r110 = r0.a;
        xy8.e r23 = r110.m;
        if (r23 == null) goto L17;
        r10 = r23.a;
    L18:
        if (r10 != null) goto L20;
    L23:
        boolean r24 = true;
    L24:
        if (r24 == false) goto L27;
        FLogger.a.w("DeleteAction", "publishMetadata.creationId is null, itemKey=" + r110.b);
        return Unit.INSTANCE;
    L27:
        FLogger.a.i("DeleteAction", "execute: creationId=" + r10);
        UserCreation r25 = r110.n;
        if (r25 == null) goto L32;
        Integer r111 = r25.d;
        if (r111 == null) goto L32;
        int r112 = r111.intValue();
    L34:
        if (r112 != 2) goto L36;
        String r113 = TriggerSendLoading.NO_LOADING;
    L37:
        if (r25 == null) goto L39;
        String r26 = zp9.d.d(r25);
    L40:
        com.larus.platform.service.e0 r114 = com.larus.platform.service.e0.a;
        r2.L$0 = r0;
        r2.L$1 = r110;
        r2.L$2 = r10;
        r2.L$3 = r113;
        r2.L$4 = r26;
        r2.label = 1;
        Object r27 = r114.g(r10, r2);
        if (r27 != r4) goto L43;
        return r4;
    L43:
        r15 = r26;
        r1 = r27;
        r13 = r110;
        r16 = r113;
        goto L44
    L39:
        r26 = "";
        goto L40
    L36:
        r113 = "1";
    L32:
        r112 = 0;
        goto L34
    L20:
        if (r10.length() == 0) goto L23;
        r24 = false;
        goto L24
    L17:
        r10 = null;
    L7:
        r2 = new DeleteAction$execute$1(this, r20);
        goto L8
    }

    public static void b(l0 r7, xy8.d r8, String r9, String r10, String r11, String r12) {
        if (r7.i == false) goto L5;
        String r13 = "more_panel_click";
    L6:
        xy8.e r0 = r8.m;
        String r1 = null;
        if (r0 == null) goto L10;
        String r2 = r0.e;
        if (r2 == null) goto L10;
    L13:
        String r3 = "";
        if (r2 != null) goto L16;
        r2 = "";
    L16:
        if (r0 == null) goto L21;
        String r4 = r0.c;
        if (r4 == null) goto L21;
        r1 = r4;
    L24:
        if (r1 == null) goto L27;
        r3 = r1;
    L27:
        int r5 = r8.q;
        if (r8.a != SourceType.USER_SEND) goto L30;
        String r6 = "user";
    L32:
        if (b.a[r8.e.ordinal()] != 1) goto L34;
        String r14 = "video_detail";
    L35:
        JSONObject r15 = new JSONObject();
        r15.put("previous_page", r14);
        r15.put("current_page", r14);
        r15.put("success", r12);
        r15.put("creation_id", r9);
        r15.put("type", r10);
        r15.put("public_status", r11);
        r15.put("creation_task_id", r2);
        r15.put(MusicAppletPage.KEY_MESSAGE_ID, r3);
        r15.put("position", r5);
        r15.put("user_type", r6);
        r15.put("click_method", r13);
        Iterator<Map.Entry<String, Object>> r16 = r8.f.entrySet().iterator();
    L37:
        if (r16.hasNext() == false) goto L41;
        Map.Entry<String, Object> r17 = r16.next();
        String r18 = r17.getKey();
        Object r19 = r17.getValue();
        if (r15.has(r18) == true) goto L37;
        r15.put(r18, r19);
        goto L37
    L41:
        FLogger.a.i("DeleteAction", "reportCancelCreation: cancel_creation, success=" + r12 + ", params=" + r15);
        com.larus.platform.service.o.a.reportEvent("cancel_creation", r15);
        return;
    L34:
        r14 = "picture_detail";
        goto L35
    L30:
        r6 = "bot";
    L21:
        xy8.f r20 = r8.l;
        if (r20 == null) goto L24;
        r1 = r20.a;
    L10:
        if (r0 == null) goto L12;
        r2 = r0.a;
        goto L13
    L12:
        r2 = null;
        goto L13
    L5:
        r13 = "detail_click";
        goto L6
    }
}
