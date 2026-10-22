package c5;

import ai.j0;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.bumptech.glide.request.d;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.ies.web.jsbridge2.o;
import com.gyf.barlibrary.SimpleImmersionFragment;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.tasm.r;
import en.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import w8.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements en.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1119c;
    public Object d;

    public /* synthetic */ a(int r5, boolean r10) {
        this.f1117a = r5;
    }

    public long a(String r10, long r11) {
        Context r5 = (Context) this.f1119c;
        if (this.f1118b == true) goto L6;
        Cursor r12 = r5.getContentResolver().query(WsChannelMultiProcessSharedProvider.b(r5, r10, "long"), null, null, null, null);     // Catch: Throwable -> L20
        if (r12 == null) goto L27;
    L17:
        r12.close();
        return r11;
    L11:
        if (r12.moveToFirst() == false) goto L14;
        long r13 = r12.getLong(0);     // Catch: Throwable -> L17
    L21:
        r12.close();     // Catch: Exception -> L19 Throwable -> L20
    L26:
        return r13;
    L14:
        r13 = r11;
        goto L21
    L27:
        return r11;
    L6:
        return ((SharedPreferences) this.d).getLong(r10, r11);
    L28:
        return r11;
    }

    public boolean b(String r10, boolean r11) {
        Context r5 = (Context) this.f1119c;
        if (this.f1118b == true) goto L6;
        Cursor r12 = r5.getContentResolver().query(WsChannelMultiProcessSharedProvider.b(r5, r10, "boolean"), null, null, null, null);     // Catch: Throwable -> L21
        if (r12 == null) goto L28;
    L18:
        r12.close();
        return r11;
    L11:
        if (r12.moveToFirst() == false) goto L15;
        boolean r13 = false;
        if (r12.getInt(0) <= 0) goto L22;
        r13 = true;
    L22:
        r12.close();     // Catch: Exception -> L20 Throwable -> L21
    L27:
        return r13;
    L15:
        r13 = r11;
        goto L22
    L28:
        return r11;
    L6:
        return ((SharedPreferences) this.d).getBoolean(r10, r11);
    L29:
        return r11;
    }

    public boolean c(com.bumptech.glide.request.b r5) {
        boolean r10 = true;
        if (r5 != null) goto L5;
        return true;
    L5:
        boolean r11 = ((Set) this.d).remove(r5);
        if (((ArrayList) this.f1119c).remove(r5) == true) goto L10;
        if (r11 == true) goto L10;
        r10 = false;
    L10:
        if (r10 == false) goto L12;
        ((d) r5).c();
    L12:
        return r10;
    }

    public void d() {
        SimpleImmersionFragment r5 = (SimpleImmersionFragment) this.f1119c;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.f1118b == true) goto L7;
        return;
    L7:
        if (r5.getUserVisibleHint() == false) goto L12;
        ((SimpleImmersionFragment) this.d).getClass();
        ((SimpleImmersionFragment) this.d).c();
        return;
    }

    public String toString() {
        switch(this.f1117a) {
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r5 = new StringBuilder();
        r5.append(super.toString());
        r5.append("{numRequests=");
        r5.append(((Set) this.d).size());
        r5.append(", isPaused=");
        return j0.r(r5, this.f1118b, "}");
    L5:
        return super.toString();
    }

    public a(int r5) {
        this.f1117a = r5;
        switch(r5) {
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        this.f1119c = new ArrayList();
        this.d = new ArrayList();
        return;
    L6:
        this.d = Collections.newSetFromMap(new WeakHashMap());
        this.f1119c = new ArrayList();
    }

    @Override // en.c
    public void a() {
        ((en.c) this.d).a();
    }

    public a(Context r5) {
        this.f1117a = 6;
        boolean r10 = false;
        this.f1118b = false;
        String r11 = t8.a.a(r5);
        if (r11 != null) goto L5;
    L7:
        if (r11 != null) goto L9;
    L13:
        this.f1118b = r10;
        Context r12 = r5.getApplicationContext();
        this.f1119c = r12;
        this.d = r12.getApplicationContext().getSharedPreferences("wschannel_multi_process_config", 4);
        if (Logger.debug() == false) goto L17;
        Logger.v("PushService", "MultiProcessShared create");
        return;
    L17:
        return;
    L9:
        if (r11.equals(r5.getPackageName()) == false) goto L13;
        if (WsChannelMultiProcessSharedProvider.g == false) goto L13;
        r10 = true;
        goto L13
    L5:
        if (r11.contains(":") == false) goto L7;
        goto L7
    }

    public a(BaseAbility r5, Context r10) {
        this.f1117a = 7;
        this.f1118b = false;
        this.f1119c = r5;
        this.d = r10;
    }

    public a(r r5, l r10) {
        this.f1117a = 5;
        this.f1119c = r10;
        this.f1118b = false;
        this.d = new en.a();
    }

    public a(File r5, boolean r10) {
        this.f1117a = 1;
        this.d = null;
        this.f1119c = r5;
        this.f1118b = r10;
    }

    public a(String r5, com.lynx.animax.player.b r10) {
        this.f1117a = 3;
        this.f1118b = true;
        this.f1119c = r5;
        this.d = r10;
    }

    public a(LinkedHashSet r5, LinkedHashSet r10, boolean r11) {
        this.f1117a = 4;
        o.e.a();
        this.f1119c = new LinkedHashSet(r5);
        this.d = new LinkedHashSet(r10);
        this.f1118b = r11;
    }

    public a(xc.a r5, f r10) {
        this.f1117a = 10;
        Intrinsics.checkNotNullParameter(r5, "appInfo");
        Intrinsics.checkNotNullParameter(r10, "network");
        this.f1119c = r5;
        this.d = r10;
    }

    public a(File[] r5, boolean r10) {
        this.f1117a = 1;
        this.f1119c = null;
        this.d = r5;
        this.f1118b = r10;
    }
}
