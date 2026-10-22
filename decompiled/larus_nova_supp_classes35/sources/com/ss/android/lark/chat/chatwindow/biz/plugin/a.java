package com.ss.android.lark.chat.chatwindow.biz.plugin;

import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.audio.f;
import com.ss.android.lark.audio.opus.e;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.log.Log;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c implements f.a {
    public f g;
    public IMessageListComponent h;
    public final AtomicReference<Pair<String, Subject<com.ss.android.lark.audio.a>>> i;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.plugin.a$a, reason: collision with other inner class name */
    public static final class C0035a {
    }

    public static final class b implements com.ss.android.lark.audio.c {
        public b() {
        }

        public final boolean intercept() {
            ChatCoreModule.a().getVcDependency().isInMeeting();
            Log.i("AudioPlayerPlugin", "intercept change mode, isInMeeting:false");
            return false;
        }
    }

    public static final class c implements IMessageListComponent.a {
        public final /* synthetic */ IMessageListComponent a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final /* synthetic */ void A9() {
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void B9(ChatChatter r2) {
            Intrinsics.checkNotNullParameter(r2, "chatChatter");
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void e(BasePageStore r2) {
            Intrinsics.checkNotNullParameter(r2, "store");
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void w9(ThreadTopic r2) {
            Intrinsics.checkNotNullParameter(r2, "threadTopic");
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final /* synthetic */ void x9() {
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void z9(Chat r2) {
            Intrinsics.checkNotNullParameter(r2, "chat");
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void y9() {
            s2b.d r0 = this.a.W2();
            if (r0 != null) goto L6;
            Log.w("AudioPlayerPlugin", "messageContext == null");
            return;
        L6:
            FragmentActivity r1 = r0.getContext();
            a r2 = this.b;
            Map r3 = f.e;
            f r4 = f.b.a(r1);
            a r5 = this.b;
            Intrinsics.checkNotNullParameter(r5, "dependency");
            Log.i("SequenceAudioPlayer", "setDependency scope:" + r4.a);
            r4.d = new WeakReference(r5);
            r2.g = r4;
        }

        public c(IMessageListComponent r1, a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements y3b.a {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // y3b.a
        public final void b(Message r10) {
            Intrinsics.checkNotNullParameter(r10, "message");
            Pair<String, Subject<com.ss.android.lark.audio.a>> r0 = this.a.i.get();
            if (r0 != null) goto L6;
            Log.i("AudioPlayerPlugin", "onAudioDownloadSuccess currentAudioItemRef null");
            return;
        L6:
            String r4 = r10.getId();
            if (Intrinsics.areEqual(r4, r0.getFirst()) == true) goto L11;
            Log.i("AudioPlayerPlugin", "onAudioDownloadSuccess unmatched messageId:" + r4 + ", expect:" + ((String) r0.getFirst()));
            return;
        L11:
            if (r10.getMessageType() == MessageType.AUDIO) goto L14;
            Log.w("AudioPlayerPlugin", "onAudioDownloadSuccess invalid type, messageId:" + r4);
            return;
        L14:
            AudioContent r2 = (AudioContent) r10.getContent();
            String r7 = r2.getLocalFilePath();
            boolean r3 = true;
            if (r7 != null) goto L17;
        L20:
            boolean r6 = true;
        L21:
            if (r6 == false) goto L24;
            Log.w("AudioPlayerPlugin", "onAudioDownloadSuccess path is null, messageId:" + r4);
            return;
        L24:
            AtomicReference<Pair<String, Subject<com.ss.android.lark.audio.a>>> r8 = this.a.i;
        L26:
            if (r8.compareAndSet(r0, null) == true) goto L31;
            if (r8.get() == r0) goto L26;
            r3 = false;
        L31:
            if (r3 == false) goto L37;
            Log.i("AudioPlayerPlugin", "onAudioDownloadSuccess onNext messageId:" + r4);
            ((Subject) r0.getSecond()).onNext(new com.ss.android.lark.audio.a(r10.getcId(), r4, r2.getDuration(), r2.getProgress(), r7));
            ((Subject) r0.getSecond()).onComplete();
            return;
        L37:
            return;
        L17:
            if (r7.length() == 0) goto L20;
            r6 = false;
            goto L21
        }

        @Override // y3b.a
        public final void a(String r3, ErrorResult r4) {
            Intrinsics.checkNotNullParameter(r3, "messageId");
            Log.e("AudioPlayerPlugin", "onAudioDownloadError messageId:" + r3, r4);
        }
    }

    static {
    }

    public a() {
        this.i = new AtomicReference();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        super.D();
        f r0 = this.g;
        if (r0 == null) goto L5;
        r0.d();
        ((ConcurrentHashMap) r0.b).clear();
        Map r1 = f.e;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        r2.remove(r0.a);
    L5:
        e.d().m(true);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void E() {
        e.d().g();
    }

    public final Observable<com.ss.android.lark.audio.a> p(String r12) {
        Intrinsics.checkNotNullParameter(r12, "key");
        this.i.set(null);
        IMessageListComponent r0 = this.h;
        if (r0 != null) goto L6;
        Log.i("AudioPlayerPlugin", "getAudioItem component == null,key:" + r12);
        return Observable.empty();
    L6:
        Iterator<T> r3 = r0.h20().iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((y6b.c) r4).d, r12) == false) goto L8;
    L13:
        y6b.c r5 = (y6b.c) r4;
        if (r5 != null) goto L17;
        Log.i("AudioPlayerPlugin", "getAudioItem messageVO == null,key:" + r12);
        return null;
    L17:
        T r6 = r5.o;
        if ((r6 instanceof AudioContentVO) == true) goto L21;
        Log.i("AudioPlayerPlugin", "getAudioItem contentVO is not audio,key:" + r12);
        return null;
    L21:
        AudioContentVO r7 = (AudioContentVO) r6;
        String r10 = r7.t;
        if (r10 != null) goto L24;
    L27:
        boolean r1 = true;
    L28:
        if (r1 == false) goto L39;
        if (r5.j() == false) goto L33;
        Log.w("AudioPlayerPlugin", "[messageID: " + r5.c + "]find recalled audio message, skip task");
        return Observable.empty();
    L33:
        String r2 = r5.c;
        Log.w("AudioPlayerPlugin", "getAudioItem localFilePath empty,key:" + r12 + ",fileState:" + r7.s.getValue(), r7.s.getErrorResult());
        if (r7.s == AudioContent.AudioState.DOWNLOADING) goto L36;
        r0.mB(r2, AudioContent.AudioState.DONE);
    L36:
        PublishSubject r13 = PublishSubject.create();
        this.i.set(TuplesKt.to(r2, r13));
        return r13;
    L39:
        return Observable.just(new com.ss.android.lark.audio.a(r12, r5.c, r7.g(), r7.u, r10));
    L24:
        if (r10.length() == 0) goto L27;
        r1 = false;
        goto L28
    L12:
        r4 = null;
        goto L13
    }

    public final void u(com.ss.android.lark.audio.a r2) {
        Intrinsics.checkNotNullParameter(r2, "audioItem");
        IMessageListComponent r0 = this.h;
        if (r0 == null) goto L6;
        r0.H5(r2.b);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        super.C(r2, r3);
        e r4 = e.d();
        r4.p = new b();
        int r5 = com.ss.android.lark.chat.chatwindow.chat.v2.component.c.E1;
        IMessageListComponent r6 = (IMessageListComponent) r2.a(IMessageListComponent.class);
        if (r6 == null) goto L5;
        r6.m(new c(r6, this));
        r6.X70(new d(this));
    L6:
        this.h = r6;
        if (r6 != null) goto L10;
        Log.w("AudioPlayerPlugin", "messageListComponent == null");
        return;
    L10:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
