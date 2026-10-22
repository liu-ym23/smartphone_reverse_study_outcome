package com.bytedance.ies.argus.bean;

import ai.j0;
import android.content.Context;
import android.text.TextUtils;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import androidx.room.writer.DaoWriter;
import av.h;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;
import com.bytedance.crash.util.g;
import com.google.gson.Gson;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import l9.q;
import mh.e;
import org.json.JSONArray;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static b f5123i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f5126c;
    public Object d;
    public final Serializable e;
    public final Object f;
    public Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f5127h;

    public b() {
        this.f5124a = 0;
        Intrinsics.checkNotNullParameter(new ib.d(2), "verifyMode");
        this.f5126c = ArgusVerifyAction.f5092b;
        this.d = "unset";
        this.f5125b = 0;
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new ArrayList();
        this.f5127h = new ArrayList();
    }

    public static b a() {
        if (f5123i != null) goto L6;
        f5123i = new b(n.f4057a);
    L6:
        return f5123i;
    }

    public static void g(b r5, d r10, String r11, int r12) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        Intrinsics.checkNotNullParameter(r10, "reason");
        ArgusVerifyAction r13 = ArgusVerifyAction.f5092b;
        if (r11 == null) goto L8;
        String r14 = r10.a() + ": " + r11;
    L9:
        ((ArrayList) r5.g).add(r14);
        r5.f5126c = r13;
        r5.d = r14;
        r5.f5125b = r10.getCode();
        return;
    L8:
        r14 = r10.a();
        goto L9
    }

    public ArrayList b(File r11, String r12) {
        File[] r13 = r11.listFiles(new h(r12, 6));
        ArrayList r5 = new ArrayList();
        if (r13 != null) goto L5;
        return r5;
    L5:
        io.reactivex.exceptions.a.i("foundRuntimeContextFiles " + r13.length);
        int r10 = r13.length;
        q r14 = null;
        int r15 = 0;
    L6:
        if (r15 >= r10) goto L22;
        q r16 = new q(r13[r15]);     // Catch: Throwable -> L18
        r5.add(r16);     // Catch: Throwable -> L18
        if (((q) this.g) != null) goto L20;
        if (".ctx2".equals(r12) == false) goto L20;
        if (r14 == null) goto L17;
        if (r16.f19587b < r14.f19587b) goto L20;
    L17:
        r14 = r16;
    L20:
        r15 = r15 + 1;
    L18:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L20
    L22:
        if (((q) this.g) != null) goto L25;
        if (r14 == null) goto L25;
        this.g = r14;
    L25:
        Collections.sort(r5, new ca.d(23));
        return r5;
    }

    public JSONObject c(ArgusVerifyAction r14) {
        Intrinsics.checkNotNullParameter(r14, "action");
        Map r5 = MapsKt.toMap((LinkedHashMap) this.f);
        JSONObject r10 = new JSONObject();
        com.bytedance.ies.argus.util.c.a(r14.f5094a, "action", r10);
        com.bytedance.ies.argus.util.c.a(Integer.valueOf(this.f5125b), "reason_code", r10);
        com.bytedance.ies.argus.util.c.a((String) this.d, "reason", r10);
        ArrayList r15 = (ArrayList) this.g;
        if (r15.size() > 1) goto L6;
        r15 = null;
    L6:
        if (r15 == null) goto L10;
        List r11 = CollectionsKt.toList(r15);
        if (r11 == null) goto L10;
        String r16 = CollectionsKt.q(r11, ">", null, null, 0, null, null, 62);
    L11:
        com.bytedance.ies.argus.util.c.a(r16, "reason_trace", r10);
        Map r13 = MapsKt.toMap((LinkedHashMap) this.e);
        if (r13.isEmpty() == false) goto L15;
        r13 = null;
    L15:
        if (r13 == null) goto L17;
        JSONObject r17 = com.bytedance.ies.argus.util.b.a(r13);
    L18:
        com.bytedance.ies.argus.util.c.a(r17, "info", r10);
        com.bytedance.ies.argus.util.c.a(null, "rewrite_payload", r10);
        Iterator r18 = r5.entrySet().iterator();
    L20:
        if (r18.hasNext() == false) goto L29;
        Map.Entry r19 = (Map.Entry) r18.next();
        String r12 = (String) r19.getKey();
        Object r110 = r19.getValue();
        Gson r20 = (Gson) com.bytedance.ies.argus.util.b.f5173a.getValue();
        Intrinsics.checkNotNullParameter(r20, "<this>");
        if ((r110 instanceof String) == false) goto L25;
        String r111 = (String) r110;     // Catch: Exception -> L27
    L28:
        com.bytedance.ies.argus.util.c.a(r111, r12, r10);
        goto L20
    L25:
        r111 = r20.toJson(r110);     // Catch: Exception -> L27
    L27:
        r111 = "";
        goto L28
    L29:
        return r10;
    L17:
        r17 = null;
    L10:
        r16 = null;
        goto L11
    }

    public void d(long r10) {
        File r5 = (File) this.f5126c;
        Iterator r11 = b(r5, ".allData").iterator();
    L3:
        q r12 = null;
        if (r11.hasNext() == false) goto L10;
        q r13 = (q) r11.next();
        if (r10 < r13.f19586a) goto L3;
        if (r10 > r13.f19587b) goto L3;
    L11:
        if (r13 != null) goto L21;
        Iterator r14 = b(r5, ".allData").iterator();
    L14:
        if (r14.hasNext() == false) goto L20;
        q r15 = (q) r14.next();
        long r16 = r15.f19587b;
        if (r10 <= r16) goto L18;
        r15.e = r16;
        r12 = r15;
        goto L14
    L18:
        if (r12 != null) goto L20;
        r15.e = r16;
        r13 = r15;
    L20:
        r13 = r12;
    L21:
        if (r13 == null) goto L35;
        new JSONArray(cl.a.D(r13.f19588c.getAbsolutePath()));     // Catch: Throwable -> L24
        return;
    L36:
        return;
    L35:
        return;
    L10:
        r13 = null;
        goto L11
    }

    public void e(long r10, long r11, JSONObject r12, JSONArray r13) {
        File r5 = (File) this.f5126c;
        File r14 = new File(r5, r10 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r11 + ".ctx2");
        File r15 = new File(r5, r10 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r11 + ".allData");
        cl.a.q(r14, r12);     // Catch: Throwable -> L5
        cl.a.p(r15, r13);     // Catch: Throwable -> L5
        this.g = new q(r14);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    }

    public void f(Map r15, JSONArray r16) {
        if (r15 == null) goto L68;
        r15.putAll(com.lynx.tasm.base.a.g());
        JSONObject r5 = Header.a().b(r15);
        if (Header.e(r5) == true) goto L69;
        z8.c r10 = new z8.c();
        e.g(r5, "header", r10.f23416a);
        r10.g((ICommonParams) n.d().f17503c);
        r10.k(n.f4063k.f4023a);
        int r11 = n.f4069q;
        String r12 = n.f4070r;
        e.g(Integer.valueOf(r11), "miniapp_id", r10.f23416a);
        e.g(r12, "miniapp_version", r10.f23416a);
        long r13 = n.f4059c;
        long r14 = System.currentTimeMillis();
        if (((q) this.g) != null) goto L11;
        b((File) this.f5126c, ".ctx2");
    L11:
        q r17 = (q) this.g;
        if (r17 != null) goto L16;
        e(r13, r14, r10.f23416a, r16);
        return;
    L16:
        if (r17.d == null) goto L64;
    L21:
        JSONObject r18 = r17.d;
        JSONObject r19 = r10.f23416a;
        int r110 = 0;
        if (Header.e(r18) == false) goto L25;
    L38:
        char r20 = 2;
    L39:
        if (r20 == 1) goto L46;
        if (r20 != 2) goto L42;
        e(r13, r14, r10.f23416a, r16);
    L62:
        ArrayList r21 = b((File) this.f5126c, "");     // Catch: Throwable -> L55
        if (r21.size() > 16) goto L52;
        return;
    L52:
        if (r110 >= (r21.size() - 8)) goto L70;
        ((q) r21.get(r110)).f19588c.delete();     // Catch: Throwable -> L55
        r110 = r110 + 1;
        goto L52
    L70:
        return;
    L55:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        return;
    L42:
        if (r20 != 3) goto L62;
        r17.f19587b = r14;
        String r22 = r17.f19588c.getParent();
        StringBuilder r23 = new StringBuilder();
        r23.append(r17.f19586a);
        r23.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r17.f19588c.renameTo(new File(r22, j0.o(r23, r17.f19587b, ".ctx2")));
        goto L62
    L46:
        e(r17.f19586a, r14, r10.f23416a, r16);
        cl.a.C(r17.f19588c);
        goto L62
    L25:
        if (Header.e(r19) == false) goto L28;
        r20 = 0;
        goto L39
    L28:
        if (String.valueOf(r19.opt("update_version_code")).equals(String.valueOf(r18.opt("update_version_code"))) == false) goto L38;
        if (e.n(r18) == true) goto L37;
        String r24 = r18.optString(WsConstants.KEY_APP_ID);
        if (TextUtils.isEmpty(r24) == true) goto L37;
        if (Integer.parseInt(r24) > 0) goto L38;
    L37:
        r20 = 1;
        goto L39
    L64:
        r17.d = new JSONObject(cl.a.D(r17.f19588c.getAbsolutePath()));     // Catch: Throwable -> L59
    L19:
        if (r17.d != null) goto L21;
        r17.d = new JSONObject();
        goto L21
    L69:
        return;
    }

    public String toString() {
        switch(this.f5124a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return "action=" + ((ArgusVerifyAction) this.f5126c).f5094a + ",payload=null,reason=" + ((String) this.d);
    }

    public b(Context r10) {
        this.f5124a = 1;
        this.f5125b = -1;
        this.f5127h = null;
        String r5 = g.f4181a;
        String r11 = g.h(r10);
        StringBuilder r12 = new StringBuilder();
        r12.append(x8.a.f22982a);
        if (m.q(r10) == false) goto L5;
        String r13 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
    L6:
        r12.append(r13.replaceAll(":", "@"));
        File r14 = new File(r11, r12.toString());
        if (r14.exists() == true) goto L9;
    L12:
        r14.mkdirs();
        m9.c.f20033z = true;
    L13:
        this.f5126c = r14;
        this.d = new File(r14.getParent(), "did");
        this.e = new File(r14.getParent(), "device_uuid");
        this.f = r10;
        return;
    L9:
        if (r14.isDirectory() == true) goto L13;
        if (r14.delete() == false) goto L13;
    L5:
        r13 = m.o(r10);
        goto L6
    }
}
