package com.obric.memorydata.awareness.impl;

import android.os.Parcelable;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0003"}, d2 = {"normalizeAwarenessValue", "", EventBody.KEY_VALUE, "awareness_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class g {
    public static final Object a(Object r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        boolean r1 = true;
        if (ZeusTransformUtils.instanceOf(r5, Parcelable.class) == false) goto L8;
    L23:
        if (r1 == true) goto L25;
        return r5;
    L25:
        return u.a(r5);
    L8:
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == false) goto L22;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L12;
    L14:
        Iterator r2 = r0.iterator();
    L16:
        if (r2.hasNext() == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r2.next(), Parcelable.class) == false) goto L16;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L22;
    L13:
        r3 = false;
        goto L20
    L12:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L14;
    L22:
        r1 = false;
        goto L23
    }
}
