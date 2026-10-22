package obric.flow.miniappwidget;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import cn.nubia.neopush.commons.Constant;
import com.obric.feature.miniapp.widget.MiniAppWidgetComponentData;
import com.obric.feature.miniapp.widget.MiniAppWidgetComponentNameCodec;
import com.obric.feature.miniapp.widget.MiniAppWidgetProviderInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static final Map a(Intent r5, String r10, String r11, String r12) {
        Bundle r13 = r5.getBundleExtra(r10);
        if (r13 == null) goto L17;
        Set<String> r14 = r13.keySet();
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L6:
        if (r16.hasNext() == false) goto L16;
        String r17 = (String) r16.next();
        Object r18 = r13.get(r17);
        if (r18 == null) goto L12;
        String r19 = r18.toString();
        if (r19 == null) goto L12;
        Pair r20 = TuplesKt.to(r17, r19);
    L13:
        if (r20 == null) goto L6;
        r15.add(r20);
    L12:
        r20 = null;
        goto L13
    L16:
        return MapsKt.toMap(r15);
    L17:
        String r21 = r5.getStringExtra(r10);
        if (r21 != null) goto L49;
        Iterable r22 = r5.getStringArrayListExtra(r11);
        if (r22 != null) goto L31;
        r22 = CollectionsKt.emptyList();
    L31:
        List r23 = r5.getStringArrayListExtra(r12);
        if (r23 != null) goto L34;
        r23 = CollectionsKt.emptyList();
    L34:
        ArrayList r24 = new ArrayList();
        Iterator r25 = r22.iterator();
        int r26 = 0;
    L36:
        if (r25.hasNext() == false) goto L48;
        Object r27 = r25.next();
        int r28 = r26 + 1;
        if (r26 >= 0) goto L40;
        CollectionsKt.throwIndexOverflow();
    L40:
        String r29 = (String) r27;
        String r30 = (String) CollectionsKt.getOrNull(r23, r26);
        if (r30 == null) goto L43;
        Pair r31 = TuplesKt.to(r29, r30);
    L44:
        if (r31 == null) goto L46;
        r24.add(r31);
    L46:
        r26 = r28;
        goto L36
    L43:
        r31 = null;
        goto L44
    L48:
        return MapsKt.toMap(r24);
    L49:
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L21
        final JSONObject r33 = new JSONObject(r21);     // Catch: Throwable -> L21
        Object r34 = Result.m124constructorimpl(MapsKt.toMap(SequencesKt.mapNotNull(SequencesKt.asSequence(r33.keys()), new MiniAppWidgetDefinitionParserKt$toStringMapFromJson$1$1(r33))));     // Catch: Throwable -> L21
    L23:
        Map r35 = MapsKt.emptyMap();
        if (Result.m130isFailureimpl(r34) == false) goto L27;
        r34 = r35;
    L27:
        return (Map) r34;
    L21:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r34 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    public static final boolean b(Intent r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5.getStringExtra("card_type"), "MINI_APP") == false) goto L5;
    L14:
        return true;
    L5:
        if (Intrinsics.areEqual(r5.getStringExtra("type"), "MINI_APP") == true) goto L14;
        if (r5.getBooleanExtra("mini_app_widget", false) == true) goto L14;
        if (r5.hasExtra("appletId") == false) goto L13;
        if (r5.hasExtra("widgetId") == true) goto L14;
    L13:
        if (c(r5) != null) goto L14;
        return false;
    }

    public static final d c(Intent r5) {
        ComponentName r10 = (ComponentName) r5.getParcelableExtra("android.intent.extra.COMPONENT_NAME");
        if (r10 != null) goto L9;
        r10 = (ComponentName) r5.getParcelableExtra("appWidgetProvider");
        if (r10 != null) goto L9;
        r10 = r5.getComponent();
        if (r10 != null) goto L9;
        return null;
    L9:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (MiniAppWidgetProviderInfo.Companion.isMiniAppWidgetComponent(r10) == true) goto L12;
        return null;
    L12:
        MiniAppWidgetComponentData r11 = MiniAppWidgetComponentNameCodec.INSTANCE.parse(r10.getClassName());
        String r12 = r11.getDefinitionId();
        return new d(r11.getAppletId(), r11.getWidgetId(), r12);
    }

    public static final f d(Intent r14) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        d r5 = c(r14);
        String r10 = r14.getStringExtra("appletId");
        String r11 = null;
        if (r10 != null) goto L5;
    L7:
        r10 = null;
    L8:
        if (r10 != null) goto L14;
        if (r5 == null) goto L11;
        r10 = r5.f20469a;
    L12:
        if (r10 != null) goto L14;
        return null;
    L11:
        r10 = null;
    L14:
        String r12 = r10;
        String r13 = r14.getStringExtra("widgetId");
        if (r13 != null) goto L17;
    L19:
        r13 = null;
    L20:
        if (r13 != null) goto L26;
        if (r5 == null) goto L23;
        r13 = r5.f20470b;
    L24:
        if (r13 != null) goto L26;
        return null;
    L23:
        r13 = null;
    L26:
        String r15 = r13;
        String r16 = r14.getStringExtra("displayName");
        if (r16 != null) goto L31;
        r16 = r14.getStringExtra(Constant.TITLE);
        if (r16 != null) goto L31;
        r16 = r14.getStringExtra("name");
    L31:
        if (r16 != null) goto L33;
        String r17 = r15;
    L34:
        int r18 = r14.getIntExtra("spanX", 2);
        Integer r19 = Integer.valueOf(r18);
        if (r18 > 0) goto L38;
        r19 = null;
    L38:
        if (r19 == null) goto L40;
        int r20 = r19.intValue();
    L41:
        int r21 = r14.getIntExtra("spanY", 2);
        Integer r22 = Integer.valueOf(r21);
        if (r21 > 0) goto L45;
        r22 = null;
    L45:
        if (r22 == null) goto L47;
        int r23 = r22.intValue();
    L48:
        String r24 = r14.getStringExtra("definitionId");
        if (r24 != null) goto L54;
        if (r5 == null) goto L52;
        r11 = r5.f20471c;
    L52:
        if (r11 != null) goto L55;
        r11 = "";
    L55:
        String r25 = r14.getStringExtra(Constant.DESCRIPTION);
        if (r25 != null) goto L58;
        String r110 = "";
    L60:
        return new f(r12, r15, r17, r20, r23, r11, r110, a(r14, "config", "configKeys", "configValues"), a(r14, "extras", "extrasKeys", "extrasValues"), 224);
    L58:
        r110 = r25;
        goto L60
    L54:
        r11 = r24;
        goto L55
    L47:
        r23 = 2;
        goto L48
    L40:
        r20 = 2;
        goto L41
    L33:
        r17 = r16;
        goto L34
    L17:
        if (StringsKt.isBlank(r13) == true) goto L19;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L7;
        goto L7
    }
}
