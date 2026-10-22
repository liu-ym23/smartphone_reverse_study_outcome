package com.obric.aiproactive.impl.spell;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/aiproactive/impl/spell/SpellProactiveContract;", "", "<init>", "()V", "AUTHORITY", "", "EVENTS_PATH", "CONTENT_URI", "Landroid/net/Uri;", "getCONTENT_URI", "()Landroid/net/Uri;", "EVENTS_URI", "getEVENTS_URI", "API_VERSION", "", "MEMORY_PACKAGE_NAME", "ECA_TRIGGER_PACKAGE_NAME", "METHOD_UPSERT_TRIGGER", "METHOD_GET_REALTIME_STATUS", "METHOD_GET_USER_INSIGHT", "METHOD_LIST_TOOLS", "METHOD_INVOKE_TOOL", "OP_QUERY_EVENTS", "KEY_API_VERSION", "KEY_LOG_ID", "KEY_START_TIME_MS", "KEY_END_TIME_MS", "KEY_CONDITION_JSON", "KEY_KEYS", "KEY_TOOL_NAME", "KEY_ARGUMENTS_JSON", "KEY_CODE", "KEY_MESSAGE", "KEY_STATUSES", "KEY_USER_INSIGHT", "KEY_TOOLS", "KEY_RESULT_JSON", "COLUMN_HAPPENED_AT", "COLUMN_RECORDED_AT", "COLUMN_FULL_CONTENT", "CODE_SUCCESS", "CODE_INVALID_ARGUMENT", "CODE_UNAUTHORIZED", "CODE_PACKAGE_NOT_READY", "CODE_INTERNAL_ERROR", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6515a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f6516b = null;
    private static final Uri c = null;

    static {
        f6515a = new a();
        Uri r0 = Uri.parse("content://com.obric.memorydata.assistant.proactive");
        Intrinsics.checkNotNullExpressionValue(r0, "parse(...)");
        f6516b = r0;
        Uri r1 = r0.buildUpon().appendPath("events").build();
        Intrinsics.checkNotNullExpressionValue(r1, "build(...)");
        c = r1;
    }

    private a() {
    }

    public final Uri a() {
        return c;
    }
}
