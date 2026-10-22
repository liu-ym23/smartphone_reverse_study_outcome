package com.ss.android.lark.integrator.security.compliance.screen_audit;

import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.security_event.CommonDrawer;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.pb.security_event.Extend;
import com.ss.android.lark.pb.security_event.RenderItem;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.auditsdk.screen.d {

    /* JADX INFO: renamed from: com.ss.android.lark.integrator.security.compliance.screen_audit.a$a, reason: collision with other inner class name */
    public static final class C0123a {
    }

    static {
    }

    @Inject
    public a() {
    }

    public final void a() {
        Intrinsics.checkNotNullParameter("", "currentPage");
        int r0 = com.ss.android.lark.auditsdk.wrapper.a.a;
        d("recording", c(com.ss.android.lark.auditsdk.wrapper.a.a.b()));
    }

    public final void b() {
        Intrinsics.checkNotNullParameter("", "currentPage");
        int r0 = com.ss.android.lark.auditsdk.wrapper.a.a;
        d("screenshot", c(com.ss.android.lark.auditsdk.wrapper.a.a.c()));
    }

    public static Event.Builder c(Event.Builder r2) {
        RenderItem r0 = new RenderItem.Builder().Key("source").Value(Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL).build();
        CommonDrawer r1 = new CommonDrawer.Builder().ItemList(CollectionsKt.listOf(r0)).build();
        return r2.Extend(new Extend.Builder().CommonDrawer(r1).build());
    }

    public static void d(String r3, Event.Builder r4) {
        owa.a.a().getClass();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r4, "builder");     // Catch: Throwable -> L5
        com.ss.android.lark.auditsdk.wrapper.b.d.a.a(r4);     // Catch: Throwable -> L5
        Log.i("OfficeSDKScreenAudit", "audit posted, type=".concat(r3));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e("OfficeSDKScreenAudit", "audit post failed, type=".concat(r3), th);
    }
}
