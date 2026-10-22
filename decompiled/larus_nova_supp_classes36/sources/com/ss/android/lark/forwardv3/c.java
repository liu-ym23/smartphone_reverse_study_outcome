package com.ss.android.lark.forwardv3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.configuration.dto.StickImage;
import com.ss.android.lark.forwardv3.dependency.ExternalForwardDirection;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements tib.g {

    public static final class a implements tib.e {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // tib.e
        public final void a() {
        }

        @Override // tib.e
        public final void b(boolean r1) {
        }

        @Override // tib.e
        public final void c() {
        }

        @Override // tib.e
        public final void d() {
        }

        @Override // tib.e
        public final void destroy() {
        }

        @Override // tib.e
        public final void e() {
        }

        @Override // tib.e
        public final void f(List<? extends SearchBaseInfo> r1) {
        }

        @Override // tib.e
        public final void g(tib.b r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
        }

        @Override // tib.e
        public final void h() {
        }

        @Override // tib.e
        public final void i(boolean r1) {
        }

        @Override // tib.e
        public final void setConsumeResultLayoutClickWhenEmpty(boolean r1) {
        }

        @Override // tib.e
        public final void setCustomBinder(ICustomBinder r2) {
            Intrinsics.checkNotNullParameter(r2, "binder");
        }
    }

    public c() {
    }

    @Override // tib.g
    public final void attachGlobalWatermark(Dialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
    }

    @Override // tib.g
    public final String getAppLinkDomain() {
        return "";
    }

    @Override // tib.g
    public final String getCreateGroupChatResultKey() {
        return "";
    }

    @Override // tib.g
    public final String getCreateGroupSelectedDataKey() {
        return "";
    }

    @Override // tib.g
    public final zib.a getEventParams(List<String> r1) {
        return null;
    }

    @Override // tib.g
    public final String getExternalTargetId() {
        return null;
    }

    @Override // tib.g
    public final tib.a getExternalTargetItem() {
        return null;
    }

    @Override // tib.g
    public final int getLoginUserAuthorityDeniedReason() {
        return 0;
    }

    @Override // tib.g
    public final String getLoginUserId() {
        return "";
    }

    @Override // tib.g
    public final void go2Chat(Context r1, String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
    }

    @Override // tib.g
    public final void go2Chat(Context r1, String r2, Chat.ChatMode r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "chatMode");
    }

    @Override // tib.g
    public final void go2Thread(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "threadId");
    }

    @Override // tib.g
    public final boolean hasFilePreviewPermissionFromMessage(Message r1) {
        return true;
    }

    @Override // tib.g
    public final boolean isDoubaoWorkTabEnabled() {
        return false;
    }

    @Override // tib.g
    public final boolean isEnterSendEnabled() {
        return false;
    }

    @Override // tib.g
    public final void showNoIMPermissionDialog(String r1) {
    }

    @Override // tib.g
    public final void showSquareMessageStickerThumb(Context r1, ImageView r2, StickImage r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "imageView");
    }

    @Override // tib.g
    public final void startCreateGroup(Fragment r1, boolean r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "fragment");
    }

    @Override // tib.g
    public final void startCreateGroupWithFilter(Context r1, Fragment r2, Bundle r3, IGetDataCallback<Chat> r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "param");
    }

    @Override // tib.g
    public final void startProfile(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userid");
    }

    @Override // tib.g
    public final tib.c createForwardChatPicker(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new tib.c(new View(r3), a.a);
    }

    @Override // tib.g
    public final Map<String, Chatter> getChatterMap(Map<String, com.bytedance.lark.pb.basic.v1.Chatter> r1) {
        return MapsKt.emptyMap();
    }

    @Override // tib.g
    public final IExternalForwardExecutor getExternalForwardExecutor(ExternalForwardDirection r1, String r2, List<String> r3, String r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r1, "direction");
        Intrinsics.checkNotNullParameter(r2, "quasiTitle");
        Intrinsics.checkNotNullParameter(r3, "messageIds");
        Intrinsics.checkNotNullParameter(r4, "sourceChatId");
        Intrinsics.checkNotNullParameter(r6, "originMergeForwardId");
        return null;
    }
}
