package com.bytedance.ai.ex.widget.rpc;

import ai.j0;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Messenger;
import android.util.Log;
import androidx.constraintlayout.motion.widget.a;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ai.ex.widget.model.MiniAppInfo;
import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;
import com.bytedance.ai.ex.widget.model.MiniAppWidgetDataSnapshot;
import com.bytedance.ai.ex.widget.model.MiniAppWidgetInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lynx.tasm.utils.e;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import k5.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b1\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002qrB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0011H\u0082\b¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bJ\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00172\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0005J;\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\u0005¢\u0006\u0002\u0010%J<\u0010&\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020\u0005J8\u0010,\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u0005J8\u0010.\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010+\u001a\u00020\u0005J0\u0010/\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001b2\b\b\u0002\u0010+\u001a\u00020\u0005J>\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001b2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010+\u001a\u00020\u0005J<\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010+\u001a\u00020\u0005J2\u00105\u001a\u0004\u0018\u0001062\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001b2\b\b\u0002\u0010+\u001a\u00020\u0005J}\u00107\u001a\u0004\u0018\u0001062\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001b2\b\u00108\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010=J8\u0010>\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010+\u001a\u00020\u0005J}\u0010?\u001a\u00020-2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001b2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010\u0019\u001a\u00020\u000eJF\u0010C\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001b2\b\u0010D\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010E\u001a\u00020-2\b\b\u0002\u0010+\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/bytedance/ai/ex/widget/rpc/MiniAppWidgetManagerRemote;", "", "<init>", "()V", "TAG", "", "REMOTE_URI", "Landroid/net/Uri;", "gson", "Lcom/google/gson/Gson;", "provider", "Landroid/content/ContentProviderClient;", "callProvider", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/Context;", "method", "action", "Lkotlin/Function1;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "callProviderBundle", "Landroid/os/Bundle;", "extras", "queryMiniAppInfos", "", "Lcom/bytedance/ai/ex/widget/model/MiniAppInfo;", "context", "flags", "", MiniAppWidgetManagerRemote.METHOD_QUERY_WIDGETS, "Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetInfo;", "appletId", "ensureWidgetAvailable", "Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetAvailability;", "widgetId", "preferredVersion", "", "scene", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetAvailability;", "dispatchWidgetBind", "", "instanceId", "messenger", "Landroid/os/Messenger;", "hostId", "registerWidgetMessenger", "", "unregisterWidgetMessenger", "dispatchWidgetUnbind", "updateWidget", "reason", "refreshAffectedByUpdate", "Lcom/bytedance/ai/ex/widget/rpc/MiniAppWidgetManagerRemote$RefreshAffectedResult;", "changedDomains", "queryWidgetData", "Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetDataSnapshot;", MiniAppWidgetManagerRemote.METHOD_UPDATE_WIDGET_DATA, "widgetData", "schemaVersion", "dataVersion", "updatedAt", "state", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetDataSnapshot;", "clearWidgetData", "notifyWidgetDataChanged", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Z", MiniAppWidgetManagerRemote.METHOD_DUMP_WIDGET_RUNTIME_STATE, "Lcom/bytedance/ai/ex/widget/rpc/MiniAppWidgetManagerRemote$WidgetRuntimeStateDump;", "sendPayload", "payload", "waitForResult", "ARG_FLAGS", "ARG_APPLET_ID", "ARG_WIDGET_ID", "ARG_INSTANCE_ID", "ARG_HOST_ID", "ARG_MESSENGER", "ARG_PAYLOAD", "ARG_WAIT_FOR_RESULT", "ARG_WIDGET_DATA", "ARG_PREFERRED_VERSION", "ARG_SCHEMA_VERSION", "ARG_DATA_VERSION", "ARG_UPDATED_AT", "ARG_STATE", "ARG_REASON", "ARG_SCENE", "ARG_CHANGED_DOMAINS", "ARG_UPDATED_WIDGET_IDS", "METHOD_QUERY_MINI_APP_INFOS", "METHOD_QUERY_WIDGETS", "METHOD_ENSURE_WIDGET_AVAILABLE", "METHOD_QUERY_WIDGET_DATA", "METHOD_UPDATE_WIDGET_DATA", "METHOD_CLEAR_WIDGET_DATA", "METHOD_NOTIFY_WIDGET_DATA_CHANGED", "METHOD_DUMP_WIDGET_RUNTIME_STATE", "METHOD_REGISTER_WIDGET_MESSENGER", "METHOD_UNREGISTER_WIDGET_MESSENGER", "METHOD_DISPATCH_WIDGET_BIND", "METHOD_DISPATCH_WIDGET_UNBIND", "METHOD_UPDATE_WIDGET", "METHOD_REFRESH_AFFECTED_BY_UPDATE", "METHOD_SEND_PAYLOAD", "QUERY_MINI_APP_INFOS_FLAG_INCLUDE_UNINSTALLED", "QUERY_MINI_APP_INFOS_FLAG_WIDGETS", "REFRESH_REASON_ON_ADD", "REFRESH_REASON_ON_RESTORE", "REFRESH_REASON_EVENT", "REFRESH_REASON_VISIBILITY_GAIN", "REFRESH_REASON_MANUAL", "REFRESH_REASON_PERIODIC", "REFRESH_REASON_PACKAGE_UPDATE", "MSG_WHAT_UPDATE_WIDGET_DATA", "WidgetRuntimeStateDump", "RefreshAffectedResult", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMiniAppWidgetManagerRemote.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiniAppWidgetManagerRemote.kt\ncom/bytedance/ai/ex/widget/rpc/MiniAppWidgetManagerRemote\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,484:1\n45#1,33:485\n1#2:518\n29#3:519\n*S KotlinDebug\n*F\n+ 1 MiniAppWidgetManagerRemote.kt\ncom/bytedance/ai/ex/widget/rpc/MiniAppWidgetManagerRemote\n*L\n85#1:485,33\n19#1:519\n*E\n"})
public final class MiniAppWidgetManagerRemote {
    public static final String ARG_APPLET_ID = "appletId";
    public static final String ARG_CHANGED_DOMAINS = "changedDomains";
    public static final String ARG_DATA_VERSION = "dataVersion";
    public static final String ARG_FLAGS = "flags";
    public static final String ARG_HOST_ID = "hostId";
    public static final String ARG_INSTANCE_ID = "instanceId";
    public static final String ARG_MESSENGER = "messenger";
    public static final String ARG_PAYLOAD = "payload";
    public static final String ARG_PREFERRED_VERSION = "preferredVersion";
    public static final String ARG_REASON = "reason";
    public static final String ARG_SCENE = "scene";
    public static final String ARG_SCHEMA_VERSION = "schemaVersion";
    public static final String ARG_STATE = "state";
    public static final String ARG_UPDATED_AT = "updatedAt";
    public static final String ARG_UPDATED_WIDGET_IDS = "updatedWidgetIds";
    public static final String ARG_WAIT_FOR_RESULT = "waitForResult";
    public static final String ARG_WIDGET_DATA = "widgetData";
    public static final String ARG_WIDGET_ID = "widgetId";
    public static final MiniAppWidgetManagerRemote INSTANCE = null;
    public static final String METHOD_CLEAR_WIDGET_DATA = "clearWidgetData";
    public static final String METHOD_DISPATCH_WIDGET_BIND = "dispatchWidgetBind";
    public static final String METHOD_DISPATCH_WIDGET_UNBIND = "dispatchWidgetUnbind";
    public static final String METHOD_DUMP_WIDGET_RUNTIME_STATE = "dumpWidgetRuntimeState";
    public static final String METHOD_ENSURE_WIDGET_AVAILABLE = "ensureWidgetAvailable";
    public static final String METHOD_NOTIFY_WIDGET_DATA_CHANGED = "notifyWidgetDataChanged";
    public static final String METHOD_QUERY_MINI_APP_INFOS = "queryMiniAppInfos";
    public static final String METHOD_QUERY_WIDGETS = "queryWidgets";
    public static final String METHOD_QUERY_WIDGET_DATA = "queryWidgetData";
    public static final String METHOD_REFRESH_AFFECTED_BY_UPDATE = "refreshAffectedByUpdate";
    public static final String METHOD_REGISTER_WIDGET_MESSENGER = "registerWidgetMessenger";
    public static final String METHOD_SEND_PAYLOAD = "sendPayload";
    public static final String METHOD_UNREGISTER_WIDGET_MESSENGER = "unregisterWidgetMessenger";
    public static final String METHOD_UPDATE_WIDGET = "updateWidget";
    public static final String METHOD_UPDATE_WIDGET_DATA = "updateWidgetData";
    public static final int MSG_WHAT_UPDATE_WIDGET_DATA = 0;
    public static final int QUERY_MINI_APP_INFOS_FLAG_INCLUDE_UNINSTALLED = 1;
    public static final int QUERY_MINI_APP_INFOS_FLAG_WIDGETS = 2;
    public static final String REFRESH_REASON_EVENT = "event";
    public static final String REFRESH_REASON_MANUAL = "manual";
    public static final String REFRESH_REASON_ON_ADD = "onAdd";
    public static final String REFRESH_REASON_ON_RESTORE = "onRestore";
    public static final String REFRESH_REASON_PACKAGE_UPDATE = "packageUpdate";
    public static final String REFRESH_REASON_PERIODIC = "periodic";
    public static final String REFRESH_REASON_VISIBILITY_GAIN = "visibilityGain";
    private static final Uri REMOTE_URI = null;
    private static final String TAG = "MiniAppWidgetRemote";
    private static final Gson gson = null;
    private static ContentProviderClient provider;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/ex/widget/rpc/MiniAppWidgetManagerRemote$RefreshAffectedResult;", "", "acceptedCount", "", "updatedWidgetIds", "", "", "<init>", "(ILjava/util/List;)V", "getAcceptedCount", "()I", "getUpdatedWidgetIds", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RefreshAffectedResult {
        private final int acceptedCount;
        private final List<String> updatedWidgetIds;

