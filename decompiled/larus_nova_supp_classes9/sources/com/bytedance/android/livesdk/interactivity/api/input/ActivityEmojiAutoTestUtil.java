package com.bytedance.android.livesdk.interactivity.api.input;

import com.bytedance.android.live.base.model.data.activityemoji.b;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.b4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ActivityEmojiAutoTestUtil {
    public static final boolean a = false;
    public static final Lazy b = null;
    public static final ActivityEmojiAutoTestUtil c = null;

    public ActivityEmojiAutoTestUtil() {
    }

    static {
        c = new ActivityEmojiAutoTestUtil();
        if (((Boolean) b4.a.getValue()).booleanValue() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        a = r0;
        b = LazyKt.lazy(ActivityEmojiAutoTestUtil$bean$2.INSTANCE);
        return;
    L5:
        if (v.a() == false) goto L7;
        r0 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<java.lang.Long>] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List<java.lang.Long>] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.ArrayList] */
    public static void a(List r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        if (v.a() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r5, "EmojiArea") == false) goto L15;
        a r6 = (a) b.getValue();
        if (r4 == null) goto L13;
        List r7 = r4;
        ?? r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L14;
        r1.add(Long.valueOf(((b) r8.next()).getId()));
    L14:
        r6.a = r1;
        return;
    L13:
        r1 = CollectionsKt.emptyList();
        goto L14
    L15:
        a r9 = (a) b.getValue();
        if (r4 == null) goto L21;
        List r10 = r4;
        ?? r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r11 = r10.iterator();
    L19:
        if (r11.hasNext() == false) goto L22;
        r2.add(Long.valueOf(((b) r11.next()).getId()));
    L22:
        r9.b = r2;
        return;
    L21:
        r2 = CollectionsKt.emptyList();
        goto L22
    }
}
