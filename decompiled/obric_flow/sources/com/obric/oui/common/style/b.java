package com.obric.oui.common.style;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    default boolean b() {
        return false;
    }

    void c(List r5);

    boolean d();

    default void f(m r5, m r10) {
        l(r5, r10, false);
    }

    boolean g();

    List getCurrentShadows();

    void j(int r5);

    boolean k();

    void l(m r5, m r10, boolean r11);

    void m(float r5);

    void setWidthMin(int r5);
}
