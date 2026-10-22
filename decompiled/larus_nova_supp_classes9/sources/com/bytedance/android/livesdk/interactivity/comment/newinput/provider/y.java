package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.content.Context;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y implements com.bytedance.android.livesdk.interactivity.api.expression.j {
    public final /* synthetic */ x a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public final /* synthetic */ Context c;

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void d(String r1, String r2) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void a() {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.b;
        r0.a(r0.a);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void dismissDialog() {
        this.b.J();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final Object g() {
        return this.b.S();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void f(com.bytedance.android.live.base.model.data.activityemoji.b r3) {
        Intrinsics.checkNotNullParameter(r3, "activityEmoji");
        this.b.C(r3);
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r0 = this.b.V();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r1 = r0.g;
        if (r1 == null) goto L9;
        if (r1.q != true) goto L9;
        String r2 = "live_emoji";
    L10:
        com.bytedance.android.livesdk.interactivity.comment.utils.a.c(r3, r2, "tab");
        return;
    L9:
        r2 = "comment_keyboard_emoji";
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void h(com.bytedance.android.livesdk.interactivity.api.emoji.a r6) {
        if (r6 == null) goto L23;
        this.b.g(r6);
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r0 = this.b.V();
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r1 = r0.g;
        if (r1 == null) goto L10;
        if (r1.q != true) goto L10;
        String r2 = "live_emoji";
    L11:
        int r3 = com.bytedance.android.livesdk.interactivity.comment.utils.a.a;
        Intrinsics.checkNotNullParameter(r6, "emoji");
        Intrinsics.checkNotNullParameter(r2, "pattern");
        HashMap r4 = new HashMap();
        r4.put("emoji_send_entrance_pattern", r2);
        String r5 = r6.d();
        String r7 = BuildConfig.FLAVOR;
        if (r5 != null) goto L14;
        r5 = BuildConfig.FLAVOR;
    L14:
        r4.put("emoji_name", r5);
        String r8 = r6.d();
        if (r8 == null) goto L18;
        r7 = r8;
    L18:
        r4.put("emoji_content", r7);
        r4.put("tab", "fusion");
        r4.put("emoji_type", "fusion");
        String r9 = r6.c();
        if (r9 != null) goto L21;
        r9 = "0";
    L21:
        r4.put("emoji_id", r9);
        r4.put("event_page", "emoji_panel");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_emoji_click", r4, new Object[]{am2.x.class, IRoom.class});
        return;
    L10:
        r2 = "comment_keyboard_emoji";
        goto L11
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void i(String r3) {
        x r0 = this.a;
        r0.f = Intrinsics.areEqual("system", r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void c(BaseEmoji r3, String r4) {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.b;
        r0.b(r3, r4, r0.a);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.expression.j
    public final void e(com.bytedance.android.live.base.model.message.h r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "guideChatConf");
        Intrinsics.checkNotNullParameter(r5, "text");
        this.b.l(this.c, r4, r5, "emoji_panel");
    }

    public y(x r1, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
