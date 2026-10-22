package a4b;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements a4b.a {
    public final h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> a;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b b;
    public b c;

    public static final class a<T> implements Observer {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Chat r2 = (Chat) r1;
            this.a.m();
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onActivityResult(int r1, int r2, Intent r3) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onDestroy() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onResume() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStop() {
    }

    public final b l() {
        b r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("messageCallbackHub");
        return null;
    }

    public final void m() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.b;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        IMessageListViewModel r2 = r0.f();
        if (r2 != null) goto L8;
        return;
    L8:
        Chat r3 = (Chat) r2.getCurrentChat().getValue();
        if (r3 != null) goto L11;
        return;
    L11:
        h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> r4 = this.a;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5 = this.b;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r5 = null;
    L14:
        FragmentActivity r6 = r5.getActivity();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r7 = this.b;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L18:
        l().b = r4.d(r3, r6, r2, r1.a());
        return;
    L17:
        r1 = r7;
        goto L18
    }

    @Override // a4b.a
    public final /* bridge */ /* synthetic */ b A() {
        return l();
    }

    public d(h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "listRenderer");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r4) {
        Intrinsics.checkNotNullParameter(r4, "initData");
        Intrinsics.checkNotNullParameter(r4, "initData");
        m();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5 = this.b;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r5 = null;
    L5:
        IMessageListViewModel r6 = r5.f();
        if (r6 == null) goto L15;
        MutableLiveData<Chat> r7 = r6.getCurrentChat();
        if (r7 == null) goto L16;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = this.b;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L13:
        r7.observe(r0.getLifecycleOwner(), new a(this));
        return;
    L12:
        r0 = r2;
        goto L13
    L16:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r3) {
        Intrinsics.checkNotNullParameter(r3, "env");
        this.b = r3;
        b r0 = new b(r3);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r4 = r0.G();
        if (r4 == null) goto L5;
        r4.k(new c(r0));
    L5:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.c = r0;
    }

    @Override // a4b.a
    public final void p(String r8, String r9, boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "messageId");
        Intrinsics.checkNotNullParameter(r9, "threadId");
        l().D(r8, r9, r11, null, null, null);
    }
}
