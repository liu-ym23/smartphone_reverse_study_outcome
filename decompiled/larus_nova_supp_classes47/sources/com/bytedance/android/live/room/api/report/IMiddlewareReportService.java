package com.bytedance.android.live.room.api.report;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import y71.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH'J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J$\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\fH&J\u001c\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/room/api/report/IMiddlewareReportService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/room/api/userinfo/event/ReportConstant$BusinessSource;", "businessSource", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "targetUser", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;", "userProfileEvent", "", "reportWithUserProfileEvent", "Ly71/a;", "reportParamsWrapper", "report", "", "fromSource", "reportType", "", "isReportMessage", "getReportType", "params", "Lcom/bytedance/android/live/room/api/report/ReportObject;", "getRequestPage", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareReportService extends IService {
    ReportObject getReportType(a r1);

    String getReportType(String r1, String r2, boolean r3);

    String getRequestPage(String r1, String r2);

    void report(a r1);

    @Deprecated(message = "不要用这个方法！！！！，这是方法是为了兼容资料卡的旧逻辑", replaceWith = @ReplaceWith(expression = "report(ReportParamsWrapper())", imports = {}))
    void reportWithUserProfileEvent(ReportConstant$BusinessSource r1, IBaseUser r2, IRoom r3, UserProfileEvent r4);
}
