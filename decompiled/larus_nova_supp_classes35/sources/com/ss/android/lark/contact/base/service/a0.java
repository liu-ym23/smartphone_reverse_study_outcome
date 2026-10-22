package com.ss.android.lark.contact.base.service;

import android.os.SystemClock;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a0 {
    public static final ConcurrentHashMap<String, Long> a = null;
    public static final ConcurrentHashMap<String, String> b = null;
    public static final a c = null;
    public static final a d = null;
    public static final a e = null;

    public static final class a {
        public final Scene a;

        public a(Scene r2) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            this.a = r2;
        }

        public final void b(Event r22, ErrorResult r23) {
            Intrinsics.checkNotNullParameter(r22, "event");
            Intrinsics.checkNotNullParameter(r23, "err");
            Intrinsics.checkNotNullParameter(r22, "event");
            Intrinsics.checkNotNullParameter(r23, "err");
            AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.UserGrowth, this.a, r22, ErrorType.SDK, ErrorLevel.Fatal, r23.getErrorCode(), BuildConfig.FLAVOR, BuildConfig.FLAVOR, r23.getMessage(), true, null, null, null, 7168, null));
        }

        public final void c(Event r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r8, "event");
            String r10 = AppreciableKit.Companion.getInstance().start(Biz.UserGrowth, this.a, r8, BuildConfig.FLAVOR, r9);
            a0.b.put(r8.name(), r10);
            a0.a.put(r8.name(), Long.valueOf(SystemClock.uptimeMillis()));
        }

        public static void a(Event r8, Map r9, Map r10, Map r11) {
            Intrinsics.checkNotNullParameter(r8, "event");
            ConcurrentHashMap<String, String> r0 = a0.b;
            String r3 = r0.get(r8.name());
            if (r3 != null) goto L5;
            return;
        L5:
            String r1 = r0.remove(r8.name());
            a0.b(r8.name());
            AppreciableKit.Companion.getInstance().end(r3, null, r9, r10, r11);
        }
    }

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new a(Scene.Invite);
        d = new a(Scene.Contact);
        e = new a(Scene.DyResource);
    }

    public static void a(ErrorResult r19) {
        Intrinsics.checkNotNullParameter(r19, "err");
        AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.Messenger, Scene.Contact, Event.add_contacts, ErrorType.SDK, ErrorLevel.Fatal, r19.getErrorCode(), "GET_CONTACT_TOKEN_V2", "InviteExternalView", r19.getMessage(), Boolean.TRUE, null, null, null, 7168, null));
    }

    public static long b(String r5) {
        ConcurrentHashMap<String, Long> r0 = a;
        Long r1 = r0.get(r5);
        if (r1 == null) goto L6;
        long r2 = r1.longValue();
        r0.remove(r5);
        return SystemClock.uptimeMillis() - r2;
    L6:
        return 0;
    }

    public static void c(boolean r7) {
        if (r7 == false) goto L5;
        String r8 = AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Contact, Event.contact_opt_approve_friend_fetch, "contact_opt_approve_friend_fetch", true);
        b.put("contact_opt_approve_friend_fetch", r8);
        a.put("contact_opt_approve_friend_fetch", Long.valueOf(SystemClock.uptimeMillis()));
        return;
    L5:
        ConcurrentHashMap<String, String> r9 = b;
        String r0 = r9.get("contact_opt_approve_friend_fetch");
        if (r0 != null) goto L8;
        return;
    L8:
        String r10 = r9.remove("contact_opt_approve_friend_fetch");
        AppreciableKit.Companion.getInstance().end(r0);
    }

    public static void d(boolean r15) {
        if (r15 == false) goto L5;
        String r16 = AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Contact, Event.enter_contact_applications, "contact_applications_page", true);
        b.put("contact_applications_page", r16);
        a.put("contact_applications_page", Long.valueOf(SystemClock.uptimeMillis()));
        return;
    L5:
        ConcurrentHashMap<String, String> r17 = b;
        String r8 = r17.get("contact_applications_page");
        if (r8 != null) goto L8;
        return;
    L8:
        String r18 = r17.remove("contact_applications_page");
        long r0 = b("contact_applications_page");
        AppreciableKit.end$default(AppreciableKit.Companion.getInstance(), r8, MapsKt.mapOf(TuplesKt.to("sdk_cost", Long.valueOf(r0))), null, null, null, 28, null);
    }

    public static void e(boolean r14) {
        String r0 = "ContactExternalView".concat("V2");
        if (r14 == false) goto L5;
        b.put(r0, AppreciableKit.start$default(AppreciableKit.Companion.getInstance(), Biz.Messenger, Scene.Contact, Event.show_external_contacts, r0, true, null, null, MapsKt.mapOf(TuplesKt.to("member_count", DocTabPayload.DocType.UNKNOWN)), null, 352, null));
        a.put(r0, Long.valueOf(SystemClock.uptimeMillis()));
        return;
    L5:
        ConcurrentHashMap<String, String> r15 = b;
        String r3 = r15.get(r0);
        if (r3 != null) goto L8;
        return;
    L8:
        String r16 = r15.remove(r0);
        long r1 = b(r0);
        AppreciableKit.end$default(AppreciableKit.Companion.getInstance(), r3, MapsKt.mapOf(new Pair[]{TuplesKt.to("sdk_cost", 0L), TuplesKt.to("init_view_cost", Long.valueOf(r1)), TuplesKt.to("first_render", Long.valueOf(r1))}), null, null, null, 28, null);
    }

    public static void f(boolean r10) {
        if (r10 == false) goto L5;
        b.put("InviteExternalContactView", AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Contact, Event.show_address_book, "InviteExternalContactView", true));
        a.put("InviteExternalContactView", Long.valueOf(SystemClock.uptimeMillis()));
        return;
    L5:
        ConcurrentHashMap<String, String> r11 = b;
        String r3 = r11.get("InviteExternalContactView");
        if (r3 != null) goto L8;
        return;
    L8:
        String r12 = r11.remove("InviteExternalContactView");
        long r0 = b("InviteExternalContactView");
        AppreciableKit.end$default(AppreciableKit.Companion.getInstance(), r3, MapsKt.mapOf(new Pair[]{TuplesKt.to("sdk_cost", 0L), TuplesKt.to("init_view_cost", Long.valueOf(r0)), TuplesKt.to("first_render", Long.valueOf(r0))}), null, null, MapsKt.mapOf(TuplesKt.to("source_type", 1)), 12, null);
    }

    public static void g(boolean r10) {
        if (r10 == false) goto L5;
        b.put("InviteExternalView", AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Contact, Event.add_contacts, "InviteExternalView", true));
        a.put("InviteExternalView", Long.valueOf(SystemClock.uptimeMillis()));
        return;
    L5:
        ConcurrentHashMap<String, String> r11 = b;
        String r3 = r11.get("InviteExternalView");
        if (r3 != null) goto L8;
        return;
    L8:
        String r12 = r11.remove("InviteExternalView");
        long r0 = b("InviteExternalView");
        AppreciableKit.end$default(AppreciableKit.Companion.getInstance(), r3, MapsKt.mapOf(new Pair[]{TuplesKt.to("link_cost", Long.valueOf(r0)), TuplesKt.to("qrcode_cost", Long.valueOf(r0)), TuplesKt.to("init_view_cost", Long.valueOf(r0)), TuplesKt.to("first_render", Long.valueOf(r0))}), null, null, null, 28, null);
    }
}
