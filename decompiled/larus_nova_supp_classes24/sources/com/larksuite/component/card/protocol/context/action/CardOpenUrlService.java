package com.larksuite.component.card.protocol.context.action;

import android.content.Context;
import android.os.Bundle;
import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J`\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H'¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/card/protocol/context/action/CardOpenUrlService;", "Ljava/io/Serializable;", "interceptOpenUrl", "", "url", "", "context", "Landroid/content/Context;", "cardId", "isGroup", "chatId", "mActionTrace", "Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "monitorData", "Lcom/larksuite/component/card/monitor/UniversalCardMonitorData;", "componentTag", "isStreamingMode", "extraParams", "Landroid/os/Bundle;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface CardOpenUrlService extends Serializable {
    boolean interceptOpenUrl(String r1, Context r2, String r3, boolean r4, String r5, OPTrace r6, UniversalCardMonitorData r7, String r8, boolean r9, Bundle r10);
}
