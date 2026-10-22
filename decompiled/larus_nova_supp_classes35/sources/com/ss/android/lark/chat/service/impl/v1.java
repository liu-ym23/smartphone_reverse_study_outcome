package com.ss.android.lark.chat.service.impl;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.todo.impl.features.detail.comment.CommentKeyboardSection;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import com.ss.android.lark.videosend.tools.VideoCoverManager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class v1 implements m6b.m {
    public final m6b.l a;

    public class a implements ObservableOnSubscribe<Map<String, FrameInfo>> {
        public final /* synthetic */ List a;

        public a(List r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<Map<String, FrameInfo>> r8) throws Exception {
            HashMap r0 = new HashMap();
            Iterator r1 = this.a.iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            String r2 = ((VideoInfo) r1.next()).getPath();
            if (r0.containsKey(r2) == true) goto L4;
            VideoCoverManager.a r3 = VideoCoverManager.getVideoCover(ChatCoreModule.a().getContext(), r2);
            r0.put(r2, new FrameInfo(r3.a, r3.b, r3.c));
            goto L4
        L9:
            r8.onNext(r0);
            r8.onComplete();
        }
    }

    @Inject
    public v1(m6b.l r1) {
        this.a = r1;
    }

    @Override // m6b.m
    public final Observable<Map<String, FrameInfo>> Db(List<VideoInfo> r2) {
        return Observable.create(new a(r2));
    }

    @Override // m6b.m
    public final void d2(final String r2, final boolean r3, final IGetDataCallback<List<MessageInfo>> r4) {
        Observable r5 = Observable.create(new o1(this, r2, r3)).map(new p1(r2)).subscribeOn(LarkRxSchedulers.io());
        Objects.requireNonNull(r4);
        r5.subscribe(new q1(r4), com.ss.android.lark.utils.rxjava.a.a.a);
    }

    @Override // m6b.m
    public final Observable M4(List r2, final boolean r3, final CommentKeyboardSection.handleActivityResult.1 r4, final Biz r5, final Scene r6) {
        return Observable.fromIterable(r2).concatMap(new r1(r3, r4, r5, r6)).concatMap(new s1()).subscribeOn(LarkRxSchedulers.io());
    }
}
