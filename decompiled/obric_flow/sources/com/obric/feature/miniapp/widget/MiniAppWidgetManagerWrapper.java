package com.obric.feature.miniapp.widget;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import androidx.core.os.BundleKt;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.ex.widget.WidgetRenderService;
import com.bytedance.ai.ex.widget.WidgetSDK;
import com.bytedance.ai.ex.widget.WidgetView;
import com.bytedance.ai.ex.widget.model.MiniAppInfo;
import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;
import com.bytedance.ai.ex.widget.model.MiniAppWidgetDataSnapshot;
import com.bytedance.ai.ex.widget.model.MiniAppWidgetInfo;
import com.bytedance.ai.ex.widget.rpc.MiniAppWidgetManagerRemote;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.model.p;
import com.bytedance.ai.widget.models.OAppletWrap;
import com.google.common.reflect.w;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import ii.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.d;
import kotlinx.coroutines.sync.e;
import kotlinx.coroutines.z;
import oo.l;
import t0.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u0014\u0010\u0010J\"\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u001f\u0010 J\"\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0086@¢\u0006\u0004\b\u001f\u0010#J,\u0010(\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000e2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%H\u0086@¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J#\u0010.\u001a\u0004\u0018\u00010\u000b2\u0006\u0010$\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0004\b,\u0010-J+\u0010.\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0004\b,\u0010/J\u001f\u00104\u001a\u0002012\u0006\u00100\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b2\u00103J\u001f\u00107\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b5\u00106JE\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0:2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020%2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0004\b;\u0010<J)\u0010@\u001a\u00020\u001e2\b\u0010>\u001a\u0004\u0018\u00010'2\u0006\u0010$\u001a\u00020\u000e2\b\u0010?\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b@\u0010AJ\u001f\u0010C\u001a\u00020\u001e2\b\u0010>\u001a\u0004\u0018\u00010'2\u0006\u0010B\u001a\u00020\u001e¢\u0006\u0004\bC\u0010DJ\u001f\u0010F\u001a\u00020\u001e2\b\u0010>\u001a\u0004\u0018\u00010'2\u0006\u0010E\u001a\u00020\u001e¢\u0006\u0004\bF\u0010DJ\u0017\u0010G\u001a\u00020\u001e2\b\u0010>\u001a\u0004\u0018\u00010'¢\u0006\u0004\bG\u0010HJ'\u0010L\u001a\u00020\u001e2\b\u0010>\u001a\u0004\u0018\u00010'2\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020J¢\u0006\u0004\bL\u0010MJ/\u0010O\u001a\u0004\u0018\u00010N2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\bO\u0010PJ5\u0010Q\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bQ\u0010RJ-\u0010S\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\bS\u0010TJ-\u0010U\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\bU\u0010TJ5\u0010X\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%2\u0006\u0010W\u001a\u00020V¢\u0006\u0004\bX\u0010YJ5\u0010Z\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bZ\u0010RJE\u0010\\\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\\\u0010]J9\u0010^\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%2\b\b\u0002\u0010[\u001a\u00020\u000b¢\u0006\u0004\b^\u0010_J9\u0010b\u001a\u0004\u0018\u00010a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bb\u0010cJA\u0010f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%2\u0006\u0010d\u001a\u00020\u000b2\b\b\u0002\u0010e\u001a\u00020\u001e¢\u0006\u0004\bf\u0010gR\u0014\u0010h\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010j\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bj\u0010iR\u0014\u0010k\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bk\u0010iR\u0014\u0010l\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bl\u0010iR\u0014\u0010m\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bm\u0010iR\u0014\u0010n\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bn\u0010iR\u0014\u0010o\u001a\u00020%8\u0006X\u0086T¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010q\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bq\u0010iR\u0014\u0010r\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\br\u0010iR\u0014\u0010s\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bs\u0010iR\u0014\u0010t\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bt\u0010iR\u0014\u0010u\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bu\u0010iR\u0014\u0010v\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bv\u0010iR\u0014\u0010w\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bw\u0010i¨\u0006x"}, d2 = {"Lcom/obric/feature/miniapp/widget/MiniAppWidgetManagerWrapper;", "", "Landroid/content/Context;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "init", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;)V", "refreshMiniAppWidgetsSync", "(Landroid/content/Context;)V", "", "appletId", "", "Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetInfo;", "getMiniAppWidgets", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppletIds", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/bytedance/ai/ex/widget/model/MiniAppInfo;", "getAppletInfo", "widgetId", "getWidgetInfo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "preferredVersion", "scene", "Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetAvailability;", "ensureWidgetAvailable", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetAvailability;", "", "openMiniApp", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/os/Bundle;", "args", "(Landroid/content/Context;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "miniAppWidgetInfo", "", "instanceId", "Landroid/view/View;", "createWidget", "(Landroid/content/Context;Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetInfo;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOWidgetRenderContext", "(Landroid/content/Context;)Landroid/content/Context;", "buildStableMessageId$widget_sdk_4l_release", "(Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetInfo;Ljava/lang/Integer;)Ljava/lang/String;", "buildStableMessageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "hostId", "Lcom/bytedance/ai/widget/models/OAppletWrap;", "buildOWidgetAppletWrap$widget_sdk_4l_release", "(Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ai/widget/models/OAppletWrap;", "buildOWidgetAppletWrap", "buildOWidgetLynxGroupName$widget_sdk_4l_release", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "buildOWidgetLynxGroupName", "appTheme", "targetDensityDpi", "", "buildOWidgetViewContext$widget_sdk_4l_release", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/Map;", "buildOWidgetViewContext", "widgetView", "widgetData", "updateWidgetView", "(Landroid/view/View;Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetInfo;Ljava/lang/String;)Z", "isNightMode", "dispatchWidgetThemeChanged", "(Landroid/view/View;Z)Z", "isVisible", "dispatchWidgetVisibilityChanged", "destroyWidgetHost", "(Landroid/view/View;)Z", "eventName", "Lcom/google/gson/JsonObject;", LynxResourceModule.PARAMS_KEY, "sendEventToWidget", "(Landroid/view/View;Ljava/lang/String;Lcom/google/gson/JsonObject;)Z", "Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetDataSnapshot;", "queryWidgetData", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Lcom/bytedance/ai/ex/widget/model/MiniAppWidgetDataSnapshot;", "clearWidgetData", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)Z", "dispatchWidgetBind", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V", "dispatchWidgetUnbind", "Landroid/os/Messenger;", "messenger", "registerWidgetMessenger", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILandroid/os/Messenger;)Z", "unregisterWidgetMessenger", "reason", "notifyWidgetDataChanged", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z", "updateWidget", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;", "changedDomains", "Lcom/bytedance/ai/ex/widget/rpc/MiniAppWidgetManagerRemote$RefreshAffectedResult;", "refreshAffectedByUpdate", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/bytedance/ai/ex/widget/rpc/MiniAppWidgetManagerRemote$RefreshAffectedResult;", "payload", "waitForResult", "sendPayload", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)Ljava/lang/String;", "APPLET_PACKAGE_NAME", "Ljava/lang/String;", "ARG_APPLET_ID", "ARG_WIDGET_ID", "ARG_INSTANCE_ID", "ARG_WIDGET_DATA", "ARG_REASON", "MSG_WHAT_UPDATE_WIDGET_DATA", "I", "REFRESH_REASON_ON_ADD", "REFRESH_REASON_ON_RESTORE", "REFRESH_REASON_EVENT", "REFRESH_REASON_VISIBILITY_GAIN", "REFRESH_REASON_MANUAL", "REFRESH_REASON_PERIODIC", "REFRESH_REASON_PACKAGE_UPDATE", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMiniAppWidgetManagerWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiniAppWidgetManagerWrapper.kt\ncom/obric/feature/miniapp/widget/MiniAppWidgetManagerWrapper\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Uri.kt\nandroidx/core/net/UriKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,744:1\n116#2,8:745\n125#2,2:757\n116#2,8:759\n125#2,2:773\n116#2,11:775\n116#2,11:786\n116#2,11:798\n1557#3:753\n1628#3,3:754\n1368#3:767\n1454#3,5:768\n1557#3:812\n1628#3,3:813\n1#4:797\n29#5:809\n29#5:810\n29#5:811\n13933#6,14:816\n*S KotlinDebug\n*F\n+ 1 MiniAppWidgetManagerWrapper.kt\ncom/obric/feature/miniapp/widget/MiniAppWidgetManagerWrapper\n*L\n114#1:745,8\n114#1:757,2\n129#1:759,8\n129#1:773,2\n140#1:775,11\n147#1:786,11\n196#1:798,11\n119#1:753\n119#1:754,3\n133#1:767\n133#1:768,5\n310#1:812\n310#1:813,3\n206#1:809\n245#1:810\n308#1:811\n509#1:816,14\n*E\n"})
public final class MiniAppWidgetManagerWrapper {
    public static final String APPLET_PACKAGE_NAME = "com.obric.appletapp";
    public static final String ARG_APPLET_ID = "appletId";
    public static final String ARG_INSTANCE_ID = "instanceId";
    public static final String ARG_REASON = "reason";
    public static final String ARG_WIDGET_DATA = "widgetData";
    public static final String ARG_WIDGET_ID = "widgetId";
    public static final MiniAppWidgetManagerWrapper INSTANCE = null;
    public static final int MSG_WHAT_UPDATE_WIDGET_DATA = 0;
    public static final String REFRESH_REASON_EVENT = "event";
    public static final String REFRESH_REASON_MANUAL = "manual";
    public static final String REFRESH_REASON_ON_ADD = "onAdd";
    public static final String REFRESH_REASON_ON_RESTORE = "onRestore";
    public static final String REFRESH_REASON_PACKAGE_UPDATE = "packageUpdate";
    public static final String REFRESH_REASON_PERIODIC = "periodic";
    public static final String REFRESH_REASON_VISIBILITY_GAIN = "visibilityGain";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Job f11389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.sync.a f11390b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f11391c = null;

    /* JADX INFO: renamed from: com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper$createWidget$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper", f = "MiniAppWidgetManagerWrapper.kt", i = {0, 0, 0, 0, 1}, l = {368, 396}, m = "createWidget", n = {"this", "context", "miniAppWidgetInfo", "instanceId", "appTheme"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Context f11393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public MiniAppWidgetInfo f11394c;
        public Integer d;
        public /* synthetic */ Object e;
        public final /* synthetic */ MiniAppWidgetManagerWrapper f;
        public int g;

        public AnonymousClass1(MiniAppWidgetManagerWrapper r5, Continuation r10) {
            this.f = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.e = r5;
            this.g |= Integer.MIN_VALUE;
            return this.f.createWidget(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper$getAppletIds$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper", f = "MiniAppWidgetManagerWrapper.kt", i = {1}, l = {139, 750}, m = "getAppletIds", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    public static final class C01771 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public kotlinx.coroutines.sync.a f11398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f11399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MiniAppWidgetManagerWrapper f11400c;
        public int d;

        public C01771(MiniAppWidgetManagerWrapper r5, Continuation r10) {
            this.f11400c = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.f11399b = r5;
            this.d |= Integer.MIN_VALUE;
            return this.f11400c.getAppletIds(this);
        }
    }

    /* JADX INFO: renamed from: com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper$getAppletInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper", f = "MiniAppWidgetManagerWrapper.kt", i = {0, 1, 1}, l = {146, 750}, m = "getAppletInfo", n = {"appletId", "appletId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$1"})
    public static final class C01781 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public kotlinx.coroutines.sync.a f11402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f11403c;
        public final /* synthetic */ MiniAppWidgetManagerWrapper d;
        public int e;

        public C01781(MiniAppWidgetManagerWrapper r5, Continuation r10) {
            this.d = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.f11403c = r5;
            this.e |= Integer.MIN_VALUE;
            return this.d.getAppletInfo(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper$getMiniAppWidgets$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper", f = "MiniAppWidgetManagerWrapper.kt", i = {0, 1, 1}, l = {128, 750}, m = "getMiniAppWidgets", n = {"appletId", "appletId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$1"})
    public static final class C01791 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public kotlinx.coroutines.sync.a f11405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f11406c;
        public final /* synthetic */ MiniAppWidgetManagerWrapper d;
        public int e;

        public C01791(MiniAppWidgetManagerWrapper r5, Continuation r10) {
            this.d = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.f11406c = r5;
            this.e |= Integer.MIN_VALUE;
            return this.d.getMiniAppWidgets(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper$getWidgetInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper", f = "MiniAppWidgetManagerWrapper.kt", i = {0}, l = {153}, m = "getWidgetInfo", n = {"widgetId"}, s = {"L$0"})
    public static final class C01801 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f11408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MiniAppWidgetManagerWrapper f11409c;
        public int d;

        public C01801(MiniAppWidgetManagerWrapper r5, Continuation r10) {
            this.f11409c = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.f11408b = r5;
            this.d |= Integer.MIN_VALUE;
            return this.f11409c.getWidgetInfo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper$init$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper$init$1", f = "MiniAppWidgetManagerWrapper.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f11411b;

        public C01811(Context r5, Continuation r10) {
            this.f11411b = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new C01811(this.f11411b, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.f11410a;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MiniAppWidgetManagerWrapper r12 = MiniAppWidgetManagerWrapper.INSTANCE;
            Context r13 = this.f11411b;
            this.f11410a = 1;
            if (MiniAppWidgetManagerWrapper.access$refreshMiniAppWidgets(r12, r13, this) != r10) goto L12;
            return r10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((C01811) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper$openMiniApp$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper", f = "MiniAppWidgetManagerWrapper.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {195, 750}, m = "openMiniApp", n = {"context", "normalizedArgs", "appletId", "context", "normalizedArgs", "appletId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    public static final class AnonymousClass2 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f11415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bundle f11416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11417c;
        public kotlinx.coroutines.sync.a d;
        public /* synthetic */ Object e;
        public final /* synthetic */ MiniAppWidgetManagerWrapper f;
        public int g;

        public AnonymousClass2(MiniAppWidgetManagerWrapper r5, Continuation r10) {
            this.f = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.e = r5;
            this.g |= Integer.MIN_VALUE;
            return this.f.openMiniApp(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper$refreshMiniAppWidgetsSync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper$refreshMiniAppWidgetsSync$1", f = "MiniAppWidgetManagerWrapper.kt", i = {}, l = {104, 106}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f11422b;

        public C01821(Context r5, Continuation r10) {
            this.f11422b = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new C01821(this.f11422b, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.f11421a;
            if (r11 == 0) goto L10;
            if (r11 == 1) goto L9;
            if (r11 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L22:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r5);
            Job r12 = MiniAppWidgetManagerWrapper.access$getInitJob$p();
            if (r12 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("initJob");
            r12 = null;
        L14:
            if (r12.isCompleted() == false) goto L18;
            MiniAppWidgetManagerWrapper r13 = MiniAppWidgetManagerWrapper.INSTANCE;
            Context r14 = this.f11422b;
            this.f11421a = 1;
            if (MiniAppWidgetManagerWrapper.access$refreshMiniAppWidgets(r13, r14, this) != r10) goto L22;
        L20:
            return r10;
        L18:
            MiniAppWidgetManagerWrapper r15 = MiniAppWidgetManagerWrapper.INSTANCE;
            this.f11421a = 2;
            if (MiniAppWidgetManagerWrapper.access$awaitInit(r15, this) != r10) goto L22;
            goto L20
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((C01821) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        INSTANCE = new MiniAppWidgetManagerWrapper();
        f11390b = e.a();
        f11391c = new LinkedHashMap();
    }

    public MiniAppWidgetManagerWrapper() {
    }

    public static Object a(Continuation r5) {
        Job r10 = f11389a;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("initJob");
        r10 = null;
    L5:
        Object r11 = r10.join(r5);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r11;
    L9:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$awaitInit(MiniAppWidgetManagerWrapper r5, Continuation r10) {
        r5.getClass();
        return a(r10);
    }

    public static final /* synthetic */ Job access$getInitJob$p() {
        return f11389a;
    }

    public static final /* synthetic */ Map access$getMiniAppInfosMap$p() {
        return f11391c;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getMutex$p() {
        return f11390b;
    }

    public static final /* synthetic */ Object access$refreshMiniAppWidgets(MiniAppWidgetManagerWrapper r5, Context r10, Continuation r11) {
        return r5.a(r10, r11);
    }

    public static int b(Context r5) {
        Integer r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L9
        INSTANCE.getClass();     // Catch: Throwable -> L9
        int r12 = (int) (a(r5) * DisplayMetrics.DENSITY_DEVICE_STABLE);     // Catch: Throwable -> L9
        Integer r13 = Integer.valueOf(r12);     // Catch: Throwable -> L9
        if (r12 > 0) goto L7;
        r13 = null;
    L7:
        Object r14 = Result.m124constructorimpl(r13);     // Catch: Throwable -> L9
    L11:
        Throwable r15 = Result.m127exceptionOrNullimpl(r14);
        if (r15 == null) goto L15;
        Log.w("MiniAppWidgetProvider", "resolveOWidgetTargetDensityDpi failed", r15);
    L15:
        if (Result.m130isFailureimpl(r14) == false) goto L17;
        r14 = null;
    L17:
        Integer r16 = (Integer) r14;
        if (r16 != null) goto L35;
        int r17 = r5.getResources().getConfiguration().densityDpi;
        Integer r18 = Integer.valueOf(r17);
        if (r17 <= 0) goto L23;
        r16 = r18;
    L24:
        if (r16 != null) goto L35;
        int r19 = r5.getResources().getDisplayMetrics().densityDpi;
        Integer r20 = Integer.valueOf(r19);
        if (r19 <= 0) goto L29;
        r10 = r20;
    L29:
        if (r10 != null) goto L36;
        return 160;
    L36:
        return r10.intValue();
    L23:
        r16 = null;
    L35:
        return r16.intValue();
    L9:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static /* synthetic */ boolean clearWidgetData$default(MiniAppWidgetManagerWrapper r5, Context r10, int r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = null;
    L9:
        return r5.clearWidgetData(r10, r11, r12, r13);
    }

    public static /* synthetic */ Object createWidget$default(MiniAppWidgetManagerWrapper r5, Context r10, MiniAppWidgetInfo r11, Integer r12, Continuation r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = null;
    L6:
        return r5.createWidget(r10, r11, r12, r13);
    }

    public static /* synthetic */ MiniAppWidgetAvailability ensureWidgetAvailable$default(MiniAppWidgetManagerWrapper r10, Context r11, String r12, String r13, Long r14, String r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        r14 = null;
    L5:
        Long r5 = r14;
        if ((r16 & 16) == 0) goto L9;
        r15 = "manual";
    L9:
        return r10.ensureWidgetAvailable(r11, r12, r13, r5, r15);
    }

    public static /* synthetic */ boolean notifyWidgetDataChanged$default(MiniAppWidgetManagerWrapper r10, Context r11, String r12, String r13, int r14, String r15, String r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        String r19 = null;
    L7:
        if ((r17 & 32) == 0) goto L9;
        String r20 = null;
    L11:
        return r10.notifyWidgetDataChanged(r11, r12, r13, r14, r19, r20);
    L9:
        r20 = r16;
        goto L11
    L5:
        r19 = r15;
        goto L7
    }

    public static /* synthetic */ MiniAppWidgetManagerRemote.RefreshAffectedResult refreshAffectedByUpdate$default(MiniAppWidgetManagerWrapper r5, Context r10, String r11, List r12, String r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = null;
    L6:
        return r5.refreshAffectedByUpdate(r10, r11, r12, r13);
    }

    public static /* synthetic */ String sendPayload$default(MiniAppWidgetManagerWrapper r10, Context r11, String r12, String r13, int r14, String r15, boolean r16, int r17, Object r18) {
        if ((r17 & 32) == 0) goto L6;
        r16 = false;
    L6:
        return r10.sendPayload(r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ boolean unregisterWidgetMessenger$default(MiniAppWidgetManagerWrapper r5, Context r10, int r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = null;
    L9:
        return r5.unregisterWidgetMessenger(r10, r11, r12, r13);
    }

    public static /* synthetic */ String updateWidget$default(MiniAppWidgetManagerWrapper r10, Context r11, String r12, String r13, int r14, String r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = "manual";
    L6:
        return r10.updateWidget(r11, r12, r13, r14, r15);
    }

    public final OAppletWrap buildOWidgetAppletWrap$widget_sdk_4l_release(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        Intrinsics.checkNotNullParameter(r10, "appletId");
        return new OAppletWrap(buildOWidgetLynxGroupName$widget_sdk_4l_release(r5, r10), false);
    }

    public final String buildOWidgetLynxGroupName$widget_sdk_4l_release(String r5, String r10) {
        return androidx.constraintlayout.motion.widget.a.t(androidx.constraintlayout.motion.widget.a.D(r5, "hostId", r10, "appletId", "owidget:"), r5, ":", r10);
    }

    public final Map<String, String> buildOWidgetViewContext$widget_sdk_4l_release(String r10, int r11, String r12, String r13, Integer r14) {
        Intrinsics.checkNotNullParameter(r10, "appTheme");
        Intrinsics.checkNotNullParameter(r12, "appletId");
        Intrinsics.checkNotNullParameter(r13, "widgetId");
        Map r5 = MapsKt.createMapBuilder();
        r5.put("hostId", "launcher");
        r5.put("appletId", r12);
        r5.put("widgetId", r13);
        r5.put("renderScene", "owidget");
        r5.put("appTheme", r10);
        INSTANCE.getClass();
        r5.put(WidgetView.DENSITY, String.valueOf(r11 / 160.0f));
        r5.put("fontScale", String.valueOf(1.0f));
        r5.put("rawHostId", "launcher");
        r5.put("rawAppletId", r12);
        r5.put("rawWidgetId", r13);
        if (r14 == null) goto L8;
        String r15 = r14.toString();
        if (r15 == null) goto L8;
        r5.put("instanceId", r15);
        r5.put("rawInstanceId", r15);
    L8:
        return MapsKt.build(r5);
    }

    public final String buildStableMessageId$widget_sdk_4l_release(MiniAppWidgetInfo r5, Integer r10) {
        Intrinsics.checkNotNullParameter(r5, "miniAppWidgetInfo");
        return buildStableMessageId$widget_sdk_4l_release(r5.getAppletId(), r5.getWidgetId(), r10);
    }

    public final boolean clearWidgetData(Context r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return MiniAppWidgetManagerRemote.INSTANCE.clearWidgetData(r10, r11, r12, r13, "launcher");
    }

    public final Context createOWidgetRenderContext(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = b(r5);
        Configuration r11 = new Configuration(r5.getResources().getConfiguration());
        r11.densityDpi = r10;
        r11.fontScale = 1.0f;
        return r5.createConfigurationContext(r11);
    }

    public final Object createWidget(Context r35, MiniAppWidgetInfo r36, Integer r37, Continuation<? super View> r38) {
        MiniAppWidgetManagerWrapper r5 = this;
        Context r10 = r35;
        MiniAppWidgetInfo r11 = r36;
        Integer r12 = r37;
        if ((r38 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r13 = (AnonymousClass1) r38;
        int r14 = r13.g;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.g = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.e;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.g;
        if (r17 == 0) goto L16;
        if (r17 == 1) goto L15;
        if (r17 != 2) goto L14;
        String r18 = (String) r13.f11392a;
        ResultKt.throwOnFailure(r15);
        WidgetView r19 = null;
    L40:
        WidgetView r110 = (WidgetView) r15;
        if (r110 == null) goto L43;
        r19 = r110;
    L43:
        if (r19 == null) goto L45;
        Boxing.boxBoolean(r19.post(new a(r19, r18, 0)));
    L45:
        return r110;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Integer r20 = r13.d;
        MiniAppWidgetInfo r21 = r13.f11394c;
        Context r22 = r13.f11393b;
        MiniAppWidgetManagerWrapper r23 = (MiniAppWidgetManagerWrapper) r13.f11392a;
        ResultKt.throwOnFailure(r15);
        r12 = r20;
        r5 = r23;
        r11 = r21;
        r10 = r22;
    L21:
        MiniAppWidgetDataSnapshot r24 = (MiniAppWidgetDataSnapshot) r15;
    L23:
        String r25 = r5.buildStableMessageId$widget_sdk_4l_release(r11, r12);
        int r111 = b(r10);
        Configuration r26 = new Configuration(r10.getResources().getConfiguration());
        r26.densityDpi = r111;
        r26.fontScale = 1.0f;
        Context r27 = r10.createConfigurationContext(r26);
        if ((r27.getResources().getConfiguration().uiMode & 48) != 32) goto L27;
        String r28 = WidgetView.UI_MODE_DARK;
    L26:
        String r112 = r28;
        Map<String, String> r113 = r5.buildOWidgetViewContext$widget_sdk_4l_release(r112, r111, r11.getAppletId(), r11.getWidgetId(), r12);
        OAppletWrap r29 = r5.buildOWidgetAppletWrap$widget_sdk_4l_release("launcher", r11.getAppletId());
        String r30 = r11.getAppletId();
        String r31 = r11.getWidgetId();
        String r114 = r29.getGroupName();
        StringBuilder r32 = androidx.constraintlayout.motion.widget.a.y("createWidget appletId=", r30, ", widgetId=", r31, ", instanceId=");
        r32.append(r12);
        r32.append(", messageId=");
        r32.append(r25);
        r32.append(", targetDensityDpi=");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r32, r111, ", lynxGroup=", r114, ", viewContext=");
        r32.append(r113);
        Log.d("MiniAppWidgetProvider", r32.toString());
        WidgetSDK r33 = WidgetSDK.INSTANCE;
        String r115 = r11.getAppletId();
        String r210 = r11.getWidgetId();
        if (r24 == null) goto L35;
        String r34 = r24.getWidgetData();
        if (r34 == null) goto L35;
        if (StringsKt.isBlank(r34) == true) goto L35;
        String r211 = r34;
    L36:
        WidgetInfo r39 = new WidgetInfo(r115, r210, r211, null, null, null, null, null, null, null, null, 2040, null);
        Map r116 = MapsKt.mapOf(TuplesKt.to(WidgetView.ENV_DESTROY_ON_DETACH, Boxing.boxBoolean(false)));
        r13.f11392a = r112;
        r13.f11393b = null;
        r13.f11394c = null;
        r13.d = null;
        r13.g = 2;
        r19 = null;
        r15 = WidgetSDK.createWidget$default(r33, r39, r27, null, r25, r116, r113, null, null, r29, r13, 192, null);
        if (r15 == r16) goto L46;
        r18 = r112;
        goto L40
    L46:
        return r16;
    L35:
        r211 = null;
        goto L36
    L27:
        r28 = WidgetView.UI_MODE_LIGHT;
        goto L26
    L16:
        ResultKt.throwOnFailure(r15);
        if (r12 == null) goto L22;
        int r40 = r37.intValue();
        z r41 = Dispatchers.getIO();
        MiniAppWidgetManagerWrapper$createWidget$snapshot$1$1 r42 = new MiniAppWidgetManagerWrapper$createWidget$snapshot$1$1(r10, r11, r40, null);
        r13.f11392a = r5;
        r13.f11393b = r10;
        r13.f11394c = r11;
        r13.d = r12;
        r13.g = 1;
        r15 = BuildersKt.withContext(r41, r42, r13);
        if (r15 != r16) goto L21;
        return r16;
    L22:
        r24 = null;
    L7:
        r13 = new AnonymousClass1(r5, r38);
        goto L8
    }

    public final boolean destroyWidgetHost(View r5) {
        if ((r5 instanceof WidgetView) == false) goto L5;
        WidgetView r10 = (WidgetView) r5;
    L6:
        if (r10 != null) goto L9;
        return false;
    L9:
        r10.destroyHost();
        return true;
    L5:
        r10 = null;
        goto L6
    }

    public final void dispatchWidgetBind(Context r10, String r11, String r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        MiniAppWidgetManagerRemote.dispatchWidgetBind$default(MiniAppWidgetManagerRemote.INSTANCE, r10, r11, r12, r13, null, "launcher", 16, null);
    }

    public final boolean dispatchWidgetThemeChanged(View r5, boolean r10) {
        if ((r5 instanceof WidgetView) == false) goto L5;
        WidgetView r11 = (WidgetView) r5;
    L6:
        if (r11 != null) goto L9;
        return false;
    L9:
        WidgetSDK.INSTANCE.notifyWidgetThemeChanged(r11, r10);
        return true;
    L5:
        r11 = null;
        goto L6
    }

    public final void dispatchWidgetUnbind(Context r10, String r11, String r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        MiniAppWidgetManagerRemote.INSTANCE.dispatchWidgetUnbind(r10, r11, r12, r13, "launcher");
    }

    public final boolean dispatchWidgetVisibilityChanged(View r5, boolean r10) {
        if ((r5 instanceof WidgetView) == false) goto L5;
        WidgetView r11 = (WidgetView) r5;
    L6:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r10 == false) goto L11;
        WidgetRenderService.INSTANCE.onHostShow(r11);
        return true;
    L11:
        WidgetRenderService.INSTANCE.onHostHide(r11);
        return true;
    L5:
        r11 = null;
        goto L6
    }

    public final MiniAppWidgetAvailability ensureWidgetAvailable(Context r10, String r11, String r12, Long r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        Intrinsics.checkNotNullParameter(r14, "scene");
        return MiniAppWidgetManagerRemote.INSTANCE.ensureWidgetAvailable(r10, r11, r12, r13, r14);
    }

    public final Object getAppletIds(Continuation<? super List<String>> r5) {
        if ((r5 instanceof C01771) == false) goto L7;
        C01771 r10 = (C01771) r5;
        int r11 = r10.d;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.d = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f11399b;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.d;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        kotlinx.coroutines.sync.a r15 = r10.f11398a;
        ResultKt.throwOnFailure(r12);
    L30:
        List r16 = CollectionsKt.toList(f11391c.keySet());     // Catch: Throwable -> L27
        ((d) r15).d(null);
        return r16;
    L27:
        th = move-exception;
        ((d) r15).d(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r12);
    L19:
        kotlinx.coroutines.sync.a r17 = f11390b;
        r10.f11398a = r17;
        r10.d = 2;
        d r18 = (d) r17;
        if (r18.c(r10) != r13) goto L22;
    L21:
        return r13;
    L22:
        r15 = r18;
        goto L30
    L16:
        ResultKt.throwOnFailure(r12);
        r10.d = 1;
        if (a(r10) != r13) goto L19;
    L7:
        r10 = new C01771(this, r5);
        goto L8
    }

    public final Object getAppletInfo(String r5, Continuation<? super MiniAppInfo> r10) {
        if ((r10 instanceof C01781) == false) goto L7;
        C01781 r11 = (C01781) r10;
        int r12 = r11.e;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.e = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f11403c;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.e;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        kotlinx.coroutines.sync.a r16 = r11.f11402b;
        String r17 = r11.f11401a;
        ResultKt.throwOnFailure(r13);
    L30:
        MiniAppInfo r18 = (MiniAppInfo) f11391c.get(r17);     // Catch: Throwable -> L27
        ((d) r16).d(null);
        return r18;
    L27:
        th = move-exception;
        ((d) r16).d(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r5 = r11.f11401a;
        ResultKt.throwOnFailure(r13);
    L19:
        kotlinx.coroutines.sync.a r19 = f11390b;
        r11.f11401a = r5;
        r11.f11402b = r19;
        r11.e = 2;
        d r20 = (d) r19;
        if (r20.c(r11) != r14) goto L22;
    L21:
        return r14;
    L22:
        r17 = r5;
        r16 = r20;
        goto L30
    L16:
        ResultKt.throwOnFailure(r13);
        r11.f11401a = r5;
        r11.e = 1;
        if (a(r11) != r14) goto L19;
    L7:
        r11 = new C01781(this, r10);
        goto L8
    }

    public final Object getMiniAppWidgets(String r5, Continuation<? super List<MiniAppWidgetInfo>> r10) {
        if ((r10 instanceof C01791) == false) goto L7;
        C01791 r11 = (C01791) r10;
        int r12 = r11.e;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.e = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f11406c;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.e;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        kotlinx.coroutines.sync.a r16 = r11.f11405b;
        String r17 = r11.f11404a;
        ResultKt.throwOnFailure(r13);
    L46:
        if (r17 == null) goto L33;
        MiniAppInfo r18 = (MiniAppInfo) f11391c.get(r17);     // Catch: Throwable -> L30
        if (r18 == null) goto L32;
        List<MiniAppWidgetInfo> r19 = r18.getWidgets();     // Catch: Throwable -> L30
        if (r19 == null) goto L32;
    L42:
        ((d) r16).d(null);
        return r19;
    L32:
        r19 = CollectionsKt.emptyList();     // Catch: Throwable -> L30
        goto L42
    L33:
        Collection r20 = f11391c.values();     // Catch: Throwable -> L30
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L30
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L30
    L35:
        if (r22.hasNext() == false) goto L41;
        List<MiniAppWidgetInfo> r23 = ((MiniAppInfo) r22.next()).getWidgets();     // Catch: Throwable -> L30
        if (r23 != null) goto L39;
        r23 = CollectionsKt.emptyList();     // Catch: Throwable -> L30
    L39:
        CollectionsKt.a(r21, r23);     // Catch: Throwable -> L30
        goto L35
    L41:
        r19 = r21;
    L30:
        th = move-exception;
        ((d) r16).d(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r5 = r11.f11404a;
        ResultKt.throwOnFailure(r13);
    L19:
        kotlinx.coroutines.sync.a r24 = f11390b;
        r11.f11404a = r5;
        r11.f11405b = r24;
        r11.e = 2;
        d r25 = (d) r24;
        if (r25.c(r11) != r14) goto L22;
    L21:
        return r14;
    L22:
        r17 = r5;
        r16 = r25;
        goto L46
    L16:
        ResultKt.throwOnFailure(r13);
        r11.f11404a = r5;
        r11.e = 1;
        if (a(r11) != r14) goto L19;
    L7:
        r11 = new C01791(this, r10);
        goto L8
    }

    public final Object getWidgetInfo(String r5, String r10, Continuation<? super MiniAppWidgetInfo> r11) {
        if ((r11 instanceof C01801) == false) goto L7;
        C01801 r12 = (C01801) r11;
        int r13 = r12.d;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.d = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f11408b;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.d;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = r12.f11407a;
        ResultKt.throwOnFailure(r14);
    L17:
        MiniAppInfo r17 = (MiniAppInfo) r14;
        Object r18 = null;
        if (r17 == null) goto L32;
        List<MiniAppWidgetInfo> r19 = r17.getWidgets();
        if (r19 == null) goto L33;
        Iterator<T> r20 = r19.iterator();
    L23:
        if (r20.hasNext() == false) goto L28;
        Object r21 = r20.next();
        if (Intrinsics.areEqual(((MiniAppWidgetInfo) r21).getWidgetId(), r10) == false) goto L23;
        r18 = r21;
    L28:
        return (MiniAppWidgetInfo) r18;
    L33:
        return null;
    L32:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r12.f11407a = r10;
        r12.d = 1;
        r14 = getAppletInfo(r5, r12);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r12 = new C01801(this, r11);
        goto L8
    }

    public final void init(Context r10, CoroutineScope r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "scope");
        f11389a = BuildersKt.launch$default(r11, null, CoroutineStart.LAZY, new C01811(r10, null), 1, null);
    }

    public final boolean notifyWidgetDataChanged(Context r16, String r17, String r18, int r19, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "appletId");
        Intrinsics.checkNotNullParameter(r18, "widgetId");
        return MiniAppWidgetManagerRemote.notifyWidgetDataChanged$default(MiniAppWidgetManagerRemote.INSTANCE, r16, r17, r18, r19, r20, "launcher", null, null, null, null, r21, 960, null);
    }

    public final Object openMiniApp(Context r5, String r10, Continuation<? super Boolean> r11) {
        return openMiniApp(r5, BundleKt.bundleOf(new Pair[]{TuplesKt.to("appletId", r10)}), r11);
    }

    public final MiniAppWidgetDataSnapshot queryWidgetData(Context r10, String r11, String r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        return MiniAppWidgetManagerRemote.INSTANCE.queryWidgetData(r10, r11, r12, r13, "launcher");
    }

    public final MiniAppWidgetManagerRemote.RefreshAffectedResult refreshAffectedByUpdate(Context r10, String r11, List<String> r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "changedDomains");
        return MiniAppWidgetManagerRemote.INSTANCE.refreshAffectedByUpdate(r10, r11, r12, r13, "launcher");
    }

    public final void refreshMiniAppWidgetsSync(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        BuildersKt.runBlocking$default(null, new C01821(r5, null), 1, null);
    }

    public final boolean registerWidgetMessenger(Context r10, String r11, String r12, int r13, Messenger r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        Intrinsics.checkNotNullParameter(r14, "messenger");
        return MiniAppWidgetManagerRemote.INSTANCE.registerWidgetMessenger(r10, r11, r12, r13, r14, "launcher");
    }

    public final boolean sendEventToWidget(View r5, String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        if ((r5 instanceof WidgetView) == false) goto L5;
        WidgetView r12 = (WidgetView) r5;
    L6:
        if (r12 != null) goto L10;
        return false;
    L10:
        return r12.onMessageToAIBridge(r10, r11);
    L5:
        r12 = null;
        goto L6
    }

    public final String sendPayload(Context r10, String r11, String r12, int r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        Intrinsics.checkNotNullParameter(r14, "payload");
        return MiniAppWidgetManagerRemote.INSTANCE.sendPayload(r10, r11, r12, r13, r14, r15, "launcher");
    }

    public final boolean unregisterWidgetMessenger(Context r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return MiniAppWidgetManagerRemote.INSTANCE.unregisterWidgetMessenger(r10, r11, r12, r13, "launcher");
    }

    public final String updateWidget(Context r10, String r11, String r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        Intrinsics.checkNotNullParameter(r14, "reason");
        return MiniAppWidgetManagerRemote.INSTANCE.updateWidget(r10, r11, r12, r13, r14, "launcher");
    }

    public final boolean updateWidgetView(View r19, MiniAppWidgetInfo r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "miniAppWidgetInfo");
        if ((r19 instanceof WidgetView) == false) goto L5;
        WidgetView r5 = (WidgetView) r19;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        String r10 = r20.getAppletId();
        String r11 = r20.getWidgetId();
        if (r21 != null) goto L12;
    L14:
        String r12 = null;
    L16:
        return r5.updateWidgetData(new WidgetInfo(r10, r11, r12, null, null, null, null, null, null, null, null, 2040, null));
    L12:
        if (StringsKt.isBlank(r21) == true) goto L14;
        r12 = r21;
        goto L16
    L5:
        r5 = null;
        goto L6
    }

    public final Object a(Context r10, Continuation r11) {
        if ((r11 instanceof MiniAppWidgetManagerWrapper$refreshMiniAppWidgets$1) == false) goto L7;
        MiniAppWidgetManagerWrapper$refreshMiniAppWidgets$1 r5 = (MiniAppWidgetManagerWrapper$refreshMiniAppWidgets$1) r11;
        int r12 = r5.e;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.f11420c;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.e;
        if (r15 == 0) goto L18;
        if (r15 != 1) goto L17;
        kotlinx.coroutines.sync.a r16 = r5.f11419b;
        Context r17 = r5.f11418a;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L14
        kotlinx.coroutines.sync.a r18 = r16;
        r10 = r17;
    L40:
        LinkedHashMap r19 = f11391c;     // Catch: Throwable -> L27
        r19.clear();     // Catch: Throwable -> L27
        List<MiniAppInfo> r20 = MiniAppWidgetManagerRemote.INSTANCE.queryMiniAppInfos(r10, 2);     // Catch: Throwable -> L27
        ArrayList r21 = new ArrayList(CollectionsKt.h(r20));     // Catch: Throwable -> L27
        Iterator<T> r22 = r20.iterator();     // Catch: Throwable -> L27
    L25:
        if (r22.hasNext() == false) goto L29;
        MiniAppInfo r23 = (MiniAppInfo) r22.next();     // Catch: Throwable -> L27
        r21.add(TuplesKt.to(r23.getAppletId(), r23));     // Catch: Throwable -> L27
        goto L25
    L29:
        MapsKt.putAll(r19, r21);     // Catch: Throwable -> L27
        int r24 = Log.d("MiniAppWidgetProvider", "refreshMiniAppWidgets get " + f11391c.size());     // Catch: Throwable -> L27
        ((d) r18).d(null);     // Catch: Throwable -> L14
        Object r25 = Result.m124constructorimpl(Boxing.boxInt(r24));     // Catch: Throwable -> L14
    L34:
        Throwable r26 = Result.m127exceptionOrNullimpl(r25);
        if (r26 == null) goto L38;
        Log.w("MiniAppWidgetProvider", "refreshMiniAppWidgets failed", r26);
    L38:
        return Unit.INSTANCE;
    L27:
        th = move-exception;
        ((d) r18).d(null);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r13);
        Log.d("MiniAppWidgetProvider", "refreshMiniAppWidgets");
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L14
        kotlinx.coroutines.sync.a r28 = f11390b;     // Catch: Throwable -> L14
        r5.f11418a = r10;     // Catch: Throwable -> L14
        r5.f11419b = r28;     // Catch: Throwable -> L14
        r5.e = 1;     // Catch: Throwable -> L14
        d r29 = (d) r28;     // Catch: Throwable -> L14
        Object r30 = r29.c(r5);     // Catch: Throwable -> L14
        r18 = r29;
        if (r30 != r14) goto L40;
        return r14;
    L14:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r25 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L7:
        r5 = new MiniAppWidgetManagerWrapper$refreshMiniAppWidgets$1(this, r11);
        goto L8
    }

    public final Object openMiniApp(Context r13, Bundle r14, Continuation<? super Boolean> r15) {
        if ((r15 instanceof AnonymousClass2) == false) goto L7;
        AnonymousClass2 r5 = (AnonymousClass2) r15;
        int r10 = r5.g;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.g = r10 - Integer.MIN_VALUE;
    L8:
        Object r12 = r5.e;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r5.g;
        boolean r17 = true;
        Object r18 = null;
        if (r11 == 0) goto L24;
        if (r11 == 1) goto L19;
        if (r11 != 2) goto L18;
        kotlinx.coroutines.sync.a r19 = r5.d;
        String r110 = r5.f11417c;
        Bundle r111 = r5.f11416b;
        Context r20 = r5.f11415a;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
    L93:
        MiniAppInfo r112 = (MiniAppInfo) f11391c.get(r110);     // Catch: Throwable -> L71
        ((d) r19).d(null);     // Catch: Throwable -> L15
        if (r112 != null) goto L49;
        Log.w("MiniAppWidgetProvider", "openMiniApp: missing miniAppInfo for appletId=" + r110);     // Catch: Throwable -> L15
        r17 = false;
    L70:
        Object r113 = Result.m124constructorimpl(Boxing.boxBoolean(r17));     // Catch: Throwable -> L15
    L81:
        Throwable r114 = Result.m127exceptionOrNullimpl(r113);
        if (r114 == null) goto L84;
        Log.w("MiniAppWidgetProvider", "openMiniApp failed for appletId=" + r110 + ", args=" + r111, r114);
    L84:
        Boolean r115 = Boxing.boxBoolean(false);
        if (Result.m130isFailureimpl(r113) == true) goto L87;
        return r113;
    L87:
        return r115;
    L49:
        Intent r116 = new Intent("android.intent.action.VIEW");     // Catch: Throwable -> L15
        r116.addCategory("android.intent.category.BROWSABLE");     // Catch: Throwable -> L15
        String r117 = r112.getLaunchInfo();     // Catch: Throwable -> L15
        if (r117 == null) goto L52;
        Uri r118 = Uri.parse(r117);     // Catch: Throwable -> L15
    L53:
        r116.setData(r118);     // Catch: Throwable -> L15
        r116.addFlags(268435456);     // Catch: Throwable -> L15
        Iterator<T> r119 = r20.getPackageManager().queryIntentActivities(r116, 1048576).iterator();     // Catch: Throwable -> L15
    L56:
        if (r119.hasNext() == false) goto L66;
        Object r21 = r119.next();     // Catch: Throwable -> L15
        ResolveInfo r22 = (ResolveInfo) r21;     // Catch: Throwable -> L15
        if (r22 == null) goto L62;
        ActivityInfo r23 = r22.activityInfo;     // Catch: Throwable -> L15
        if (r23 == null) goto L62;
        String r24 = r23.packageName;     // Catch: Throwable -> L15
    L64:
        if (Intrinsics.areEqual(r24, "com.obric.appletapp") == false) goto L56;
        r18 = r21;
    L62:
        r24 = null;
    L66:
        ResolveInfo r25 = (ResolveInfo) r18;     // Catch: Throwable -> L15
        if (r25 == null) goto L69;
        r116.setComponent(new ComponentName("com.obric.appletapp", r25.activityInfo.name));     // Catch: Throwable -> L15
    L69:
        r20.startActivity(r116);     // Catch: Throwable -> L15
        goto L70
    L52:
        r118 = null;
        goto L53
    L71:
        th = move-exception;
        ((d) r19).d(null);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        Throwable th2 = th;
    L77:
        String r26 = r110;
    L80:
        Result.Companion r120 = Result.Companion;
        r113 = Result.m124constructorimpl(ResultKt.createFailure(th2));
        r110 = r26;
        goto L81
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r110 = r5.f11417c;
        Bundle r121 = r5.f11416b;
        Context r27 = r5.f11415a;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L22
        Bundle r122 = r121;
        r13 = r27;
    L88:
        kotlinx.coroutines.sync.a r28 = f11390b;     // Catch: Throwable -> L75
        r5.f11415a = r13;     // Catch: Throwable -> L75
        r5.f11416b = r122;     // Catch: Throwable -> L75
        r5.f11417c = r110;     // Catch: Throwable -> L75
        r5.d = r28;     // Catch: Throwable -> L75
        r5.g = 2;     // Catch: Throwable -> L75
        d r29 = (d) r28;     // Catch: Throwable -> L75
        if (r29.c(r5) != r16) goto L44;
    L43:
        return r16;
    L44:
        r111 = r122;
        r20 = r13;
        r19 = r29;
    L75:
        th = move-exception;
        r111 = r122;
        th2 = th;
    L22:
        th2 = th;
        r111 = r121;
        goto L77
    L24:
        ResultKt.throwOnFailure(r12);
        r122 = a(r14);
        if (r122 == null) goto L27;
        r26 = r122.getString("appletId");
    L28:
        if (r26 != null) goto L31;
        r26 = "";
    L31:
        if (StringsKt.isBlank(r26) == false) goto L90;
        Log.w("MiniAppWidgetProvider", "openMiniApp skipped: missing appletId, args=" + r14);
        return Boxing.boxBoolean(false);
    L90:
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L78
        if (a(r13, r122) == false) goto L37;
        Log.i("MiniAppWidgetProvider", "openMiniApp: intercepted navigation for appletId=".concat(r26));     // Catch: Throwable -> L78
        r111 = r122;
        r110 = r26;
        goto L70
    L37:
        Log.i("MiniAppWidgetProvider", "openMiniApp: using original intent method for appletId=".concat(r26));     // Catch: Throwable -> L78
        r5.f11415a = r13;     // Catch: Throwable -> L78
        r5.f11416b = r122;     // Catch: Throwable -> L78
        r5.f11417c = r26;     // Catch: Throwable -> L78
        r5.g = 1;     // Catch: Throwable -> L78
        if (a(r5) == r16) goto L43;
        r110 = r26;
    L78:
        th = move-exception;
        r111 = r122;
        th2 = th;
        goto L80
    L27:
        r26 = null;
    L7:
        r5 = new AnonymousClass2(this, r15);
        goto L8
    }

    public final String buildStableMessageId$widget_sdk_4l_release(String r5, String r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        if (r11 == null) goto L6;
        int r12 = r11.intValue();
        StringBuilder r13 = androidx.constraintlayout.motion.widget.a.y("launcher_widget:launcher:", r5, ":", r10, ":");
        r13.append(r12);
        return r13.toString();
    L6:
        return null;
    }

    public static boolean a(Context r12, Bundle r13) {
        Bundle r14 = a(r13);
        c r5 = null;
        Class<?> r10 = null;
        r10 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        if (r14 == null) goto L5;
        String r11 = r14.getString("appletId", "");
    L7:
        if (r11 != null) goto L9;
    L23:
        String r15 = null;
    L24:
        int r16 = 0;
        if (r15 != null) goto L27;
    L200:
        return false;
    L27:
        if (r15.length() == 0) goto L200;
        if ((r12 instanceof Application) == false) goto L38;
        b r17 = p.f2294c;
        if (r17 == null) goto L38;
        Activity r18 = r17.currentActivity();
        if (r18 == null) goto L38;
        r12 = r18;
    L38:
        if (a(r12, r15, r14) == false) goto L40;
        return true;
    L40:
        Intent r19 = new Intent();
        if (r11 == null) goto L43;
        Uri r20 = Uri.parse(r11);
    L44:
        r19.putExtra("appletId", r11);
        r19.putExtras(r14);
        r19.putExtra(MiniAppConstants.APPLET_FROM_LAUNCHER, true);
        if (r12 != null) goto L48;
        Log.e("SmartRouter", "SmartRoute#open context is null!!!");
    L199:
        return true;
    L48:
        if (TextUtils.isEmpty(r15) == false) goto L51;
        Log.e("SmartRouter", "SmartRoute#url is null!!!");
        goto L199
    L51:
        if (TextUtils.isEmpty(r15) == false) goto L53;
        boolean r110 = false;
    L54:
        if (r110 == true) goto L56;
        Log.e("SmartRouter", "SmartRoute#url is illegal and url is ".concat(r15));
        goto L199
    L56:
        Intent r111 = new Intent();
        r111.putExtras(r19);
        r111.addFlags(r19.getFlags());
        hi.a r21 = new hi.a();
        r21.f17327a = "";
        r21.f17328b = null;
        r21.f17329c = "";
        r21.d = null;
        r21.e = "";
        r21.f = "";
        r21.g = "";
        r21.f17330h = -1;
        r21.f17331i = -1;
        hi.a.b(r111, r15, false);
        r21.f17327a = r15;
        if (r21.f17329c.equals(r15) == true) goto L59;
        r21.f17329c = r21.f17327a;
    L59:
        r21.f17328b = r111;
        r21.f17330h = -1;
        r21.f17331i = -1;
        r21.f17332j = r20;
        r21.a();
        w r112 = hi.b.f17333a;
        r112.getClass();
        String r22 = r21.f17329c;
        w r23 = (w) r112.f9376b;
        if (TextUtils.isEmpty(r22) == true) goto L198;
        Uri r24 = Uri.parse(r22);
        if (r24.isHierarchical() == false) goto L198;
        String r25 = r24.getScheme();
        if (TextUtils.isEmpty(r25) == true) goto L79;
        r23.getClass();
        if (r25.equals("snssdk143") == true) goto L79;
        String[] r26 = (String[]) r23.f9377c;
        if (r26 == null) goto L198;
        if (r26.length <= 0) goto L198;
        int r27 = r26.length;
        int r28 = 0;
    L76:
        if (r28 >= r27) goto L198;
        if (r25.equals(r26[r28]) == true) goto L79;
        r28 = r28 + 1;
    L79:
        r9.c r29 = (r9.c) r112.d;
        monitor-enter(r29);
        monitor-exit(r29);
        String r30 = r21.f17329c;
        if (TextUtils.isEmpty(r30) == false) goto L85;
        boolean r31 = false;
    L86:
        if (r31 == true) goto L88;
        Log.e("SmartRouter", "RouteManager#RouteIntent-outputUrl is illegal and url is : " + r30);
        r21 = null;
    L104:
        if (r21 == null) goto L199;
        l r32 = (l) r112.f9377c;
        String r33 = r21.f17329c;
        r32.getClass();
        if (TextUtils.isEmpty(r33) == false) goto L109;
        String r34 = "";
    L128:
        if (TextUtils.isEmpty(r34) == false) goto L136;
        monitor-enter(r112);
        Log.w("SmartRouter", "if you use urls in plugins, you must set SupportPluginCallback to support plugins.");     // Catch: Throwable -> L133
        monitor-exit(r112);
        Log.w("SmartRouter", "RouteManager#open cannot find the routeUri with " + r21.f17329c);
    L133:
        th = move-exception;
        throw th;
    L136:
        TextUtils.isEmpty(r34);
        String r35 = r21.f17329c;
        w r36 = (w) r112.f9376b;
        if (TextUtils.isEmpty(r35) == false) goto L139;
        Log.e("SmartRouter", "RouteFactory#createRoute url is null!!!");
    L187:
        if (r5 == null) goto L189;
        l r113 = (l) r112.f9377c;
        r5.f17572b = r21;
        String r37 = r21.f17329c;
        r5.f17571a = r37;
        Uri.parse(r37);
        r5.f17573c = r113;
    L189:
        if (r5 != null) goto L203;
        Log.e("SmartRouter", "RouteManager#Not support the route with url：" + r21.f17329c);
        goto L199
    L203:
        r5.a(r12);     // Catch: Exception -> L193
    L193:
        e = move-exception;
        Log.e("SmartRouter", "Please check the scheme and its mapping class!!!");
        e.printStackTrace();
        e.getMessage();
        goto L199
    L139:
        Uri r38 = Uri.parse(r35);
        if (r38.isHierarchical() == true) goto L142;
        Log.e("SmartRouter", "RouteFactory#createRoute url is not illegal!!!");
        goto L187
    L142:
        String r39 = r38.getScheme();
        if (TextUtils.isEmpty(r39) == false) goto L145;
        Log.e("SmartRouter", "RouteFactory#createRoute scheme is null!!!");
        goto L187
    L145:
        String r40 = r38.getHost();
        if (TextUtils.isEmpty(r40) == false) goto L148;
        Log.e("SmartRouter", "RouteFactory#createRoute host is null!!!");
        goto L187
    L148:
        r36.getClass();
        if (r39.equals("snssdk143") == true) goto L160;
        String[] r41 = (String[]) r36.f9377c;
        if (r41 != null) goto L154;
    L186:
        Log.e("SmartRouter", "RouteFactory#createRoute router cannot support this scheme protocol: " + r35 + "\nRouteConfig:\n" + r36.toString());
        goto L187
    L154:
        if (r41.length <= 0) goto L186;
        int r114 = r41.length;
    L156:
        if (r16 >= r114) goto L186;
        if (r39.equals(r41[r16]) == true) goto L160;
        r16 = r16 + 1;
    L160:
        if (r40.startsWith("bt.") == true) goto L162;
        r10 = Class.forName(r34);     // Catch: Throwable -> L173 ClassNotFoundException -> L175
    L177:
        if (r10 != null) goto L179;
    L184:
        r5 = new ii.a(1);
        goto L187
    L179:
        if (Service.class.isAssignableFrom(r10) == false) goto L182;
        r5 = new ii.b();
        goto L187
    L182:
        if (BroadcastReceiver.class.isAssignableFrom(r10) == false) goto L184;
        r5 = new ii.a(0);
        goto L187
    L175:
        e = move-exception;
        e.printStackTrace();
    L173:
        th = move-exception;
        th.printStackTrace();
        goto L177
    L162:
        if (TextUtils.isEmpty(r40) == false) goto L164;
        Class r42 = null;
    L165:
        if (r42 != null) goto L201;
        Log.e("SmartRouter", "RouteFactory#createRoute there is no route for this host: ".concat(r40));
        goto L187
    L201:
        r5 = (c) r42.newInstance();     // Catch: Exception -> L169
    L169:
        e = move-exception;
        Log.e("SmartRouter", "RouteFactory#createRoute routeClass new instance exception!!!");
        e.printStackTrace();
        goto L187
    L164:
        r42 = (Class) ((HashMap) r36.d).get(r40);
        goto L165
    L109:
        HashMap r43 = r32.f20820a;
        Uri r44 = Uri.parse(r33);
        if (r44.isHierarchical() == true) goto L112;
        String r45 = null;
    L116:
        String r46 = (String) r43.get(r45);
        if (TextUtils.isEmpty(r46) == false) goto L126;
        HashMap r47 = r32.f20820a;
        Uri r48 = Uri.parse(r33);
        if (r48.isHierarchical() == true) goto L121;
        String r49 = null;
    L125:
        r34 = (String) r47.get(r49);
        goto L128
    L121:
        if (TextUtils.isEmpty(r48.getScheme()) == true) goto L123;
        r49 = r48.getScheme() + "://" + r48.getAuthority() + r48.getPath();
        goto L125
    L123:
        r49 = "//" + r48.getAuthority() + r48.getPath();
        goto L125
    L126:
        r34 = r46;
        goto L128
    L112:
        if (TextUtils.isEmpty(r44.getScheme()) == true) goto L114;
        r45 = "//" + r44.getAuthority() + r44.getPath();
        goto L116
    L114:
        r45 = r33;
        goto L116
    L88:
        ((w) r112.f9376b).getClass();
        if (TextUtils.isEmpty(Uri.parse(r30).getScheme()) == true) goto L91;
    L94:
        if (r30 == null) goto L104;
        if (TextUtils.isEmpty(r30) == false) goto L99;
        boolean r50 = false;
    L100:
        if (r50 == false) goto L196;
        if (r30.equals(r21.f17329c) == true) goto L104;
        r21.f17329c = r30;
        r21.a();
        hi.a.b(r21.f17328b, r21.f17329c, true);
        goto L104
    L196:
        throw new IllegalArgumentException("url is illegal!!!");
    L99:
        r50 = Uri.parse(r30).isHierarchical();
        goto L100
    L91:
        if (r30.startsWith("//") == false) goto L93;
        r30 = "snssdk143:".concat(r30);
        goto L94
    L93:
        r30 = "snssdk143://".concat(r30);
        goto L94
    L85:
        r31 = Uri.parse(r30).isHierarchical();
    L198:
        StringBuilder r115 = com.lynx.tasm.utils.e.b("RouteManager#checkLegality originUrl is illegal: ", r22, ". \n");
        r115.append(((w) r112.f9376b).toString());
        Log.e("SmartRouter", r115.toString());
        goto L199
    L53:
        r110 = Uri.parse(r15).isHierarchical();
        goto L54
    L43:
        r20 = null;
        goto L44
    L9:
        if (StringsKt.isBlank(r11) == true) goto L23;
        if (Intrinsics.areEqual(r11, MiniAppConstants.APPLET_ID_CALENDAR) == false) goto L14;
    L22:
        r15 = MiniAppConstants.ROUTE_URL_CALENDAR;
        goto L24
    L14:
        if (Intrinsics.areEqual(r11, "com.flow.calendar2") == true) goto L22;
        if (StringsKt.P(r11, MiniAppConstants.APPLET_ID_OBRIC_PREFIX) == false) goto L20;
        r15 = MiniAppConstants.ROUTE_URL_MINIAPP;
        goto L24
    L20:
        if (((Boolean) BuildersKt.runBlocking$default(null, new MiniAppWidgetManagerWrapper$isKnownMiniApp$1(r11, null), 1, null)).booleanValue() == false) goto L23;
        r15 = MiniAppConstants.ROUTE_URL_MINIAPP;
        goto L24
    L5:
        r11 = null;
        goto L7
    }

    public static Bundle a(Bundle r5) {
        if (r5 == null) goto L43;
        Bundle r10 = new Bundle(r5);
        String r11 = r10.getString("appletId");
        String r12 = "";
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        if (StringsKt.isBlank(r11) == false) goto L12;
        r11 = r10.getString(Constant.APPID);
        if (r11 != null) goto L12;
        r11 = "";
    L12:
        if (StringsKt.isBlank(r11) == true) goto L14;
        r10.putString("appletId", r11);
    L14:
        String r13 = r10.getString("pageId");
        if (r13 != null) goto L18;
        r13 = "";
    L18:
        if (StringsKt.isBlank(r13) == false) goto L23;
        r13 = r10.getString("pageId");
        if (r13 != null) goto L23;
        r13 = "";
    L23:
        if (StringsKt.isBlank(r13) == false) goto L28;
        r13 = r10.getString("pageId");
        if (r13 != null) goto L28;
        r13 = "";
    L28:
        if (StringsKt.isBlank(r13) == true) goto L30;
        r10.putString("pageId", r13);
        r10.putString("pageId", r13);
    L30:
        String r14 = r10.getString("pageData");
        if (r14 != null) goto L34;
        r14 = "";
    L34:
        if (StringsKt.isBlank(r14) == false) goto L38;
        r14 = r10.getString("pageData");
        if (r14 != null) goto L38;
    L40:
        if (StringsKt.isBlank(r12) == true) goto L42;
        r10.putString("pageData", r12);
    L42:
        return r10;
    L38:
        r12 = r14;
        goto L40
    L43:
        return null;
    }

    public static boolean a(Context r12, String r13, Bundle r14) {
        if (Intrinsics.areEqual(r13, MiniAppConstants.ROUTE_URL_CALENDAR) == true) goto L5;
        return false;
    L5:
        if (r14 != null) goto L7;
        r14 = Bundle.EMPTY;
    L7:
        String r5 = r14.getString("appletId");
        if (Intrinsics.areEqual(r5, MiniAppConstants.APPLET_ID_CALENDAR) == false) goto L10;
    L13:
        String r10 = r14.getString("pageId");
        String r11 = "";
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        if (StringsKt.isBlank(r10) == false) goto L21;
        r10 = r14.getString("pageId");
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        String r15 = null;
        if (StringsKt.isBlank(r10) == false) goto L25;
        r10 = null;
    L25:
        if (r10 == null) goto L27;
        Lazy r16 = p.f2292a;
        Intrinsics.checkNotNullParameter(r10, "pageId");
        com.bytedance.ai.model.widgets.a r17 = (com.bytedance.ai.model.widgets.a) p.f2293b.get(r10);
    L28:
        if (r17 == null) goto L33;
        PageInfo r18 = r17.f2330b;
        if (r18 == null) goto L33;
        String r19 = r18.getPageName();
        if (r19 == null) goto L33;
    L51:
        if (r17 == null) goto L58;
        PageInfo r20 = r17.f2330b;
        if (r20 == null) goto L58;
        String r21 = r20.getPageData();
        if (r21 == null) goto L58;
        r15 = r21;
    L70:
        List r22 = CollectionsKt.listOf(new Intent[]{new Intent("android.intent.action.VIEW", Uri.parse("applet://open_calendar")), new Intent("com.obric.miniapp.CALENDAR_MAIN")});
        ArrayList r23 = new ArrayList(CollectionsKt.h(r22));
        Iterator r24 = r22.iterator();
    L72:
        if (r24.hasNext() == false) goto L79;
        Intent r25 = (Intent) r24.next();
        r25.setPackage("com.obric.appletapp");
        r25.putExtras(r14);
        r25.putExtra("appletId", MiniAppConstants.APPLET_ID_CALENDAR);
        r25.putExtra(MiniAppConstants.APPLET_FROM_LAUNCHER, true);
        if (r19 == null) goto L76;
        r25.putExtra("pageId", r19);
        r25.putExtra("pageId", r19);
        r25.putExtra("pageId", r19);
    L76:
        if (r15 == null) goto L78;
        r25.putExtra("pageData", r15);
        r25.putExtra("pageData", r15);
    L78:
        r25.addFlags(872415232);
        r23.add(r25);
        goto L72
    L79:
        Iterator r110 = r23.iterator();
    L81:
        if (r110.hasNext() == false) goto L97;
        Intent r111 = (Intent) r110.next();
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L85
        r12.startActivity(r111);     // Catch: Throwable -> L85
        Object r112 = Result.m124constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L85
    L87:
        Throwable r27 = Result.m127exceptionOrNullimpl(r112);
        if (r27 == null) goto L90;
        Log.w("MiniAppWidgetProvider", "openCalendarInSystemContainer failed, try next intent", r27);
    L90:
        Boolean r28 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r112) == false) goto L94;
        r112 = r28;
    L94:
        if (((Boolean) r112).booleanValue() == false) goto L81;
        Log.i("MiniAppWidgetProvider", "openCalendarInSystemContainer success, appletId=" + r5 + ", pageId=" + r19);
        return true;
    L85:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r112 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L87
    L97:
        return false;
    L58:
        String r30 = r14.getString("pageData");
        if (r30 != null) goto L62;
        r30 = "";
    L62:
        if (StringsKt.isBlank(r30) == false) goto L66;
        r30 = r14.getString("pageData");
        if (r30 != null) goto L66;
    L68:
        if (StringsKt.isBlank(r11) == true) goto L70;
        r15 = r11;
    L66:
        r11 = r30;
    L33:
        r19 = r14.getString("pageId");
        if (r19 != null) goto L37;
        r19 = "";
    L37:
        if (StringsKt.isBlank(r19) == false) goto L42;
        r19 = r14.getString("pageId");
        if (r19 != null) goto L42;
        r19 = "";
    L42:
        if (StringsKt.isBlank(r19) == false) goto L47;
        r19 = r14.getString("pageId");
        if (r19 != null) goto L47;
        r19 = "";
    L47:
        if (StringsKt.isBlank(r19) == false) goto L51;
        r19 = null;
        goto L51
    L27:
        r17 = null;
        goto L28
    L10:
        if (Intrinsics.areEqual(r5, "com.flow.calendar2") == true) goto L13;
        return false;
    }

    public static final void a(WidgetView r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "$it");
        Intrinsics.checkNotNullParameter(r10, "$appTheme");
        WidgetSDK.INSTANCE.notifyWidgetThemeChanged(r5, Intrinsics.areEqual(r10, WidgetView.UI_MODE_DARK));
    }

    public static float a(Context r10) {
        Display r5 = r10.getDisplay();
        if (r5 == null) goto L41;
        Display.Mode r11 = r5.getMode();
        if (r11 == null) goto L41;
        Display r12 = r10.getDisplay();
        if (r12 == null) goto L41;
        Display.Mode[] r13 = r12.getSupportedModes();
        if (r13 == null) goto L41;
        Float r14 = null;
        if (r13.length != 0) goto L14;
        Display.Mode r15 = null;
    L24:
        if (r15 == null) goto L41;
        int r16 = RangesKt.coerceAtMost(r15.getPhysicalWidth(), r15.getPhysicalHeight());
        int r17 = RangesKt.coerceAtLeast(r15.getPhysicalWidth(), r15.getPhysicalHeight());
        int r18 = RangesKt.coerceAtMost(r11.getPhysicalWidth(), r11.getPhysicalHeight());
        int r19 = RangesKt.coerceAtLeast(r11.getPhysicalWidth(), r11.getPhysicalHeight());
        if (r16 <= 0) goto L41;
        if (r17 <= 0) goto L41;
        if (r18 <= 0) goto L41;
        if (r19 <= 0) goto L41;
        float r110 = Math.min(r18 / r16, r19 / r17);
        Float r20 = Float.valueOf(r110);
        if (r110 > 0.0f) goto L34;
    L38:
        if (r14 == null) goto L41;
        return r14.floatValue();
    L34:
        if (Float.isInfinite(r110) == true) goto L38;
        if (Float.isNaN(r110) == true) goto L38;
        r14 = r20;
        goto L38
    L14:
        r15 = r13[0];
        int r21 = ArraysKt.getLastIndex(r13);
        if (r21 == 0) goto L24;
        int r22 = r15.getPhysicalHeight() * r15.getPhysicalWidth();
        int r23 = 1;
        if (1 > r21) goto L24;
    L19:
        Display.Mode r24 = r13[r23];
        int r25 = r24.getPhysicalHeight() * r24.getPhysicalWidth();
        if (r22 >= r25) goto L22;
        r15 = r24;
        r22 = r25;
    L22:
        if (r23 == r21) goto L24;
        r23 = r23 + 1;
    L41:
        return 1.0f;
    }
}
