package com.bytedance.android.live.screenrotate.config;

import a81.b;
import android.content.res.Configuration;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.screenrotation.config.FoldType;
import com.bytedance.android.live.screenrotate.rotate.ScreenRotateContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ConfigChangeHandler implements a81.a {
    public static final Map<b, Disposable> a = null;
    public static final ConfigChangeHandler b = null;

    public ConfigChangeHandler() {
    }

    static {
        b = new ConfigChangeHandler();
        a = new ConcurrentHashMap();
    }

    public static Disposable b(final DataCenter r2, final b r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        ScreenRotateContext.Companion r0 = ScreenRotateContext.Companion;
        Function1<z71.a, Disposable> r1 = new ConfigChangeHandler$registerOnConfigChanged$3(r3);
        r0.getClass();
        Disposable r4 = (Disposable) ScreenRotateContext.Companion.c(null, r2, r1);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return Disposables.fromAction(new ConfigChangeHandler$registerOnConfigChanged$4(r2, r3));
    }

    public static void c(DataCenter r2, final b r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        ScreenRotateContext.Companion r0 = ScreenRotateContext.Companion;
        Function1<z71.a, Unit> r1 = new ConfigChangeHandler$unregisterOnConfigChanged$1(r3);
        r0.getClass();
        ScreenRotateContext.Companion.c(null, r2, r1);
    }

    @Override // a81.a
    public final void a(DataCenter r8, Configuration r9) {
        Intrinsics.checkNotNullParameter(r9, "newConfig");
        SimpleAlogArgsBuilder r0 = new SimpleAlogArgsBuilder();
        r0.c("onConfigChange， newConfig:" + r9);
        f81.a.a(r0.b());
        Set r1 = ((ConcurrentHashMap) a).keySet();
        ScreenRotateContext.Companion.getClass();
        z71.a r10 = ScreenRotateContext.Companion.b(r8);
        if (r10 == null) goto L9;
        Map<b, Disposable> r12 = r10.getConfigChangeListeners();
        if (r12 == null) goto L9;
        Collection r13 = r12.keySet();
        if (r13 == null) goto L9;
    L10:
        Iterator r14 = SetsKt.plus(r1, r13).iterator();
    L12:
        if (r14.hasNext() == false) goto L22;
        b r2 = (b) r14.next();
        r2.a(r9);
        FoldType.Companion.getClass();
        Boolean.valueOf(FoldScreenUtils.f()).booleanValue();
        Integer r3 = Integer.valueOf(FoldScreenUtils.a());
        int r4 = r3.intValue();
        Map<Integer, String> r5 = FoldType.a.a;
        String r6 = null;
        if (r5.keySet().contains(Integer.valueOf(r4)) == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L12;
        int r7 = r3.intValue();
        SimpleAlogArgsBuilder r15 = new SimpleAlogArgsBuilder();
        StringBuilder r16 = new StringBuilder("onConfigChange， 折叠屏状态:");
        Integer r17 = Integer.valueOf(r7);
        if (r17 == null) goto L21;
        r6 = r5.get(Integer.valueOf(r17.intValue()));
    L21:
        r16.append(r6);
        r15.c(r16.toString());
        f81.a.a(r15.b());
        r2.b(r7);
        goto L12
    L22:
        return;
    L9:
        r13 = CollectionsKt.emptyList();
        goto L10
    }
}
