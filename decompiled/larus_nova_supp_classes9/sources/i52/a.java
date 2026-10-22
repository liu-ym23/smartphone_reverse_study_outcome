package i52;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePluginType;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a implements h52.c {
    public boolean a;
    public IBaseUser b;
    public String c;
    public String d;
    public IPublicAreaCommon e;
    public e f;
    public a5 g;
    public long h;
    public h52.c.a i;
    public final MessageModelType j;
    public final MessageBinderType k;
    public final MessagePluginType l;
    public final long m;

    @Override // h52.c
    public final h52.c.a getTextInfo() {
        h52.c.a r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textInfo");
    L5:
        return r0;
    }

    @Override // h52.c
    public final MessageBinderType a() {
        return this.k;
    }

    @Override // h52.c
    public final e b() {
        return this.f;
    }

    @Override // h52.c
    public final long d() {
        return this.h;
    }

    @Override // h52.c
    public final long getMessageId() {
        return this.m;
    }

    @Override // h52.c
    public final IBaseUser getUser() {
        return this.b;
    }

    @Override // h52.c
    public final void c(com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d r1) {
        this.f = r1;
    }

    public a(MessageModelType r2, MessageBinderType r3, MessagePluginType r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "modelType");
        Intrinsics.checkNotNullParameter(r3, "binderType");
        Intrinsics.checkNotNullParameter(r4, "pluginType");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.a = true;
        this.h = System.currentTimeMillis();
    }
}
