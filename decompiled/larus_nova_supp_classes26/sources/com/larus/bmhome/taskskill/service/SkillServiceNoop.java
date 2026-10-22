package com.larus.bmhome.taskskill.service;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001f\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\u0019JM\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010$J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t0*H\u0016J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020-H\u0016J \u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0016J\u0018\u00102\u001a\u00020\t2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\rH\u0016J\b\u00103\u001a\u00020\u001bH\u0016J\u001a\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u001bH\u0016¨\u00069"}, d2 = {"Lcom/larus/bmhome/taskskill/service/SkillServiceNoop;", "Lcom/larus/bmhome/taskskill/service/ISkillService;", "<init>", "()V", "getDeviceOrRuntimeChangedCellInfo", "Lkotlin/Pair;", "Ljava/lang/Class;", "", "tryTriggerOfficeTaskAskHumanInnerNotification", "", "data", "Lcom/larus/im/bean/InAppBannerNotify;", "resolvePcDeviceId", "", "agentTaskParam", "Lcom/larus/bmhome/taskskill/model/ConversationAgentTaskParam;", "prepareTaskSkillFullScreenTransfer", "conversationId", "prepareOTransferVisibleSkills", "createSkillComponent", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "sceneDelegate", "Lcom/larus/bmhome/taskskill/SkillComponentSceneDelegate;", "initialContentViewId", "", "(Lcom/larus/bmhome/taskskill/SkillComponentSceneDelegate;Ljava/lang/Integer;)Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "interceptQuickReplyClick", "", "messageId", "blockId", "item", "Lcom/larus/im/bean/message/block/QuickReplyItem;", "itemIndex", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "interactionType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/block/QuickReplyItem;ILandroidx/fragment/app/FragmentActivity;Ljava/lang/Integer;)Z", "executeQuickReplyAction", "Lcom/larus/bmhome/taskskill/service/QuickReplyActionHandle;", "request", "Lcom/larus/bmhome/taskskill/service/QuickReplyActionRequest;", "onEvent", "Lkotlin/Function1;", "Lcom/larus/bmhome/taskskill/service/QuickReplyActionEvent;", "showLocalPcDispatchFallbackDialogIfNeeded", "Lcom/larus/bmhome/taskskill/service/LocalPcDispatchFallbackDialogRequest;", "retainTaskSkillActionBarFilter", "ownerId", MusicAppletPage.KEY_SOURCE, "actionBarScopeId", "releaseTaskSkillActionBarFilter", "isRemoteControlEnabled", "snapshotTaskSkillMessage", "Lcom/larus/bmhome/taskskill/model/TaskSkillMessageSnapshot;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "isInTaskMode", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SkillServiceNoop implements ISkillService {
    public SkillServiceNoop() {
    }

    public final void a() {
    }

    public final boolean d(b r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        return false;
    }

    public final Integer f(String r1) {
        return null;
    }

    public final Pair<Class<?>, Object> g() {
        return null;
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "ownerId");
        Intrinsics.checkNotNullParameter(r3, MusicAppletPage.KEY_SOURCE);
    }

    public final String j(bs8.a r1) {
        return null;
    }

    public final boolean k() {
        return false;
    }

    public final boolean l(String r1, String r2, String r3, QuickReplyItem r4, int r5, FragmentActivity r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r4, "item");
        return false;
    }

    public final void m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
    }

    public final void n(tc9.e r1) {
    }

    public final void p(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
    }

    public final void r(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "ownerId");
        Intrinsics.checkNotNullParameter(r3, MusicAppletPage.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r4, "actionBarScopeId");
    }

    public final void o() {
        Intrinsics.checkNotNullParameter("flow.refreshConnector", "scene");
    }

    public final ComponentFeature b(bz8.j r1, Integer r2) {
        Intrinsics.checkNotNullParameter(r1, "sceneDelegate");
        return new c();
    }

    public final l c(m r2, com.larus.bmhome.chat.standarduikit.interaction.viewmodel.h r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "onEvent");
        r3.invoke(k.i.a);
        return new u();
    }

    public final bs8.n h(wc9.e r1, boolean r2) {
        return new bs8.n(0);
    }

    public final Object e(String r1, int r2, String r3, String r4, Continuation<? super Result<Long>> r5) {
        Result.Companion r6 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new UnsupportedOperationException("addRecentlyUsedSkill unsupported")));
    }

    public final Object q(String r1, int r2, String r3, String r4, Continuation<? super Result<Unit>> r5) {
        Result.Companion r6 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new UnsupportedOperationException("removeRecentlyUsedSkill unsupported")));
    }
}
