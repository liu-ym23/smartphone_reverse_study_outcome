package com.larus.common_ui.floatwindow.view;

import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface v {
    void a(Function0<Unit> r1);

    void b(SingleFloatWindowState r1, boolean r2);

    void c();

    SingleFloatWindowState d();

    void e();

    Rect f(boolean r1);

    void g();

    void h(e19.h r1, SingleFloatWindowState r2, boolean r3);

    void i(AppCompatActivity r1);

    void removeView(View r1);
}
