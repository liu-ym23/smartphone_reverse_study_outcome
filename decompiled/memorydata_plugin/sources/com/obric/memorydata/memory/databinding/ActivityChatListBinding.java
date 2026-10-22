package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.ui.detail.ChatListView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityChatListBinding implements ViewBinding {
    public final OScrollView chatListScrollView;
    public final ChatListView chatListView;
    public final View cutOff;
    private final FrameLayout rootView;
    public final OFloatingTitleBar viewTitle;

    private ActivityChatListBinding(FrameLayout r1, OScrollView r2, ChatListView r3, View r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.chatListScrollView = r2;
        this.chatListView = r3;
        this.cutOff = r4;
        this.viewTitle = r5;
    }

    public static ActivityChatListBinding bind(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.chat_list_scroll_view, OaidModel.KEY_ID, "chat_list_scroll_view");
        OScrollView r7 = (OScrollView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OScrollView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.chat_list_view, OaidModel.KEY_ID, "chat_list_view");
        ChatListView r8 = (ChatListView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), ChatListView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r9 = r11.findViewById(r0);
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r10 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L13;
        return new ActivityChatListBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r11, FrameLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ActivityChatListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityChatListBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.activity_chat_list, "layout", "activity_chat_list"), r4, false, "com.obric.memorydata.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return bind(r6);
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
