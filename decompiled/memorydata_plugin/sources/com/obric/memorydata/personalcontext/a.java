package com.obric.memorydata.personalcontext;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ)\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/AlarmFullContentFormatVersionPolicy;", "", "<init>", "()V", "resolveMatchingFormatVersion", "", "entityFullContentFormatVersion", "", "metaFullContentFormatVersion", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "selectMigrationVersion", "activeVersion", "appliedVersion", "declaredVersion", "(Ljava/lang/Integer;ILjava/lang/Integer;)Ljava/lang/Integer;", "tasksInsertedKey", "version", "terminalFailureTasksKey", "shouldCheckPackageUpdate", "", "packageNames", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12029a = null;

    static {
        f12029a = new a();
    }

    private a() {
    }

    public final Integer a(Integer r5, int r6, Integer r7) {
        boolean r4 = true;
        if (r5 != null) goto L5;
    L16:
        if (r7 == null) goto L24;
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue() > r6) goto L21;
        r4 = false;
    L21:
        if (r4 == false) goto L24;
        return r7;
    L24:
        return null;
    L5:
        if (r5.intValue() <= r6) goto L16;
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r7 != null) goto L9;
    L11:
        r4 = false;
    L12:
        if (r4 == false) goto L15;
        return r5;
    L15:
        return null;
    L9:
        if (r7.intValue() < r8) goto L11;
        goto L11
    }

    public final Integer a(String r5, String r6) {
        boolean r4 = true;
        if (r5 == null) goto L12;
        Integer r7 = StringsKt.toIntOrNull(r5);
        if (r7 == null) goto L12;
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
    L13:
        if (r6 == null) goto L22;
        Integer r8 = StringsKt.toIntOrNull(r6);
        if (r8 == null) goto L22;
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == false) goto L22;
    L23:
        if (r7 == null) goto L34;
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r8 != null) goto L28;
    L30:
        r4 = false;
    L31:
        if (r4 == true) goto L33;
        return null;
    L33:
        return r7;
    L28:
        if (r1 != r8.intValue()) goto L30;
    L34:
        return null;
    L19:
        r9 = false;
    L22:
        r8 = null;
        goto L23
    L9:
        r3 = false;
    L12:
        r7 = null;
        goto L13
    }

    public final String a(int r2) {
        return "alarm_repeat_full_content_v" + r2 + "_tasks_inserted";
    }

    public final boolean a(Set<String> r2) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "packageNames");
        if (r1.contains("build_entity_full_content") == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.contains("build_meta_full_content") == true) goto L8;
        return false;
    }

    public final String b(int r2) {
        return "alarm_repeat_full_content_v" + r2 + "_terminal_failure_tasks";
    }
}
