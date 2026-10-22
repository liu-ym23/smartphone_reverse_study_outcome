package com.ss.android.lark.integrator.im.chat.core.dependency;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Range;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import com.bytedance.lark.pb.im.v1.ContentType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.ai.translate.service.ITranslateService;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.core.dependency.ChatSettingDependency;
import com.ss.android.lark.chat.core.dependency.StickerDependency;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.SendScene;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregating.interfaces.IFeatureGatingService;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.inv.export.router.InvRouter$InviteExternalPage$Param$From;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.profile.entity.Profile;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.richtext.RichText;
import com.suite.lark.platform.service.resourcerepository.api.ResourceRequestBaseSet;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w4b.b0;
import w4b.c0;
import w4b.d0;
import w4b.e0;
import w4b.f0;
import w4b.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(w4b.c.class)
@Metadata(d1 = {"\u0000ò\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 Æ\u00012\u00020\u0001:\u0002Æ\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020VH\u0016J\n\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010Y\u001a\u00020ZH\u0016J\n\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\b\u0010]\u001a\u00020^H\u0016J\b\u0010_\u001a\u00020`H\u0016J\n\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0010\u0010c\u001a\u00020\u00052\u0006\u0010d\u001a\u00020eH\u0002JH\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010\u001f2\b\u0010i\u001a\u0004\u0018\u00010\u001f2\u0006\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010\u001f2\b\u0010m\u001a\u0004\u0018\u00010\u001f2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010oH\u0016J\b\u0010p\u001a\u00020\u001fH\u0016JR\u0010f\u001a\u00020g2\u000e\u0010q\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010r2\b\u0010s\u001a\u0004\u0018\u00010\u001f2\b\u0010l\u001a\u0004\u0018\u00010\u001f2\b\u0010m\u001a\u0004\u0018\u00010\u001f2\u001a\u0010n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0t\u0018\u00010oH\u0016J\u001a\u0010u\u001a\u0004\u0018\u00010v2\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010xH\u0016J,\u0010y\u001a\u0004\u0018\u00010z2\b\u0010{\u001a\u0004\u0018\u00010\u00072\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020v\u0018\u00010x2\u0006\u0010|\u001a\u00020\u0005H\u0016J.\u0010}\u001a\u00020g2\u0006\u0010{\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u007f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001f2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u001fH\u0016JU\u0010\u0082\u0001\u001a\u00020g2\u0006\u0010{\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u001f2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u001f2\u001d\u0010\u0086\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0087\u0001j\u000b\u0012\u0004\u0012\u00020\u001f\u0018\u0001`\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u0005H\u0016Jq\u0010\u008a\u0001\u001a\u00020g2\b\u0010{\u001a\u0004\u0018\u00010\u00072\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020k2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u001f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u001f2\u0007\u0010\u0090\u0001\u001a\u00020\u00052\u0007\u0010\u0091\u0001\u001a\u00020\u00052\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001f2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001fH\u0016J\t\u0010\u0094\u0001\u001a\u00020\u0005H\u0016J\u001d\u0010\u0095\u0001\u001a\u00020\u00052\b\u0010{\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J\f\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J\f\u0010¥\u0001\u001a\u0005\u0018\u00010 \u0001H\u0016J\n\u0010¦\u0001\u001a\u00030§\u0001H\u0016J\t\u0010¨\u0001\u001a\u00020\u001fH\u0016J&\u0010©\u0001\u001a\u00030ª\u00012\b\u0010«\u0001\u001a\u00030ª\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u00012\u0006\u0010{\u001a\u00020\u0007H\u0016J\t\u0010®\u0001\u001a\u00020\u001fH\u0016J\u0015\u0010¯\u0001\u001a\u00020g2\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016J\u0015\u0010²\u0001\u001a\u00020g2\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016J*\u0010³\u0001\u001a\u00020g2\b\u0010{\u001a\u0004\u0018\u00010\u00072\t\u0010´\u0001\u001a\u0004\u0018\u00010\u001f2\n\u0010µ\u0001\u001a\u0005\u0018\u00010¶\u0001H\u0016J\n\u0010·\u0001\u001a\u00030¸\u0001H\u0016J\n\u0010¹\u0001\u001a\u00030º\u0001H\u0016J/\u0010»\u0001\u001a\u00020\u00052\f\u0010¼\u0001\u001a\u0007\u0012\u0002\b\u00030½\u00012\n\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u00012\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u0001H\u0016J\t\u0010Â\u0001\u001a\u00020\u0005H\u0016J-\u0010Ã\u0001\u001a\u00020\u00052\f\u0010¼\u0001\u001a\u0007\u0012\u0002\b\u00030½\u00012\b\u0010¾\u0001\u001a\u00030¿\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001H\u0016R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R\"\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001¨\u0006Ç\u0001"}, d2 = {"Lcom/ss/android/lark/integrator/im/chat/core/dependency/ChatCoreDependencyImpl;", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency;", "<init>", "()V", "isLarkPkg", "", "getContext", "Landroid/content/Context;", "getPerfEnterChatMonitor", "Lcom/ss/android/lark/chat/api/IPerfEnterChatMonitor;", "getLoginDependency", "Lcom/ss/android/lark/chat/core/dependency/LoginDependency;", "getNotificationDependency", "Lcom/ss/android/lark/chat/core/dependency/NotificationDependency;", "getFeedDependency", "Lcom/ss/android/lark/chat/core/dependency/FeedDependency;", "getFeatureGatingDependency", "Lcom/ss/android/lark/chat/core/dependency/FeatureGatingDependency;", "getCreateGroupDependency", "Lcom/ss/android/lark/chat/core/dependency/CreateGroupDependency;", "getProfileDependency", "Lcom/ss/android/lark/chat/core/dependency/ProfileDependency;", "getMultiTaskDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IMultiTaskDependency;", "getLanguageDependency", "Lcom/ss/android/lark/chat/core/dependency/LanguageDependency;", "getFeatureConfigDependency", "Lcom/ss/android/lark/chat/core/dependency/FeatureConfigDependency;", "getWschannelDependency", "Lcom/ss/android/lark/chat/core/dependency/WsChannelDependency;", "getSessionForUrl", "", "url", "getFilePickerDependency", "Lcom/ss/android/lark/chat/core/dependency/FilePickerDependency;", "getSettingDependency", "Lcom/ss/android/lark/chat/core/dependency/SettingDependency;", "getExtensionDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreExtensionDependency;", "getTimeFormatDependency", "Lcom/ss/android/lark/chat/core/dependency/TimeFormatDependency;", "getPhoneDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IPhoneDependency;", "getBrowserDependency", "Lcom/ss/android/lark/chat/core/dependency/BrowserDependency;", "getAuditDependency", "Lcom/ss/android/lark/chat/core/dependency/AuditDependency;", "getImageDependency", "Lcom/ss/android/lark/chat/core/dependency/ImageDependency;", "getOpenPlatformDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IOpenPlatformDependency;", "getGroupMemberManageDependency", "Lcom/ss/android/lark/chat/core/dependency/GroupMemberManageDependency;", "getAppConfigDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IAppConfigDependency;", "getMoneyDependency", "Lcom/ss/android/lark/chat/core/dependency/MoneyDependency;", "getMiraDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$MiraDependency;", "getGuideDependency", "Lcom/ss/android/lark/chat/core/dependency/GuideDependency;", "getStickerDependency", "Lcom/ss/android/lark/chat/core/dependency/StickerDependency;", "getFileDetailDependency", "Lcom/ss/android/lark/dependency/IFileDetailDependency;", "getSecurityComplianceDependency", "Lcom/ss/android/lark/chat/core/dependency/ISecurityComplianceDependency;", "getDownloadDependency", "Lcom/ss/android/lark/chat/core/dependency/DownloadDependency;", "getPushDependency", "Lcom/ss/android/lark/chat/core/dependency/PushDependency;", "getMainDependency", "Lcom/ss/android/lark/chat/core/dependency/MainDependency;", "getChatSettingDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatSettingDependency;", "getCcmDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreCcmDependency;", "getDingDependency", "Lcom/ss/android/lark/chat/core/dependency/DingDependency;", "getTeamDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreTeamDependency;", "getChatDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatDependency;", "getThreadDependency", "Lcom/ss/android/lark/chat/core/dependency/ThreadDependency;", "getMergeForwardDependnecy", "Lcom/ss/android/lark/chat/core/dependency/MergeForwardDependency;", "getFavoriteDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$FavoriteDependency;", "getPassportDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$PassportDependency;", "getLeanModeDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$LeanModeDependency;", "getSearchDependency", "Lcom/ss/android/lark/chat/core/dependency/ISearchDependency;", "getUrlPreviewDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreUrlPreviewDependency;", "getProfile", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$Profile;", "isTopicGroupAdmin", InvRouter$InviteExternalPage$Param$From.PROFILE, "Lcom/ss/android/lark/profile/entity/Profile;", "getResource", "", "resourceKey", "downloadPath", "downloadFileScene", "", "previewId", "msgLinkToken", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "getSecurityWebHost", "resourceKeySet", "", "path", "", "getOpenedUserStatus", "Lcom/bytedance/lark/pb/basic/v1/Chatter$ChatterCustomStatus;", "userStatusList", "", "getOpenedUserStatusSmallDrawable", "Landroid/graphics/drawable/Drawable;", "context", "isScale", "startContactsProfileActivity", "chatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "chatId", "chatName", "openReadStateDetailPage", "type", "Lcom/ss/android/lark/chat/entity/message/Message$Type;", "msgId", "atChatterIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isDing", "startPhotoEditorActivityFromPreview", "fragment", "Landroidx/fragment/app/Fragment;", "requestCode", "imageUrl", "resultPath", "showSaveBtn", "showForwardBtn", "fileKey", "messageId", "isAutoTranslateEnableViaBilling", "openAppLinkUrl", "getTranslateDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$ITranslateDependency;", "mEnterpriseTopicDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IEnterpriseTopicDependency;", "getMEnterpriseTopicDependency", "()Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IEnterpriseTopicDependency;", "setMEnterpriseTopicDependency", "(Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IEnterpriseTopicDependency;)V", "getEnterpriseTopicDependency", "calendarEventAiDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IRecommendEventAiDependency;", "getCalendarEventAiDependency", "()Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IRecommendEventAiDependency;", "setCalendarEventAiDependency", "(Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IRecommendEventAiDependency;)V", "getIRecommendEventAiDependency", "getAiDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IAiDependency;", "getDeviceId", "addActionHandlerToManager", "Lcom/ss/android/lark/biz/im/api/messageaction/MessageActionHandlerManager;", "manager", "callBack", "Lcom/ss/android/lark/biz/im/api/messageaction/MessageVo2MessageInfoCallBack;", "rustSdkLogSubPath", "registerSourceMessageRecalledEventListener", "listener", "Lcom/ss/android/lark/listener/ISourceMessageRecalledEventListener;", "unRegisterSourceMessageRecalledEventListener", "launchMainWindow", "pageName", "bundle", "Landroid/os/Bundle;", "getVcDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IVcDependency;", "getMyAIDependency", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$IMyAIDependency;", "canShowSingleUrlCard", "messageVO", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "chatContext", "Lcom/ss/android/lark/chat/chatwindow/biz/component/messagelist/render/cell/IChatContext;", "cellParam", "Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/text/param/UrlPreviewParam;", "isDevEnv", "isHideRichTextView", "messageCellConfig", "Lcom/ss/android/lark/chat/config/MessageCellConfig;", "Companion", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ChatCoreDependencyImpl implements w4b.c {
    public static final a Companion = null;
    private static final String TAG = "ChatCoreModuleDeps";
    private w4b.c.i calendarEventAiDependency;
    private w4b.c.d mEnterpriseTopicDependency;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements w4b.c.b {
        public b() {
        }

        public final Dialog a(Context r14, String r15, String r16, String r17, String r18, String r19, Map<String, String> r20) {
            return ((ITranslateService) ApiUtils.getApi(ITranslateService.class)).showTranslateFeedbackDialog(r14, r15, r16, r17, r18, r19, "", z5c.l.c.b, ITranslateService.TranslateFeedbackScene.CHAT_NAME, null, r20);
        }
    }

    public static final class c implements w4b.c.c {
        public final void isOn() {
            Intrinsics.checkNotNullParameter("message.pull", "configKey");
        }

        public final UniversalUserSetting a() {
            Intrinsics.checkNotNullParameter("GLOBALLY_ENTER_CHAT_POSITION", TabAppInfo.IMAGE_JSON_KEY);
            return com.ss.android.lark.larkconfig.universal.e.a.a("GLOBALLY_ENTER_CHAT_POSITION");
        }

        public c() {
        }
    }

    public static final class d implements w4b.c.a {
        public d() {
        }
    }

    public static final class e implements w4b.k {
        public final IFeatureGatingService a;

        public final boolean a() {
            return this.a.isEnable("suite_translation");
        }

        public final boolean b() {
            return this.a.isEnable("suite_voice2text");
        }

        public e() {
            this.a = FeatureGatingModule.getFeatureGatingService();
        }
    }

    public static final class f implements w4b.c.f {
        public f() {
        }

        public final void a(psb.a r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
        }

        public final void b() {
        }

        public final void c(psb.a r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
        }

        public final void d() {
        }

        public final Range<Integer> e() {
            return new Range(10, 52);
        }
    }

    public static final class g implements w4b.c.g {
        public g() {
        }

        public final void a(Chat r2) {
            Intrinsics.checkNotNullParameter(r2, "chat");
            nmb.a.a().getOpenPlatformDependency().a();
        }
    }

    public static final class h implements w4b.c.o {
        public h() {
        }

        public final String Fc() {
            return nmb.a.a().getPassportDependency().getSessionId();
        }

        public final String fe() {
            return nmb.a.a().getPassportDependency().getTenantId();
        }

        public final String userId() {
            return nmb.a.a().getPassportDependency().getUserId();
        }
    }

    public static final class i implements w4b.c.h {
        public i() {
        }

        public final void a(Context r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "cxt");
            Intrinsics.checkNotNullParameter(r3, "phoneNum");
            if ((r2 instanceof FragmentActivity) == false) goto L7;
            dza.a r0 = (dza.a) LarkContext.spiByDwarf(dza.a.class);
            if (r0 == null) goto L9;
            r0.r1(r3, ((FragmentActivity) r2).getSupportFragmentManager());
            return;
        L9:
            return;
        L7:
            Log.e(ChatCoreDependencyImpl.TAG, "showPhoneIdentifyDialog, context error");
        }
    }

    public static final class j implements w4b.c.j {
        public j() {
        }

        public final void a() {
        }

        public final void b(String r2, String r3, String[] r4, IGetDataCallback<List<String>> r5) {
            Intrinsics.checkNotNullParameter(r2, "originLang");
            Intrinsics.checkNotNullParameter(r3, "targetLang");
            Intrinsics.checkNotNullParameter(r4, "words");
            Intrinsics.checkNotNullParameter(r5, "callback");
            pmb.d r6 = nmb.a.a().getCoreDependency();
            ContentType r7 = ContentType.UNKNOWN_CONTENT_TYPE;
            r6.j();
        }
    }

    public static final class k implements w4b.c.k {
        public k() {
        }

        public final void isInMeeting() {
        }

        public final boolean a(int r1) {
            nmb.a.a().getVideoConferenceDependency().a();
            return false;
        }
    }

    static {
        Companion = new a();
    }

    public ChatCoreDependencyImpl() {
    }

    private final boolean isTopicGroupAdmin(Profile r1) {
        return false;
    }

    public final w4b.c.i getCalendarEventAiDependency() {
        return null;
    }

    public w4b.c.d getEnterpriseTopicDependency() {
        return null;
    }

    public w4b.c.i getIRecommendEventAiDependency() {
        return null;
    }

    public w4b.c.m getLeanModeDependency() {
        return null;
    }

    public final w4b.c.d getMEnterpriseTopicDependency() {
        return null;
    }

    public boolean isLarkPkg() {
        return false;
    }

    public void launchMainWindow(Context r1, String r2, Bundle r3) {
    }

    public void openReadStateDetailPage(Context r1, String r2, Message.Type r3, String r4, ArrayList<String> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "msgId");
    }

    public final void setCalendarEventAiDependency(w4b.c.i r1) {
    }

    public final void setMEnterpriseTopicDependency(w4b.c.d r1) {
    }

    public void startContactsProfileActivity(Context r1, Chatter r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "chatter");
    }

    public void startPhotoEditorActivityFromPreview(Context r1, Fragment r2, int r3, String r4, String r5, boolean r6, boolean r7, String r8, String r9, String r10) {
    }

    public w4b.c.b getAiDependency() {
        return new b();
    }

    public w4b.c.c getAppConfigDependency() {
        return new c();
    }

    public w4b.a getAuditDependency() {
        return new com.ss.android.lark.integrator.im.chat.core.dependency.a();
    }

    public BrowserDependency getBrowserDependency() {
        return new com.ss.android.lark.integrator.im.chat.core.dependency.b();
    }

    public w4b.g getChatDependency() {
        return new com.ss.android.lark.integrator.im.chat.core.dependency.c();
    }

    public ChatSettingDependency getChatSettingDependency() {
        return new com.ss.android.lark.integrator.im.chat.core.dependency.d();
    }

    public w4b.h getCreateGroupDependency() {
        int r0 = nmb.b.a;
        if (Intrinsics.areEqual(w4b.h.class, Boolean.class) == false) goto L6;
        Object r1 = Boolean.FALSE;
    L33:
        if (r1 == null) goto L37;
        return (w4b.h) r1;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.chat.core.dependency.CreateGroupDependency");
    L6:
        if (Intrinsics.areEqual(w4b.h.class, Byte.class) == false) goto L9;
        r1 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(w4b.h.class, Short.class) == false) goto L12;
        r1 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(w4b.h.class, Integer.class) == false) goto L15;
        r1 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(w4b.h.class, Long.class) == false) goto L18;
        r1 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(w4b.h.class, Float.class) == false) goto L21;
        r1 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(w4b.h.class, Double.class) == false) goto L24;
        r1 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(w4b.h.class, Character.class) == false) goto L27;
        r1 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(w4b.h.class, ArrayList.class) == false) goto L30;
        r1 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(w4b.h.class, Unit.class) == false) goto L32;
        r1 = Unit.INSTANCE;
        goto L33
    L32:
        r1 = nmb.b.a(w4b.h.class);
        goto L33
    }

    public w4b.i getDingDependency() {
        int r0 = nmb.b.a;
        if (Intrinsics.areEqual(w4b.i.class, Boolean.class) == false) goto L6;
        Object r1 = Boolean.FALSE;
    L33:
        if (r1 == null) goto L37;
        return (w4b.i) r1;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.chat.core.dependency.DingDependency");
    L6:
        if (Intrinsics.areEqual(w4b.i.class, Byte.class) == false) goto L9;
        r1 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(w4b.i.class, Short.class) == false) goto L12;
        r1 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(w4b.i.class, Integer.class) == false) goto L15;
        r1 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(w4b.i.class, Long.class) == false) goto L18;
        r1 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(w4b.i.class, Float.class) == false) goto L21;
        r1 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(w4b.i.class, Double.class) == false) goto L24;
        r1 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(w4b.i.class, Character.class) == false) goto L27;
        r1 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(w4b.i.class, ArrayList.class) == false) goto L30;
        r1 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(w4b.i.class, Unit.class) == false) goto L32;
        r1 = Unit.INSTANCE;
        goto L33
    L32:
        r1 = nmb.b.a(w4b.i.class);
        goto L33
    }

    public w4b.j getDownloadDependency() {
        return new com.ss.android.lark.integrator.im.chat.core.dependency.f();
    }

    public w4b.d getExtensionDependency() {
        return new com.ss.android.lark.integrator.im.extension.a();
    }

    public w4b.c.a getFavoriteDependency() {
        return new d();
    }

    public w4b.k getFeatureConfigDependency() {
        return new e();
    }

    public w4b.l getFeatureGatingDependency() {
        return new com.ss.android.lark.integrator.im.chat.core.dependency.g();
    }

    public w4b.m getFeedDependency() {
        int r0 = FlowChatModule.d;
        return FlowChatModule.a.a().a().getFeedDependency();
    }

    public w4b.n getFilePickerDependency() {
        int r0 = nmb.b.a;
        if (Intrinsics.areEqual(w4b.n.class, Boolean.class) == false) goto L6;
        Object r1 = Boolean.FALSE;
    L33:
        if (r1 == null) goto L37;
        return (w4b.n) r1;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.chat.core.dependency.FilePickerDependency");
    L6:
        if (Intrinsics.areEqual(w4b.n.class, Byte.class) == false) goto L9;
        r1 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(w4b.n.class, Short.class) == false) goto L12;
        r1 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(w4b.n.class, Integer.class) == false) goto L15;
        r1 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(w4b.n.class, Long.class) == false) goto L18;
        r1 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(w4b.n.class, Float.class) == false) goto L21;
        r1 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(w4b.n.class, Double.class) == false) goto L24;
        r1 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(w4b.n.class, Character.class) == false) goto L27;
        r1 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(w4b.n.class, ArrayList.class) == false) goto L30;
        r1 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(w4b.n.class, Unit.class) == false) goto L32;
        r1 = Unit.INSTANCE;
        goto L33
    L32:
        r1 = nmb.b.a(w4b.n.class);
        goto L33
    }

    public w4b.o getGroupMemberManageDependency() {
        int r0 = nmb.b.a;
        if (Intrinsics.areEqual(w4b.o.class, Boolean.class) == false) goto L6;
        Object r1 = Boolean.FALSE;
    L33:
        if (r1 == null) goto L37;
        return (w4b.o) r1;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.chat.core.dependency.GroupMemberManageDependency");
    L6:
        if (Intrinsics.areEqual(w4b.o.class, Byte.class) == false) goto L9;
        r1 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(w4b.o.class, Short.class) == false) goto L12;
        r1 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(w4b.o.class, Integer.class) == false) goto L15;
        r1 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(w4b.o.class, Long.class) == false) goto L18;
        r1 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(w4b.o.class, Float.class) == false) goto L21;
        r1 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(w4b.o.class, Double.class) == false) goto L24;
        r1 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(w4b.o.class, Character.class) == false) goto L27;
        r1 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(w4b.o.class, ArrayList.class) == false) goto L30;
        r1 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(w4b.o.class, Unit.class) == false) goto L32;
        r1 = Unit.INSTANCE;
        goto L33
    L32:
        r1 = nmb.b.a(w4b.o.class);
        goto L33
    }

    public w4b.p getGuideDependency() {
        return new com.ss.android.lark.integrator.im.chat.core.dependency.h();
    }

    public w4b.s getImageDependency() {
        return new com.ss.android.lark.integrator.im.chat.core.dependency.j();
    }

    public w4b.t getLanguageDependency() {
        return new com.ss.android.lark.integrator.im.chat.core.dependency.k();
    }

    public w4b.u getLoginDependency() {
        return new m();
    }

    public w4b.v getMainDependency() {
        return new n();
    }

    public w4b.w getMergeForwardDependnecy() {
        return new o();
    }

    public w4b.c.n getMiraDependency() {
        return new p();
    }

    public w4b.x getMoneyDependency() {
        int r0 = nmb.b.a;
        if (Intrinsics.areEqual(w4b.x.class, Boolean.class) == false) goto L6;
        Object r1 = Boolean.FALSE;
    L33:
        if (r1 == null) goto L37;
        return (w4b.x) r1;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.chat.core.dependency.MoneyDependency");
    L6:
        if (Intrinsics.areEqual(w4b.x.class, Byte.class) == false) goto L9;
        r1 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(w4b.x.class, Short.class) == false) goto L12;
        r1 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(w4b.x.class, Integer.class) == false) goto L15;
        r1 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(w4b.x.class, Long.class) == false) goto L18;
        r1 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(w4b.x.class, Float.class) == false) goto L21;
        r1 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(w4b.x.class, Double.class) == false) goto L24;
        r1 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(w4b.x.class, Character.class) == false) goto L27;
        r1 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(w4b.x.class, ArrayList.class) == false) goto L30;
        r1 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(w4b.x.class, Unit.class) == false) goto L32;
        r1 = Unit.INSTANCE;
        goto L33
    L32:
        r1 = nmb.b.a(w4b.x.class);
        goto L33
    }

    public w4b.c.e getMultiTaskDependency() {
        int r0 = nmb.b.a;
        if (Intrinsics.areEqual(w4b.c.e.class, Boolean.class) == false) goto L6;
        Object r1 = Boolean.FALSE;
    L33:
        if (r1 == null) goto L37;
        return (w4b.c.e) r1;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.chat.core.dependency.ChatCoreDependency.IMultiTaskDependency");
    L6:
        if (Intrinsics.areEqual(w4b.c.e.class, Byte.class) == false) goto L9;
        r1 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(w4b.c.e.class, Short.class) == false) goto L12;
        r1 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(w4b.c.e.class, Integer.class) == false) goto L15;
        r1 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(w4b.c.e.class, Long.class) == false) goto L18;
        r1 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(w4b.c.e.class, Float.class) == false) goto L21;
        r1 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(w4b.c.e.class, Double.class) == false) goto L24;
        r1 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(w4b.c.e.class, Character.class) == false) goto L27;
        r1 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(w4b.c.e.class, ArrayList.class) == false) goto L30;
        r1 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(w4b.c.e.class, Unit.class) == false) goto L32;
        r1 = Unit.INSTANCE;
        goto L33
    L32:
        r1 = nmb.b.a(w4b.c.e.class);
        goto L33
    }

    public w4b.c.f getMyAIDependency() {
        return new f();
    }

    public w4b.y getNotificationDependency() {
        int r0 = nmb.b.a;
        if (Intrinsics.areEqual(w4b.y.class, Boolean.class) == false) goto L6;
        Object r1 = Boolean.FALSE;
    L33:
        if (r1 == null) goto L37;
        return (w4b.y) r1;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.chat.core.dependency.NotificationDependency");
    L6:
        if (Intrinsics.areEqual(w4b.y.class, Byte.class) == false) goto L9;
        r1 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(w4b.y.class, Short.class) == false) goto L12;
        r1 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(w4b.y.class, Integer.class) == false) goto L15;
        r1 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(w4b.y.class, Long.class) == false) goto L18;
        r1 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(w4b.y.class, Float.class) == false) goto L21;
        r1 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(w4b.y.class, Double.class) == false) goto L24;
        r1 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(w4b.y.class, Character.class) == false) goto L27;
        r1 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(w4b.y.class, ArrayList.class) == false) goto L30;
        r1 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(w4b.y.class, Unit.class) == false) goto L32;
        r1 = Unit.INSTANCE;
        goto L33
    L32:
        r1 = nmb.b.a(w4b.y.class);
        goto L33
    }

    public w4b.c.g getOpenPlatformDependency() {
        return new g();
    }

    public w4b.c.o getPassportDependency() {
        return new h();
    }

    public x1b.c getPerfEnterChatMonitor() {
        return ((okb.d) ImSdkProxy.g.getValue()).a();
    }

    public w4b.c.h getPhoneDependency() {
        return new i();
    }

    public b0 getProfileDependency() {
        return new q();
    }

    public c0 getPushDependency() {
        return new r();
    }

    public w4b.q getSearchDependency() {
        return new s();
    }

    public w4b.r getSecurityComplianceDependency() {
        return new t();
    }

    public d0 getSettingDependency() {
        return new u();
    }

    public StickerDependency getStickerDependency() {
        return new v();
    }

    public e0 getThreadDependency() {
        return new w();
    }

    public f0 getTimeFormatDependency() {
        return new x();
    }

    public w4b.c.j getTranslateDependency() {
        return new j();
    }

    public w4b.c.k getVcDependency() {
        return new k();
    }

    public g0 getWschannelDependency() {
        return new z();
    }

    public boolean isAutoTranslateEnableViaBilling() {
        if (com.ss.android.lark.larkconfig.userconfig.e.a.a.a() != null) goto L5;
    L7:
        return false;
    L5:
        if (com.ss.android.lark.larkconfig.userconfig.e.a.a.a().c() == false) goto L7;
        return true;
    }

    public boolean isDevEnv() {
        if (((gpb.a) ApiUtils.getApi(gpb.a.class)).envType() != 1) goto L7;
        return false;
    L7:
        return true;
    }

    public w4b.b getCcmDependency() {
        return nmb.a.a().getCCMDependency();
    }

    public Context getContext() {
        return LarkContext.getApplication();
    }

    public String getDeviceId() {
        return nmb.a.a().getPassportDependency().getDeviceId();
    }

    public vab.b getFileDetailDependency() {
        return nmb.a.a().getMigrateTempDependency().c();
    }

    public w4b.c.p getProfile() {
        nmb.a.a().getCoreDependency().getProfile();
        return null;
    }

    public String getSecurityWebHost() {
        List r0 = jcb.b.c().b("security_web");
        List r1 = r0;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L13;
        return "";
    L13:
        return (String) ListProtector.get(r0, 0);
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public w4b.e getTeamDependency() {
        return (w4b.e) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(w4b.e.class);
    }

    public w4b.f getUrlPreviewDependency() {
        return (w4b.f) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(w4b.f.class);
    }

    public String rustSdkLogSubPath() {
        nmb.a.a().getEnvDependency().rustSdkLogSubPath();
        return "";
    }

    public com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus getOpenedUserStatus(List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r1) {
        nmb.a.a().getCoreDependency().m();
        return null;
    }

    public String getSessionForUrl(String r1) {
        g6b.a.a r2 = g6b.a.a;
        if (r2 == null) goto L7;
        r2.i();
        return null;
    L7:
        return null;
    }

    public void registerSourceMessageRecalledEventListener(aqb.i r1) {
        nmb.a.a().getMigrateTempDependency().b();
    }

    public void unRegisterSourceMessageRecalledEventListener(aqb.i r1) {
        nmb.a.a().getMigrateTempDependency().a();
    }

    public boolean openAppLinkUrl(Context r3, String r4) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (nmb.a.a().getCoreDependency().k(r3, r4) == false) goto L9;
        nmb.a.a().getCoreDependency().s(r3, r4);
        return true;
    L9:
        return false;
    }

    public mya.h addActionHandlerToManager(mya.h r2, mya.j r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Intrinsics.checkNotNullParameter(r3, "callBack");
        Intrinsics.checkNotNullParameter(r4, "context");
        r2.a(mya.s.class, new com.ss.android.lark.chat.chatwindow.chat.message.actionimpl.g());
        r2.a(mya.q.class, new com.ss.android.lark.chat.chatwindow.chat.message.actionimpl.d());
        r2.a(mya.m.class, new com.ss.android.lark.chat.chatwindow.chat.message.actionimpl.b());
        r2.a(mya.v.class, new com.ss.android.lark.chat.chatwindow.chat.message.actionimpl.i());
        r2.a(mya.r.class, new com.ss.android.lark.chat.chatwindow.chat.message.actionimpl.f());
        r2.a(mya.n.class, new com.ss.android.lark.chat.chatwindow.chat.message.actionimpl.c());
        r2.a(mya.t.class, new com.ss.android.lark.chat.chatwindow.chat.message.actionimpl.h(r4));
        return r2;
    }

    public boolean canShowSingleUrlCard(y6b.a<?> r4, m2b.a r5, g3b.v r6) {
        Intrinsics.checkNotNullParameter(r4, "messageVO");
        boolean r1 = false;
        if (r4.getType() == Message.Type.TEXT) goto L6;
        return false;
    L6:
        if (r4.e() == true) goto L8;
        return false;
    L8:
        BaseTextContentVO r7 = r4.b();
        if ((r7 instanceof BaseTextContentVO) == false) goto L11;
        BaseTextContentVO r8 = r7;
    L12:
        if (r8 != null) goto L14;
        return false;
    L14:
        RichText r9 = r8.g();
        if (r9 == null) goto L80;
        List r10 = r9.getAnchorIds();
        if (r10 == null) goto L80;
        String r11 = (String) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L80;
        PreviewHangPoint r12 = (PreviewHangPoint) r8.C.get(r11);
        if (r12 != null) goto L25;
        return false;
    L25:
        if (r12.getSendScene() != SendScene.DOUBAO_CLOUD_DRIVE_CHOOSE) goto L28;
        return true;
    L28:
        if (r12.getSendScene() == SendScene.DEFAULT) goto L30;
        return false;
    L30:
        if (r5 != null) goto L32;
    L34:
        boolean r13 = false;
    L35:
        if (r13 == true) goto L69;
        if (r5 != null) goto L38;
    L40:
        boolean r14 = false;
    L41:
        if (r14 == true) goto L69;
        if (r5 == null) goto L48;
        Chat r15 = r5.getChat();
        if (r15 == null) goto L48;
        if (r15.isThread() != true) goto L48;
        boolean r16 = true;
    L49:
        if (r16 == true) goto L69;
        if (r5 == null) goto L81;
        Chat r17 = r5.getChat();
        if (r17 != null) goto L56;
        return false;
    L56:
        if (r17.isGroup() == false) goto L59;
    L67:
        return true;
    L59:
        if (r17.isP2PChat() == false) goto L82;
        y6b.b r18 = r5.x8();
        if (r18 != null) goto L63;
        return false;
    L63:
        if (r18.j != Chatter.ChatterType.BOT) goto L65;
        boolean r19 = true;
    L66:
        if (r19 == false) goto L67;
        return false;
    L65:
        r19 = false;
        goto L66
    L82:
        return false;
    L81:
        return false;
    L48:
        r16 = false;
        goto L49
    L38:
        if (r5.m() != true) goto L40;
        r14 = true;
    L69:
        if (r5 == null) goto L79;
        y6b.b r20 = r5.x8();
        if (r20 == null) goto L79;
        if (r20.j != Chatter.ChatterType.BOT) goto L75;
        boolean r21 = true;
    L76:
        if (r21 != true) goto L79;
        r1 = true;
        goto L79
    L75:
        r21 = false;
    L79:
        return !r1;
    L32:
        if (r5.Y() != true) goto L34;
        r13 = true;
    L80:
        return false;
    L11:
        r8 = null;
        goto L12
    }

    public Drawable getOpenedUserStatusSmallDrawable(Context r1, List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r2, boolean r3) {
        nmb.a.a().getCoreDependency().g();
        return null;
    }

    public boolean isHideRichTextView(y6b.a<?> r2, m2b.a r3, v4b.d r4) {
        Intrinsics.checkNotNullParameter(r2, "messageVO");
        Intrinsics.checkNotNullParameter(r3, "chatContext");
        if (r4 == null) goto L5;
        boolean r5 = r4.c;
    L6:
        if (r5 == true) goto L8;
    L10:
        return false;
    L8:
        if (canShowSingleUrlCard(r2, r3, null) == false) goto L10;
        return true;
    L5:
        r5 = true;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getResource(Set<String> r4, String r5, String r6, String r7, final IGetDataCallback<Map<String, String>> r8) {
        ArrayList r0 = new ArrayList();
        if (r4 == null) goto L10;
        Iterator<T> r9 = r4.iterator();
    L6:
        if (r9.hasNext() == false) goto L10;
        String r1 = (String) r9.next();
        if (TextUtils.isEmpty(r1) == true) goto L6;
        r0.add(new ResourceRequestBaseSet(r1, r5, r6, r7));
    L10:
        nmb.a.a().getCoreDependency().f().getResources(r0, -99, new AnonymousClass3(r8));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getResource(final String r3, String r4, int r5, String r6, String r7, final IGetDataCallback<String> r8) {
        ArrayList r9 = new ArrayList();
        ResourceRequestBaseSet r0 = new ResourceRequestBaseSet(r3, r4, null, null);
        r0.f = r6;
        r9.add(r0);
        nmb.a.a().getCoreDependency().f().getResources(r9, r5, new AnonymousClass1(r3, r8));
    }
}
