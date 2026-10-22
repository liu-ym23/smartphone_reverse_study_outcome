package com.bytedance.android.live.room.api;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import y71.a;
import zg1.r2;
import zg1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.room.report.ReportService")
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH'J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&JN\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J&\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0010H&J8\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J$\u0010#\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010 \u001a\u0004\u0018\u00010\u00112\u0006\u0010\"\u001a\u00020!H&J\u001c\u0010$\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010 \u001a\u0004\u0018\u00010\u0011H&¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/room/api/IReportService;", "Lcom/bytedance/android/live/room/api/report/IMiddlewareReportService;", "Lcom/bytedance/android/live/room/api/userinfo/event/ReportConstant$BusinessSource;", "businessSource", "Lcom/bytedance/android/live/base/model/user/User;", "targetUser", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;", "userProfileEvent", "", "reportWithUserProfileEvent", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Ly71/a;", "reportParamsWrapper", "report", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "", "fromSource", "reportSource", "reportTypeForLog", "Lzg1/u;", "commentReportModel", "Lzg1/r2;", "reportAnchorEvent", "reportWithReportAnchorEvent", "Landroid/content/Context;", "context", "anchor", "Landroid/content/DialogInterface$OnDismissListener;", "dismissCallback", "screenShotReport", "reportType", "", "isReportMessage", "getReportType", "getRequestPage", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IReportService extends IMiddlewareReportService {
    @Override // com.bytedance.android.live.room.api.report.IMiddlewareReportService
    String getReportType(String r1, String r2, boolean r3);

    @Override // com.bytedance.android.live.room.api.report.IMiddlewareReportService
    String getRequestPage(String r1, String r2);

    void report(ReportConstant$BusinessSource r1, User r2, Room r3, String r4, String r5, String r6, u r7);

    @Override // com.bytedance.android.live.room.api.report.IMiddlewareReportService
    void report(a r1);

    void reportWithReportAnchorEvent(ReportConstant$BusinessSource r1, r2 r2, Room r3);

    @Override // com.bytedance.android.live.room.api.report.IMiddlewareReportService
    void reportWithUserProfileEvent(ReportConstant$BusinessSource r1, IBaseUser r2, IRoom r3, UserProfileEvent r4);

    @Deprecated(message = "不要用这个方法！！！！，这是方法是为了兼容资料卡的旧逻辑", replaceWith = @ReplaceWith(expression = "report(ReportParamsWrapper())", imports = {}))
    void reportWithUserProfileEvent(ReportConstant$BusinessSource r1, User r2, IRoom r3, UserProfileEvent r4);

    void screenShotReport(ReportConstant$BusinessSource r1, Context r2, User r3, Room r4, DialogInterface.OnDismissListener r5);
}
