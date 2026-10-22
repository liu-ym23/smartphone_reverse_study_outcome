package com.ss.android.lark.mention.base.impl.atselector;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.mvp.IModel;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface d extends IModel {

    public interface a {
    }

    void N2(String r1, String r2, IGetDataCallback<ccb.d> r3);

    Map<String, ChatChatter> N4();

    boolean T0();

    void U0(String r1, List<BaseAtBean> r2);

    void U7(IGetDataCallback<List<BaseAtBean>> r1);

    Map<String, BaseAtBean> b3();

    void d1(Map<String, ChatterSensitiveInfo> r1, List<BaseAtBean> r2);

    String e5();

    List<UserGroupEntity> g2();

    void m2(List r1, String r2, IGetDataCallback r3);

    List<BaseAtBean> q3();

    void z1(String r1, String r2, IGetDataCallback<ccb.d> r3);
}
