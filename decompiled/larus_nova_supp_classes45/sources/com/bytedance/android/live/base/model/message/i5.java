package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface i5 extends vh7.c<i5> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ String getLeftAdditionalContent();

    String getPostfixString();

    String getPrefixString();

    /* synthetic */ String getRightAdditionalContent();

    /* synthetic */ boolean getSelfShowRealName();

    IBaseUser getUser();

    /* synthetic */ boolean getWithColon();

    boolean isWithColon();

    boolean selfShowRealName();

    void setUser(IBaseUser r1);

    void setWithColon(boolean r1);
}