        /* JADX WARN: Multi-variable type inference failed */
        public RefreshAffectedResult() {
            int r5 = 0;
            this(r5, null, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RefreshAffectedResult copy$default(RefreshAffectedResult r5, int r10, List r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.acceptedCount;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.updatedWidgetIds;
        L9:
            return r5.copy(r10, r11);
        }

        public final int component1() {
            return this.acceptedCount;
        }

        public final List<String> component2() {
            return this.updatedWidgetIds;
        }

        public final RefreshAffectedResult copy(int r5, List<String> r10) {
            Intrinsics.checkNotNullParameter(r10, "updatedWidgetIds");
            return new RefreshAffectedResult(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof RefreshAffectedResult) == true) goto L8;
            return false;
        L8:
            RefreshAffectedResult r10 = (RefreshAffectedResult) r5;
            if (this.acceptedCount == r10.acceptedCount) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.updatedWidgetIds, r10.updatedWidgetIds) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int getAcceptedCount() {
            return this.acceptedCount;
        }

        public final List<String> getUpdatedWidgetIds() {
            return this.updatedWidgetIds;
        }

        public int hashCode() {
            int r5 = Integer.hashCode(this.acceptedCount) * 31;
            return this.updatedWidgetIds.hashCode() + r5;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("RefreshAffectedResult(acceptedCount=");
            r5.append(this.acceptedCount);
            r5.append(", updatedWidgetIds=");
            return a.v(r5, this.updatedWidgetIds, ')');
        }

        public RefreshAffectedResult(int r5, List<String> r10) {
            Intrinsics.checkNotNullParameter(r10, "updatedWidgetIds");
            this.acceptedCount = r5;
            this.updatedWidgetIds = r10;
        }

        public /* synthetic */ RefreshAffectedResult(int r5, List r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = 0;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r10 = CollectionsKt.emptyList();
        L8:
            this(r5, r10);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u008b\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018¨\u0006-"}, d2 = {"Lcom/bytedance/ai/ex/widget/rpc/MiniAppWidgetManagerRemote$WidgetRuntimeStateDump;", "", "runtimeStateCount", "", "messengerStateCount", "snapshotStateCount", "pendingNotifyCount", "trailingNotifyCount", "runtimeKeys", "", "", "messengerKeys", "pendingNotifyKeys", "trailingNotifyKeys", "snapshotKeys", "<init>", "(IIIIILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getRuntimeStateCount", "()I", "getMessengerStateCount", "getSnapshotStateCount", "getPendingNotifyCount", "getTrailingNotifyCount", "getRuntimeKeys", "()Ljava/util/List;", "getMessengerKeys", "getPendingNotifyKeys", "getTrailingNotifyKeys", "getSnapshotKeys", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WidgetRuntimeStateDump {
        private final List<String> messengerKeys;
        private final int messengerStateCount;
        private final int pendingNotifyCount;
        private final List<String> pendingNotifyKeys;
        private final List<String> runtimeKeys;
        private final int runtimeStateCount;
        private final List<String> snapshotKeys;
        private final int snapshotStateCount;
        private final int trailingNotifyCount;
        private final List<String> trailingNotifyKeys;

        public WidgetRuntimeStateDump() {
            int r5 = 0;
            int r10 = 0;
            int r11 = 0;
            int r12 = 0;
            int r13 = 0;
            List r14 = null;
            List r15 = null;
            List r16 = null;
            List r17 = null;
            List r18 = null;
            this(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, 1023, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WidgetRuntimeStateDump copy$default(WidgetRuntimeStateDump r11, int r12, int r13, int r14, int r15, int r16, List r17, List r18, List r19, List r20, List r21, int r22, Object r23) {
            if ((r22 & 1) == 0) goto L5;
            int r5 = r11.runtimeStateCount;
        L7:
            if ((r22 & 2) == 0) goto L9;
            int r10 = r11.messengerStateCount;
        L11:
            if ((r22 & 4) == 0) goto L13;
            int r24 = r11.snapshotStateCount;
        L15:
            if ((r22 & 8) == 0) goto L17;
            int r25 = r11.pendingNotifyCount;
        L19:
            if ((r22 & 16) == 0) goto L21;
            int r26 = r11.trailingNotifyCount;
        L23:
            if ((r22 & 32) == 0) goto L25;
            List r27 = r11.runtimeKeys;
        L27:
            if ((r22 & 64) == 0) goto L29;
            List r28 = r11.messengerKeys;
        L31:
            if ((r22 & 128) == 0) goto L33;
            List r29 = r11.pendingNotifyKeys;
        L35:
            if ((r22 & 256) == 0) goto L37;
            List r110 = r11.trailingNotifyKeys;
        L39:
            if ((r22 & 512) == 0) goto L41;
            List r30 = r11.snapshotKeys;
        L43:
            return r11.copy(r5, r10, r24, r25, r26, r27, r28, r29, r110, r30);
        L41:
            r30 = r21;
            goto L43
        L37:
            r110 = r20;
            goto L39
        L33:
            r29 = r19;
            goto L35
        L29:
            r28 = r18;
            goto L31
        L25:
            r27 = r17;
            goto L27
        L21:
            r26 = r16;
            goto L23
        L17:
            r25 = r15;
            goto L19
        L13:
            r24 = r14;
            goto L15
        L9:
            r10 = r13;
            goto L11
        L5:
            r5 = r12;
            goto L7
        }

        public final int component1() {
            return this.runtimeStateCount;
        }

        public final List<String> component10() {
            return this.snapshotKeys;
        }

        public final int component2() {
            return this.messengerStateCount;
        }

        public final int component3() {
            return this.snapshotStateCount;
        }

        public final int component4() {
            return this.pendingNotifyCount;
        }

        public final int component5() {
            return this.trailingNotifyCount;
        }

        public final List<String> component6() {
            return this.runtimeKeys;
        }

        public final List<String> component7() {
            return this.messengerKeys;
        }

        public final List<String> component8() {
            return this.pendingNotifyKeys;
        }

        public final List<String> component9() {
            return this.trailingNotifyKeys;
        }

        public final WidgetRuntimeStateDump copy(int r13, int r14, int r15, int r16, int r17, List<String> r18, List<String> r19, List<String> r20, List<String> r21, List<String> r22) {
            Intrinsics.checkNotNullParameter(r18, "runtimeKeys");
            Intrinsics.checkNotNullParameter(r19, "messengerKeys");
            Intrinsics.checkNotNullParameter(r20, "pendingNotifyKeys");
            Intrinsics.checkNotNullParameter(r21, "trailingNotifyKeys");
            Intrinsics.checkNotNullParameter(r22, "snapshotKeys");
            return new WidgetRuntimeStateDump(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof WidgetRuntimeStateDump) == true) goto L8;
            return false;
        L8:
            WidgetRuntimeStateDump r10 = (WidgetRuntimeStateDump) r5;
            if (this.runtimeStateCount == r10.runtimeStateCount) goto L12;
            return false;
        L12:
            if (this.messengerStateCount == r10.messengerStateCount) goto L15;
            return false;
        L15:
            if (this.snapshotStateCount == r10.snapshotStateCount) goto L18;
            return false;
        L18:
            if (this.pendingNotifyCount == r10.pendingNotifyCount) goto L21;
            return false;
        L21:
            if (this.trailingNotifyCount == r10.trailingNotifyCount) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.runtimeKeys, r10.runtimeKeys) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.messengerKeys, r10.messengerKeys) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.pendingNotifyKeys, r10.pendingNotifyKeys) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.trailingNotifyKeys, r10.trailingNotifyKeys) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.snapshotKeys, r10.snapshotKeys) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final List<String> getMessengerKeys() {
            return this.messengerKeys;
        }

