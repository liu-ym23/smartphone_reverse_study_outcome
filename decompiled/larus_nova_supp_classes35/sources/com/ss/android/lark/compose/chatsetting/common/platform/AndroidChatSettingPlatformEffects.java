package com.ss.android.lark.compose.chatsetting.common.platform;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.basic.v1.TnsBlockedFeature;
import com.lark.kmp.pb.basic.v1.TnsOpKind;
import com.lark.kmp.pb.basic.v1.TnsSystemBannedInfo;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.compose.chatsetting.report.ChatSettingFunction;
import com.ss.android.lark.compose.chatsetting.report.FlowChatFunctionAbandonDialog;
import com.ss.android.lark.compose.chatsetting.report.FlowReportManager;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.compose.groupinfo.FlowGroupInfoActivity;
import com.ss.android.lark.compose.groupqrcode.FlowGroupQrCodeActivity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AndroidChatSettingPlatformEffects implements b {
    public final UserSession a;
    public final Lazy b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ChatSettingTrackEvent.values().length];
            r0[ChatSettingTrackEvent.GROUP_MEMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L65:
            r0[ChatSettingTrackEvent.GROUP_MEMBER_AVATAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L79:
            r0[ChatSettingTrackEvent.GROUP_MEMBER_ADD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L51:
            r0[ChatSettingTrackEvent.GROUP_MEMBER_DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L53:
            r0[ChatSettingTrackEvent.EDIT_GROUP_INFO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L61:
            r0[ChatSettingTrackEvent.GROUP_QR_CODE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L31
        L73:
            r0[ChatSettingTrackEvent.GROUP_MANAGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L32
        L57:
            r0[ChatSettingTrackEvent.MUTE_TOGGLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L33
        L67:
            r0[ChatSettingTrackEvent.PIN_TOGGLE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L34
        L71:
            r0[ChatSettingTrackEvent.SEARCH.ordinal()] = 10;     // Catch: NoSuchFieldError -> L35
        L47:
            r0[ChatSettingTrackEvent.CLEAR_HISTORY_ENTRY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L36
        L63:
            r0[ChatSettingTrackEvent.CLEAR_HISTORY_CONFIRM.ordinal()] = 12;     // Catch: NoSuchFieldError -> L37
        L77:
            r0[ChatSettingTrackEvent.DISMISS_GROUP_ENTRY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L38
        L45:
            r0[ChatSettingTrackEvent.DISMISS_GROUP_CONFIRM.ordinal()] = 14;     // Catch: NoSuchFieldError -> L39
        L55:
            r0[ChatSettingTrackEvent.QUIT_GROUP_ENTRY.ordinal()] = 15;     // Catch: NoSuchFieldError -> L40
        L75:
            r0[ChatSettingTrackEvent.QUIT_GROUP_CONFIRM.ordinal()] = 16;     // Catch: NoSuchFieldError -> L41
        L49:
            r0[ChatSettingTrackEvent.REPORT.ordinal()] = 17;     // Catch: NoSuchFieldError -> L42
        L21:
            a = r0;
            int[] r1 = new int[Chat.Type.values().length];
            r1[Chat.Type.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L43
        L81:
            r1[Chat.Type.P2P.ordinal()] = 2;     // Catch: NoSuchFieldError -> L44
        L24:
            b = r1;
        }
    }

    public AndroidChatSettingPlatformEffects() {
        this(null);
    }

    public AndroidChatSettingPlatformEffects(UserSession r1) {
        this.a = r1;
        this.b = LazyKt.lazy(AndroidChatSettingPlatformEffects$reportManager$2.INSTANCE);
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final boolean d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r2 instanceof AppCompatActivity;
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final Object f(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        if ((r4 instanceof AppCompatActivity) == false) goto L6;
        AppCompatActivity r5 = (AppCompatActivity) r4;     // Catch: Throwable -> L11
    L7:
        if (r5 == null) goto L10;
        Intent r1 = new Intent();     // Catch: Throwable -> L11
        r1.putExtra("extra_result_quit_confirmed", true);     // Catch: Throwable -> L11
        r5.setResult(-1, r1);     // Catch: Throwable -> L11
        r5.finish();     // Catch: Throwable -> L11
        return Result.constructor-impl(Unit.INSTANCE);
    L10:
        throw new IllegalStateException("AppCompatActivity is required to return quit result".toString());     // Catch: Throwable -> L11
    L6:
        r5 = null;
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final boolean g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r2 instanceof FragmentActivity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final void h(Chat r7) {
        Intrinsics.checkNotNullParameter(r7, "chat");
        FlowReportManager r0 = (FlowReportManager) this.b.getValue();
        r0.getClass();
        if (r7 == null) goto L67;
        Chat.TnsInfo r8 = r7.getTns_info();
        if (r8 == null) goto L8;
        TnsOpKind r3 = r8.getOp_kind();
        if (r3 != null) goto L13;
    L45:
        Log.e("FlowReportManager", "opKind is null or opKind: " + r3);
        if ((!r0.a().isEmpty()) == false) goto L66;
        Log.e("FlowReportManager", "clear disableFunctionList, op_kind is null or TNS_OP_NONE");
        r0.a().clear();
        return;
    L66:
        return;
    L13:
        if (r3 == TnsOpKind.TNS_OP_NONE) goto L45;
        if (FlowReportManager.b.a[r3.ordinal()] != 1) goto L43;
        TnsSystemBannedInfo r9 = r8.getSystem_banned_info();
        if (r9 == null) goto L20;
        List r10 = r9.getBlocked_features();
    L21:
        if (r10 != null) goto L23;
    L38:
        ?? r4 = CollectionsKt.emptyList();
    L39:
        Log.i("FlowReportManager", "updateDisableFunctionList, blockFunctionList size: " + r4.size() + ", disableFunctionList size: " + r0.a().size());
        Collection<? extends ChatSettingFunction> r5 = (Collection) r4;
        if ((!r5.isEmpty()) == false) goto L62;
        r0.a().clear();
        r0.a().addAll(r5);
        return;
    L62:
        return;
    L23:
        if (r10.isEmpty() == true) goto L38;
        r4 = new ArrayList();
        Iterator r11 = r10.iterator();
    L27:
        if (r11.hasNext() == false) goto L39;
        int r6 = FlowReportManager.b.b[((TnsBlockedFeature) r11.next()).ordinal()];
        if (r6 != 1) goto L31;
        r4.add(ChatSettingFunction.ADD_MEMBER);
        r4.add(ChatSettingFunction.GROUP_QR_CODE);
        goto L27
    L31:
        if (r6 != 2) goto L33;
        r4.add(ChatSettingFunction.REMOVE_MEMBER);
        goto L27
    L33:
        if (r6 != 3) goto L27;
        r4.add(ChatSettingFunction.GROUP_NAME_AND_AVATAR);
        r4.add(ChatSettingFunction.GROUP_MANAGE);
        goto L27
    L20:
        r10 = null;
        goto L21
    L43:
        if ((!r0.a().isEmpty()) == false) goto L64;
        Log.e("FlowReportManager", "clear disableFunctionList, opKind " + r3);
        r0.a().clear();
        return;
    L64:
        return;
    L8:
        if ((!r0.a().isEmpty()) == false) goto L60;
        Log.e("FlowReportManager", "clear disableFunctionList, tnsInfo is null");
        r0.a().clear();
        return;
    L60:
        return;
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final boolean a(Context r6, ChatSettingFunction r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "function");
        FlowReportManager r2 = (FlowReportManager) this.b.getValue();
        int r3 = FlowReportManager.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "function");
        if (r2.a().isEmpty() == false) goto L5;
        return false;
    L5:
        boolean r8 = r2.a().contains(r7);
        if (r8 == false) goto L10;
        if (r6 == null) goto L10;
        Intrinsics.checkNotNullParameter(r6, "context");
        int r1 = FlowChatFunctionAbandonDialog.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intent r0 = new Intent(r6, FlowChatFunctionAbandonDialog.class);
        String r4 = UIUtils.getString(r6, 2131890180);
        String r5 = UIUtils.getString(r6, 2131890179);
        Bundle r9 = new Bundle();
        r9.putString("key_main_title", r4);
        r9.putString("key_sub_title", r5);
        r0.putExtras(r9);
        r6.startActivity(r0);
    L10:
        return r8;
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final Object c(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        if ((r2 instanceof FragmentActivity) == false) goto L6;
        FragmentActivity r4 = (FragmentActivity) r2;     // Catch: Throwable -> L11
    L7:
        if (r4 == null) goto L10;
        int r1 = dgb.a.d;     // Catch: Throwable -> L11
        dgb.a.a.a().getClass();     // Catch: Throwable -> L11
        dgb.a.a(r4, r3);     // Catch: Throwable -> L11
        return Result.constructor-impl(Unit.INSTANCE);
    L10:
        throw new IllegalStateException("FragmentActivity is required to create a group from P2P chat".toString());     // Catch: Throwable -> L11
    L6:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final Object e(Context r5, e r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "params");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        UserSession r1 = this.a;     // Catch: Throwable -> L8
        if (r1 == null) goto L7;
        Intent r2 = new Intent(r5, FlowGroupQrCodeActivity.class);     // Catch: Throwable -> L8
        r2.putExtra("chat_id", r6.a);     // Catch: Throwable -> L8
        r2.putExtra("avatar_key", r6.b);     // Catch: Throwable -> L8
        r2.putExtra("chat_name", r6.c);     // Catch: Throwable -> L8
        r2.putExtra("owner_id", r6.d);     // Catch: Throwable -> L8
        PassportcConvention.g(r2, r1);     // Catch: Throwable -> L8
        r5.startActivity(r2);     // Catch: Throwable -> L8
        return Result.constructor-impl(Unit.INSTANCE);
    L7:
        throw new IllegalStateException("UserSession is required to open group QR code".toString());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final Object i(Context r5, d r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "params");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        UserSession r1 = this.a;     // Catch: Throwable -> L8
        if (r1 == null) goto L7;
        Intent r2 = new Intent(r5, FlowGroupInfoActivity.class);     // Catch: Throwable -> L8
        r2.putExtra("chat_id", r6.a);     // Catch: Throwable -> L8
        r2.putExtra("chat_name", r6.b);     // Catch: Throwable -> L8
        r2.putExtra("avatar_key", r6.c);     // Catch: Throwable -> L8
        r2.putExtra("can_edit", r6.d);     // Catch: Throwable -> L8
        PassportcConvention.g(r2, r1);     // Catch: Throwable -> L8
        r5.startActivity(r2);     // Catch: Throwable -> L8
        return Result.constructor-impl(Unit.INSTANCE);
    L7:
        throw new IllegalStateException("UserSession is required to open group info".toString());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final void j(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "chatId");
        CopyOnWriteArraySet<aqb.c> r1 = e8b.a.a;
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Iterator<aqb.c> r0 = e8b.a.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().b(r3, r4);
        goto L4
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final void l(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "chatId");
        CopyOnWriteArraySet<aqb.c> r1 = e8b.a.a;
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Iterator<aqb.c> r0 = e8b.a.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r3, r4);
        goto L4
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final void m(Context r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_ERROR);
        com.ss.android.lark.compose.util.a.a(r2, r3);
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final void n(Context r3, c r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "toast");
        if (Intrinsics.areEqual(r4, c.f.a) == false) goto L6;
        FlowToast.c(r3, 2131890111);
        return;
    L6:
        if (Intrinsics.areEqual(r4, c.e.a) == false) goto L9;
        FlowToast.c(r3, 2131890823);
        return;
    L9:
        if (Intrinsics.areEqual(r4, c.g.a) == false) goto L12;
        FlowToast.c(r3, 2131890716);
        return;
    L12:
        if (Intrinsics.areEqual(r4, c.C0129c.a) == false) goto L15;
        FlowToast.c(r3, 2131891023);
        return;
    L15:
        if (Intrinsics.areEqual(r4, c.d.a) == false) goto L18;
        FlowToast.c(r3, 2131892995);
        return;
    L18:
        if (Intrinsics.areEqual(r4, c.b.a) == false) goto L21;
        FlowToast.c(r3, 2131892420);
        return;
    L21:
        if (Intrinsics.areEqual(r4, c.a.a) == false) goto L24;
        FlowToast.c(r3, 2131891009);
        return;
    L24:
        if ((r4 instanceof c.h) == false) goto L27;
        String r5 = UIHelper.mustacheFormat(2131892437, "Name", ((c.h) r4).a);
        Intrinsics.checkNotNull(r5);
        FlowToast.d(r3, r5);
        return;
    L27:
        if (Intrinsics.areEqual(r4, c.i.a) == false) goto L30;
        FlowToast.c(r3, 2131892436);
        return;
    L30:
        if ((r4 instanceof c.j) == false) goto L33;
        FlowToast.d(r3, ((c.j) r4).a);
        return;
    L33:
        if ((r4 instanceof c.k) == false) goto L37;
        UDToast.show(r3, ((c.k) r4).a);
        return;
    L37:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final void o(ChatSettingTrackEvent r9, Boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "event");
        String r2 = "on";
        switch(a.a[r9.ordinal()]) {
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L36;
            case 8: goto L31;
            case 9: goto L26;
            case 10: goto L25;
            case 11: goto L21;
            case 12: goto L17;
            case 13: goto L16;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L7;
            case 17: goto L6;
            default: goto L5;
        };
    L6:
        com.ss.android.lark.compose.util.b.a("report", "none", null);
        return;
    L7:
        int r11 = com.ss.android.lark.compose.util.b.a;
        Map<String, Object> r12 = ChatParamUtils.e();
        if (r12 == null) goto L60;
        Statistics.sendEvent("im_quit_group_confirm_click", new JSONObject(r12).put("click", "confirm").put("target", "none"));
        return;
    L60:
        return;
    L11:
        com.ss.android.lark.compose.util.b.a("quit_group", "im_quit_group_confirm_view", null);
        return;
    L12:
        int r13 = com.ss.android.lark.compose.util.b.a;
        Map<String, Object> r14 = ChatParamUtils.e();
        if (r14 == null) goto L61;
        Statistics.sendEvent("im_dismiss_group_confirm_click", new JSONObject(r14).put("click", "confirm").put("target", "none"));
        return;
    L61:
        return;
    L16:
        com.ss.android.lark.compose.util.b.a("dismiss_group", "im_dismiss_group_confirm_view", null);
        return;
    L17:
        int r15 = com.ss.android.lark.compose.util.b.a;
        Map<String, Object> r16 = ChatParamUtils.e();
        if (r16 == null) goto L62;
        Statistics.sendEvent("im_chat_empty_history_confirm_click", new JSONObject(r16).put("click", "empty").put("target", "im_chat_setting_view"));
        return;
    L62:
        return;
    L21:
        com.ss.android.lark.compose.util.b.a("empty_history_msg", "im_chat_empty_history_confirm_view", null);
        Map<String, Object> r17 = ChatParamUtils.e();
        if (r17 == null) goto L63;
        Statistics.sendEvent("im_chat_empty_history_confirm_view", new JSONObject(r17));
        return;
    L63:
        return;
    L25:
        com.ss.android.lark.compose.util.b.a(ChatFromType.SEARCH, "im_chat_history_view", null);
        return;
    L26:
        int r18 = com.ss.android.lark.compose.util.b.a;
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == true) goto L30;
        r2 = "off";
    L30:
        com.ss.android.lark.compose.util.b.a("quickswitcher_switch", "im_chat_setting_view", r2);
        return;
    L31:
        int r19 = com.ss.android.lark.compose.util.b.a;
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == true) goto L35;
        r2 = "off";
    L35:
        com.ss.android.lark.compose.util.b.a("mute_taggle", "none", r2);
        return;
    L36:
        com.ss.android.lark.compose.util.b.a("group_manage", "im_group_manage_view", null);
        return;
    L37:
        com.ss.android.lark.compose.util.b.a("group_QR", "im_group_QR_view", null);
        return;
    L38:
        com.ss.android.lark.compose.util.b.a("edit_group_info", "im_edit_group_info_view", null);
        return;
    L39:
        com.ss.android.lark.compose.util.b.a("group_member_del", "im_group_member_del_view", null);
        return;
    L40:
        com.ss.android.lark.compose.util.b.a("group_member_add", "im_group_member_add_view", null);
        return;
    L41:
        com.ss.android.lark.compose.util.b.a("member_avatar", "profile_main_view", null);
        return;
    L42:
        com.ss.android.lark.compose.util.b.a("group_member", "im_group_member_view", null);
        return;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final void b(Chat.Type r2, boolean r3, boolean r4) {
        if (r2 != null) goto L4;
        int r5 = -1;
    L6:
        if (r5 != 1) goto L8;
        com.bytedance.lark.pb.basic.v1.Chat.Type r6 = com.bytedance.lark.pb.basic.v1.Chat.Type.GROUP;
    L12:
        if (r3 == false) goto L14;
        com.ss.android.lark.compose.util.b.b("click_doubao_proactive_reply_switch", r6, r4);
        return;
    L14:
        com.ss.android.lark.compose.util.b.b("click_use_doubao_in_chat_switch", r6, r4);
        return;
    L8:
        if (r5 == 2) goto L10;
        r6 = null;
        goto L12
    L10:
        r6 = com.bytedance.lark.pb.basic.v1.Chat.Type.P2P;
        goto L12
    L4:
        r5 = a.b[r2.ordinal()];
        goto L6
    }

    @Override // com.ss.android.lark.compose.chatsetting.common.platform.b
    public final Object k(Context r2, String r3, CoroutineScope r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        Intrinsics.checkNotNullParameter(r4, "scope");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        ((FlowReportManager) this.b.getValue()).getClass();     // Catch: Throwable -> L5
        FlowReportManager.b(r2, r3, r4);     // Catch: Throwable -> L5
        return Result.constructor-impl(Unit.INSTANCE);
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    }
}
