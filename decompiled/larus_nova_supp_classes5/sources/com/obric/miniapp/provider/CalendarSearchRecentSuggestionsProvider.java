package com.obric.miniapp.provider;

import android.app.Application;
import android.content.SearchRecentSuggestionsProvider;
import android.content.UriMatcher;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.common.apphost.AppHost;
import com.larus.utils.l;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.request.SearchCalendarRequest;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016JS\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c2\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0002J$\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0002J*\u0010*\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/miniapp/provider/CalendarSearchRecentSuggestionsProvider;", "Landroid/content/SearchRecentSuggestionsProvider;", "<init>", "()V", "sUriMatcher", "Landroid/content/UriMatcher;", "onCreate", "", DownloadConstants.QUERY_KEY, "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "setTodayToNextYear", "", "bundle", "Landroid/os/Bundle;", "setTodayToLastYear", "loadInstance", EffectConfiguration.KEY_CURSOR, "Landroid/database/MatrixCursor;", "tokenizeSearchQuery", "", "maxCountSearchToken", "", "escapeSearchToken", "token", "getTimeText", "begin", "", "getDisplayDate", "context", "Landroid/content/Context;", "time", "timeZone", "isChineseLanguage", "formatDateTime", "millis", "flags", "Companion", "TimeRange", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarSearchRecentSuggestionsProvider extends SearchRecentSuggestionsProvider {
    public static final String[] b = null;
    public static final Pattern c = null;
    public static final Pattern d = null;
    public final UriMatcher a;

    public static final class a {
    }

    static {
        b = new String[]{DBDefinition.ID, "suggest_text_1", "suggest_text_2", "suggest_intent_data_id", "suggest_intent_extra_data", "suggest_shortcut_id", "is_achieved", "calendar_color", "eventTimezone", "allDay"};
        c = PatternProtector.compile("[^\\s\"'.?!,]+|\"([^\"]*)\"");
        d = PatternProtector.compile("([%_#])");
    }

    @Override // android.content.SearchRecentSuggestionsProvider, android.content.ContentProvider
    public final boolean onCreate() {
        FLogger.a.i("CalendarSearchRecentSuggestionsProvider", "onCreate");
        setupSuggestions("com.obric.miniapp.provider.CalendarSearchRecentSuggestionsProvider", 1);
        return super.onCreate();
    }

    public CalendarSearchRecentSuggestionsProvider() {
        UriMatcher r0 = new UriMatcher(-1);
        this.a = r0;
        FLogger.a.i("CalendarSearchRecentSuggestionsProvider", "init");
        r0.addURI("com.obric.miniapp.provider.CalendarSearchRecentSuggestionsProvider", "search_suggest_query", 1);
        r0.addURI("com.obric.miniapp.provider.CalendarSearchRecentSuggestionsProvider", "search_suggest_query/*", 1);
        r0.addURI("com.obric.miniapp.provider.CalendarSearchRecentSuggestionsProvider", "search_suggest_shortcut", 2);
        r0.addURI("com.obric.miniapp.provider.CalendarSearchRecentSuggestionsProvider", "search_suggest_shortcut/*", 2);
    }

    public static void c(Bundle r10) {
        Calendar r0 = Calendar.getInstance();
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        r0.add(1, -1);
        long r7 = r0.getTimeInMillis();
        r0.set(11, 23);
        r0.set(12, 59);
        r0.set(13, 59);
        r0.set(14, 59);
        r0.add(6, -1);
        r0.add(1, 1);
        long r1 = r0.getTimeInMillis();
        r10.putLong("start", r7);
        r10.putLong("end", r1);
    }

    public final String a(long r11) {
        Application r0 = AppHost.a.getApplication();
        monitor-enter(CalendarSearchRecentSuggestionsProvider.class);
        Resources r1 = r0.getResources();     // Catch: Throwable -> L23
        if (r1 == null) goto L11;
        Configuration r2 = r1.getConfiguration();     // Catch: Throwable -> L23
        if (r2 == null) goto L11;
        Locale r3 = r2.locale;     // Catch: Throwable -> L23
        if (r3 == null) goto L11;
        String r4 = r3.getLanguage();     // Catch: Throwable -> L23
    L13:
        if (Intrinsics.areEqual(r4, Locale.CHINESE.getLanguage()) == false) goto L15;
        Calendar r5 = Calendar.getInstance();     // Catch: Throwable -> L23
        r5.setTimeInMillis(r11);     // Catch: Throwable -> L23
        String r6 = new SimpleDateFormat("yyyy/MM/dd EE").format(r5.getTime());     // Catch: Throwable -> L23
    L16:
        monitor-exit(CalendarSearchRecentSuggestionsProvider.class);
        if (DateFormat.is24HourFormat(r0) == false) goto L20;
        int r7 = 129;
    L22:
        return r6 + ' ' + DateUtils.formatDateTime(getContext(), r11, r7);
    L20:
        r7 = 1;
        goto L22
    L15:
        r6 = DateUtils.formatDateRange(r0, new Formatter(new StringBuilder(50), Locale.getDefault()), r11, r11, 98326, null).toString();     // Catch: Throwable -> L23
    L11:
        r4 = null;
    L23:
        th = move-exception;
        throw th;
    }

    public final void b(MatrixCursor r16, Bundle r17) {
        Bundle r0 = new SearchCalendarRequest().b(r17);
        if (r0 == null) goto L66;
        JsonArray r1 = JsonParser.parseString(r0.getString("result")).getAsJsonArray();     // Catch: Exception -> L62
        if (r1 == null) goto L66;
        Iterator r2 = r1.iterator();     // Catch: Exception -> L62
        long r3 = 0;
    L9:
        if (r2.hasNext() == false) goto L58;
        JsonObject r4 = ((JsonElement) r2.next()).getAsJsonObject();     // Catch: Exception -> L55
        JsonElement r5 = r4.get("eventUuid");     // Catch: Exception -> L55
        Object r6 = null;
        if (r5 == null) goto L14;
        Object r7 = Long.valueOf(r5.getAsLong());     // Catch: Exception -> L55
    L15:
        JsonElement r8 = r4.get(DBDefinition.TITLE);     // Catch: Exception -> L55
        if (r8 == null) goto L18;
        Object r9 = r8.getAsString();     // Catch: Exception -> L55
    L19:
        JsonElement r10 = r4.get("dtstart");     // Catch: Exception -> L55
        if (r10 == null) goto L22;
        Long r11 = Long.valueOf(r10.getAsLong());     // Catch: Exception -> L55
    L23:
        JsonElement r12 = r4.get("dtend");     // Catch: Exception -> L55
        if (r12 == null) goto L26;
        Long r13 = Long.valueOf(r12.getAsLong());     // Catch: Exception -> L55
    L27:
        JsonElement r14 = r4.get("allDay");     // Catch: Exception -> L55
        if (r14 == null) goto L30;
        Integer r15 = Integer.valueOf(r14.getAsInt());     // Catch: Exception -> L55
    L31:
        JsonElement r18 = r4.get("eventTimezone");     // Catch: Exception -> L55
        if (r18 == null) goto L34;
        r6 = r18.getAsString();     // Catch: Exception -> L55
    L34:
        if (r7 == null) goto L51;
        if (r9 == null) goto L51;
        if (r11 == null) goto L51;
        if (r13 == null) goto L51;
        if (r15 == null) goto L51;
        if (r6 == null) goto L51;
        if (r15.intValue() != 1) goto L45;
        Object r19 = AppHost.a.getApplication().getString(2131911803);     // Catch: Exception -> L55
    L75:
        Intrinsics.checkNotNull(r19);     // Catch: Exception -> L49
        r3 = r3 + 1;     // Catch: Exception -> L49
        r16.addRow(new Object[]{Long.valueOf(r3), r9, r19, r7, new b(r11.longValue(), r13.longValue()).toString(), r7, 1, 0, r6, r15});     // Catch: Exception -> L53
    L53:
        e = e;
    L71:
        FLogger.a.e("CalendarSearchRecentSuggestionsProvider", "loadInstance: invalid field: " + e);     // Catch: Exception -> L60
    L60:
        e = e;
    L64:
        FLogger.a.e("CalendarSearchRecentSuggestionsProvider", "loadInstance error: " + e);
        Unit r20 = Unit.INSTANCE;
        return;
    L49:
        e = e;
        goto L71
    L45:
        r19 = a(r11.longValue());     // Catch: Exception -> L49
    L51:
        FLogger.a.e("CalendarSearchRecentSuggestionsProvider", "loadInstance: invalid field. ignore current instance");     // Catch: Exception -> L53
        goto L9
    L30:
        r15 = null;
        goto L31
    L26:
        r13 = null;
        goto L27
    L22:
        r11 = null;
        goto L23
    L18:
        r9 = null;
        goto L19
    L14:
        r7 = null;
    L55:
        e = e;
        goto L71
    L58:
        Unit r21 = Unit.INSTANCE;     // Catch: Exception -> L60
        return;
    L62:
        e = e;
    }

    @Override // android.content.SearchRecentSuggestionsProvider, android.content.ContentProvider
    public Cursor query(Uri r18, String[] r19, String r20, String[] r21, String r22) {
        Intrinsics.checkNotNullParameter(r18, "uri");
        FLogger r3 = FLogger.a;
        r3.d("CalendarSearchRecentSuggestionsProvider", DownloadConstants.QUERY_KEY);
        long r5 = Binder.clearCallingIdentity();
        MatrixCursor r7 = new MatrixCursor(b);     // Catch: Throwable -> L75
        int r8 = this.a.match(r18);     // Catch: Throwable -> L75
        int r11 = 1;
        if (r8 != 1) goto L7;
        String r2 = r18.getLastPathSegment();     // Catch: Throwable -> L75
        if (r2 != null) goto L22;
    L25:
        boolean r4 = true;
    L26:
        if (r4 == true) goto L58;
        int r6 = r2.length();     // Catch: Throwable -> L75
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L75
        Matcher r15 = c.matcher(r2);     // Catch: Throwable -> L75
        int r10 = 0;
    L30:
        if (r15.find() == false) goto L41;
        if (r10 >= r6) goto L41;
        if (r15.group(r11) == null) goto L35;
        String r16 = r15.group(r11);     // Catch: Throwable -> L75
    L36:
        r10 = r10 + 1;     // Catch: Throwable -> L75
        String r12 = d.matcher(r16).replaceAll("#$1");     // Catch: Throwable -> L75
        if (r12 == null) goto L39;
        r9.add(r12);     // Catch: Throwable -> L75
    L39:
        r11 = 1;
        goto L30
    L35:
        r16 = r15.group();     // Catch: Throwable -> L75
    L41:
        if (r9.isEmpty() == true) goto L58;
        Bundle r13 = new Bundle();     // Catch: Throwable -> L75
        r13.putString(EffectConfiguration.KEY_SEARCH_KEYWORD, r2);     // Catch: Throwable -> L75
        String r14 = r18.getQueryParameter("dtstart");     // Catch: Exception -> L56 Throwable -> L75
        if (r14 == null) goto L47;
        Long r17 = Long.valueOf(Long.parseLong(r14));     // Catch: Exception -> L56 Throwable -> L75
    L48:
        String r0 = r18.getQueryParameter("dtend");     // Catch: Exception -> L56 Throwable -> L75
        if (r0 == null) goto L51;
        Long r1 = Long.valueOf(Long.parseLong(r0));     // Catch: Exception -> L56 Throwable -> L75
    L52:
        if (r17 == null) goto L55;
        if (r1 == null) goto L55;
        r13.putLong("start", r17.longValue());     // Catch: Exception -> L56 Throwable -> L75
        r13.putLong("end", r1.longValue());     // Catch: Exception -> L56 Throwable -> L75
    L55:
        Bundle r23 = r13;
    L59:
        if (r23 == null) goto L73;
        String r24 = r23.getString(EffectConfiguration.KEY_SEARCH_KEYWORD);     // Catch: Throwable -> L75
        if (r24 != null) goto L63;
    L66:
        boolean r25 = true;
    L67:
        if (r25 == false) goto L69;
        b(r7, r23);     // Catch: Throwable -> L75
        goto L73
    L69:
        if (r23.getLong("start") == 0) goto L71;
        b(r7, r23);     // Catch: Throwable -> L75
        goto L73
    L71:
        Bundle r26 = new Bundle(r23);     // Catch: Throwable -> L75
        Calendar r27 = Calendar.getInstance();     // Catch: Throwable -> L75
        r27.set(11, 0);     // Catch: Throwable -> L75
        r27.set(12, 0);     // Catch: Throwable -> L75
        r27.set(13, 0);     // Catch: Throwable -> L75
        r27.set(14, 0);     // Catch: Throwable -> L75
        long r28 = r27.getTimeInMillis();     // Catch: Throwable -> L75
        r27.add(1, 1);     // Catch: Throwable -> L75
        long r110 = r27.getTimeInMillis();     // Catch: Throwable -> L75
        r26.putLong("start", r28);     // Catch: Throwable -> L75
        r26.putLong("end", r110);     // Catch: Throwable -> L75
        b(r7, r26);     // Catch: Throwable -> L75
        Bundle r29 = new Bundle(r23);     // Catch: Throwable -> L75
        c(r29);     // Catch: Throwable -> L75
        b(r7, r29);     // Catch: Throwable -> L75
        goto L73
    L63:
        if (r24.length() == 0) goto L66;
        r25 = false;
    L73:
        Binder.restoreCallingIdentity(r5);
        return r7;
    L51:
        r1 = null;
        goto L52
    L47:
        r17 = null;
    L56:
        e = move-exception;
        FLogger.a.e("CalendarSearchRecentSuggestionsProvider", "parse parameters error: " + e);     // Catch: Throwable -> L75
    L58:
        r23 = null;
        goto L59
    L22:
        if (r2.length() == 0) goto L25;
        r4 = false;
        goto L26
    L7:
        if (r8 == 2) goto L9;
        r3.e("CalendarSearchRecentSuggestionsProvider", "Unknown URL " + r18 + ' ');     // Catch: Throwable -> L75
        goto L58
    L9:
        String r30 = r18.getLastPathSegment();     // Catch: Throwable -> L75
        if (r30 != null) goto L12;
    L15:
        boolean r31 = true;
    L16:
        if (r31 == true) goto L58;
        r23 = new Bundle();     // Catch: Throwable -> L75
        l.c(this, "eventUuid", r30);     // Catch: Throwable -> L75
        goto L59
    L12:
        if (r30.length() == 0) goto L15;
        r31 = false;
    L75:
        th = move-exception;
        Binder.restoreCallingIdentity(r5);
        throw th;
    }
}
