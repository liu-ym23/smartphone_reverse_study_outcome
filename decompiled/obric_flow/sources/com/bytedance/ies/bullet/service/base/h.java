package com.bytedance.ies.bullet.service.base;

import android.view.View;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface h {
    View a();

    void a(String r5, Object r10);

    void a(Map r5);

    boolean a(String r5);

    SccConfig.SccLevel b();

    void b(Map r5);

    void c();

    void d();

    void destroy();

    void e();

    String f();

    boolean g();

    KitType h();
}
