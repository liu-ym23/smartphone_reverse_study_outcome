package iy;

import android.content.Context;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.liveinteract.plantform.utils.l;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import ny.o;
import ny.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface h {
    void A4(JsonObject r1);

    ApiServerException B4(int r1, String r2);

    boolean C4();

    Integer O0();

    void Q1();

    String d();

    int g();

    Context getContext();

    IRoomBase getRoom();

    void m4();

    void n4(Function0<Unit> r1, Function0<Unit> r2);

    void o4(t r1, ei6.a r2);

    void p4();

    Object q4();

    l r4();

    void s4(JSONObject r1);

    boolean t4();

    Object u4(String r1, o r2);

    boolean v4();

    void w4(JsonObject r1);

    void x4();

    long y4();

    void z4(ny.e r1, ec6.a r2, Function0 r3, Function0 r4);
}
