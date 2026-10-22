package m2a;

import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.platform.uimodel.MediaEntity;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static MediaEntity a(String r32) {
        JSONObject r0 = new JSONObject(r32);
        String r1 = r0.optString("aweme_id");
        Intrinsics.checkNotNull(r1);
        if (r1.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        String r4 = null;
        if (r2 == false) goto L9;
        String r7 = r1;
    L10:
        if (r7 != null) goto L12;
        return null;
    L12:
        JSONObject r3 = r0.optJSONObject(LynxResourceModule.VIDEO_TYPE);
        JSONObject r5 = r0.optJSONObject("author");
        if (r3 == null) goto L15;
        String r16 = r3.toString();
    L16:
        if (r3 == null) goto L22;
        JSONObject r6 = r3.optJSONObject("cover");
        if (r6 == null) goto L22;
        JSONArray r8 = r6.optJSONArray("url_list");
        if (r8 == null) goto L22;
        String r13 = r8.optString(0);
    L23:
        if (r3 == null) goto L25;
        Integer r14 = Integer.valueOf(r3.optInt("width", 0));
    L26:
        if (r3 == null) goto L28;
        Integer r15 = Integer.valueOf(r3.optInt("height", 0));
    L29:
        if (r5 == null) goto L31;
        String r24 = r5.optString("uid");
    L32:
        if (r5 == null) goto L35;
        r4 = r5.optString("nickname");
    L35:
        return new MediaEntity(null, r7, null, null, null, null, null, r13, r14, r15, r16, null, Integer.valueOf(SourceFrom.DouYin.value), null, null, null, 0, null, r24, r4, null, null, null, null, 15984765, null);
    L31:
        r24 = null;
        goto L32
    L28:
        r15 = null;
        goto L29
    L25:
        r14 = null;
    L22:
        r13 = null;
        goto L23
    L15:
        r16 = null;
        goto L16
    L9:
        r7 = null;
        goto L10
    L5:
        r2 = false;
        goto L6
    }
}
