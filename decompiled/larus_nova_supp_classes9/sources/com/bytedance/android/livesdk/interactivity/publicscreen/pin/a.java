package com.bytedance.android.livesdk.interactivity.publicscreen.pin;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.pin.PublicScreenPinType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.j;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder;
import com.bytedance.android.livesdkapi.message.ChatMentionInfo;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import kotlin.jvm.internal.Intrinsics;
import u42.h;
import u42.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements u42.b {
    public boolean a;
    public final boolean b;
    public Long c;
    public final PublicScreenPinType d;
    public f<?> e;
    public final e52.a f;

    @Override // u42.b
    public final void b() {
        this.a = true;
    }

    @Override // u42.b
    public final int getPriority() {
        return -1;
    }

    @Override // u42.b
    public final long h() {
        IPublicAreaCommon r0 = this.e.v();
        if (r0 == null) goto L7;
        ChatMentionInfo r1 = r0.getChatMentionInfo();
        if (r1 == null) goto L7;
        long r2 = r1.getShowTime();
    L9:
        return r2 * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
    L7:
        r2 = 0;
        goto L9
    }

    @Override // u42.b
    public final boolean a() {
        return this.a;
    }

    @Override // u42.b
    public final boolean e() {
        return this.b;
    }

    @Override // u42.b
    public final f<?> getMessage() {
        return this.e;
    }

    @Override // u42.b
    public final Long getShowTimestamp() {
        return this.c;
    }

    @Override // u42.b
    public PublicScreenPinType getType() {
        return this.d;
    }

    @Override // u42.b
    public final void c(u42.e r4) {
        Intrinsics.checkNotNullParameter(r4, "pinContext");
        u42.f.a("MentionChatPinHandler onpin, duration: " + r4.a);
    }

    @Override // u42.b
    public final void d(f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    @Override // u42.b
    public final void f(h r2) {
        Intrinsics.checkNotNullParameter(r2, "unpinContext");
        u42.f.a("MentionChatPinHandler onUnpin");
    }

    @Override // u42.b
    public final void g(Long r1) {
        this.c = r1;
    }

    @Override // u42.b
    public final View i(c.b r5) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        TextMessageRenderViewHolder.f r6 = j.a(r5.getContext());
        k<f<?>> r1 = this.f.g();
        Intrinsics.checkNotNull(r1);
        TextMessageRenderViewHolder r0 = new TextMessageRenderViewHolder(r6, r1, false, this.f);
        f<?> r7 = this.e;
        g52.e r2 = this.f.getTextConfig();
        r0.a = r7;
        r0.U3(r7, 0, r2);
        return ((RecyclerView.ViewHolder) r0).itemView;
    }

    @Override // u42.b
    public final long j(i r3) {
        Intrinsics.checkNotNullParameter(r3, "updatePinContext");
        Intrinsics.checkNotNullParameter(r3, "updatePinContext");
        return 0;
    }

    public a(f<?> r2, e52.a r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "textMessageConfig");
        this.e = r2;
        this.f = r3;
        this.b = true;
        this.d = PublicScreenPinType.MENTION_CHAT;
    }
}
