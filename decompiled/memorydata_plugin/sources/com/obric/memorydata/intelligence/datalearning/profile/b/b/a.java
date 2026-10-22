package com.obric.memorydata.intelligence.datalearning.profile.b.b;

import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.utils.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/time/sleepwakeup/SleepWakeupHelper;", "", "<init>", "()V", "DECIMAL", "", "getTimeDateFrom", "", "timestamp", "", "getTimestampFrom", "timeDate", "isOverlappingNightTime", "", "beginTime", "endTime", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9956a = null;

    static {
        f9956a = new a();
    }

    private a() {
    }

    public final long a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "timeDate");
        List<String> r5 = new Regex(ParameterizedMessage.ERROR_MSG_SEPARATOR).split((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), 0);
        if (r5.isEmpty() == true) goto L13;
        ListIterator<String> r7 = r5.listIterator(r5.size());
    L6:
        if (r7.hasPrevious() == false) goto L13;
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r7.previous(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L6;
        List r8 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"), r7.nextIndex() + 1);
    L14:
        String[] r9 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        if (r9.length == 2) goto L18;
        return 0;
    L18:
        return (Integer.parseInt(r9[1]) * 60000) + (Integer.parseInt(r9[0]) * 3600000);
    L10:
        r3 = false;
    L13:
        r8 = CollectionsKt.emptyList();
        goto L14
    }

    public final String a(long r7) {
        long r8 = r7 % WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        StringBuilder r6 = new StringBuilder("");
        long r2 = r8 / ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
        long r9 = (r8 % ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) / 60000;
        if (r2 >= 10) goto L5;
        r6.append("0");
    L5:
        r6.append(r2).append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        if (r9 >= 10) goto L8;
        r6.append("0");
    L8:
        r6.append(r9);
        String r10 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
        return r10;
    }

    public final boolean a(long r1, long r3) {
        int r0 = r.b(r1);
        if (r0 <= r.b(r3)) goto L5;
        return true;
    L5:
        if (r0 < 6) goto L10;
        return false;
    L10:
        return true;
    }
}
