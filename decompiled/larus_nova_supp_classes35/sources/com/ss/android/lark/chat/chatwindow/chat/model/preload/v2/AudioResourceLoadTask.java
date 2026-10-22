package com.ss.android.lark.chat.chatwindow.chat.model.preload.v2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.biz.im.api.extension.message.f;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.preload.v2.task.OneTimeTask;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import o1c.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\"#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J`\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162 \u0010\u0018\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u001a\u0018\u00010\u0019H\u0002J#\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010\u001eJ#\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010\u001eJ \u0010 \u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\f\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019H\u0016J\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006$"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/model/preload/v2/AudioResourceLoadTask;", "Lcom/ss/android/lark/preload/v2/task/OneTimeTask;", "Lcom/ss/android/lark/chat/chatwindow/chat/model/preload/v2/AudioResourceLoadTask$Params;", BuildConfig.FLAVOR, "<init>", "()V", "biz", "Lcom/ss/android/lark/appreciablelib/Biz;", "getBiz", "()Lcom/ss/android/lark/appreciablelib/Biz;", "doPreloadExt", BuildConfig.FLAVOR, "params", "doPreload", "load", "messageInfoList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "forceFetch", "loadTaskContext", "Lcom/ss/android/lark/biz/im/api/extension/message/MessageResourceLoadTaskContext;", "previewId", BuildConfig.FLAVOR, "msgLinkToken", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", BuildConfig.FLAVOR, "getCacheExt", "extra", BuildConfig.FLAVOR, "(Lcom/ss/android/lark/chat/chatwindow/chat/model/preload/v2/AudioResourceLoadTask$Params;Ljava/lang/Object;)Ljava/lang/Boolean;", "getCache", "forceLoad", "getCacheKeys", "Companion", "Params", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioResourceLoadTask extends OneTimeTask<b, Boolean> {
    public static final /* synthetic */ int q = 0;
    public final Biz p;

    public static final class a {
    }

    public static final class b {
        public final Set<? extends MessageInfo> a;
        public final f b;
        public final String c;
        public final String d;

        public b() {
            Set r0 = null;
            this(r0, r0, 15);
        }

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            f r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Params(messageInfoSet=" + this.a + ", loadTaskContext=" + this.b + ", previewId=" + this.c + ", msgLinkToken=" + this.d + ')';
        }

        public /* synthetic */ b(Set r2, f r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r2 = SetsKt.emptySet();
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3, null, null);
        }

        public b(Set<? extends MessageInfo> r2, f r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "messageInfoSet");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public AudioResourceLoadTask() {
        this.p = Biz.Messenger;
    }

    public final Biz getBiz() {
        return this.p;
    }

    public static Set h(b r2) {
        HashSet r0 = new HashSet();
        if (r2 == null) goto L12;
        Set<? extends MessageInfo> r3 = r2.a;
        if (r3 == null) goto L12;
        Iterator<T> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        MessageInfo r1 = (MessageInfo) r4.next();
        if (r1 == null) goto L8;
        r0.add(r1.getId());
    L12:
        return r0;
    }

    public final /* bridge */ /* synthetic */ void d(Object r1) {
        g((b) r1);
    }

    public final void e(Object r3) {
        ((o1c.a) this).m = SystemClock.elapsedRealtime();
        g((b) r3);
    }

    public final /* bridge */ /* synthetic */ Set f(Object r1) {
        return h((b) r1);
    }

    public final void g(b r10) {
        final Set r0 = h(r10);
        ((o1c.a) this).m = SystemClock.elapsedRealtime();
        c.a r1 = ((o1c.a) this).k;
        if (r1 == null) goto L5;
        r1.e(this, ((HashSet) r0).size());
    L5:
        if (r10 == null) goto L8;
        i(r10.a, false, r10.b, r10.c, r10.d, new AudioResourceLoadTask$doPreload$1$1(this, r0));
        return;
    }

    public final Object j(Object r9) {
        if (r9 == null) goto L26;
        Set r10 = SetsKt.setOf((String) r9);
        o1c.b r0 = ((o1c.a) this).n;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        c.a r3 = ((o1c.a) this).k;
        if (r3 == null) goto L13;
        r3.k(this, r1, MapsKt.mapOf(TuplesKt.to("source_type", BuildConfig.FLAVOR)));
    L13:
        o1c.b r4 = ((o1c.a) this).n;
        if (r4 != null) goto L16;
    L18:
        boolean r11 = false;
    L19:
        if (r1 == false) goto L25;
        if (r11 == true) goto L25;
        c.a r12 = ((o1c.a) this).k;
        if (r12 == null) goto L25;
        r12.m(this, MapsKt.mapOf(new Pair[]{TuplesKt.to("source_type", BuildConfig.FLAVOR), TuplesKt.to("first_hit_interval", Long.valueOf(SystemClock.elapsedRealtime() - ((o1c.a) this).m))}));
    L25:
        return Boolean.valueOf(r1);
    L16:
        if (r4.c(this, r10) != true) goto L18;
        r11 = true;
        goto L19
    L7:
        if (r0.d(this, r10) != true) goto L9;
        r1 = true;
        goto L10
    L26:
        return Boolean.FALSE;
    }

    public final void J1(Object r7, IGetDataCallback r8) {
        b r9 = (b) r7;
        if (r9 == null) goto L6;
        i(r9.a, true, r9.b, r9.c, r9.d, r8);
        return;
    }

    public static void i(Set r10, final boolean r11, final f r12, final String r13, final String r14, final IGetDataCallback r15) {
        Log.i("AudioResourceLoadTask", "load audio forceLoad =" + r11);
        final HashMap r4 = new HashMap();
        final HashMap r7 = new HashMap();
        Iterator r16 = r10.iterator();
    L4:
        if (r16.hasNext() == false) goto L25;
        MessageInfo r0 = (MessageInfo) r16.next();
        if (r0 == null) goto L8;
        Message r2 = r0.getMessage();
    L9:
        if (r2 == null) goto L4;
        if (r0.getMessage().getType() != Message.Type.AUDIO) goto L4;
        Message r3 = r0.getMessage();
        AudioContent r5 = (AudioContent) r3.getContent();
        String r6 = r5.getKey();
        if (TextUtils.isEmpty(r6) == true) goto L4;
        if (r11 == true) goto L21;
        if (TextUtils.isEmpty(r5.getLocalFilePath()) == true) goto L21;
        if (r5.getAudioWaveBytes() != null) goto L4;
    L21:
        if (TextUtils.equals(r3.getId(), r3.getcId()) == true) goto L4;
        String r8 = r3.getId();
        r4.put(r6, r8);
        r7.put(r8, r0);
        goto L4
    L8:
        r2 = null;
        goto L9
    L25:
        if (CollectionUtils.isEmpty(r4) == false) goto L27;
        return;
    L27:
        if (r11 == false) goto L32;
        Iterator r17 = r4.entrySet().iterator();
    L30:
        if (r17.hasNext() == false) goto L32;
        Map.Entry r1 = (Map.Entry) r17.next();
        Log.i("AudioResourceLoadTask", "forceFetch audio key:" + ((String) r1.getKey()) + ", messageId:" + ((String) r1.getValue()));
    L32:
        Log.d("AudioResourceLoadTask", "prepareAudioMessage1:" + r4.size() + ", previewId: " + r13);
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new AudioResourceLoadTask$load$2(r11, r4, r13, r14, r7, r12, r15));
    }
}
