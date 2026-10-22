package com.ss.android.lark.chat.chatwindow.biz.plugin.core;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.ss.android.lark.chat.component.ChatWindowAdapterComponent;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/plugin/core/PluginLifecycleAdapter;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "activity", "Landroidx/fragment/app/FragmentActivity;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "pluginManager", "Lcom/ss/android/lark/chat/chatwindow/biz/plugin/core/ChatPluginManager;", "chatWindow", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/IChatWindowApp;", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroidx/lifecycle/Lifecycle;Lcom/ss/android/lark/chat/chatwindow/biz/plugin/core/ChatPluginManager;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/IChatWindowApp;Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;)V", "onCreate", BuildConfig.FLAVOR, "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "onResume", "onPause", "onStop", "onDestroy", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PluginLifecycleAdapter implements DefaultLifecycleObserver {
    public final FragmentActivity a;
    public final Lifecycle b;
    public final b c;
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.c d;
    public final i7b.a e;

    public final void onCreate(LifecycleOwner r6) {
        Intrinsics.checkNotNullParameter(r6, "owner");
        b r7 = this.c;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r0 = this.d;
        i7b.a r1 = this.e;
        FragmentActivity r2 = this.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "chatWindowApp");
        Intrinsics.checkNotNullParameter(r1, "initData");
        Intrinsics.checkNotNullParameter(r2, "activity");
        e r3 = r7.a.a(r1);
        r7.d.addAll(r3.a(r2, r0));
        r7.e = r1;
        r7.f = r0;
        Iterator<d> r4 = r7.d.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().j(r0, r1);
        goto L4
    L6:
        r7.b = true;
    }

    public final void onDestroy(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        this.b.removeObserver(this);
        b r4 = this.c;
        r4.getClass();
        Log.d("ChatPluginManager", "destroy");
        if (r4.b == false) goto L9;
        Iterator<d> r5 = r4.d.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        r5.next().destroy();
        goto L7
    L11:
        return;
    }

    public final void onPause(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        b r4 = this.c;
        r4.getClass();
        Log.d("ChatPluginManager", "pause");
        if (r4.b == false) goto L9;
        Iterator<d> r5 = r4.d.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        r5.next().onPause();
        goto L7
    L11:
        return;
    }

    public final void onResume(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        b r4 = this.c;
        r4.getClass();
        Log.d("ChatPluginManager", "resume");
        if (r4.b == false) goto L9;
        Iterator<d> r5 = r4.d.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        r5.next().resume();
        goto L7
    L11:
        return;
    }

    public final void onStart(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        b r4 = this.c;
        r4.getClass();
        Log.d("ChatPluginManager", "start");
        if (r4.b == false) goto L9;
        Iterator<d> r5 = r4.d.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        r5.next().onStart();
        goto L7
    L11:
        return;
    }

    public final void onStop(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        b r4 = this.c;
        r4.getClass();
        Log.d("ChatPluginManager", "stop");
        if (r4.b == false) goto L9;
        Iterator<d> r5 = r4.d.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        r5.next().stop();
        goto L7
    L11:
        return;
    }

    public PluginLifecycleAdapter(FragmentActivity r2, LifecycleRegistry r3, b r4, ChatWindowAdapterComponent r5, i7b.a r6) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "lifecycle");
        Intrinsics.checkNotNullParameter(r4, "pluginManager");
        Intrinsics.checkNotNullParameter(r5, "chatWindow");
        Intrinsics.checkNotNullParameter(r6, "initData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
