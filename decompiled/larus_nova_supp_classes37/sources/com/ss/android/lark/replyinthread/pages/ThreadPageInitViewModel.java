package com.ss.android.lark.replyinthread.pages;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.k1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J$\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00122\b\u0010#\u001a\u0004\u0018\u00010\u0012H\u0002J$\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(J\b\u0010*\u001a\u00020\u001bH\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006,"}, d2 = {"Lcom/ss/android/lark/replyinthread/pages/ThreadPageInitViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "threadPageLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/replyinthread/pages/ThreadPageInfo;", "getThreadPageLiveData", "()Landroidx/lifecycle/MutableLiveData;", "closePageInfo", "", "kotlin.jvm.PlatformType", "getClosePageInfo", "callbackManager", "Lcom/larksuite/framework/callback/CallbackManager;", "bundle", "Landroid/os/Bundle;", "threadId", "", "rootMessageId", "originMergeForwardMessageId", "useBottomSheet", "getUseBottomSheet", "()Z", "setUseBottomSheet", "(Z)V", "onCreate", "", "arguments", "loadMergeForwardMessage", "mergeForwardMessageId", "handlePreviewMessage", "previewMessage", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "previewId", "msgLinkToken", "handleParentMessageContent", "parentMessageContent", "Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent;", "mergeForwardMessage", "Lcom/ss/android/lark/chat/entity/message/Message;", "translateMessage", "onCleared", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ThreadPageInitViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "ThreadPageInitViewModel";
    private Bundle bundle;
    private final CallbackManager callbackManager;
    private final MutableLiveData<Boolean> closePageInfo;
    private String originMergeForwardMessageId;
    private String rootMessageId;
    private String threadId;
    private final MutableLiveData<f> threadPageLiveData;
    private boolean useBottomSheet;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public void onCleared() {
        this.callbackManager.cancelCallbacks();
        super.onCleared();
    }

    public ThreadPageInitViewModel() {
        this.threadPageLiveData = new MutableLiveData();
        this.closePageInfo = new MutableLiveData(Boolean.FALSE);
        this.callbackManager = new CallbackManager();
        this.threadId = "";
        this.rootMessageId = "";
        this.originMergeForwardMessageId = "";
    }

    public final MutableLiveData<Boolean> getClosePageInfo() {
        return this.closePageInfo;
    }

    public final MutableLiveData<f> getThreadPageLiveData() {
        return this.threadPageLiveData;
    }

    public final boolean getUseBottomSheet() {
        return this.useBottomSheet;
    }

    public static final /* synthetic */ String access$getThreadId$p(ThreadPageInitViewModel r0) {
        return r0.threadId;
    }

    private final void loadMergeForwardMessage(final String r5) {
        IGetDataCallback<Map<String, ? extends Message>> r0 = new ThreadPageInitViewModel$loadMergeForwardMessage$callback$1(this, r5);
        ImSdkService.f().Fe(CollectionsKt.mutableListOf(new String[]{r5}), this.callbackManager.wrapAndAddCallback(r0));
    }

    public final void onCreate(Bundle r9) {
        if (r9 != null) goto L6;
        Log.e(TAG, "open reply in thread failed: bundle is null");
        this.closePageInfo.postValue(Boolean.TRUE);
        return;
    L6:
        this.bundle = r9;
        boolean r2 = false;
        this.useBottomSheet = r9.getBoolean("key_bottom_sheet_container_start", false);
        Bundle r10 = this.bundle;
        Bundle r3 = null;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("bundle");
        r10 = null;
    L9:
        String r11 = r10.getString("key_params_thread_id");
        String r4 = "";
        if (r11 != null) goto L12;
        r11 = "";
    L12:
        this.threadId = r11;
        if (r11.length() != 0) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == false) goto L19;
        Log.e(TAG, "open reply in thread failed: thread id is empty");
        this.closePageInfo.postValue(Boolean.TRUE);
        return;
    L19:
        Bundle r13 = this.bundle;
        if (r13 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("bundle");
        r13 = null;
    L22:
        String r14 = r13.getString("key_params_root_message_id");
        if (r14 != null) goto L25;
        r14 = "";
    L25:
        this.rootMessageId = r14;
        if (r14.length() != 0) goto L28;
        boolean r15 = true;
    L29:
        if (r15 == false) goto L31;
        Log.i(TAG, "open reply in thread, root message id is empty, thread id = " + this.threadId);
        this.rootMessageId = this.threadId;
    L31:
        Bundle r16 = this.bundle;
        if (r16 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("bundle");
        r16 = null;
    L34:
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Map r7 = k1.a;
        String r17 = r16.getString("key_params_root_message_id");
        Map r6 = k1.d;
        if (r17 != null) goto L37;
        r17 = "";
    L37:
        MessageInfo r18 = (MessageInfo) r6.remove(r17);
        if (r18 == null) goto L48;
        Bundle r0 = this.bundle;
        if (r0 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("bundle");
        r0 = null;
    L42:
        String r1 = r0.getString("key_params_preview_id");
        Bundle r5 = this.bundle;
        if (r5 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("bundle");
    L46:
        handlePreviewMessage(r18, r1, r3.getString("key_params_msg_link_token"));
        return;
    L45:
        r3 = r5;
        goto L46
    L48:
        Bundle r19 = this.bundle;
        if (r19 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("bundle");
        r19 = null;
    L51:
        String r20 = r19.getString("key_params_origin_merge_forward_message_id");
        if (r20 != null) goto L54;
        r20 = "";
    L54:
        this.originMergeForwardMessageId = r20;
        if (r20.length() != 0) goto L57;
        r2 = true;
    L57:
        if (r2 == false) goto L64;
        MutableLiveData<f> r21 = this.threadPageLiveData;
        String r8 = this.threadId;
        Bundle r22 = this.bundle;
        if (r22 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("bundle");
    L62:
        r21.postValue(new b(r8, r3));
        return;
    L61:
        r3 = r22;
        goto L62
    L64:
        Bundle r23 = this.bundle;
        if (r23 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("bundle");
        r23 = null;
    L67:
        Intrinsics.checkNotNullParameter(r23, "<this>");
        String r24 = r23.getString("key_params_parent_message_content");
        Map r25 = k1.c;
        if (r24 != null) goto L70;
        r24 = "";
    L70:
        MergeForwardContent r26 = (MergeForwardContent) r25.remove(r24);
        if (r26 == null) goto L74;
        handleParentMessageContent(r26, null, null);
        return;
    L74:
        Bundle r27 = this.bundle;
        if (r27 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("bundle");
        r27 = null;
    L77:
        Intrinsics.checkNotNullParameter(r27, "<this>");
        String r28 = r27.getString("key_params_merge_forward_message_id");
        Map r29 = k1.a;
        if (r28 != null) goto L80;
        r28 = "";
    L80:
        Message r30 = (Message) r29.remove(r28);
        String r31 = r27.getString("key_params_merge_forward_message_id");
        Map r32 = k1.b;
        if (r31 == null) goto L84;
        r4 = r31;
    L84:
        Pair r33 = new Pair(r30, (Message) r32.remove(r4));
        Message r34 = (Message) r33.getFirst();
        if (r34 != null) goto L87;
        return;
    L87:
        handleParentMessageContent(null, r34, (Message) r33.getSecond());
        return;
    L28:
        r15 = false;
        goto L29
    L15:
        r12 = false;
        goto L16
    }

    public final void setUseBottomSheet(boolean r1) {
        this.useBottomSheet = r1;
    }

    private final void handlePreviewMessage(MessageInfo r4, String r5, String r6) {
        this.threadPageLiveData.postValue(new d(this.threadId, r4, r5, r6));
    }

    public final void handleParentMessageContent(MergeForwardContent r8, Message r9, Message r10) {
        Bundle r0 = null;
        String r1 = null;
        if (r8 != null) goto L12;
        if (r9 == null) goto L6;
        Message.Type r11 = r9.getType();
    L8:
        if (r11 != Message.Type.MERGE_FORWARD) goto L10;
        r8 = (MergeForwardContent) r9.getContent();
        goto L12
    L10:
        r8 = null;
        goto L12
    L6:
        r11 = null;
    L12:
        if (r8 != null) goto L15;
        Log.e(TAG, "parent message content is null, thread id = " + this.threadId);
        this.closePageInfo.postValue(Boolean.TRUE);
        return;
    L15:
        Chat r2 = r8.getOriginChat();
        boolean r3 = false;
        if (r2 != null) goto L18;
    L20:
        boolean r4 = false;
    L21:
        if (r4 == true) goto L51;
        Chat r5 = r8.getOriginChat();
        int r6 = mac.b.a;
        if (r5 != null) goto L25;
    L29:
        boolean r7 = false;
    L30:
        if (r7 == true) goto L51;
        if (r8.getThread() == null) goto L41;
        Thread r12 = r8.getThread();
        if (r12 == null) goto L38;
        r1 = r12.id;
    L38:
        if (Intrinsics.areEqual(r1, this.threadId) == false) goto L41;
        this.threadPageLiveData.postValue(new com.ss.android.lark.replyinthread.pages.a(this.threadId, this.originMergeForwardMessageId, r9, r10));
        return;
    L41:
        if ((!r8.getMessageThreadMap().isEmpty()) == false) goto L43;
        this.threadPageLiveData.postValue(new c(this.threadId, this.rootMessageId, this.originMergeForwardMessageId, r8));
        return;
    L43:
        StringBuilder r13 = new StringBuilder("parser merge forward message failed, thread id: ");
        r13.append(this.threadId);
        r13.append(" origin chat is null: ");
        if (r8.getOriginChat() != null) goto L46;
        boolean r14 = true;
    L47:
        r13.append(r14);
        r13.append(", thread is null: ");
        if (r8.getThread() != null) goto L50;
        r3 = true;
    L50:
        r13.append(r3);
        r13.append(", message thread map is empty: ");
        r13.append(r8.getMessageThreadMap().isEmpty());
        Log.e(TAG, r13.toString());
        this.closePageInfo.postValue(Boolean.TRUE);
        return;
    L46:
        r14 = false;
        goto L47
    L25:
        if (Chat.Role.MEMBER == r5.getRole()) goto L29;
        if (r5.getHasVCChatPermission() == false) goto L29;
        r7 = true;
    L51:
        MutableLiveData<f> r15 = this.threadPageLiveData;
        String r16 = this.threadId;
        Bundle r17 = this.bundle;
        if (r17 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("bundle");
    L55:
        r15.postValue(new b(r16, r0));
        return;
    L54:
        r0 = r17;
        goto L55
    L18:
        if (r2.isMember() != true) goto L20;
        r4 = true;
        goto L21
    }
}
