package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.VSShowChatMessageCommentRoleConfig;
import com.bytedance.android.livesdkapi.message.OfficialCommentConfig;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 implements d {
    public final q5 a;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final com.bytedance.android.live.base.model.data.k getContentExt() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int getScore() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean h() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean i() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean a() {
        return this.a.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final List<String> b() {
        return this.a.b();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String d() {
        OfficialCommentConfig r0 = this.a.getOfficialCommentConfig();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBackgroundColor();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final CharSequence getChatContent() {
        VSShowChatMessageCommentRoleConfig r0 = this.a.G0();
        String r1 = BuildConfig.FLAVOR;
        if (r0 == null) goto L6;
        String r2 = r0.getCharactorName();
        if (r2 == null) goto L6;
    L7:
        String r3 = this.a.getChatContent();
        if (r3 == null) goto L12;
        r1 = r3;
    L12:
        return r2.concat(r1);
    L6:
        r2 = BuildConfig.FLAVOR;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final o1 getLandscapeAreaCommon() {
        return this.a.getLandscapeAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final j0 getMedal() {
        return this.a.getMedal();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final long getMessageId() {
        return this.a.getMessageId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final IBaseUser getUserInfo() {
        return this.a.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean isSelfSendFake() {
        return this.a.isSelfSendFake();
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
        return this.a;
    }

    public d0(q5 r2) {
        Intrinsics.checkNotNullParameter(r2, "showChatMessage");
        this.a = r2;
    }
}
