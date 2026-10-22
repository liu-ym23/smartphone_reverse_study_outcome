package a30;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetEffectComposerInUsedResultModel;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.x;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.z;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import i12.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.s2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends s2<JsonObject, LiveGetEffectComposerInUsedResultModel> {
    public a() {
    }

    public final void invoke(Object r6, CallContext r7) {
        Intrinsics.checkNotNullParameter((JsonObject) r6, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        LiveGetEffectComposerInUsedResultModel r8 = new LiveGetEffectComposerInUsedResultModel();
        r8.a(LiveGetEffectComposerInUsedResultModel.Code.Success);
        LiveGetEffectComposerInUsedResultModel.a r9 = new LiveGetEffectComposerInUsedResultModel.a();
        i12.e r0 = o.b();
        ArrayList r1 = null;
        if (r0 == null) goto L5;
        Object r2 = com.bytedance.android.scope.m.e.d(r0, x.class);
    L6:
        x r3 = (x) r2;
        if (r3 == null) goto L17;
        Map r4 = r3.a;
        ArrayList r5 = new ArrayList(r4.size());
        Iterator r11 = ((LinkedHashMap) r4).entrySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        Map.Entry r12 = (Map.Entry) r11.next();
        r5.add(new z((String) r12.getKey(), CollectionsKt.toList((Iterable) r12.getValue())));
        goto L10
    L12:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r14 = r5.iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        z r15 = (z) r14.next();
        LiveGetEffectComposerInUsedResultModel.b r16 = new LiveGetEffectComposerInUsedResultModel.b();
        r16.a(r15.b);
        r16.b(r15.a);
        r13.add(r16);
        goto L14
    L16:
        r1 = r13;
    L17:
        r9.a(r1);
        Unit r17 = Unit.INSTANCE;
        r8.b(r9);
        finishWithResult(r8);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
