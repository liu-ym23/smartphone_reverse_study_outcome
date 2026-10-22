package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarMsgController;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final DigitAvatarMsgController a;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.digitavatar.videoavatar.a$a, reason: collision with other inner class name */
    public static final class C0028a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0028a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r9 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.j) r8;
            if (r9 == null) goto L13;
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.h r0 = r9.getDigitAvatarEmojiData();
            if (r0 == null) goto L14;
            ALogger.i("KtvDigitAvatar", "发送avatar表情：[" + r9.getEmojiName() + ", " + r0.actionID + ']');
            DigitAvatarMsgController r10 = this.a.a;
            com.bytedance.android.live.liveinteract.digitavatar.a r2 = new com.bytedance.android.live.liveinteract.digitavatar.a(r0.actionID);
            r10.getClass();
            Intrinsics.checkNotNullParameter(r2, "action");
            List r1 = CollectionsKt.listOf(r2);
            Intrinsics.checkNotNullParameter(r1, "actions");
            JSONArray r3 = new JSONArray();
            JSONArray r4 = new JSONArray();
            Iterator r5 = r1.iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            com.bytedance.android.live.liveinteract.digitavatar.a r6 = (com.bytedance.android.live.liveinteract.digitavatar.a) r5.next();
            r3.put(r6.a);
            r4.put(r6.b);
            goto L8
        L10:
            JSONObject r7 = new JSONObject();
            r7.put("playClip", r3);
            r7.put("playMode", r4);
            ALogger.i("KtvDigitAvatar", "向effect发送动作指令，actionList=" + r1);
            r10.a(204, 0, r7.toString());
            return;
        L14:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public a(DigitAvatarMsgController r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r2, "avatarMsgController");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        this.a = r2;
        DigitAvatarContext r4 = DigitAvatarContext.Companion.getContext();
        if (r4 == null) goto L12;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r5 = r4.getSendAvatarEmoji();
        if (r5 == null) goto L13;
        PublishSubject r6 = r5.onEvent();
        if (r6 == null) goto L14;
        ObservableSubscribeProxy r7 = (ObservableSubscribeProxy) r6.as(AutoDispose.bind(r3));
        if (r7 == null) goto L15;
        r7.subscribe(new C0028a(this), b.a);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
