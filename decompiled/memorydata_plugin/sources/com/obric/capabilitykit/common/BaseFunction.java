package com.obric.capabilitykit.common;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "migration to intent api")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/common/BaseFunction;", "", ActivityLifecycle.NAME, "", "getName", "()Ljava/lang/String;", "doAction", "Lcom/obric/capabilitykit/common/BaseResult;", TrackerImpl.PARAMS, "Lcom/google/gson/JsonObject;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/google/gson/JsonObject;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isBlock", "", "translateTimeIntoUTC", "", "input", "translateUTCIntoTime", OaidModel.KEY_TIME, "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface BaseFunction {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static long a(BaseFunction r14, String r15) {
            BaseFunction r16 = (BaseFunction) ZeusTransformUtils.wrapperContextForParams(r14, BaseFunction.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "input");
            List r17 = StringsKt.split$default(StringsKt.replace$default(r15, "-", "#", false, 4, null), new String[]{"#"}, false, 0, 6, null);
            if (r17.size() < 3) goto L12;
            int r4 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r17.get(0), String.class, "com.obric.memorydata.plugin"));
            int r5 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r17.get(1), String.class, "com.obric.memorydata.plugin")) - 1;
            int r6 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r17.get(2), String.class, "com.obric.memorydata.plugin"));
            String r0 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r17, 3), String.class, "com.obric.memorydata.plugin");
            String r2 = "0";
            if (r0 != null) goto L7;
            r0 = "0";
        L7:
            int r7 = Integer.parseInt(r0);
            String r18 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r17, 4), String.class, "com.obric.memorydata.plugin");
            if (r18 == null) goto L11;
            r2 = r18;
        L11:
            int r8 = Integer.parseInt(r2);
            Calendar r19 = Calendar.getInstance();
            r19.setTimeZone(TimeZone.getDefault());
            r19.set(r4, r5, r6, r7, r8, 0);
            r19.set(14, 0);
            return r19.getTimeInMillis();
        L12:
            return -1;
        }

        public static String a(BaseFunction r3, long r4) {
            BaseFunction r5 = (BaseFunction) ZeusTransformUtils.wrapperContextForParams(r3, BaseFunction.class, "com.obric.memorydata.plugin");
            Calendar r6 = Calendar.getInstance();
            r6.setTimeInMillis(r4);
            r6.setTimeZone(TimeZone.getDefault());
            int r7 = r6.get(1);
            int r0 = r6.get(2) + 1;
            int r8 = r6.get(5);
            int r1 = r6.get(11);
            int r9 = r6.get(12);
            return new StringBuilder().append(r7).append('/').append(r0).append('/').append(r8).append(' ').append(r1).append(':').append(r9).toString();
        }

        public static boolean a(BaseFunction r2) {
            BaseFunction r3 = (BaseFunction) ZeusTransformUtils.wrapperContextForParams(r2, BaseFunction.class, "com.obric.memorydata.plugin");
            return false;
        }
    }

    Object doAction(JsonObject r1, DispatchContext r2, Continuation<? super BaseResult> r3);

    String getName();

    boolean isBlock();

    long translateTimeIntoUTC(String r1);

    String translateUTCIntoTime(long r1);
}
