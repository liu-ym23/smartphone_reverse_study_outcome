package com.obric.eventkit.eventstaskmanager;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\f\u001a\n\u0010\r\u001a\u00020\u0003*\u00020\u0005\"<\u0010\u0000\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"EVENTS", "", "Lkotlin/Triple;", "", "Ljava/lang/Class;", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "Lkotlin/Function0;", "getEVENTS", "()Ljava/util/List;", "newInstanceByEventType", ExifInterface.GPS_DIRECTION_TRUE, "eventType", "(Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "getEventType", "eventstaskkit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class EventTypeKt {
    private static final List<Triple<String, Class<? extends AppEvent>, Function0<AppEvent>>> EVENTS = null;

    static {
        EVENTS = CollectionsKt.listOf(new Triple[]{new Triple("NOTIFICATION_EVENT", NotificationEvent.class, EventTypeKt$EVENTS$1.INSTANCE), new Triple("ACTIVE_AGENT_EVENT", ActiveAgentEvent.class, EventTypeKt$EVENTS$2.INSTANCE)});
    }

    public static final String a(AppEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<T> r0 = EVENTS.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        Triple r3 = (Triple) ZeusTransformUtils.preCheckCast(r1, Triple.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r5.getClass(), r3.getSecond()) == false) goto L4;
    L9:
        Triple r6 = (Triple) ZeusTransformUtils.preCheckCast(r1, Triple.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L13;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getFirst(), String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        return r7;
    L13:
        return "UNKNOWN";
    L8:
        r1 = null;
        goto L9
    }

    public static final List<Triple<String, Class<? extends AppEvent>, Function0<AppEvent>>> a() {
        return EVENTS;
    }

    public static final <T extends AppEvent> T newInstanceByEventType(String r5) {
        Iterator<T> r0 = EVENTS.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((Triple) ZeusTransformUtils.preCheckCast(r1, Triple.class, "com.obric.memorydata.plugin")).getFirst(), r5) == false) goto L4;
    L9:
        Triple r6 = (Triple) ZeusTransformUtils.preCheckCast(r1, Triple.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L14;
        Function0 r7 = (Function0) ZeusTransformUtils.preCheckCast(r6.getThird(), Function0.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L14;
        AppEvent r8 = (AppEvent) ZeusTransformUtils.preCheckCast(r7.invoke(), AppEvent.class, "com.obric.memorydata.plugin");
    L16:
        if (ZeusTransformUtils.instanceOf(r8, AppEvent.class) == true) goto L18;
        return null;
    L18:
        return (T) r8;
    L14:
        r8 = null;
        goto L16
    L8:
        r1 = null;
        goto L9
    }
}
