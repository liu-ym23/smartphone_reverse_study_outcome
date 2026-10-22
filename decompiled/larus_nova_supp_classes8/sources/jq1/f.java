package jq1;

import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.v;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements b {
    public final h4 b;

    @Override // jq1.b
    public final List<String> b() {
        return null;
    }

    @Override // jq1.b
    public final long getAgreeMsgId() {
        return 0;
    }

    @Override // jq1.b
    public final o1 getLandscapeAreaCommon() {
        return null;
    }

    @Override // jq1.b
    public final /* bridge */ /* synthetic */ j0 getMedal() {
        return null;
    }

    @Override // jq1.b
    public final String h() {
        return "";
    }

    @Override // jq1.b
    public final k i() {
        return null;
    }

    @Override // jq1.b
    public final boolean isSelfSendFake() {
        return false;
    }

    @Override // jq1.b
    public final boolean a() {
        return this.b.isOfficialDanmaku();
    }

    @Override // jq1.b
    public final String d() {
        v r0 = this.b.getEffect();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBackgroundColor();
    }

    @Override // jq1.b
    public final CharSequence getChatContent() {
        String r0 = this.b.getChatContent();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
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

    public f(h4 r2) {
        Intrinsics.checkNotNullParameter(r2, "screenMessage");
        this.b = r2;
    }
}
