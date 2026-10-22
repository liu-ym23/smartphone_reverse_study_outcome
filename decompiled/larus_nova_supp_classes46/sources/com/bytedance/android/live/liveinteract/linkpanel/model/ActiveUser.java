package com.bytedance.android.live.liveinteract.linkpanel.model;

import am3.g;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/model/ActiveUser;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/a;", "", "isIsActive", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "isActive", "Z", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ActiveUser extends FlexModelBase<com.bytedance.android.livesdk.multilink.base.model.a> implements com.bytedance.android.livesdk.multilink.base.model.a, h {

    @SerializedName("is_active")
    public boolean isActive;

    @SerializedName("user")
    public IBaseUser user;

    public ActiveUser() {
        super(com.bytedance.android.livesdk.multilink.base.model.a.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public ActiveUser(g r6) {
        super(com.bytedance.android.livesdk.multilink.base.model.a.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.user = f.a(r6, IBaseUser.class);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.isActive = am3.h.a(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    public IBaseUser getUser() {
        return this.user;
    }

    public boolean isIsActive() {
        return this.isActive;
    }
}
