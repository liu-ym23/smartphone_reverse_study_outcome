package com.bytedance.ai.bridge.calendar;

import ai.j0;
import androidx.annotation.Keep;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$GetCalendarsParamModel;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$CalendarResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "GetCalendarsParamModel", "CalendarResultModel", "Calendar", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsGetCalendarsMethodIDL extends CoreAIBridgeMethod<GetCalendarsParamModel, CalendarResultModel> {
    private final String name;

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$Calendar;", "", "displayName", "", "url", "cTag", "syncToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getUrl", "getCTag", "getSyncToken", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Calendar {

        @SerializedName("cTag")
        private final String cTag;

        @SerializedName("displayName")
        private final String displayName;

        @SerializedName("syncToken")
        private final String syncToken;

        @SerializedName("url")
        private final String url;

        public Calendar(String r5, String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r5, "displayName");
            Intrinsics.checkNotNullParameter(r10, "url");
            Intrinsics.checkNotNullParameter(r11, "cTag");
            this.displayName = r5;
            this.url = r10;
            this.cTag = r11;
            this.syncToken = r12;
        }

        public static /* synthetic */ Calendar copy$default(Calendar r5, String r10, String r11, String r12, String r13, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L6;
            r10 = r5.displayName;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r11 = r5.url;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r12 = r5.cTag;
        L12:
            if ((r14 & 8) == 0) goto L15;
            r13 = r5.syncToken;
        L15:
            return r5.copy(r10, r11, r12, r13);
        }

        public final String component1() {
            return this.displayName;
        }

        public final String component2() {
            return this.url;
        }

        public final String component3() {
            return this.cTag;
        }

        public final String component4() {
            return this.syncToken;
        }

        public final Calendar copy(String r5, String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r5, "displayName");
            Intrinsics.checkNotNullParameter(r10, "url");
            Intrinsics.checkNotNullParameter(r11, "cTag");
            return new Calendar(r5, r10, r11, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Calendar) == true) goto L8;
            return false;
        L8:
            Calendar r10 = (Calendar) r5;
            if (Intrinsics.areEqual(this.displayName, r10.displayName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.url, r10.url) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.cTag, r10.cTag) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.syncToken, r10.syncToken) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final String getCTag() {
            return this.cTag;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getSyncToken() {
            return this.syncToken;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int r5 = this.displayName.hashCode() * 31;
            int r10 = a.b(this.url, r5, 31);
            int r11 = a.b(this.cTag, r10, 31);
            String r12 = this.syncToken;
            if (r12 != null) goto L5;
            int r13 = 0;
        L7:
            return r11 + r13;
        L5:
            r13 = r12.hashCode();
            goto L7
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("Calendar(displayName=");
            r5.append(this.displayName);
            r5.append(", url=");
            r5.append(this.url);
            r5.append(", cTag=");
            r5.append(this.cTag);
            r5.append(", syncToken=");
            return j0.p(r5, this.syncToken, ')');
        }

        public /* synthetic */ Calendar(String r5, String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 8) == 0) goto L5;
            r12 = null;
        L5:
            this(r5, r10, r11, r12);
        }
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$CalendarResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "Ljava/util/List;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$Calendar;", "calendars", "getCalendars", "()Ljava/util/List;", "setCalendars", "(Ljava/util/List;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface CalendarResultModel extends ResultModel {
        List<Calendar> getCalendars();

        @AIBridgeParamField(keyPath = "calendars", required = true)
        void setCalendars(List<Calendar> r5);
    }

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$GetCalendarsParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "serverUrl", "", "getServerUrl", "()Ljava/lang/String;", "userName", "getUserName", "password", "getPassword", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface GetCalendarsParamModel extends ParamModel {
        @AIBridgeParamField(keyPath = "password", required = true)
        String getPassword();

        @AIBridgeParamField(keyPath = "serverUrl", required = true)
        String getServerUrl();

        @AIBridgeParamField(keyPath = "userName", required = true)
        String getUserName();
    }

    public AbsGetCalendarsMethodIDL() {
        this.name = "applet.calendar.getCalendars";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
