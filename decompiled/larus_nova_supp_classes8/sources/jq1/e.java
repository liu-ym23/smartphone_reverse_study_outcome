package jq1;

import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.q1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements b {
    public final k0 b;

    @Override // jq1.b
    public final boolean a() {
        return false;
    }

    @Override // jq1.b
    public final String d() {
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
    public final List<String> b() {
        q1 r0 = this.b.getLandscapeAreaCommon();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getColorList();
    }

    @Override // jq1.b
    public final long getAgreeMsgId() {
        return this.b.getAgreeMsgId();
    }

    @Override // jq1.b
    public final CharSequence getChatContent() {
        String r0 = this.b.getContent();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // jq1.b
    public final o1 getLandscapeAreaCommon() {
        return this.b.getLandscapeAreaCommon();
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

    public e(k0 r2) {
        Intrinsics.checkNotNullParameter(r2, "chatMessage");
        this.b = r2;
    }
}
