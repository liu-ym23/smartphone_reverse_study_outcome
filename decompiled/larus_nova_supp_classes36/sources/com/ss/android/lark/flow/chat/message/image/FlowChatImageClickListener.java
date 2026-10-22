package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.MessageListEventDispatchFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatImageClickListener implements b3b.i {
    public static final /* synthetic */ int h = 0;
    public final v a;
    public final Context b;
    public final IMessageListViewModel c;
    public final e3b.a.a d;
    public final m2b.a e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public final void v(View r1, PhotoItem r2, boolean r3) {
    }

    public final Context getContext() {
        return this.b;
    }

    public final void a(List<? extends PhotoItem> r16, int r17) {
        Intrinsics.checkNotNullParameter(r16, "photoItems");
        Log.i("FlowChatImageClickListener", "openGalleryPreview, photoItems: " + r16.size() + ", currentPosition: " + r17);
        IMessageListViewModel r0 = this.c;
        if (r0 == null) goto L11;
        MutableLiveData r1 = r0.getCurrentChat();
        if (r1 == null) goto L12;
        Chat r6 = (Chat) r1.getValue();
        if (r6 == null) goto L13;
        String r4 = r6.getId();
        Fragment r5 = this.d.getFragment();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r5), Dispatchers.getMain(), null, new FlowChatImageClickListener$openGalleryPreview$1(r16, this, r17, r4, r5, r6, null), 2, null);
        return;
    L13:
        return;
    L12:
        return;
    }

    public final void n(View r10, String r11, List<? extends Object> r12, int r13) {
        if (r13 < 0) goto L11;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.isEmpty() == false) goto L7;
        return;
    L7:
        if (r13 >= r12.size()) goto L14;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.d.getFragment()), Dispatchers.getMain().getImmediate(), null, new FlowChatImageClickListener$onOpenImageClick$1(r12, r13, r11, this, null), 2, null);
        return;
    L14:
        return;
    }

    public FlowChatImageClickListener(v r2, Context r3, IMessageListViewModel r4, MessageListEventDispatchFeature.a r5, m2b.a r6) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "dependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = LazyKt.lazy(FlowChatImageClickListener$openFeishuGalleryPreviewDependency$2.INSTANCE);
        this.g = LazyKt.lazy(new FlowChatImageClickListener$mediaPreviewObserverManager$2(this));
    }

    public final void s(View r1, ActivityTransitionLauncher.LocationInfo r2, PhotoItem r3, boolean r4, boolean r5, int r6, Message.SourceType r7) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.d.getFragment()), Dispatchers.getMain().getImmediate(), null, new FlowChatImageClickListener$onImageClick$1(this, r3, null), 2, null);
    }
}
