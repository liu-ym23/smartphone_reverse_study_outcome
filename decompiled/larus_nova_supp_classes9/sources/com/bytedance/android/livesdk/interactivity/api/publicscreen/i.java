package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class i {
    public boolean a;
    public long b;
    public PSMessageAction c;
    public u42.b d;
    public Long e;
    public String f;
    public Long g;

    public interface a {
        z92.a a(com.bytedance.android.live.base.model.message.t r1);
    }

    public abstract j<? extends i, ? extends PSMessageViewHolder> b();

    public abstract IPublicAreaCommon c();

    public long d() {
        return 0;
    }

    public boolean e() {
        return false;
    }

    public abstract IBaseUser f();

    public boolean g() {
        return false;
    }

    public abstract PublicScreenConfig$MessageModelType getType();

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public DisplayTimeRecorder j() {
        return null;
    }

    public i() {
        this.c = PSMessageAction.UNKNOW;
    }

    public PSMessageAction a() {
        return this.c;
    }
}
