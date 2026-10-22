package com.larus.bmhome.share.api;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import by7.e;
import com.larus.bmhome.chat.detail.AbstractCommonDetailFragment;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.share.panel.a;
import com.larus.bmhome.share.panel.b;
import com.larus.bmhome.share.panel.d;
import com.larus.bmhome.share.panel.h;
import com.larus.camera.impl.ui.viewmodel.b0;
import com.larus.im.bean.bot.BotModel;
import java.util.List;
import jr9.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016JL\u0010\r\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J`\u0010\u0017\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J0\u0010\u001e\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010\u001d2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\nH\u0016JE\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010'\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010.\u001a\u00020#H\u0016¢\u0006\u0002\u0010/J}\u00100\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\n2\b\u00101\u001a\u0004\u0018\u00010\n2\b\u0010'\u001a\u0004\u0018\u00010\n2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u00010-2\b\u00105\u001a\u0004\u0018\u00010\n2\b\u00106\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u00107\u001a\u00020*2\b\u00108\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0002\u00109J\u001c\u0010:\u001a\u00020*2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016JR\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010A\u001a\u0004\u0018\u00010\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020*H\u0016J[\u0010D\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010E\u001a\u0004\u0018\u00010\n2\b\u0010F\u001a\u0004\u0018\u00010\n2\u0006\u0010?\u001a\u00020@2\u0006\u0010G\u001a\u00020*2#\u0010H\u001a\u001f\u0012\u0013\u0012\u00110-¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0004\u0012\u00020\u0005\u0018\u00010IH\u0016J$\u0010M\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J.\u0010N\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010E\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J.\u0010O\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010E\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J0\u0010P\u001a\u00020\u00052\b\u0010E\u001a\u0004\u0018\u00010\n2\b\u0010F\u001a\u0004\u0018\u00010\n2\b\u0010Q\u001a\u0004\u0018\u00010\n2\b\u0010R\u001a\u0004\u0018\u00010\nH\u0016J\u001e\u0010S\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010S\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010T\u001a\u0004\u0018\u00010\nH\u0016Jt\u0010U\u001a\u0004\u0018\u00010V2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010W\u001a\u00020*2\u0006\u0010X\u001a\u00020*2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010A\u001a\u0004\u0018\u00010\u00162\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010Z2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010ZH\u0016J\u001c\u0010]\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010^\u001a\u0004\u0018\u00010<2\b\u0010_\u001a\u0004\u0018\u00010>2\u0006\u0010`\u001a\u00020a2\u0006\u0010?\u001a\u00020@H\u0016J\u001a\u0010b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010c\u001a\u00020\nH\u0016JB\u0010d\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\n2\b\u00102\u001a\u0004\u0018\u00010\n2\b\u00101\u001a\u0004\u0018\u00010\n2\u0006\u0010e\u001a\u00020*2\b\u0010f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010g\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010h\u001a\u00020*H\u0016J8\u0010i\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010j\u001a\u0004\u0018\u00010\n2\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010kH\u0016J\u0012\u0010l\u001a\u00020*2\b\u0010E\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010m\u001a\u0004\u0018\u00010n2\b\u0010o\u001a\u0004\u0018\u00010\n2\u0006\u0010W\u001a\u00020*H\u0016J\u0012\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006r"}, d2 = {"Lcom/larus/bmhome/share/api/ShareServiceNoop;", "Lcom/larus/bmhome/share/api/IShareService;", "<init>", "()V", "init", "", "performShareApp", "context", "Landroid/content/Context;", "enterFrom", "", "node", "Lcom/ixigua/lib/track/ITrackNode;", "performShareBot", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "currentPage", "sharePanelClickListener", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "performShareLink", "shareLink", "shareTitle", "shareSubTitle", "linkImageUrl", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "performShareImage", MusicAppletPage.KEY_PATH, "sharePanelEventParam", "sendShareImageEvent", "params", "Lorg/json/JSONObject;", "sendShareEvokeAppEvent", "uri", "Landroid/net/Uri;", "botId", "clickShareChatButton", "isImmersiveBackground", "", "chatType", "messageCnt", "", "traceInfo", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;Lorg/json/JSONObject;)V", "shareMessageEvent", "clickFrom", "messageId", "showName", "isButtonAddText", "userType", "deepResearchId", "isAiDoc", "extra", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/ixigua/lib/track/ITrackNode;ZLorg/json/JSONObject;)V", "canShowConversationShareAction", "showSharePanel", "Landroidx/fragment/app/DialogFragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "shareContent", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "callback", "landscapeFixedPanelWidth", "monitorShare", ShareChannel.SHARE, "shareChannel", "shareType", "showLoading", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resultCode", "mobSharePanelShow", "mobSharePanelElementShow", "mobSharePanelClick", "mobShareResult", "shareId", "success", "getBotShareTitle", "botName", "getSharePanelView", "Lcom/larus/bmhome/share/panel/AbsSharePanelView;", "isImmersive", "isMainBot", "shareItemConfigs", "", "Lcom/larus/platform/model/share/ShareItemConfig;", "prependItemConfigs", "getShareSubTitle", "showLongImageSharePanel", "fragmentActivity", "longImageShareParams", "Lcom/larus/bmhome/share/panel/LongImageShareParams;", "copyContentToClipboard", "content", "sharePanelToastShow", "isSuccess", "errorMsg", "notifySystemAlbumUpdate", "isImage", "notifySystemImageUpdate", "imagePath", "Lkotlin/Function2;", "isInstalledChannel", "createShareItemUIConfig", "Lcom/larus/platform/model/share/ShareItemUIConfig;", "channelType", "getSharePanelConfig", "Lcom/larus/platform/model/share/SharePanelConfig;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareServiceNoop implements IShareService {
    public ShareServiceNoop() {
    }

    public final boolean a(String r1) {
        return false;
    }

    public final DialogFragment c(FragmentActivity r1, ShareScene r2, b r3, h r4, d r5, e r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "shareScene");
        Intrinsics.checkNotNullParameter(r3, "shareContent");
        return null;
    }

    public final void d(String r1, String r2, String r3, String r4) {
    }

    public final void e(boolean r1, String r2, String r3, String r4, String r5, String r6, Integer r7, String r8, String r9, e r10, boolean r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r5, "messageId");
        Intrinsics.checkNotNullParameter(r6, "showName");
    }

    public final void f(Context r1, wc9.e r2, BotModel r3, ShareScene r4, String r5, e r6, d r7) {
        Intrinsics.checkNotNullParameter(r4, "shareScene");
    }

    public final jr9.b g(String r1) {
        return null;
    }

    public final boolean h(wc9.e r1, BotModel r2) {
        return false;
    }

    public final void i(ShareScene r1, String r2, h r3, e r4) {
        Intrinsics.checkNotNullParameter(r1, "shareScene");
    }

    public final void init() {
    }

    public final DialogFragment j(FragmentActivity r1, com.larus.bmhome.share.panel.e r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "longImageShareParams");
        Intrinsics.checkNotNullParameter(r3, "shareContent");
        return null;
    }

    public final void k(boolean r1, String r2, Integer r3, String r4, e r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "traceInfo");
    }

    public final void l(String r1, String r2, String r3, boolean r4, String r5, AbstractCommonDetailFragment r6) {
    }

    public final boolean m() {
        return false;
    }

    public final String n(Context r1, BotModel r2) {
        return "";
    }

    public final void o(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
    }

    public final String p(Context r1, BotModel r2) {
        return null;
    }

    public final a q(Context r1, ShareScene r2, b r3, boolean r4, boolean r5, h r6, d r7, List<jr9.a> r8, e r9, List<jr9.a> r10) {
        Intrinsics.checkNotNullParameter(r2, "shareScene");
        return null;
    }

    public final void r(Context r1, String r2, String r3, String r4, ShareScene r5, String r6, h r7, e r8, d r9) {
        Intrinsics.checkNotNullParameter(r5, "shareScene");
    }

    public final void s(ShareScene r1, String r2, h r3, e r4) {
        Intrinsics.checkNotNullParameter(r1, "shareScene");
    }

    public final c t(ShareScene r2) {
        Intrinsics.checkNotNullParameter(r2, "shareScene");
        return null;
    }

    public final void u(Context r1, String r2, h r3, e r4) {
    }

    public final void v(Uri r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
    }

    public final void w(JSONObject r1) {
    }

    public final void x(ShareScene r1, h r2, e r3) {
        Intrinsics.checkNotNullParameter(r1, "shareScene");
    }

    public final void y(Context r1, String r2, b0 r3) {
        Boolean r4 = Boolean.FALSE;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r3.invoke(r4, r2);
    }

    public final void b(Context r1, String r2, String r3, b r4, boolean r5, Function1<? super Integer, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "shareContent");
        if (r6 == null) goto L6;
        r6.invoke(2);
        return;
    }
}
