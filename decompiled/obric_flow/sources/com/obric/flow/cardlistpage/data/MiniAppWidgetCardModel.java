package com.obric.flow.cardlistpage.data;

import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.base.CardType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012¢\u0006\u0002\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/obric/flow/cardlistpage/data/MiniAppWidgetCardModel;", "Lcom/obric/flow/cardlistpage/base/BaseCardModel;", "id", "", "spanX", "", "spanY", Constant.TITLE, Constant.DESCRIPTION, "sortIndex", "createTime", "", "modifyTime", "instanceId", "appletId", "widgetId", "definitionId", "config", "", "extras", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getAppletId", "()Ljava/lang/String;", "getConfig", "()Ljava/util/Map;", "getDefinitionId", "getExtras", "getInstanceId", "getWidgetId", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MiniAppWidgetCardModel extends BaseCardModel {
    private final String appletId;
    private final Map<String, String> config;
    private final String definitionId;
    private final Map<String, String> extras;
    private final String instanceId;
    private final String widgetId;

    public /* synthetic */ MiniAppWidgetCardModel(String r19, int r20, int r21, String r22, String r23, Integer r24, Long r25, Long r26, String r27, String r28, String r29, String r30, Map r31, Map r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 32) == 0) goto L5;
        Integer r10 = null;
    L7:
        if ((r33 & 64) == 0) goto L9;
        Long r11 = null;
    L11:
        if ((r33 & 128) == 0) goto L13;
        Long r12 = null;
    L15:
        if ((r33 & 4096) == 0) goto L17;
        Map r16 = MapsKt.emptyMap();
    L19:
        if ((r33 & 8192) == 0) goto L21;
        Map r17 = MapsKt.emptyMap();
    L22:
        this(r19, r20, r21, r22, r23, r10, r11, r12, r27, r28, r29, r30, r16, r17);
        return;
    L21:
        r17 = r32;
        goto L22
    L17:
        r16 = r31;
        goto L19
    L13:
        r12 = r26;
        goto L15
    L9:
        r11 = r25;
        goto L11
    L5:
        r10 = r24;
        goto L7
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final Map<String, String> getConfig() {
        return this.config;
    }

    public final String getDefinitionId() {
        return this.definitionId;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final String getInstanceId() {
        return this.instanceId;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public MiniAppWidgetCardModel(String r19, int r20, int r21, String r22, String r23, Integer r24, Long r25, Long r26, String r27, String r28, String r29, String r30, Map<String, String> r31, Map<String, String> r32) {
        Intrinsics.checkNotNullParameter(r19, "id");
        Intrinsics.checkNotNullParameter(r22, Constant.TITLE);
        Intrinsics.checkNotNullParameter(r23, Constant.DESCRIPTION);
        Intrinsics.checkNotNullParameter(r27, "instanceId");
        Intrinsics.checkNotNullParameter(r28, "appletId");
        Intrinsics.checkNotNullParameter(r29, "widgetId");
        Intrinsics.checkNotNullParameter(r30, "definitionId");
        Intrinsics.checkNotNullParameter(r31, "config");
        Intrinsics.checkNotNullParameter(r32, "extras");
        super(r19, r27, CardType.MINI_APP, r20, r21, r22, r23, false, r24, r25, r26, 128, null);
        this.instanceId = r27;
        this.appletId = r28;
        this.widgetId = r29;
        this.definitionId = r30;
        this.config = r31;
        this.extras = r32;
    }
}
