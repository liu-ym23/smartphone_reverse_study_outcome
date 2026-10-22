package d4b;

import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.r;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import t6b.i;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements d4b.a {
    public final i a;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b b;

    public static final class a extends r<c<?>> {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.r, com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.InterfaceC0082c
        public final void a(List<? extends c<?>> r3) {
            Intrinsics.checkNotNullParameter(r3, "itemList");
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.b;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("env");
            r0 = null;
        L5:
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r1 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a.class);
            if (r1 == null) goto L9;
            r1.g(r3);
            return;
        }
    }

    /* JADX INFO: renamed from: d4b.b$b, reason: collision with other inner class name */
    public static final class C0209b<T> implements Observer {
        public final /* synthetic */ b a;

        public C0209b(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            if (((Boolean) r4).booleanValue() == false) goto L19;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5 = this.a.b;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = null;
            if (r5 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("env");
            r5 = null;
        L7:
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r6 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) r5.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
            if (r6 == null) goto L20;
            List<c<?>> r7 = r6.w();
            if (r7 == null) goto L21;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = this.a.b;
            if (r2 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("env");
        L15:
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r1 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a.class);
            if (r1 == null) goto L22;
            r1.g(r7);
            return;
        L22:
            return;
        L14:
            r0 = r2;
            goto L15
        L21:
            return;
        L20:
            return;
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

    public b(i r2) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r4) {
        Intrinsics.checkNotNullParameter(r4, "initData");
        Intrinsics.checkNotNullParameter(r4, "initData");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5 = this.b;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r5 = null;
    L5:
        IMessageListViewModel r6 = r5.f();
        if (r6 == null) goto L15;
        MutableLiveData<Boolean> r7 = r6.getMessageReadable();
        if (r7 == null) goto L16;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = this.b;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L13:
        r7.observe(r0.getLifecycleOwner(), new C0209b(this));
        return;
    L12:
        r0 = r2;
        goto L13
    L16:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.b = r2;
        if (this.a.c() == false) goto L11;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r3 = this.b;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r3 = null;
    L7:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r4 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) r3.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r4 == null) goto L12;
        r4.n(new a(this));
        return;
    L12:
        return;
    }
}
