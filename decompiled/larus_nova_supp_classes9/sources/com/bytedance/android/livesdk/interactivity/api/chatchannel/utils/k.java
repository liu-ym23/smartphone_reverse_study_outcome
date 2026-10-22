package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.logsdk.format.Spm;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(s22.a r3) {
        return "{channelId: " + r3.getChannelId() + ", channelName:" + ((String) r3.getChannelName().a) + ", isOwner: " + ((Boolean) r3.v().a).booleanValue() + ", count: " + ((Number) r3.d0().a).longValue() + ", linkState: " + ((Boolean) r3.d().a).booleanValue() + ", inviteState: " + ((Boolean) r3.z().a).booleanValue() + "}";
    }

    @JvmStatic
    public static final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a314.a999").addArg("info", r2), "ChatChannelTracer");
    }

    @JvmStatic
    public static final void e(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        b("create success, channelInfo is " + a(r2));
    }

    @JvmStatic
    public static final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "inviteId");
        b("parse inviteId error,inviteId:" + r2);
    }

    @JvmStatic
    public static final void j(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        b("join success, channelInfo is " + a(r2));
    }

    @JvmStatic
    public static final void k(s22.a r3) {
        Intrinsics.checkNotNullParameter(r3, "chatChannel");
        b("update owner, channelId is " + r3.getChannelId() + ", isOwner is " + ((Boolean) r3.v().a).booleanValue() + ", ownerId is " + ((User) r3.getOwner().a).getIdStr());
    }

    @JvmStatic
    public static final void f(s22.a r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r4, "source");
        b("dissolve success, channelId is " + r3.getChannelId() + ", source is " + r4);
    }

    @JvmStatic
    public static final void i(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        b("add item failed, channelId is " + r2 + ", reason is " + r4);
    }

    @JvmStatic
    public static final void l(s22.a r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r4, "source");
        b("quit success, channelId is " + r3.getChannelId() + ", source is " + r4);
    }

    @JvmStatic
    public static final void g(long r2, boolean r4, String r5) {
        b("enable state is " + r4 + ", reason is " + r5 + ", room is " + r2);
    }

    @JvmStatic
    public static final void d(long r2, String r4, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r7, "emojiName");
        b("send chat success, channelId is " + r2 + ", content is " + r4 + ", emojiId is " + r5 + ", emojiName is " + r7);
    }

    @JvmStatic
    public static final void c(long r2, String r4, long r5, String r7, Throwable r8) {
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r7, "emojiName");
        b("send chat failed, channelId is " + r2 + ", content is " + r4 + ", emojiId is " + r5 + ", emojiName is " + r7 + ", reason=" + l.a(r8));
    }
}
