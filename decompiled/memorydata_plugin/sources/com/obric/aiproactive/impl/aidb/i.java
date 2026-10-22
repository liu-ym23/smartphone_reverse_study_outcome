package com.obric.aiproactive.impl.aidb;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001aR\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"AI_PROACTIVE_MANUAL_PREFERENCE_EVENT_NAME", "", "AI_PROACTIVE_MANUAL_PREFERENCE_OPERATE_TYPE_CREATE", "", "AI_PROACTIVE_MANUAL_PREFERENCE_OPERATE_TYPE_UPDATE", "AI_PROACTIVE_MANUAL_PREFERENCE_OPERATE_TYPE_DELETE", "PREFERENCE_ACTION_TYPE_CREATE", "PREFERENCE_ACTION_TYPE_EDIT", "PREFERENCE_ACTION_TYPE_DELETE", "shouldTrackManualPreferenceUpdate", "", "preferenceTypeBefore", "preferenceTypeAfter", "preferenceBefore", "preferenceAfter", "shouldTrackManualPreferenceDelete", "preferenceType", "buildManualPreferenceAwarenessExtra", "", "", "operateType", "rawTable", "rawId", "", "preference", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class i {
    public static final Map<String, Object> a(int r2, String r3, long r4, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r3, "rawTable");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("operate_type", Integer.valueOf(r2)), TuplesKt.to("raw_table", r3), TuplesKt.to("raw_id", Long.valueOf(r4)), TuplesKt.to("preference", r6), TuplesKt.to("preference_before", r7), TuplesKt.to("preference_after", r8), TuplesKt.to(AILabCheckPermissionTask.KEY_SOURCE, "manual")});
    }

    public static final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "preferenceType");
        if (StringsKt.equals(r2, "user", true) == false) goto L5;
        return true;
    L5:
        if (StringsKt.equals(r2, "assistant", true) == false) goto L7;
        return true;
    L7:
        if (StringsKt.equals(r2, "interview", true) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final boolean a(String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "preferenceTypeBefore");
        Intrinsics.checkNotNullParameter(r5, "preferenceTypeAfter");
        Intrinsics.checkNotNullParameter(r6, "preferenceBefore");
        Intrinsics.checkNotNullParameter(r7, "preferenceAfter");
        boolean r0 = StringsKt.equals(r5, "user", true);
        boolean r8 = !Intrinsics.areEqual(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString(), StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        boolean r9 = !StringsKt.equals(r4, r5, true);
        if (r0 == false) goto L7;
        if (r8 == true) goto L9;
        if (r9 == false) goto L7;
        return true;
    L9:
        return true;
    L7:
        return false;
    }
}
