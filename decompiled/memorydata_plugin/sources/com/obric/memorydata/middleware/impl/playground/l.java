package com.obric.memorydata.middleware.impl.playground;

import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u0003H\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"toJsonEntities", "", "Lorg/json/JSONObject;", "", "CODE_TIMEOUT", "", "CODE_DISPATCH_ERROR", "CODE_DUPLICATE_QUESTION_ID", "CODE_INTERRUPTED", "LOG_CODE_DISPATCH_TIMEOUT", "", "LOG_CODE_DISPATCH_INTERRUPTED", "LOG_CODE_DISPATCH_FAILED", "LOG_CODE_CALLBACK_PARSE_FAILED", "middleware_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class l {
    public static final List<JSONObject> a(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, AppEntity.class) == false) goto L6;
        List r7 = CollectionsKt.listOf(r6);
    L23:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L25:
        if (r9.hasNext() == false) goto L28;
        r0.add(new JSONObject(EntityExtKt.toJsonKeepTimeStamp((AppEntity) ZeusTransformUtils.preCheckCast(r9.next(), AppEntity.class, "com.obric.memorydata.plugin"))));
        goto L25
    L28:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L6:
        if ((r6 instanceof Object[]) == false) goto L15;
        Object[] r10 = (Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        int r3 = r10.length;
    L8:
        if (r2 >= r3) goto L13;
        Object r4 = r10[r2];
        if (ZeusTransformUtils.instanceOf(r4, AppEntity.class) == false) goto L12;
        r1.add(r4);
    L12:
        r2 = r2 + 1;
    L13:
        r7 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        goto L23
    L15:
        if (ZeusTransformUtils.instanceOf(r6, Iterable.class) == false) goto L22;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L18:
        if (r12.hasNext() == false) goto L13;
        Object r5 = r12.next();
        if (ZeusTransformUtils.instanceOf(r5, AppEntity.class) == false) goto L18;
        r1.add(r5);
        goto L18
    L22:
        r7 = CollectionsKt.emptyList();
        goto L23
    }
}
