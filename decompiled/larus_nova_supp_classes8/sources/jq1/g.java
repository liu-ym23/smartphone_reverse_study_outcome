package jq1;

import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.VSShowChatMessageCommentRoleConfig;
import com.bytedance.android.livesdkapi.message.OfficialCommentConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements b {
    public final q5 b;

    @Override // jq1.b
    public final boolean a() {
        return this.b.a();
    }

    @Override // jq1.b
    public final List<String> b() {
        return this.b.b();
    }

    @Override // jq1.b
    public final String d() {
        OfficialCommentConfig r0 = this.b.getOfficialCommentConfig();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBackgroundColor();
    }

    @Override // jq1.b
    public final long getAgreeMsgId() {
        return this.b.getAgreeMsgId();
    }

    @Override // jq1.b
    public final CharSequence getChatContent() {
        VSShowChatMessageCommentRoleConfig r0 = this.b.G0();
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.getCharactorName();
        if (r2 == null) goto L6;
    L7:
        String r3 = this.b.getChatContent();
        if (r3 == null) goto L12;
        r1 = r3;
    L12:
        return r2.concat(r1);
    L6:
        r2 = "";
        goto L7
    }

    @Override // jq1.b
    public final o1 getLandscapeAreaCommon() {
        return this.b.getLandscapeAreaCommon();
    }

    @Override // jq1.b
    public final j0 getMedal() {
        return this.b.getMedal();
    }

    @Override // jq1.b
    public final long getMessageId() {
        return this.b.getMessageId();
    }

    @Override // jq1.b
    public final IBaseUser getUserInfo() {
        return this.b.getUserInfo();
    }

    @Override // jq1.b
    public final String h() {
        VSShowChatMessageCommentRoleConfig r0 = this.b.G0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCharactorName();
    }

    @Override // jq1.b
    public final k i() {
        VSShowChatMessageCommentRoleConfig r0 = this.b.G0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCharactorAvatar();
    }

    @Override // jq1.b
    public final boolean isSelfSendFake() {
        return this.b.isSelfSendFake();
    }

    @Override // jq1.b
    public final String c() {
        return b.C0394b.a(this);
    }

    @Override // jq1.b
    public final String e() {
        return b.C0394b.b(this);
    }

    @Override // jq1.b
    public final boolean f() {
        return b.C0394b.c(this);
    }

    @Override // jq1.b
    public final boolean g() {
        return b.C0394b.d(this);
    }

    public g(q5 r2) {
        Intrinsics.checkNotNullParameter(r2, "showChatMessage");
        this.b = r2;
    }
}
