package com.bytedance.android.live.room.api;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.task.a;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import java.util.Map;
import kotlin.Metadata;
import w71.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.service.LiveProfileProxyService")
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H&J*\u0010\u001d\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH&J\u001c\u0010!\u001a\u00020\n2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001f0\u001eH&J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0002H&JH\u0010/\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010-H&¨\u00060"}, d2 = {"Lcom/bytedance/android/live/room/api/ILiveExperienceProxyService;", "Lcom/bytedance/android/live/base/IService;", "", "rankType", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "", "showUserDialog", "", "pcu", "", "roomId", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "anchor", "Lcom/bytedance/live/datacontext/DataContext;", "dataContext", "Lcom/bytedance/android/live/core/tetris/task/a;", "widgetLoadTask", "Landroid/view/View;", "contentView", "scheduleP0WidgetLoadTask", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lw71/c;", "listener", "requestRankBackend", "", "", Constants.Keys.DATA, "collectReportTask", "statusHeight", "repotTopSpaceHeight", "logTag", "resId", "nitaTag", "Landroid/app/Activity;", "activity", "Landroid/view/ViewGroup;", "container", "", "attach", "Landroid/view/LayoutInflater;", "fallbackInflater", "tryNitaInflate", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveExperienceProxyService extends IService {
    void collectReportTask(Map<String, Object> r1);

    void repotTopSpaceHeight(int r1);

    void requestRankBackend(DataContext r1, long r2, LifecycleOwner r4, c r5);

    void scheduleP0WidgetLoadTask(DataContext r1, a r2, View r3);

    void showUserDialog(int r1, Context r2, DataCenter r3, IRoom r4);

    void showUserDialog(int r1, Context r2, String r3, long r4, IBaseUser r6);

    View tryNitaInflate(String r1, int r2, String r3, Activity r4, ViewGroup r5, boolean r6, LayoutInflater r7);
}
