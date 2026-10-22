package com.larus.chat.gallery.impl.preview.provider;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r1 extends com.larus.gallery.api.t<xy8.d> {
    public final Function0<Unit> f;
    public boolean g;
    public int h;
    public String i;
    public boolean j;
    public final HashSet<Integer> k;
    public final Map<String, xy8.d> l;
    public final c m;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GalleryType.values().length];
            r0[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements com.larus.gallery.api.z {
        public final /* synthetic */ r1 a;

        public c(r1 r1) {
            this.a = r1;
        }

        public final void b(nr9.g r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "data");
            Intrinsics.checkNotNullParameter(r1, "data");
        }

        public final void c(nr9.g r18, boolean r19) {
            Intrinsics.checkNotNullParameter(r18, "data");
            xy8.d r2 = r1.y(this.a, r18);
            if (r2 != null) goto L5;
            return;
        L5:
            String r3 = r18.a;
            String r4 = r1.z(this.a, r2);
            Boolean r6 = Boolean.valueOf(r19);
            Object r1 = r2.f.get("enter_from");
            if (r1 == null) goto L8;
            String r5 = r1.toString();
        L10:
            if (r2.a != SourceType.USER_SEND) goto L12;
            String r8 = "1";
        L13:
            Integer r10 = Integer.valueOf(r2.q);
            this.a.getClass();
            xy8.e r7 = r2.m;
            if (r7 == null) goto L20;
            String r9 = r7.e;
            if (r9 == null) goto L20;
            if ((!StringsKt.isBlank(r9)) == false) goto L20;
            String r11 = r9;
        L21:
            a4.f(r3, r4, null, r6, r5, r8, null, r10, r11, "video_detail", null, null, null, 16776260);
            return;
        L20:
            r11 = null;
            goto L21
        L12:
            r8 = TriggerSendLoading.NO_LOADING;
            goto L13
        L8:
            r5 = null;
            goto L10
        }

        public final void d(nr9.g r18, long r19, boolean r21) {
            Intrinsics.checkNotNullParameter(r18, "data");
            xy8.d r2 = r1.y(this.a, r18);
            if (r2 != null) goto L5;
            return;
        L5:
            String r3 = r18.a;
            String r4 = r1.z(this.a, r2);
            Boolean r6 = Boolean.valueOf(x19.a.a);
            Object r1 = r2.f.get("enter_from");
            if (r1 == null) goto L8;
            String r5 = r1.toString();
        L9:
            Long r8 = Long.valueOf(r19);
            Boolean r9 = Boolean.valueOf(r21);
            if (r2.a != SourceType.USER_SEND) goto L12;
            String r10 = "1";
        L13:
            this.a.getClass();
            xy8.e r12 = r2.m;
            if (r12 == null) goto L20;
            String r13 = r12.e;
            if (r13 == null) goto L20;
            if ((!StringsKt.isBlank(r13)) == false) goto L20;
        L21:
            JSONObject r14 = new JSONObject();
            Iterator<Map.Entry<String, Object>> r7 = r2.f.entrySet().iterator();
        L23:
            if (r7.hasNext() == false) goto L25;
            Map.Entry<String, Object> r11 = r7.next();
            r14.put(r11.getKey(), r11.getValue());
            goto L23
        L25:
            Unit r15 = Unit.INSTANCE;
            a4.m(r3, r4, null, r6, r5, r8, r9, r10, "video_detail", r13, r14, null, null, 16775172);
            return;
        L20:
            r13 = null;
            goto L21
        L12:
            r10 = TriggerSendLoading.NO_LOADING;
            goto L13
        L8:
            r5 = null;
            goto L9
        }
    }

    static {
    }

    public final void t() {
        com.larus.gallery.api.w r0 = ((com.larus.gallery.api.t) this).e;
        if (r0 == null) goto L6;
        r0.xm(this.m);
        return;
    }

    public final void u() {
        com.larus.gallery.api.w r0 = ((com.larus.gallery.api.t) this).e;
        if (r0 == null) goto L5;
        r0.bC(this.m);
    L5:
        ((LinkedHashMap) this.l).clear();
        if (this.j == true) goto L11;
        this.j = true;
        Function0<Unit> r1 = this.f;
        if (r1 == null) goto L12;
        r1.invoke();
        return;
    L12:
        return;
    }

    public r1(Function0<Unit> r1) {
        this.f = r1;
        this.g = true;
        this.h = -1;
        this.i = "click";
        this.k = new HashSet();
        this.l = new LinkedHashMap();
        this.m = new c(this);
    }

    public final void x(com.larus.gallery.api.p r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof com.larus.gallery.api.p.f) == false) goto L6;
        this.i = ((com.larus.gallery.api.p.f) r2).a;
        return;
    }

    public static final xy8.d y(r1 r4, nr9.g r5) {
        r4.getClass();
        String r6 = r5.a;
        if (r6 == null) goto L28;
        boolean r2 = true;
        if ((!StringsKt.isBlank(r6)) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L32;
        xy8.d r1 = (xy8.d) ((LinkedHashMap) r4.l).get(r6);
        if (r1 != null) goto L27;
        xy8.d r7 = (xy8.d) ((com.larus.gallery.api.t) r4).d;
        if (r7 != null) goto L15;
        return null;
    L15:
        if (r7.e != GalleryType.Video) goto L23;
        xy8.g r3 = r7.d;
        if (r3 == null) goto L19;
        String r8 = r3.a;
    L21:
        if (Intrinsics.areEqual(r8, r6) == false) goto L23;
    L24:
        if (r2 == true) goto L31;
        return null;
    L31:
        return r7;
    L19:
        r8 = null;
    L23:
        r2 = false;
        goto L24
    L27:
        return r1;
    L32:
        return null;
    L28:
        return null;
    }

    public static final String z(r1 r2, xy8.d r3) {
        r2.getClass();
        xy8.e r4 = r3.m;
        if (r4 == null) goto L11;
        String r5 = r4.c;
        if (r5 == null) goto L11;
        if ((!StringsKt.isBlank(r5)) == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L11;
    L18:
        return r5;
    L11:
        Object r6 = r3.f.get(MusicAppletPage.KEY_MESSAGE_ID);
        if (r6 == null) goto L19;
        r5 = r6.toString();
        if (r5 != null) goto L16;
        return null;
    L16:
        if ((!StringsKt.isBlank(r5)) == true) goto L18;
        return null;
    L19:
        return null;
    }

    public final void w(Object r3, int r4) {
        xy8.d r5 = (xy8.d) r3;
        Intrinsics.checkNotNullParameter(r5, "data");
        ((com.larus.gallery.api.t) this).d = r5;
        xy8.g r0 = r5.d;
        if (r0 == null) goto L13;
        String r1 = r0.a;
        if (r1 == null) goto L13;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        this.l.put(r1, r5);
    L13:
        if (this.g == false) goto L16;
        this.g = false;
        A(r5, r4, "click", "");
    L22:
        this.h = r4;
        return;
    L16:
        if (Intrinsics.areEqual(this.i, "click") == true) goto L22;
        if (r4 <= this.h) goto L20;
        String r2 = "left";
    L21:
        A(r5, r4, this.i, r2);
        goto L22
    L20:
        r2 = "right";
        goto L21
    }

    public final void A(xy8.d r9, int r10, String r11, String r12) {
        if (this.k.contains(Integer.valueOf(r10)) == false) goto L5;
        return;
    L5:
        this.k.add(Integer.valueOf(r10));
        int r13 = b.a[r9.e.ordinal()];
        boolean r0 = true;
        if (r13 != 1) goto L8;
        String r14 = "enter_picture_detail";
    L12:
        JSONObject r1 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r2 = r9.f.entrySet().iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        Map.Entry<String, Object> r3 = r2.next();
        r1.put(r3.getKey(), r3.getValue());
        goto L14
    L16:
        r1.put("source_type", r9.a.name());
        r1.put("item_key", r9.b);
        r1.put("enter_method", r11);
        r1.put("position", r9.q);
        SourceType r4 = r9.a;
        SourceType r5 = SourceType.USER_SEND;
        if (r4 != r5) goto L19;
        String r6 = "user";
    L20:
        r1.put("user_type", r6);
        xy8.e r7 = r9.m;
        Object r8 = null;
        if (r7 == null) goto L31;
        String r15 = r7.e;
        if (r15 == null) goto L31;
        if ((!StringsKt.isBlank(r15)) == true) goto L28;
        r15 = null;
    L28:
        if (r15 == null) goto L31;
        r1.put("creation_task_id", r15);
    L31:
        if (r9.e != GalleryType.Video) goto L59;
        if (r9.a != r5) goto L35;
        String r16 = "1";
    L36:
        r1.put("is_upload_video", r16);
        xy8.g r17 = r9.d;
        if (r17 == null) goto L46;
        String r18 = r17.a;
        if (r18 == null) goto L46;
        if ((!StringsKt.isBlank(r18)) == true) goto L44;
        r18 = null;
    L44:
        if (r18 == null) goto L46;
        r1.put("video_id", r18);
    L46:
        Object r19 = r9.f.get("previous_page");
        if (r19 != null) goto L49;
        r19 = r9.f.get("enter_from");
    L49:
        if (r19 == null) goto L59;
        String r20 = r19.toString();
        if (r20 == null) goto L59;
        if ((!StringsKt.isBlank(r20)) == true) goto L56;
        r20 = null;
    L56:
        if (r20 == null) goto L59;
        r1.put("previous_page", r20);
        goto L59
    L35:
        r16 = TriggerSendLoading.NO_LOADING;
    L59:
        if (r12.length() > 0) goto L62;
        r0 = false;
    L62:
        if (r0 == false) goto L64;
        r1.put("slide_status", r12);
    L64:
        com.larus.platform.service.o.a.reportEvent(r14, r1);
        if (Intrinsics.areEqual(r9.j.get("_mixed_richmedia_enter_detail_trace"), "1") == false) goto L86;
        String r21 = r9.j.get("_mixed_richmedia_enter_detail_params");
        if (r21 == null) goto L84;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L71
        Object r22 = Result.constructor-impl(new JSONObject(r21));     // Catch: Throwable -> L71
    L74:
        if (Result.isFailure-impl(r22) == true) goto L77;
        r8 = r22;
    L77:
        JSONObject r23 = (JSONObject) r8;
        if (r23 == null) goto L85;
        r23.put("enter_method", r11);
        com.larus.platform.service.o.a.reportEvent("mixed_richmedia_enter_detail", r23);
        return;
    L85:
        return;
    L71:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L74
    L84:
        return;
    L86:
        return;
    L19:
        r6 = "bot";
        goto L20
    L8:
        if (r13 == 2) goto L10;
        r14 = "enter_custom_detail";
        goto L12
    L10:
        r14 = "enter_video_detail";
        goto L12
    }
}
