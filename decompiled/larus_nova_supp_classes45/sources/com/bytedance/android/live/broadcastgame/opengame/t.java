package com.bytedance.android.live.broadcastgame.opengame;

import android.net.Uri;
import androidx.collection.LruCache;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformMiniAppDebugger;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.File;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t {
    public static final /* synthetic */ int q = 0;
    public long a;
    public String b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final boolean f;
    public final boolean g;
    public final long h;
    public final String i;
    public final String j;
    public final Map<String, ? extends Object> k;
    public com.bytedance.android.live.broadcastgame.opengame.runtime.g l;
    public File m;
    public final String n;
    public final PluginType o;
    public final boolean p;

    public static final class a {
        public static int a(String r6) {
            Intrinsics.checkNotNullParameter(r6, "schema");
            PluginType.Companion.getClass();
            boolean r3 = true;
            if (PluginType.a.a(r6) == PluginType.LYNX) goto L5;
        L7:
            Intrinsics.checkNotNullParameter(r6, "$this$isPreviewVersion");
            LruCache r1 = LiveSchemaInfo.r;
            LiveSchemaInfo r2 = LiveSchemaInfo.c.a(r6);
            if (r2 == null) goto L10;
            String r4 = (String) r2.d.getValue();
        L12:
            if (Intrinsics.areEqual(r4, "preview") == false) goto L14;
        L36:
            return 2;
        L14:
            if (PluginType.a.a(r6) != PluginType.MINI_APP) goto L35;
            int r5 = OpenPlatformMiniAppDebugger.h;
            if (OpenPlatformMiniAppDebugger.Companion.b(r6) == true) goto L36;
            Intrinsics.checkNotNullParameter(r6, "schema");
            if (r6.length() != 0) goto L20;
            boolean r0 = true;
        L21:
            if (r0 == true) goto L32;
            Uri r7 = UriProtector.parse(r6);
            if (Intrinsics.areEqual(r7.getHost(), "microapp") == false) goto L32;
            if (Intrinsics.areEqual(UriProtector.getQueryParameter(r7, "version_type"), "latest") == false) goto L28;
        L33:
            if (r3 == false) goto L35;
        L28:
            if (Intrinsics.areEqual(UriProtector.getQueryParameter(r7, "version_type"), "audit") == true) goto L33;
            if (Intrinsics.areEqual(UriProtector.getQueryParameter(r7, "version_type"), "preview") == true) goto L33;
        L32:
            r3 = false;
            goto L33
        L20:
            r0 = false;
        L35:
            return 0;
        L10:
            r4 = null;
            goto L12
        L5:
            if (com.bytedance.android.live.broadcastgame.api.openplatform.k.a(r6) == false) goto L7;
            return 1;
        }
    }

    static {
    }

    public final String c() {
        Object r0 = this.k.get("OPEN_APP_NAME");
        if ((r0 instanceof String) == true) goto L6;
        r0 = null;
    L6:
        return (String) r0;
    }

    public final u e() {
        Object r0 = this.k.get("game");
        if ((r0 instanceof u) == true) goto L6;
        r0 = null;
    L6:
        return (u) r0;
    }

    public final String a() {
        u r0 = e();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.name;
    }

    public final String b(boolean r2) {
        if (r2 == false) goto L7;
        String r3 = a();
        if (r3 != null) goto L11;
        return "";
    L11:
        return r3;
    L7:
        r3 = c();
        if (r3 != null) goto L11;
        return "";
    }

    public final int d(boolean r4) {
        Object r1 = null;
        if (r4 == false) goto L13;
        Object r5 = this.k.get("game");
        if ((r5 instanceof u) == false) goto L8;
        r1 = r5;
    L8:
        u r2 = (u) r1;
        if (r2 == null) goto L21;
        com.bytedance.android.live.broadcastgame.api.model.r r6 = r2.c();
        if (r6 != null) goto L23;
        return 0;
    L23:
        return r6.g();
    L21:
        return 0;
    L13:
        Object r7 = this.k.get("business_type");
        if ((r7 instanceof Integer) == false) goto L17;
        r1 = r7;
    L17:
        Integer r3 = (Integer) r1;
        if (r3 != null) goto L20;
        return 0;
    L20:
        return r3.intValue();
    }

    public t(long r2, String r4, String r5, Map r6, String r7, PluginType r8) {
        Intrinsics.checkNotNullParameter(r4, "appId");
        Intrinsics.checkNotNullParameter(r5, "appVersion");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "schemaUrl");
        Intrinsics.checkNotNullParameter(r8, "pluginType");
        this.h = r2;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.l = null;
        this.m = null;
        this.n = r7;
        this.o = r8;
        this.p = false;
        this.a = -1;
        this.b = "";
        Object r3 = r6.get("is_support_single_game_cast");
        Boolean r9 = Boolean.TRUE;
        this.f = Intrinsics.areEqual(r3, r9);
        this.g = Intrinsics.areEqual(r6.get("auto_cast_game"), r9);
    }
}
