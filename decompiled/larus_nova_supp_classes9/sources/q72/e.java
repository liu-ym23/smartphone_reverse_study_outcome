package q72;

import android.graphics.Bitmap;
import com.bytedance.android.live.base.model.data.k;
import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements com.bytedance.android.livesdk.interactivity.api.publicscreen.d {
    public Bitmap a;
    public boolean b;
    public Bitmap c;
    public boolean d;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d e;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean a() {
        return this.e.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final List<String> b() {
        return this.e.b();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String d() {
        return this.e.d();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final String e() {
        return this.e.e();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean f() {
        return this.e.f();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean g() {
        return this.e.g();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final CharSequence getChatContent() {
        return this.e.getChatContent();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final k getContentExt() {
        return this.e.getContentExt();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final o1 getLandscapeAreaCommon() {
        return this.e.getLandscapeAreaCommon();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final j0 getMedal() {
        return this.e.getMedal();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final t getMessage() {
        return this.e.getMessage();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final long getMessageId() {
        return this.e.getMessageId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int getScore() {
        return this.e.getScore();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final IBaseUser getUserInfo() {
        return this.e.getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean h() {
        return this.e.h();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean i() {
        return this.e.i();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean isSelfSendFake() {
        return this.e.isSelfSendFake();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final int k() {
        return this.e.k();
    }

    public e(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r2) {
        Intrinsics.checkNotNullParameter(r2, "talentMessage");
        this.e = r2;
    }
}
