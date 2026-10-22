package com.obric.feature.miniapp.widget;

import ai.j0;
import androidx.room.writer.DaoWriter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/feature/miniapp/widget/MiniAppWidgetComponentNameCodec;", "", "()V", "ENCODED_PREFIX", "", "PART_SEPARATOR", "buildClassName", "appletId", "widgetId", "definitionId", "spanX", "", "spanY", "buildLegacyClassName", "parse", "Lcom/obric/feature/miniapp/widget/MiniAppWidgetComponentData;", "className", "takeIfNotBlank", "MiniAppWidgetHost_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMiniAppWidgetComponentNameCodec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiniAppWidgetComponentNameCodec.kt\ncom/obric/feature/miniapp/widget/MiniAppWidgetComponentNameCodec\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n1#2:63\n*E\n"})
public final class MiniAppWidgetComponentNameCodec {
    private static final String ENCODED_PREFIX = "owidget|";
    public static final MiniAppWidgetComponentNameCodec INSTANCE = null;
    private static final String PART_SEPARATOR = "|";

    static {
        INSTANCE = new MiniAppWidgetComponentNameCodec();
    }

    private MiniAppWidgetComponentNameCodec() {
    }

    public static /* synthetic */ String buildClassName$default(MiniAppWidgetComponentNameCodec r10, String r11, String r12, String r13, int r14, int r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        int r5 = 0;
    L7:
        if ((r16 & 16) == 0) goto L9;
        int r18 = 0;
    L11:
        return r10.buildClassName(r11, r12, r13, r5, r18);
    L9:
        r18 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    private final String buildLegacyClassName(String r5, String r10) {
        return j0.D(r5, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, r10);
    }

    private final String takeIfNotBlank(String r5) {
        if (r5 == null) goto L10;
        String r10 = StringsKt.trim(r5).toString();
        if (r10 != null) goto L7;
        return null;
    L7:
        if (r10.length() > 0) goto L9;
        return null;
    L9:
        return r10;
    L10:
        return null;
    }

    public final String buildClassName(String r5, String r10, String r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        String r14 = takeIfNotBlank(r5);
        String r15 = takeIfNotBlank(r10);
        String r16 = takeIfNotBlank(r11);
        if (r14 == null) goto L9;
        if (r15 == null) goto L9;
        if (r16 == null) goto L9;
        StringBuilder r17 = androidx.constraintlayout.motion.widget.a.y(ENCODED_PREFIX, r14, PART_SEPARATOR, r15, PART_SEPARATOR);
        r17.append(r16);
        return r17.toString();
    L9:
        return buildLegacyClassName(r5, r10);
    }

    public final MiniAppWidgetComponentData parse(String r5) {
        String r10 = takeIfNotBlank(r5);
        if (r10 != null) goto L7;
        return new MiniAppWidgetComponentData(null, null, null);
    L7:
        if (StringsKt.P(r10, ENCODED_PREFIX) == false) goto L11;
        List r11 = StringsKt.K(StringsKt.A(r10, ENCODED_PREFIX), new String[]{PART_SEPARATOR}, 3, 2);
        return new MiniAppWidgetComponentData(takeIfNotBlank((String) CollectionsKt.getOrNull(r11, 0)), takeIfNotBlank((String) CollectionsKt.getOrNull(r11, 1)), takeIfNotBlank((String) CollectionsKt.getOrNull(r11, 2)));
    L11:
        return new MiniAppWidgetComponentData(takeIfNotBlank(StringsKt.V(r10)), takeIfNotBlank(StringsKt.Q(r10, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD)), null);
    }
}
