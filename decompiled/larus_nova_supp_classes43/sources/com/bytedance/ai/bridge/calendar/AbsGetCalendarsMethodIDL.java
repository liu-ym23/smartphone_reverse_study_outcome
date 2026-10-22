package com.bytedance.ai.bridge.calendar;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$GetCalendarsParamModel;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$CalendarResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "GetCalendarsParamModel", "CalendarResultModel", "Calendar", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetCalendarsMethodIDL extends CoreAIBridgeMethod<b, a> {
    public final String a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$Calendar;", "", "displayName", "", com.bytedance.android.ec.core.event.a.KEY_URL, "cTag", "syncToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getUrl", "getCTag", "getSyncToken", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Calendar {

        @SerializedName("cTag")
        private final String cTag;

        @SerializedName("displayName")
        private final String displayName;

        @SerializedName("syncToken")
        private final String syncToken;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_URL)
        private final String url;

        public static /* synthetic */ Calendar copy$default(Calendar r0, String r1, String r10, String r11, String r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r1 = r0.displayName;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r10 = r0.url;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r11 = r0.cTag;
        L12:
            if ((r13 & 8) == 0) goto L15;
            r12 = r0.syncToken;
        L15:
            return r0.copy(r1, r10, r11, r12);
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

        public final Calendar copy(String r10, String r11, String r12, String r13) {
            Intrinsics.checkNotNullParameter(r10, "displayName");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r12, "cTag");
            return new Calendar(r10, r11, r12, r13);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Calendar) == true) goto L8;
            return false;
        L8:
            Calendar r11 = (Calendar) r10;
            if (Intrinsics.areEqual(this.displayName, r11.displayName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.url, r11.url) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.cTag, r11.cTag) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.syncToken, r11.syncToken) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.displayName.hashCode() * 31) + this.url.hashCode()) * 31) + this.cTag.hashCode()) * 31;
            String r1 = this.syncToken;
            if (r1 != null) goto L5;
            int r10 = 0;
        L7:
            return r0 + r10;
        L5:
            r10 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "Calendar(displayName=" + this.displayName + ", url=" + this.url + ", cTag=" + this.cTag + ", syncToken=" + this.syncToken + ')';
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

        public Calendar(String r10, String r11, String r12, String r13) {
            Intrinsics.checkNotNullParameter(r10, "displayName");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r12, "cTag");
            this.displayName = r10;
            this.url = r11;
            this.cTag = r12;
            this.syncToken = r13;
        }

        public /* synthetic */ Calendar(String r1, String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 8) == 0) goto L5;
            r12 = null;
        L5:
            this(r1, r10, r11, r12);
        }
    }

    @AIBridgeResultModel
    public interface a extends ResultModel {
        @AIBridgeParamField(keyPath = "calendars", required = true)
        void setCalendars(List<Calendar> r1);
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = "password", required = true)
        String getPassword();

        @AIBridgeParamField(keyPath = "serverUrl", required = true)
        String getServerUrl();

        @AIBridgeParamField(keyPath = "userName", required = true)
        String getUserName();
    }

    public AbsGetCalendarsMethodIDL() {
        this.a = "applet.calendar.getCalendars";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
