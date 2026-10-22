package to1;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.live.datacontext.m;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.reactivex.functions.Function;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final Object apply(Object r18) {
        String r2 = (String) r18;
        o r0 = o3.f();
        if (r0 == null) goto L5;
        Boolean r1 = r0.isVSRoom();
    L7:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L43;
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L43;
        Boolean r6 = o3.f().isPortraitInteraction();
        if (r6 == null) goto L18;
        boolean r7 = r6.booleanValue();
    L19:
        Boolean r8 = o3.f().isVSVerticalStream();
        if (r8 == null) goto L22;
        boolean r9 = r8.booleanValue();
    L23:
        eq1.b r4 = new eq1.b(r7, r9);
        this.a.getClass();
        ALogger.e("tag_banner_TOP", "JsEventCase->handleVSSchemaUrl prev: \n" + r2);     // Catch: Exception -> L41
        JsonParser r10 = new JsonParser();     // Catch: Exception -> L41
        JsonObject r11 = r10.parse(r2).getAsJsonObject();     // Catch: Exception -> L41
        JsonArray r12 = r10.parse(r11.get("add_list").getAsString()).getAsJsonArray();     // Catch: Exception -> L41
        Iterator<T> r13 = r12.iterator();     // Catch: Exception -> L41
    L26:
        if (r13.hasNext() == false) goto L39;
        JsonObject r14 = ((JsonElement) r13.next()).getAsJsonObject();     // Catch: Exception -> L41
        JsonObject r15 = r10.parse(r14.get("item_data").getAsString()).getAsJsonObject();     // Catch: Exception -> L41
        String r5 = r15.get("schema_url").getAsString();     // Catch: Exception -> L41
        if (r5 != null) goto L30;
    L33:
        boolean r16 = true;
    L34:
        if (r16 == true) goto L38;
        String r17 = r4.b(r5);     // Catch: Exception -> L41
        if (r17 == null) goto L38;
        r15.addProperty("schema_url", r17);     // Catch: Exception -> L41
    L38:
        r14.addProperty("item_data", r15.toString());     // Catch: Exception -> L41
        goto L26
    L30:
        if (r5.length() == 0) goto L33;
        r16 = false;
        goto L34
    L39:
        r11.addProperty("add_list", r12.toString());     // Catch: Exception -> L41
        String r19 = GsonHelper.getDefault().toJson(r11);     // Catch: Exception -> L41
        ALogger.e("tag_banner_TOP", "JsEventCase->handleVSSchemaUrl after: \n" + r19);     // Catch: Exception -> L41
        r2 = r19;
    L41:
        e = move-exception;
        ALogger.e("tag_banner_TOP", "JsEventCase->handleVSSchemaUrl exception: " + e);
        goto L43
    L22:
        r9 = false;
        goto L23
    L18:
        r7 = true;
        goto L19
    L10:
        if (r2.length() == 0) goto L13;
        r3 = false;
    L43:
        JSONObject r20 = new JSONObject();
        r20.put("type", "refresh");
        r20.put("data", r2);
        r20.put("log", this.a.c());
        o r21 = z51.a.h(null, 3);
        if (r21 == null) goto L54;
        m r22 = r21.getRoom();
        if (r22 == null) goto L54;
        IRoom r23 = (IRoom) r22.getValue();
        if (r23 == null) goto L54;
        IRoomAuthStatus r24 = r23.getRoomAuthStatus();
        if (r24 == null) goto L54;
        if (r24.enableBanner() != true) goto L54;
        boolean r25 = true;
    L55:
        r20.put("enable", r25);
        return r20;
    L54:
        r25 = false;
        goto L55
    L5:
        r1 = null;
        goto L7
    }
}
