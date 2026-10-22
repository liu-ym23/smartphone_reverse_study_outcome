package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface g {
    void A(String r1, String r2);

    void X0(String r1, String r2);

    NextLiveData<String> c();

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    String mo696c();

    long d();

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    NextLiveData<String> mo697d();

    void e(String r1);

    void f(String r1, String r2);

    void f0(boolean r1);

    NextLiveData<Boolean> g();

    NextLiveData<Boolean> getBattleStatus();

    int getCloudCollaboratePanelType();

    void h();

    void i(boolean r1, String r2, List<String> r3, String r4, String r5);

    void j(com.bytedance.android.live.revlink.link.domain.anchorimpl.j r1);

    void k(String r1, String r2, String r3);

    boolean l();

    void m(String r1, String r2);

    boolean n();

    void reset();

    void s(String r1, String r2);

    void x(boolean r1);
}
