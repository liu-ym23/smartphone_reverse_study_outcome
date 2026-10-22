package com.larus.bmhome.chat.trace.appreciable;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import androidx.collection.LruCache;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatPageTrace {
    public static final LruCache<String, ChatPageRecord> a = null;
    public static volatile boolean b;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bK\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001Bá\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010%J\u0006\u0010j\u001a\u00020kJ\u0010\u0010l\u001a\u00020k2\u0006\u0010m\u001a\u00020\u0005H\u0002J\b\u0010n\u001a\u0004\u0018\u00010oJ \u0010p\u001a\u00020k2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\u00032\u0006\u0010t\u001a\u00020\u0003H\u0002R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b1\u0010+\"\u0004\b2\u0010-R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010'\"\u0004\b4\u0010)R\"\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010'\"\u0004\b<\u0010)R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bD\u0010+\"\u0004\bE\u0010-R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bF\u0010+\"\u0004\bG\u0010-R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010'\"\u0004\bI\u0010)R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\b\u0013\u0010J\"\u0004\bK\u0010LR\u001e\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\b\u0016\u0010J\"\u0004\bR\u0010LR\"\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bS\u0010+\"\u0004\bT\u0010-R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bU\u0010+\"\u0004\bV\u0010-R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bW\u0010+\"\u0004\bX\u0010-R \u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010'\"\u0004\bZ\u0010)R\"\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b[\u0010@\"\u0004\b\\\u0010BR\"\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b\u001c\u0010@\"\u0004\b]\u0010BR\"\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b^\u0010@\"\u0004\b_\u0010BR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u001e\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bb\u0010+\"\u0004\bc\u0010-R\u001e\u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bd\u0010+\"\u0004\be\u0010-R\u001e\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bf\u0010+\"\u0004\bg\u0010-R\u001e\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bh\u0010+\"\u0004\bi\u0010-¨\u0006u"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatPageTrace$ChatPageRecord;", "", "channel", "", "totalDuration", "", "loadDuration", "session", "schema", "distanceToAppStart", "cvsId", "botId", "chatType", "previousPage", "hasLocal", "", "bindDuration", "createToBindDuration", "mainBotCovId", "isMainBot", "", "bindMessageType", "isPluginReadyWhenClick", "clickEntranceToPluginReadyCost", "pluginReadyToFlowSdkReadyCost", "silentAuthCost", "initEnterFrom", "flowInited", "isFirstEnter", "authStatusCode", "extraInfoBundle", "Landroid/os/Bundle;", "onCreateTime", "onStartTime", "onPageLoadTime", "onDataBindTime", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;ILjava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/os/Bundle;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getChannel", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", "getTotalDuration", "()Ljava/lang/Long;", "setTotalDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLoadDuration", "setLoadDuration", "getSession", "setSession", "getSchema", "setSchema", "getDistanceToAppStart", "setDistanceToAppStart", "getCvsId", "setCvsId", "getBotId", "setBotId", "getChatType", "setChatType", "getPreviousPage", "setPreviousPage", "getHasLocal", "()Ljava/lang/Integer;", "setHasLocal", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBindDuration", "setBindDuration", "getCreateToBindDuration", "setCreateToBindDuration", "getMainBotCovId", "setMainBotCovId", "()Ljava/lang/Boolean;", "setMainBot", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getBindMessageType", "()I", "setBindMessageType", "(I)V", "setPluginReadyWhenClick", "getClickEntranceToPluginReadyCost", "setClickEntranceToPluginReadyCost", "getPluginReadyToFlowSdkReadyCost", "setPluginReadyToFlowSdkReadyCost", "getSilentAuthCost", "setSilentAuthCost", "getInitEnterFrom", "setInitEnterFrom", "getFlowInited", "setFlowInited", "setFirstEnter", "getAuthStatusCode", "setAuthStatusCode", "getExtraInfoBundle", "()Landroid/os/Bundle;", "getOnCreateTime", "setOnCreateTime", "getOnStartTime", "setOnStartTime", "getOnPageLoadTime", "setOnPageLoadTime", "getOnDataBindTime", "setOnDataBindTime", "report", "", "appendAdditionalTracingInfo", "onDataBindTimeStamp", "toJSONObject", "Lorg/json/JSONObject;", "writeFileToExternalStorage", "context", "Landroid/content/Context;", "filename", "content", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatPageRecord {

        @SerializedName("auth_status_code")
        private Integer authStatusCode;

        @SerializedName("bind_duration")
        private Long bindDuration;

        @SerializedName("bind_msg_type")
        private int bindMessageType;

        @SerializedName("bot_id")
        private String botId;

        @SerializedName("channel")
        private String channel;

        @SerializedName("chat_type")
        private String chatType;

        @SerializedName("click_entrance_to_plugin_ready_cost")
        private Long clickEntranceToPluginReadyCost;

        @SerializedName("created_to_bind_duration")
        private Long createToBindDuration;

        @SerializedName(MusicAppletPage.KEY_CONVERSATION_ID)
        private String cvsId;

        @SerializedName("distance_to_app_start")
        private Long distanceToAppStart;
        private final transient Bundle extraInfoBundle;

        @SerializedName("flow_inited")
        private Integer flowInited;

        @SerializedName("has_local")
        private Integer hasLocal;

        @SerializedName("init_enter_from")
        private String initEnterFrom;

        @SerializedName("is_first_enter")
        private Integer isFirstEnter;

        @SerializedName("is_main_bot")
        private Boolean isMainBot;

        @SerializedName("is_plugin_ready_when_click")
        private Boolean isPluginReadyWhenClick;

        @SerializedName("load_duration")
        private Long loadDuration;

        @SerializedName("main_bot_conv_id")
        private String mainBotCovId;
        private transient Long onCreateTime;
        private transient Long onDataBindTime;
        private transient Long onPageLoadTime;
        private transient Long onStartTime;

        @SerializedName("plugin_ready_to_flow_sdk_ready_cost")
        private Long pluginReadyToFlowSdkReadyCost;

        @SerializedName("previous_page")
        private String previousPage;

        @SerializedName("schema")
        private String schema;

        @SerializedName("session")
        private Long session;

        @SerializedName("silent_auth_cost")
        private Long silentAuthCost;

        @SerializedName("total_duration")
        private Long totalDuration;

        public ChatPageRecord() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870911, null);
        }

        public final void report() {
            Long r0 = this.onStartTime;
            Long r1 = this.onPageLoadTime;
            Long r2 = this.onDataBindTime;
            Long r3 = this.onCreateTime;
            wc9.e r4 = (wc9.e) AuthModelDelegate.b.y().getValue();
            if (r4 != null) goto L6;
            r4 = LaunchCacheDelegate.b.b();
        L6:
            if (r4 == null) goto L8;
            String r5 = r4.a;
        L9:
            this.mainBotCovId = r5;
            this.isMainBot = Boolean.valueOf(Intrinsics.areEqual(r5, this.cvsId));
            if (r0 == null) goto L24;
            if (r1 == null) goto L25;
            if (r2 == null) goto L26;
            if (r3 == null) goto L27;
            this.loadDuration = Long.valueOf(r1.longValue() - r0.longValue());
            this.bindDuration = Long.valueOf(r2.longValue() - r1.longValue());
            this.totalDuration = Long.valueOf(r2.longValue() - r0.longValue());
            this.createToBindDuration = Long.valueOf(r2.longValue() - r3.longValue());
            appendAdditionalTracingInfo(r2.longValue());
            JSONObject r6 = toJSONObject();
            if (r6 == null) goto L17;
            com.larus.utils.a0.a(r6, com.flow.kmp.common.util.g.b(ce9.a.a().toString()));
        L18:
            FLogger.a.i("ChatPageTrace", "reportEvent, param=" + r6);
            Objects.toString(r6);
            if (r6 == null) goto L28;
            com.larus.platform.service.o.a.reportEvent("page_chat_first_paint", r6);
            com.larus.bmhome.utils.c.a("page_chat_first_paint", r6, true);
            if (com.larus.network.http.d.e == false) goto L29;
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChatPageTrace$ChatPageRecord$report$1$1(this, r6, null), 2, null);
            return;
        L29:
            return;
        L28:
            return;
        L17:
            r6 = null;
            goto L18
        L27:
            return;
        L26:
            return;
        L25:
            return;
        L24:
            return;
        L8:
            r5 = null;
            goto L9
        }

        public final JSONObject toJSONObject() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            Object r1 = Result.constructor-impl(new JSONObject(new Gson().toJson(this)));     // Catch: Throwable -> L4
        L7:
            if (Result.isFailure-impl(r1) == false) goto L10;
            r1 = null;
        L10:
            return (JSONObject) r1;
        L4:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }

        public final Integer getAuthStatusCode() {
            return this.authStatusCode;
        }

        public final Long getBindDuration() {
            return this.bindDuration;
        }

        public final int getBindMessageType() {
            return this.bindMessageType;
        }

        public final String getBotId() {
            return this.botId;
        }

        public final String getChannel() {
            return this.channel;
        }

        public final String getChatType() {
            return this.chatType;
        }

        public final Long getClickEntranceToPluginReadyCost() {
            return this.clickEntranceToPluginReadyCost;
        }

        public final Long getCreateToBindDuration() {
            return this.createToBindDuration;
        }

        public final String getCvsId() {
            return this.cvsId;
        }

        public final Long getDistanceToAppStart() {
            return this.distanceToAppStart;
        }

        public final Bundle getExtraInfoBundle() {
            return this.extraInfoBundle;
        }

        public final Integer getFlowInited() {
            return this.flowInited;
        }

        public final Integer getHasLocal() {
            return this.hasLocal;
        }

        public final String getInitEnterFrom() {
            return this.initEnterFrom;
        }

        public final Long getLoadDuration() {
            return this.loadDuration;
        }

        public final String getMainBotCovId() {
            return this.mainBotCovId;
        }

        public final Long getOnCreateTime() {
            return this.onCreateTime;
        }

        public final Long getOnDataBindTime() {
            return this.onDataBindTime;
        }

        public final Long getOnPageLoadTime() {
            return this.onPageLoadTime;
        }

        public final Long getOnStartTime() {
            return this.onStartTime;
        }

        public final Long getPluginReadyToFlowSdkReadyCost() {
            return this.pluginReadyToFlowSdkReadyCost;
        }

        public final String getPreviousPage() {
            return this.previousPage;
        }

        public final String getSchema() {
            return this.schema;
        }

        public final Long getSession() {
            return this.session;
        }

        public final Long getSilentAuthCost() {
            return this.silentAuthCost;
        }

        public final Long getTotalDuration() {
            return this.totalDuration;
        }

        public final Integer isFirstEnter() {
            return this.isFirstEnter;
        }

        public final Boolean isMainBot() {
            return this.isMainBot;
        }

        public final Boolean isPluginReadyWhenClick() {
            return this.isPluginReadyWhenClick;
        }

        private final void appendAdditionalTracingInfo(long r5) {
            if (AppHost.a.isPlugin() == false) goto L61;
            Bundle r0 = this.extraInfoBundle;
            boolean r2 = true;
            if (r0 != null) goto L7;
        L9:
            boolean r1 = false;
        L10:
            if (r1 == false) goto L12;
            this.isPluginReadyWhenClick = Boolean.valueOf(this.extraInfoBundle.getBoolean("is_plugin_ready_when_click"));
        L12:
            Bundle r3 = this.extraInfoBundle;
            if (r3 != null) goto L15;
        L17:
            boolean r4 = false;
        L18:
            if (r4 == false) goto L20;
            this.clickEntranceToPluginReadyCost = Long.valueOf(this.extraInfoBundle.getLong("click_entrance_to_plugin_ready_cost"));
        L20:
            Bundle r6 = this.extraInfoBundle;
            if (r6 != null) goto L23;
        L25:
            boolean r7 = false;
        L26:
            if (r7 == false) goto L28;
            this.pluginReadyToFlowSdkReadyCost = Long.valueOf(this.extraInfoBundle.getLong("plugin_ready_to_flow_sdk_ready_cost"));
        L28:
            Bundle r8 = this.extraInfoBundle;
            if (r8 != null) goto L31;
        L33:
            boolean r9 = false;
        L34:
            if (r9 == false) goto L36;
            this.silentAuthCost = Long.valueOf(this.extraInfoBundle.getLong("silent_auth_cost"));
        L36:
            Bundle r10 = this.extraInfoBundle;
            if (r10 != null) goto L39;
        L41:
            boolean r11 = false;
        L42:
            if (r11 == false) goto L44;
            this.totalDuration = Long.valueOf(r5 - this.extraInfoBundle.getLong("click_douyin_entrance_timestamp"));
        L44:
            Bundle r12 = this.extraInfoBundle;
            if (r12 != null) goto L47;
        L49:
            boolean r13 = false;
        L50:
            if (r13 == false) goto L52;
            this.initEnterFrom = this.extraInfoBundle.getString("init_enter_from");
        L52:
            Bundle r14 = this.extraInfoBundle;
            if (r14 != null) goto L55;
        L57:
            r2 = false;
        L58:
            if (r2 == false) goto L62;
            this.flowInited = Integer.valueOf(this.extraInfoBundle.getInt("flow_inited"));
            return;
        L62:
            return;
        L55:
            if (r14.containsKey("flow_inited") != true) goto L57;
        L47:
            if (r12.containsKey("init_enter_from") != true) goto L49;
            r13 = true;
            goto L50
        L39:
            if (r10.containsKey("click_douyin_entrance_timestamp") != true) goto L41;
            r11 = true;
            goto L42
        L31:
            if (r8.containsKey("silent_auth_cost") != true) goto L33;
            r9 = true;
            goto L34
        L23:
            if (r6.containsKey("plugin_ready_to_flow_sdk_ready_cost") != true) goto L25;
            r7 = true;
            goto L26
        L15:
            if (r3.containsKey("click_entrance_to_plugin_ready_cost") != true) goto L17;
            r4 = true;
            goto L18
        L7:
            if (r0.containsKey("is_plugin_ready_when_click") != true) goto L9;
            r1 = true;
            goto L10
        }

        public final void setAuthStatusCode(Integer r1) {
            this.authStatusCode = r1;
        }

        public final void setBindDuration(Long r1) {
            this.bindDuration = r1;
        }

        public final void setBindMessageType(int r1) {
            this.bindMessageType = r1;
        }

        public final void setBotId(String r1) {
            this.botId = r1;
        }

        public final void setChannel(String r1) {
            this.channel = r1;
        }

        public final void setChatType(String r1) {
            this.chatType = r1;
        }

        public final void setClickEntranceToPluginReadyCost(Long r1) {
            this.clickEntranceToPluginReadyCost = r1;
        }

        public final void setCreateToBindDuration(Long r1) {
            this.createToBindDuration = r1;
        }

        public final void setCvsId(String r1) {
            this.cvsId = r1;
        }

        public final void setDistanceToAppStart(Long r1) {
            this.distanceToAppStart = r1;
        }

        public final void setFirstEnter(Integer r1) {
            this.isFirstEnter = r1;
        }

        public final void setFlowInited(Integer r1) {
            this.flowInited = r1;
        }

        public final void setHasLocal(Integer r1) {
            this.hasLocal = r1;
        }

        public final void setInitEnterFrom(String r1) {
            this.initEnterFrom = r1;
        }

        public final void setLoadDuration(Long r1) {
            this.loadDuration = r1;
        }

        public final void setMainBot(Boolean r1) {
            this.isMainBot = r1;
        }

        public final void setMainBotCovId(String r1) {
            this.mainBotCovId = r1;
        }

        public final void setOnCreateTime(Long r1) {
            this.onCreateTime = r1;
        }

        public final void setOnDataBindTime(Long r1) {
            this.onDataBindTime = r1;
        }

        public final void setOnPageLoadTime(Long r1) {
            this.onPageLoadTime = r1;
        }

        public final void setOnStartTime(Long r1) {
            this.onStartTime = r1;
        }

        public final void setPluginReadyToFlowSdkReadyCost(Long r1) {
            this.pluginReadyToFlowSdkReadyCost = r1;
        }

        public final void setPluginReadyWhenClick(Boolean r1) {
            this.isPluginReadyWhenClick = r1;
        }

        public final void setPreviousPage(String r1) {
            this.previousPage = r1;
        }

        public final void setSchema(String r1) {
            this.schema = r1;
        }

        public final void setSession(Long r1) {
            this.session = r1;
        }

        public final void setSilentAuthCost(Long r1) {
            this.silentAuthCost = r1;
        }

        public final void setTotalDuration(Long r1) {
            this.totalDuration = r1;
        }

        private final void writeFileToExternalStorage(Context r3, String r4, String r5) {
            if (Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted") == false) goto L21;
            PolarisFileOutputStreamWrapper r6 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r3.getExternalFilesDir(null), r4));     // Catch: Exception -> L13
            r6.write(r5.getBytes(Charsets.UTF_8));     // Catch: Throwable -> L8
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L8
            CloseableKt.closeFinally(r6, null);     // Catch: Exception -> L13
            return;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            CloseableKt.closeFinally(r6, th);     // Catch: Exception -> L13
            throw th;     // Catch: Exception -> L13
        L13:
            e = move-exception;
            FLogger.a.e("ChatPageTrace", "exception=" + e.getMessage());
            com.larus.platform.service.g.a.ensureNotReachHere(e);
            return;
        }

        public static final /* synthetic */ void access$writeFileToExternalStorage(ChatPageRecord r0, Context r1, String r2, String r3) {
            r0.writeFileToExternalStorage(r1, r2, r3);
        }

        public ChatPageRecord(String r3, Long r4, Long r5, Long r6, String r7, Long r8, String r9, String r10, String r11, String r12, Integer r13, Long r14, Long r15, String r16, Boolean r17, int r18, Boolean r19, Long r20, Long r21, Long r22, String r23, Integer r24, Integer r25, Integer r26, Bundle r27, Long r28, Long r29, Long r30, Long r31) {
            this.channel = r3;
            this.totalDuration = r4;
            this.loadDuration = r5;
            this.session = r6;
            this.schema = r7;
            this.distanceToAppStart = r8;
            this.cvsId = r9;
            this.botId = r10;
            this.chatType = r11;
            this.previousPage = r12;
            this.hasLocal = r13;
            this.bindDuration = r14;
            this.createToBindDuration = r15;
            this.mainBotCovId = r16;
            this.isMainBot = r17;
            this.bindMessageType = r18;
            this.isPluginReadyWhenClick = r19;
            this.clickEntranceToPluginReadyCost = r20;
            this.pluginReadyToFlowSdkReadyCost = r21;
            this.silentAuthCost = r22;
            this.initEnterFrom = r23;
            this.flowInited = r24;
            this.isFirstEnter = r25;
            this.authStatusCode = r26;
            this.extraInfoBundle = r27;
            this.onCreateTime = r28;
            this.onStartTime = r29;
            this.onPageLoadTime = r30;
            this.onDataBindTime = r31;
        }

        public /* synthetic */ ChatPageRecord(String r31, Long r32, Long r33, Long r34, String r35, Long r36, String r37, String r38, String r39, String r40, Integer r41, Long r42, Long r43, String r44, Boolean r45, int r46, Boolean r47, Long r48, Long r49, Long r50, String r51, Integer r52, Integer r53, Integer r54, Bundle r55, Long r56, Long r57, Long r58, Long r59, int r60, DefaultConstructorMarker r61) {
            if ((r60 & 1) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r60 & 2) == 0) goto L9;
            Long r3 = null;
        L11:
            if ((r60 & 4) == 0) goto L13;
            Long r4 = null;
        L15:
            if ((r60 & 8) == 0) goto L17;
            Long r5 = null;
        L19:
            if ((r60 & 16) == 0) goto L21;
            String r6 = null;
        L23:
            if ((r60 & 32) == 0) goto L25;
            Long r7 = null;
        L27:
            if ((r60 & 64) == 0) goto L29;
            String r8 = null;
        L31:
            if ((r60 & 128) == 0) goto L33;
            String r9 = null;
        L35:
            if ((r60 & 256) == 0) goto L37;
            String r10 = null;
        L39:
            if ((r60 & 512) == 0) goto L41;
            String r11 = null;
        L43:
            if ((r60 & 1024) == 0) goto L45;
            Integer r12 = null;
        L47:
            if ((r60 & 2048) == 0) goto L49;
            Long r13 = null;
        L51:
            if ((r60 & 4096) == 0) goto L53;
            Long r14 = null;
        L55:
            if ((r60 & 8192) == 0) goto L57;
            String r15 = null;
        L59:
            if ((r60 & 16384) == 0) goto L61;
            Boolean r2 = null;
        L63:
            if ((r60 & 32768) == 0) goto L65;
            int r16 = -1;
        L67:
            if ((r60 & 65536) == 0) goto L69;
            Boolean r18 = null;
        L71:
            if ((r60 & 131072) == 0) goto L73;
            Long r19 = null;
        L75:
            if ((r60 & 262144) == 0) goto L77;
            Long r20 = null;
        L79:
            if ((r60 & 524288) == 0) goto L81;
            Long r21 = 0L;
        L83:
            if ((r60 & 1048576) == 0) goto L85;
            String r22 = null;
        L87:
            if ((r60 & 2097152) == 0) goto L89;
            Integer r23 = -1;
        L91:
            if ((r60 & 4194304) == 0) goto L93;
            Integer r24 = -1;
        L95:
            if ((r60 & 8388608) == 0) goto L97;
            Integer r17 = -1;
        L99:
            if ((r60 & 16777216) == 0) goto L101;
            Bundle r25 = null;
        L103:
            if ((r60 & 33554432) == 0) goto L105;
            Long r26 = null;
        L107:
            if ((r60 & 67108864) == 0) goto L109;
            Long r27 = null;
        L111:
            if ((r60 & 134217728) == 0) goto L113;
            Long r28 = null;
        L115:
            if ((r60 & 268435456) == 0) goto L117;
            Long r0 = null;
        L118:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r18, r19, r20, r21, r22, r23, r24, r17, r25, r26, r27, r28, r0);
            return;
        L117:
            r0 = r59;
            goto L118
        L113:
            r28 = r58;
            goto L115
        L109:
            r27 = r57;
            goto L111
        L105:
            r26 = r56;
            goto L107
        L101:
            r25 = r55;
            goto L103
        L97:
            r17 = r54;
            goto L99
        L93:
            r24 = r53;
            goto L95
        L89:
            r23 = r52;
            goto L91
        L85:
            r22 = r51;
            goto L87
        L81:
            r21 = r50;
            goto L83
        L77:
            r20 = r49;
            goto L79
        L73:
            r19 = r48;
            goto L75
        L69:
            r18 = r47;
            goto L71
        L65:
            r16 = r46;
            goto L67
        L61:
            r2 = r45;
            goto L63
        L57:
            r15 = r44;
            goto L59
        L53:
            r14 = r43;
            goto L55
        L49:
            r13 = r42;
            goto L51
        L45:
            r12 = r41;
            goto L47
        L41:
            r11 = r40;
            goto L43
        L37:
            r10 = r39;
            goto L39
        L33:
            r9 = r38;
            goto L35
        L29:
            r8 = r37;
            goto L31
        L25:
            r7 = r36;
            goto L27
        L21:
            r6 = r35;
            goto L23
        L17:
            r5 = r34;
            goto L19
        L13:
            r4 = r33;
            goto L15
        L9:
            r3 = r32;
            goto L11
        L5:
            r1 = r31;
            goto L7
        }
    }

    static {
        a = new LruCache(10);
        b = true;
    }

    public static String a(String r1) {
        if (o0.d(r1) == true) goto L13;
        wc9.e r2 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r2 != null) goto L8;
        r2 = LaunchCacheDelegate.b.b();
    L8:
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.a;
    L13:
        return r1;
    }
}
