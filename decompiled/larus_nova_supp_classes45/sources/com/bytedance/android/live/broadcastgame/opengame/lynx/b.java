package com.bytedance.android.live.broadcastgame.opengame.lynx;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final /* synthetic */ int d = 0;
    public List<C0063b> a;
    public String b;
    public long c;

    public static final class a {
        public static b a(JSONObject r8) throws JSONException {
            Intrinsics.checkNotNullParameter(r8, "json");
            b r0 = new b();
            Intrinsics.checkNotNullParameter(JSONObjectProtectorUtils.getString(r8, "version"), "<set-?>");
            Intrinsics.checkNotNullParameter(JSONObjectProtectorUtils.getString(r8, "appid"), "<set-?>");
            Intrinsics.checkNotNullParameter(r8.optString("cli_version"), "<set-?>");
            JSONObject r1 = r8.optJSONObject("globalConfig");
            if (r1 == null) goto L6;
            String r3 = r1.optString("panelHeightType");
            if (r3 == null) goto L6;
        L7:
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r0.b = r3;
            if (r1 == null) goto L10;
            long r4 = r1.optLong("networkTimeout");
        L11:
            r0.c = r4;
            JSONArray r9 = JSONObjectProtectorUtils.getJSONArray(r8, "views");
            int r2 = r9.length();
            ArrayList r5 = new ArrayList();
            int r6 = 0;
        L12:
            if (r6 >= r2) goto L14;
            r5.add(JSONArrayProtectorUtils.getJSONObject(r9, r6));
            r6 = r6 + 1;
            goto L12
        L14:
            ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator r7 = r5.iterator();
        L16:
            if (r7.hasNext() == false) goto L29;
            JSONObject r12 = (JSONObject) r7.next();
            C0063b r13 = new C0063b();
            String r14 = r12.optString("type");
            Intrinsics.checkNotNullParameter(r14, "<set-?>");
            r13.a = r14;
            String r15 = r13.getType();
            int r16 = r15.hashCode();
            if (r16 == (-2094363978)) goto L26;
            if (r16 != 106433028) goto L28;
            if (r15.equals("panel") == false) goto L28;
            r13.c = r12.optString("entry");
            String r17 = r12.optString("alias");
            Intrinsics.checkNotNullParameter(r17, "<set-?>");
            r13.b = r17;
        L28:
            r11.add(r13);
            goto L16
        L26:
            if (r15.equals("entrance") == false) goto L28;
            r12.optJSONObject("icon");
            goto L28
        L29:
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            r0.a = r11;
            return r0;
        L10:
            r4 = 60000;
        L6:
            r3 = "";
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.lynx.b$b, reason: collision with other inner class name */
    public static final class C0063b {
        public String a;
        public String b;
        public String c;

        public C0063b() {
            this.a = "";
            this.b = "";
        }

        public final String getType() {
            return this.a;
        }
    }

    static {
    }

    public b() {
        this.a = CollectionsKt.emptyList();
        this.b = "";
        this.c = 60000;
    }
}
