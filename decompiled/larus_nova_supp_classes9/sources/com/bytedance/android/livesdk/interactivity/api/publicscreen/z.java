package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.q1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class z implements d, e, f {
    public final k0 a;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean a() {
        return false;
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
    public final /* bridge */ /* synthetic */ j0 getMedal() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean h() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final List<String> b() {
        q1 r0 = this.a.getLandscapeAreaCommon();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getColorList();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final long c() {
        return this.a.getEventTime();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final CharSequence getChatContent() {
        String r0 = this.a.getChatContent();
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final o1 getLandscapeAreaCommon() {
        return this.a.getLandscapeAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final long getMessageId() {
        return this.a.getMessageId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.f
    public final long getPriorityScore() {
        m0 r0 = this.a.getBaseMessage();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getPriorityScore();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final long getReceiveTime() {
        return this.a.getReceiveTime();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int getScore() {
        m0 r0 = this.a.getBaseMessage();
        if (r0 == null) goto L5;
        long r1 = r0.getPriorityScore();
    L7:
        return (int) (r1 % ((long) 100));
    L5:
        r1 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final IBaseUser getUserInfo() {
        return this.a.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public boolean i() {
        return this.a.isHotChat();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean isSelfSendFake() {
        return this.a.isSelfSendFake();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final boolean isSendReview() {
        return this.a.isSendReview();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final String j() {
        return this.a.getChatContent();
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

    public z(k0 r2) {
        Intrinsics.checkNotNullParameter(r2, "chatMessage");
        this.a = r2;
    }
}
