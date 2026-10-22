package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.eventbus.EventBus;
import com.ss.android.eventbus.Subscribe;
import com.ss.android.eventbus.ThreadMode;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.biz.im.api.extension.message.MultiSelectContext;
import com.ss.android.lark.biz.officesdk.im.share.IOfficeSDKSharePanelType;
import com.ss.android.lark.biz.officesdk.im.share.IOfficeSDKShareScene;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapperComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.o;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatTnsInfo;
import com.ss.android.lark.chat.entity.chat.ChatTnsOpKind;
import com.ss.android.lark.chat.entity.chat.ChatTnsSystemBannedInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.component.banner.IFlowBottomBannerComponent;
import com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.message.r;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.statistics.multiselect.MultiSelectHitPointNew;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONException;
import org.json.JSONObject;
import z5c.p3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u009d\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\r_behmruz\u007f\u009b\u0001»\u0001\b\u0007\u0018\u0000 Ç\u00012\u00020\u0001:\u0002Ç\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0083\u0001\u001a\u00020-2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0016J\u0013\u0010\u0086\u0001\u001a\u00020-2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0002J\t\u0010\u0087\u0001\u001a\u00020-H\u0002J\u0013\u0010\u0088\u0001\u001a\u00020-2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0002J\t\u0010\u0089\u0001\u001a\u00020-H\u0016J\t\u0010\u008a\u0001\u001a\u00020-H\u0002J\t\u0010\u008b\u0001\u001a\u00020-H\u0002J\t\u0010\u008c\u0001\u001a\u00020-H\u0002J\t\u0010\u008d\u0001\u001a\u00020-H\u0002J\u0012\u0010\u008e\u0001\u001a\u00020-2\u0007\u0010\u008f\u0001\u001a\u00020@H\u0002J\u001e\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020&0,2\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020&0,H\u0002J\u0018\u0010\u0092\u0001\u001a\u00020-2\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020&0,H\u0002J\t\u0010\u0093\u0001\u001a\u00020-H\u0002J\u0012\u0010\u0094\u0001\u001a\u00020@2\u0007\u0010\u0095\u0001\u001a\u00020@H\u0002J\u0012\u0010\u0096\u0001\u001a\u00020(2\u0007\u0010\u0097\u0001\u001a\u00020\u001bH\u0002J\t\u0010\u0098\u0001\u001a\u00020-H\u0002J\t\u0010\u0099\u0001\u001a\u00020-H\u0002J\u0010\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002¢\u0006\u0003\u0010\u009c\u0001J\t\u0010\u009d\u0001\u001a\u00020-H\u0002J\t\u0010\u009e\u0001\u001a\u00020-H\u0002J\t\u0010\u009f\u0001\u001a\u00020(H\u0002J\t\u0010 \u0001\u001a\u00020(H\u0002J\u0012\u0010¡\u0001\u001a\u00020-2\u0007\u0010¢\u0001\u001a\u00020@H\u0002J\t\u0010£\u0001\u001a\u00020-H\u0002J\t\u0010¤\u0001\u001a\u00020-H\u0002J\u0017\u0010¥\u0001\u001a\u00020-2\f\u0010¦\u0001\u001a\u0007\u0012\u0002\b\u00030§\u0001H\u0002J\t\u0010¨\u0001\u001a\u00020-H\u0002J\n\u0010©\u0001\u001a\u00030ª\u0001H\u0002J2\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020&0,2\u0012\u0010¬\u0001\u001a\r\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u00ad\u00010,2\r\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020Z0,H\u0002J$\u0010¯\u0001\u001a\u00020-2\u0019\u0010°\u0001\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0,\u0012\u0004\u0012\u00020-0+H\u0002J!\u0010±\u0001\u001a\u00020-2\u0007\u0010²\u0001\u001a\u00020@2\r\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020&0,H\u0002J\t\u0010´\u0001\u001a\u00020(H\u0002J\u0012\u0010µ\u0001\u001a\u00020-2\u0007\u0010¶\u0001\u001a\u00020ZH\u0002J\u0013\u0010·\u0001\u001a\u00020-2\b\u0010¸\u0001\u001a\u00030¹\u0001H\u0007J\u0014\u0010½\u0001\u001a\u00020-2\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u0010¿\u0001\u001a\u00020-2\b\u0010À\u0001\u001a\u00030Á\u00012\u0007\u0010Â\u0001\u001a\u00020(H\u0002J\u0014\u0010Ã\u0001\u001a\u00020Z2\t\u0010Ä\u0001\u001a\u0004\u0018\u00010ZH\u0002J\t\u0010Å\u0001\u001a\u00020-H\u0002J\t\u0010Æ\u0001\u001a\u00020ZH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010*\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0,\u0012\u0004\u0012\u00020-\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b3\u00104R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b9\u0010:R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u00106\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u00106\u001a\u0004\bE\u0010BR\u001b\u0010G\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u00106\u001a\u0004\bH\u0010BR\u001b\u0010J\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u00106\u001a\u0004\bK\u0010BR\u0010\u0010M\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010Y\u001a\u00020Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u00106\u001a\u0004\b[\u0010\\R\u0010\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`R\u0010\u0010a\u001a\u00020bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010cR\u0010\u0010d\u001a\u00020eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010fR\u001b\u0010g\u001a\u00020h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u00106\u001a\u0004\bi\u0010jR\u001b\u0010l\u001a\u00020m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u00106\u001a\u0004\bn\u0010oR\u0010\u0010q\u001a\u00020rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010sR\u001b\u0010t\u001a\u00020u8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u00106\u001a\u0004\bv\u0010wR\u001b\u0010y\u001a\u00020z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b}\u00106\u001a\u0004\b{\u0010|R\u001e\u0010~\u001a\u00020\u007f8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0082\u0001\u00106\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0013\u0010º\u0001\u001a\u00030»\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¼\u0001¨\u0006È\u0001"}, d2 = {"Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin;", "Lcom/ss/android/lark/chat/chatwindow/biz/plugin/core/CommonChatPlugin;", "shareScene", "Lcom/ss/android/lark/biz/officesdk/im/share/IOfficeSDKShareScene;", "<init>", "(Lcom/ss/android/lark/biz/officesdk/im/share/IOfficeSDKShareScene;)V", "getShareScene", "()Lcom/ss/android/lark/biz/officesdk/im/share/IOfficeSDKShareScene;", "chatApp", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/IChatWindowApp;", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "messageListComponent", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent;", "bannerComponent", "Lcom/ss/android/lark/flow/chat/component/banner/IFlowBottomBannerComponent;", "titleBarComponent", "Lcom/ss/android/lark/chat/chatwindow/biz/component/titlebar/ITitlebarComponent;", "keyboardComponent", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/IKeyboardWrapperComponent;", "keyboardWrapper", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/IKeyboardWrapper;", "mMessageListRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mMultiSelectStub", "Landroid/view/ViewStub;", "mMultiSelectContainer", "Landroid/view/View;", "mMultiSelectActionContainer", "mMultiSelectCancelLayout", "mMultiSelectActionScrollContainer", "mSelectMessageContainer", "mSelectMessageOk", "Landroid/widget/TextView;", "mFollowingSelectLine", "Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowFollowingSelectLine;", "followingSelectedMsgList", "", "Lcom/ss/android/lark/dto/chat/GetMessageIdsByPositionResponse$MessageTypeInfo;", "isPulledFollowingIds", "", "pullFollowingIdsComplete", "onPullFollowingIdsComplete", "Lkotlin/Function1;", "", "", "followingSelectScope", "Lkotlinx/coroutines/CoroutineScope;", "isAdapterObserverRegistered", "loadingRunnable", "Ljava/lang/Runnable;", "getLoadingRunnable", "()Ljava/lang/Runnable;", "loadingRunnable$delegate", "Lkotlin/Lazy;", "recyclerViewAdapterObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "getRecyclerViewAdapterObserver", "()Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "recyclerViewAdapterObserver$delegate", "mCurrentMode", "Lcom/ss/android/lark/chat/chatwindow/biz/component/messagelist/render/cell/ListMode;", "openPageForMessageSelectPurpose", "titleBarHeight", "", "getTitleBarHeight", "()I", "titleBarHeight$delegate", "checkboxHeight", "getCheckboxHeight", "checkboxHeight$delegate", "avatarHeight", "getAvatarHeight", "avatarHeight$delegate", "checkboxTopMargin", "getCheckboxTopMargin", "checkboxTopMargin$delegate", "panelView", "selectMessageStub", "hasSelectDoubao", "abandonContainerStub", "abandonContainer", "abandonMainTitle", "abandonSubTitleContainer", "Landroid/widget/LinearLayout;", "abandonSubTitle1", "abandonSubTitle2", "abandonSubTitle3", "isAbandonWithHideKeyBoard", "brandName", "", "getBrandName", "()Ljava/lang/String;", "brandName$delegate", "activityResultHandler", "com/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$activityResultHandler$1", "Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$activityResultHandler$1;", "badgeInterceptor", "com/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$badgeInterceptor$1", "Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$badgeInterceptor$1;", "leftActionInterceptor", "com/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$leftActionInterceptor$1", "Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$leftActionInterceptor$1;", "selectMessageAction", "com/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$selectMessageAction$2$1", "getSelectMessageAction", "()Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$selectMessageAction$2$1;", "selectMessageAction$delegate", "cancelMultiSelectAction", "com/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$cancelMultiSelectAction$2$1", "getCancelMultiSelectAction", "()Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$cancelMultiSelectAction$2$1;", "cancelMultiSelectAction$delegate", "rightActionInterceptor", "com/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$rightActionInterceptor$1", "Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$rightActionInterceptor$1;", "centerViewProvider", "com/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$centerViewProvider$2$1", "getCenterViewProvider", "()Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$centerViewProvider$2$1;", "centerViewProvider$delegate", "mSelectedMessageChangeListener", "com/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$mSelectedMessageChangeListener$2$1", "getMSelectedMessageChangeListener", "()Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$mSelectedMessageChangeListener$2$1;", "mSelectedMessageChangeListener$delegate", "scrollListener", "com/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$scrollListener$2$1", "getScrollListener", "()Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$scrollListener$2$1;", "scrollListener$delegate", "onCreate", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "checkIfNeedEnterAbandonMode", "initAbandonContainer", "checkIfNeedEnterSelectMode", "onDestroy", "changeToSelectMessagesForCallerMode", "initSelectMessageIfNeed", "initFollowingSelectLineIfNeed", "initFollowingLine", "pullFollowingMessages", "messagePosition", "filterFollowingSelectCotMessages", "messages", "submitFollowingSelectedMessages", "finishFollowingMessagePull", "findFirstItemUnderMultiLine", "firstVisiblePosition", "isViewUnderMultiLine", "messageView", "registerAdapterDataObserver", "unregisterAdapterDataObserver", "createRecyclerViewAdapterObserver", "com/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$createRecyclerViewAdapterObserver$1", "()Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$createRecyclerViewAdapterObserver$1;", "onMessageListDataChanged", "changeFollowingLineVisibility", "needShowFollowingSelectLine", "isFollowingSelectSupported", "changeToMultiSelectMode", "selectedPosition", "backToNormalMode", "updateVisibleBubblesStickyPosition", "updateBubbleStickyPosition", "cell", "Lcom/ss/android/lark/blueprint/BlueprintCell;", "initMultiSelectPanel", "getMultiSelectActionContext", "Lcom/ss/android/lark/biz/im/api/extension/message/MultiSelectContext;", "margeSelectIds", "localMsgs", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "followingIds", "getSelectedMessageTypeInfos", "callback", "logForMultiSelect", "actionId", "messageTypeInfoList", "isFollowingSelectMessage", "showToast", "msg", "onMultiSelectActed", "event", "Lcom/ss/android/lark/flow/chat/multi_select/MultiSelectResultEvent;", "backInterceptor", "com/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$backInterceptor$1", "Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowMessageSelectPlugin$backInterceptor$1;", "updateAbandonView", "newChat", "handleAbandonSubTextView", "systemBannedInfo", "Lcom/ss/android/lark/chat/entity/chat/ChatTnsSystemBannedInfo;", "isGroupOwnerOrAdmin", "getSelectMessagesPageTitle", "jsonString", "checkHasDoubaoType", "getDoubaoDisableTip", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowMessageSelectPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public static final /* synthetic */ int f0 = 0;
    public CoroutineScope A;
    public boolean B;
    public final Lazy C;
    public final Lazy D;
    public ListMode E;
    public boolean F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy J;
    public View K;
    public boolean L;
    public ViewStub M;
    public View N;
    public TextView O;
    public LinearLayout P;
    public TextView Q;
    public TextView R;
    public TextView S;
    public boolean T;
    public final Lazy U;
    public final b V;
    public final d W;
    public final f X;
    public final Lazy Y;
    public final Lazy Z;
    public final i a0;
    public final Lazy b0;
    public final Lazy c0;
    public final Lazy d0;
    public final c e0;
    public final IOfficeSDKShareScene g;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c h;
    public Chat i;
    public IMessageListComponent j;
    public IFlowBottomBannerComponent k;
    public ITitlebarComponent l;
    public IKeyboardWrapperComponent m;
    public IKeyboardWrapper n;
    public RecyclerView o;
    public View p;
    public View q;
    public View r;
    public View s;
    public View t;
    public TextView u;
    public FlowFollowingSelectLine v;
    public final List<ccb.c.a> w;
    public boolean x;
    public boolean y;
    public Function1<? super List<ccb.c.a>, Unit> z;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.chat.chatwindow.chat.v2.component.c.b {
        public final /* synthetic */ FlowMessageSelectPlugin a;

        public b(FlowMessageSelectPlugin r1) {
            this.a = r1;
        }

        public final boolean b(int r2, int r3, Intent r4) {
            if (r3 != (-1)) goto L10;
            if (r4 != null) goto L7;
            return false;
        L7:
            if (r2 != 9) goto L12;
            FlowMessageSelectPlugin r5 = this.a;
            int r6 = FlowMessageSelectPlugin.f0;
            r5.J();
            return true;
        L12:
            return false;
        L10:
            return false;
        }
    }

    public static final class c implements com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey> {
        public final /* bridge */ /* synthetic */ boolean a(TitleBarActionKey r1) {
            return false;
        }

        public c() {
        }
    }

    public static final class d implements com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey> {
        public d() {
        }

        public final boolean a(TitleBarActionKey r2) {
            Intrinsics.checkNotNullParameter(r2, "param");
            if (r2 != TitleBarActionKey.BADGE) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class e extends OnSingleClickListener {
        public final /* synthetic */ FlowMessageSelectPlugin a;

        public e(FlowMessageSelectPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin$pullFollowingMessages$1] */
        public final void onSingleClick(View r10) {
            Intrinsics.checkNotNullParameter(r10, "v");
            RecyclerView r11 = this.a.o;
            if (r11 == null) goto L5;
            RecyclerView.LayoutManager r12 = r11.getLayoutManager();
        L7:
            if ((r12 instanceof LinearLayoutManager) == false) goto L9;
            LinearLayoutManager r13 = (LinearLayoutManager) r12;
        L10:
            int r1 = -1;
            if (r13 == null) goto L13;
            int r14 = r13.findFirstVisibleItemPosition();
        L14:
            FlowMessageSelectPlugin r2 = this.a;
            RecyclerView r3 = r2.o;
            if (r3 == null) goto L51;
            RecyclerView.LayoutManager r4 = r3.getLayoutManager();
            if (r4 == null) goto L51;
            View r5 = r4.findViewByPosition(r14);
            if (r5 == null) goto L51;
        L20:
            BlueprintCell r6 = yza.a.b(r5);
            if ((r6 instanceof BlueprintCell) == false) goto L23;
            BlueprintCell r7 = r6;
        L24:
            if (r7 == null) goto L42;
            q r8 = r7.l();
            if (r8 == null) goto L42;
            k r9 = r8.f(IMMessageKeys.Blocks.MULTI_SELECT, IMMessageKeys.Slots.SELECT);
            if (r9 == null) goto L42;
            View r15 = r9.getView();
            if (r15 == null) goto L42;
            FlowFollowingSelectLine r16 = r2.v;
            if (r16 == null) goto L42;
            Rect r17 = new Rect();
            Rect r18 = new Rect();
            if (r15.getGlobalVisibleRect(r17) == false) goto L42;
            if (r16.getGlobalVisibleRect(r18) == false) goto L42;
            if (r18.bottom > r17.bottom) goto L42;
            boolean r19 = true;
        L43:
            if (r19 == true) goto L51;
            r14 = r14 + 1;
            RecyclerView r20 = r2.o;
            if (r20 == null) goto L51;
            RecyclerView.LayoutManager r21 = r20.getLayoutManager();
            if (r21 == null) goto L51;
            r5 = r21.findViewByPosition(r14);
            if (r5 == null) goto L51;
        L42:
            r19 = false;
            goto L43
        L23:
            r7 = null;
        L51:
            IMessageListComponent r22 = this.a.j;
            if (r22 == null) goto L54;
            r1 = r22.RT(r14);
        L54:
            if (r14 < 0) goto L62;
            FlowFollowingSelectLine r23 = this.a.v;
            if (r23 == null) goto L58;
            r23.setCurrentSelectCount(0);
        L58:
            IMessageListComponent r24 = this.a.j;
            if (r24 == null) goto L62;
            r24.yU(r14);
        L62:
            if (r1 < 0) goto L67;
            final FlowMessageSelectPlugin r25 = this.a;
            ((ArrayList) r25.w).clear();
            r25.x = true;
            r25.y = false;
            p r26 = ImSdkService.f();
            Chat r27 = r25.i;
            if (r27 != null) goto L66;
            Intrinsics.throwUninitializedPropertyAccessException("chat");
            r27 = null;
        L66:
            r26.W2(r27.getId(), r1, new FlowMessageSelectPlugin$pullFollowingMessages$1(r25));
            UICallbackExecutor.execute((Runnable) r25.C.getValue());
        L67:
            Lazy r28 = MultiSelectHitPointNew.a;
            Chat r29 = this.a.i;
            if (r29 != null) goto L70;
            Intrinsics.throwUninitializedPropertyAccessException("chat");
            r29 = null;
        L70:
            MultiSelectHitPointNew.a.a(r29, null, "select_follow_msg", "none");
            int r110 = com.ss.android.lark.statistics.multiselect.a.a;
            Statistics.sendEvent("multiselect_followingmessage_click");
            return;
        L13:
            r14 = -1;
            goto L14
        L9:
            r13 = null;
            goto L10
        L5:
            r12 = null;
            goto L7
        }
    }

    public static final class f implements com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey> {
        public f() {
        }

        public final boolean a(TitleBarActionKey r2) {
            Intrinsics.checkNotNullParameter(r2, "param");
            if (r2 == TitleBarActionKey.CANCEL_MULTI_SELECT) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class g extends o {
        public final /* synthetic */ FlowMessageSelectPlugin a;

        public final void E(String r2) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
        }

        public g(FlowMessageSelectPlugin r1) {
            this.a = r1;
        }

        public final void R(int r17) {
            Lazy r1 = MultiSelectHitPointNew.a;
            Chat r2 = this.a.i;
            ViewGroup r3 = null;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("chat");
            r2 = null;
        L5:
            if (r2 == null) goto L8;
            Statistics.sendEvent("im_msg_multi_select_view", new JSONObject(ChatParamUtils.b(r2, (String) MultiSelectHitPointNew.a.getValue(), 4)));
        L8:
            int r4 = com.ss.android.lark.statistics.multiselect.a.a;
            Statistics.sendEvent("multiselect_enter");
            final FlowMessageSelectPlugin r5 = this.a;
            r5.getClass();
            Collection r6 = ChatCoreModule.a().getExtensionDependency().d();
            com.ss.android.lark.flow.chat.page.flow.plugin.select.f r7 = new com.ss.android.lark.flow.chat.page.flow.plugin.select.f(r5);
            final ArrayList r8 = new ArrayList();
            Intrinsics.checkNotNull(r6);
            ArrayList r9 = new ArrayList();
            Iterator r10 = r6.iterator();
        L9:
            boolean r11 = false;
            if (r10.hasNext() == false) goto L18;
            Object r12 = r10.next();
            com.ss.android.lark.biz.im.api.extension.message.k r13 = (com.ss.android.lark.biz.im.api.extension.message.k) r12;
            if (r13.c().contains(MultiSelectContext.Page.CHAT_WINDOW) == true) goto L14;
        L16:
            if (r11 == false) goto L9;
            r9.add(r12);
            goto L9
        L14:
            if (r13.b(r7) == false) goto L16;
            r11 = true;
            goto L16
        L18:
            Iterator r14 = r9.iterator();
        L20:
            if (r14.hasNext() == false) goto L22;
            r8.add(((com.ss.android.lark.biz.im.api.extension.message.k) r14.next()).a(r7, r5.B()));
            goto L20
        L22:
            CollectionsKt.sortWith(r8, com.ss.android.lark.flow.chat.page.flow.plugin.select.h.a);
            int r15 = FlowChatModule.d;
            uza.a r16 = FlowChatModule.a.a().b;
            if (r16 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("officeSDKSharePanel");
            r16 = null;
        L26:
            r5.K = r16.d0(new uza.b(r5.B().requireActivity(), r5.g, null, new FlowMessageSelectPlugin$initMultiSelectPanel$4(r8), new FlowMessageSelectPlugin$initMultiSelectPanel$5(r5, r8), 28));
            r5.L();
            IMessageListComponent r18 = r5.j;
            if (r18 == null) goto L56;
            RelativeLayout r19 = r18.UI();
            if (r19 == null) goto L56;
            if (r5.p != null) goto L45;
            r5.o = r19.findViewById(2131365561);
            ViewStub r20 = (ViewStub) r19.findViewById(2131380447);
            View r21 = r19;
            if (r20 == null) goto L39;
            View r22 = r20.inflate();
            r21 = r19;
            if (r22 == null) goto L39;
            r21 = r22;
        L39:
            r5.p = r21.findViewById(2131380446);
            r5.r = r21.findViewById(2131380427);
            r5.q = r21.findViewById(2131380444);
            r5.s = r21.findViewById(2131380445);
            View r23 = r5.p;
            if ((r23 instanceof ViewGroup) == false) goto L42;
            ViewGroup r24 = (ViewGroup) r23;
        L43:
            if (r24 == null) goto L45;
            View r25 = new View(r5.getContext());
            r25.setLayoutParams(new ViewGroup.LayoutParams(-1, UIHelper.dp2px(1.0f)));
            r25.setBackgroundResource(2131102045);
            r24.addView(r25);
            goto L45
        L42:
            r24 = null;
        L45:
            View r26 = r5.s;
            if (r26 == null) goto L48;
            r26.setBackgroundResource(2131102028);
            int r27 = UIUtils.dp2px(r26.getContext(), 16.0f);
            r26.setPadding(0, r27, 0, r27);
        L48:
            View r28 = r5.q;
            if ((r28 instanceof ViewGroup) == false) goto L51;
            r3 = (ViewGroup) r28;
        L51:
            if (r3 == null) goto L55;
            r3.removeAllViews();
            View r29 = r5.K;
            if (r29 == null) goto L55;
            r3.addView(r29);
        L55:
            r5.Q();
        L56:
            IKeyboardWrapper r30 = r5.n;
            if (r30 == null) goto L59;
            r30.hideKeyboard();
        L59:
            ITitlebarComponent r31 = r5.l;
            if (r31 == null) goto L64;
            FlowTitleBarComponent.LeftAreaImpl r32 = r31.x00();
            if (r32 == null) goto L64;
            r32.b(r5.X);
        L64:
            ITitlebarComponent r33 = r5.l;
            if (r33 == null) goto L69;
            FlowTitleBarComponent.LeftAreaImpl r34 = r33.x00();
            if (r34 == null) goto L69;
            r34.a((FlowMessageSelectPlugin$cancelMultiSelectAction$2.a) r5.Z.getValue());
        L69:
            ITitlebarComponent r35 = r5.l;
            if (r35 == null) goto L74;
            FlowTitleBarComponent.RightAreaImpl r36 = r35.F00();
            if (r36 == null) goto L74;
            r36.b(r5.a0);
        L74:
            ITitlebarComponent r37 = r5.l;
            if (r37 == null) goto L79;
            FlowTitleBarComponent.a r38 = r37.XA();
            if (r38 == null) goto L79;
            r38.a((FlowMessageSelectPlugin$centerViewProvider$2.a) r5.b0.getValue());
        L79:
            View r39 = r5.r;
            if (r39 == null) goto L82;
            r39.setOnClickListener(new com.ss.android.lark.flow.chat.page.flow.plugin.select.a(r5));
        L82:
            IMessageListComponent r40 = r5.j;
            if (r40 == null) goto L85;
            r40.Ml((FlowMessageSelectPlugin$mSelectedMessageChangeListener$2.a) r5.c0.getValue());
        L85:
            r5.T();
            ListMode r41 = ListMode.MULTI_SELECT;
            r5.E = r41;
            IMessageListComponent r42 = r5.j;
            if (r42 == null) goto L88;
            r42.Y00(r41, r17);
        L88:
            IFlowBottomBannerComponent r43 = r5.k;
            if (r43 == null) goto L91;
            r43.hO(false);
        L91:
            View r44 = r5.p;
            if (r44 == null) goto L94;
            r44.setVisibility(0);
        L94:
            View r45 = r5.t;
            if (r45 == null) goto L97;
            r45.setVisibility(8);
        L97:
            RecyclerView r46 = r5.o;
            if (r46 == null) goto L100;
            r46.post(new com.ss.android.lark.flow.chat.page.flow.plugin.select.b(r5));
        L100:
            r5.P();
        }
    }

    public static final class h implements com.ss.android.lark.chat.chatwindow.chat.v2.component.c.c {
        public final /* synthetic */ FlowMessageSelectPlugin a;

        public final boolean l1() {
            FlowMessageSelectPlugin r0 = this.a;
            ListMode r1 = r0.E;
            if (r1 != ListMode.NORMAL) goto L5;
            return false;
        L5:
            if (r1 == ListMode.SELECT_MESSAGES_FOR_CALLER) goto L7;
        L9:
            r0.J();
            return true;
        L7:
            if (r0.F == false) goto L9;
            return false;
        }

        public h(FlowMessageSelectPlugin r1) {
            this.a = r1;
        }
    }

    public static final class i implements com.ss.android.lark.biz.im.api.extension.chat_window.a<TitleBarActionKey> {
        public i() {
        }

        public final boolean a(TitleBarActionKey r2) {
            Intrinsics.checkNotNullParameter(r2, "param");
            return true;
        }
    }

    static {
    }

    public FlowMessageSelectPlugin() {
        this(0);
    }

    public final void D() {
        if (this.B == false) goto L11;
        RecyclerView r0 = this.o;
        if (r0 == null) goto L10;
        RecyclerView.Adapter r1 = r0.getAdapter();
        if (r1 == null) goto L10;
        r1.unregisterAdapterDataObserver((RecyclerView.AdapterDataObserver) this.D.getValue());
    L10:
        this.B = false;
    L11:
        CoroutineScope r2 = this.A;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3 = null;
        if (r2 == null) goto L14;
        CoroutineScopeKt.cancel$default(r2, null, 1, null);
    L14:
        this.A = null;
        UICallbackExecutor.removeCallbacks((Runnable) this.C.getValue());
        LKUIToast.cancelLoading();
        this.z = null;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r4 = this.h;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("chatApp");
    L18:
        r3.s(this.V);
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.D();
        EventBus.getDefault().unregister(this);
        return;
    L17:
        r3 = r4;
        goto L18
    }

    public final void J() {
        IKeyboardWrapper r0 = this.n;
        if (r0 == null) goto L5;
        r0.I();
    L5:
        ITitlebarComponent r1 = this.l;
        if (r1 == null) goto L10;
        FlowTitleBarComponent.LeftAreaImpl r2 = r1.x00();
        if (r2 == null) goto L10;
        r2.f(this.W);
    L10:
        ITitlebarComponent r3 = this.l;
        if (r3 == null) goto L15;
        FlowTitleBarComponent.LeftAreaImpl r4 = r3.x00();
        if (r4 == null) goto L15;
        r4.e(TitleBarActionKey.CANCEL_MULTI_SELECT);
        r4.f(this.X);
    L15:
        ITitlebarComponent r5 = this.l;
        if (r5 == null) goto L20;
        FlowTitleBarComponent.RightAreaImpl r6 = r5.F00();
        if (r6 == null) goto L20;
        r6.f(this.a0);
    L20:
        ITitlebarComponent r7 = this.l;
        if (r7 == null) goto L25;
        FlowTitleBarComponent.a r8 = r7.XA();
        if (r8 == null) goto L25;
        r8.c((FlowMessageSelectPlugin$centerViewProvider$2.a) this.b0.getValue());
    L25:
        IMessageListComponent r9 = this.j;
        if (r9 == null) goto L28;
        r9.Y00(ListMode.NORMAL, -1);
    L28:
        IFlowBottomBannerComponent r10 = this.k;
        if (r10 == null) goto L32;
        r10.hO(true);
    L32:
        if (this.B == false) goto L40;
        RecyclerView r11 = this.o;
        if (r11 == null) goto L39;
        RecyclerView.Adapter r12 = r11.getAdapter();
        if (r12 == null) goto L39;
        r12.unregisterAdapterDataObserver((RecyclerView.AdapterDataObserver) this.D.getValue());
    L39:
        this.B = false;
    L40:
        View r13 = this.p;
        if (r13 == null) goto L43;
        r13.setVisibility(8);
    L43:
        View r14 = this.t;
        if (r14 == null) goto L46;
        r14.setVisibility(8);
    L46:
        FlowFollowingSelectLine r15 = this.v;
        if (r15 == null) goto L49;
        r15.setVisibility(8);
    L49:
        FlowFollowingSelectLine r16 = this.v;
        if (r16 == null) goto L52;
        r16.setCurrentSelectCount(0);
    L52:
        ((ArrayList) this.w).clear();
        this.x = false;
        this.y = false;
        this.z = null;
        UICallbackExecutor.removeCallbacks((Runnable) this.C.getValue());
        LKUIToast.cancelLoading();
        this.E = ListMode.NORMAL;
    }

    public final void K() {
        FlowFollowingSelectLine r0 = this.v;
        if (r0 == null) goto L40;
        boolean r3 = true;
        int r4 = 0;
        if (this.g != IOfficeSDKShareScene.CHAT) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L34;
        Chat r2 = this.i;
        if (r2 != null) goto L13;
    L15:
        RecyclerView r5 = this.o;
        if (r5 == null) goto L18;
        int r6 = r5.computeVerticalScrollRange();
    L19:
        RecyclerView r7 = this.o;
        if (r7 == null) goto L22;
        int r8 = r7.getHeight();
    L23:
        if (r6 > r8) goto L35;
        IMessageListComponent r9 = this.j;
        if (r9 == null) goto L28;
        List r10 = r9.h20();
    L29:
        if (r10 != null) goto L32;
        r10 = CollectionsKt.emptyList();
    L32:
        if (SequencesKt.count(SequencesKt.take(SequencesKt.filter(CollectionsKt.asSequence(r10), FlowMessageSelectPlugin$needShowFollowingSelectLine$1.INSTANCE), 5)) < 5) goto L34;
    L28:
        r10 = null;
    L35:
        if (r3 == true) goto L38;
        r4 = 8;
    L38:
        r0.setVisibility(r4);
        return;
    L22:
        r8 = 0;
        goto L23
    L18:
        r6 = 0;
        goto L19
    L13:
        if (r2.isAIChat() == false) goto L15;
    L34:
        r3 = false;
        goto L35
    L7:
        r1 = false;
        goto L8
    }

    public final void L() {
        IMessageListComponent r0 = this.j;
        String r1 = null;
        if (r0 == null) goto L8;
        List<ccb.c.a> r2 = S(r0.gK(), r0.pP());
        Map r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16));
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L9;
        ccb.c.a r5 = (ccb.c.a) r4.next();
        Pair r6 = TuplesKt.to(r5.a, r5.getType());
        r3.put(r6.getFirst(), r6.getSecond());
    L9:
        if (r3 != null) goto L11;
        r3 = MapsKt.emptyMap();
    L11:
        boolean r7 = false;
        if (r3.isEmpty() == true) goto L24;
        Iterator r8 = r3.entrySet().iterator();
    L16:
        if (r8.hasNext() == false) goto L24;
        if (Message.Type.DOUBAO != ((Message.Type) ((Map.Entry) r8.next()).getValue())) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L16;
        r7 = true;
        goto L24
    L20:
        r9 = false;
    L24:
        if (this.L != r7) goto L26;
        return;
    L26:
        this.L = r7;
        int r10 = FlowChatModule.d;
        uza.a r11 = FlowChatModule.a.a().b;
        if (r11 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("officeSDKSharePanel");
        r11 = null;
    L30:
        View r12 = this.K;
        IOfficeSDKSharePanelType r13 = IOfficeSDKSharePanelType.SINGLE_FORWARD;
        boolean r14 = !r7;
        if (r7 == false) goto L33;
        ICUUtils.FormatArgsBuilder r15 = new ICUUtils.FormatArgsBuilder();
        r15.b("brandName", (String) this.U.getValue());
        r1 = ICUUtils.icuFormat(UIHelper.getString(2131890163), r15.a);
    L33:
        r11.W0(r12, CollectionsKt.listOf(new uza.c(r13, r14, r1)));
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final int M() {
        return ((Number) this.H.getValue()).intValue();
    }

    public final int N() {
        return ((Number) this.J.getValue()).intValue();
    }

    public final int O() {
        return ((Number) this.G.getValue()).intValue();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void P() {
        if (this.g != IOfficeSDKShareScene.CHAT) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        K();
        this.x = false;
        this.y = false;
        this.z = null;
        FlowFollowingSelectLine r1 = this.v;
        if (r1 == null) goto L12;
        r1.setSelectTipClickListener(new e(this));
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void Q() {
        int r2 = 0;
        if (this.g != IOfficeSDKShareScene.CHAT) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        IMessageListComponent r1 = this.j;
        if (r1 == null) goto L23;
        RelativeLayout r3 = r1.UI();
        if (r3 != null) goto L14;
        return;
    L14:
        if (this.v == null) goto L16;
        return;
    L16:
        FlowFollowingSelectLine r4 = new FlowFollowingSelectLine(getContext());
        r4.setVisibility(8);
        r4.setSelectLimit(100);
        this.v = r4;
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(-1, -2);
        r5.addRule(14);
        r5.addRule(10);
        ITitlebarComponent r6 = this.l;
        if (r6 == null) goto L21;
        View r7 = r6.getTitleView();
        if (r7 == null) goto L21;
        r2 = r7.getHeight();
    L21:
        r5.topMargin = r2 + UIHelper.dp2px(6.0f);
        r3.addView(this.v, r5);
        K();
        return;
    L23:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean R() {
        IMessageListComponent r0 = this.j;
        if (r0 == null) goto L5;
        List r1 = r0.pP();
    L6:
        List r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L14:
        return !r3;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public final void T() {
        if (this.B == false) goto L5;
        return;
    L5:
        RecyclerView r0 = this.o;
        if (r0 == null) goto L10;
        RecyclerView.Adapter r1 = r0.getAdapter();
        if (r1 == null) goto L10;
        r1.registerAdapterDataObserver((RecyclerView.AdapterDataObserver) this.D.getValue());
    L10:
        RecyclerView r2 = this.o;
        if (r2 == null) goto L13;
        RecyclerView.Adapter r3 = r2.getAdapter();
    L14:
        if (r3 == null) goto L16;
        boolean r4 = true;
    L17:
        this.B = r4;
        return;
    L16:
        r4 = false;
        goto L17
    L13:
        r3 = null;
        goto L14
    }

    public FlowMessageSelectPlugin(IOfficeSDKShareScene r2) {
        Intrinsics.checkNotNullParameter(r2, "shareScene");
        this.g = r2;
        this.w = new ArrayList();
        this.C = LazyKt.lazy(new FlowMessageSelectPlugin$loadingRunnable$2(this));
        this.D = LazyKt.lazy(new FlowMessageSelectPlugin$recyclerViewAdapterObserver$2(this));
        this.E = ListMode.NORMAL;
        this.G = LazyKt.lazy(new FlowMessageSelectPlugin$titleBarHeight$2(this));
        this.H = LazyKt.lazy(new FlowMessageSelectPlugin$checkboxHeight$2(this));
        this.I = LazyKt.lazy(new FlowMessageSelectPlugin$avatarHeight$2(this));
        this.J = LazyKt.lazy(new FlowMessageSelectPlugin$checkboxTopMargin$2(this));
        this.U = LazyKt.lazy(FlowMessageSelectPlugin$brandName$2.INSTANCE);
        this.V = new b(this);
        this.W = new d();
        this.X = new f();
        this.Y = LazyKt.lazy(new FlowMessageSelectPlugin$selectMessageAction$2(this));
        this.Z = LazyKt.lazy(new FlowMessageSelectPlugin$cancelMultiSelectAction$2(this));
        this.a0 = new i();
        this.b0 = LazyKt.lazy(new FlowMessageSelectPlugin$centerViewProvider$2(this));
        this.c0 = LazyKt.lazy(new FlowMessageSelectPlugin$mSelectedMessageChangeListener$2(this));
        this.d0 = LazyKt.lazy(new FlowMessageSelectPlugin$scrollListener$2(this));
        this.e0 = new c();
    }

    public static final void H(FlowMessageSelectPlugin r2) {
        r2.K();
        RecyclerView r0 = r2.o;
        if (r0 == null) goto L6;
        r0.addOnLayoutChangeListener(new com.ss.android.lark.flow.chat.page.flow.plugin.select.i(r2));
        return;
    }

    public static final void I(FlowMessageSelectPlugin r6) {
        if (r6.E == ListMode.NORMAL) goto L36;
        RecyclerView r0 = r6.o;
        if (r0 == null) goto L30;
        LinearLayoutManager r1 = r0.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == false) goto L10;
        LinearLayoutManager r2 = r1;
    L11:
        if (r2 == null) goto L34;
        int r3 = r2.findLastVisibleItemPosition();
        int r4 = r2.findFirstVisibleItemPosition();
        if (r4 > r3) goto L35;
    L31:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L26
        View r7 = r2.findViewByPosition(r3);     // Catch: Throwable -> L26
        if (r7 == null) goto L24;
        m r8 = yza.a.b(r7);     // Catch: Throwable -> L26
        if ((r8 instanceof BlueprintCell) == false) goto L20;
        BlueprintCell<?> r9 = (BlueprintCell) r8;     // Catch: Throwable -> L26
    L21:
        if (r9 == null) goto L24;
        r6.V(r9);     // Catch: Throwable -> L26
        goto L24
    L20:
        r9 = null;
    L24:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        if (r3 == r4) goto L37;
        r3 = r3 - 1;
        goto L31
    L37:
        return;
    L26:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L35:
        return;
    L34:
        return;
    L10:
        r2 = null;
        goto L11
    L30:
        return;
    }

    public final void U(Chat r30) {
        if (this.F == false) goto L6;
        Log.i("FlowMessageSelectPlugin", "updateAbandonView, openPageForMessageSelectPurpose true");
        return;
    L6:
        if (r30 != null) goto L8;
        return;
    L8:
        ChatTnsInfo r1 = r30.getChatTnsInfo();
        if (r1 == null) goto L11;
        ChatTnsSystemBannedInfo r4 = r1.getSystemBannedInfo();
    L13:
        if (r1 != null) goto L15;
    L18:
        boolean r2 = false;
    L19:
        StringBuilder r7 = new StringBuilder("updateAbandonView, needShow: ");
        r7.append(r2);
        r7.append(", chatId: ");
        r7.append(r30.getId());
        r7.append(", systemBannedInfo: ");
        if (r4 == null) goto L22;
        boolean r8 = true;
    L23:
        r7.append(r8);
        Log.i("FlowMessageSelectPlugin", r7.toString());
        if (r2 == false) goto L157;
        IMessageListComponent r3 = this.j;
        if (r3 == null) goto L48;
        RelativeLayout r5 = r3.UI();
        if (r5 == null) goto L48;
        if (this.M != null) goto L33;
    L35:
        ViewStub r9 = (ViewStub) r5.findViewById(2131365613);
        this.M = r9;
        View r6 = r5;
        if (r9 == null) goto L41;
        View r10 = r9.inflate();
        r6 = r5;
        if (r10 == null) goto L41;
        r6 = r10;
    L41:
        View r11 = r6.findViewById(2131365612);
        this.N = r11;
        if (r11 == null) goto L44;
        r11.setBackgroundColor(UIUtils.getColor(getContext(), 2131101983));
    L44:
        TextView r12 = (TextView) r6.findViewById(2131390917);
        this.O = r12;
        if (r12 == null) goto L47;
        r12.setTextColor(UIUtils.getColor(getContext(), 2131102040));
    L47:
        this.P = (LinearLayout) r6.findViewById(2131378894);
        this.Q = (TextView) r6.findViewById(2131391525);
        this.R = (TextView) r6.findViewById(2131391526);
        this.S = (TextView) r6.findViewById(2131391527);
        goto L48
    L33:
        if (this.N == null) goto L35;
    L48:
        IKeyboardWrapper r13 = this.n;
        if (r13 == null) goto L52;
        r13.hideKeyboard();
    L52:
        if (Intrinsics.areEqual(ChatCoreModule.a().getPassportDependency().userId(), r30.getOwnerId()) == true) goto L54;
    L56:
        boolean r14 = false;
    L58:
        if (r4.isPermanent() != true) goto L65;
        if (r14 == false) goto L61;
    L64:
        int r15 = 2131890191;
    L71:
        TextView r16 = this.O;
        if (r16 == null) goto L74;
        r16.setText(UIUtils.getString(getContext(), r15));
    L74:
        if (r14 == false) goto L76;
    L79:
        boolean r17 = true;
    L80:
        long r18 = 0;
        if (TextUtils.isEmpty(r4.getAppealUrl()) == true) goto L130;
        if (r17 == false) goto L130;
        if (r4.isPermanent() == false) goto L86;
        String r19 = UIUtils.getString(getContext(), 2131890190);
    L87:
        Intrinsics.checkNotNull(r19);
        String r110 = StringsKt.substringBefore$default(r19, "{appeal}", null, 2, null);
        int r111 = UIUtils.getColor(getContext(), 2131102042);
        Long r112 = r4.getExpireAt();
        if (r112 == null) goto L90;
        r18 = r112.longValue();
    L90:
        ChatTnsSystemBannedInfo r113 = r4;
        String r20 = c7c.b.a(getContext(), new Date(r18 * ((long) AudioViewModel.ASR_SESSION_IDLE)), new c7c.a(null, null, null, null, null, false, false, false, false, 2047));
        if (r.a(StringsKt.trim(r110).toString()) == false) goto L101;
        ICUUtils.FormatArgsBuilder r21 = new ICUUtils.FormatArgsBuilder();
        r21.b("date", r20);
        String r22 = ICUUtils.icuFormat(r110, r21.a);
        TextView r23 = this.Q;
        if (r23 == null) goto L95;
        r23.setText(r22);
    L95:
        TextView r24 = this.Q;
        if (r24 == null) goto L98;
        r24.setTextColor(r111);
    L98:
        TextView r25 = this.Q;
        if (r25 == null) goto L104;
        r25.setVisibility(0);
    L104:
        String r26 = UIUtils.getString(getContext(), 2131890187);
        int r27 = UIUtils.getColor(getContext(), 2131102049);
        TextView r28 = this.R;
        if (r28 == null) goto L107;
        r28.setText(r26);
    L107:
        TextView r29 = this.R;
        if (r29 == null) goto L110;
        r29.setTextColor(r27);
    L110:
        TextView r31 = this.R;
        if (r31 == null) goto L113;
        r31.setVisibility(0);
    L113:
        TextView r32 = this.R;
        if (r32 == null) goto L116;
        r32.setOnClickListener(new com.ss.android.lark.flow.chat.page.flow.plugin.select.g(r113, this));
    L116:
        String r33 = StringsKt.substringAfter$default(r19, "{appeal}", null, 2, null);
        if (r.a(StringsKt.trim(r33).toString()) == false) goto L127;
        ICUUtils.FormatArgsBuilder r34 = new ICUUtils.FormatArgsBuilder();
        r34.b("date", r20);
        String r35 = ICUUtils.icuFormat(r33, r34.a);
        TextView r36 = this.S;
        if (r36 == null) goto L121;
        r36.setText(r35);
    L121:
        TextView r37 = this.S;
        if (r37 == null) goto L124;
        r37.setTextColor(r111);
    L124:
        TextView r38 = this.S;
        if (r38 == null) goto L149;
        r38.setVisibility(0);
    L149:
        LinearLayout r39 = this.P;
        if (r39 == null) goto L152;
        r39.setVisibility(0);
    L152:
        View r40 = this.N;
        if (r40 == null) goto L155;
        r40.setVisibility(0);
    L155:
        this.T = true;
        return;
    L127:
        TextView r41 = this.S;
        if (r41 == null) goto L149;
        r41.setVisibility(8);
        goto L149
    L101:
        TextView r42 = this.Q;
        if (r42 == null) goto L104;
        r42.setVisibility(8);
        goto L104
    L86:
        r19 = UIUtils.getString(getContext(), 2131890188);
    L130:
        ChatTnsSystemBannedInfo r114 = r4;
        if (r114.isPermanent() == false) goto L133;
        String r43 = "";
    L137:
        TextView r44 = this.Q;
        if (r44 == null) goto L140;
        r44.setText(r43);
    L140:
        TextView r45 = this.Q;
        if (r45 == null) goto L143;
        r45.setVisibility(0);
    L143:
        TextView r46 = this.R;
        if (r46 == null) goto L146;
        r46.setVisibility(8);
    L146:
        TextView r47 = this.S;
        if (r47 == null) goto L149;
        r47.setVisibility(8);
        goto L149
    L133:
        Long r48 = r114.getExpireAt();
        if (r48 == null) goto L136;
        r18 = r48.longValue();
    L136:
        String r49 = c7c.b.a(getContext(), new Date(r18 * ((long) AudioViewModel.ASR_SESSION_IDLE)), new c7c.a(null, null, null, null, null, false, false, false, false, 2047));
        String r50 = UIUtils.getString(getContext(), 2131890184);
        ICUUtils.FormatArgsBuilder r51 = new ICUUtils.FormatArgsBuilder();
        r51.b("date", r49);
        r43 = ICUUtils.icuFormat(r50, r51.a);
        goto L137
    L76:
        if (r30.isAdmin() == true) goto L79;
        r17 = false;
        goto L80
    L61:
        if (r30.isAdmin() == true) goto L64;
        r15 = 2131890186;
        goto L71
    L65:
        if (r14 == false) goto L67;
    L70:
        r15 = 2131890189;
        goto L71
    L67:
        if (r30.isAdmin() == true) goto L70;
        r15 = 2131890185;
        goto L71
    L54:
        if (r.a(r30.getOwnerId()) == false) goto L56;
        r14 = true;
        goto L58
    L157:
        if (this.T == false) goto L161;
        IKeyboardWrapper r52 = this.n;
        if (r52 == null) goto L161;
        r52.I();
    L161:
        this.T = false;
        View r53 = this.N;
        if (r53 == null) goto L166;
        r53.setVisibility(8);
        return;
    L166:
        return;
    L22:
        r8 = false;
        goto L23
    L15:
        if (r1.getTnsOpKind() != ChatTnsOpKind.TNS_OP_BANNED) goto L18;
        if (r4 == null) goto L18;
        r2 = true;
        goto L19
    L11:
        r4 = null;
        goto L13
    }

    public final void V(BlueprintCell<?> r8) {
        k r0 = r8.l().a(IMMessageKeys.Blocks.MULTI_SELECT);
        if (r0 == null) goto L51;
        View r1 = r0.getView();
        if (r1 == null) goto L54;
        BlueprintCellViewHolder r9 = r8.h;
        if (r9 == null) goto L52;
        View r10 = ((RecyclerView.ViewHolder) r9).itemView;
        if (r10 == null) goto L55;
        Object r2 = r10.getTag(2131373020);
        ConstraintLayout.LayoutParams r3 = null;
        if ((r2 instanceof View) == false) goto L15;
        View r4 = (View) r2;
    L16:
        if (r4 != null) goto L20;
        r4 = r10.findViewById(2131389126);
        if (r4 != null) goto L20;
        return;
    L20:
        Object r5 = r10.getTag(2131373019);
        if ((r5 instanceof View) == false) goto L23;
        View r6 = (View) r5;
    L24:
        if (r6 != null) goto L28;
        r6 = r10.findViewById(2131364411);
        if (r6 != null) goto L28;
        return;
    L28:
        int r7 = r10.getTop() + r4.getTop();
        int r11 = r10.getTop() + r6.getBottom();
        ViewGroup.LayoutParams r12 = r1.getLayoutParams();
        if ((r12 instanceof ConstraintLayout.LayoutParams) == false) goto L31;
        r3 = (ConstraintLayout.LayoutParams) r12;
    L31:
        if (r3 != null) goto L33;
        return;
    L33:
        int r13 = ((ViewGroup.MarginLayoutParams) r3).topMargin;
        int r14 = r11 - r7;
        if (r14 >= (M() * 3)) goto L37;
        int r15 = N();
    L48:
        if (r15 == r13) goto L53;
        ((ViewGroup.MarginLayoutParams) r3).topMargin = r15;
        r1.setLayoutParams(r3);
        return;
    L53:
        return;
    L37:
        if (r7 < O()) goto L40;
        r15 = N();
        goto L48
    L40:
        if (((r11 - M()) - (N() * 2)) < O()) goto L43;
        r15 = (N() + O()) - r7;
        goto L48
    L43:
        if (r11 > O()) goto L45;
    L47:
        r15 = r13;
        goto L48
    L45:
        if (((r11 - M()) - (N() * 2)) >= O()) goto L47;
        r15 = r14 - (M() + N());
        goto L48
    L23:
        r6 = null;
        goto L24
    L15:
        r4 = null;
        goto L16
    L55:
        return;
    L52:
        return;
    L54:
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMultiSelectActed(com.ss.android.lark.flow.chat.multi_select.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (r2.a == false) goto L6;
        J();
        return;
    }

    public /* synthetic */ FlowMessageSelectPlugin(int r1) {
        this(IOfficeSDKShareScene.CHAT);
    }

    public static final void F(final FlowMessageSelectPlugin r4, final Function1 r5) {
        IMessageListComponent r0 = r4.j;
        List<String> r1 = null;
        if (r0 == null) goto L5;
        final List<? extends y6b.c<?>> r2 = r0.gK();
    L6:
        if (r2 != null) goto L9;
        r2 = CollectionsKt.emptyList();
    L9:
        if (r4.x == true) goto L16;
        List<? extends y6b.c<?>> r3 = r2;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r7 = r3.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        y6b.c r8 = (y6b.c) r7.next();
        r6.add(new ccb.c.a(r8.c, r8.getType()));
        goto L12
    L14:
        r5.invoke(r6);
        return;
    L16:
        if (r4.y == false) goto L23;
        IMessageListComponent r9 = r4.j;
        if (r9 == null) goto L20;
        r1 = r9.pP();
    L20:
        if (r1 != null) goto L22;
        r1 = CollectionsKt.emptyList();
    L22:
        r5.invoke(r4.S(r2, r1));
        return;
    L23:
        r4.z = new FlowMessageSelectPlugin$getSelectedMessageTypeInfos$2(r5, r4, r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r6, i7b.a r7) {
        Intrinsics.checkNotNullParameter(r6, "chatApp");
        Intrinsics.checkNotNullParameter(r7, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r6, r7);
        Chat r1 = null;
        boolean r2 = true;
        this.A = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.h = r6;
        this.i = r7.f;
        EventBus.getDefault().register(this);
        this.j = r6.a(IMessageListComponent.class);
        this.k = (IFlowBottomBannerComponent) r6.a(IFlowBottomBannerComponent.class);
        IMessageListComponent r3 = this.j;
        if (r3 == null) goto L5;
        SceneCoordinateRecyclerView r4 = r3.Et();
    L6:
        this.o = r4;
        IMessageListComponent r5 = this.j;
        if (r5 == null) goto L9;
        r5.QE(new g(this));
    L9:
        IMessageListComponent r8 = this.j;
        if (r8 == null) goto L12;
        r8.addOnScrollListener((FlowMessageSelectPlugin$scrollListener$2.AnonymousClass1) this.d0.getValue());
    L12:
        IKeyboardWrapperComponent r9 = r6.a(IKeyboardWrapperComponent.class);
        this.m = r9;
        if (r9 == null) goto L15;
        IKeyboardWrapper r10 = r9.wA();
    L16:
        this.n = r10;
        this.l = r6.a(ITitlebarComponent.class);
        r6.i(this.V);
        r6.p(new h(this));
        String r11 = r7.l;
        if (r11 != null) goto L19;
    L22:
        boolean r12 = true;
    L23:
        this.F = !r12;
        Log.i("FlowMessageSelectPlugin", "checkIfNeedEnterSelectMode: " + this.F);
        if (this.F == false) goto L71;
        String r13 = r7.m;
        if (r13 != null) goto L28;
    L31:
        if (r2 == false) goto L87;
    L37:
        String r14 = "";
    L38:
        ITitlebarComponent r15 = this.l;
        if (r15 == null) goto L43;
        FlowTitleBarComponent.LeftAreaImpl r16 = r15.x00();
        if (r16 == null) goto L43;
        r16.b(this.e0);
    L43:
        ITitlebarComponent r17 = this.l;
        if (r17 == null) goto L48;
        FlowTitleBarComponent.LeftAreaImpl r18 = r17.x00();
        if (r18 == null) goto L48;
        r18.b(this.W);
    L48:
        ITitlebarComponent r19 = this.l;
        if (r19 == null) goto L53;
        FlowTitleBarComponent.LeftAreaImpl r20 = r19.x00();
        if (r20 == null) goto L53;
        r20.a((FlowMessageSelectPlugin$selectMessageAction$2.a) this.Y.getValue());
    L53:
        ITitlebarComponent r21 = this.l;
        if (r21 == null) goto L58;
        FlowTitleBarComponent.LeftAreaImpl r22 = r21.x00();
        if (r22 == null) goto L58;
        r22.b(this.X);
    L58:
        ITitlebarComponent r23 = this.l;
        if (r23 == null) goto L63;
        FlowTitleBarComponent.a r24 = r23.XA();
        if (r24 == null) goto L63;
        r24.a(new com.ss.android.lark.flow.chat.page.flow.plugin.select.d(this, r14));
    L63:
        ITitlebarComponent r25 = this.l;
        if (r25 == null) goto L68;
        FlowTitleBarComponent.RightAreaImpl r26 = r25.F00();
        if (r26 == null) goto L68;
        r26.b(this.a0);
    L68:
        IMessageListComponent r27 = this.j;
        if (r27 == null) goto L71;
        r27.m(new com.ss.android.lark.flow.chat.page.flow.plugin.select.e(this));
        goto L71
    L87:
        JsonObject r28 = JsonParser.parseString(r13).getAsJsonObject();     // Catch: Throwable -> L86
        if (r28.has("title") == false) goto L37;
        r14 = r28.get("title").getAsString();     // Catch: Throwable -> L86
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L86
    L28:
        if (r13.length() == 0) goto L31;
        r2 = false;
    L71:
        IMessageListComponent r29 = this.j;
        if (r29 == null) goto L74;
        r29.m(new com.ss.android.lark.flow.chat.page.flow.plugin.select.c(this));
    L74:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r30 = this.h;
        if (r30 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("chatApp");
        r30 = null;
    L77:
        ChatWindowKeyboard r31 = r30.n();
        if (r31 == null) goto L80;
        r31.m7(new FlowMessageSelectPlugin$checkIfNeedEnterAbandonMode$2(this));
    L80:
        Chat r32 = this.i;
        if (r32 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("chat");
    L84:
        U(r1);
        return;
    L83:
        r1 = r32;
        goto L84
    L19:
        if (r11.length() == 0) goto L22;
        r12 = false;
        goto L23
    L15:
        r10 = null;
        goto L16
    L5:
        r4 = null;
        goto L6
    }

    public final List<ccb.c.a> S(List<? extends y6b.c<?>> r5, List<String> r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<? extends y6b.c<?>> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        y6b.c<?> r1 = r7.next();
        String r2 = r1.c;
        r0.put(r2, new ccb.c.a(r2, r1.getType()));
        goto L4
    L6:
        Iterator r8 = ((ArrayList) this.w).iterator();
    L8:
        if (r8.hasNext() == false) goto L13;
        ccb.c.a r3 = (ccb.c.a) r8.next();
        if (r6.contains(r3.a) == false) goto L8;
        r0.putIfAbsent(r3.a, r3);
        goto L8
    L13:
        return CollectionsKt.toList(r0.values());
    }

    public static final void G(FlowMessageSelectPlugin r4, int r5, List r6) {
        r4.getClass();
        Chat r1 = null;
        if (r5 != 10) goto L5;
        Lazy r7 = MultiSelectHitPointNew.a;
        Chat r8 = r4.i;
        if (r8 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("chat");
    L62:
        MultiSelectHitPointNew.a.a(r1, r6, "mergeforward", p3.d.b);
        int r9 = com.ss.android.lark.statistics.multiselect.a.a;
        Statistics.sendEvent("multiselect_forward_click", com.ss.android.lark.statistics.multiselect.a.a.a(r4.R()));
        return;
    L61:
        r1 = r8;
        goto L62
    L5:
        if (r5 != 20) goto L7;
        Lazy r10 = MultiSelectHitPointNew.a;
        Chat r11 = r4.i;
        if (r11 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("chat");
    L57:
        MultiSelectHitPointNew.a.a(r1, r6, "onebyone_forward", p3.d.b);
        int r12 = com.ss.android.lark.statistics.multiselect.a.a;
        Statistics.sendEvent("multiselect_quickforward_click", com.ss.android.lark.statistics.multiselect.a.a.a(r4.R()));
        return;
    L56:
        r1 = r11;
        goto L57
    L7:
        if (r5 != 25) goto L9;
        Lazy r13 = MultiSelectHitPointNew.a;
        Chat r14 = r4.i;
        if (r14 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("chat");
    L52:
        MultiSelectHitPointNew.a.a(r1, r6, "copy_msg_link", "none");
        return;
    L51:
        r1 = r14;
        goto L52
    L9:
        if (r5 != 30) goto L11;
        Lazy r15 = MultiSelectHitPointNew.a;
        Chat r16 = r4.i;
        if (r16 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("chat");
    L43:
        MultiSelectHitPointNew.a.a(r1, r6, "create_todo", "todo_create_view");
        int r17 = com.ss.android.lark.statistics.multiselect.a.a;
        int r18 = r6.size();
        Statistics.sendEvent("todo_im_conversions_task", com.ss.android.lark.statistics.multiselect.a.a.a(r4.R()).put("message_num", r18));     // Catch: JSONException -> L46
        return;
    L46:
        e = move-exception;
        Log.w("MultiSelectHitPoint", "sendClickMultiSelectTodo", e);
        return;
    L42:
        r1 = r16;
        goto L43
    L11:
        if (r5 != 50) goto L13;
        Lazy r19 = MultiSelectHitPointNew.a;
        Chat r20 = r4.i;
        if (r20 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("chat");
    L38:
        MultiSelectHitPointNew.a.a(r1, r6, "fast_action", "none");
        return;
    L37:
        r1 = r20;
        goto L38
    L13:
        if (r5 != 60) goto L15;
        Lazy r21 = MultiSelectHitPointNew.a;
        Chat r22 = r4.i;
        if (r22 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("chat");
    L33:
        MultiSelectHitPointNew.a.a(r1, r6, "delete", "im_delete_confirm_view");
        int r23 = com.ss.android.lark.statistics.multiselect.a.a;
        Statistics.sendEvent("multiselect_delete_click", com.ss.android.lark.statistics.multiselect.a.a.a(r4.R()));
        return;
    L32:
        r1 = r22;
        goto L33
    L15:
        if (r5 != 70) goto L17;
        Lazy r24 = MultiSelectHitPointNew.a;
        Chat r25 = r4.i;
        if (r25 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("chat");
    L28:
        MultiSelectHitPointNew.a.a(r1, r6, "multiselect_favorite", "none");
        return;
    L27:
        r1 = r25;
        goto L28
    L17:
        if (r5 != 80) goto L73;
        Lazy r26 = MultiSelectHitPointNew.a;
        Chat r27 = r4.i;
        if (r27 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("chat");
    L23:
        MultiSelectHitPointNew.a.a(r1, r6, "ask_doubao", "ask_doubao_view");
        return;
    L22:
        r1 = r27;
        goto L23
    }
}
