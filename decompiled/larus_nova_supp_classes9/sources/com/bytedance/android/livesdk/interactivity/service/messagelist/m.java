package com.bytedance.android.livesdk.interactivity.service.messagelist;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m {
    public static final int g = 0;
    public final MultiTypeAdapter a;
    public final MessageListScrollManager b;
    public final SpaceItemDecoration c;
    public final CompositeDisposable d;
    public Disposable e;
    public final RecyclerView f;

    public static final class a {
    }

    static {
        g = s1.f(8.0f);
    }

    public final void a(IMessageListManager r10) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        Disposable r1 = this.e;
        if (r1 == null) goto L5;
        this.d.remove(r1);
    L5:
        MessageListScrollManager r2 = this.b;
        int r4 = 0;
        if (r2.i == null) goto L26;
        int r3 = r2.d.findFirstVisibleItemPosition();
        View r5 = r2.d.findViewByPosition(r3);
        if (r5 == null) goto L11;
        int r6 = r5.getTop();
    L12:
        IMessageListManager r7 = r2.i;
        if (r7 == null) goto L19;
        b r8 = r7.getConfig();
        if (r8 == null) goto L19;
        l r9 = r8.b();
        if (r9 == null) goto L19;
        r9.g = true;
    L19:
        IMessageListManager.b r11 = new IMessageListManager.b(0);
        r11.a = r3;
        r11.b = r6;
        r11.c = r2.b;
        r11.d = r2.c;
        IMessageListManager r13 = r2.i;
        if (r13 == null) goto L26;
        b r14 = r13.getConfig();
        if (r14 == null) goto L26;
        l r15 = r14.b();
        if (r15 == null) goto L26;
        Intrinsics.checkNotNullParameter(r11, "newStatus");
        r15.e = r11;
        goto L26
    L11:
        r6 = 0;
    L26:
        this.a.a = r10.getMessageList();
        this.a.notifyDataSetChanged();
        MessageListScrollManager r16 = this.b;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r10, "manager");
        r16.i = r10;
        r16.e(MessageListScrollManager.ScrollState.Focus);
        Disposable r0 = r16.h;
        if (r0 == null) goto L29;
        r0.dispose();
    L29:
        l r17 = r10.getConfig().b();
        if (r17 == null) goto L34;
        IMessageListManager.b r18 = r17.e;
        if (r18 == null) goto L34;
        r16.d.scrollToPositionWithOffset(r18.a, r18.b);
        r16.d(r18.c);
        r16.c = r18.d;
    L46:
        MainThreadPostUtils.b(new j(r16, r10));
        Disposable r19 = r10.a().subscribe(new o(this));
        RxUtilKt.c(r19, this.d);
        this.e = r19;
        Unit r110 = Unit.INSTANCE;
        return;
    L34:
        MessageListScrollManager$bind$2$condition$1 r20 = MessageListScrollManager$bind$2$condition$1.INSTANCE;
        List<c> r21 = r10.getMessageList();
        Intrinsics.checkNotNullParameter(r21, "list");
        Intrinsics.checkNotNullParameter(r20, "condition");
        List<c> r23 = r21;
        int r24 = r23.size();
    L35:
        int r25 = -1;
        if (r4 >= r24) goto L42;
        if (((Boolean) r20.invoke(ListProtector.get(r21, r4))).booleanValue() == true) goto L39;
        r4 = r4 + 1;
        goto L35
    L39:
        int r26 = r4 - 1;
    L45:
        r16.d(r26);
        MainThreadPostUtils.b(new i(r16));
        goto L46
    L42:
        if ((!r23.isEmpty()) == false) goto L44;
        r25 = CollectionsKt.getLastIndex(r21);
    L44:
        r26 = r25;
        goto L45
    }

    public final <T> void b(Class<? extends T> r2, me.drakeet.multitype.b<T, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "binder");
        this.a.z2(r2, r3);
    }

    public m(RecyclerView r4, View r5, TextView r6, int r7, float r8) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        Intrinsics.checkNotNullParameter(r5, "hintLayout");
        Intrinsics.checkNotNullParameter(r6, "hintTextView");
        this.f = r4;
        this.d = new CompositeDisposable();
        MultiTypeAdapter r0 = new MultiTypeAdapter();
        this.a = r0;
        SpaceItemDecoration r1 = new SpaceItemDecoration(1, r7, true);
        this.c = r1;
        this.b = new MessageListScrollManager(r4, r5, r6, r8);
        r4.setItemViewCacheSize(4);
        r4.addItemDecoration(r1);
        r4.setAdapter(r0);
    }
}
