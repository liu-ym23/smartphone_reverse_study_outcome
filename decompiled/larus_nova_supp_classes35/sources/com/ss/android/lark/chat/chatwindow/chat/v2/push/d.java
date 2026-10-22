package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import android.text.TextUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements c0.a {
    public final String a;
    public final WeakReference<a> b;
    public final c c;
    public final b d;
    public final C0080d e;

    public interface a {
        void onPushUpdatedChatter(Chatter r1);

        void onPushUpdatedNickname(String r1, String r2);

        void onUpdateSelfInfo(Chatter r1);
    }

    public static final class b implements com.ss.android.lark.chat.service.impl.w {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.service.impl.w
        public final void a(String r2, String r3, Channel r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            if (Intrinsics.areEqual(this.a.a, r4.getId()) == true) goto L6;
            return;
        L6:
            if (TextUtils.isEmpty(r2) == true) goto L13;
            a r5 = this.a.b.get();
            if (r5 == null) goto L14;
            Intrinsics.checkNotNull(r2);
            Intrinsics.checkNotNull(r3);
            r5.onPushUpdatedNickname(r2, r3);
            return;
        L14:
            return;
        }
    }

    public static final class c implements com.ss.android.lark.biz.im.api.h0 {
        public final /* synthetic */ d a;

        public c(d r1) {
            this.a = r1;
        }

        public final void a(Chatter r6) {
            if (r6 != null) goto L6;
            Log.e(TitlebarViewModel.LOG_TAG, "PushChatters chatter is null");
            return;
        L6:
            StringCompanionObject r1 = StringCompanionObject.INSTANCE;
            Log.d(TitlebarViewModel.LOG_TAG, String.format("onPushChatter, id is [%s], avatarKey is [%s]", Arrays.copyOf(new Object[]{r6.getId(), r6.getAvatarKey()}, 2)));
            a r0 = this.a.b.get();
            if (r0 == null) goto L10;
            r0.onPushUpdatedChatter(r6);
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.push.d$d, reason: collision with other inner class name */
    public static final class C0080d implements com.ss.android.lark.biz.im.api.l0 {
        public final /* synthetic */ d a;

        public C0080d(d r1) {
            this.a = r1;
        }

        public final void a(Chatter r3) {
            String r0 = ChatCoreModule.a().getLoginDependency().getUserId();
            if (r3 != null) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r0, r3.getId()) == false) goto L11;
            a r1 = this.a.b.get();
            if (r1 == null) goto L12;
            r1.onUpdateSelfInfo(r3);
            return;
        L12:
            return;
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        ImSdkService.c().J1(this.c);
        ImSdkService.c().x5(this.d);
        ImSdkService.c().r8(this.e);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        ImSdkService.c().te(this.c);
        ImSdkService.c().h5(this.d);
        ImSdkService.c().A5(this.e);
    }

    public d(String r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "mChatId");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a = r2;
        this.b = new WeakReference(r3);
        this.c = new c(this);
        this.d = new b(this);
        this.e = new C0080d(this);
    }
}
