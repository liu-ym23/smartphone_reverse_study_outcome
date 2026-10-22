package com.ss.android.lark.integrator.todo;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.integrator.todo.dependency.TodoTimeFormatDependency;
import com.ss.android.lark.integrator.todo.dependency.b;
import com.ss.android.lark.integrator.todo.dependency.c;
import com.ss.android.lark.integrator.todo.dependency.d;
import com.ss.android.lark.integrator.todo.dependency.e;
import com.ss.android.lark.integrator.todo.dependency.f;
import com.ss.android.lark.integrator.todo.dependency.g;
import com.ss.android.lark.integrator.todo.dependency.h;
import com.ss.android.lark.integrator.todo.dependency.i;
import com.ss.android.lark.integrator.todo.dependency.j;
import com.ss.android.lark.integrator.todo.dependency.k;
import com.ss.android.lark.integrator.todo.dependency.l;
import com.ss.android.lark.integrator.todo.dependency.m;
import com.ss.android.lark.integrator.todo.dependency.n;
import com.ss.android.lark.integrator.todo.dependency.o;
import com.ss.android.lark.integrator.todo.dependency.p;
import com.ss.android.lark.integrator.todo.dependency.q;
import com.ss.android.lark.integrator.todo.dependency.r;
import com.ss.android.lark.integrator.todo.dependency.s;
import com.ss.android.lark.integrator.todo.dependency.t;
import com.ss.android.lark.integrator.todo.dependency.u;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.todo.dependency.a;
import g7c.v;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(a.class)
@Metadata(d1 = {"\u0000À\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010s\u001a\u00020tH\u0016J\b\u0010u\u001a\u00020vH\u0016J\b\u0010w\u001a\u00020xH\u0016J\b\u0010y\u001a\u00020zH\u0016J\b\u0010{\u001a\u00020|H\u0016J\b\u0010}\u001a\u00020~H\u0016J\t\u0010\u007f\u001a\u00030\u0080\u0001H\u0016J\n\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\n\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\n\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016J\n\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0016J\n\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016J\n\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0016J\n\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0016J\n\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0016J\n\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0016J\n\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J\n\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0016J\n\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0016J\n\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0016J\n\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\t\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b4\u00105R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\t\u001a\u0004\b9\u0010:R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\t\u001a\u0004\b>\u0010?R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bC\u0010DR\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\t\u001a\u0004\bH\u0010IR\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\t\u001a\u0004\bM\u0010NR\u001b\u0010P\u001a\u00020Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\t\u001a\u0004\bR\u0010SR\u001b\u0010U\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\t\u001a\u0004\bW\u0010XR\u001b\u0010Z\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\t\u001a\u0004\b\\\u0010]R\u001b\u0010_\u001a\u00020`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\t\u001a\u0004\ba\u0010bR\u001b\u0010d\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\t\u001a\u0004\bf\u0010gR\u001b\u0010i\u001a\u00020j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\t\u001a\u0004\bk\u0010lR\u001b\u0010n\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\t\u001a\u0004\bp\u0010q¨\u0006\u009f\u0001"}, d2 = {"Lcom/ss/android/lark/integrator/todo/TodoOfficeDependency;", "Lcom/ss/android/lark/todo/dependency/ITodoDependency;", "<init>", "()V", "setting", "Lcom/ss/android/lark/integrator/todo/dependency/TodoSetting;", "getSetting", "()Lcom/ss/android/lark/integrator/todo/dependency/TodoSetting;", "setting$delegate", "Lkotlin/Lazy;", "timeFormat", "Lcom/ss/android/lark/integrator/todo/dependency/TodoTimeFormatDependency;", "getTimeFormat", "()Lcom/ss/android/lark/integrator/todo/dependency/TodoTimeFormatDependency;", "timeFormat$delegate", IImBrowserService.LINK_SCENE_MESSENGER, "Lcom/ss/android/lark/integrator/todo/dependency/MessengerDependency;", "getMessenger", "()Lcom/ss/android/lark/integrator/todo/dependency/MessengerDependency;", "messenger$delegate", "login", "Lcom/ss/android/lark/integrator/todo/dependency/TodoLogin;", "getLogin", "()Lcom/ss/android/lark/integrator/todo/dependency/TodoLogin;", "login$delegate", "fg", "Lcom/ss/android/lark/integrator/todo/dependency/TodoFeatureGating;", "getFg", "()Lcom/ss/android/lark/integrator/todo/dependency/TodoFeatureGating;", "fg$delegate", "browser", "Lcom/ss/android/lark/integrator/todo/dependency/TodoBrowser;", "getBrowser", "()Lcom/ss/android/lark/integrator/todo/dependency/TodoBrowser;", "browser$delegate", "language", "Lcom/ss/android/lark/integrator/todo/dependency/TodoLanguage;", "getLanguage", "()Lcom/ss/android/lark/integrator/todo/dependency/TodoLanguage;", "language$delegate", "emoji", "Lcom/ss/android/lark/integrator/todo/dependency/TodoEmoji;", "getEmoji", "()Lcom/ss/android/lark/integrator/todo/dependency/TodoEmoji;", "emoji$delegate", "ccm", "Lcom/ss/android/lark/integrator/todo/dependency/TodoCCMDependency;", "getCcm", "()Lcom/ss/android/lark/integrator/todo/dependency/TodoCCMDependency;", "ccm$delegate", "core", "Lcom/ss/android/lark/integrator/todo/dependency/CoreModuleDependency;", "getCore", "()Lcom/ss/android/lark/integrator/todo/dependency/CoreModuleDependency;", "core$delegate", LoadParams.ImageFormat.IMAGE, "Lcom/ss/android/lark/integrator/todo/dependency/ImageDependency;", "getImage", "()Lcom/ss/android/lark/integrator/todo/dependency/ImageDependency;", "image$delegate", "push", "Lcom/ss/android/lark/integrator/todo/dependency/PushDependency;", "getPush", "()Lcom/ss/android/lark/integrator/todo/dependency/PushDependency;", "push$delegate", "zenMode", "Lcom/ss/android/lark/integrator/todo/dependency/ZenModeDependency;", "getZenMode", "()Lcom/ss/android/lark/integrator/todo/dependency/ZenModeDependency;", "zenMode$delegate", "appLifeCycle", "Lcom/ss/android/lark/integrator/todo/dependency/AppLifeCycleDependency;", "getAppLifeCycle", "()Lcom/ss/android/lark/integrator/todo/dependency/AppLifeCycleDependency;", "appLifeCycle$delegate", "statistics", "Lcom/ss/android/lark/integrator/todo/dependency/StatisticsDependency;", "getStatistics", "()Lcom/ss/android/lark/integrator/todo/dependency/StatisticsDependency;", "statistics$delegate", "accountChange", "Lcom/ss/android/lark/integrator/todo/dependency/AccountChangeDependency;", "getAccountChange", "()Lcom/ss/android/lark/integrator/todo/dependency/AccountChangeDependency;", "accountChange$delegate", "common", "Lcom/ss/android/lark/integrator/todo/dependency/CommonDependency;", "getCommon", "()Lcom/ss/android/lark/integrator/todo/dependency/CommonDependency;", "common$delegate", "chat", "Lcom/ss/android/lark/integrator/todo/dependency/TodoChatDependency;", "getChat", "()Lcom/ss/android/lark/integrator/todo/dependency/TodoChatDependency;", "chat$delegate", LocationHitPoint$ResultType.SEARCH, "Lcom/ss/android/lark/integrator/todo/dependency/SearchDependency;", "getSearch", "()Lcom/ss/android/lark/integrator/todo/dependency/SearchDependency;", "search$delegate", "main", "Lcom/ss/android/lark/integrator/todo/dependency/MainModuleDependency;", "getMain", "()Lcom/ss/android/lark/integrator/todo/dependency/MainModuleDependency;", "main$delegate", "appConfig", "Lcom/ss/android/lark/integrator/todo/dependency/AppConfigDependency;", "getAppConfig", "()Lcom/ss/android/lark/integrator/todo/dependency/AppConfigDependency;", "appConfig$delegate", "urlPreview", "Lcom/ss/android/lark/integrator/todo/dependency/UrlPreviewDependency;", "getUrlPreview", "()Lcom/ss/android/lark/integrator/todo/dependency/UrlPreviewDependency;", "urlPreview$delegate", "settingDependency", "Lcom/ss/android/lark/todo/dependency/idependency/ISettingDependency;", "timeFormatDependency", "Lcom/ss/android/lark/todo/dependency/idependency/ITimeFormatDependency;", "messengerModuleDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IMessengerDependency;", "loginDependency", "Lcom/ss/android/lark/todo/dependency/idependency/ILoginDependency;", "featureGatingDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IFeatureGatingDependency;", "browserDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IBrowserModuleDependency;", "languageDependency", "Lcom/ss/android/lark/todo/dependency/idependency/ILanguageDependency;", "emojiDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IEmojiDependency;", "coreModuleDependency", "Lcom/ss/android/lark/todo/dependency/idependency/ICoreModuleDependency;", "imageDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IImageDependency;", "pushDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IPushDependency;", "zenModeDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IZenModeDependency;", "appLifeCycleDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IAppLifeCycleDependency;", "statisticsDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IStatisticsDependency;", "accountChangeDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IAccountChangeDependency;", "commonDependency", "Lcom/ss/android/lark/todo/dependency/idependency/ICommonDependency;", "chatModuleDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IChatModuleDependency;", "searchDependency", "Lcom/ss/android/lark/todo/dependency/idependency/ISearchModuleDependency;", "mainModuleDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IMainModuleDependency;", "appConfigDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IAppConfigDependency;", "urlPreviewDependency", "Lcom/ss/android/lark/todo/dependency/idependency/IUrlPreviewModuleDependency;", "ccmDependency", "Lcom/ss/android/lark/todo/dependency/idependency/ICCMDependency;", "todo-office-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class TodoOfficeDependency implements a {
    private final Lazy accountChange$delegate;
    private final Lazy appConfig$delegate;
    private final Lazy appLifeCycle$delegate;
    private final Lazy browser$delegate;
    private final Lazy ccm$delegate;
    private final Lazy chat$delegate;
    private final Lazy common$delegate;
    private final Lazy core$delegate;
    private final Lazy emoji$delegate;
    private final Lazy fg$delegate;
    private final Lazy image$delegate;
    private final Lazy language$delegate;
    private final Lazy login$delegate;
    private final Lazy main$delegate;
    private final Lazy messenger$delegate;
    private final Lazy push$delegate;
    private final Lazy search$delegate;
    private final Lazy setting$delegate;
    private final Lazy statistics$delegate;
    private final Lazy timeFormat$delegate;
    private final Lazy urlPreview$delegate;
    private final Lazy zenMode$delegate;

    private final com.ss.android.lark.integrator.todo.dependency.a getAccountChange() {
        return (com.ss.android.lark.integrator.todo.dependency.a) this.accountChange$delegate.getValue();
    }

    private final b getAppConfig() {
        return (b) this.appConfig$delegate.getValue();
    }

    private final c getAppLifeCycle() {
        return (c) this.appLifeCycle$delegate.getValue();
    }

    private final l getBrowser() {
        return (l) this.browser$delegate.getValue();
    }

    private final m getCcm() {
        return (m) this.ccm$delegate.getValue();
    }

    private final n getChat() {
        return (n) this.chat$delegate.getValue();
    }

    private final d getCommon() {
        return (d) this.common$delegate.getValue();
    }

    private final e getCore() {
        return (e) this.core$delegate.getValue();
    }

    private final o getEmoji() {
        return (o) this.emoji$delegate.getValue();
    }

    private final p getFg() {
        return (p) this.fg$delegate.getValue();
    }

    private final f getImage() {
        return (f) this.image$delegate.getValue();
    }

    private final q getLanguage() {
        return (q) this.language$delegate.getValue();
    }

    private final r getLogin() {
        return (r) this.login$delegate.getValue();
    }

    private final g getMain() {
        return (g) this.main$delegate.getValue();
    }

    private final h getMessenger() {
        return (h) this.messenger$delegate.getValue();
    }

    private final i getPush() {
        return (i) this.push$delegate.getValue();
    }

    private final j getSearch() {
        return (j) this.search$delegate.getValue();
    }

    private final s getSetting() {
        return (s) this.setting$delegate.getValue();
    }

    private final k getStatistics() {
        return (k) this.statistics$delegate.getValue();
    }

    private final TodoTimeFormatDependency getTimeFormat() {
        return (TodoTimeFormatDependency) this.timeFormat$delegate.getValue();
    }

    private final t getUrlPreview() {
        return (t) this.urlPreview$delegate.getValue();
    }

    private final u getZenMode() {
        return (u) this.zenMode$delegate.getValue();
    }

    public TodoOfficeDependency() {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.setting$delegate = LazyKt.lazy(r0, TodoOfficeDependency$setting$2.INSTANCE);
        this.timeFormat$delegate = LazyKt.lazy(r0, TodoOfficeDependency$timeFormat$2.INSTANCE);
        this.messenger$delegate = LazyKt.lazy(r0, TodoOfficeDependency$messenger$2.INSTANCE);
        this.login$delegate = LazyKt.lazy(r0, TodoOfficeDependency$login$2.INSTANCE);
        this.fg$delegate = LazyKt.lazy(r0, TodoOfficeDependency$fg$2.INSTANCE);
        this.browser$delegate = LazyKt.lazy(r0, TodoOfficeDependency$browser$2.INSTANCE);
        this.language$delegate = LazyKt.lazy(r0, TodoOfficeDependency$language$2.INSTANCE);
        this.emoji$delegate = LazyKt.lazy(r0, TodoOfficeDependency$emoji$2.INSTANCE);
        this.ccm$delegate = LazyKt.lazy(r0, TodoOfficeDependency$ccm$2.INSTANCE);
        this.core$delegate = LazyKt.lazy(r0, TodoOfficeDependency$core$2.INSTANCE);
        this.image$delegate = LazyKt.lazy(r0, TodoOfficeDependency$image$2.INSTANCE);
        this.push$delegate = LazyKt.lazy(r0, TodoOfficeDependency$push$2.INSTANCE);
        this.zenMode$delegate = LazyKt.lazy(r0, TodoOfficeDependency$zenMode$2.INSTANCE);
        this.appLifeCycle$delegate = LazyKt.lazy(r0, TodoOfficeDependency$appLifeCycle$2.INSTANCE);
        this.statistics$delegate = LazyKt.lazy(r0, TodoOfficeDependency$statistics$2.INSTANCE);
        this.accountChange$delegate = LazyKt.lazy(r0, TodoOfficeDependency$accountChange$2.INSTANCE);
        this.common$delegate = LazyKt.lazy(r0, TodoOfficeDependency$common$2.INSTANCE);
        this.chat$delegate = LazyKt.lazy(r0, TodoOfficeDependency$chat$2.INSTANCE);
        this.search$delegate = LazyKt.lazy(r0, TodoOfficeDependency$search$2.INSTANCE);
        this.main$delegate = LazyKt.lazy(r0, TodoOfficeDependency$main$2.INSTANCE);
        this.appConfig$delegate = LazyKt.lazy(r0, TodoOfficeDependency$appConfig$2.INSTANCE);
        this.urlPreview$delegate = LazyKt.lazy(r0, TodoOfficeDependency$urlPreview$2.INSTANCE);
    }

    public g7c.a accountChangeDependency() {
        return getAccountChange();
    }

    public g7c.b appConfigDependency() {
        return getAppConfig();
    }

    public g7c.c appLifeCycleDependency() {
        return getAppLifeCycle();
    }

    public g7c.d browserDependency() {
        return getBrowser();
    }

    public g7c.e ccmDependency() {
        return getCcm();
    }

    public g7c.f chatModuleDependency() {
        return getChat();
    }

    public g7c.g commonDependency() {
        return getCommon();
    }

    public g7c.h coreModuleDependency() {
        return getCore();
    }

    public g7c.i emojiDependency() {
        return getEmoji();
    }

    public g7c.j featureGatingDependency() {
        return getFg();
    }

    public g7c.k imageDependency() {
        return getImage();
    }

    public g7c.l languageDependency() {
        return getLanguage();
    }

    public g7c.m loginDependency() {
        return getLogin();
    }

    public g7c.n mainModuleDependency() {
        return getMain();
    }

    public g7c.o messengerModuleDependency() {
        return getMessenger();
    }

    public g7c.p pushDependency() {
        return getPush();
    }

    public g7c.q searchDependency() {
        return getSearch();
    }

    public g7c.r settingDependency() {
        return getSetting();
    }

    public g7c.s statisticsDependency() {
        return getStatistics();
    }

    public g7c.t timeFormatDependency() {
        return getTimeFormat();
    }

    public g7c.u urlPreviewDependency() {
        return getUrlPreview();
    }

    public v zenModeDependency() {
        return getZenMode();
    }
}
