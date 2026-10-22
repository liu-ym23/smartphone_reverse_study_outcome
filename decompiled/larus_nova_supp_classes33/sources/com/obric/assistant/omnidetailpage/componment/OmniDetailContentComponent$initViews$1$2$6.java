package com.obric.assistant.omnidetailpage.componment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.omnidetailpage.util.OmniPageUtil;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class OmniDetailContentComponent$initViews$1$2$6 extends FunctionReferenceImpl implements Function2<ifa.f.g, String, Unit> {
    public OmniDetailContentComponent$initViews$1$2$6(Object r8) {
        super(2, r8, OmniDetailContentComponent.class, "handleModeSettingClick", "handleModeSettingClick(Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$ModeSetting;Ljava/lang/String;)V", 0);
    }

    public final void invoke(ifa.f.g r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        Intrinsics.checkNotNullParameter(r6, "p1");
        OmniDetailContentComponent r0 = (OmniDetailContentComponent) ((CallableReference) this).receiver;
        int r1 = OmniDetailContentComponent.I;
        Context r2 = r0.getContext();
        if (r2 == null) goto L20;
        String r7 = r5.b.getBlockId();
        boolean r3 = false;
        if (r6.length() != 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L17;
        if (r7 != null) goto L12;
    L13:
        r3 = true;
    L14:
        if (r3 == true) goto L17;
        ConcurrentHashMap<String, Pair<Drawable, String>> r8 = OmniPageUtil.a;
        OmniPageUtil.a(r2, r6, r7, MapsKt.emptyMap());
        return;
    L12:
        if (r7.length() != 0) goto L14;
    L17:
        FLogger.a.w("OmniDetailContentComponent", "handleModeSettingClick ignored invalid action");
        return;
    L8:
        r4 = false;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((ifa.f.g) r1, (String) r2);
        return Unit.INSTANCE;
    }
}