        public final int getMessengerStateCount() {
            return this.messengerStateCount;
        }

        public final int getPendingNotifyCount() {
            return this.pendingNotifyCount;
        }

        public final List<String> getPendingNotifyKeys() {
            return this.pendingNotifyKeys;
        }

        public final List<String> getRuntimeKeys() {
            return this.runtimeKeys;
        }

        public final int getRuntimeStateCount() {
            return this.runtimeStateCount;
        }

        public final List<String> getSnapshotKeys() {
            return this.snapshotKeys;
        }

        public final int getSnapshotStateCount() {
            return this.snapshotStateCount;
        }

        public final int getTrailingNotifyCount() {
            return this.trailingNotifyCount;
        }

        public final List<String> getTrailingNotifyKeys() {
            return this.trailingNotifyKeys;
        }

        public int hashCode() {
            int r5 = Integer.hashCode(this.runtimeStateCount) * 31;
            int r10 = d.a(this.messengerStateCount, r5);
            int r11 = d.a(this.snapshotStateCount, r10);
            int r12 = d.a(this.pendingNotifyCount, r11);
            int r13 = d.a(this.trailingNotifyCount, r12);
            int r14 = a.f(this.runtimeKeys, r13, 31);
            int r15 = a.f(this.messengerKeys, r14, 31);
            int r16 = a.f(this.pendingNotifyKeys, r15, 31);
            int r17 = a.f(this.trailingNotifyKeys, r16, 31);
            return this.snapshotKeys.hashCode() + r17;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("WidgetRuntimeStateDump(runtimeStateCount=");
            r5.append(this.runtimeStateCount);
            r5.append(", messengerStateCount=");
            r5.append(this.messengerStateCount);
            r5.append(", snapshotStateCount=");
            r5.append(this.snapshotStateCount);
            r5.append(", pendingNotifyCount=");
            r5.append(this.pendingNotifyCount);
            r5.append(", trailingNotifyCount=");
            r5.append(this.trailingNotifyCount);
            r5.append(", runtimeKeys=");
            r5.append(this.runtimeKeys);
            r5.append(", messengerKeys=");
            r5.append(this.messengerKeys);
            r5.append(", pendingNotifyKeys=");
            r5.append(this.pendingNotifyKeys);
            r5.append(", trailingNotifyKeys=");
            r5.append(this.trailingNotifyKeys);
            r5.append(", snapshotKeys=");
            return a.v(r5, this.snapshotKeys, ')');
        }

