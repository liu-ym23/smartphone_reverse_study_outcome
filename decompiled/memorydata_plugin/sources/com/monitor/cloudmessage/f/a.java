package com.monitor.cloudmessage.f;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.e.e;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.f.b.b;
import com.monitor.cloudmessage.utils.NetworkUtils;
import com.monitor.cloudmessage.utils.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ArrayList<com.monitor.cloudmessage.f.b.a> f5854a;

    static {
        f5854a = new ArrayList();
    }

    private static String a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        int r0 = r4.lastIndexOf(".");
        if (r0 != (-1)) goto L11;
        StringBuilder r5 = new StringBuilder().append(r4);
    L10:
        return r5.append("-cloudMsg.zip").toString();
    L11:
        r5 = new StringBuilder().append(r4.substring(0, r0));
        goto L10
    }

    public static void a(com.monitor.cloudmessage.f.b.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.b() != null) goto L6;
        return;
    L6:
        if (r3.b().c().size() != 0) goto L9;
        return;
    L9:
        if (b(r3) == true) goto L12;
        return;
    L12:
        if (r3.d() == true) goto L14;
        r3.a(r3.b().c());
    L15:
        boolean r0 = com.monitor.cloudmessage.f.c.a.a(r3);
        if (r3.f() == false) goto L31;
        if (r0 == false) goto L32;
        Iterator<String> r4 = r3.b().c().iterator();
    L20:
        if (r4.hasNext() == false) goto L34;
        File r1 = new File((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin"));
        if (r1.exists() == false) goto L20;
        r1.delete();
        goto L20
    L34:
        return;
    L32:
        return;
    L31:
        return;
    L14:
        c(r3);
        goto L15
    }

    public static void a(b r4) {
        if (com.bytedance.apm.b.k() == false) goto L5;
        e.d("cloudmessage", new String[]{"uploadInfo=" + r4});
    L5:
        if (r4 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r4.k()) == true) goto L12;
        com.monitor.cloudmessage.f.c.a.a(r4);
        return;
    }

    private static boolean b(com.monitor.cloudmessage.f.b.a r6) {
        if (r6.j() == false) goto L6;
        return false;
    L6:
        if (r6.c() == true) goto L11;
        if ((System.currentTimeMillis() - r6.i()) >= 0) goto L11;
        return false;
    L11:
        if (NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L13;
        return false;
    L13:
        return true;
    }

    private static void c(com.monitor.cloudmessage.f.b.a r9) {
        if (r9.b().c().size() != 1) goto L5;
    L14:
        File r0 = new File((String) ZeusTransformUtils.preCheckCast(r9.b().c().get(0), String.class, "com.obric.memorydata.plugin"));
        File r1 = new File(r0.getParent(), a(r0.getName()));
        if (r1.exists() == false) goto L17;
        r1.delete();
    L17:
        c.a(r1.getAbsolutePath(), (String[]) ZeusTransformUtils.preCheckCast(r9.b().c().toArray(new String[r9.b().c().size()]), String[].class, "com.obric.memorydata.plugin"));
        ArrayList r2 = new ArrayList(1);
        r2.add(r1.getAbsolutePath());
    L18:
        r9.a(r2);
        return;
    L5:
        if (r9.e() == true) goto L14;
        r2 = new ArrayList();
        Iterator<String> r4 = r9.b().c().iterator();
    L9:
        if (r4.hasNext() == false) goto L18;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        File r6 = new File(r5);
        File r7 = new File(r6.getParent(), a(r6.getName()));
        if (r7.exists() == false) goto L13;
        r7.delete();
    L13:
        c.a(r7.getAbsolutePath(), new String[]{r5});
        r2.add(r7.getAbsolutePath());
        goto L9
    }
}
