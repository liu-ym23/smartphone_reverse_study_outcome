package com.ss.android.lark.chat.chatwindow.chat.menu.reaction;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.larksuite.framework.thread.ThreadUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ReactionEventDispatcher {
    public static final LinkedHashMap<a, LifecycleBoundObserver> a = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/menu/reaction/ReactionEventDispatcher$LifecycleBoundObserver;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "observer", "Lcom/ss/android/lark/chat/chatwindow/chat/menu/reaction/ReactionEventDispatcher$ReactionEventObserver;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lcom/ss/android/lark/chat/chatwindow/chat/menu/reaction/ReactionEventDispatcher$ReactionEventObserver;)V", "onDestroy", BuildConfig.FLAVOR, "owner", "Landroidx/lifecycle/LifecycleOwner;", "detachObserver", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LifecycleBoundObserver implements DefaultLifecycleObserver {
        public final /* synthetic */ void onCreate(LifecycleOwner r1) {
            DefaultLifecycleObserver.-CC.$default$onCreate(this, r1);
        }

        public final /* synthetic */ void onPause(LifecycleOwner r1) {
            DefaultLifecycleObserver.-CC.$default$onPause(this, r1);
        }

        public final /* synthetic */ void onResume(LifecycleOwner r1) {
            DefaultLifecycleObserver.-CC.$default$onResume(this, r1);
        }

        public final /* synthetic */ void onStart(LifecycleOwner r1) {
            DefaultLifecycleObserver.-CC.$default$onStart(this, r1);
        }

        public final /* synthetic */ void onStop(LifecycleOwner r1) {
            DefaultLifecycleObserver.-CC.$default$onStop(this, r1);
        }

        public final void onDestroy(LifecycleOwner r2) {
            Intrinsics.checkNotNullParameter(r2, "owner");
            DefaultLifecycleObserver.-CC.$default$onDestroy(this, r2);
            LinkedHashMap<a, LifecycleBoundObserver> r3 = ReactionEventDispatcher.a;
            Intrinsics.checkNotNullParameter(null, "observer");
            if (ReactionEventDispatcher.a.remove(null) != null) goto L5;
            return;
        L5:
            throw null;
        }
    }

    public interface a {
        void a();
    }

    public static final class b {
        public final String a;
        public final String b;
        public final Message.Type c;
        public final List<ReactionInfo> d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            List<ReactionInfo> r1 = this.d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ReactionMessage(id=" + this.a + ", cid=" + this.b + ", type=" + this.c + ", reactionInfoList=" + this.d + ')';
        }

        public final Message.Type getType() {
            return this.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r2, String r3, Message.Type r4, List<? extends ReactionInfo> r5) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "cid");
            Intrinsics.checkNotNullParameter(r4, IPortraitService.TYPE);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
        a = new LinkedHashMap();
    }

    public static void a(String r4, f5b.b r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "chatId");
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r6, "reactionKey");
        Log.i("ReactionEventDispatcher", "onAddReaction, chat: " + r4 + ", msg: " + r5.getId() + ", reaction: " + r6);
        ThreadUtils.runOnUIThread(new com.ss.android.lark.chat.chatwindow.chat.menu.reaction.a(r4, new b(r5.getId(), r5.getcId(), r5.getMessage().getType(), r5.getReactionInfoList()), r6));
    }
}