        public WidgetRuntimeStateDump(int r5, int r10, int r11, int r12, int r13, List<String> r14, List<String> r15, List<String> r16, List<String> r17, List<String> r18) {
            Intrinsics.checkNotNullParameter(r14, "runtimeKeys");
            Intrinsics.checkNotNullParameter(r15, "messengerKeys");
            Intrinsics.checkNotNullParameter(r16, "pendingNotifyKeys");
            Intrinsics.checkNotNullParameter(r17, "trailingNotifyKeys");
            Intrinsics.checkNotNullParameter(r18, "snapshotKeys");
            this.runtimeStateCount = r5;
            this.messengerStateCount = r10;
            this.snapshotStateCount = r11;
            this.pendingNotifyCount = r12;
            this.trailingNotifyCount = r13;
            this.runtimeKeys = r14;
            this.messengerKeys = r15;
            this.pendingNotifyKeys = r16;
            this.trailingNotifyKeys = r17;
            this.snapshotKeys = r18;
        }

        public /* synthetic */ WidgetRuntimeStateDump(int r5, int r10, int r11, int r12, int r13, List r14, List r15, List r16, List r17, List r18, int r19, DefaultConstructorMarker r110) {
            if ((r19 & 1) == 0) goto L6;
            r5 = 0;
        L6:
            if ((r19 & 2) == 0) goto L9;
            r10 = 0;
        L9:
            if ((r19 & 4) == 0) goto L12;
            r11 = 0;
        L12:
            if ((r19 & 8) == 0) goto L15;
            r12 = 0;
        L15:
            if ((r19 & 16) == 0) goto L18;
            r13 = 0;
        L18:
            if ((r19 & 32) == 0) goto L21;
            r14 = CollectionsKt.emptyList();
        L21:
            if ((r19 & 64) == 0) goto L24;
            r15 = CollectionsKt.emptyList();
        L24:
            if ((r19 & 128) == 0) goto L27;
            r16 = CollectionsKt.emptyList();
        L27:
            if ((r19 & 256) == 0) goto L30;
            r17 = CollectionsKt.emptyList();
        L30:
            if ((r19 & 512) == 0) goto L32;
            r18 = CollectionsKt.emptyList();
        L32:
            this(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18);
        }
    }

    static {
        INSTANCE = new MiniAppWidgetManagerRemote();
        REMOTE_URI = Uri.parse("content://com.obric.appletapp.SystemAppletProvider");
        gson = new Gson();
    }

    private MiniAppWidgetManagerRemote() {
    }

    private final <T> T callProvider(Context r10, String r11, Function1<? super ContentProviderClient, ? extends T> r12) {
        ContentProviderClient r5 = provider;
        if (r5 == null) goto L13;
        T r13 = r12.invoke(r5);     // Catch: DeadObjectException -> L8
        if (r13 != null) goto L10;
        Log.w(TAG, "call returned null, method=" + r11 + ", cached=true");     // Catch: DeadObjectException -> L8
    L10:
        return r13;
    L8:
        e = move-exception;
        Log.w(TAG, "cached provider dead, method=" + r11, e);
        provider = null;
    L13:
        if (provider != null) goto L15;
        provider = r10.getContentResolver().acquireUnstableContentProviderClient(REMOTE_URI);
    L15:
        ContentProviderClient r14 = provider;
        if (r14 != null) goto L28;
        StringBuilder r15 = j0.x("acquire provider failed, method=", r11, ", uri=");
        r15.append(REMOTE_URI);
        Log.w(TAG, r15.toString());
        return null;
    L28:
        T r16 = r12.invoke(r14);     // Catch: DeadObjectException -> L23
        if (r16 != null) goto L32;
        Log.w(TAG, "call returned null, method=" + r11 + ", cached=false");     // Catch: DeadObjectException -> L23
    L32:
        return r16;
    L23:
        e = move-exception;
        Log.w(TAG, "provider dead, method=" + r11, e);
        provider = null;
        return null;
    }

    private final Bundle callProviderBundle(Context r10, String r11, Bundle r12) {
        ContentProviderClient r5 = provider;
        if (r5 == null) goto L13;
        Bundle r13 = r5.call(r11, null, r12);     // Catch: DeadObjectException -> L8
        if (r13 != null) goto L10;
        Log.w(TAG, "call returned null, method=" + r11 + ", cached=true");     // Catch: DeadObjectException -> L8
        return r13;
    L10:
        return r13;
    L8:
        e = move-exception;
        Log.w(TAG, "cached provider dead, method=" + r11, e);
        provider = null;
    L13:
        if (provider != null) goto L15;
        provider = r10.getContentResolver().acquireUnstableContentProviderClient(REMOTE_URI);
    L15:
        ContentProviderClient r14 = provider;
        if (r14 != null) goto L27;
        StringBuilder r15 = e.b("acquire provider failed, method=", r11, ", uri=");
        r15.append(REMOTE_URI);
        Log.w(TAG, r15.toString());
        return null;
    L27:
        Bundle r16 = r14.call(r11, null, r12);     // Catch: DeadObjectException -> L22
        if (r16 != null) goto L32;
        Log.w(TAG, "call returned null, method=" + r11 + ", cached=false");     // Catch: DeadObjectException -> L22
    L32:
        return r16;
    L22:
        e = move-exception;
        Log.w(TAG, "provider dead, method=" + r11, e);
        provider = null;
        return null;
    }

    public static /* synthetic */ boolean clearWidgetData$default(MiniAppWidgetManagerRemote r10, Context r11, int r12, String r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        String r18 = null;
    L11:
        if ((r16 & 16) == 0) goto L14;
        r15 = "launcher";
    L14:
        return r10.clearWidgetData(r11, r12, r5, r18, r15);
    L9:
        r18 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public static /* synthetic */ void dispatchWidgetBind$default(MiniAppWidgetManagerRemote r10, Context r11, String r12, String r13, int r14, Messenger r15, String r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        r15 = null;
    L5:
        Messenger r5 = r15;
        if ((r17 & 32) == 0) goto L8;
        r16 = "launcher";
    L8:
        r10.dispatchWidgetBind(r11, r12, r13, r14, r5, r16);
    }

    public static /* synthetic */ void dispatchWidgetUnbind$default(MiniAppWidgetManagerRemote r10, Context r11, String r12, String r13, int r14, String r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L5;
        r15 = "launcher";
    L5:
        r10.dispatchWidgetUnbind(r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ MiniAppWidgetAvailability ensureWidgetAvailable$default(MiniAppWidgetManagerRemote r10, Context r11, String r12, String r13, Long r14, String r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        r14 = null;
    L5:
        Long r5 = r14;
        if ((r16 & 16) == 0) goto L9;
        r15 = "manual";
    L9:
        return r10.ensureWidgetAvailable(r11, r12, r13, r5, r15);
    }

    public static /* synthetic */ boolean notifyWidgetDataChanged$default(MiniAppWidgetManagerRemote r15, Context r16, String r17, String r18, int r19, String r20, String r21, Integer r22, Long r23, Long r24, String r25, String r26, int r27, Object r28) {
        if ((r27 & 16) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r27 & 32) == 0) goto L9;
        String r11 = "launcher";
    L11:
        if ((r27 & 64) == 0) goto L13;
        Integer r12 = null;
    L15:
        if ((r27 & 128) == 0) goto L17;
        Long r13 = null;
    L19:
        if ((r27 & 256) == 0) goto L21;
        Long r14 = null;
    L23:
        if ((r27 & 512) == 0) goto L25;
        String r110 = null;
    L27:
        if ((r27 & 1024) == 0) goto L29;
        String r111 = null;
    L31:
        return r15.notifyWidgetDataChanged(r16, r17, r18, r19, r10, r11, r12, r13, r14, r110, r111);
    L29:
        r111 = r26;
        goto L31
    L25:
        r110 = r25;
        goto L27
    L21:
        r14 = r24;
        goto L23
    L17:
        r13 = r23;
        goto L19
    L13:
        r12 = r22;
        goto L15
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }

    public static /* synthetic */ MiniAppWidgetDataSnapshot queryWidgetData$default(MiniAppWidgetManagerRemote r10, Context r11, String r12, String r13, int r14, String r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = "launcher";
    L6:
        return r10.queryWidgetData(r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ RefreshAffectedResult refreshAffectedByUpdate$default(MiniAppWidgetManagerRemote r10, Context r11, String r12, List r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        r14 = null;
    L5:
        String r5 = r14;
        if ((r16 & 16) == 0) goto L9;
        r15 = "launcher";
    L9:
        return r10.refreshAffectedByUpdate(r11, r12, r13, r5, r15);
    }

    public static /* synthetic */ boolean registerWidgetMessenger$default(MiniAppWidgetManagerRemote r10, Context r11, String r12, String r13, int r14, Messenger r15, String r16, int r17, Object r18) {
        if ((r17 & 32) == 0) goto L6;
        r16 = "launcher";
    L6:
        return r10.registerWidgetMessenger(r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ String sendPayload$default(MiniAppWidgetManagerRemote r10, Context r11, String r12, String r13, int r14, String r15, boolean r16, String r17, int r18, Object r19) {
        if ((r18 & 32) == 0) goto L5;
        boolean r20 = false;
    L7:
        if ((r18 & 64) == 0) goto L9;
        String r21 = "launcher";
    L11:
        return r10.sendPayload(r11, r12, r13, r14, r15, r20, r21);
    L9:
        r21 = r17;
        goto L11
    L5:
        r20 = r16;
        goto L7
    }

    public static /* synthetic */ boolean unregisterWidgetMessenger$default(MiniAppWidgetManagerRemote r10, Context r11, int r12, String r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        String r18 = null;
    L11:
        if ((r16 & 16) == 0) goto L14;
        r15 = "launcher";
    L14:
        return r10.unregisterWidgetMessenger(r11, r12, r5, r18, r15);
    L9:
        r18 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public static /* synthetic */ String updateWidget$default(MiniAppWidgetManagerRemote r10, Context r11, String r12, String r13, int r14, String r15, String r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        r15 = null;
    L5:
        String r5 = r15;
        if ((r17 & 32) == 0) goto L9;
        r16 = "launcher";
    L9:
        return r10.updateWidget(r11, r12, r13, r14, r5, r16);
    }

    public static /* synthetic */ MiniAppWidgetDataSnapshot updateWidgetData$default(MiniAppWidgetManagerRemote r14, Context r15, String r16, String r17, int r18, String r19, String r20, Integer r21, Long r22, Long r23, String r24, String r25, int r26, Object r27) {
        if ((r26 & 32) == 0) goto L5;
        String r10 = "launcher";
    L7:
        if ((r26 & 64) == 0) goto L9;
        Integer r11 = null;
    L11:
        if ((r26 & 128) == 0) goto L13;
        Long r12 = null;
    L15:
        if ((r26 & 256) == 0) goto L17;
        Long r13 = null;
    L19:
        if ((r26 & 512) == 0) goto L21;
        String r110 = null;
    L23:
        if ((r26 & 1024) == 0) goto L25;
        String r111 = null;
    L27:
        return r14.updateWidgetData(r15, r16, r17, r18, r19, r10, r11, r12, r13, r110, r111);
    L25:
        r111 = r25;
        goto L27
    L21:
        r110 = r24;
        goto L23
    L17:
        r13 = r23;
        goto L19
    L13:
        r12 = r22;
        goto L15
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }

    public final boolean clearWidgetData(Context r5, int r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r13, "hostId");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L6
        Bundle r15 = new Bundle();     // Catch: Throwable -> L6
        r15.putInt("instanceId", r10);     // Catch: Throwable -> L6
        if (r11 == null) goto L8;
        r15.putString("appletId", r11);     // Catch: Throwable -> L6
    L8:
        if (r12 == null) goto L10;
        r15.putString("widgetId", r12);     // Catch: Throwable -> L6
    L10:
        r15.putString("hostId", r13);     // Catch: Throwable -> L6
        Bundle r16 = callProviderBundle(r5, "clearWidgetData", r15);     // Catch: Throwable -> L6
        boolean r17 = false;
        if (r16 == null) goto L13;
        r17 = r16.getBoolean("clearWidgetData", false);     // Catch: Throwable -> L6
    L13:
        Object r18 = Result.m124constructorimpl(Boolean.valueOf(r17));     // Catch: Throwable -> L6
    L16:
        Throwable r19 = Result.m127exceptionOrNullimpl(r18);
        if (r19 == null) goto L19;
        r19.printStackTrace();
    L19:
        Boolean r20 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r18) == false) goto L23;
        r18 = r20;
    L23:
        return ((Boolean) r18).booleanValue();
    L6:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final void dispatchWidgetBind(Context r5, String r10, String r11, int r12, Messenger r13, String r14) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        Intrinsics.checkNotNullParameter(r14, "hostId");
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L6
        Bundle r16 = new Bundle();     // Catch: Throwable -> L6
        r16.putString("appletId", r10);     // Catch: Throwable -> L6
        r16.putString("widgetId", r11);     // Catch: Throwable -> L6
        r16.putInt("instanceId", r12);     // Catch: Throwable -> L6
        r16.putString("hostId", r14);     // Catch: Throwable -> L6
        if (r13 == null) goto L8;
        r16.putParcelable("messenger", r13);     // Catch: Throwable -> L6
    L8:
        Object r17 = Result.m124constructorimpl(callProviderBundle(r5, "dispatchWidgetBind", r16));     // Catch: Throwable -> L6
    L11:
        Throwable r18 = Result.m127exceptionOrNullimpl(r17);
        if (r18 == null) goto L17;
        r18.printStackTrace();
        return;
    L17:
        return;
    L6:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void dispatchWidgetUnbind(Context r5, String r10, String r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        Intrinsics.checkNotNullParameter(r13, "hostId");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L5
        Bundle r15 = new Bundle();     // Catch: Throwable -> L5
        r15.putString("appletId", r10);     // Catch: Throwable -> L5
        r15.putString("widgetId", r11);     // Catch: Throwable -> L5
        r15.putInt("instanceId", r12);     // Catch: Throwable -> L5
        r15.putString("hostId", r13);     // Catch: Throwable -> L5
        Object r16 = Result.m124constructorimpl(callProviderBundle(r5, "dispatchWidgetUnbind", r15));     // Catch: Throwable -> L5
    L7:
        Throwable r17 = Result.m127exceptionOrNullimpl(r16);
        if (r17 == null) goto L13;
        r17.printStackTrace();
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final WidgetRuntimeStateDump dumpWidgetRuntimeState(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        Bundle r12 = callProviderBundle(r5, METHOD_DUMP_WIDGET_RUNTIME_STATE, new Bundle());     // Catch: Throwable -> L8
        if (r12 == null) goto L10;
        String r13 = r12.getString(METHOD_DUMP_WIDGET_RUNTIME_STATE);     // Catch: Throwable -> L8
        if (r13 == null) goto L10;
        WidgetRuntimeStateDump r14 = (WidgetRuntimeStateDump) gson.fromJson(r13, WidgetRuntimeStateDump.class);     // Catch: Throwable -> L8
    L11:
        Object r15 = Result.m124constructorimpl(r14);     // Catch: Throwable -> L8
    L14:
        Throwable r16 = Result.m127exceptionOrNullimpl(r15);
        if (r16 == null) goto L18;
        r16.printStackTrace();
    L18:
        if (Result.m130isFailureimpl(r15) == true) goto L22;
        r10 = r15;
    L22:
        return (WidgetRuntimeStateDump) r10;
    L10:
        r14 = null;
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final MiniAppWidgetAvailability ensureWidgetAvailable(Context r10, String r11, String r12, Long r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        Intrinsics.checkNotNullParameter(r14, "scene");
        Object r5 = null;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L6
        Bundle r16 = new Bundle();     // Catch: Throwable -> L6
        r16.putString("appletId", r11);     // Catch: Throwable -> L6
        r16.putString("widgetId", r12);     // Catch: Throwable -> L6
        if (r13 == null) goto L8;
        r16.putLong("preferredVersion", r13.longValue());     // Catch: Throwable -> L6
    L8:
        r16.putString("scene", r14);     // Catch: Throwable -> L6
        Bundle r17 = callProviderBundle(r10, "ensureWidgetAvailable", r16);     // Catch: Throwable -> L6
        if (r17 == null) goto L13;
        String r18 = r17.getString("ensureWidgetAvailable");     // Catch: Throwable -> L6
        if (r18 == null) goto L13;
        MiniAppWidgetAvailability r19 = (MiniAppWidgetAvailability) gson.fromJson(r18, MiniAppWidgetAvailability.class);     // Catch: Throwable -> L6
    L14:
        Object r20 = Result.m124constructorimpl(r19);     // Catch: Throwable -> L6
    L17:
        Throwable r21 = Result.m127exceptionOrNullimpl(r20);
        if (r21 == null) goto L21;
        r21.printStackTrace();
    L21:
        if (Result.m130isFailureimpl(r20) == true) goto L25;
        r5 = r20;
    L25:
        return (MiniAppWidgetAvailability) r5;
    L13:
        r19 = null;
    L6:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public final boolean notifyWidgetDataChanged(Context r13, String r14, String r15, int r16, String r17, String r18, Integer r19, Long r20, Long r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "appletId");
        Intrinsics.checkNotNullParameter(r15, "widgetId");
        Intrinsics.checkNotNullParameter(r18, "hostId");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        Bundle r12 = new Bundle();     // Catch: Throwable -> L6
        r12.putString("appletId", r14);     // Catch: Throwable -> L6
        r12.putString("widgetId", r15);     // Catch: Throwable -> L6
        r12.putInt("instanceId", r16);     // Catch: Throwable -> L6
        r12.putString("hostId", r18);     // Catch: Throwable -> L6
        if (r17 == null) goto L8;
        r12.putString("widgetData", r17);     // Catch: Throwable -> L6
    L8:
        if (r19 == null) goto L10;
        r12.putInt("schemaVersion", r19.intValue());     // Catch: Throwable -> L6
    L10:
        if (r20 == null) goto L12;
        r12.putLong("dataVersion", r20.longValue());     // Catch: Throwable -> L6
    L12:
        if (r21 == null) goto L14;
        r12.putLong("updatedAt", r21.longValue());     // Catch: Throwable -> L6
    L14:
        if (r22 == null) goto L16;
        r12.putString("state", r22);     // Catch: Throwable -> L6
    L16:
        if (r23 == null) goto L18;
        r12.putString("reason", r23);     // Catch: Throwable -> L6
    L18:
        Bundle r5 = callProviderBundle(r13, "notifyWidgetDataChanged", r12);     // Catch: Throwable -> L6
        boolean r10 = false;
        if (r5 == null) goto L21;
        r10 = r5.getBoolean("notifyWidgetDataChanged", false);     // Catch: Throwable -> L6
    L21:
        Object r24 = Result.m124constructorimpl(Boolean.valueOf(r10));     // Catch: Throwable -> L6
    L24:
        Throwable r25 = Result.m127exceptionOrNullimpl(r24);
        if (r25 == null) goto L27;
        r25.printStackTrace();
    L27:
        Boolean r26 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r24) == false) goto L31;
        r24 = r26;
    L31:
        return ((Boolean) r24).booleanValue();
    L6:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public final List<MiniAppInfo> queryMiniAppInfos(Context r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r11 = null;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L8
        Bundle r13 = new Bundle();     // Catch: Throwable -> L8
        r13.putInt("flags", r10);     // Catch: Throwable -> L8
        Bundle r14 = callProviderBundle(r5, "queryMiniAppInfos", r13);     // Catch: Throwable -> L8
        if (r14 == null) goto L10;
        String r15 = r14.getString("queryMiniAppInfos");     // Catch: Throwable -> L8
        if (r15 == null) goto L10;
        List r16 = (List) gson.fromJson(r15, TypeToken.getParameterized(List.class, new Type[]{MiniAppInfo.class}).getType());     // Catch: Throwable -> L8
    L11:
        Object r17 = Result.m124constructorimpl(r16);     // Catch: Throwable -> L8
    L14:
        Throwable r18 = Result.m127exceptionOrNullimpl(r17);
        if (r18 == null) goto L18;
        r18.printStackTrace();
    L18:
        if (Result.m130isFailureimpl(r17) == true) goto L21;
        r11 = r17;
    L21:
        List<MiniAppInfo> r19 = (List) r11;
        if (r19 == null) goto L24;
        return r19;
    L24:
        return CollectionsKt.emptyList();
    L10:
        r16 = null;
    L8:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final MiniAppWidgetDataSnapshot queryWidgetData(Context r10, String r11, String r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        Intrinsics.checkNotNullParameter(r14, "hostId");
        Object r5 = null;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L8
        Bundle r16 = new Bundle();     // Catch: Throwable -> L8
        r16.putString("appletId", r11);     // Catch: Throwable -> L8
        r16.putString("widgetId", r12);     // Catch: Throwable -> L8
        r16.putInt("instanceId", r13);     // Catch: Throwable -> L8
        r16.putString("hostId", r14);     // Catch: Throwable -> L8
        Bundle r17 = callProviderBundle(r10, "queryWidgetData", r16);     // Catch: Throwable -> L8
        if (r17 == null) goto L10;
        String r18 = r17.getString("queryWidgetData");     // Catch: Throwable -> L8
        if (r18 == null) goto L10;
        MiniAppWidgetDataSnapshot r19 = (MiniAppWidgetDataSnapshot) gson.fromJson(r18, MiniAppWidgetDataSnapshot.class);     // Catch: Throwable -> L8
    L11:
        Object r20 = Result.m124constructorimpl(r19);     // Catch: Throwable -> L8
    L14:
        Throwable r21 = Result.m127exceptionOrNullimpl(r20);
        if (r21 == null) goto L18;
        r21.printStackTrace();
    L18:
        if (Result.m130isFailureimpl(r20) == true) goto L22;
        r5 = r20;
    L22:
        return (MiniAppWidgetDataSnapshot) r5;
    L10:
        r19 = null;
    L8:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final List<MiniAppWidgetInfo> queryWidgets(Context r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Object r11 = null;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L8
        Bundle r13 = new Bundle();     // Catch: Throwable -> L8
        r13.putString("appletId", r10);     // Catch: Throwable -> L8
        Bundle r14 = callProviderBundle(r5, METHOD_QUERY_WIDGETS, r13);     // Catch: Throwable -> L8
        if (r14 == null) goto L10;
        String r15 = r14.getString(METHOD_QUERY_WIDGETS);     // Catch: Throwable -> L8
        if (r15 == null) goto L10;
        List r16 = (List) gson.fromJson(r15, TypeToken.getParameterized(List.class, new Type[]{MiniAppWidgetInfo.class}).getType());     // Catch: Throwable -> L8
    L11:
        Object r17 = Result.m124constructorimpl(r16);     // Catch: Throwable -> L8
    L14:
        Throwable r18 = Result.m127exceptionOrNullimpl(r17);
        if (r18 == null) goto L18;
        r18.printStackTrace();
    L18:
        if (Result.m130isFailureimpl(r17) == true) goto L21;
        r11 = r17;
    L21:
        List<MiniAppWidgetInfo> r19 = (List) r11;
        if (r19 == null) goto L24;
        return r19;
    L24:
        return CollectionsKt.emptyList();
    L10:
        r16 = null;
    L8:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final RefreshAffectedResult refreshAffectedByUpdate(Context r10, String r11, List<String> r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "changedDomains");
        Intrinsics.checkNotNullParameter(r14, "hostId");
        Object r5 = null;
        if (StringsKt.isBlank(r11) == false) goto L5;
    L31:
        Log.w(TAG, "refreshAffectedByUpdate skipped: appletId=" + r11 + ", changedDomains=" + r12);
        return null;
    L5:
        if (r12.isEmpty() == true) goto L31;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L10
        Bundle r16 = new Bundle();     // Catch: Throwable -> L10
        r16.putString("appletId", r11);     // Catch: Throwable -> L10
        r16.putStringArrayList("changedDomains", new ArrayList(r12));     // Catch: Throwable -> L10
        r16.putString("hostId", r14);     // Catch: Throwable -> L10
        if (r13 == null) goto L12;
        r16.putString("reason", r13);     // Catch: Throwable -> L10
    L12:
        Bundle r17 = callProviderBundle(r10, "refreshAffectedByUpdate", r16);     // Catch: Throwable -> L10
        if (r17 == null) goto L18;
        int r18 = r17.getInt("refreshAffectedByUpdate", 0);     // Catch: Throwable -> L10
        List r19 = r17.getStringArrayList("updatedWidgetIds");     // Catch: Throwable -> L10
        if (r19 != null) goto L17;
        r19 = CollectionsKt.emptyList();     // Catch: Throwable -> L10
    L17:
        RefreshAffectedResult r20 = new RefreshAffectedResult(r18, r19);     // Catch: Throwable -> L10
    L19:
        Object r21 = Result.m124constructorimpl(r20);     // Catch: Throwable -> L10
    L22:
        Throwable r22 = Result.m127exceptionOrNullimpl(r21);
        if (r22 == null) goto L26;
        r22.printStackTrace();
    L26:
        if (Result.m130isFailureimpl(r21) == true) goto L30;
        r5 = r21;
    L30:
        return (RefreshAffectedResult) r5;
    L18:
        r20 = null;
    L10:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public final boolean registerWidgetMessenger(Context r10, String r11, String r12, int r13, Messenger r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        Intrinsics.checkNotNullParameter(r14, "messenger");
        Intrinsics.checkNotNullParameter(r15, "hostId");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L6
        Bundle r16 = new Bundle();     // Catch: Throwable -> L6
        r16.putString("appletId", r11);     // Catch: Throwable -> L6
        r16.putString("widgetId", r12);     // Catch: Throwable -> L6
        r16.putInt("instanceId", r13);     // Catch: Throwable -> L6
        r16.putString("hostId", r15);     // Catch: Throwable -> L6
        r16.putParcelable("messenger", r14);     // Catch: Throwable -> L6
        Bundle r17 = callProviderBundle(r10, "registerWidgetMessenger", r16);     // Catch: Throwable -> L6
        boolean r18 = false;
        if (r17 == null) goto L8;
        r18 = r17.getBoolean("registerWidgetMessenger", false);     // Catch: Throwable -> L6
    L8:
        Object r19 = Result.m124constructorimpl(Boolean.valueOf(r18));     // Catch: Throwable -> L6
    L11:
        Throwable r20 = Result.m127exceptionOrNullimpl(r19);
        if (r20 == null) goto L14;
        r20.printStackTrace();
    L14:
        Boolean r21 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r19) == false) goto L18;
        r19 = r21;
    L18:
        return ((Boolean) r19).booleanValue();
    L6:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final String sendPayload(Context r10, String r11, String r12, int r13, String r14, boolean r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        Intrinsics.checkNotNullParameter(r16, "hostId");
        Bundle r5 = new Bundle();
        r5.putString("appletId", r11);
        r5.putString("widgetId", r12);
        r5.putInt("instanceId", r13);
        r5.putString("hostId", r16);
        r5.putString("payload", r14);
        if (r15 == false) goto L5;
        r5.putBoolean("waitForResult", true);
    L5:
        Object r17 = null;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L9
        Bundle r19 = callProviderBundle(r10, "sendPayload", r5);     // Catch: Throwable -> L9
        if (r19 == null) goto L11;
        String r20 = r19.getString("sendPayload");     // Catch: Throwable -> L9
    L12:
        Log.i(TAG, String.valueOf(r19));     // Catch: Throwable -> L9
        Object r21 = Result.m124constructorimpl(r20);     // Catch: Throwable -> L9
    L15:
        Throwable r22 = Result.m127exceptionOrNullimpl(r21);
        if (r22 == null) goto L19;
        r22.printStackTrace();
    L19:
        if (Result.m130isFailureimpl(r21) == true) goto L23;
        r17 = r21;
    L23:
        return (String) r17;
    L11:
        r20 = null;
    L9:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final boolean unregisterWidgetMessenger(Context r5, int r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r13, "hostId");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L6
        Bundle r15 = new Bundle();     // Catch: Throwable -> L6
        r15.putInt("instanceId", r10);     // Catch: Throwable -> L6
        if (r11 == null) goto L8;
        r15.putString("appletId", r11);     // Catch: Throwable -> L6
    L8:
        if (r12 == null) goto L10;
        r15.putString("widgetId", r12);     // Catch: Throwable -> L6
    L10:
        r15.putString("hostId", r13);     // Catch: Throwable -> L6
        Bundle r16 = callProviderBundle(r5, "unregisterWidgetMessenger", r15);     // Catch: Throwable -> L6
        boolean r17 = false;
        if (r16 == null) goto L13;
        r17 = r16.getBoolean("unregisterWidgetMessenger", false);     // Catch: Throwable -> L6
    L13:
        Object r18 = Result.m124constructorimpl(Boolean.valueOf(r17));     // Catch: Throwable -> L6
    L16:
        Throwable r19 = Result.m127exceptionOrNullimpl(r18);
        if (r19 == null) goto L19;
        r19.printStackTrace();
    L19:
        Boolean r20 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r18) == false) goto L23;
        r18 = r20;
    L23:
        return ((Boolean) r18).booleanValue();
    L6:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final String updateWidget(Context r10, String r11, String r12, int r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        Intrinsics.checkNotNullParameter(r15, "hostId");
        Object r5 = null;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L6
        Bundle r17 = new Bundle();     // Catch: Throwable -> L6
        r17.putString("appletId", r11);     // Catch: Throwable -> L6
        r17.putString("widgetId", r12);     // Catch: Throwable -> L6
        r17.putInt("instanceId", r13);     // Catch: Throwable -> L6
        r17.putString("hostId", r15);     // Catch: Throwable -> L6
        if (r14 == null) goto L8;
        r17.putString("reason", r14);     // Catch: Throwable -> L6
    L8:
        Bundle r18 = callProviderBundle(r10, "updateWidget", r17);     // Catch: Throwable -> L6
        if (r18 == null) goto L11;
        String r19 = r18.getString("updateWidget");     // Catch: Throwable -> L6
    L12:
        Object r20 = Result.m124constructorimpl(r19);     // Catch: Throwable -> L6
    L15:
        Throwable r21 = Result.m127exceptionOrNullimpl(r20);
        if (r21 == null) goto L19;
        r21.printStackTrace();
    L19:
        if (Result.m130isFailureimpl(r20) == true) goto L23;
        r5 = r20;
    L23:
        return (String) r5;
    L11:
        r19 = null;
    L6:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final MiniAppWidgetDataSnapshot updateWidgetData(Context r13, String r14, String r15, int r16, String r17, String r18, Integer r19, Long r20, Long r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "appletId");
        Intrinsics.checkNotNullParameter(r15, "widgetId");
        Intrinsics.checkNotNullParameter(r18, "hostId");
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        Bundle r12 = new Bundle();     // Catch: Throwable -> L6
        r12.putString("appletId", r14);     // Catch: Throwable -> L6
        r12.putString("widgetId", r15);     // Catch: Throwable -> L6
        r12.putInt("instanceId", r16);     // Catch: Throwable -> L6
        r12.putString("hostId", r18);     // Catch: Throwable -> L6
        r12.putString("widgetData", r17);     // Catch: Throwable -> L6
        if (r19 == null) goto L8;
        r12.putInt("schemaVersion", r19.intValue());     // Catch: Throwable -> L6
    L8:
        if (r20 == null) goto L10;
        r12.putLong("dataVersion", r20.longValue());     // Catch: Throwable -> L6
    L10:
        if (r21 == null) goto L12;
        r12.putLong("updatedAt", r21.longValue());     // Catch: Throwable -> L6
    L12:
        if (r22 == null) goto L14;
        r12.putString("state", r22);     // Catch: Throwable -> L6
    L14:
        if (r23 == null) goto L16;
        r12.putString("reason", r23);     // Catch: Throwable -> L6
    L16:
        Bundle r5 = callProviderBundle(r13, METHOD_UPDATE_WIDGET_DATA, r12);     // Catch: Throwable -> L6
        if (r5 == null) goto L21;
        String r24 = r5.getString(METHOD_UPDATE_WIDGET_DATA);     // Catch: Throwable -> L6
        if (r24 == null) goto L21;
        MiniAppWidgetDataSnapshot r25 = (MiniAppWidgetDataSnapshot) gson.fromJson(r24, MiniAppWidgetDataSnapshot.class);     // Catch: Throwable -> L6
    L22:
        Object r26 = Result.m124constructorimpl(r25);     // Catch: Throwable -> L6
    L25:
        Throwable r27 = Result.m127exceptionOrNullimpl(r26);
        if (r27 == null) goto L29;
        r27.printStackTrace();
    L29:
        if (Result.m130isFailureimpl(r26) == true) goto L33;
        r10 = r26;
    L33:
        return (MiniAppWidgetDataSnapshot) r10;
    L21:
        r25 = null;
    L6:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r26 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L25
    }
}
