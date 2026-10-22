package com.obric.assistant.interaction.impl.window;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.apm.ApmAgent;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.h4;
import com.larus.bmhome.chat.l4;
import com.larus.bmhome.setting.IFragmentProvider;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.platform.service.z2;
import com.larus.setting.api.SettingService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.ActivityProxyListener;
import com.obric.assistant.interaction.api.service.IActivityResultHelperApi;
import com.obric.assistant.interaction.api.service.IActivityResultHelperApiKt;
import com.obric.assistant.interaction.api.window.IChatWindowActivity;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import de8.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ¿\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002¿\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.H\u0002J$\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u000f2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\b\u00104\u001a\u00020+H\u0002J\b\u00105\u001a\u00020+H\u0002J\b\u00106\u001a\u00020+H\u0002J\b\u00107\u001a\u00020#H\u0002J\u0010\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\tH\u0002J\u0010\u0010:\u001a\u00020\u00112\u0006\u00109\u001a\u00020\tH\u0002J\u0010\u0010;\u001a\u00020\u00152\u0006\u00109\u001a\u00020\tH\u0002J\u0010\u0010<\u001a\u00020=2\u0006\u00109\u001a\u00020\tH\u0002J\u0015\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020@H\u0000¢\u0006\u0002\bAJ\u0017\u0010B\u001a\u00020+2\b\u0010C\u001a\u0004\u0018\u00010DH\u0000¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0001¢\u0006\u0002\bIJ\r\u0010J\u001a\u00020+H\u0000¢\u0006\u0002\bKJ\b\u0010L\u001a\u00020DH\u0003J\n\u0010M\u001a\u0004\u0018\u00010NH\u0016J\n\u0010O\u001a\u0004\u0018\u00010NH\u0002J)\u0010P\u001a\u00020+2\u0006\u0010Q\u001a\u00020R2\u0012\u0010S\u001a\n\u0012\u0006\b\u0001\u0012\u00020U0T\"\u00020UH\u0002¢\u0006\u0002\u0010VJ \u0010W\u001a\u00020+2\u0006\u0010Q\u001a\u00020R2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020#H\u0002J\u0017\u0010[\u001a\u00020+2\b\u0010\\\u001a\u0004\u0018\u00010DH\u0000¢\u0006\u0002\b]J\r\u0010^\u001a\u00020+H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u00020+H\u0000¢\u0006\u0002\baJ\r\u0010b\u001a\u00020+H\u0000¢\u0006\u0002\bcJ\r\u0010d\u001a\u00020+H\u0000¢\u0006\u0002\beJ\r\u0010f\u001a\u00020+H\u0000¢\u0006\u0002\bgJ\u001f\u0010h\u001a\u00020+2\u0006\u0010Q\u001a\u00020R2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020+0jH\u0082\bJ\u0018\u0010k\u001a\u00020+2\u0006\u0010Q\u001a\u00020R2\u0006\u0010-\u001a\u00020.H\u0002J'\u0010l\u001a\u00020#2\u0006\u0010m\u001a\u00020=2\u0006\u0010n\u001a\u00020=2\b\u0010o\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\bpJ\u0010\u0010q\u001a\u00020#2\u0006\u0010r\u001a\u00020sH\u0002J\b\u0010t\u001a\u00020\tH\u0016J\b\u0010u\u001a\u00020\u0011H\u0016J\b\u0010v\u001a\u00020\u0015H\u0016J\u0010\u0010w\u001a\u00020+2\u0006\u0010x\u001a\u00020\u0015H\u0016J\u0012\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u00020RH\u0016J\b\u0010|\u001a\u000203H\u0016J\b\u0010}\u001a\u00020\u000bH\u0016J\b\u0010~\u001a\u00020\u007fH\u0016J\u000e\u0010\u0080\u0001\u001a\u00070\u0081\u0001R\u00020\u007fH\u0016J\t\u0010\u0082\u0001\u001a\u00020RH\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\n\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\u0007\u0010\u0087\u0001\u001a\u00020@J\u0013\u0010\u0088\u0001\u001a\u00020+2\b\u0010\\\u001a\u0004\u0018\u00010DH\u0014J\t\u0010\u0089\u0001\u001a\u00020+H\u0014J\t\u0010\u008a\u0001\u001a\u00020+H\u0014J\t\u0010\u008b\u0001\u001a\u00020+H\u0014J\t\u0010\u008c\u0001\u001a\u00020+H\u0014J\t\u0010\u008d\u0001\u001a\u00020+H\u0014J\t\u0010\u008e\u0001\u001a\u00020+H\u0014J\t\u0010\u008f\u0001\u001a\u00020+H\u0014J\u0013\u0010\u0090\u0001\u001a\u00020+2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0016J\u0019\u0010\u0093\u0001\u001a\u00020+2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0000¢\u0006\u0003\b\u0094\u0001J#\u0010\u0095\u0001\u001a\u00020+2\u0006\u0010m\u001a\u00020=2\u0006\u0010n\u001a\u00020=2\b\u0010o\u001a\u0004\u0018\u00010\u0015H\u0014J2\u0010\u0096\u0001\u001a\u00020+2\u0006\u0010m\u001a\u00020=2\u000f\u0010\u0097\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020R0T2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0016¢\u0006\u0003\u0010\u009a\u0001J9\u0010\u0096\u0001\u001a\u00020+2\u0006\u0010m\u001a\u00020=2\r\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020R0T2\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009b\u0001\u001a\u00020=H\u0016¢\u0006\u0003\u0010\u009c\u0001J\u000f\u0010\u009d\u0001\u001a\u00020#H\u0000¢\u0006\u0003\b\u009e\u0001J\u0012\u0010\u009f\u0001\u001a\u00020+2\u0007\u0010 \u0001\u001a\u00020RH\u0002J\t\u0010¡\u0001\u001a\u00020+H\u0016J\t\u0010¢\u0001\u001a\u00020+H\u0016J\t\u0010£\u0001\u001a\u00020+H\u0016J\t\u0010¤\u0001\u001a\u00020+H\u0016J\u0015\u0010¥\u0001\u001a\u00020+2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J%\u0010¨\u0001\u001a\u00020+2\u0007\u0010©\u0001\u001a\u00020\u00152\u0006\u0010m\u001a\u00020=2\t\u0010ª\u0001\u001a\u0004\u0018\u00010DH\u0016JL\u0010«\u0001\u001a\u00020+2\b\u0010©\u0001\u001a\u00030¬\u00012\u0006\u0010m\u001a\u00020=2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00152\u0007\u0010®\u0001\u001a\u00020=2\u0007\u0010¯\u0001\u001a\u00020=2\u0007\u0010°\u0001\u001a\u00020=2\t\u0010ª\u0001\u001a\u0004\u0018\u00010DH\u0017J\u0014\u0010±\u0001\u001a\u00020+2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0015H\u0016J\u001f\u0010±\u0001\u001a\u00020+2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010ª\u0001\u001a\u0004\u0018\u00010DH\u0016J\"\u0010²\u0001\u001a\u00020+2\u0011\u0010³\u0001\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010TH\u0016¢\u0006\u0003\u0010´\u0001J-\u0010²\u0001\u001a\u00020+2\u0011\u0010³\u0001\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010T2\t\u0010ª\u0001\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0003\u0010µ\u0001J\u0012\u0010¶\u0001\u001a\u00020#2\u0007\u0010·\u0001\u001a\u00020RH\u0016J\f\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\t\u0010º\u0001\u001a\u00020RH\u0016J\t\u0010»\u0001\u001a\u00020=H\u0016J\f\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001H\u0016J\t\u0010¾\u0001\u001a\u00020#H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006À\u0001"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/larus/bmhome/chat/IChatActivity;", "Lcom/larus/bmhome/chat/IDefaultChatActivity;", "Lcom/larus/bmhome/chat/ITraceActivity;", "Lcom/obric/assistant/interaction/api/window/IChatWindowActivity;", "app", "Landroid/app/Application;", "baseCtx", "Landroid/content/Context;", "win", "Landroid/view/Window;", "<init>", "(Landroid/app/Application;Landroid/content/Context;Landroid/view/Window;)V", "token", "Landroid/os/IBinder;", "fakeComponentName", "Landroid/content/ComponentName;", "activityInfo", "Landroid/content/pm/ActivityInfo;", "currentIntent", "Landroid/content/Intent;", "lifecycleDispatcher", "Lcom/obric/assistant/interaction/impl/window/FakeActivityLifecycleDispatcher;", "fakeActivityResultRegistry", "Lcom/obric/assistant/interaction/impl/window/ChatWindowActivityResultRegistry;", "androidXFragmentsController", "Landroidx/fragment/app/FragmentController;", "getAndroidXFragmentsController", "()Landroidx/fragment/app/FragmentController;", "androidXFragmentsController$delegate", "Lkotlin/Lazy;", "stage", "Lcom/obric/assistant/interaction/impl/window/FakeActivityStage;", "platformHostAttached", "", "destroyedDispatched", "finishRequested", "contentRoot", "Landroid/view/ViewGroup;", "mainHandler", "Landroid/os/Handler;", "configureAppCompatForFakeWindow", "", "shouldIgnoreDecorToolbarCrash", "error", "", "bindCoreFields", "window", "activityToken", "windowManager", "Landroid/view/WindowManager;", "bindAndroidXFields", "ensurePlatformHostAttached", "attachContextCompat", "attachContextImpl", "buildActivityInfo", "ctx", "buildFakeComponentName", "buildFakeIntent", "resolveDefaultTheme", "", "bindContentRoot", "root", "Landroid/view/View;", "bindContentRoot$impl_mainlandRelease", "updateIntentExtras", "extras", "Landroid/os/Bundle;", "updateIntentExtras$impl_mainlandRelease", "mountChatFragment", "rootView", "Lcom/obric/assistant/interaction/impl/window/AssistantChatView;", "mountChatFragment$impl_mainlandRelease", "updateData", "updateData$impl_mainlandRelease", "buildChatBundleForWindow", "getChatFragment", "Landroidx/fragment/app/Fragment;", "findMountedChatFragment", "checkLifecycleState", "actionName", "", "expectedStates", "", "Landroidx/lifecycle/Lifecycle$State;", "(Ljava/lang/String;[Landroidx/lifecycle/Lifecycle$State;)V", "requireLifecycleDispatch", "event", "Landroidx/lifecycle/Lifecycle$Event;", "dispatched", "performCreate", "savedInstanceState", "performCreate$impl_mainlandRelease", "performStart", "performStart$impl_mainlandRelease", "performResume", "performResume$impl_mainlandRelease", "performPause", "performPause$impl_mainlandRelease", "performStop", "performStop$impl_mainlandRelease", "performDestroy", "performDestroy$impl_mainlandRelease", "performLifecycleAction", "action", "Lkotlin/Function0;", "reportLifecycleError", "dispatchActivityResultCompat", "requestCode", "resultCode", "data", "dispatchActivityResultCompat$impl_mainlandRelease", "startProxyActivity", "listener", "Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "getApplicationContext", "getComponentName", "getIntent", "setIntent", "newIntent", "getSystemService", "", "name", "getWindowManager", "getWindow", "getResources", "Landroid/content/res/Resources;", "getTheme", "Landroid/content/res/Resources$Theme;", "getPackageName", "getLayoutInflater", "Landroid/view/LayoutInflater;", "getSupportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "ensureDecorView", "onCreate", "onRestart", "onStart", "onResume", "onPause", "onStop", "onDestroy", "onPostResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchWindowConfigurationChanged", "dispatchWindowConfigurationChanged$impl_mainlandRelease", "onActivityResult", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "deviceId", "(I[Ljava/lang/String;[II)V", "canBeReusedByWindowHost", "canBeReusedByWindowHost$impl_mainlandRelease", "requestFinish", WindowEvent.Params.REASON, "finish", "finishAndRemoveTask", "finishAfterTransition", "finishAffinity", "finishFromChild", "child", "Landroid/app/Activity;", "startActivityForResult", MemorySourceLinkType.INTENT, "options", "startIntentSenderForResult", "Landroid/content/IntentSender;", "fillInIntent", "flagsMask", "flagsValues", "extraFlags", "startActivity", "startActivities", "intents", "([Landroid/content/Intent;)V", "([Landroid/content/Intent;Landroid/os/Bundle;)V", "shouldShowRequestPermissionRationale", "permission", "getVContext", "Lcom/larus/ui/arch/context/external/VContext;", "scene", "getTaskId", "getDisplay", "Landroid/view/Display;", "isTaskRoot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowActivity extends AppCompatActivity implements d4, h4, l4, IChatWindowActivity {
    private static final String CATEGORY_CHAT_WINDOW_LIFECYCLE_ERROR = "chat_window_lifecycle_error";
    public static final Companion Companion = null;
    private static final String DECOR_TOOLBAR_CRASH_PREFIX = "Can't make a decor toolbar out of";
    private static final String EVENT_OBRIC_APP_ERROR = "obric_app_error";
    public static final String TAG = "ChatWindowActivity";
    private final ActivityInfo activityInfo;
    private final Lazy androidXFragmentsController$delegate;
    private final Application app;
    private final Context baseCtx;
    private ViewGroup contentRoot;
    private Intent currentIntent;
    private boolean destroyedDispatched;
    private final ChatWindowActivityResultRegistry fakeActivityResultRegistry;
    private final ComponentName fakeComponentName;
    private boolean finishRequested;
    private final FakeActivityLifecycleDispatcher lifecycleDispatcher;
    private final Handler mainHandler;
    private boolean platformHostAttached;
    private FakeActivityStage stage;
    private final IBinder token;
    private Window win;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowActivity$Companion;", "", "<init>", "()V", "TAG", "", "DECOR_TOOLBAR_CRASH_PREFIX", "EVENT_OBRIC_APP_ERROR", "CATEGORY_CHAT_WINDOW_LIFECYCLE_ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ FragmentController A1(ChatWindowActivity r0) {
        return androidXFragmentsController_delegate$lambda$2(r0);
    }

    public static /* synthetic */ a B1(Bundle r0, a r1) {
        return updateData$lambda$32(r0, r1);
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ void access$001(AppCompatActivity r0, Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Activity fakeActivityResultRegistry$lambda$0(ChatWindowActivity r0) {
        return r0;
    }

    private final int resolveDefaultTheme(Context r1) {
        return 2131953696;
    }

    public static /* synthetic */ Activity y1(ChatWindowActivity r0) {
        return fakeActivityResultRegistry$lambda$0(r0);
    }

    public static /* synthetic */ void z1(ChatWindowActivity r0, String r1) {
        requestFinish$lambda$51(r0, r1);
    }

    public void finish() {
        com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public int getTaskId() {
        return 0;
    }

    public boolean isTaskRoot() {
        return true;
    }

    public void onCreate(Bundle r1) {
        com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onStop() {
        com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public String scene() {
        return "O";
    }

    private final void attachContextCompat() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(attachContextImpl()));     // Catch: Throwable -> L4
    L6:
        Boolean r2 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = r2;
    L10:
        if (((Boolean) r1).booleanValue() == true) goto L15;
        attachBaseContext(this.baseCtx);
        return;
    L15:
        return;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean attachContextImpl() {
        Object r2 = ChatWindowReflectionCompat.ActivityThreadRef.INSTANCE.current();
        ChatWindowReflectionCompat.LoadedApkRef r0 = ChatWindowReflectionCompat.LoadedApkRef.INSTANCE;
        Application r1 = this.app;
        Object r3 = r0.obtain(r1, r1.getApplicationContext());
        ChatWindowReflectionCompat.ContextImplRef r4 = ChatWindowReflectionCompat.ContextImplRef.INSTANCE;
        Context r5 = r4.createActivityContext(r2, r3, this.activityInfo, this.token, 0, null);
        if (r5 != null) goto L15;
        return false;
    L15:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L8
        r4.setOuterContext(r5, this);     // Catch: Throwable -> L8
        attachBaseContext(r5);     // Catch: Throwable -> L8
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L17;
        FLogger.a.e(TAG, "attachContextImpl failed", r8);
        return true;
    L17:
        return true;
    L8:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    private final void bindAndroidXFields() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setDeclaredFieldIfExists(this, ComponentActivity.class, "mActivityResultRegistry", this.fakeActivityResultRegistry);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setDeclaredFieldIfExists(this, ComponentActivity.class, "activityResultRegistry", this.fakeActivityResultRegistry);     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L12;
        FLogger.a.e(TAG, "bindAndroidXFields failed", r2);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    private final void configureAppCompatForFakeWindow() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(supportRequestWindowFeature(1)));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L19;
        FLogger.a.w(TAG, "supportRequestWindowFeature(NO_TITLE) failed", r2);
    L19:
        AppCompatDelegate r3 = getDelegate();     // Catch: Throwable -> L11
        Boolean r4 = Boolean.FALSE;     // Catch: Throwable -> L11
        ChatWindowActivityKt.access$setPrivateFieldOrLog(r3, "mHasActionBar", r4, TAG);     // Catch: Throwable -> L11
        ChatWindowActivityKt.access$setPrivateFieldOrLog(r3, "mOverlayActionBar", r4, TAG);     // Catch: Throwable -> L11
        ChatWindowActivityKt.access$setPrivateFieldOrLog(r3, "mWindowNoTitle", Boolean.TRUE, TAG);     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L21;
        FLogger.a.w(TAG, "configure AppCompat delegate failed", r6);
        return;
    L21:
        return;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    private final void ensurePlatformHostAttached() {
        if (this.platformHostAttached == false) goto L25;
        return;
    L25:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        Field r1 = ChatWindowActivityKt.access$findDeclaredField(Activity.class, "mFragments");     // Catch: Throwable -> L19
        if (r1 == null) goto L18;
        Object r2 = r1.get(this);     // Catch: Throwable -> L19
        if (r2 == null) goto L18;
        Method r3 = r2.getClass().getDeclaredMethod("getFragmentManager", new Class[0]);     // Catch: Throwable -> L19
        r3.setAccessible(true);     // Catch: Throwable -> L19
        Object r4 = r3.invoke(r2, new Object[0]);     // Catch: Throwable -> L19
        Field r5 = ChatWindowActivityKt.access$findDeclaredField(r4.getClass(), "mHost");     // Catch: Throwable -> L19
        if (r5 == null) goto L12;
        Object r6 = r5.get(r4);     // Catch: Throwable -> L19
    L13:
        if (r6 == null) goto L16;
        this.platformHostAttached = true;     // Catch: Throwable -> L19
        return;
    L16:
        Method r7 = r2.getClass().getDeclaredMethod("attachHost", new Class[]{INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.Fragment")});     // Catch: Throwable -> L19
        r7.setAccessible(true);     // Catch: Throwable -> L19
        r7.invoke(r2, new Object[]{null});     // Catch: Throwable -> L19
        this.platformHostAttached = true;     // Catch: Throwable -> L19
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L26;
        FLogger.a.e(TAG, "ensurePlatformHostAttached failed", r9);
        return;
    L26:
        return;
    L12:
        r6 = null;
    L18:
        throw new IllegalStateException("Activity#mFragments not found".toString());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    private final FragmentController getAndroidXFragmentsController() {
        return (FragmentController) this.androidXFragmentsController$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canBeReusedByWindowHost$impl_mainlandRelease() {
        if (this.finishRequested == false) goto L5;
    L9:
        return false;
    L5:
        if (isFinishing() == true) goto L9;
        if (isDestroyed() == true) goto L9;
        return true;
    }

    public void com_obric_assistant_interaction_impl_window_ChatWindowActivity__finish$___twin___() {
        requestFinish("finish");
    }

    public void com_obric_assistant_interaction_impl_window_ChatWindowActivity__onDestroy$___twin___() {
        FLogger.a.i(TAG, "onDestroy: " + this);
        super.onDestroy();
    }

    public void com_obric_assistant_interaction_impl_window_ChatWindowActivity__onStop$___twin___() {
        FLogger.a.i(TAG, "onStop: " + this);
        super.onStop();
    }

    public final View ensureDecorView() {
        return INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.win);
    }

    public void finishAffinity() {
        requestFinish("finishAffinity");
    }

    public void finishAfterTransition() {
        requestFinish("finishAfterTransition");
    }

    public void finishAndRemoveTask() {
        requestFinish("finishAndRemoveTask");
    }

    public Context getApplicationContext() {
        Context r0 = this.app.getApplicationContext();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.app;
    }

    public Display getDisplay() {
        Object r0 = getSystemService("display");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        return ((DisplayManager) r0).getDisplay(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutInflater getLayoutInflater() {
        Object r0 = super/*android.app.Activity*/.getSystemService("layout_inflater");
        if ((r0 instanceof LayoutInflater) == false) goto L5;
        LayoutInflater r1 = (LayoutInflater) r0;
    L6:
        if (r1 != null) goto L9;
        r1 = LayoutInflater.from(getBaseContext());
    L9:
        return r1.cloneInContext(this);
    L5:
        r1 = null;
        goto L6
    }

    public String getPackageName() {
        return this.baseCtx.getPackageName();
    }

    public Resources getResources() {
        return this.baseCtx.getResources();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Resources.Theme getTheme() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(super/*android.app.Activity*/.getTheme());     // Catch: Throwable -> L4
    L7:
        if (Result.exceptionOrNull-impl(r1) == null) goto L11;
        r1 = this.baseCtx.getTheme();
    L11:
        return (Resources.Theme) r1;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public WindowManager getWindowManager() {
        return this.win.getWindowManager();
    }

    public void onPause() {
        FLogger.a.i(TAG, "onPause: " + this);
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
    }

    public void onPostResume() {
        FLogger.a.i(TAG, "onPostResume: " + this);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        super.onPostResume();     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 != null) goto L10;
        return;
    L10:
        if (shouldIgnoreDecorToolbarCrash(r2) == false) goto L13;
        FLogger.a.w(TAG, "ignore decor toolbar init for fake window", r2);
        configureAppCompatForFakeWindow();
        return;
    L13:
        throw r2;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRestart() {
        FLogger.a.i(TAG, "onRestart: " + this);
        super/*android.app.Activity*/.onRestart();
    }

    public void onResume() {
        FLogger.a.i(TAG, "onResume: " + this);
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        SettingService.a.k();
    }

    public void onStart() {
        FLogger.a.i(TAG, "onStart: " + this);
        super.onStart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void performDestroy$impl_mainlandRelease() {
    L18:
        th = move-exception;
        FLogger.a.e(TAG, "performLifecycleAction performDestroy failed with error: " + th.getMessage(), th);
        reportLifecycleError("performDestroy", th);
        throw th;
    L4:
        if (this.destroyedDispatched == true) goto L23;
        FakeActivityStage r1 = this.stage;     // Catch: Throwable -> L18
        FakeActivityStage r2 = FakeActivityStage.DESTROYED;     // Catch: Throwable -> L18
        if (r1 != r2) goto L9;
        return;
    L9:
        if (r1 != FakeActivityStage.RESUMED) goto L11;
    L12:
        performStop$impl_mainlandRelease();     // Catch: Throwable -> L18
    L14:
        if (this.stage != FakeActivityStage.INITIALIZED) goto L16;
        this.stage = FakeActivityStage.CREATED;     // Catch: Throwable -> L18
    L16:
        checkLifecycleState("performDestroy", new Lifecycle.State[]{Lifecycle.State.INITIALIZED, Lifecycle.State.CREATED});     // Catch: Throwable -> L18
        this.lifecycleDispatcher.dispatchPreDestroy(this);     // Catch: Throwable -> L18
        Boolean r3 = Boolean.TRUE;     // Catch: Throwable -> L18
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mFinished", r3);     // Catch: Throwable -> L18
        onDestroy();     // Catch: Throwable -> L18
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mDestroyed", r3);     // Catch: Throwable -> L18
        requireLifecycleDispatch("performDestroy", Lifecycle.Event.ON_DESTROY, this.lifecycleDispatcher.dispatchDestroy(this));     // Catch: Throwable -> L18
        this.destroyedDispatched = true;     // Catch: Throwable -> L18
        this.stage = r2;     // Catch: Throwable -> L18
        return;
    L11:
        if (r1 != FakeActivityStage.STARTED) goto L14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void performPause$impl_mainlandRelease() {
    L8:
        th = move-exception;
        FLogger.a.e(TAG, "performLifecycleAction performPause failed with error: " + th.getMessage(), th);
        reportLifecycleError("performPause", th);
        throw th;
    L4:
        if (this.stage == FakeActivityStage.RESUMED) goto L6;
        return;
    L6:
        checkLifecycleState("performPause", new Lifecycle.State[]{Lifecycle.State.RESUMED});     // Catch: Throwable -> L8
        onPause();     // Catch: Throwable -> L8
        requireLifecycleDispatch("performPause", Lifecycle.Event.ON_PAUSE, this.lifecycleDispatcher.dispatchPause(this));     // Catch: Throwable -> L8
        this.stage = FakeActivityStage.STARTED;     // Catch: Throwable -> L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void performResume$impl_mainlandRelease() {
        FakeActivityStage r1 = this.stage;     // Catch: Throwable -> L17
        if (r1 == FakeActivityStage.DESTROYED) goto L22;
        FakeActivityStage r2 = FakeActivityStage.RESUMED;     // Catch: Throwable -> L17
        if (r1 != r2) goto L9;
        return;
    L9:
        if (r1 != FakeActivityStage.INITIALIZED) goto L11;
    L14:
        performStart$impl_mainlandRelease();     // Catch: Throwable -> L17
    L15:
        checkLifecycleState("performResume", new Lifecycle.State[]{Lifecycle.State.STARTED});     // Catch: Throwable -> L17
        onResume();     // Catch: Throwable -> L17
        onPostResume();     // Catch: Throwable -> L17
        requireLifecycleDispatch("performResume", Lifecycle.Event.ON_RESUME, this.lifecycleDispatcher.dispatchResume(this));     // Catch: Throwable -> L17
        this.stage = r2;     // Catch: Throwable -> L17
        return;
    L11:
        if (r1 == FakeActivityStage.CREATED) goto L14;
        if (r1 != FakeActivityStage.STOPPED) goto L15;
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.a.e(TAG, "performLifecycleAction performResume failed with error: " + th.getMessage(), th);
        reportLifecycleError("performResume", th);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void performStart$impl_mainlandRelease() {
        FakeActivityStage r1 = this.stage;     // Catch: Throwable -> L18
        if (r1 == FakeActivityStage.DESTROYED) goto L23;
        FakeActivityStage r2 = FakeActivityStage.STARTED;     // Catch: Throwable -> L18
        if (r1 != r2) goto L8;
        return;
    L8:
        if (r1 != FakeActivityStage.RESUMED) goto L11;
        return;
    L11:
        if (r1 != FakeActivityStage.INITIALIZED) goto L14;
        performCreate$impl_mainlandRelease(null);     // Catch: Throwable -> L18
    L14:
        if (this.stage != FakeActivityStage.STOPPED) goto L16;
        onRestart();     // Catch: Throwable -> L18
    L16:
        checkLifecycleState("performStart", new Lifecycle.State[]{Lifecycle.State.CREATED});     // Catch: Throwable -> L18
        onStart();     // Catch: Throwable -> L18
        requireLifecycleDispatch("performStart", Lifecycle.Event.ON_START, this.lifecycleDispatcher.dispatchStart(this));     // Catch: Throwable -> L18
        this.stage = r2;     // Catch: Throwable -> L18
        return;
    L23:
        return;
    L18:
        th = move-exception;
        FLogger.a.e(TAG, "performLifecycleAction performStart failed with error: " + th.getMessage(), th);
        reportLifecycleError("performStart", th);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void performStop$impl_mainlandRelease() {
        FakeActivityStage r1 = this.stage;     // Catch: Throwable -> L17
        if (r1 != FakeActivityStage.DESTROYED) goto L6;
        return;
    L6:
        if (r1 != FakeActivityStage.INITIALIZED) goto L8;
        return;
    L8:
        if (r1 == FakeActivityStage.CREATED) goto L24;
        FakeActivityStage r2 = FakeActivityStage.STOPPED;     // Catch: Throwable -> L17
        if (r1 != r2) goto L13;
        return;
    L13:
        if (r1 != FakeActivityStage.RESUMED) goto L15;
        performPause$impl_mainlandRelease();     // Catch: Throwable -> L17
    L15:
        checkLifecycleState("performStop", new Lifecycle.State[]{Lifecycle.State.STARTED});     // Catch: Throwable -> L17
        onStop();     // Catch: Throwable -> L17
        requireLifecycleDispatch("performStop", Lifecycle.Event.ON_STOP, this.lifecycleDispatcher.dispatchStop(this));     // Catch: Throwable -> L17
        this.stage = r2;     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L17:
        th = move-exception;
        FLogger.a.e(TAG, "performLifecycleAction performStop failed with error: " + th.getMessage(), th);
        reportLifecycleError("performStop", th);
        throw th;
    }

    private final Bundle buildChatBundleForWindow() {
        Bundle r0 = getIntent().getExtras();
        if (r0 == null) goto L6;
        Bundle r1 = r0.deepCopy();
        if (r1 == null) goto L6;
    L7:
        r1.putBoolean("O_WINDOW_CHAT", true);
        r1.putBoolean("disable_onboarding_tts", true);
        r1.putBoolean("isMultiWindowMode", true);
        r1.putParcelable("argChatBubbleParamsFromHost", new ChatBubbleParams(true, 6));
        return r1;
    L6:
        r1 = new Bundle();
        goto L7
    }

    private final Fragment findMountedChatFragment() {
        return (Fragment) CollectionsKt.firstOrNull(getSupportFragmentManager().getFragments());
    }

    @Override // com.obric.assistant.interaction.api.window.IChatWindowActivity
    public Fragment getChatFragment() {
        return findMountedChatFragment();
    }

    public FragmentManager getSupportFragmentManager() {
        return super/*androidx.fragment.app.FragmentActivity*/.getSupportFragmentManager();
    }

    public t1a.b getVContext() {
        Fragment r0 = (Fragment) CollectionsKt.firstOrNull(getSupportFragmentManager().getFragments());
        if (r0 != null) goto L7;
        return null;
    L7:
        return s1a.a.g(r0);
    }

    public final void updateData$impl_mainlandRelease() {
        Fragment r0 = findMountedChatFragment();
        if (r0 != null) goto L6;
        FLogger.a.w(TAG, "updateData skipped because chat fragment is not mounted");
        return;
    L6:
        final Bundle r1 = buildChatBundleForWindow();
        t1a.b r2 = s1a.a.g(r0);
        de8.c r3 = r2.a(de8.c.class);
        if (r3 == null) goto L14;
        Bundle r4 = r3.a;
        if (r4 == null) goto L11;
        r4.clear();
        r4.putAll(r1);
    L11:
        Bundle r5 = r3.b;
        if (r5 == null) goto L14;
        r5.clear();
        r5.putAll(r1);
    L14:
        t1a.e r6 = r2.e(a.class);
        if (r6 == null) goto L18;
        r6.a(new c(r1));
        return;
    }

    public ComponentName getComponentName() {
        return this.fakeComponentName;
    }

    public Intent getIntent() {
        return this.currentIntent;
    }

    public Window getWindow() {
        return this.win;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p(ChatWindowActivity r0) {
        return r0.mainHandler;
    }

    private static final FragmentController androidXFragmentsController_delegate$lambda$2(ChatWindowActivity r3) {
        Field r0 = ChatWindowActivityKt.access$findDeclaredField(FragmentActivity.class, "mFragments");
        FragmentController r1 = null;
        if (r0 == null) goto L5;
        Object r4 = r0.get(r3);
    L7:
        if ((r4 instanceof FragmentController) == false) goto L9;
        r1 = (FragmentController) r4;
    L9:
        if (r1 != null) goto L11;
        FLogger.a.w(TAG, "FragmentActivity#mFragments not found, noteStateNotSaved will be skipped");
    L11:
        return r1;
    L5:
        r4 = null;
        goto L7
    }

    private final ActivityInfo buildActivityInfo(Context r5) {
        ActivityInfo r0 = new ActivityInfo();
        r0.packageName = r5.getPackageName();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(r5.getPackageManager().getApplicationInfo(r5.getPackageName(), 0));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        Object r4 = r2;
        if (r3 == null) goto L11;
        ApplicationInfo r6 = new ApplicationInfo();
        r6.packageName = r5.getPackageName();
        r4 = r6;
    L11:
        r0.applicationInfo = (ApplicationInfo) r4;
        r0.theme = resolveDefaultTheme(r5);
        r0.name = this.fakeComponentName.getClassName();
        return r0;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final ComponentName buildFakeComponentName(Context r3) {
        return new ComponentName(r3.getPackageName(), ChatWindowActivity.class.getName());
    }

    private final Intent buildFakeIntent(Context r3) {
        Intent r0 = new Intent();
        r0.setComponent(this.fakeComponentName);
        r0.setPackage(r3.getPackageName());
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ChatWindowActivity r1) {
        r1.com_obric_assistant_interaction_impl_window_ChatWindowActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(ChatWindowActivity r0) {
        r0.com_obric_assistant_interaction_impl_window_ChatWindowActivity__finish$___twin___();
    }

    public static void com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(ChatWindowActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_obric_assistant_interaction_impl_window_ChatWindowActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    private final void requestFinish(final String r5) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "requestFinish reason=" + r5);
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mFinished", Boolean.TRUE);
        if (this.finishRequested == false) goto L6;
        r0.i(TAG, "requestFinish ignored, already requested");
        return;
    L6:
        this.finishRequested = true;
        this.mainHandler.post(new b(this, r5));
    }

    private final boolean shouldIgnoreDecorToolbarCrash(Throwable r6) {
        if ((r6 instanceof IllegalStateException) == false) goto L13;
        String r7 = r6.getMessage();
        if (r7 != null) goto L7;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (StringsKt.startsWith$default(r7, DECOR_TOOLBAR_CRASH_PREFIX, false, 2, null) != true) goto L9;
        r8 = true;
        goto L10
    L13:
        return false;
    }

    private final boolean startProxyActivity(ActivityProxyListener r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        IActivityResultHelperApi r1 = IActivityResultHelperApiKt.getActivityResultHelper();     // Catch: Throwable -> L8
        if (r1 != null) goto L5;
        boolean r5 = false;
    L6:
        Object r6 = Result.constructor-impl(Boolean.valueOf(r5));     // Catch: Throwable -> L8
    L10:
        Throwable r2 = Result.exceptionOrNull-impl(r6);
        if (r2 == null) goto L15;
        FLogger.a.e(TAG, "startProxyActivity failed", r2);
        r6 = Boolean.FALSE;
    L15:
        return ((Boolean) r6).booleanValue();
    L5:
        r1.startActivityForResult(r4);     // Catch: Throwable -> L8
        r5 = true;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void bindContentRoot$impl_mainlandRelease(View r2) {
        Intrinsics.checkNotNullParameter(r2, "root");
        if ((r2 instanceof ViewGroup) == false) goto L5;
        ViewGroup r3 = (ViewGroup) r2;
    L6:
        this.contentRoot = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }

    public void com_obric_assistant_interaction_impl_window_ChatWindowActivity__onCreate$___twin___(Bundle r6) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "onCreate: " + this);
        configureAppCompatForFakeWindow();
        boolean r1 = getIntent().getBooleanExtra("wakeup_assistant", false);
        r0.d(TAG, "handleWakeup: " + r1 + ", " + getIntent());
        ObricInteractDelegate.b.notifyWakeupEvent(r1);
        ensurePlatformHostAttached();
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r6);
    }

    public final void dispatchWindowConfigurationChanged$impl_mainlandRelease(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, new Configuration(r2));
    }

    public void finishFromChild(Activity r4) {
        FLogger.a.i(TAG, "finishFromChild child=" + r4);
        requestFinish("finishFromChild");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object getSystemService(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        if (Intrinsics.areEqual("window", r2) == false) goto L7;
        return this.win.getWindowManager();
    L7:
        if (Intrinsics.areEqual("layout_inflater", r2) == false) goto L17;
        Object r3 = super/*android.app.Activity*/.getSystemService(r2);
        if ((r3 instanceof LayoutInflater) == false) goto L11;
        LayoutInflater r4 = (LayoutInflater) r3;
    L12:
        if (r4 != null) goto L15;
        r4 = LayoutInflater.from(getBaseContext());
    L15:
        return r4.cloneInContext(this);
    L11:
        r4 = null;
        goto L12
    L17:
        return super/*android.app.Activity*/.getSystemService(r2);
    }

    public final void mountChatFragment$impl_mainlandRelease(AssistantChatView r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        if (findMountedChatFragment() == null) goto L5;
        return;
    L5:
        IFragmentProvider r0 = (IFragmentProvider) ServiceManager.get().getService(IFragmentProvider.class);
        if (r0 == null) goto L10;
        Fragment r1 = r0.e(buildChatBundleForWindow());
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(getSupportFragmentManager().beginTransaction(), r4.getFragmentContainerId$impl_mainlandRelease(), r1).commitNowAllowingStateLoss();
        sga.e.a(r4);
        return;
    L10:
        throw new IllegalStateException("IFragmentProvider.getService returned null".toString());
    }

    public void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        FragmentController r0 = getAndroidXFragmentsController();
        if (r0 == null) goto L5;
        r0.noteStateNotSaved();
    L5:
        INVOKESPECIAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void performCreate$impl_mainlandRelease(Bundle r5) {
    L8:
        th = move-exception;
        FLogger.a.e(TAG, "performLifecycleAction performCreate failed with error: " + th.getMessage(), th);
        reportLifecycleError("performCreate", th);
        throw th;
    L4:
        if (this.stage == FakeActivityStage.INITIALIZED) goto L6;
        return;
    L6:
        checkLifecycleState("performCreate", new Lifecycle.State[]{Lifecycle.State.INITIALIZED});     // Catch: Throwable -> L8
        onCreate(r5);     // Catch: Throwable -> L8
        requireLifecycleDispatch("performCreate", Lifecycle.Event.ON_CREATE, this.lifecycleDispatcher.dispatchCreate(this, r5));     // Catch: Throwable -> L8
        this.stage = FakeActivityStage.CREATED;     // Catch: Throwable -> L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setIntent(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "newIntent");
        this.currentIntent = r2;
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mIntent", r2);
        super/*android.app.Activity*/.setIntent(r2);
    }

    public boolean shouldShowRequestPermissionRationale(String r3) {
        Intrinsics.checkNotNullParameter(r3, "permission");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Boolean.valueOf(com_obric_assistant_interaction_impl_window_ChatWindowActivity_androidx_appcompat_app_AppCompatActivity_shouldShowRequestPermissionRationale_super(this, r3)));     // Catch: Throwable -> L5
    L7:
        Boolean r1 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L11;
        r4 = r1;
    L11:
        return ((Boolean) r4).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivities(Intent[] r5) {
        if (r5 != null) goto L15;
        return;
    L15:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        int r1 = r5.length;     // Catch: Throwable -> L9
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r5[r2].addFlags(268435456);     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        getBaseContext().startActivities(r5);     // Catch: Throwable -> L9
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L18;
        FLogger.a.e(TAG, "startActivities failed", r7);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public void startActivity(Intent r2) {
        startActivity(r2, null);
    }

    public final void updateIntentExtras$impl_mainlandRelease(Bundle r3) {
        Intent r0 = new Intent(this.currentIntent);
        if (r3 == null) goto L5;
        Bundle r1 = new Bundle(r3);
    L6:
        r0.replaceExtras(r1);
        setIntent(r0);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void INVOKESPECIAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(AppCompatActivity r3, Configuration r4) {
        access$001(r3, r4);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L22;
        int r2 = r3.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r4 == null) goto L8;
        Integer r5 = Integer.valueOf(r4.orientation);     // Catch: Throwable -> L17
    L9:
        if (r5 != null) goto L12;
    L14:
        if (r2 != 3) goto L24;
        r3.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r3.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r5.intValue() != r2) goto L14;
        return;
    L8:
        r5 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(ChatWindowActivity r3, Configuration r4) {
        r3.onConfigurationChanged(r4);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L22;
        int r1 = r3.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r4 == null) goto L8;
        Integer r5 = Integer.valueOf(r4.orientation);     // Catch: Throwable -> L17
    L9:
        if (r5 != null) goto L12;
    L14:
        if (r1 != 3) goto L24;
        r3.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:ChatWindowActivity portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r5.intValue() != r1) goto L14;
        return;
    L8:
        r5 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    public static final /* synthetic */ boolean access$startProxyActivity(ChatWindowActivity r0, ActivityProxyListener r1) {
        return r0.startProxyActivity(r1);
    }

    private final void checkLifecycleState(String r13, Lifecycle.State... r14) {
        Lifecycle.State r0 = getLifecycle().getCurrentState();
        if (ArraysKt.contains(r14, r0) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("ChatWindowActivity " + r13 + " invalid lifecycle state, expected=" + ArraysKt.joinToString$default(r14, null, null, null, 0, null, null, 63, null) + ", actual=" + r0 + ", activity=" + this);
    }

    private static boolean com_obric_assistant_interaction_impl_window_ChatWindowActivity_androidx_appcompat_app_AppCompatActivity_shouldShowRequestPermissionRationale_super(AppCompatActivity r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b("auto_cert_com_obric_assistant_interaction_impl_window_ChatWindowActivity_androidx_appcompat_app_AppCompatActivity_shouldShowRequestPermissionRationale_super");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102609);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102609, "androidx/appcompat/app/AppCompatActivity", "shouldShowRequestPermissionRationale", r18, r1, "boolean", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Boolean) r4.b).booleanValue();
    L21:
        return super/*android.app.Activity*/.shouldShowRequestPermissionRationale(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(ChatWindowActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(r1) == false) goto L8;
        v19.f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_obric_assistant_interaction_impl_window_ChatWindowActivity__onCreate$___twin___(r2);
    }

    private final void performLifecycleAction(String r4, Function0<Unit> r5) {
        r5.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        FLogger.a.e(TAG, "performLifecycleAction " + r4 + " failed with error: " + th.getMessage(), th);
        reportLifecycleError(r4, th);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void reportLifecycleError(String r3, Throwable r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put("action", r3);     // Catch: Throwable -> L7
        r1.put("activity", toString());     // Catch: Throwable -> L7
        r1.put("error", r4.getClass().getName());     // Catch: Throwable -> L7
        String r2 = r4.getMessage();     // Catch: Throwable -> L7
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.put("message", r2);     // Catch: Throwable -> L7
        r1.put("stacktrace", ExceptionsKt.stackTraceToString(r4));     // Catch: Throwable -> L7
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L7
        r5.put("category", CATEGORY_CHAT_WINDOW_LIFECYCLE_ERROR);     // Catch: Throwable -> L7
        ApmAgent.monitorEvent(EVENT_OBRIC_APP_ERROR, r5, null, r1);     // Catch: Throwable -> L7
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L15;
        FLogger.a.e(TAG, "reportLifecycleError failed", r7);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    private static final void requestFinish$lambda$51(ChatWindowActivity r1, String r2) {
        WindowHost.INSTANCE.dismissWithReasonIfCurrent(r1, r2);
    }

    private static final a updateData$lambda$32(Bundle r1, a r2) {
        Intrinsics.checkNotNullParameter(r2, "resultFirstData");
        Bundle r0 = new Bundle(r1);
        r2.getClass();
        return new a(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivities(Intent[] r5, Bundle r6) {
        if (r5 != null) goto L15;
        return;
    L15:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        int r1 = r5.length;     // Catch: Throwable -> L9
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r5[r2].addFlags(268435456);     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        getBaseContext().startActivities(r5, r6);     // Catch: Throwable -> L9
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L18;
        FLogger.a.e(TAG, "startActivities(options) failed", r8);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivity(Intent r3, Bundle r4) {
        if (r3 != null) goto L12;
        return;
    L12:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        r3.addFlags(268435456);     // Catch: Throwable -> L6
        getBaseContext().startActivity(r3, r4);     // Catch: Throwable -> L6
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L14;
        FLogger.a.e(TAG, "startActivity failed", r6);
        return;
    L14:
        return;
    L6:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public ChatWindowActivity(Application r2, Context r3, Window r4) {
        Intrinsics.checkNotNullParameter(r2, "app");
        Intrinsics.checkNotNullParameter(r3, "baseCtx");
        Intrinsics.checkNotNullParameter(r4, "win");
        this.app = r2;
        this.baseCtx = r3;
        this.win = r4;
        this.token = new Binder();
        this.fakeComponentName = buildFakeComponentName(r3);
        this.activityInfo = buildActivityInfo(r3);
        this.currentIntent = buildFakeIntent(r3);
        this.lifecycleDispatcher = new FakeActivityLifecycleDispatcher();
        this.fakeActivityResultRegistry = new ChatWindowActivityResultRegistry(new d(this), new ChatWindowActivity$fakeActivityResultRegistry$2(this));
        this.androidXFragmentsController$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new e(this));
        this.stage = FakeActivityStage.INITIALIZED;
        this.mainHandler = new Handler(Looper.getMainLooper());
        FLogger.a.i(TAG, "ChatWindowActivity init win=" + this.win + " token=" + this.win.getAttributes().token);
        attachContextCompat();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        setTheme(2131953696);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L13:
        v19.f.a(getTheme());     // Catch: Throwable -> L9
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Window r6 = this.win;
        bindCoreFields(r6, this.token, r6.getWindowManager());
        configureAppCompatForFakeWindow();
        bindAndroidXFields();
        ensurePlatformHostAttached();
        Boolean r7 = Boolean.FALSE;
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mFinished", r7);
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mDestroyed", r7);
        return;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.add(r3, r4);
    }

    private final void bindCoreFields(Window r3, IBinder r4, WindowManager r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldSafely(this, "mApplication", this.app);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldSafely(this, "mWindow", r3);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mWindowManager", r5);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mToken", r4);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mActivityInfo", this.activityInfo);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mComponent", this.fakeComponentName);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mIntent", this.currentIntent);     // Catch: Throwable -> L4
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L25;
        FLogger.a.e(TAG, "bindCoreFields failed", r7);
    L25:
        ChatWindowReflectionCompat.ActivityThreadRef r8 = ChatWindowReflectionCompat.ActivityThreadRef.INSTANCE;     // Catch: Throwable -> L17
        Object r9 = r8.current();     // Catch: Throwable -> L17
        if (r9 == null) goto L12;
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mMainThread", r9);     // Catch: Throwable -> L17
    L12:
        Instrumentation r10 = r8.instrumentation(r9);     // Catch: Throwable -> L17
        if (r10 == null) goto L15;
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mInstrumentation", r10);     // Catch: Throwable -> L17
    L15:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L27;
        FLogger.a.e(TAG, "bindCoreFields instrumentation failed", r12);
        return;
    L27:
        return;
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    private final void requireLifecycleDispatch(String r3, Lifecycle.Event r4, boolean r5) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException("ChatWindowActivity " + r3 + " failed to dispatch " + r4 + ", stage=" + this.stage + ", lifecycle=" + getLifecycle().getCurrentState() + ", activity=" + this);
    }

    public final boolean dispatchActivityResultCompat$impl_mainlandRelease(int r2, int r3, Intent r4) {
        return this.fakeActivityResultRegistry.dispatchRawResult(r2, r3, r4);
    }

    public void onActivityResult(int r3, int r4, Intent r5) {
        FragmentController r0 = getAndroidXFragmentsController();
        if (r0 == null) goto L6;
        r0.noteStateNotSaved();
    L6:
        if (this.fakeActivityResultRegistry.dispatchRawResult(r3, r4, r5) == false) goto L8;
        return;
    L8:
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r3, r4, r5);
        if (r5 == null) goto L19;
        Bundle r6 = r5.getExtras();
        if (r6 == null) goto L20;
        xe8.a r1 = getChatFragment();
        if ((r1 instanceof xe8.a) == false) goto L15;
        xe8.a r2 = r1;
    L16:
        if (r2 == null) goto L21;
        r2.Lc(r6, r3, r4);
        return;
    L21:
        return;
    L15:
        r2 = null;
        goto L16
    L20:
        return;
    }

    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r3, "permissions");
        Intrinsics.checkNotNullParameter(r4, "grantResults");
        FragmentController r0 = getAndroidXFragmentsController();
        if (r0 == null) goto L5;
        r0.noteStateNotSaved();
    L5:
        com_obric_assistant_interaction_impl_window_ChatWindowActivity_androidx_appcompat_app_AppCompatActivity_onRequestPermissionsResult_super(this, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivityForResult(Intent r4, int r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        ChatWindowActivity$startActivityForResult$listener$1 r0 = new ChatWindowActivity$startActivityForResult$listener$1(r5, this, r4, r6);
        if (startProxyActivity(r0) == false) goto L5;
        return;
    L5:
        if (r0.getProxyTerminalGate().tryComplete() == true) goto L7;
        return;
    L7:
        FLogger.a.w(TAG, "startActivityForResult fallback to Context.startActivity, requestCode=" + r5);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L10
        r4.addFlags(268435456);     // Catch: Throwable -> L10
        getBaseContext().startActivity(r4, r6);     // Catch: Throwable -> L10
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L19;
        FLogger.a.e(TAG, "startActivityForResult fallback failed", r9);
        return;
    L19:
        return;
    L10:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    private static void com_obric_assistant_interaction_impl_window_ChatWindowActivity_androidx_appcompat_app_AppCompatActivity_onRequestPermissionsResult_super(AppCompatActivity r18, int r19, String[] r20, int[] r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19), r20, r21};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102611);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102611, "androidx/appcompat/app/AppCompatActivity", "onRequestPermissionsResult", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        super/*androidx.fragment.app.FragmentActivity*/.onRequestPermissionsResult(r19, r20, r21);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static void com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_ChatWindowActivity_onRequestPermissionsResult(ChatWindowActivity r18, int r19, String[] r20, int[] r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19), r20, r21};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102611);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102611, "com/obric/assistant/interaction/impl/window/ChatWindowActivity", "onRequestPermissionsResult", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.onRequestPermissionsResult(r19, r20, r21);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public void onRequestPermissionsResult(int r1, String[] r2, int[] r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        Intrinsics.checkNotNullParameter(r3, "grantResults");
        com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_ChatWindowActivity_onRequestPermissionsResult(this, r1, r2, r3);
    }

    @Deprecated(message = "Window fake activity still requires a proxy activity to deliver IntentSender results reliably")
    public void startIntentSenderForResult(IntentSender r11, int r12, Intent r13, int r14, int r15, int r16, Bundle r17) {
        Intrinsics.checkNotNullParameter(r11, MemorySourceLinkType.INTENT);
        ChatWindowActivity$startIntentSenderForResult$listener$1 r0 = new ChatWindowActivity$startIntentSenderForResult$listener$1(r12, this, r11, r13, r14, r15, r16, r17);
        if (startProxyActivity(r0) == true) goto L6;
        r0.completeCancelOnce("startIntentSenderForResult ignored because proxy unavailable, requestCode=" + r12, null);
        return;
    }
}
