package com.bytedance.android.live.broadcast.rts;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface g {
    String a();

    void b();

    Function2<String, Map<String, String>, Unit> c();

    String d();

    Function0<Unit> e();

    void f();

    String getAnchorId();

    String getRoomId();

    String getSource();
}
