package com.obric.memorydata.personalcontext.external.schedule;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ICSProtocolEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.utils.aj;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J0\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00070\u00172\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/schedule/ExternalScheduleDataRequester;", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityDataRequester;", "<init>", "()V", "TAG", "", "supportDonateTypes", "", "", "projection", "", "[Ljava/lang/String;", "reminderProjection", "onQueryEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "contentResolver", "Landroid/content/ContentResolver;", "entityIds", "onGetAllEntities", "queryScheduleByIds", "Lcom/obric/capabilitykit/entity/app/ICSProtocolEntity;", "ids", "queryRemindersByEventIds", "", "Lcom/obric/memorydata/personalcontext/external/schedule/ReminderInfo;", "eventIds", "buildIcsString", "data", "Lcom/obric/memorydata/personalcontext/external/schedule/ScheduleRawData;", "getDonateEntityTypeList", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends com.obric.memorydata.personalcontext.external.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12162a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f12163b = null;
    private static final String[] c = null;
    private static final String[] d = null;

    static {
        f12162a = new b();
        f12163b = CollectionsKt.listOf(402);
        c = new String[]{"_id", "title", "eventLocation", "dtstart", "dtend", "allDay", "description", "rrule", "_sync_id", "duration", "eventTimezone", "eventEndTimezone", "rdate", "exrule", "exdate", "eventColor", "original_id", "originalInstanceTime", "originalAllDay"};
        d = new String[]{"event_id", "minutes", "method"};
    }

    private b() {
    }

    private final String a(k r32) {
        f r7 = new f();
        f.a(r7, "PRODID", "-//Obric//MemoryData//EN", null, 4, null);
        f.a(r7, "VERSION", "2.0", null, 4, null);
        f.a(r7, "CALSCALE", "GREGORIAN", null, 4, null);
        h r1 = new h();
        g.a((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin"), "UID", r32.a(), null, 4, null);
        g.a((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin"), "SUMMARY", r32.b(), null, 4, null);
        String r3 = r32.j();
        String r4 = r32.k();
        String r9 = "yyyyMMdd";
        if (r32.f() == false) goto L85;
        ZoneId r15 = ZoneId.of("UTC");
        if (Intrinsics.areEqual(r3, "UTC") == false) goto L269;
        DateTimeFormatter r0 = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss", Locale.US);
        LocalDateTime r5 = LocalDateTime.ofInstant(Instant.ofEpochMilli(r32.c()), r15);
        String r6 = ZoneId.systemDefault().getId();
        Pair r2 = TuplesKt.to(r5, r0);
        r3 = r6;
    L21:
        LocalDateTime r8 = (LocalDateTime) ZeusTransformUtils.preCheckCast(r2.component1(), LocalDateTime.class, "com.obric.memorydata.plugin");
        DateTimeFormatter r10 = (DateTimeFormatter) ZeusTransformUtils.preCheckCast(r2.component2(), DateTimeFormatter.class, "com.obric.memorydata.plugin");
        g r19 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin");
        String r11 = r8.format(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "format(...)");
        g.a(r19, "DTSTART", r11, null, 4, null);
        if (r32.d() <= 0) goto L41;
        if (r4 != null) goto L25;
    L38:
        DateTimeFormatter r12 = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss", Locale.US);
        LocalDateTime r13 = LocalDateTime.ofInstant(Instant.ofEpochMilli(r32.d() - ((long) 1000)), r15);
        String r14 = ZoneId.systemDefault().getId();
        Pair r16 = TuplesKt.to(r13, r12);
        r4 = r14;
    L39:
        LocalDateTime r17 = (LocalDateTime) ZeusTransformUtils.preCheckCast(r16.component1(), LocalDateTime.class, "com.obric.memorydata.plugin");
        DateTimeFormatter r18 = (DateTimeFormatter) ZeusTransformUtils.preCheckCast(r16.component2(), DateTimeFormatter.class, "com.obric.memorydata.plugin");
        g r110 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin");
        String r20 = r17.format(r18);
        Intrinsics.checkNotNullExpressionValue(r20, "format(...)");
        g.a(r110, "DTEND", r20, null, 4, null);
        r7 = r7;
    L40:
        boolean r21 = false;
    L124:
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(r32.e(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r22 != null) goto L127;
    L130:
        boolean r23 = true;
    L131:
        if (r23 == true) goto L133;
        g.a((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin"), "LOCATION", r32.e(), null, 4, null);
    L133:
        CharSequence r24 = (CharSequence) ZeusTransformUtils.preCheckCast(r32.g(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r24 != null) goto L136;
    L139:
        boolean r25 = true;
    L140:
        if (r25 == true) goto L142;
        g.a((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin"), "DESCRIPTION", r32.g(), null, 4, null);
    L142:
        CharSequence r26 = (CharSequence) ZeusTransformUtils.preCheckCast(r32.h(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r26 != null) goto L145;
    L148:
        boolean r27 = true;
    L149:
        if (r27 == true) goto L151;
        g.a((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin"), "RRULE", r32.h(), null, 4, null);
    L151:
        CharSequence r28 = (CharSequence) ZeusTransformUtils.preCheckCast(r32.i(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r28 != null) goto L154;
    L157:
        boolean r29 = true;
    L158:
        if (r29 == true) goto L161;
        if (r21 == true) goto L161;
        g.a((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin"), "DURATION", r32.i(), null, 4, null);
    L161:
        CharSequence r30 = (CharSequence) ZeusTransformUtils.preCheckCast(r32.l(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r30 != null) goto L164;
    L167:
        boolean r31 = true;
    L168:
        if (r31 == true) goto L170;
        g.a((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin"), "RDATE", r32.l(), null, 4, null);
    L170:
        CharSequence r33 = (CharSequence) ZeusTransformUtils.preCheckCast(r32.m(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r33 != null) goto L173;
    L176:
        boolean r34 = true;
    L177:
        if (r34 == true) goto L179;
        g.a((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin"), "EXRULE", r32.m(), null, 4, null);
    L179:
        CharSequence r35 = (CharSequence) ZeusTransformUtils.preCheckCast(r32.n(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r35 != null) goto L182;
    L185:
        boolean r36 = true;
    L186:
        if (r36 == true) goto L189;
        g.a((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin"), "EXDATE", r32.n(), null, 4, null);
    L189:
        if (r32.o() == null) goto L191;
        g r111 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin");
        StringCompanionObject r37 = StringCompanionObject.INSTANCE;
        boolean r112 = false;
        String r38 = String.format(Locale.US, "#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & r32.o().intValue())}, 1));
        Intrinsics.checkNotNullExpressionValue(r38, "format(...)");
        g.a(r111, "COLOR", r38, null, 4, null);
    L193:
        if (r32.p() != null) goto L195;
    L219:
        boolean r39 = true;
    L220:
        CharSequence r40 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r40 != null) goto L223;
    L226:
        boolean r41 = r39;
    L227:
        if (r41 == true) goto L229;
        g.a((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin"), "X-ANDROID-EVENT-TIMEZONE", r3, null, 4, null);
    L229:
        CharSequence r42 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r42 != null) goto L232;
    L235:
        if (r39 == true) goto L237;
        g.a((g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin"), "X-ANDROID-EVENT-END-TIMEZONE", r4, null, 4, null);
    L237:
        Iterator r43 = ((Iterable) ZeusTransformUtils.preCheckCast(r32.r(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L239:
        if (r43.hasNext() == false) goto L266;
        j r44 = (j) ZeusTransformUtils.preCheckCast(r43.next(), j.class, "com.obric.memorydata.plugin");
        e r45 = new e();
        int r46 = r44.b();
        if (r46 != 2) goto L243;
        String r47 = "EMAIL";
    L250:
        g.a((g) ZeusTransformUtils.preCheckCast(r45, g.class, "com.obric.memorydata.plugin"), "ACTION", r47, null, 4, null);
        if (r44.a() != 0) goto L255;
        String r48 = "PT0M";
    L262:
        g.a((g) ZeusTransformUtils.preCheckCast(r45, g.class, "com.obric.memorydata.plugin"), "TRIGGER", r48, null, 4, null);
        if (Intrinsics.areEqual(r47, "DISPLAY") == false) goto L265;
        g.a((g) ZeusTransformUtils.preCheckCast(r45, g.class, "com.obric.memorydata.plugin"), "DESCRIPTION", "Reminder", null, 4, null);
    L265:
        r1.a(r45);
        goto L239
    L255:
        if (r44.a() <= 0) goto L259;
        StringBuilder r49 = new StringBuilder().append("-PT");
        int r50 = r44.a();
    L257:
        r48 = r49.append(r50).append('M').toString();
        goto L262
    L259:
        if (r44.a() != (-1)) goto L261;
        r48 = "-PT10M";
        goto L262
    L261:
        r49 = new StringBuilder().append("PT");
        r50 = Math.abs(r44.a());
        goto L257
    L243:
        if (r46 != 3) goto L245;
        r47 = "SMS";
        goto L250
    L245:
        if (r46 == 4) goto L247;
        r47 = "DISPLAY";
        goto L250
    L247:
        r47 = "AUDIO";
        goto L250
    L266:
        g r51 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin");
        f r52 = r7;
        r52.a(r51);
        return r52.toString();
    L232:
        if (r42.length() == 0) goto L235;
        r39 = r112;
        goto L235
    L223:
        if (r40.length() == 0) goto L226;
        r41 = r112;
        goto L227
    L195:
        if (r32.p().longValue() <= 0) goto L219;
        r39 = true;
        boolean r53 = Intrinsics.areEqual(r32.q(), true);
        if (r53 == true) goto L200;
        r9 = "yyyyMMdd'T'HHmmss";
    L200:
        DateTimeFormatter r54 = DateTimeFormatter.ofPattern(r9, Locale.US);
        CharSequence r55 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L212
        if (r55 != null) goto L204;
    L207:
        boolean r56 = true;
    L208:
        if (r56 == true) goto L210;
        ZoneId r57 = ZoneId.of(r4);     // Catch: Exception -> L212
    L214:
        LocalDateTime r58 = LocalDateTime.ofInstant(Instant.ofEpochMilli(r32.p().longValue()), r57);
        if (r53 == false) goto L217;
        Map<String, String> r59 = MapsKt.mapOf(TuplesKt.to("VALUE", "DATE"));
    L218:
        String r60 = r58.format(r54);
        Intrinsics.checkNotNullExpressionValue(r60, "format(...)");
        r1.a("RECURRENCE-ID", r60, r59);
        goto L220
    L217:
        r59 = MapsKt.emptyMap();
        goto L218
    L210:
        r57 = ZoneId.systemDefault();     // Catch: Exception -> L212
        goto L214
    L204:
        if (r55.length() == 0) goto L207;
        r56 = r112;
    L212:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleDataRequester", "Invalid end timezone: " + r4, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r57 = ZoneId.systemDefault();
        goto L214
    L191:
        r112 = false;
        goto L193
    L182:
        if (r35.length() == 0) goto L185;
        r36 = false;
        goto L186
    L173:
        if (r33.length() == 0) goto L176;
        r34 = false;
        goto L177
    L164:
        if (r30.length() == 0) goto L167;
        r31 = false;
        goto L168
    L154:
        if (r28.length() == 0) goto L157;
        r29 = false;
        goto L158
    L145:
        if (r26.length() == 0) goto L148;
        r27 = false;
        goto L149
    L136:
        if (r24.length() == 0) goto L139;
        r25 = false;
        goto L140
    L127:
        if (r22.length() == 0) goto L130;
        r23 = false;
        goto L131
    L25:
        if (Intrinsics.areEqual(r4, "UTC") == true) goto L38;
    L35:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleDataRequester", "Invalid end timezone: " + r4, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        ZoneId r61 = ZoneId.systemDefault();
    L37:
        r16 = TuplesKt.to(LocalDateTime.ofInstant(Instant.ofEpochMilli(r32.d()), r61), DateTimeFormatter.ofPattern("yyyyMMdd", Locale.US));
        goto L39
    L28:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L30;
        boolean r62 = true;
    L31:
        if (r62 == true) goto L33;
        r61 = ZoneId.of(r4);     // Catch: Exception -> L35
    L271:
        goto L37
    L33:
        r61 = ZoneId.systemDefault();     // Catch: Exception -> L35
        goto L271
    L30:
        r62 = false;
        goto L31
    L41:
        CharSequence r63 = (CharSequence) ZeusTransformUtils.preCheckCast(r32.i(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r63 != null) goto L44;
    L47:
        boolean r64 = true;
    L48:
        if (r64 == true) goto L83;
        String r113 = null;
        MatchResult r65 = Regex.find$default(new Regex("^P(?:(\\d+)W)?(?:(\\d+)D)?"), (CharSequence) ZeusTransformUtils.preCheckCast(r32.i(), CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
        if (r65 == null) goto L79;
        String r66 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r65.getGroupValues(), 1), String.class, "com.obric.memorydata.plugin");
        if (r66 != null) goto L54;
    L64:
        long r114 = 0;
    L65:
        String r67 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r65.getGroupValues(), 2), String.class, "com.obric.memorydata.plugin");
        if (r67 != null) goto L68;
    L77:
        long r210 = 0;
    L78:
        long r68 = (r114 * ((long) 7)) + r210;
    L81:
        if (r68 <= 0) goto L40;
        DateTimeFormatter r69 = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss", Locale.US);
        LocalDateTime r70 = r8.plusDays(r68 - 1).withHour(23).withMinute(59).withSecond(59);
        g r115 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin");
        String r71 = r70.format(r69);
        Intrinsics.checkNotNullExpressionValue(r71, "format(...)");
        g.a(r115, "DTEND", r71, null, 4, null);
        r21 = true;
        goto L124
    L68:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r67, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L70;
        boolean r72 = true;
    L71:
        if (r72 == false) goto L73;
        r113 = r67;
    L73:
        if (r113 == null) goto L77;
        Long r73 = StringsKt.toLongOrNull(r113);
        if (r73 == null) goto L77;
        r210 = r73.longValue();
        goto L78
    L70:
        r72 = false;
        goto L71
    L54:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r66, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L56;
        boolean r116 = true;
    L57:
        if (r116 == true) goto L60;
        r66 = null;
    L60:
        if (r66 == null) goto L64;
        Long r74 = StringsKt.toLongOrNull(r66);
        if (r74 == null) goto L64;
        r114 = r74.longValue();
        goto L65
    L56:
        r116 = false;
        goto L57
    L79:
        r68 = 0;
        goto L81
    L83:
        r7 = r7;
        DateTimeFormatter r75 = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss", Locale.US);
        LocalDateTime r76 = r8.withHour(23).withMinute(59).withSecond(59);
        g r117 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin");
        String r77 = r76.format(r75);
    L84:
        Intrinsics.checkNotNullExpressionValue(r77, "format(...)");
        g.a(r117, "DTEND", r77, null, 4, null);
        goto L40
    L44:
        if (r63.length() == 0) goto L47;
        r64 = false;
        goto L48
    L269:
        CharSequence r78 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
        if (r78 != null) goto L10;
    L13:
        boolean r79 = true;
    L14:
        if (r79 == true) goto L16;
        ZoneId r80 = ZoneId.of(r3);     // Catch: Exception -> L18
    L20:
        r2 = TuplesKt.to(LocalDateTime.ofInstant(Instant.ofEpochMilli(r32.c()), r80), DateTimeFormatter.ofPattern("yyyyMMdd", Locale.US));
        goto L21
    L16:
        r80 = ZoneId.systemDefault();     // Catch: Exception -> L18
        goto L20
    L10:
        if (r78.length() == 0) goto L13;
        r79 = false;
    L18:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleDataRequester", "Invalid timezone: " + r3, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r80 = ZoneId.systemDefault();
        goto L20
    L85:
        r7 = r7;
        CharSequence r81 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L97
        if (r81 != null) goto L89;
    L92:
        boolean r82 = true;
    L93:
        if (r82 == true) goto L95;
        ZoneId r83 = ZoneId.of(r3);     // Catch: Exception -> L97
    L99:
        DateTimeFormatter r84 = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss", Locale.US);
        LocalDateTime r85 = LocalDateTime.ofInstant(Instant.ofEpochMilli(r32.c()), r83);
        g r118 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin");
        String r86 = r85.format(r84);
        Intrinsics.checkNotNullExpressionValue(r86, "format(...)");
        g.a(r118, "DTSTART", r86, null, 4, null);
        if (r32.d() > 0) goto L268;
        CharSequence r87 = (CharSequence) ZeusTransformUtils.preCheckCast(r32.i(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r87 != null) goto L118;
    L121:
        boolean r88 = true;
    L122:
        if (r88 == false) goto L40;
    L123:
        r117 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.memorydata.plugin");
        r77 = r85.format(r84);
        goto L84
    L118:
        if (r87.length() == 0) goto L121;
        r88 = false;
        goto L122
    L268:
        CharSequence r89 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L112
        if (r89 != null) goto L104;
    L107:
        boolean r90 = true;
    L108:
        if (r90 == true) goto L110;
        ZoneId r91 = ZoneId.of(r4);     // Catch: Exception -> L112
    L114:
        r85 = LocalDateTime.ofInstant(Instant.ofEpochMilli(r32.d()), r91);
        goto L123
    L110:
        r91 = ZoneId.systemDefault();     // Catch: Exception -> L112
        goto L114
    L104:
        if (r89.length() == 0) goto L107;
        r90 = false;
    L112:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleDataRequester", "Invalid end timezone: " + r4, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r91 = ZoneId.systemDefault();
        goto L114
    L95:
        r83 = ZoneId.systemDefault();     // Catch: Exception -> L97
        goto L99
    L89:
        if (r81.length() == 0) goto L92;
        r82 = false;
    L97:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleDataRequester", "Invalid timezone: " + r3, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r83 = ZoneId.systemDefault();
        goto L99
    }

    private static final Unit a(List r4, List r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "it");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r9.next(), Map.class, "com.obric.memorydata.plugin")).get("_id"), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.List<com.obric.capabilitykit.entity.app.ICSProtocolEntity>] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List<com.obric.capabilitykit.entity.app.ICSProtocolEntity>] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v33, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List, java.util.List<com.obric.capabilitykit.entity.app.ICSProtocolEntity>] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r56v1 */
    /* JADX WARN: Type inference failed for: r56v2 */
    /* JADX WARN: Type inference failed for: r56v3 */
    /* JADX WARN: Type inference failed for: r56v4 */
    /* JADX WARN: Type inference failed for: r56v5 */
    /* JADX WARN: Type inference failed for: r56v6 */
    /* JADX WARN: Type inference failed for: r56v7 */
    /* JADX WARN: Type inference failed for: r56v8 */
    private final List<ICSProtocolEntity> c(ContentResolver r55, List<String> r56) {
        ?? r1 = "com.obric.memorydata.plugin";
        List<String> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r56, List.class, "com.obric.memorydata.plugin");
        ?? r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r0.isEmpty() == false) goto L5;
        return r2;
    L5:
        Map<String, List<j>> r10 = d(r55, r0);
        String r33 = AppContext.INSTANCE.getUserId();
        Cursor r3 = ZeusProviderTransform.query(r55, CalendarContract.Events.CONTENT_URI, c, "_id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')', null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L116
        if (r3 == null) goto L144;
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r3, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L116
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L105
        int r6 = r5.getColumnIndexOrThrow("_id");     // Catch: Throwable -> L105
        int r7 = r5.getColumnIndexOrThrow("title");     // Catch: Throwable -> L105
        int r8 = r5.getColumnIndexOrThrow("eventLocation");     // Catch: Throwable -> L105
        int r9 = r5.getColumnIndexOrThrow("dtstart");     // Catch: Throwable -> L105
        int r11 = r5.getColumnIndexOrThrow("dtend");     // Catch: Throwable -> L105
        int r12 = r5.getColumnIndexOrThrow("allDay");     // Catch: Throwable -> L105
        int r14 = r5.getColumnIndexOrThrow("description");     // Catch: Throwable -> L105
        int r15 = r5.getColumnIndexOrThrow("rrule");     // Catch: Throwable -> L105
        int r13 = r5.getColumnIndexOrThrow("_sync_id");     // Catch: Throwable -> L105
        int r16 = r5.getColumnIndex("duration");     // Catch: Throwable -> L105
        int r17 = r5.getColumnIndex("eventTimezone");     // Catch: Throwable -> L105
        r4 = r4;
        int r18 = r5.getColumnIndex("eventEndTimezone");     // Catch: Throwable -> L103
        ?? r57 = r2;
        int r19 = r5.getColumnIndex("rdate");     // Catch: Throwable -> L100
        String r34 = "com.obric.memorydata.plugin";
        int r20 = r5.getColumnIndex("exrule");     // Catch: Throwable -> L98
        Map<String, List<j>> r35 = r10;
        int r58 = r5.getColumnIndex("exdate");     // Catch: Throwable -> L98
        int r36 = r5.getColumnIndex("eventColor");     // Catch: Throwable -> L98
        int r37 = r5.getColumnIndex("original_id");     // Catch: Throwable -> L98
        int r38 = r5.getColumnIndex("originalInstanceTime");     // Catch: Throwable -> L98
        int r110 = r5.getColumnIndex("originalAllDay");     // Catch: Throwable -> L98
        r34 = r34;
        r57 = r57;
    L16:
        int r39 = r110;
        if (r5.moveToNext() == false) goto L92;
        String r111 = String.valueOf(r5.getLong(r6));     // Catch: Throwable -> L90
        String r112 = r5.getString(r7);     // Catch: Throwable -> L90
        if (r112 != null) goto L25;
        r112 = "";
    L25:
        long r113 = r5.getLong(r9);     // Catch: Throwable -> L90
        long r21 = r5.getLong(r11);     // Catch: Throwable -> L90
        String r23 = r5.getString(r8);     // Catch: Throwable -> L90
        boolean r24 = true;
        if (r5.getInt(r12) <= 0) goto L28;
        boolean r26 = true;
    L29:
        String r27 = r5.getString(r14);     // Catch: Throwable -> L90
        String r28 = r5.getString(r15);     // Catch: Throwable -> L90
        r5.getString(r13);     // Catch: Throwable -> L90
        if (r16 >= 0) goto L139;
        String r29 = null;
    L33:
        if (r17 < 0) goto L35;
        String r30 = r5.getString(r17);     // Catch: Throwable -> L23
    L36:
        if (r18 < 0) goto L38;
        String r31 = r5.getString(r18);     // Catch: Throwable -> L23
    L39:
        if (r19 < 0) goto L41;
        String r32 = r5.getString(r19);     // Catch: Throwable -> L23
    L42:
        if (r20 < 0) goto L44;
        String r40 = r5.getString(r20);     // Catch: Throwable -> L23
    L45:
        if (r58 < 0) goto L47;
        int r22 = r58;
        String r42 = r5.getString(r22);     // Catch: Throwable -> L23
    L48:
        if (r36 < 0) goto L52;
        r58 = r22;
        int r25 = r36;
        if (r5.isNull(r25) == true) goto L53;
        Integer r310 = Integer.valueOf(r5.getInt(r25));     // Catch: Throwable -> L23
    L54:
        if (r37 < 0) goto L58;
        int r43 = r25;
        int r41 = r37;
        if (r5.isNull(r41) == true) goto L59;
        Long r311 = Long.valueOf(r5.getLong(r41));     // Catch: Throwable -> L23
    L60:
        if (r38 < 0) goto L64;
        int r44 = r41;
        int r45 = r38;
        if (r5.isNull(r45) == true) goto L65;
        Long r312 = Long.valueOf(r5.getLong(r45));     // Catch: Throwable -> L23
    L66:
        if (r39 < 0) goto L75;
        int r46 = r45;
        int r47 = r39;
        if (r5.isNull(r47) == false) goto L70;
    L76:
        int r48 = r47;
        Boolean r313 = null;
    L77:
        Map<String, List<j>> r49 = r35;
        int r410 = r19;
        String r50 = r34;
        List r51 = (List) ZeusTransformUtils.preCheckCast(r35.get(r111), List.class, r50);     // Catch: Throwable -> L88
        if (r51 == null) goto L128;
    L85:
        int r314 = r17;
        int r411 = r16;
        int r52 = r13;
        int r53 = r14;
        int r54 = r15;
        ?? r59 = r57;
        r59.add(new ICSProtocolEntity(r111, System.currentTimeMillis(), System.currentTimeMillis(), r33, f12162a.a(new k(r33, r112, r113, r21, r23, r26, r27, r28, r29, r30, r31, r32, r40, r42, r310, r311, r312, r313, r51))));     // Catch: Throwable -> L96
        r57 = r59;
        r17 = r314;
        r5 = r5;
        r20 = r20;
        r36 = r43;
        r37 = r44;
        r38 = r46;
        r110 = r48;
        r35 = r49;
        r16 = r411;
        r13 = r52;
        r14 = r53;
        r15 = r54;
        r34 = r50;
        r19 = r410;
    L96:
        th = th;
    L97:
        r4 = r4;
        ?? r60 = r59;
        String r61 = r50;
    L107:
        Throwable r62 = th;
        r1 = r60;
        r2 = r61;
    L122:
        throw r62;     // Catch: Throwable -> L109
    L109:
        th = move-exception;
        CloseableKt.closeFinally(r4, r62);     // Catch: Exception -> L113
        throw th;     // Catch: Exception -> L113
    L128:
        r51 = CollectionsKt.emptyList();     // Catch: Throwable -> L83
    L83:
        th = th;
        String r63 = r50;
        ?? r510 = r57;
    L102:
        r60 = r510;
        r61 = r63;
    L88:
        th = th;
        r59 = r57;
        goto L97
    L70:
        if (r5.getInt(r47) > 0) goto L74;
        r24 = false;
    L74:
        r48 = r47;
        r313 = Boolean.valueOf(r24);     // Catch: Throwable -> L23
        goto L77
    L75:
        r46 = r45;
        r47 = r39;
    L65:
        r312 = null;
        goto L66
    L64:
        r44 = r41;
        r45 = r38;
    L59:
        r311 = null;
        goto L60
    L58:
        r43 = r25;
        r41 = r37;
    L53:
        r310 = null;
        goto L54
    L52:
        r58 = r22;
        r25 = r36;
        goto L53
    L47:
        r22 = r58;
        r42 = null;
        goto L48
    L44:
        r40 = null;
        goto L45
    L41:
        r32 = null;
        goto L42
    L38:
        r31 = null;
        goto L39
    L35:
        r30 = null;
        goto L36
    L139:
        r29 = r5.getString(r16);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r4 = r4;
        r1 = r57;
        r62 = th;
        r2 = r34;
        goto L122
    L28:
        r26 = false;
    L90:
        th = th;
        r59 = r57;
        r50 = r34;
        goto L97
    L92:
        r59 = r57;
        r50 = r34;
        Unit r64 = Unit.INSTANCE;     // Catch: Throwable -> L96
        CloseableKt.closeFinally(r4, null);     // Catch: Exception -> L113
        return r59;
    L98:
        th = th;
        r4 = r4;
        r60 = r57;
        r61 = r34;
    L100:
        th = th;
        r63 = "com.obric.memorydata.plugin";
        r510 = r57;
    L103:
        th = th;
        r4 = r4;
    L106:
        r61 = "com.obric.memorydata.plugin";
        r60 = r2;
    L105:
        th = th;
    L113:
        e = e;
    L118:
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleDataRequester", "Failed to query calendar events by ids", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, r2));
        return r1;
    L144:
        return r2;
    L116:
        e = e;
        r2 = "com.obric.memorydata.plugin";
        r1 = r2;
        goto L118
    }

    private final Map<String, List<j>> d(ContentResolver r12, List<String> r13) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Map<String, List<j>> r14 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (r11.isEmpty() == false) goto L29;
        return r14;
    L29:
        Cursor r15 = ZeusProviderTransform.query(r12, CalendarContract.Reminders.CONTENT_URI, d, "event_id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')', null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
        if (r15 == null) goto L26;
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r16, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        int r2 = r1.getColumnIndexOrThrow("event_id");     // Catch: Throwable -> L19
        int r3 = r1.getColumnIndexOrThrow("minutes");     // Catch: Throwable -> L19
        int r4 = r1.getColumnIndexOrThrow("method");     // Catch: Throwable -> L19
    L11:
        if (r1.moveToNext() == false) goto L16;
        String r5 = String.valueOf(r1.getLong(r2));     // Catch: Throwable -> L19
        int r6 = r1.getInt(r3);     // Catch: Throwable -> L19
        int r7 = r1.getInt(r4);     // Catch: Throwable -> L19
        List<j> r8 = r14.get(r5);     // Catch: Throwable -> L19
        if (r8 != null) goto L15;
        r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        r14.put(r5, r8);     // Catch: Throwable -> L19
    L15:
        ((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin")).add(new j(r6, r7));     // Catch: Throwable -> L19
        goto L11
    L16:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r16, null);     // Catch: Exception -> L24
        goto L26
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Exception -> L24
        throw th;     // Catch: Exception -> L24
    L26:
        return r14;
    L24:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleDataRequester", "Failed to query calendar reminders", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L26
    }

    public static /* synthetic */ Unit lambda$UyhEWy4VVmcSyGC6pJ08cH50_Ck(List r0, List r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<Integer> a() {
        return f12163b;
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<AppEntity> b(ContentResolver r4, List<String> r5) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "contentResolver");
        Intrinsics.checkNotNullParameter(r3, "entityIds");
        List<AppEntity> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), 200), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        List<String> r1 = (List) ZeusTransformUtils.preCheckCast(r7.next(), List.class, "com.obric.memorydata.plugin");
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast(f12162a.c(r4, r1), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r6;
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<AppEntity> c(ContentResolver r12) {
        Intrinsics.checkNotNullParameter(r12, "contentResolver");
        final List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Uri r4 = CalendarContract.Events.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(r4, "CONTENT_URI");
        aj.a(r12, r4, new String[]{"_id"}, "_id", 2000, null, null, new $$Lambda$b$UyhEWy4VVmcSyGC6pJ08cH50_Ck(r0));
        List<AppEntity> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(a(r12, r0), Collection.class, "com.obric.memorydata.plugin"));
        return r1;
    }
}
