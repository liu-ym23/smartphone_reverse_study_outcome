package ngb;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.CalendarContent;
import com.bytedance.lark.pb.basic.v1.CalendarEventMessageCard;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.flow.chat.message.downgrade.data.LarkDowngradeCalendarContent;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements gya.a<LarkDowngradeCalendarContent> {
    public a() {
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final MessageType a() {
        return MessageType.CALENDAR;
    }

    public static JsonObject j(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isJsonObject() == true) goto L8;
        r3 = null;
    L8:
        if (r3 != null) goto L10;
        return null;
    L10:
        return r3.getAsJsonObject();
    }

    public final String d(Context r2, Content r3) {
        LarkDowngradeCalendarContent r4 = (LarkDowngradeCalendarContent) r3;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "content");
        return r4.getTitle();
    }

    public final String f(Context r2, Content r3) {
        LarkDowngradeCalendarContent r4 = (LarkDowngradeCalendarContent) r3;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "content");
        return r4.getTitle();
    }

    public final String h(Context r1, f5b.b r2) {
        gya.a.a.a(r1, r2);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LarkDowngradeCalendarContent k(Message r11, com.bytedance.lark.pb.basic.v1.Content r12) {
        Intrinsics.checkNotNullParameter(r11, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r12, "pbContent");
        CalendarContent r13 = r12.calendar_content;
        String r14 = null;
        if (r13 == null) goto L5;
        CalendarEventMessageCard r0 = r13.event_card;
    L6:
        LarkDowngradeCalendarContent r1 = new LarkDowngradeCalendarContent();
        boolean r2 = true;
        if (r0 == null) goto L19;
        String r4 = r0.summary;
        if (r4 == null) goto L19;
        if (r4.length() <= 0) goto L13;
        boolean r5 = true;
    L14:
        String r6 = r4;
        if (Boolean.valueOf(r5).booleanValue() == true) goto L18;
        r6 = 0;
    L18:
        if (r6 == 0) goto L19;
    L55:
        r1.setTitle(r6);
        if (r0 == null) goto L60;
        Long r15 = r0.end_time;
        if (r15 == null) goto L60;
        long r16 = r15.longValue();
    L61:
        r1.setEndTime(r16);
        return r1;
    L60:
        r16 = -1;
        goto L61
    L13:
        r5 = false;
    L19:
        if (r13 == null) goto L21;
        String r17 = r13.payload;
    L23:
        if (r17 != null) goto L25;
    L28:
        Object r3 = "";
        if (r2 == false) goto L63;
    L30:
        r6 = r3;
        goto L55
    L63:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L48
        JsonObject r18 = j(JsonParser.parseString(r17).getAsJsonObject(), "title");     // Catch: Throwable -> L48
        if (r18 == null) goto L44;
        JsonObject r19 = j(r18, "elements");     // Catch: Throwable -> L48
        if (r19 == null) goto L44;
        JsonObject r110 = j(r19, "title");     // Catch: Throwable -> L48
        if (r110 == null) goto L44;
        JsonObject r111 = j(r110, "property");     // Catch: Throwable -> L48
        if (r111 == null) goto L44;
        JsonElement r112 = r111.get("content");     // Catch: Throwable -> L48
        if (r112 == null) goto L44;
        String r8 = r112.getAsString();     // Catch: Throwable -> L48
        if (r8 == null) goto L44;
        r14 = StringsKt.replace$default(r8, "\n", "", false, 4, null);     // Catch: Throwable -> L48
    L44:
        if (r14 != null) goto L46;
        r14 = "";
    L46:
        Object r113 = Result.constructor-impl(r14);     // Catch: Throwable -> L48
    L51:
        if (Result.isFailure-impl(r113) == true) goto L54;
        r3 = r113;
    L54:
        r3 = (String) r3;
    L48:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L51
    L25:
        if (StringsKt.isBlank(r17) == true) goto L28;
        r2 = false;
        goto L28
    L21:
        r17 = null;
        goto L23
    L5:
        r0 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ Content g(Entity r1, Message r2, com.bytedance.lark.pb.basic.v1.Content r3) {
        return k(r2, r3);
    }

    public final Content e(Entity r1, Message r2, com.bytedance.lark.pb.basic.v1.Content r3, TranslateInfo r4) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r3, "pbContent");
        return k(r2, r3);
    }

    public final void i(com.bytedance.lark.pb.basic.v1.Content r1, BaseTextContent<?> r2, String r3, Entity r4) {
        gya.a.a.b(r1, r2, r3);
    }
}
