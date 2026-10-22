package com.bytedance.android.live.room.api.messagewindow.service;

import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import h71.c;
import h71.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.messagewindow.framework.CardInnerService")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/service/ICardInnerService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/view/View;", "cardContainer", "Lh71/d;", "createMsgWindowPositionAdjuster", "Lh71/c;", "getMsgWindowAdjustStrategyFilter", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ICardInnerService extends IService {
    d createMsgWindowPositionAdjuster(View r1);

    c getMsgWindowAdjustStrategyFilter();
}
