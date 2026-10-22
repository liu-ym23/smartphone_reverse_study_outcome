package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.text.Spannable;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.j4;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.p0;
import com.bytedance.android.live.base.model.message.v0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 implements d, p0, f {
    public Spannable a;
    public final v0 b;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final List<String> b() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String d() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final com.bytedance.android.live.base.model.data.k getContentExt() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final o1 getLandscapeAreaCommon() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final /* bridge */ /* synthetic */ j0 getMedal() {
        return null;
    }

    public final a5 getRichText() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int getScore() {
        return 0;
    }

    public final j4 getSelfFakeRichContent() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean h() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean i() {
        return false;
    }

    public final void setSelfFakeRichContent(j4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.f
    public final long c() {
        return this.b.getReceiveTime();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final CharSequence getChatContent() {
        Spannable r0 = this.a;
        if (r0 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r0;
    }

    public final String getDefaultContent() {
        String r0 = this.b.getDefaultContent();
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final long getMessageId() {
        return this.b.getMessageId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.f
    public final long getPriorityScore() {
        m0 r0 = this.b.getBaseMessage();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getPriorityScore();
    }

    public final a5 getRichTextContent() {
        return this.b.getEmojiContent();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final IBaseUser getUserInfo() {
        return this.b.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean isSelfSendFake() {
        return this.b.isInsert();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String e() {
        return d.b.a(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean f() {
        return d.b.c(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean g() {
        return d.b.d(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int k() {
        return d.b.b(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final com.bytedance.android.live.base.model.message.t getMessage() {
        return this.b;
    }

    public final Spannable getRenderSpan() {
        return this.a;
    }

    public a0(v0 r2) {
        Intrinsics.checkNotNullParameter(r2, "emojiChatMessage");
        this.b = r2;
    }

    public final void setRenderSpan(Spannable r1) {
        this.a = r1;
    }
}
