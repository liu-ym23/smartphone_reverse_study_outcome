package com.obric.memorydata.memory.ui.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.databinding.ActivityChatListBinding;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ba;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ChatActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityChatListBinding;", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChatActivity extends BaseMemoryActivity {
    private static final String ARG_MESSAGE = "arg_message";
    public static final a Companion = null;
    private static final String TAG = "ChatActivity";
    private ActivityChatListBinding binding;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/ChatActivity$Companion;", "", "<init>", "()V", "ARG_MESSAGE", "", "TAG", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "messages", "", "Lcom/obric/memorydata/memory/ui/detail/ChatListView$Companion$ChatMessage;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r4, List<ChatListView.Companion.ChatMessage> r5) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r6, "messages");
            Intent r7 = new Intent(r3, ChatActivity.class);
            r7.putParcelableArrayListExtra(ChatActivity.ARG_MESSAGE, new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")));
            ZeusTransformUtils.startActivity(r3, r7, "com.obric.memorydata.plugin");
        }
    }

    static {
        Companion = new a(null);
    }

    public ChatActivity() {
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        int r0 = ba.c();
        boolean r1 = isLocked();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onBackPressed taskId=" + getTaskId() + ", numActivities=" + r0 + ", locked=" + r1, false, 4, null);
        if (r1 == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onBackPressed: locked → exitApp", false, 4, null);
        exitApp();
        return;
    L6:
        super.onBackPressed();
        com.obric.memorydata.ui.h.f13009a.c((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        finish();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r9) {
        com.obric.memorydata.ui.h.f13009a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        prepareSystemBar();
        ActivityChatListBinding r10 = ActivityChatListBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r10, "inflate(...)");
        this.binding = r10;
        ActivityChatListBinding r2 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r10.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityChatListBinding r11 = this.binding;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L8:
        OScrollView r12 = r11.chatListScrollView;
        Intrinsics.checkNotNullExpressionValue(r12, "chatListScrollView");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        ActivityChatListBinding r13 = this.binding;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L11:
        OFloatingTitleBar r14 = r13.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r14, "viewTitle");
        ActivityChatListBinding r5 = this.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        View r6 = (View) ZeusTransformUtils.preCheckCast(r5.chatListScrollView, View.class, "com.obric.memorydata.plugin");
        int r4 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        ActivityChatListBinding r7 = this.binding;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L17:
        setupTitleBarBackAction(r14, r6, r4, r7.cutOff);
        ActivityChatListBinding r15 = this.binding;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L20:
        OFloatingTitleBar r16 = r15.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r16, "viewTitle");
        registerFloatingTitleBar(r16);
        if (Build.VERSION.SDK_INT < 33) goto L28;
        Intent r17 = getIntent();
        if (r17 == null) goto L27;
        ArrayList r18 = r17.getParcelableArrayListExtra(ARG_MESSAGE, ChatListView.Companion.ChatMessage.class);
        if (r18 == null) goto L27;
        List<ChatListView.Companion.ChatMessage> r19 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
    L38:
        ActivityChatListBinding r8 = this.binding;
        if (r8 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L42:
        r2.chatListView.setMessages(r19);
        return;
    L41:
        r2 = r8;
    L27:
        r19 = CollectionsKt.emptyList();
        goto L38
    L28:
        Intent r20 = getIntent();
        if (r20 == null) goto L31;
        ArrayList r21 = r20.getParcelableArrayListExtra(ARG_MESSAGE);
    L33:
        if (ZeusTransformUtils.instanceOf(r21, List.class) == false) goto L35;
        r19 = (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin");
    L36:
        if (r19 != null) goto L38;
    L35:
        r19 = null;
        goto L36
    L31:
        r21 = null;
        goto L33
    }
}
