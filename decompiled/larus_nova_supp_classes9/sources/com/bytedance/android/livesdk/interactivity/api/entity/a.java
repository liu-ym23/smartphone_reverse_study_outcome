package com.bytedance.android.livesdk.interactivity.api.entity;

import android.text.Spannable;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a<T extends t> extends f<T> {
    public tb2.a G;

    public void K() {
    }

    public abstract void L();

    public abstract void M();

    public abstract void O();

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public String h() {
        return "#ff4e33";
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public IBaseUser x() {
        return null;
    }

    public final Spannable N() {
        Spannable r0 = this.G.a;
        if (r0 == null) goto L7;
        if (TextUtils.isEmpty(r0.toString()) == true) goto L7;
    L23:
        return this.G.a;
    L7:
        if (this.b.supportDisplayText() == true) goto L9;
        this.G.a = g();
        goto L23
    L9:
        if (this.b.getBaseMessage() == null) goto L23;
        if (this.b.getBaseMessage().getDisplayText() == null) goto L23;
        va r1 = this.b;
        if ((r1 instanceof va) == false) goto L16;
        Text r2 = r1.F1();
    L17:
        String r3 = r2.getDefaultPattern();
        if (r3 == null) goto L20;
        Logger.d("I18N_MESSAGE", "current message is " + this.b.getMessageMethod());
        this.G = sb2.a.g(r3, r2, j());
        goto L23
    L20:
        Logger.e("I18N_MESSAGE", "pattern is null");
        goto L23
    L16:
        r2 = r1.getBaseMessage().getDisplayText();
        goto L17
    }

    public a(T r2) {
        super(r2, 1);
        this.G = new tb2.a();
    }
}
