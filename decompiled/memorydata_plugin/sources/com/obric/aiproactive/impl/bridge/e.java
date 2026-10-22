package com.obric.aiproactive.impl.bridge;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u0005*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"AI_PROACTIVE_ARTIFACT_WIRE_PROTOCOL_VERSION", "", "AI_PROACTIVE_ARTIFACT_CAPABILITY_VERSION", "AI_PROACTIVE_ARTIFACT_MAX_REQUEST_CHARS", "AI_PROACTIVE_ARTIFACT_MAX_FILE_BYTES", "", "MANAGED_DIR", "", "SHELL_PLUGIN_CACHE_DIR", "SHELL_EXPORT_DIR", "COMMIT_MARKER", "STAGING_PREFIX", "OPEN_NAME_PREFIX", "ORPHAN_GRACE_MS", "ORPHAN_SWEEP_INTERVAL_MS", "SAFE_ID", "Lkotlin/text/Regex;", "SAFE_MIME", "SAFE_EXTENSION", "optionalLong", "Lorg/json/JSONObject;", ActivityLifecycle.NAME, "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Regex f6403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Regex f6404b = null;
    private static final Regex c = null;

    static {
        f6403a = new Regex("[A-Za-z0-9._:-]{1,128}");
        f6404b = new Regex("[A-Za-z0-9!#$&^_.+-]+/[A-Za-z0-9!#$&^_.+-]+");
        c = new Regex("[A-Za-z0-9]{1,10}");
    }

    public static final /* synthetic */ Long a(JSONObject r0, String r1) {
        return b(r0, r1);
    }

    public static final /* synthetic */ Regex a() {
        return f6403a;
    }

    private static final Long b(JSONObject r2, String r3) {
        if (r2.has(r3) == true) goto L5;
        return null;
    L5:
        if (r2.isNull(r3) == true) goto L24;
        Object r4 = r2.opt(r3);
        if (ZeusTransformUtils.instanceOf(r4, Byte.class) == false) goto L12;
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).byteValue();
    L22:
        return Long.valueOf(r5);
    L12:
        if (ZeusTransformUtils.instanceOf(r4, Short.class) == false) goto L15;
        r5 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).shortValue();
        goto L22
    L15:
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L18;
        r5 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
        goto L22
    L18:
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == true) goto L20;
        return null;
    L20:
        return (Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.memorydata.plugin");
    L24:
        return null;
    }

    public static final /* synthetic */ Regex b() {
        return f6404b;
    }

    public static final /* synthetic */ Regex c() {
        return c;
    }
}
