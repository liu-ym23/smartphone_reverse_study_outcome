package com.ss.android.lark.flow.chat.titlebar;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowTitleBar;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.biz.im.api.n1;
import com.ss.android.lark.biz.im.api.o1;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarModelFactory;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.PageUserStatusUrlPreviewViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin$centerViewProvider$2;
import com.ss.android.lark.flow.chat.titlebar.view.BadgeBackView;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadTitleBarPlugin$onCreate$2;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.ui.TitleBarIconSize;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.f0;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000Á\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007*\u00017\b\u0007\u0018\u0000 º\u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\b·\u0001¸\u0001¹\u0001º\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010H\u001a\u00020=H\u0016¢\u0006\u0002\u0010?J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020JH\u0016J\b\u0010L\u001a\u00020JH\u0016J\b\u0010M\u001a\u00020NH\u0016J\n\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Q\u001a\u00020JH\u0016J\b\u0010R\u001a\u00020JH\u0016J\b\u0010S\u001a\u00020JH\u0016J\b\u0010T\u001a\u00020JH\u0016J\u0010\u0010U\u001a\u00020J2\u0006\u0010V\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020J2\u0006\u0010Y\u001a\u00020ZH\u0016J\u000e\u0010[\u001a\u00020J2\u0006\u0010\\\u001a\u00020]J\u0010\u0010^\u001a\u00020J2\u0006\u0010_\u001a\u00020\u0012H\u0016J\n\u0010`\u001a\u0004\u0018\u00010NH\u0016J\n\u0010a\u001a\u0004\u0018\u00010PH\u0016J\n\u0010b\u001a\u0004\u0018\u00010PH\u0016J\n\u0010c\u001a\u0004\u0018\u00010NH\u0016J\u0010\u0010d\u001a\u00020J2\u0006\u0010e\u001a\u00020PH\u0016J\u0010\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020=H\u0016J\u0010\u0010h\u001a\u00020J2\u0006\u0010i\u001a\u00020=H\u0016J\u0010\u0010j\u001a\u00020J2\u0006\u0010k\u001a\u00020=H\u0016J\u0010\u0010l\u001a\u00020J2\u0006\u0010m\u001a\u00020&H\u0016J\u0010\u0010n\u001a\u00020J2\u0006\u0010o\u001a\u00020=H\u0016J\u0010\u0010p\u001a\u00020J2\u0006\u0010q\u001a\u00020)H\u0016J\u0010\u0010r\u001a\u00020J2\u0006\u0010q\u001a\u00020)H\u0016J\u0010\u0010s\u001a\u00020J2\u0006\u0010q\u001a\u00020,H\u0016J\u0010\u0010t\u001a\u00020J2\u0006\u0010q\u001a\u00020,H\u0016J\u0010\u0010u\u001a\u00020J2\u0006\u0010q\u001a\u000200H\u0016J\u0010\u0010v\u001a\u00020J2\u0006\u0010q\u001a\u000200H\u0016J\u0010\u0010w\u001a\u00020J2\u0006\u0010q\u001a\u00020.H\u0016J\u0010\u0010x\u001a\u00020J2\u0006\u0010q\u001a\u00020.H\u0016J\u0010\u0010y\u001a\u00020J2\u0006\u0010q\u001a\u000202H\u0016J\u0010\u0010z\u001a\u00020J2\u0006\u0010q\u001a\u000202H\u0016J\u0010\u0010{\u001a\u00020J2\u0006\u0010q\u001a\u000204H\u0016J\u0010\u0010|\u001a\u00020J2\u0006\u0010q\u001a\u000204H\u0016J\b\u0010}\u001a\u00020=H\u0016J\b\u0010~\u001a\u00020=H\u0016J\u0010\u0010\u007f\u001a\u00020J2\u0006\u0010V\u001a\u00020\u0010H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u0012H\u0016J\u0013\u0010\u0081\u0001\u001a\u00020J2\b\u0010V\u001a\u0004\u0018\u00010\u001cH\u0016J\u000b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010\u0083\u0001\u001a\u00020JH\u0016J\u0015\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J\u001b\u0010\u0087\u0001\u001a\u00020J2\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0006\u0010V\u001a\u00020\u001cH\u0002J\u001b\u0010\u0088\u0001\u001a\u00020J2\u0007\u0010\u0089\u0001\u001a\u00020 2\u0007\u0010\u008a\u0001\u001a\u00020\u001eH\u0002J\u0011\u0010\u008b\u0001\u001a\u00020J2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001J\u0013\u0010\u008e\u0001\u001a\u00020J2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008d\u0001J\u0016\u0010\u0090\u0001\u001a\u00020J2\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020;0:J\n\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\n\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J!\u0010\u0098\u0001\u001a\u001a\u0012\u000e\u0012\f\u0012\u0007\b\u0001\u0012\u00030\u009b\u00010\u009a\u0001\u0012\u0005\u0012\u00030\u009b\u00010\u0099\u0001H\u0016J\t\u0010\u009c\u0001\u001a\u00020&H\u0016J\t\u0010\u009d\u0001\u001a\u00020JH\u0002J*\u0010\u009e\u0001\u001a\u00020J2\t\b\u0001\u0010\u009f\u0001\u001a\u00020=2\u0014\u0010 \u0001\u001a\u000f\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020J0¡\u0001H\u0002J>\u0010¢\u0001\u001a\u00020J2\t\b\u0001\u0010\u009f\u0001\u001a\u00020=2\f\b\u0002\u0010£\u0001\u001a\u0005\u0018\u00010¤\u00012\u0014\u0010 \u0001\u001a\u000f\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020J0¡\u0001H\u0002¢\u0006\u0003\u0010¥\u0001J\t\u0010¦\u0001\u001a\u00020JH\u0002J\u0013\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010©\u0001\u001a\u00020;H\u0002J\u001d\u0010ª\u0001\u001a\u00020J2\u0007\u0010«\u0001\u001a\u00020Z2\t\b\u0002\u0010¬\u0001\u001a\u00020&H\u0002J\u0013\u0010\u00ad\u0001\u001a\u00020J2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J\u001a\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001*\u00020\u001a2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J\u0013\u0010°\u0001\u001a\u00020J2\u0007\u0010±\u0001\u001a\u00020\u0004H\u0096\u0001J\u0013\u0010²\u0001\u001a\u00020J2\u0007\u0010±\u0001\u001a\u00020\u0004H\u0096\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00060\u0016R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00060\u0018R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020,0(j\b\u0012\u0004\u0012\u00020,`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020.0(j\b\u0012\u0004\u0012\u00020.`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0012\u0012\u0004\u0012\u0002000(j\b\u0012\u0004\u0012\u000200`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0012\u0012\u0004\u0012\u0002020(j\b\u0012\u0004\u0012\u000202`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u0002040(j\b\u0012\u0004\u0012\u000204`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0004\n\u0002\u00108R\u0016\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010<\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010C\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040´\u0001X\u0096\u0005¢\u0006\b\u001a\u0006\bµ\u0001\u0010¶\u0001¨\u0006»\u0001"}, d2 = {"Lcom/ss/android/lark/flow/chat/titlebar/FlowTitleBarComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent;", "Lcom/ss/android/lark/biz/im/api/component/callback/IComponentCallbackManager;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$ITitleBarComponentCallbacks;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "coreNavigationBar", "Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar;", "flowCenterBinder", "Lcom/ss/android/lark/flow/chat/titlebar/chattag/IFlowCenterBinder;", "meetingRoleProvider", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowTitleBar$MeetingRoleProvider;", "currentTheme", "Lcom/ss/android/lark/chat/entity/theme/TitleTheme;", "leftAreaImpl", "Lcom/ss/android/lark/flow/chat/titlebar/FlowTitleBarComponent$LeftAreaImpl;", "centerAreaImpl", "Lcom/ss/android/lark/flow/chat/titlebar/FlowTitleBarComponent$CenterAreaImpl;", "rightAreaImpl", "Lcom/ss/android/lark/flow/chat/titlebar/FlowTitleBarComponent$RightAreaImpl;", "mViewModel", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/viewmodel/TitlebarViewModel;", "p2pContentProvider", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/providers/TitleBarContentProvider;", "publicSignatureSnapshot", "Lcom/ss/android/lark/biz/im/api/UserStatusUrlPreviewSnapshot;", "publicSignatureView", "Lcom/suite/lark/platform/component/widget_biz_userstatus/UserStatusTextView;", "signaturePreviewSourceKey", "", "signaturePreviewViewModel", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/PageUserStatusUrlPreviewViewModel;", "hasResumed", "", "tabVisibilityListeners", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$ITabVisibilityListener;", "Lkotlin/collections/ArrayList;", "widgetVisibilityListeners", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$IWidgetVisibilityListener;", "pinVisibilityListeners", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$IPinVisibilityChangeListener;", "widgetStatusChangeListeners", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$IWidgetStatusChangeListener;", "themeChangeListeners", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$ITitleBarThemeChangeListener;", "visibilityChangeListeners", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent$ITitleBarVisibilityChangeListener;", "titleBarContentProvider", "defaultContentProvider", "com/ss/android/lark/flow/chat/titlebar/FlowTitleBarComponent$defaultContentProvider$1", "Lcom/ss/android/lark/flow/chat/titlebar/FlowTitleBarComponent$defaultContentProvider$1;", "rightActions", "", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/TitleBarAction;", "backgroundColorRes", "", "getBackgroundColorRes", "()Ljava/lang/Integer;", "setBackgroundColorRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "showSideBarStyle", "getShowSideBarStyle", "()Z", "setShowSideBarStyle", "(Z)V", "getLayoutResId", "onCreate", "", "onDestroy", "onResume", "getTitleView", "Landroid/view/View;", "getTitleWrapper", "Landroid/widget/FrameLayout;", "hideTitle", "showTitle", "hideAllTitleBar", "showAllTitleBar", "registerCenterTag", "provider", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/binder/IBinderOut$ICenterBinderOut$ICenterTagProvider;", "unRegisterCenterTag", "id", "", "updateP2PStrangerTag", "tagType", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerTagType;", "changeTheme", "theme", "getTabContainerWrapper", "getWidgetContainerWrapper", "getPinContainerWrapper", "getPinDivider", "addTouchDelegate", "centerLayout", "setTitleColor", "color", "triggerTabHeightChanged", "tabHeight", "triggerWidgetHeightChanged", "widgetHeight", "triggerWidgetStatusChanged", "isFold", "triggerPinStatusChanged", "pinHeight", "addTabVisibilityListener", "listener", "removeTabVisibilityListener", "addWidgetVisibilityListener", "removeWidgetVisibilityListener", "addWidgetStatusChangeListener", "removeWidgetStatusChangeListener", "addPinVisibilityListener", "removePinVisibilityListener", "addTitleThemeChangeListener", "removeTitleThemeChangeListener", "addTitleVisibilityChangeListener", "removeTitleVisibilityChangeListener", "getTitleAreaHeight", "getTabHeight", "setMeetingRoleProvider", "getTheme", "setTitleBarContentProvider", "getTitleBarContentProvider", "updateTitle", "getPublicSignatureSnapshot", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "updateSubtitle", "bindPublicSignatureContent", "view", "snapshot", "setTitle", "title", "", "setSubTitle", "subTitle", "setRightActions", "actions", "getLeftArea", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowTitleBar$LeftArea;", "getCenterArea", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowTitleBar$CenterArea;", "getRightArea", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowTitleBar$RightArea;", "provideWidgetExport", "", "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "hasView", "showHostSideBar", "setLeftPrimaryAction", "iconResId", "onClick", "Lkotlin/Function1;", "setLeftBackAction", "badgeMarginToIconStartDp", "", "(ILjava/lang/Float;Lkotlin/jvm/functions/Function1;)V", "setDefaultRightAction", "toNavigationAction", "Lcom/ss/android/lark/flow/chat/titlebar/view/CoreNavigationBar$Action;", "action", "launchFlowChatSetting", "chatId", "isSoloChat", "launchP2PChatterProfile", "getP2PChatChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "registerCallback", "callback", "unregisterCallback", "callbacks", "", "getCallbacks", "()Ljava/util/List;", "LeftAreaImpl", "CenterAreaImpl", "RightAreaImpl", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowTitleBarComponent extends ChatBaseComponent implements ITitlebarComponent, oxa.c<Object> {
    public static final /* synthetic */ int J = 0;
    public final ArrayList<ITitlebarComponent.f> A;
    public final ArrayList<ITitlebarComponent.a> B;
    public final ArrayList<ITitlebarComponent.e> C;
    public final ArrayList<ITitlebarComponent.c> D;
    public final ArrayList<ITitlebarComponent.d> E;
    public i4b.a F;
    public final FlowTitleBarComponent$defaultContentProvider$1 G;
    public Integer H;
    public boolean I;
    public final v l;
    public CoreNavigationBar m;
    public ugb.e n;
    public final TitleTheme o;
    public final LeftAreaImpl p;
    public final a q;
    public final RightAreaImpl r;
    public TitlebarViewModel s;
    public i4b.a t;
    public n1 u;
    public UserStatusTextView v;
    public final Object w;
    public PageUserStatusUrlPreviewViewModel x;
    public boolean y;
    public final ArrayList<ITitlebarComponent.b> z;

    public final class LeftAreaImpl {
        public final HashMap<TitleBarActionKey, com.ss.android.lark.biz.im.api.extension.chat_window.j> a;
        public final Set<com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey>> b;
        public final Lazy c;
        public final /* synthetic */ FlowTitleBarComponent d;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ChatWindowTitleBar.LeftArea.LeftAreaStyle.values().length];
                r0[ChatWindowTitleBar.LeftArea.LeftAreaStyle.STYLE_CLOSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[ChatWindowTitleBar.LeftArea.LeftAreaStyle.STYLE_BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[ChatWindowTitleBar.LeftArea.LeftAreaStyle.STYLE_SHOW_SIDEBAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final void g(TitleBarIconSize r2) {
            Intrinsics.checkNotNullParameter(r2, "size");
        }

        public final void d() {
            Iterator<Map.Entry<TitleBarActionKey, com.ss.android.lark.biz.im.api.extension.chat_window.j>> r0 = this.a.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L23;
            Map.Entry<TitleBarActionKey, com.ss.android.lark.biz.im.api.extension.chat_window.j> r1 = r0.next();
            TitleBarActionKey r2 = r1.getKey();
            com.ss.android.lark.biz.im.api.extension.chat_window.j r3 = r1.getValue();
            View r4 = c(r2);
            if (r4 == null) goto L4;
            Boolean r5 = (Boolean) ((Map) this.c.getValue()).get(r2);
            boolean r6 = true;
            if (r5 == null) goto L10;
            boolean r7 = r5.booleanValue();
        L11:
            int r8 = 0;
            if (r4.getVisibility() == 0) goto L15;
            r6 = false;
        L15:
            if (r6 == r7) goto L4;
            if (r7 == true) goto L19;
            r8 = 8;
        L19:
            r4.setVisibility(r8);
            if (r7 == true) goto L21;
            r3.onHide();
            goto L4
        L21:
            r3.onShow();
            goto L4
        L10:
            r7 = true;
            goto L11
        }

        public LeftAreaImpl(FlowTitleBarComponent r1) {
            this.d = r1;
            this.a = new HashMap();
            this.b = new LinkedHashSet();
            this.c = LazyKt.lazy(FlowTitleBarComponent$LeftAreaImpl$actionVisibilityMap$2.INSTANCE);
        }

        public final void a(com.ss.android.lark.biz.im.api.extension.chat_window.j r6) {
            Intrinsics.checkNotNullParameter(r6, "action");
            this.a.put(r6.getKey(), r6);
            TitleBarActionKey r1 = r6.getKey();
            CoreNavigationBar r2 = this.d.m;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r2 = null;
        L5:
            CoreNavigationBar.e r3 = FlowTitleBarComponent.F0(this.d, r6);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "action");
            boolean r0 = true;
            r2.a(r3, true);
            Set<com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey>> r4 = this.b;
            int r5 = 0;
            if ((r4 instanceof Collection) == true) goto L8;
        L10:
            Iterator<T> r7 = r4.iterator();
        L12:
            if (r7.hasNext() == false) goto L16;
            if (((com.ss.android.lark.biz.im.api.extension.chat_window.a) r7.next()).a(r1) == false) goto L12;
            r0 = false;
        L16:
            Boolean r8 = Boolean.valueOf(r0);
            ((Map) this.c.getValue()).put(r1, r8);
            View r9 = c(r1);
            if (r9 == null) goto L29;
            if (r0 == true) goto L21;
            r5 = 8;
        L21:
            r9.setVisibility(r5);
            r6.f(r9);
            if (r0 == false) goto L24;
            r6.onShow();
            return;
        L24:
            r6.onHide();
            return;
        L29:
            return;
        L8:
            if (r4.isEmpty() == false) goto L10;
            goto L10
        }

        public final void b(com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey> r7) {
            Intrinsics.checkNotNullParameter(r7, "interceptor");
            if (this.b.contains(r7) == false) goto L5;
            return;
        L5:
            this.b.add(r7);
            TitleBarActionKey[] r0 = TitleBarActionKey.values();
            int r1 = r0.length;
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L11;
            TitleBarActionKey r3 = r0[r2];
            if (r7.a(r3) == false) goto L10;
            ((Map) this.c.getValue()).put(r3, Boolean.FALSE);
        L10:
            r2 = r2 + 1;
            goto L6
        L11:
            d();
        }

        public final View c(TitleBarActionKey r7) {
            CoreNavigationBar r0 = this.d.m;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r0 = null;
        L5:
            int r1 = r0.getChildCount();
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L14;
            CoreNavigationBar r4 = this.d.m;
            if (r4 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r4 = null;
        L10:
            View r5 = r4.getChildAt(r3);
            if (r5.getTag() == r7) goto L12;
            r3 = r3 + 1;
            goto L6
        L12:
            return r5;
        L14:
            return null;
        }

        public final com.ss.android.lark.biz.im.api.extension.chat_window.j e(TitleBarActionKey r4) {
            Intrinsics.checkNotNullParameter(r4, TabAppInfo.IMAGE_JSON_KEY);
            com.ss.android.lark.biz.im.api.extension.chat_window.j r0 = this.a.remove(r4);
            if (r0 == null) goto L8;
            CoreNavigationBar r1 = this.d.m;
            if (r1 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r1 = null;
        L7:
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "actionId");
            r1.h(r4, true);
            r0.d();
        L8:
            return r0;
        }

        public final void f(com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey> r8) {
            Intrinsics.checkNotNullParameter(r8, "interceptor");
            if (this.b.contains(r8) == true) goto L5;
            return;
        L5:
            this.b.remove(r8);
            TitleBarActionKey[] r9 = TitleBarActionKey.values();
            int r0 = r9.length;
            int r2 = 0;
        L6:
            if (r2 >= r0) goto L14;
            TitleBarActionKey r3 = r9[r2];
            Iterator<T> r4 = this.b.iterator();
            boolean r5 = false;
        L9:
            if (r4.hasNext() == false) goto L13;
            if (((com.ss.android.lark.biz.im.api.extension.chat_window.a) r4.next()).a(r3) == false) goto L9;
            r5 = true;
            goto L9
        L13:
            ((Map) this.c.getValue()).put(r3, Boolean.valueOf(!r5));
            r2 = r2 + 1;
            goto L6
        L14:
            d();
        }
    }

    public final class RightAreaImpl {
        public final HashMap<TitleBarActionKey, com.ss.android.lark.biz.im.api.extension.chat_window.j> a;
        public final Set<com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey>> b;
        public final Lazy c;
        public final /* synthetic */ FlowTitleBarComponent d;

        public final void d() {
            Iterator<Map.Entry<TitleBarActionKey, com.ss.android.lark.biz.im.api.extension.chat_window.j>> r0 = this.a.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L23;
            Map.Entry<TitleBarActionKey, com.ss.android.lark.biz.im.api.extension.chat_window.j> r1 = r0.next();
            TitleBarActionKey r2 = r1.getKey();
            com.ss.android.lark.biz.im.api.extension.chat_window.j r3 = r1.getValue();
            View r4 = c(r2);
            if (r4 == null) goto L4;
            Boolean r5 = (Boolean) ((Map) this.c.getValue()).get(r2);
            boolean r6 = true;
            if (r5 == null) goto L10;
            boolean r7 = r5.booleanValue();
        L11:
            int r8 = 0;
            if (r4.getVisibility() == 0) goto L15;
            r6 = false;
        L15:
            if (r6 == r7) goto L4;
            if (r7 == true) goto L19;
            r8 = 8;
        L19:
            r4.setVisibility(r8);
            if (r7 == true) goto L21;
            r3.onHide();
            goto L4
        L21:
            r3.onShow();
            goto L4
        L10:
            r7 = true;
            goto L11
        L23:
            CoreNavigationBar r9 = this.d.m;
            if (r9 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r9 = null;
        L26:
            r9.requestLayout();
        }

        public RightAreaImpl(FlowTitleBarComponent r1) {
            this.d = r1;
            this.a = new HashMap();
            this.b = new LinkedHashSet();
            this.c = LazyKt.lazy(FlowTitleBarComponent$RightAreaImpl$actionVisibilityMap$2.INSTANCE);
        }

        public final void a(com.ss.android.lark.biz.im.api.extension.chat_window.k r6) {
            Intrinsics.checkNotNullParameter(r6, "action");
            this.a.put(r6.getKey(), r6);
            TitleBarActionKey r1 = r6.getKey();
            CoreNavigationBar r2 = this.d.m;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r2 = null;
        L5:
            CoreNavigationBar.e r3 = FlowTitleBarComponent.F0(this.d, r6);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "action");
            int r0 = 0;
            r2.a(r3, false);
            Set<com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey>> r4 = this.b;
            if ((r4 instanceof Collection) == true) goto L8;
        L10:
            Iterator<T> r5 = r4.iterator();
        L12:
            if (r5.hasNext() == false) goto L16;
            if (((com.ss.android.lark.biz.im.api.extension.chat_window.a) r5.next()).a(r1) == false) goto L12;
            boolean r7 = false;
        L17:
            Boolean r8 = Boolean.valueOf(r7);
            ((Map) this.c.getValue()).put(r1, r8);
            View r9 = c(r1);
            if (r9 == null) goto L30;
            if (r7 == true) goto L22;
            r0 = 8;
        L22:
            r9.setVisibility(r0);
            r6.f(r9);
            if (r7 == false) goto L25;
            r6.onShow();
            return;
        L25:
            r6.onHide();
            return;
        L30:
            return;
        L16:
            r7 = true;
            goto L17
        L8:
            if (r4.isEmpty() == false) goto L10;
            goto L10
        }

        public final void b(com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey> r7) {
            Intrinsics.checkNotNullParameter(r7, "interceptor");
            if (this.b.contains(r7) == false) goto L5;
            return;
        L5:
            this.b.add(r7);
            TitleBarActionKey[] r0 = TitleBarActionKey.values();
            int r1 = r0.length;
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L11;
            TitleBarActionKey r3 = r0[r2];
            if (r7.a(r3) == false) goto L10;
            ((Map) this.c.getValue()).put(r3, Boolean.FALSE);
        L10:
            r2 = r2 + 1;
            goto L6
        L11:
            d();
        }

        public final View c(TitleBarActionKey r7) {
            CoreNavigationBar r0 = this.d.m;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r0 = null;
        L5:
            int r1 = r0.getChildCount();
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L14;
            CoreNavigationBar r4 = this.d.m;
            if (r4 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r4 = null;
        L10:
            View r5 = r4.getChildAt(r3);
            if (r5.getTag() == r7) goto L12;
            r3 = r3 + 1;
            goto L6
        L12:
            return r5;
        L14:
            return null;
        }

        public final com.ss.android.lark.biz.im.api.extension.chat_window.j e(TitleBarActionKey r4) {
            Intrinsics.checkNotNullParameter(r4, TabAppInfo.IMAGE_JSON_KEY);
            com.ss.android.lark.biz.im.api.extension.chat_window.j r0 = this.a.remove(r4);
            if (r0 == null) goto L8;
            CoreNavigationBar r1 = this.d.m;
            if (r1 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r1 = null;
        L7:
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "actionId");
            r1.h(r4, false);
            r0.d();
        L8:
            return r0;
        }

        public final void f(com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey> r8) {
            Intrinsics.checkNotNullParameter(r8, "interceptor");
            if (this.b.contains(r8) == true) goto L5;
            return;
        L5:
            this.b.remove(r8);
            TitleBarActionKey[] r9 = TitleBarActionKey.values();
            int r0 = r9.length;
            int r2 = 0;
        L6:
            if (r2 >= r0) goto L14;
            TitleBarActionKey r3 = r9[r2];
            Iterator<T> r4 = this.b.iterator();
            boolean r5 = false;
        L9:
            if (r4.hasNext() == false) goto L13;
            if (((com.ss.android.lark.biz.im.api.extension.chat_window.a) r4.next()).a(r3) == false) goto L9;
            r5 = true;
            goto L9
        L13:
            ((Map) this.c.getValue()).put(r3, Boolean.valueOf(!r5));
            r2 = r2 + 1;
            goto L6
        L14:
            d();
        }
    }

    public final class a {
        public final Set<ChatWindowTitleBar.a> a;
        public final /* synthetic */ FlowTitleBarComponent b;

        /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent$a$a, reason: collision with other inner class name */
        public static final class C0040a implements CoreNavigationBar.f {
            public final /* synthetic */ ChatWindowTitleBar.a a;

            public C0040a(ChatWindowTitleBar.a r1) {
                this.a = r1;
            }

            @Override // com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar.f
            public final View createView(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                FrameLayout r0 = new FrameLayout(r2);
                this.a.a(r0);
                return r0;
            }
        }

        public final void b() {
            ChatWindowTitleBar.a r0 = (ChatWindowTitleBar.a) CollectionsKt.firstOrNull(this.a);
            CoreNavigationBar r2 = null;
            if (r0 == null) goto L9;
            CoreNavigationBar r3 = this.b.m;
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        L8:
            r2.setCenterViewProvider(new C0040a(r0));
            return;
        L7:
            r2 = r3;
            goto L8
        L9:
            CoreNavigationBar r1 = this.b.m;
            if (r1 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r1 = null;
        L12:
            r1.setCenterViewProvider(null);
        }

        public a(FlowTitleBarComponent r1) {
            this.b = r1;
            this.a = new LinkedHashSet();
        }

        public final void a(ChatWindowTitleBar.a r2) {
            Intrinsics.checkNotNullParameter(r2, "provider");
            this.a.add(r2);
            b();
        }

        public final void c(FlowMessageSelectPlugin$centerViewProvider$2.a r2) {
            Intrinsics.checkNotNullParameter(r2, "provider");
            this.a.remove(r2);
            b();
        }
    }

    public static final class b {
    }

    public static final class c implements CoreNavigationBar.d {
        public c() {
        }

        @Override // com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar.d
        public final void a(AppCompatTextView r3) {
            Intrinsics.checkNotNullParameter(r3, "subtitleView");
            r3.setTextColor(UIUtils.getColor(r3.getContext(), 2131108715));
        }

        @Override // com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar.d
        public final void b(AppCompatImageView r4) {
            Intrinsics.checkNotNullParameter(r4, "arrowView");
            r4.setImageDrawable(UDIconUtils.getIconDrawable(r4.getContext(), 2131256115, UIUtils.getColor(r4.getContext(), 2131102416)));
        }

        @Override // com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar.d
        public final void c(AppCompatTextView r3) {
            Intrinsics.checkNotNullParameter(r3, "titleView");
            r3.setTextColor(UIUtils.getColor(r3.getContext(), 2131108713));
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ FlowTitleBarComponent a;

        public d(FlowTitleBarComponent r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent, com.ss.android.lark.framework.larkwidget.Widget] */
        public final void onChanged(Object r10) {
            i7b.a r11 = (i7b.a) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            TitlebarModelFactory r0 = new TitlebarModelFactory(this.a.l, r11.f, r11.g);
            ?? r1 = this.a;
            int r2 = com.ss.android.lark.chat.chatwindow.chat.v2.component.d.a;
            TitlebarViewModel r3 = r1.t0(com.ss.android.lark.chat.chatwindow.chat.v2.component.d.a(TitlebarViewModel.class), TitlebarViewModel.class, r0);
            r3.create();
            r1.s = r3;
            ChatChatter r4 = r11.g;
            CoreNavigationBar r5 = null;
            if (r4 == null) goto L7;
            ChatterDescription r6 = r4.getDescription();
            if (r6 == null) goto L7;
            String r7 = r6.description;
        L8:
            if (r7 != null) goto L10;
        L13:
            boolean r8 = true;
        L14:
            TitlebarViewModel r9 = this.a.s;
            if (r9 == null) goto L18;
            r9.triggerUpdateNewP2PChatter(r8);
        L18:
            if (r11.d == false) goto L26;
            FlowTitleBarComponent r12 = this.a;
            if (r12.I == true) goto L26;
            TitlebarViewModel r13 = r12.s;
            if (r13 == null) goto L26;
            MutableLiveData r14 = r13.getBadgeCountLiveData();
            if (r14 == null) goto L26;
            FlowTitleBarComponent r15 = this.a;
            r14.observe(r15, new com.ss.android.lark.flow.chat.titlebar.c(r15));
        L26:
            Chat.Type r16 = r11.f.getType();
            Chat.Type r17 = Chat.Type.P2P;
            if (r16 != r17) goto L33;
            final FlowTitleBarComponent r18 = this.a;
            i4b.a r19 = r18.F;
            if (r19 != null) goto L31;
            r19 = new FlowTitleBarComponent$onCreate$3$3(r18);
            r18.t = r19;
        L31:
            r18.F = r19;
        L33:
            if (this.a.t != null) goto L35;
        L37:
            FlowTitleBarComponent r20 = this.a;
            i4b.a r21 = r20.F;
            if (r21 != null) goto L41;
            r21 = r20.G;
        L41:
            if (r21.b() == true) goto L43;
            ugb.e r22 = null;
        L53:
            r20.n = r22;
            FlowTitleBarComponent r23 = this.a;
            ugb.e r24 = r23.n;
            if (r24 == null) goto L60;
            CoreNavigationBar r25 = r23.m;
            if (r25 != null) goto L58;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        L59:
            r24.a(r5.getContext(), new sxa.a(r11.f, r11.g));
            goto L60
        L58:
            r5 = r25;
        L60:
            TitlebarViewModel r110 = this.a.s;
            if (r110 == null) goto L66;
            MutableLiveData r111 = r110.getP2pChatterLiveData();
            if (r111 == null) goto L67;
            FlowTitleBarComponent r26 = this.a;
            r111.observe(r26, new com.ss.android.lark.flow.chat.titlebar.f(r26));
            return;
        L67:
            return;
        L66:
            return;
        L43:
            if (r11.f.getType() != r17) goto L48;
            CoreNavigationBar r27 = this.a.m;
            if (r27 != null) goto L47;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r27 = null;
        L47:
            r22 = new ugb.c(r27);
            goto L53
        L48:
            CoreNavigationBar r28 = this.a.m;
            if (r28 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r28 = null;
        L51:
            r22 = new ugb.b(r28);
            goto L53
        L35:
            if (r11.f.isSecret() == true) goto L37;
            FlowTitleBarComponent r29 = this.a;
            PageUserStatusUrlPreviewViewModel r30 = new ViewModelProvider(this.a.getFragment()).get(PageUserStatusUrlPreviewViewModel.class);
            FlowTitleBarComponent r31 = this.a;
            PageUserStatusUrlPreviewViewModel r32 = r30;
            r32.registerSource(r31.w, ChatHitPointExtraParams.UrlAnalysisScene.CHAT_NAVIBAR, new com.ss.android.lark.flow.chat.titlebar.d(r31), new com.ss.android.lark.flow.chat.titlebar.e(r31));
            r29.x = r32;
            goto L37
        L10:
            if (StringsKt.isBlank(r7) == true) goto L13;
            r8 = false;
        L7:
            r7 = null;
            goto L8
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ FlowTitleBarComponent a;

        public e(FlowTitleBarComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Chat r7 = (Chat) r6;
            if (r7 == null) goto L21;
            this.a.updateTitle();
            FlowTitleBarComponent r0 = this.a;
            ugb.e r1 = r0.n;
            if (r1 == null) goto L20;
            CoreNavigationBar r2 = r0.m;
            ChatChatter r3 = null;
            if (r2 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
            r2 = null;
        L10:
            Context r4 = r2.getContext();
            TitlebarViewModel r5 = this.a.s;
            if (r5 == null) goto L15;
            ChatChatter r8 = FlowTitleBarComponent.G0(r5, r7);
            if (r8 == null) goto L15;
            r3 = r8;
        L18:
            r1.a(r4, new sxa.a(r7, r3));
            return;
        L15:
            i7b.a r9 = (i7b.a) this.a.D0().getValue();
            if (r9 == null) goto L18;
            r3 = r9.g;
            goto L18
        L20:
            return;
        }
    }

    public static final class f implements com.ss.android.lark.biz.im.api.extension.chat_window.m {
        public final /* synthetic */ FlowTitleBarComponent a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Float c;
        public final /* synthetic */ Function1<View, Unit> d;

        public final void d() {
        }

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final TitleBarActionKey getKey() {
            return TitleBarActionKey.BACK;
        }

        /* JADX WARN: Type inference failed for: r5v1, types: [android.view.ViewGroup, com.ss.android.lark.flow.chat.titlebar.view.BadgeBackView] */
        public final BadgeBackView a(TitleTheme.ThemeType r5) {
            Intrinsics.checkNotNullParameter(r5, "theme");
            ?? r6 = new BadgeBackView(this.a.B0(), null, 6, 0);
            int r0 = this.b;
            Float r1 = this.c;
            r6.setIconResId(r0);
            if (r1 == null) goto L5;
            float r2 = r1.floatValue();
            r6.setBadgeMarginToIconStart(UIUtils.dp2px(r6.getContext(), r2));
        L5:
            return r6;
        }

        public final void f(View r2) {
            Intrinsics.checkNotNullParameter(r2, "actionView");
            Intrinsics.checkNotNullParameter(r2, "actionView");
        }

        public final void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.d.invoke(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(FlowTitleBarComponent r1, int r2, Float r3, Function1<? super View, Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final boolean v0() {
        return true;
    }

    public final int z4() {
        return 0;
    }

    public final void La() {
        CoreNavigationBar r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r0 = null;
    L5:
        r0.setVisibility(8);
        Iterator<T> r1 = this.E.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((ITitlebarComponent.d) r1.next()).a();
        goto L7
    }

    public final View getTitleView() {
        CoreNavigationBar r0 = this.m;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        return null;
    L6:
        return r0;
    }

    public final void n3() {
        CoreNavigationBar r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r0 = null;
    L5:
        r0.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        PageUserStatusUrlPreviewViewModel r0 = this.x;
        if (r0 == null) goto L5;
        r0.unregisterSource(this.w);
    L5:
        this.x = null;
        this.u = null;
        this.v = null;
        CoreNavigationBar r1 = this.m;
        if (r1 == null) goto L10;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r1 = null;
    L9:
        r1.setSubtitle(null);
    L10:
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onDestroy();
    }

    public final int w3() {
        CoreNavigationBar r0 = this.m;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r0 = null;
    L6:
        return r0.getHeight();
    }

    public final Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> z0() {
        return MapsKt.mapOf(TuplesKt.to(ITitlebarComponent.class, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onCreate();
        View r0 = this.e;
        if (r0 == null) goto L41;
        CoreNavigationBar r1 = (CoreNavigationBar) r0.findViewById(2131367969);
        if (r1 == null) goto L42;
        this.m = r1;
        Integer r2 = this.H;
        CoreNavigationBar r3 = null;
        if (r2 == null) goto L16;
        int r4 = r2.intValue();
        CoreNavigationBar r5 = this.m;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r5 = null;
    L12:
        CoreNavigationBar r6 = this.m;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r6 = null;
    L15:
        r5.setBackgroundColor(UIUtils.getColor(r6.getContext(), r4));
    L16:
        CoreNavigationBar r7 = this.m;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r7 = null;
    L19:
        r7.setTitleStyleConfigure(new c());
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(D0(), this, new d(this));
        C0().observe(this, new e(this));
        if (this.I == false) goto L34;
        LeftAreaImpl r8 = this.p;
        ChatWindowTitleBar.LeftArea.LeftAreaStyle r9 = ChatWindowTitleBar.LeftArea.LeftAreaStyle.STYLE_SHOW_SIDEBAR;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "style");
        int r10 = LeftAreaImpl.a.a[r9.ordinal()];
        if (r10 != 1) goto L24;
        final FlowTitleBarComponent r11 = r8.d;
        Function1<View, Unit> r12 = new FlowTitleBarComponent$LeftAreaImpl$updateStyle$1(r11);
        CoreNavigationBar r13 = r11.m;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r13 = null;
    L33:
        r13.d(true);
        r11.p.a(new h(r11, r12));
    L35:
        CoreNavigationBar r14 = this.m;
        if (r14 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
    L39:
        r3.d(false);
        this.r.a(new g(this));
        return;
    L38:
        r3 = r14;
        goto L39
    L24:
        if (r10 != 2) goto L26;
        final FlowTitleBarComponent r15 = r8.d;
        r15.J0(2131235451, null, new FlowTitleBarComponent$LeftAreaImpl$updateStyle$2(r15));
        goto L35
    L26:
        if (r10 == 3) goto L28;
        final FlowTitleBarComponent r16 = r8.d;
        r16.J0(2131235451, null, new FlowTitleBarComponent$LeftAreaImpl$updateStyle$4(r16));
        goto L35
    L28:
        FlowTitleBarComponent r17 = r8.d;
        Float r18 = Float.valueOf(40.0f);
        final FlowTitleBarComponent r19 = r8.d;
        r17.J0(2131235459, r18, new FlowTitleBarComponent$LeftAreaImpl$updateStyle$3(r19));
        goto L35
    L34:
        J0(2131235451, null, new AnonymousClass5(this));
        goto L35
    L42:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onResume() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onResume();
        if (this.y == true) goto L6;
        this.y = true;
        return;
    L6:
        TitlebarViewModel r0 = this.s;
        if (r0 == null) goto L10;
        TitlebarViewModel.triggerUpdateNewP2PChatter$default(r0, false, 1, null);
        return;
    }

    public final Integer r0() {
        return 2131561147;
    }

    public final void updateTitle() {
        Chat r0 = (Chat) C0().getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        i4b.a r1 = this.F;
        if (r1 != null) goto L8;
        r1 = this.G;
    L8:
        CoreNavigationBar r2 = this.m;
        CoreNavigationBar r3 = null;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r2 = null;
    L11:
        r2.setTitle(r1.c(r0));
        n1 r4 = H0(r0);
        if (r4 != null) goto L22;
        this.u = null;
        this.v = null;
        CoreNavigationBar r5 = this.m;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r5 = null;
    L17:
        if (r1 != this.t) goto L19;
        CharSequence r6 = null;
    L20:
        r5.setSubtitle(r6);
    L38:
        CoreNavigationBar r7 = this.m;
        if (r7 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r7 = null;
    L41:
        r7.setTitleClickListener(r1.e(r0));
        CoreNavigationBar r8 = this.m;
        if (r8 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r8 = null;
    L44:
        r8.setSubTitleClickListener(r1.a(r0));
        CoreNavigationBar r9 = this.m;
        if (r9 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
    L48:
        r3.setTitleRowClickListener(r1.e(r0));
        return;
    L47:
        r3 = r9;
        goto L48
    L19:
        r6 = r1.d(r0);
        goto L20
    L22:
        if (Intrinsics.areEqual(r4, this.u) == true) goto L24;
    L25:
        CoreNavigationBar r10 = this.m;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r10 = null;
    L28:
        AppCompatTextView r11 = new UserStatusTextView(r10.getContext());
        r11.setTextSize(2, 11.0f);
        Resources r12 = r11.getResources();
        r11.setEmojiconSize((int) TypedValue.applyDimension(2, 11.0f, WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics())));
        r11.setTextColor(UIUtils.getColor(r11.getContext(), 2131108715));
        r11.setUrlTextColor(UIUtils.getColor(r11.getContext(), 2131106616));
        r11.setIncludeFontPadding(false);
        r11.setMaxLines(1);
        r11.setSingleLine(true);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        r11.setNeedToRecognize(true);
        r11.setShowArrow(false);
        r11.setUrlStringClickListner(new m());
        this.v = r11;
        this.u = r4;
        String r13 = r4.b;
        String r14 = r4.a;
        int r15 = UserStatusParseUrlPreViewUtils.a;
        String r16 = k6b.c.a(r13, r14, null);
        RecogniseSpansResult r17 = f0.a.a.a(r16);
        r11.Q(r17, r4.a, r16);
        if (r17 != null) goto L32;
        WeakReference r18 = new WeakReference(r11);
        int r19 = FlowChatModule.d;
        FlowChatModule r20 = FlowChatModule.a.a();
        String r21 = r4.a;
        String r22 = r4.b;
        SyncDataStrategy r110 = SyncDataStrategy.TRY_LOCAL;
        ChatHitPointExtraParams.UrlAnalysisScene r111 = ChatHitPointExtraParams.UrlAnalysisScene.CHAT_NAVIBAR;
        com.ss.android.lark.flow.chat.titlebar.b r112 = new com.ss.android.lark.flow.chat.titlebar.b(r18, this, r4, r16);
        r20.getClass();
        FlowChatModule.b(r21, r22, r110, r111, null, r112);
    L32:
        LinkEmojiTextView r23 = this.v;
        if (r23 == null) goto L38;
        CoreNavigationBar r24 = this.m;
        if (r24 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r24 = null;
    L37:
        r24.setSubtitleView(r23);
        goto L38
    L24:
        if (this.v != null) goto L32;
        goto L25
    }

    public final RightAreaImpl F00() {
        return this.r;
    }

    public final a XA() {
        return this.q;
    }

    public final TitleTheme getTheme() {
        return this.o;
    }

    public final LeftAreaImpl x00() {
        return this.p;
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent$defaultContentProvider$1] */
    public FlowTitleBarComponent(v r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        new ArrayList();
        this.l = r2;
        this.o = new TitleTheme(TitleTheme.ThemeType.LIGHT);
        this.p = new LeftAreaImpl(this);
        this.q = new a(this);
        this.r = new RightAreaImpl(this);
        this.w = new Object();
        this.z = new ArrayList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.G = new FlowTitleBarComponent$defaultContentProvider$1(this);
    }

    public final n1 H0(Chat r5) {
        i4b.a r0 = this.t;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.F == r0) goto L8;
    L26:
        return null;
    L8:
        if (r5.getType() != Chat.Type.P2P) goto L26;
        if (r5.isSecret() == true) goto L26;
        TitlebarViewModel r2 = this.s;
        if (r2 == null) goto L19;
        MutableLiveData r3 = r2.getP2pChatterLiveData();
        if (r3 == null) goto L19;
        Chatter r4 = (Chatter) r3.getValue();
        if (r4 == null) goto L19;
        String r6 = r4.getId();
    L20:
        CharSequence r7 = r0.d(r5);
        if (r7 == null) goto L23;
        String r8 = r7.toString();
    L25:
        return o1.a(r6, r8, null);
    L23:
        r8 = null;
    L19:
        r6 = null;
        goto L20
    }

    public final void OY(ITitlebarComponent.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.B.add(r2);
    }

    public final void PA(ITitlebarComponent.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.D.add(r2);
    }

    public final void Yr(ITitlebarComponent.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.D.remove(r2);
    }

    public final void kq(ITitlebarComponent.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.z.add(r2);
    }

    public final void pR(ITitlebarComponent.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.C.add(r2);
    }

    public final void sm(ITitlebarComponent.f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.A.add(r2);
    }

    public final void xD(ReplyInThreadTitleBarPlugin$onCreate$2 r1) {
        this.F = r1;
    }

    public static final void E0(FlowTitleBarComponent r7, Chat r8) {
        TitlebarViewModel r0 = r7.s;
        if (r0 == null) goto L10;
        MutableLiveData r1 = r0.getP2pChatterLiveData();
        if (r1 == null) goto L10;
        Chatter r2 = (Chatter) r1.getValue();
        if (r2 == null) goto L10;
        String r3 = r2.getId();
        if (r3 == null) goto L10;
    L11:
        String r4 = r3;
        if (r4.length() != 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
        r7.I0(r8.getId(), false);
        return;
    L17:
        CoreNavigationBar r9 = r7.m;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r9 = null;
    L20:
        Context r6 = r9.getContext();
        ContactSource.a r10 = new ContactSource.a();
        r10.b = 2;
        r10.e = r8.getId();
        r10.c = "";
        ContactSource r11 = new ContactSource(r10);
        IProfileLauncherV2.a.getClass();
        IProfileLauncherV2 r12 = IProfileLauncherV2.Companion.a();
        Intrinsics.checkNotNull(r6);
        String r13 = r8.getId();
        Intrinsics.checkNotNull(r11);
        IProfileLauncherV2.a.a(r12, r6, r4, r13, r11, 154);
        return;
    L14:
        r5 = false;
    L10:
        r3 = r8.getP2pChatterId();
        goto L11
    }

    public static final CoreNavigationBar.e F0(FlowTitleBarComponent r7, final com.ss.android.lark.biz.im.api.extension.chat_window.j r8) {
        r7.getClass();
        TitleBarActionKey r1 = r8.getKey();
        TitleTheme.ThemeType r9 = r7.o.getType();
        if ((r8 instanceof com.ss.android.lark.biz.im.api.extension.chat_window.m) == false) goto L6;
        return new CoreNavigationBar.e(r1, null, new i(r8, r9, r1), new FlowTitleBarComponent$toNavigationAction$2(r8), 6);
    L6:
        if ((r8 instanceof com.ss.android.lark.biz.im.api.extension.chat_window.l) == false) goto L9;
        return new CoreNavigationBar.e(r1, null, new j(r8, r9, r1), new FlowTitleBarComponent$toNavigationAction$4(r8), 6);
    L9:
        if ((r8 instanceof com.ss.android.lark.biz.im.api.extension.chat_window.k) == false) goto L12;
        return new CoreNavigationBar.e(r1, ((com.ss.android.lark.biz.im.api.extension.chat_window.k) r8).g(r9), new k(r8, r9, r1), new FlowTitleBarComponent$toNavigationAction$6(r8), 4);
    L12:
        return new CoreNavigationBar.e(r1, null, new l(r1), new FlowTitleBarComponent$toNavigationAction$8(r8), 6);
    }

    public static ChatChatter G0(TitlebarViewModel r3, Chat r4) {
        ChatChatter r5 = (Chatter) r3.getP2pChatterLiveData().getValue();
        if (r5 != null) goto L6;
        return null;
    L6:
        ChatChatter r0 = new ChatChatter(r5);
        if ((r5 instanceof ChatChatter) == false) goto L11;
        ChatChatter r1 = r5;
        if (Intrinsics.areEqual(r1.getId(), r4.getId()) == false) goto L11;
        r0.setChatter(r1.getChatter());
        r0.setOnCallRole(r1.getOnCallRole());
        r0.setNickName(r1.getNickName());
    L12:
        return r0;
    L11:
        r0.setChatter(r5);
        goto L12
    }

    public final void I0(String r4, boolean r5) {
        CoreNavigationBar r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r0 = null;
    L5:
        Context r1 = r0.getContext();
        Intent r6 = new Intent().setClassName(r1, "com.ss.android.lark.compose.chatsetting.main.ui.FlowChatSettingActivity").putExtra("chat_id", r4).putExtra("is_solo_chat", r5);
        PassportcConvention.g(r6, PassportcConvention.b(getFragment()));
        getFragment().startActivity(r6);
    }

    public final void J0(int r3, Float r4, Function1<? super View, Unit> r5) {
        CoreNavigationBar r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r0 = null;
    L5:
        r0.d(true);
        this.p.a(new f(this, r3, r4, r5));
    }
}
